package com.ds.live.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.ds.live.until.*;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.temp.entity.AuditTotalVO;
import com.ds.temp.mapper.TempAuditTotalMapper;
import com.kg.live.contants.AuditGameNameEnum;
import com.kg.live.contants.PlatFormEnum;
import com.kg.live.contants.PlatformTypeEnum;
import com.kg.live.entity.ApiInfoEntity;
import com.kg.live.entity.ApiInfoEntityExample;
import com.kg.live.entity.BbinLiveSportEntity;
import com.kg.live.entity.BbinLiveSportEntityExample;
import com.kg.live.mapper.ApiInfoEntityMapper;
import com.kg.live.mapper.BbinLiveSportEntityMapper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class ManLiveService {
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private ApiInfoEntityMapper apiInfoMapper;
	@Autowired
	private BbinLiveSportEntityMapper bbinLiveMapper;
	@Autowired
	private TempAuditTotalMapper tempAuditTotalMapper;
	
	public void manGetRecord(String date, ApiInfoEntity api) {
		Integer siteId = api.getSiteId();
		String siteName = api.getSiteName();
		/*String reportUrl = "http://linkapi.s1116.com/app/WebService/JSON/display.php/";//视讯请求地址*/
		String reportUrl = BBINCommon.URL;//视讯请求地址
		String uppername = api.getLiveKey();//bb视讯上级代理
		logger.info("开始拉取网站id："+siteId+",网站名称："+siteName+",体育请求地址："+reportUrl
				+",请求liveKey:"+uppername);
		
		getBet(date,siteId,siteName,reportUrl,uppername);
		
		
	}
	public void manGetRecord(String date) {
		List<ApiInfoEntity> aipInfoList = getAipInfoList();
		for (ApiInfoEntity api : aipInfoList) {
			Integer siteId = api.getSiteId();
			String siteName = api.getSiteName();
			String reportUrl = "http://linkapi.s1116.com/app/WebService/JSON/display.php/";//视讯请求地址
			String uppername = api.getLiveKey();//bb视讯上级代理
			logger.info("开始拉取网站id："+siteId+",网站名称："+siteName+",体育请求地址："+reportUrl
					+",请求liveKey:"+uppername);
			getBet(date,siteId,siteName,reportUrl,uppername);
		}
	}
	
	private void getBet(String date,Integer siteId, String siteName, String reportUrl,
			String uppernameKey) {
		try{
			logger.info("网站名称："+siteName+"bbin体育正式开始拉取数据......");
			String uppername = uppernameKey;  //必须
		//	String rounddate = BBINDateUtils.getBBINRounddate(new Date());
			String rounddate = date;
			logger.info("网站名称："+siteName+"bbin体育拉取日期"+rounddate);
			
			int gamekind = LiveConfig.BBIN_GAME_KIND_SPORT; //视讯
			int page = 1;
			int pagelimit = LiveConfig.BBIN_PAGE_LIMIT; //200
			
			//kkw910+BETRECORD_KEY+时间
		//	String tempParam = LiveConfig.BBIN_LIVE_WEBSITE+LiveConfig.BBIN_BETRECORD_KEY+BBINDateUtils.getGMT4Date(new Date());
			String tempParam = LiveConfig.BBIN_LIVE_WEBSITE+LiveConfig.BBIN_BETRECORD_KEY+BBINDateUtils.getGMT4Date(new Date());
			logger.info("网站："+siteName+"bbin 体育请求参数tempParam::" + tempParam+"::请求时间时间rounddate:"+rounddate);
			
			for(int j=1;j<=page;j++){//int j=page 只有初始化的时候执行一次，此后将不再赋值
				//随机修几秒
				Thread.sleep((int)(Math.random()*5)*1000);
				
			/*	String param = "website="+LiveConfig.BBIN_LIVE_WEBSITE+"&action=BetTime"+"&uppername="+uppername+
				"&date="+rounddate+"&starttime=00:00:00"+"&endtime=23:59:59"+"&page="+j+"&pagelimit="+pagelimit+
				"&key="+DataUtils.randomString(7)+DataUtils.toMD5(tempParam)+DataUtils.randomString(2);*/
				String param = assemblyParam(uppername, rounddate, pagelimit, gamekind, j);
				logger.info("网站："+siteName+"bbin体育正式拉取参数 param:" + param);
				JSONObject obj = null;
				try{
					String result = WebHTTPUtils.sendPost1(reportUrl+"WagersRecordBy1",param);
					obj = JSONObject.fromObject(result);
				}catch(Exception e){
					logger.info("此次拉取数据异常,跳过当前页.....");
					logger.info("obj"+(obj == null?"":obj.toString())+"异常信息："+e.getMessage());
//					j--;
//					Thread.sleep(5*1000);
					continue;
				}
				
				logger.info("网站："+siteName+"bbin体育已成功响应:totalPage:" + page+",当前页为"+j);
				if(obj.has("result")){
					if(obj.getBoolean("result")){
						if(obj.has("pagination")){
							JSONObject jo=JSONObject.fromObject(obj.getString("pagination"));//格式化成json对象
							page = jo.getInt("TotalPage");
						}
						JSONArray dataArray = obj.getJSONArray("data");
						
						for(int i=0; i<dataArray.size(); i++){//当前页条目数，如果
							
							JSONObject dataJson = dataArray.getJSONObject(i);
							
							
							if(null == dataJson.getString("UserName") && "".equals(dataJson.getString("UserName"))){
								continue;
							}
							BbinLiveSportEntity liveEntity = getBBINLiveByWagersid(dataJson.getString("WagersID"),gamekind);
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
						//	liveEntity.setSerialId(dataJson.getString("SerialID"));
						//	liveEntity.setRoundNo(dataJson.getString("RoundNo"));
							liveEntity.setGameType(dataJson.getString("GameType"));
						//	liveEntity.setGameCode(dataJson.getString("GameCode"));
							liveEntity.setResult(dataJson.getString("Result"));
						//	liveEntity.setCard(dataJson.getString("Card"));
						//	liveEntity.setResultType(dataJson.getString("ResultType"));
							liveEntity.setBetAmount(new BigDecimal(dataJson.getDouble("BetAmount")).setScale(2, BigDecimal.ROUND_HALF_UP));
							liveEntity.setPayOff(new BigDecimal(dataJson.getDouble("Payoff")).setScale(2, BigDecimal.ROUND_HALF_UP));
							
							//有效投注金额
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
							//	liveEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_UNBET);//未结算
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
					    	
					    //	logger.info("网站："+siteName+"bbin....WinLossType:::"+liveEntity.getWinLossType()+"######bbin 视讯正式开始拉取数据  pay:"+dataJson.getDouble("Payoff"));
							if(updateFlag){  //视讯修改的时候不用判断
								
								setUpdateTime(liveEntity);
								bbinLiveMapper.updateByPrimaryKey(liveEntity);
								logger.info("网站："+siteName+"bbin体育修改:" + dataJson.getString("WagersID"));
								
							}else{
								liveEntity.setCreateTime(new Date());
								logger.info("网站："+siteName+"BBIN体育新增:" + dataJson.getString("WagersID"));
								bbinLiveMapper.insert(liveEntity);
							}
							/******************/
							//添加到map
							/******************/	
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
						
					}// end result = true
					else{
						logger.info("网站：" + siteName + "请求api结果为："+obj.toString()+",请稍后重试.....");
						//没有结果当前页不能增加
//						j--;
//						Thread.sleep((int)(Math.random()*2)*1000);
						break;
					}
				}//end obj.has("result")
				
			}//end forech page
			
			}catch(Exception e){
				e.printStackTrace();
				logger.info("网站："+siteName+"bbin 正式环境拉取数据异常:"+e.getMessage());
			}
		logger.info("网站："+siteName+"bbin 手动拉取完成");
	}

	private void setUpdateTime(BbinLiveSportEntity liveEntity){
		Date time = liveEntity.getUpdateTime();
		if(time == null){
			liveEntity.setUpdateTime(new Date());
		}
	}

	public List<ApiInfoEntity> getAipInfoList() {
		ApiInfoEntityExample e = new ApiInfoEntityExample();
		e.createCriteria().andLiveIdEqualTo(LiveConfig.BBIN_LIVE_ID).andStateEqualTo(LiveConfig.NORMAL_STATE);
		return apiInfoMapper.selectByExample(e);
	}

	private BbinLiveSportEntity getBBINLiveByWagersid(String wagersid, int gamekind){
		BbinLiveSportEntityExample e = new BbinLiveSportEntityExample();
		e.createCriteria().andWagersIdEqualTo(wagersid).andBbinGameKindEqualTo((byte)gamekind);
		List<BbinLiveSportEntity> list = bbinLiveMapper.selectByExample(e);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	private String assemblyParam(String uppername, String rounddate, int pagelimit, int gamekind, int j) {
    /*    Map<String,String> paramMap = new HashMap<String,String>(){{
            put("website",LiveConfig.BBIN_LIVE_WEBSITE);
            put("uppername",uppername);
            put("rounddate",rounddate);
            put("starttime","00:00:00");
            put("endtime","23:59:59");
            put("gamekind",gamekind+"");
            put("page", j+"");
            put("pagelimit", pagelimit+"");
        }};
        String param = mapToString(paramMap);
        String key = EncryptUtils.encrypt(param, BBINUtils.USERKEY);
        param+="&key="+key;
        return param;*/
		Map<String,String> paramMap = new TreeMap<String,String>(){{
			put("uppername",uppername);
			put("rounddate",rounddate);
			put("starttime","00:00:00");
			put("endtime","23:59:59");
			put("gamekind",String.valueOf(LiveConfig.BBIN_GAME_KIND_SPORT));
			put("page",String.valueOf(j));
			put("pagelimit", String.valueOf(LiveConfig.BBIN_PAGE_LIMIT));
		}};
		String param =  BBINCommon.mapToString(paramMap);
		String key = EncryptUtils.encrypt(param, BBINCommon.USERKEY);
		param+="&key="+key;
		return param.toString();
	}
	

}
