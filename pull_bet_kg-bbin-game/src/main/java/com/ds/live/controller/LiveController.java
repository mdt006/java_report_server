package com.ds.live.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ds.live.gameservice.GameDBService;
import com.ds.live.gameservice.ManualPullGameDataService;
import com.ds.live.service.NewManLiveService;
import com.ds.live.until.LiveConfig;
import com.kg.live.entity.ApiInfoEntity;


@Controller
public class LiveController {
	@Autowired
	private NewManLiveService newManLiveService;
	@Autowired
	private GameDBService bbService;
	@Autowired
	private ManualPullGameDataService manualPullGameDataService;
	
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
		newManLiveService.initapiInfoList();
		List<ApiInfoEntity> aipInfoList = newManLiveService.getAipInfoList();
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
	
	//捕鱼大师和捕鱼达人
	@RequestMapping(value="pullGameData")
	public @ResponseBody Object pullGameData(HttpServletRequest request) {
		String date = request.getParameter("date");//日期
		String siteId = request.getParameter("siteId");//网站id
		String starttime =request.getParameter("starttime");
		String endtime =request.getParameter("endtime");
		String pageStr=request.getParameter("pageStr");
		String pageLimitStr=request.getParameter("pageLimitStr");
		String action=request.getParameter("action");
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
		//获取权重请求列表
		List<ApiInfoEntity> apiInfoList = bbService.getConfigApiInfo();
		if(apiInfoList == null || apiInfoList.size() == 0){
			return "site is null";
		}
		ApiInfoEntity apiInfo =null;
		for (ApiInfoEntity apiInfoEntity : apiInfoList) {
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
		manualPullGameDataService.getGameRecord(apiInfo, date, starttime, endtime, page, pagelimit, action);
		long end = System.currentTimeMillis();
		return "ok,耗时："+(end - start);
	}
}
