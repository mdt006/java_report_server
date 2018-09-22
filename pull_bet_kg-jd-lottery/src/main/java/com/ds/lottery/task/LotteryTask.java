package com.ds.lottery.task;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ds.lottery.common.BaseCommon;
import com.ds.lottery.dao.DsLotteryDao;
import com.ds.lottery.service.DsLotteryServiceImp;
import com.ds.lottery.until.DSLotteryConfig;
import com.ds.lottery.until.DateUtil;
import com.ds.lottery.until.HttpUtil;
import com.ds.lottery.vo.GameTypeVo;
import com.ds.temp.entity.AuditTotalVO;
import com.ds.temp.mapper.TempAuditTotalMapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.kg.live.contants.AuditGameNameEnum;
import com.kg.live.contants.PlatFormEnum;
import com.kg.live.contants.PlatformTypeEnum;
import com.kg.live.entity.DsJingdianEntity;
import com.kg.live.entity.DsJingdianEntityExample;
import com.kg.live.entity.DsReportEntity;
import com.kg.live.entity.LotteryInfoEntity;
import com.kg.live.mapper.DsJingdianEntityMapper;

public class LotteryTask implements Runnable {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private DsLotteryServiceImp lotteryService;
	private LotteryInfoEntity lottery;
	private DsLotteryDao lotteryDao;
	private TempAuditTotalMapper tempAuditTotalMapper;
	// private TempAuditTotalMapper tempAuditTotalMapper;
	private DsJingdianEntityMapper jingdianMapper;
	// 上次简要
	private Date lastValidateDate;
	// 报表校验时间间隔
	private final static Long TOTALREPORT_VALIDONCETIME = 1000L * 60 * 60 * 3;
	// 用来缓存记录拉取ID
	private Map<String, Long> maxIdMap = new HashMap<String, Long>();
	// 经典彩缓存列表
	private Cache<String, String> cacheJD = CacheBuilder.newBuilder().expireAfterWrite(30, TimeUnit.MINUTES).build();
	// report的缓存列表
	private Cache<String, String> cacheReport = CacheBuilder.newBuilder().expireAfterWrite(3, TimeUnit.DAYS).build();
	// 存放待插入到数据库的jingdian列表
	private List<DsJingdianEntity> jingdianList = new ArrayList<DsJingdianEntity>();
	// 存放待插入到数据库的report列表
	private List<DsReportEntity> reportInsertList = new ArrayList<DsReportEntity>();
	// 存放待更新到数据库的report列表
	// private List<DsReportEntity> reportUpdateList = new
	// ArrayList<DsReportEntity>();
	private Map<String, DsReportEntity> reportUpdateMap = new HashMap<String, DsReportEntity>();
//	// 存待插入到数据库的稽核表TempAuditTotal
//	private List<TempAuditTotal> auditListInsert = new ArrayList<TempAuditTotal>();
//	// 存待更新到数据库的稽核表TempAuditTotal
//	private List<TempAuditTotal> auditListUpdate = new ArrayList<TempAuditTotal>();
	private List<AuditTotalVO> auditList = new ArrayList<AuditTotalVO>();
	
	// 记录上次拉取到的id
	private Long lastMaxId = 0l;

	public LotteryTask(DsLotteryServiceImp lotteryService, LotteryInfoEntity lottery) {
		super();
		this.lotteryService = lotteryService;
		this.lottery = lottery;
		this.lotteryDao = lotteryService.getLotteryDao();
		this.jingdianMapper = lotteryService.getJingdianMapper();
	    this.tempAuditTotalMapper=lotteryService.getTempAuditTotalMapper();
	}

	// @Override
	public void run() {
		Thread.currentThread().setName(lottery.getUser());
		int siteId = lottery.getSiteid();
		String user = lottery.getUser();
		int level = lottery.getLevel();
		String reportUrl = lottery.getRecordUrl();
		logger.info("线程={},准备拉取,参数siteId={},record url={},level={},user={}", Thread.currentThread().getName(), siteId,
				reportUrl, level, user);
		// 配置文件改动 先暂停
		while (BaseCommon.LOT_INFO_MAP != null && BaseCommon.LOT_INFO_MAP.containsKey(siteId)) {
			logger.info("siteId={},拉取开始...", siteId);
			getLotteryBet(siteId, user, level, reportUrl);
			logger.info("siteId={},拉取结束...", siteId);
			logger.info("结束之后：{}",BaseCommon.LOT_INFO_MAP);
		}
		// 线程已经停止，线程计数器+1
		DsLotteryServiceImp.stopCount.getAndIncrement();
		logger.info("线程={},已停止", Thread.currentThread().getName());
	}

