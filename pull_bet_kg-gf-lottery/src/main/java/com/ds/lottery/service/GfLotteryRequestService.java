package com.ds.lottery.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ds.lottery.common.BaseCommon;
import com.ds.lottery.dao.DsLotteryDao;
import com.ds.lottery.entity.GFLotteryEntity;
import com.ds.lottery.entity.GFLotteryEntityExample;
import com.ds.lottery.entity.GFLotteryInfoEntity;
import com.ds.lottery.mapper.GFLotteryEntityMapper;
import com.ds.lottery.until.DSLotteryConfig;
import com.ds.lottery.until.DateUtil;
import com.ds.lottery.until.HttpUtil;
import com.ds.lottery.until.ThreadUtil;
import com.ds.lottery.vo.GameTypeVo;
import com.ds.temp.entity.AuditTotalVO;
import com.ds.temp.mapper.TempAuditTotalMapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.kg.live.contants.AuditGameNameEnum;
import com.kg.live.contants.PlatFormEnum;
import com.kg.live.contants.PlatformTypeEnum;
import com.kg.live.entity.DsReportEntity;

/**
 *
 * @author worf
 * @date 2018年4月24日 下午4:38:47
 */
public class GfLotteryRequestService implements Runnable {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private DsLotteryServiceImp lotteryService;
	private GFLotteryInfoEntity lottery;
	private DsLotteryDao lotteryDao;
	private GFLotteryEntityMapper guanfangMapper;
	private TempAuditTotalMapper tempAuditTotalMapper;
	private CountDownLatch cdl;

	private Map<String, GameTypeVo> gameTypeVoMap;
	private Map<String, DsReportEntity> reportUpdateMap = new HashMap<String, DsReportEntity>();

	private List<AuditTotalVO> auditList = new ArrayList<AuditTotalVO>();
	// 用来缓存记录拉取ID
//	private Map<String, Long> maxIdMap = new HashMap<String, Long>();
	// report的缓存列表
	private Cache<String, String> cacheReport = CacheBuilder.newBuilder().expireAfterWrite(3, TimeUnit.DAYS).build();

	// 存放待插入到数据库的Guanfang列表
	private List<GFLotteryEntity> guanfangList = new ArrayList<GFLotteryEntity>();
	// 存放待插入到数据库的report列表
	private List<DsReportEntity> reportInsertList = new ArrayList<DsReportEntity>();

	// 记录上次拉取到的id
//	private Long lastMaxId = 0l;

	// 上次简要
	private Date lastValidateDate;
	// 报表校验时间间隔
	private final static Long TOTALREPORT_VALIDONCETIME = 1000L * 60 * 30;

	boolean flag = true;

	public GfLotteryRequestService(DsLotteryServiceImp lotteryService, GFLotteryInfoEntity lottery,
			Map<String, GameTypeVo> gameTypeVoMap, CountDownLatch cdl) {
		super();
		this.lotteryService = lotteryService;
		this.lottery = lottery;
		this.cdl = cdl;
		this.lotteryDao = lotteryService.getLotteryDao();
		this.guanfangMapper = lotteryService.getGuanfangMapper();
		this.tempAuditTotalMapper = lotteryService.getTempAuditTotalMapper();
		this.gameTypeVoMap = gameTypeVoMap;
	}

	@Override
	public void run() {
		try {
			int siteId = lottery.getSiteid();
			String user = lottery.getUser();
			int level = lottery.getLevel();
			String reportUrl = lottery.getRecordUrl();
			logger.info("准备拉取,参数siteId={},record url={},level={},user={}", siteId, reportUrl, level, user);
//			while (flag) {
				getLotteryBet(siteId, user, level, reportUrl);
//			}
		} catch (Exception e) {
			logger.error("run error", e);
		} finally {
			logger.info("{}拉取完成", lottery.getSiteid());
			cdl.countDown();
		}
	}

