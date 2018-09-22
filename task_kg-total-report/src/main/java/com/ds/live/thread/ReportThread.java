package com.ds.live.thread;


import org.apache.log4j.Logger;

import com.ds.live.common.BaseCommon;
import com.ds.live.service.ReportService;
import com.kg.live.entity.TotalReportConfigWithBLOBs;

public class ReportThread implements Runnable{
	private Logger logger = Logger.getLogger(this.getClass());
	private ReportService reportService;
	private TotalReportConfigWithBLOBs reportConfig;
	
	
	public ReportThread(ReportService reportService,
			TotalReportConfigWithBLOBs config) {
		super();
		this.reportService = reportService;
		this.reportConfig = config;
	}


	@Override
	public void run() {
		while(true){
			//判断该配置是否有修改状态以及是否还存在(例如修改state,删除此条配置)则该线程停止
			Boolean b=BaseCommon.CONFIG_MAP.containsKey(reportConfig.getId()+"_"+reportConfig.getState());
			if(!b){
				break;
			}
			try {
				logger.info(reportConfig.getMemo()+"开始统计");
				String gameTypeSql = reportConfig.getSourceTableName();
				reportService.insertGameType(gameTypeSql);
				String selectReportSql = reportConfig.getSelectBetTableSql();
				logger.info("selectReportSql："+selectReportSql);
				//获取未统计或者统计之后已经发生改变的sql语句
				reportService.exeNotTotalReport(selectReportSql);
				logger.info(reportConfig.getMemo()+"统计一次完成");
				//验证取消被统计的注单,并将其删除(report表中) 针对蛮牛--某会员某一天某种游戏,因取消注单,而无任何有效投注
				if(reportConfig.getMemo().equals("蛮牛")){
					logger.info("蛮牛统计进入校验程序------------->start");
					reportService.verifyManniu();
					logger.info("蛮牛校验完成,线程休眠1分钟");
				}
				Thread.sleep(BaseCommon.ONE_SLEEP_TIME);
			} catch (Exception e) {
				try {
					Thread.sleep(BaseCommon.ONE_SLEEP_TIME);

				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				long errorTime=System.currentTimeMillis();
				logger.error(errorTime+"="+reportConfig.getMemo( )+">统计异常：",e);
				BaseCommon.sendTelegramMessage(errorTime+"="+reportConfig.getMemo()+">统计异常"+e.getMessage());
			}
		}
		logger.info(reportConfig.getId()+"统计线程停止："+reportConfig.getMemo());
	}

}
