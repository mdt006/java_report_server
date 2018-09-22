package com.ds.lmg.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.lmg.dao.LMGDao;
import com.ds.temp.entity.AuditTotalVO;
import com.ds.temp.mapper.TempAuditTotalMapper;
import com.kg.live.contants.APIEnum;
import com.kg.live.contants.AuditGameNameEnum;
import com.kg.live.contants.PlatFormEnum;
import com.kg.live.contants.PlatformTypeEnum;
import com.kg.live.entity.ApiInfoEntity;
import com.kg.live.entity.ApiInfoEntityExample;
import com.kg.live.entity.LMGLiveEntityWithBLOBs;
import com.kg.live.mapper.ApiInfoEntityMapper;


@Service
public class LMGService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ApiInfoEntityMapper apiInfoMapper;
	@Autowired
	private LMGDao lmgDao;
	@Autowired
	private TempAuditTotalMapper tempAuditTotalMapper;
	
	public List<ApiInfoEntity> getAipInfoList() {
		ApiInfoEntityExample e = new ApiInfoEntityExample();
		e.createCriteria().andLiveIdEqualTo(PlatFormEnum.LMG.getValue()).andStateEqualTo(Short.valueOf(APIEnum.NORMAL.getValue()+""));
		return apiInfoMapper.selectByExample(e);
	}

	public String getMaxSeqNo(Integer siteId) {
		return lmgDao.getMaxSeqNo(siteId);
	}
	
	
	
	public void insOrUp(List<LMGLiveEntityWithBLOBs> lmglist) {
		long start = System.currentTimeMillis();
		if(lmglist.size()>0){
			insOrUpLmg(lmglist);
			insOrUpAudit(lmglist);
		}
		long end = System.currentTimeMillis();
		logger.info("插入数据库耗时:"+(end-start));
	}
	/**
	 * 需要实现
	 * @param lmglist
	 */
	private void insOrUpLmg(List<LMGLiveEntityWithBLOBs> lmglist) {
		lmgDao.addLmg(lmglist);
	}
	/**
	 * 需要实现
	 * @param lmglist
	 */
	private void insOrUpAudit(List<LMGLiveEntityWithBLOBs> lmglist) {	
		//稽核表			
		List<AuditTotalVO> auditList=new ArrayList<AuditTotalVO>();
		Integer siteId=lmglist.get(0).getSiteId();
			lmglist.stream().forEach(entity ->{
				AuditTotalVO tempAuditTotal = new AuditTotalVO();
				//插入稽核list		
				tempAuditTotal.setOrderNo(entity.getId()+"");
				tempAuditTotal.setUsername(entity.getUsername());
				tempAuditTotal.setLiveId(PlatFormEnum.LMG.getValue());
				tempAuditTotal.setType(PlatformTypeEnum.LIVE.getValue());
				tempAuditTotal.setBetAmount(entity.getStakeAmount());
				tempAuditTotal.setValidAmount(entity.getValidStake());
				tempAuditTotal.setPayAmount(entity.getWinLoss());
				tempAuditTotal.setBetTime(entity.getEndTime());
				tempAuditTotal.setGameName(AuditGameNameEnum.LMG_LIVE.toString());
				auditList.add(tempAuditTotal);
//				tempAuditTotalMapper.insertOrupdate(tempAuditTotal, entity.getSiteId());
			});
			tempAuditTotalMapper.batInsertOrupdate(auditList, siteId);
		
	}
	


	
}
