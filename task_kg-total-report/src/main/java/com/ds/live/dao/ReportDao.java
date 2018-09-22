package com.ds.live.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ds.live.vo.TotalReportVo;
import com.ds.live.vo.ValidateReportVo;
import com.ds.temp.entity.TempAuditTotal;
import com.kg.live.entity.DsReportEntity;
import com.kg.live.entity.DsReportSiteDay;

public interface ReportDao {

	List<TotalReportVo> getBetList(@Param("selectReportSql")String selectReportSql);

	void insertTempTable(@Param("insertTempSql")String insertTempSql, @Param("list")List<TotalReportVo> reportVoList);

	List<TempAuditTotal> getAuditBetList(@Param("selectReportSql")String selectReportSql);

	void insertTempAuditLog(@Param("insertTempSql")String insertTempSql, @Param("list")List<TempAuditTotal> auditTotalList);

	ValidateReportVo getVailidateReport(@Param("forReportSql")String forReportSql);

	ValidateReportVo getVailidateDetailReport(@Param("fmtDetailSql")String fmtDetailSql);

	void deleteReportSql(@Param("delReportSql")String delReportSql);

	void delTempSql(@Param("fmtDelTempSql")String fmtDelTempSql);

	int updateReportEntity(@Param("totalReportVo")TotalReportVo totalReportVo);

	void insertGameType(@Param("gameTypeSql")String gameTypeSql);
	
	List<Integer> selectExistManniuIdByDate(@Param("strDate") String strDate);
	
	void deleteReportById(@Param("id") Integer id);

	void insertAgHunterReport(DsReportEntity reportEntity);

	void updateAgHunterReport(DsReportEntity reportEntity);
	
	List<DsReportSiteDay> getSiteReportByDay(@Param("strDate") String strDate);
	
	List<DsReportSiteDay> getValidReportByDays(@Param("strDate") String strDate);
	
	void insertOrUpdateReportSiteDay(List<DsReportSiteDay> list);
	
}
