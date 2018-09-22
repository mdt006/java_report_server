package com.ds.live.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.live.until.LiveConfig;
import com.ds.live.until.StringJudge;
import com.ds.temp.entity.TempAuditTotal;
import com.ds.temp.entity.TempAuditTotalExample;
import com.ds.temp.entity.TempAuditTotalExample.Criteria;
import com.ds.temp.mapper.TempAuditTotalMapper;
import com.kg.live.entity.DsLotteryBetEntity;
import com.kg.live.entity.DsLotteryBetEntityExample;
import com.kg.live.mapper.DsLotteryBetEntityMapper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class HandLiveService {
	private Logger logger = Logger.getLogger(this.getClass());
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	private DsLotteryBetEntityMapper lotteryBetMapper;
	@Autowired
	private TempAuditTotalMapper tempAuditTotalMapper;
	
	//拉取数据
	public String bet(String beginid,String hashCode,String siteId,String lotteryGameType){
		
		String maxId = null;//最大 id
		
		while(true){
			JSONObject obj = new JSONObject();
			obj.put("hashCode", hashCode); //hashcode
			obj.put("command", "GET_LOTTERY_RECORD"); //彩票 拉取 命令
			JSONObject json = new JSONObject();
			if(null == maxId){
				json.put("beginId", beginid);
			}else{
				json.put("beginId", maxId);
			}
			json.put("count", "1000");
			json.put("lotteryGameType", lotteryGameType);
			obj.put("params", json);
	
			logger.info("网站" + siteId + "GET_LOTTERY_RECORD...obj:" + obj);
	
			
			
			JSONObject jsonObject = JSONObject.fromObject(StringJudge.sendPost1("http://repwf.dsbet87.com/dsapiwfrecord/app/api.do", obj.toString()));
			if (jsonObject.has("errorCode")) {
				//请求数据成功
				if ("0".equals(jsonObject.getString("errorCode")) && "".equals(jsonObject.getString("errorMessage"))) {
	
					JSONObject jsonObj = JSONObject.fromObject(jsonObject.getString("params"));
	
					JSONArray arr = JSONArray.fromObject(jsonObj.getString("recordList"));
	
					logger.info(siteId + "数据条目数:" + arr.size());
	
					if(0==arr.size()){
						return "ok";
					}
					
					for (int i = 0, flag = arr.size(); i < flag; i++) {
						JSONObject data = arr.getJSONObject(i);
						DsLotteryBetEntity lotteryEntity = getDsLotteryBetByBetId(data.getString("betId"), Integer.valueOf(siteId));
						boolean updateFLag = false;
	
						if (null != lotteryEntity) {
							logger.info(siteId + "DS传统彩getLotteryBet修改:" + lotteryEntity.getBetId());
							updateFLag = true;
						} else {
							lotteryEntity = new DsLotteryBetEntity();
							logger.info(siteId + "DS传统彩getLotteryBet插入:" + lotteryEntity.getBetId());
						}
	
						lotteryEntity.setSiteId(Integer.valueOf(siteId));
						lotteryEntity.setBillno(data.getLong("id"));//订单编号
						maxId = data.getString("id");//最大id
						lotteryEntity.setUsername(data.getString("username"));
						lotteryEntity.setTray(data.getString("tray"));
						lotteryEntity.setBetTime(Timestamp.valueOf(format.format(data.getLong("betTime"))));
	
						lotteryEntity.setBetId(data.getString("betId"));
						lotteryEntity.setGameInfoId(data.getInt("gameInfoId"));//游戏类型
						lotteryEntity.setGameNo(data.getString("gameNo"));//期号
						lotteryEntity.setBetOn(data.getString("betOn"));//下注类型
						lotteryEntity.setBetType(data.getString("betType"));//下注类型详细
						lotteryEntity.setOdds(data.getDouble("odds"));//赔率
						lotteryEntity.setBetDetail(data.getString("betDetails"));//下注明细一般用于连码
						lotteryEntity.setStakeAmount(data.getDouble("stakeAmount"));//下注额
						lotteryEntity.setValidStake(data.getDouble("validStake"));//有效下注金额
						lotteryEntity.setWinLoss(data.getDouble("winLoss")); //输赢
						lotteryEntity.setIp(data.getString("ip"));
						lotteryEntity.setLotteryGameType(lotteryGameType);
						if (data.getDouble("winLoss") > 0) {
							lotteryEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_WIN);//赢
						} else if (data.getDouble("winLoss") < 0) {
							lotteryEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_LOSE);//输
						} else if (data.getDouble("winLoss") == 0) {
	
							lotteryEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_HE);//和
							/*
							 * String resultList = data.getString("resultList"); if(null == resultList || "null".equals(resultList) || "".equals(resultList)){ lottoEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_HE);//和 }else{ String[] result = resultList.split(","); if(null != result){ if("[3".equals(result[0])){ lottoEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_HE);//和 }else{ lottoEntity.setWinLossType(LiveConfig.LIVE_RESULT_TYPE_WIN);//赢 } } }
							 */
						}
	
						if (updateFLag) {//更新
							//lotteryEntity.setUpdateTime(new Date());
							//lotteryBetMapper.updateByPrimaryKey(lotteryEntity);
							logger.info("网站" + siteId + "GET_LOTTERY_RECORD..修改.billno:" + data.getLong("id"));
						} else {
							lotteryEntity.setCreateTime(new Date());
							lotteryBetMapper.insert(lotteryEntity);
							logger.info("网站" + siteId + "GET_LOTTERY_RECORD..插入.billno:" + data.getLong("id"));
						}
						
						
						logger.info("temp_audit_total start");
						int liveId = 30;//表示ds视讯
						TempAuditTotalExample example = new TempAuditTotalExample();
						Criteria createCriteria = example.createCriteria();
						createCriteria.andOrderNoEqualTo(data.getString("betId"));
						createCriteria.andLiveIdEqualTo(liveId);
						List<TempAuditTotal> list = this.tempAuditTotalMapper.selectByExample(example);
						TempAuditTotal record = list == null || list.size() == 0 ? null : list.get(0);
						BigDecimal betAmount = new BigDecimal(data.getDouble("stakeAmount")).setScale(2, BigDecimal.ROUND_HALF_UP);
						BigDecimal validAmount = new BigDecimal(data.getDouble("validStake")).setScale(2, BigDecimal.ROUND_HALF_UP);
						BigDecimal payAmount = new BigDecimal(data.getDouble("winLoss")).setScale(2, BigDecimal.ROUND_HALF_UP);
						if (record == null) {//insert
							record = new TempAuditTotal();
							record.setBetTime(Timestamp.valueOf(format.format(data.getLong("betTime"))));
							record.setSiteId(Integer.valueOf(siteId));
							record.setUsername(data.getString("username"));
							record.setLiveId(liveId);
							record.setOrderNo(data.getString("betId"));
							record.setPayAmount(payAmount);
							record.setBetAmount(betAmount);
							record.setValidAmount(validAmount);
							record.setCreateTime(new Date());
							record.setType(3);
							this.tempAuditTotalMapper.insert(record);
						} else {//update
							record.setBetTime(Timestamp.valueOf(format.format(data.getLong("betTime"))));
							record.setSiteId(Integer.valueOf(siteId));
							record.setUsername(data.getString("username"));
							record.setLiveId(liveId);
							record.setOrderNo(data.getString("betId"));
							record.setPayAmount(payAmount);
							record.setBetAmount(betAmount);
							record.setValidAmount(validAmount);
							record.setUpdateTime(new Date());
							this.tempAuditTotalMapper.updateByPrimaryKey(record);
						}
						logger.info("temp_audit_total end");
						
					}//end for each arr.size
	
					
				}//end if errorCode 正确
				else {
					logger.info("网站：" + siteId + " 彩票 拉取数据失败,errorCode不为0，请检查配置......errorCode:"+jsonObject.getString("errorCode")+",errorMessage:"+jsonObject.getString("errorMessage"));
				}//end if errorCode z
	
			}
		}
		
	}
	
	private DsLotteryBetEntity getDsLotteryBetByBetId(String betId, Integer siteId) {
		DsLotteryBetEntityExample e = new DsLotteryBetEntityExample();
		e.createCriteria().andBetIdEqualTo(betId).andSiteIdEqualTo(siteId);
		List<DsLotteryBetEntity> list = lotteryBetMapper.selectByExample(e);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
