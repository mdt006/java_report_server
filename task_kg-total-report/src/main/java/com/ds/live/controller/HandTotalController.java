package com.ds.live.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.ds.live.service.BaseService;
import com.ds.live.service.DsAgHunterServiceImp;
import com.ds.live.service.HandTotalService;
import com.ds.live.service.SiteDayReportService;
import com.kg.live.entity.TotalReportConfigWithBLOBs;

@Controller
public class HandTotalController {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private HandTotalService handTotalService;
	@Autowired
	private DsAgHunterServiceImp dsAgHunterServiceImp;
	@Autowired
	private BaseService baseService;
	@Autowired
	private SiteDayReportService siteDayReportService;
	/**
	 * @describe 用于新统计Sql,负责删除重复(只删除report),然后重新统计,gameType代表total-report_config表的id
	 * @replenish 现行统计sql无法统计出reprot表多的数据,情况:用户投注后,开始注单正常,后变取消且此用户此游戏类型下无任何有效投注
	 * @date 2017-05-11
	 * @author Arron
	 */
	@RequestMapping("handTotalByDateAndGameTypeAndState")
	@ResponseBody
	public String handTotalByDateAndGameType(@RequestParam String strDate, @RequestParam String strGameType,@RequestParam String strState) {
		if (StringUtils.isEmpty(strDate) || StringUtils.isEmpty(strGameType)|| StringUtils.isEmpty(strState)) {
			return "strDate||strGameType为空||strState为空！";
		}
		Integer gameType = null;
		Short state=null;
		try {
			new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
			gameType = Integer.parseInt(strGameType);
			state=Short.parseShort(strState);
		} catch (Exception e) {
			return "日期格式化错误-yyyy-MM-dd-" + strDate + "或strGameType错误" + strGameType + "";
		}
		String msg = handTotalService.startHandTotal(strDate, gameType,state);
		logger.info("手动统计任务结束:" + msg);
		return msg;
	}
	/**
	 * 手动统计捕鱼
	 */
	
	@RequestMapping("/total_hunter")
	public @ResponseBody String total_hunter(@RequestParam String strDate) {
		if (StringUtils.isEmpty(strDate) ) {
			return "strDate为空！";
		}
		Date date=null;
		int sumCount=0;
		try {
			logger.info("开始手动统计日期：{}",strDate);
			date=new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
			List<TotalReportConfigWithBLOBs> configList = baseService.getConfigListByState(60);
			for (TotalReportConfigWithBLOBs config : configList) {
				String insertTempSql = config.getInsertTempSql();
				String betListSql = config.getSelectBetTableSql();
				int count=dsAgHunterServiceImp.getBet(betListSql, insertTempSql, config.getMemo(), date);
				logger.info("统计条数："+count);
				sumCount+=count;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("手动统计任务结束:"+sumCount);
		return String.valueOf(sumCount);
	}
	
	/**
	 * 手动统计网站每天的数据
	 */
	@RequestMapping("/siteDayReport")
	public @ResponseBody String siteDayReport(String strDate) {
		if (StringUtils.isEmpty(strDate) ) {
			return "strDate is null！";
		}
		try {
			Date date=new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
			siteDayReportService.exeTotalReportByDay(date);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("手动统计异常：",e);
		}
		
		return "total end ";
	}
}