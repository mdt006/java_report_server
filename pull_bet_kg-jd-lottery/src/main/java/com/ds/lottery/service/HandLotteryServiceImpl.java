package com.ds.lottery.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ds.lottery.dao.DsLotteryDao;
import com.ds.lottery.until.DSLotteryConfig;
import com.ds.lottery.until.DateUtil;
import com.ds.lottery.until.HttpUtil;
import com.ds.temp.entity.TempAuditTotal;
import com.ds.temp.mapper.TempAuditTotalMapper;
import com.kg.live.entity.DsJingdianEntity;
import com.kg.live.entity.DsJingdianEntityExample;
import com.kg.live.entity.LotteryInfoEntity;
import com.kg.live.entity.LotteryInfoEntityExample;
import com.kg.live.mapper.DsJingdianEntityMapper;
import com.kg.live.mapper.LotteryInfoEntityMapper;

/*手动拉取service*/

@Service
public class HandLotteryServiceImpl {
	private Logger logger = LoggerFactory.getLogger(HandLotteryServiceImpl.class);

	@Autowired
	private DsJingdianEntityMapper jingdianMapper;
	@Autowired
	private TempAuditTotalMapper tempAuditTotalMapper;

	@Autowired
	private LotteryInfoEntityMapper lotteryMapper;

	@Resource
	private DsLotteryDao dsLotteryDao;

	public boolean handFetch(Integer beginId, Integer count, String user, Integer siteId, String level,
			String record_url) {
		try {
			if (count > 5000) {
				logger.info("一次拉取数量太多");
				return false;
			}
			JSONObject param = new JSONObject();
			param.put("len", count);
			param.put("user", user);
			param.put("startId", beginId);
			param.put("level", level);
			JSONObject object = JSON.parseObject(HttpUtil.sendPost1(record_url, param.toString()));
			if (object.getString("Message").equals("success") && object.getJSONArray("Result").size() != 0) {// 获取成功
				JSONArray array = object.getJSONArray("Result");
				int arraySize = array.size();
				logger.info("拉取到注单 ,数量={}", arraySize);
				for (int i = 0; i < arraySize; i++) {
					DsJingdianEntity jingdianEntity = array.getObject(i, DsJingdianEntity.class);
					jingdianEntity = extAttr(jingdianEntity, siteId);
					boolean exist = getDsJingdianByNid(jingdianEntity);
					if (exist) {
						jingdianMapper.updateByPrimaryKey(jingdianEntity);
					} else {
						jingdianMapper.insert(jingdianEntity);
					}
					// 插入日志
					if (exist) {
						updateAudit(jingdianEntity);
					} else {
						insertAudit(jingdianEntity);
					}

				}
				return true;
			}
		} catch (Exception e) {
			logger.info("handFetch error", e);
		}
		return false;

	}

	private DsJingdianEntity extAttr(DsJingdianEntity jingdianEntity, Integer siteId) {
		Date bet_time = DateUtil.covertTime(jingdianEntity.getTimeAdd());
		jingdianEntity.setBetTime(bet_time);
		jingdianEntity.setReportTime(DateUtil.covertTime(jingdianEntity.getTimeDraw()));
		jingdianEntity.setSiteid(siteId);
		jingdianEntity.setUser(jingdianEntity.getUser().split("_")[1].toString());
		if (jingdianEntity.getIsCancel()) { // 取消 前端定义
			jingdianEntity.setWinLoseType(Byte.valueOf("4")); // 取消 数据库定义
			return jingdianEntity;
		}
		switch (jingdianEntity.getStataus()) {
		case 1: // 和 前端定义
			jingdianEntity.setWinLoseType(Byte.valueOf("3")); // 和 数据库定义
			break;
		case 2: // 赢 前端定义
			jingdianEntity.setWinLoseType(Byte.valueOf("2")); // 赢 数据库定义
			break;
		case 3: // 输 前端定义
			jingdianEntity.setWinLoseType(Byte.valueOf("1")); // 输 数据库定义
			break;
		}
		return jingdianEntity;
	}

	private boolean getDsJingdianByNid(DsJingdianEntity jingdianEntity) {
		DsJingdianEntityExample e = new DsJingdianEntityExample();
		e.createCriteria().andNidEqualTo(jingdianEntity.getNid()).andSiteidEqualTo(jingdianEntity.getSiteid());
		List<DsJingdianEntity> list = jingdianMapper.selectByExample(e);
		if (list != null && list.size() > 0) {
			jingdianEntity.setTid(list.get(0).getTid());
			return true;
		}
		return false;
	}

	private void insertAudit(DsJingdianEntity jingdianEntity) {
		logger.info("insert TempAuditTotal,siteId={},nid={}", jingdianEntity.getSiteid(), jingdianEntity.getNid());
		TempAuditTotal audit = new TempAuditTotal();
		audit.setBetTime(jingdianEntity.getBetTime());
		audit.setSiteId(jingdianEntity.getSiteid());
		audit.setUsername(jingdianEntity.getUser());
		audit.setOrderNo(jingdianEntity.getNid());
		audit.setPayAmount(jingdianEntity.getWin());
		audit.setBetAmount(BigDecimal.valueOf(jingdianEntity.getJiner()));
		audit.setValidAmount(jingdianEntity.getJinerb());
		audit.setCreateTime(new Date());
		audit.setType(3);
		tempAuditTotalMapper.insert(audit);

	}

