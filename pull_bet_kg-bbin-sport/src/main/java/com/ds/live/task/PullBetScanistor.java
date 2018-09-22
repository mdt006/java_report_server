package com.ds.live.task;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ds.live.service.BBINService;
import com.ds.live.until.BBINDateUtils;
import com.ds.live.until.LiveConfig;
import com.kg.live.entity.ApiInfoEntity;
import com.kg.live.entity.ApiInfoEntityExample;
import com.kg.live.entity.BbinLiveSportEntity;
import com.kg.live.entity.BbinLiveSportEntityExample;
import com.kg.live.mapper.ApiInfoEntityMapper;
import com.kg.live.mapper.BbinLiveSportEntityMapper;


@Component
public class PullBetScanistor{
	private Logger logger = Logger.getLogger(getClass());
	@Autowired
	private BBINService bbinService;
	@Autowired
	private ApiInfoEntityMapper apiInfoMapper;
	@Autowired
	private BbinLiveSportEntityMapper bbinSportMapper;
	
	static SimpleDateFormat sdfdate= new SimpleDateFormat("yyyy-MM-dd",Locale.US);
	
	@Scheduled(cron = "0 0/5 * * * ? ")
	public void exec() {
		try {
			List<ApiInfoEntity> apiInfoList = getAipInfoList();
			logger.info("BBIN开始进入各个网站拉取数据.....");
			//拉取bbin注单的rounddate,比正常美东时间会早几分钟，这样才不至于前一天的数据有延迟
			String rounddate = BBINDateUtils.getBBINRounddate(new Date());
			//各个代理网站开始拉取
			for (ApiInfoEntity api : apiInfoList) {
				bbinService.startPullBet(api,rounddate);
			}
			
		} catch (Exception e) {
			logger.error("拉取程序出错..", e);
		}
		logger.info("BBIN所有网站拉取一次完成");
	}
	
//	@Scheduled(cron = "0 0/30 * * * ? ")
//	public void execLastWeek() {
//		try {
//			List<ApiInfoEntity> apiInfoList = getAipInfoList();
//			logger.info("BBIN开始进入各个网站拉取上周数据.....");
//			
//			for (int i = 7; i > 0; i--) {
//				Calendar calendar = Calendar.getInstance();
//				calendar.setTime(new Date());
//				calendar.add(Calendar.DATE, -1*i);
//				//拉取bbin注单的rounddate,比正常美东时间会早几分钟，这样才不至于前一天的数据有延迟
//				String rounddate = BBINDateUtils.getBBINRounddate(calendar.getTime());
//				logger.info("BBIN开始进入各个网站拉取"+rounddate+"数据.....");
//				//各个代理网站开始拉取
//				for (ApiInfoEntity api : apiInfoList) {
//					bbinService.startPullBet(api,rounddate);
//				}
//			}
//			
//		} catch (Exception e) {
//			logger.error("拉取程序出错..", e);
//		}
//		logger.info("BBIN所有网站拉取最近七天完成");
//	}
	
	/**
	 * 获取历史未结算注单
	 */
	@Scheduled(cron = "0 0/5 * * * ? ")
	public void pullHistoryBet(){
		try {
			List<BbinLiveSportEntity> bbinLiveSportEntityList = getHisRecord();
			logger.info("BBIN体育开始进入各个网站拉取未结算注单数据.....");
			
			ApiInfoEntity apiInfo = null;
			
			for (BbinLiveSportEntity bbin : bbinLiveSportEntityList) {
				apiInfo = getHisApiInfo(bbin.getUppername());
				
				bbinService.startPullBet(apiInfo,sdfdate.format(bbin.getWagersDate()));
			}
			
		} catch (Exception e) {
			logger.error("拉取bbin体育未结算注单程序出错..", e);
		}
		logger.info("BBIN体育未结算注单所有网站拉取一次完成");
		
	}
	
	
	private List<ApiInfoEntity> getAipInfoList(){
		ApiInfoEntityExample e = new ApiInfoEntityExample();
		e.createCriteria().andLiveIdEqualTo(LiveConfig.BBIN_LIVE_ID).andStateEqualTo(LiveConfig.NORMAL_STATE);
		return apiInfoMapper.selectByExample(e);
	}
	
	private ApiInfoEntity getHisApiInfo(String uppername){
		ApiInfoEntityExample e = new ApiInfoEntityExample();
		e.createCriteria().andLiveKeyEqualTo(uppername);
		List<ApiInfoEntity> list = apiInfoMapper.selectByExample(e);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
		
	}
	
	private List<BbinLiveSportEntity> getHisRecord(){
		//获取当前日期零点时间
		Calendar endTime = Calendar.getInstance();
		endTime.set(Calendar.HOUR_OF_DAY, 0);
		endTime.set(Calendar.MINUTE, 0);
		endTime.set(Calendar.SECOND, 0);
		
		//获取30天之内
		Calendar starTime = Calendar.getInstance();
		starTime.add(Calendar.DATE, -30); 
		
		BbinLiveSportEntityExample e = new BbinLiveSportEntityExample();
		e.createCriteria().andWinLossTypeIsNull().andWagersDateLessThan(endTime.getTime()).andWagersDateGreaterThan(starTime.getTime());
		List<BbinLiveSportEntity> list = bbinSportMapper.selectByExample(e);
		return list;
	}
}
