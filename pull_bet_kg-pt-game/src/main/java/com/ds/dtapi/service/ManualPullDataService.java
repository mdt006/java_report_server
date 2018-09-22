package com.ds.dtapi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ds.dtapi.common.BaseCommon;
import com.ds.dtapi.entity.PTPagination;
import com.ds.dtapi.util.PTReqUtill;
import com.ds.dtapi.util.ThreadUtil;
import com.kg.live.entity.ApiInfoEntity;
import com.kg.live.entity.DtPtGame;


@Service
public class ManualPullDataService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private PTService ptService;
	
	public void pullData(ApiInfoEntity apiInfo,String rounddate,String start_time,String end_time,boolean isUpdate){
		
		try {
			if(StringUtils.isBlank(start_time) || StringUtils.isBlank(end_time)){
				for(int i=0;i<BaseCommon.TIME_LIST.size();i++){
					String s=BaseCommon.TIME_LIST.get(i);
					int now_page=1;
					String[] times=s.split("_");
					String pt_start_time=BaseCommon.addDateByHours(rounddate+" "+times[0], 12);//转换成美东时间(对应数据库)
					String pt_end_time=BaseCommon.addDateByHours(rounddate+" "+times[1], 12);
					List<DtPtGame> pt_list=ptService.getListBySiteAndTime(apiInfo.getSiteId(),rounddate+" "+times[0], rounddate+" "+times[1]);
					Map<String,String> cache_map=this.getMapByList(pt_list);
					while(true){
						ThreadUtil.sleep(BaseCommon.M_WAIT_TIME);
						logger.info("拉取参数：rounddate="+rounddate+",times="+s+",当前页："+now_page);
						String respStr="";
						if(i==0){
							String t=BaseCommon.addDateByDay(rounddate, 1);//+1天
							respStr=this.getResponseDataByLastTime(apiInfo.getKeyb(),rounddate+"%20"+times[0],t+"%20"+times[1],now_page);
						}else{
							respStr=this.getResponseData(apiInfo.getKeyb(), pt_start_time,pt_end_time,now_page);
						}
						if(StringUtils.isNoneBlank(respStr)){
							List<DtPtGame> list=new ArrayList<DtPtGame>();
							JSONObject jsonResult=JSONObject.parseObject(respStr);
							if(null==jsonResult.get("errorcode")){
								PTPagination pageInfo=jsonResult.getObject("pagination", PTPagination.class);
								list=JSONArray.parseArray(jsonResult.getString("result"), DtPtGame.class);
								if(list.size()>0){
									ptService.manualSaveData(cache_map, list, apiInfo, isUpdate);
								}
								if(pageInfo.getCurrentPage()>=pageInfo.getTotalPages()){//已拉取最后一页
									break;
								}else{
									now_page++;
								}
							}else{
								logger.info("返回信息："+respStr);
							}
						}
					}
					
				}
			}else{
				int now_page=1;
				String pt_start_time=BaseCommon.addDateByHours(rounddate+" "+start_time, 12);//转换成美东时间(对应数据库)
				String pt_end_time=BaseCommon.addDateByHours(rounddate+" "+end_time, 12);
				List<DtPtGame> pt_list=ptService.getListBySiteAndTime(apiInfo.getSiteId(),rounddate+" "+start_time, rounddate+" "+end_time);
				Map<String,String> cache_map=this.getMapByList(pt_list);
				while(true){
					ThreadUtil.sleep(BaseCommon.M_WAIT_TIME);
					String respStr=this.getResponseData(apiInfo.getKeyb(),pt_start_time,pt_end_time,now_page);
					if(StringUtils.isNoneBlank(respStr)){
						List<DtPtGame> list=new ArrayList<DtPtGame>();
						JSONObject jsonResult=JSONObject.parseObject(respStr);
						if(null==jsonResult.get("errorcode")){
							PTPagination pageInfo=jsonResult.getObject("pagination", PTPagination.class);
							list=JSONArray.parseArray(jsonResult.getString("result"), DtPtGame.class);
							if(list.size()>0){
								ptService.manualSaveData(cache_map, list, apiInfo, isUpdate);
							}
							if(pageInfo.getCurrentPage()>=pageInfo.getTotalPages()){//已拉取最后一页
								break;
							}else{
								now_page++;
							}
						}else{
							logger.info("返回信息："+respStr);
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	public String getResponseData(String entityKey,String start_time,String end_time,int now_page) throws Exception {
		
		String url=PTReqUtill.getUrlParam(start_time, end_time, now_page, BaseCommon.M_PAGE_SIZE);
		logger.info("url:"+url);
		String resStr=PTReqUtill.CallAPI(BaseCommon.PT_PASSWORD, entityKey, BaseCommon.PT_BASEURI+url);
		return resStr;
		
	}
	//昨天最后一秒 23:59:59
	public String getResponseDataByLastTime(String entityKey,String start_time,String end_time,int now_page) throws Exception {
		String url=PTReqUtill.getUrlParam(start_time, end_time, now_page, BaseCommon.M_PAGE_SIZE);
		logger.info("url:"+url);
		String resStr=PTReqUtill.CallAPI(BaseCommon.PT_PASSWORD, entityKey, BaseCommon.PT_BASEURI+url);
		return resStr;
		
	}
	
	public Map<String,String> getMapByList(List<DtPtGame> list){
		Map<String,String> map=new HashMap<String,String>();
		logger.info("查询条数：{}",list.size());
		for(DtPtGame o : list){
			map.put(o.getGamecode(), o.getGamecode());
		}
		return map;
	}
	
}
