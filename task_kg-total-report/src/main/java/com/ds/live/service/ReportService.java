package com.ds.live.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.onetwo.common.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.live.dao.ReportDao;
import com.ds.live.vo.TotalReportVo;
import com.kg.live.entity.DsReportEntity;
import com.kg.live.entity.TotalReportConfigExample;
import com.kg.live.entity.TotalReportConfigWithBLOBs;
import com.kg.live.mapper.DsReportEntityMapper;
import com.kg.live.mapper.TotalReportConfigMapper;

@Service
public class ReportService {
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private TotalReportConfigMapper reportConfigMapper;
	@Autowired
	private DsReportEntityMapper reportMapper;
	@Autowired
	private ReportDao reportDao;

	public List<TotalReportConfigWithBLOBs> getConfigList(Short state) {
		TotalReportConfigExample e = new TotalReportConfigExample();
		e.createCriteria().andStateEqualTo(state.intValue());
		return reportConfigMapper.selectByExampleWithBLOBs(e);
	}

	public void exeNotTotalReport(String selectReportSql) {
		for (int i = 0; i < 3; i++) {
			exeTotalReportByDay(selectReportSql, DateUtil.addDay(new Date(), -i));
		}
	}

	private void exeTotalReportByDay(String selectReportSql, Date date) {
		String dStr = DateUtil.formatDateByPattern(date, "yyyy-MM-dd");
		String forReportSql = StringUtils.replace(selectReportSql, "?", dStr);
		// 获取到为统计到的或者统计错的注单
		List<TotalReportVo> notTotalreportList = reportDao.getBetList(forReportSql);
		updateTotalReport(notTotalreportList);
	}

	private void updateTotalReport(List<TotalReportVo> notTotalreportList) {
		for (TotalReportVo totalReportVo : notTotalreportList) {
			if (setReportEntity(totalReportVo) == 0) {
				addReportEntity(totalReportVo);
			}
		}
	}

	private int setReportEntity(TotalReportVo totalReportVo) {
		return reportDao.updateReportEntity(totalReportVo);
	}

	private void addReportEntity(TotalReportVo totalReportVo) {
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
		reportMapper.insert(report);
	}

	/**
	 * 一些最新的电子游戏未来得及添加到ds_game_type表 导致统计不准确，故先添加到此表，然后进行统计
	 * 
	 * @param gameTypeSql
	 */
	public void insertGameType(String gameTypeSql) {
		if (StringUtils.isBlank(gameTypeSql)) {
			return;
		}
		logger.info("插入gameType表:" + gameTypeSql);
		reportDao.insertGameType(gameTypeSql);
	}

	/**
	 * @describe 验证取消被统计的注单,并将其删除(report表中) 针对蛮牛--某会员某一天某种游戏,因取消注单,而无任何有效投注
	 */
	public void verifyManniu() {
		for(int i=0;i<3;i++){
			String strDate = new SimpleDateFormat("yyyy-MM-dd").format(DateUtil.addDay(new Date(), -i));
			List<Integer> idList = reportDao.selectExistManniuIdByDate(strDate);
			logger.info(strDate+"idList------->"+idList);
			if (idList != null) {
				for (Integer id : idList) {
					reportDao.deleteReportById(id);
				}
				logger.info(strDate+"蛮牛统计删除完成！");
			}
			logger.info(strDate+"蛮牛验证成功,没有需要删除的report记录!");
		}
		
		
		
	}
	
}