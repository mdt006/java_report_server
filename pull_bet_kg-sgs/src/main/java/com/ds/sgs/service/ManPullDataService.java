package com.ds.sgs.service;

import java.security.SignatureException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.sgs.common.BaseCommon;
import com.ds.sgs.entity.DsSgsConfig;
import com.ds.sgs.util.DateUtils;
import com.ds.sgs.util.HttpClientUtils;
import com.ds.sgs.util.SHA1Utils;
import com.kg.live.entity.ApiInfoEntity;

/**
 * 手动拉取注单service
 * 
 * @author worf 
 * @date 2018年6月8日 下午4:37:18
 */
@Service
public class ManPullDataService {
	
	private Logger logger = LoggerFactory.getLogger(ManPullDataService.class);
	
	@Autowired
	private SgsService sgsService;
	
	public String getPullData(Date startTime, Date endTime){
		try {
			sgsService.getDbApiInfoList();
			sgsService.putApiInfoMap();
			List<ApiInfoEntity> apiInfoList = sgsService.getApiInfoList();
			if(apiInfoList == null || apiInfoList.size() == 0){
				return "api_info配置为空";
			}
			List<DsSgsConfig> configList = sgsService.getSgsConfigList();
			if(configList == null || configList.size() == 0){
				return "ds_sgs_config配置为空";
			}
			logger.info("sgs注单数据手动拉取开始.......");
			for (DsSgsConfig dsSgsConfig : configList) {
				String url = dsSgsConfig.getUrl();
				String clientSecret = dsSgsConfig.getClientSecret();
				String clientId = dsSgsConfig.getClientId();
				//请求注单接口
				String startDate = DateUtils.getUTCTime(startTime, false);
				String endDate = DateUtils.getUTCTime(endTime, false);
				String sendUrl = sgsService.getSendUrl(url, startDate, endDate);
				logger.info("send url：" + sendUrl);
				//获取签名
				String sgsDate = DateUtils.getUTCTime(new Date(), true);
				String signature = SHA1Utils.genHMAC2(clientSecret, clientSecret + sgsDate);
				logger.info("send sgsDate：{}，signature：{}", sgsDate, signature);
				String result = HttpClientUtils.sendSgsGet(sendUrl, signature, sgsDate, clientId);
				//判断是否请求成功
				String object = sgsService.convertJsonObject(result);
				if(StringUtils.isNotBlank(object)){
					return "手动拉取数据失败,错误信息：" + object;
				}
				logger.info("send result："+result);
				try {
					sgsService.saveManData(result);
				} catch (Exception e) {
					e.printStackTrace();
					logger.info("数据写入数据库出错......" + e.getMessage());
					return "手动拉取数据写入数据库出错......"+e.getMessage();
				}
			}
		} catch (Exception e) {
			logger.info("手动拉取数据发生异常，异常信息{}", e.getMessage());
			return "手动拉取数据发生异常，异常信息:"+e.getMessage();
		}
		logger.info("手动拉取数据完成");
		return "ok";
	}
	
	
	public String getPullOneDayData(String date){
		sgsService.getDbApiInfoList();
		sgsService.putApiInfoMap();
		List<ApiInfoEntity> apiInfoList = sgsService.getApiInfoList();
		if(apiInfoList == null || apiInfoList.size() == 0){
			return "api_info配置为空";
		}
		List<DsSgsConfig> configList = sgsService.getSgsConfigList();
		if(configList == null || configList.size() == 0){
			return "ds_sgs_config配置为空";
		}
		logger.info("sgs注单数据手动拉取开始.......，拉取日期："+date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (DsSgsConfig dsSgsConfig : configList) {
			String url = dsSgsConfig.getUrl();
			String clientSecret = dsSgsConfig.getClientSecret();
			String clientId = dsSgsConfig.getClientId();
			String[] times = null;
			//获取签名
			Date nowDate = new Date();
			String sgsDate = DateUtils.getUTCTime(nowDate, true);
			String signature;
			try {
				signature = SHA1Utils.genHMAC2(clientSecret, clientSecret + sgsDate);
			} catch (SignatureException e1) {
				logger.info("手动拉取获取签名出错："+date);
				return "手动拉取获取签名出错："+e1.getMessage();
			}
			
			for (String time : BaseCommon.TIME_LIST) {
				try {
					times = time.split("_");
					String startTime = date + " " + times[0];
					String endTime = date + " " + times[1];
					Date startDate = sdf.parse(startTime);
					Date endDate = sdf.parse(endTime);
					if(startDate.getTime() > nowDate.getTime()){
						logger.info("手动拉取注单完成");
						return "ok";
					}
					if(endDate.getTime() > nowDate.getTime()){
						endDate = nowDate;
					}
					//请求注单接口
					String sendUrl = sgsService.getSendUrl(url, DateUtils.getUTCTime(startDate, false), DateUtils.getUTCTime(endDate, false));
					logger.info("send url：" + sendUrl);
					logger.info("send sgsDate：{}，signature：{}", sgsDate, signature);
					String result = HttpClientUtils.sendSgsGet(sendUrl, signature, sgsDate, clientId);
					//判断是否请求成功
					String object = sgsService.convertJsonObject(result);
					if(StringUtils.isNotBlank(object)){
						logger.info("拉取数据失败,错误信息："+ object);
						continue;
					}
					logger.info("send result："+result);
					try {
						sgsService.saveManData(result);
					} catch (Exception e) {
						e.printStackTrace();
						logger.info("数据写入数据库出错......" + e.getMessage());
						continue;
					}
				} catch (Exception e) {
					logger.info("拉取数据发生异常，异常信息{}", e.getMessage());
					continue;
				}
			}
		}
		
		logger.info("sgs注单数据手动拉取结束.......，拉取日期："+date);
		return "ok";
	}
	
	

}
