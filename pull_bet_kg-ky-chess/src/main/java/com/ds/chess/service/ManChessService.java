package com.ds.chess.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ds.chess.common.BaseCommon;
import com.ds.chess.util.RequestUtil;
import com.kg.live.entity.ApiInfoEntity;

/**   
 * 手动拉取注单service
 * @author worf 
 * @date 2018年4月28日 上午11:48:01  
 */
@Service
public class ManChessService {
	
	private Logger logger = LoggerFactory.getLogger(ManChessService.class);
	
	@Autowired
	private KyChessService kyChessService;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public String getPullData(long startTime, long endTime, Integer siteId){
		List<ApiInfoEntity> apiInfoList = new ArrayList<ApiInfoEntity>();
		if(siteId != null){
			ApiInfoEntity apiInfo = kyChessService.getApiInfoBySiteId(siteId);
			if(apiInfo == null){
				return "site config is not found";
			}
			apiInfoList.add(apiInfo);
		}else{
			apiInfoList = kyChessService.getDbApiInfoList();
		}
		if(apiInfoList.isEmpty()){
			return "配置为空";
		}
		logger.info("ky棋牌注单数据手动拉取开始.......");
		for (ApiInfoEntity apiConfig : apiInfoList) {
			try {
				String param = kyChessService.getSendParams(startTime, endTime, apiConfig);
				logger.info("网站名称："+apiConfig.getSiteName()+"，请求地址："+apiConfig.getReporturl()+"，请求参数：" + param);
				String result = RequestUtil.sendGet(apiConfig.getReporturl(), param);
				logger.info("网站名称：{}，返回结果：{}", apiConfig.getSiteName(), result);
				JSONObject object = JSONObject.parseObject(result);
				JSONObject dObject = object.getJSONObject("d");
				if("0".equals(dObject.getString("code"))){ //请求成功
					kyChessService.saveManData(dObject.getJSONObject("list"), apiConfig);
				}else{
					continue;
				}
			}catch (Exception e) {
				logger.info("手动拉取数据发生异常，异常信息{}", e.getMessage());
				continue;
			}
		}
		logger.info("手动拉取数据完成");
		return "ok";
	}
	
	
	public String getPullData2(String date, Integer siteId){
		List<ApiInfoEntity> apiInfoList = new ArrayList<ApiInfoEntity>();
		if(siteId != null){
			ApiInfoEntity apiInfo = kyChessService.getApiInfoBySiteId(siteId);
			if(apiInfo == null){
				return "site config is not found";
			}
			apiInfoList.add(apiInfo);
		}else{
			apiInfoList = kyChessService.getDbApiInfoList();
		}
		if(apiInfoList.isEmpty()){
			return "配置为空";
		}
		logger.info("ky棋牌注单数据手动拉取开始.......，拉取日期："+date);
		for (ApiInfoEntity apiConfig : apiInfoList) {
			String[] times = null;
			Date nowDate = new Date();
			for (String time : BaseCommon.TIME_LIST) {
				try {
					times = time.split("_");
					String startTime = date + " " + times[0];
					String endTime = date + " " + times[1];
					Date startDate = sdf.parse(startTime);
					Date endDate = sdf.parse(endTime);
					if(startDate.getTime() > nowDate.getTime()){
						break;
					}
					if(endDate.getTime() > nowDate.getTime()){
						endDate = nowDate;
					}
					String param = kyChessService.getSendParams(startDate.getTime(), endDate.getTime(), apiConfig);
					logger.info("网站名称："+apiConfig.getSiteName()+"，请求地址："+apiConfig.getReporturl()+"，请求参数：" + param);
					String result = RequestUtil.sendGet(apiConfig.getReporturl(), param);
					logger.info("网站名称：{}，返回结果：{}", apiConfig.getSiteName(), result);
					JSONObject object = JSONObject.parseObject(result);
					JSONObject dObject = object.getJSONObject("d");
					if("0".equals(dObject.getString("code"))){ //请求成功
						kyChessService.saveManData(dObject.getJSONObject("list"), apiConfig);
					}else{
						continue;
					} 
				} catch (Exception e) {
					logger.info("拉取数据发生异常，异常信息{}", e.getMessage());
					continue;
				}
			}
		}
		return "ok";
	}
	
	

}