	public void getLotteryBet(int siteId, String user, int level, String reportUrl) {
		try {
//			Long startId = 0L;
//			Long maxId = maxIdMap.get("maxId");
//			if (maxId != null) {
//				logger.info("siteId={} 从缓存中获取最大Id={}", siteId, maxId);
//				startId = maxId;
//			} else if (lastMaxId != 0l) {
//				startId = lastMaxId;
//			} else {
//				startId = lotteryDao.getMaxDsLotteryId(siteId) == null ? startId : lotteryDao.getMaxDsLotteryId(siteId);
//			}
			Long startId = lotteryDao.getMaxDsLotteryId(siteId) == null ? 0L : lotteryDao.getMaxDsLotteryId(siteId);

			JSONObject param = new JSONObject();
			param.put("len", DSLotteryConfig.LEN);
			param.put("user", user);
			param.put("startId", startId + 1);
			param.put("level", level);

			JSONObject object = JSON.parseObject(HttpUtil.sendPost1(reportUrl, param.toString()));
			logger.info(param.toString());
			if (object.getString("Message").equals("success") && object.getJSONArray("Result").size() != 0) {// 获取成功
				JSONArray array = object.getJSONArray("Result");
				int arraySize = array.size();
				logger.info("网站={},拉取到注单 ,数量={}", siteId, arraySize);
				long starFor = System.currentTimeMillis();
				for (int i = 0; i < array.size(); i++) {
					GFLotteryEntity guanfangEntity = array.getObject(i, GFLotteryEntity.class);
					guanfangEntity = extAttr(guanfangEntity, siteId);
					GFLotteryEntity dbguanfangEntity = getDsGuanfangByNid(guanfangEntity);
					// 根据注单，当前日期，用户 查询ds_report是否存在
					DsReportEntity totalReport = getReportEntity(guanfangEntity);
					// 如果数据库不存在,则直接插入ds_Guanfang_lottery,插入或更新ds_report
					if (dbguanfangEntity == null) {
						guanfangList.add(guanfangEntity);
						if (totalReport == null) {
							insertDsReport(guanfangEntity);
						} else {
							updateDsReport(totalReport, guanfangEntity);
						}
					} else {
						// 如果原来ds_Guanfang_lottery存在记录则需要对比下上一次的记录和此次的记录是否发生改变
						// 如果有改变，则需要更新ds_report表，如果没有变化则不需要
						validateGuanfang(guanfangEntity, dbguanfangEntity, totalReport);
						// 更新ds_Guanfang_lottery到数据库
						guanfangEntity.setTid(dbguanfangEntity.getTid());
						guanfangList.add(guanfangEntity);
					}
					// 插入稽核
					insertOrUpdateAudit(guanfangEntity);
//					if (maxIdMap.get("maxId") == null) {
//						maxIdMap.put("maxId", 0l);
//					}
//					if (guanfangEntity.getId() > maxIdMap.get("maxId")) {
//						maxIdMap.put("maxId", guanfangEntity.getId());
//					}
				} // end for list
				long endFor = System.currentTimeMillis();
				logger.info("siteId:{},arraySize:{},for循环耗时:{}", siteId, arraySize, endFor - starFor);
				// 开始插入到数据库
				long startCurdTime = System.currentTimeMillis();
				insertOrUpdateReport(siteId);
				long endCurdTime = System.currentTimeMillis();
				logger.info("siteId:{},arraySize:{},Curd耗时:{}", siteId, arraySize, endCurdTime - startCurdTime);

//				lastMaxId = maxIdMap.get("maxId");
			} else if (object.getString("Message").equals("success") && object.getJSONArray("Result").size() == 0) { // 没有拉取到注单
				logger.info("网站={} 拉取成功,但注单数量为0", siteId);
//				flag = false;
				return;
			} else if (!object.getString("Message").equals("success")) {
				logger.info("网站={} 拉取数据失败,请检查配置,错误消息={}", siteId, object.getString("Message"));
				ThreadUtil.sleep(1000L);
				return;
			}
			// 进行校验比对report
			validateTotalReport(siteId);
		} catch (Exception e) {
			logger.error("拉取数据发生异常", e);
			cacheReport.cleanUp();
//			maxIdMap.clear();
//			lastMaxId = 0L;
			return;
		} finally {
			guanfangList.clear();
			reportInsertList.clear();
			reportUpdateMap.clear();
		}
		logger.info("网站={},拉取数据成功", siteId);
	}

