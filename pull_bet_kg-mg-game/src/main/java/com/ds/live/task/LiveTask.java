package com.ds.live.task;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ds.live.dao.DsLiveDao;
import com.ds.live.service.DsLiveServiceImp;
import com.ds.live.until.MD5Util;
import com.ds.live.until.MGDateUtil;
import com.ds.live.vo.MgRecordTimeVo;
import com.ds.temp.entity.AuditTotalVO;
import com.ds.temp.mapper.TempAuditTotalMapper;
import com.kg.live.contants.AuditGameNameEnum;
import com.kg.live.contants.PlatFormEnum;
import com.kg.live.contants.PlatformTypeEnum;
import com.kg.live.entity.MGGameConfig;
import com.kg.live.entity.MGGameEntity;
import com.kg.live.entity.MGGameEntityExample;
import com.kg.live.entity.MGRecordTimeEntity;
import com.kg.live.entity.MGRecordTimeEntityExample;
import com.kg.live.mapper.MGGameEntityMapper;
import com.kg.live.mapper.MGRecordTimeEntityMapper;

public class LiveTask implements Runnable {
	private Logger logger = Logger.getLogger(this.getClass());
	
	
	private DsLiveDao dsLiveDao;
	
	private DsLiveServiceImp liveService;
	private MGGameEntityMapper mgGameMapper;
	
	private MGGameConfig config;
	private TempAuditTotalMapper tempAuditTotalMapper;
	private MGRecordTimeEntityMapper mgRecordTimeEntityMapper;
	private Map<String,Integer> siteIdMap;
	private Set<String> betMd5Set = new HashSet<String>();
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public LiveTask(DsLiveServiceImp liveService, MGGameConfig config,Map<String,Integer> siteIdMap) {
		super();
		this.liveService = liveService;
		mgGameMapper = liveService.getMgGameMapper();
		this.config = config;
		this.tempAuditTotalMapper = liveService.getTempAuditTotalMapper();
		this.siteIdMap = siteIdMap;
		this.dsLiveDao = liveService.getDsLiveDao();
		this.mgRecordTimeEntityMapper = liveService.getMgRecordTimeEntityMapper();
	}

	@Override
	public void run() {
		Thread.currentThread().setName(config.getAgentCode());

		while (liveService.getAipInfoList() != null && liveService.getAipInfoList().size() > 0) {
			String agentCode = config.getAgentCode();
			String agentPre = config.getAgentPre();
			String reportUrl = config.getUrl();
			Long agentId = config.getAgentId();
			String agentName = config.getpUsm();
			String agentPwd = config.getpPwd();
			logger.info("开始拉取代理：" + agentCode + ",代理前缀：" + agentPre + ",请求地址：" + reportUrl + ",请求agentId:" + agentId);
			try {
				if(betMd5Set.size() > 50000){
					betMd5Set.clear();
				}
				getBet(agentCode, agentPre, reportUrl, agentId,agentName,agentPwd); //拉取数据

				logger.info("代理：" + agentCode + "一次拉取完成，休眠一分钟......");
				Thread.sleep(1000*60);
			} catch (Exception e) {
				e.printStackTrace();
				logger.info("拉取出错" + agentCode + "错误信息：" + e.getMessage());
			}

		}
		//线程已经停止，线程计数器+1
		DsLiveServiceImp.stopCount.getAndIncrement();
		logger.info("线程" + Thread.currentThread().getName() + "已停止......");
	}
	
