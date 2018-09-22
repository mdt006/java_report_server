package com.ds.dtapi.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kg.live.entity.ApiInfoEntity;
import com.kg.live.mapper.DtPtPageRecordMapper;

@Component
public class PTTask{
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private PTService ptService;
	@Autowired
	private DtPtPageRecordMapper pageRecordMapper;
	
	private static Map<String,ApiInfoEntity> apiInfoThreadMap=new ConcurrentHashMap<String,ApiInfoEntity>();

	@PostConstruct
	public void start(){
		logger.info("程序开始:"+new Date().getTime());
		List<ApiInfoEntity> apiInfoList = ptService.getConfigApiInfo();
		for (ApiInfoEntity apiInfo : apiInfoList) {
			this.startNewPullThread(apiInfo);
		}
	}
	
	@Scheduled(cron="0 0/5 * * * ? ")
	public void checkPullThread(){
		List<ApiInfoEntity> apiInfoList = ptService.getConfigApiInfo();
		this.threadConfig(apiInfoList);
		logger.info("当前拉取线程：{}",apiInfoThreadMap);
	}
	
	private void startNewPullThread(ApiInfoEntity newInfo){
		new Thread(new PTRequestService(newInfo,ptService,pageRecordMapper)).start();
		apiInfoThreadMap.put(newInfo.getAgent(), newInfo);
		logger.info("启动一条拉取线程:{},{}",newInfo.getSiteId(),newInfo.getAgent());
	}
	
	public static boolean validNewApiInfo(ApiInfoEntity newInfo){
		if(!apiInfoThreadMap.containsKey(newInfo.getAgent())){
			return true;
		}
		return false;
	}
	
	/**
	 * 删除数据库中已清除的配置
	 * 或者加入新的配置拉取
	 */
	private void threadConfig(List<ApiInfoEntity> list){
		Map<String,ApiInfoEntity> apiMap=new HashMap<String,ApiInfoEntity>();
		apiMap.putAll(apiInfoThreadMap);
		for(Map.Entry<String, ApiInfoEntity> map: apiMap.entrySet()){
			boolean exits=false;
			for(ApiInfoEntity apiInfo : list){
				exits=map.getKey().equals(apiInfo.getAgent());
				if(exits){
					break;
				}
			}
			if(!exits){
				apiInfoThreadMap.remove(map.getKey());
				logger.info("删除当前运行配置,SiteId:{}",map.getValue().getSiteId());
			}
			
		}
		for(ApiInfoEntity apiInfo : list){
			if(!apiInfoThreadMap.containsKey(apiInfo.getAgent())){
				logger.info("加入一条新的线程配置:{},{}",apiInfo.getSiteId(),apiInfo.getAgent());
				this.startNewPullThread(apiInfo);
			}
		}
	}
}