	private GFLotteryEntity extAttr(GFLotteryEntity guanfangEntity, Integer siteId) {
		guanfangEntity.setReportTime(DateUtil.covertTime(guanfangEntity.getDrawTime()));
		guanfangEntity.setBetTime(DateUtil.covertTime(guanfangEntity.getAddTime()));
		guanfangEntity.setSiteid(siteId);
		guanfangEntity.setUserName(guanfangEntity.getUserName().split("_")[1].toString());
		/**
		 * 撤单状态(0未撤单 1用户撤单 2追中撤单 3出号撤单 4未开撤单 5结算前检查撤销 9管理员撤单)
		 */
		if (guanfangEntity.getIsCancel() != 0) { // 取消 前端定义
			guanfangEntity.setWinLoseType(Byte.valueOf("4")); // 取消 数据库定义
			return guanfangEntity;
		}
		/**
		 * 判断订单已结算 isTake==1 isPay==1 isCancel==0
		 */
		if (guanfangEntity.getIsCancel() == 0 && guanfangEntity.getIsPay() == 1 && guanfangEntity.getIsCancel() == 0) {
			BigDecimal wins = guanfangEntity.getWins().subtract(guanfangEntity.getAmount());
			if (wins.doubleValue() > 0) {
				guanfangEntity.setWinLoseType(Byte.valueOf("2")); // 赢 数据库定义
			} else if (wins.doubleValue() < 0) {
				guanfangEntity.setWinLoseType(Byte.valueOf("1")); // 输 数据库定义
			} else {
				guanfangEntity.setWinLoseType(Byte.valueOf("3")); // 和 数据库定义
			}
			guanfangEntity.setWins(wins);
		}
		return guanfangEntity;
	}