	public void getBet(String agentCode, String agentPre, String reportUrl,
			Long agentId, String agentName, String agentPwd) {
		try {
			String token = getToken(agentName, agentPwd);
			if (token == null) {
				logger.error("代理：-----" + agentCode + "-----获取token异常。。");
				return;
			}
			JSONObject json = JSONObject.parseObject(token);
			String tokenStr = json.getString("token");
			System.out.println("---------------tokenStr-----------" + tokenStr);
			
			MGRecordTimeEntity mgRecordTimeEntity = getMGRecordTime(agentId.toString());
			if(mgRecordTimeEntity==null){
				mgRecordTimeEntity = new MGRecordTimeEntity();
				mgRecordTimeEntity.setLastGetRecordTime(MGDateUtil.getGMT8Date(new Date()));
				mgRecordTimeEntity.setAgent(agentId.toString());
			}
			
			MgRecordTimeVo mgRecordTimeVo = getEndTime(mgRecordTimeEntity.getLastGetRecordTime(),MGDateUtil.getGMT8Date(new Date()));
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
			String startTime = sdf.format(mgRecordTimeVo.getStartTime());
			String endTime = sdf.format(mgRecordTimeVo.getEndTime());
			
			String betListStr = getBetList(tokenStr,startTime,endTime);
//			System.out.println("-------------betListStr ----------------- "
//				+ betListStr);
			
			JSONArray array = JSONArray.parseArray(betListStr);
			if (array == null || array.size() <= 0) {
				logger.info("-------array------为空.........");
				updateTime(mgRecordTimeEntity,mgRecordTimeVo.getEndTime());
				return;
			}
			
			int preLength = agentPre.length(); 
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			BigDecimal amountDec = null;
			MGGameEntity mgGameEntity = null;
			int flag = 0;//用于记录此次插入或者更新数据库的数量
			for (int i = 0; i < array.size(); i++) {

				JSONObject dataObject = array.getJSONObject(i);
				String str = dataObject.toString();
				String md5Str = MD5Util.toMD5(str);
				
				if(betMd5Set.contains(md5Str)){
					logger.info("-------colId:------" + dataObject.getString("colId") + "--------数据已经存在.........");
					continue;
				}
				flag++;
				String type = dataObject.getString("type");
				String colId = dataObject.getString("colId");
				
				String mbrUsername = dataObject.getString("mbrUsername");
				String username = mbrUsername.substring(preLength+2, mbrUsername.length());
				
				String siteIdStr = mbrUsername.substring(4, 6);								
				Integer siteId = null;
				if(!siteIdStr.equals("") && siteIdStr != null){
					siteId = siteIdMap.get(siteIdStr);
				}
				/**
				 * by guangguang 2017.3.2没有用到的数据不保存到数据库
				 */
				if(siteId == null){
					continue;
				}
				String gameKey = dataObject.getString("gameKey");
				String[] gameKeyList = gameKey.split(":");
				gameKey = gameKeyList[1];
				
				String horKey = dataObject.getString("key");
				String[] horKeyList = horKey.split(":");
				horKey = horKeyList[1];
				
				String horNeKey = dataObject.getString("horNeKey");
				String[] horNeKeyList = horNeKey.split(":");
				horNeKey = horNeKeyList[1];
				
				String mbrNeKey = dataObject.getString("mbrNeKey");
				String[] mbrNeKeyList = mbrNeKey.split(":");
				mbrNeKey = mbrNeKeyList[1];
				
				Long time = new Long(dataObject.getString("transactionTimestampDate"));
			//	time = time - 1000*60*60*12;
				String transactionTimestamp = format.format(time);
				Date transactionTimestampDate = format.parse(transactionTimestamp);
				
				amountDec = new BigDecimal(dataObject.getString("amount"));
			
				if(("mgsaspibet").equals(type)){
					mgGameEntity = getMGGame(colId);
					
					if (mgGameEntity != null) {
						logger.info("colId------" + colId + "----- 投注注单已经存在");
						continue;
					}	
					mgGameEntity  = new MGGameEntity();
					mgGameEntity.setSiteid(siteId);
					mgGameEntity.setPlayername(mbrUsername);
					mgGameEntity.setUsername(username);
					mgGameEntity.setHorKey(horKey);
					mgGameEntity.setBetColId(dataObject.getString("colId"));
					mgGameEntity.setHorNeKey(horNeKey);
					mgGameEntity.setMbrNeKey(mbrNeKey);
					mgGameEntity.setBetTransKey(dataObject.getString("betTransKey"));
					mgGameEntity.setGameKey(gameKey);
					mgGameEntity.setGameCode(gameKey);
					mgGameEntity.setType(dataObject.getString("type"));
					mgGameEntity.setProduct(dataObject.getString("product"));
					mgGameEntity.setTransactionTimestampDate(transactionTimestampDate);
					mgGameEntity.setAmount(amountDec);
					mgGameEntity.setValidateAmount(amountDec);
					mgGameEntity.setMbrCode(dataObject.getString("mbrCode"));
					mgGameEntity.setMbrAlias(dataObject.getString("mbrAlias"));
					mgGameEntity.setGameCasinoId(dataObject.getString("gameCasinoId"));
					mgGameEntity.setGamePokerId(dataObject.getString("gamePokerId"));
					mgGameEntity.setGamePokerType(dataObject.getString("gamePokerType"));
					mgGameEntity.setRefKey(dataObject.getString("refKey"));
					mgGameEntity.setRefType(dataObject.getString("refType"));
					mgGameEntity.setAfterTxWalletAmount(new BigDecimal(dataObject.getString("afterTxWalletAmount")));
					mgGameEntity.setMgsGameId(dataObject.getString("mgsGameId"));
					mgGameEntity.setMgsActionId(dataObject.getString("mgsActionId"));
					mgGameEntity.setClrngAmnt(new BigDecimal(dataObject.getString("clrngAmnt")));
					mgGameEntity.setGamePlatformType(dataObject.getString("gamePlatformType"));
					mgGameEntity.setTransactionTimestamp(time);
					mgGameEntity.setCreateTime(new Date());
					
					mgGameMapper.insert(mgGameEntity);				
					logger.info("colId-------" + colId + "-----------注单新增操作........");					
				}else if(("mgsapiwin").equals(type)){						
					mgGameEntity = getMGGameWin(mbrUsername,gameKey,dataObject.getString("mgsGameId"));					
					if(mgGameEntity == null){						
						logger.info("colId-------" + colId + "----------此派彩注单无对应下注注单........");
						continue;
					}
					if(mgGameEntity.getWinColIds() != null && mgGameEntity.getWinColIds().contains(colId)){
						logger.info("colId-------" + colId + "-----------此派彩注单已经存在........");
						continue;
					}else{						
						if(mgGameEntity.getPayoff() != null){
							BigDecimal payoffDec = mgGameEntity.getPayoff();
							payoffDec = payoffDec.add(amountDec);
							mgGameEntity.setPayoff(payoffDec);
							
							String winColIds = mgGameEntity.getWinColIds()+","+dataObject.getString("colId");
							mgGameEntity.setWinColIds(winColIds);
						}else {
							mgGameEntity.setWinColIds(dataObject.getString("colId"));
							BigDecimal payOff = amountDec.subtract(mgGameEntity.getAmount());
							mgGameEntity.setPayoff(payOff);
							
						}
						int paySize = mgGameEntity.getPayoff().compareTo(BigDecimal.ZERO);							
						if(paySize < 0){
							mgGameEntity.setWinLoseType(1);
						}
						else if(paySize > 0){
							mgGameEntity.setWinLoseType(2);
						}
						else if(paySize == 0){
							mgGameEntity.setWinLoseType(3);
						}
						mgGameEntity.setLastUpdateTime(new Date());
						mgGameMapper.updateByPrimaryKey(mgGameEntity);
						logger.info("colId------" + colId + "---------更新派彩注单........");
					}					
				
				}//end if type= mgsapiwin
				
				logger.info("temp_audit_total start");
				AuditTotalVO audit = new AuditTotalVO();
				audit.setBetTime(Timestamp.valueOf(transactionTimestamp));
				audit.setUsername(mgGameEntity.getUsername());
				audit.setLiveId(PlatFormEnum.MG.getValue());
				audit.setGameName(AuditGameNameEnum.MG_GAME.toString());
				audit.setType(PlatformTypeEnum.GAME.getValue());
				audit.setOrderNo(mgGameEntity.getBetColId());
				audit.setPayAmount(mgGameEntity.getAmount().negate().setScale(2, BigDecimal.ROUND_HALF_UP));
				audit.setBetAmount(mgGameEntity.getAmount().setScale(2,BigDecimal.ROUND_HALF_UP));
				audit.setValidAmount(mgGameEntity.getAmount().setScale(2,BigDecimal.ROUND_HALF_UP));
				tempAuditTotalMapper.insertOrupdate(audit, siteId);
				logger.info("temp_audit_total end");
				

				String strData = dataObject.toString();
				String md5StrData = MD5Util.toMD5(strData);
				betMd5Set.add(md5StrData);
			}//end foreach
			
			//更新payoff为空的
			if(flag > 0){
				dsLiveDao.updatePayoff();
				logger.info("-----------------更新payoff为空的注单-----------------");
			}
			//更新时间
			updateTime(mgRecordTimeEntity,mgRecordTimeVo.getEndTime());
			
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public void updateTime(MGRecordTimeEntity mgRecordTimeEntity,Date endTimeDate){
		mgRecordTimeEntity.setLastGetRecordTime(endTimeDate);
		
		if(mgRecordTimeEntity.getLastUpdateTime() == null){
			mgRecordTimeEntity.setLastUpdateTime(endTimeDate);
			mgRecordTimeEntityMapper.insert(mgRecordTimeEntity);
		}else{
			mgRecordTimeEntityMapper.updateByPrimaryKey(mgRecordTimeEntity);
		}
		
	}
	public String getBetList(String token,String startTime,String endTime){
		HttpClient httpClients =  HttpClientBuilder.create().build();
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(60000).setConnectTimeout(60000).build();
		String httpStr = config.getUrl();
		String agentID = config.getAgentId().toString();
		String url = httpStr+"lps/secure/hortx/"+agentID+"?start="+startTime+"&end="+endTime+"&timezone=Asia/Shanghai";
		
		System.out.println(url);
		HttpGet request = new HttpGet(url);
		request.addHeader("X-Requested-With", "X-Api-Client");
		request.addHeader("X-Api-Call", "X-Api-Client");
		request.addHeader("X-Api-Auth", token);
		HttpResponse response=null;
		String result = null;
		try {
			request.setConfig(requestConfig);
			response = httpClients.execute(request);
			result = EntityUtils.toString(response.getEntity());
			
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	@SuppressWarnings("deprecation")
	public String getToken(String p_usm,String p_pwd){
		
		HttpClient httpClients =  HttpClientBuilder.create().build();
		String httpStr = config.getUrl();
		String url=httpStr+"lps/j_spring_security_check?j_username="+p_usm+"&j_password="+p_pwd;
		
		HttpPost request = new HttpPost(url);
	    HttpResponse response=null;
	 
		try {
			
			request.addHeader("X-Requested-With", "X-Api-Client");
			request.addHeader("X-Api-Call", "X-Api-Client");
			
			response = httpClients.execute(request);
			
			String token=EntityUtils.toString(response.getEntity());
			return token;

			 
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			httpClients.getConnectionManager().shutdown();
		}		
		return null;
		 
	}
	
	//查询colId是否存在
	private  MGGameEntity getMGGame(String colId) {
		
		MGGameEntityExample e = new  MGGameEntityExample();
		e.createCriteria().andBetColIdEqualTo(colId);
		List<MGGameEntity> list = mgGameMapper.selectByExample(e);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	//查询注单记录时间表
	private  MGRecordTimeEntity getMGRecordTime(String agentId) {		
		MGRecordTimeEntityExample e = new  MGRecordTimeEntityExample();
		e.createCriteria().andAgentEqualTo(agentId);
		List<MGRecordTimeEntity> list = mgRecordTimeEntityMapper.selectByExample(e);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	//查询派彩注单是否存在
	private  MGGameEntity getMGGameWin(String mbrUsername,String gameKey,String mgsGameId ) {
		
		MGGameEntityExample e = new  MGGameEntityExample();
		e.createCriteria().andPlayernameEqualTo(mbrUsername).andGameCodeEqualTo(gameKey).andMgsGameIdEqualTo(mgsGameId);
		List<MGGameEntity> list = mgGameMapper.selectByExample(e);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	//计算距离上次拉取时间
	public MgRecordTimeVo getEndTime(Date startTimeDate,Date endTimeDate){
		MgRecordTimeVo mgRecordTimeVo = new MgRecordTimeVo();
		Long endTimeLong = endTimeDate.getTime();
		Long startTimeLong = startTimeDate.getTime();
		Long diff = endTimeLong - startTimeLong;
		//long nd = 1000*24*60*60;//一天的毫秒数
		long nh = 1000*60*60;//一小时的毫秒数
		long hour = diff/nh;//计算差多少小时
		
		if(hour>1){
			endTimeLong = startTimeLong + nh;
		}else{
			startTimeLong = endTimeLong - nh;
		}
		
		mgRecordTimeVo.setEndTime(new Date(endTimeLong));
		mgRecordTimeVo.setStartTime(new Date(startTimeLong));
		
		return mgRecordTimeVo;		
	}
	
	public DsLiveDao getDsLiveDao() {
		return dsLiveDao;
	}

	public void setDsLiveDao(DsLiveDao dsLiveDao) {
		this.dsLiveDao = dsLiveDao;
	}
}
