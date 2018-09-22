package com.ds.live.task;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import com.ds.live.dao.DsLiveDao;
import com.ds.live.service.DsLiveServiceImp;
import com.ds.live.until.ErrorUtil;
import com.ds.live.until.LiveConfig;
import com.ds.live.until.StringJudge;
import com.ds.msg.TelegramMessage;
import com.ds.temp.entity.AuditTotalVO;
import com.ds.temp.mapper.TempAuditTotalMapper;
import com.kg.live.contants.PlatformTypeEnum;
import com.kg.live.entity.ApiInfoEntity;
import com.kg.live.entity.DsLiveEntity;
import com.kg.live.entity.DsLiveEntityExample;
import com.kg.live.mapper.DsLiveEntityMapper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class LiveTask implements Runnable {
	private Logger logger = Logger.getLogger(this.getClass());

	private DsLiveServiceImp liveService;
	private ApiInfoEntity api;
	private DsLiveEntityMapper liveMapper;
	private DsLiveDao liveDao;

	
	private TempAuditTotalMapper tempAuditTotalMapper;
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//用来缓存记录最大订单好，key为gameType  value为最大订单号
	private Map<String,Long> maxBillnoMap = new HashMap<String,Long>();
	public LiveTask(DsLiveServiceImp liveService, ApiInfoEntity api) {
		super();
		this.liveService = liveService;
		this.api = api;
		liveMapper = liveService.getLiveMapper();
		liveDao = liveService.getLiveDao();

		this.tempAuditTotalMapper = liveService.getTempAuditTotalMapper();
	}

	@Override
	public void run() {
		Thread.currentThread().setName(api.getSiteName());

		while (liveService.getAipInfoList() != null && liveService.getAipInfoList().size() > 0) {
			Integer siteId = api.getSiteId();
			String siteName = api.getSiteName();
			String reportUrl = api.getReporturl();//视讯请求地址
			String hashCode = api.getLiveKey();//视讯hashCode

			logger.info("开始拉取网站id：" + siteId + ",网站名称：" + siteName + ",视讯请求地址：" + reportUrl + ",请求hashCode:" + hashCode);
			try {
				getBet(siteId, siteName, reportUrl, hashCode); //视讯拉取数据
				logger.info("网站：" + siteName + "一次拉取完成，休眠一分钟......");
				Thread.sleep(10*1000);
			} catch (Exception e) {
				e.printStackTrace();
				logger.info("网站拉取出错" + siteName + "错误信息：" + e.getMessage());
			}

		}
		//线程已经停止，线程计数器+1
		DsLiveServiceImp.stopCount.getAndIncrement();
		logger.info("线程" + Thread.currentThread().getName() + "已停止......");
	}

	public void getBet(Integer siteId, String siteName, String reportUrl, String hashCode) {
		try {
			Long lastmaxid = maxBillnoMap.get("live");
			String beginid = "";
			if(lastmaxid == null){
				beginid = liveDao.getMaxDsLiveBillno(siteId);
				if(beginid != null && beginid != ""){
					lastmaxid = Long.valueOf(beginid);
				}
			}else{
				logger.info(siteId+"从缓存获取最大视讯billno:"+lastmaxid);
				beginid = lastmaxid.toString();
			}
			
			logger.info("网站" + siteName + ",max beginid:" + beginid);
			if (null == beginid) {
				beginid = "0";
			}
			JSONObject obj = new JSONObject();
			obj.put("hashCode", hashCode); //hashcode
			obj.put("command", "GET_RECORD_BY_SEQUENCENO");
			JSONObject json = new JSONObject();
			json.put("beginId", beginid);
			json.put("count", "1000");
			obj.put("params", json);

			logger.info("网站" + siteName + ",GET_RECORD...obj:" + obj);

			Thread.sleep((int) (Math.random() * 5) * 1000);
			JSONObject jsonObject = JSONObject.fromObject(StringJudge.sendPost1(reportUrl, obj.toString()));

			logger.info("ds jsonObject::" + jsonObject);
			
			//请求成功
			if (jsonObject != null && "0".equals(jsonObject.getString("errorCode")) && "".equals(jsonObject.getString("errorMessage"))) {
				JSONObject jsonObj = JSONObject.fromObject(jsonObject.getString("params"));
				JSONArray arr = JSONArray.fromObject(jsonObj.getString("recordList"));

				logger.info(siteName + "数据条目数:" + arr.size());
				try {
					for (int i = 0, flag = arr.size(); i < flag; i++) {
						JSONObject data = arr.getJSONObject(i);
						DsLiveEntity liveEntity = getDsLiveByBillno(data.getLong("id"), siteId);
						boolean updateFLag = false;

						if (null != liveEntity) {
							logger.info(siteName + "DS视讯getBet修改:" + liveEntity.getBillno());
							updateFLag = true;
						} else {
							liveEntity = new DsLiveEntity();
							logger.info(siteName + "DS视讯getBet插入:" + data.getLong("id"));
						}

						liveEntity.setSiteId(siteId);
						liveEntity.setBillno(data.getLong("id"));//订单编号
						liveEntity.setSequenceNo(data.getLong("sequenceNo"));
						liveEntity.setUsername(data.getString("userName"));
						liveEntity.setGameType(data.getString("gameType"));
						liveEntity.setTableName(data.getString("tableName"));
						liveEntity.setGameInfoId(data.getInt("gameInfoId"));
						liveEntity.setShowInfoId(data.getInt("shoeInfoId"));
						liveEntity.setPokerList(data.getString("pokerList"));
						liveEntity.setStakeAmount(new BigDecimal(data.getDouble("stakeAmount")).setScale(2, BigDecimal.ROUND_HALF_UP));
						liveEntity.setValidStake(new BigDecimal(data.getDouble("validStake")).setScale(2, BigDecimal.ROUND_HALF_UP));
						liveEntity.setWinLoss(new BigDecimal(data.getDouble("winLoss")).setScale(2, BigDecimal.ROUND_HALF_UP));
						liveEntity.setBankerResult(data.getString("bankerResult"));
						liveEntity.setComm(new BigDecimal(data.getDouble("comm")).setScale(2, BigDecimal.ROUND_HALF_UP));
						liveEntity.setCurrency(data.getString("currency"));
						liveEntity.setIp(data.getString("ip"));
						//	liveEntity.setResultImgName(data.getString("resultImgName"));
						liveEntity.setResultList(data.getString("resultList"));
						liveEntity.setTableInfoId(data.getInt("tableInfoId"));
						if ("-1".equals(data.getString("bankerResult"))) {
							liveEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_CANCEL);//注单取消
						} else {
							if (data.getDouble("winLoss") > 0) { //
								liveEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_WIN);//赢
							} else if (data.getDouble("winLoss") < 0) {
								liveEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_LOSE);//输
							} else if (data.getDouble("winLoss") == 0) {
								String resultList = data.getString("resultList");
								if (null == resultList || "null".equals(resultList) || "".equals(resultList)) {
									liveEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_HE);//和 
								} else {
									String[] result = resultList.split(",");
									if (null != result) {
										if ("[3".equals(result[0])) {
											liveEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_HE);//和 
										} else {
											liveEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_WIN);//赢
										}
									}
								}

							}
						}

						liveEntity.setBalanceAfter(new BigDecimal(data.getDouble("balanceAfter")).setScale(2, BigDecimal.ROUND_HALF_UP));
						liveEntity.setLiveMemberReportDetails(data.getString("liveMemberReportDetails"));
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						format.setTimeZone(TimeZone.getTimeZone("GMT-4"));////美国中部分时间，相当于减掉 12小时
						liveEntity.setEndTime(Timestamp.valueOf(format.format(data.getLong("endTime"))));

						if (updateFLag) {//更新
							liveEntity.setUpdateTime(new Date());
							liveMapper.updateByPrimaryKey(liveEntity);
						} else {
							liveEntity.setCreateTime(new Date());
							liveMapper.insert(liveEntity);
						}

						//插入日志
						logger.info("temp_audit_total start");
						BigDecimal betAmount = new BigDecimal(data.getDouble("stakeAmount")).setScale(2, BigDecimal.ROUND_HALF_UP);
						BigDecimal validAmount = new BigDecimal(data.getDouble("validStake")).setScale(2, BigDecimal.ROUND_HALF_UP);
						BigDecimal payAmount = new BigDecimal(data.getDouble("winLoss")).setScale(2, BigDecimal.ROUND_HALF_UP);
						AuditTotalVO audit = new AuditTotalVO();
						audit.setBetTime(Timestamp.valueOf(format.format(data.getLong("endTime"))));
						audit.setUsername(data.getString("userName"));
						audit.setLiveId(LiveConfig.DS_KKW_LIVE_ID);
						audit.setGameName("ds_kkw");
						audit.setType(PlatformTypeEnum.LIVE.getValue());
						audit.setOrderNo(data.getLong("id") + "");
						audit.setPayAmount(payAmount);
						audit.setBetAmount(betAmount);
						audit.setValidAmount(validAmount);
						tempAuditTotalMapper.insertOrupdate(audit, siteId);
						logger.info("temp_audit_total end");
						
						if(lastmaxid == null ||lastmaxid < liveEntity.getSequenceNo()){
							lastmaxid = liveEntity.getSequenceNo();
						}
						
					}
					maxBillnoMap.put("live", lastmaxid);
				} catch (Exception e) {
					logger.info("网站："+siteName+",数据处理异常："+ e.getMessage());
					TelegramMessage telegramMessage = TelegramMessage.getInstance();
		        	telegramMessage.sendMessage(LiveConfig.BOT_A, LiveConfig.GROUP_JAVA, LiveConfig.TELEGRAM_DATA_ERROR, 
		        			"KKWDS视讯注单拉取数据处理异常，siteId："+siteId+" error："+ErrorUtil.LogExceptionStack(e));
				}
			}else {
				logger.info("网站：" + siteName + "拉取数据失败，请检查配置，线程休眠1分钟......");
				TelegramMessage telegramMessage = TelegramMessage.getInstance();
	        	telegramMessage.sendMessage(LiveConfig.BOT_A, LiveConfig.GROUP_JAVA, LiveConfig.TELEGRAM_RESULT_ERROR, 
	        			"KKWDS视讯注单拉取失败，siteId："+siteId+" error："+jsonObject);
				Thread.sleep(1000 * 60);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("网站：" + siteName + "拉取数据发生异常，线程降休眠30s，异常信息：" + e.getMessage());
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		logger.info("网站：" + siteName + "拉取数据成功.....");
	}

	private DsLiveEntity getDsLiveByBillno(Long billno, Integer siteId) {
		DsLiveEntityExample e = new DsLiveEntityExample();
		e.createCriteria().andBillnoEqualTo(billno).andSiteIdEqualTo(siteId);
		List<DsLiveEntity> list = liveMapper.selectByExample(e);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
