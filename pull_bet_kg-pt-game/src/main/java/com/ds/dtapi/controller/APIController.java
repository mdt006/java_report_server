package com.ds.dtapi.controller;




import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ds.dtapi.service.ManualPullDataService;
import com.ds.dtapi.service.PTService;
import com.ds.dtapi.service.ValidDataService;
import com.kg.live.entity.ApiInfoEntity;



@Controller
@RequestMapping(value="app")
public class APIController {
	
	private static Logger logger = LoggerFactory.getLogger(APIController.class);
	@Autowired
	private PTService ptService;
	@Autowired
	private ManualPullDataService manualPullDataService;
	@Autowired
	private ValidDataService validDataService;
	@RequestMapping(value="manualPullData")
	public @ResponseBody Object manGetOneRecordNew(HttpServletRequest request) {
		String date = request.getParameter("date");//日期
		String siteId=request.getParameter("siteId");//代理
		String starttime =request.getParameter("starttime");
		String endtime =request.getParameter("endtime");
		String isUpdate=request.getParameter("isUpdate");
		boolean flag=false;
//		int page = 1;
//		int pagelimit = 500; //200
		if(StringUtils.isBlank(date)){
			return "date is null";
		}
		if(StringUtils.isBlank(siteId) || StringUtils.isBlank(siteId)){
			return " siteId is null ";
		}
		ApiInfoEntity apiInfo = ptService.getApiInfoBySiteId(Integer.parseInt(siteId));
		if(null==apiInfo){
			return "site config is not found";
		}
		if(StringUtils.isNotBlank(isUpdate)){
			flag=Boolean.valueOf(isUpdate);
		}
		long start = System.currentTimeMillis();
		manualPullDataService.pullData(apiInfo, date, starttime, endtime,flag);
		long end = System.currentTimeMillis();
		return "ok,耗时："+(end - start);
	}
	
	@RequestMapping(value="checkByTime")
	public @ResponseBody Object checkByTime(HttpServletRequest request) throws Exception {
		String date = request.getParameter("date");//日期
		String siteId=request.getParameter("siteId");//代理
		if(StringUtils.isBlank(date)){
			return "date is null";
		}
		if(StringUtils.isBlank(siteId) || StringUtils.isBlank(siteId)){
			return " siteId is null ";
		}
		ApiInfoEntity apiInfo = ptService.getApiInfoBySiteId(Integer.parseInt(siteId));
		if(null==apiInfo){
			return "site config is not found";
		}
		long start = System.currentTimeMillis();
		validDataService.getCountByTime(apiInfo, date);
		long end = System.currentTimeMillis();
		return "ok,耗时："+(end - start);
	}
	
	@RequestMapping(value="checkBySite")
	public @ResponseBody Object checkBySite(HttpServletRequest request) throws Exception {
		String date = request.getParameter("date");//日期
		String siteId=request.getParameter("siteId");//代理
		if(StringUtils.isBlank(date)){
			return "date is null";
		}
		if(StringUtils.isBlank(siteId) || StringUtils.isBlank(siteId)){
			return " siteId is null ";
		}
		ApiInfoEntity apiInfo = ptService.getApiInfoBySiteId(Integer.parseInt(siteId));
		if(null==apiInfo){
			return "site config is not found";
		}
		long start = System.currentTimeMillis();
		validDataService.startValidBySite(apiInfo, date);
		long end = System.currentTimeMillis();
		return "ok,耗时："+(end - start);
	}

	

	
	
}
