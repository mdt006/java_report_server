package com.ds.lottery.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ds.lottery.vo.GameTypeVo;
import com.ds.lottery.vo.TotalReportVo;
import com.kg.live.entity.DsJingdianEntity;
import com.kg.live.entity.DsReportEntity;

public interface DsLotteryDao {
	/**
	 * 获取最大Id
	 */
	Long getMaxDsLotteryId(@Param(value = "siteId") Integer siteId);

	/**
	 * 
	 * @param date
	 * @param siteId
	 * @describe 获取这一天的最小Id
	 */
	Long getMinDsLotteryIdBySiteIdAndDate(@Param(value = "date") String date, @Param(value = "siteId") Integer siteId);

	/**
	 * 
	 * @param date
	 * @param siteId
	 * @describe 获取这一天的最大Id
	 */
	Long getMaxDsLotteryIdBySiteIdAndDate(@Param(value = "date") String date, @Param(value = "siteId") Integer siteId);

	/**
	 * 
	 * @param date
	 * @param siteId
	 * @describe 获取从beginid开始,1000条后的最大ID
	 */
	Long getTempMaxIdByIdAndSiteId(@Param(value = "siteId") Integer siteId, @Param(value = "beginId") Long beginId);

	List<DsReportEntity> selectReport(@Param(value = "siteId")Integer siteId, @Param(value = "user")String user,
			@Param(value = "gameType")int gameType, @Param(value = "betDate")Date betDate);
	int insertDsReport(DsReportEntity record);
	int updateReportByPrimaryKey(DsReportEntity reportEntity);

	List<TotalReportVo> getDifferentList(@Param(value = "siteId")int siteId, @Param(value = "dateStr")  String dateStr,@Param("liveName") String liveName);

	int updateReportEntity(@Param("totalReportVo")TotalReportVo totalReportVo);

	List<GameTypeVo> getGameTypeList(@Param("liveId")int liveId, @Param("gameKinds")List<Integer> gameKinds);
	
	//批量插入存在即更新 ds_jingdian_lottery
	void addJD(List<DsJingdianEntity> jingdianList);
	
	//批量插入 ds_report
	void addReport(List<DsReportEntity> reportList);
	
	//批量更新 ds_report
	void updateReport(DsReportEntity reportList);
	
}
