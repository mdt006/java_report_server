package com.ds.report.entity.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportDetail;
import com.ds.report.entity.DtPtGame;
import com.ds.report.entity.DtPtGameExample;

public interface DtPtGameMapper {
    long countByExample(DtPtGameExample example);

    int deleteByExample(DtPtGameExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DtPtGame record);

    int insertSelective(DtPtGame record);

    List<DtPtGame> selectByExample(DtPtGameExample example);

    DtPtGame selectByPrimaryKey(Long id);
    
    DtPtGame selectByGameCode(@Param("gameCode")String gameCode);

    int updateByExampleSelective(@Param("record") DtPtGame record, @Param("example") DtPtGameExample example);

    int updateByExample(@Param("record") DtPtGame record, @Param("example") DtPtGameExample example);

    int updateByPrimaryKeySelective(DtPtGame record);

    int updateByPrimaryKey(DtPtGame record);
    
    //查询明细总条数、总投注金额、总有效金额及总输赢金额
    DsReportDetail queryTotal(DtPtGameExample example);
    
	List<DsReport> queryTotalGroupGameType(DtPtGameExample example);

    /** 按天统计 */
	List<DsReport> queryBetTotalByDayNew(DtPtGameExample example);

	List<DsReportDetail> queryDetail(DtPtGameExample m_example);
}