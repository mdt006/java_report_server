package com.ds.live.gameservice;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ds.live.common.Platform;
import com.ds.live.until.HttpUtil;
import com.ds.live.until.PlatformUtil;
import com.ds.live.vo.ReturnResult;
import com.kg.live.entity.ApiInfoEntity;

@Service
public class ManualPullGameDataService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private GameDBService bbService;
	
	
	public void getGameRecord(ApiInfoEntity configApiInfo,String date,String start_time,String end_time,
			int page,int pageLimit, String httpAction) {
		String url="http://linkapi.s1116.com/app/WebService/JSON/display.php/"+httpAction;
		while(true){
			String param=getSendParam(configApiInfo, httpAction, date, page,pageLimit);
			ReturnResult result=sendHttp(configApiInfo, url, param, httpAction, 0, 0);
			logger.info("手动拉取到第{}页",page);
			if(result.isResult()){
				if(page>=result.getData().getTotalPage()){
					logger.info("已拉取到最后一页，结束拉取");
					break;
				}
				if(result.getData().getTotalNumber()>=pageLimit){
					page++;
				}
			}
			
		}
	}
	
	
	private ReturnResult sendHttp(ApiInfoEntity configApiInfo, String url, String param, String httpAction, Integer gamekind, Integer subgamekind) {
		JSONObject obj = null;
		try {
			logger.info(configApiInfo.getLiveKey()+"手动拉取请求参数:"+url+"?"+param);
			obj = JSONObject.parseObject(HttpUtil.sendPost1(url, param));
		} catch (Exception e) {
			logger.error("sendHttp error", e);
			return new ReturnResult(false,1,"send api error");
		}
		if(obj == null){
			return new ReturnResult(false,1,"send api error");
		}
		String result = obj.getString("result");
		if(result.equals("false")){
			logger.info("sendHttp param:"+param);
			logger.info("sendHttp result:"+obj.toString());
			Integer code = obj.getJSONObject("data").getInteger("Code");
			//如果code为44444(系统维护)，则直接返回true
			if(code == 44444){
				logger.info("系统维护中.....");
				return new ReturnResult(true,code,"System is in maintenance");
			}
			return new ReturnResult(false,code,"api is busy");//此次请求不成功
		}
		logger.info("拉取:"+configApiInfo.getLiveKey()+" sendHttp:"+result);
		//开启一个线程插入数据库
		Integer totalPage = obj.getJSONObject("pagination").getInteger("TotalPage");
		Integer totalNumber = obj.getJSONArray("data").size();
		if(totalNumber>0){
			String thread_no =configApiInfo.getLiveKey()+"_"+new Date().getTime();
			logger.info(thread_no+"开启线程入库，数量:"+totalNumber);
			new Thread(new GameThreadService(configApiInfo,bbService, obj,httpAction,gamekind,subgamekind,thread_no)).start();
		}
		return new ReturnResult(true,0,"ok",totalPage,totalNumber);
	}

	private String getSendParam(ApiInfoEntity configApiInfo,String action,String date, int page,int pageLimit) {
		String key = getKey(configApiInfo);
		if("WagersRecordBy38".equals(action)||"WagersRecordBy30".equals(action)) {
			return getRecord38And30(configApiInfo,date,page,pageLimit);
		}
		StringBuffer sb = new StringBuffer();
		sb.append("website=").append(Platform.Constans.kkw_WEBSITE);
		sb.append("&uppername=").append(configApiInfo.getLiveKey());
		sb.append("&rounddate=").append(date);
		sb.append("&starttime=00:00:00");
		sb.append("&endtime=23:59:59");
		sb.append("&gamekind="+0);
		sb.append("&subgamekind="+0);
		sb.append("&page=").append(page);
		sb.append("&pagelimit="+pageLimit);
		sb.append("&key=").append(key);
		return sb.toString();
	}
	/**
	 * 获取捕鱼大师捕鱼达人记录
	 * @param configApiInfo
	 * @param pageRecord
	 * @param page
	 * @return
	 */
	private String getRecord38And30(ApiInfoEntity configApiInfo,String date, int page,int pageLimit) {
		String key = getKey(configApiInfo);
		StringBuffer sb = new StringBuffer();
		sb.append("website=").append(Platform.Constans.kkw_WEBSITE);
		sb.append("&uppername=").append(configApiInfo.getLiveKey());
		sb.append("&action=").append("BetTime");
		sb.append("&date=").append(date);
//		sb.append("&end_date=").append(date);
		sb.append("&starttime=00:00:00");
		sb.append("&endtime=23:59:59");
		sb.append("&gamekind="+0);
		sb.append("&subgamekind="+0);
		sb.append("&page=").append(page);
		sb.append("&pagelimit="+pageLimit);
		sb.append("&key=").append(key);
		return sb.toString();
	}

	private String getKey(ApiInfoEntity configApiInfo) {
		String key = PlatformUtil.randomString(7)+
				PlatformUtil.toMD5(Platform.Constans.kkw_WEBSITE+Platform.Constans.kkw_BetRecord_KeyB+PlatformUtil.getTime())+
				PlatformUtil.randomString(2);
		return key;
	}



	

}
