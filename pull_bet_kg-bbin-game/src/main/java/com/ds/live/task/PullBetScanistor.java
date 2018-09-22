package com.ds.live.task;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.onetwo.common.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ds.live.service.ValidDataService;
import com.ds.live.until.BBINDateUtils;
import com.ds.live.until.LiveConfig;
import com.kg.live.entity.ApiInfoEntity;
import com.kg.live.entity.ApiInfoEntityExample;
import com.kg.live.mapper.ApiInfoEntityMapper;


@Component
public class PullBetScanistor{
	private Logger logger = Logger.getLogger(getClass());
	@Autowired
	private ApiInfoEntityMapper apiInfoMapper;
	@Autowired
	private ValidDataService validDataService;
	
	private void pullBet(String rounddate){
		try {
			List<ApiInfoEntity> apiInfoList = getAipInfoList();
			logger.info("BBIN开始验证拉取数据..."+rounddate);
			//各个代理网站开始拉取
			for (ApiInfoEntity api : apiInfoList) {
				validDataService.validCount(api,rounddate);
			}
			
		} catch (Exception e) {
			logger.error("拉取程序出错..", e);
		}
		logger.info("BBIN所有网站验证昨天数据一次完成");
	}
	/**
	 * 获取昨天最后一页数据的
	 */
	@Scheduled(cron = "0 30 0 * * ?")
	public void pullYesdateExec(){
		String rounddate = BBINDateUtils.getBBINRounddate(DateUtil.addDay(new Date(), -1));
		logger.info("开始验证昨天的数据："+rounddate);
		
		pullBet(rounddate);
	}
	
	
	private List<ApiInfoEntity> getAipInfoList(){
		ApiInfoEntityExample e = new ApiInfoEntityExample();
		e.createCriteria().andLiveIdEqualTo(LiveConfig.BBIN_LIVE_ID).andStateEqualTo(LiveConfig.NORMAL_STATE);
		return apiInfoMapper.selectByExample(e);
	}
}