	private void updateAudit(DsJingdianEntity jingdianEntity) {
		logger.info("update TempAuditTotal,siteId={},nid={}", jingdianEntity.getSiteid(), jingdianEntity.getNid());
		TempAuditTotal audit = new TempAuditTotal();
		audit.setBetTime(jingdianEntity.getBetTime());
		audit.setSiteId(jingdianEntity.getSiteid());
		audit.setUsername(jingdianEntity.getUser());
		// audit.setLiveId();
		audit.setOrderNo(jingdianEntity.getNid());
		audit.setPayAmount(jingdianEntity.getWin()); // 会员输赢
		audit.setBetAmount(BigDecimal.valueOf(jingdianEntity.getJiner())); // 投注金额
		audit.setValidAmount(jingdianEntity.getJinerb()); // 有效投注金额
		audit.setUpdateTime(new Date());
		tempAuditTotalMapper.updateByOrderNo(audit);
	}

	/**
	 * @author Arron
	 * @Time 2017-04-03
	 * @describe 防止经典彩注单漏拉,每天凌晨四点定时去拉取(由于服务器是美东时间,所以开始时间是服务器当天,结束时间就是后一天)
	 * 
	 */
	@Scheduled(cron = "0 0 16 1/1 * ?")
	public void handLotteryServiceTask() {
		try {
			Date nowDate = new Date();
			String dBegin = new SimpleDateFormat("yyyy-MM-dd").format(nowDate);
			String dEnd = new SimpleDateFormat("yyyy-MM-dd 23:59:59").format(nowDate);
			List<LotteryInfoEntity> infoList = getApiInfoList();
			logger.info("每日定时拉取任务开始：dBegin" + dBegin + "----------dEnd" + dEnd);
			Long beginId = 0L;
			Long endId = 0L;
			for (int i = 0; i < infoList.size(); i++) {
				LotteryInfoEntity infoEntity = infoList.get(i);
				beginId = dsLotteryDao.getMinDsLotteryIdBySiteIdAndDate(dBegin, infoEntity.getSiteid());
				if (beginId == null) {
					continue;
				}
				endId = dsLotteryDao.getMaxDsLotteryIdBySiteIdAndDate(dEnd, infoEntity.getSiteid());
				logger.info("每日定时拉取任务beginId:" + beginId + "----------endId:" + endId);
				while (true) {
					//while (true) {
						boolean pullResult = handFetch(Integer.valueOf(beginId.toString()), DSLotteryConfig.LEN, infoEntity.getUser(),
								infoEntity.getSiteid(), String.valueOf(infoEntity.getLevel()),
								infoEntity.getRecordUrl());
						logger.info("HandLotteryServiceImpl---->handLotteryServiceTask--pullResult:"+pullResult);
						/*if (pullResult) {
							break;
						}

					}*/
					Long tempMaxId = dsLotteryDao.getTempMaxIdByIdAndSiteId(infoEntity.getSiteid(), beginId);
					if (tempMaxId == null || tempMaxId.compareTo(endId) > 0) {
						break;
					}
					beginId = tempMaxId;
				}
			}
		} catch (Exception e) {
			logger.error("每日定时出错！", e);
		}
	}

	private List<LotteryInfoEntity> getApiInfoList() {
		LotteryInfoEntityExample e = new LotteryInfoEntityExample();
		e.createCriteria().andStateEqualTo(DSLotteryConfig.NORMAL_STATE);
		return lotteryMapper.selectByExample(e);
	}

	/**
	 * 
	 * @param date yyyy-MM-dd
	 * @param siteId
	 */
	public void handLotteryByIdAndSite(Date date, String siteId) {
		try {
			String dBegin = new SimpleDateFormat("yyyy-MM-dd").format(date);
			String dEnd = new SimpleDateFormat("yyyy-MM-dd 23:59:59").format(date);
			logger.info("手动拉取任务开始：SiteId----" + siteId + "dBegin-----" + dBegin + "-----dEnd-----" + dEnd);
			Long beginId = 0L;
			Long endId = 0L;
			List<LotteryInfoEntity> infoList = getApiInfoList();
			LotteryInfoEntity infoEntity = null;
			for (int i = 0; i < infoList.size(); i++) {
				if (Integer.valueOf(siteId).equals(infoList.get(i).getSiteid())) {
					infoEntity = infoList.get(i);
					break;
				}
			}
			if (infoEntity == null) {
				logger.info("请给正确的siteId");
				return;
			}
			beginId = dsLotteryDao.getMinDsLotteryIdBySiteIdAndDate(dBegin, Integer.valueOf(siteId));
			endId = dsLotteryDao.getMaxDsLotteryIdBySiteIdAndDate(dEnd, Integer.valueOf(siteId));
			logger.info("手动拉取任务开始：SiteId----" + siteId + "beginId-----" + beginId + "-----endId-----" + endId);
			while (true) {
				// while (true) {
					boolean pullResult = handFetch(Integer.valueOf(beginId.toString()), DSLotteryConfig.LEN, infoEntity.getUser(),
							infoEntity.getSiteid(), String.valueOf(infoEntity.getLevel()), infoEntity.getRecordUrl());
					logger.info("HandLotteryServiceImpl---->handLotteryByIdAndSite--pullResult:"+pullResult);
					/*if (pullResult) {
						break;
					}

				}*/
				Long tempMaxId = dsLotteryDao.getTempMaxIdByIdAndSiteId(infoEntity.getSiteid(), beginId);
				if (tempMaxId == null || tempMaxId.compareTo(endId) > 0) {
					break;
				}
				beginId = tempMaxId;
			}
		} catch (Exception e) {
			logger.error("手动拉取出错！", e);
		}
	}
}