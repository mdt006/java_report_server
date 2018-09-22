package com.ds.live.gameservice;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.ds.live.common.Platform;
import com.ds.live.entity.BBINGameHttpConfig;
import com.ds.live.entity.BBINGamePageRecord;
import com.ds.live.entity.BBINGamePageRecordExample;
import com.ds.live.mapper.BBINGamePageRecordMapper;
import com.ds.live.until.BBINCommon;
import com.ds.live.until.HttpUtil;
import com.ds.live.until.PlatformUtil;
import com.ds.live.until.ThreadUtil;
import com.ds.live.vo.ReturnResult;
import com.kg.live.entity.ApiInfoEntity;
public class GameRequestService implements Runnable{
	private Logger logger = LoggerFactory.getLogger(getClass());
	private BBINGamePageRecordMapper pageRecordMapper;
	private GameDBService bbService;
	private CountDownLatch cdl;
	private ApiInfoEntity configApiInfo;
	private List<BBINGameHttpConfig> gameHttpConfigList;
	
	

	public GameRequestService(BBINGamePageRecordMapper pageRecordMapper, GameDBService bbService, CountDownLatch cdl,
			ApiInfoEntity configApiInfo, List<BBINGameHttpConfig> gameHttpConfigList) {
		super();
		this.pageRecordMapper = pageRecordMapper;
		this.bbService = bbService;
		this.cdl = cdl;
		this.configApiInfo = configApiInfo;
		this.gameHttpConfigList = gameHttpConfigList;
	}

	@Override
	public void run() {
		try {
			getRecord(configApiInfo, gameHttpConfigList);
		} catch (Exception e) {
			logger.error("run error", e);
		}finally {
			logger.info("{}拉取完成",configApiInfo.getSiteId());
			cdl.countDown();
		}
	}
	
	public void getRecord(ApiInfoEntity configApiInfo, List<BBINGameHttpConfig> gameHttpConfig) {
		for (BBINGameHttpConfig bbinGameHttpConfig : gameHttpConfig) {
			try {
				getGameRecord(configApiInfo,bbinGameHttpConfig);
			} catch (Exception e) {
				logger.error("getRecord error", e);
			}
		}
	}

	private void getGameRecord(ApiInfoEntity configApiInfo, BBINGameHttpConfig bbinGameHttpConfig) {
		String rounddate = LocalDate.now().toString();//当前日期
		BBINGamePageRecord pageRecord = getPageRecord(configApiInfo.getLiveKey(),rounddate,bbinGameHttpConfig);
		if(pageRecord == null){
			//添加pageRecord
			pageRecord = new BBINGamePageRecord();
			pageRecord.setCreateTime(new Date());
			pageRecord.setCurPage(1);
			pageRecord.setGameKind(5);
			pageRecord.setLastPage(0);
			pageRecord.setLastPageCheckTimes(0);//上一页校验次数
			pageRecord.setPageSize(0);
			pageRecord.setRounddate(rounddate);
			pageRecord.setUppername(configApiInfo.getLiveKey());
			pageRecord.setYesterdayCheckStatus(0);//未校验
			pageRecord.setGameKind(bbinGameHttpConfig.getGameKind());
			pageRecord.setSubGameKind(bbinGameHttpConfig.getSubGameKind());
			pageRecord.setHttpAction(bbinGameHttpConfig.getHttpAction());
			addPageRecord(pageRecord);
		}
		//开始检查校验昨天数据
		String yesRounddate = LocalDate.now().plusDays(-1).toString();
		BBINGamePageRecord yesPageRecord = getPageRecord(configApiInfo.getLiveKey(),yesRounddate,bbinGameHttpConfig);
		/**
		 * 检查昨天是否有拉取记录
		 * 如果没有，则不用处理
		 * 如果有，则检查上一页的YesterdayCheckStatus的字段，如果有校验则（value=1）不用处理，
		 * 如果没有校验，则需要拉取数据，并将更改YesterdayCheckStatus的状态
		 */
		if(yesPageRecord != null){
			//未校验，则拉取数据
			if(yesPageRecord.getYesterdayCheckStatus() <= 1){
				logger.info("开始核对前一天数据,uppername:{},date:{}",configApiInfo.getLiveKey(),yesRounddate);
				boolean resultOK = sendBBINPost(configApiInfo,yesPageRecord);
				if(resultOK){
					yesPageRecord.setYesterdayCheckStatus(yesPageRecord.getYesterdayCheckStatus()+1);
					pageRecordMapper.updateByPrimaryKeySelective(yesPageRecord);
					logger.info(",uppername:{},date:{} 核对完成(昨天)",configApiInfo.getLiveKey(),yesRounddate);
				}else{
					logger.info(",uppername:{},date:{} 核对出错(昨天)",configApiInfo.getLiveKey(),yesRounddate);
				}
				
			}else{
				logger.info(",uppername:{},date:{} 已经核对过，无需再核对",configApiInfo.getLiveKey(),yesRounddate);
			}
		}
		//开始拉取当天数据
		logger.info("开始拉取当天数据,uppername:{},date:{}",configApiInfo.getLiveKey(),pageRecord.getRounddate());
		sendBBINPost(configApiInfo,pageRecord);
		logger.info("当天数据拉取完成,uppername:{},date:{}",configApiInfo.getLiveKey(),pageRecord.getRounddate());
	}