	public void getLotteryBet(int siteId, String user, int level, String reportUrl) {

		try {
			Long startId = 0L;
			Long maxId = maxIdMap.get("maxId");
			if (maxId != null) {
				logger.info("siteId={} 从缓存中获取最大Id={}", siteId, maxId);
				startId = maxId;
			} else if (lastMaxId != 0l) {
				startId = lastMaxId;
			} else {
				startId = lotteryDao.getMaxDsLotteryId(siteId) == null ? startId : lotteryDao.getMaxDsLotteryId(siteId);
			}
			JSONObject param = new JSONObject();
			param.put("len", DSLotteryConfig.LEN);
			param.put("user", user);
			param.put("startId", startId + 1);
			param.put("level", level);

			JSONObject object = JSON.parseObject(HttpUtil.sendPost1(reportUrl, param.toString()));
			if (object.getString("Message").equals("success") && object.getJSONArray("Result").size() != 0) {// 获取成功
				JSONArray array = object.getJSONArray("Result");
				int arraySize = array.size();
				logger.info("网站={},拉取到注单 ,数量={}", siteId, arraySize);
				long starFor = System.currentTimeMillis();
				for (int i = 0; i < array.size(); i++) {
					DsJingdianEntity jingdianEntity = array.getObject(i, DsJingdianEntity.class);
					jingdianEntity = extAttr(jingdianEntity, siteId);
					DsJingdianEntity dbJingdianEntity = getDsJingdianByNid(jingdianEntity);
					// 根据注单，当前日期，用户 查询ds_report是否存在
					DsReportEntity totalReport = getReportEntity(jingdianEntity);
					// 如果数据库不存在,则直接插入ds_jingdian_lottery,插入或更新ds_report
					// 如果数据
					if (dbJingdianEntity == null) {
						jingdianList.add(jingdianEntity);
						if (totalReport == null) {
							insertDsReport(jingdianEntity);
						} else {
							updateDsReport(totalReport, jingdianEntity);
						}
					} else {
						// 如果原来ds_jingdian_lottery存在记录则需要对比下上一次的记录和此次的记录是否发生改变
						// 如果有改变，则需要更新ds_report表，如果没有变化则不需要
						validateJingdian(jingdianEntity, dbJingdianEntity, totalReport);
						// 更新ds_jingdian_lottery到数据库
						jingdianEntity.setTid(dbJingdianEntity.getTid());
						jingdianList.add(jingdianEntity);
					}
					// 插入稽核
					insertOrUpdateAudit(jingdianEntity);
					
					if (maxIdMap.get("maxId") == null) {
						maxIdMap.put("maxId", 0l);
					}
					if (jingdianEntity.getId() > maxIdMap.get("maxId")) {
						maxIdMap.put("maxId", jingdianEntity.getId());
					}
				} // end for list
				long endFor = System.currentTimeMillis();
				logger.info("siteId:{},arraySize:{},for循环耗时:{}", siteId, arraySize, endFor - starFor);
				// 开始插入到数据库
				long startCurdTime = System.currentTimeMillis();
				insertOrUpdateReport(siteId);
				long endCurdTime = System.currentTimeMillis();
				logger.info("siteId:{},arraySize:{},Curd耗时:{}", siteId, arraySize, endCurdTime - startCurdTime);

				lastMaxId = maxIdMap.get("maxId");
			} else if (object.getString("Message").equals("success") && object.getJSONArray("Result").size() == 0) { // 没有拉取到注单
																														// 稍等5分钟在尝试
				logger.info("网站={} 拉取成功,但注单数量为0,休眠1分钟", siteId);
				Thread.sleep(1000 * 60);
				return;
			} else if (!object.getString("Message").equals("success")) {
				logger.info("网站={} 拉取数据失败,请检查配置,休眠1分钟,错误消息={}", siteId, object.getString("Message"));
				Thread.sleep(1000 * 60);
				return;
			}
			// 进行校验比对report
			validateTotalReport(siteId);
		} catch (Exception e) {
			logger.error("拉取数据发生异常，线程降休眠30s", e);
			try {
				cacheJD.cleanUp();
				cacheReport.cleanUp();
				maxIdMap.clear();
				lastMaxId = 0L;
				Thread.sleep(30000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			return;
		} finally {
			jingdianList.clear();
			reportInsertList.clear();
			reportUpdateMap.clear();
			auditList.clear();
			
		}
		logger.info("网站={},拉取数据成功", siteId);
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
		if (jingdianList.size() > 0) {
			long startTime = System.currentTimeMillis();
			lotteryDao.addJD(jingdianList);
			long endTime = System.currentTimeMillis();
			logger.info("siteId:{},jingdianList.size():{},耗时:{}", siteId, jingdianList.size(), endTime - startTime);
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

	/**
	 * 1.如果原来的注单winloseType = 4,新的注单winloseType ！=
	 * 4，则ds_report的投注金额，投注数据，有效投注金额都需要加上 2.如果原来的注单winloseType ！=
	 * 4,新的注单winloseType = 4，则ds_report的投注金额，投注数据，有效投注金额都需要减掉
	 * 3.如果两次都不为4则需要对比两次的有效投注，有效投注金额，和派彩金额是否发生改变，如果改变，则把变化量更新到ds_report
	 * 
	 * @param jingdianEntity
	 * @param dbJingdianEntity
	 * @param totalReport
	 */
	private void validateJingdian(DsJingdianEntity jingdianEntity, DsJingdianEntity dbJingdianEntity,
			DsReportEntity totalReport) {
		Integer addBetCount = 0;// 新增投注量
		BigDecimal addBetamount = new BigDecimal(0);// 新增投注金额
		BigDecimal addValidamount = new BigDecimal(0);// 新增有效投注金额
		BigDecimal addWinlose = new BigDecimal(0);// 新增输赢金额
		if (dbJingdianEntity.getWinLoseType().intValue() == 4 && jingdianEntity.getWinLoseType() == 4) {
			return;
		}
		if (dbJingdianEntity.getWinLoseType().intValue() == 4 && jingdianEntity.getWinLoseType() != 4) {
			addBetCount = 1;
			addBetamount = new BigDecimal(jingdianEntity.getJiner());
			addValidamount = jingdianEntity.getJinerb();
			addWinlose = jingdianEntity.getWin();
		}
		if (dbJingdianEntity.getWinLoseType().intValue() != 4 && jingdianEntity.getWinLoseType() == 4) {
			addBetCount = -1;
			addBetamount = new BigDecimal(dbJingdianEntity.getJiner()).negate();
			addValidamount = dbJingdianEntity.getJinerb().negate();
			addWinlose = dbJingdianEntity.getWin().negate();
		}
		if (dbJingdianEntity.getWinLoseType().intValue() != 4 && jingdianEntity.getWinLoseType() != 4) {
			addBetCount = 0;
			addBetamount = new BigDecimal(jingdianEntity.getJiner() - dbJingdianEntity.getJiner());
			addValidamount = jingdianEntity.getJinerb().subtract(dbJingdianEntity.getJinerb());
			addWinlose = jingdianEntity.getWin().subtract(dbJingdianEntity.getWin());
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

		GameTypeVo gameType = BaseCommon.OUTCODE_GAME_MAP.get(jingdianEntity.getLid().toString());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String betDate = sdf.format(jingdianEntity.getReportTime());
		reportUpdateMap.put(totalReport.getSiteId() + totalReport.getUsername() + totalReport.getGameType() + betDate,
				totalReport);
		cacheReport.put(jingdianEntity.getSiteid() + "+" + jingdianEntity.getUser() + "+" + gameType.getGameType() + "+"
				+ betDate, JSONObject.toJSONString(totalReport));

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

	/**
	 * 去数据库读取是否已存在,如果数据库不存在，则去缓存中查询
	 * 
	 * @param jingdianEntity
	 * @return
	 */
	private DsJingdianEntity getDsJingdianByNid(DsJingdianEntity jingdianEntity) {
		DsJingdianEntityExample e = new DsJingdianEntityExample();
		e.createCriteria().andNidEqualTo(jingdianEntity.getNid());
		List<DsJingdianEntity> list = jingdianMapper.selectByExample(e);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	private void insertOrUpdateAudit(DsJingdianEntity jingdianEntity) {
		AuditTotalVO audit = new AuditTotalVO();
		audit.setBetTime(jingdianEntity.getBetTime());
		audit.setUsername(jingdianEntity.getUser());
		audit.setLiveId(PlatFormEnum.DS.getValue());
		audit.setGameName(AuditGameNameEnum.KG_JINGDIAN.toString());
		audit.setType(PlatformTypeEnum.LOTTO.getValue());
		audit.setOrderNo(jingdianEntity.getNid());
		audit.setPayAmount(jingdianEntity.getWin());
		audit.setBetAmount(BigDecimal.valueOf(jingdianEntity.getJiner()));
		audit.setValidAmount(jingdianEntity.getJinerb());
		auditList.add(audit);
	}

	/**
	 * 插入报表
	 * 
	 * @param jingdianEntity
	 */
	private void insertDsReport(DsJingdianEntity jingdianEntity) {
		// 取消的注单,不再插入报表
		if (jingdianEntity.getWinLoseType().intValue() == 4) {
			return;
		}
		DsReportEntity reportEntity = new DsReportEntity();
		GameTypeVo gameType = BaseCommon.OUTCODE_GAME_MAP.get(jingdianEntity.getLid().toString());
		
		if ("59".equals(gameType.getGameKind())) { // 经典香港彩
			reportEntity.setGameKind(59);
			reportEntity.setGameKindName(BaseCommon.KIND_NAME_HK);
		} else if ("57".equals(gameType.getGameKind())) { // KG经典PC28
			reportEntity.setGameKind(57);
			reportEntity.setGameKindName(BaseCommon.KIND_NAME_PC28);
		}else { // 经典时时彩
			reportEntity.setGameKind(58);
			reportEntity.setGameKindName(BaseCommon.KIND_NAME_SSC);
		}
		reportEntity.setBetamount(new BigDecimal(jingdianEntity.getJiner()));
		reportEntity.setBetCount(1);
		reportEntity.setBetTime(jingdianEntity.getReportTime());
		reportEntity.setGameType(gameType != null ? gameType.getGameType() : jingdianEntity.getLid());
		reportEntity.setGameName(gameType != null ? gameType.getGameName() : jingdianEntity.getLid().toString());
		reportEntity.setLiveId((byte) 12);
		reportEntity.setLiveName(BaseCommon.KIND_NAME_DSPT);
		reportEntity.setSiteId(jingdianEntity.getSiteid());
		reportEntity.setUsername(jingdianEntity.getUser());
		reportEntity.setValidamount(jingdianEntity.getJinerb());
		reportEntity.setWinlose(jingdianEntity.getWin());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String betDate = sdf.format(jingdianEntity.getReportTime());
		cacheReport.put(jingdianEntity.getSiteid() + "+" + jingdianEntity.getUser() + "+" + gameType.getGameType() + "+"
				+ betDate, JSONObject.toJSONString(reportEntity));

		reportInsertList.add(reportEntity);
	}

	/**
	 * 更新报表
	 * 
	 * @param jingdianEntity
	 * @return
	 */
	private void updateDsReport(DsReportEntity reportEntity, DsJingdianEntity jingdianEntity) {
		// 取消的注单,不再插入报表
		if (jingdianEntity.getWinLoseType().intValue() == 4) {
			return;
		}
		reportEntity.setBetamount(reportEntity.getBetamount().add(new BigDecimal(jingdianEntity.getJiner())));
		reportEntity.setBetCount(reportEntity.getBetCount() + 1);
		reportEntity.setValidamount(reportEntity.getValidamount().add(jingdianEntity.getJinerb()));
		reportEntity.setWinlose(reportEntity.getWinlose().add(jingdianEntity.getWin()));
		GameTypeVo gameType = BaseCommon.OUTCODE_GAME_MAP.get(jingdianEntity.getLid().toString());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String betDate = sdf.format(jingdianEntity.getReportTime());
		cacheReport.put(jingdianEntity.getSiteid() + "+" + jingdianEntity.getUser() + "+" + gameType.getGameType() + "+"
				+ betDate, JSONObject.toJSONString(reportEntity));
		reportUpdateMap.put(
				reportEntity.getSiteId() + reportEntity.getUsername() + reportEntity.getGameType() + betDate,
				reportEntity);
	}

	/**
	 * //先去缓存查询，如果缓存不存在才去数据库查询
	 * 
	 * @param jingdianEntity
	 * @return
	 * @throws Exception
	 */
	public DsReportEntity getReportEntity(DsJingdianEntity jingdianEntity) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String betDate = sdf.format(jingdianEntity.getReportTime());
		GameTypeVo gameTypeVo = BaseCommon.OUTCODE_GAME_MAP.get(jingdianEntity.getLid().toString());
		if(null==gameTypeVo){
			logger.info("gameType is null,lid 未配置：{}",jingdianEntity.getLid());
		}
		String reportStr = cacheReport.getIfPresent(jingdianEntity.getSiteid() + "+" + jingdianEntity.getUser() + "+"
				+ gameTypeVo.getGameType() + "+" + betDate);
		if (reportStr != null) {
			DsReportEntity dsReportEntity = JSONObject.parseObject(reportStr, DsReportEntity.class);
			dsReportEntity.setBetTime(sdf.parse(sdf.format(dsReportEntity.getBetTime())));
			return dsReportEntity;
		}
		// 如果缓存是空的话，去数据库查下
		List<DsReportEntity> list = lotteryDao.selectReport(jingdianEntity.getSiteid(), jingdianEntity.getUser(),
				gameTypeVo.getGameType(), sdf.parse(betDate));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
