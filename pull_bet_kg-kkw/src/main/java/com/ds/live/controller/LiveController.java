package com.ds.live.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ds.live.service.DsLiveServiceImp;
import com.ds.live.service.HandLiveService;

@Controller
public class LiveController {
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private DsLiveServiceImp liveService;
	
	@Autowired
	private HandLiveService handLiveService;
	
	@RequestMapping(value="setLiveNull")
	public @ResponseBody Object getMoney(HttpServletRequest request) {
		liveService.setAipInfoList(null);
		return "ok";
	}
	
	@RequestMapping(value="handLive")
	public @ResponseBody Object getBillno(HttpServletRequest request){
		
		String beginid = request.getParameter("beginid");//注单编号
		String hashCode = request.getParameter("hashCode");//hashCode
		String siteId = request.getParameter("siteId");//网址编号
		String lotteryGameType = request.getParameter("lotteryGameType");//拉取彩票类型
		
		logger.info("请求参数:beginid " + beginid + " hashCode "+hashCode + " siteId " + siteId + " lotteryGameType "+lotteryGameType);
		
		if(null == beginid){
			return "false";
		}
		
		handLiveService.bet(beginid, hashCode, siteId, lotteryGameType);
		
		return "ok";
	}
}
