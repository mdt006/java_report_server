package com.ds.live.task;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.onetwo.common.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ds.live.common.BaseCommon;
import com.ds.live.service.BaseService;
import com.ds.live.service.DsAgHunterServiceImp;
import com.ds.live.service.DsLiveServiceImp;
import com.ds.live.service.ReportService;
import com.ds.live.service.SiteDayReportService;
import com.ds.live.thread.AgHunterThread;
import com.ds.live.thread.LiveThread;
import com.ds.live.thread.ReportThread;
import com.kg.live.entity.TotalReportConfigWithBLOBs;

@Component
public class StartTask {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private BaseService baseService;
	@Autowired
	private ReportService reportService;
	@Autowired
	private DsLiveServiceImp liveService;
	@Autowired
	private DsAgHunterServiceImp agHunterService;
	@Autowired
	private SiteDayReportService siteDayReportService;
	
	@PostConstruct
	public void startTaskAll(){
		List<TotalReportConfigWithBLOBs> configList=baseService.loadConfigList();
		logger.info("开始统计所有配置数据....数量："+configList.size());
		for(TotalReportConfigWithBLOBs config : configList){
			logger.info("{}开启统计线程,state={}",config.getMemo(),config.getState());
			this.startTaskForConfig(config);
		}
		
	}
	public void startTaskForConfig(TotalReportConfigWithBLOBs config){
		
		if(config.getState()==100){
			new Thread(new ReportThread(reportService,config)).start();
		}
		if(config.getState()==60){
			new Thread(new AgHunterThread(agHunterService,config)).start();
		}
		if(config.getState()==50){
			new Thread(new LiveThread(liveService,config)).start();
		}
		BaseCommon.CONFIG_MAP.put(config.getId()+"_"+config.getState(), config);
	}
	
	@Scheduled(cron="0 0/8 * * * ? ")
	public void loadConfigMap(){
		List<TotalReportConfigWithBLOBs> configList=baseService.loadConfigList();
		logger.info("加载配置，数量:{}",configList.size());
		Map<String,TotalReportConfigWithBLOBs> listMap=new HashMap<String,TotalReportConfigWithBLOBs>();
		listMap.putAll(BaseCommon.CONFIG_MAP);
		for (Map.Entry<String, TotalReportConfigWithBLOBs> map : listMap.entrySet()) {
			boolean exits=false;
			for(TotalReportConfigWithBLOBs o : configList){
				String mapKey=o.getId()+"_"+o.getState();
				exits=map.getKey().equals(mapKey);
				if(exits){
					break;
				}
			}
			if(!exits){//如果当前运行的配置当中在数据库中已被删除，那么删除当前运行的配置(线程自动判断停止运行)
				logger.info("删除当前配置,{},id,state={}",map.getValue().getMemo(),map.getKey());
				BaseCommon.CONFIG_MAP.remove(map.getKey());
			}
		}
		for(TotalReportConfigWithBLOBs o : configList){
			String mapKey=o.getId()+"_"+o.getState();
			if(!BaseCommon.CONFIG_MAP.containsKey(mapKey)){//如果新加载的配置没有存在于正在运行的线程
				//开启新的线程
				this.startTaskForConfig(o);
				logger.info("开启新的统计线程,统计名称:{},state={}",o.getMemo(),o.getState());
			}else{
				BaseCommon.CONFIG_MAP.put(mapKey, o);//更新当前配置
			}
		}
		logger.info("当前正在进行统计的线程，map{}",BaseCommon.CONFIG_MAP.toString());
	}
	
	@Scheduled(cron="0 0/1 * * * ? ")
	public void startDsReportSiteDayTask(){
		logger.info("开始统计网站每天的数据");
		try {
			for(int i=0;i<3;i++){
				siteDayReportService.exeTotalReportByDay( DateUtil.addDay(new Date(), -i));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("startDsReportSiteDayTask方法执行错误：",e);
			BaseCommon.sendTelegramMessage("startDsReportSiteDayTask>>>"+e.getMessage());
		}
	}
	@Scheduled(cron="0 0 19 * * ? ")
	public void checkReportByMonth(){
		logger.info("校验两个月数据>>>>>>>>>");
		long starttime=System.currentTimeMillis();
		try {
			siteDayReportService.validReportByMonthDay( DateUtil.addDay(new Date(), -60));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("checkReportByMonth方法执行错误：",e);
			
			BaseCommon.sendTelegramMessage("checkReportByMonth>>>"+e.getMessage());
		}
		long endtime=System.currentTimeMillis();
		logger.info("校验两个月数据耗时："+(endtime-starttime));
	}
	
	
}