	private boolean sendBBINPost(ApiInfoEntity configApiInfo, BBINGamePageRecord pageRecord) {
		//判断是否需要读取当前页的上一页数据
				Boolean resultOK = null;
				int curPageSize = pageRecord.getPageSize();//当前页注单size
				int lastPageChecks = pageRecord.getLastPageCheckTimes();//上一页的检查次数
				int lastPage = pageRecord.getLastPage();//上一页
				int page = pageRecord.getCurPage();//当前页
//				String betRecordUrl = configApiInfo.getReporturl()+pageRecord.getHttpAction();
				String betRecordUrl = "http://linkapi.s1116.com/app/WebService/JSON/display.php/"+pageRecord.getHttpAction();

				//不用读取上一页数据
				if(lastPage == 0||lastPageChecks>=BBINCommon.LAST_PAGE_CHECK_TIMES
						||curPageSize>=BBINCommon.CUR_PAGE_CHECK_MAX_PAGE_SIZE){
					for(int i = page;i <= page; i++){
						String param = getSendParam(configApiInfo, pageRecord,i);
						ReturnResult result = sendHttp(configApiInfo,betRecordUrl, param,
								pageRecord.getHttpAction(),pageRecord.getGameKind(),pageRecord.getSubGameKind());
						//如果请求成功
						if(result.isResult()){
							//判断返回的code，如果是系统维护则跳出循环，如果是正常拉取则继续循环
							if(result.getData().getCode() == 44444){
								pageRecord.setCurPage(i);
								pageRecord.setLastPage(i-1);
								resultOK = false;
								break;
							}
							//正常返回结果数据
							page = result.getData().getTotalPage();
							pageRecord.setLastPage(i-1);
							pageRecord.setCurPage(i);
							pageRecord.setPageSize(result.getData().TotalNumber);
							logger.info(configApiInfo.getLiveKey()+"拉取页数："+i+",最大页数："+page);

						}else{//非正常请求，则需要重新请求当页数据
							i--;
							ThreadUtil.sleep(BBINCommon.HTTP_ERROR_THREAD_SLEEP);
							continue;
						}
					}//循环完毕，开始把pageRecord更新到数据库
					/*如果上一页页数没发生变化,则上一页的核对次数加1,如果发生变化，则核对次数改为0**/
					if(pageRecord.getLastPage() != lastPage){
						logger.info("uppername:{} 上页加1,需要重新校验上页数据",configApiInfo.getLiveKey());
						pageRecord.setLastPageCheckTimes(0);
					}
					pageRecordMapper.updateByPrimaryKeySelective(pageRecord);//更新page读取到第几页
					if(resultOK == null){
						resultOK = true;
					}
					return resultOK;
				}else{//读取上一页的数据
					
					for(int i = lastPage;i <= lastPage; i++){
						String param = getSendParam(configApiInfo, pageRecord,i);
						ReturnResult result = sendHttp(configApiInfo,betRecordUrl, param,
								pageRecord.getHttpAction(),pageRecord.getGameKind(),pageRecord.getSubGameKind());
						//如果请求成功
						if(result.isResult()){
							//判断返回的code，如果是系统维护则跳出循环，如果是正常拉取则继续循环
							if(result.getData().getCode() == 44444){
								pageRecord.setLastPage(i-1);
								pageRecord.setCurPage(i);
								resultOK = false;
								break;
							}
							//正常返回结果数据
							lastPage = result.getData().getTotalPage();
							pageRecord.setLastPage(i-1);
							pageRecord.setCurPage(i);
							pageRecord.setPageSize(result.getData().TotalNumber);
						}else{//非正常请求，则需要重新请求当页数据
							i--;
							ThreadUtil.sleep(BBINCommon.HTTP_ERROR_THREAD_SLEEP);
							continue;
						}
						
					}//循环完毕，开始把pageRecord更新到数据库
					
					/*如果上一页页数没发生变化,则上一页的核对次数加1,如果发生变化，则核对次数改为0**/
					if(pageRecord.getLastPage() == (lastPage-1)){
						logger.info("uppername:{} 校验上页数据完成",configApiInfo.getLiveKey());
						
						pageRecord.setLastPageCheckTimes(pageRecord.getLastPageCheckTimes()+1);
					}else{
						pageRecord.setLastPageCheckTimes(0);
					}
					pageRecordMapper.updateByPrimaryKeySelective(pageRecord);//更新page读取到第几页
					if(resultOK == null){
						resultOK = true;
					}
					return resultOK;
				}
	}

