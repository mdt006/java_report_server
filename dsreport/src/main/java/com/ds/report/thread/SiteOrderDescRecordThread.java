package com.ds.report.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.ds.report.service.SiteOrderDescService;

public class SiteOrderDescRecordThread implements Runnable{
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	private SiteOrderDescService siteOrderDescService;
	private JSONObject obj;
	public SiteOrderDescRecordThread(SiteOrderDescService siteOrderDescService,JSONObject obj) {
		super();
		this.siteOrderDescService=siteOrderDescService;
		this.obj=obj;
	}
	@Override
	public void run() {
		try{
			addCache();
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
	
	public void addCache()
			throws Exception {
		siteOrderDescService.siteOrderDesc(obj);
	}
	
	
	

}
