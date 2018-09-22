package com.ds.live.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
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
import com.kg.live.entity.BbinLiveSportEntity;
import com.kg.live.entity.BbinLiveSportEntityExample;
import com.kg.live.entity.BbinPageRecord;
import com.kg.live.entity.BbinPageRecordExample;
import com.kg.live.mapper.BbinLiveSportEntityMapper;
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
	private BbinLiveSportEntityMapper bbinSportMapper;
	@Autowired
	private TempAuditTotalMapper tempAuditTotalMapper;
	
	//用于记录注单的md5值，以便下次对比，减少数据库的查询次数
	private Cache<String, String> cache = CacheBuilder.newBuilder().expireAfterWrite(10, TimeUnit.MINUTES).build();
	
	public void startPullBet(ApiInfoEntity api,String rounddate) {
		Integer siteId = api.getSiteId();
		String siteName = api.getSiteName();
		String reportUrl = "http://linkapi.s1116.com/app/WebService/JSON/display.php/";// 请求地址
		String uppername = api.getLiveKey();// 上级代理
		logger.info("开始拉取网站id：" + siteId + ",网站名称：" + siteName + ",体育请求地址："
				+ reportUrl + ",请求liveKey:" + uppername);
		try {
			getBet(siteId, siteName, reportUrl, uppername,rounddate);
		} catch (Exception e) {
			logger.error("错误信息：siteId = " + siteId,e);
		}
		
	}

	private void getBet(Integer siteId, String siteName, String reportUrl,
			String uppernameKey, String rounddate) {
		try {
			String uppername = uppernameKey; // 必须
			logger.info("网站名称：" + siteName + "bbin拉取日期" + rounddate);

			int gamekind = LiveConfig.BBIN_GAME_KIND_SPORT; // 体育
			int page = 1;
			// 从数据库读取page信息
			BbinPageRecord pageRecord = getPageRecord(siteId, rounddate,
					gamekind);
			if (pageRecord != null) {
				page = pageRecord.getPage();
				logger.info("网站：" + siteName + "数据库记录到到上次的page为" + page);
			} else {
				pageRecord = new BbinPageRecord();
			}

			int pagelimit = LiveConfig.BBIN_PAGE_LIMIT;
			boolean thisTimeFirst = true;
			for (int j = page; j <= page; j++) {// int j=page
												// 只有初始化的时候执行一次，此后将不再赋值
				String tempParam = LiveConfig.BBIN_LIVE_WEBSITE
						+ LiveConfig.BBIN_BETRECORD_KEY
						+ BBINDateUtils.getGMT4Date(new Date());
				String param = getBBINParam(uppername, rounddate, gamekind, page, pagelimit, tempParam);
				JSONObject obj = null;
				try {
					// 每次第一次进入的时候要验证上页的数据是否有变化,
					// 拉取到最后一页的时候需要验证上一页是否有变化
					if (thisTimeFirst == true || (page - j) <= 1) {
						validateLastPage(siteId, siteName, uppername,
								rounddate, gamekind, pagelimit, j, reportUrl);
						thisTimeFirst = false;
					}
					logger.info("网站：" + siteName + "bbin param:" + param);
					obj = JSONObject.fromObject(WebHTTPUtils.sendPost1(
							reportUrl + "WagersRecordBy1", param));
				} catch (Exception e) {
					logger.info("网站：" + siteName + "此次请求失败.....");
					j--;
					Thread.sleep(SLEEPLONGTIME);
					continue;
				}

				logger.info("网站：" + siteName + "bbin请求路径:" + reportUrl
						+ "WagersRecordBy1?" + param);
				if (obj.has("result")) {
					if (obj.getBoolean("result")) {
						JSONArray dataArray = obj.getJSONArray("data");

						if (obj.has("pagination")) {
							JSONObject jo = JSONObject.fromObject(obj
									.getString("pagination"));// 格式化成json对象
							page = jo.getInt("TotalPage");
						}
						// 插入或更新到数据库
						insertUpdateDb(dataArray, gamekind, siteId, siteName,
								uppername);

					}// end result = true
					else {
						logger.info("网站：" + siteName + "请求api结果为："+obj.toString()+",稍后将重试.....");
						break; //新开网站会造成死循环
						// 没有结果当前页不能增加
						/*j--;
						Thread.sleep(SLEEPLONGTIME);*/
					}
				}// end obj.has("result")

			}// end forech page

			pageRecord.setDate(rounddate);
			pageRecord.setPage(page);
			pageRecord.setSiteId(siteId);
			pageRecord.setGameKind(gamekind);
			Integer upflag = pageRecordMapper
					.updateByPrimaryKeySelective(pageRecord);
			if (upflag == null || upflag == 0) {
				pageRecordMapper.insert(pageRecord);
				logger.info("网站：" + siteName + "数据库插入记录page"
						+ pageRecord.getPage());
			} else {
				logger.info("网站：" + siteName + "已经数据库更新记录page"
						+ pageRecord.getPage());
			}
			/****************************/
		} catch (Exception e) {
			e.printStackTrace();
			try {
				logger.info("网站：" + siteName + "bbin拉取数据异常，线程降休眠:"
						+ e.getMessage());
				Thread.sleep(SLEEPLONGTIME);//
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private String getBBINParam(String uppername,String rounddate,int gamekind,int page,int pagelimit,String tempParam){
		StringBuffer sb = new StringBuffer();
		sb.append("website="+LiveConfig.BBIN_LIVE_WEBSITE);
		sb.append("&action=BetTime");
		sb.append("&uppername="+uppername);
		sb.append("&date="+rounddate);
		sb.append("&starttime=00:00:00");
		sb.append("&endtime=23:59:59");
//		sb.append("&gamekind="+gamekind);
		sb.append("&page="+page);
		sb.append("&pagelimit="+pagelimit);
		sb.append("&key="+DataUtils.randomString(7)+DataUtils.toMD5(tempParam)+DataUtils.randomString(2));
		return sb.toString();
	}
	
	private void validateLastPage(Integer siteId, String siteName,
			String uppername, String rounddate, int gamekind, int pagelimit,
			int nowPage, String reportUrl) {
		int page = nowPage-1;
		logger.info("网站："+siteName+"开始检查上页page="+page+"数据是否有变化");
		if(page <= 0){
			logger.info("网站："+siteName+"没有上页数据.......");
			return;
		}
		while(true){
			String tempParam = LiveConfig.BBIN_LIVE_WEBSITE+LiveConfig.BBIN_BETRECORD_KEY
					+BBINDateUtils.getGMT4Date(new Date());
			String param = getBBINParam(uppername, rounddate, gamekind, page, pagelimit, tempParam);
			logger.info("网站"+siteName+"bbin param:" + param);
			JSONObject obj = null;
			try{
				obj = JSONObject.fromObject(WebHTTPUtils.sendPost1(reportUrl+"WagersRecordBy1",param));
				if(obj.has("result")){
					if(obj.getBoolean("result")){
						JSONArray dataArray = obj.getJSONArray("data");
						insertUpdateDb(dataArray,gamekind,siteId,siteName,uppername);
						break;
					}//result = true
					else{
						logger.info("网站：" + siteName + "开始检查上页page=" + page + "请求失败,重新请求...");
						Thread.sleep(SLEEPLONGTIME);
						continue;
					}
				}//has result
				else{
					logger.info("网站：" + siteName + "开始检查上页page=" + page + "请求失败,重新请求...");
					Thread.sleep(SLEEPLONGTIME);
					continue;
				}
			}catch(Exception e){
				logger.info("网站："+siteName+"此次请求失败.....");
				try {
					Thread.sleep(SLEEPLONGTIME);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				continue;
			}
		}//end while
		
		
	}
	private void insertUpdateDb(JSONArray dataArray, int gamekind,
			Integer siteId, String siteName, String uppername) {
		for(int i=0; i<dataArray.size(); i++){//当前页条目数，如果
			JSONObject dataJson = dataArray.getJSONObject(i);
			String betMd5Str = DataUtils.toMD5(dataJson.toString());
			//检查缓存cache，如果换成有此数据，则直接跳过
			String mapBetMd5 = cache.getIfPresent(betMd5Str);
			if (StringUtils.isNotBlank(mapBetMd5)) {
				continue;
			}
			
			if(null == dataJson.getString("UserName") && "".equals(dataJson.getString("UserName"))){
				continue;
			}
			BbinLiveSportEntity liveEntity = getRecordByWagersid(dataJson.getString("WagersID"),gamekind);
			boolean updateFlag = false;
			if(liveEntity == null){
				liveEntity = new BbinLiveSportEntity();
			}else{
				updateFlag = true;
			}
			liveEntity.setBbinGameKind((byte)gamekind);
			String userNameStr = dataJson.getString("UserName").substring(LiveConfig.BBIN_NAME_PRE_LENGTH,
						dataJson.getString("UserName").length());
			liveEntity.setUserName(userNameStr);
			liveEntity.setSiteId(siteId);
			liveEntity.setBbinWebsite(LiveConfig.BBIN_LIVE_WEBSITE);
			liveEntity.setUppername(uppername);
			liveEntity.setWagersId(dataJson.getString("WagersID"));
			liveEntity.setWagersDate(Timestamp.valueOf(dataJson.getString("WagersDate")));
			liveEntity.setGameType(dataJson.getString("GameType"));
			liveEntity.setResult(dataJson.getString("Result"));
			liveEntity.setBetAmount(new BigDecimal(dataJson.getDouble("BetAmount")).setScale(2, BigDecimal.ROUND_HALF_UP));
			liveEntity.setPayOff(new BigDecimal(dataJson.getDouble("Payoff")).setScale(2, BigDecimal.ROUND_HALF_UP));
			liveEntity.setCommissionable(new BigDecimal(dataJson.getDouble("Commissionable")).setScale(2, BigDecimal.ROUND_HALF_UP));//有效下注金额
			//Result	注单结果
			/*	N：没有结果
			C：注销
			W：赢L：输
			LW：赢一半
			LL：输一半
			0：平手
			D：未接受
			F：非法下注注销
			X：未结算
			S：等待中
			*/
			String result = dataJson.getString("Result");
			logger.info("网站："+siteName+"bbin体育注单号"+ dataJson.getString("WagersID")+"result:"+result);
	    	if("C".equals(result)
	    			||"F".equals(result)
	    			||"D".equals(result)
	    			){
				liveEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_CANCEL);//注单取消
			}else if("X".equals(result)
					||"S".equals(result)){
			}else if("W".equals(result)
					||"LW".equals(result)
					||"LL".equals(result)
					||"L".equals(result)
					||"0".equals(result)){
				if(dataJson.getDouble("Payoff")==0.0){//和
					setUpdateTime(liveEntity);
					liveEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_HE);//
				}else if(dataJson.getDouble("Payoff") > 0.0){//赢
					setUpdateTime(liveEntity);
					liveEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_WIN);
				}else if(dataJson.getDouble("Payoff") < 0.0){//输
					setUpdateTime(liveEntity);
					liveEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_LOSE);
				}
			}
	    	//新加字段
	    	liveEntity.setCurrency(dataJson.getString("Currency"));
	    	liveEntity.setExchangeRate(dataJson.getString("ExchangeRate"));
	    	liveEntity.setModifiedDate(Timestamp.valueOf(dataJson.getString("UPTIME")));
	    	liveEntity.setOrderDate(java.sql.Date.valueOf(dataJson.getString("OrderDate")));
	    	if(StringUtils.isNotBlank(dataJson.getString("PayoutTime")) && 
	    			!"null".equals(dataJson.getString("PayoutTime"))){
	    		liveEntity.setPayoutTime(Timestamp.valueOf(dataJson.getString("PayoutTime")));
	    	}
	    	if(StringUtils.isNotBlank(dataJson.getString("AccountDate")) &&
	    			!"null".equals(dataJson.getString("AccountDate"))){
	    		liveEntity.setAccountDate(java.sql.Date.valueOf(dataJson.getString("AccountDate")));
	    	}
	    	
			if(updateFlag){
				setUpdateTime(liveEntity);
				bbinSportMapper.updateByPrimaryKey(liveEntity);
				logger.info("网站："+siteName+"bbin修改:" + dataJson.getString("WagersID"));
			}else{
				liveEntity.setCreateTime(new Date());
				logger.info("网站："+siteName+"BBIN新增:" + dataJson.getString("WagersID"));
				bbinSportMapper.insert(liveEntity);
			}
			//添加到map
			cache.put(betMd5Str, dataJson.getString("WagersID"));
			logger.info("temp_audit_total start");
			AuditTotalVO audit = new AuditTotalVO();
			audit.setBetTime(Timestamp.valueOf(dataJson.getString("WagersDate")));
			audit.setUsername(userNameStr);
			audit.setLiveId(PlatFormEnum.BBIN.getValue());
			audit.setGameName(AuditGameNameEnum.BBIN_SPORT.toString());
			audit.setType(PlatformTypeEnum.SPROT.getValue());
			audit.setOrderNo(dataJson.getString("WagersID"));
			audit.setPayAmount(new BigDecimal(dataJson.getDouble("Payoff")).setScale(2, BigDecimal.ROUND_HALF_UP));
			audit.setBetAmount(new BigDecimal(dataJson.getDouble("BetAmount")).setScale(2, BigDecimal.ROUND_HALF_UP));
			audit.setValidAmount(new BigDecimal(dataJson.getDouble("Commissionable")).setScale(2, BigDecimal.ROUND_HALF_UP));
			tempAuditTotalMapper.insertOrupdate(audit, liveEntity.getSiteId());
			logger.info("temp_audit_total end");
		}//end forech arr.size
		
	}
	
	
	private BbinLiveSportEntity getRecordByWagersid(String wagersid, int gamekind){
		BbinLiveSportEntityExample e = new BbinLiveSportEntityExample();
		e.createCriteria().andWagersIdEqualTo(wagersid).andBbinGameKindEqualTo((byte)gamekind);
		List<BbinLiveSportEntity> list = bbinSportMapper.selectByExample(e);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	private void setUpdateTime(BbinLiveSportEntity liveEntity){
		Date time = liveEntity.getUpdateTime();
		if(time == null){
			liveEntity.setUpdateTime(new Date());
		}
	}
	
	private BbinPageRecord getPageRecord(Integer siteId, String date, Integer gamekind) {
		BbinPageRecordExample e = new BbinPageRecordExample();
		e.createCriteria().andSiteIdEqualTo(siteId).andDateEqualTo(date).andGameKindEqualTo(gamekind);
		List<BbinPageRecord> list = pageRecordMapper.selectByExample(e);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
