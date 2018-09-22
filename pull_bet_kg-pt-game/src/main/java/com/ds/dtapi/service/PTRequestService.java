package com.ds.dtapi.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ds.dtapi.common.BaseCommon;
import com.ds.dtapi.entity.PTPagination;
import com.ds.dtapi.util.PTReqUtill;
import com.ds.dtapi.util.ThreadUtil;
import com.kg.live.entity.ApiInfoEntity;
import com.kg.live.entity.DtPtGame;
import com.kg.live.entity.DtPtPageRecord;
import com.kg.live.mapper.DtPtPageRecordMapper;

public class PTRequestService implements Runnable{
	private Logger logger = LoggerFactory.getLogger(getClass());
	private PTService ptService;
	private DtPtPageRecordMapper pageRecordMapper;
	private ApiInfoEntity apiInfo;

	public PTRequestService(ApiInfoEntity apiInfo,PTService ptService,DtPtPageRecordMapper pageRecordMapper){
		this.apiInfo=apiInfo;
		this.ptService=ptService;
		this.pageRecordMapper=pageRecordMapper;
	}
	
	@Override
	public void run() {
		startPullData();
	}

	public void startPullData(){
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
		int time_index=0;
		int now_page=1;
		String rounddate = LocalDate.now(ZoneId.of("GMT+8")).toString();
		String[] times = null;
		boolean none_history_data=false;
		logger.info(apiInfo.getSiteId()+"开始拉取.......");
		while(true){
			if(PTTask.validNewApiInfo(apiInfo)){//配置被修改
				logger.info("当前配置已不存在，停止拉取:agent={},siteId={}",apiInfo.getAgent(),apiInfo.getSiteId());
				break;
			}
			logger.info(apiInfo.getSiteId()+"休息一会,当前页:"+now_page+",timeIndex:"+time_index);
			times=BaseCommon.TIME_LIST.get(time_index).split("_");
			try {
				if(time_index==0){//服务器初始化或者第二天开始
					DtPtPageRecord pageRecord = ptService.getPageRecord(apiInfo.getAgent(),rounddate);
					if(pageRecord == null){
						//添加pageRecord
						pageRecord = new DtPtPageRecord();
						pageRecord.setSiteId(apiInfo.getSiteId());
						pageRecord.setCreateTime(new Date());
						pageRecord.setPage(1);
						pageRecord.setLastPageCheckTimes(0);//上一页校验次数
						pageRecord.setPageSize(0);
						pageRecord.setTimeIndex(0);
						pageRecord.setRounddate(rounddate);
						pageRecord.setAgent(apiInfo.getAgent());
						pageRecord.setYesterdayCheckStatus(0);//昨天数据未校验
						pageRecordMapper.insert(pageRecord);
					}else{
						time_index=pageRecord.getTimeIndex();
						now_page=pageRecord.getPage();
					}
				}
				if(!rounddate.equals(LocalDate.now(ZoneId.of("GMT+8")).toString())){//换天,验证一次上一页
					validHistoyDataToPage(apiInfo, time_index, now_page, rounddate);
					rounddate = LocalDate.now(ZoneId.of("GMT+8")).toString();//当前日期
					time_index=0;
					now_page=1;
				}else if(none_history_data){//当前时间段数据已拉取完，并且当前半小时已过，定位下一时间段,验证上一页
					Date d1 = sdf.parse(times[1]);
					Date d2 = sdf.parse(LocalTime.now(ZoneId.of("GMT+8")).toString());
					if(d2.getTime() - d1.getTime()>0){
						validHistoyDataToPage(apiInfo, time_index, now_page, rounddate);//验证上一页
						time_index++;
						now_page=1;
						times=BaseCommon.TIME_LIST.get(time_index).split("_");
						none_history_data=false;
					}
					//缓存打印
					Long cache_gc_count=BaseCommon.record_map.stats().evictionCount();
					logger.info("cache gc total:"+cache_gc_count+",cache data count:"+BaseCommon.record_map.size());
				}
				logger.info("请求参数：{},{},{},{},{}",apiInfo.getSiteId(),rounddate,times[0],times[1],now_page);
				ThreadUtil.sleep(BaseCommon.ONCE_TIME_THREAD_SLEEP);
				String respStr="";
				if(time_index==0){
					String t=BaseCommon.addDateByDay(rounddate, -1);//-1天 昨天到今天
					respStr=this.getResponseDataByLastTime(apiInfo.getKeyb(),t+"%20"+times[0],rounddate+"%20"+times[1],now_page);
				}else{
					respStr=this.getResponseData(rounddate, times[0],times[1],now_page);
				}
				if(StringUtils.isNoneBlank(respStr)){
					List<DtPtGame> list=new ArrayList<DtPtGame>();
					JSONObject jsonResult=JSONObject.parseObject(respStr);
					if(null==jsonResult.get("errorcode")){
						PTPagination pageInfo=jsonResult.getObject("pagination", PTPagination.class);
						list=JSONArray.parseArray(jsonResult.getString("result"), DtPtGame.class);
						if(list.size()>0){
							ptService.insertOrUpdate(list, apiInfo,false);
							
							
							DtPtPageRecord pageRecord =new DtPtPageRecord();
							pageRecord.setAgent(apiInfo.getAgent());
							pageRecord.setRounddate(rounddate);
							pageRecord.setPage(now_page);
							pageRecord.setTimeIndex(time_index);
							pageRecord.setBeginTime(times[0]);
							pageRecord.setEndTime(times[1]);
							pageRecord.setPageSize(list.size());
							pageRecord.setUpdateTime(new Date());
							pageRecordMapper.updateByAgentAndDate(pageRecord);
						}
						if(list.size()>=pageInfo.getItemsPerPage()){
							now_page++;
							none_history_data=false;
						}else if(now_page>=pageInfo.getTotalPages()){
							none_history_data=true;
						}
					}else{
						logger.info("返回信息："+respStr);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(apiInfo.getSiteId()+"拉取异常,参数:"+rounddate+times[0]+"_"+times[1]+"page="+now_page);
				ThreadUtil.sleep(5000L);
				logger.error("程序异常。休息25秒后继续执行");
			}
			
		}
		
	}
	public String getResponseData(String rounddate,String start_time,String end_time,int now_page) throws Exception {
		
		String url=PTReqUtill.getUrlParam(rounddate+"%20"+start_time, rounddate+"%20"+end_time, now_page, BaseCommon.PAGE_SIZE);
		logger.info("getResponseData url:"+BaseCommon.PT_BASEURI+url);
		String resStr=PTReqUtill.CallAPI(BaseCommon.PT_PASSWORD, apiInfo.getKeyb(), BaseCommon.PT_BASEURI+url);
		return resStr;
		
	}
	
	
	public void send(String startdate,String enddate,int page,int pageSize)throws Exception{
		List<DtPtGame> list=new ArrayList<DtPtGame>();
		String url=PTReqUtill.getUrlParam(startdate, enddate, page, pageSize);
		logger.info("send url:"+BaseCommon.PT_BASEURI+url);
		String resStr=PTReqUtill.CallAPI(BaseCommon.PT_PASSWORD, apiInfo.getKeyb(), BaseCommon.PT_BASEURI+url);
		if(StringUtils.isNoneBlank(resStr)){
			JSONObject jsonResult=JSONObject.parseObject(resStr);
			
			list=JSONArray.parseArray(jsonResult.getString("result"), DtPtGame.class);
			if(list.size()>0){
				ptService.insertOrUpdate(list, apiInfo,false);
			}
		}
	}
	
	public void validHistoyDataToPage(ApiInfoEntity apiInfo,int time_index,int now_page,String rounddate)throws Exception{//验证某一页数据
		String[] times=BaseCommon.TIME_LIST.get(time_index).split("_");
		if(time_index==0){
			String t=BaseCommon.addDateByDay(rounddate, -1);//-1天 昨天到今天
			this.send( t+"%20"+times[0], rounddate+"%20"+times[1], now_page, BaseCommon.PAGE_SIZE);
		}else{
			this.send( rounddate+"%20"+times[0], rounddate+"%20"+times[1], now_page, BaseCommon.PAGE_SIZE);
		}
	}
	
	//昨天最后一秒 23:59:59
	public String getResponseDataByLastTime(String entityKey,String start_time,String end_time,int now_page) throws Exception {
		String url=PTReqUtill.getUrlParam(start_time, end_time, now_page, BaseCommon.M_PAGE_SIZE);
		logger.info("昨天最后时间段url:"+url);
		String resStr=PTReqUtill.CallAPI(BaseCommon.PT_PASSWORD, entityKey, BaseCommon.PT_BASEURI+url);
		return resStr;
			
	}
	
	
	
}

