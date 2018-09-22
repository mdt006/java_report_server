package com.ds.lmg.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ds.lmg.constant.LMGContants;
import com.ds.lmg.util.ThreadUtil;
import com.kg.live.entity.ApiInfoEntity;
import com.kg.live.entity.LMGLiveEntityWithBLOBs;


public class LMGThreadService  implements Runnable{
	private Logger logger = LoggerFactory.getLogger(getClass());
	private ApiInfoEntity apiInfo;
	private LMGService lmgServ;
	private CountDownLatch cdl;
	private Map<Integer,Long> maxSeqNoMap;
	private Long tempSeqId = 0L;
	public LMGThreadService(ApiInfoEntity apiInfo, LMGService lmgServ, CountDownLatch cdl,
			Map<Integer, Long> maxSeqNoMap) {
		super();
		this.apiInfo = apiInfo;
		this.lmgServ = lmgServ;
		this.cdl = cdl;
		this.maxSeqNoMap = maxSeqNoMap;
	}
	
	
	@Override
	public void run() {
		try {
			getRecord(apiInfo.getSiteId(),apiInfo.getReporturl(), apiInfo.getLiveKey());
		} catch (Exception e) {
			logger.error("run error", e);
		}finally {
			logger.info("{}拉取完成",apiInfo.getSiteId());
			cdl.countDown();
		}
		
	}
	private String sendRequest(int siteId,String lmgurl,String hashcode) {
		Long lastmaxid = maxSeqNoMap.get(siteId);
		String beginid = "";
		if(lastmaxid == null){
			beginid = lmgServ.getMaxSeqNo(apiInfo.getSiteId());
			if(beginid != null && beginid != ""){
				lastmaxid = Long.valueOf(beginid);
				tempSeqId = lastmaxid;
			}
		}else{
			logger.info(siteId+"从缓存获取最大视讯maxSeqNo:"+lastmaxid);
			beginid = lastmaxid.toString();
		}
		logger.info("网站" + siteId + ",max beginid:" + beginid);
		if (null == beginid) {
			beginid = "0";
		}
		JSONObject obj = new JSONObject();
		obj.put("hashCode", hashcode); //hashcode
		obj.put("command", "GET_RECORD_BY_SEQUENCENO");
		JSONObject json = new JSONObject();
		json.put("beginId", beginid);
		json.put("count", "1000");
		obj.put("params", json);
		logger.info("网站" + siteId + "GET_RECORD...obj:" + obj);
		
		RestTemplate restTemplate=new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<String> entity = new HttpEntity<String>(obj.toJSONString(), headers);
		String result = restTemplate.postForObject(lmgurl, entity, String.class);
		return result;
	}
	private void getRecord(int siteId,String lmgurl,String hashcode) {
		String result = null;
		try {
			result = sendRequest(siteId, lmgurl, hashcode);
			JSONObject jsonobj = JSONObject.parseObject(result);
			if (jsonobj.get("errorCode") != null) {
				//请求数据成功
				if ("0".equals(jsonobj.getString("errorCode"))) {
					JSONObject jsonParams = jsonobj.getJSONObject("params");
					JSONArray recArr = jsonParams.getJSONArray("recordList");
					logger.info(siteId + "数据条目数:" + recArr.size());
					//把json直接解析为实体类对象，然后imgServ插入到数据库;
					if(recArr.size()>0){ 
						//jsonParams.put("siteId", siteId);
						List<LMGLiveEntityWithBLOBs> lmglist = JSONArray.parseArray(jsonParams.getString("recordList"), LMGLiveEntityWithBLOBs.class);
						setAttr(lmglist);
						
						lmgServ.insOrUp(lmglist);
						//插入数据成功之后把最大seqid放入map，否则清空map
						maxSeqNoMap.put(siteId, tempSeqId);
						
					}					
				}//end if errorCode 正确
				else {
					logger.info("网站：" + siteId + "拉取数据失败:"+result);
					logger.info("网站：" + siteId + "拉取数据失败,errorCode不为0，请检查配置，线程休眠......");
					ThreadUtil.sleep(LMGContants.ERROR_THREAD_SLEEP);
					return;
				}//end if errorCode z
			}//end if has errorCode
			else {
				logger.info("网站：" + siteId + "拉取数据失败,errorCode为空，线程休眠1分钟......");
				ThreadUtil.sleep(LMGContants.ERROR_THREAD_SLEEP);
				return;
			}
		} catch (Exception e) {
			maxSeqNoMap.remove(siteId);
			logger.error("网站：" + siteId + "拉取数据发生异常，线程降休眠30s，异常信息：", e);
			ThreadUtil.sleep(LMGContants.ERROR_THREAD_SLEEP);
		}
		logger.info("网站：" + siteId + "拉取数据成功.....");
	}
	/**
	 * 设置siteId，输赢标识等
	 * @param lmglist
	 */
	
	
	private void setAttr(List<LMGLiveEntityWithBLOBs> lmglist) {
		
		lmglist.stream().forEach(entity ->{
			entity.setSiteId(apiInfo.getSiteId());
			if(entity.getSequenceNo()>tempSeqId) {
				tempSeqId = entity.getSequenceNo();
			}
			//输赢类型修改
			if("-1".equals(entity.getBankerResult())){
				entity.setWinLossType(LMGContants.LIVE_RESULT_TYPE_CANCEL); //注单取消
			}else{
				int value = entity.getWinLoss().compareTo(BigDecimal.ZERO);
				//-1表示小于，0是等于，1是大于。
				if(value == 1){
					entity.setWinLossType(LMGContants.LIVE_RESULT_TYPE_WIN);//赢
				}else if(value == -1){
					entity.setWinLossType(LMGContants.LIVE_RESULT_TYPE_LOSE); //输
				}else if(value == 0){
					entity.setWinLossType(LMGContants.LIVE_RESULT_TYPE_HE); //和 
					String resultList = entity.getResultList();
					if (null == resultList || "null".equals(resultList) || "".equals(resultList)) {
						entity.setWinLossType(LMGContants.LIVE_RESULT_TYPE_HE);//和 
					} else {
						String[] result = resultList.split(",");
						if (null != result) {
							if ("[3".equals(result[0])) {
								entity.setWinLossType(LMGContants.LIVE_RESULT_TYPE_HE);//和 
							} else {
								entity.setWinLossType(LMGContants.LIVE_RESULT_TYPE_WIN);//赢
							}
						}
					}
				}
			}
		});
	}
	
	

}
