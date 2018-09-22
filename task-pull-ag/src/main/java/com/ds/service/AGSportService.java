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
import com.kg.live.entity.DsAgSport;
import com.kg.live.entity.DsAgSportExample;
import com.kg.live.mapper.DsAgSportMapper;
@Service
public class AGSportService extends BaseService<DsAgSport> {
	private final Logger log = LoggerFactory.getLogger(AGCommon.LOG_AG_SPORT);
	@Autowired
	private DsAgSportMapper sportMapper;
	@Override
	public DsAgSport setEntityByElement(Element info, String namepre, ApiInfoEntity apiInfo) {
		String dataType = info.attributeValue("dataType");
		if ("BR".equals(dataType)) {
			DsAgSport sport = getEntityByBillno(info.attributeValue("billNo"), namepre);
			boolean updateFlag = false;
			if (sport == null) {
				sport = new DsAgSport();
				log.info("ag新增:" + info.attributeValue("billNo"));
			} else {
				log.info("ag修改:" + info.attributeValue("billNo"));
				updateFlag = true;
			}
			sport.setSiteId(apiInfo == null ? null : apiInfo.getSiteId());
			sport.setBillNo(info.attributeValue("billNo"));
			sport.setPlayerName(info.attributeValue("playerName"));
			sport.setUsername(info.attributeValue("playerName").substring(AGCommon.AG_GAME_NAME_PRE_LENGTH,
					info.attributeValue("playerName").length()));
			sport.setUserPre(namepre);
			sport.setAgentCode(info.attributeValue("agentCode"));
			sport.setGameCode(info.attributeValue("gameCode"));
			sport.setNetAmount(
					new BigDecimal(info.attributeValue("netAmount")).setScale(2, BigDecimal.ROUND_HALF_UP));
			sport.setBetTime(Timestamp.valueOf(info.attributeValue("betTime")));
			sport.setGameType(info.attributeValue("gameType"));
			sport.setBetAmount(
					new BigDecimal(info.attributeValue("betAmount")).setScale(2, BigDecimal.ROUND_HALF_UP));
			sport.setValidBetAmount(
					new BigDecimal(info.attributeValue("validBetAmount")).setScale(2, BigDecimal.ROUND_HALF_UP));
			String flag = info.attributeValue("flag");
			sport.setFlag(flag);
			// 1=已结算 0=未结算 -1=重置试玩额度 -2=注单被篡改 -8=取消指定局注单 -9=取消注单 2=下注中 4=撤单套现
			if ("1".equals(info.attributeValue("flag")) || "4".equals(info.attributeValue("flag"))) {
				double netAmount = sport.getNetAmount().doubleValue();
				if (netAmount > 0) {
					sport.setWinLossType(AGCommon.LIVE_RESULT_TYPE_WIN);
				} else if (netAmount < 0) {
					sport.setWinLossType(AGCommon.LIVE_RESULT_TYPE_LOSE);
				} else if (netAmount == 0) {
					sport.setWinLossType(AGCommon.LIVE_RESULT_TYPE_HE);
				}
			} else if ("0".equals(flag)
					|| "2".equals(flag)) {
				sport.setWinLossType(AGCommon.LIVE_RESULT_TYPE_UNBET);
			} else if ("-1".equals(flag)
					|| "-8".equals(flag)
					|| "-9".equals(flag)
					|| "-2".equals(flag)) {
				sport.setWinLossType(AGCommon.LIVE_RESULT_TYPE_CANCEL);
			} 
			sport.setCurrency(info.attributeValue("currency"));
			sport.setDeviceType(info.attributeValue("deviceType"));
			sport.setLoginIp(info.attributeValue("loginIP"));
			sport.setPlatformId(info.attributeValue("platformId"));
			sport.setPlatformType(info.attributeValue("platformType"));
			String recalcuTime = info.attributeValue("recalcuTime");
			if(StringUtils.isNotBlank(recalcuTime)&&!"null".equals(recalcuTime)){
				sport.setRecalcuTime(Timestamp.valueOf(recalcuTime));
			}
			sport.setRemark(info.attributeValue("remark"));
			sport.setGameKind(AGCommon.AG_GAME_KIND_SPORT);
			
			if (updateFlag) {
				sport.setUpdateTime(new Date());
				sportMapper.updateByPrimaryKey(sport);
			} else {
				sport.setCreateTime(new Date());
				sportMapper.insert(sport);
			}
			return sport;
		}
		return null;
	}

	@Override
	public void setAuditEntity(Element info, DsAgSport sport, ApiInfoEntity apiInfo) {
		log.info("temp_audit_total start");
		if(sport == null) {
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
		audit.setGameName(AuditGameNameEnum.AG_SPORT.toString());
		audit.setType(PlatformTypeEnum.SPROT.getValue());
		audit.setOrderNo(info.attributeValue("billNo"));
		audit.setPayAmount(payAmount);
		audit.setBetAmount(betAmount);
		audit.setValidAmount(validAmount);
		tempAuditTotalMapper.insertOrupdate(audit, sport.getSiteId());
		log.info("temp_audit_total end");
	}
	@Override
	public DsAgSport getEntityByBillno(String billno, String namepre) {
		DsAgSportExample e = new DsAgSportExample();
		e.createCriteria().andBillNoEqualTo(billno).andUserPreEqualTo(namepre);
		List<DsAgSport> list = sportMapper.selectByExample(e);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
