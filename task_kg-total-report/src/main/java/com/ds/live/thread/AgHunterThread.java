package com.ds.live.thread;



import java.util.Date;

import org.apache.log4j.Logger;
import org.onetwo.common.utils.DateUtil;

import com.ds.live.common.BaseCommon;
import com.ds.live.service.DsAgHunterServiceImp;
import com.kg.live.entity.TotalReportConfigWithBLOBs;

public class AgHunterThread implements Runnable{
	private Logger logger = Logger.getLogger(this.getClass());
	private DsAgHunterServiceImp agHunterService;
	private TotalReportConfigWithBLOBs reportConfig;
	/**
	 * 用于统计核对的时间标识，如果超过一个小时，就可以进行下一轮核对
	 */
	public AgHunterThread(DsAgHunterServiceImp agHunterService, TotalReportConfigWithBLOBs reportConfig) {
		super();
		this.agHunterService = agHunterService;
		this.reportConfig = reportConfig;
	}
	
	@Override
	public void run() {
		while(true){
			//判断该配置是否有修改状态以及是否还存在(例如修改state,删除此条配置)则该线程停止
			Boolean b=BaseCommon.CONFIG_MAP.containsKey(reportConfig.getId()+"_"+reportConfig.getState());
			if(!b){
				break;
			}
			
			String selectReportSql = reportConfig.getSelectBetTableSql();
			String insertTempSql =  reportConfig.getInsertTempSql();
			String memo = reportConfig.getMemo();
			logger.info("selectReportSql："+selectReportSql);
			logger.info("insertTempSql："+insertTempSql);
			try {
				for (int i = 0; i < 3; i++) {
					Integer count = agHunterService.getBet(selectReportSql,insertTempSql,memo,DateUtil.addDay(new Date(), -i));
					logger.info("统计条数:"+count);
				}
				//进入统计核对程序
				logger.info("进入核对程序");
				Thread.sleep(BaseCommon.ONE_SLEEP_TIME);
				logger.info("核对程序完成");
			} catch (Exception e) {
				e.printStackTrace();
				try {
					Thread.sleep(BaseCommon.ONE_SLEEP_TIME);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				long errorTime=System.currentTimeMillis();
				logger.error(errorTime+"="+reportConfig.getMemo()+">统计异常：",e);
				BaseCommon.sendTelegramMessage(errorTime+"="+reportConfig.getMemo()+">统计异常"+e.getMessage());
			}
		}
		logger.info(reportConfig.getId()+"统计线程停止："+reportConfig.getMemo());	
			
	}
		

}
