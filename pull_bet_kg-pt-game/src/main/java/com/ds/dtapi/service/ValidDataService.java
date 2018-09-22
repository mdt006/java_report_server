package com.ds.dtapi.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ds.dtapi.common.BaseCommon;
import com.ds.dtapi.entity.PTPagination;
import com.ds.dtapi.util.PTReqUtill;
import com.kg.live.entity.ApiInfoEntity;

@Service
public class ValidDataService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private PTService ptService;
	
	
	public boolean validBySiteAndTime(Integer site_id,String keyb,String date,String starttime,String endtime) {
		long count = 0;
		int pt_count=0;
		try {
			
			count=ptService.getCountBySiteAndTime(site_id, date+" "+starttime, date+" "+endtime);
			//调用pt api
			while(true){
				try {
					String pt_start_time=BaseCommon.addDateByHours(date+" "+starttime, 12);//转换成美东时间(对应数据库)
					String pt_end_time=BaseCommon.addDateByHours(date+" "+endtime, 12);
					String respStr=this.getResponseDataForMat(keyb,pt_start_time,pt_end_time,1);
					if(StringUtils.isNoneBlank(respStr)){
						JSONObject jsonResult=JSONObject.parseObject(respStr);
						if(null==jsonResult.get("errorcode")){
							PTPagination pageInfo=jsonResult.getObject("pagination", PTPagination.class);
							pt_count = pageInfo.getTotalCount();
							break;
						}
					}
				} catch (Exception e) {
					logger.error("调用pt出现异常:",e);
					break;
				}
			}
		} catch (Exception e) {
			logger.error("验证出现异常:",e);
		}
		logger.info("{},{},数量：PT{},{}",starttime,endtime,pt_count,count);
		if(count-pt_count>=0){
			return true;
		}
		return false;
	}
	
	public void startValidBySite(ApiInfoEntity apiInfo,String date) throws Exception{
		for(int i=1;i<BaseCommon.TIME_LIST.size();i++){
			Thread.sleep(5*1000);
			String s=BaseCommon.TIME_LIST.get(i);
			String[] times=s.split("_");
			boolean f=this.validBySiteAndTime(apiInfo.getSiteId(), apiInfo.getKeyb(), date, times[0],times[1]);
			if(!f){
				logger.info("{}此时间段验证不一致：{}",apiInfo.getSiteId(),s);
			}
		}
	} 
	
	public void getCountByTime(ApiInfoEntity apiInfo,String date) throws Exception{
		Map<String,Integer> map=new HashMap<String,Integer>();
		for(int i=1;i<BaseCommon.TIME_LIST.size();i++){
			String s=BaseCommon.TIME_LIST.get(i);
			String[] times=s.split("_");
			String respStr=this.getResponseData(date,apiInfo.getKeyb(),times[0],times[1],1);
			if(StringUtils.isNoneBlank(respStr)){
				JSONObject jsonResult=JSONObject.parseObject(respStr);
				if(null==jsonResult.get("errorcode")){
					PTPagination pageInfo=jsonResult.getObject("pagination", PTPagination.class);
					int pt_count = pageInfo.getTotalCount();
					map.put(s, pt_count);
				}
			}
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			logger.info(entry.getKey()+"=="+entry.getValue());
		}
	} 
	
	
	public String getResponseData(String rounddate,String keyb,String start_time,String end_time,int now_page) throws Exception {
		
		String url=PTReqUtill.getUrlParam(rounddate+"%20"+start_time, rounddate+"%20"+end_time, now_page, 1);
		logger.info("valid getResponseData url:"+BaseCommon.PT_BASEURI+url);
		String resStr=PTReqUtill.CallAPI(BaseCommon.PT_PASSWORD, keyb, BaseCommon.PT_BASEURI+url);
		return resStr;
	}
	//按传入的时间转换成数据库对应的时间
	public String getResponseDataForMat(String keyb,String start_time,String end_time,int now_page) throws Exception {
		String url=PTReqUtill.getUrlParam(start_time, end_time, now_page, 1);
		logger.info("valid getResponseDataForMat url:"+BaseCommon.PT_BASEURI+url);
		String resStr=PTReqUtill.CallAPI(BaseCommon.PT_PASSWORD, keyb, BaseCommon.PT_BASEURI+url);
		return resStr;
	}
}
