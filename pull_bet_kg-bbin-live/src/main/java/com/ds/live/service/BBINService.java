package com.ds.live.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.onetwo.common.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.live.until.BBINDateUtils;
import com.ds.live.until.DataUtils;
import com.ds.live.until.LiveConfig;
import com.ds.live.until.WebHTTPUtils;
import com.ds.temp.entity.AuditTotalVO;
import com.ds.temp.mapper.TempAuditTotalMapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.kg.live.contants.AuditGameNameEnum;
import com.kg.live.contants.PlatFormEnum;
import com.kg.live.contants.PlatformTypeEnum;
import com.kg.live.entity.ApiInfoEntity;
import com.kg.live.entity.BbinLiveEntity;
import com.kg.live.entity.BbinLiveEntityExample;
import com.kg.live.entity.BbinPageRecord;
import com.kg.live.entity.BbinPageRecordExample;
import com.kg.live.mapper.BbinLiveEntityMapper;
import com.kg.live.mapper.BbinPageRecordMapper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service
public class BBINService {
	private Logger logger = Logger.getLogger(getClass());
	private static final Long SLEEPLONGTIME = 2000L;
	@Autowired
	private BbinPageRecordMapper pageRecordMapper;
	@Autowired
	private BbinLiveEntityMapper bbinLiveMapper;
	@Autowired
	private TempAuditTotalMapper tempAuditTotalMapper;
	//用于记录注单的md5值，以便下次对比，减少数据库的查询次数
	private Cache<String, String> cache = CacheBuilder.newBuilder().expireAfterWrite(10, TimeUnit.MINUTES).build();
	
	
	public void startPullBet(ApiInfoEntity api,String rounddate) {
		Integer siteId = api.getSiteId();
		String siteName = api.getSiteName();
		String reportUrl = api.getReporturl();// 视讯请求地址
		String uppername = api.getLiveKey();// bb视讯上级代理
		logger.info("开始拉取网站id：" + siteId + ",网站名称：" + siteName + ",视讯请求地址："
				+ reportUrl + ",请求liveKey:" + uppername);
		try {
			getBet(rounddate, api);
		} catch (Exception e) {
			logger.error("错误信息：siteId = " + siteId,e);
		}
		
	}
	
	private void getBet(String rounddate, ApiInfoEntity config) {
		logger.info("网站名称：" + config.getSiteName() + "bbin视讯正式开始拉取数据......");
		logger.info("网站名称：" + config.getSiteName() + "bbin视讯拉取日期" + rounddate);

		//从数据库获取上次该网站视讯读到哪一期
		BbinPageRecord pageRecord = getPageRecord(config.getSiteId(), rounddate);
		if (pageRecord != null) {
			logger.info("网站：" + config.getSiteName() + "数据库记录到到上次的page为" + pageRecord.getPage());
		} else {
			pageRecord = new BbinPageRecord();
			pageRecord.setPage(1);
			pageRecord.setDate(rounddate);
			pageRecord.setSiteId(config.getSiteId());
			pageRecord.setGameKind(LiveConfig.BBIN_GAME_KIND_LIVE);
			//新的一天验证前一天数据
			String lastDate = BBINDateUtils.getBBINRounddate(DateUtil.addDay(new Date(), -1));
			BbinPageRecord yesPageRecord = getPageRecord(config.getSiteId(), lastDate);
			if(yesPageRecord != null){
				logger.info("网站："+config.getSiteName()+"日期已不同，开始验证前一天数据 date："+lastDate+"，数据库记录到到上次的page为" + yesPageRecord.getPage());
				sendBBINPost(config, rounddate, yesPageRecord);
			}
		}
		sendBBINPost(config, rounddate, pageRecord);
	}
	
