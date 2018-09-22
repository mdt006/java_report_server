package com.ds.lottery.controller;

import java.text.SimpleDateFormat;
import java.util.Date;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ds.lottery.service.DsLotteryServiceImp;

@Controller
public class LotteryController {
	private Logger logger = LoggerFactory.getLogger(LotteryController.class);
	
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
	
	
}
