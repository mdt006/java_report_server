package com.ds.live.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.onetwo.common.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ds.live.dao.ReportDao;
import com.ds.live.vo.TotalReportVo;
import com.ds.live.vo.ValidateReportVo;
import com.kg.live.entity.DsReportEntity;
import com.kg.live.entity.DsReportEntityExample;
import com.kg.live.entity.TotalReportConfig;
import com.kg.live.entity.TotalReportConfigWithBLOBs;
import com.kg.live.mapper.DsReportEntityMapper;

/**
 * 
*    
* 项目名称：
* 类名称：
* 类描述：   
* 创建人：光光   
* 创建时间：2015年5月10日 下午7:47:48   
* 修改人：光光   
* 修改时间：2015年5月10日 下午7:47:48   
* 修改备注：   
* @version    
*
 */
@Service
public class DsLiveServiceImp {
	final static Logger logger = Logger.getLogger(DsLiveServiceImp.class);
	
	@Autowired
	private ReportDao reportDao;
	@Autowired
	private DsReportEntityMapper reportMapper;
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor = {RuntimeException.class, Exception.class})
	public Integer getBet(String selectReportSql, String insertTempSql,String memo) {
			List<TotalReportVo> reportVoList = reportDao.getBetList(selectReportSql);
			if(reportVoList == null || reportVoList.size() == 0){
				logger.info(memo+"此次统计已进行完，亲爱的，休息下吧......");
				return 0;
			}
			//加下日志
			//插入到临时表
			reportDao.insertTempTable(insertTempSql,reportVoList);
			//插入到report表
			for (TotalReportVo totalReportVo : reportVoList) {
				
				DsReportEntity reportEntity = getReportEntity(totalReportVo.getSiteId(), 
						totalReportVo.getUsername(), totalReportVo.getBetTime(), totalReportVo.getGameType(), totalReportVo.getLiveId(),totalReportVo.getGameKind());
				
				if(reportEntity == null){
					reportEntity = new DsReportEntity();
					reportEntity.setBetamount(totalReportVo.getBetAmount());
					reportEntity.setBetCount(1);
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
					reportEntity.setBetCount(reportEntity.getBetCount()+1);
					reportEntity.setValidamount(reportEntity.getValidamount().add(totalReportVo.getValidAmount()));
					reportEntity.setWinlose(reportEntity.getWinlose().add(totalReportVo.getWinLossAmount()));
					reportMapper.updateByPrimaryKey(reportEntity);
				}
						
			}
			
//			if(reportVoList.size() < 500){
//				logger.info(memo+"此次统计了："+reportVoList.size()+",休息下吧......");
//				return reportVoList.size();
//			}
			
			return reportVoList.size();
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
	

	public ReportDao getReportDao() {
		return reportDao;
	}
	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}

	public void validateBetReport(TotalReportConfig reportConfig) {
		
		
	}
	
	public Date validateBetReport(TotalReportConfigWithBLOBs reportConfig, Date dateFlag) {
		if(dateFlag == null){
			return new Date();
		}
		long lastVaildate = dateFlag.getTime();
		long now = System.currentTimeMillis();
		if((now - lastVaildate)<1000*60*60){//小于一个小时就不统计
			logger.info("时间还早,我先休息会再去核对");
			return dateFlag;
		}
		logger.info("正式进入核对.....");
		Date d = new Date();//验证日期
		//开始验证数据，验证今天和昨天
		for (int i = 0; i < 2; i++) {
			validate(DateUtil.addDay(d, -i), reportConfig);
		}
		return d;
	}
	
	/**
	 * 
	 * @param d
	 * @param reportConfig
	 */
	private void validate(Date d,TotalReportConfigWithBLOBs reportConfig){
		String dStr = DateUtil.formatDateByPattern(d, "yyyy-MM-dd");
		String validateReportSelectSql = reportConfig.getValidateReportSelectSql();
		if(StringUtils.isBlank(validateReportSelectSql)){
			return;
		}
		
		String forReportSql = StringUtils.replace(validateReportSelectSql, "?", dStr);
		String detailSql = reportConfig.getVaildateDetailTableSelectSql();
		String fmtDetailSql = StringUtils.replace(detailSql, "?", dStr);
		//开始统计数据
		ValidateReportVo reportVo = reportDao.getVailidateReport(forReportSql);
		ValidateReportVo reportVo2 = reportDao.getVailidateDetailReport(fmtDetailSql);
		if(reportVo2 != null && !reportVo2.validate(reportVo)){
			logger.info(reportConfig.getMemo()+"核对日期："+dStr+"结果不一致，准备删除数据重新统计");
			delete(dStr, reportConfig);
			logger.info(reportConfig.getMemo()+"核对日期："+dStr+"结果不一致，删除数据完成");
		}else{
			logger.info(reportConfig.getMemo()+"核对日期："+dStr+"结果一致");
		}
	}
	private void delete(String dStr,TotalReportConfigWithBLOBs reportConfig){
		String delReportSelectSql = reportConfig.getDeleteReportSql();
		String delReportSql = StringUtils.replace(delReportSelectSql, "?", dStr);
		reportDao.deleteReportSql(delReportSql);
		
		String delTempSql = reportConfig.getDeleteTempTableSql();
		String fmtDelTempSql = StringUtils.replace(delTempSql, "?", dStr);
		reportDao.delTempSql(fmtDelTempSql);
		
		
	}
	
	
}
