package com.ds.live.task;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

import com.ds.live.until.*;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.onetwo.common.utils.DateUtil;

import com.ds.live.service.DsLiveServiceImp;
import com.ds.temp.entity.AuditTotalVO;
import com.ds.temp.mapper.TempAuditTotalMapper;
import com.kg.live.contants.AuditGameNameEnum;
import com.kg.live.contants.PlatFormEnum;
import com.kg.live.contants.PlatformTypeEnum;
import com.kg.live.entity.ApiInfoEntity;
import com.kg.live.entity.BbinLiveJilvEntity;
import com.kg.live.entity.BbinLiveJilvEntityExample;
import com.kg.live.entity.BbinPageRecord;
import com.kg.live.entity.BbinPageRecordExample;
import com.kg.live.mapper.BbinLiveJilvEntityMapper;
import com.kg.live.mapper.BbinPageRecordMapper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class LiveTask implements Runnable{
	private Logger logger = Logger.getLogger(this.getClass());
	
	private DsLiveServiceImp liveService;
	private ApiInfoEntity api;
	private BbinLiveJilvEntityMapper bbinLiveMapper;
	private BbinPageRecordMapper pageRecordMapper;
	private BbinPageRecord pageRecord;
	private BbinPageRecord sweetPageRecord;
	private BbinPageRecord sweet2PageRecord;
	private BbinPageRecord lhdbPageRecord;
	
	private TempAuditTotalMapper tempAuditTotalMapper;
	public LiveTask(DsLiveServiceImp liveService, ApiInfoEntity api) {
		super();
		this.liveService = liveService;
		this.api = api;
		bbinLiveMapper = liveService.getBbinLiveMapper();
		pageRecordMapper = liveService.getPageRecordMapper();
		
		this.tempAuditTotalMapper = liveService.getTempAuditTotalMapper();
	}
	
	@Override
	public void run() {
		Thread.currentThread().setName(api.getSiteName());
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> betMd5Map = new HashMap<String,Object>();
		
		//糖果派对
		Map<String,Object> mapSweet = new HashMap<String,Object>();
		Map<String,Object> betMd5MapSweet = new HashMap<String,Object>();
		
		//糖果派对2
		Map<String,Object> mapSweetTwo = new HashMap<String,Object>();
		Map<String,Object> betMd5MapSweetTwo = new HashMap<String,Object>();
		
		//连环夺宝
		Map<String,Object> mapLianhuan = new HashMap<String,Object>();
		Map<String,Object> betMd5MapLianhuan = new HashMap<String,Object>();
		
		while(liveService.getAipInfoList()!=null && liveService.getAipInfoList().size()>0){
			Integer siteId = api.getSiteId();
			String siteName = api.getSiteName();
			//String reportUrl = "http://180.150.154.97:8080/dtbbinrecordapi/game/bbin/api/";
			String reportUrl = BBINCommon.URL;
			String uppername = api.getLiveKey();
			logger.info("开始拉取网站id："+siteId+",网站名称："+siteName+",机率请求地址："+reportUrl+",请求liveKey:"+uppername);
			try {
				//	Thread.sleep(5000);
				getBet(siteId,siteName,reportUrl,uppername,map,betMd5Map);
				
				//糖果派对注单拉取
				getSweetBet(siteId,siteName,reportUrl,uppername,mapSweet,betMd5MapSweet);
				//糖果派对2注单拉取
				getSweetBetTwo(siteId,siteName,reportUrl,uppername,mapSweetTwo,betMd5MapSweetTwo);
				//连环夺宝注单拉取
				getLianhuanBet(siteId, siteName, reportUrl, uppername, mapLianhuan, betMd5MapLianhuan);
			} catch (Exception e) {
				e.printStackTrace();
				logger.info("错误信息："+e.getMessage());
			}
			
		}
		//线程已经停止，线程计数器+1
		DsLiveServiceImp.stopCount.getAndIncrement();
		logger.info("线程"+Thread.currentThread().getName()+"已停止......");
	}

	private void getBet(Integer siteId, String siteName, String reportUrl,
			String uppername, Map<String, Object> map,Map<String, Object> betMd5Map) {
		
		logger.info("网站名称："+siteName+"bbin机率正式开始拉取数据......");
		String rounddate = BBINDateUtils.getBBINRounddate(new Date());
		logger.info("网站名称："+siteName+"bbin机率拉取日期"+rounddate);
		
		/*********加入page实体类数据库记录********************/
		if(map == null || map.size() == 0){
			//从数据库读取page信息
			pageRecord = getPageRecord(siteId, rounddate, LiveConfig.BBIN_GAME_KIND_JL);
			if(pageRecord != null){
				logger.info("网站："+siteName+"数据库记录到到上次的page为"+pageRecord.getPage());
			}else{
				pageRecord = new BbinPageRecord();
				pageRecord.setPage(1);
				pageRecord.setDate(rounddate);
				pageRecord.setSiteId(siteId);
				pageRecord.setGameKind(LiveConfig.BBIN_GAME_KIND_JL);
			}
		}else{
			Integer lastPage = (Integer) map.get("page");
			String lastRoundDate = (String) map.get("rounddate");
			if(rounddate.equals(lastRoundDate)){//同一天，则可以接着读
				if(lastPage!= null && lastPage!=0){
					logger.info("网站："+siteName+"已经读取到上次的page为"+lastPage);
				}
			}else{
				//已经到第二天，则map清空，验证前一天数据
				logger.info("网站："+siteName+"日期已不同，map将清空,验证前一天数据"+uppername+" date:"+lastRoundDate+",page:"+lastPage);
				sendBBINPost(pageRecord, lastRoundDate, uppername, siteName, siteId, reportUrl, map, betMd5Map, 1, "");
				map.clear();
				pageRecord.setId(null);
				pageRecord.setDate(rounddate);
			}
		}
		sendBBINPost(pageRecord, rounddate, uppername, siteName, siteId, reportUrl, map, betMd5Map, 1, "");
		logger.info("网站："+siteName+"bbin 正式环境拉取一次数据完成，线程将休眠1分钟:");
		ThreadUtil.sleep(1000*60*2L);
	}
	
	/*
	 * 糖果派对 拉取数据
	 */
	private void getSweetBet(Integer siteId, String siteName, String reportUrl,
			String uppername, Map<String, Object> map,Map<String, Object> betMd5Map) {
		logger.info("网站名称："+siteName+"bbin机率 糖果派对 正式开始拉取数据......");
		String rounddate = BBINDateUtils.getBBINRounddate(new Date());
		logger.info("网站名称："+siteName+"bbin机率糖果派对拉取日期"+rounddate);

		/*********加入page实体类数据库记录********************/
		if(map == null || map.size() == 0){
			//从数据库读取page信息
			sweetPageRecord = getPageRecord(siteId, rounddate,LiveConfig.BBIN_GAME_KIND_JL*10);
			if(sweetPageRecord != null){
				logger.info("网站："+siteName+"数据库记录#糖果派对#到上次的page为"+sweetPageRecord.getPage());
			}else{
				sweetPageRecord = new BbinPageRecord();
				sweetPageRecord.setPage(1);
				sweetPageRecord.setDate(rounddate);
				sweetPageRecord.setSiteId(siteId);
				sweetPageRecord.setGameKind(LiveConfig.BBIN_GAME_KIND_JL*10);
			}
		}else{
			Integer lastPage = (Integer) map.get("page");
			String lastRoundDate = (String) map.get("rounddate");
			if(rounddate.equals(lastRoundDate)){//同一天，则可以接着读
				if(lastPage!= null && lastPage!=0){
					logger.info("网站："+siteName+"已经读取到糖果派对上次的page为"+lastPage);
				}
			}else{
				//已经到第二天，则map清空，验证前一天数据
				logger.info("网站："+siteName+"日期已不同，map将清空,糖果派对验证前一天数据"+uppername+" date:"+lastRoundDate+",page:"+lastPage);
				sendBBINPost(sweetPageRecord, lastRoundDate, uppername, siteName, siteId, reportUrl, map, betMd5Map, 2, "糖果派对");
				map.clear();
				sweetPageRecord.setId(null);
				sweetPageRecord.setDate(rounddate);
			}
		}
		sendBBINPost(sweetPageRecord, rounddate, uppername, siteName, siteId, reportUrl, map, betMd5Map, 2, "糖果派对");
		logger.info("网站："+siteName+"bbin 正式环境糖果派对拉取一次数据完成，线程将休眠1分钟:");
		ThreadUtil.sleep(1000*60*2L);
	}
	
	/*
	 * 糖果派对2 注单拉取
	 * */
	private void getSweetBetTwo(Integer siteId, String siteName, String reportUrl,
			String uppername, Map<String, Object> map,Map<String, Object> betMd5Map) {
		logger.info("网站名称："+siteName+"bbin机率 糖果派对2 正式开始拉取数据......");
		String rounddate = BBINDateUtils.getBBINRounddate(new Date());
		logger.info("网站名称："+siteName+"bbin机率糖果派对2拉取日期"+rounddate);
		/*********加入page实体类数据库记录********************/
		if(map == null || map.size() == 0){
			//从数据库读取page信息，电子游戏gamekind为5，*11为糖果派对2的
			sweet2PageRecord = getPageRecord(siteId, rounddate,LiveConfig.BBIN_GAME_KIND_JL*11);
			if(sweet2PageRecord != null){
				logger.info("网站："+siteName+"数据库记录#糖果派对2#到上次的page为"+sweet2PageRecord.getPage());
			}else{
				sweet2PageRecord = new BbinPageRecord();
				sweet2PageRecord.setPage(1);
				sweet2PageRecord.setDate(rounddate);
				sweet2PageRecord.setSiteId(siteId);
				sweet2PageRecord.setGameKind(LiveConfig.BBIN_GAME_KIND_JL*11);
			}
		}else{
			Integer lastPage = (Integer) map.get("page");
			String lastRoundDate = (String) map.get("rounddate");
			if(rounddate.equals(lastRoundDate)){//同一天，则可以接着读
				if(lastPage!= null && lastPage!=0){
					logger.info("网站："+siteName+"已经读取到糖果派对2上次的page为"+lastPage);
				}
			}else{
				//已经到第二天，则map清空，验证前一天数据
				logger.info("网站："+siteName+"日期已不同，map将清空,糖果派对2验证前一天数据"+uppername+" date:"+lastRoundDate+",page:"+lastPage);
				sendBBINPost(sweet2PageRecord, lastRoundDate, uppername, siteName, siteId, reportUrl, map, betMd5Map, 5, "糖果派对2");
				map.clear();
				sweet2PageRecord.setId(null);
				sweet2PageRecord.setDate(rounddate);
			}
		}
		sendBBINPost(sweet2PageRecord, rounddate, uppername, siteName, siteId, reportUrl, map, betMd5Map, 5, "糖果派对2");
		logger.info("网站："+siteName+"bbin 正式环境糖果派对2拉取一次数据完成，线程将休眠1分钟:");
		ThreadUtil.sleep(1000*60*2L);
	}
	
	/**
	 * 连环夺宝 注单拉取
	 */ 
	private void getLianhuanBet(Integer siteId, String siteName, String reportUrl, String uppername, 
			Map<String, Object> map, Map<String, Object> betMd5Map){
    	logger.info("网站名称：" + siteName + "bbin机率 连环夺宝 正式开始拉取数据......");
    	String rounddate = BBINDateUtils.getBBINRounddate(new Date());
    	logger.info("网站名称：" + siteName + "bbin机率连环夺宝拉取日期" + rounddate);
    	if ((map == null) || (map.size() == 0)){
    		lhdbPageRecord = getPageRecord(siteId, rounddate, LiveConfig.BBIN_GAME_KIND_JL*200);
    		if (lhdbPageRecord != null){
    			logger.info("网站：" + siteName + "数据库记录#连环夺宝#到上次的page为" + lhdbPageRecord.getPage());
    		}else{
    			lhdbPageRecord = new BbinPageRecord();
    			lhdbPageRecord.setPage(1);
    			lhdbPageRecord.setDate(rounddate);
    			lhdbPageRecord.setSiteId(siteId);
    			lhdbPageRecord.setGameKind(LiveConfig.BBIN_GAME_KIND_JL*200);
    		}
    	}else{
    		Integer lastPage = (Integer)map.get("page");
    		String lastRoundDate = (String)map.get("rounddate");
    		if (rounddate.equals(lastRoundDate)){
    			if(lastPage!= null && lastPage!=0){
    				logger.info("网站：" + siteName + "已经读取到连环夺宝上次的page为" + lastPage);
    			}
    		}else{
    			//已经到第二天，则map清空，验证前一天数据
				logger.info("网站："+siteName+"日期已不同，map将清空,连环夺宝验证前一天数据"+uppername+" date:"+lastRoundDate+",page:"+lastPage);
				sendBBINPost(lhdbPageRecord, lastRoundDate, uppername, siteName, siteId, reportUrl, map, betMd5Map, 3, "连环夺宝");
				map.clear();
				lhdbPageRecord.setId(null);
				lhdbPageRecord.setDate(rounddate);
    		}
    	}
    	sendBBINPost(lhdbPageRecord, rounddate, uppername, siteName, siteId, reportUrl, map, betMd5Map, 3, "连环夺宝");
    	ThreadUtil.sleep(1000*60*2L);
	}
	
	
	private void validateLastPage(Integer siteId,String siteName,String uppername,String rounddate,
			int nowPage,String reportUrl, Map<String, Object> map,Map<String, Object> betMd5Map,int subgamekind) {
		int page = nowPage-1;
		logger.info("网站："+siteName+"开始检查上页page="+page+"数据是否有变化");
		if(page <= 0){
			logger.info("网站："+siteName+"没有上页数据.......");
			return;
		}
		//验证上页md5
		String md5 = (String) map.get("pageMd5");
		if(StringUtils.isBlank(md5)){
			logger.info("网站"+siteName+"page="+page+"未找到md5值......");
		}
		while(true){
			String param = getSendParam(uppername, rounddate, page, subgamekind);
			logger.info("网站"+siteName+"bbin 机率获取上页数据拉取参数 param:" + param);
			JSONObject obj = null;
			try{
				/*************************/
				obj = JSONObject.fromObject(WebHTTPUtils.sendPost1(reportUrl+"BetRecord",param));
				if(obj.has("result")){
					if(obj.getBoolean("result")){
						JSONArray dataArray = obj.getJSONArray("data");
						String dataArrayMd5 = DataUtils.toMD5(dataArray.toString());
						if(dataArrayMd5.equals(md5)){
							logger.info("网站："+siteName+"page="+page+"没有发生变化");
						}else{
							logger.info("网站："+siteName+"page="+page+"发生了变化,需要重新读取......");
							insertUpdateDb(dataArray,siteId,siteName,uppername,betMd5Map);
							map.put("pageMd5", dataArrayMd5);
						}
						
						break;
					}//result = true
					else{
						continue;
					}
				}//has result
				else{
					continue;
				}
			}catch(Exception e){
				logger.info("网站："+siteName+"此次请求失败.....");
				ThreadUtil.sleep(1000*60L);
				continue;
			}
		}//end while
	}
	
	private void insertUpdateDb(JSONArray dataArray,int siteId,String siteName,String uppername, Map<String, Object> betMd5Map){
		for(int i=0; i<dataArray.size(); i++){
			/****************************/
			JSONObject dataJson = dataArray.getJSONObject(i);
			String betMd5 = DataUtils.toMD5(dataJson.toString());
			String mapBetMd5 = (String) betMd5Map.get(betMd5);
			if(StringUtils.isNotBlank(mapBetMd5)){
				continue;
			}
			/****************************/
			BbinLiveJilvEntity liveEntity = getBBINLiveByWagersid(dataJson.getString("WagersID"),LiveConfig.BBIN_GAME_KIND_JL);
			//	BbinLiveEntity liveEntity = getBBINLiveByWagersid(dataJson.getString("WagersID"),gamekind);
			boolean updateFlag = false;
			if(liveEntity == null){
				liveEntity = new BbinLiveJilvEntity();
			}else{
				updateFlag = true;
			}
			liveEntity.setBbinGameKind(LiveConfig.BBIN_GAME_KIND_JL.byteValue());
			
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
			String wagerDate = dataJson.getString("WagersDate");
			liveEntity.setBetDate(DateUtil.parseByPatterns(wagerDate,"YYYY-MM-dd"));
			//有效投注金额
			liveEntity.setCommissionable(new BigDecimal(dataJson.getDouble("Commissionable")).setScale(2, BigDecimal.ROUND_HALF_UP));//有效下注金额
			
			//-1：注销、1：赢、200：输
	    	/*if("-1".equals(dataJson.getString("Result"))
	    			){
				liveEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_CANCEL);//注单取消
			}else if("1".equals(dataJson.getString("Result"))){
				liveEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_WIN);
			}else if("200".equals(dataJson.getString("Result"))){
				liveEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_LOSE);
			}*/
	    	
			if("-1".equals(dataJson.getString("Result"))){
				liveEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_CANCEL);//注单取消
			}else if ("0".equals(dataJson.getString("Result"))
					||"-77".equals(dataJson.getString("Result"))){
			}else if (dataJson.getDouble("Payoff") > 0){
				liveEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_WIN);
			}else if(dataJson.getDouble("Payoff") < 0){
				liveEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_LOSE);
			}else if(dataJson.getDouble("Payoff") == 0.0){
				liveEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_HE);
			}
			
	    //	logger.info("网站："+siteName+"bbin....WinLossType:::"+liveEntity.getWinLossType()+"######bbin 视讯正式开始拉取数据  pay:"+dataJson.getDouble("Payoff"));
			if(updateFlag){  //视讯修改的时候不用判断
				
				//0 表示注单未修改  4表示注单被取消
				liveEntity.setUpdateTime(new Date());
				bbinLiveMapper.updateByPrimaryKey(liveEntity);
				
			}else{
				liveEntity.setCreateTime(new Date());
				bbinLiveMapper.insert(liveEntity);
			}
			/******************/
			//添加到map
			betMd5Map.put(betMd5, dataJson.getString("WagersID"));
			/******************/
			
			AuditTotalVO audit = new AuditTotalVO();
			audit.setBetTime(Timestamp.valueOf(dataJson.getString("WagersDate")));
			audit.setUsername(userNameStr);
			audit.setLiveId(PlatFormEnum.BBIN.getValue());
			audit.setGameName(AuditGameNameEnum.BBIN_GAME.toString());
			audit.setType(PlatformTypeEnum.GAME.getValue());
			audit.setOrderNo(dataJson.getString("WagersID"));
			audit.setPayAmount(new BigDecimal(dataJson.getDouble("Payoff")).setScale(2, BigDecimal.ROUND_HALF_UP));
			audit.setBetAmount(new BigDecimal(dataJson.getDouble("BetAmount")).setScale(2, BigDecimal.ROUND_HALF_UP));
			audit.setValidAmount(new BigDecimal(dataJson.getDouble("Commissionable")).setScale(2, BigDecimal.ROUND_HALF_UP));
			tempAuditTotalMapper.insertOrupdate(audit, liveEntity.getSiteId());
	    	
		}//end forech arr.size
	}
	private BbinLiveJilvEntity getBBINLiveByWagersid(String wagersid, int gamekind){
		BbinLiveJilvEntityExample e = new BbinLiveJilvEntityExample();
		e.createCriteria().andWagersIdEqualTo(wagersid);
		List<BbinLiveJilvEntity> list = bbinLiveMapper.selectByExample(e);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	private BbinPageRecord getPageRecord(Integer siteId,String date,Integer gameKind){
		BbinPageRecordExample e = new BbinPageRecordExample();
		e.createCriteria().andSiteIdEqualTo(siteId).andDateEqualTo(date).andGameKindEqualTo(gameKind);
		List<BbinPageRecord> list = pageRecordMapper.selectByExample(e);
		if(list != null && list.size() >0){
			return list.get(0);
		}
		return null;
	}
	
	private void insertOrUpdateRecord(String siteName, BbinPageRecord pageRecord){
		if(pageRecord.getId() == null){
			pageRecordMapper.insert(pageRecord);
			logger.info("网站："+siteName+"，数据库插入记录page="+pageRecord.getPage()+"，gameKind="+pageRecord.getGameKind());
		}else{
			pageRecordMapper.updateByPrimaryKeySelective(pageRecord);
			logger.info("网站："+siteName+"，数据库更新记录page="+pageRecord.getPage()+"，gameKind="+pageRecord.getGameKind());
		}
	}
	
	private String getSendParam(String uppername, String rounddate, int page, int subgamekind){
		/*String key = getKey();
		StringBuffer sb = new StringBuffer();
		sb.append("website=").append(LiveConfig.BBIN_LIVE_WEBSITE);
		sb.append("&uppername=").append(uppername);
		sb.append("&rounddate=").append(rounddate);
		sb.append("&starttime=00:00:00");
		sb.append("&endtime=23:59:59");
		sb.append("&gamekind=").append(LiveConfig.BBIN_GAME_KIND_JL);
		sb.append("&subgamekind=").append(subgamekind);
		sb.append("&page=").append(page);
		sb.append("&pagelimit=").append(LiveConfig.BBIN_PAGE_LIMIT);
		sb.append("&key=").append(key);
		return sb.toString();*/
		Map<String,String> paramMap = new TreeMap<String,String>(){{
			put("uppername",uppername);
			put("rounddate",rounddate);
			put("starttime","00:00:00");
			put("endtime","23:59:59");
			put("gamekind",String.valueOf(subgamekind));
			put("page",String.valueOf(page));
			put("pagelimit", String.valueOf(LiveConfig.BBIN_PAGE_LIMIT));
		}};
		String param =  BBINCommon.mapToString(paramMap);
		String key = EncryptUtils.encrypt(param, BBINCommon.USERKEY);
		param+="&key="+key;
		return param;
	}
	
	private String getKey(){
		String tempParam = LiveConfig.BBIN_LIVE_WEBSITE+LiveConfig.BBIN_BETRECORD_KEY+BBINDateUtils.getGMT4Date(new Date());
		String key = DataUtils.randomString(7) + DataUtils.toMD5(tempParam) + DataUtils.randomString(2);
		return key;
	}
	
	private void sendBBINPost(BbinPageRecord pageRecord, String rounddate, String uppername, String siteName,int siteId,
			String reportUrl, Map<String, Object> map, Map<String, Object> betMd5Map, int subgamekind, String subgamekindMsg){
		try{
			int page = pageRecord.getPage();
			for(int j=page;j<=page;j++){//int j=page 只有初始化的时候执行一次，此后将不再赋值
				//随机修几秒
				Thread.sleep((int)(Math.random()*10)*1000);
				String param = getSendParam(uppername, rounddate, j, subgamekind);
				logger.info("网站："+siteName+"bbin机率"+subgamekindMsg+"正式拉取参数 param:" + param);
				JSONObject obj = null;
				try{
					/************************/
					//检查上页是否有变化
					if((page-j)<3){
						validateLastPage(siteId, siteName, uppername, rounddate, j, reportUrl, map, betMd5Map,subgamekind);
					}
					/*************************/
					obj = JSONObject.fromObject(WebHTTPUtils.sendPost1(reportUrl+"BetRecord",param));
				}catch(Exception e){
					logger.info("网站："+siteName+"此次请求失败.....");
					j--;
					Thread.sleep(1000*60);
					continue;
				}
				
				logger.info("网站："+siteName+"bbin机率"+subgamekindMsg+"请求路径:" + reportUrl+"BetRecord?"+param);
				if(obj.has("result")){
					if(obj.getBoolean("result")){
						JSONArray dataArray = obj.getJSONArray("data");
						if(obj.has("pagination")){
							JSONObject jo=JSONObject.fromObject(obj.getString("pagination"));//格式化成json对象
							page = jo.getInt("TotalPage");
						}
						//插入或更新到数据库
						insertUpdateDb(dataArray,siteId,siteName,uppername,betMd5Map);
						/*************/
						if(dataArray.size() == LiveConfig.BBIN_PAGE_LIMIT && (j<page)){
							 String pageMd5 = DataUtils.toMD5(dataArray.toString());
							 map.put("pageMd5", pageMd5);
							 betMd5Map.clear();//满一页，就可以清除以前的条目的md5值，只记录当前页的md5值
							 
						}
						/*************/
						
					}// end result = true
					else{
						logger.info("网站："+siteName+"请求api为false,稍后将重试，"+subgamekindMsg+"返回信息为："+obj.getString("result"));
						//没有结果当前页不能增加
						j--;
						Thread.sleep((int)(Math.random()*10)*1000);
					}
				}//end obj.has("result")
				
			}//end forech page
			
			//设置map
			map.put("page", page);//当前页
			map.put("rounddate", rounddate);
			logger.info("网站："+siteName+"已经记录"+subgamekindMsg+"map"+map);
			/****************************/
			pageRecord.setPage(page);
			insertOrUpdateRecord(siteName, pageRecord);
			/****************************/
		}catch(Exception e){
			e.printStackTrace();
			logger.info("网站："+siteName+"bbin 正式环境拉取"+subgamekindMsg+"数据异常，线程降休眠1分钟:"+e.getMessage());
			map.clear();
			pageRecord = null;
			ThreadUtil.sleep(1000*60*2L);
		}
	}
			

}
