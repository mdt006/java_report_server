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
import com.kg.live.entity.AGLiveEntity;
import com.kg.live.entity.AGLiveEntityExample;
import com.kg.live.entity.ApiInfoEntity;
import com.kg.live.mapper.AGLiveEntityMapper;

@Service
public class AGYoplayService extends BaseService<AGLiveEntity> {
	private final Logger log = LoggerFactory.getLogger(AGCommon.LOG_AG_YOPLAY);
	@Autowired
	private AGLiveEntityMapper liveEntityMapper;

	@Override
	public AGLiveEntity setEntityByElement(Element info, String namepre, ApiInfoEntity apiInfo) {
		String dataType = info.attributeValue("dataType");
		if ("BR".equals(dataType) || "EBR".equals(dataType)) {
			AGLiveEntity liveEntity = getEntityByBillno(info.attributeValue("billNo"), namepre);
			boolean updateFlag = false;
			if (liveEntity == null) {
				liveEntity = new AGLiveEntity();
				log.info("ag新增:" + info.attributeValue("billNo"));
			} else {
				log.info("ag修改:" + info.attributeValue("billNo"));
				updateFlag = true;
			}
			liveEntity.setSiteId(apiInfo == null ? null : apiInfo.getSiteId());
			liveEntity.setBillNo(info.attributeValue("billNo"));
			liveEntity.setPlayerName(info.attributeValue("playerName"));
			liveEntity.setUsername(info.attributeValue("playerName").substring(AGCommon.AG_GAME_NAME_PRE_LENGTH,
					info.attributeValue("playerName").length()));
			liveEntity.setUserPre(namepre);
			liveEntity.setAgentCode(info.attributeValue("agentCode"));
			liveEntity.setGameCode(info.attributeValue("gameCode"));
			liveEntity.setRound(info.attributeValue("round"));
			liveEntity.setNetAmount(
					new BigDecimal(info.attributeValue("netAmount")).setScale(2, BigDecimal.ROUND_HALF_UP));
			liveEntity.setBetTime(Timestamp.valueOf(info.attributeValue("betTime")));
			liveEntity.setGameType(info.attributeValue("gameType"));
			liveEntity.setBetAmount(
					new BigDecimal(info.attributeValue("betAmount")).setScale(2, BigDecimal.ROUND_HALF_UP));
			liveEntity.setValidBetAmount(
					new BigDecimal(info.attributeValue("validBetAmount")).setScale(2, BigDecimal.ROUND_HALF_UP));
			liveEntity.setFlag(info.attributeValue("flag"));
			Byte winLossType = setWinLoseType(info, info.attributeValue("flag"));
			liveEntity.setWinLossType(winLossType);
			liveEntity.setTableCode(info.attributeValue("tableCode"));
			liveEntity.setCurrency(info.attributeValue("currency"));
			liveEntity.setDeviceType(info.attributeValue("deviceType"));
			liveEntity.setLoginIp(info.attributeValue("loginIP"));
			liveEntity.setPlatformId(info.attributeValue("platformId"));
			liveEntity.setPlatformType(info.attributeValue("platformType"));
			liveEntity.setPlayType(info.attributeValue("playType"));
			liveEntity.setRecalcuTime(Timestamp.valueOf(info.attributeValue("recalcuTime")));
			liveEntity.setRemark(info.attributeValue("remark"));
			liveEntity.setGameKind(super.getAgLiveGameKind(info.attributeValue("gameType")));
			/*** 电子游戏修改 *******************/
			liveEntity.setSlottype(
					info.attributeValue("slottype") == null ? null : Integer.valueOf(info.attributeValue("slottype")));
			liveEntity.setMainbillno(info.attributeValue("mainbillno"));

			String betAmountBase = info.attributeValue("betAmountBase");
			if (StringUtils.isNotBlank(betAmountBase)) {
				liveEntity.setBetAmountBase(new BigDecimal(betAmountBase).setScale(2, BigDecimal.ROUND_HALF_UP));
			}
			String betAmountBonus = info.attributeValue("betAmountBonus");
			if (StringUtils.isNotBlank(betAmountBonus)) {
				liveEntity.setBetAmountBonus(new BigDecimal(betAmountBonus).setScale(2, BigDecimal.ROUND_HALF_UP));
			}
			String netAmountBase = info.attributeValue("netAmountBase");
			if (StringUtils.isNotBlank(netAmountBase)) {
				liveEntity.setBetAmountBonus(new BigDecimal(netAmountBase).setScale(2, BigDecimal.ROUND_HALF_UP));
			}
			String netAmountBonus = info.attributeValue("netAmountBonus");
			if (StringUtils.isNotBlank(netAmountBonus)) {
				liveEntity.setBetAmountBonus(new BigDecimal(netAmountBonus).setScale(2, BigDecimal.ROUND_HALF_UP));
			}
			if (updateFlag) {
				liveEntity.setUpdateTime(new Date());
				liveEntityMapper.updateByPrimaryKey(liveEntity);
			} else {
				liveEntity.setCreateTime(new Date());
				liveEntityMapper.insert(liveEntity);
			}
			return liveEntity;
		}
		return null;
	}

	@Override
	public void setAuditEntity(Element info, AGLiveEntity liveEntity, ApiInfoEntity apiInfo) {
		log.info("temp_audit_total start");
		if (liveEntity == null) {
			return;
		}
		BigDecimal betAmount = new BigDecimal(info.attributeValue("betAmount")).setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal validAmount = new BigDecimal(info.attributeValue("validBetAmount")).setScale(2,
				BigDecimal.ROUND_HALF_UP);
		BigDecimal payAmount = new BigDecimal(info.attributeValue("netAmount")).setScale(2, BigDecimal.ROUND_HALF_UP);
		String username = info.attributeValue("playerName").substring(AGCommon.AG_GAME_NAME_PRE_LENGTH,
				info.attributeValue("playerName").length());
		AuditTotalVO audit = new AuditTotalVO();
		audit.setBetTime(Timestamp.valueOf(info.attributeValue("betTime")));
		audit.setUsername(username);
		audit.setLiveId(PlatFormEnum.AG.getValue());
		audit.setGameName(AuditGameNameEnum.AG_GAME.toString());
		audit.setType(liveEntity.getGameKind() == (byte) 21 ? PlatformTypeEnum.LIVE.getValue()
				: PlatformTypeEnum.GAME.getValue());
		audit.setOrderNo(info.attributeValue("billNo"));
		audit.setPayAmount(payAmount);
		audit.setBetAmount(betAmount);
		audit.setValidAmount(validAmount);
		tempAuditTotalMapper.insertOrupdate(audit, liveEntity.getSiteId());
		log.info("temp_audit_total end");

	}

	@Override
	public AGLiveEntity getEntityByBillno(String billno, String namepre) {
		AGLiveEntityExample e = new AGLiveEntityExample();
		e.createCriteria().andBillNoEqualTo(billno).andUserPreEqualTo(namepre);
		List<AGLiveEntity> list = liveEntityMapper.selectByExample(e);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
