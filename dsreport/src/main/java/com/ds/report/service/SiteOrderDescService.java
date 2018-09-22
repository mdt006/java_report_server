package com.ds.report.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.apache.commons.lang.StringUtils;
import org.onetwo.common.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ds.report.common.BaseCacheMap;
import com.ds.report.dao.mapper.DsReportDao;
import com.ds.report.entity.DSSiteIdInfo;
import com.ds.report.entity.DSSiteIdInfoExample;
import com.ds.report.entity.GameKindOrder;
import com.ds.report.entity.GameKindOrderExample;
import com.ds.report.entity.mapper.DSSiteIdInfoMapper;
import com.ds.report.entity.mapper.GameKindOrderMapper;
import com.ds.report.thread.SiteIdReportThread;
import com.ds.report.vo.SiteOrderVo;

@Service
public class SiteOrderDescService {
	@Autowired
	private DsReportDao reportDao;
	
	@Autowired
	private DSSiteIdInfoMapper dsSiteIdInfoMapper;
	@Autowired
	private GameKindOrderMapper gameKindOrderMapper;
	
	
	public JSONArray siteOrderDesc( JSONObject obj)
			throws Exception {
		List<SiteOrderVo> dsReport = reportDao.siteOrderDesc(obj);
		// 是否分类统计标识
		String isGameKind = obj.getString("isGameKind");
		if (StringUtils.isNotBlank(isGameKind) && isGameKind.equals("1")) {
			// 排序把未没有投注的gameKind添加的列表
			orderByGameKind(dsReport);
		}
		// 根据来源不同进行分组
		Map<String, List<SiteOrderVo>> listGroup = new LinkedHashMap<String, List<SiteOrderVo>>();
		if (!dsReport.isEmpty()) {
			for (int i = 0; i < dsReport.size(); i++) {
				Integer iGameKind = dsReport.get(i).getGameKind();
				String strGameKindName = dsReport.get(i).getGameKindName();
				String strKey = iGameKind.toString() + "|" + strGameKindName;
				if (listGroup.containsKey(strKey)) {
					listGroup.get(strKey).add(dsReport.get(i));
				} else {
					List<SiteOrderVo> lNew = new ArrayList<SiteOrderVo>();
					lNew.add(dsReport.get(i));
					listGroup.put(strKey, lNew);
				}

			}
		}
		CountDownLatch latch = new CountDownLatch(listGroup.size());// 多线程计数器
		List<DSSiteIdInfo> siteIdList = getSiteIdInfoList();// 要统计的所有网站，要把所有网站都统计处理
		for (String key : listGroup.keySet()) {
			List<SiteOrderVo> reportList = listGroup.get(key);
			new Thread(new SiteIdReportThread(reportList, latch, siteIdList)).start();
		}
		latch.await();

		JSONArray array = new JSONArray();
		if (!listGroup.isEmpty()) {
			for (Map.Entry<String, List<SiteOrderVo>> entry : listGroup.entrySet()) {
				String strKey = entry.getKey();
				List<SiteOrderVo> lsReport = entry.getValue();
				JSONObject subObj = new JSONObject();
				subObj.put("gameKind", strKey.substring(0, strKey.indexOf("|")));
				subObj.put("gameKindName", strKey.substring(strKey.indexOf("|") + 1, strKey.length()));
				subObj.put("data", lsReport);
				array.add(subObj);
			}

		}
		String key=MD5.getMD5Str(obj.toString());
		BaseCacheMap.addCacheMap(key, array.toJSONString());
		return array;

	}
	
	
	private void orderByGameKind(List<SiteOrderVo> dsReport) {
		Map<Integer, SiteOrderVo> dbReportMap = new HashMap<Integer, SiteOrderVo>();// gameKind----->Object
		final Map<Integer, GameKindOrder> gameKindMap = new HashMap<Integer, GameKindOrder>();// gameKind----->Object
		List<GameKindOrder> gameKindOrderList = getGameKindOrderList();
		for (GameKindOrder gameKindOrder : gameKindOrderList) {
			gameKindMap.put(gameKindOrder.getGameKind(), gameKindOrder);

		}
		for (SiteOrderVo d : dsReport) {
			dbReportMap.put(d.getGameKind(), d);
		}
		for (GameKindOrder gameKindOrder : gameKindOrderList) {
			if (!dbReportMap.containsKey(gameKindOrder.getGameKind())) {// 把没有下注的类型加上去
				dsReport.add(siteOrderDescReport(gameKindOrder.getGameKind(), gameKindOrder.getGameKindName()));
			}
		}
		Collections.sort(dsReport, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				SiteOrderVo d1 = (SiteOrderVo) o1;
				SiteOrderVo d2 = (SiteOrderVo) o2;
				Integer order1 = gameKindMap.get(d1.getGameKind()).getOrderAsc();
				Integer order2 = gameKindMap.get(d2.getGameKind()).getOrderAsc();
				return order1 - order2;
			}
		});
	}

	private SiteOrderVo siteOrderDescReport(Integer gameKind, String gameKindName) {
		SiteOrderVo report = new SiteOrderVo();
		report.setGameKind(gameKind);
		report.setGameKindName(gameKindName);
		report.setBetCount(0);
		report.setWinlose(new BigDecimal(0));
		report.setValidamount(new BigDecimal(0));
		report.setBetamount(new BigDecimal(0));
		return report;
	}
	
	public List<DSSiteIdInfo> getSiteIdInfoList() {
		DSSiteIdInfoExample e = new DSSiteIdInfoExample();
		e.createCriteria().andStateEqualTo(50);
		return dsSiteIdInfoMapper.selectByExample(e);
	}
	
	public List<GameKindOrder> getGameKindOrderList() {
		GameKindOrderExample e = new GameKindOrderExample();
		e.createCriteria().andStateEqualTo(50);
		return gameKindOrderMapper.selectByExample(e);
	}
}

