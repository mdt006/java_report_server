package com.ds.live.task;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.onetwo.common.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ds.live.service.BBINService;
import com.ds.live.until.BBINDateUtils;
import com.ds.live.until.LiveConfig;
import com.kg.live.entity.ApiInfoEntity;
import com.kg.live.entity.ApiInfoEntityExample;
import com.kg.live.mapper.ApiInfoEntityMapper;


@Component
public class PullBetScanistor{
	private Logger logger = Logger.getLogger(getClass());
	@Autowired
	private BBINService bbinService;
	@Autowired
	private ApiInfoEntityMapper apiInfoMapper;

	@Scheduled(cron = "0/10 * * * * ?")
	public void exec() {
		//拉取bbin注单的rounddate,比正常美东时间会早几分钟，这样才不至于前一天的数据有延迟
		String rounddate = BBINDateUtils.getBBINRounddate(new Date());
		pullBet(rounddate);
	}
	private void pullBet(String rounddate){
		try {
			List<ApiInfoEntity> apiInfoList = getAipInfoList();
			logger.info("BBIN开始进入各个网站拉取数据.....");
			//各个代理网站开始拉取
			for (ApiInfoEntity api : apiInfoList) {
				bbinService.startPullBet(api,rounddate);
			}
			
		} catch (Exception e) {
			logger.error("拉取程序出错..", e);
		}
		logger.info("BBIN所有网站拉取一次完成");
	}
	/**
	 * 获取昨天最后一页数据的
	 */
	@Scheduled(cron = "0 30 0 * * ?")
	public void pullYesdateExec(){
		logger.info("开始拉取昨天的数据");
		String rounddate = BBINDateUtils.getBBINRounddate(DateUtil.addDay(new Date(), -1));
		pullBet(rounddate);
	}
	
	
	private List<ApiInfoEntity> getAipInfoList(){
		ApiInfoEntityExample e = new ApiInfoEntityExample();
		e.createCriteria().andLiveIdEqualTo(LiveConfig.BBIN_LIVE_ID).andStateEqualTo(LiveConfig.NORMAL_STATE);
		return apiInfoMapper.selectByExample(e);
	}
}
