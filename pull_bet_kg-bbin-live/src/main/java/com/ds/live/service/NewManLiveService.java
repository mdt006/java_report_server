package com.ds.live.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import com.ds.live.until.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
import com.kg.live.entity.BbinLiveEntity;
import com.kg.live.entity.BbinLiveEntityExample;
import com.kg.live.mapper.ApiInfoEntityMapper;
import com.kg.live.mapper.BbinLiveEntityMapper;

@Service
public class NewManLiveService {
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private ApiInfoEntityMapper apiInfoMapper;
	@Autowired
	private BbinLiveEntityMapper bbinLiveMapper;
	@Autowired
	private TempAuditTotalMapper tempAuditTotalMapper;
	
	
	private List<ApiInfoEntity> aipInfoList;
	
	public void manGetRecord(String date,String starttime,String endtime,int page,int pageLimit,ApiInfoEntity api) {
		Integer siteId = api.getSiteId();
		String siteName = api.getSiteName();
		String reportUrl = api.getReporturl();//视讯请求地址
		String uppername = api.getLiveKey();//bb视讯上级代理
		logger.info("开始拉取网站id："+siteId+",网站名称："+siteName+",视讯请求地址："+reportUrl
				+",请求liveKey:"+uppername);
		
		getBet(date,siteId,siteName,reportUrl,uppername, starttime, endtime,page,pageLimit);
		
		
	}
	
