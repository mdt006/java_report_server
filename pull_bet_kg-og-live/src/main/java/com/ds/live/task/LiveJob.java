package com.ds.live.task;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ds.live.service.DsLiveServiceImp;
import com.kg.live.entity.ApiInfoEntity;

public class LiveJob {
	final static Logger logger = Logger.getLogger(LiveJob.class);
	private static boolean firstRun = true;
	@Autowired
	private DsLiveServiceImp liveService;
	public void execute(){
		logger.info("进入定时任务检查....");
		if(firstRun){
			firstRun = false;
			logger.info("startGetRecord().....");
			liveService.startGetRecord();
			
		}else{
			if(validateList()){
				if(liveService.getAipInfoList()!=null 
						&& liveService.getAipInfoList().size()>0){
					logger.info("配置文件已发生改变,清空原来配置文件列表");
					liveService.setAipInfoList(null);
				}
				
			}else{
				logger.info("配置文件没有发生改变，不进行任何处理.....");
			}
		}
	}
	/**
	 * 验证是否配置文件是否发生改变，如果改变，则重新加载配置文件
	 */
	public boolean validateList(){
		//现有的list
		List<ApiInfoEntity> oldList = liveService.getAipInfoList();
		//最新db的list
		List<ApiInfoEntity> newList = liveService.getDbApiInfoList();
		//配置文件被清空
		if(newList == null 
				||oldList == null
				||newList.size() ==0
				||oldList.size() ==0){
			return true;
		}
		if(newList.size()!= oldList.size()){
			return true;
		}
		for (ApiInfoEntity newApi : newList) {
			for (ApiInfoEntity oldApi : oldList) {
				if(oldApi.getId().equals(newApi.getId())){
					if(!oldApi.getLiveKey().equals(newApi.getLiveKey())){
						return true;
					}
				}
			}
		}
		
		return false;
	}
}
