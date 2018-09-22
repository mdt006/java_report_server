package com.ds.lottery.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.ds.lottery.service.DsLotteryServiceImp;
import com.ds.lottery.service.HandLotteryServiceImpl;

@Controller
public class LotteryController {
	private Logger logger = LoggerFactory.getLogger(LotteryController.class);
	
	@Autowired
	private HandLotteryServiceImpl handLotteryServiceImpl;
	@Autowired
	private DsLotteryServiceImp lotteryServ;
	/**
	 * 重新统计报表
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="reValidateTotalReport")
	public @ResponseBody Object reValidateTotalReport(String siteIdList,String date)  {
		logger.info("reValidateTotalReport");
		if(org.apache.commons.lang3.StringUtils.isBlank(siteIdList)){
			return "siteIdList can not bet null";
		}
		if(org.apache.commons.lang3.StringUtils.isBlank(date)){
			return "date can not bet null";
		}
		try {
			Date formatDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			String[] siteIdArr = siteIdList.split(",");
			for (String s : siteIdArr) {
				lotteryServ.validateTotalReport(Integer.valueOf(s), formatDate);
			}
			
			return "ok";
		} catch (Exception e) {
			logger.error("",e);
		}
		return "error";
	}
	
	@RequestMapping(value="repullbetLottery")
	public @ResponseBody Object repullbetLottery(HttpServletRequest request) {
		logger.info("repullbetLottery invoke");
		handLotteryServiceImpl.handLotteryServiceTask();
	//	LotteryService.setLotteryInfoList(null);
		return "ok";
	}
	
	
	
	@RequestMapping(value="handFetch")
	public @ResponseBody Object handFetch(@Valid @ModelAttribute("beginId")Integer beginId,@Valid @ModelAttribute("count")Integer count,@Valid @ModelAttribute("user") String user,
			@Valid @ModelAttribute("siteId") Integer siteId,@Valid @ModelAttribute("level") String level,@Valid @ModelAttribute("record_url") String record_url) {
		logger.info("handFetch invoke beginId={},count={},user={},siteId={},level={},record_url={}",beginId,count,user,siteId,level,record_url);
		boolean flag=handLotteryServiceImpl.handFetch(beginId,count,user,siteId,level,record_url);
		if(flag){
			return "handFetch sucess";
		}
		return "handFetch fail";
	}
	
	@RequestMapping(value="handFetchByDateAndSiteId")
	public @ResponseBody Object handFetchByDateAndSiteId(@RequestParam String date,@RequestParam String siteId) {
		if(StringUtils.isEmpty(date)||StringUtils.isEmpty(siteId)){
			return "日期和siteId都不能为空";
		}
		Date formatDate=null;
		try {
			formatDate=new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			return "日期格式错误,格式:yyyy-MM-dd";
		}
		handLotteryServiceImpl.handLotteryByIdAndSite(formatDate, siteId);
		return "手动拉取网站-->"+siteId+"---成功";
	}
}
