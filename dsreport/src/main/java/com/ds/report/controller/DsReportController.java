package com.ds.report.controller;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.onetwo.common.utils.DateUtil;
import org.onetwo.common.utils.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ds.report.service.DsReportServiceImpl;
import com.ds.report.service.HunterJackpotServiceImpl;
import com.ds.report.utils.DataUtils;
import com.ds.report.utils.DateUtils;
import com.ds.report.utils.RequestUtils;
import com.ds.report.vo.BetInfoByDateParam;
import com.ds.report.vo.HunterDetailRecordVo;
import com.ds.report.vo.MemberBetInfoParam;
import com.ds.report.vo.ValidateMemberByDateParam;

@Controller
public class DsReportController {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private DsReportServiceImpl dsReportService;
	
	@Resource
	private HunterJackpotServiceImpl hunterJackpotServiceImpl;
	/**
	 * 注单统计报表
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/listTotalReport",method=RequestMethod.POST)
	@ResponseBody
	public Object listTotalReport(HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>(); 
		long start=System.currentTimeMillis();
		try{
			logger.info("注单统计报表listTotalReport start");
			RequestUtils.showParams(request);
			String jsonStr = RequestUtils.getParams(request);
			com.alibaba.fastjson.JSONObject param = JSON.parseObject(jsonStr);
			logger.info(param.toJSONString());
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
			logger.info("注单统计报表listTotalReport param:"+paramMap.toString());
			this.dsReportService.queryTotalReport(paramMap,result);
			logger.info("注单统计报表listTotalReport end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
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
	public Object listDetailReport(HttpServletRequest request){
		com.alibaba.fastjson.JSONObject result = new com.alibaba.fastjson.JSONObject(); 
		long start=System.currentTimeMillis();
		try{
			logger.info("注单明细报表listDetailReport start");
			RequestUtils.showParams(request);
			String jsonStr = RequestUtils.getParams(request);
			com.alibaba.fastjson.JSONObject param = JSON.parseObject(jsonStr);
			logger.info(param.toJSONString());
			String username = param.getString("username");
			String siteId = param.getString("siteId");
			String betTimeBegin = param.getString("betTimeBegin");
			String betTimeEnd = param.getString("betTimeEnd");
			String startTime = param.getString("startTime");
			String endTime = param.getString("endTime");
			String gameKind = param.getString("gameKind");
			String gameType = param.getString("gameType");
			String liveId = param.getString("liveId");
			//桌子ID（蛮牛）
			String tableId = getRequestParm(request,"tableId");
			//期数（蛮牛，现金网）
			String term = getRequestParm(request,"term");
			String key = param.getString("key");
			String page = param.getString("page");
			String pageLimit = param.getString("pageLimit");
			
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
			logger.info("注单明细报表listDetailReport parma:"+paramMap.toString());
			this.dsReportService.queryDetailReport(paramMap,result);
			logger.info("注单明细报表listDetailReport end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}
		long end=System.currentTimeMillis();
		logger.info("time:"+(end-start)+">>>>>>result:"+result);
		return result;
	
	}
	
	/**
	 * 按天统计单个用户注单数及金额
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/betTotalByDay",method=RequestMethod.POST)
	@ResponseBody
	public Object betTotalByDay(HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>(); 
		long start=System.currentTimeMillis();
		try{
			logger.info("按天统计单个用户注单数及金额betTotalByDay start");
			
			RequestUtils.showParams(request);
			String jsonStr = RequestUtils.getParams(request);
			com.alibaba.fastjson.JSONObject param = JSON.parseObject(jsonStr);
			logger.info(param.toJSONString());
			
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
	//		this.dsReportService.queryBetTotalByDay(paramMap,result);
			this.dsReportService.queryBetTotalByDayNew(paramMap,result);
			logger.info("按天统计单个用户注单数及金额betTotalByDay end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}
		long end=System.currentTimeMillis();
		logger.info("time:"+(end-start)+">>>>>>result:"+result);
		return result;
	
	}
	
	/**
	 * 统计单个用户注单数及金额
	 * @param request
	 * @return
	 */
/*	@RequestMapping(value="/betTotalByUser",method=RequestMethod.POST)
	@ResponseBody
	public Object betTotalByUser(HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>(); 
		long start=System.currentTimeMillis();
		try{
			logger.info("统计单个用户注单数及金额betTotalByUser start");
			RequestUtils.showParams(request);
			String jsonStr = RequestUtils.getParams(request);
			com.alibaba.fastjson.JSONObject param = JSON.parseObject(jsonStr);
			logger.info(param.toJSONString());
			
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
			logger.info("统计单个用户注单数及金额betTotalByUser param:"+paramMap.toString());
		//	this.dsReportService.queryBetTotalByUser(paramMap,result);
			this.dsReportService.queryBetTotalByUserGroupGameType(paramMap,result);
			logger.info("统计单个用户注单数及金额betTotalByUser end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}
		long end=System.currentTimeMillis();
		logger.info("time:"+(end-start)+">>>>>>result:"+result);
		return result;
	
	}*/
	

