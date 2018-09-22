package com.ds.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.common.AGCommon;
import com.ds.temp.entity.AuditTotalVO;
import com.kg.live.contants.AuditGameNameEnum;
import com.kg.live.contants.PlatFormEnum;
import com.kg.live.contants.PlatformTypeEnum;
import com.kg.live.entity.ApiInfoEntity;
import com.kg.live.entity.DsAgHunter;
import com.kg.live.entity.DsAgHunterExample;
import com.kg.live.mapper.DsAgHunterMapper;

@Service
public class AGHunterService extends BaseService<DsAgHunter> {
	private final Logger log = LoggerFactory.getLogger(AGCommon.LOG_AG_HUNTER);
	@Autowired
	private DsAgHunterMapper hunterMapper;

	@Override
	public DsAgHunter setEntityByElement(Element info, String namepre, ApiInfoEntity apiInfo) {
		String dataType = info.attributeValue("dataType");
		if ("HSR".equals(dataType) || "HPR".equals(dataType)) {
			DsAgHunter hunter = getEntityByBillno(info.attributeValue("tradeNo"), namepre);
			boolean updateFlag = false;
			if (hunter == null) {
				hunter = new DsAgHunter();
				log.info("ag新增:" + info.attributeValue("tradeNo"));
			} else {
				log.info("ag修改:" + info.attributeValue("tradeNo"));
				updateFlag = true;
			}
			hunter.setSiteId(apiInfo == null ? null : apiInfo.getSiteId());
			hunter.setTradeNo(info.attributeValue("tradeNo"));
			hunter.setTransferId(info.attributeValue("transferId"));

			hunter.setDataType(info.attributeValue("dataType"));
			hunter.setPlayerName(info.attributeValue("playerName"));
			hunter.setUsername(info.attributeValue("playerName").substring(AGCommon.AG_GAME_NAME_PRE_LENGTH,
					info.attributeValue("playerName").length()));
			hunter.setNamepre(namepre);
			hunter.setAgentCode(info.attributeValue("agentCode"));
			hunter.setGameCode(info.attributeValue("gameCode"));
			hunter.setBetTime(Timestamp.valueOf(info.attributeValue("creationTime")));
			hunter.setFlag(info.attributeValue("flag"));
			hunter.setExchangeRate(Byte.valueOf(info.attributeValue("exchangeRate")));
			if (StringUtils.isNotBlank(info.attributeValue("Earn"))) {
				hunter.setEarn(new BigDecimal(info.attributeValue("Earn")).setScale(3, BigDecimal.ROUND_HALF_UP));
			}
			if (StringUtils.isBlank(info.attributeValue("Cost"))) {
				hunter.setBetAmount(new BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_UP));
				hunter.setValidBetAmount(new BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_UP));
			} else {
				hunter.setCost(new BigDecimal(info.attributeValue("Cost")).setScale(3, BigDecimal.ROUND_HALF_UP));
				hunter.setBetAmount(new BigDecimal(info.attributeValue("Cost")).setScale(3, BigDecimal.ROUND_HALF_UP));
				hunter.setValidBetAmount(
						new BigDecimal(info.attributeValue("Cost")).setScale(3, BigDecimal.ROUND_HALF_UP));
			}
			if (StringUtils.isBlank(info.attributeValue("Jackpotcomm"))) {
				hunter.setJackpotcomm(new BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_UP));
			} else {
				hunter.setJackpotcomm(new BigDecimal(info.attributeValue("Jackpotcomm")));
			}

			// "HSR" 捕鱼王下注记录
			if ("HSR".equals(info.attributeValue("dataType"))) {
				hunter.setSceneId(info.attributeValue("sceneId"));
				hunter.setSceneStartTime(Timestamp.valueOf(info.attributeValue("SceneStartTime")));
				hunter.setSceneEndTime(Timestamp.valueOf(info.attributeValue("SceneEndTime")));
				hunter.setRoomid(info.attributeValue("Roomid"));
				hunter.setRoombet(new BigDecimal(info.attributeValue("Roombet")).setScale(3, BigDecimal.ROUND_HALF_UP));
				BigDecimal tempWinlose = new BigDecimal(info.attributeValue("transferAmount"))
						.add(new BigDecimal(info.attributeValue("Jackpotcomm")).setScale(3, BigDecimal.ROUND_HALF_UP));
				hunter.setType(Byte.valueOf(info.attributeValue("type")));
				hunter.setDeviceType(Byte.valueOf(info.attributeValue("deviceType")));
				// type=1 场景捕鱼 type=2 抽奖 type=7 捕鱼王奖励
				String type = info.attributeValue("type");
				if (type.equals("1")) {
					hunter.setNetAmount(tempWinlose);
				} else {
					hunter.setNetAmount(new BigDecimal(info.attributeValue("transferAmount")).setScale(3,
							BigDecimal.ROUND_HALF_UP));
				}
			}
			// 养鱼记录
			if ("HPR".equals(info.attributeValue("dataType"))) {
				hunter.setNetAmount(
						new BigDecimal(info.attributeValue("transferAmount")).setScale(3, BigDecimal.ROUND_HALF_UP));
				hunter.setTransferType(Byte.valueOf(info.attributeValue("transferType")));
				hunter.setRemark(info.attributeValue("remark"));
				hunter.setFishIdStart(info.attributeValue("fishIdStart"));
				hunter.setFishIdEnd(info.attributeValue("fishIdEnd"));
			}

			if (hunter.getNetAmount().doubleValue() > 0) {
				hunter.setWinLossType(AGCommon.LIVE_RESULT_TYPE_WIN);
			} else if (hunter.getNetAmount().doubleValue() < 0) {
				hunter.setWinLossType(AGCommon.LIVE_RESULT_TYPE_LOSE);
			} else if (hunter.getNetAmount().doubleValue() == 0) {
				hunter.setWinLossType(AGCommon.LIVE_RESULT_TYPE_HE);
			}
			hunter.setCurrentAmount(
					new BigDecimal(info.attributeValue("currentAmount")).setScale(3, BigDecimal.ROUND_HALF_UP));
			hunter.setPreviousAmount(
					new BigDecimal(info.attributeValue("previousAmount")).setScale(3, BigDecimal.ROUND_HALF_UP));
			hunter.setCurrency(info.attributeValue("currency"));
			hunter.setIp(info.attributeValue("IP"));
			hunter.setPlatformType(info.attributeValue("platformType"));
			if (updateFlag) {
				hunter.setUpdateTime(new Date());
				hunterMapper.updateByPrimaryKey(hunter);
			} else {
				hunter.setCreateTime(new Date());
				hunterMapper.insert(hunter);
			}
			return hunter;
		}
		return null;
	}

	@Override
	public void setAuditEntity(Element info, DsAgHunter hunter, ApiInfoEntity apiInfo) {
		log.info("temp_audit_total start");
		if (hunter == null) {
			return;
		}
		BigDecimal betAmount = hunter.getBetAmount();
		BigDecimal validAmount = hunter.getValidBetAmount();
		BigDecimal payAmount = hunter.getNetAmount();
		String username = info.attributeValue("playerName").substring(AGCommon.AG_GAME_NAME_PRE_LENGTH,
				info.attributeValue("playerName").length());
		AuditTotalVO audit = new AuditTotalVO();
		audit.setBetTime(hunter.getBetTime());
		audit.setUsername(username);
		audit.setLiveId(PlatFormEnum.AG.getValue());
		audit.setGameName(AuditGameNameEnum.AG_HUNTER.toString());
		audit.setType(PlatformTypeEnum.GAME.getValue());
		audit.setOrderNo(hunter.getTradeNo());
		audit.setPayAmount(payAmount);
		audit.setBetAmount(betAmount);
		audit.setValidAmount(validAmount);
		tempAuditTotalMapper.insertOrupdate(audit, hunter.getSiteId());
		log.info("temp_audit_total end");

	}

	@Override
	public DsAgHunter getEntityByBillno(String billno, String namepre) {
		DsAgHunterExample e = new DsAgHunterExample();
		e.createCriteria().andTradeNoEqualTo(billno).andNamepreEqualTo(namepre);
		List<DsAgHunter> list = hunterMapper.selectByExample(e);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
