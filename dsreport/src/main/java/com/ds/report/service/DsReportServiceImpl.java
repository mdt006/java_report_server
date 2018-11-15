package com.ds.report.service;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.onetwo.common.utils.DateUtil;
import org.onetwo.common.utils.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ds.member.entity.MemberEntity;
import com.ds.member.entity.MemberEntityExample;
import com.ds.member.mapper.MemberEntityMapper;
import com.ds.report.dao.mapper.DsReportDao;
import com.ds.report.dao.mapper.DsReportMapper;
import com.ds.report.entity.DsAuditTotal;
import com.ds.report.entity.DsCommissionTotal;
import com.ds.report.entity.DsJpgame;
import com.ds.report.entity.DsLiveTips;
import com.ds.report.entity.DsPrivilegeTotal;
import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportDetail;
import com.ds.report.entity.DsReportExample;
import com.ds.report.entity.DsReportExample.Criteria;
import com.ds.report.entity.DsWaterTotal;
import com.ds.report.entity.DsWaterTotalNew;
import com.ds.report.entity.GameKindOrder;
import com.ds.report.entity.GameKindOrderExample;
import com.ds.report.entity.LiveIdConfig;
import com.ds.report.entity.LiveIdConfigExample;
import com.ds.report.entity.MemberLogVo;
import com.ds.report.entity.mapper.DSSiteIdInfoMapper;
import com.ds.report.entity.mapper.GameKindOrderMapper;
import com.ds.report.entity.mapper.LiveIdConfigMapper;
import com.ds.report.utils.CommonUtils;
import com.ds.report.utils.RedisUtils;
import com.ds.report.vo.AuditTotalBatParam;
import com.ds.report.vo.AuditTotalBatResult;
import com.ds.report.vo.AuditTotalDateVo;
import com.ds.report.vo.BetInfoByDateParam;
import com.ds.report.vo.BetInfoByDateSum;
import com.ds.report.vo.GameWaterVo;
import com.ds.report.vo.GetAllLiveByUserVo;
import com.ds.report.vo.HunterDetailRecordVo;
import com.ds.report.vo.HunterDetailTotalVo;
import com.ds.report.vo.MemberBetInfoParam;
import com.ds.report.vo.MemberBetInfoVo;
import com.ds.report.vo.MemberBetSumVo;
import com.ds.report.vo.TotalBySiteVo;
import com.ds.report.vo.ValidateMemberByDateParam;
import com.ds.report.vo.ValidateMemberByDateVo;
import com.ds.temp.entity.TempAuditTotalExample;
import com.ds.temp.mapper.TempAuditTotalMapper;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.yooyo.util.WebApplication;

import hprose.client.HproseTcpClient;

@Service
public class DsReportServiceImpl {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/* 注单统计表 */
	@Resource
	private DsReportMapper dsReportMapper;

	/* DS游戏大类：12 ，游戏类型：41 DS视讯 */
	@Resource
	private DsLiveServiceImpl dsLiveServiceImpl;

	/* BBIN游戏大类：11 ，游戏类型：1 BBIN球类 */
	@Resource
	private DsBbinSportServiceImpl dsBbinSportServiceImpl;

	/* BBIN游戏大类：11 ，游戏类型：3 BBIN视讯 */
	@Resource
	private DsBbinLiveServiceImpl dsBbinLiveServiceImpl;

	/* BBIN游戏大类：11 ，游戏类型：5 BBIN机率 */
	@Resource
	private DsBbinJilvServiceImpl dsBbinJilvServiceImpl;

	/* BBIN游戏大类：11 ，游戏类型：15 BBIN3d */
	@Resource
	private DsBbin3dServiceImpl dsBbin3dServiceImpl;

	/* AG游戏大类：2 ，游戏类型：21 AG视讯 22 AG机率 */
	@Resource
	private DsAgLiveServiceImpl dsAgLiveServiceImpl;

	/* 彩票游戏大类：14，游戏类型：51 */
	@Resource
	private DsJingdianLottoServiceImpl jingdianServiceImpl;

	@Resource
	private DsGameServiceImpl dsGameServiceImpl;
	@Resource
	private DsH8ServiceImpl dsH8ServiceImpl;
	@Resource
	private DsLottoServiceImpl dsLottoService;
	@Resource
	private DsLottoeryServiceImpl dsLotteryService;
	@Resource
	private DsFenFenLottoServiceImpl dsFenFenLottoServiceImpl;
	@Resource
	private MGGameServiceImpl mgGameServiceImpl;
	@Resource
	private ManniuServiceImpl manniuServiceImpl;

	@Resource
	private OGLiveServiceImpl oGLiveServiceImpl;
	@Resource
	private DsGFLottoServiceImpl gfLottoService;

	/* 小费 */
	@Resource
	private DsLiveTipsServiceImpl dsLiveTipsServiceImpl;

	/* 彩金 */
	@Resource
	private DsJpgameServiceImpl dsJpgameServiceImpl;
	/* 游戏类型 */
	// @Resource
	// private DsGameTypeMapper dsGameTypeMapper;
	@Autowired
	private DsReportDao reportDao;
	@Resource
	protected RedisTemplate<Serializable, Object> redisTemplate;

	@Autowired
	private MemberEntityMapper memberMapper;

	@Autowired
	private TempAuditTotalMapper tempAuditTotalMapper;
	@Autowired
	private GameKindOrderMapper gameKindOrderMapper;
	@Autowired
	private DSSiteIdInfoMapper siteIdInfoMapper;
	@Autowired
	private LiveIdConfigMapper liveIdConfigMapper;
	@Autowired
	private HunterJackpotServiceImpl hunterJackpotServiceImpl;
	@Autowired
	private DtPtGameServiceImpl dtPtGameServiceImpl;
	@Autowired
	private DtMGGameServiceImpl dtMGGameServiceImpl;
	@Autowired
	private ReporWaterService reporWaterService;
	@Autowired
	private LMGServiceImpl lmgServiceImpl;
	@Autowired
	private KyChessServiceImpl kyChessServiceImpl;
	@Autowired
	private DsAgSportServiceImpl agSportServiceImpl;
	@Autowired
	private SgsLiveServiceImpl sgsLiveServiceImpl;
	@Autowired
	private SgsGameServiceImpl sgsGameServiceImpl;
	
	private String cacheTimeOut = WebApplication.getProperty("redis_report_time_out");

	private String isUseCache = WebApplication.getProperty("is_use_cache");

	private String Md5Valid = WebApplication.getProperty("md5_valid");

	private HproseTcpClient tcpMoneyclient;
	private final String money_hprose_tcp_url = WebApplication.getProperty("hprose_money_tcp_url");

	public String getMd5Valid() {
		try {
			if (StringUtils.isBlank(Md5Valid)) {
				return "1";
			} else {
				return Md5Valid;
			}
		} catch (Exception ex) {
			return "1";
		}
	}

	private void addRedis(String strMd5, String list) {
		redisTemplate.opsForValue().set(strMd5, list);
	}

	/**
	 * 查询汇总报表,按照层级显示
	 * 
	 */
	public void queryTotalReport(Map<String, Object> paramMap, Map<String, Object> result) throws Exception {
		try {
			logger.info("注单统计报表queryTotalReport start");
			long start = System.currentTimeMillis();
			StringBuilder strCondition = new StringBuilder();
			String siteId = "";
			if (paramMap.containsKey("siteId")) {
				siteId = paramMap.get("siteId").toString();
				strCondition.append("siteId|").append(siteId).append(";");
			}
			String key = "";
			if (paramMap.containsKey("key")) {
				key = paramMap.get("key").toString();
			}
			String betTimeBegin = "";
			if (paramMap.containsKey("betTimeBegin")) {
				betTimeBegin = paramMap.get("betTimeBegin").toString();
				strCondition.append("betTimeBegin|").append(betTimeBegin).append(";");
			}
			String betTimeEnd = "";
			if (paramMap.containsKey("betTimeEnd")) {
				betTimeEnd = paramMap.get("betTimeEnd").toString();
				strCondition.append("betTimeEnd|").append(betTimeEnd).append(";");
			}
			String username = "";
			if (paramMap.containsKey("username")) {
				username = paramMap.get("username").toString();
				strCondition.append("username|").append(username).append(";");
			}
			String gameKind = "";
			if (paramMap.containsKey("gameKind")) {
				gameKind = paramMap.get("gameKind").toString();
				strCondition.append("gameKind|").append(gameKind).append(";");
			}
			String gameType = "";
			if (paramMap.containsKey("gameType")) {
				gameType = paramMap.get("gameType").toString();
				strCondition.append("gameType|").append(gameType).append(";");
			}
			String agentLevel = "";
			if (paramMap.containsKey("agentLevel")) {
				agentLevel = paramMap.get("agentLevel").toString();
				strCondition.append("agentLevel|").append(agentLevel).append(";");
			}
			String betStatus = "";
			if (paramMap.containsKey("betStatus")) {
				betStatus = paramMap.get("betStatus").toString();
				strCondition.append("betStatus|").append(betStatus).append(";");
			}
			String liveId = "";// liveId 为 null
			if (paramMap.containsKey("liveId")) {
				liveId = paramMap.get("liveId").toString();
				if (StringUtils.isBlank(liveId) || "null".equals(liveId) || "".equals(liveId)) {
					liveId = "";
				}
				strCondition.append("liveId|").append(liveId).append(";");
			}
			if (StringUtils.isBlank(key)) {
				result.put("returnCode", 910002);
				result.put("returnMsg", "key is null");
				logger.info("key is null");
				return;
			}
			if (StringUtils.isBlank(siteId)) {
				result.put("returnCode", 910003);
				result.put("returnMsg", "siteId is null");
				logger.info("siteId is null");
				return;
			}
			if (StringUtils.isBlank(betTimeBegin)) {
				result.put("returnCode", 910004);
				result.put("returnMsg", "betTimeBegin is null");
				logger.info("betTimeBegin is null");
				return;
			}
			if (StringUtils.isBlank(betTimeEnd)) {
				result.put("returnCode", 910005);
				result.put("returnMsg", "betTimeEnd is null");
				logger.info("betTimeEnd is null");
				return;
			}
			if (StringUtils.isNotBlank(agentLevel) && !agentLevel.toLowerCase().equals("branch")
					&& StringUtils.isBlank(username)) {
				result.put("returnCode", 910006);
				result.put("returnMsg", "username is null");
				logger.info("username is null");
				return;
			}
			if (StringUtils.isNotBlank(agentLevel) && agentLevel.toLowerCase().equals("member")
					&& StringUtils.isBlank(gameKind)) {
				result.put("returnCode", 910007);
				result.put("returnMsg", "gameKind is null");
				logger.info("gameKind is null");
				return;
			}
			logger.info("valid time : " + (System.currentTimeMillis() - start) + ">>>>>");
			String param = key.substring(5);
			String str = param.substring(0, param.length() - 6);
			String md5 = siteId + username + liveId + gameKind + gameType + betTimeBegin + betTimeEnd + agentLevel
					+ betStatus;
			logger.info("md5 str:" + md5);
			// 缓存中有数据
			String cacheName = "listTotalReport:" + md5;
			Map<String, Object> cacheData = this.getCacheData(cacheName);
			if (cacheData.get("code").equals("1")) {
				logger.info("从缓存中读取数据");
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				if (!agentLevel.toLowerCase().equals("member")) {
					result.put("dataList", cacheData.get("cacheData").toString());
				} else {
					result.putAll((Map<String, Object>) cacheData.get("cacheData"));
				}
				logger.info("total queryTotalReport time : " + (System.currentTimeMillis() - start));
				return;
			}
			logger.info("md5:" + toMD5(md5));
			if (toMD5(md5).equals(str) || getMd5Valid().equals("0")) {
				if (!agentLevel.toLowerCase().equals("member")) {
					logger.info("####queryTotalReport方法 strCondition 参数值::::" + strCondition);
					long queryStart = System.currentTimeMillis();
					List<DsReport> dsReport = this.dsReportMapper.queryTotalByProc(strCondition.toString());
					logger.info("query data time : " + (System.currentTimeMillis() - queryStart));
					/***********************************/
					if (paramMap.containsKey("gameKind") || paramMap.containsKey("liveId")) {
					} else {
						order(dsReport);// 进行排序
					}
					/************************************/
					// 根据来源不同进行分组
					Map<String, List<DsReport>> listGroup = new LinkedHashMap<String, List<DsReport>>();
					if (!dsReport.isEmpty()) {
						for (int i = 0; i < dsReport.size(); i++) {
							Integer iGameKind = dsReport.get(i).getGameKind();
							String strGameKindName = dsReport.get(i).getGameKindName();
							String strKey = iGameKind.toString() + "|" + strGameKindName;
							if (listGroup.containsKey(strKey)) {
								listGroup.get(strKey).add(dsReport.get(i));
							} else {
								List<DsReport> lNew = new ArrayList<DsReport>();
								lNew.add(dsReport.get(i));
								listGroup.put(strKey, lNew);
							}
						}
					}

					if (!listGroup.isEmpty()) {
						result.put("returnCode", 900000);
						result.put("returnMsg", "Success");
						StringBuilder sb = new StringBuilder();
						sb.append("[");
						int i = 0;
						for (Map.Entry<String, List<DsReport>> entry : listGroup.entrySet()) {
							String strKey = entry.getKey();
							List<DsReport> lsReport = entry.getValue();

							sb.append("{\"gameKind\":\"").append(strKey.substring(0, strKey.indexOf("|")))
									.append("\",");
							sb.append("\"gameKindName\":");
							sb.append(this.tranferUnicode(strKey.substring(strKey.indexOf("|") + 1, strKey.length())));
							sb.append(",");
							sb.append("\"data\":");
							sb.append(this.convertToJson(lsReport));
							if (i == listGroup.size() - 1) {
								sb.append("}");
							} else {
								sb.append("},");
							}
							i++;
						}
						sb.append("]");
						result.put("dataList", sb.toString());
						this.setCacheData(cacheName, sb.toString());
						logger.info("group and query time : " + (System.currentTimeMillis() - queryStart));
					} else {
						result.put("returnCode", 900000);
						result.put("returnMsg", "Success");
						result.put("dataList", "");
						this.setCacheData(cacheName, "");
					}
				} else {
					Map<String, Object> dsDetail = this.queryDetailData(paramMap);
					result.put("returnCode", 900000);
					result.put("returnMsg", "Success");
					result.putAll(dsDetail);
					this.setCacheData(cacheName, dsDetail);
				}
			} else {
				result.put("returnCode", 910008);
				result.put("returnMsg", "Key valid error");
				logger.info("Key valid error");
			}
			logger.info("total queryTotalReport time : " + (System.currentTimeMillis() - start));
			logger.info("注单统计报表queryTotalReport end");
		} catch (Exception ex) {
//			logger.error(ex.getMessage(),e);
			logger.error("注单统计报表异常！",ex);
			throw ex;
			/*
			 * result.put("returnCode", 910001); result.put("returnMsg",
			 * "System Error");
			 */
		}
	}

