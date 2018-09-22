package com.ds.report.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.ds.report.controller.DsReportHproseAction;
import com.yooyo.util.WebApplication;

import hprose.server.HproseTcpServer;

//@Service
public class DsReportHproseService implements ApplicationListener<ContextRefreshedEvent> {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private DsReportServiceImpl dsReportServiceImpl;
	
	@Resource
	private HunterJackpotServiceImpl hunterJackpotServiceImpl;
	@Resource
	private SiteOrderDescService siteOrderDescService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {//root application context 没有parent，他就是老大.  
		
		if (event.getApplicationContext().getParent() == null) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					
					try {
						String tcpHost = WebApplication.getProperty("tcpHost");
						String tcpPort = WebApplication.getProperty("tcpPort");
					HproseTcpServer server = new HproseTcpServer("tcp://"+tcpHost+":"+tcpPort);
					//hprose版本从hprose-java-6换成maven上的版本hprose-java-2.0.32原来方法已经不存在
				//	server.setThreadCount(500);
					server.setReactorThreads(100);
					server.add("listTotalReport",new DsReportHproseAction(dsReportServiceImpl));
					server.add("listDetailReport",new DsReportHproseAction(dsReportServiceImpl));
					server.add("betTotalByDay",new DsReportHproseAction(dsReportServiceImpl));
					server.add("betTotalByUser",new DsReportHproseAction(dsReportServiceImpl));
					server.add("privilegeTotal",new DsReportHproseAction(dsReportServiceImpl));
					server.add("commissionTotal",new DsReportHproseAction(dsReportServiceImpl));
					server.add("commissionTotalByPage",new DsReportHproseAction(dsReportServiceImpl));
					server.add("waterReportByProc",new DsReportHproseAction(dsReportServiceImpl));
					server.add("waterReport",new DsReportHproseAction(dsReportServiceImpl));
					server.add("auditTotal",new DsReportHproseAction(dsReportServiceImpl));
					server.add("auditTotalTemp",new DsReportHproseAction(dsReportServiceImpl));
					server.add("tipsList",new DsReportHproseAction(dsReportServiceImpl));
					server.add("validUserCount",new DsReportHproseAction(dsReportServiceImpl));
					server.add("jpGameList",new DsReportHproseAction(dsReportServiceImpl));
					server.add("getMemberBetInfo",new DsReportHproseAction(dsReportServiceImpl));
					server.add("getBetInfoByDate",new DsReportHproseAction(dsReportServiceImpl));
					server.add("getValidateMemberByDate",new DsReportHproseAction(dsReportServiceImpl));
					server.add("getAllLiveByUser",new DsReportHproseAction(dsReportServiceImpl));
					server.add("getAllTypeByUser",new DsReportHproseAction(dsReportServiceImpl));
					server.add("waterReportNew",new DsReportHproseAction(dsReportServiceImpl));
					server.add("waterReportNewByPage",new DsReportHproseAction(dsReportServiceImpl));
					server.add("setMemberData",new DsReportHproseAction(dsReportServiceImpl));
					server.add("getMemberNameList",new DsReportHproseAction(dsReportServiceImpl));
					server.add("siteOrderDesc",new DsReportHproseAction(siteOrderDescService));
					server.add("getBetInfoByLiveId",new DsReportHproseAction(dsReportServiceImpl));
					server.add("auditTotalTempBatch",new DsReportHproseAction(dsReportServiceImpl));
					server.add("getJackpot",new DsReportHproseAction(dsReportServiceImpl));
					server.add("getTotalRecord",new DsReportHproseAction(hunterJackpotServiceImpl));
					server.add("getDeatilRecord",new DsReportHproseAction(dsReportServiceImpl));
					server.add("getReportGroupByGameType",new DsReportHproseAction(dsReportServiceImpl));
					server.add("getTotalBySite",new DsReportHproseAction(dsReportServiceImpl));

					server.setDebugEnabled(true);
					server.start();
					
					logger.info("HproseTcp.........START");
					System.in.read();
				} catch (Exception e) {
					e.printStackTrace();
					logger.info("HproseTcp......exception。。。。");
				}
				}
			}).start();

		}
	}

}
