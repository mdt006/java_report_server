package com.ds.chess.service;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.ds.chess.dao.DsKyRecordTimeMapper;
import com.ds.chess.entity.DsKyRecordTime;
import com.ds.chess.util.RequestUtil;
import com.ds.chess.vo.KyRecordTimeVo;
import com.kg.live.entity.ApiInfoEntity;

/**
 * 开元注单拉取线程
 * @author worf
 * @date 2018年4月18日 下午4:01:00
 */
public class KyChessRequestService implements Runnable {
	private Logger logger = LoggerFactory.getLogger(getClass());

	private KyChessService kyChessService;

	private DsKyRecordTimeMapper dsKyRecordTimeMapper;
	
	private CountDownLatch cdl;
	
	private ApiInfoEntity apiConfig;

	public KyChessRequestService(KyChessService kyChessService, CountDownLatch cdl, ApiInfoEntity apiConfig) {
		super();
		this.cdl = cdl;
		this.kyChessService = kyChessService;
		this.dsKyRecordTimeMapper = kyChessService.getDsKyRecordTimeMapper();
		this.apiConfig = apiConfig;
	}

	@Override
	public void run() {
		try {
			logger.info("开始拉取网站id：" + apiConfig.getSiteId() + ",网站名称：" + apiConfig.getSiteName() + ",视讯请求地址：" + 
					apiConfig.getReporturl() + ",请求agent:" + apiConfig.getAgent());
			startPullData(apiConfig);
		} catch (Exception e) {
			logger.error("run error", e);
		} finally {
			logger.info("{}拉取完成", apiConfig.getSiteId());
			cdl.countDown();
		}
	}

	public void startPullData(ApiInfoEntity apiConfig) {
		try {
			//从数据库获取上次拉取时间
			DsKyRecordTime dsKyRecordTime = dsKyRecordTimeMapper.selectByAgent(apiConfig.getAgent());
			if(dsKyRecordTime == null){
				dsKyRecordTime = new DsKyRecordTime();
				dsKyRecordTime.setAgent(apiConfig.getAgent());
				dsKyRecordTime.setLastGetRecordTime(new Date());
			}
			
			KyRecordTimeVo kyRecordTimeVo = getEndTime(dsKyRecordTime.getLastGetRecordTime(),new Date());
			
			String param = kyChessService.getSendParams(kyRecordTimeVo.getStartTime().getTime(), kyRecordTimeVo.getEndTime().getTime(), apiConfig);
			logger.info("网站名称：{}，请求参数：{}", apiConfig.getSiteName(), param);
			String result = RequestUtil.sendGet(apiConfig.getReporturl(), param);
			logger.info("网站名称：{}，返回结果：{}", apiConfig.getSiteName(), result);
			JSONObject object = JSONObject.parseObject(result);
			JSONObject dObject = object.getJSONObject("d");
			if("0".equals(dObject.getString("code"))){ //请求成功
				logger.info("返回列表行数为："+dObject.getInteger("count"));
				kyChessService.saveData(dObject.getJSONObject("list"), apiConfig);
			}else if(16 == dObject.getInteger("code")){  //没有数据返回
				logger.info("网站：{}，返回列表行数为空，更新最后拉取时间", apiConfig.getSiteName());
				updateTime(dsKyRecordTime, kyRecordTimeVo.getEndTime());
				return;
			}else{
				logger.info("网站：{}，拉取数据失败,请检查配置,错误代码={}", apiConfig.getSiteName(), dObject.getString("code"));
				return;
			} 
			//更新时间
			updateTime(dsKyRecordTime, kyRecordTimeVo.getEndTime());
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("网站：{}，拉取数据发生异常，异常信息：{}", apiConfig.getSiteName(), e.getMessage());
		}
		logger.info("网站：{}，拉取数据成功.....",apiConfig.getSiteName());
	}
	
	
	//计算距离上次拉取时间
	public KyRecordTimeVo getEndTime(Date startTimeDate, Date endTimeDate){
		KyRecordTimeVo kyRecordTimeVo = new KyRecordTimeVo();
		Long endTimeLong = endTimeDate.getTime();
		Long startTimeLong = startTimeDate.getTime();
		Long diff = endTimeLong - startTimeLong;
		long nh = 1000*60*30;//30分钟的毫秒数
		long min = diff/nh;//计算差多少个30分钟
		if(min >= 1){
			startTimeLong = startTimeLong - 1000*60*3;
			endTimeLong = startTimeLong + nh;
		}else{
			startTimeLong = endTimeLong - nh;
		}
		kyRecordTimeVo.setEndTime(new Date(endTimeLong));
		kyRecordTimeVo.setStartTime(new Date(startTimeLong));
		return kyRecordTimeVo;		
	}

	public void updateTime(DsKyRecordTime dsKyRecordTime, Date endTimeDate){
		dsKyRecordTime.setLastGetRecordTime(endTimeDate);
		if(dsKyRecordTime.getLastUpdateTime() == null){
			dsKyRecordTime.setLastUpdateTime(endTimeDate);
			dsKyRecordTimeMapper.insert(dsKyRecordTime);
		}else{
			dsKyRecordTimeMapper.updateByPrimaryKey(dsKyRecordTime);
		}
	}
	
}