	private void order(List<DsReport> dsReport) {
		Map<Integer, DsReport> dbReportMap = new HashMap<Integer, DsReport>();// gameKind----->Object
		final Map<Integer, GameKindOrder> gameKindMap = new HashMap<Integer, GameKindOrder>();// gameKind----->Object
		List<GameKindOrder> gameKindOrderList = getGameKindOrderList();
		for (GameKindOrder gameKindOrder : gameKindOrderList) {
			gameKindMap.put(gameKindOrder.getGameKind(), gameKindOrder);
		}
		for (DsReport d : dsReport) {
			dbReportMap.put(d.getGameKind(), d);
		}
		for (GameKindOrder gameKindOrder : gameKindOrderList) {
			if (!dbReportMap.containsKey(gameKindOrder.getGameKind())) {// 把没有下注的类型加上去
				dsReport.add(setReport(gameKindOrder.getGameKind(), gameKindOrder.getGameKindName()));
			}
		}
		logger.info(gameKindMap.toString());
		Collections.sort(dsReport, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				DsReport d1 = (DsReport) o1;
				DsReport d2 = (DsReport) o2;
				//此处报错，dsreport为空，或者gamekindorder 未配置
				Integer order1 = gameKindMap.get(d1.getGameKind()).getOrderAsc();
				Integer order2 = gameKindMap.get(d2.getGameKind()).getOrderAsc();
				return order1 - order2;
			}
		});
	}

	private DsReport setReport(Integer gameKind, String gameKindName) {
		DsReport report = new DsReport();
		report.setGameKind(gameKind);
		report.setGameKindName(gameKindName);
		report.setBetCount(0);
		report.setWinlose(new BigDecimal(0));
		report.setValidamount(new BigDecimal(0));
		report.setBetamount(new BigDecimal(0));
		return report;
	}

	private List<GameKindOrder> getGameKindOrderList() {
		GameKindOrderExample e = new GameKindOrderExample();
		e.createCriteria().andStateEqualTo(50);
		return gameKindOrderMapper.selectByExample(e);
	}

	private Map<String, Object> getCacheData(String cacheName) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if (isUseCache.equals("1")) {
				RedisUtils redisUtils = new RedisUtils();
				redisUtils.redisTemplate = this.redisTemplate;
				if (redisUtils.exists(cacheName)) {
					logger.info("读取缓存start");
					String cacheData = (String) redisUtils.get(cacheName);
					result.put("code", "1");
					result.put("cacheData", cacheData);
					logger.info("读取缓存end");
				} else {
					result.put("code", "0");
					logger.info("不存在缓存数据");
				}
			} else {
				result.put("code", "0");
				logger.info("系统不做数据缓存");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			result.put("code", "0");
		}
		return result;
	}

	private void setCacheData(String cacheName, Object cacheData) {
		try {
			if (isUseCache.equals("1")) {
				logger.info("写入缓存start");
				RedisUtils redisUtils = new RedisUtils();
				redisUtils.redisTemplate = this.redisTemplate;
				redisUtils.set(cacheName, cacheData,
						StringUtils.isBlank(cacheTimeOut) ? 1 : Long.valueOf(cacheTimeOut));
				logger.info("写入缓存end");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

	/**
	 * 查询明细报表 2:AG视讯厅 3:OG视讯厅 11:BBIN视讯厅 12:DS视讯厅
	 */
	@SuppressWarnings({ "unchecked" })
	public void queryDetailReport(Map<String, Object> paramMap, com.alibaba.fastjson.JSONObject result)
			throws Exception {
		try {
			long start = System.currentTimeMillis();
			logger.info("注单明细报表queryDetailReport start");
			String siteId = "";
			if (paramMap.containsKey("siteId")) {
				siteId = paramMap.get("siteId").toString();
			}
			String billNo = null;
			if (paramMap.containsKey("billNo")) {
				billNo = paramMap.get("billNo") + "";
			}
			String key = "";
			if (paramMap.containsKey("key")) {
				key = paramMap.get("key").toString();
			}
			String betTimeBegin = "";
			if (paramMap.containsKey("betTimeBegin")) {
				betTimeBegin = paramMap.get("betTimeBegin").toString();
			}
			String betTimeEnd = "";
			if (paramMap.containsKey("betTimeEnd")) {
				betTimeEnd = paramMap.get("betTimeEnd").toString();
			}
			String liveId = "";
			if (paramMap.containsKey("liveId")) {
				liveId = paramMap.get("liveId").toString();
			}
			String startTime = "";
			if (paramMap.containsKey("startTime")) {
				startTime = paramMap.get("startTime").toString();
			}
			String endTime = "";
			if (paramMap.containsKey("endTime")) {
				endTime = paramMap.get("endTime").toString();
			}
			String username = "";
			if (paramMap.containsKey("username")) {
				username = paramMap.get("username").toString();
			}
			String gameKind = "";
			if (paramMap.containsKey("gameKind")) {
				gameKind = paramMap.get("gameKind").toString();
			}
			String gameType = "";
			if (paramMap.containsKey("gameType")) {
				gameType = paramMap.get("gameType").toString();
			}
			String page = "";
			if (paramMap.containsKey("page")) {
				page = paramMap.get("page").toString();
			}
			String pageLimit = "";
			if (paramMap.containsKey("pageLimit")) {
				pageLimit = paramMap.get("pageLimit").toString();
			}
//			if (StringUtils.isBlank(key)) {
//				result.put("returnCode", 910002);
//				result.put("returnMsg", "key is null");
//				return;
//			}

			if (StringUtils.isBlank(siteId)) {
				result.put("returnCode", 910003);
				result.put("returnMsg", "siteId is null");
				logger.info("siteId is null");
				return;
			}
			if (StringUtils.isBlank(betTimeBegin)) {
				result.put("returnCode", 910004);
				result.put("returnMsg", "betTimeBegin is null");
				logger.info("betTimeBegin is null");
				return;
			}
			if (StringUtils.isBlank(betTimeEnd)) {
				result.put("returnCode", 910005);
				result.put("returnMsg", "betTimeEnd is null");
				logger.info("betTimeEnd is null");
				return;
			}
//			if (StringUtils.isBlank(username)) {
//				result.put("returnCode", 910006);
//				result.put("returnMsg", "username is null");
//				logger.info("username is null");
//				return;
//			}
			// if (StringUtils.isBlank(gameKind)) {
			// result.put("returnCode", 910007);
			// result.put("returnMsg", "gameKind is null");
			// logger.info("gameKind is null");
			// return;
			// }

//			String param = key.substring(5);
//			String str = param.substring(0, param.length() - 6);
			String md5 = siteId + username + liveId + gameKind + gameType + betTimeBegin + betTimeEnd + startTime
					+ endTime + page + pageLimit;
			logger.info("md5 str:" + md5);
			// 缓存中有数据
			String cacheName = "listDetailReport:" + md5;
			Map<String, Object> cacheData = this.getCacheData(cacheName);
			if (cacheData.get("code").equals("1")) {
				logger.info("从缓存中读取数据");
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.putAll((Map<String, Object>) cacheData.get("cacheData"));
				// result.put("dataList",
				// cacheData.get("cacheData").toString());
				logger.info("total queryDetailReport time : " + (System.currentTimeMillis() - start));
				return;
			}
			logger.info("md5:" + toMD5(md5));
			// if (toMD5(md5).equals(str)||getMd5Valid().equals("0")) {

			com.alibaba.fastjson.JSONObject dsDetail = this.queryDetailData(paramMap);
			result.put("returnCode", 900000);
			result.put("returnMsg", "Success");
			result.putAll(dsDetail);
			this.setCacheData(cacheName, dsDetail);
			// } else {
			// result.put("returnCode", 910008);
			// result.put("returnMsg", "Key valid error");
			// logger.info("Key valid error");
			// }
			logger.info("total queryDetailReport time : " + (System.currentTimeMillis() - start));
			logger.info("注单明细报表queryDetailReport end");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
		}
	}

	/**
	 * 按用户统计汇总数
	 * 
	 */
	public void queryBetTotalByUser(Map<String, Object> paramMap, Map<String, Object> result) throws Exception {
		try {
			logger.info("按用户统计汇总数queryBetTotalByUser start");
			long start = System.currentTimeMillis();
			String siteId = "";
			if (paramMap.containsKey("siteId")) {
				siteId = paramMap.get("siteId").toString();
			}
			String key = "";
			if (paramMap.containsKey("key")) {
				key = paramMap.get("key").toString();
			}
			String betTimeBegin = "";
			if (paramMap.containsKey("betTimeBegin")) {
				betTimeBegin = paramMap.get("betTimeBegin").toString();
			}
			String betTimeEnd = "";
			if (paramMap.containsKey("betTimeEnd")) {
				betTimeEnd = paramMap.get("betTimeEnd").toString();
			}
			String liveId = "";
			if (paramMap.containsKey("liveId")) {
				liveId = paramMap.get("liveId").toString();
			}
			String startTime = "";
			if (paramMap.containsKey("startTime")) {
				startTime = paramMap.get("startTime").toString();
			}
			String endTime = "";
			if (paramMap.containsKey("endTime")) {
				endTime = paramMap.get("endTime").toString();
			}
			String username = "";
			if (paramMap.containsKey("username")) {
				username = paramMap.get("username").toString();
			}
			String gameKind = "";
			if (paramMap.containsKey("gameKind")) {
				gameKind = paramMap.get("gameKind").toString();
			}
			String gameType = "";
			if (paramMap.containsKey("gameType")) {
				gameType = paramMap.get("gameType").toString();
			}
			if (StringUtils.isBlank(key)) {
				result.put("returnCode", 910002);
				result.put("returnMsg", "key is null");
				return;
			}

			if (StringUtils.isBlank(siteId)) {
				result.put("returnCode", 910003);
				result.put("returnMsg", "siteId is null");
				logger.info("siteId is null");
				return;
			}
			if (StringUtils.isBlank(betTimeBegin)) {
				result.put("returnCode", 910004);
				result.put("returnMsg", "betTimeBegin is null");
				logger.info("betTimeBegin is null");
				return;
			}
			if (StringUtils.isBlank(betTimeEnd)) {
				result.put("returnCode", 910005);
				result.put("returnMsg", "betTimeEnd is null");
				logger.info("betTimeEnd is null");
				return;
			}
			if (StringUtils.isBlank(username)) {
				result.put("returnCode", 910006);
				result.put("returnMsg", "username is null");
				logger.info("username is null");
				return;
			}
			if (StringUtils.isBlank(gameKind)) {
				result.put("returnCode", 910007);
				result.put("returnMsg", "gameKind is null");
				logger.info("gameKind is null");
				return;
			}
			if (StringUtils.isBlank(liveId)) {
				result.put("returnCode", 910009);
				result.put("returnMsg", "liveId is null");
				logger.info("liveId is null");
				return;
			}
			String param = key.substring(5);
			String str = param.substring(0, param.length() - 6);
			String md5 = siteId + username + liveId + gameKind + gameType + betTimeBegin + betTimeEnd + startTime
					+ endTime;
			logger.info("md5 str:" + md5);
			// 取缓存数据
			String cacheName = "betTotalByUser:" + md5;
			Map<String, Object> cacheData = this.getCacheData(cacheName);
			if (cacheData.get("code").equals("1")) {
				logger.info("从缓存中读取数据");
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", cacheData.get("cacheData").toString());
				logger.info("total queryBetTotalByUser time : " + (System.currentTimeMillis() - start));
				return;
			}
			logger.info("md5:" + toMD5(md5));
			if (toMD5(md5).equals(str) || getMd5Valid().equals("0")) {
				DsReportExample m_example = this.generateSearchParam(paramMap);
				List<DsReport> dsBetTotal = this.dsReportMapper.queryBetTotal(m_example);
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", this.convertToJson(dsBetTotal));
				this.setCacheData(cacheName, this.convertToJson(dsBetTotal));
			} else {
				result.put("returnCode", 910008);
				result.put("returnMsg", "Key valid error");
				logger.info("Key valid error");
			}
			logger.info("total queryBetTotalByUser time : " + (System.currentTimeMillis() - start));
			logger.info("按用户统计汇总数queryBetTotalByUser end");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
			/*
			 * result.put("returnCode", 910001); result.put("returnMsg",
			 * "System error");
			 */
		}

	}

	/**
	 * 按用户/天统计汇总数
	 * 
	 */
	public void queryBetTotalByDay(Map<String, Object> paramMap, Map<String, Object> result) throws Exception {
		try {
			logger.info("按用户/天统计汇总数queryBetTotalByDay start");
			long start = System.currentTimeMillis();
			String siteId = "";
			if (paramMap.containsKey("siteId")) {
				siteId = paramMap.get("siteId").toString();
			}
			String key = "";
			if (paramMap.containsKey("key")) {
				key = paramMap.get("key").toString();
			}
			String betTimeBegin = "";
			if (paramMap.containsKey("betTimeBegin")) {
				betTimeBegin = paramMap.get("betTimeBegin").toString();
			}
			String betTimeEnd = "";
			if (paramMap.containsKey("betTimeEnd")) {
				betTimeEnd = paramMap.get("betTimeEnd").toString();
			}
			String liveId = "";
			if (paramMap.containsKey("liveId")) {
				liveId = paramMap.get("liveId").toString();
			}
			String startTime = "";
			if (paramMap.containsKey("startTime")) {
				startTime = paramMap.get("startTime").toString();
			}
			String endTime = "";
			if (paramMap.containsKey("endTime")) {
				endTime = paramMap.get("endTime").toString();
			}
			String username = "";
			if (paramMap.containsKey("username")) {
				username = paramMap.get("username").toString();
			}
			String gameKind = "";
			if (paramMap.containsKey("gameKind")) {
				gameKind = paramMap.get("gameKind").toString();
			}
			String gameType = "";
			if (paramMap.containsKey("gameType")) {
				gameType = paramMap.get("gameType").toString();
			}
			String orderType = "";
			if (paramMap.containsKey("orderType")) {
				orderType = paramMap.get("orderType").toString();
			}

			if (StringUtils.isBlank(key)) {
				result.put("returnCode", 910002);
				result.put("returnMsg", "key is null");
				logger.info("key is null");
				return;
			}

			if (StringUtils.isBlank(siteId)) {
				result.put("returnCode", 910003);
				result.put("returnMsg", "siteId is null");
				logger.info("siteId is null");
				return;
			}
			if (StringUtils.isBlank(betTimeBegin)) {
				result.put("returnCode", 910004);
				result.put("returnMsg", "betTimeBegin is null");
				logger.info("betTimeBegin is null");
				return;
			}
			if (StringUtils.isBlank(betTimeEnd)) {
				result.put("returnCode", 910005);
				result.put("returnMsg", "betTimeEnd is null");
				logger.info("betTimeEnd is null");
				return;
			}
			if (StringUtils.isBlank(username)) {
				result.put("returnCode", 910006);
				result.put("returnMsg", "username is null");
				logger.info("username is null");
				return;
			}
			// if (StringUtils.isBlank(gameKind)) {
			// result.put("returnCode", 910007);
			// result.put("returnMsg", "gameKind is null");
			// logger.info("gameKind is null");
			// return;
			// }

			String param = key.substring(5);
			String str = param.substring(0, param.length() - 6);
			String md5 = siteId + username + liveId + gameKind + gameType + betTimeBegin + betTimeEnd + startTime
					+ endTime;
			logger.info("md5 str:" + md5);
			// 缓存中有数据
			String cacheName = "betTotalByDay:" + md5;
			Map<String, Object> cacheData = this.getCacheData(cacheName);
			if (cacheData.get("code").equals("1")) {
				logger.info("从缓存中读取数据");
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", cacheData.get("cacheData").toString());
				logger.info("total queryBetTotalByDay time : " + (System.currentTimeMillis() - start));
				return;
			}
			logger.info("md5:" + toMD5(md5));
			if (toMD5(md5).equals(str) || getMd5Valid().equals("0")) {
				DsReportExample m_example = this.generateSearchParam(paramMap);
				m_example.setOrderType(orderType);
				List<DsReport> dsBetList = this.dsReportMapper.queryBetTotalByDay(m_example);
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", this.convertToJson(dsBetList));
				this.setCacheData(cacheName, this.convertToJson(dsBetList));
			} else {
				result.put("returnCode", 910008);
				result.put("returnMsg", "Key valid error");
				logger.info("Key valid error");
			}
			logger.info("total queryBetTotalByDay time : " + (System.currentTimeMillis() - start));
			logger.info("按用户/天统计汇总数queryBetTotalByDay end");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
			/*
			 * result.put("returnCode", 910001); result.put("returnMsg",
			 * "System error");
			 */
		}

	}

	

	/**
	 * 查询注单明细 2:AG视讯厅 3:OG视讯厅 11:BBIN视讯厅 12:DS视讯厅
	 */
	private com.alibaba.fastjson.JSONObject queryDetailData(Map<String, Object> paramMap) throws Exception {
		String strgameKind = "";
		DsReportDetail dsTotal = null;
		List<DsReportDetail> listDetail = null;
		com.alibaba.fastjson.JSONObject retrunMap = new com.alibaba.fastjson.JSONObject();
		try {
			logger.info("查询注单明细queryDetailData start");

			if (paramMap.containsKey("gameKind")) {
				strgameKind = paramMap.get("gameKind").toString();
				if (strgameKind.equals("1")) {// BBIN 球类
					dsTotal = this.dsBbinSportServiceImpl.queryTotal(paramMap);
					if (dsTotal.getBetCount() > 0)
						listDetail = this.dsBbinSportServiceImpl.queryDetail(paramMap);
				} else if (strgameKind.equals("3")) { // BBIN视讯
					dsTotal = this.dsBbinLiveServiceImpl.queryTotal(paramMap);
					if (dsTotal.getBetCount() > 0)
						listDetail = this.dsBbinLiveServiceImpl.queryDetail(paramMap);
				}
				// TODO
				/**
				 * update 2016-02-25 by jay
				 */
				else if (strgameKind.equals("70")) { // OG视讯
					dsTotal = this.oGLiveServiceImpl.queryTotal(paramMap);
					if (dsTotal.getBetCount() > 0)
						listDetail = this.oGLiveServiceImpl.queryDetail(paramMap);
				}

				else if (strgameKind.equals("5")) {// BBIN 机率
					dsTotal = this.dsBbinJilvServiceImpl.queryTotal(paramMap);
					if (dsTotal.getBetCount() > 0)
						listDetail = this.dsBbinJilvServiceImpl.queryDetail(paramMap);
				} else if (strgameKind.equals("12")) {// BBIN 彩票

				} else if (strgameKind.equals("15")) {// BBIN 3D厅
					dsTotal = this.dsBbin3dServiceImpl.queryTotal(paramMap);
					if (dsTotal.getBetCount() > 0)
						listDetail = this.dsBbin3dServiceImpl.queryDetail(paramMap);
				} else if("16".equals(strgameKind)){
					dsTotal = this.dtPtGameServiceImpl.queryTotal(paramMap);
					if (dsTotal.getBetCount() > 0)
						listDetail = this.dtPtGameServiceImpl.queryDetail(paramMap);
				} else if (strgameKind.equals("21") || strgameKind.equals("22")) { // 21
																					// AG视讯
																					// 22
																					// AG机率
					dsTotal = this.dsAgLiveServiceImpl.queryTotal(paramMap);
					if (dsTotal.getBetCount() > 0)
						listDetail = this.dsAgLiveServiceImpl.queryDetail(paramMap);
				}else if("23".equals(strgameKind)){//AG捕鱼
					dsTotal = this.hunterJackpotServiceImpl.queryTotal(paramMap);
					if (dsTotal.getBetCount() > 0)
						listDetail = this.hunterJackpotServiceImpl.queryDetail(paramMap);
				}else if("24".equals(strgameKind)){//AG体育
					dsTotal = this.agSportServiceImpl.queryTotal(paramMap);
					if (dsTotal.getBetCount() > 0)
						listDetail = this.agSportServiceImpl.queryDetail(paramMap);
				}else if (strgameKind.equals("41")) { // DS视讯
					dsTotal = this.dsLiveServiceImpl.queryTotal(paramMap);
					if (dsTotal.getBetCount() > 0)
						listDetail = this.dsLiveServiceImpl.queryDetail(paramMap);
				}else if (strgameKind.equals("30000")) { // kkw视讯
					dsTotal = this.dsLiveServiceImpl.queryTotal(paramMap);
					if (dsTotal.getBetCount() > 0)
						listDetail = this.dsLiveServiceImpl.queryDetail(paramMap);
				} 
				/**
				 * 51,57,58,59都走此方法,共用一张表
				 */
				else if ("51".equals(strgameKind)||"57".equals(strgameKind)||"58".equals(strgameKind)||"59".equals(strgameKind)) { //KG经典彩
					dsTotal = this.jingdianServiceImpl.queryTotal(paramMap);
					if (dsTotal.getBetCount() > 0)
						listDetail = this.jingdianServiceImpl.queryDetail(paramMap);
				} else if ("52".equals(strgameKind)) { //KG官方彩
					dsTotal = this.dsFenFenLottoServiceImpl.queryTotal(paramMap);
					if (dsTotal.getBetCount() > 0) {
						listDetail = this.dsFenFenLottoServiceImpl.queryDetail(paramMap);
					}
				} else if (strgameKind.equals("53")) { // ds电子游戏
					dsTotal = this.dsGameServiceImpl.queryTotal(paramMap);
					if (dsTotal.getBetCount() > 0)
						listDetail = this.dsGameServiceImpl.queryDetail(paramMap);

				} else if (strgameKind.equals("42")) {// h8体育
					dsTotal = this.dsH8ServiceImpl.queryTotal(paramMap);
					if (dsTotal.getBetCount() > 0)
						listDetail = this.dsH8ServiceImpl.queryDetail(paramMap);
				} else if (strgameKind.equals("54")) {// ds香港彩
					dsTotal = this.dsLottoService.queryTotal(paramMap);
					if (dsTotal.getBetCount() > 0)
						listDetail = this.dsLottoService.queryDetail(paramMap);
				} else if (strgameKind.equals("55")) {// ds传统彩
					dsTotal = this.dsLotteryService.queryTotal(paramMap);
					if (dsTotal.getBetCount() > 0)
						listDetail = this.dsLotteryService.queryDetail(paramMap);
				} else if (strgameKind.equals("60")) {// MG电子游戏
					dsTotal = this.mgGameServiceImpl.queryTotal(paramMap);
					if (dsTotal.getBetCount() > 0)
						listDetail = this.mgGameServiceImpl.queryDetail(paramMap);
				} else if (strgameKind.equals("80")) {// 蛮牛
					dsTotal = this.manniuServiceImpl.queryTotal(paramMap);
					if (dsTotal.getBetCount() > 0)
						listDetail = this.manniuServiceImpl.queryDetail(paramMap);
				}
				else if (strgameKind.equals("56")) {// KG新官方彩
					dsTotal = this.gfLottoService.queryTotal(paramMap);
					if (dsTotal.getBetCount() > 0)
						listDetail = this.gfLottoService.queryDetail(paramMap);
				}else if("65".equals(strgameKind)){//PMG电子
					dsTotal=this.dtMGGameServiceImpl.queryTotal(paramMap);
					if (dsTotal.getBetCount() > 0)
						listDetail = this.dtMGGameServiceImpl.queryDetail(paramMap);
				}else if("18".equals(strgameKind)){//LMG视讯
					dsTotal=this.lmgServiceImpl.queryTotal(paramMap);
					if (dsTotal.getBetCount() > 0)
						listDetail = this.lmgServiceImpl.queryDetail(paramMap);
				}else if("90".equals(strgameKind)){//开元棋牌
					dsTotal=this.kyChessServiceImpl.queryTotal(paramMap);
					if (dsTotal.getBetCount() > 0)
						listDetail = this.kyChessServiceImpl.queryDetail(paramMap);
				}else if("95".equals(strgameKind)){//SGS视讯
					dsTotal = this.sgsLiveServiceImpl.queryTotal(paramMap);
					if(dsTotal.getBetCount() > 0)
						listDetail = this.sgsLiveServiceImpl.queryDetail(paramMap);
				}else if("96".equals(strgameKind)){//SGS电子 
					dsTotal = this.sgsGameServiceImpl.queryTotal(paramMap);
					if(dsTotal.getBetCount() > 0)
						listDetail = this.sgsGameServiceImpl.queryDetail(paramMap);
				}
				if (listDetail == null) {
					// logger.info("dataList size === {}",
					// dsTotal.getBetCount());
				} else {
					logger.info("dataList size === {}-->{}", dsTotal.getBetCount(), listDetail.size());
				}
				if (dsTotal.getBetCount() > 0) {
					retrunMap.put("total", dsTotal);
					retrunMap.put("dataList", listDetail);
				}else{
					listDetail=new ArrayList<DsReportDetail>();
					retrunMap.put("total", 0);
					retrunMap.put("dataList", listDetail);
				}

			}
			logger.info("查询注单明细queryDetailData end");
			return retrunMap;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
		}
	}

	/**
	 * 优惠统计 输入条件：日期区间、层级、用户名称、网站名称 输出：根据用户名称统计每天游戏大类的有效投注额
	 * 
	 * @param request
	 * @return
	 */
	public void privilegeTotal(Map<String, Object> paramMap, Map<String, Object> result) throws Exception {
		try {
			logger.info("优惠统计privilegeTotal start");
			long start = System.currentTimeMillis();
			StringBuilder strCondition = new StringBuilder();
			String siteId = "";
			if (paramMap.containsKey("siteId")) {
				siteId = paramMap.get("siteId").toString();
				strCondition.append("siteId|").append(siteId).append(";");
			}
			String key = "";
			if (paramMap.containsKey("key")) {
				key = paramMap.get("key").toString();
			}
			String betTimeBegin = "";
			if (paramMap.containsKey("betTimeBegin")) {
				betTimeBegin = paramMap.get("betTimeBegin").toString();
				strCondition.append("betTimeBegin|").append(betTimeBegin).append(";");
			}
			String betTimeEnd = "";
			if (paramMap.containsKey("betTimeEnd")) {
				betTimeEnd = paramMap.get("betTimeEnd").toString();
				strCondition.append("betTimeEnd|").append(betTimeEnd).append(";");
			}
			String username = "";
			if (paramMap.containsKey("username")) {
				username = paramMap.get("username").toString();
				strCondition.append("username|").append(username).append(";");
			}
			String agentLevel = "";
			if (paramMap.containsKey("agentLevel")) {
				agentLevel = paramMap.get("agentLevel").toString();
				strCondition.append("agentLevel|").append(agentLevel).append(";");
			}

			if (StringUtils.isBlank(key)) {
				result.put("returnCode", 910002);
				result.put("returnMsg", "key is null");
				logger.info("key is null");
				return;
			}

			if (StringUtils.isBlank(siteId)) {
				result.put("returnCode", 910003);
				result.put("returnMsg", "siteId is null");
				logger.info("siteId is null");
				return;
			}
			if (StringUtils.isBlank(betTimeBegin)) {
				result.put("returnCode", 910004);
				result.put("returnMsg", "betTimeBegin is null");
				logger.info("betTimeBegin is null");
				return;
			}
			if (StringUtils.isBlank(betTimeEnd)) {
				result.put("returnCode", 910005);
				result.put("returnMsg", "betTimeEnd is null");
				logger.info("betTimeEnd is null");
				return;
			}
			if (StringUtils.isBlank(username)) {
				result.put("returnCode", 910006);
				result.put("returnMsg", "username is null");
				logger.info("username is null");
				return;
			}
			if (StringUtils.isBlank(agentLevel)) {
				result.put("returnCode", 910007);
				result.put("returnMsg", "agentLevel is null");
				logger.info("agentLevel is null");
				return;
			}
			String param = key.substring(5);
			String str = param.substring(0, param.length() - 6);
			String md5 = siteId + betTimeBegin + betTimeEnd + username + agentLevel;
			logger.info("md5 str:" + md5);
			// 取缓存数据
			String cacheName = "privilegeTotal:" + md5;
			Map<String, Object> cacheData = this.getCacheData(cacheName);
			if (cacheData.get("code").equals("1")) {
				logger.info("从缓存中读取数据");
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", cacheData.get("cacheData").toString());
				logger.info("total privilegeTotal time : " + (System.currentTimeMillis() - start));
				return;
			}
			logger.info("md5:" + toMD5(md5));
			if (toMD5(md5).equals(str) || getMd5Valid().equals("0")) {

				List<DsPrivilegeTotal> dsPrivilegeTotal = this.dsReportMapper
						.privilegeTotalByProc(strCondition.toString());
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", this.convertToJson(dsPrivilegeTotal));
				this.setCacheData(cacheName, this.convertToJson(dsPrivilegeTotal));
			} else {
				result.put("returnCode", 910008);
				result.put("returnMsg", "Key valid error");
				logger.info("Key valid error");
				return;
			}
			logger.info("total privilegeTotal time : " + (System.currentTimeMillis() - start));
			logger.info("优惠统计privilegeTotal end");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
			/*
			 * result.put("returnCode", 910001); result.put("returnMsg",
			 * "System error");
			 */
		}
	}

	/**
	 * 返水报表 输入条件：返水优惠设定值、日期区间、层级、用户名称、网站名称 输出：根据用户名称统计每个游戏大类的返水金额
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public void waterReportByProc(Map<String, Object> paramMap, Map<String, Object> result) throws Exception {
		try {
			logger.info("返水报表waterReport start");
			long start = System.currentTimeMillis();
			String siteId = "";
			StringBuilder strCondition = new StringBuilder();
			if (paramMap.containsKey("siteId")) {
				siteId = paramMap.get("siteId").toString();
				strCondition.append("siteId|").append(siteId).append(";");
			}
			String key = "";
			if (paramMap.containsKey("key")) {
				key = paramMap.get("key").toString();
			}
			String betTimeBegin = "";
			if (paramMap.containsKey("betTimeBegin")) {
				betTimeBegin = paramMap.get("betTimeBegin").toString();
				strCondition.append("betTimeBegin|").append(betTimeBegin).append(";");
			}
			String betTimeEnd = "";
			if (paramMap.containsKey("betTimeEnd")) {
				betTimeEnd = paramMap.get("betTimeEnd").toString();
				strCondition.append("betTimeEnd|").append(betTimeEnd).append(";");
			}
			String username = "";
			if (paramMap.containsKey("username")) {
				username = paramMap.get("username").toString();
				strCondition.append("username|").append(username).append(";");
			}
			String agentLevel = "";
			if (paramMap.containsKey("agentLevel")) {
				agentLevel = paramMap.get("agentLevel").toString();
				strCondition.append("agentLevel|").append(agentLevel).append(";");
			}
			String waterType = "";
			if (paramMap.containsKey("waterType")) {
				waterType = paramMap.get("waterType").toString();
				strCondition.append("waterType|").append(waterType).append(";");
			}
			String returnOrder = "";
			if (paramMap.containsKey("return_order")) {
				returnOrder = paramMap.get("return_order").toString();
			}
			String returnPercent = "";
			if (paramMap.containsKey("return_percent")) {
				returnPercent = paramMap.get("return_percent").toString();
			}

			if (StringUtils.isBlank(key)) {
				result.put("returnCode", 910002);
				result.put("returnMsg", "key is null");
				logger.info("key is null");
				return;
			}

			if (StringUtils.isBlank(siteId)) {
				result.put("returnCode", 910003);
				result.put("returnMsg", "siteId is null");
				logger.info("siteId is null");
				return;
			}
			if (StringUtils.isBlank(betTimeBegin)) {
				result.put("returnCode", 910004);
				result.put("returnMsg", "betTimeBegin is null");
				logger.info("betTimeBegin is null");
				return;
			}
			if (StringUtils.isBlank(betTimeEnd)) {
				result.put("returnCode", 910005);
				result.put("returnMsg", "betTimeEnd is null");
				logger.info("betTimeEnd is null");
				return;
			}
			if (StringUtils.isBlank(username)) {
				result.put("returnCode", 910006);
				result.put("returnMsg", "username is null");
				logger.info("username is null");
				return;
			}
			if (StringUtils.isBlank(agentLevel)) {
				result.put("returnCode", 910010);
				result.put("returnMsg", "agentLevel is null");
				logger.info("agentLevel is null");
				return;
			}
			if (StringUtils.isBlank(waterType)) {
				result.put("returnCode", 9100011);
				result.put("returnMsg", "waterType is null");
				logger.info("waterType is null");
				return;
			}
			if (StringUtils.isBlank(returnOrder)) {
				result.put("returnCode", 9100012);
				result.put("returnMsg", "return_order is null");
				logger.info("return_order is null");
				return;
			}
			if (StringUtils.isBlank(returnPercent)) {
				result.put("returnCode", 9100013);
				result.put("returnMsg", "return_percent is null");
				logger.info("return_percent is null");
				return;
			}

			String param = key.substring(5);
			String str = param.substring(0, param.length() - 6);
			String md5 = siteId + betTimeBegin + betTimeEnd + username + agentLevel + waterType;
			logger.info("md5 str:" + md5);
			// 取缓存数据
			String cacheName = "waterReport:" + md5 + returnOrder + returnPercent;
			Map<String, Object> cacheData = this.getCacheData(cacheName);
			if (cacheData.get("code").equals("1")) {
				logger.info("从缓存中读取数据");
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", cacheData.get("cacheData").toString());
				logger.info("total waterReport time : " + (System.currentTimeMillis() - start));
				return;
			}
			logger.info("md5:" + toMD5(md5));
			if (toMD5(md5).equals(str) || getMd5Valid().equals("0")) {
				Map<String, Object> mapCondition = new HashMap<String, Object>();
				mapCondition.put("condition", strCondition.toString());
				mapCondition.put("returnOrder", returnOrder);
				mapCondition.put("returnPercent", returnPercent);
				List<DsWaterTotal> dsWaterTotal = this.dsReportMapper.waterReportByProc(mapCondition);
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", this.convertToJson(dsWaterTotal));
				java.util.Date nowdate = new java.util.Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
				Date betTime = format.parse(betTimeEnd + " 23:59:59");
				Calendar cal = Calendar.getInstance();
				cal.setTime(nowdate);
				cal.add(Calendar.DATE, -1);

				Calendar cal1 = Calendar.getInstance();
				cal1.setTime(betTime);
				cal1.add(Calendar.DATE, 1);

				if (betTime.before(cal.getTime())
						|| (cal1.get(Calendar.DATE) == nowdate.getDate() && nowdate.getHours() > 4)) {
					if (isUseCache.equals("1")) {
						logger.info("写入缓存start");
						RedisUtils redisUtils = new RedisUtils();
						redisUtils.redisTemplate = this.redisTemplate;
						redisUtils.set(cacheName, this.convertToJson(dsWaterTotal));
						logger.info("写入缓存end");
					}
				} else {
					this.setCacheData(cacheName, this.convertToJson(dsWaterTotal));
				}
			} else {
				result.put("returnCode", 910008);
				result.put("returnMsg", "Key valid error");
				logger.info("Key valid error");
				return;
			}
			logger.info("total waterReport time : " + (System.currentTimeMillis() - start));
			logger.info("返水报表waterReport end");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
			/*
			 * result.put("returnCode", 910001); result.put("returnMsg",
			 * "System error");
			 */
		}
	}

	/**
	 * 退佣统计 输入条件：日期区间、网站名称 输出：根据用户名称统计有效投注金额
	 * 
	 * @param request
	 * @return
	 */
	public void commissionTotal(Map<String, Object> paramMap, Map<String, Object> result) throws Exception {
		try {
			logger.info("退佣统计commissionTotal start");
			long start = System.currentTimeMillis();
			StringBuilder strCondition = new StringBuilder();
			String siteId = "";
			if (paramMap.containsKey("siteId")) {
				siteId = paramMap.get("siteId").toString();
				strCondition.append("siteId|").append(siteId).append(";");
			}
			String key = "";
			if (paramMap.containsKey("key")) {
				key = paramMap.get("key").toString();
			}
			String betTimeBegin = "";
			if (paramMap.containsKey("betTimeBegin")) {
				betTimeBegin = paramMap.get("betTimeBegin").toString();
				strCondition.append("betTimeBegin|").append(betTimeBegin).append(";");
			}
			String betTimeEnd = "";
			if (paramMap.containsKey("betTimeEnd")) {
				betTimeEnd = paramMap.get("betTimeEnd").toString();
				strCondition.append("betTimeEnd|").append(betTimeEnd).append(";");
			}
			String username = "";
			if (paramMap.containsKey("username")) {
				username = paramMap.get("username").toString();
				strCondition.append("username|").append(username).append(";");
			}
			String agentLevel = "";
			if (paramMap.containsKey("agentLevel")) {
				agentLevel = paramMap.get("agentLevel").toString();
				strCondition.append("agentLevel|").append(agentLevel).append(";");
			}
			String defValidamount = "";
			if (paramMap.containsKey("defValidamount")) {
				defValidamount = paramMap.get("defValidamount").toString();
				strCondition.append("defValidamount|").append(defValidamount).append(";");
			}

			if (StringUtils.isBlank(key)) {
				result.put("returnCode", 910002);
				result.put("returnMsg", "key is null");
				logger.info("key is null");
				return;
			}

			if (StringUtils.isBlank(siteId)) {
				result.put("returnCode", 910003);
				result.put("returnMsg", "siteId is null");
				logger.info("siteId is null");
				return;
			}
			if (StringUtils.isBlank(betTimeBegin)) {
				result.put("returnCode", 910004);
				result.put("returnMsg", "betTimeBegin is null");
				logger.info("betTimeBegin is null");
				return;
			}
			if (StringUtils.isBlank(betTimeEnd)) {
				result.put("returnCode", 910005);
				result.put("returnMsg", "betTimeEnd is null");
				logger.info("betTimeEnd is null");
				return;
			}

			String param = key.substring(5);
			String str = param.substring(0, param.length() - 6);
			String md5 = siteId + betTimeBegin + betTimeEnd + username + agentLevel + defValidamount;
			logger.info("md5 str:" + md5);
			// 取缓存数据
			String cacheName = "commissionTotal:" + md5;
			Map<String, Object> cacheData = this.getCacheData(cacheName);
			if (cacheData.get("code").equals("1")) {
				logger.info("从缓存中读取数据");
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", cacheData.get("cacheData").toString());
				logger.info("total commissionTotal time : " + (System.currentTimeMillis() - start));
				return;
			}
			logger.info("md5:" + toMD5(md5));
			if (toMD5(md5).equals(str) || getMd5Valid().equals("0")) {
				/*
				 * DsReportExample m_example =
				 * this.generateSearchParam(paramMap);
				 * 
				 * List<DsCommissionTotal> dsCommissionTotal =
				 * this.dsReportMapper.commissionTotal(m_example);
				 */
				Map<String, Object> mapCondition = new HashMap<String, Object>();
				mapCondition.put("condition", strCondition.toString());
				List<DsCommissionTotal> dsCommissionTotal = this.dsReportMapper
						.commissionTotalByProc(strCondition.toString());
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", this.convertToJson(dsCommissionTotal));
				this.setCacheData(cacheName, this.convertToJson(dsCommissionTotal));
			} else {
				result.put("returnCode", 910008);
				result.put("returnMsg", "Key valid error");
				logger.info("Key valid error");
				return;
			}
			logger.info("total commissionTotal time : " + (System.currentTimeMillis() - start));
			logger.info("退佣统计commissionTotal end");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
			/*
			 * result.put("returnCode", 910001); result.put("returnMsg",
			 * "System error");
			 */
		}
	}

	/**
	 * 退佣统计 输入条件：日期区间、网站名称 输出：根据用户名称统计有效投注金额
	 * 
	 * @param request
	 * @return
	 */
	public void commissionTotalByPage(Map<String, Object> paramMap, Map<String, Object> result) throws Exception {
		try {
			logger.info("退佣统计commissionTotalByPage start");
			long start = System.currentTimeMillis();
			StringBuilder strCondition = new StringBuilder();
			String siteId = "";
			if (paramMap.containsKey("siteId")) {
				siteId = paramMap.get("siteId").toString();
				strCondition.append("siteId|").append(siteId).append(";");
			}
			String key = "";
			if (paramMap.containsKey("key")) {
				key = paramMap.get("key").toString();
			}
			String betTimeBegin = "";
			if (paramMap.containsKey("betTimeBegin")) {
				betTimeBegin = paramMap.get("betTimeBegin").toString();
				strCondition.append("betTimeBegin|").append(betTimeBegin).append(";");
			}
			String betTimeEnd = "";
			if (paramMap.containsKey("betTimeEnd")) {
				betTimeEnd = paramMap.get("betTimeEnd").toString();
				strCondition.append("betTimeEnd|").append(betTimeEnd).append(";");
			}
			String username = "";
			if (paramMap.containsKey("username")) {
				username = paramMap.get("username").toString();
				strCondition.append("username|").append(username).append(";");
			}
			String agentLevel = "";
			if (paramMap.containsKey("agentLevel")) {
				agentLevel = paramMap.get("agentLevel").toString();
				strCondition.append("agentLevel|").append(agentLevel).append(";");
			}
			String defValidamount = "";
			if (paramMap.containsKey("defValidamount")) {
				defValidamount = paramMap.get("defValidamount").toString();
				strCondition.append("defValidamount|").append(defValidamount).append(";");
			}

			if (StringUtils.isBlank(key)) {
				result.put("returnCode", 910002);
				result.put("returnMsg", "key is null");
				logger.info("key is null");
				return;
			}

			if (StringUtils.isBlank(siteId)) {
				result.put("returnCode", 910003);
				result.put("returnMsg", "siteId is null");
				logger.info("siteId is null");
				return;
			}
			if (StringUtils.isBlank(betTimeBegin)) {
				result.put("returnCode", 910004);
				result.put("returnMsg", "betTimeBegin is null");
				logger.info("betTimeBegin is null");
				return;
			}
			if (StringUtils.isBlank(betTimeEnd)) {
				result.put("returnCode", 910005);
				result.put("returnMsg", "betTimeEnd is null");
				logger.info("betTimeEnd is null");
				return;
			}

			String param = key.substring(5);
			String str = param.substring(0, param.length() - 6);
			String md5 = siteId + betTimeBegin + betTimeEnd + username + agentLevel + defValidamount;
			logger.info("md5 str:" + md5);
			// 取缓存数据
			String cacheName = "commissionTotalByPage:" + md5;
			Map<String, Object> cacheData = this.getCacheData(cacheName);
			if (cacheData.get("code").equals("1")) {
				logger.info("从缓存中读取数据");
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", cacheData.get("cacheData").toString());
				logger.info("total commissionTotal time : " + (System.currentTimeMillis() - start));
				return;
			}

			logger.info("md5:" + toMD5(md5));
			if (toMD5(md5).equals(str) || getMd5Valid().equals("0")) {
				/*
				 * DsReportExample m_example =
				 * this.generateSearchParam(paramMap);
				 * 
				 * List<DsCommissionTotal> dsCommissionTotal =
				 * this.dsReportMapper.commissionTotal(m_example);
				 */
				Map<String, Object> mapCondition = new HashMap<String, Object>();
				mapCondition.put("condition", strCondition.toString());
				mapCondition.put("startIndex", paramMap.get("page"));
				mapCondition.put("recordCount", paramMap.get("pageLimit"));
				List<DsCommissionTotal> dsCommissionTotal = this.dsReportMapper.commissionTotalByPage(mapCondition);
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", this.convertToJson(dsCommissionTotal));
				result.put("total", mapCondition.get("totalCount"));
				this.setCacheData(cacheName, this.convertToJson(dsCommissionTotal));
			} else {
				result.put("returnCode", 910008);
				result.put("returnMsg", "Key valid error");
				logger.info("Key valid error");
				return;
			}
			logger.info("total commissionTotal time : " + (System.currentTimeMillis() - start));
			logger.info("退佣统计commissionTotalByPage end");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
			/*
			 * result.put("returnCode", 910001); result.put("returnMsg",
			 * "System error");
			 */
		}
	}

	/**
	 * MD5 加密
	 * 
	 * @param str
	 * @return
	 */
	private static String toMD5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] byteDigest = md.digest();

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < byteDigest.length; offset++) {
				int i = byteDigest[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return null;
	}


	private Object convertToJson(Object object) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		SimpleModule module = new SimpleModule();
		module.addSerializer(String.class, new StringUnicodeSerializer());
		mapper.registerModule(module);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
		mapper.setDateFormat(dateFormat);
		return mapper.writeValueAsString(object);
	}

	/**
	 * 用户汇总报表查询条件拼凑
	 */
	private DsReportExample generateSearchParam(Map<String, Object> paramMap) throws Exception {
		try {
			logger.info("DsReportExample generateSearchParam start");
			DsReportExample m_example = new DsReportExample();
			Criteria m_criteria = m_example.createCriteria();

			m_criteria.andSiteIdEqualTo(Integer.valueOf(paramMap.get("siteId").toString()));

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

			String startTime = "";
			if (paramMap.containsKey("startTime")) {
				startTime = paramMap.get("startTime").toString();
			} else {
				startTime = "00:00:00";
			}

			m_criteria.andBetTimeGreaterThanOrEqualTo(
					format.parse(paramMap.get("betTimeBegin").toString() + " " + startTime));

			String endTime = "";
			if (paramMap.containsKey("endTime")) {
				endTime = paramMap.get("endTime").toString();
			} else {
				endTime = "23:59:59";
			}
			m_criteria.andBetTimeLessThanOrEqualTo(format.parse(paramMap.get("betTimeEnd").toString() + " " + endTime));

			if (paramMap.containsKey("gameKind") && StringUtils.isNotBlank(paramMap.get("gameKind").toString())) {
				m_criteria.andGameKindEqualTo(Integer.valueOf(paramMap.get("gameKind").toString()));
			}
			if (paramMap.containsKey("gameType") && StringUtils.isNotBlank(paramMap.get("gameType").toString())) {
				m_criteria.andGameTypeEqualTo(Integer.valueOf(paramMap.get("gameType").toString()));
			}
			if (paramMap.containsKey("liveId") && StringUtils.isNotBlank(paramMap.get("liveId").toString())) {
				m_criteria.andLiveIdEqualTo(Byte.valueOf(paramMap.get("liveId").toString()));
			}

			if (paramMap.containsKey("username") && StringUtils.isNotBlank(paramMap.get("username").toString())) {
				List<String> listUsername = new ArrayList<String>();
				String username = paramMap.get("username").toString();

				if (username.indexOf(" ") > 0) {
					String[] str = username.split(" ");
					if (str.length > 0) {
						for (String s : str) {
							if (StringUtils.isNotBlank(s)) {
								listUsername.add(s);
							}
						}
					}
				} else if (username.indexOf(",") > 0) {
					String[] str = username.split(",");
					if (str.length > 0) {
						for (String s : str) {
							if (StringUtils.isNotBlank(s)) {
								listUsername.add(s);
							}
						}
					}

				} else {
					listUsername.add(username);
				}

				if (paramMap.containsKey("agentLevel")
						&& StringUtils.isNotBlank(paramMap.get("agentLevel").toString())) {
					String agentLevel = paramMap.get("agentLevel").toString().toLowerCase();
					m_example.setAgentLevel(agentLevel);
					if (agentLevel.equals("superior")) {
						m_criteria.andSuperiorIn(listUsername);
					} else if (agentLevel.equals("corprator")) {
						m_criteria.andCorpratorIn(listUsername);
					} else if (agentLevel.equals("world")) {
						m_criteria.andWorldIn(listUsername);
					} else if (agentLevel.equals("agent")) {
						m_criteria.andAgentsIn(listUsername);
					} else if (agentLevel.equals("member")) {
						m_criteria.andUsernameIn(listUsername);
					}
				} else {
					m_criteria.andUsernameIn(listUsername);
				}
			}

			if (paramMap.containsKey("defValidamount")
					&& StringUtils.isNotBlank(paramMap.get("defValidamount").toString())) {
				m_example.setDefValidamount(new BigDecimal(paramMap.get("defValidamount").toString()));
			} else {
				m_example.setDefValidamount(new BigDecimal("0.1"));
			}

			Integer page = 1;
			Integer pageLimit = CommonUtils.pageLimit;
			if (paramMap.containsKey("page") && StringUtils.isNotBlank(paramMap.get("page").toString())) {
				page = Integer.valueOf(paramMap.get("page").toString());
			}
			if (paramMap.containsKey("pageLimit") && StringUtils.isNotBlank(paramMap.get("pageLimit").toString())) {
				pageLimit = Integer.valueOf(paramMap.get("pageLimit").toString());
			}
			m_example.setPage((page - 1) * pageLimit);
			m_example.setPageLimit(pageLimit);
			logger.info("DsReportExample generateSearchParam end");
			return m_example;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
		}
	}

	private String writeUnicodeEscape(char c) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append('\\').append('u').append(HEX_CHARS[(c >> 12) & 0xF]).append(HEX_CHARS[(c >> 8) & 0xF])
				.append(HEX_CHARS[(c >> 4) & 0xF]).append(HEX_CHARS[c & 0xF]);
		return sb.toString();
	}

	private final char[] HEX_CHARS = "0123456789ABCDEF".toCharArray();
	private final int[] ESCAPE_CODES = CharTypes.get7BitOutputEscapes();

	private String tranferUnicode(String str) throws IOException {
		StringBuilder strReturn = new StringBuilder();
		strReturn.append('"');
		for (char c : str.toCharArray()) {
			if (c >= 0x80) {
				strReturn.append(this.writeUnicodeEscape(c));// 为所有非ASCII字符生成转义的unicode字符
			} else {
				// 为ASCII字符中前128个字符使用转义的unicode字符
				int code = (c < ESCAPE_CODES.length ? ESCAPE_CODES[c] : 0);
				if (code == 0) {
					strReturn.append(c);
				} else if (code < 0) {
					strReturn.append(this.writeUnicodeEscape((char) (-code - 1)));// 通用转义字符
				} else {
					strReturn.append("\\").append((char) (-code - 1));// 短转义字符
																		// (\n
																		// \t
																		// ...)
				}
			}
		}
		strReturn.append('"');
		return strReturn.toString();
	}

	/**
	 * 返水报表 输入条件：返水优惠设定值、日期区间、层级、用户名称、网站名称 输出：根据用户名称统计每个游戏大类的返水金额
	 * 
	 * @param result2
	 * @param percentMap2
	 * @param orderGameMap
	 * @param orderSportMap
	 * @param request
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public void waterReportNew(Map<String, Object> paramMap, Map<String, Object> orderMap,
			Map<String, Object> orderLiveMap, Map<String, Object> orderHongkongMap, Map<String, Object> orderLottoMap,
			Map<String, Object> orderSportMap, Map<String, Object> orderGameMap, Map<String, Object> percentMap,
			Map<String, Object> result) throws Exception {
		try {
			logger.info("返水报表waterReport start");
			long start = System.currentTimeMillis();
			String siteId = "";
			StringBuilder strCondition = new StringBuilder();
			if (paramMap.containsKey("siteId")) {
				siteId = paramMap.get("siteId").toString();
				strCondition.append("siteId|").append(siteId).append(";");
			}
			String key = "";
			if (paramMap.containsKey("key")) {
				key = paramMap.get("key").toString();
			}
			String betTimeBegin = "";
			if (paramMap.containsKey("betTimeBegin")) {
				betTimeBegin = paramMap.get("betTimeBegin").toString();
				strCondition.append("betTimeBegin|").append(betTimeBegin).append(";");
			}
			String betTimeEnd = "";
			if (paramMap.containsKey("betTimeEnd")) {
				betTimeEnd = paramMap.get("betTimeEnd").toString();
				strCondition.append("betTimeEnd|").append(betTimeEnd).append(";");
			}
			String username = "";
			if (paramMap.containsKey("username")) {
				username = paramMap.get("username").toString();
				strCondition.append("username|").append(username).append(";");
			}
			String agentLevel = "";
			if (paramMap.containsKey("agentLevel")) {
				agentLevel = paramMap.get("agentLevel").toString();
				strCondition.append("agentLevel|").append(agentLevel).append(";");
			}
			String waterType = "";
			if (paramMap.containsKey("waterType")) {
				waterType = paramMap.get("waterType").toString();
				strCondition.append("waterType|").append(waterType).append(";");
			}
			String returnOrder = "";
			if (paramMap.containsKey("return_order")) {
				returnOrder = paramMap.get("return_order").toString();
			}
			String returnPercent = "";
			if (paramMap.containsKey("return_percent")) {
				returnPercent = paramMap.get("return_percent").toString();
			}

			if (StringUtils.isBlank(key)) {
				result.put("returnCode", 910002);
				result.put("returnMsg", "key is null");
				logger.info("key is null");
				return;
			}

			if (StringUtils.isBlank(siteId)) {
				result.put("returnCode", 910003);
				result.put("returnMsg", "siteId is null");
				logger.info("siteId is null");
				return;
			}
			if (StringUtils.isBlank(betTimeBegin)) {
				result.put("returnCode", 910004);
				result.put("returnMsg", "betTimeBegin is null");
				logger.info("betTimeBegin is null");
				return;
			}
			if (StringUtils.isBlank(betTimeEnd)) {
				result.put("returnCode", 910005);
				result.put("returnMsg", "betTimeEnd is null");
				logger.info("betTimeEnd is null");
				return;
			}
			if (StringUtils.isNotBlank(agentLevel) && StringUtils.isBlank(username)) {
				result.put("returnCode", 910006);
				result.put("returnMsg", "username is null");
				logger.info("username is null");
				return;
			}
			/*
			 * if (StringUtils.isBlank(agentLevel)) { result.put("returnCode",
			 * 910010); result.put("returnMsg", "agentLevel is null");
			 * logger.info("agentLevel is null"); return; }
			 */
			if (StringUtils.isBlank(waterType)) {
				result.put("returnCode", 9100011);
				result.put("returnMsg", "waterType is null");
				logger.info("waterType is null");
				return;
			}
			if (orderMap.size() == 0) {
				result.put("returnCode", 9100012);
				result.put("returnMsg", "return_order is null");
				logger.info("return_order is null");
				return;
			}
			if (percentMap.size() == 0) {
				result.put("returnCode", 9100013);
				result.put("returnMsg", "return_percent is null");
				logger.info("return_percent is null");
				return;
			}

			String param = key.substring(5);
			String str = param.substring(0, param.length() - 6);
			String md5 = siteId + betTimeBegin + betTimeEnd + username + agentLevel + waterType;
			logger.info("md5 str:" + md5);
			// 取缓存数据
			String cacheName = "waterReport:" + md5 + returnOrder + returnPercent;
			Map<String, Object> cacheData = this.getCacheData(cacheName);
			if (cacheData.get("code").equals("1")) {
				logger.info("从缓存中读取数据");
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", cacheData.get("cacheData").toString());
				logger.info("total waterReport time : " + (System.currentTimeMillis() - start));
				return;
			}
			logger.info("md5:" + toMD5(md5));
			if (toMD5(md5).equals(str) || getMd5Valid().equals("0")) {
				/*
				 * DsReportExample m_example =
				 * this.generateSearchParam(paramMap); List<DsWaterTotal>
				 * dsWaterTotal = this.dsReportMapper.waterReport(m_example);
				 */
				// strCondition =
				// siteId|1;betTimeBegin|2015-08-13;betTimeEnd|2015-09-02;username|adm000;agentLevel|super;waterType|0;
				logger.info("strCondition:" + strCondition.toString());
				List<DsWaterTotalNew> dsWaterTotal = this.dsReportMapper.waterReportTotalNew(strCondition.toString());
				//特殊游戏返水
				Map<String,Object> all_map=reporWaterService.getWaterInfo(Integer.valueOf(siteId), betTimeBegin, betTimeEnd, paramMap.get("game").toString());
				Map<String,GameWaterVo> gameWaterMap=(Map<String,GameWaterVo>)all_map.get("water_map");
				Map<String,JSONArray> json_map=(Map<String,JSONArray>)all_map.get("jsonMap");
				if (!dsWaterTotal.isEmpty()) {
					//
					List orderList = new ArrayList(orderMap.entrySet());// 5大类
					// orderList = [3=lotto, 2=hongkong, 1=live, 7=bb_3d,
					// 6=game, 5=bb_sport, 4=ball]
					// 将HASHMAP中的数据排序
					Collections.sort(orderList, new Comparator() {
						public int compare(Object arg1, Object arg2) {
							Map.Entry obj1 = (Map.Entry) arg1;
							Map.Entry obj2 = (Map.Entry) arg2;
							return (obj1.getKey()).toString().compareTo((String) obj2.getKey());
						}
					});
					// orderList = [1=live, 2=hongkong, 3=lotto, 4=ball,
					// 5=bb_sport, 6=game, 7=bb_3d]

					List orderLiveList = new ArrayList(orderLiveMap.entrySet());
					// orderLiveList = [3=live_other, 2=live_bb, 1=live_ds]
					Collections.sort(orderLiveList, new Comparator() {
						public int compare(Object arg1, Object arg2) {
							Map.Entry obj1 = (Map.Entry) arg1;
							Map.Entry obj2 = (Map.Entry) arg2;
							return (obj1.getKey()).toString().compareTo((String) obj2.getKey());
						}
					});
					// orderLiveList = [1=live_ds, 2=live_bb, 3=live_other]

					List percentList = new ArrayList(percentMap.entrySet());// 详细返点
					// percentList = [1={bb_3d=1.3, max_return=999, ball=1,
					// vgold=1, lotto=0.8, live_bb=0.12, hongkong=0.8,
					// bb_sport=0.8, live_ds=0.12, game=1.3, live_other=0.12},
					// 1000={bb_3d=1.8, max_return=1888, ball=1, vgold=1000,
					// lotto=1, live_bb=1.5, hongkong=1, bb_sport=1,
					// live_ds=1.5, game=1.8, live_other=1.5}]
					Collections.sort(percentList, new Comparator() {
						public int compare(Object arg1, Object arg2) {
							Map.Entry obj1 = (Map.Entry) arg1;
							Map.Entry obj2 = (Map.Entry) arg2;
							return (new BigDecimal(Double.valueOf((obj1.getKey()).toString()))
									.compareTo(new BigDecimal(Double.valueOf((obj2.getKey()).toString()))));
						}
					});
					// [1={bb_3d=1.3, max_return=999, ball=1, vgold=1,
					// lotto=0.8, live_bb=0.12, hongkong=0.8, bb_sport=0.8,
					// live_ds=0.12, game=1.3, live_other=0.12},
					// 1000={bb_3d=1.8, max_return=1888, ball=1, vgold=1000,
					// lotto=1, live_bb=1.5, hongkong=1, bb_sport=1,
					// live_ds=1.5, game=1.8, live_other=1.5}]
					if (waterType.equals("0")) {
						BigDecimal maxReturn = new BigDecimal(0);
						// 返点list循环，取出最大反水金额
						for (Iterator iter = percentList.iterator(); iter.hasNext();) {
							Map.Entry entry = (Map.Entry) iter.next();
							Map<String, Object> percentDetailMap = (Map<String, Object>) entry.getValue();
							maxReturn = new BigDecimal(percentDetailMap.get("max_return").toString());
							break;

						}

						for (int i = 0; i < dsWaterTotal.size(); i++) {
							DsWaterTotalNew row = dsWaterTotal.get(i);

							Map<String, Object> calcPencentDetailMap = new HashMap<String, Object>();
							BigDecimal calcGold = new BigDecimal(0);
							// 返点list循环
							for (Iterator iter = percentList.iterator(); iter.hasNext();) {

								Map.Entry entry = (Map.Entry) iter.next();
								// strKey = 1 strKey = 1000 (vgold的值)
								String strKey = (String) entry.getKey();
								Map<String, Object> curPercentDetailMap = (Map<String, Object>) entry.getValue();
								// Map<String,Object> nextPercentDetailMap = new
								// HashMap<String,Object>();
								BigDecimal curGold = new BigDecimal(strKey);
								BigDecimal nextGold = new BigDecimal(0);
								for (Iterator iterGold = percentList.iterator(); iterGold.hasNext();) {
									Map.Entry entryGold = (Map.Entry) iterGold.next();
									if ((new BigDecimal(entryGold.getKey().toString())).compareTo(curGold) > 0) {
										nextGold = new BigDecimal(entryGold.getKey().toString());
										// nextPercentDetailMap =
										// (Map<String,Object>)entryGold.getValue();
										break;
									}
								}

								if ((row.getTotalUncalcValidamount().compareTo(curGold) > 0
										&& row.getTotalUncalcValidamount().compareTo(nextGold) < 0
										&& nextGold.compareTo(new BigDecimal(0)) != 0)) {
									calcPencentDetailMap = curPercentDetailMap;
									calcGold = nextGold;
									break;
								} else if (nextGold.compareTo(new BigDecimal(0)) == 0
										&& row.getTotalUncalcValidamount().compareTo(curGold) > 0) {
									calcPencentDetailMap = curPercentDetailMap;
									calcGold = nextGold;
									break;
								}

							}
							DsWaterTotalNew returnRow = new DsWaterTotalNew();
							for (Entry<String, Object> entryDetail : calcPencentDetailMap.entrySet()) {
								String strkey = entryDetail.getKey();
								BigDecimal vPercent = new BigDecimal(entryDetail.getValue().toString());
								returnRow = this.updateRowNew(row, strkey, vPercent, calcGold,gameWaterMap,json_map);
							}
							if (row.getTotalWater().compareTo(maxReturn) == 1) {
								row.setReturnWater(maxReturn);
							} else {
								row.setReturnWater(row.getTotalWater());
							}
							row.setTotalCalcValidamount(null);
							row.setTotalUncalcValidamount(null);
							row.setLiveBbCalcValidamount(null);
							row.setLiveBbUncalcValidamount(null);
							row.setLiveDsCalcValidamount(null);
							row.setLiveDsUncalcValidamount(null);
							row.setLiveAgCalcValidamount(null);
							row.setLiveAgUncalcValidamount(null);

							row.setDsGameCalcValidamount(null);
							row.setDsgameUncalcValidamount(null);
							row.setBbGameCalcValidamount(null);
							row.setBbgameUncalcValidamount(null);
							row.setAgGameCalcValidamount(null);
							row.setAggameUncalcValidamount(null);
							row.setMgGameCalcValidamount(null);
							row.setMggameUncalcValidamount(null);

							row.setXiaoyuLottoCalcValidamount(null);
							row.setXiaoyuLottoUncalcValidamount(null);
							row.setFenfenLottoCalcValidamount(null);
							row.setFenfenLottoUncalcValidamount(null);

							row.setXiaoyuHongkongCalcValidamount(null);
							row.setXiaoyuHongkongUncalcValidamount(null);
							row.setDsHongkongCalcValidamount(null);
							row.setDsHongkongUncalcValidamount(null);

							row.setBbSportCalcValidamount(null);
							row.setBbSportUncalcValidamount(null);
							row.setH8CalcValidamount(null);
							row.setH8UncalcValidamount(null);

							dsWaterTotal.set(i, returnRow);

							// DsWaterTotal returnRow =
							// this.calcWater(row,orderMap,orderLiveMap,percentMap);
							// dsWaterTotal.set(i, returnRow);
						}
					} else {
						
						// 分层反水
						/******************/
						for (int i = 0; i < dsWaterTotal.size(); i++) {
							DsWaterTotalNew row = dsWaterTotal.get(i);
							DsWaterTotalNew returnRow = this.calcWaterNew(row, orderList, orderLiveList, percentList,gameWaterMap,json_map);
							row.setTotalCalcValidamount(null);
							row.setTotalUncalcValidamount(null);
							row.setLiveBbCalcValidamount(null);
							row.setLiveBbUncalcValidamount(null);
							row.setLiveDsCalcValidamount(null);
							row.setLiveDsUncalcValidamount(null);
							row.setLiveAgCalcValidamount(null);
							row.setLiveAgUncalcValidamount(null);

							row.setDsGameCalcValidamount(null);
							row.setDsgameUncalcValidamount(null);
							row.setBbGameCalcValidamount(null);
							row.setBbgameUncalcValidamount(null);
							row.setAgGameCalcValidamount(null);
							row.setAggameUncalcValidamount(null);
							row.setMgGameCalcValidamount(null);
							row.setMggameUncalcValidamount(null);

							row.setXiaoyuLottoCalcValidamount(null);
							row.setXiaoyuLottoUncalcValidamount(null);
							row.setFenfenLottoCalcValidamount(null);
							row.setFenfenLottoUncalcValidamount(null);

							row.setXiaoyuHongkongCalcValidamount(null);
							row.setXiaoyuHongkongUncalcValidamount(null);
							row.setDsHongkongCalcValidamount(null);
							row.setDsHongkongUncalcValidamount(null);

							row.setBbSportCalcValidamount(null);
							row.setBbSportUncalcValidamount(null);
							row.setH8CalcValidamount(null);
							row.setH8UncalcValidamount(null);
							dsWaterTotal.set(i, returnRow);
						}
						/******************/
					}
				}

				/*
				 * Map<String,Object> mapCondition = new
				 * HashMap<String,Object>(); mapCondition.put("condition",
				 * strCondition.toString()); mapCondition.put("returnOrder",
				 * returnOrder); mapCondition.put("returnPercent",
				 * returnPercent); List<DsWaterTotal> dsWaterTotal =
				 * this.dsReportMapper.waterReport(mapCondition);
				 */
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", this.convertToJson(dsWaterTotal));
				java.util.Date nowdate = new java.util.Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
				Date betTime = format.parse(betTimeEnd + " 23:59:59");
				Calendar cal = Calendar.getInstance();
				cal.setTime(nowdate);
				cal.add(Calendar.DATE, -1);

				Calendar cal1 = Calendar.getInstance();
				cal1.setTime(betTime);
				cal1.add(Calendar.DATE, 1);

				if (betTime.before(cal.getTime())
						|| (cal1.get(Calendar.DATE) == nowdate.getDate() && nowdate.getHours() > 4)) {
					if (isUseCache.equals("1")) {
						logger.info("写入缓存start");
						RedisUtils redisUtils = new RedisUtils();
						redisUtils.redisTemplate = this.redisTemplate;
						redisUtils.set(cacheName, this.convertToJson(dsWaterTotal));
						logger.info("写入缓存end");
					}
				} else {
					this.setCacheData(cacheName, this.convertToJson(dsWaterTotal));
				}
			} else {
				result.put("returnCode", 910008);
				result.put("returnMsg", "Key valid error");
				logger.info("Key valid error");
				return;
			}
			logger.info("total waterReport time : " + (System.currentTimeMillis() - start));
			logger.info("返水报表waterReport end");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
			/*
			 * result.put("returnCode", 910001); result.put("returnMsg",
			 * "System error");
			 */
		}
	}

	/**
	 * 返水报表 输入条件：返水优惠设定值、日期区间、层级、用户名称、网站名称 输出：根据用户名称统计每个游戏大类的返水金额
	 * 
	 * @param result2
	 * @param percentMap2
	 * @param orderGameMap
	 * @param orderSportMap
	 * @param request
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public void waterReportNewByPage(Map<String, Object> paramMap, Map<String, Object> orderMap,
			Map<String, Object> orderLiveMap, Map<String, Object> orderHongkongMap, Map<String, Object> orderLottoMap,
			Map<String, Object> orderSportMap, Map<String, Object> orderGameMap, Map<String, Object> percentMap,
			Map<String, Object> result, int page, int pageLimit) throws Exception {
		try {
			logger.info("返水报表waterReport start");
			long start = System.currentTimeMillis();
			String siteId = "";
			StringBuilder strCondition = new StringBuilder();
			if (paramMap.containsKey("siteId")) {
				siteId = paramMap.get("siteId").toString();
				strCondition.append("siteId|").append(siteId).append(";");
			}
			String key = "";
			if (paramMap.containsKey("key")) {
				key = paramMap.get("key").toString();
			}
			String betTimeBegin = "";
			if (paramMap.containsKey("betTimeBegin")) {
				betTimeBegin = paramMap.get("betTimeBegin").toString();
				strCondition.append("betTimeBegin|").append(betTimeBegin).append(";");
			}
			String betTimeEnd = "";
			if (paramMap.containsKey("betTimeEnd")) {
				betTimeEnd = paramMap.get("betTimeEnd").toString();
				strCondition.append("betTimeEnd|").append(betTimeEnd).append(";");
			}
			String username = "";
			if (paramMap.containsKey("username")) {
				username = paramMap.get("username").toString();
				strCondition.append("username|").append(username).append(";");
			}
			String agentLevel = "";
			if (paramMap.containsKey("agentLevel")) {
				agentLevel = paramMap.get("agentLevel").toString();
				strCondition.append("agentLevel|").append(agentLevel).append(";");
			}
			String waterType = "";
			if (paramMap.containsKey("waterType")) {
				waterType = paramMap.get("waterType").toString();
				strCondition.append("waterType|").append(waterType).append(";");
			}
			strCondition.append("minValidBet|").append(paramMap.get("minValidBet").toString()).append(";");
			
			String returnOrder = "";
			if (paramMap.containsKey("return_order")) {
				returnOrder = paramMap.get("return_order").toString();
			}
			String returnPercent = "";
			if (paramMap.containsKey("return_percent")) {
				returnPercent = paramMap.get("return_percent").toString();
			}

			if (StringUtils.isBlank(key)) {
				result.put("returnCode", 910002);
				result.put("returnMsg", "key is null");
				logger.info("key is null");
				return;
			}

			if (StringUtils.isBlank(siteId)) {
				result.put("returnCode", 910003);
				result.put("returnMsg", "siteId is null");
				logger.info("siteId is null");
				return;
			}
			if (StringUtils.isBlank(betTimeBegin)) {
				result.put("returnCode", 910004);
				result.put("returnMsg", "betTimeBegin is null");
				logger.info("betTimeBegin is null");
				return;
			}
			if (StringUtils.isBlank(betTimeEnd)) {
				result.put("returnCode", 910005);
				result.put("returnMsg", "betTimeEnd is null");
				logger.info("betTimeEnd is null");
				return;
			}
			if (StringUtils.isNotBlank(agentLevel) && StringUtils.isBlank(username)) {
				result.put("returnCode", 910006);
				result.put("returnMsg", "username is null");
				logger.info("username is null");
				return;
			}
			/*
			 * if (StringUtils.isBlank(agentLevel)) { result.put("returnCode",
			 * 910010); result.put("returnMsg", "agentLevel is null");
			 * logger.info("agentLevel is null"); return; }
			 */
			if (StringUtils.isBlank(waterType)) {
				result.put("returnCode", 9100011);
				result.put("returnMsg", "waterType is null");
				logger.info("waterType is null");
				return;
			}
			if (orderMap.size() == 0) {
				result.put("returnCode", 9100012);
				result.put("returnMsg", "return_order is null");
				logger.info("return_order is null");
				return;
			}
			if (percentMap.size() == 0) {
				result.put("returnCode", 9100013);
				result.put("returnMsg", "return_percent is null");
				logger.info("return_percent is null");
				return;
			}

			String param = key.substring(5);
			String str = param.substring(0, param.length() - 6);
			String md5 = siteId + betTimeBegin + betTimeEnd + username + agentLevel + waterType + page + pageLimit;
			logger.info("md5 str:" + md5);
			// 取缓存数据
			String cacheName = "waterReport:" + md5 + returnOrder + returnPercent;
			Map<String, Object> cacheData = this.getCacheData(cacheName);
			if (cacheData.get("code").equals("1")) {
				logger.info("从缓存中读取数据");
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", cacheData.get("cacheData").toString());
				result.put("total", cacheData.get("total") + "");
				logger.info("total waterReport time : " + (System.currentTimeMillis() - start));
				return;
			}
			logger.info("md5:" + toMD5(md5));
			if (1==1) {
				/*
				 * DsReportExample m_example =
				 * this.generateSearchParam(paramMap); List<DsWaterTotal>
				 * dsWaterTotal = this.dsReportMapper.waterReport(m_example);
				 */
				// strCondition =
				// siteId|1;betTimeBegin|2015-08-13;betTimeEnd|2015-09-02;username|adm000;agentLevel|super;waterType|0;
				logger.info("strCondition:" + strCondition.toString());// strCondition.toString()
				Map<String, Object> pMap = new HashMap<String, Object>();
				pMap.put("condition", strCondition.toString());
				pMap.put("startIndex", page);
				pMap.put("recordCount", pageLimit);
				List<DsWaterTotalNew> dsWaterTotal = this.dsReportMapper.waterReportTotalNewByPage(pMap);
				//特殊游戏返水
				Map<String,Object> all_map=reporWaterService.getWaterInfo(Integer.valueOf(siteId), betTimeBegin, betTimeEnd, paramMap.get("game").toString());
				Map<String,GameWaterVo> gameWaterMap=(Map<String,GameWaterVo>)all_map.get("water_map");
				Map<String,JSONArray> json_map=(Map<String,JSONArray>)all_map.get("jsonMap");

				if (!dsWaterTotal.isEmpty()) {
					//
					List orderList = new ArrayList(orderMap.entrySet());// 5大类
					// orderList = [3=lotto, 2=hongkong, 1=live, 7=bb_3d,
					// 6=game, 5=bb_sport, 4=ball]
					// 将HASHMAP中的数据排序
					Collections.sort(orderList, new Comparator() {
						public int compare(Object arg1, Object arg2) {
							Map.Entry obj1 = (Map.Entry) arg1;
							Map.Entry obj2 = (Map.Entry) arg2;
							return (obj1.getKey()).toString().compareTo((String) obj2.getKey());
						}
					});
					// orderList = [1=live, 2=hongkong, 3=lotto, 4=ball,
					// 5=bb_sport, 6=game, 7=bb_3d]

					List orderLiveList = new ArrayList(orderLiveMap.entrySet());
					// orderLiveList = [3=live_other, 2=live_bb, 1=live_ds]
					Collections.sort(orderLiveList, new Comparator() {
						public int compare(Object arg1, Object arg2) {
							Map.Entry obj1 = (Map.Entry) arg1;
							Map.Entry obj2 = (Map.Entry) arg2;
							return (obj1.getKey()).toString().compareTo((String) obj2.getKey());
						}
					});
					// orderLiveList = [1=live_ds, 2=live_bb, 3=live_other]

					List percentList = new ArrayList(percentMap.entrySet());// 详细返点
					// percentList = [1={bb_3d=1.3, max_return=999, ball=1,
					// vgold=1, lotto=0.8, live_bb=0.12, hongkong=0.8,
					// bb_sport=0.8, live_ds=0.12, game=1.3, live_other=0.12},
					// 1000={bb_3d=1.8, max_return=1888, ball=1, vgold=1000,
					// lotto=1, live_bb=1.5, hongkong=1, bb_sport=1,
					// live_ds=1.5, game=1.8, live_other=1.5}]
					Collections.sort(percentList, new Comparator() {
						public int compare(Object arg1, Object arg2) {
							Map.Entry obj1 = (Map.Entry) arg1;
							Map.Entry obj2 = (Map.Entry) arg2;
							return (new BigDecimal(Double.valueOf((obj1.getKey()).toString()))
									.compareTo(new BigDecimal(Double.valueOf((obj2.getKey()).toString()))));
						}
					});
					// [1={bb_3d=1.3, max_return=999, ball=1, vgold=1,
					// lotto=0.8, live_bb=0.12, hongkong=0.8, bb_sport=0.8,
					// live_ds=0.12, game=1.3, live_other=0.12},
					// 1000={bb_3d=1.8, max_return=1888, ball=1, vgold=1000,
					// lotto=1, live_bb=1.5, hongkong=1, bb_sport=1,
					// live_ds=1.5, game=1.8, live_other=1.5}]
					if (waterType.equals("0")) {
						BigDecimal maxReturn = new BigDecimal(0);
						Map<String, BigDecimal> maxReturnMap = new HashMap<String, BigDecimal>();

						// 返点list循环，取出最大反水金额
						for (Iterator iter = percentList.iterator(); iter.hasNext();) {
							Map.Entry entry = (Map.Entry) iter.next();
							Map<String, Object> percentDetailMap = (Map<String, Object>) entry.getValue();
							// maxReturn = new
							// BigDecimal(percentDetailMap.get("max_return").toString());

							maxReturnMap.put(new BigDecimal(entry.getKey().toString()).toPlainString(),
									new BigDecimal(percentDetailMap.get("max_return").toString()));
							// break;

						}

						for (int i = 0; i < dsWaterTotal.size(); i++) {
							DsWaterTotalNew row = dsWaterTotal.get(i);

							Map<String, Object> calcPencentDetailMap = new HashMap<String, Object>();
							BigDecimal calcGold = new BigDecimal(0);
							// 返点list循环
							for (Iterator iter = percentList.iterator(); iter.hasNext();) {

								Map.Entry entry = (Map.Entry) iter.next();
								// strKey = 1 strKey = 1000 (vgold的值)
								String strKey = (String) entry.getKey();
								Map<String, Object> curPercentDetailMap = (Map<String, Object>) entry.getValue();
								// Map<String,Object> nextPercentDetailMap = new
								// HashMap<String,Object>();
								BigDecimal curGold = new BigDecimal(strKey);
								BigDecimal nextGold = new BigDecimal(0);
								for (Iterator iterGold = percentList.iterator(); iterGold.hasNext();) {
									Map.Entry entryGold = (Map.Entry) iterGold.next();
									if ((new BigDecimal(entryGold.getKey().toString())).compareTo(curGold) > 0) {
										nextGold = new BigDecimal(entryGold.getKey().toString());
										// nextPercentDetailMap =
										// (Map<String,Object>)entryGold.getValue();
										break;
									}
								}

								if ((row.getTotalUncalcValidamount().compareTo(curGold) >= 0
										&& row.getTotalUncalcValidamount().compareTo(nextGold) < 0
										&& nextGold.compareTo(new BigDecimal(0)) != 0)) {
									calcPencentDetailMap = curPercentDetailMap;
									calcGold = nextGold;
									maxReturn = maxReturnMap.get(curGold.toPlainString());
									break;
								} else if (nextGold.compareTo(new BigDecimal(0)) == 0
										&& row.getTotalUncalcValidamount().compareTo(curGold) >= 0) {
									calcPencentDetailMap = curPercentDetailMap;
									calcGold = nextGold;
									maxReturn = maxReturnMap.get(curGold.toPlainString());
									break;
								}

							}
							// 开始计算每种游戏的的返水，比如BBIN体育
							DsWaterTotalNew returnRow = new DsWaterTotalNew();
							for (Entry<String, Object> entryDetail : calcPencentDetailMap.entrySet()) {
								String strkey = entryDetail.getKey();
//								System.out.println(">>>>>>>>>>>>>>"+entryDetail.getValue().toString());
								BigDecimal vPercent = new BigDecimal(entryDetail.getValue().toString());
								/********************************/
								returnRow = this.updateRowNew(row, strkey, vPercent, calcGold,gameWaterMap,json_map);
								/********************************/
							}
							// 判读最大返水金额
							if (row.getTotalWater().compareTo(maxReturn) == 1) {
								row.setReturnWater(maxReturn);
							} else {
								row.setReturnWater(row.getTotalWater());
							}
							row.setTotalCalcValidamount(null);
							row.setTotalUncalcValidamount(null);
							row.setLiveBbCalcValidamount(null);
							row.setLiveBbUncalcValidamount(null);
							row.setLiveDsCalcValidamount(null);
							row.setLiveDsUncalcValidamount(null);
							row.setLiveAgCalcValidamount(null);
							row.setLiveAgUncalcValidamount(null);
							row.setLiveSgsCalcValidamount(null);
							row.setLiveSgsUncalcValidamount(null);
							row.setLiveKKWCalcValidamount(null);
							row.setLiveKKWUncalcValidamount(null);

							row.setDsGameCalcValidamount(null);
							row.setDsgameUncalcValidamount(null);
							row.setBbGameCalcValidamount(null);
							row.setBbgameUncalcValidamount(null);
							row.setAgGameCalcValidamount(null);
							row.setAggameUncalcValidamount(null);
							row.setSgsGameCalcValidamount(null);
							row.setSgsGameUncalcValidamount(null);

							row.setXiaoyuLottoCalcValidamount(null);
							row.setXiaoyuLottoUncalcValidamount(null);
							row.setFenfenLottoCalcValidamount(null);
							row.setFenfenLottoUncalcValidamount(null);
							row.setChuantongLottoCalcValidamount(null);
							row.setChuantongLottoUncalcValidamount(null);
							row.setXingyunLottoCalcValidamount(null);
							row.setXingyunLottoUncalcValidamount(null);
							row.setXiaoyuHongkongCalcValidamount(null);
							row.setXiaoyuHongkongUncalcValidamount(null);
							row.setDsHongkongCalcValidamount(null);
							row.setDsHongkongUncalcValidamount(null);

							row.setBbSportCalcValidamount(null);
							row.setBbSportUncalcValidamount(null);
							row.setH8CalcValidamount(null);
							row.setH8UncalcValidamount(null);

							dsWaterTotal.set(i, returnRow);

							// DsWaterTotal returnRow =
							// this.calcWater(row,orderMap,orderLiveMap,percentMap);
							// dsWaterTotal.set(i, returnRow);
						}
					} else {
						// 分层反水
						/******************/
						for (int i = 0; i < dsWaterTotal.size(); i++) {
							DsWaterTotalNew row = dsWaterTotal.get(i);
							DsWaterTotalNew returnRow = this.calcWaterNew(row, orderList, orderLiveList, percentList,gameWaterMap,json_map);
							row.setTotalCalcValidamount(null);
							row.setTotalUncalcValidamount(null);
							row.setLiveBbCalcValidamount(null);
							row.setLiveBbUncalcValidamount(null);
							row.setLiveDsCalcValidamount(null);
							row.setLiveDsUncalcValidamount(null);
							row.setLiveAgCalcValidamount(null);
							row.setLiveAgUncalcValidamount(null);
							row.setLiveSgsCalcValidamount(null);
							row.setLiveSgsUncalcValidamount(null);
							row.setLiveKKWCalcValidamount(null);
							row.setLiveKKWUncalcValidamount(null);

							row.setDsGameCalcValidamount(null);
							row.setDsgameUncalcValidamount(null);
							row.setBbGameCalcValidamount(null);
							row.setBbgameUncalcValidamount(null);
							row.setAgGameCalcValidamount(null);
							row.setAggameUncalcValidamount(null);
							row.setSgsGameCalcValidamount(null);
							row.setSgsGameUncalcValidamount(null);

							row.setXiaoyuLottoCalcValidamount(null);
							row.setXiaoyuLottoUncalcValidamount(null);
							row.setFenfenLottoCalcValidamount(null);
							row.setFenfenLottoUncalcValidamount(null);
							row.setChuantongLottoCalcValidamount(null);
							row.setChuantongLottoUncalcValidamount(null);

							row.setXiaoyuHongkongCalcValidamount(null);
							row.setXiaoyuHongkongUncalcValidamount(null);
							row.setDsHongkongCalcValidamount(null);
							row.setDsHongkongUncalcValidamount(null);

							row.setBbSportCalcValidamount(null);
							row.setBbSportUncalcValidamount(null);
							row.setH8CalcValidamount(null);
							row.setH8UncalcValidamount(null);
							dsWaterTotal.set(i, returnRow);
						}
						/******************/
					}
				}

				/*
				 * Map<String,Object> mapCondition = new
				 * HashMap<String,Object>(); mapCondition.put("condition",
				 * strCondition.toString()); mapCondition.put("returnOrder",
				 * returnOrder); mapCondition.put("returnPercent",
				 * returnPercent); List<DsWaterTotal> dsWaterTotal =
				 * this.dsReportMapper.waterReport(mapCondition);
				 */
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", this.convertToJson(dsWaterTotal));
				result.put("total", pMap.get("totalCount") + "");
				java.util.Date nowdate = new java.util.Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
				Date betTime = format.parse(betTimeEnd + " 23:59:59");
				Calendar cal = Calendar.getInstance();
				cal.setTime(nowdate);
				cal.add(Calendar.DATE, -1);

				Calendar cal1 = Calendar.getInstance();
				cal1.setTime(betTime);
				cal1.add(Calendar.DATE, 1);

				if (betTime.before(cal.getTime())
						|| (cal1.get(Calendar.DATE) == nowdate.getDate() && nowdate.getHours() > 4)) {
					if (isUseCache.equals("1")) {
						logger.info("写入缓存start");
						RedisUtils redisUtils = new RedisUtils();
						redisUtils.redisTemplate = this.redisTemplate;
						redisUtils.set(cacheName, this.convertToJson(dsWaterTotal));
						logger.info("写入缓存end");
					}
				} else {
					this.setCacheData(cacheName, this.convertToJson(dsWaterTotal));
				}
			} else {
				result.put("returnCode", 910008);
				result.put("returnMsg", "Key valid error");
				logger.info("Key valid error");
				return;
			}
			logger.info("total waterReport time : " + (System.currentTimeMillis() - start));
			logger.info("返水报表waterReport end");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
			/*
			 * result.put("returnCode", 910001); result.put("returnMsg",
			 * "System error");
			 */
		}
	}

	private DsWaterTotalNew updateRowNew(DsWaterTotalNew row, String pencentName, BigDecimal vPercent,
			BigDecimal nextGold,Map<String,GameWaterVo> gameWaterMap,Map<String,JSONArray> json_map) throws Exception {
		try {
			BigDecimal tempCalcAmount = new BigDecimal(0);
			BigDecimal nowWater=new BigDecimal(0);
			if (pencentName.equals("live_ds")) {
				if (row.getLiveDsUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getLiveDsUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				row.setLiveDsWater(
						row.getLiveDsWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
								.setScale(2, RoundingMode.HALF_UP));
				row.setLiveDsCalcValidamount(row.getLiveDsCalcValidamount().add(tempCalcAmount));
				row.setLiveDsUncalcValidamount(row.getLiveDsUncalcValidamount().subtract(tempCalcAmount));
				row.setLiveWater(row.getLiveWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
						.setScale(2, RoundingMode.HALF_UP));
				nowWater=row.getLiveDsWater();
			} else if (pencentName.equals("live_kkwds")) {
				if (row.getLiveKKWUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getLiveKKWUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				row.setLiveKKWWater(
						row.getLiveKKWWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
								.setScale(2, RoundingMode.HALF_UP));
				row.setLiveKKWCalcValidamount(row.getLiveKKWCalcValidamount().add(tempCalcAmount));
				row.setLiveKKWUncalcValidamount(row.getLiveKKWUncalcValidamount().subtract(tempCalcAmount));
				row.setLiveWater(row.getLiveWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
						.setScale(2, RoundingMode.HALF_UP));
				nowWater=row.getLiveKKWWater();
			} else if(pencentName.equals("live_lmg")){
				if (row.getLiveLmgUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getLiveLmgUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				row.setLiveLmgWater(
						row.getLiveLmgWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
								.setScale(2, RoundingMode.HALF_UP));
				row.setLiveLmgCalcValidamount(row.getLiveLmgCalcValidamount().add(tempCalcAmount));
				row.setLiveLmgUncalcValidamount(row.getLiveLmgUncalcValidamount().subtract(tempCalcAmount));
				row.setLiveWater(row.getLiveWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
						.setScale(2, RoundingMode.HALF_UP));
				nowWater=row.getLiveLmgWater();
			} else if (pencentName.equals("live_bb")) {
				if (row.getLiveBbUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getLiveBbUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				row.setLiveBbWater(
						row.getLiveBbWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
								.setScale(2, RoundingMode.HALF_UP));
				row.setLiveBbCalcValidamount(row.getLiveBbCalcValidamount().add(tempCalcAmount));
				row.setLiveBbUncalcValidamount(row.getLiveBbUncalcValidamount().subtract(tempCalcAmount));
				row.setLiveWater(row.getLiveWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
						.setScale(2, RoundingMode.HALF_UP));
				nowWater=row.getLiveBbWater();

				
			} else if (pencentName.equals("live_ag")) {
				if (row.getLiveAgUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getLiveAgUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				row.setLiveAGWater(
						row.getLiveAGWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
								.setScale(2, RoundingMode.HALF_UP));
				row.setLiveAgCalcValidamount(row.getLiveAgCalcValidamount().add(tempCalcAmount));
				row.setLiveAgUncalcValidamount(row.getLiveAgUncalcValidamount().subtract(tempCalcAmount));
				row.setLiveWater(row.getLiveWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
						.setScale(2, RoundingMode.HALF_UP));
				nowWater=row.getLiveAGWater();
			} else if (pencentName.equals("live_og")) {
				if (row.getLiveOgUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getLiveOgUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				row.setLiveOGWater(
						row.getLiveOGWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
								.setScale(2, RoundingMode.HALF_UP));
				row.setLiveOgCalcValidamount(row.getLiveOgCalcValidamount().add(tempCalcAmount));
				row.setLiveOgUncalcValidamount(row.getLiveOgUncalcValidamount().subtract(tempCalcAmount));
				row.setLiveWater(row.getLiveWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
						.setScale(2, RoundingMode.HALF_UP));
				nowWater=row.getLiveOGWater();
			} else if (pencentName.equals("live_sgs")) {
				if (row.getLiveSgsUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getLiveSgsUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				row.setLiveSgsWater(
						row.getLiveSgsWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
								.setScale(2, RoundingMode.HALF_UP));
				row.setLiveSgsCalcValidamount(row.getLiveSgsCalcValidamount().add(tempCalcAmount));
				row.setLiveSgsUncalcValidamount(row.getLiveSgsUncalcValidamount().subtract(tempCalcAmount));
				row.setLiveWater(row.getLiveWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
						.setScale(2, RoundingMode.HALF_UP));
				nowWater=row.getLiveSgsWater();
			} else if (pencentName.equals("hongkong_xiaoyuHongkong")) {
				if (row.getXiaoyuHongkongUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getXiaoyuHongkongUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());

				row.setXiaoyuHongkongWater(
						row.getXiaoyuHongkongWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
								.setScale(2, RoundingMode.HALF_UP));
				row.setXiaoyuHongkongCalcValidamount(row.getXiaoyuHongkongCalcValidamount().add(tempCalcAmount));
				row.setXiaoyuHongkongUncalcValidamount(
						row.getXiaoyuHongkongUncalcValidamount().subtract(tempCalcAmount));
				row.setHongkongWater(
						row.getHongkongWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
								.setScale(2, RoundingMode.HALF_UP));
				nowWater=row.getXiaoyuHongkongWater();
			} else if (pencentName.equals("hongkong_dsHongkong")) {
				if (row.getDsHongkongUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getDsHongkongUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());

				row.setDsHongkongWater(
						row.getDsHongkongWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
								.setScale(2, RoundingMode.HALF_UP));
				row.setDsHongkongCalcValidamount(row.getDsHongkongCalcValidamount().add(tempCalcAmount));
				row.setDsHongkongUncalcValidamount(row.getDsHongkongUncalcValidamount().subtract(tempCalcAmount));
				row.setHongkongWater(
						row.getHongkongWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
								.setScale(2, RoundingMode.HALF_UP));
				nowWater=row.getDsHongkongWater();

			} else if (pencentName.equals("lotto_xiaoyuLotto")) {
				if (row.getXiaoyuLottoUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getXiaoyuLottoUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				row.setXiaoyuLottoWater(
						row.getXiaoyuLottoWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
								.setScale(2, RoundingMode.HALF_UP));
				row.setXiaoyuLottoCalcValidamount(row.getXiaoyuLottoCalcValidamount().add(tempCalcAmount));
				row.setXiaoyuLottoUncalcValidamount(row.getXiaoyuLottoUncalcValidamount().subtract(tempCalcAmount));
				row.setLottoWater(row.getLottoWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
						.setScale(2, RoundingMode.HALF_UP));
				nowWater=row.getXiaoyuLottoWater();
			} else if (pencentName.equals("lotto_fenfenLotto")) {
				if (row.getFenfenLottoUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getFenfenLottoUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				row.setFenfenLottoWater(
						row.getFenfenLottoWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
								.setScale(2, RoundingMode.HALF_UP));
				row.setFenfenLottoCalcValidamount(row.getFenfenLottoCalcValidamount().add(tempCalcAmount));
				row.setFenfenLottoUncalcValidamount(row.getFenfenLottoUncalcValidamount().subtract(tempCalcAmount));
				row.setLottoWater(row.getLottoWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
						.setScale(2, RoundingMode.HALF_UP));
				nowWater=row.getFenfenLottoWater();
			}else if (pencentName.equals("lotto_xingyunLotto")) {
				if (row.getXingyunLottoUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getXingyunLottoUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				row.setXingyunLottoWater(
						row.getXingyunLottoWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
								.setScale(2, RoundingMode.HALF_UP));
				row.setXingyunLottoCalcValidamount(row.getXingyunLottoCalcValidamount().add(tempCalcAmount));
				row.setXingyunLottoUncalcValidamount(row.getXingyunLottoUncalcValidamount().subtract(tempCalcAmount));
				row.setLottoWater(row.getLottoWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
						.setScale(2, RoundingMode.HALF_UP));
				nowWater=row.getXingyunLottoWater();
			} else if (pencentName.equals("lotto_chuantongLotto")) {
				if (row.getChuantongLottoUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getChuantongLottoUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				row.setChuantongLottoWater(
						row.getChuantongLottoWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
								.setScale(2, RoundingMode.HALF_UP));
				row.setChuantongLottoCalcValidamount(row.getChuantongLottoCalcValidamount().add(tempCalcAmount));
				row.setChuantongLottoUncalcValidamount(
						row.getChuantongLottoUncalcValidamount().subtract(tempCalcAmount));
				row.setLottoWater(row.getLottoWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
						.setScale(2, RoundingMode.HALF_UP));
				nowWater=row.getChuantongLottoWater();
			} else if (pencentName.equals("sport_H8Sport")) {
				if (row.getH8UncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getH8UncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				row.setH8Water(row.getH8Water().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
						.setScale(2, RoundingMode.HALF_UP));
				row.setH8CalcValidamount(row.getH8CalcValidamount().add(tempCalcAmount));
				row.setH8UncalcValidamount(row.getH8UncalcValidamount().subtract(tempCalcAmount));
				row.setSportWater(row.getSportWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
						.setScale(2, RoundingMode.HALF_UP));
				nowWater=row.getH8Water();
			} else if (pencentName.equals("sport_BBSport")) {
				if (row.getBbSportUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getBbSportUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				row.setBbSportWater(
						row.getBbSportWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
								.setScale(2, RoundingMode.HALF_UP));
				row.setBbSportCalcValidamount(row.getBbSportCalcValidamount().add(tempCalcAmount));
				row.setBbSportUncalcValidamount(row.getBbSportUncalcValidamount().subtract(tempCalcAmount));
				row.setSportWater(row.getSportWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
						.setScale(2, RoundingMode.HALF_UP));
				nowWater=row.getBbSportWater();
			} else if (pencentName.equals("sport_AGSport")) {
				if (row.getAgSportUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getAgSportUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				row.setAgSportWater(
						row.getAgSportWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
								.setScale(2, RoundingMode.HALF_UP));
				row.setAgSportCalcValidamount(row.getAgSportCalcValidamount().add(tempCalcAmount));
				row.setAgSportUncalcValidamount(row.getAgSportUncalcValidamount().subtract(tempCalcAmount));
				row.setSportWater(row.getSportWater().add(row.getAgSportWater()));
				nowWater=row.getAgSportWater();
			} else if (pencentName.equals("game_dsGame")) {
				if (row.getDsgameUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getDsgameUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				row.setDsGameWater(
						row.getDsGameWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
								.setScale(2, RoundingMode.HALF_UP));
				row.setDsGameCalcValidamount(row.getDsGameCalcValidamount().add(tempCalcAmount));
				row.setDsgameUncalcValidamount(row.getDsgameUncalcValidamount().subtract(tempCalcAmount));
				row.setGameWater(row.getGameWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
						.setScale(2, RoundingMode.HALF_UP));
				nowWater=row.getDsGameWater();
			} else if (pencentName.equals("game_BBGame")) {
				if (row.getBbgameUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getBbgameUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				
				row.setBbGameCalcValidamount(row.getBbGameCalcValidamount().add(tempCalcAmount));
				row.setBbgameUncalcValidamount(row.getBbgameUncalcValidamount().subtract(tempCalcAmount));
				
				//返水计算
				String user_name=row.getUsername();
				if(null !=gameWaterMap && gameWaterMap.containsKey("5_"+user_name)){//特殊游戏返水+本身返水
					GameWaterVo v=gameWaterMap.get("5_"+user_name);
					//-特殊下注*返点/100
					BigDecimal base_water=(tempCalcAmount.subtract(v.getValidamount())).multiply(vPercent).divide(new BigDecimal(100));
					row.setBbGameWater(base_water.add(v.getWater_money().multiply(vPercent).divide(new BigDecimal(100)))
									.setScale(2, RoundingMode.HALF_UP));
					row.setGameWater(row.getGameWater().add(row.getBbGameWater())
							.setScale(2, RoundingMode.HALF_UP));
					row.setBbGame_type_list(json_map.get("5_"+user_name).toJSONString());
				}else{
					row.setBbGameWater(
							row.getBbGameWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
									.setScale(2, RoundingMode.HALF_UP));
					
					row.setGameWater(row.getGameWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
							.setScale(2, RoundingMode.HALF_UP));
				}
				nowWater=row.getBbGameWater();
			} else if (pencentName.equals("game_AgGame")) {
				if (row.getAggameUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getAggameUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				
				row.setAgGameCalcValidamount(row.getAgGameCalcValidamount().add(tempCalcAmount));
				row.setAggameUncalcValidamount(row.getAggameUncalcValidamount().subtract(tempCalcAmount));
				
				//返水计算
				String user_name=row.getUsername();
				if(null !=gameWaterMap && gameWaterMap.containsKey("22_"+user_name)){//特殊游戏返水+本身返水
					GameWaterVo v=gameWaterMap.get("22_"+user_name);
					//-特殊下注*返点/100
					BigDecimal base_water=(tempCalcAmount.subtract(v.getValidamount())).multiply(vPercent).divide(new BigDecimal(100));
					row.setAgGameWater(base_water.add(v.getWater_money().multiply(vPercent).divide(new BigDecimal(100)))
									.setScale(2, RoundingMode.HALF_UP));
					row.setGameWater(row.getGameWater().add(row.getAgGameWater())
							.setScale(2, RoundingMode.HALF_UP));
					row.setAgGame_type_list(json_map.get("22_"+user_name).toJSONString());
				}else{
					row.setAgGameWater(
							row.getAgGameWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
									.setScale(2, RoundingMode.HALF_UP));
					
					row.setGameWater(row.getGameWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
							.setScale(2, RoundingMode.HALF_UP));
				}
				nowWater=row.getAgGameWater();
				
			} else if (pencentName.equals("game_MGGame")) {// 添加MG的
				if (row.getMggameUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getMggameUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				row.setMgGameCalcValidamount(row.getMgGameCalcValidamount().add(tempCalcAmount));
				row.setMggameUncalcValidamount(row.getMggameUncalcValidamount().subtract(tempCalcAmount));
				
				//返水计算
				String user_name=row.getUsername();
				if(null !=gameWaterMap && gameWaterMap.containsKey("60_"+user_name)){//特殊游戏返水+本身返水
					GameWaterVo v=gameWaterMap.get("60_"+user_name);
					//-特殊下注*返点/100
					BigDecimal base_water=(tempCalcAmount.subtract(v.getValidamount())).multiply(vPercent).divide(new BigDecimal(100));
					row.setMgGameWater(base_water.add(v.getWater_money().multiply(vPercent).divide(new BigDecimal(100)))
									.setScale(2, RoundingMode.HALF_UP));
					row.setGameWater(row.getGameWater().add(row.getMgGameWater())
							.setScale(2, RoundingMode.HALF_UP));
					row.setMgGame_type_list(json_map.get("60_"+user_name).toJSONString());

				}else{
					row.setMgGameWater(
							row.getMgGameWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
									.setScale(2, RoundingMode.HALF_UP));
					
					row.setGameWater(row.getGameWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
							.setScale(2, RoundingMode.HALF_UP));
				}
				nowWater=row.getMgGameWater();
			}else if (pencentName.equals("game_PTGame")) {// 添加PT
				if (row.getPtgameUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getPtgameUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				
				row.setPtGameCalcValidamount(row.getPtGameCalcValidamount().add(tempCalcAmount));
				row.setPtgameUncalcValidamount(row.getPtgameUncalcValidamount().subtract(tempCalcAmount));
				
				//返水计算
				String user_name=row.getUsername();
				if(null !=gameWaterMap && gameWaterMap.containsKey("16_"+user_name)){//特殊游戏返水+本身返水
					GameWaterVo v=gameWaterMap.get("16_"+user_name);
					//PT-特殊下注*返点/100
					BigDecimal base_water=(tempCalcAmount.subtract(v.getValidamount())).multiply(vPercent).divide(new BigDecimal(100));
					row.setPtGameWater(base_water.add(v.getWater_money().multiply(vPercent).divide(new BigDecimal(100)))
									.setScale(2, RoundingMode.HALF_UP));
					row.setGameWater(row.getGameWater().add(row.getPtGameWater())
							.setScale(2, RoundingMode.HALF_UP));
					row.setPtGame_type_list(json_map.get("16_"+user_name).toJSONString());

				}else{
					row.setPtGameWater(
							row.getPtGameWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
									.setScale(2, RoundingMode.HALF_UP));
					
					row.setGameWater(row.getGameWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
							.setScale(2, RoundingMode.HALF_UP));
				}
				nowWater=row.getPtGameWater();
			}else if (pencentName.equals("game_SgsGame")) {// 添加SGS
				if (row.getSgsGameUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getSgsGameUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				
				row.setSgsGameCalcValidamount(row.getSgsGameCalcValidamount().add(tempCalcAmount));
				row.setSgsGameUncalcValidamount(row.getSgsGameUncalcValidamount().subtract(tempCalcAmount));
				
				
				//返水计算
				String user_name=row.getUsername();
				if(null !=gameWaterMap && gameWaterMap.containsKey("96_"+user_name)){//特殊游戏返水+本身返水
					GameWaterVo v=gameWaterMap.get("96_"+user_name);
					//-特殊下注*返点/100
					BigDecimal base_water=(tempCalcAmount.subtract(v.getValidamount())).multiply(vPercent).divide(new BigDecimal(100));
					row.setSgsGameWater(base_water.add(v.getWater_money().multiply(vPercent).divide(new BigDecimal(100)))
									.setScale(2, RoundingMode.HALF_UP));
					row.setGameWater(row.getGameWater().add(row.getSgsGameWater())
							.setScale(2, RoundingMode.HALF_UP));
					row.setSgsGame_type_list(json_map.get("96_"+user_name).toJSONString());

				}else{
					row.setSgsGameWater(
							row.getSgsGameWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
									.setScale(2, RoundingMode.HALF_UP));
					
					row.setGameWater(row.getGameWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
							.setScale(2, RoundingMode.HALF_UP));
				}
				nowWater=row.getSgsGameWater();
			}else if (pencentName.equals("game_PMGGame")) {// 添加PMG的
				if (row.getPmggameUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getPmggameUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				
				row.setPmgGameCalcValidamount(row.getPmgGameCalcValidamount().add(tempCalcAmount));
				row.setPmggameUncalcValidamount(row.getPmggameUncalcValidamount().subtract(tempCalcAmount));
				
				
				//返水计算
				String user_name=row.getUsername();
				if(null !=gameWaterMap && gameWaterMap.containsKey("65_"+user_name)){//特殊游戏返水+本身返水
					GameWaterVo v=gameWaterMap.get("65_"+user_name);
					//-特殊下注*返点/100
					BigDecimal base_water=(tempCalcAmount.subtract(v.getValidamount())).multiply(vPercent).divide(new BigDecimal(100));
					row.setPmgGameWater(base_water.add(v.getWater_money().multiply(vPercent).divide(new BigDecimal(100)))
									.setScale(2, RoundingMode.HALF_UP));
					row.setGameWater(row.getGameWater().add(row.getPmgGameWater())
							.setScale(2, RoundingMode.HALF_UP));
					row.setPmgGame_type_list(json_map.get("65_"+user_name).toJSONString());

				}else{
					row.setPmgGameWater(
							row.getPmgGameWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
									.setScale(2, RoundingMode.HALF_UP));
					
					row.setGameWater(row.getGameWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
							.setScale(2, RoundingMode.HALF_UP));
				}
				nowWater=row.getPmgGameWater();
			}else if (pencentName.equals("chess_kyChess")) {//开元棋牌
				if (row.getKyChessUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getKyChessUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				row.setKyChessWater(
						row.getKyChessWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
								.setScale(2, RoundingMode.HALF_UP));
				row.setKyChessCalcValidamount(row.getKyChessCalcValidamount().add(tempCalcAmount));
				row.setKyChessUncalcValidamount(row.getKyChessUncalcValidamount().subtract(tempCalcAmount));
				row.setChessWater(row.getChessWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
						.setScale(2, RoundingMode.HALF_UP));
				nowWater=row.getKyChessWater();

				
			}
			row.setTotalWater(row.getTotalWater().add(nowWater)
					.setScale(2, RoundingMode.HALF_UP));
			row.setTotalCalcValidamount(row.getTotalCalcValidamount().add(tempCalcAmount).setScale(2));
			row.setTotalUncalcValidamount(
					row.getTotalUncalcValidamount().subtract(tempCalcAmount).setScale(2, RoundingMode.HALF_UP));
			return row;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
		}
	}

	public void waterReport(Map<String, Object> paramMap, Map<String, Object> orderMap,
			Map<String, Object> orderLiveMap, Map<String, Object> percentMap, Map<String, Object> result)
			throws Exception {
		try {
			logger.info("返水报表waterReport start");
			long start = System.currentTimeMillis();
			String siteId = "";
			StringBuilder strCondition = new StringBuilder();
			if (paramMap.containsKey("siteId")) {
				siteId = paramMap.get("siteId").toString();
				strCondition.append("siteId|").append(siteId).append(";");
			}
			String key = "";
			if (paramMap.containsKey("key")) {
				key = paramMap.get("key").toString();
			}
			String betTimeBegin = "";
			if (paramMap.containsKey("betTimeBegin")) {
				betTimeBegin = paramMap.get("betTimeBegin").toString();
				strCondition.append("betTimeBegin|").append(betTimeBegin).append(";");
			}
			String betTimeEnd = "";
			if (paramMap.containsKey("betTimeEnd")) {
				betTimeEnd = paramMap.get("betTimeEnd").toString();
				strCondition.append("betTimeEnd|").append(betTimeEnd).append(";");
			}
			String username = "";
			if (paramMap.containsKey("username")) {
				username = paramMap.get("username").toString();
				strCondition.append("username|").append(username).append(";");
			}
			String agentLevel = "";
			if (paramMap.containsKey("agentLevel")) {
				agentLevel = paramMap.get("agentLevel").toString();
				strCondition.append("agentLevel|").append(agentLevel).append(";");
			}
			String waterType = "";
			if (paramMap.containsKey("waterType")) {
				waterType = paramMap.get("waterType").toString();
				strCondition.append("waterType|").append(waterType).append(";");
			}
			String returnOrder = "";
			if (paramMap.containsKey("return_order")) {
				returnOrder = paramMap.get("return_order").toString();
			}
			String returnPercent = "";
			if (paramMap.containsKey("return_percent")) {
				returnPercent = paramMap.get("return_percent").toString();
			}

			if (StringUtils.isBlank(key)) {
				result.put("returnCode", 910002);
				result.put("returnMsg", "key is null");
				logger.info("key is null");
				return;
			}

			if (StringUtils.isBlank(siteId)) {
				result.put("returnCode", 910003);
				result.put("returnMsg", "siteId is null");
				logger.info("siteId is null");
				return;
			}
			if (StringUtils.isBlank(betTimeBegin)) {
				result.put("returnCode", 910004);
				result.put("returnMsg", "betTimeBegin is null");
				logger.info("betTimeBegin is null");
				return;
			}
			if (StringUtils.isBlank(betTimeEnd)) {
				result.put("returnCode", 910005);
				result.put("returnMsg", "betTimeEnd is null");
				logger.info("betTimeEnd is null");
				return;
			}
			if (StringUtils.isNotBlank(agentLevel) && StringUtils.isBlank(username)) {
				result.put("returnCode", 910006);
				result.put("returnMsg", "username is null");
				logger.info("username is null");
				return;
			}
			/*
			 * if (StringUtils.isBlank(agentLevel)) { result.put("returnCode",
			 * 910010); result.put("returnMsg", "agentLevel is null");
			 * logger.info("agentLevel is null"); return; }
			 */
			if (StringUtils.isBlank(waterType)) {
				result.put("returnCode", 9100011);
				result.put("returnMsg", "waterType is null");
				logger.info("waterType is null");
				return;
			}
			if (orderMap.size() == 0) {
				result.put("returnCode", 9100012);
				result.put("returnMsg", "return_order is null");
				logger.info("return_order is null");
				return;
			}
			if (percentMap.size() == 0) {
				result.put("returnCode", 9100013);
				result.put("returnMsg", "return_percent is null");
				logger.info("return_percent is null");
				return;
			}

			String param = key.substring(5);
			String str = param.substring(0, param.length() - 6);
			String md5 = siteId + betTimeBegin + betTimeEnd + username + agentLevel + waterType;
			logger.info("md5 str:" + md5);
			// 取缓存数据
			String cacheName = "waterReport:" + md5 + returnOrder + returnPercent;
			Map<String, Object> cacheData = this.getCacheData(cacheName);
			if (cacheData.get("code").equals("1")) {
				logger.info("从缓存中读取数据");
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", cacheData.get("cacheData").toString());
				logger.info("total waterReport time : " + (System.currentTimeMillis() - start));
				return;
			}
			logger.info("md5:" + toMD5(md5));
			if (toMD5(md5).equals(str) || getMd5Valid().equals("0")) {
				/*
				 * DsReportExample m_example =
				 * this.generateSearchParam(paramMap); List<DsWaterTotal>
				 * dsWaterTotal = this.dsReportMapper.waterReport(m_example);
				 */
				// strCondition =
				// siteId|1;betTimeBegin|2015-08-13;betTimeEnd|2015-09-02;username|adm000;agentLevel|super;waterType|0;
				List<DsWaterTotal> dsWaterTotal = this.dsReportMapper.waterReportTotal(strCondition.toString());
				if (!dsWaterTotal.isEmpty()) {
					//
					List orderList = new ArrayList(orderMap.entrySet());
					// orderList = [3=lotto, 2=hongkong, 1=live, 7=bb_3d,
					// 6=game, 5=bb_sport, 4=ball]
					// 将HASHMAP中的数据排序
					Collections.sort(orderList, new Comparator() {
						public int compare(Object arg1, Object arg2) {
							Map.Entry obj1 = (Map.Entry) arg1;
							Map.Entry obj2 = (Map.Entry) arg2;
							return (obj1.getKey()).toString().compareTo((String) obj2.getKey());
						}
					});
					// orderList = [1=live, 2=hongkong, 3=lotto, 4=ball,
					// 5=bb_sport, 6=game, 7=bb_3d]

					List orderLiveList = new ArrayList(orderLiveMap.entrySet());
					// orderLiveList = [3=live_other, 2=live_bb, 1=live_ds]
					Collections.sort(orderLiveList, new Comparator() {
						public int compare(Object arg1, Object arg2) {
							Map.Entry obj1 = (Map.Entry) arg1;
							Map.Entry obj2 = (Map.Entry) arg2;
							return (obj1.getKey()).toString().compareTo((String) obj2.getKey());
						}
					});
					// orderLiveList = [1=live_ds, 2=live_bb, 3=live_other]

					List percentList = new ArrayList(percentMap.entrySet());
					// percentList = [1={bb_3d=1.3, max_return=999, ball=1,
					// vgold=1, lotto=0.8, live_bb=0.12, hongkong=0.8,
					// bb_sport=0.8, live_ds=0.12, game=1.3, live_other=0.12},
					// 1000={bb_3d=1.8, max_return=1888, ball=1, vgold=1000,
					// lotto=1, live_bb=1.5, hongkong=1, bb_sport=1,
					// live_ds=1.5, game=1.8, live_other=1.5}]
					Collections.sort(percentList, new Comparator() {
						public int compare(Object arg1, Object arg2) {
							Map.Entry obj1 = (Map.Entry) arg1;
							Map.Entry obj2 = (Map.Entry) arg2;
							return (new BigDecimal(Double.valueOf((obj1.getKey()).toString()))
									.compareTo(new BigDecimal(Double.valueOf((obj2.getKey()).toString()))));
						}
					});
					// [1={bb_3d=1.3, max_return=999, ball=1, vgold=1,
					// lotto=0.8, live_bb=0.12, hongkong=0.8, bb_sport=0.8,
					// live_ds=0.12, game=1.3, live_other=0.12},
					// 1000={bb_3d=1.8, max_return=1888, ball=1, vgold=1000,
					// lotto=1, live_bb=1.5, hongkong=1, bb_sport=1,
					// live_ds=1.5, game=1.8, live_other=1.5}]
					if (waterType.equals("0")) {
						BigDecimal maxReturn = new BigDecimal(0);
						for (Iterator iter = percentList.iterator(); iter.hasNext();) {
							Map.Entry entry = (Map.Entry) iter.next();
							Map<String, Object> percentDetailMap = (Map<String, Object>) entry.getValue();
							maxReturn = new BigDecimal(percentDetailMap.get("max_return").toString());
							break;

						}
						for (int i = 0; i < dsWaterTotal.size(); i++) {
							DsWaterTotal row = dsWaterTotal.get(i);
							// 当前用户数据应该那一层反水
							Map<String, Object> calcPencentDetailMap = new HashMap<String, Object>();
							// 下一层反水的起点
							BigDecimal calcGold = new BigDecimal(0);
							// 下面的反水就是为了计算两个对象赋值
							for (Iterator iter = percentList.iterator(); iter.hasNext();) {

								Map.Entry entry = (Map.Entry) iter.next();
								String strKey = (String) entry.getKey();
								// {bb_3d=1.3, max_return=999, ball=1, vgold=1,
								// lotto=0.8, live_bb=0.12, hongkong=0.8,
								// bb_sport=0.8, live_ds=0.12, game=1.3,
								// live_other=0.12}
								Map<String, Object> curPercentDetailMap = (Map<String, Object>) entry.getValue();
								// Map<String,Object> nextPercentDetailMap = new
								// HashMap<String,Object>();
								BigDecimal curGold = new BigDecimal(strKey);// 1
																			// 1000
								BigDecimal nextGold = new BigDecimal(0);// 1的下一级
																		// 1000
								// percentList = [1={bb_3d=1.3, max_return=999,
								// ball=1, vgold=1, lotto=0.8, live_bb=0.12,
								// hongkong=0.8, bb_sport=0.8, live_ds=0.12,
								// game=1.3, live_other=0.12}, 1000={bb_3d=1.8,
								// max_return=1888, ball=1, vgold=1000, lotto=1,
								// live_bb=1.5, hongkong=1, bb_sport=1,
								// live_ds=1.5, game=1.8, live_other=1.5}]
								// 取出下一级金额
								for (Iterator iterGold = percentList.iterator(); iterGold.hasNext();) {
									Map.Entry entryGold = (Map.Entry) iterGold.next();
									if ((new BigDecimal(entryGold.getKey().toString())).compareTo(curGold) > 0) {
										nextGold = new BigDecimal(entryGold.getKey().toString());
										// nextPercentDetailMap =
										// (Map<String,Object>)entryGold.getValue();
										break;
									}
								}
								// TotalUncalcValidamount 未计算的有效投注总额
								if ((row.getTotalUncalcValidamount().compareTo(curGold) > 0
										&& row.getTotalUncalcValidamount().compareTo(nextGold) < 0
										&& nextGold.compareTo(new BigDecimal(0)) != 0)) {
									calcPencentDetailMap = curPercentDetailMap;
									calcGold = nextGold;
									break;
								} else if (nextGold.compareTo(new BigDecimal(0)) == 0
										&& row.getTotalUncalcValidamount().compareTo(curGold) > 0) {
									// 此情况为顶级情况，比如反水层级最高为1000，而总的有效投注金额大于1000
									calcPencentDetailMap = curPercentDetailMap;
									calcGold = nextGold;
									break;
								}

							} // 为确定层级计算结束
							DsWaterTotal returnRow = new DsWaterTotal();
							// calcPencentDetailMap {bb_3d=1.8, max_return=1888,
							// ball=1, vgold=1000, lotto=1, live_bb=1.5,
							// hongkong=1, bb_sport=1, live_ds=1.5, game=1.8,
							// live_other=1.5}
							for (Entry<String, Object> entryDetail : calcPencentDetailMap.entrySet()) {
								String strkey = entryDetail.getKey();// bb_3d
								BigDecimal vPercent = new BigDecimal(entryDetail.getValue().toString());// 1.8
								returnRow = this.updateRow(row, strkey, vPercent, calcGold);// calcGold=0
							}
							// 判读最大返水金额
							if (row.getTotalWater().compareTo(maxReturn) == 1) {
								row.setReturnWater(maxReturn);
							} else {
								row.setReturnWater(row.getTotalWater());
							}
							row.setTotalCalcValidamount(null);
							row.setTotalUncalcValidamount(null);
							row.setBallCalcValidamount(null);
							row.setBallUncalcValidamount(null);
							row.setLiveBbCalcValidamount(null);
							row.setLiveBbUncalcValidamount(null);
							row.setLiveDsCalcValidamount(null);
							row.setLiveDsUncalcValidamount(null);
							row.setLiveOtherCalcValidamount(null);
							row.setLiveOtherUncalcValidamount(null);
							row.setGameCalcValidamount(null);
							row.setGameUncalcValidamount(null);
							row.setLottoCalcValidamount(null);
							row.setLottoUncalcValidamount(null);
							row.setHongkongCalcValidamount(null);
							row.setHongkongUncalcValidamount(null);
							row.setBbSportCalcValidamount(null);
							row.setBbSportUncalcValidamount(null);
							row.setBb3dCalcValidamount(null);
							row.setBb3dUncalcValidamount(null);
							dsWaterTotal.set(i, returnRow);

							// DsWaterTotal returnRow =
							// this.calcWater(row,orderMap,orderLiveMap,percentMap);
							// dsWaterTotal.set(i, returnRow);
						}
					} else {
						for (int i = 0; i < dsWaterTotal.size(); i++) {
							DsWaterTotal row = dsWaterTotal.get(i);
							DsWaterTotal returnRow = this.calcWater(row, orderList, orderLiveList, percentList);
							row.setTotalCalcValidamount(null);
							row.setTotalUncalcValidamount(null);
							row.setBallCalcValidamount(null);
							row.setBallUncalcValidamount(null);
							row.setLiveBbCalcValidamount(null);
							row.setLiveBbUncalcValidamount(null);
							row.setLiveDsCalcValidamount(null);
							row.setLiveDsUncalcValidamount(null);
							row.setLiveOtherCalcValidamount(null);
							row.setLiveOtherUncalcValidamount(null);
							row.setGameCalcValidamount(null);
							row.setGameUncalcValidamount(null);
							row.setLottoCalcValidamount(null);
							row.setLottoUncalcValidamount(null);
							row.setHongkongCalcValidamount(null);
							row.setHongkongUncalcValidamount(null);
							row.setBbSportCalcValidamount(null);
							row.setBbSportUncalcValidamount(null);
							row.setBb3dCalcValidamount(null);
							row.setBb3dUncalcValidamount(null);
							dsWaterTotal.set(i, returnRow);
						}
					}
				}

				/*
				 * Map<String,Object> mapCondition = new
				 * HashMap<String,Object>(); mapCondition.put("condition",
				 * strCondition.toString()); mapCondition.put("returnOrder",
				 * returnOrder); mapCondition.put("returnPercent",
				 * returnPercent); List<DsWaterTotal> dsWaterTotal =
				 * this.dsReportMapper.waterReport(mapCondition);
				 */
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", this.convertToJson(dsWaterTotal));
				java.util.Date nowdate = new java.util.Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
				Date betTime = format.parse(betTimeEnd + " 23:59:59");
				Calendar cal = Calendar.getInstance();
				cal.setTime(nowdate);
				cal.add(Calendar.DATE, -1);

				Calendar cal1 = Calendar.getInstance();
				cal1.setTime(betTime);
				cal1.add(Calendar.DATE, 1);

				if (betTime.before(cal.getTime())
						|| (cal1.get(Calendar.DATE) == nowdate.getDate() && nowdate.getHours() > 4)) {
					if (isUseCache.equals("1")) {
						logger.info("写入缓存start");
						RedisUtils redisUtils = new RedisUtils();
						redisUtils.redisTemplate = this.redisTemplate;
						redisUtils.set(cacheName, this.convertToJson(dsWaterTotal));
						logger.info("写入缓存end");
					}
				} else {
					this.setCacheData(cacheName, this.convertToJson(dsWaterTotal));
				}
			} else {
				result.put("returnCode", 910008);
				result.put("returnMsg", "Key valid error");
				logger.info("Key valid error");
				return;
			}
			logger.info("total waterReport time : " + (System.currentTimeMillis() - start));
			logger.info("返水报表waterReport end");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
			/*
			 * result.put("returnCode", 910001); result.put("returnMsg",
			 * "System error");
			 */
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private DsWaterTotal calcWater(DsWaterTotal row, List orderList, List orderLiveList, List percentList)
			throws Exception {
		try {

			BigDecimal maxReturn = new BigDecimal(0);
			// 取出最大反水
			for (Iterator iter = percentList.iterator(); iter.hasNext();) {

				Map.Entry entry = (Map.Entry) iter.next();
				String key = (String) entry.getKey();
				Map<String, Object> percentDetailMap = (Map<String, Object>) entry.getValue();
				maxReturn = new BigDecimal(percentDetailMap.get("max_return").toString());
				break;
			}
			// maxReturn = 999
			// 只有两层，循环两次
			for (Iterator iter = percentList.iterator(); iter.hasNext();) {
				if (row.getTotalUncalcValidamount().compareTo(new BigDecimal(0)) == 0) {
					break;
				}
				// entry 1={bb_3d=1.3, max_return=999, ball=1, vgold=1,
				// lotto=0.8, live_bb=0.12, hongkong=0.8, bb_sport=0.8,
				// live_ds=0.12, game=1.3, live_other=0.12}
				Map.Entry entry = (Map.Entry) iter.next();
				String key = (String) entry.getKey(); // 1 1000 层级
				// {bb_3d=1.3, max_return=999, ball=1, vgold=1, lotto=0.8,
				// live_bb=0.12, hongkong=0.8, bb_sport=0.8, live_ds=0.12,
				// game=1.3, live_other=0.12}
				Map<String, Object> percentDetailMap = (Map<String, Object>) entry.getValue();
				BigDecimal nextGold = new BigDecimal(0);// 取出下一层级1000
				for (Iterator iterGold = percentList.iterator(); iterGold.hasNext();) {
					Map.Entry entryGold = (Map.Entry) iterGold.next();
					if ((new BigDecimal(entryGold.getKey().toString())).compareTo(new BigDecimal(key)) > 0) {
						nextGold = new BigDecimal(entryGold.getKey().toString());
						break;
					}
				}
				// 用户投注金额已达到当前层级或者已达到最高层级
				if (nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0) {
					// 如果需计算金额小于小一层级的起始金额或者没有下一层级（下一层级金额为0），则直接根据未计算金额算出返水
					if (row.getTotalUncalcValidamount().compareTo(nextGold) == 0) {
						break;
					}
					// 开始为每种类型反水
					for (Entry<String, Object> entryDetail : percentDetailMap.entrySet()) {
						String strkey = entryDetail.getKey();// bb_3d
						BigDecimal vPercent = new BigDecimal(entryDetail.getValue().toString());// 1.3
						row = this.updateRow(row, strkey, vPercent, nextGold);

					}
				} else {
					// 如果根据下一层级的起始金额计算返水
					for (Iterator iterOrder = orderList.iterator(); iterOrder.hasNext();) {
						Map.Entry entryOrder = (Map.Entry) iterOrder.next();
						String orderName = (String) entryOrder.getValue();
						if (orderName.equals("live")) {
							for (Iterator iterLive = orderLiveList.iterator(); iterLive.hasNext();) {
								if (row.getTotalCalcValidamount().compareTo(nextGold) >= 0) {
									break;
								}
								Map.Entry entryLive = (Map.Entry) iterLive.next();
								String liveName = (String) entryLive.getValue();
								BigDecimal vPercent = new BigDecimal(
										Double.valueOf(percentDetailMap.get(liveName).toString()));
								row = this.updateRow(row, liveName, vPercent, nextGold);

							}
						} else {
							if (row.getTotalCalcValidamount().compareTo(nextGold) >= 0) {
								break;
							}
							BigDecimal vPercent = new BigDecimal(
									Double.valueOf(percentDetailMap.get(orderName).toString()));
							row = this.updateRow(row, orderName, vPercent, nextGold);
						}
					}
				}

			}
			// 判读最大返水金额
			if (row.getTotalWater().compareTo(maxReturn) == 1) {
				row.setReturnWater(maxReturn);
			} else {
				row.setReturnWater(row.getTotalWater());
			}
			return row;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
		}

	}

	private DsWaterTotalNew calcWaterNew(DsWaterTotalNew row, List orderList, List orderLiveList, List percentList,Map<String,GameWaterVo> gameWaterMap,Map<String,JSONArray> json_map)
			throws Exception {
		try {

			BigDecimal maxReturn = new BigDecimal(0);
			// 取出最大反水
			for (Iterator iter = percentList.iterator(); iter.hasNext();) {

				Map.Entry entry = (Map.Entry) iter.next();
				String key = (String) entry.getKey();
				Map<String, Object> percentDetailMap = (Map<String, Object>) entry.getValue();
				maxReturn = new BigDecimal(percentDetailMap.get("max_return").toString());
				break;
			}
			// maxReturn = 999
			// 只有两层，循环两次
			for (Iterator iter = percentList.iterator(); iter.hasNext();) {
				if (row.getTotalUncalcValidamount().compareTo(new BigDecimal(0)) == 0) {
					break;
				}
				// entry 1={bb_3d=1.3, max_return=999, ball=1, vgold=1,
				// lotto=0.8, live_bb=0.12, hongkong=0.8, bb_sport=0.8,
				// live_ds=0.12, game=1.3, live_other=0.12}
				Map.Entry entry = (Map.Entry) iter.next();
				String key = (String) entry.getKey(); // 1 1000 层级
				// {bb_3d=1.3, max_return=999, ball=1, vgold=1, lotto=0.8,
				// live_bb=0.12, hongkong=0.8, bb_sport=0.8, live_ds=0.12,
				// game=1.3, live_other=0.12}
				Map<String, Object> percentDetailMap = (Map<String, Object>) entry.getValue();
				BigDecimal nextGold = new BigDecimal(0);// 取出下一层级1000
				for (Iterator iterGold = percentList.iterator(); iterGold.hasNext();) {
					Map.Entry entryGold = (Map.Entry) iterGold.next();
					if ((new BigDecimal(entryGold.getKey().toString())).compareTo(new BigDecimal(key)) > 0) {
						nextGold = new BigDecimal(entryGold.getKey().toString());
						break;
					}
				}
				// 用户投注金额已达到当前层级或者已达到最高层级
				if (nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0) {
					// 如果需计算金额小于小一层级的起始金额或者没有下一层级（下一层级金额为0），则直接根据未计算金额算出返水
					if (row.getTotalUncalcValidamount().compareTo(nextGold) == 0) {
						break;
					}
					// 开始为每种类型反水
					for (Entry<String, Object> entryDetail : percentDetailMap.entrySet()) {
						String strkey = entryDetail.getKey();// bb_3d
						BigDecimal vPercent = new BigDecimal(entryDetail.getValue().toString());// 1.3
						row = this.updateRowNew(row, strkey, vPercent, nextGold,gameWaterMap,json_map);

					}
				} else {
					// 如果根据下一层级的起始金额计算返水
					for (Iterator iterOrder = orderList.iterator(); iterOrder.hasNext();) {
						Map.Entry entryOrder = (Map.Entry) iterOrder.next();
						String orderName = (String) entryOrder.getValue();
						if (orderName.equals("live") || orderName.equals("hongkong") || orderName.equals("lotto")
								|| orderName.equals("sport") || orderName.equals("game")) {
							for (Iterator iterLive = orderLiveList.iterator(); iterLive.hasNext();) {
								if (row.getTotalCalcValidamount().compareTo(nextGold) >= 0) {
									break;
								}
								Map.Entry entryLive = (Map.Entry) iterLive.next();
								String liveName = (String) entryLive.getValue();
								BigDecimal vPercent = new BigDecimal(
										Double.valueOf(percentDetailMap.get(liveName).toString()));
								row = this.updateRowNew(row, liveName, vPercent, nextGold,gameWaterMap,json_map);

							}
						} else {
							if (row.getTotalCalcValidamount().compareTo(nextGold) >= 0) {
								break;
							}
							BigDecimal vPercent = new BigDecimal(
									Double.valueOf(percentDetailMap.get(orderName).toString()));
							row = this.updateRowNew(row, orderName, vPercent, nextGold,gameWaterMap,json_map);
						}
					}
				}

			}
			// 判读最大返水金额
			if (row.getTotalWater().compareTo(maxReturn) == 1) {
				row.setReturnWater(maxReturn);
			} else {
				row.setReturnWater(row.getTotalWater());
			}
			return row;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
		}

	}

	/**
	 * 
	 * @param row
	 * @param pencentName
	 *            bb_3d
	 * @param vPercent
	 *            1.8
	 * @param nextGold
	 *            下级反水 有可能是0
	 * @return
	 * @throws Exception
	 */
	private DsWaterTotal updateRow(DsWaterTotal row, String pencentName, BigDecimal vPercent, BigDecimal nextGold)
			throws Exception {
		try {
			BigDecimal tempCalcAmount = new BigDecimal(0);
			if (pencentName.equals("live_ds")) {
				if (row.getLiveDsUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getLiveDsUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				row.setLiveDsWater(
						row.getLiveDsWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
								.setScale(2, RoundingMode.HALF_UP));
				row.setLiveDsCalcValidamount(row.getLiveDsCalcValidamount().add(tempCalcAmount));
				row.setLiveDsUncalcValidamount(row.getLiveDsUncalcValidamount().subtract(tempCalcAmount));
				row.setLiveWater(row.getLiveWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
						.setScale(2, RoundingMode.HALF_UP));

			} else if (pencentName.equals("live_bb")) {
				if (row.getLiveBbUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getLiveBbUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				row.setLiveBbWater(
						row.getLiveBbWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
								.setScale(2, RoundingMode.HALF_UP));
				row.setLiveBbCalcValidamount(row.getLiveBbCalcValidamount().add(tempCalcAmount));
				row.setLiveBbUncalcValidamount(row.getLiveBbUncalcValidamount().subtract(tempCalcAmount));
				row.setLiveWater(row.getLiveWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
						.setScale(2, RoundingMode.HALF_UP));
			} else if (pencentName.equals("live_other")) {
				if (row.getLiveOtherUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getLiveOtherUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				row.setLiveOtherWater(
						row.getLiveOtherWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
								.setScale(2, RoundingMode.HALF_UP));
				row.setLiveOtherCalcValidamount(row.getLiveOtherCalcValidamount().add(tempCalcAmount));
				row.setLiveOtherUncalcValidamount(row.getLiveOtherUncalcValidamount().subtract(tempCalcAmount));
				row.setLiveWater(row.getLiveWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
						.setScale(2, RoundingMode.HALF_UP));
			} else if (pencentName.equals("hongkong")) {
				if (row.getHongkongUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getHongkongUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());

				row.setHongkongWater(
						row.getHongkongWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
								.setScale(2, RoundingMode.HALF_UP));
				row.setHongkongCalcValidamount(row.getHongkongCalcValidamount().add(tempCalcAmount));
				row.setHongkongUncalcValidamount(row.getHongkongUncalcValidamount().subtract(tempCalcAmount));
			} else if (pencentName.equals("lotto")) {
				if (row.getLottoUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getLottoUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				row.setLottoWater(row.getLottoWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
						.setScale(2, RoundingMode.HALF_UP));
				row.setLottoCalcValidamount(row.getLottoCalcValidamount().add(tempCalcAmount));
				row.setLottoUncalcValidamount(row.getLottoUncalcValidamount().subtract(tempCalcAmount));
			} else if (pencentName.equals("ball")) {
				if (row.getBallUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getBallUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				row.setBallWater(row.getBallWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
						.setScale(2, RoundingMode.HALF_UP));
				row.setBallCalcValidamount(row.getBallCalcValidamount().add(tempCalcAmount));
				row.setBallUncalcValidamount(row.getBallUncalcValidamount().subtract(tempCalcAmount));
			} else if (pencentName.equals("bb_sport")) {
				if (row.getBbSportUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getBbSportUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				row.setBbSportWater(
						row.getBbSportWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
								.setScale(2, RoundingMode.HALF_UP));
				row.setBbSportCalcValidamount(row.getBbSportCalcValidamount().add(tempCalcAmount));
				row.setBbSportUncalcValidamount(row.getBbSportUncalcValidamount().subtract(tempCalcAmount));
			} else if (pencentName.equals("game")) {
				if (row.getGameUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getGameUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				row.setGameWater(row.getGameWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
						.setScale(2, RoundingMode.HALF_UP));
				row.setGameCalcValidamount(row.getGameCalcValidamount().add(tempCalcAmount));
				row.setGameUncalcValidamount(row.getGameUncalcValidamount().subtract(tempCalcAmount));
			} else if (pencentName.equals("bb_3d")) {
				/**
				 * 顶级反水就进入这里
				 */
				if (row.getBb3dUncalcValidamount().add(row.getTotalCalcValidamount()).compareTo(nextGold) <= 0
						|| nextGold.equals(new BigDecimal(0)) || row.getTotalValidamount().compareTo(nextGold) < 0)
					tempCalcAmount = row.getBb3dUncalcValidamount();
				else
					tempCalcAmount = nextGold.subtract(row.getTotalCalcValidamount());
				// 反水等于 row.getBb3dWater()（默认为0） +
				// tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100))
				// 也就是算出来的“未反水金额”*反水比（vPercent）
				row.setBb3dWater(row.getBb3dWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
						.setScale(2, RoundingMode.HALF_UP));
				row.setBb3dCalcValidamount(row.getBb3dCalcValidamount().add(tempCalcAmount));
				row.setBb3dUncalcValidamount(row.getBb3dUncalcValidamount().subtract(tempCalcAmount));
			}
			row.setTotalWater(row.getTotalWater().add(tempCalcAmount.multiply(vPercent).divide(new BigDecimal(100)))
					.setScale(2, RoundingMode.HALF_UP));
			row.setTotalCalcValidamount(row.getTotalCalcValidamount().add(tempCalcAmount).setScale(2));
			row.setTotalUncalcValidamount(
					row.getTotalUncalcValidamount().subtract(tempCalcAmount).setScale(2, RoundingMode.HALF_UP));
			return row;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
		}
	}

	/**
	 * 稽核统计 输入条件：日期区间、户名称、网站名称 输出：统计每个用户的有效投注额
	 * 
	 * @param request
	 * @return
	 */
	public void auditTotalTemp(Map<String, Object> paramMap, Map<String, Object> result) throws Exception {
		try {
			logger.info("稽核统计auditTotalTemp start");
			long start = System.currentTimeMillis();
			String siteId = "";
			if (paramMap.containsKey("siteId")) {
				siteId = paramMap.get("siteId").toString();
			}
			String username = "";
			if (paramMap.containsKey("username")) {
				username = paramMap.get("username").toString();
			}
			String key = "";
			if (paramMap.containsKey("key")) {
				key = paramMap.get("key").toString();
			}
			String betTimeBegin = "";
			if (paramMap.containsKey("betTimeBegin")) {
				betTimeBegin = paramMap.get("betTimeBegin").toString();
			}
			String betTimeEnd = "";
			if (paramMap.containsKey("betTimeEnd")) {
				betTimeEnd = paramMap.get("betTimeEnd").toString();
			}

			String startTime = "";
			if (paramMap.containsKey("startTime")) {
				startTime = paramMap.get("startTime").toString();
			}
			String endTime = "";
			if (paramMap.containsKey("endTime")) {
				endTime = paramMap.get("endTime").toString();
			}

			if (StringUtils.isBlank(key)) {
				result.put("returnCode", 910002);
				result.put("returnMsg", "key is null");
				logger.info("key is null");
				return;
			}

			if (StringUtils.isBlank(siteId)) {
				result.put("returnCode", 910003);
				result.put("returnMsg", "siteId is null");
				logger.info("siteId is null");
				return;
			}
			if (StringUtils.isBlank(username)) {
				result.put("returnCode", 910006);
				result.put("returnMsg", "username is null");
				logger.info("username is null");
				return;
			}
			if (StringUtils.isBlank(betTimeBegin)) {
				result.put("returnCode", 910004);
				result.put("returnMsg", "betTimeBegin is null");
				logger.info("betTimeBegin is null");
				return;
			}
			if (StringUtils.isBlank(betTimeEnd)) {
				result.put("returnCode", 910005);
				result.put("returnMsg", "betTimeEnd is null");
				logger.info("betTimeEnd is null");
				return;
			}

			String param = key.substring(5);
			String str = param.substring(0, param.length() - 6);
			String md5 = siteId + username + betTimeBegin + betTimeEnd + startTime + endTime;
			logger.info("md5 str:" + md5);
			// 取缓存数据
			String cacheName = "auditTotalTemp:" + md5;
			Map<String, Object> cacheData = this.getCacheData(cacheName);
			if (cacheData.get("code").equals("1")) {
				logger.info("从缓存中读取数据");
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", cacheData.get("cacheData").toString());
				logger.info("total auditTotal time : " + (System.currentTimeMillis() - start));
				return;
			}
			logger.info("md5:" + toMD5(md5));
			if (toMD5(md5).equals(str) || getMd5Valid().equals("0")) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
				TempAuditTotalExample example = new TempAuditTotalExample();
				com.ds.temp.entity.TempAuditTotalExample.Criteria createCriteria = example.createCriteria();
				createCriteria.andSiteIdEqualTo(Integer.valueOf(siteId));
				createCriteria.andUsernameEqualTo(username);
				betTimeBegin = betTimeBegin + " " + (StringUtils.isBlank(startTime) ? "00:00:00" : startTime);
				betTimeEnd = betTimeEnd + " " + (StringUtils.isBlank(endTime) ? "00:00:00" : endTime);
				//前等后不等
				createCriteria.andBetTimeGreaterThanOrEqualTo(format.parse(betTimeBegin));
				createCriteria.andBetTimeLessThan(format.parse(betTimeEnd));
				com.ds.temp.entity.DsAuditTotal dsAuditTotal = this.tempAuditTotalMapper.auditByExample(example);
				com.ds.temp.entity.DsAuditTotal dsAuditTotal1 = this.tempAuditTotalMapper.getAuditTotalBySiteIdAndUser(Integer.valueOf(siteId), username,betTimeBegin,betTimeEnd);
				if(null!=dsAuditTotal){//合并统计
					if(null!=dsAuditTotal1){
						dsAuditTotal=dsAuditTotal.total(dsAuditTotal,dsAuditTotal1);
					}
				}else{
					dsAuditTotal=dsAuditTotal1;
				}
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", this.convertToJson(dsAuditTotal));
				this.setCacheData(cacheName, this.convertToJson(dsAuditTotal));
			} else {
				result.put("returnCode", 910008);
				result.put("returnMsg", "Key valid error");
				logger.info("Key valid error");
				return;
			}
			logger.info("total auditTotal time : " + (System.currentTimeMillis() - start));
			logger.info("稽核统计auditTotal end");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
			/*
			 * result.put("returnCode", 910001); result.put("returnMsg",
			 * "System error");
			 */
		}
	}

	/**
	 * 稽核统计 输入条件：日期区间、户名称、网站名称 输出：统计每个用户的有效投注额
	 * 
	 * @param request
	 * @return
	 */
	public void auditTotal(Map<String, Object> paramMap, Map<String, Object> result) throws Exception {
		try {
			logger.info("稽核统计auditTotal start");
			long start = System.currentTimeMillis();
			String siteId = "";
			if (paramMap.containsKey("siteId")) {
				siteId = paramMap.get("siteId").toString();
			}
			String username = "";
			if (paramMap.containsKey("username")) {
				username = paramMap.get("username").toString();
			}
			String key = "";
			if (paramMap.containsKey("key")) {
				key = paramMap.get("key").toString();
			}
			String betTimeBegin = "";
			if (paramMap.containsKey("betTimeBegin")) {
				betTimeBegin = paramMap.get("betTimeBegin").toString();
			}
			String betTimeEnd = "";
			if (paramMap.containsKey("betTimeEnd")) {
				betTimeEnd = paramMap.get("betTimeEnd").toString();
			}

			String startTime = "";
			if (paramMap.containsKey("startTime")) {
				startTime = paramMap.get("startTime").toString();
			}
			String endTime = "";
			if (paramMap.containsKey("endTime")) {
				endTime = paramMap.get("endTime").toString();
			}

			if (StringUtils.isBlank(key)) {
				result.put("returnCode", 910002);
				result.put("returnMsg", "key is null");
				logger.info("key is null");
				return;
			}

			if (StringUtils.isBlank(siteId)) {
				result.put("returnCode", 910003);
				result.put("returnMsg", "siteId is null");
				logger.info("siteId is null");
				return;
			}
			if (StringUtils.isBlank(username)) {
				result.put("returnCode", 910006);
				result.put("returnMsg", "username is null");
				logger.info("username is null");
				return;
			}
			if (StringUtils.isBlank(betTimeBegin)) {
				result.put("returnCode", 910004);
				result.put("returnMsg", "betTimeBegin is null");
				logger.info("betTimeBegin is null");
				return;
			}
			if (StringUtils.isBlank(betTimeEnd)) {
				result.put("returnCode", 910005);
				result.put("returnMsg", "betTimeEnd is null");
				logger.info("betTimeEnd is null");
				return;
			}

			String param = key.substring(5);
			String str = param.substring(0, param.length() - 6);
			String md5 = siteId + username + betTimeBegin + betTimeEnd + startTime + endTime;
			logger.info("md5 str:" + md5);
			// 取缓存数据
			String cacheName = "auditTotal:" + md5;
			Map<String, Object> cacheData = this.getCacheData(cacheName);
			if (cacheData.get("code").equals("1")) {
				logger.info("从缓存中读取数据");
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", cacheData.get("cacheData").toString());
				logger.info("total auditTotal time : " + (System.currentTimeMillis() - start));
				return;
			}
			logger.info("md5:" + toMD5(md5));
			if (toMD5(md5).equals(str) || getMd5Valid().equals("0")) {
				DsReportExample m_example = this.generateSearchParam(paramMap);

				DsAuditTotal dsAuditTotal = this.dsReportMapper.auditTotal(m_example);
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", this.convertToJson(dsAuditTotal));
				this.setCacheData(cacheName, this.convertToJson(dsAuditTotal));
			} else {
				result.put("returnCode", 910008);
				result.put("returnMsg", "Key valid error");
				logger.info("Key valid error");
				return;
			}
			logger.info("total auditTotal time : " + (System.currentTimeMillis() - start));
			logger.info("稽核统计auditTotal end");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
			/*
			 * result.put("returnCode", 910001); result.put("returnMsg",
			 * "System error");
			 */
		}
	}

	/**
	 * 小费管理 输入条件：日期区间、网站名称、来源 输出：小费列表
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public void tipsList(Map<String, Object> paramMap, Map<String, Object> result) throws Exception {
		try {
			logger.info("小费管理tipsList start");
			long start = System.currentTimeMillis();
			String siteId = "";
			if (paramMap.containsKey("siteId")) {
				siteId = paramMap.get("siteId").toString();
			}
			String key = "";
			if (paramMap.containsKey("key")) {
				key = paramMap.get("key").toString();
			}
			String betTimeBegin = "";
			if (paramMap.containsKey("betTimeBegin")) {
				betTimeBegin = paramMap.get("betTimeBegin").toString();
			}
			String betTimeEnd = "";
			if (paramMap.containsKey("betTimeEnd")) {
				betTimeEnd = paramMap.get("betTimeEnd").toString();
			}

			String liveId = "";
			if (paramMap.containsKey("liveId")) {
				liveId = paramMap.get("liveId").toString();
			}
			String page = "";
			if (paramMap.containsKey("page")) {
				page = paramMap.get("page").toString();
			}
			String pageLimit = "";
			if (paramMap.containsKey("pageLimit")) {
				pageLimit = paramMap.get("pageLimit").toString();
			}

			if (StringUtils.isBlank(key)) {
				result.put("returnCode", 910002);
				result.put("returnMsg", "key is null");
				logger.info("key is null");
				return;
			}

			if (StringUtils.isBlank(siteId)) {
				result.put("returnCode", 910003);
				result.put("returnMsg", "siteId is null");
				logger.info("siteId is null");
				return;
			}
			if (StringUtils.isBlank(betTimeBegin)) {
				result.put("returnCode", 910004);
				result.put("returnMsg", "betTimeBegin is null");
				logger.info("betTimeBegin is null");
				return;
			}
			if (StringUtils.isBlank(betTimeEnd)) {
				result.put("returnCode", 910005);
				result.put("returnMsg", "betTimeEnd is null");
				logger.info("betTimeEnd is null");
				return;
			}

			String param = key.substring(5);
			String str = param.substring(0, param.length() - 6);
			String md5 = siteId + betTimeBegin + betTimeEnd + liveId + page + pageLimit;
			logger.info("md5 str:" + md5);
			// 取缓存数据
			String cacheName = "tipsList:" + md5;
			Map<String, Object> cacheData = this.getCacheData(cacheName);
			if (cacheData.get("code").equals("1")) {
				logger.info("从缓存中读取数据");
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.putAll((Map<String, Object>) cacheData.get("cacheData"));
				logger.info("total tipsList time : " + (System.currentTimeMillis() - start));
				return;
			}
			logger.info("md5:" + toMD5(md5));
			// if (toMD5(md5).equals(str) || getMd5Valid().equals("0")) {
			DsLiveTips dsTotal = this.dsLiveTipsServiceImpl.queryTotal(paramMap);
			List<DsLiveTips> dsLiveTips = null;
			if (dsTotal.getRecordCount() > 0) {
				dsLiveTips = this.dsLiveTipsServiceImpl.queryDetail(paramMap);
			}
			result.put("returnCode", 900000);
			result.put("returnMsg", "Success");
			if (dsTotal.getRecordCount() > 0) {
				Map<String, Object> resultMap = new HashMap<String, Object>();
				resultMap.put("total", dsTotal);
				resultMap.put("dataList", dsLiveTips);
				result.putAll(resultMap);
				this.setCacheData(cacheName, this.convertToJson(resultMap));
			}

			// } else {
			// result.put("returnCode", 910008);
			// result.put("returnMsg", "Key valid error");
			// logger.info("Key valid error");
			// return;
			// }
			logger.info("total tipsList time : " + (System.currentTimeMillis() - start));
			logger.info("小费管理tipsList end");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
			/*
			 * result.put("returnCode", 910001); result.put("returnMsg",
			 * "System error");
			 */
		}
	}

	/**
	 * 有效会员统计 输入条件：日期区间、网站名称、有效金额 输出：根据代理分组统计会员数
	 * 
	 * @param request
	 * @return
	 */
	public void validUserCount(Map<String, Object> paramMap, Map<String, Object> result) throws Exception {
		try {
			logger.info("有效会员统计validUserCount start");
			long start = System.currentTimeMillis();
			StringBuilder strCondition = new StringBuilder();
			String siteId = "";
			if (paramMap.containsKey("siteId")) {
				siteId = paramMap.get("siteId").toString();
				strCondition.append("siteId|").append(siteId).append(";");
			}
			String key = "";
			if (paramMap.containsKey("key")) {
				key = paramMap.get("key").toString();
			}
			String betTimeBegin = "";
			if (paramMap.containsKey("betTimeBegin")) {
				betTimeBegin = paramMap.get("betTimeBegin").toString();
				strCondition.append("betTimeBegin|").append(betTimeBegin).append(";");
			}
			String betTimeEnd = "";
			if (paramMap.containsKey("betTimeEnd")) {
				betTimeEnd = paramMap.get("betTimeEnd").toString();
				strCondition.append("betTimeEnd|").append(betTimeEnd).append(";");
			}
			String username = "";
			if (paramMap.containsKey("username")) {
				username = paramMap.get("username").toString();
				strCondition.append("username|").append(username).append(";");
			}
			String agentLevel = "";
			if (paramMap.containsKey("agentLevel")) {
				agentLevel = paramMap.get("agentLevel").toString();
				strCondition.append("agentLevel|").append(agentLevel).append(";");
			}
			String defValidamount = "";
			if (paramMap.containsKey("defValidamount")) {
				defValidamount = paramMap.get("defValidamount").toString();
				strCondition.append("defValidamount|").append(defValidamount).append(";");
			}
			String page = "";
			if (paramMap.containsKey("page")) {
				page = paramMap.get("page").toString();
				strCondition.append("page|").append(page).append(";");
			}
			String pageLimit = "";
			if (paramMap.containsKey("pageLimit")) {
				pageLimit = paramMap.get("pageLimit").toString();
				strCondition.append("pageLimit|").append(pageLimit).append(";");
			}

			if (StringUtils.isBlank(key)) {
				result.put("returnCode", 910002);
				result.put("returnMsg", "key is null");
				logger.info("key is null");
				return;
			}

			if (StringUtils.isBlank(siteId)) {
				result.put("returnCode", 910003);
				result.put("returnMsg", "siteId is null");
				logger.info("siteId is null");
				return;
			}
			if (StringUtils.isBlank(betTimeBegin)) {
				result.put("returnCode", 910004);
				result.put("returnMsg", "betTimeBegin is null");
				logger.info("betTimeBegin is null");
				return;
			}
			if (StringUtils.isBlank(betTimeEnd)) {
				result.put("returnCode", 910005);
				result.put("returnMsg", "betTimeEnd is null");
				logger.info("betTimeEnd is null");
				return;
			}

			String param = key.substring(5);
			String str = param.substring(0, param.length() - 6);
			String md5 = siteId + betTimeBegin + betTimeEnd + username + agentLevel + defValidamount + page + pageLimit;
			logger.info("md5 str:" + md5);
			// 取缓存数据
			String cacheName = "validUserCount:" + md5;
			Map<String, Object> cacheData = this.getCacheData(cacheName);
			if (cacheData.get("code").equals("1")) {
				logger.info("从缓存中读取数据");
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", cacheData.get("cacheData").toString());
				logger.info("total validUserCount time : " + (System.currentTimeMillis() - start));
				return;
			}
			logger.info("md5:" + toMD5(md5));
			if (toMD5(md5).equals(str) || getMd5Valid().equals("0")) {
				Map<String, Object> mapCondition = new HashMap<String, Object>();
				mapCondition.put("condition", strCondition.toString());

				List<List<DsCommissionTotal>> ds = this.dsReportMapper.validUserListByProc(strCondition.toString());
				DsCommissionTotal dsTotal = (DsCommissionTotal) ds.get(0).get(0);
				List<DsCommissionTotal> dsDetail = ds.get(1);
				Map<String, Object> resultMap = new HashMap<String, Object>();
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				resultMap.put("total", this.convertToJson(dsTotal));
				resultMap.put("dataList", this.convertToJson(dsDetail));
				result.putAll(resultMap);
				this.setCacheData(cacheName, this.convertToJson(resultMap));
				/*
				 * DsReportExample m_example =
				 * this.generateSearchParam(paramMap); DsCommissionTotal dsTotal
				 * = this.dsReportMapper.validUserTotal(m_example);
				 * List<DsCommissionTotal> dsDetail = null; if
				 * (dsTotal.getRecordCount() > 0){ dsDetail =
				 * this.dsReportMapper.validUserList(m_example); }
				 * result.put("returnCode", 900000); result.put("returnMsg",
				 * "Success"); if (dsTotal.getRecordCount() > 0) { Map<String,
				 * Object> resultMap = new HashMap<String, Object>();
				 * resultMap.put("total", this.convertToJson(dsTotal));
				 * resultMap.put("dataList", this.convertToJson(dsDetail));
				 * result.putAll(resultMap);
				 * this.setCacheData(cacheName,this.convertToJson(resultMap)); }
				 */
			} else {
				result.put("returnCode", 910008);
				result.put("returnMsg", "Key valid error");
				logger.info("Key valid error");
				return;
			}

			logger.info("total validUserCount time : " + (System.currentTimeMillis() - start));
			logger.info("有效会员统计validUserCount end");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
			/*
			 * result.put("returnCode", 910001); result.put("returnMsg",
			 * "System error");
			 */
		}
	}

	/**
	 * 彩金统计 输入条件：日期区间、网站名称、类型、来源 输出：统计中奖金额
	 * 
	 * @param request
	 * @return
	 */
	public void jpGameList(Map<String, Object> paramMap, Map<String, Object> result) throws Exception {
		try {
			logger.info("彩金统计jpGameList start");
			long start = System.currentTimeMillis();
			String siteId = "";
			if (paramMap.containsKey("siteId")) {
				siteId = paramMap.get("siteId").toString();
			}
			String key = "";
			if (paramMap.containsKey("key")) {
				key = paramMap.get("key").toString();
			}
			String betTimeBegin = "";
			if (paramMap.containsKey("betTimeBegin")) {
				betTimeBegin = paramMap.get("betTimeBegin").toString();
			}
			String betTimeEnd = "";
			if (paramMap.containsKey("betTimeEnd")) {
				betTimeEnd = paramMap.get("betTimeEnd").toString();
			}
			String jptype = "";
			if (paramMap.containsKey("jptype")) {
				jptype = paramMap.get("jptype").toString();
			}
			String liveId = "";
			if (paramMap.containsKey("liveId")) {
				liveId = paramMap.get("liveId").toString();
			}
			String page = "";
			if (paramMap.containsKey("page")) {
				page = paramMap.get("page").toString();
			}
			String pageLimit = "";
			if (paramMap.containsKey("pageLimit")) {
				pageLimit = paramMap.get("pageLimit").toString();
			}

			if (StringUtils.isBlank(key)) {
				result.put("returnCode", 910002);
				result.put("returnMsg", "key is null");
				logger.info("key is null");
				return;
			}

			if (StringUtils.isBlank(siteId)) {
				result.put("returnCode", 910003);
				result.put("returnMsg", "siteId is null");
				logger.info("siteId is null");
				return;
			}
			if (StringUtils.isBlank(betTimeBegin)) {
				result.put("returnCode", 910004);
				result.put("returnMsg", "betTimeBegin is null");
				logger.info("betTimeBegin is null");
				return;
			}
			if (StringUtils.isBlank(betTimeEnd)) {
				result.put("returnCode", 910005);
				result.put("returnMsg", "betTimeEnd is null");
				logger.info("betTimeEnd is null");
				return;
			}

			String param = key.substring(5);
			String str = param.substring(0, param.length() - 6);
			String md5 = siteId + betTimeBegin + betTimeEnd + jptype + liveId + page + pageLimit;
			logger.info("md5 str:" + md5);
			// 取缓存数据
			String cacheName = "jpGameList:" + md5;
			Map<String, Object> cacheData = this.getCacheData(cacheName);
			if (cacheData.get("code").equals("1")) {
				logger.info("从缓存中读取数据");
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", cacheData.get("cacheData").toString());
				logger.info("total jpGameList time : " + (System.currentTimeMillis() - start));
				return;
			}
			logger.info("md5:" + toMD5(md5));
			if (toMD5(md5).equals(str) || getMd5Valid().equals("0")) {
				DsJpgame dsTotal = this.dsJpgameServiceImpl.queryTotal(paramMap);
				List<DsJpgame> dsDetail = null;
				if (dsTotal.getRecordCount() > 0) {
					dsDetail = this.dsJpgameServiceImpl.queryDetail(paramMap);
				}
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				if (dsTotal.getRecordCount() > 0) {
					Map<String, Object> resultMap = new HashMap<String, Object>();
					resultMap.put("total", this.convertToJson(dsTotal));
					resultMap.put("dataList", this.convertToJson(dsDetail));
					result.putAll(resultMap);
					this.setCacheData(cacheName, this.convertToJson(resultMap));
				}
			} else {
				result.put("returnCode", 910008);
				result.put("returnMsg", "Key valid error");
				logger.info("Key valid error");
				return;
			}

			logger.info("total jpGameList time : " + (System.currentTimeMillis() - start));
			logger.info("彩金统计jpGameList end");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
			/*
			 * result.put("returnCode", 910001); result.put("returnMsg",
			 * "System error");
			 */
		}
	}

	public void getMemberBetInfo(com.alibaba.fastjson.JSONObject data, com.alibaba.fastjson.JSONObject result,
			MemberBetInfoParam queryParam, Page pagation) {
		// 详细列表
		List<MemberBetInfoVo> list = reportDao
				.findMemberBetByPage(new RowBounds(pagation.getFirst() - 1, pagation.getPageSize()), queryParam);
		result.put("data", list);
		// 总条目数
		Long totalCount = reportDao.countMemberBetByPage(queryParam);
		Map<String, Object> pagationMap = new HashMap<String, Object>();
		pagationMap.put("page", pagation.getPageNo());
		pagationMap.put("pageSize", pagation.getPageSize());
		pagationMap.put("totalNumber", totalCount);
		result.put("pagation", pagationMap);

		result.put("betMemberCount", totalCount);
		// 统计
		MemberBetSumVo sumVo = reportDao.memberBetSum(queryParam);
		result.put("betSumAmount", sumVo);

		// if(StringUtils.isBlank(queryParam.getUsername())){
		// //统计总下注人数
		// Long memberCount= reportDao.memberBetCountByPage(queryParam);
		// result.put("betMemberCount", memberCount);
		// }

	}

	public void getBetInfoByDate(com.alibaba.fastjson.JSONObject result, BetInfoByDateParam queryParam) {
		// 详细列表
		List<MemberBetInfoVo> list = reportDao.findBetByDate(queryParam);
		result.put("data", list);
		BetInfoByDateSum sumVo = reportDao.betInfoByDateSum(queryParam);
		result.put("betSumAmount", sumVo);
	}

	public void getValidateMemberByDate(com.alibaba.fastjson.JSONObject result, ValidateMemberByDateParam queryParam) {
		// 详细列表
		List<ValidateMemberByDateVo> list = reportDao.findValidateMemberByDate(queryParam);
		result.put("data", list);
		Integer totalCount = 0;
		if (list != null && list.size() > 0) {
			for (ValidateMemberByDateVo validateMemberByDateVo : list) {
				totalCount += validateMemberByDateVo.getValidateMember();
			}
		}
		result.put("totalMember", totalCount);
	}

	public void getBanlanceByLiveId(com.alibaba.fastjson.JSONObject result, Map<String, Object> queryParam) {
		String username = (String) queryParam.get("username");
		// 查询所有
		if (StringUtils.isBlank(username)) {
			List<String> usernameList = reportDao.getBanlanceByLiveId(queryParam);
		}

	}

	public void getAllLiveByUser(com.alibaba.fastjson.JSONObject result, com.alibaba.fastjson.JSONObject obj) {
		List<GetAllLiveByUserVo> data = reportDao.getAllLiveByUser(obj);
		result.put("data", data);
		result.put("returnCode", 900000);
		result.put("returnMsg", "Success");
	}

	public void getAllTypeByUser(com.alibaba.fastjson.JSONObject result, com.alibaba.fastjson.JSONObject obj) {
		BigDecimal totalamount = reportDao.getAllTypeByUser(obj);

		result.put("totalValidamount", totalamount);
		result.put("username", obj.getString("username"));
		result.put("returnCode", 900000);
		result.put("returnMsg", "Success");
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { RuntimeException.class, Exception.class })
	public void setMemberData(Map<String, Object> result, String username, String siteId, String agents, String world,
			String corprator, String superior, String company) throws Exception {
		// String setMemberResult = setMemberData(username, siteId, agents,
		// world, corprator, superior, company);
		// com.alibaba.fastjson.JSONObject setMemberJson =
		// com.alibaba.fastjson.JSONObject.parseObject(setMemberResult);
		// logger.info("调用钱包中心setMemberData返回result：" + setMemberJson);
		// if (!setMemberJson.getString("code").equals("100000")) {
		// result.put("code", 100001);
		// result.put("message", setMemberJson.getString("message"));
		// return;
		// }
		MemberEntity member = getMemberByUsername(Integer.valueOf(siteId), username);
		if (member == null) {
			member = new MemberEntity();
			member.setCreateTime(new Date());
			member.setAgents(agents);
			member.setCompany(company);
			member.setCorprator(corprator);
			member.setSiteId(Integer.valueOf(siteId));
			member.setSuperior(superior);
			member.setUsername(username);
			member.setWorld(world);
			memberMapper.insert(member);
			logger.info("插入username：" + username + ",siteId:" + siteId);
		} else {
			member.setUpdateTime(new Date());
			member.setAgents(agents);
			member.setCompany(company);
			member.setCorprator(corprator);
			member.setSiteId(Integer.valueOf(siteId));
			member.setSuperior(superior);
			member.setUsername(username);
			member.setWorld(world);
			memberMapper.updateByPrimaryKey(member);
			logger.info("更新username：" + username + ",siteId:" + siteId);
		}
		result.put("message", "ok");
		result.put("code", 100000);
	}

	private MemberEntity getMemberByUsername(Integer siteId, String username) {
		MemberEntityExample e = new MemberEntityExample();
		e.createCriteria().andSiteIdEqualTo(siteId).andUsernameEqualTo(username);
		List<MemberEntity> list = memberMapper.selectByExample(e);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public void getMemberNameList(com.alibaba.fastjson.JSONObject result, com.alibaba.fastjson.JSONObject obj) {
		List<String> usernameList = reportDao.getMemberNameList(obj);
		result.put("data", usernameList);
	}

	/**
	 * 按用户划分游戏类型(gameType)统计汇总数
	 * 
	 */
	public void queryBetTotalByUserGroupGameType(Map<String, Object> paramMap, Map<String, Object> result)
			throws Exception {
		try {
			logger.info("按用户统计汇总数queryBetTotalByUserGroupGameType start");
			long start = System.currentTimeMillis();
			String siteId = "";
			if (paramMap.containsKey("siteId")) {
				siteId = paramMap.get("siteId").toString();
			}
			String key = "";
			if (paramMap.containsKey("key")) {
				key = paramMap.get("key").toString();
			}
			String betTimeBegin = "";
			if (paramMap.containsKey("betTimeBegin")) {
				betTimeBegin = paramMap.get("betTimeBegin").toString();
			}
			String betTimeEnd = "";
			if (paramMap.containsKey("betTimeEnd")) {
				betTimeEnd = paramMap.get("betTimeEnd").toString();
			}
			String liveId = "";
			if (paramMap.containsKey("liveId")) {
				liveId = paramMap.get("liveId").toString();
			}
			String startTime = "";
			if (paramMap.containsKey("startTime")) {
				startTime = paramMap.get("startTime").toString();
			}
			String endTime = "";
			if (paramMap.containsKey("endTime")) {
				endTime = paramMap.get("endTime").toString();
			}
			String username = "";
			if (paramMap.containsKey("username")) {
				username = paramMap.get("username").toString();
			}
			String gameKind = "";
			if (paramMap.containsKey("gameKind")) {
				gameKind = paramMap.get("gameKind").toString();
			}
			String gameType = "";
			if (paramMap.containsKey("gameType")) {
				gameType = paramMap.get("gameType").toString();
			}
			if (StringUtils.isBlank(key)) {
				result.put("returnCode", 910002);
				result.put("returnMsg", "key is null");
				return;
			}

			if (StringUtils.isBlank(siteId)) {
				result.put("returnCode", 910003);
				result.put("returnMsg", "siteId is null");
				logger.info("siteId is null");
				return;
			}
			if (StringUtils.isBlank(betTimeBegin)) {
				result.put("returnCode", 910004);
				result.put("returnMsg", "betTimeBegin is null");
				logger.info("betTimeBegin is null");
				return;
			}
			if (StringUtils.isBlank(betTimeEnd)) {
				result.put("returnCode", 910005);
				result.put("returnMsg", "betTimeEnd is null");
				logger.info("betTimeEnd is null");
				return;
			}
			if (StringUtils.isBlank(username)) {
				result.put("returnCode", 910006);
				result.put("returnMsg", "username is null");
				logger.info("username is null");
				return;
			}
			if (StringUtils.isBlank(gameKind)) {
				result.put("returnCode", 910007);
				result.put("returnMsg", "gameKind is null");
				logger.info("gameKind is null");
				return;
			}
			if (StringUtils.isBlank(liveId)) {
				result.put("returnCode", 910009);
				result.put("returnMsg", "liveId is null");
				logger.info("liveId is null");
				return;
			}
			String param = key.substring(5);
			String str = param.substring(0, param.length() - 6);
			String md5 = siteId + username + liveId + gameKind + gameType + betTimeBegin + betTimeEnd + startTime
					+ endTime;
			logger.info("md5 str:" + md5);
			// 取缓存数据
			String cacheName = "betTotalByUser:" + md5;
			Map<String, Object> cacheData = this.getCacheData(cacheName);
			if (cacheData.get("code").equals("1")) {
				logger.info("从缓存中读取数据");
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", cacheData.get("cacheData").toString());
				logger.info("total queryBetTotalByUser time : " + (System.currentTimeMillis() - start));
				return;
			}
			String strgameKind = null;
			List<DsReport> dataList = null;
			if (paramMap.containsKey("gameKind")) {
				strgameKind = paramMap.get("gameKind").toString();
				if (strgameKind.equals("1")) {// BBIN 球类
					dataList = this.dsBbinSportServiceImpl.queryTotalGroupGameType(paramMap);
				} else if (strgameKind.equals("3")) { // BBIN视讯
					dataList = this.dsBbinLiveServiceImpl.queryTotalGroupGameType(paramMap);
				} else if (strgameKind.equals("5")) {// BBIN 机率
					dataList = this.dsBbinJilvServiceImpl.queryTotalGroupGameType(paramMap);
				} else if (strgameKind.equals("12")) {// BBIN 彩票

				} else if (strgameKind.equals("15")) {// BBIN 3D厅
					dataList = this.dsBbin3dServiceImpl.queryTotalGroupGameType(paramMap);
				}else if("16".equals(strgameKind)){
					dataList = this.dtPtGameServiceImpl.queryTotalGroupGameType(paramMap);

				} else if (strgameKind.equals("21") || strgameKind.equals("22")) { // 21
																					// AG视讯
																					// 22
																					// AG机率
					dataList = this.dsAgLiveServiceImpl.queryTotalGroupGameType(paramMap);
				}else if("23".equals(strgameKind)){
					dataList = this.hunterJackpotServiceImpl.queryTotalGroupGameType(paramMap);
				}else if("24".equals(strgameKind)){
					dataList = this.agSportServiceImpl.queryTotalGroupGameType(paramMap);
				} else if (strgameKind.equals("41")) { // DS视讯

					dataList = this.dsLiveServiceImpl.queryTotalGroupGameType(paramMap);
				} else if (strgameKind.equals("51")||strgameKind.equals("57")||strgameKind.equals("58")||strgameKind.equals("59")) { // 彩票
					dataList = jingdianServiceImpl.queryTotalGroupGameType(paramMap);
				} else if (strgameKind.equals("53")) { // ds电子游戏
					dataList = this.dsGameServiceImpl.queryTotalGroupGameType(paramMap);
				} else if (strgameKind.equals("42")) {// h8体育
					dataList = this.dsH8ServiceImpl.queryTotalGroupGameType(paramMap);
				} else if (strgameKind.equals("54")) {// ds香港彩
					dataList = this.dsLottoService.queryTotalGroupGameType(paramMap);
				} else if (strgameKind.equals("55")) {// ds传统彩
					dataList = this.dsLotteryService.queryTotalGroupGameType(paramMap);
				} else if (strgameKind.equals("52")) {// ds分分彩
					dataList = this.dsFenFenLottoServiceImpl.queryTotalGroupGameType(paramMap);
				} else if (strgameKind.equals("60")) {// MG电子
					dataList = this.mgGameServiceImpl.queryTotalGroupGameType(paramMap);
				} else if (strgameKind.equals("65")) {// PMG电子
					dataList = this.dtMGGameServiceImpl.queryTotalGroupGameType(paramMap);
				} else if (strgameKind.equals("56")) {// KG新官方彩
						dataList = this.gfLottoService.queryTotalGroupGameType(paramMap);
				}else if (strgameKind.equals("18")) {// LMG视讯
					dataList = this.lmgServiceImpl.queryTotalGroupGameType(paramMap);
				}else if (strgameKind.equals("90")) {// 开元棋牌
					dataList = this.kyChessServiceImpl.queryTotalGroupGameType(paramMap);
				}else if("95".equals(strgameKind)){// SGS视讯
					dataList = this.sgsLiveServiceImpl.queryTotalGroupGameType(paramMap);
				}else if("96".equals(strgameKind)){// SGS电子
					dataList = this.sgsGameServiceImpl.queryTotalGroupGameType(paramMap);
				}else if ("30000".equals(strgameKind)) { // kkw视讯
					dataList = this.dsLiveServiceImpl.queryTotalGroupGameType(paramMap);
				} 
				// TODO
				/**
				 * update 2016-02-24 by jay
				 */
				else if (strgameKind.equals("70")) {// OG视讯
					dataList = this.oGLiveServiceImpl.queryTotalGroupGameType(paramMap);
				} else if (strgameKind.equals("80")) {// 蛮牛
					dataList = this.manniuServiceImpl.queryTotalGroupGameType(paramMap);
				}
			}
			if (dataList != null && dataList.size() == 1) {// [null]
				if (dataList.get(0) == null) {
					dataList.remove(0);
				}
			}
			logger.info("md5:" + toMD5(md5));
			logger.info("result = {}", this.convertToJson(dataList));
			if (toMD5(md5).equals(str) || getMd5Valid().equals("0")) {
				// DsReportExample m_example =
				// this.generateSearchParam(paramMap);
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", this.convertToJson(dataList));
				this.setCacheData(cacheName, this.convertToJson(dataList));
			} else {
				result.put("returnCode", 910008);
				result.put("returnMsg", "Key valid error");
				logger.info("Key valid error");
			}
			logger.info("total queryBetTotalByUserGroupGameType time : " + (System.currentTimeMillis() - start));
			// bbin
			// List<DsReport> bbinSportReport =
			// this.dsBbinSportServiceImpl.queryTotalGroupGameType(paramMap);
			// logger.info("bbin sprot result = {}",
			// JSONArray.toJSONString(bbinSportReport));
			// List<DsReport> bbinLiveReport =
			// this.dsBbinLiveServiceImpl.queryTotalGroupGameType(paramMap);
			// logger.info("bbin live result = {}",
			// JSONArray.toJSONString(bbinLiveReport));
			// List<DsReport> bbinJiLvReport =
			// this.dsBbinJilvServiceImpl.queryTotalGroupGameType(paramMap);
			// logger.info("bbin jilv result =
			// {}",JSONArray.toJSONString(bbinJiLvReport));
			// List<DsReport> bbin3DReport =
			// this.dsBbin3dServiceImpl.queryTotalGroupGameType(paramMap);
			// logger.info("bbin 3d result =
			// {}",JSONArray.toJSONString(bbin3DReport));
			// //ag
			// List<DsReport> agLiveReport =
			// this.dsAgLiveServiceImpl.queryTotalGroupGameType(paramMap);
			// logger.info("ag live result = {}",
			// JSONArray.toJSONString(agLiveReport));
			// ds
			// List<DsReport> dsLiveReport =
			// this.dsLiveServiceImpl.queryTotalGroupGameType(paramMap);
			// logger.info("ds live result =
			// {}",JSONArray.toJSONString(dsLiveReport));
			// List<DsReport> dsLottoReport =
			// this.dsLottoService.queryTotalGroupGameType(paramMap);
			// logger.info("ds lotto result = {}",
			// JSONArray.toJSONString(dsLottoReport));
			// List<DsReport> dsLotteryReport =
			// this.dsLotteryService.queryTotalGroupGameType(paramMap);
			// logger.info("ds lottery result = {}",
			// JSONArray.toJSONString(dsLotteryReport));
			// List<DsReport> dsH8SportReport =
			// this.dsH8ServiceImpl.queryTotalGroupGameType(paramMap);
			// logger.info("h8 sport result = {}",
			// JSONArray.toJSONString(dsH8SportReport));
			logger.info("按用户统计汇总数queryBetTotalByUserGroupGameType end");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
			/*
			 * result.put("returnCode", 910001); result.put("returnMsg",
			 * "System error");
			 */
		}

	}

	public void queryBetTotalByDayNew(Map<String, Object> paramMap, Map<String, Object> result) throws Exception {
		try {
			logger.info("按用户/天统计汇总数queryBetTotalByDay start");
			long start = System.currentTimeMillis();
			String siteId = "";
			if (paramMap.containsKey("siteId")) {
				siteId = paramMap.get("siteId").toString();
			}
			String key = "";
			if (paramMap.containsKey("key")) {
				key = paramMap.get("key").toString();
			}
			String betTimeBegin = "";
			if (paramMap.containsKey("betTimeBegin")) {
				betTimeBegin = paramMap.get("betTimeBegin").toString();
			}
			String betTimeEnd = "";
			if (paramMap.containsKey("betTimeEnd")) {
				betTimeEnd = paramMap.get("betTimeEnd").toString();
			}
			String liveId = "";
			if (paramMap.containsKey("liveId")) {
				liveId = paramMap.get("liveId").toString();
			}
			String startTime = "";
			if (paramMap.containsKey("startTime")) {
				startTime = paramMap.get("startTime").toString();
			}
			String endTime = "";
			if (paramMap.containsKey("endTime")) {
				endTime = paramMap.get("endTime").toString();
			}
			String username = "";
			if (paramMap.containsKey("username")) {
				username = paramMap.get("username").toString();
			}
			String gameKind = "";
			if (paramMap.containsKey("gameKind")) {
				gameKind = paramMap.get("gameKind").toString();
			}
			String gameType = "";
			if (paramMap.containsKey("gameType")) {
				gameType = paramMap.get("gameType").toString();
			}
			String orderType = "";
			if (paramMap.containsKey("orderType")) {
				orderType = paramMap.get("orderType").toString();
			}

			if (StringUtils.isBlank(key)) {
				result.put("returnCode", 910002);
				result.put("returnMsg", "key is null");
				logger.info("key is null");
				return;
			}

			if (StringUtils.isBlank(siteId)) {
				result.put("returnCode", 910003);
				result.put("returnMsg", "siteId is null");
				logger.info("siteId is null");
				return;
			}
			if (StringUtils.isBlank(betTimeBegin)) {
				result.put("returnCode", 910004);
				result.put("returnMsg", "betTimeBegin is null");
				logger.info("betTimeBegin is null");
				return;
			}
			if (StringUtils.isBlank(betTimeEnd)) {
				result.put("returnCode", 910005);
				result.put("returnMsg", "betTimeEnd is null");
				logger.info("betTimeEnd is null");
				return;
			}
			if (StringUtils.isBlank(username)) {
				result.put("returnCode", 910006);
				result.put("returnMsg", "username is null");
				logger.info("username is null");
				return;
			}
			// if (StringUtils.isBlank(gameKind)) {
			// result.put("returnCode", 910007);
			// result.put("returnMsg", "gameKind is null");
			// logger.info("gameKind is null");
			// return;
			// }

			String param = key.substring(5);
			String str = param.substring(0, param.length() - 6);
			String md5 = siteId + username + liveId + gameKind + gameType + betTimeBegin + betTimeEnd + startTime
					+ endTime;
			logger.info("md5 str:" + md5);
			// 缓存中有数据
			String cacheName = "betTotalByDay:" + md5;
			Map<String, Object> cacheData = this.getCacheData(cacheName);
			if (cacheData.get("code").equals("1")) {
				logger.info("从缓存中读取数据");
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", cacheData.get("cacheData").toString());
				logger.info("total queryBetTotalByDay time : " + (System.currentTimeMillis() - start));
				return;
			}
			logger.info("md5:" + toMD5(md5) + ",str:" + str);
			String strgameKind = null;
			List<DsReport> dataList = null;
			// if (toMD5(md5).equals(str) || getMd5Valid().equals("0")) {
			DsReportExample m_example = this.generateSearchParam(paramMap);
			m_example.setOrderType(orderType);
			if (paramMap.containsKey("gameKind")) {
				strgameKind = paramMap.get("gameKind").toString();
				if (strgameKind.equals("1")) {// BBIN 球类
					dataList = this.dsBbinSportServiceImpl.queryBetTotalByDayNew(paramMap);
				} else if (strgameKind.equals("3")) { // BBIN视讯
					dataList = this.dsBbinLiveServiceImpl.queryBetTotalByDayNew(paramMap);
				} else if (strgameKind.equals("5")) {// BBIN 机率
					dataList = this.dsBbinJilvServiceImpl.queryBetTotalByDayNew(paramMap);
				} else if (strgameKind.equals("12")) {// BBIN 彩票

				} else if (strgameKind.equals("15")) {// BBIN 3D厅
					dataList = this.dsBbin3dServiceImpl.queryBetTotalByDayNew(paramMap);
				}else if("16".equals(strgameKind)){
					dataList = this.dtPtGameServiceImpl.queryBetTotalByDayNew(paramMap);

				}else if (strgameKind.equals("21") || strgameKind.equals("22")) { // 21
																					// AG视讯
																					// 22
																					// AG机率
					dataList = this.dsAgLiveServiceImpl.queryBetTotalByDayNew(paramMap);
				}else if("23".equals(strgameKind)){//Ag捕鱼
					dataList = this.hunterJackpotServiceImpl.queryBetTotalByDayNew(paramMap);
				}else if("24".equals(strgameKind)){//Ag体育
					dataList = this.agSportServiceImpl.queryBetTotalByDayNew(paramMap);
				} else if (strgameKind.equals("41")) { // DS视讯
					dataList = this.dsLiveServiceImpl.queryBetTotalByDayNew(paramMap);
				} else if (strgameKind.equals("51")||strgameKind.equals("57")||strgameKind.equals("58")||strgameKind.equals("59")) { // 彩票
					dataList = this.jingdianServiceImpl.queryBetTotalByDayNew(paramMap);
				} else if (strgameKind.equals("53")) { // ds电子游戏
					dataList = this.dsGameServiceImpl.queryBetTotalByDayNew(paramMap);
				} else if (strgameKind.equals("42")) {// h8体育
					dataList = this.dsH8ServiceImpl.queryBetTotalByDayNew(paramMap);
				} else if (strgameKind.equals("54")) {// ds香港彩
					dataList = this.dsLottoService.queryBetTotalByDayNew(paramMap);
				} else if (strgameKind.equals("55")) {// ds传统彩
					dataList = this.dsLotteryService.queryBetTotalByDayNew(paramMap);
				} else if (strgameKind.equals("52")) {// ds分分彩
					dataList = this.dsFenFenLottoServiceImpl.queryBetTotalByDayNew(paramMap);
				} else if (strgameKind.equals("60")) {// MG电子
					dataList = this.mgGameServiceImpl.queryBetTotalByDayNew(paramMap);
				}else if (strgameKind.equals("65")) {// PMG电子
					dataList = this.dtMGGameServiceImpl.queryBetTotalByDayNew(paramMap);
				} else if (strgameKind.equals("80")) {// 蛮牛
					dataList = this.manniuServiceImpl.queryBetTotalByDayNew(paramMap);
				} else if (strgameKind.equals("70")) {// OG
					dataList = this.oGLiveServiceImpl.queryBetTotalByDayNew(paramMap);
				}else if (strgameKind.equals("56")) {// 新官方彩
					dataList = this.gfLottoService.queryBetTotalByDayNew(paramMap);
				}else if (strgameKind.equals("18")) {// LMG视讯
					dataList = this.lmgServiceImpl.queryBetTotalByDayNew(paramMap);
				}else if (strgameKind.equals("90")) {// 开元棋牌
					dataList = this.kyChessServiceImpl.queryBetTotalByDayNew(paramMap);
				}else if("95".equals(strgameKind)){// SGS视讯
					dataList = this.sgsLiveServiceImpl.queryBetTotalByDayNew(paramMap);
				}else if("96".equals(strgameKind)){// SGS电子
					dataList = this.sgsGameServiceImpl.queryBetTotalByDayNew(paramMap);
				}else if ("30000".equals(strgameKind)) { // kkw视讯
					dataList = this.dsLiveServiceImpl.queryBetTotalByDayNew(paramMap);
				}
				
			} else {
				dataList = this.dsReportMapper.queryBetTotalByDay(m_example);
			}
			result.put("returnCode", 900000);
			result.put("returnMsg", "Success");
			result.put("dataList", this.convertToJson(dataList));
			this.setCacheData(cacheName, this.convertToJson(dataList));
			// } else {
			// result.put("returnCode", 910008);
			// result.put("returnMsg", "Key valid error");
			// logger.info("Key valid error");
			// }
			logger.info("total queryBetTotalByDay time : " + (System.currentTimeMillis() - start));
			logger.info("按用户/天统计汇总数queryBetTotalByDay end");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
			/*
			 * result.put("returnCode", 910001); result.put("returnMsg",
			 * "System error");
			 */
		}

	}

	

	

	/**
	 * 获取指定时间内的一个平台的信息
	 * 
	 * @param result
	 * @param obj
	 */
	public void getBetInfoByLiveId(com.alibaba.fastjson.JSONObject result, com.alibaba.fastjson.JSONObject obj) {
		LiveIdConfigExample e = new LiveIdConfigExample();
		e.createCriteria().andLiveIdEqualTo(obj.getInteger("liveId"));
		List<LiveIdConfig> configList = liveIdConfigMapper.selectByExample(e);
		List<DsReport> reportList = new ArrayList<DsReport>();
		for (LiveIdConfig liveIdConfig : configList) {
			// 处理时间（北京还是美东）
			formatTime(liveIdConfig, obj);
			DsReport report = reportDao.getBetInfoByLiveId(liveIdConfig, obj);
			reportList.add(report);
		}
		DsReport sumReport = new DsReport();
		sumReport.setBetamount(new BigDecimal(0));
		sumReport.setValidamount(new BigDecimal(0));
		sumReport.setWinlose(new BigDecimal(0));
		sumReport.setBetCount(0);
		sumReport.setGameKind(0);
		sumReport.setGameKindName("总计");
		// 循环list 得到总计的结果
		for (DsReport report : reportList) {
			sumReport.setBetamount(sumReport.getBetamount().add(report.getBetamount()));
			sumReport.setValidamount(sumReport.getValidamount().add(report.getValidamount()));
			sumReport.setWinlose(sumReport.getWinlose().add(report.getWinlose()));
			sumReport.setBetCount(sumReport.getBetCount() + report.getBetCount());
		}
		reportList.add(0, sumReport);
		result.put("returnCode", 900000);
		result.put("returnMsg", "Success");
		result.put("dataList", reportList);

	}

	// 把北京时间都要转换成美东时间
	private void formatTime(LiveIdConfig liveIdConfig, JSONObject obj) {
		Integer timeType = liveIdConfig.getTimeType();// 0:美东时间 1：北京时间
		Date betTimeBegin = obj.getDate("betTimeBegin");
		Date betTimeEnd = obj.getDate("betTimeEnd");
		if (timeType == 0) {// 美东时间，不用转换
			obj.put("formatTimeBegin", betTimeBegin);
			obj.put("formatTimeEnd", betTimeEnd);
		} else {
			obj.put("formatTimeBegin", DateUtil.addHours(betTimeBegin, -12));
			obj.put("formatTimeEnd", DateUtil.addHours(betTimeEnd, -12));
		}

	}

	/**
	 * 查看会员信息日志表
	 */
	public void queryMemberLogById(Long queryId, Map<String, Object> result) {
		List<MemberLogVo> memberLogList = reportDao.selectIMemberLogById(queryId);
		result.put("returnCode", 900000);
		result.put("returnMsg", "Success");
		result.put("dataList", memberLogList);
	}

	public void auditTotalTempBatch(Map<String, Object> param, Map<String, Object> result) {

		List<AuditTotalBatResult> dataList = new ArrayList<AuditTotalBatResult>();
		List<AuditTotalDateVo> list = new ArrayList<AuditTotalDateVo>();

		String username = (String) param.get("username");
		Integer siteId = Integer.parseInt(param.get("siteId").toString());
		JSONArray timeArray = (JSONArray) param.get("timeArray");
		AuditTotalBatParam queryParam = new AuditTotalBatParam();
		queryParam.setUsername(username);
		queryParam.setSiteId(siteId);

		for (int i = 0; i < timeArray.size(); i++) {
			AuditTotalDateVo vo = new AuditTotalDateVo();
			JSONObject timeJson = (JSONObject) timeArray.get(i);
			String startTime = (String) timeJson.get("startTime");
			String endTime = (String) timeJson.get("endTime");
			vo.setStartTime(startTime);
			vo.setEndTime(endTime);
			list.add(vo);

			if (list.size() == 10) {
				queryParam.setTimeList(list);
				dataList.addAll(reportDao.getAuditBat(queryParam));
				list.clear();
			} else if (timeArray.size() < 10 && timeArray.size() == list.size()) {
				queryParam.setTimeList(list);
				dataList.addAll(reportDao.getAuditBat(queryParam));
				list.clear();
			} else if (timeArray.size() - 1 == i) {
				queryParam.setTimeList(list);
				dataList.addAll(reportDao.getAuditBat(queryParam));
				list.clear();
			}
		}

		result.put("returnCode", 900000);
		result.put("returnMsg", "Success");
		result.put("dataList", dataList);
	}
	
		//	查询详细AG捕鱼 jackpot详细记录
		@RequestMapping(value="getDeatilRecord")
		public @ResponseBody Object getDeatilRecord(HttpServletRequest request) {
			String siteId = request.getParameter("siteId");
			String username = request.getParameter("username");
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			
			
			if(StringUtils.isBlank(username)){
				return "username不能为空";
			}
			if(StringUtils.isBlank(startTime)){
				return "startTime不能为空";
			}
			
			long start = System.currentTimeMillis();
			//liveService.manGetFtpData(date,apiInfo);
			long end = System.currentTimeMillis();
			return "ok,耗时："+(end - start);
		}

		//查询捕鱼王详细记录
	public void getDeatilRecord(Integer siteId,String username, Date startTime, Date endTime,int pageNum,int pageSize,Map<String,Object> resultJson) throws IOException{
		List<HunterDetailRecordVo> list=this.hunterJackpotServiceImpl.getDeatilRecord(siteId, username, startTime, endTime, pageNum, pageSize);
		HunterDetailTotalVo vo=this.hunterJackpotServiceImpl.getDeatilRecordCount(siteId, username, startTime, endTime);
		int pageCount=0;
		int count =0;
		
		if(null!=vo){
			count=vo.getCount();
			resultJson.put("sumBetAmount", vo.getSumBetAmount());
			resultJson.put("sumEarn", vo.getSumEarn());
			resultJson.put("sumWinlose", vo.getSumWinlose());
			resultJson.put("sumDrawAwardAll", vo.getSumDrawAwardAll());
			resultJson.put("sumHunterAwardAll", vo.getSumHunterAwardAll());

		}
		if(count%pageSize==0){
			pageCount=count/pageSize;
		}else{
			pageCount=(count/pageSize)+1;

		}
		

		resultJson.put("count", count);
		resultJson.put("pageCount", pageCount);
		resultJson.put("result", convertToJson(list));
		resultJson.put("returnCode", 900000);
		resultJson.put("returnMsg", "Success");
	}
	
	public void getJackpot(Map<String, Object> paramMap,
			Map<String, Object> result) {
		
		
		
		
	}
	/**按gameType分组查询报表统计**/
    public void getReportGroupByGameType(JSONObject result,int siteId,String username,Date startTime, Date endTime,int page,int pageLimit){
    	List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
    	int count=0;
    	DsReportExample example=new DsReportExample();
    	Criteria c=example.createCriteria();
    	if(0!=siteId){
    		c.andSiteIdEqualTo(siteId);
    	}
    	if(StringUtils.isNotBlank(username)){
    		c.andUsernameEqualTo(username);
    	}
    	if(null!=startTime && null!=endTime){
    		c.andBetTimeBetween(startTime, endTime);
    	}
    	if(page==0){
    		page=1;
    	}
    	if(pageLimit==0){
    		pageLimit=CommonUtils.pageLimit;
    	}
    	count=dsReportMapper.getReportGroupByGameTypeCount(example);
    	example.setPage((page - 1) * pageLimit);
		example.setPageLimit(pageLimit);
		list=dsReportMapper.getReportGroupByGameType(example);
		int pageCount=count/pageLimit+1;
		if(count%pageLimit==0){
			pageCount=count/pageLimit;
		}
		result.put("dataList", JSONArray.toJSONString(list));
		result.put("count", count);
		result.put("pageCount", pageCount);
    }
    /**按gameKind分表查询报表统计
     * @throws Exception **/
    public List<Map<String,Object>> getGroupByGameKindForTable(Integer siteId,String username,String startTime, String endTime) throws Exception{
    	List<Map<String,Object>> listMap=new ArrayList<Map<String,Object>>();
    	Map<String,String> sqlMap=new HashMap<String, String>();
    	Map<String,Object> paramMap=new HashMap<String, Object>();
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    	paramMap.put("siteId", siteId);
    	paramMap.put("username", username);
    	paramMap.put("startTime", sdf.parse(startTime));
    	paramMap.put("endTime", sdf.parse(endTime));
    	//查询dsreport中的下注彩种
    	List<Map<String,Object>> gameMapList=dsReportMapper.getGameKindsByUsername(paramMap);
    	//获取查询sql.
    	List<Map<String,Object>> listSqlMap=dsReportMapper.getDetailSqlMap();
    	for(Map<String,Object> map:listSqlMap){
    		sqlMap.put(map.get("gameKind").toString(),map.get("select_sql").toString());
    	}
    	for(Map<String,Object> gameMap : gameMapList){
    		String select_sql=sqlMap.get(gameMap.get("gameKind").toString());
    		if(StringUtils.isNotBlank(select_sql)){
    			select_sql=select_sql.replaceAll("param_username", username)
    		    		.replaceAll("param_startTime", startTime)
    		    		.replaceAll("param_endTime", endTime)
    		    		.replaceAll("param_siteId", siteId.toString())
    		    		.replaceAll("param_game_kind", gameMap.get("gameKind").toString())
    		    		.replaceAll("param_gameType", gameMap.get("gameType").toString());
        		List<Map<String,Object>> list=dsReportMapper.getDetailDataBySql(select_sql);
        		if(null!=list && list.size()>0){
        			Map<String,Object> m=list.get(0);
        			if(!"0".equals(m.get("betCount").toString())){
        				m.putAll(gameMap);
        				m.put("username", username);
            			listMap.add(m);
        			}
        		}
    		}else{
    			logger.info("sql未配置:{},{},{},{}",gameMap,username,startTime,endTime);
    		}
    	}
    	return listMap;
    }
    
    
    /**按gameType分组查询报表统计**/
    public void getTotalBySite(JSONObject result,String siteId,String beginTime, String endTime,int page,int pageLimit){
    	List<TotalBySiteVo> list=new ArrayList<TotalBySiteVo>();
    	int count=0;
    	if(page==0){
    		page=1;
    	}
    	if(pageLimit==0){
    		pageLimit=CommonUtils.pageLimit;
    	}
    	count=reportDao.getTotalBySiteCount(siteId, beginTime, endTime);
    	
    	page=((page - 1) * pageLimit);
		list=reportDao.getTotalBySite(siteId, beginTime, endTime, page, pageLimit);
		int pageCount=count/pageLimit+1;
		if(count%pageLimit==0){
			pageCount=count/pageLimit;
		}
		result.put("dataList", JSONArray.toJSON(list));
		result.put("count", count);
		result.put("pageCount", pageCount);
    }
    
}