	private void getBet(String date,Integer siteId, String siteName, String reportUrl,
			String uppernameKey,String starttime,String endtime,int page,int pagelimit) {
		try{
			logger.info("网站名称："+siteName+"bbin视讯正式开始拉取数据......");
			String uppername = uppernameKey;  //必须
		//	String rounddate = BBINDateUtils.getBBINRounddate(new Date());
			String rounddate = date;
			int gamekind = LiveConfig.BBIN_GAME_KIND_LIVE; //视讯
			
			//kkw910+BETRECORD_KEY+时间
		//	String tempParam = LiveConfig.BBIN_LIVE_WEBSITE+LiveConfig.BBIN_BETRECORD_KEY+BBINDateUtils.getGMT4Date(new Date());
			String tempParam = LiveConfig.BBIN_LIVE_WEBSITE+LiveConfig.BBIN_BETRECORD_KEY+BBINDateUtils.getGMT4Date(new Date());
			logger.info("网站："+siteName+"bbin 视讯请求参数tempParam::" + tempParam+"::请求时间时间rounddate:"+rounddate);
			
			for(int j=page;j<=page;j++){//int j=page 只有初始化的时候执行一次，此后将不再赋值
				//随机修几秒
				Thread.sleep((int)(Math.random()*5)*1000);
				int add=0;
				int udd=0;
			/*	String param = "website="+LiveConfig.BBIN_LIVE_WEBSITE+"&uppername="+uppername+
				"&rounddate="+rounddate+"&starttime="+starttime+"&endtime="+endtime+"&gamekind="+gamekind+"&page="+j+"&pagelimit="+pagelimit+
				"&key="+DataUtils.randomString(7)+DataUtils.toMD5(tempParam)+DataUtils.randomString(2);
				*/
				String param = assemblyParam(uppername, rounddate, pagelimit, gamekind, j);
				logger.info("网站："+siteName+"bbin视讯正式拉取参数 param:" + param);
				JSONObject obj = null;
				try{
					obj = JSONObject.fromObject(WebHTTPUtils.sendPost1(reportUrl+"BetRecord",param));
				}catch(Exception e){
					logger.info("此次拉取数据异常,稍后将重新拉取当前页.....");
					logger.info("obj"+(obj == null?"":obj.toString())+"异常信息："+e.getMessage());
					j--;
					Thread.sleep(5*1000);
					continue;
				}
				
				logger.info("网站："+siteName+"bbin视讯已成功响应:totalPage:" + page+",当前页为"+j);
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
							BbinLiveEntity liveEntity = getBBINLiveByWagersid(dataJson.getString("WagersID"));
							boolean updateFlag = false;
							if(liveEntity == null){
								liveEntity = new BbinLiveEntity();
							}else{
								updateFlag = true;
							}
							
							String userNameStr = dataJson.getString("UserName").substring(LiveConfig.BBIN_NAME_PRE_LENGTH,
										dataJson.getString("UserName").length());
							liveEntity.setUserName(userNameStr);
							liveEntity.setSiteId(siteId);
							liveEntity.setBbinWebsite(LiveConfig.BBIN_LIVE_WEBSITE);
							liveEntity.setUppername(uppername);
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
							
					    	if("-1".equals(dataJson.getString("ResultType"))){
								liveEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_CANCEL);//注单取消
							}else{
								if ((dataJson.getString("Result") != null) && (!"".equals(dataJson.getString("Result")))){
									if(dataJson.getDouble("Payoff")==0.0){//和
										liveEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_HE);//
									}else if(dataJson.getDouble("Payoff") > 0.0){//赢
										liveEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_WIN);
									}else if(dataJson.getDouble("Payoff") < 0.0){//输
										liveEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_LOSE);
									}
								}
							}
					    	
					    //	logger.info("网站："+siteName+"bbin....WinLossType:::"+liveEntity.getWinLossType()+"######bbin 视讯正式开始拉取数据  pay:"+dataJson.getDouble("Payoff"));
							if(updateFlag){  //视讯修改的时候不用判断
								
								//0 表示注单未修改  4表示注单被取消
								liveEntity.setUpdateTime(new Date());
								bbinLiveMapper.updateByPrimaryKey(liveEntity);
								udd++;
								
							}else{
								liveEntity.setCreateTime(new Date());
								bbinLiveMapper.insert(liveEntity);
								add++;
							}
							
					    	
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
							
						}//end forech arr.size
						logger.info("本页新增："+add+"条，更新："+udd+"条");
						logger.info("本次拉取条数:"+dataArray.size()+",共"+page+"页");
					}// end result = true
					else{
						logger.info("网站："+siteName+"请求api为false,稍后将重试....."+obj.toString());
						//没有结果当前页不能增加
						break; //防止死循环
						/*j--;
						Thread.sleep((int)(Math.random()*2)*1000);*/
					}
				}//end obj.has("result")
				
			}//end forech page
			
			}catch(Exception e){
				e.printStackTrace();
				try {
					logger.info("网站："+siteName+"bbin 正式环境拉取数据异常，线程降休眠1分钟:"+e.getMessage());
					Thread.sleep(1000*60);//
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		try {
		//	logger.info("网站："+siteName+"bbin 正式环境拉取一次数据完成，线程将休眠1分钟:");
			//设置map的值
			logger.info("网站："+siteName+"bbin 拉取完成");
			Thread.sleep(1000*10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}//
	}




	@PostConstruct
	public void initapiInfoList(){
		ApiInfoEntityExample e = new ApiInfoEntityExample();
		e.createCriteria().andLiveIdEqualTo(LiveConfig.BBIN_LIVE_ID).andStateEqualTo(LiveConfig.NORMAL_STATE);
		aipInfoList = apiInfoMapper.selectByExample(e);
		logger.info("初始化list完成......");
	}

	public List<ApiInfoEntity> getAipInfoList() {
		return aipInfoList;
	}

	public void setAipInfoList(List<ApiInfoEntity> aipInfoList) {
		this.aipInfoList = aipInfoList;
	}
	private BbinLiveEntity getBBINLiveByWagersid(String wagersid){
		BbinLiveEntityExample e = new BbinLiveEntityExample();
		e.createCriteria().andWagersIdEqualTo(wagersid);
		List<BbinLiveEntity> list = bbinLiveMapper.selectByExample(e);
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
			put("gamekind",String.valueOf(gamekind));
			put("page",String.valueOf(j));
			put("pagelimit", String.valueOf(pagelimit));
		}};
		String param =  BBINCommon.mapToString(paramMap);
		String key = EncryptUtils.encrypt(param, BBINCommon.USERKEY);
		param+="&key="+key;
		return param.toString();
	}
	

}
