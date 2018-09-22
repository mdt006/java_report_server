package com.ds.report.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.onetwo.common.utils.DateUtil;
import org.onetwo.common.utils.MD5;
import org.onetwo.common.utils.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ds.report.common.BaseCacheMap;
import com.ds.report.service.DsReportServiceImpl;
import com.ds.report.service.HunterJackpotServiceImpl;
import com.ds.report.service.SiteOrderDescService;
import com.ds.report.thread.SiteOrderDescRecordThread;
import com.ds.report.utils.DataUtils;
import com.ds.report.utils.DateUtils;
import com.ds.report.vo.BetInfoByDateParam;
import com.ds.report.vo.MemberBetInfoParam;
import com.ds.report.vo.ValidateMemberByDateParam;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 *    
 * 项目名称：dsReport  
 * 类名称：DsReportHproseAction   
 * 类描述：   报表Hprose接口，采用TCP协议
 * 创建人：wen
 * 创建时间：2015-5-20     
 * @version    
 *
 */
public class DsReportHproseAction {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private DsReportServiceImpl dsReportService;
	private HunterJackpotServiceImpl hunterJackpotService;
	private SiteOrderDescService siteOrderDescService;
	
	public DsReportHproseAction(){
	}

	public DsReportHproseAction(DsReportServiceImpl serviceImpl){
		this.dsReportService = serviceImpl;
	}
	
	public DsReportHproseAction(HunterJackpotServiceImpl hunterJackpotServiceImpl){
		this.hunterJackpotService = hunterJackpotServiceImpl;
	}
	
	public DsReportHproseAction(SiteOrderDescService siteOrderDescService){
		this.siteOrderDescService = siteOrderDescService;
	}
	/**
	 * 注单统计报表
	 * @param json参数字符串
	 * @return
	 */
	public String listTotalReport(String strJson){
		Map<String,Object> result = new HashMap<String,Object>(); 
		try{
			logger.info("注单统计报表listTotalReport tcp start:"+strJson);
			JSONObject request = JSONObject.fromObject(strJson);

			String username = getRequestParm(request,"username");
			String siteId = getRequestParm(request,"siteId");
			String betTimeBegin = getRequestParm(request,"betTimeBegin");
			String betTimeEnd = getRequestParm(request,"betTimeEnd");
			String gameKind = getRequestParm(request,"gameKind");
			String gameType = getRequestParm(request,"gameType");
			String agentLevel = getRequestParm(request,"agentLevel");
			String betStatus = getRequestParm(request,"betStatus");
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
			logger.info("注单统计报表listTotalReport tcp end");
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System Error");
		}

		return JSONObject.fromObject(result).toString();
	}
	
	/**
	 * 注单明细报表
	 * @param request
	 * @return
	 */
	public String listDetailReport(String strJson){
		com.alibaba.fastjson.JSONObject result = new com.alibaba.fastjson.JSONObject(); 
		try{
			logger.info("注单明细报表listDetailReport tcp start:"+strJson);
			JSONObject request = JSONObject.fromObject(strJson);
			//add
			String billNo = getRequestParm(request,"billNo");
			String username = getRequestParm(request,"username");
			String siteId = getRequestParm(request,"siteId");
			String betTimeBegin = getRequestParm(request,"betTimeBegin");
			String betTimeEnd = getRequestParm(request,"betTimeEnd");
			String startTime = getRequestParm(request,"startTime");
			String endTime = getRequestParm(request,"endTime");
			String gameKind = getRequestParm(request,"gameKind");
			String gameType = getRequestParm(request,"gameType");
			String liveId = getRequestParm(request,"liveId");
			//桌子ID（蛮牛）
			String tableId = getRequestParm(request,"tableId");
			//期数（蛮牛，现金网）
			String term = getRequestParm(request,"term");
			String key = getRequestParm(request,"key");
			String page = getRequestParm(request,"page");
			String pageLimit = getRequestParm(request,"pageLimit");
			String is_js_time=getRequestParm(request,"is_js_time");

			Map<String,Object> paramMap = new HashMap<String,Object>();
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
			if(StringUtils.isNotBlank(is_js_time) && StringUtils.isNotBlank(is_js_time)){
				paramMap.put("is_js_time", is_js_time);
			}
			this.dsReportService.queryDetailReport(paramMap,result);
			logger.info("注单明细报表listDetailReport end");
			logger.debug("return result : {}", result.toJSONString());
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System Error");
		}

		return result.toJSONString();
	
	}
	
