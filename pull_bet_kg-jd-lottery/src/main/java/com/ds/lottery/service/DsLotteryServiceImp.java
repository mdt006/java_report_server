package com.ds.lottery.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.onetwo.common.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.lottery.common.BaseCommon;
import com.ds.lottery.dao.DsLotteryDao;
import com.ds.lottery.until.DSLotteryConfig;
import com.ds.lottery.vo.GameTypeVo;
import com.ds.lottery.vo.TotalReportVo;
import com.ds.temp.mapper.TempAuditTotalMapper;
import com.kg.live.entity.DsReportEntity;
import com.kg.live.entity.LotteryInfoEntity;
import com.kg.live.entity.LotteryInfoEntityExample;
import com.kg.live.mapper.DsJingdianEntityMapper;
import com.kg.live.mapper.LotteryInfoEntityMapper;

@Service
public class DsLotteryServiceImp {
	private final static Logger logger = LoggerFactory.getLogger(DsLotteryServiceImp.class);
	
	@Autowired
	private DsLotteryDao lotteryDao;
	
	@Autowired
	private LotteryInfoEntityMapper lotteryMapper;
	
	@Autowired
	private DsJingdianEntityMapper jingdianMapper;
	
	@Autowired
	private TempAuditTotalMapper tempAuditTotalMapper;
	
	private List<LotteryInfoEntity> lotteryInfoList;
	
	
	//已经停止运行的线程数量
	public static AtomicInteger stopCount = new AtomicInteger(); 
	
	//统计网站的数量
	private static Integer listSize=0;
	/**
	 * 校验ds_report和ds_jingdian_lottery不同的注单
	 * 如果有不同的，则更新ds_report表
	 * @param siteId
	 * @param date
	 */
	public void validateTotalReport(int siteId, Date date) {
		String dateStr = DateUtil.formatDateByPattern(date, "yyyy-MM-dd");
		List<TotalReportVo> differentList = lotteryDao.getDifferentList(siteId,dateStr,BaseCommon.KIND_NAME_DSPT);
		updateTotalReport(differentList);
	}
	private void updateTotalReport(List<TotalReportVo> notTotalreportList){
		for (TotalReportVo totalReportVo : notTotalreportList) {
			if(setReportEntity(totalReportVo) == 0){
				addReportEntity(totalReportVo);
			}
		}
	}
	private int setReportEntity(TotalReportVo totalReportVo){
		return lotteryDao.updateReportEntity(totalReportVo);
	}
	private void addReportEntity(TotalReportVo totalReportVo){
		DsReportEntity report = new DsReportEntity();
		report.setSiteId(totalReportVo.getSiteId());
		report.setUsername(totalReportVo.getUsername());
		report.setBetCount(totalReportVo.getCount());
		report.setBetamount(totalReportVo.getBetAmount());
		report.setBetTime(totalReportVo.getBetTime());
		report.setValidamount(totalReportVo.getValidAmount());
		report.setWinlose(totalReportVo.getWinLossAmount());
		report.setLiveId(totalReportVo.getLiveId().byteValue());
		report.setLiveName(totalReportVo.getLiveName());
		report.setGameKind(totalReportVo.getGameKind());
		report.setGameKindName(totalReportVo.getGameKindName());
		report.setGameName(totalReportVo.getGameName());
		report.setGameType(totalReportVo.getGameType());
		lotteryDao.insertDsReport(report);
	}
	
	
	public void initLotteryInfo(){
		LotteryInfoEntityExample e = new LotteryInfoEntityExample();
		e.createCriteria().andStateEqualTo(DSLotteryConfig.NORMAL_STATE);
		lotteryInfoList = lotteryMapper.selectByExample(e);
		listSize = lotteryInfoList == null?0:lotteryInfoList.size();
		logger.info("listSize size={}",listSize);
	
	}
	/**
	 * 获取数据库最新配置
	 * @return
	 */
	public List<LotteryInfoEntity> getDbLotteryInfoList(){
		LotteryInfoEntityExample e = new LotteryInfoEntityExample();
		e.createCriteria().andStateEqualTo(DSLotteryConfig.NORMAL_STATE);
		return lotteryMapper.selectByExample(e);
		
	}
	
	
	public List<LotteryInfoEntity> getLotteryInfoList() {
		return lotteryInfoList;
	}
	public void setLotteryInfoList(List<LotteryInfoEntity> lotteryInfoList) {
		this.lotteryInfoList = lotteryInfoList;
	}


	public DsLotteryDao getLotteryDao() {
		return lotteryDao;
	}


	public void setLotteryDao(DsLotteryDao lotteryDao) {
		this.lotteryDao = lotteryDao;
	}


	public DsJingdianEntityMapper getJingdianMapper() {
		return jingdianMapper;
	}


	public void setJingdianMapper(DsJingdianEntityMapper jingdianMapper) {
		this.jingdianMapper = jingdianMapper;
	}


	public TempAuditTotalMapper getTempAuditTotalMapper() {
		return tempAuditTotalMapper;
	}


	public void setTempAuditTotalMapper(TempAuditTotalMapper tempAuditTotalMapper) {
		this.tempAuditTotalMapper = tempAuditTotalMapper;
	}
	/**
	 * 根据liveId和gameKind获取到gameKind的所有游戏
	 * @param liveId
	 * @param gameKind
	 * @return
	 */
	public Map<String, GameTypeVo> getGameType(int liveId, List<Integer> gameKinds) {
		Map<String, GameTypeVo> map = new HashMap<String, GameTypeVo>();
		List<GameTypeVo> gameVoList = lotteryDao.getGameTypeList(liveId,gameKinds);
		for (GameTypeVo gameTypeVo : gameVoList) {
			map.put(gameTypeVo.getOutGameCode(), gameTypeVo);
		}
		return map;
	}
}
