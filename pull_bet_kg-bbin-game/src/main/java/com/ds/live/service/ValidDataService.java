package com.ds.live.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ds.live.common.BaseCommon;
import com.ds.live.common.Platform;
import com.ds.live.dao.BBINDao;
import com.ds.live.entity.BBINGameVo;
import com.ds.live.until.WebHTTPUtils;
import com.kg.live.entity.ApiInfoEntity;

@Service
public class ValidDataService {
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired 
	private BBINDao bbinDao;
	@Autowired
	private BaseService baseService;
	

	public void validCount(ApiInfoEntity api,String date) {
		Integer siteId = api.getSiteId();
		String reportUrl = "http://180.150.154.97:8080/dtbbinrecordapi/game/bbin/api/BetRecord";// 视讯请求地址
		String uppername = api.getLiveKey();// bb视讯上级代理
		logger.info("开始验证："+date +",网站:"+ siteId +"请求地址：" + reportUrl + ",请求liveKey:" + uppername);
		int gamekind=5;
		String key_b=Platform.Constans.kkw_BetRecord_KeyB;
		
		String baseSql1="";
		String baseSql2="";
		String baseSql3="";
		String baseSql5="";
		
		baseSql1=BaseCommon.getCountSql(siteId, date+" "+"00:00:00",date+" "+"23:59:59", 1);//其余几率游戏-1
		baseSql2=BaseCommon.getCountSql(siteId, date+" "+"00:00:00",date+" "+"23:59:59", 5902);//糖果派对1-2
		baseSql3=BaseCommon.getCountSql(siteId, date+" "+"00:00:00",date+" "+"23:59:59", 5901);//连环夺宝-3
		baseSql5=BaseCommon.getCountSql(siteId, date+" "+"00:00:00",date+" "+"23:59:59", 5908);//糖果派对2-5
			
		int baseCount1=bbinDao.getCountByTime(baseSql1);
		int baseCount2=bbinDao.getCountByTime(baseSql2);
		int baseCount3=bbinDao.getCountByTime(baseSql3);
		int baseCount5=bbinDao.getCountByTime(baseSql5);
			
		boolean sv1=startValid(baseCount1, date, "00:00:00", "23:59:59", 1, 1, siteId, 
					reportUrl, uppername, gamekind, 1, key_b);//其余几率游戏
		boolean sv2=startValid(baseCount2, date, "00:00:00", "23:59:59", 1, 1, siteId, 
					reportUrl, uppername, gamekind, 2, key_b);//糖果派对
		boolean sv3=startValid(baseCount3, date, "00:00:00", "23:59:59", 1, 1, siteId, 
					reportUrl, uppername, gamekind, 3, key_b);//连环夺宝
		boolean sv5=startValid(baseCount5, date, "00:00:00", "23:59:59", 1, 1, siteId, 
					reportUrl, uppername, gamekind, 5, key_b);//糖果派对2
		
		for(String s :BaseCommon.TIME_LIST){
			String[] times=s.split("_");
			
			if(!sv1){
				String otherSql=BaseCommon.getCountSql(siteId, date+" "+times[0],date+" "+times[1], 1);//其余几率游戏
				int otherCount=bbinDao.getCountByTime(otherSql);
				boolean v1=startValid(otherCount, date, times[0], times[1], 1, 1, siteId, 
						reportUrl, uppername, gamekind, 1, key_b);//其余几率游戏
				if(!v1){
					logger.info(siteId+"电子游戏重新拉取："+s);
					getRecord(date, times[0], times[1], 1, BaseCommon.PAGE_LIMIT, siteId, 
							reportUrl, uppername, gamekind, 1, key_b);
				}
			}
			if(!sv2){
				String sweetSql=BaseCommon.getCountSql(siteId, date+" "+times[0],date+" "+times[1], 5902);//糖果派对1
				int sweetCount=bbinDao.getCountByTime(sweetSql);
				boolean v2=startValid(sweetCount, date, times[0], times[1], 1, 1, siteId, 
						reportUrl, uppername, gamekind, 2, key_b);//糖果派对
				if(!v2){
					logger.info(siteId+"糖果派对重新拉取："+s);
					getRecord(date, times[0], times[1], 1, BaseCommon.PAGE_LIMIT, siteId, 
							reportUrl, uppername, gamekind, 2, key_b);
				}
			}
			if(!sv3){
				String lianhuanSql=BaseCommon.getCountSql(siteId, date+" "+times[0],date+" "+times[1], 5901);//连环夺宝
				int lianhuanCount=bbinDao.getCountByTime(lianhuanSql);
				boolean v3=startValid(lianhuanCount, date, times[0], times[1], 1, 1, siteId, 
						reportUrl, uppername, gamekind, 3, key_b);//连环夺宝
				if(!v3){
					logger.info(siteId+"连环夺宝重新拉取："+s);
					getRecord(date, times[0], times[1], 1, BaseCommon.PAGE_LIMIT, siteId, 
							reportUrl, uppername, gamekind, 3, key_b);
				}
			}
			if(!sv5){
				String sweet2Sql=BaseCommon.getCountSql(siteId, date+" "+times[0],date+" "+times[1], 5908);//糖果派对2
				int sweet2Count=bbinDao.getCountByTime(sweet2Sql);
				boolean v5=startValid(sweet2Count, date, times[0], times[1], 1, 1, siteId, 
						reportUrl, uppername, gamekind, 5, key_b);//糖果派对2
				if(!v5){
					logger.info(siteId+"糖果派对2重新拉取："+s);
					getRecord(date, times[0], times[1], 1, BaseCommon.PAGE_LIMIT, siteId, 
							reportUrl, uppername, gamekind, 5, key_b);

				}
			}
			
			
		}
		
		
	}
	//验证数量是否一致
	public boolean startValid(int now_count,String date,String start_time,String end_time,int page,int pagelimit,
			Integer siteId, String reportUrl, String uppername,int gamekind,int subgamekind,String key_b){
		String param=BaseCommon.getSendParam(uppername, date, start_time, end_time, gamekind, subgamekind, page, pagelimit, key_b);
		int count=0;
		boolean v=true;
		logger.info(siteId+"请求参数:"+param);
		while(v){
			try {
				String res=getResponseData(reportUrl,param);
				JSONObject obj = JSONObject.parseObject(res);
				if (obj.containsKey("result")) {
						if (obj.getBoolean("result")) {
							if (obj.containsKey("pagination")) {
								JSONObject jo = JSONObject.parseObject(obj.getString("pagination"));// 格式化成json对象
								page = jo.getIntValue("TotalPage");
								count=jo.getIntValue("TotalNumber");
								logger.info(siteId+"当前数量："+now_count+",中心库数量："+count);
								break;
							}
						}
				}else{
					Thread.sleep(20*1000L);
					logger.info("返回信息:"+res);
				}
			} catch (Exception e) {
				try {
					Thread.sleep(20*1000L);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				logger.error("验证程序异常：",e);
			}
		}
		if(count-now_count>0){
			logger.info(siteId+"当前数量不一致："+param);
			v=false;
		}
		return v;
	}
	
	//拉取数据
	public boolean getRecord(String date,String start_time,String end_time,int page,int pagelimit,
				Integer siteId, String reportUrl, String uppername,int gamekind,int subgamekind,String key_b){
		int total_page=1;
		String param="";
		while(true){
			try {
				param=BaseCommon.getSendParam(uppername, date, start_time, end_time, gamekind, subgamekind, page, pagelimit, key_b);
				String res=getResponseData(reportUrl,param);
				JSONObject obj = JSONObject.parseObject(res);
				if (obj.containsKey("result")) {
					if (obj.getBoolean("result")) {
						List<BBINGameVo> list=JSONArray.parseArray(obj.getString("data"), BBINGameVo.class);
						if (obj.containsKey("pagination")) {
							JSONObject jo = JSONObject.parseObject(obj.getString("pagination"));// 格式化成json对象
							total_page = jo.getIntValue("TotalPage");
						}
						logger.info(siteId+"重新拉取参数："+param);
						logger.info(siteId+"拉取数量："+list.size()+",当前页："+page+",总页数:"+total_page);
						baseService.saveDataList(list, siteId, uppername);
						if(page>=total_page){
							break;
						}
						if(list.size()>=pagelimit){
							page++;
						}
					} 
				}
				
			} catch (Exception e) {
				try {
					Thread.sleep(20*1000L);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				logger.error("重新验证拉取异常：",e);
			}
		}
		logger.info(siteId+"结束拉取："+param);
		return true;
	}
	
	public String getResponseData( String reportUrl,String param) {
			return WebHTTPUtils.sendPost1(reportUrl, param);
	}
	
}
