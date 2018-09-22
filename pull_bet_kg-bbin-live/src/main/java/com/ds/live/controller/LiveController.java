package com.ds.live.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ds.live.service.ManLiveService;
import com.ds.live.service.NewManLiveService;
import com.ds.live.until.LiveConfig;
import com.kg.live.entity.ApiInfoEntity;


@Controller
public class LiveController {
	@Autowired
	private ManLiveService liveService;
	@Autowired
	private NewManLiveService newManLiveService ;
	@RequestMapping(value="manGetOneRecord")
	public @ResponseBody Object manGetOneRecord(HttpServletRequest request) {
		String date = request.getParameter("date");//日期
		String siteId = request.getParameter("siteId");//网站id
		if(StringUtils.isBlank(date)){
			return "date不能为空";
		}
		if(StringUtils.isBlank(siteId)){
			return "siteId不能为空";
		}
		List<ApiInfoEntity> aipInfoList = liveService.getAipInfoList();
		if(aipInfoList == null || aipInfoList.size() == 0){
			return "site is null";
		}
		ApiInfoEntity apiInfo =null;
		for (ApiInfoEntity apiInfoEntity : aipInfoList) {
			if(Integer.valueOf(siteId).equals(apiInfoEntity.getSiteId())){
				apiInfo = apiInfoEntity;
				break;
			}
		}
		if(apiInfo == null || apiInfo.getState() != 50){
			return "site is not found";
		}
		
		long start = System.currentTimeMillis();
		liveService.manGetRecord(date,apiInfo);
		long end = System.currentTimeMillis();
		return "ok,耗时："+(end - start);
	}
	@RequestMapping(value="manGetRecord")
	public @ResponseBody Object manGetRecord(HttpServletRequest request) {
		String date = request.getParameter("date");//日期
		if(StringUtils.isBlank(date)){
			return "date不能为空";
		}
		long start = System.currentTimeMillis();
		liveService.manGetRecord(date);
		long end = System.currentTimeMillis();
		return "ok,耗时："+(end - start);
	}
	@RequestMapping(value="manGetOneRecordNew")
	public @ResponseBody Object manGetOneRecordNew(HttpServletRequest request) {
		String date = request.getParameter("date");//日期
		String siteId = request.getParameter("siteId");//网站id
		String starttime =request.getParameter("starttime");
		String endtime =request.getParameter("endtime");
		String pageStr=request.getParameter("pageStr");
		String pageLimitStr=request.getParameter("pageLimitStr");
		int page = 1;
		int pagelimit = LiveConfig.BBIN_PAGE_LIMIT; //200
		if(StringUtils.isBlank(starttime) || StringUtils.isBlank(endtime)){
			return "starttime or endtime is null";
		}
		if(StringUtils.isBlank(date)){
			return "date不能为空";
		}
		if(StringUtils.isBlank(siteId)){
			return "siteId不能为空";
		}
		List<ApiInfoEntity> aipInfoList = liveService.getAipInfoList();
		if(aipInfoList == null || aipInfoList.size() == 0){
			return "site is null";
		}
		ApiInfoEntity apiInfo =null;
		for (ApiInfoEntity apiInfoEntity : aipInfoList) {
			if(Integer.valueOf(siteId).equals(apiInfoEntity.getSiteId())){
				apiInfo = apiInfoEntity;
				break;
			}
		}
		if(apiInfo == null || apiInfo.getState() != 50){
			return "site is not found";
		}
		if(StringUtils.isNotBlank(pageStr)&&StringUtils.isNumeric(pageStr)){
			page=Integer.parseInt(pageStr);
		}
		if(StringUtils.isNotBlank(pageLimitStr)&&StringUtils.isNumeric(pageLimitStr)){
			pagelimit=Integer.parseInt(pageLimitStr);
		}
		long start = System.currentTimeMillis();
		newManLiveService.manGetRecord(date,starttime,endtime,page,pagelimit,apiInfo);
		long end = System.currentTimeMillis();
		return "ok,耗时："+(end - start);
	}
}