	/**
	 * 按天统计单个用户注单数及金额
	 * @param request
	 * @return
	 */
	public String betTotalByDay(String strJson){
		Map<String,Object> result = new HashMap<String,Object>(); 
		try{
			logger.info("按天统计单个用户注单数及金额betTotalByDay tcp start:"+strJson);
			JSONObject request = JSONObject.fromObject(strJson);
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
			String orderType = getRequestParm(request,"orderType");
			
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

//			this.dsReportService.queryBetTotalByDay(paramMap,result);
			this.dsReportService.queryBetTotalByDayNew(paramMap,result);
			logger.info("按天统计单个用户注单数及金额betTotalByDay tcp end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}

		return JSONObject.fromObject(result).toString();
	
	}
	
	/**
	 * 统计单个用户注单数及金额
	 * @param request
	 * @return
	 */
	public String betTotalByUserOld(String strJson){
		Map<String,Object> result = new HashMap<String,Object>(); 
		try{
			logger.info("统计单个用户注单数及金额betTotalByUser tcp start:"+strJson);
			JSONObject request = JSONObject.fromObject(strJson);
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

			this.dsReportService.queryBetTotalByUser(paramMap,result);
			logger.info("统计单个用户注单数及金额betTotalByUser tcp end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System Error");
		}

		return JSONObject.fromObject(result).toString();
	
	}
	
	/**
	 * 优惠统计
	 * 输入条件：日期区间、层级、用户名称、网站名称
	 * 输出：根据用户名称统计每天游戏大类的有效投注额
	 * @param request
	 * @return
	 */
	public String privilegeTotal(String strJson){
		Map<String,Object> result = new HashMap<String,Object>(); 
		try{
			logger.info("优惠统计privilegeTotal tcp start:"+strJson);
			JSONObject request = JSONObject.fromObject(strJson);
			String siteId = getRequestParm(request,"siteId");
			String areaLevel = getRequestParm(request,"areaLevel");
			String username = getRequestParm(request,"username");
			String betTimeBegin = getRequestParm(request,"betTimeBegin");
			String betTimeEnd = getRequestParm(request,"betTimeEnd");
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
			if(StringUtils.isNotBlank(areaLevel)){
				paramMap.put("areaLevel", areaLevel);
			}

			this.dsReportService.privilegeTotal(paramMap,result);
			logger.info("优惠统计privilegeTotal tcp end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}

		return JSONObject.fromObject(result).toString();
	
	}
	
	/**
	 * 返水报表
	 * 输入条件：返水优惠设定值、日期区间、层级、用户名称、网站名称
	 * 输出：根据用户名称统计每个游戏大类的返水金额
	 * @param request
	 * @return
	 */
	public String waterReportByProc(String strJson){
		Map<String,Object> result = new HashMap<String,Object>(); 
		try{
			logger.info("返水报表waterReportByProc start");
			JSONObject request = JSONObject.fromObject(strJson);
			String siteId = getRequestParm(request,"siteId");
			String agentLevel = getRequestParm(request,"agentLevel");
			String username = getRequestParm(request,"username");
			String betTimeBegin = getRequestParm(request,"betTimeBegin");
			String betTimeEnd = getRequestParm(request,"betTimeEnd");
			String key = getRequestParm(request,"key");
			String waterType = getRequestParm(request,"waterType");
//			String waterSet = getRequestParm(request,"waterSet");

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
		
			JSONObject returnOrder=JSONObject.fromObject(getRequestParm(request,"return_order"));
			JSONArray returnPercent=JSONArray.fromObject(getRequestParm(request,"return_percent"));
			StringBuilder sbOrder = new StringBuilder();
			for (@SuppressWarnings("rawtypes")Iterator iter = returnOrder.keys(); iter.hasNext();){
				String iterName = (String)iter.next();
				if(iterName.equals("live_order")){
					JSONObject liveOrder=JSONObject.fromObject(getRequestParm(returnOrder,"live_order"));
					for (@SuppressWarnings("rawtypes")Iterator iterOrder = liveOrder.keys(); iterOrder.hasNext();){
						String orderName = (String)iterOrder.next();
						sbOrder.append("live_").append(orderName).append("|").append(getRequestParm(liveOrder,orderName)).append(";");
					}
						
				}else{
					sbOrder.append(iterName).append("|").append(getRequestParm(returnOrder,iterName)).append(";");
				}
			}
			logger.info("返水报表waterReport sbOrder:"+sbOrder.toString());
			StringBuilder sbPercent = new StringBuilder();
			String[] arr=new String[returnPercent.size()];  
			for(int i=0;i<returnPercent.size();i++){  
				arr[i]=returnPercent.getString(i); 
			    JSONObject jsonPercent = JSONObject.fromObject(arr[i]);
			    for (@SuppressWarnings("rawtypes")Iterator iter = jsonPercent.keys(); iter.hasNext();){
			        	
			        String iterName = (String)iter.next();
			        if(iterName.endsWith("percent_detail")){
			        	JSONObject jsonPercentDetail = JSONObject.fromObject(getRequestParm(jsonPercent,iterName));
			        	for (@SuppressWarnings("rawtypes")Iterator iterPencent = jsonPercentDetail.keys(); iterPencent.hasNext();){
			        		String iterPencentName = (String)iterPencent.next();
			        		if(iterPencentName.equals("live")){
			        			JSONObject jsonLive = JSONObject.fromObject(getRequestParm(jsonPercentDetail,iterPencentName));
			        			for (@SuppressWarnings("rawtypes")Iterator iterLive = jsonLive.keys(); iterLive.hasNext();){
			        				String liveName = (String)iterLive.next();
			        				sbPercent.append("live_").append(liveName).append("|").append(getRequestParm(jsonLive,liveName)).append(";");
			        			}
			        		}else{
			        			sbPercent.append(iterPencentName).append("|").append(getRequestParm(jsonPercentDetail,iterPencentName)).append(";");
			        		}
			        	}
			        		
			        }else{
			        	sbPercent.append(iterName).append("|").append(getRequestParm(jsonPercent,iterName)).append(";");
			        }
			        	
			     } 
			    sbPercent.append("#");
			}
			logger.info("返水报表waterReport sbPercent:"+sbPercent.toString());	
			    
			paramMap.put("return_order", sbOrder.toString());
			paramMap.put("return_percent", sbPercent.toString());

			logger.info("返水报表waterReport param:"+paramMap.toString());
			this.dsReportService.waterReportByProc(paramMap,result);
			logger.info("返水报表waterReport end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}

		return JSONObject.fromObject(result).toString();
	
	}
	
	/**
	 * 退佣统计
	 * 输入条件：日期区间、网站名称
	 * 输出：根据代理分组统计有效投注金额、派彩金额、会员数
	 * @param request
	 * @return
	 */
	public String commissionTotal(String strJson){
		Map<String,Object> result = new HashMap<String,Object>(); 
		try{
			logger.info("退佣统计commissionTotal tcp start:"+strJson);
			JSONObject request = JSONObject.fromObject(strJson);
			String siteId = getRequestParm(request,"siteId");
			String betTimeBegin = getRequestParm(request,"betTimeBegin");
			String betTimeEnd = getRequestParm(request,"betTimeEnd");
			String agentLevel = getRequestParm(request,"agentLevel");
			String username = getRequestParm(request,"username");
			String key = getRequestParm(request,"key");
			String defValidamount = getRequestParm(request,"defValidamount");
			
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
			this.dsReportService.commissionTotal(paramMap,result);
			logger.info("退佣统计commissionTotal tcp end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}

		return JSONObject.fromObject(result).toString();
	
	}
	
	/**
	 * 退佣统计
	 * 输入条件：日期区间、网站名称
	 * 输出：根据代理分组统计有效投注金额、派彩金额、会员数
	 * @param request
	 * @return
	 */
	public String commissionTotalByPage(String strJson){
		Map<String,Object> result = new HashMap<String,Object>(); 
		try{
			logger.info("退佣统计commissionTotalByPage tcp start:"+strJson);
			JSONObject request = JSONObject.fromObject(strJson);
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

		return JSONObject.fromObject(result).toString();
	
	}
	
	private String getRequestParm(JSONObject jsonParam,String paramName){
		try{
			return jsonParam.getString(paramName).trim();
		}catch(Exception ex){
			return "";
		}
	}
	
	/**
	 * 返水报表
	 * 输入条件：返水优惠设定值、日期区间、层级、用户名称、网站名称
	 * 输出：根据用户名称统计每个游戏大类的返水金额
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/waterReportNew",method=RequestMethod.POST)
	@ResponseBody
	public Object waterReportNew(String strJson,String strOrder,String strPercent){
		Map<String,Object> result = new HashMap<String,Object>(); 
		try{
			logger.info("返水报表waterReportNew tcp start:"+strJson+";return_order:"+strOrder+";return_percent:"+strPercent);
			JSONObject request = JSONObject.fromObject(strJson);
			String siteId = getRequestParm(request,"siteId");
			String agentLevel = getRequestParm(request,"agentLevel");
			String username = getRequestParm(request,"username");
			String betTimeBegin = getRequestParm(request,"betTimeBegin");
			String betTimeEnd = getRequestParm(request,"betTimeEnd");
			String key = getRequestParm(request,"key");
			String waterType = getRequestParm(request,"waterType");
//			String waterSet = getRequestParm(request,"waterSet");

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
			JSONObject returnOrder = JSONObject.fromObject(strOrder);//{"3d":7,"ball":4,"bb_sport":5,"game":6,"hongkong":2,"live":1,"live_order":{"bb":2,"ds":1,"other":3},"lotto":3}
			JSONArray returnPercent = JSONArray.fromObject(strPercent);//[{"max_return":"999","percent_detail":{"3d":1.3,"ball":1,"bb_sport":0.8,"game":1.3,"hongkong":0.8,"live":{"bb":0.12,"ds":0.12,"other":0.12},"lotto":0.8},"vgold":"1"},
			//{"max_return":"1888","percent_detail":{"3d":1.8,"ball":1,"bb_sport":1,"game":1.8,"hongkong":1,"live":{"bb":1.5,"ds":1.5,"other":1.5},"lotto":1},"vgold":"1000"}]
			Map<String,Object> orderMap = new HashMap<String,Object>(); //{3=lotto, 2=hongkong, 1=live, 7=bb_3d, 6=game, 5=bb_sport, 4=ball}
			Map<String,Object> orderLiveMap = new HashMap<String,Object>(); //{3=live_other, 2=live_bb, 1=live_ds}
			Map<String,Object> orderHongkongMap = new HashMap<String,Object>(); //香港彩
			Map<String,Object> orderLottoMap = new HashMap<String,Object>(); //彩票
			Map<String,Object> orderSportMap = new HashMap<String,Object>(); //体育
			Map<String,Object> orderGameMap = new HashMap<String,Object>(); //电子游戏
			StringBuilder sbOrder = new StringBuilder();//3d|7;ball|4;bb_sport|5;game|6;hongkong|2;live|1;live_bb|2;live_ds|1;live_other|3;lotto|3;
			for (@SuppressWarnings("rawtypes")Iterator iter = returnOrder.keys(); iter.hasNext();){//returnOrder循环取出
				String iterName = (String)iter.next();
				if(iterName.equals("live_order")){//视讯类
					JSONObject liveOrder=JSONObject.fromObject(getRequestParm(returnOrder,"live_order"));
					for (@SuppressWarnings("rawtypes")Iterator iterOrder = liveOrder.keys(); iterOrder.hasNext();){
						String orderName = (String)iterOrder.next();
						sbOrder.append("live_").append(orderName).append("|").append(getRequestParm(liveOrder,orderName)).append(";");
						orderLiveMap.put(getRequestParm(liveOrder,orderName), "live_"+orderName);
					}
						
				}else if(iterName.equals("hongkong_order")){//香港彩
					JSONObject hongkongOrder=JSONObject.fromObject(getRequestParm(returnOrder,"hongkong_order"));
					for (@SuppressWarnings("rawtypes")Iterator iterOrder = hongkongOrder.keys(); iterOrder.hasNext();){
						String orderName = (String)iterOrder.next();
						sbOrder.append("hongkong_").append(orderName).append("|").append(getRequestParm(hongkongOrder,orderName)).append(";");
						orderHongkongMap.put(getRequestParm(hongkongOrder,orderName), "hongkong_"+orderName);
					}
				}else if(iterName.equals("lotto_order")){//lotto
					JSONObject lottoOrder=JSONObject.fromObject(getRequestParm(returnOrder,"lotto_order"));
					for (@SuppressWarnings("rawtypes")Iterator iterOrder = lottoOrder.keys(); iterOrder.hasNext();){
						String orderName = (String)iterOrder.next();
						sbOrder.append("lotto_").append(orderName).append("|").append(getRequestParm(lottoOrder,orderName)).append(";");
						orderLottoMap.put(getRequestParm(lottoOrder,orderName), "lotto_"+orderName);
					}
				}
				else if(iterName.equals("sport_order")){//体育
					JSONObject sportOrder=JSONObject.fromObject(getRequestParm(returnOrder,"sport_order"));
					for (@SuppressWarnings("rawtypes")Iterator iterOrder = sportOrder.keys(); iterOrder.hasNext();){
						String orderName = (String)iterOrder.next();
						sbOrder.append("sport_").append(orderName).append("|").append(getRequestParm(sportOrder,orderName)).append(";");
						orderSportMap.put(getRequestParm(sportOrder,orderName), "sport_"+orderName);
					}
				}
				else if(iterName.equals("game_order")){//电子游戏
					JSONObject gameOrder=JSONObject.fromObject(getRequestParm(returnOrder,"game_order"));
					for (@SuppressWarnings("rawtypes")Iterator iterOrder = gameOrder.keys(); iterOrder.hasNext();){
						String orderName = (String)iterOrder.next();
						sbOrder.append("game_").append(orderName).append("|").append(getRequestParm(gameOrder,orderName)).append(";");
						orderGameMap.put(getRequestParm(gameOrder,orderName), "game_"+orderName);
					}
				}else{//取出各个网站顺序
					sbOrder.append(iterName).append("|").append(getRequestParm(returnOrder,iterName)).append(";");
					orderMap.put(getRequestParm(returnOrder,iterName), iterName);
				}
				
			}
			logger.info("返水报表waterReport sbOrder:"+sbOrder.toString());
			String[] arr=new String[returnPercent.size()];  //size = 2 分两层，按vgold划分
			Map<String,Object> percentMap = new HashMap<String,Object>(); 
			for(int i=0;i<returnPercent.size();i++){  
				StringBuilder sbPercent = new StringBuilder();
				Map<String,Object> percentDetailMap = new HashMap<String,Object>(); 
				String vGold = "";
				arr[i]=returnPercent.getString(i); 
			    JSONObject jsonPercent = JSONObject.fromObject(arr[i]);
			    for (@SuppressWarnings("rawtypes")Iterator iter = jsonPercent.keys(); iter.hasNext();){
			        	
			        String iterName = (String)iter.next();
			        if(iterName.endsWith("percent_detail")){//反水汇率"percent_detail":{"ball":1,"live":{"ds":0.12,"bb":0.12,"other":0.12}}
			        	JSONObject jsonPercentDetail = JSONObject.fromObject(getRequestParm(jsonPercent,iterName));//percent_detail
			        	for (@SuppressWarnings("rawtypes")Iterator iterPencent = jsonPercentDetail.keys(); iterPencent.hasNext();){
			        		String iterPencentName = (String)iterPencent.next();
			        		if(iterPencentName.equals("live")){//视讯
			        			JSONObject jsonLive = JSONObject.fromObject(getRequestParm(jsonPercentDetail,iterPencentName));
			        			for (@SuppressWarnings("rawtypes")Iterator iterLive = jsonLive.keys(); iterLive.hasNext();){
			        				String liveName = (String)iterLive.next();
			        				sbPercent.append("live_").append(liveName).append("|").append(getRequestParm(jsonLive,liveName)).append(";");
			        				percentDetailMap.put("live_"+liveName, getRequestParm(jsonLive,liveName));
			        			}
			        		}else if(iterPencentName.equals("hongkong")){//香港彩
			        			JSONObject jsonHongkong = JSONObject.fromObject(getRequestParm(jsonPercentDetail,iterPencentName));
			        			for (@SuppressWarnings("rawtypes")Iterator iterLive = jsonHongkong.keys(); iterLive.hasNext();){
			        				String hongkongName = (String)iterLive.next();
			        				sbPercent.append("hongkong_").append(hongkongName).append("|").append(getRequestParm(jsonHongkong,hongkongName)).append(";");
			        				percentDetailMap.put("hongkong_"+hongkongName, getRequestParm(jsonHongkong,hongkongName));
			        			}
			        		}else if(iterPencentName.equals("lotto")){//彩票
			        			JSONObject jsonLotto = JSONObject.fromObject(getRequestParm(jsonPercentDetail,iterPencentName));
			        			for (@SuppressWarnings("rawtypes")Iterator iterLive = jsonLotto.keys(); iterLive.hasNext();){
			        				String lottoName = (String)iterLive.next();
			        				sbPercent.append("lotto_").append(lottoName).append("|").append(getRequestParm(jsonLotto,lottoName)).append(";");
			        				percentDetailMap.put("lotto_"+lottoName, getRequestParm(jsonLotto,lottoName));
			        			}
			        		}else if(iterPencentName.equals("sport")){//体育
			        			JSONObject jsonSport = JSONObject.fromObject(getRequestParm(jsonPercentDetail,iterPencentName));
			        			for (@SuppressWarnings("rawtypes")Iterator iterLive = jsonSport.keys(); iterLive.hasNext();){
			        				String sportName = (String)iterLive.next();
			        				sbPercent.append("sport_").append(sportName).append("|").append(getRequestParm(jsonSport,sportName)).append(";");
			        				percentDetailMap.put("sport_"+sportName, getRequestParm(jsonSport,sportName));
			        			}
			        		}else if(iterPencentName.equals("game")){//电子游戏
			        			JSONObject jsonGame = JSONObject.fromObject(getRequestParm(jsonPercentDetail,iterPencentName));
			        			for (@SuppressWarnings("rawtypes")Iterator iterLive = jsonGame.keys(); iterLive.hasNext();){
			        				String gameName = (String)iterLive.next();
			        				sbPercent.append("game_").append(gameName).append("|").append(getRequestParm(jsonGame,gameName)).append(";");
			        				percentDetailMap.put("game_"+gameName, getRequestParm(jsonGame,gameName));
			        			}
			        		}
			        		
			        	}//percent for end
			        		
			        }else if(iterName.equals("vgold")){//vgold
						vGold = getRequestParm(jsonPercent,iterName);
						sbPercent.append(iterName).append("|").append(getRequestParm(jsonPercent,iterName)).append(";");
						percentDetailMap.put(iterName, getRequestParm(jsonPercent,iterName));
					}else{//max_return
			        	sbPercent.append(iterName).append("|").append(getRequestParm(jsonPercent,iterName)).append(";");
			        	percentDetailMap.put(iterName, getRequestParm(jsonPercent,iterName));
			        }
			        	
				}
			    percentMap.put(vGold, percentDetailMap);
			}//end for vgold size

			logger.info("返水报表waterReport param:"+paramMap.toString());
			this.dsReportService.waterReportNew(paramMap,orderMap,orderLiveMap,orderHongkongMap,orderLottoMap,orderSportMap,orderGameMap,percentMap,result);
			logger.info("返水报表waterReport end result : "+JSONObject.fromObject(result).toString());
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}

		return JSONObject.fromObject(result).toString();
	
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
		try{
			logger.info("返水报表waterReportNew tcp start:"+strJson+";return_order:"+strOrder+";return_percent:"+strPercent);
			JSONObject request = JSONObject.fromObject(strJson);
			String siteId = getRequestParm(request,"siteId");
			String agentLevel = getRequestParm(request,"agentLevel");
			String username = getRequestParm(request,"username");
			String betTimeBegin = getRequestParm(request,"betTimeBegin");
			String betTimeEnd = getRequestParm(request,"betTimeEnd");
			String key = getRequestParm(request,"key");
			String waterType = getRequestParm(request,"waterType");
			String page = getRequestParm(request,"page");
			String pageLimit = getRequestParm(request,"pageLimit");
//			String waterSet = getRequestParm(request,"waterSet");
			
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
			JSONObject returnOrder = JSONObject.fromObject(strOrder);//{"3d":7,"ball":4,"bb_sport":5,"game":6,"hongkong":2,"live":1,"live_order":{"bb":2,"ds":1,"other":3},"lotto":3}
			JSONArray returnPercent = JSONArray.fromObject(strPercent);//[{"max_return":"999","percent_detail":{"3d":1.3,"ball":1,"bb_sport":0.8,"game":1.3,"hongkong":0.8,"live":{"bb":0.12,"ds":0.12,"other":0.12},"lotto":0.8},"vgold":"1"},
			//{"max_return":"1888","percent_detail":{"3d":1.8,"ball":1,"bb_sport":1,"game":1.8,"hongkong":1,"live":{"bb":1.5,"ds":1.5,"other":1.5},"lotto":1},"vgold":"1000"}]
			Map<String,Object> orderMap = new HashMap<String,Object>(); //{3=lotto, 2=hongkong, 1=live, 7=bb_3d, 6=game, 5=bb_sport, 4=ball}
			Map<String,Object> orderLiveMap = new HashMap<String,Object>(); //{3=live_other, 2=live_bb, 1=live_ds}
			Map<String,Object> orderHongkongMap = new HashMap<String,Object>(); //香港彩
			Map<String,Object> orderLottoMap = new HashMap<String,Object>(); //彩票
			Map<String,Object> orderSportMap = new HashMap<String,Object>(); //体育
			Map<String,Object> orderGameMap = new HashMap<String,Object>(); //电子游戏
			StringBuilder sbOrder = new StringBuilder();//3d|7;ball|4;bb_sport|5;game|6;hongkong|2;live|1;live_bb|2;live_ds|1;live_other|3;lotto|3;
			for (@SuppressWarnings("rawtypes")Iterator iter = returnOrder.keys(); iter.hasNext();){//returnOrder循环取出
				String iterName = (String)iter.next();
				if(iterName.equals("live_order")){//视讯类
					JSONObject liveOrder=JSONObject.fromObject(getRequestParm(returnOrder,"live_order"));
					for (@SuppressWarnings("rawtypes")Iterator iterOrder = liveOrder.keys(); iterOrder.hasNext();){
						String orderName = (String)iterOrder.next();
						sbOrder.append("live_").append(orderName).append("|").append(getRequestParm(liveOrder,orderName)).append(";");
						orderLiveMap.put(getRequestParm(liveOrder,orderName), "live_"+orderName);
					}
						
				}else if(iterName.equals("hongkong_order")){//香港彩
					JSONObject hongkongOrder=JSONObject.fromObject(getRequestParm(returnOrder,"hongkong_order"));
					for (@SuppressWarnings("rawtypes")Iterator iterOrder = hongkongOrder.keys(); iterOrder.hasNext();){
						String orderName = (String)iterOrder.next();
						sbOrder.append("hongkong_").append(orderName).append("|").append(getRequestParm(hongkongOrder,orderName)).append(";");
						orderHongkongMap.put(getRequestParm(hongkongOrder,orderName), "hongkong_"+orderName);
					}
				}else if(iterName.equals("lotto_order")){//lotto
					JSONObject lottoOrder=JSONObject.fromObject(getRequestParm(returnOrder,"lotto_order"));
					for (@SuppressWarnings("rawtypes")Iterator iterOrder = lottoOrder.keys(); iterOrder.hasNext();){
						String orderName = (String)iterOrder.next();
						sbOrder.append("lotto_").append(orderName).append("|").append(getRequestParm(lottoOrder,orderName)).append(";");
						orderLottoMap.put(getRequestParm(lottoOrder,orderName), "lotto_"+orderName);
					}
				}else if(iterName.equals("sport_order")){//体育
					JSONObject sportOrder=JSONObject.fromObject(getRequestParm(returnOrder,"sport_order"));
					for (@SuppressWarnings("rawtypes")Iterator iterOrder = sportOrder.keys(); iterOrder.hasNext();){
						String orderName = (String)iterOrder.next();
						sbOrder.append("sport_").append(orderName).append("|").append(getRequestParm(sportOrder,orderName)).append(";");
						orderSportMap.put(getRequestParm(sportOrder,orderName), "sport_"+orderName);
					}
				}else if(iterName.equals("game_order")){//电子游戏
					JSONObject gameOrder=JSONObject.fromObject(getRequestParm(returnOrder,"game_order"));
					for (@SuppressWarnings("rawtypes")Iterator iterOrder = gameOrder.keys(); iterOrder.hasNext();){
						String orderName = (String)iterOrder.next();
						sbOrder.append("game_").append(orderName).append("|").append(getRequestParm(gameOrder,orderName)).append(";");
						orderGameMap.put(getRequestParm(gameOrder,orderName), "game_"+orderName);
					}
				}else if(iterName.equals("chess_order")){//棋牌游戏
					JSONObject chessOrder=JSONObject.fromObject(getRequestParm(returnOrder,"chess_order"));
					for (@SuppressWarnings("rawtypes")Iterator iterOrder = chessOrder.keys(); iterOrder.hasNext();){
						String orderName = (String)iterOrder.next();
						sbOrder.append("chess_").append(orderName).append("|").append(getRequestParm(chessOrder,orderName)).append(";");
						orderGameMap.put(getRequestParm(chessOrder,orderName), "chess_"+orderName);
					}
				}else{//取出各个网站顺序
					sbOrder.append(iterName).append("|").append(getRequestParm(returnOrder,iterName)).append(";");
					orderMap.put(getRequestParm(returnOrder,iterName), iterName);
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
			    JSONObject jsonPercent = JSONObject.fromObject(arr[i]);
			    for (@SuppressWarnings("rawtypes")Iterator iter = jsonPercent.keys(); iter.hasNext();){
			        	
			        String iterName = (String)iter.next();
			        if(iterName.endsWith("percent_detail")){//反水汇率"percent_detail":{"ball":1,"live":{"ds":0.12,"bb":0.12,"other":0.12}}
			        	JSONObject jsonPercentDetail = JSONObject.fromObject(getRequestParm(jsonPercent,iterName));//percent_detail
			        	for (@SuppressWarnings("rawtypes")Iterator iterPencent = jsonPercentDetail.keys(); iterPencent.hasNext();){
			        		String iterPencentName = (String)iterPencent.next();
			        		if(iterPencentName.equals("live")){//视讯
			        			JSONObject jsonLive = JSONObject.fromObject(getRequestParm(jsonPercentDetail,iterPencentName));
			        			for (@SuppressWarnings("rawtypes")Iterator iterLive = jsonLive.keys(); iterLive.hasNext();){
			        				String liveName = (String)iterLive.next();
			        				sbPercent.append("live_").append(liveName).append("|").append(getRequestParm(jsonLive,liveName)).append(";");
			        				percentDetailMap.put("live_"+liveName, getRequestParm(jsonLive,liveName));
			        			}
			        		}else if(iterPencentName.equals("hongkong")){//香港彩
			        			JSONObject jsonHongkong = JSONObject.fromObject(getRequestParm(jsonPercentDetail,iterPencentName));
			        			for (@SuppressWarnings("rawtypes")Iterator iterLive = jsonHongkong.keys(); iterLive.hasNext();){
			        				String hongkongName = (String)iterLive.next();
			        				sbPercent.append("hongkong_").append(hongkongName).append("|").append(getRequestParm(jsonHongkong,hongkongName)).append(";");
			        				percentDetailMap.put("hongkong_"+hongkongName, getRequestParm(jsonHongkong,hongkongName));
			        			}
			        		}else if(iterPencentName.equals("lotto")){//彩票
			        			JSONObject jsonLotto = JSONObject.fromObject(getRequestParm(jsonPercentDetail,iterPencentName));
			        			for (@SuppressWarnings("rawtypes")Iterator iterLive = jsonLotto.keys(); iterLive.hasNext();){
			        				String lottoName = (String)iterLive.next();
			        				sbPercent.append("lotto_").append(lottoName).append("|").append(getRequestParm(jsonLotto,lottoName)).append(";");
			        				percentDetailMap.put("lotto_"+lottoName, getRequestParm(jsonLotto,lottoName));
			        			}
			        		}else if(iterPencentName.equals("sport")){//体育
			        			JSONObject jsonSport = JSONObject.fromObject(getRequestParm(jsonPercentDetail,iterPencentName));
			        			for (@SuppressWarnings("rawtypes")Iterator iterLive = jsonSport.keys(); iterLive.hasNext();){
			        				String sportName = (String)iterLive.next();
			        				sbPercent.append("sport_").append(sportName).append("|").append(getRequestParm(jsonSport,sportName)).append(";");
			        				percentDetailMap.put("sport_"+sportName, getRequestParm(jsonSport,sportName));
			        			}
			        		}else if(iterPencentName.equals("game")){//电子游戏
			        			JSONObject jsonGame = JSONObject.fromObject(getRequestParm(jsonPercentDetail,iterPencentName));
			        			for (@SuppressWarnings("rawtypes")Iterator iterLive = jsonGame.keys(); iterLive.hasNext();){
			        				String gameName = (String)iterLive.next();
			        				sbPercent.append("game_").append(gameName).append("|").append(getRequestParm(jsonGame,gameName)).append(";");
			        				percentDetailMap.put("game_"+gameName, getRequestParm(jsonGame,gameName));
			        			}
			        		}else if(iterPencentName.equals("chess")){//棋牌游戏
			        			JSONObject jsonChess = JSONObject.fromObject(getRequestParm(jsonPercentDetail,iterPencentName));
			        			for (@SuppressWarnings("rawtypes")Iterator iterLive = jsonChess.keys(); iterLive.hasNext();){
			        				String chessName = (String)iterLive.next();
			        				sbPercent.append("chess_").append(chessName).append("|").append(getRequestParm(jsonChess,chessName)).append(";");
			        				percentDetailMap.put("chess_"+chessName, getRequestParm(jsonChess,chessName));
			        			}
			        		}
			        		
			        	}//percent for end
			        		
			        }else if(iterName.equals("vgold")){//vgold
						vGold = getRequestParm(jsonPercent,iterName);
						sbPercent.append(iterName).append("|").append(getRequestParm(jsonPercent,iterName)).append(";");
						percentDetailMap.put(iterName, getRequestParm(jsonPercent,iterName));
						if(minValidBet.intValue() == 0){
							minValidBet = new BigDecimal(vGold);
						}else if(minValidBet.compareTo(new BigDecimal(vGold))>0){
							minValidBet = new BigDecimal(vGold);
						}
						
					}else{//max_return
			        	sbPercent.append(iterName).append("|").append(getRequestParm(jsonPercent,iterName)).append(";");
			        	percentDetailMap.put(iterName, getRequestParm(jsonPercent,iterName));
			        }
			        	
				}
			    percentMap.put(vGold, percentDetailMap);
			}//end for vgold size
			paramMap.put("game", returnOrder.getString("game"));//特殊游戏返水
			paramMap.put("minValidBet", minValidBet.toPlainString());
			logger.info("返水报表waterReport param:{},page={},pageLimit={}",paramMap.toString(),page,pageLimit);
			this.dsReportService.waterReportNewByPage(paramMap,orderMap,orderLiveMap,orderHongkongMap,orderLottoMap,orderSportMap,orderGameMap,percentMap,result,Integer.valueOf(page),Integer.valueOf(pageLimit));
			logger.info("返水报表waterReport end result : "+JSONObject.fromObject(result).toString());
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}

		return JSONObject.fromObject(result).toString();
	
	}
	
	public Object waterReport(String strJson,String strOrder,String strPercent){
		Map<String,Object> result = new HashMap<String,Object>(); 
		try{
			logger.info("返水报表waterReport tcp start:"+strJson+";return_order:"+strOrder+";return_percent:"+strPercent);
			JSONObject request = JSONObject.fromObject(strJson);
			String siteId = getRequestParm(request,"siteId");
			String agentLevel = getRequestParm(request,"agentLevel");
			String username = getRequestParm(request,"username");
			String betTimeBegin = getRequestParm(request,"betTimeBegin");
			String betTimeEnd = getRequestParm(request,"betTimeEnd");
			String key = getRequestParm(request,"key");
			String waterType = getRequestParm(request,"waterType");
//			String waterSet = getRequestParm(request,"waterSet");

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
			JSONObject returnOrder = JSONObject.fromObject(strOrder);//{"3d":7,"ball":4,"bb_sport":5,"game":6,"hongkong":2,"live":1,"live_order":{"bb":2,"ds":1,"other":3},"lotto":3}
			JSONArray returnPercent = JSONArray.fromObject(strPercent);//[{"max_return":"999","percent_detail":{"3d":1.3,"ball":1,"bb_sport":0.8,"game":1.3,"hongkong":0.8,"live":{"bb":0.12,"ds":0.12,"other":0.12},"lotto":0.8},"vgold":"1"},
			//{"max_return":"1888","percent_detail":{"3d":1.8,"ball":1,"bb_sport":1,"game":1.8,"hongkong":1,"live":{"bb":1.5,"ds":1.5,"other":1.5},"lotto":1},"vgold":"1000"}]
			Map<String,Object> orderMap = new HashMap<String,Object>(); //{3=lotto, 2=hongkong, 1=live, 7=bb_3d, 6=game, 5=bb_sport, 4=ball}
			Map<String,Object> orderLiveMap = new HashMap<String,Object>(); //{3=live_other, 2=live_bb, 1=live_ds}
			
			StringBuilder sbOrder = new StringBuilder();//3d|7;ball|4;bb_sport|5;game|6;hongkong|2;live|1;live_bb|2;live_ds|1;live_other|3;lotto|3;
			for (@SuppressWarnings("rawtypes")Iterator iter = returnOrder.keys(); iter.hasNext();){//returnOrder循环取出
				String iterName = (String)iter.next();
				if(iterName.equals("live_order")){
					JSONObject liveOrder=JSONObject.fromObject(getRequestParm(returnOrder,"live_order"));
					for (@SuppressWarnings("rawtypes")Iterator iterOrder = liveOrder.keys(); iterOrder.hasNext();){
						String orderName = (String)iterOrder.next();
						sbOrder.append("live_").append(orderName).append("|").append(getRequestParm(liveOrder,orderName)).append(";");
						orderLiveMap.put(getRequestParm(liveOrder,orderName), "live_"+orderName);
					}
						
				}else if(iterName.equals("3d")){
					sbOrder.append(iterName).append("|").append(getRequestParm(returnOrder,iterName)).append(";");
					orderMap.put(getRequestParm(returnOrder,iterName), "bb_3d");
				}else{
					sbOrder.append(iterName).append("|").append(getRequestParm(returnOrder,iterName)).append(";");
					orderMap.put(getRequestParm(returnOrder,iterName), iterName);
				}
			}
			logger.info("返水报表waterReport sbOrder:"+sbOrder.toString());
			String[] arr=new String[returnPercent.size()];  
			Map<String,Object> percentMap = new HashMap<String,Object>(); 
			for(int i=0;i<returnPercent.size();i++){  
				StringBuilder sbPercent = new StringBuilder();
				Map<String,Object> percentDetailMap = new HashMap<String,Object>(); 
				String vGold = "";
				arr[i]=returnPercent.getString(i); 
			    JSONObject jsonPercent = JSONObject.fromObject(arr[i]);
			    for (@SuppressWarnings("rawtypes")Iterator iter = jsonPercent.keys(); iter.hasNext();){
			        	
			        String iterName = (String)iter.next();
			        if(iterName.endsWith("percent_detail")){
			        	JSONObject jsonPercentDetail = JSONObject.fromObject(getRequestParm(jsonPercent,iterName));
			        	for (@SuppressWarnings("rawtypes")Iterator iterPencent = jsonPercentDetail.keys(); iterPencent.hasNext();){
			        		String iterPencentName = (String)iterPencent.next();
			        		if(iterPencentName.equals("live")){
			        			JSONObject jsonLive = JSONObject.fromObject(getRequestParm(jsonPercentDetail,iterPencentName));
			        			for (@SuppressWarnings("rawtypes")Iterator iterLive = jsonLive.keys(); iterLive.hasNext();){
			        				String liveName = (String)iterLive.next();
			        				sbPercent.append("live_").append(liveName).append("|").append(getRequestParm(jsonLive,liveName)).append(";");
			        				percentDetailMap.put("live_"+liveName, getRequestParm(jsonLive,liveName));
			        			}
			        		}else if(iterPencentName.equals("3d")){
					        	sbPercent.append("bb_3d").append("|").append(getRequestParm(jsonPercentDetail,iterPencentName)).append(";");
					        	percentDetailMap.put("bb_3d", getRequestParm(jsonPercentDetail,iterPencentName));
							}else{
								sbPercent.append(iterPencentName).append("|").append(getRequestParm(jsonPercentDetail,iterPencentName)).append(";");
			        			percentDetailMap.put(iterPencentName, getRequestParm(jsonPercentDetail,iterPencentName));
			        		}
			        	}
			        		
			        }else if(iterName.equals("vgold")){
						vGold = getRequestParm(jsonPercent,iterName);
						sbPercent.append(iterName).append("|").append(getRequestParm(jsonPercent,iterName)).append(";");
						percentDetailMap.put(iterName, getRequestParm(jsonPercent,iterName));
					}else{
			        	sbPercent.append(iterName).append("|").append(getRequestParm(jsonPercent,iterName)).append(";");
			        	percentDetailMap.put(iterName, getRequestParm(jsonPercent,iterName));
			        }
			        	
				}
			    percentMap.put(vGold, percentDetailMap);
			}

			logger.info("返水报表waterReport param:"+paramMap.toString());
			this.dsReportService.waterReport(paramMap,orderMap,orderLiveMap,percentMap,result);
			logger.info("返水报表waterReport end result :" + JSONObject.fromObject(result).toString());
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}
		return JSONObject.fromObject(result).toString();
	
	}
	
	/**
	 * 稽核统计临时
	 * 输入条件：日期区间、用户名称、网站名称
	 * 输出：统计每个用户的有效投注额  从temp_audit_total表中统计
	 * @param request
	 * @return
	 */
	public String auditTotalTemp(String strJson){
		Map<String,Object> result = new HashMap<String,Object>(); 
		try{
			logger.info("稽核统计auditTotalTemp tcp start:"+strJson);
			JSONObject request = JSONObject.fromObject(strJson);
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
		}

		return JSONObject.fromObject(result).toString();
	
	}
	
	/**
	 * 批量稽核统计接口
	 * 参数传递数组
	 * @param strJson
	 * @return
	 */
	public String auditTotalTempBatch(String strJson){
		long start = System.currentTimeMillis();
		Map<String,Object> result = new HashMap<String,Object>(); 
		Map<String,Object> param = new HashMap<String,Object>();
		try{
			logger.info("批量稽核统计auditTotalTempBatch tcp start:"+strJson);
			/*AuditTotalBatParam param = com.alibaba.fastjson.JSONObject.parseObject(strJson, AuditTotalBatParam.class);*/
			com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(strJson);
			String username = (String)jsonObject.get("username");
			int siteId = Integer.parseInt((String)jsonObject.get("siteId"));
			com.alibaba.fastjson.JSONArray timeArray = jsonObject.getJSONArray("timeList");
			param.put("username", username);
			param.put("siteId", siteId);
			param.put("timeArray", timeArray);
			this.dsReportService.auditTotalTempBatch(param,result);
			logger.info("批量稽核统计auditTotalTempBatch tcp end time:"+(System.currentTimeMillis()-start));
		}catch(Exception ex){
			logger.error("批量稽核出错：",ex);
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}

		return JSONObject.fromObject(result).toString();
	
	}
	
	
	
	/**
	 * 稽核统计
	 * 输入条件：日期区间、用户名称、网站名称
	 * 输出：统计每个用户的有效投注额  --从ds_report表中获取
	 * @param request
	 * @return
	 */
	public String auditTotal(String strJson){
		Map<String,Object> result = new HashMap<String,Object>(); 
		try{
			logger.info("稽核统计auditTotal tcp start:"+strJson);
			JSONObject request = JSONObject.fromObject(strJson);
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

			this.dsReportService.auditTotal(paramMap,result);
			logger.info("稽核统计auditTotal tcp end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}

		return JSONObject.fromObject(result).toString();
	
	}
	
	/**
	 * 小费管理
	 * 输入条件：日期区间、网站名称、来源
	 * 输出：小费列表
	 * @param request
	 * @return
	 */
	public Object tipsList(String strJson){
		Map<String,Object> result = new HashMap<String,Object>(); 
		try{
			logger.info("小费管理tipsList tcp start:"+strJson);
			JSONObject request = JSONObject.fromObject(strJson);
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
		}

		return com.alibaba.fastjson.JSONObject.toJSONString(result,SerializerFeature.BrowserCompatible);
	
	}
	

	/**
	 * 有效会员统计
	 * 输入条件：日期区间、网站名称、有效金额
	 * 输出：根据代理分组统计会员数
	 * @param request
	 * @return
	 */
	public String validUserCount(String strJson){
		Map<String,Object> result = new HashMap<String,Object>(); 
		try{
			logger.info("有效会员统计validUserCount tcp start:"+strJson);
			JSONObject request = JSONObject.fromObject(strJson);
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

		return JSONObject.fromObject(result).toString();
	
	}
	
	/**
	 * 彩金统计
	 * 输入条件：日期区间、网站名称、类型、来源
	 * 输出：统计中奖金额
	 * @param request
	 * @return
	 */
	public Object jpGameList(String strJson){
		Map<String,Object> result = new HashMap<String,Object>(); 
		try{
			logger.info("彩金统计jpGameList tcp start:"+strJson);
			JSONObject request = JSONObject.fromObject(strJson);
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
		}
		return JSONObject.fromObject(result).toString();
	
	}
	/**
	 * by guangguang
	 * 获取用户下注信息
	 * @param paramjsonStr
	 * @return
	 */
	public String getMemberBetInfo(String paramjsonStr){
		logger.info("====调用getMemberBetInfo接口======paramjsonStr:"+paramjsonStr);
		com.alibaba.fastjson.JSONObject result = new com.alibaba.fastjson.JSONObject(); 
		com.alibaba.fastjson.JSONObject data = new com.alibaba.fastjson.JSONObject(); 
		try {
			com.alibaba.fastjson.JSONObject obj = com.alibaba.fastjson.JSONObject.parseObject(paramjsonStr);
			String siteId = obj.getString("siteId");
			String username = obj.getString("username");
			String beginTime =  obj.getString("beginTime");
			String endTime =  obj.getString("endTime");
			String liveId = obj.getString("liveId");
			String page = obj.getString("page");
			String pageSize = obj.getString("pageSize");
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
			if (StringUtils.isNotBlank(page) && !StringUtils.isNumeric(page)) {
				result.put("returnMsg", "page param is wrong");
				result.put("returnCode", 110009);
				return result.toString();
			}
			if (StringUtils.isNotBlank(pageSize) && !StringUtils.isNumeric(pageSize)) {
				result.put("returnMsg", "pageSize param is wrong");
				result.put("returnCode", 110009);
				return result.toString();
			}
			
			Page pagation = new Page();
			pagation.setPageNo(page == null?1:Integer.valueOf(page));
			pagation.setPageSize(StringUtils.isBlank(pageSize)?20:Integer.valueOf(pageSize));
			MemberBetInfoParam queryParam = new MemberBetInfoParam();
			queryParam.setUsername(username);
			queryParam.setSiteId(Integer.valueOf(siteId));
			if(StringUtils.isNotBlank(beginTime)){
				queryParam.setBeginTime(DateUtil.parseByPatterns(beginTime, "yyyy-MM-dd"));
			}
			if(StringUtils.isNotBlank(endTime)){
				queryParam.setEndTime(DateUtil.parseByPatterns(endTime, "yyyy-MM-dd"));
			}
			
			dsReportService.getMemberBetInfo(data,result,queryParam,pagation);
			result.put("returnCode", 900000);
			result.put("returnMsg", "Success");
		} catch (Exception e) {
			logger.error(e.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}
		
		logger.info("调用getMemberBetInfo接口result:"+result.toString());
		return result.toString();
		
	}
	/**
	 * 统计指定日期的报表
	 * 
	 * @param paramjsonStr
	 * @return
	 */
	public String getBetInfoByDate(String paramjsonStr){
		logger.info("====调用getBetInfoByDate接口======paramjsonStr:"+paramjsonStr);
		com.alibaba.fastjson.JSONObject result = new com.alibaba.fastjson.JSONObject(); 
		try {
			com.alibaba.fastjson.JSONObject obj = com.alibaba.fastjson.JSONObject.parseObject(paramjsonStr);
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
		return result.toString();
	}
	public String getValidateMemberByDate(String paramjsonStr){
		logger.info("====调用getValidateMemberByDate接口======paramjsonStr:"+paramjsonStr);
		com.alibaba.fastjson.JSONObject result = new com.alibaba.fastjson.JSONObject(); 
		try {
			com.alibaba.fastjson.JSONObject obj = com.alibaba.fastjson.JSONObject.parseObject(paramjsonStr);
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
		return result.toString();
	}
	
	public String getMemberNameList(String paramjsonStr){
		logger.info("====调用getMemberNameList接口======paramjsonStr:"+paramjsonStr);
		com.alibaba.fastjson.JSONObject result = new com.alibaba.fastjson.JSONObject();
		try{
			com.alibaba.fastjson.JSONObject obj = com.alibaba.fastjson.JSONObject.parseObject(paramjsonStr);
			String siteId = obj.getString("siteId");
			if(StringUtils.isBlank(siteId) || !StringUtils.isNumeric(siteId)){
				result.put("returnMsg", "siteId param is wrong");
				result.put("returnCode", 110009);
				return result.toString();
			}
			dsReportService.getMemberNameList(result,obj);
			result.put("returnCode", 900000);
			result.put("returnMsg", "Success");
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}
		logger.info("调用getMemberNameList接口result:"+result.toString());
		return result.toString();
	}
	
	
	public String getBanlanceByLiveId(String paramjsonStr){
		logger.info("====调用getBanlanceByLiveId接口======paramjsonStr:"+paramjsonStr);
		com.alibaba.fastjson.JSONObject result = new com.alibaba.fastjson.JSONObject(); 
		try {
			com.alibaba.fastjson.JSONObject obj = com.alibaba.fastjson.JSONObject.parseObject(paramjsonStr);
			String siteId = obj.getString("siteId");
			String username = obj.getString("username");
			String liveId = obj.getString("liveId");
			if(StringUtils.isBlank(siteId) || !StringUtils.isNumeric(siteId)){
				result.put("returnMsg", "siteId param is wrong");
				result.put("returnCode", 110009);
				return result.toString();
			}
			if(StringUtils.isBlank(liveId) || !StringUtils.isNumeric(liveId)){
				result.put("returnMsg", "liveId param is wrong");
				result.put("returnCode", 110009);
				return result.toString();
			}
			Map<String,Object> queryParam = new HashMap<String,Object>();
			queryParam.put("username", username);
			queryParam.put("siteId", Integer.valueOf(siteId));
			queryParam.put("liveId", Integer.valueOf(liveId));
			dsReportService.getBanlanceByLiveId(result,queryParam);
			result.put("returnCode", 900000);
			result.put("returnMsg", "Success");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}
		logger.info("调用getBanlanceByLiveId接口result:"+result.toString());
		return result.toString();
	}
	
	public String getAllLiveByUser(String paramjsonStr){
		logger.info("====调用getAllLiveByUser接口======paramjsonStr:"+paramjsonStr);
		com.alibaba.fastjson.JSONObject result = new com.alibaba.fastjson.JSONObject(); 
		try {
			com.alibaba.fastjson.JSONObject obj = com.alibaba.fastjson.JSONObject.parseObject(paramjsonStr);
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
		}
		logger.info("调用getAllLiveByUser接口result:"+result.toString());
		return result.toString();
	}
	public String getAllTypeByUser(String paramjsonStr){
		logger.info("====调用getAllTypeByUser接口======paramjsonStr:"+paramjsonStr);
		com.alibaba.fastjson.JSONObject result = new com.alibaba.fastjson.JSONObject(); 
		try {
			com.alibaba.fastjson.JSONObject obj = com.alibaba.fastjson.JSONObject.parseObject(paramjsonStr);
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
		}
		logger.info("调用getAllTypeByUser接口result:"+result.toString());
		return result.toString();
	}
	
	public String setMemberData(String paramjsonStr) {
		logger.info("====调用setMemberData接口======paramjsonStr:"+paramjsonStr);
		com.alibaba.fastjson.JSONObject obj = com.alibaba.fastjson.JSONObject.parseObject(paramjsonStr);
		String username = obj.getString("username");
		String siteId = obj.getString("siteId");
		String agents = obj.getString("agents");
		String world = obj.getString("world");
		String corprator = obj.getString("corprator");
		String superior = obj.getString("superior");
		String company = obj.getString("company");
		Map<String,Object> result = new HashMap<String,Object>(); 
		try {
			if(StringUtils.isBlank(username)){
				result.put("message", "username param  cant not null");
				result.put("code", 110009);
				return result.toString();
			}
			if(StringUtils.isBlank(siteId) || !DataUtils.checkNum(siteId)){
				result.put("message", "siteId param is wrong");
				result.put("code", 110009);
				return result.toString();
			}
			if(StringUtils.isBlank(agents)){
				result.put("message", "agents param  cant not null");
				result.put("code", 110009);
				return result.toString();
			}
			if(StringUtils.isBlank(world)){
				result.put("message", "world param  cant not null");
				result.put("code", 110009);
				return result.toString();
			}
			if(StringUtils.isBlank(corprator)){
				result.put("message", "corprator param  cant not null");
				result.put("code", 110009);
				return result.toString();
			}
			if(StringUtils.isBlank(superior)){
				result.put("message", "superior param  cant not null");
				result.put("code", 110009);
				return result.toString();
			}
			if(StringUtils.isBlank(company)){
				result.put("message", "company param  cant not null");
				result.put("code", 110009);
				return result.toString();
			}
			dsReportService.setMemberData(result,username,siteId,agents,world,corprator,superior,company);
			result.put("message", "ok");
			result.put("code", 100000);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			result.put("message", "system error");
			result.put("code", 110001);
		}
		logger.info("username："+username+",siteId:"+siteId+",>>>>>>>>>result:"+result);
		return result.toString();
	}
	/**
	 * 网站排名统计
	 * @param paramjsonStr
	 * @return
	 */
	public String siteOrderDesc(String paramjsonStr) {
		logger.info("====调用siteOrderDesc接口======paramjsonStr:"+paramjsonStr);
		com.alibaba.fastjson.JSONObject obj = com.alibaba.fastjson.JSONObject.parseObject(paramjsonStr);
		String betTimeBegin = obj.getString("betTimeBegin");
		String betTimeEnd = obj.getString("betTimeEnd");
		com.alibaba.fastjson.JSONObject result = new com.alibaba.fastjson.JSONObject(); 
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
			String key=MD5.getMD5Str(obj.toString());
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
//			dsReportService.siteOrderDesc(result,obj);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			result.put("returnCode", 900001);
			result.put("returnMsg", "Success");
		}
		logger.info("调用siteOrderDesc接口=====>>>>>>>>>result:"+result);
		return JSON.toJSONString(result, SerializerFeature.BrowserCompatible);
	}
	public String getBetInfoByLiveId(String paramjsonStr) {
		logger.info("====调用getBetInfoByLiveId接口======paramjsonStr:"+paramjsonStr);
		com.alibaba.fastjson.JSONObject obj = com.alibaba.fastjson.JSONObject.parseObject(paramjsonStr);
		String siteId = obj.getString("siteId");
		String liveId = obj.getString("liveId");
//		String gameKind = obj.getString("gameKind");//游戏类型
		String betTimeBegin = obj.getString("betTimeBegin");//格式 yyyy-MM-dd HH:mm:ss
		String betTimeEnd = obj.getString("betTimeEnd");//格式 yyyy-MM-dd HH:mm:ss
		com.alibaba.fastjson.JSONObject result = new com.alibaba.fastjson.JSONObject(); 
		try {
			if(StringUtils.isBlank(siteId)){
				result.put("message", "siteId param  cant not null");
				result.put("code", 110009);
				return result.toString();
			}
			if(StringUtils.isBlank(liveId)){
				result.put("message", "liveId param  cant not null");
				result.put("code", 110009);
				return result.toString();
			}
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
			
			dsReportService.getBetInfoByLiveId(result,obj);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			result.put("returnCode", 900001);
			result.put("returnMsg", "System error");
		}
		logger.info("调用getBetInfoByLiveId接口=====>>>>>>>>>result:"+result);
		return JSON.toJSONString(result, SerializerFeature.BrowserCompatible);
	}
	
	/**
	 * 根据游戏类型(gametype)去统计
	 */
	public String betTotalByUser(String strJson){
		Map<String,Object> result = new HashMap<String,Object>(); 
		try{
			logger.info("统计单个用户注单数及金额betTotalByUser tcp start:"+strJson);
			JSONObject request = JSONObject.fromObject(strJson);
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

		return JSONObject.fromObject(result).toString();
	
	}
	public String getJackpot(String strJson){
		Map<String,Object> result = new HashMap<String,Object>(); 
		try{
			logger.info("getJackpot tcp start:"+strJson);
			JSONObject request = JSONObject.fromObject(strJson);
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
			if(StringUtils.isBlank(gameType)){
				result.put("returnCode", 9100011);
				result.put("returnMsg", "gameType is null");
				logger.info("gameType is null");
				return result.toString();
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

			this.dsReportService.getJackpot(paramMap,result);
			logger.info("getJackpot tcp end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System Error");
		}

		return JSONObject.fromObject(result).toString();
	}
	/**
	* @Title: getDeatilRecord 
	* @Description: TODO捕鱼王 jackpot 获取详细注单
	* @param @param strJson
	* @param @return    设定文件 
	* @return String    String json
	* @throws
	 */
	public String getDeatilRecord(String strJson) {
		JSONObject paramJson = JSONObject.fromObject(strJson);
		String siteIdStr = getRequestParm(paramJson,"siteId");
		String username = getRequestParm(paramJson,"username");
		String startTimeStr = getRequestParm(paramJson,"startTime");
		String endTimeStr = getRequestParm(paramJson,"endTime");
		int pageNum=paramJson.getInt("pageNum");
		int pageSize=paramJson.getInt("pageSize");
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
		}
		long end = System.currentTimeMillis();
		logger.info("time:{}",end-start);
		
		return JSONObject.fromObject(resultJson).toString();
		
	}
	/*public static void main(String[] args) {
		String param="{\"siteId\":\"1022\",\"username\":\"panying\",\"timeList\":[{\"startTime\":\"2017-06-21 03:09:53\",\"endTime\":\"2017-06-21 04:10:00\"},{\"startTime\":\"2017-06-20 02:46:35\",\"endTime\":\"2017-06-21 03:09:53\"},{\"startTime\":\"2017-06-19 02:53:19\",\"endTime\":\"2017-06-20 02:46:35\"},{\"startTime\":\"2017-06-18 03:07:53\",\"endTime\":\"2017-06-19 02:53:19\"},{\"startTime\":\"2017-06-17 02:57:43\",\"endTime\":\"2017-06-18 03:07:53\"},{\"startTime\":\"2017-06-16 03:35:40\",\"endTime\":\"2017-06-17 02:57:43\"},{\"startTime\":\"2017-06-16 03:06:42\",\"endTime\":\"2017-06-16 03:35:40\"},{\"startTime\":\"2017-06-15 02:46:20\",\"endTime\":\"2017-06-16 03:06:42\"},{\"startTime\":\"2017-06-14 02:36:55\",\"endTime\":\"2017-06-15 02:46:20\"},{\"startTime\":\"2017-06-14 02:36:55\",\"endTime\":\"2017-06-15 02:46:20\"},{\"startTime\":\"2017-06-14 02:36:55\",\"endTime\":\"2017-06-15 02:46:20\"},{\"startTime\":\"2017-06-14 02:36:55\",\"endTime\":\"2017-06-15 02:46:20\"},{\"startTime\":\"2017-06-14 02:36:55\",\"endTime\":\"2017-06-15 02:46:20\"},{\"startTime\":\"2017-06-14 02:36:55\",\"endTime\":\"2017-06-15 02:46:20\"},{\"startTime\":\"2017-06-14 02:36:55\",\"endTime\":\"2017-06-15 02:46:20\"},{\"startTime\":\"2017-06-14 02:36:55\",\"endTime\":\"2017-06-15 02:46:20\"},{\"startTime\":\"2017-06-14 02:36:55\",\"endTime\":\"2017-06-15 02:46:20\"},{\"startTime\":\"2017-06-14 02:36:55\",\"endTime\":\"2017-06-15 02:46:20\"},{\"startTime\":\"2017-06-14 02:36:55\",\"endTime\":\"2017-06-15 02:46:20\"},{\"startTime\":\"2017-06-14 02:36:55\",\"endTime\":\"2017-06-15 02:46:20\"},{\"startTime\":\"2017-06-14 02:36:55\",\"endTime\":\"2017-06-15 02:46:20\"},{\"startTime\":\"2017-06-14 02:36:55\",\"endTime\":\"2017-06-15 02:46:20\"},{\"startTime\":\"2017-06-14 02:36:55\",\"endTime\":\"2017-06-15 02:46:20\"},{\"startTime\":\"2017-06-14 02:36:55\",\"endTime\":\"2017-06-15 02:46:20\"},{\"startTime\":\"2017-06-14 02:36:55\",\"endTime\":\"2017-06-15 02:46:20\"},{\"startTime\":\"2017-06-14 02:36:55\",\"endTime\":\"2017-06-15 02:46:20\"}]}";
		DsReportHproseAction ds = new DsReportHproseAction();
		ds.auditTotalTempBatch(param);
	}*/
	//查询捕鱼王统计记录		
	public String getTotalRecord(String strJson) {
			Map<String,Object> result = new HashMap<String,Object>(); 
			try{
				logger.info("getJackpot tcp start:"+strJson);
				long start = System.currentTimeMillis();
				JSONObject paramMap = JSONObject.fromObject(strJson);
				String siteId = getRequestParm(paramMap,"siteId");
				String startTime = getRequestParm(paramMap,"startTime");
				String endTime = getRequestParm(paramMap,"endTime");
				
				if(StringUtils.isBlank(startTime)){
					result.put("returnCode", 910002);
					result.put("returnMsg", "startTime is null");
					logger.info("startTime is null");
					return result.toString();
				}
				if(StringUtils.isNotBlank(siteId)){
					paramMap.put("siteId", siteId);
				}
				if(StringUtils.isNotBlank(startTime)){
					paramMap.put("startTime", startTime);
				}
				if(StringUtils.isNotBlank(endTime)){
					paramMap.put("endTime", endTime);
				}
				
				hunterJackpotService.getTotalRecord(paramMap,result);
				long end = System.currentTimeMillis();
				logger.info("getTotalRecord----result"+"耗时："+(end-start));
			}
			catch(Exception e){
				logger.error("{},{}",e);
				result.put("returnCode", 910001);
				result.put("returnMsg", "System Error");
			}
			return JSONObject.fromObject(result).toString();
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
	public String getReportGroupByGameType(String strJson){
		logger.info("进入getReportGroupByGameType参数：{}",strJson);
		List<Map<String,Object>> listMap=new ArrayList<Map<String,Object>>();
		com.alibaba.fastjson.JSONObject paramJson=null;
		int siteId = 0;
		String username="";
		String startTimeStr="";
		String endTimeStr="";
		long start = System.currentTimeMillis();
		com.alibaba.fastjson.JSONObject result=new com.alibaba.fastjson.JSONObject();
		try {
			paramJson = com.alibaba.fastjson.JSONObject.parseObject(strJson);
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
			result.put("dataList",com.alibaba.fastjson.JSONArray.toJSONString(listMap));
			result.put("returnCode", 900000);
			result.put("returnMsg", "Success");
		} catch (Exception e) {
			// TODO: handle exception
			result.put("returnMsg", "System error");
			result.put("returnCode", 110009);
			logger.info("getReportGroupByGameType异常，参数：{}，error：{}",strJson,e.getMessage());
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		logger.info("耗时：{}",end-start);
		return result.toString();
	}
	
	public String getTotalBySite(String strJson){
		String siteId = "";
		String beginTime="";
		String endTime="";
		int page =1;
		int pageLimit=20;
		long start = System.currentTimeMillis();
		com.alibaba.fastjson.JSONObject paramJson=null;
		com.alibaba.fastjson.JSONObject result=new com.alibaba.fastjson.JSONObject();
		try {
			paramJson = com.alibaba.fastjson.JSONObject.parseObject(strJson);
			siteId=paramJson.getString("siteId");
			beginTime=paramJson.getString("beginTime");
			endTime=paramJson.getString("endTime");
			page=paramJson.getIntValue("page");
			pageLimit=paramJson.getIntValue("pageLimit");
			if(StringUtils.isBlank(siteId)){
				result.put("returnMsg", "siteId is null");
				result.put("returnCode", 110009);
				return result.toString();
			}
			if(!StringUtils.isNumeric(siteId)){
				result.put("returnMsg", "siteId format wrong");
				result.put("returnCode", 110009);
				return result.toString();
			}
			dsReportService.getTotalBySite(result, siteId, beginTime, endTime, page, pageLimit);
			
			result.put("returnMsg", "success");
			result.put("returnCode", 900000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.info("用户打码量统计接口错误:"+e);
			result.put("returnMsg", "system error");
			result.put("returnCode", 110009);
		}
		long end = System.currentTimeMillis();
		logger.info("耗时：{}",end-start);
		return result.toString();
	}
}
