package com.ds.live.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ds.live.service.DsLiveServiceImp;
import com.ds.live.service.ManLiveServiceImpl;

@Controller
public class LiveController {
	@Autowired
	private DsLiveServiceImp liveService;
	@Autowired
	private ManLiveServiceImpl manLiveService;
	
	@RequestMapping(value="setLiveNull")
	public @ResponseBody Object getMoney(HttpServletRequest request) {
		liveService.setAipInfoList(null);
		return "ok";
	}
	
	/**
	 * 
	 * @param startDate format:yyyy-MM-dd HH:mm:ss
	 * @param endDate format:yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	@RequestMapping(value="manGetRecord")
	@ResponseBody
	public String manGetRecord(@RequestParam String startDate,@RequestParam String endDate){
		if(StringUtils.isBlank(startDate)||StringUtils.isBlank(endDate)){
			return "date is not null";
		}
		if(startDate.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")&&endDate.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")){
			manLiveService.manGetRecord(startDate,endDate);
			return "manGetrecord|"+startDate+"---"+endDate+"|complete!";
		}else{
			return "date format is not right";
		}
	}
}
