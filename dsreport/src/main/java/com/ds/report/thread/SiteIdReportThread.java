package com.ds.report.thread;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ds.report.entity.DSSiteIdInfo;
import com.ds.report.vo.SiteOrderVo;

public class SiteIdReportThread implements Runnable{
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private List<SiteOrderVo> reportList;
	private CountDownLatch latch;
	private List<DSSiteIdInfo> siteIdOrderList;

	public SiteIdReportThread(List<SiteOrderVo> reportList,
			CountDownLatch latch, List<DSSiteIdInfo> siteIdList) {
		super();
		this.reportList = reportList;
		this.latch = latch;
		this.siteIdOrderList = siteIdList;
	}
	@Override
	public void run() {
		try{
			orderBySiteId(reportList);
		}finally{
			latch.countDown();
		}
	}
	private void orderBySiteId(List<SiteOrderVo> dsReport) {
		Map<Integer, SiteOrderVo> dbReportMap = new HashMap<Integer, SiteOrderVo>();//siteId----->SiteOrderVo
		final Map<Long, DSSiteIdInfo> siteIdMap = new HashMap<Long, DSSiteIdInfo>();//siteId----->siteIdInfo(obj)
		//siteIdMap赋值
		for (DSSiteIdInfo siteIdInfo : siteIdOrderList) {
			siteIdMap.put(siteIdInfo.getSiteId(), siteIdInfo);
		}
		//先去掉占位置的元素
		for (Iterator it = dsReport.iterator(); it.hasNext();) {
			SiteOrderVo vo = (SiteOrderVo)it.next();
			if (vo.getSiteId() == null){
			 it.remove();
			}
		}
		//dbReportMap赋值
		for (SiteOrderVo d : dsReport) {
			dbReportMap.put(d.getSiteId(), d);
		}
		
		
		//插入没有投注的网站
		for (DSSiteIdInfo siteIdInfo : siteIdOrderList) {
			if (dbReportMap.containsKey(siteIdInfo.getSiteId().intValue())) {//把没有下注的网站加上去
				continue;
			} else {
				dsReport.add(setSiteOrderVo(siteIdInfo.getSiteId(), siteIdInfo.getSiteName()));
			}

		}
		Collections.sort(dsReport, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				SiteOrderVo d1 = (SiteOrderVo) o1;
				SiteOrderVo d2 = (SiteOrderVo) o2;
				return d1.getSiteId() - d2.getSiteId();
			}
		});
	}
	private SiteOrderVo setSiteOrderVo(Long siteId,String siteName){
		SiteOrderVo vo = new SiteOrderVo();
		vo.setBetamount(new BigDecimal(0));
		vo.setBetCount(0);
		vo.setSiteId(siteId.intValue());
		vo.setValidamount(new BigDecimal(0));
		vo.setWinlose(new BigDecimal(0));
		return vo;
	}

}
