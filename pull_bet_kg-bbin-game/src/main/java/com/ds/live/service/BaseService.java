package com.ds.live.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.live.dao.BBINDao;
import com.ds.live.entity.BBINGameVo;
import com.ds.live.until.LiveConfig;
import com.ds.temp.entity.AuditTotalVO;
import com.ds.temp.mapper.TempAuditTotalMapper;
import com.kg.live.contants.AuditGameNameEnum;
import com.kg.live.contants.PlatFormEnum;
import com.kg.live.contants.PlatformTypeEnum;

@Service
public class BaseService {
		
	@Autowired
	private BBINDao bbDao;
	@Autowired
	private TempAuditTotalMapper tempAuditTotalMapper;
	
	
	public void saveDataList(List<BBINGameVo> list,int siteId,String uppname) throws Exception{
		if(list == null || list.size() == 0){
			return ;
		}
		setAttr(list, siteId, uppname);
		bbDao.insertOrUpdate(list);
		saveAuditVoList(list, siteId);
	}
	
	
	/**
	 * 设置下其他属性
	 */
	private void setAttr(List<BBINGameVo> list,int siteId,String uppname) throws Exception{
		Date date=new Date();
		list.stream().forEach(vo ->{
			vo.setUppername(uppname);
			vo.setSiteId(siteId);
			String playName = vo.getUserName();
			vo.setUserName(StringUtils.substring(playName, LiveConfig.BBIN_NAME_PRE_LENGTH));
			BigDecimal payoff = vo.getPayOff();
			if(payoff.doubleValue()>0) {
				vo.setWinLossType(2);//1:输，2：赢，3：和
			}else if(payoff.doubleValue()<0) {
				vo.setWinLossType(1);
			}else {
				vo.setWinLossType(3);
			}
			vo.setCreateTime(date);
			vo.setUpdateTime(date);
		});
	}
	
	public void saveAuditVoList(List<BBINGameVo> list,int siteId){
		List<AuditTotalVO> auditList=new ArrayList<AuditTotalVO>();
		for (int i = 0; i < list.size(); i++) {
			BBINGameVo bbinGame = list.get(i);
			AuditTotalVO audit = new AuditTotalVO();
			audit.setBetTime(bbinGame.getWagersDate());
			audit.setUsername(bbinGame.getUserName());
			audit.setLiveId(PlatFormEnum.BBIN.getValue());
			audit.setGameName(AuditGameNameEnum.BBIN_GAME.toString());
			audit.setType(PlatformTypeEnum.GAME.getValue());
			audit.setOrderNo(bbinGame.getWagersId());
			audit.setPayAmount(bbinGame.getPayOff().setScale(2, BigDecimal.ROUND_HALF_UP));
			audit.setBetAmount(bbinGame.getBetAmount().setScale(2, BigDecimal.ROUND_HALF_UP));
			audit.setValidAmount(bbinGame.getCommissionable().setScale(2, BigDecimal.ROUND_HALF_UP));
			auditList.add(audit);
		}
		tempAuditTotalMapper.batInsertOrupdate(auditList, siteId);
	}
}