	private ReturnResult sendHttp(ApiInfoEntity configApiInfo, String url, String param, String httpAction, Integer gamekind, Integer subgamekind) {
		JSONObject obj = null;
		try {
			logger.info(configApiInfo.getLiveKey()+"请求参数:"+url+"?"+param);
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

	private String getSendParam(ApiInfoEntity configApiInfo, BBINGamePageRecord pageRecord, int page) {
		String key = getKey(configApiInfo);
		if(pageRecord.getHttpAction().equals("WagersRecordBy38")
				||pageRecord.getHttpAction().equals("WagersRecordBy30")) {
			return getRecord38And30(configApiInfo,pageRecord,page);
		}
		StringBuffer sb = new StringBuffer();
		sb.append("website=").append(Platform.Constans.kkw_WEBSITE);
		sb.append("&uppername=").append(configApiInfo.getLiveKey());
		sb.append("&rounddate=").append(pageRecord.getRounddate());
		sb.append("&starttime=00:00:00");
		sb.append("&endtime=23:59:59");
		sb.append("&gamekind="+pageRecord.getGameKind());
		sb.append("&subgamekind="+pageRecord.getSubGameKind());
		sb.append("&page=").append(page);
		sb.append("&pagelimit=500");
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
	private String getRecord38And30(ApiInfoEntity configApiInfo, BBINGamePageRecord pageRecord, int page) {
		String key = getKey(configApiInfo);
		StringBuffer sb = new StringBuffer();
		sb.append("website=").append(Platform.Constans.kkw_WEBSITE);
		sb.append("&uppername=").append(configApiInfo.getLiveKey());
		sb.append("&action=").append("BetTime");
		sb.append("&date=").append(pageRecord.getRounddate());
//		sb.append("&end_date=").append(pageRecord.getRounddate());
		sb.append("&starttime=00:00:00");
		sb.append("&endtime=23:59:59");
		sb.append("&gamekind="+pageRecord.getGameKind());
		sb.append("&subgamekind="+pageRecord.getSubGameKind());
		sb.append("&page=").append(1);
//		sb.append("&page=").append(page);
		sb.append("&pagelimit=500");
		sb.append("&key=").append(key);
		return sb.toString();
	}

	private String getKey(ApiInfoEntity configApiInfo) {
		String key = PlatformUtil.randomString(7)+
				PlatformUtil.toMD5(Platform.Constans.kkw_WEBSITE+Platform.Constans.kkw_BetRecord_KeyB+PlatformUtil.getTime())+
				PlatformUtil.randomString(2);
		return key;
	}

	private void addPageRecord(BBINGamePageRecord pageRecord) {
		pageRecordMapper.insert(pageRecord);
	}

	private BBINGamePageRecord getPageRecord(String agent, String rounddate,
			BBINGameHttpConfig bbinGameHttpConfig) {
		BBINGamePageRecordExample e = new BBINGamePageRecordExample();
		e.createCriteria().andUppernameEqualTo(agent).andRounddateEqualTo(rounddate)
			.andGameKindEqualTo(bbinGameHttpConfig.getGameKind())
			.andSubGameKindEqualTo(bbinGameHttpConfig.getSubGameKind())
			.andHttpActionEqualTo(bbinGameHttpConfig.getHttpAction());
		List<BBINGamePageRecord> list = pageRecordMapper.selectByExample(e);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	

}
