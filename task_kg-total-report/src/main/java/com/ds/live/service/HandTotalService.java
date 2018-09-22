package com.ds.live.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ds.live.dao.ReportDao;
import com.ds.live.vo.TotalReportVo;
import com.ds.live.vo.ValidateReportVo;
import com.kg.live.entity.DsReportEntity;
import com.kg.live.entity.DsReportEntityExample;
import com.kg.live.entity.TotalReportConfigWithBLOBs;
import com.kg.live.mapper.DsReportEntityMapper;

@Service
public class HandTotalService {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private ReportDao reportDao;
	@Resource
	private DsReportEntityMapper reportMapper;
	@Resource
	private ReportService reportService;

	public String startHandTotal(String date, int gameType, short state) {
		logger.info("手动统计程序开始:date---" + date + "--gameType--" + gameType);
		TotalReportConfigWithBLOBs totalConfig = null;
		List<TotalReportConfigWithBLOBs> apiList = reportService.getConfigList(state);
		for (int i = 0; i < apiList.size(); i++) {
			logger.info("apiList.get(i).getId()---i:" + i + "---Id:" + apiList.get(i).getId());
			if (apiList.get(i).getId() == gameType) {
				totalConfig = apiList.get(i);
			}
		}
		if (totalConfig == null) {
			return "gameType在列表中找不到,请确认";
		}
		String reportSql = StringUtils.replace(totalConfig.getValidateReportSelectSql(), "?", date);
		String detailSql = StringUtils.replace(totalConfig.getVaildateDetailTableSelectSql(), "?", date);
		String betListSql = StringUtils.replace(totalConfig.getSelectBetTableSql(), "?", date);
		// 开始统计数据
		ValidateReportVo reportVo = reportDao.getVailidateReport(reportSql);
		ValidateReportVo reportVo2 = reportDao.getVailidateDetailReport(detailSql);
		List<TotalReportVo> totalReportList = null;
		logger.info(reportVo2+">>>>>>"+reportVo);
		if (reportVo2 != null && !reportVo2.validate(reportVo)) {
			delete(date, totalConfig);
			logger.info(totalConfig.getMemo() + "核对日期：" + date + "结果不一致，删除数据完成");
			totalReportList = reportDao.getBetList(betListSql);
			//加下日志
			//插入到临时表
			String insertTempSql =  totalConfig.getInsertTempSql();
			if(!StringUtils.isEmpty(insertTempSql)){
				reportDao.insertTempTable(insertTempSql,totalReportList);
				logger.info("插入temp中数量："+totalReportList.size());
			}
			
			for (TotalReportVo totalReportVo : totalReportList) {
				addReportEntity(totalReportVo);
			}
			return "结果不一致,已经重新统计完成--->"+totalReportList.size();
		}else if(null==reportVo && null==reportVo2){//临时表与dsreport都清空的情况
			totalReportList = reportDao.getBetList(betListSql);
			//插入到临时表
			String insertTempSql =  totalConfig.getInsertTempSql();
			if(!StringUtils.isEmpty(insertTempSql)){
				reportDao.insertTempTable(insertTempSql,totalReportList);
				logger.info("插入temp中数量："+totalReportList.size());
			}
			for (TotalReportVo totalReportVo : totalReportList) {
				addReportEntity(totalReportVo);
			}
			return "结果不一致,数据清除重新统计完成--->"+totalReportList.size();
		}else {
			logger.info(totalConfig.getMemo() + "核对日期：" + date + "结果一致");
			return "结果一致,无需重新统计----->count:"+reportVo.getCount();
		}
			
	}

	private void delete(String dStr, TotalReportConfigWithBLOBs reportConfig) {
		String delReportSelectSql = reportConfig.getDeleteReportSql();
		String delReportSql = StringUtils.replace(delReportSelectSql, "?", dStr);
		reportDao.deleteReportSql(delReportSql);
		
		String delTempSql = reportConfig.getDeleteTempTableSql();
		String fmtDelTempSql = StringUtils.replace(delTempSql, "?", dStr);
		if(!StringUtils.isEmpty(delTempSql)){
			reportDao.delTempSql(fmtDelTempSql);
		}
	}


	private void addReportEntity(TotalReportVo totalReportVo) {
		
		DsReportEntity reportEntity = getReportEntity(totalReportVo.getSiteId(), 
				totalReportVo.getUsername(), totalReportVo.getBetTime(), totalReportVo.getGameType(), totalReportVo.getLiveId(),totalReportVo.getGameKind());
		
		if(reportEntity == null){
			reportEntity = new DsReportEntity();
			reportEntity.setBetamount(totalReportVo.getBetAmount());
			reportEntity.setBetCount(totalReportVo.getCount());
			reportEntity.setBetTime(totalReportVo.getBetTime());
			reportEntity.setGameKind(totalReportVo.getGameKind());
			reportEntity.setGameKindName(totalReportVo.getGameKindName());
			reportEntity.setGameType(totalReportVo.getGameType());
			reportEntity.setGameName(totalReportVo.getGameName());
			reportEntity.setLiveId(totalReportVo.getLiveId().byteValue());
			reportEntity.setLiveName(totalReportVo.getLiveName());
			reportEntity.setSiteId(totalReportVo.getSiteId());
			reportEntity.setUsername(totalReportVo.getUsername());
			reportEntity.setValidamount(totalReportVo.getValidAmount());
			reportEntity.setWinlose(totalReportVo.getWinLossAmount());
			reportMapper.insert(reportEntity);
		}else{
			reportEntity.setBetamount(totalReportVo.getBetAmount().add(reportEntity.getBetamount()));
			reportEntity.setBetCount(totalReportVo.getCount());
			reportEntity.setValidamount(reportEntity.getValidamount().add(totalReportVo.getValidAmount()));
			reportEntity.setWinlose(reportEntity.getWinlose().add(totalReportVo.getWinLossAmount()));
			reportMapper.updateByPrimaryKey(reportEntity);
		}
		
	
	}
	public DsReportEntity getReportEntity(Integer siteId,String username,Date betTime,Integer gameType,Integer liveId,Integer gameKind){
		DsReportEntityExample e = new DsReportEntityExample();
		e.createCriteria().andSiteIdEqualTo(siteId).andUsernameEqualTo(username).andGameKindEqualTo(gameKind)
			.andGameTypeEqualTo(gameType).andLiveIdEqualTo(liveId.byteValue()).andBetTimeEqualTo(betTime);
		List<DsReportEntity> list = reportMapper.selectByExample(e);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
}