	private void validateLastPage(String rounddate,int nowPage,ApiInfoEntity config) {
		int page = nowPage - 1;
		logger.info("网站：" + config.getSiteName() + "开始检查上页page=" + page + "数据是否有变化");
		if (page <= 0) {
			logger.info("网站：" + config.getSiteName() + "没有上页数据.......");
			return;
		}
		while (true) {
			String param = getSendParam(config, rounddate, page);
			logger.info("网站" + config.getSiteName() + "bbin param:" + param);
			JSONObject obj = null;
			try {
				/*************************/
				obj = JSONObject.fromObject(WebHTTPUtils.sendPost1(config.getReporturl() + "BetRecord", param));
				if (obj.has("result")) {
					if (obj.getBoolean("result")) {
						JSONArray dataArray = obj.getJSONArray("data");
						insertUpdateDb(dataArray, config);
						break;
					}//result = true
					else {
						logger.info("网站：" + config.getSiteName() + "开始检查上页page=" + page + "请求失败,重新请求...");
						Thread.sleep(SLEEPLONGTIME);
						continue;
					}
				}//has result
				else {
					Thread.sleep(SLEEPLONGTIME);
					continue;
				}
			} catch (Exception e) {
				logger.info("网站：" + config.getSiteName() + "此次请求失败,重新请求...");
				try {
					Thread.sleep(SLEEPLONGTIME);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				continue;
			}
		}
	}
	
	private void sendBBINPost(ApiInfoEntity config, String rounddate, BbinPageRecord pageRecord){
		try {
			int page = pageRecord.getPage();
			boolean thisTimeFirst = true;
			for (int j = page; j <= page; j++) {//int j=page 只有初始化的时候执行一次，此后将不再赋值
				String param = getSendParam(config, rounddate, j);
				logger.info("网站：" + config.getSiteName() + "bbin视讯正式拉取参数 param:" + param);
				//每次第一次进入的时候要验证上页的数据是否有变化,
				//拉取到最后一页的时候需要验证上一页是否有变化
				//检查上页是否有变化，如果有变化，则更新到数据库
				if(thisTimeFirst == true || (page-j) <= 1){
					validateLastPage(rounddate, j, config);
					thisTimeFirst = false;
				}
				
				JSONObject obj = null;
				try {
					obj = JSONObject.fromObject(WebHTTPUtils.sendPost1(config.getReporturl() + "BetRecord", param));
				} catch (Exception e) {
					logger.info("网站：" + config.getSiteName() + "此次请求失败.....");
					j--;
					Thread.sleep(SLEEPLONGTIME);
					continue;
				}
				if (obj.has("result")) {
					if (obj.getBoolean("result")) {
						JSONArray dataArray = obj.getJSONArray("data");

						if (obj.has("pagination")) {
							JSONObject jo = JSONObject.fromObject(obj.getString("pagination"));//格式化成json对象
							page = jo.getInt("TotalPage");
						}
						//插入或更新到数据库
						insertUpdateDb(dataArray, config);

					}// end result = true
					else {
						logger.info("网站：" + config.getSiteName() + "请求api为false,稍后将重试.....");
						break;
						//没有结果当前页不能增加,--新开网站无数据会卡死
						/*j--;
						Thread.sleep(SLEEPLONGTIME);*/
					}
				}//end obj.has("result")

			}//end forech page
			pageRecord.setPage(page);
			if(pageRecord.getId() == null){
				pageRecordMapper.insert(pageRecord);
				logger.info("网站：" + config.getSiteName() + "数据库插入记录page" + pageRecord.getPage());
			}else{
				pageRecordMapper.updateByPrimaryKeySelective(pageRecord);
				logger.info("网站：" + config.getSiteName() + "已经数据库更新记录page" + pageRecord.getPage());
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				logger.info("网站：" + config.getSiteName() + "bbin 正式环境拉取数据异常，线程降休眠1分钟:" + e.getMessage());
				Thread.sleep(SLEEPLONGTIME);//
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private String getSendParam(ApiInfoEntity config, String rounddate, int page){
		String key = getKey();
		StringBuffer sb = new StringBuffer();
		sb.append("website=").append(LiveConfig.BBIN_LIVE_WEBSITE);
		sb.append("&uppername=").append(config.getLiveKey());
		sb.append("&rounddate=").append(rounddate);
		sb.append("&starttime=00:00:00");
		sb.append("&endtime=23:59:59");
		sb.append("&gamekind=").append(LiveConfig.BBIN_GAME_KIND_LIVE);
		sb.append("&page=").append(page);
		sb.append("&pagelimit=").append(LiveConfig.BBIN_PAGE_LIMIT);
		sb.append("&key=").append(key);
		return sb.toString();
	}
	
	private String getKey(){
		String tempParam = LiveConfig.BBIN_LIVE_WEBSITE + LiveConfig.BBIN_BETRECORD_KEY + BBINDateUtils.getGMT4Date(new Date());
		String key = DataUtils.randomString(7) + DataUtils.toMD5(tempParam) + DataUtils.randomString(2);
		return key;
	}
	
	private void insertUpdateDb(JSONArray dataArray,ApiInfoEntity config) {
		for (int i = 0; i < dataArray.size(); i++) {//当前页条目数，如果
			
			JSONObject dataJson = dataArray.getJSONObject(i);
			String betMd5Str = DataUtils.toMD5(dataJson.toString());
			//检查缓存cache，如果缓存有此数据，则直接跳过
			String mapBetMd5 = cache.getIfPresent(betMd5Str);
			if (StringUtils.isNotBlank(mapBetMd5)) {
				continue;
			}
			BbinLiveEntity liveEntity = getBBINLiveByWagersid(dataJson.getString("WagersID"));
			boolean updateFlag = false;
			if (liveEntity == null) {
				//如果派彩为0.则有可能此局尚未结束，则可以先不插入，下次拉取插入即可
				if(dataJson.getDouble("Payoff") == 0.0){
					Calendar nowTime = Calendar.getInstance();
					nowTime.add(Calendar.MINUTE, -5);
					if(nowTime.getTimeInMillis() - Timestamp.valueOf(dataJson.getString("WagersDate")).getTime() > 0){
						liveEntity = new BbinLiveEntity();
					}else{
						continue;
					}
				}else{
					liveEntity = new BbinLiveEntity();
				}
			} else {
				updateFlag = true;
			}

			String userNameStr = dataJson.getString("UserName").substring(LiveConfig.BBIN_NAME_PRE_LENGTH, dataJson.getString("UserName").length());
			liveEntity.setUserName(userNameStr);
			liveEntity.setSiteId(config.getSiteId());
			liveEntity.setBbinWebsite(LiveConfig.BBIN_LIVE_WEBSITE);
			liveEntity.setUppername(config.getLiveKey());
			liveEntity.setWagersId(dataJson.getString("WagersID"));
			liveEntity.setWagersDate(Timestamp.valueOf(dataJson.getString("WagersDate")));
			liveEntity.setSerialId(dataJson.getString("SerialID"));
			liveEntity.setRoundNo(dataJson.getString("RoundNo"));
			liveEntity.setGameType(Integer.valueOf(dataJson.getString("GameType")));
			liveEntity.setGameCode(dataJson.getString("GameCode"));
			liveEntity.setResult(dataJson.getString("Result"));
			liveEntity.setCard(dataJson.getString("Card"));
			liveEntity.setResultType(dataJson.getString("ResultType"));
			liveEntity.setBetAmount(new BigDecimal(dataJson.getDouble("BetAmount")).setScale(2, BigDecimal.ROUND_HALF_UP));
			liveEntity.setPayOff(new BigDecimal(dataJson.getDouble("Payoff")).setScale(2, BigDecimal.ROUND_HALF_UP));

			//有效投注金额
			liveEntity.setCommissionable(new BigDecimal(dataJson.getDouble("Commissionable")).setScale(2, BigDecimal.ROUND_HALF_UP));//有效下注金额

			if ("-1".equals(dataJson.getString("ResultType"))) {
				liveEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_CANCEL);// 注单取消
			} else if ("0".equals(dataJson.getString("ResultType"))) {
			} else {
				if ((dataJson.getString("Result") != null)
						&& (!"".equals(dataJson.getString("Result")))) {
					if (dataJson.getDouble("Payoff") == 0.0) {// 和
						liveEntity
								.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_HE);//
					} else if (dataJson.getDouble("Payoff") > 0.0) {// 赢
						liveEntity
								.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_WIN);
					} else if (dataJson.getDouble("Payoff") < 0.0) {// 输
						liveEntity
								.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_LOSE);
					}
				}
			}

			if (updateFlag) { //视讯修改的时候不用判断
				//0 表示注单未修改  4表示注单被取消
				liveEntity.setUpdateTime(new Date());
				bbinLiveMapper.updateByPrimaryKey(liveEntity);
				logger.info("网站：" + config.getSiteName() + "bbin视讯修改:" + dataJson.getString("WagersID"));
			} else {
				liveEntity.setCreateTime(new Date());
				logger.info("网站：" + config.getSiteName() + "视讯新增:" + dataJson.getString("WagersID"));
				bbinLiveMapper.insert(liveEntity);
			}
			/******************/
			//添加到map
			cache.put(betMd5Str, dataJson.getString("WagersID"));
			/******************/
			logger.info("temp_audit_total start");
			AuditTotalVO audit = new AuditTotalVO();
			audit.setBetTime(Timestamp.valueOf(dataJson.getString("WagersDate")));
			audit.setUsername(userNameStr);
			audit.setLiveId(PlatFormEnum.BBIN.getValue());
			audit.setGameName(AuditGameNameEnum.BBIN_LIVE.toString());
			audit.setType(PlatformTypeEnum.LIVE.getValue());
			audit.setOrderNo(dataJson.getString("WagersID"));
			audit.setPayAmount(new BigDecimal(dataJson.getDouble("Payoff")).setScale(2, BigDecimal.ROUND_HALF_UP));
			audit.setBetAmount(new BigDecimal(dataJson.getDouble("BetAmount")).setScale(2, BigDecimal.ROUND_HALF_UP));
			audit.setValidAmount(new BigDecimal(dataJson.getDouble("Commissionable")).setScale(2, BigDecimal.ROUND_HALF_UP));
			tempAuditTotalMapper.insertOrupdate(audit, liveEntity.getSiteId());
			logger.info("temp_audit_total end");
		}//end forech arr.size
	}
	private BbinLiveEntity getBBINLiveByWagersid(String wagersid) {
		BbinLiveEntityExample e = new BbinLiveEntityExample();
		e.createCriteria().andWagersIdEqualTo(wagersid);
		List<BbinLiveEntity> list = bbinLiveMapper.selectByExample(e);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	private BbinPageRecord getPageRecord(Integer siteId, String date) {
		BbinPageRecordExample e = new BbinPageRecordExample();
		e.createCriteria().andSiteIdEqualTo(siteId).andDateEqualTo(date).andGameKindEqualTo(LiveConfig.BBIN_GAME_KIND_LIVE);
		List<BbinPageRecord> list = pageRecordMapper.selectByExample(e);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