	/**
	 * 去数据库读取是否已存在
	 * 
	 * @param guanfangEntity
	 * @return
	 */
	private GFLotteryEntity getDsGuanfangByNid(GFLotteryEntity guanfangEntity) {
		GFLotteryEntityExample e = new GFLotteryEntityExample();
		e.createCriteria().andNidEqualTo(guanfangEntity.getNid());
		List<GFLotteryEntity> list = guanfangMapper.selectByExample(e);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 先去缓存查询，如果缓存不存在才去数据库查询
	 * 
	 * @param guanfangEntity
	 * @return
	 * @throws Exception
	 */
	public DsReportEntity getReportEntity(GFLotteryEntity guanfangEntity) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String betDate = sdf.format(guanfangEntity.getReportTime());
		GameTypeVo gameTypeVo = gameTypeVoMap.get(guanfangEntity.getLid().toString());
		String reportStr = cacheReport.getIfPresent(guanfangEntity.getSiteid() + "+" + guanfangEntity.getUserName()
				+ "+" + gameTypeVo.getGameType() + "+" + betDate);
		if (reportStr != null) {
			DsReportEntity dsReportEntity = JSONObject.parseObject(reportStr, DsReportEntity.class);
			dsReportEntity.setBetTime(sdf.parse(sdf.format(dsReportEntity.getBetTime())));
			return dsReportEntity;
		}
		// 如果缓存是空的话，去数据库查下
		List<DsReportEntity> list = lotteryDao.selectReport(guanfangEntity.getSiteid(), guanfangEntity.getUserName(),
				gameTypeVo.getGameType(), sdf.parse(betDate));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 插入报表
	 * 
	 * @param guanfangEntity
	 */
	private void insertDsReport(GFLotteryEntity guanfangEntity) {
		// 取消的注单,不再插入报表
		if (guanfangEntity.getWinLoseType().intValue() == 4) {
			return;
		}
		if (guanfangEntity.getWinLoseType() == null) {
			return;
		}
		DsReportEntity reportEntity = new DsReportEntity();
		reportEntity.setGameKind(56);
		reportEntity.setGameKindName(BaseCommon.KIND_NAME_GF);
		reportEntity.setBetamount(guanfangEntity.getAmount());
		reportEntity.setBetCount(1);
		GameTypeVo gameType = gameTypeVoMap.get(guanfangEntity.getLid().toString());
		reportEntity.setBetTime(guanfangEntity.getReportTime());
		reportEntity.setGameType(gameType != null ? gameType.getGameType() : guanfangEntity.getLid());
		reportEntity.setGameName(gameType != null ? gameType.getGameName() : guanfangEntity.getLid().toString());
		reportEntity.setLiveId((byte) 12);
		reportEntity.setLiveName(BaseCommon.KIND_NAME_DSPT);
		reportEntity.setSiteId(guanfangEntity.getSiteid());
		reportEntity.setUsername(guanfangEntity.getUserName());
		reportEntity.setValidamount(guanfangEntity.getAmount());
		reportEntity.setWinlose(guanfangEntity.getWins());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String betDate = sdf.format(guanfangEntity.getReportTime());
		cacheReport.put(guanfangEntity.getSiteid() + "+" + guanfangEntity.getUserName() + "+" + gameType.getGameType()
				+ "+" + betDate, JSONObject.toJSONString(reportEntity));

		reportInsertList.add(reportEntity);
	}

	/**
	 * 更新报表
	 * 
	 * @param guanfangEntity
	 * @return
	 */
	private void updateDsReport(DsReportEntity reportEntity, GFLotteryEntity guanfangEntity) {
		// 取消的注单,不再插入报表
		if (guanfangEntity.getWinLoseType().intValue() == 4) {
			return;
		}
		if (guanfangEntity.getWinLoseType() == null) {
			return;
		}
		reportEntity.setBetamount(reportEntity.getBetamount().add(guanfangEntity.getAmount()));
		reportEntity.setBetCount(reportEntity.getBetCount() + 1);
		reportEntity.setValidamount(reportEntity.getValidamount().add(guanfangEntity.getAmount()));
		reportEntity.setWinlose(reportEntity.getWinlose().add(guanfangEntity.getWins()));
		GameTypeVo gameType = gameTypeVoMap.get(guanfangEntity.getLid().toString());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String betDate = sdf.format(guanfangEntity.getReportTime());
		cacheReport.put(guanfangEntity.getSiteid() + "+" + guanfangEntity.getUserName() + "+" + gameType.getGameType()
				+ "+" + betDate, JSONObject.toJSONString(reportEntity));
		reportUpdateMap.put(
				reportEntity.getSiteId() + reportEntity.getUsername() + reportEntity.getGameType() + betDate,
				reportEntity);
	}

	/**
	 * 1.如果原来的注单winloseType = 4,新的注单winloseType ！=
	 * 4，则ds_report的投注金额，投注数据，有效投注金额都需要加上 2.如果原来的注单winloseType ！=
	 * 4,新的注单winloseType = 4，则ds_report的投注金额，投注数据，有效投注金额都需要减掉
	 * 3.如果两次都不为4则需要对比两次的有效投注，有效投注金额，和派彩金额是否发生改变，如果改变，则把变化量更新到ds_report
	 * 
	 * @param guanfangEntity
	 * @param dbguanfangEntity
	 * @param totalReport
	 */
	private void validateGuanfang(GFLotteryEntity guanfangEntity, GFLotteryEntity dbguanfangEntity,
			DsReportEntity totalReport) {
		Integer addBetCount = 0;// 新增投注量
		BigDecimal addBetamount = new BigDecimal(0);// 新增投注金额
		BigDecimal addValidamount = new BigDecimal(0);// 新增有效投注金额
		BigDecimal addWinlose = new BigDecimal(0);// 新增输赢金额
		if (dbguanfangEntity.getWinLoseType().intValue() == 4 && guanfangEntity.getWinLoseType() == 4) {
			return;
		}
		if (dbguanfangEntity.getWinLoseType().intValue() == 4 && guanfangEntity.getWinLoseType() != 4) {
			addBetCount = 1;
			addBetamount = guanfangEntity.getAmount();
			addValidamount = guanfangEntity.getAmount();
			addWinlose = guanfangEntity.getWins();
		}
		if (dbguanfangEntity.getWinLoseType().intValue() != 4 && guanfangEntity.getWinLoseType() == 4) {
			addBetCount = -1;
			addBetamount = dbguanfangEntity.getAmount().negate();
			addValidamount = dbguanfangEntity.getAmount().negate();
			addWinlose = dbguanfangEntity.getWins().negate();
		}
		if (dbguanfangEntity.getWinLoseType().intValue() != 4 && guanfangEntity.getWinLoseType() != 4) {
			addBetCount = 0;
			addBetamount = guanfangEntity.getAmount().subtract(dbguanfangEntity.getAmount());
			addValidamount = guanfangEntity.getAmount().subtract(dbguanfangEntity.getAmount());
			addWinlose = guanfangEntity.getWins().subtract(dbguanfangEntity.getWins());
		}
		// 没有变化则无需更新
		if (addBetCount == 0 && (addBetamount.compareTo(new BigDecimal(0)) == 0)
				&& (addValidamount.compareTo(new BigDecimal(0)) == 0)
				&& (addWinlose.compareTo(new BigDecimal(0)) == 0)) {
			return;
		}
		totalReport.setBetCount(totalReport.getBetCount() + addBetCount);
		totalReport.setBetamount(totalReport.getBetamount().add(addBetamount));
		totalReport.setValidamount(totalReport.getValidamount().add(addValidamount));
		totalReport.setWinlose(totalReport.getWinlose().add(addWinlose));

		GameTypeVo gameType = gameTypeVoMap.get(guanfangEntity.getLid().toString());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String betDate = sdf.format(guanfangEntity.getReportTime());
		reportUpdateMap.put(totalReport.getSiteId() + totalReport.getUsername() + totalReport.getGameType() + betDate,
				totalReport);
		cacheReport.put(guanfangEntity.getSiteid() + "+" + guanfangEntity.getUserName() + "+" + gameType.getGameType()
				+ "+" + betDate, JSONObject.toJSONString(totalReport));

	}

	private void insertOrUpdateAudit(GFLotteryEntity guanfangEntity) {
		AuditTotalVO audit = new AuditTotalVO();
		audit.setBetTime(guanfangEntity.getBetTime());
		audit.setUsername(guanfangEntity.getUserName());
		audit.setLiveId(PlatFormEnum.DS.getValue());
		audit.setGameName(AuditGameNameEnum.KG_GUANFANG.toString());
		audit.setType(PlatformTypeEnum.LOTTO.getValue());
		audit.setOrderNo(guanfangEntity.getNid());
		audit.setPayAmount(guanfangEntity.getWins());
		audit.setBetAmount(guanfangEntity.getWins());
		audit.setValidAmount(guanfangEntity.getAmount());
		auditList.add(audit);
	}

	/**
	 * 
	 * 1.list插入或更新到数据库
	 * 
	 * @param siteId
	 */
	private void insertOrUpdateReport(int siteId) {
		if (reportInsertList.size() > 0) {
			long startTime = System.currentTimeMillis();
			lotteryDao.addReport(reportInsertList);
			long endTime = System.currentTimeMillis();
			logger.info("siteId:{},insertReport.size():{},耗时:{}", siteId, reportInsertList.size(), endTime - startTime);
		}
		if (reportUpdateMap.size() > 0) {
			long startTime = System.currentTimeMillis();
			for (DsReportEntity reportEntity : reportUpdateMap.values()) {
				lotteryDao.updateReport(reportEntity);
			}
			long endTime = System.currentTimeMillis();
			logger.info("siteId:{},updateReport.size():{},耗时:{}", siteId, reportUpdateMap.size(), endTime - startTime);
		}
		if (guanfangList.size() > 0) {
			long startTime = System.currentTimeMillis();
			// List<GFLotteryEntity> ps= new ArrayList<GFLotteryEntity>();
			// ps=guanfangList.subList(0, 13);
			// logger.info(guanfangList.get(0).toString());
			// ps.add(guanfangList.get(0));
			lotteryDao.addGF(guanfangList);
			long endTime = System.currentTimeMillis();
			logger.info("siteId:{},GuanfangList.size():{},耗时:{}", siteId, guanfangList.size(), endTime - startTime);
		}

		if (auditList.size() > 0) {
			long startTime = System.currentTimeMillis();
			tempAuditTotalMapper.batInsertOrupdate(auditList, siteId);
			long endTime = System.currentTimeMillis();
			logger.info("siteId:{},insertAudit.size():{},耗时:{}", siteId, auditList.size(), endTime - startTime);
		}

	}

	/**
	 * 校验总报表是否一致 1.
	 * 
	 * @param siteId
	 */
	private void validateTotalReport(int siteId) {
		// 第一次，lastValidateDate 为null 校验
		if (lastValidateDate == null) {
			lastValidateDate = new Date();
			return;
		}
		// 小于时间间隔，不校验
		if ((System.currentTimeMillis() - lastValidateDate.getTime()) < TOTALREPORT_VALIDONCETIME) {
			return;
		}
		logger.info("开始校验report siteId:" + siteId);
		// 校验最近两天
		for (int i = 0; i < 2; i++) {
			lotteryService.validateTotalReport(siteId, org.onetwo.common.utils.DateUtil.addDay(new Date(), -i));
		}
		// 更新校验时间
		lastValidateDate = new Date();
	}

}
