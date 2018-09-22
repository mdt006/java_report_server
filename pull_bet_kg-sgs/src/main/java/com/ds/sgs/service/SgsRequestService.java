package com.ds.sgs.service;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ds.sgs.common.BaseCommon;
import com.ds.sgs.dao.DsSgsRecordTimeMapper;
import com.ds.sgs.entity.DsSgsConfig;
import com.ds.sgs.entity.DsSgsRecordTime;
import com.ds.sgs.util.DateUtils;
import com.ds.sgs.util.HttpClientUtils;
import com.ds.sgs.util.SHA1Utils;
import com.ds.sgs.util.ThreadUtil;
import com.ds.sgs.vo.SgsRecordTimeVo;

/**
 * 开元注单拉取线程
 * @author worf
 * @date 2018年4月18日 下午4:01:00
 */
public class SgsRequestService implements Runnable {
	private Logger logger = LoggerFactory.getLogger(getClass());

	private SgsService sgsService;
	
	private DsSgsRecordTimeMapper dsSgsRecordTimeMapper;
	
	private DsSgsConfig dsSgsConfig;

	private CountDownLatch cdl;
	
	public SgsRequestService(SgsService sgsService, CountDownLatch cdl, DsSgsConfig dsSgsConfig) {
		super();
		this.cdl = cdl;
		this.sgsService = sgsService;
		this.dsSgsConfig = dsSgsConfig;
		this.dsSgsRecordTimeMapper = sgsService.getDsSgsRecordTimeMapper();
	}

	@Override
	public void run() {
		try {
			logger.info("sgs注单拉取开始.......");
			String url = dsSgsConfig.getUrl();
			String clientSecret = dsSgsConfig.getClientSecret();
			String clientId = dsSgsConfig.getClientId();
			startPullData(url, clientSecret, clientId);
		} catch (Exception e) {
			logger.error("run error", e);
		} finally {
			cdl.countDown();
		}
	}

	public void startPullData(String url, String clientSecret, String clientId) {
		try {
			boolean firstPull = true;
			//从数据库获取上次拉取时间
			DsSgsRecordTime record = dsSgsRecordTimeMapper.selectOne();
			Date nowDate = new Date();
			if(record == null){
				record = new DsSgsRecordTime();
				record.setClientSecret(clientSecret);
				record.setLastGetRecordTime(nowDate);
			}
			
			SgsRecordTimeVo sgsRecordTimeVo = getEndTime(record.getLastGetRecordTime(), nowDate);
			//获取签名
			String sgsDate = DateUtils.getUTCTime(nowDate, true);
			String signature = SHA1Utils.genHMAC2(clientSecret, clientSecret + sgsDate);
			logger.info("send sgsDate：{}，signature：{}", sgsDate, signature);
			while (firstPull || sgsRecordTimeVo.getEndTime().getTime() < nowDate.getTime()) {
				firstPull = false;
				//请求注单接口
				String startDate = DateUtils.getUTCTime(sgsRecordTimeVo.getStartTime(), false);
				String endDate = DateUtils.getUTCTime(sgsRecordTimeVo.getEndTime(), false);
				String sendUrl = sgsService.getSendUrl(url, startDate, endDate);
				logger.info("send url：" + sendUrl);
				String result = HttpClientUtils.sendSgsGet(sendUrl, signature, sgsDate, clientId);
				//判断是否请求成功
				String object = sgsService.convertJsonObject(result);
				if(StringUtils.isNotBlank(object)){
					logger.info("拉取数据失败,错误信息："+ object);
					sgsRecordTimeVo = getEndTime(record.getLastGetRecordTime(), nowDate);
					ThreadUtil.sleep(BaseCommon.ONCE_TIME_THREAD_SLEEP);
					continue;
				}
				logger.info("send result：\n"+result);
				try {
					sgsService.saveData(result);
					//更新时间
					updateTime(record, sgsRecordTimeVo.getEndTime());
				} catch (Exception e) {
					e.printStackTrace();
					logger.info("数据写入数据库出错......" + e.getMessage());
				}
				sgsRecordTimeVo = getEndTime(record.getLastGetRecordTime(), nowDate);
				ThreadUtil.sleep(BaseCommon.ONE_SECOND_THREAD_SLEEP);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("拉取数据发生异常，异常信息{}", e.getMessage());
		}
		logger.info("sgs注单拉取完成.......");
	}
	
	
	/**
	 * 计算距离上次拉取时间
	 * @param startTimeDate
	 * @param endTimeDate
	 * @return
	 */
	public SgsRecordTimeVo getEndTime(Date startTimeDate, Date endTimeDate){
		SgsRecordTimeVo kyRecordTimeVo = new SgsRecordTimeVo();
		Long endTimeLong = endTimeDate.getTime();
		Long startTimeLong = startTimeDate.getTime();
		Long diff = endTimeLong - startTimeLong;
		long nh = 1000*60*30;//30分钟的毫秒数
		long min = diff/nh;//计算差多少个30分钟
		if(min >= 1){
			endTimeLong = startTimeLong + nh;
		}else{
			startTimeLong = endTimeLong - nh;
		}
		kyRecordTimeVo.setEndTime(new Date(endTimeLong));
		kyRecordTimeVo.setStartTime(new Date(startTimeLong));
		return kyRecordTimeVo;		
	}
	
	public void updateTime(DsSgsRecordTime dsSgsRecordTime, Date endTimeDate){
		dsSgsRecordTime.setLastGetRecordTime(endTimeDate);
		if(dsSgsRecordTime.getId() == null){
			dsSgsRecordTimeMapper.insert(dsSgsRecordTime);
		}else{
			dsSgsRecordTimeMapper.updateByPrimaryKey(dsSgsRecordTime);
		}
	}
}
