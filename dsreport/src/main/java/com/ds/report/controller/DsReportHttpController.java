package com.ds.report.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.onetwo.common.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ds.report.common.BaseCacheMap;
import com.ds.report.common.BaseCommon;
import com.ds.report.service.DsReportServiceImpl;
import com.ds.report.service.HunterJackpotServiceImpl;
import com.ds.report.service.SiteOrderDescService;
import com.ds.report.thread.SiteOrderDescRecordThread;
import com.ds.report.utils.DateUtils;
import com.ds.report.utils.MD5;
import com.ds.report.vo.BetInfoByDateParam;
import com.ds.report.vo.ValidateMemberByDateParam;


@Controller
@RequestMapping("/http")
public class DsReportHttpController {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DsReportServiceImpl dsReportService;
	@Autowired
	private SiteOrderDescService siteOrderDescService;
	@Autowired
	private HunterJackpotServiceImpl hunterJackpotService;

	
	/**
	 * 注单统计报表
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/listTotalReport",method=RequestMethod.POST)
	@ResponseBody
	public Object listTotalReport(String strJson){
		JSONObject result = new JSONObject(); 
		Map<String,Object> paramMap = new HashMap<String,Object>();
		long start=System.currentTimeMillis();
		try{
			logger.info("注单统计报表listTotalReport start:"+strJson);
			JSONObject param=JSONObject.parseObject(strJson);
			
			String username = param.getString("username");
			String siteId = param.getString("siteId");
			String betTimeBegin = param.getString("betTimeBegin");
			String betTimeEnd = param.getString("betTimeEnd");
			String gameKind = param.getString("gameKind");
			String gameType = param.getString("gameType");
			String agentLevel = param.getString("agentLevel");
			String betStatus = param.getString("betStatus");
			String liveId = param.getString("liveId");
			String key = param.getString("key");
			String page = param.getString("page");
			String pageLimit = param.getString("pageLimit");
			
			if(StringUtils.isNotBlank(siteId)){
				paramMap.put("siteId", siteId);
			}
			if(StringUtils.isNotBlank(betTimeBegin)){
				paramMap.put("betTimeBegin",betTimeBegin);
			}

			if(StringUtils.isNotBlank(betTimeEnd)){
				paramMap.put("betTimeEnd", betTimeEnd);
			}
			if(StringUtils.isNotBlank(key)){
				paramMap.put("key", key);
			}
			if(StringUtils.isNotBlank(username)){
				paramMap.put("username", username);
			}
			if(StringUtils.isNotBlank(username)){
				paramMap.put("username", username);
			}
			if(StringUtils.isNotBlank(gameKind)){
				paramMap.put("gameKind", gameKind);
			}
			if(StringUtils.isNotBlank(gameType)){
				paramMap.put("gameType", gameType);
			}
			if(StringUtils.isNotBlank(agentLevel)){
				paramMap.put("agentLevel", agentLevel);
			}	
			if(StringUtils.isNotBlank(betStatus)){
				paramMap.put("betStatus", betStatus);
			}
			if(StringUtils.isNotBlank(liveId)){
				paramMap.put("liveId", liveId);
			}
			if(StringUtils.isNotBlank(page)){
				paramMap.put("page", page);
			}
			if(StringUtils.isNotBlank(pageLimit)){
				paramMap.put("pageLimit", pageLimit);
			}
			
			
			this.dsReportService.queryTotalReport(paramMap,result);
			logger.info("注单统计报表listTotalReport end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
			BaseCommon.sendTelegramMessage("注单统计报表listTotalReport异常:"+ex.getMessage());
		}
		long end=System.currentTimeMillis();
		logger.info("time:"+(end-start)+">>>>>>result:"+result);
		return result;
	}

	/**
	 * 注单明细报表
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/listDetailReport",method=RequestMethod.POST)
	@ResponseBody
	public Object listDetailReport(String strJson){
		JSONObject result = new JSONObject(); 
		Map<String,Object> paramMap = new HashMap<String,Object>();
		long start=System.currentTimeMillis();
		JSONObject param=JSONObject.parseObject(strJson);
		
		try{
			String billNo = getRequestParm(param,"billNo");
			String username = getRequestParm(param,"username");
			String siteId = getRequestParm(param,"siteId");
			String betTimeBegin = getRequestParm(param,"betTimeBegin");
			String betTimeEnd = getRequestParm(param,"betTimeEnd");
			String startTime = getRequestParm(param,"startTime");
			String endTime = getRequestParm(param,"endTime");
			String gameKind = getRequestParm(param,"gameKind");
			String gameType = getRequestParm(param,"gameType");
			String liveId = getRequestParm(param,"liveId");
			//桌子ID（蛮牛）
			String tableId = getRequestParm(param,"tableId");
			//期数（蛮牛，现金网）
			String term = getRequestParm(param,"term");
			String key = getRequestParm(param,"key");
			String page = getRequestParm(param,"page");
			String pageLimit = getRequestParm(param,"pageLimit");
			String is_js_time=getRequestParm(param,"is_js_time");

			if(StringUtils.isNotBlank("billNo")){
				paramMap.put("billNo", billNo);
			}
			if(StringUtils.isNotBlank(siteId)){
				paramMap.put("siteId", siteId);
			}
			if(StringUtils.isNotBlank(betTimeBegin)){
				paramMap.put("betTimeBegin",betTimeBegin);
			}

			if(StringUtils.isNotBlank(betTimeEnd)){
				paramMap.put("betTimeEnd", betTimeEnd);
			}
			if(StringUtils.isNotBlank(key)){
				paramMap.put("key", key);
			}
			if(StringUtils.isNotBlank(username)){
				paramMap.put("username", username);
			}
			if(StringUtils.isNotBlank(gameKind)){
				paramMap.put("gameKind", gameKind);
			}
			if(StringUtils.isNotBlank(gameType)){
				paramMap.put("gameType", gameType);
			}
			if(StringUtils.isNotBlank(startTime)){
				paramMap.put("startTime", startTime);
			}	
			if(StringUtils.isNotBlank(endTime)){
				paramMap.put("endTime", endTime);
			}
			if(StringUtils.isNotBlank(liveId)){
				paramMap.put("liveId", liveId);
			}
			if(StringUtils.isNotBlank(tableId)){
				paramMap.put("tableId", tableId);
			}
			if(StringUtils.isNotBlank(term)){
				paramMap.put("term", term);
			}
			if(StringUtils.isNotBlank(page)){
				paramMap.put("page", page);
			}
			if(StringUtils.isNotBlank(pageLimit)){
				paramMap.put("pageLimit", pageLimit);
			}
			if(StringUtils.isNotBlank(is_js_time)){
				paramMap.put("is_js_time", is_js_time);
			}
			
			
			logger.info("注单明细报表listDetailReport parma:"+paramMap.toString());
			this.dsReportService.queryDetailReport(paramMap,result);
			logger.info("注单明细报表listDetailReport end");
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
			BaseCommon.sendTelegramMessage("注单明细报表listDetailReport参数信息:"+strJson+";抛出异常:"+ex.getMessage());

		}
		long end=System.currentTimeMillis();
		logger.info("time:"+(end-start)+">>>>>>result:"+result);
		return JSON.toJSONString(result, SerializerFeature.BrowserCompatible);
	
	}
	
	
	
	
	
	/**
	 * 返水报表
	 * 输入条件：返水优惠设定值、日期区间、层级、用户名称、网站名称
	 * 输出：根据用户名称统计每个游戏大类的返水金额
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/waterReportNewByPage",method=RequestMethod.POST)
	@ResponseBody
	public Object waterReportNewByPage(String strJson,String strOrder,String strPercent){
		Map<String,Object> result = new HashMap<String,Object>(); 
		Map<String,Object> paramMap = new HashMap<String,Object>();
		try{
			logger.info("返水报表waterReportNew http start:"+strJson+";return_order:"+strOrder+";return_percent:"+strPercent);
			JSONObject param=JSONObject.parseObject(strJson);
			String siteId = getRequestParm(param,"siteId");
			String agentLevel = getRequestParm(param,"agentLevel");
			String username = getRequestParm(param,"username");
			String betTimeBegin = getRequestParm(param,"betTimeBegin");
			String betTimeEnd = getRequestParm(param,"betTimeEnd");
			String key = getRequestParm(param,"key");
			String waterType = getRequestParm(param,"waterType");
			String page = getRequestParm(param,"page");
			String pageLimit = getRequestParm(param,"pageLimit");
			
			if(StringUtils.isNotBlank(siteId)){
				paramMap.put("siteId", siteId);
			}
			if(StringUtils.isNotBlank(betTimeBegin)){
				paramMap.put("betTimeBegin",betTimeBegin);
			}

			if(StringUtils.isNotBlank(betTimeEnd)){
				paramMap.put("betTimeEnd", betTimeEnd);
			}
			if(StringUtils.isNotBlank(key)){
				paramMap.put("key", key);
			}
			if(StringUtils.isNotBlank(username)){
				if(username.indexOf(" ") > 0){
					paramMap.put("username",username.replace(" ", ",") );
				}else{
					paramMap.put("username",username);
				}
			}
			if(StringUtils.isNotBlank(agentLevel)){
				paramMap.put("agentLevel", agentLevel);
			}
			if(StringUtils.isNotBlank(waterType)){
				paramMap.put("waterType", waterType);
			}
			/*JSONObject returnOrder=JSONObject.fromObject(getRequestParm(request,"return_order"));
			JSONArray returnPercent=JSONArray.fromObject(getRequestParm(request,"return_percent"));*/
			JSONObject returnOrder = JSONObject.parseObject(strOrder);//{"3d":7,"ball":4,"bb_sport":5,"game":6,"hongkong":2,"live":1,"live_order":{"bb":2,"ds":1,"other":3},"lotto":3}
			JSONArray returnPercent = JSONArray.parseArray(strPercent);//[{"max_return":"999","percent_detail":{"3d":1.3,"ball":1,"bb_sport":0.8,"game":1.3,"hongkong":0.8,"live":{"bb":0.12,"ds":0.12,"other":0.12},"lotto":0.8},"vgold":"1"},
			//{"max_return":"1888","percent_detail":{"3d":1.8,"ball":1,"bb_sport":1,"game":1.8,"hongkong":1,"live":{"bb":1.5,"ds":1.5,"other":1.5},"lotto":1},"vgold":"1000"}]
			Map<String,Object> orderMap = new HashMap<String,Object>(); //{3=lotto, 2=hongkong, 1=live, 7=bb_3d, 6=game, 5=bb_sport, 4=ball}
			Map<String,Object> orderLiveMap = new HashMap<String,Object>(); //{3=live_other, 2=live_bb, 1=live_ds}
			Map<String,Object> orderHongkongMap = new HashMap<String,Object>(); //香港彩
			Map<String,Object> orderLottoMap = new HashMap<String,Object>(); //彩票
			Map<String,Object> orderSportMap = new HashMap<String,Object>(); //体育
			Map<String,Object> orderGameMap = new HashMap<String,Object>(); //电子游戏
			StringBuilder sbOrder = new StringBuilder();//3d|7;ball|4;bb_sport|5;game|6;hongkong|2;live|1;live_bb|2;live_ds|1;live_other|3;lotto|3;
			for (Map.Entry<String, Object> entry : returnOrder.entrySet()){//returnOrder循环取出
				String iterName = entry.getKey();
				if(iterName.equals("live_order")){//视讯类
					JSONObject liveOrder=returnOrder.getJSONObject("live_order");
					for (Map.Entry<String, Object> liveOrderEntry : returnOrder.entrySet()){
						String orderName = (String)liveOrderEntry.getKey();
						sbOrder.append("live_").append(orderName).append("|").append(liveOrder.getString(orderName)).append(";");
						orderLiveMap.put(liveOrder.getString(orderName), "live_"+orderName);
					}
						
				}else if(iterName.equals("hongkong_order")){//香港彩
					JSONObject hongkongOrder=returnOrder.getJSONObject("hongkong_order");
					for (Map.Entry<String, Object> hongkongOrderEntry : hongkongOrder.entrySet()){
						String orderName = hongkongOrderEntry.getKey();
						sbOrder.append("hongkong_").append(orderName).append("|").append(hongkongOrder.getString(orderName)).append(";");
						orderHongkongMap.put(hongkongOrder.getString(orderName), "hongkong_"+orderName);
					}
				}else if(iterName.equals("lotto_order")){//lotto
					JSONObject lottoOrder=returnOrder.getJSONObject("lotto_order");
					for (Map.Entry<String, Object> lottoOrderEntry : lottoOrder.entrySet()){
						String orderName = lottoOrderEntry.getKey();
						sbOrder.append("lotto_").append(orderName).append("|").append(lottoOrder.getString(orderName)).append(";");
						orderLottoMap.put(lottoOrder.getString(orderName), "lotto_"+orderName);
					}
				}else if(iterName.equals("sport_order")){//体育
					JSONObject sportOrder=returnOrder.getJSONObject("sport_order");
					for (Map.Entry<String, Object> sportOrderEntry : sportOrder.entrySet()){
						String orderName = sportOrderEntry.getKey();
						sbOrder.append("sport_").append(orderName).append("|").append(sportOrder.getString(orderName)).append(";");
						orderSportMap.put(sportOrder.getString(orderName), "sport_"+orderName);
					}
				}else if(iterName.equals("game_order")){//电子游戏
					JSONObject gameOrder=returnOrder.getJSONObject("game_order");
					for (Map.Entry<String, Object> gameOrderEntry : gameOrder.entrySet()){
						String orderName = gameOrderEntry.getKey();
						sbOrder.append("game_").append(orderName).append("|").append(gameOrder.getString(orderName)).append(";");
						orderGameMap.put(gameOrder.getString(orderName), "game_"+orderName);
					}
				}else if(iterName.equals("chess_order")){//棋牌游戏
					JSONObject chessOrder=returnOrder.getJSONObject("chess_order");
					for (Map.Entry<String, Object> chessOrderEntry : chessOrder.entrySet()){
						String orderName = chessOrderEntry.getKey();
						sbOrder.append("chess_").append(orderName).append("|").append(chessOrder.getString(orderName)).append(";");
						orderGameMap.put(chessOrder.getString(orderName), "chess_"+orderName);
					}
				}else{//取出各个网站顺序
					sbOrder.append(iterName).append("|").append(returnOrder.getString(iterName)).append(";");
					orderMap.put(returnOrder.getString(iterName), iterName);
				}
				
			}
			logger.info("返水报表waterReport sbOrder:"+sbOrder.toString());
			String[] arr=new String[returnPercent.size()];  //size = 2 分两层，按vgold划分
			BigDecimal minValidBet = new BigDecimal(0);//最少投注金额，根据返水去设置
			Map<String,Object> percentMap = new HashMap<String,Object>(); 
			for(int i=0;i<returnPercent.size();i++){  
				StringBuilder sbPercent = new StringBuilder();
				Map<String,Object> percentDetailMap = new HashMap<String,Object>(); 
				String vGold = "";
				arr[i]=returnPercent.getString(i); 
			    JSONObject jsonPercent = JSONObject.parseObject(arr[i]);
			    for (Map.Entry<String, Object> jsonPercentEntry : jsonPercent.entrySet()){
			        	
			        String iterName = jsonPercentEntry.getKey();
			        if(iterName.endsWith("percent_detail")){//反水汇率"percent_detail":{"ball":1,"live":{"ds":0.12,"bb":0.12,"other":0.12}}
			        	JSONObject jsonPercentDetail = jsonPercent.getJSONObject(iterName);//percent_detail
			        	for (Map.Entry<String, Object> jsonPercentDetailEntry : jsonPercentDetail.entrySet()){
			        		String iterPencentName = jsonPercentDetailEntry.getKey();
			        		if(iterPencentName.equals("live")){//视讯
			        			JSONObject jsonLive = jsonPercentDetail.getJSONObject(iterPencentName);
			        			for (Map.Entry<String, Object> jsonLiveEntry : jsonLive.entrySet()){
			        				String liveName = jsonLiveEntry.getKey();
			        				sbPercent.append("live_").append(liveName).append("|").append(jsonLive.getString(liveName)).append(";");
			        				percentDetailMap.put("live_"+liveName, jsonLive.getString(liveName));
			        			}
			        		}else if(iterPencentName.equals("hongkong")){//香港彩
			        			JSONObject jsonHongkong = jsonPercentDetail.getJSONObject(iterPencentName);
			        			for (Map.Entry<String, Object> jsonHongkongEntry : jsonHongkong.entrySet()){
			        				String hongkongName = jsonHongkongEntry.getKey();
			        				sbPercent.append("hongkong_").append(hongkongName).append("|").append(jsonHongkong.getString(hongkongName)).append(";");
			        				percentDetailMap.put("hongkong_"+hongkongName, jsonHongkong.getString(hongkongName));
			        			}
			        		}else if(iterPencentName.equals("lotto")){//彩票
			        			JSONObject jsonLotto = jsonPercentDetail.getJSONObject(iterPencentName);
			        			for (Map.Entry<String, Object> jsonLottoEntry : jsonLotto.entrySet()){
			        				String lottoName = jsonLottoEntry.getKey();
			        				sbPercent.append("lotto_").append(lottoName).append("|").append(jsonLotto.getString(lottoName)).append(";");
			        				percentDetailMap.put("lotto_"+lottoName, jsonLotto.getString(lottoName));
			        			}
			        		}else if(iterPencentName.equals("sport")){//体育
			        			JSONObject jsonSport = jsonPercentDetail.getJSONObject(iterPencentName);
			        			for (Map.Entry<String, Object> jsonSportEntry : jsonSport.entrySet()){
			        				String sportName = jsonSportEntry.getKey();
			        				sbPercent.append("sport_").append(sportName).append("|").append(jsonSport.getString(sportName)).append(";");
			        				percentDetailMap.put("sport_"+sportName, jsonSport.getString(sportName));
			        			}
			        		}else if(iterPencentName.equals("game")){//电子游戏
			        			JSONObject jsonGame = jsonPercentDetail.getJSONObject(iterPencentName);
			        			for (Map.Entry<String, Object> jsonGameEntry : jsonGame.entrySet()){
			        				String gameName = jsonGameEntry.getKey();
			        				sbPercent.append("game_").append(gameName).append("|").append(jsonGame.getString(gameName)).append(";");
			        				percentDetailMap.put("game_"+gameName, jsonGame.getString(gameName));
			        			}
			        		}else if(iterPencentName.equals("chess")){//棋牌游戏
			        			JSONObject jsonChess = jsonPercentDetail.getJSONObject(iterPencentName);
			        			for (Map.Entry<String, Object> jsonChessEntry : jsonChess.entrySet()){
			        				String chessName = jsonChessEntry.getKey();
			        				sbPercent.append("chess_").append(chessName).append("|").append(jsonChess.getString(chessName)).append(";");
			        				percentDetailMap.put("chess_"+chessName, jsonChess.getString(chessName));
			        			}
			        		}
			        		
			        	}//percent for end
			        		
			        }else if(iterName.equals("vgold")){//vgold
						vGold = jsonPercent.getString(iterName);
						sbPercent.append(iterName).append("|").append(vGold).append(";");
						percentDetailMap.put(iterName, vGold);
						if(minValidBet.intValue() == 0){
							minValidBet = new BigDecimal(vGold);
						}else if(minValidBet.compareTo(new BigDecimal(vGold))>0){
							minValidBet = new BigDecimal(vGold);
						}
						
					}else{//max_return
			        	sbPercent.append(iterName).append("|").append(jsonPercent.getString(iterName)).append(";");
			        	percentDetailMap.put(iterName, jsonPercent.getString(iterName));
			        }
			        	
				}
			    percentMap.put(vGold, percentDetailMap);
			}//end for vgold size
			paramMap.put("game", returnOrder.getString("game"));//特殊游戏返水
			paramMap.put("minValidBet", minValidBet.toPlainString());
			logger.info("返水报表waterReport param:{},page={},pageLimit={}",paramMap.toString(),page,pageLimit);
			this.dsReportService.waterReportNewByPage(paramMap,orderMap,orderLiveMap,orderHongkongMap,orderLottoMap,orderSportMap,orderGameMap,percentMap,result,Integer.valueOf(page),Integer.valueOf(pageLimit));
			logger.info("返水报表waterReport end result : "+result.toString());
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
			BaseCommon.sendTelegramMessage("返水报表参数信息:"+strJson+";strOrder="+strOrder+";strPercent="+strPercent+";抛出异常:"+ex.getMessage());

		}

		return result.toString();
	
	}
	
	/**
	 * 网站排名统计
	 * @param strJson
	 * @return
	 */
	@RequestMapping(value="/siteOrderDesc",method=RequestMethod.POST)
	@ResponseBody
	public String siteOrderDesc(String strJson) {
		logger.info("====调用siteOrderDesc接口======"+strJson);
		JSONObject obj = JSONObject.parseObject(strJson);
		String betTimeBegin = obj.getString("betTimeBegin");
		String betTimeEnd = obj.getString("betTimeEnd");
		JSONObject result = new JSONObject(); 
		try {
			if(StringUtils.isBlank(betTimeBegin)){
				result.put("message", "betTimeBegin param  cant not null");
				result.put("code", 110009);
				return result.toString();
			}
			if(StringUtils.isBlank(betTimeEnd)){
				result.put("message", "betTimeEnd param  cant not null");
				result.put("code", 110009);
				return result.toString();
			}
			String key=MD5.getMD5(obj.toString());
			String data=BaseCacheMap.getCacheMap(key);
			if(StringUtils.isNotBlank(data)){
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", com.alibaba.fastjson.JSONArray.parseArray(data));
				new Thread(new SiteOrderDescRecordThread(siteOrderDescService, obj)).start();
				return data;
			}else{
				com.alibaba.fastjson.JSONArray array=siteOrderDescService.siteOrderDesc(obj);
				result.put("returnCode", 900000);
				result.put("returnMsg", "Success");
				result.put("dataList", array);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			result.put("returnCode", 900001);
			result.put("returnMsg", "System error");
			BaseCommon.sendTelegramMessage("报表总计siteOrderDesc参数信息:"+strJson+";抛出异常:"+e.getMessage());

		}
		logger.info("调用siteOrderDesc接口=====>>>>>>>>>result:"+result);
		return JSON.toJSONString(result, SerializerFeature.BrowserCompatible);
	}
	
	
	/**
	 * 按天统计单个用户注单数及金额
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/betTotalByDay",method=RequestMethod.POST)
	@ResponseBody
	public Object betTotalByDay(String strJson){
		Map<String,Object> result = new HashMap<String,Object>(); 
		long start=System.currentTimeMillis();
		try{
			logger.info("按天统计单个用户注单数及金额betTotalByDay start json:"+strJson);
			
			JSONObject param = JSON.parseObject(strJson);
			
			String username = param.getString("username");
			String siteId = param.getString("siteId");
			String betTimeBegin = param.getString("betTimeBegin");
			String betTimeEnd = param.getString("betTimeEnd");
			String startTime = param.getString("startTime");
			String endTime = param.getString("endTime");
			String gameKind = param.getString("gameKind");
			String gameType = param.getString("gameType");
			String liveId = param.getString("liveId");
			String key = param.getString("key");
			String orderType = param.getString("orderType");
			
			
			Map<String,Object> paramMap = new HashMap<String,Object>();
			if(StringUtils.isNotBlank(siteId)){
				paramMap.put("siteId", siteId);
			}
			if(StringUtils.isNotBlank(betTimeBegin)){
				paramMap.put("betTimeBegin",betTimeBegin);
			}

			if(StringUtils.isNotBlank(betTimeEnd)){
				paramMap.put("betTimeEnd", betTimeEnd);
			}
			if(StringUtils.isNotBlank(key)){
				paramMap.put("key", key);
			}
			if(StringUtils.isNotBlank(username)){
				paramMap.put("username", username);
			}
			if(StringUtils.isNotBlank(gameKind)){
				paramMap.put("gameKind", gameKind);
			}
			if(StringUtils.isNotBlank(gameType)){
				paramMap.put("gameType", gameType);
			}
			if(StringUtils.isNotBlank(startTime)){
				paramMap.put("startTime", startTime);
			}	
			if(StringUtils.isNotBlank(endTime)){
				paramMap.put("endTime", endTime);
			}

			if(StringUtils.isNotBlank(liveId)){
				paramMap.put("liveId", liveId);
			}
			if(StringUtils.isNotBlank(orderType)){
				paramMap.put("orderType", orderType);
			}else{
				paramMap.put("orderType", "desc");
			}
			logger.info("按天统计单个用户注单数及金额betTotalByDay param:"+paramMap.toString());
			this.dsReportService.queryBetTotalByDayNew(paramMap,result);
			logger.info("按天统计单个用户注单数及金额betTotalByDay end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
			BaseCommon.sendTelegramMessage("betTotalByDay参数信息:"+strJson+";抛出异常:"+ex.getMessage());

		}
		long end=System.currentTimeMillis();
		logger.info("time:"+(end-start)+">>>>>>result:"+result);
		return result;
	
	}
	
	@RequestMapping(value="/getAllTypeByUser",method=RequestMethod.POST)
	@ResponseBody
	public String getAllTypeByUser(String strJson){
		logger.info("====调用getAllTypeByUser接口======strJson:"+strJson);
		JSONObject result = new JSONObject(); 
		try {
			JSONObject obj = JSONObject.parseObject(strJson);
			String siteId = obj.getString("siteId");
			String username = obj.getString("username");
			String beginTime = obj.getString("beginTime");
			String endTime = obj.getString("endTime");
			if(StringUtils.isBlank(siteId) || !StringUtils.isNumeric(siteId)){
				result.put("returnMsg", "siteId param is wrong");
				result.put("returnCode", 110009);
				return result.toString();
			}
			if(StringUtils.isBlank(username)){
				result.put("returnMsg", "username param is wrong");
				result.put("returnCode", 110009);
				return result.toString();
			}
			
			if(StringUtils.isBlank(beginTime)){
				result.put("returnMsg", "beginTime is wrong");
				result.put("returnCode", 110009);
				return result.toString();
			}
			if(StringUtils.isBlank(endTime)){
				result.put("returnMsg", "endTime is wrong");
				result.put("returnCode", 110009);
				return result.toString();
			}
			if(StringUtils.isNotBlank(beginTime)){
				if(!DateUtils.isValidDate(beginTime)){
					result.put("returnMsg", "beginTime is wrong");
					result.put("returnCode", 110009);
					return result.toString();
				}
			}
			if(!StringUtils.isNotBlank(endTime)){
				if(DateUtils.isValidDate(endTime)){
					result.put("returnMsg", "endTime is wrong");
					result.put("returnCode", 110009);
					return result.toString();
				}
			}
			dsReportService.getAllTypeByUser(result,obj);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
			BaseCommon.sendTelegramMessage("getAllTypeByUser参数信息:"+strJson+";抛出异常:"+e.getMessage());

		}
		logger.info("调用getAllTypeByUser接口result:"+result.toString());
		return result.toString();
	}
	
	
	/**
	 * 稽核统计临时
	 * 输入条件：日期区间、用户名称、网站名称
	 * 输出：统计每个用户的有效投注额  从audit_total表中统计
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/auditTotalTemp",method=RequestMethod.POST)
	@ResponseBody
	public Object auditTotalTemp(String strJson){
		Map<String,Object> result = new HashMap<String,Object>(); 
		try{
			logger.info("稽核统计auditTotalTemp tcp start:"+strJson);
			JSONObject request = JSONObject.parseObject(strJson);
			String siteId = getRequestParm(request,"siteId");
			String username = getRequestParm(request,"username");
			String betTimeBegin = getRequestParm(request,"betTimeBegin");
			String betTimeEnd = getRequestParm(request,"betTimeEnd");
			String startTime = getRequestParm(request,"startTime");
			String endTime = getRequestParm(request,"endTime");
			String key = getRequestParm(request,"key");
			
			Map<String,Object> paramMap = new HashMap<String,Object>();
			if(StringUtils.isNotBlank(siteId)){
				paramMap.put("siteId", siteId);
			}
			if(StringUtils.isNotBlank(username)){
				paramMap.put("username", username);
			}
			if(StringUtils.isNotBlank(betTimeBegin)){
				paramMap.put("betTimeBegin",betTimeBegin);
			}

			if(StringUtils.isNotBlank(betTimeEnd)){
				paramMap.put("betTimeEnd", betTimeEnd);
			}
			if(StringUtils.isNotBlank(key)){
				paramMap.put("key", key);
			}
			
			if(StringUtils.isNotBlank(startTime)){
				paramMap.put("startTime", startTime);
			}	
			if(StringUtils.isNotBlank(endTime)){
				paramMap.put("endTime", endTime);
			}

			this.dsReportService.auditTotalTemp(paramMap,result);
			logger.info("稽核统计auditTotalTemp tcp end");
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
			BaseCommon.sendTelegramMessage("稽核统计auditTotalTemp参数信息:"+strJson+";抛出异常:"+ex.getMessage());

		}

		return result;
	
	}
	
	
	@RequestMapping(value="/getAllLiveByUser",method=RequestMethod.POST)
	@ResponseBody
	public String getAllLiveByUser(String strJson){
		logger.info("====调用getAllLiveByUser接口======paramjsonStr:"+strJson);
		JSONObject result = new JSONObject(); 
		try {
			JSONObject obj = JSONObject.parseObject(strJson);
			String siteId = obj.getString("siteId");
			String username = obj.getString("username");
			String beginTime = obj.getString("beginTime");
			String endTime = obj.getString("endTime");
			
			if(StringUtils.isBlank(siteId) || !StringUtils.isNumeric(siteId)){
				result.put("returnMsg", "siteId param is wrong");
				result.put("returnCode", 110009);
				return result.toString();
			}
			if(StringUtils.isBlank(username)){
				result.put("returnMsg", "username param is wrong");
				result.put("returnCode", 110009);
				return result.toString();
			}
			
			if(StringUtils.isBlank(beginTime)){
				result.put("returnMsg", "beginTime is wrong");
				result.put("returnCode", 110009);
				return result.toString();
			}
			if(StringUtils.isBlank(endTime)){
				result.put("returnMsg", "endTime is wrong");
				result.put("returnCode", 110009);
				return result.toString();
			}
			if(StringUtils.isNotBlank(beginTime)){
				if(!DateUtils.isValidDate(beginTime)){
					result.put("returnMsg", "beginTime is wrong");
					result.put("returnCode", 110009);
					return result.toString();
				}
			}
			if(!StringUtils.isNotBlank(endTime)){
				if(DateUtils.isValidDate(endTime)){
					result.put("returnMsg", "endTime is wrong");
					result.put("returnCode", 110009);
					return result.toString();
				}
			}
			
			dsReportService.getAllLiveByUser(result,obj);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
			BaseCommon.sendTelegramMessage("稽核统计auditTotalTemp参数信息:"+strJson+";抛出异常:"+e.getMessage());

		}
		logger.info("调用getAllLiveByUser接口result:"+result.toString());
		return result.toString();
	}
	
	/**
	* @Title: getDeatilRecord 
	* @Description: TODO捕鱼王 jackpot 获取详细注单
	* @param @param strJson
	* @param @return    设定文件 
	* @return String    String json
	* @throws
	 */
	@RequestMapping(value="/getDeatilRecord",method=RequestMethod.POST)
	@ResponseBody
	public Object getDeatilRecord(String strJson) {
		JSONObject paramJson = JSONObject.parseObject(strJson);
		String siteIdStr = getRequestParm(paramJson,"siteId");
		String username = getRequestParm(paramJson,"username");
		String startTimeStr = getRequestParm(paramJson,"startTime");
		String endTimeStr = getRequestParm(paramJson,"endTime");
		int pageNum=paramJson.getInteger("pageNum");
		int pageSize=paramJson.getInteger("pageSize");
		pageNum=(pageNum-1)*pageSize;
		Integer siteId = null;
		Date endTime = null;
		Date startTime =null;
		Map<String,Object> resultJson=new HashMap<String, Object>();
		long start = System.currentTimeMillis();
		try {
			if(StringUtils.isNotBlank(siteIdStr)){
				siteId = Integer.valueOf(siteIdStr);
			}
			if(StringUtils.isNotBlank(startTimeStr)){
				startTime=Timestamp.valueOf(startTimeStr);
			}
			if(StringUtils.isNotBlank(endTimeStr)){
				endTime=Timestamp.valueOf(endTimeStr);
			}
			if(StringUtils.isBlank(startTimeStr)){
				resultJson.put("returnMsg", "startTime is null");
				resultJson.put("returnCode", 110009);
				logger.info("param is null,{},{},{},{}",siteIdStr,username,startTimeStr,endTimeStr);

			}else{
				dsReportService.getDeatilRecord(siteId,username, startTime, endTime,pageNum,pageSize,resultJson);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			resultJson.put("returnMsg", "System error");
			resultJson.put("returnCode", 110009);
			logger.error("AG捕鱼getDeatilRecord接口错误:{},{},{},{}",siteIdStr,username,startTime,endTimeStr);
			logger.error(e.getMessage());
			e.printStackTrace();
			BaseCommon.sendTelegramMessage("AG捕鱼getDeatilRecord参数信息:"+strJson+";抛出异常:"+e.getMessage());

		}
		long end = System.currentTimeMillis();
		logger.info("time:{}",end-start);
		
		return resultJson;
		
	}
	
	// 查询捕鱼王统计记录
	@RequestMapping(value="/getTotalRecord",method=RequestMethod.POST)
	@ResponseBody
	public Object getTotalRecord(String strJson) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			logger.info("getJackpot tcp start:" + strJson);
			long start = System.currentTimeMillis();
			JSONObject paramMap = JSONObject.parseObject(strJson);
			String siteId = getRequestParm(paramMap, "siteId");
			String startTime = getRequestParm(paramMap, "startTime");
			String endTime = getRequestParm(paramMap, "endTime");

			if (StringUtils.isBlank(startTime)) {
				result.put("returnCode", 910002);
				result.put("returnMsg", "startTime is null");
				logger.info("startTime is null");
				return result.toString();
			}
			if (StringUtils.isNotBlank(siteId)) {
				paramMap.put("siteId", siteId);
			}
			if (StringUtils.isNotBlank(startTime)) {
				paramMap.put("startTime", startTime);
			}
			if (StringUtils.isNotBlank(endTime)) {
				paramMap.put("endTime", endTime);
			}

			hunterJackpotService.getTotalRecord(paramMap, result);
			long end = System.currentTimeMillis();
			logger.info("getTotalRecord----result" + "耗时：" + (end - start));
		} catch (Exception e) {
			logger.error("{},{}", e);
			result.put("returnCode", 910001);
			result.put("returnMsg", "System Error");
			BaseCommon.sendTelegramMessage("AG捕鱼getTotalRecord参数信息:"+strJson+";抛出异常:"+e.getMessage());

		}
		return result;
	}
	
	/**
	 * 小费管理
	 * 输入条件：日期区间、网站名称、来源
	 * 输出：小费列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/tipsList",method=RequestMethod.POST)
	@ResponseBody
	public Object tipsList(String strJson){
		Map<String,Object> result = new HashMap<String,Object>(); 
		try{
			logger.info("小费管理tipsList tcp start:"+strJson);
			JSONObject request = JSONObject.parseObject(strJson);
			String siteId = getRequestParm(request,"siteId");
			String betTimeBegin = getRequestParm(request,"betTimeBegin");
			String betTimeEnd = getRequestParm(request,"betTimeEnd");
			String liveId = getRequestParm(request,"liveId");
			String username = getRequestParm(request,"username");
			String transferType = getRequestParm(request,"transferType");
			String key = getRequestParm(request,"key");
			String page = getRequestParm(request,"page");
			String pageLimit = getRequestParm(request,"pageLimit");
			
			Map<String,Object> paramMap = new HashMap<String,Object>();
			if(StringUtils.isNotBlank(siteId)){
				paramMap.put("siteId", siteId);
			}
			if(StringUtils.isNotBlank(betTimeBegin)){
				paramMap.put("betTimeBegin",betTimeBegin);
			}

			if(StringUtils.isNotBlank(betTimeEnd)){
				paramMap.put("betTimeEnd", betTimeEnd);
			}
			if(StringUtils.isNotBlank(key)){
				paramMap.put("key", key);
			}
			if(StringUtils.isNotBlank(liveId)){
				paramMap.put("liveId", liveId);
			}
			if(StringUtils.isNotBlank(page)){
				paramMap.put("page", page);
			}	
			if(StringUtils.isNotBlank(pageLimit)){
				paramMap.put("pageLimit", pageLimit);
			}
			if(StringUtils.isNotBlank(username)){
				paramMap.put("username", username);
			}
			if(StringUtils.isNotBlank(transferType)){
				paramMap.put("transferType", transferType);
			}
//			paramMap.put("transferType", "DONATEFEE");
			logger.info("小费管理tipsList param:"+paramMap.toString());
			this.dsReportService.tipsList(paramMap,result);
			logger.info("小费管理tipsList end");
		}catch(Exception ex){
			logger.error("小费错误 : ", ex);
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
			BaseCommon.sendTelegramMessage("小费管理tipsList参数信息:"+strJson+";抛出异常:"+ex.getMessage());

		}

		return JSONObject.toJSONString(result,SerializerFeature.BrowserCompatible);
	
	}
	
	/**
	 * 
	* @Title: getReportGroupByGameType 
	* @Description: TODO(根据GameType分组查询) 
	* @param @param strJson(用户名，siteId,时间范围)
	* @param @return    统计列表 
	* @return String    jsonString;
	* @throws
	 */
	@RequestMapping(value="/getReportGroupByGameType",method=RequestMethod.POST)
	@ResponseBody
	public Object getReportGroupByGameType(String strJson){
		logger.info("进入getReportGroupByGameType参数：{}",strJson);
		List<Map<String,Object>> listMap=new ArrayList<Map<String,Object>>();
		JSONObject paramJson=null;
		int siteId = 0;
		String username="";
		String startTimeStr="";
		String endTimeStr="";
		long start = System.currentTimeMillis();
		JSONObject result=new JSONObject();
		try {
			paramJson = JSONObject.parseObject(strJson);
			if(StringUtils.isBlank(paramJson.getString("siteId"))){
				result.put("returnCode", 910002);
				result.put("returnMsg", "siteId is null");
				return result.toString();
			}
			username = paramJson.getString("username");
			startTimeStr = paramJson.getString("startTime");
			endTimeStr = paramJson.getString("endTime");
			
			siteId = Integer.parseInt(paramJson.getString("siteId"));
			if(StringUtils.isBlank(username)){
				result.put("returnCode", 910002);
				result.put("returnMsg", "username is null");
				return result.toString();
			}
			if(StringUtils.isBlank(startTimeStr) || StringUtils.isBlank(endTimeStr)){
				result.put("returnCode", 910002);
				result.put("returnMsg", "(startTimeStr or endTimeStr) is null");
				return result.toString();
			}
			listMap=this.dsReportService.getGroupByGameKindForTable(siteId, username, startTimeStr, endTimeStr);
			result.put("dataList",JSONArray.toJSONString(listMap));
			result.put("returnCode", 900000);
			result.put("returnMsg", "Success");
		} catch (Exception e) {
			// TODO: handle exception
			result.put("returnMsg", "System error");
			result.put("returnCode", 110009);
			logger.info("getReportGroupByGameType异常，参数：{}，error：{}",strJson,e.getMessage());
			e.printStackTrace();
			BaseCommon.sendTelegramMessage("getReportGroupByGameType参数信息:"+strJson+";抛出异常:"+e.getMessage());

		}
		long end = System.currentTimeMillis();
		logger.info("耗时：{}",end-start);
		return result;
	}
	
	/**
	 * 彩金统计
	 * 输入条件：日期区间、网站名称、类型、来源
	 * 输出：统计中奖金额
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/jpGameList",method=RequestMethod.POST)
	@ResponseBody
	public Object jpGameList(String strJson){
		Map<String,Object> result = new HashMap<String,Object>(); 
		try{
			logger.info("彩金统计jpGameList tcp start:"+strJson);
			JSONObject request = JSONObject.parseObject(strJson);
			String siteId = getRequestParm(request,"siteId");
			String betTimeBegin = getRequestParm(request,"betTimeBegin");
			String betTimeEnd = getRequestParm(request,"betTimeEnd");
			String jptype = getRequestParm(request,"jptype");
			String liveId = getRequestParm(request,"liveId");
			String key = getRequestParm(request,"key");
			String page = getRequestParm(request,"page");
			String pageLimit = getRequestParm(request,"pageLimit");
			
			Map<String,Object> paramMap = new HashMap<String,Object>();
			if(StringUtils.isNotBlank(siteId)){
				paramMap.put("siteId", siteId);
			}
			if(StringUtils.isNotBlank(betTimeBegin)){
				paramMap.put("betTimeBegin",betTimeBegin);
			}

			if(StringUtils.isNotBlank(betTimeEnd)){
				paramMap.put("betTimeEnd", betTimeEnd);
			}
			if(StringUtils.isNotBlank(key)){
				paramMap.put("key", key);
			}
			if(StringUtils.isNotBlank(jptype)){
				paramMap.put("jptype", jptype);
			}
			if(StringUtils.isNotBlank(liveId)){
				paramMap.put("liveId", liveId);
			}
			if(StringUtils.isNotBlank(page)){
				paramMap.put("page", page);
			}	
			if(StringUtils.isNotBlank(pageLimit)){
				paramMap.put("pageLimit", pageLimit);
			}
			
			logger.info("彩金统计jpGameList param:"+paramMap.toString());
			this.dsReportService.jpGameList(paramMap,result);
			logger.info("彩金统计jpGameList end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
			BaseCommon.sendTelegramMessage("彩金统计jpGameList参数信息:"+strJson+";抛出异常:"+ex.getMessage());

		}
		return result;
	
	}
	
	
	/**
	 * 根据游戏类型(gametype)去统计
	 */
	public 	Object betTotalByUser(String strJson){
		Map<String,Object> result = new HashMap<String,Object>(); 
		try{
			logger.info("统计单个用户注单数及金额betTotalByUser tcp start:"+strJson);
			JSONObject request = JSONObject.parseObject(strJson);
			String username = getRequestParm(request,"username");
			String siteId = getRequestParm(request,"siteId");
			String betTimeBegin = getRequestParm(request,"betTimeBegin");
			String betTimeEnd = getRequestParm(request,"betTimeEnd");
			String startTime = getRequestParm(request,"startTime");
			String endTime = getRequestParm(request,"endTime");
			String gameKind = getRequestParm(request,"gameKind");
			String gameType = getRequestParm(request,"gameType");
			String liveId = getRequestParm(request,"liveId");
			String key = getRequestParm(request,"key");
			
			
			Map<String,Object> paramMap = new HashMap<String,Object>();
			
			
			if(StringUtils.isNotBlank(siteId)){
				paramMap.put("siteId", siteId);
			}
			if(StringUtils.isNotBlank(betTimeBegin)){
				paramMap.put("betTimeBegin",betTimeBegin);
			}

			if(StringUtils.isNotBlank(betTimeEnd)){
				paramMap.put("betTimeEnd", betTimeEnd);
			}
			if(StringUtils.isNotBlank(key)){
				paramMap.put("key", key);
			}
			if(StringUtils.isNotBlank(username)){
				paramMap.put("username", username);
			}
			if(StringUtils.isNotBlank(gameKind)){
				paramMap.put("gameKind", gameKind);
			}
			if(StringUtils.isNotBlank(gameType)){
				paramMap.put("gameType", gameType);
			}
			if(StringUtils.isNotBlank(startTime)){
				paramMap.put("startTime", startTime);
			}	
			if(StringUtils.isNotBlank(endTime)){
				paramMap.put("endTime", endTime);
			}

			if(StringUtils.isNotBlank(liveId)){
				paramMap.put("liveId", liveId);
			}

			this.dsReportService.queryBetTotalByUserGroupGameType(paramMap,result);
			logger.info("统计单个用户注单数及金额betTotalByUser tcp end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System Error");
		}

		return result;
	
	}
	/**
	 * 获取有效会员
	 */
	public Object getValidateMemberByDate(String strJson){
		logger.info("====调用getValidateMemberByDate接口======paramjsonStr:"+strJson);
		JSONObject result = new JSONObject(); 
		try {
			JSONObject obj = JSONObject.parseObject(strJson);
			String siteId = obj.getString("siteId");
			String beginTime =  obj.getString("beginTime");
			String endTime =  obj.getString("endTime");
			String liveId = obj.getString("liveId");
			String agentLevel = obj.getString("agentLevel");
			String agentName = obj.getString("agentName");
			if(StringUtils.isBlank(beginTime)){
				result.put("returnMsg", "beginTime is wrong");
				result.put("returnCode", 110009);
				return result.toString();
			}
			if(StringUtils.isBlank(endTime)){
				result.put("returnMsg", "endTime is wrong");
				result.put("returnCode", 110009);
				return result.toString();
			}
			if(StringUtils.isNotBlank(beginTime)){
				if(!DateUtils.isValidDate(beginTime)){
					result.put("returnMsg", "beginTime is wrong");
					result.put("returnCode", 110009);
					return result.toString();
				}
			}
			if(!StringUtils.isNotBlank(endTime)){
				if(DateUtils.isValidDate(endTime)){
					result.put("returnMsg", "endTime is wrong");
					result.put("returnCode", 110009);
					return result.toString();
				}
			}
			
			if(StringUtils.isBlank(siteId) || !StringUtils.isNumeric(siteId)){
				result.put("returnMsg", "siteId param is wrong");
				result.put("returnCode", 110009);
				return result.toString();
			}
			if(StringUtils.isNotBlank(liveId) && !StringUtils.isNumeric(liveId)){
				result.put("returnMsg", "liveId param is wrong");
				result.put("returnCode", 110009);
				return result.toString();
			}
			String [] agentLevelArr = {"agents","world","corprator","superior","company"};
			if(StringUtils.isNotBlank(agentLevel) && !Arrays.asList(agentLevelArr).contains(agentLevel)){
				result.put("returnMsg", "agentLevel param is wrong,must be agents,world,corprator,superior,company");
				result.put("returnCode", 110009);
				return result.toString();
			}
			if(StringUtils.isNotBlank(agentLevel) && StringUtils.isBlank(agentName)){
				result.put("returnMsg", "agentLevel param is not null,but agentName is null");
				result.put("returnCode", 110009);
				return result.toString();
			}
			ValidateMemberByDateParam queryParam = new ValidateMemberByDateParam();
			queryParam.setAgentName(agentName);
			queryParam.setSiteId(Integer.valueOf(siteId));
			if(StringUtils.isNotBlank(beginTime)){
				queryParam.setBeginTime(DateUtil.parseByPatterns(beginTime, "yyyy-MM-dd"));
			}
			if(StringUtils.isNotBlank(endTime)){
				queryParam.setEndTime(DateUtil.parseByPatterns(endTime, "yyyy-MM-dd"));
			}
			if(StringUtils.isNotBlank(liveId)){
				queryParam.setLiveId(Integer.valueOf(liveId));
			}
			queryParam.setAgentLevel(agentLevel);
			dsReportService.getValidateMemberByDate(result,queryParam);
			result.put("returnCode", 900000);
			result.put("returnMsg", "Success");
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}
		logger.info("调用getValidateMemberByDate接口result:"+result.toString());
		return result;
	}
	
	/**
	 * 统计指定日期的报表
	 * 
	 * @param paramjsonStr
	 * @return
	 */
	public Object getBetInfoByDate(String strJson){
		logger.info("====调用getBetInfoByDate接口======paramjsonStr:"+strJson);
		JSONObject result = new JSONObject(); 
		try {
			JSONObject obj = JSONObject.parseObject(strJson);
			String siteId = obj.getString("siteId");
			String beginTime =  obj.getString("beginTime");
			String endTime =  obj.getString("endTime");
			String liveId = obj.getString("liveId");
			if(StringUtils.isBlank(beginTime)){
				result.put("returnMsg", "beginTime is wrong");
				result.put("returnCode", 110009);
				return result.toString();
			}
			if(StringUtils.isBlank(endTime)){
				result.put("returnMsg", "endTime is wrong");
				result.put("returnCode", 110009);
				return result.toString();
			}
			if(StringUtils.isNotBlank(beginTime)){
				if(!DateUtils.isValidDate(beginTime)){
					result.put("returnMsg", "beginTime is wrong");
					result.put("returnCode", 110009);
					return result.toString();
				}
			}
			if(!StringUtils.isNotBlank(endTime)){
				if(DateUtils.isValidDate(endTime)){
					result.put("returnMsg", "endTime is wrong");
					result.put("returnCode", 110009);
					return result.toString();
				}
			}
			
			if(StringUtils.isBlank(siteId) || !StringUtils.isNumeric(siteId)){
				result.put("returnMsg", "siteId param is wrong");
				result.put("returnCode", 110009);
				return result.toString();
			}
			if(StringUtils.isNotBlank(liveId) && !StringUtils.isNumeric(liveId)){
				result.put("returnMsg", "liveId param is wrong");
				result.put("returnCode", 110009);
				return result.toString();
			}
			
			BetInfoByDateParam queryParam = new BetInfoByDateParam();
			queryParam.setSiteId(Integer.valueOf(siteId));
			if(StringUtils.isNotBlank(beginTime)){
				queryParam.setBeginTime(DateUtil.parseByPatterns(beginTime, "yyyy-MM-dd"));
			}
			if(StringUtils.isNotBlank(endTime)){
				queryParam.setEndTime(DateUtil.parseByPatterns(endTime, "yyyy-MM-dd"));
			}
			if(StringUtils.isNotBlank(liveId)){
				queryParam.setLiveId(Integer.valueOf(liveId));
			}
			dsReportService.getBetInfoByDate(result,queryParam);
			result.put("returnCode", 900000);
			result.put("returnMsg", "Success");
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}
		logger.info("调用getBetInfoByDate接口result:"+result.toString());
		return result;
	}
	
	/**
	 * 退佣统计
	 * 输入条件：日期区间、网站名称
	 * 输出：根据代理分组统计有效投注金额、派彩金额、会员数
	 * @param request
	 * @return
	 */
	public Object commissionTotalByPage(String strJson){
		Map<String,Object> result = new HashMap<String,Object>(); 
		try{
			logger.info("退佣统计commissionTotalByPage tcp start:"+strJson);
			JSONObject request = JSONObject.parseObject(strJson);
			String siteId = getRequestParm(request,"siteId");
			String betTimeBegin = getRequestParm(request,"betTimeBegin");
			String betTimeEnd = getRequestParm(request,"betTimeEnd");
			String agentLevel = getRequestParm(request,"agentLevel");
			String username = getRequestParm(request,"username");
			String key = getRequestParm(request,"key");
			String defValidamount = getRequestParm(request,"defValidamount");
			//jackson
			String page = getRequestParm(request,"page");
			String pageLimit = getRequestParm(request,"pageLimit");
			
			Map<String,Object> paramMap = new HashMap<String,Object>();
			if(StringUtils.isNotBlank(siteId)){
				paramMap.put("siteId", siteId);
			}
			if(StringUtils.isNotBlank(betTimeBegin)){
				paramMap.put("betTimeBegin",betTimeBegin);
			}

			if(StringUtils.isNotBlank(betTimeEnd)){
				paramMap.put("betTimeEnd", betTimeEnd);
			}
			if(StringUtils.isNotBlank(key)){
				paramMap.put("key", key);
			}
			if(StringUtils.isNotBlank(username)){
				paramMap.put("username", username);
			}
			if(StringUtils.isNotBlank(agentLevel)){
				paramMap.put("agentLevel", agentLevel);
			}
			if(StringUtils.isNotBlank(defValidamount)){
				paramMap.put("defValidamount", defValidamount);
			}
			paramMap.put("page", page);
			paramMap.put("pageLimit", pageLimit);
			this.dsReportService.commissionTotalByPage(paramMap,result);
			logger.info("退佣统计commissionTotalByPage tcp end : result = {}", com.alibaba.fastjson.JSONObject.toJSONString(result));
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}

		return result;
	
	}
	
	
	/**
	 * 有效会员统计
	 * 输入条件：日期区间、网站名称、有效金额
	 * 输出：根据代理分组统计会员数
	 * @param request
	 * @return
	 */
	public Object validUserCount(String strJson){
		Map<String,Object> result = new HashMap<String,Object>(); 
		try{
			logger.info("有效会员统计validUserCount tcp start:"+strJson);
			JSONObject request = JSONObject.parseObject(strJson);
			String siteId = getRequestParm(request,"siteId");
			String betTimeBegin = getRequestParm(request,"betTimeBegin");
			String betTimeEnd = getRequestParm(request,"betTimeEnd");
			String agentLevel = getRequestParm(request,"agentLevel");
			String username = getRequestParm(request,"username");
			String key = getRequestParm(request,"key");
			String defValidamount = getRequestParm(request,"defValidamount");
			String page = getRequestParm(request,"page");
			String pageLimit = getRequestParm(request,"pageLimit");
			
			Map<String,Object> paramMap = new HashMap<String,Object>();
			if(StringUtils.isNotBlank(siteId)){
				paramMap.put("siteId", siteId);
			}
			if(StringUtils.isNotBlank(betTimeBegin)){
				paramMap.put("betTimeBegin",betTimeBegin);
			}

			if(StringUtils.isNotBlank(betTimeEnd)){
				paramMap.put("betTimeEnd", betTimeEnd);
			}
			if(StringUtils.isNotBlank(key)){
				paramMap.put("key", key);
			}
			if(StringUtils.isNotBlank(username)){
				paramMap.put("username", username);
			}
			if(StringUtils.isNotBlank(agentLevel)){
				paramMap.put("agentLevel", agentLevel);
			}
			if(StringUtils.isNotBlank(defValidamount)){
				paramMap.put("defValidamount", defValidamount);
			}
			if(StringUtils.isNotBlank(page)){
				paramMap.put("page", page);
			}	
			if(StringUtils.isNotBlank(pageLimit)){
				paramMap.put("pageLimit", pageLimit);
			}
			this.dsReportService.validUserCount(paramMap,result);
			logger.info("有效会员统计validUserCount tcp end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}

		return result;
	
	}
	
	private String getRequestParm(JSONObject jsonParam,String paramName){
		try{
			return jsonParam.getString(paramName).trim();
		}catch(Exception ex){
			return "";
		}
	}	
	
	
}
