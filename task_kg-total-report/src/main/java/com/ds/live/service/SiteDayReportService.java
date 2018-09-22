package com.ds.live.service;

import java.util.Date;
import java.util.List;

import org.onetwo.common.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.live.dao.ReportDao;
import com.kg.live.entity.DsReportSiteDay;

@Service
public class SiteDayReportService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private ReportDao reportDao;


	public void exeTotalReportByDay(Date date) throws Exception {
		String strDate = DateUtil.formatDateByPattern(date, "yyyy-MM-dd");
		
		List<DsReportSiteDay> reportList = reportDao.getSiteReportByDay(strDate);
		logger.info("统计日期{},条数{}",strDate,reportList.size());
		if(reportList.size()>0){
			reportDao.insertOrUpdateReportSiteDay(reportList);
		}
		
	}
	
	public void validReportByMonthDay(Date date) throws Exception {
		String strDate = DateUtil.formatDateByPattern(date, "yyyy-MM-dd");
		
		List<DsReportSiteDay> reportList = reportDao.getValidReportByDays(strDate);
		logger.info("验证日期{},条数{}",strDate,reportList.size());
		if(reportList.size()>0){
			reportDao.insertOrUpdateReportSiteDay(reportList);
		}
		
	}

}