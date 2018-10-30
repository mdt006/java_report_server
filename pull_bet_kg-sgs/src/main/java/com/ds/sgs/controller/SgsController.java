package com.ds.sgs.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ds.sgs.common.BaseCommon;
import com.ds.sgs.service.ManPullDataService;

/**
 * 手动拉取注单controller
 * @author worf 
 * @date 2018年6月8日 下午4:34:13
 */
@Controller
public class SgsController {
	
	@Autowired
	private ManPullDataService manChessService;
	
	/**
	 * 手动拉取指定时间区间注单   最大不能超过60分钟
	 * @param startDate    开始时间    yyyy-MM-dd HH:mm:ss
	 * @param endDate      结束时间   yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	@RequestMapping(value="manGetRecord",method= RequestMethod.POST,produces=("application/json;charset=UTF-8"))
	public @ResponseBody Object manGetRecord(@RequestParam String startDate,@RequestParam String endDate) {
		if(StringUtils.isBlank(startDate) || StringUtils.isBlank(endDate)){
			return "开始或结束时间不能为空";
		}
		long startTime= 0l;
		long endTime = 0l;
		Date start; 
		Date end;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			start = sdf.parse(startDate);
			end = sdf.parse(endDate);
			startTime = start.getTime();
			endTime = end.getTime();
			if(endTime - startTime > BaseCommon.TIME_HOUR){
				return "时间间隔不能超过60分钟";
			}
		} catch (ParseException e) {
			return "日期格式错误,格式:yyyy-MM-dd HH:mm:ss";
		}
		//手动拉取
		return manChessService.getPullData(start, end);
	}
	
	/**
	 * 手动拉取某一天所有注单
	 * @param date   yyyy-MM-dd
	 * @return
	 */
	@RequestMapping(value="manGetDayRecord",method= RequestMethod.POST,produces=("application/json;charset=UTF-8"))
	public @ResponseBody Object manGetDayRecord(@RequestParam String date) {
		if(StringUtils.isBlank(date)){
			return "拉取日期为空";
		}
		return manChessService.getPullOneDayData(date);
	}

}