	/**
	 * 优惠统计
	 * 输入条件：日期区间、层级、用户名称、网站名称
	 * 输出：根据用户名称统计每天游戏大类的有效投注额
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/privilegeTotal",method=RequestMethod.POST)
	@ResponseBody
	public Object privilegeTotal(HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>(); 
		long start=System.currentTimeMillis();
		try{
			logger.info("优惠统计privilegeTotal start");
			RequestUtils.showParams(request);
			String jsonStr = RequestUtils.getParams(request);
			com.alibaba.fastjson.JSONObject param = JSON.parseObject(jsonStr);
			logger.info(param.toJSONString());
			String siteId = param.getString("siteId");
			String agentLevel = param.getString("agentLevel");
			String username = param.getString("username");
			String betTimeBegin = param.getString("betTimeBegin");
			String betTimeEnd = param.getString("betTimeEnd");
			String key = param.getString("key");
			
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
			logger.info("优惠统计privilegeTotal param:"+paramMap.toString());
			this.dsReportService.privilegeTotal(paramMap,result);
			logger.info("优惠统计privilegeTotal end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}
		long end=System.currentTimeMillis();
		logger.info("time:"+(end-start)+">>>>>>result:"+result);
		return result;
	
	}
	
	/**
	 * 返水报表
	 * 输入条件：返水优惠设定值、日期区间、层级、用户名称、网站名称
	 * 输出：根据用户名称统计每个游戏大类的返水金额
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/waterReportByProc",method=RequestMethod.POST)
	@ResponseBody
	public Object waterReportByProc(HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>(); 
		long start=System.currentTimeMillis();
		try{
			logger.info("返水报表waterReport start");
			RequestUtils.showParams(request);
			String jsonStr = RequestUtils.getParams(request);
			com.alibaba.fastjson.JSONObject param = JSON.parseObject(jsonStr);
			logger.info(param.toJSONString());
			String siteId = param.getString("siteId");
			String agentLevel = param.getString("agentLevel");
			String username = param.getString("username");
			String betTimeBegin = param.getString("betTimeBegin");
			String betTimeEnd = param.getString("betTimeEnd");
			String key = param.getString("key");
			String waterType = param.getString("waterType");

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
			String strOrder = param.getString("return_order");
			String strPercent = param.getString("return_percent");
			JSONObject returnOrder=JSONObject.fromObject(getJsonParm(JSONObject.fromObject(strOrder),"return_order"));
			JSONArray returnPercent=JSONArray.fromObject(getJsonParm(JSONObject.fromObject(strPercent),"return_percent"));
			StringBuilder sbOrder = new StringBuilder();
			for (@SuppressWarnings("rawtypes")Iterator iter = returnOrder.keys(); iter.hasNext();){
				String iterName = (String)iter.next();
				if(iterName.equals("live_order")){
					JSONObject liveOrder=JSONObject.fromObject(getJsonParm(returnOrder,"live_order"));
					for (@SuppressWarnings("rawtypes")Iterator iterOrder = liveOrder.keys(); iterOrder.hasNext();){
						String orderName = (String)iterOrder.next();
						sbOrder.append("live_").append(orderName).append("|").append(getJsonParm(liveOrder,orderName)).append(";");
					}
						
				}else{
					sbOrder.append(iterName).append("|").append(getJsonParm(returnOrder,iterName)).append(";");
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
			        	JSONObject jsonPercentDetail = JSONObject.fromObject(getJsonParm(jsonPercent,iterName));
			        	for (@SuppressWarnings("rawtypes")Iterator iterPencent = jsonPercentDetail.keys(); iterPencent.hasNext();){
			        		String iterPencentName = (String)iterPencent.next();
			        		if(iterPencentName.equals("live")){
			        			JSONObject jsonLive = JSONObject.fromObject(getJsonParm(jsonPercentDetail,iterPencentName));
			        			for (@SuppressWarnings("rawtypes")Iterator iterLive = jsonLive.keys(); iterLive.hasNext();){
			        				String liveName = (String)iterLive.next();
			        				sbPercent.append("live_").append(liveName).append("|").append(getJsonParm(jsonLive,liveName)).append(";");
			        			}
			        		}else{
			        			sbPercent.append(iterPencentName).append("|").append(getJsonParm(jsonPercentDetail,iterPencentName)).append(";");
			        		}
			        	}
			        		
			        }else{
			        	sbPercent.append(iterName).append("|").append(getJsonParm(jsonPercent,iterName)).append(";");
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
		long end=System.currentTimeMillis();
		logger.info("time:"+(end-start)+">>>>>>result:"+result);
		return result;
	
	}
	
	
	/**
	 * 退佣统计
	 * 输入条件：日期区间、网站名称
	 * 输出：根据代理分组统计有效投注金额、派彩金额、会员数
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/commissionTotal",method=RequestMethod.POST)
	@ResponseBody
	public Object commissionTotal(HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>(); 
		long start=System.currentTimeMillis();
		try{
			logger.info("退佣统计commissionTotal start");
			RequestUtils.showParams(request);
			String jsonStr = RequestUtils.getParams(request);
			com.alibaba.fastjson.JSONObject param = JSON.parseObject(jsonStr);
			logger.info(param.toJSONString());
			
			
			String siteId = param.getString("siteId");
			String betTimeBegin = param.getString("betTimeBegin");
			String betTimeEnd = param.getString("betTimeEnd");
			String agentLevel = param.getString("agentLevel");
			String username = param.getString("username");
			String key = param.getString("key");
			String defValidamount = param.getString("defValidamount");
			
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
			
			logger.info("退佣统计commissionTotal param:"+paramMap.toString());
			this.dsReportService.commissionTotal(paramMap,result);
			logger.info("退佣统计commissionTotal end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}
		long end=System.currentTimeMillis();
		logger.info("time:"+(end-start)+">>>>>>result:"+result);
		return result;
	
	}
	@RequestMapping(value="/commissionTotalByPage",method=RequestMethod.POST)
	@ResponseBody
	public Object commissionTotalByPage(HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>(); 
		long start=System.currentTimeMillis();
		try{
			logger.info("退佣统计commissionTotal start");
			RequestUtils.showParams(request);
			String jsonStr = RequestUtils.getParams(request);
			com.alibaba.fastjson.JSONObject param = JSON.parseObject(jsonStr);
			logger.info(param.toJSONString());
			String siteId = param.getString("siteId");
			String betTimeBegin = param.getString("betTimeBegin");
			String betTimeEnd = param.getString("betTimeEnd");
			String agentLevel = param.getString("agentLevel");
			String username = param.getString("username");
			String key = param.getString("key");
			String defValidamount = param.getString("defValidamount");
			
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
			
			logger.info("退佣统计commissionTotalByPage param:"+paramMap.toString());
			this.dsReportService.commissionTotalByPage(paramMap,result);
			logger.info("退佣统计commissionTotalByPage end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}
		long end=System.currentTimeMillis();
		logger.info("time:"+(end-start)+">>>>>>result:"+result);
		return result;
	
	}
	
	private String getRequestParm(HttpServletRequest request,String paramName){
		try{
			return request.getParameter(paramName).trim();
		}catch(Exception ex){
			return "";
		}
	}
	
	private String getJsonParm(JSONObject jsonParam,String paramName){
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
	@RequestMapping(value="/waterReport",method=RequestMethod.POST)
	@ResponseBody
	public Object waterReport(HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>(); 
		long start=System.currentTimeMillis();
		try{
			logger.info("返水报表waterReport start");
			RequestUtils.showParams(request);
			String jsonStr = RequestUtils.getParams(request);
			com.alibaba.fastjson.JSONObject param = JSON.parseObject(jsonStr);
			logger.info(param.toJSONString());
			String siteId = param.getString("siteId");
			String agentLevel = param.getString("agentLevel");
			String username = param.getString("username");
			String betTimeBegin = param.getString("betTimeBegin");
			String betTimeEnd = param.getString("betTimeEnd");
			String key = param.getString("key");
			String waterType = param.getString("waterType");
			
			//logger.info();
			
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
			String strOrder = param.getString("return_order");
			String strPercent = param.getString("return_percent");
			JSONObject returnOrder=JSONObject.fromObject(strOrder);
			JSONArray returnPercent=JSONArray.fromObject(strPercent);
			StringBuilder sbOrder = new StringBuilder();
			
			Map<String,Object> orderMap = new HashMap<String,Object>(); 
			Map<String,Object> orderLiveMap = new HashMap<String,Object>(); 
			for (@SuppressWarnings("rawtypes")Iterator iter = returnOrder.keys(); iter.hasNext();){
				String iterName = (String)iter.next();
				if(iterName.equals("live_order")){
					JSONObject liveOrder=JSONObject.fromObject(getJsonParm(returnOrder,"live_order"));
					//orderMap.put(getJsonParm(returnOrder,iterName), iterName);
					for (@SuppressWarnings("rawtypes")Iterator iterOrder = liveOrder.keys(); iterOrder.hasNext();){
						String orderName = (String)iterOrder.next();
						sbOrder.append("live_").append(orderName).append("|").append(getJsonParm(liveOrder,orderName)).append(";");
						orderLiveMap.put(getJsonParm(liveOrder,orderName), "live_"+orderName);
					}
						
				}else if(iterName.equals("3d")){
					sbOrder.append(iterName).append("|").append(getJsonParm(returnOrder,iterName)).append(";");
					orderMap.put(getJsonParm(returnOrder,iterName), "bb_3d");
				}else{
					sbOrder.append(iterName).append("|").append(getJsonParm(returnOrder,iterName)).append(";");
					orderMap.put(getJsonParm(returnOrder,iterName), iterName);
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
			        	JSONObject jsonPercentDetail = JSONObject.fromObject(getJsonParm(jsonPercent,iterName));
			        	for (@SuppressWarnings("rawtypes")Iterator iterPencent = jsonPercentDetail.keys(); iterPencent.hasNext();){
			        		String iterPencentName = (String)iterPencent.next();
			        		if(iterPencentName.equals("live")){
			        			JSONObject jsonLive = JSONObject.fromObject(getJsonParm(jsonPercentDetail,iterPencentName));
			        			for (@SuppressWarnings("rawtypes")Iterator iterLive = jsonLive.keys(); iterLive.hasNext();){
			        				String liveName = (String)iterLive.next();
			        				sbPercent.append("live_").append(liveName).append("|").append(getJsonParm(jsonLive,liveName)).append(";");
			        				percentDetailMap.put("live_"+liveName, getJsonParm(jsonLive,liveName));
			        			}
			        		}else if(iterPencentName.equals("3d")){
					        	sbPercent.append("bb_3d").append("|").append(getJsonParm(jsonPercentDetail,iterPencentName)).append(";");
					        	percentDetailMap.put("bb_3d", getJsonParm(jsonPercentDetail,iterPencentName));
							}else{
			        			sbPercent.append(iterPencentName).append("|").append(getJsonParm(jsonPercentDetail,iterPencentName)).append(";");
			        			percentDetailMap.put(iterPencentName, getJsonParm(jsonPercentDetail,iterPencentName));
			        		}
			        	}
			        		
			        }else if(iterName.equals("vgold")){
						vGold = getJsonParm(jsonPercent,iterName);
						sbPercent.append(iterName).append("|").append(getJsonParm(jsonPercent,iterName)).append(";");
						percentDetailMap.put(iterName, getJsonParm(jsonPercent,iterName));
					}else{
			        	sbPercent.append(iterName).append("|").append(getJsonParm(jsonPercent,iterName)).append(";");
			        	percentDetailMap.put(iterName, getJsonParm(jsonPercent,iterName));
			        }
			        	
				}
			    percentMap.put(vGold, percentDetailMap);
			   
			}  
			//logger.info("返水报表waterReport sbPercent:"+sbPercent.toString());	
			    
			//paramMap.put("return_order", sbOrder.toString());
			//paramMap.put("return_percent", sbPercent.toString());
			
			logger.info("返水报表waterReport param:"+paramMap.toString());
			this.dsReportService.waterReport(paramMap,orderMap,orderLiveMap,percentMap,result);
			logger.info("返水报表waterReport end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}
		long end=System.currentTimeMillis();
		logger.info("time:"+(end-start)+">>>>>>result:"+result);
		return result;
	
	}
	
	/**
	 * 稽核统计
	 * 输入条件：日期区间、用户名称、网站名称
	 * 输出：统计每个用户的有效投注额
	 * @param request  --从de_report表中统计
	 * @return
	 */
	@RequestMapping(value="/auditTotal",method=RequestMethod.POST)
	@ResponseBody
	public Object auditTotal(HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>(); 
		long start=System.currentTimeMillis();
		try{
			logger.info("稽核统计auditTotal start");
			
			RequestUtils.showParams(request);
			String jsonStr = RequestUtils.getParams(request);
			com.alibaba.fastjson.JSONObject param = JSON.parseObject(jsonStr);
			logger.info(param.toJSONString());
					
			String siteId = param.getString("siteId");
			String username = param.getString("username");
			String betTimeBegin = param.getString("betTimeBegin");
			String betTimeEnd = param.getString("betTimeEnd");
			String startTime = param.getString("startTime");
			String endTime = param.getString("endTime");
			String key = param.getString("key");
			
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
			if(StringUtils.isNotBlank(startTime)){
				paramMap.put("startTime", startTime);
			}	
			if(StringUtils.isNotBlank(endTime)){
				paramMap.put("endTime", endTime);
			}
			logger.info("稽核统计auditTotal param:"+paramMap.toString());
			this.dsReportService.auditTotal(paramMap,result);
			logger.info("稽核统计auditTotal end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}
		long end=System.currentTimeMillis();
		logger.info("time:"+(end-start)+">>>>>>result:"+result);
		return result;
	
	}
	
	
	/**
	 * 稽核统计临时
	 * 输入条件：日期区间、用户名称、网站名称
	 * 输出：统计每个用户的有效投注额  从temp_audit_total表中统计
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/auditTotalTemp",method=RequestMethod.POST)
	@ResponseBody
	public Object auditTotalTemp(HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>(); 
		long start=System.currentTimeMillis();
		try{
			logger.info("稽核统计auditTotal start");
			RequestUtils.showParams(request);
			String jsonStr = RequestUtils.getParams(request);
			com.alibaba.fastjson.JSONObject param = JSON.parseObject(jsonStr);
			logger.info(param.toJSONString());
			
			
			String siteId = param.getString("siteId");
			String username = param.getString("username");
			String betTimeBegin = param.getString("betTimeBegin");
			String betTimeEnd = param.getString("betTimeEnd");
			String startTime = param.getString("startTime");
			String endTime = param.getString("endTime");
			String key = param.getString("key");
			
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
			if(StringUtils.isNotBlank(startTime)){
				paramMap.put("startTime", startTime);
			}	
			if(StringUtils.isNotBlank(endTime)){
				paramMap.put("endTime", endTime);
			}
			logger.info("稽核统计auditTotal param:"+paramMap.toString());
			this.dsReportService.auditTotalTemp(paramMap,result);
			logger.info("稽核统计auditTotal end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}
		long end=System.currentTimeMillis();
		logger.info("time:"+(end-start)+">>>>>>result:"+result);
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
	public Object tipsList(HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>(); 
		long start=System.currentTimeMillis();
		try{
			logger.info("小费管理tipsList start");
			RequestUtils.showParams(request);
			String jsonStr = RequestUtils.getParams(request);
			com.alibaba.fastjson.JSONObject param = JSON.parseObject(jsonStr);
			logger.info(param.toJSONString());
			String siteId = param.getString("siteId");
			String betTimeBegin = param.getString("betTimeBegin");
			String betTimeEnd = param.getString("betTimeEnd");
			String liveId = param.getString("liveId");
			String key = param.getString("key");
			String page = param.getString("page");
			String pageLimit = param.getString("pageLimit");
			
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
			paramMap.put("transferType", "DONATEFEE");
			logger.info("小费管理tipsList param:"+paramMap.toString());
			this.dsReportService.tipsList(paramMap,result);
			logger.info("小费管理tipsList end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}
		long end=System.currentTimeMillis();
		logger.info("time:"+(end-start)+">>>>>>result:"+result);
		return result;
	
	}
	
	
	/**
	 * 有效会员统计
	 * 输入条件：日期区间、网站名称、有效金额
	 * 输出：根据代理分组统计会员数
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/validUserCount",method=RequestMethod.POST)
	@ResponseBody
	public Object validUserCount(HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		long start=System.currentTimeMillis();
		try{
			logger.info("有效会员统计validUserCount start");
			RequestUtils.showParams(request);
			String jsonStr = RequestUtils.getParams(request);
			com.alibaba.fastjson.JSONObject param = JSON.parseObject(jsonStr);
			logger.info(param.toJSONString());
			String siteId = param.getString("siteId");
			String betTimeBegin = param.getString("betTimeBegin");
			String betTimeEnd = param.getString("betTimeEnd");
			String agentLevel = param.getString("agentLevel");
			String username = param.getString("username");
			String key = param.getString("key");
			String defValidamount = param.getString("defValidamount");
			String page = param.getString("page");
			String pageLimit = param.getString("pageLimit");
			
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
			
			logger.info("有效会员统计validUserCount param:"+paramMap.toString());
			this.dsReportService.validUserCount(paramMap,result);
			logger.info("有效会员统计validUserCount end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}
		long end=System.currentTimeMillis();
		logger.info("time:"+(end-start)+">>>>>>result:"+result);
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
	public Object jpGameList(HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>(); 
		long start=System.currentTimeMillis();
		try{
			logger.info("彩金统计jpGameList start");
			RequestUtils.showParams(request);
			String jsonStr = RequestUtils.getParams(request);
			com.alibaba.fastjson.JSONObject param = JSON.parseObject(jsonStr);
			logger.info(param.toJSONString());
			String siteId = param.getString("siteId");
			String betTimeBegin = param.getString("betTimeBegin");
			String betTimeEnd = param.getString("betTimeEnd");
			String jptype = param.getString("jptype");
			String liveId = param.getString("liveId");
			String key = param.getString("key");
			String page = param.getString("page");
			String pageLimit = param.getString("pageLimit");
			
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
		long end=System.currentTimeMillis();
		logger.info("time:"+(end-start)+">>>>>>result:"+result);
		return result;
	
	}
	@RequestMapping(value="/setMemberData",method=RequestMethod.POST)
	public @ResponseBody Object setMemberData(HttpServletRequest request) {
		logger.info("===============调用setMemberData接口=======================");
		long start =System.currentTimeMillis();
		RequestUtils.showParams(request);
		
		String jsonStr = RequestUtils.getParams(request);
		com.alibaba.fastjson.JSONObject param = JSON.parseObject(jsonStr);
		logger.info(param.toJSONString());
		
		String username = param.getString("username");
		String siteId = param.getString("siteId");
		String agents = param.getString("agents");
		String world = param.getString("world");
		String corprator = param.getString("corprator");
		String superior = param.getString("superior");
		String company = param.getString("company");
		String ip = request.getRemoteAddr();
		logger.info("请求者IP："+ip);
		Map<String,Object> result = new HashMap<String,Object>(); 
		try {
			if(StringUtils.isBlank(username)){
				result.put("message", "username param  cant not null");
				result.put("code", 110009);
				return result;
			}
			if(StringUtils.isBlank(siteId) || !DataUtils.checkNum(siteId)){
				result.put("message", "siteId param is wrong");
				result.put("code", 110009);
				return result;
			}
			if(StringUtils.isBlank(agents)){
				result.put("message", "agents param  cant not null");
				result.put("code", 110009);
				return result;
			}
			if(StringUtils.isBlank(world)){
				result.put("message", "world param  cant not null");
				result.put("code", 110009);
				return result;
			}
			if(StringUtils.isBlank(corprator)){
				result.put("message", "corprator param  cant not null");
				result.put("code", 110009);
				return result;
			}
			if(StringUtils.isBlank(superior)){
				result.put("message", "superior param  cant not null");
				result.put("code", 110009);
				return result;
			}
			if(StringUtils.isBlank(company)){
				result.put("message", "company param  cant not null");
				result.put("code", 110009);
				return result;
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
		long end =System.currentTimeMillis();
		logger.info("time:"+(end-start)+"username："+username+",siteId:"+siteId+",>>>>>>>>>result:"+result);
		return result;
	}
	@RequestMapping(value="/getAllLiveByUser",method=RequestMethod.POST)
	@ResponseBody
	public Object getAllLiveByUser(HttpServletRequest request){
		com.alibaba.fastjson.JSONObject result = new com.alibaba.fastjson.JSONObject(); 
		long start=System.currentTimeMillis();
		try{
			logger.info("getAllLiveByUser start");
			RequestUtils.showParams(request);
			String jsonStr = RequestUtils.getParams(request);
			com.alibaba.fastjson.JSONObject param = JSON.parseObject(jsonStr);
			logger.info(param.toJSONString());
			String siteId = param.getString("siteId");
			String betTimeBegin = param.getString("beginTime");
			String betTimeEnd = param.getString("endTime");
			String username = param.getString("username");
			
			com.alibaba.fastjson.JSONObject paramMap = new com.alibaba.fastjson.JSONObject();
			if(StringUtils.isNotBlank(siteId)){
				paramMap.put("siteId", siteId);
			}
			if(StringUtils.isNotBlank(betTimeBegin)){
				paramMap.put("betTimeBegin",betTimeBegin);
			}

			if(StringUtils.isNotBlank(betTimeEnd)){
				paramMap.put("betTimeEnd", betTimeEnd);
			}
			if(StringUtils.isNotBlank(username)){
				paramMap.put("username", username);
			}
			
			logger.info("getAllLiveByUser param:"+paramMap.toString());
			this.dsReportService.getAllLiveByUser(result,paramMap);
			logger.info("getAllLiveByUser end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}
		long end=System.currentTimeMillis();
		logger.info("time:"+(end-start)+">>>>>>result:"+result);
		return result;
	
	}
	@RequestMapping(value="/getAllTypeByUser",method=RequestMethod.POST)
	@ResponseBody
	public Object getAllTypeByUser(HttpServletRequest request){
		com.alibaba.fastjson.JSONObject result = new com.alibaba.fastjson.JSONObject(); 
		long start=System.currentTimeMillis();
		try{
			logger.info("getAllTypeByUser start");
			RequestUtils.showParams(request);
			String jsonStr = RequestUtils.getParams(request);
			com.alibaba.fastjson.JSONObject param = JSON.parseObject(jsonStr);
			logger.info(param.toJSONString());
			String siteId = param.getString("siteId");
			String betTimeBegin = param.getString("beginTime");
			String betTimeEnd = param.getString("endTime");
			String username = param.getString("username");
			
			com.alibaba.fastjson.JSONObject paramMap = new com.alibaba.fastjson.JSONObject();
			if(StringUtils.isNotBlank(siteId)){
				paramMap.put("siteId", siteId);
			}
			if(StringUtils.isNotBlank(betTimeBegin)){
				paramMap.put("beginTime",betTimeBegin);
			}

			if(StringUtils.isNotBlank(betTimeEnd)){
				paramMap.put("endTime", betTimeEnd);
			}
			if(StringUtils.isNotBlank(username)){
				paramMap.put("username", username);
			}
			
			logger.info("getAllTypeByUser param:"+paramMap.toString());
			dsReportService.getAllTypeByUser(result,paramMap);
			logger.info("getAllTypeByUser end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			result.put("returnCode", 910001);
			result.put("returnMsg", "System error");
		}
		long end=System.currentTimeMillis();
		logger.info("time:"+(end-start)+">>>>>>result:"+result);
		return result;
	
	}
	@RequestMapping(value="/getBetInfoByDate",method=RequestMethod.POST)
	@ResponseBody
	public Object getBetInfoByDate(HttpServletRequest request){
		com.alibaba.fastjson.JSONObject result = new com.alibaba.fastjson.JSONObject(); 
		long start=System.currentTimeMillis();
		try {
			RequestUtils.showParams(request);
			String jsonStr = RequestUtils.getParams(request);
			com.alibaba.fastjson.JSONObject param = JSON.parseObject(jsonStr);
			logger.info(param.toJSONString());
			String siteId =param.getString("siteId");
			String beginTime =  param.getString("beginTime");
			String endTime =  param.getString("endTime");
			String liveId = param.getString("liveId");
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
		long end=System.currentTimeMillis();
		logger.info("time:"+(end-start)+">>>>调用getBetInfoByDate接口result:"+result.toString());
		return result.toString();
	
	}
	@RequestMapping(value="/getBetInfoByLiveId",method=RequestMethod.POST)
	@ResponseBody
	public Object getBetInfoByLiveId(HttpServletRequest request){
		long start=System.currentTimeMillis();
		RequestUtils.showParams(request);
		String jsonStr = RequestUtils.getParams(request);
		com.alibaba.fastjson.JSONObject param = JSON.parseObject(jsonStr);
		logger.info(param.toJSONString());
		String siteId = param.getString("siteId");
		String liveId = param.getString("liveId");
//		String gameKind = obj.getString("gameKind");//游戏类型
		String betTimeBegin = param.getString("betTimeBegin");//格式 yyyy-MM-dd HH:mm:ss
		String betTimeEnd = param.getString("betTimeEnd");//格式 yyyy-MM-dd HH:mm:ss
		com.alibaba.fastjson.JSONObject result = new com.alibaba.fastjson.JSONObject(); 
		com.alibaba.fastjson.JSONObject obj = new com.alibaba.fastjson.JSONObject();
		try {
			if(StringUtils.isBlank(siteId)){
				result.put("message", "siteId param  cant not null");
				result.put("code", 110009);
				return result.toString();
			}
			obj.put("siteId", siteId);
			if(StringUtils.isBlank(liveId)){
				result.put("message", "liveId param  cant not null");
				result.put("code", 110009);
				return result.toString();
			}
			obj.put("liveId", liveId);
			if(StringUtils.isBlank(betTimeBegin)){
				result.put("message", "betTimeBegin param  cant not null");
				result.put("code", 110009);
				return result.toString();
			}
			obj.put("betTimeBegin", betTimeBegin);
			if(StringUtils.isBlank(betTimeEnd)){
				result.put("message", "betTimeEnd param  cant not null");
				result.put("code", 110009);
				return result.toString();
			}
			obj.put("betTimeEnd", betTimeEnd);
			dsReportService.getBetInfoByLiveId(result,obj);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			result.put("returnCode", 900001);
			result.put("returnMsg", "System error");
		}
		long end=System.currentTimeMillis();
		logger.info("time:"+(end-start)+">>>>调用getBetInfoByLiveId接口=====>>>>>>>>>result:"+result);
		return JSON.toJSONString(result, SerializerFeature.BrowserCompatible);
	
	}
	@RequestMapping(value="/getMemberBetInfo",method=RequestMethod.POST)
	@ResponseBody
	public Object getMemberBetInfo(HttpServletRequest request){
		com.alibaba.fastjson.JSONObject result = new com.alibaba.fastjson.JSONObject(); 
		com.alibaba.fastjson.JSONObject data = new com.alibaba.fastjson.JSONObject(); 
		long start=System.currentTimeMillis();
		try {
			RequestUtils.showParams(request);
			String jsonStr = RequestUtils.getParams(request);
			com.alibaba.fastjson.JSONObject param = JSON.parseObject(jsonStr);
			logger.info(param.toJSONString());
			String siteId = param.getString("siteId");
			String username = param.getString("username");
			String beginTime =  param.getString("beginTime");
			String endTime = param.getString("endTime");
			String liveId = param.getString("liveId");
			String page = param.getString("page");
			String pageSize = param.getString("pageSize");
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
		long end=System.currentTimeMillis();
		logger.info("time:"+(end-start)+">>>>调用getMemberBetInfo接口result:"+result.toString());
		return result.toString();
	
	}
	@RequestMapping(value="/getMemberNameList",method=RequestMethod.POST)
	@ResponseBody
	public Object getMemberNameList(HttpServletRequest request){
		com.alibaba.fastjson.JSONObject result = new com.alibaba.fastjson.JSONObject();
		long start=System.currentTimeMillis();
		try{
			com.alibaba.fastjson.JSONObject obj = new com.alibaba.fastjson.JSONObject();
			RequestUtils.showParams(request);
			String jsonStr = RequestUtils.getParams(request);
			com.alibaba.fastjson.JSONObject param = JSON.parseObject(jsonStr);
			logger.info(param.toJSONString());
			String siteId = param.getString("siteId");
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
		long end=System.currentTimeMillis();
		logger.info("time:"+(end-start)+">>>>调用getMemberNameList接口result:"+result.toString());
		return result.toString();
	
	}
	@RequestMapping(value="/getValidateMemberByDate",method=RequestMethod.POST)
	@ResponseBody
	public Object getValidateMemberByDate(HttpServletRequest request){
		com.alibaba.fastjson.JSONObject result = new com.alibaba.fastjson.JSONObject();
		long start=System.currentTimeMillis();
		try{
			RequestUtils.showParams(request);
			String jsonStr = RequestUtils.getParams(request);
			com.alibaba.fastjson.JSONObject param = JSON.parseObject(jsonStr);
			String siteId = param.getString("siteId");
			String beginTime =  param.getString("beginTime");
			String endTime =  param.getString("endTime");
			String liveId = param.getString("liveId");
			String agentLevel = param.getString("agentLevel");
			String agentName = param.getString("agentName");
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
		long end=System.currentTimeMillis();
		logger.info("time:"+(end-start)+">>>>调用getValidateMemberByDate接口result:"+result.toString());
		return result.toString();
	
	}
	@RequestMapping(value="/waterReportNew",method=RequestMethod.POST)
	@ResponseBody
	public Object waterReportNew(HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>(); 
		try{
			RequestUtils.showParams(request);
			String jsonStr = RequestUtils.getParams(request);
			com.alibaba.fastjson.JSONObject param = JSON.parseObject(jsonStr);
			logger.info(param.toJSONString());
			
			String siteId = param.getString("siteId");
			String agentLevel = param.getString("agentLevel");
			String username = param.getString("username");
			String betTimeBegin = param.getString("betTimeBegin");
			String betTimeEnd = param.getString("betTimeEnd");
			String key = param.getString("key");
			String waterType = param.getString("waterType");
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
			JSONObject returnOrder = JSONObject.fromObject(param.getString("return_order"));//{"3d":7,"ball":4,"bb_sport":5,"game":6,"hongkong":2,"live":1,"live_order":{"bb":2,"ds":1,"other":3},"lotto":3}
			JSONArray returnPercent = JSONArray.fromObject(param.getString("return_percent"));//[{"max_return":"999","percent_detail":{"3d":1.3,"ball":1,"bb_sport":0.8,"game":1.3,"hongkong":0.8,"live":{"bb":0.12,"ds":0.12,"other":0.12},"lotto":0.8},"vgold":"1"},
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
					JSONObject liveOrder=JSONObject.fromObject(getJsonParm(returnOrder,"live_order"));
					for (@SuppressWarnings("rawtypes")Iterator iterOrder = liveOrder.keys(); iterOrder.hasNext();){
						String orderName = (String)iterOrder.next();
						sbOrder.append("live_").append(orderName).append("|").append(getJsonParm(liveOrder,orderName)).append(";");
						orderLiveMap.put(getJsonParm(liveOrder,orderName), "live_"+orderName);
					}
						
				}else if(iterName.equals("hongkong_order")){//香港彩
					JSONObject hongkongOrder=JSONObject.fromObject(getJsonParm(returnOrder,"hongkong_order"));
					for (@SuppressWarnings("rawtypes")Iterator iterOrder = hongkongOrder.keys(); iterOrder.hasNext();){
						String orderName = (String)iterOrder.next();
						sbOrder.append("hongkong_").append(orderName).append("|").append(getJsonParm(hongkongOrder,orderName)).append(";");
						orderHongkongMap.put(getJsonParm(hongkongOrder,orderName), "hongkong_"+orderName);
					}
				}else if(iterName.equals("lotto_order")){//lotto
					JSONObject lottoOrder=JSONObject.fromObject(getJsonParm(returnOrder,"lotto_order"));
					for (@SuppressWarnings("rawtypes")Iterator iterOrder = lottoOrder.keys(); iterOrder.hasNext();){
						String orderName = (String)iterOrder.next();
						sbOrder.append("lotto_").append(orderName).append("|").append(getJsonParm(lottoOrder,orderName)).append(";");
						orderLottoMap.put(getJsonParm(lottoOrder,orderName), "lotto_"+orderName);
					}
				}
				else if(iterName.equals("sport_order")){//体育
					JSONObject sportOrder=JSONObject.fromObject(getJsonParm(returnOrder,"sport_order"));
					for (@SuppressWarnings("rawtypes")Iterator iterOrder = sportOrder.keys(); iterOrder.hasNext();){
						String orderName = (String)iterOrder.next();
						sbOrder.append("sport_").append(orderName).append("|").append(getJsonParm(sportOrder,orderName)).append(";");
						orderSportMap.put(getJsonParm(sportOrder,orderName), "sport_"+orderName);
					}
				}
				else if(iterName.equals("game_order")){//电子游戏
					JSONObject gameOrder=JSONObject.fromObject(getJsonParm(returnOrder,"game_order"));
					for (@SuppressWarnings("rawtypes")Iterator iterOrder = gameOrder.keys(); iterOrder.hasNext();){
						String orderName = (String)iterOrder.next();
						sbOrder.append("game_").append(orderName).append("|").append(getJsonParm(gameOrder,orderName)).append(";");
						orderGameMap.put(getJsonParm(gameOrder,orderName), "game_"+orderName);
					}
				}else{//取出各个网站顺序
					sbOrder.append(iterName).append("|").append(getJsonParm(returnOrder,iterName)).append(";");
					orderMap.put(getJsonParm(returnOrder,iterName), iterName);
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
			        	JSONObject jsonPercentDetail = JSONObject.fromObject(getJsonParm(jsonPercent,iterName));//percent_detail
			        	for (@SuppressWarnings("rawtypes")Iterator iterPencent = jsonPercentDetail.keys(); iterPencent.hasNext();){
			        		String iterPencentName = (String)iterPencent.next();
			        		if(iterPencentName.equals("live")){//视讯
			        			JSONObject jsonLive = JSONObject.fromObject(getJsonParm(jsonPercentDetail,iterPencentName));
			        			for (@SuppressWarnings("rawtypes")Iterator iterLive = jsonLive.keys(); iterLive.hasNext();){
			        				String liveName = (String)iterLive.next();
			        				sbPercent.append("live_").append(liveName).append("|").append(getJsonParm(jsonLive,liveName)).append(";");
			        				percentDetailMap.put("live_"+liveName, getJsonParm(jsonLive,liveName));
			        			}
			        		}else if(iterPencentName.equals("hongkong")){//香港彩
			        			JSONObject jsonHongkong = JSONObject.fromObject(getJsonParm(jsonPercentDetail,iterPencentName));
			        			for (@SuppressWarnings("rawtypes")Iterator iterLive = jsonHongkong.keys(); iterLive.hasNext();){
			        				String hongkongName = (String)iterLive.next();
			        				sbPercent.append("hongkong_").append(hongkongName).append("|").append(getJsonParm(jsonHongkong,hongkongName)).append(";");
			        				percentDetailMap.put("hongkong_"+hongkongName, getJsonParm(jsonHongkong,hongkongName));
			        			}
			        		}else if(iterPencentName.equals("lotto")){//彩票
			        			JSONObject jsonLotto = JSONObject.fromObject(getJsonParm(jsonPercentDetail,iterPencentName));
			        			for (@SuppressWarnings("rawtypes")Iterator iterLive = jsonLotto.keys(); iterLive.hasNext();){
			        				String lottoName = (String)iterLive.next();
			        				sbPercent.append("lotto_").append(lottoName).append("|").append(getJsonParm(jsonLotto,lottoName)).append(";");
			        				percentDetailMap.put("lotto_"+lottoName, getJsonParm(jsonLotto,lottoName));
			        			}
			        		}else if(iterPencentName.equals("sport")){//体育
			        			JSONObject jsonSport = JSONObject.fromObject(getJsonParm(jsonPercentDetail,iterPencentName));
			        			for (@SuppressWarnings("rawtypes")Iterator iterLive = jsonSport.keys(); iterLive.hasNext();){
			        				String sportName = (String)iterLive.next();
			        				sbPercent.append("sport_").append(sportName).append("|").append(getJsonParm(jsonSport,sportName)).append(";");
			        				percentDetailMap.put("sport_"+sportName, getJsonParm(jsonSport,sportName));
			        			}
			        		}else if(iterPencentName.equals("game")){//电子游戏
			        			JSONObject jsonGame = JSONObject.fromObject(getJsonParm(jsonPercentDetail,iterPencentName));
			        			for (@SuppressWarnings("rawtypes")Iterator iterLive = jsonGame.keys(); iterLive.hasNext();){
			        				String gameName = (String)iterLive.next();
			        				sbPercent.append("game_").append(gameName).append("|").append(getJsonParm(jsonGame,gameName)).append(";");
			        				percentDetailMap.put("game_"+gameName, getJsonParm(jsonGame,gameName));
			        			}
			        		}
			        		
			        	}//percent for end
			        		
			        }else if(iterName.equals("vgold")){//vgold
						vGold = getJsonParm(jsonPercent,iterName);
						sbPercent.append(iterName).append("|").append(getJsonParm(jsonPercent,iterName)).append(";");
						percentDetailMap.put(iterName, getJsonParm(jsonPercent,iterName));
					}else{//max_return
			        	sbPercent.append(iterName).append("|").append(getJsonParm(jsonPercent,iterName)).append(";");
			        	percentDetailMap.put(iterName, getJsonParm(jsonPercent,iterName));
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/waterReportNewByPage",method=RequestMethod.POST)
	@ResponseBody
	public Object waterReportNewByPage(HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>(); 
		try{
			//logger.info("返水报表waterReportNew tcp start:"+strJson+";return_order:"+strOrder+";return_percent:"+strPercent);
			
			RequestUtils.showParams(request);
			String jsonStr = RequestUtils.getParams(request);
			com.alibaba.fastjson.JSONObject param = JSON.parseObject(jsonStr);
			logger.info(param.toJSONString());
			
			JSONObject param1 = JSONObject.fromObject(param.getString("param1"));
			String siteId = param1.getString("siteId");
			String agentLevel = param1.getString("agentLevel");
			String username = param1.getString("username");
			String betTimeBegin = param1.getString("betTimeBegin");
			String betTimeEnd = param1.getString("betTimeEnd");
			String key = param1.getString("key");
			String waterType = param1.getString("waterType");
			String page = param1.getString("page");
			String pageLimit = param1.getString("pageLimit");
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
			JSONObject returnOrder = JSONObject.fromObject(param.getString("return_order"));//{"3d":7,"ball":4,"bb_sport":5,"game":6,"hongkong":2,"live":1,"live_order":{"bb":2,"ds":1,"other":3},"lotto":3}
			JSONArray returnPercent = JSONArray.fromObject(param.getString("return_percent"));//[{"max_return":"999","percent_detail":{"3d":1.3,"ball":1,"bb_sport":0.8,"game":1.3,"hongkong":0.8,"live":{"bb":0.12,"ds":0.12,"other":0.12},"lotto":0.8},"vgold":"1"},
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
					JSONObject liveOrder=JSONObject.fromObject(getJsonParm(returnOrder,"live_order"));
					for (@SuppressWarnings("rawtypes")Iterator iterOrder = liveOrder.keys(); iterOrder.hasNext();){
						String orderName = (String)iterOrder.next();
						sbOrder.append("live_").append(orderName).append("|").append(getJsonParm(liveOrder,orderName)).append(";");
						orderLiveMap.put(getJsonParm(liveOrder,orderName), "live_"+orderName);
					}
						
				}else if(iterName.equals("hongkong_order")){//香港彩
					JSONObject hongkongOrder=JSONObject.fromObject(getJsonParm(returnOrder,"hongkong_order"));
					for (@SuppressWarnings("rawtypes")Iterator iterOrder = hongkongOrder.keys(); iterOrder.hasNext();){
						String orderName = (String)iterOrder.next();
						sbOrder.append("hongkong_").append(orderName).append("|").append(getJsonParm(hongkongOrder,orderName)).append(";");
						orderHongkongMap.put(getJsonParm(hongkongOrder,orderName), "hongkong_"+orderName);
					}
				}else if(iterName.equals("lotto_order")){//lotto
					JSONObject lottoOrder=JSONObject.fromObject(getJsonParm(returnOrder,"lotto_order"));
					for (@SuppressWarnings("rawtypes")Iterator iterOrder = lottoOrder.keys(); iterOrder.hasNext();){
						String orderName = (String)iterOrder.next();
						sbOrder.append("lotto_").append(orderName).append("|").append(getJsonParm(lottoOrder,orderName)).append(";");
						orderLottoMap.put(getJsonParm(lottoOrder,orderName), "lotto_"+orderName);
					}
				}
				else if(iterName.equals("sport_order")){//体育
					JSONObject sportOrder=JSONObject.fromObject(getJsonParm(returnOrder,"sport_order"));
					for (@SuppressWarnings("rawtypes")Iterator iterOrder = sportOrder.keys(); iterOrder.hasNext();){
						String orderName = (String)iterOrder.next();
						sbOrder.append("sport_").append(orderName).append("|").append(getJsonParm(sportOrder,orderName)).append(";");
						orderSportMap.put(getJsonParm(sportOrder,orderName), "sport_"+orderName);
					}
				}
				else if(iterName.equals("game_order")){//电子游戏
					JSONObject gameOrder=JSONObject.fromObject(getJsonParm(returnOrder,"game_order"));
					for (@SuppressWarnings("rawtypes")Iterator iterOrder = gameOrder.keys(); iterOrder.hasNext();){
						String orderName = (String)iterOrder.next();
						sbOrder.append("game_").append(orderName).append("|").append(getJsonParm(gameOrder,orderName)).append(";");
						orderGameMap.put(getJsonParm(gameOrder,orderName), "game_"+orderName);
					}
				}else{//取出各个网站顺序
					sbOrder.append(iterName).append("|").append(getJsonParm(returnOrder,iterName)).append(";");
					orderMap.put(getJsonParm(returnOrder,iterName), iterName);
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
			        	JSONObject jsonPercentDetail = JSONObject.fromObject(getJsonParm(jsonPercent,iterName));//percent_detail
			        	for (@SuppressWarnings("rawtypes")Iterator iterPencent = jsonPercentDetail.keys(); iterPencent.hasNext();){
			        		String iterPencentName = (String)iterPencent.next();
			        		if(iterPencentName.equals("live")){//视讯
			        			JSONObject jsonLive = JSONObject.fromObject(getJsonParm(jsonPercentDetail,iterPencentName));
			        			for (@SuppressWarnings("rawtypes")Iterator iterLive = jsonLive.keys(); iterLive.hasNext();){
			        				String liveName = (String)iterLive.next();
			        				sbPercent.append("live_").append(liveName).append("|").append(getJsonParm(jsonLive,liveName)).append(";");
			        				percentDetailMap.put("live_"+liveName, getJsonParm(jsonLive,liveName));
			        			}
			        		}else if(iterPencentName.equals("hongkong")){//香港彩
			        			JSONObject jsonHongkong = JSONObject.fromObject(getJsonParm(jsonPercentDetail,iterPencentName));
			        			for (@SuppressWarnings("rawtypes")Iterator iterLive = jsonHongkong.keys(); iterLive.hasNext();){
			        				String hongkongName = (String)iterLive.next();
			        				sbPercent.append("hongkong_").append(hongkongName).append("|").append(getJsonParm(jsonHongkong,hongkongName)).append(";");
			        				percentDetailMap.put("hongkong_"+hongkongName, getJsonParm(jsonHongkong,hongkongName));
			        			}
			        		}else if(iterPencentName.equals("lotto")){//彩票
			        			JSONObject jsonLotto = JSONObject.fromObject(getJsonParm(jsonPercentDetail,iterPencentName));
			        			for (@SuppressWarnings("rawtypes")Iterator iterLive = jsonLotto.keys(); iterLive.hasNext();){
			        				String lottoName = (String)iterLive.next();
			        				sbPercent.append("lotto_").append(lottoName).append("|").append(getJsonParm(jsonLotto,lottoName)).append(";");
			        				percentDetailMap.put("lotto_"+lottoName, getJsonParm(jsonLotto,lottoName));
			        			}
			        		}else if(iterPencentName.equals("sport")){//体育
			        			JSONObject jsonSport = JSONObject.fromObject(getJsonParm(jsonPercentDetail,iterPencentName));
			        			for (@SuppressWarnings("rawtypes")Iterator iterLive = jsonSport.keys(); iterLive.hasNext();){
			        				String sportName = (String)iterLive.next();
			        				sbPercent.append("sport_").append(sportName).append("|").append(getJsonParm(jsonSport,sportName)).append(";");
			        				percentDetailMap.put("sport_"+sportName, getJsonParm(jsonSport,sportName));
			        			}
			        		}else if(iterPencentName.equals("game")){//电子游戏
			        			JSONObject jsonGame = JSONObject.fromObject(getJsonParm(jsonPercentDetail,iterPencentName));
			        			for (@SuppressWarnings("rawtypes")Iterator iterLive = jsonGame.keys(); iterLive.hasNext();){
			        				String gameName = (String)iterLive.next();
			        				sbPercent.append("game_").append(gameName).append("|").append(getJsonParm(jsonGame,gameName)).append(";");
			        				percentDetailMap.put("game_"+gameName, getJsonParm(jsonGame,gameName));
			        			}
			        		}
			        		
			        	}//percent for end
			        		
			        }else if(iterName.equals("vgold")){//vgold
						vGold = getJsonParm(jsonPercent,iterName);
						sbPercent.append(iterName).append("|").append(getJsonParm(jsonPercent,iterName)).append(";");
						percentDetailMap.put(iterName, getJsonParm(jsonPercent,iterName));
					}else{//max_return
			        	sbPercent.append(iterName).append("|").append(getJsonParm(jsonPercent,iterName)).append(";");
			        	percentDetailMap.put(iterName, getJsonParm(jsonPercent,iterName));
			        }
			        	
				}
			    percentMap.put(vGold, percentDetailMap);
			}//end for vgold size

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
	
	/**
	 * @author Arron
	 * @param 接收一个json格式的id--post方法
	 * @return 返回大于此id的ds_member_log表中的所有信息
	 */
	@RequestMapping(value="/getMemberLogById",method=RequestMethod.POST)
	@ResponseBody
	public Object getMemberLogById(HttpServletRequest request){
		RequestUtils.showParams(request);
		String jsonStr = RequestUtils.getParams(request);
		com.alibaba.fastjson.JSONObject param = JSON.parseObject(jsonStr);
		logger.info("调用getMemberLogById-----"+param.toJSONString());
		String id = param.getString("id");
		Map<String,Object> result = new HashMap<String,Object>(); 
		if(StringUtils.isBlank(id)){
			result.put("returnMsg", "id is wrong");
			result.put("returnCode", 110009);
			return result;
		}
		if(!StringUtils.isNumeric(id)){
			result.put("returnMsg", "id format wrong");
			result.put("returnCode", 110009);
			return result;
		}
		Long queryId=Long.valueOf(id);
		dsReportService.queryMemberLogById(queryId, result);
		logger.info("getMemberLogById----result"+result);
		return result;
	}
	
	@RequestMapping(value="/getTotalBySite",method=RequestMethod.POST)
	@ResponseBody
	public String getTotalBySite(String siteId,String beginTime,String endTime,int page,int pageLimit){
		com.alibaba.fastjson.JSONObject result =new com.alibaba.fastjson.JSONObject();
		try {
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
		
		return result.toString();
	}
}
