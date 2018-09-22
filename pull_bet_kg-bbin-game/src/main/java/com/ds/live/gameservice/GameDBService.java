package com.ds.live.gameservice;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.live.dao.BBINDao;
import com.ds.live.entity.BBINGameHttpConfig;
import com.ds.live.entity.BBINGameHttpConfigExample;
import com.ds.live.entity.BBINGameVo;
import com.ds.live.mapper.BBINGameHttpConfigMapper;
import com.ds.temp.entity.AuditTotalVO;
import com.ds.temp.mapper.TempAuditTotalMapper;
import com.kg.live.contants.AuditGameNameEnum;
import com.kg.live.contants.PlatFormEnum;
import com.kg.live.contants.PlatformTypeEnum;
import com.kg.live.entity.ApiInfoEntity;
import com.kg.live.entity.ApiInfoEntityExample;
import com.kg.live.mapper.ApiInfoEntityMapper;

@Service
public class GameDBService {
	@Autowired
	private ApiInfoEntityMapper  apiInfoMapper;
	@Autowired
	private BBINGameHttpConfigMapper gameHttpConfigMapper;
	@Autowired
	private BBINDao bbDao;
	
	@Autowired
	private TempAuditTotalMapper tempAuditTotalMapper;
	
	private Logger logger = Logger.getLogger(getClass());
	/**
	 * 获取api配置列表
	 * @return
	 */
	public List<ApiInfoEntity> getConfigApiInfo(){
		ApiInfoEntityExample e = new ApiInfoEntityExample();
		e.createCriteria().andStateEqualTo(Short.valueOf("50")).andLiveIdEqualTo(11);//state:50为正常  liveId=11为bbin平台
		return apiInfoMapper.selectByExample(e);
	}
	public List<BBINGameHttpConfig> getGameHttpConfig() {
		BBINGameHttpConfigExample e = new BBINGameHttpConfigExample();
		e.createCriteria().andStatusEqualTo(50);
		return gameHttpConfigMapper.selectByExample(e);
	}
	public void insertOrUpdate(List<BBINGameVo> list) {
		bbDao.insertOrUpdate(list);
	}

	public void insertOrUpdateTempAuditTotal(List<BBINGameVo> list) {
		
		BBINGameVo bbinGame = null;
		for (int i = 0; i < list.size(); i++) {
			bbinGame = list.get(i);
			AuditTotalVO audit = new AuditTotalVO();
			audit.setBetTime(bbinGame.getWagersDate());
			audit.setUsername(bbinGame.getUserName());
			audit.setLiveId(PlatFormEnum.BBIN.getValue());
			audit.setGameName(AuditGameNameEnum.BBIN_HUNTER.toString());
			audit.setType(PlatformTypeEnum.GAME.getValue());
			audit.setOrderNo(bbinGame.getWagersId());
			audit.setPayAmount(bbinGame.getPayOff().setScale(2, BigDecimal.ROUND_HALF_UP));
			audit.setBetAmount(bbinGame.getBetAmount().setScale(2, BigDecimal.ROUND_HALF_UP));
			audit.setValidAmount(bbinGame.getCommissionable().setScale(2, BigDecimal.ROUND_HALF_UP));
			tempAuditTotalMapper.insertOrupdate(audit, bbinGame.getSiteId());
		}
	}
}
