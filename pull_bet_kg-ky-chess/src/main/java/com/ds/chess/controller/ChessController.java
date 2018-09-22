package com.ds.chess.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ds.chess.service.ManChessService;

/**   
 * 手动拉取注单
 * @author worf 
 * @date 2018年4月28日 上午10:50:32  
 */
@Controller
public class ChessController {
	private static final long time = 1000*60*60;
	
	@Autowired
	private ManChessService manChessService;
	
	/**
	 * 手动拉取指定时间区间注单   最大不能超过60分钟
	 * @param startDate    开始时间    yyyy-MM-dd HH:mm:ss
	 * @param endDate      结束时间   yyyy-MM-dd HH:mm:ss
	 * @param siteId       站点id
	 * @return
	 */
	@RequestMapping(value="manGetRecord",produces="text/html;charset=UTF-8;")
	public @ResponseBody Object manGetRecord(@RequestParam String startDate,@RequestParam String endDate,
											@RequestParam(required=false) Integer siteId) {
		if(StringUtils.isBlank(startDate) || StringUtils.isBlank(endDate)){
			return "开始或结束时间不能为空";
		}
		long startTime= 0l;
		long endTime = 0l;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date start = sdf.parse(startDate);
			Date end = sdf.parse(endDate);
			startTime = start.getTime();
			endTime = end.getTime();
			if(endTime - startTime > time){
				return "时间间隔不能超过60分钟";
			}
		} catch (ParseException e) {
			return "日期格式错误,格式:yyyy-MM-dd HH:mm:ss";
		}
		//手动拉取
		return manChessService.getPullData(startTime, endTime, siteId);
	}
	
	/**
	 * 手动拉取某一天所有注单
	 * @param date   yyyy-MM-dd
	 * @param siteId       站点id
	 * @return
	 */
	@RequestMapping(value="manGetDayRecord",produces="text/html;charset=UTF-8;")
	public @ResponseBody Object manGetDayRecord(@RequestParam String date, @RequestParam(required=false) Integer siteId) {
		if(StringUtils.isBlank(date)){
			return "拉取日期为空";
		}
		return manChessService.getPullData2(date, siteId);
	}

}
