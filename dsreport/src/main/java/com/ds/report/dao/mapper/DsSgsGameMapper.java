package com.ds.report.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportDetail;
import com.ds.report.entity.DsSgsGame;
import com.ds.report.entity.DsSgsGameExample;

public interface DsSgsGameMapper {
    long countByExample(DsSgsGameExample example);

    int deleteByExample(DsSgsGameExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DsSgsGame record);

    int insertSelective(DsSgsGame record);

    List<DsSgsGame> selectByExample(DsSgsGameExample example);

    DsSgsGame selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DsSgsGame record, @Param("example") DsSgsGameExample example);

    int updateByExample(@Param("record") DsSgsGame record, @Param("example") DsSgsGameExample example);

    int updateByPrimaryKeySelective(DsSgsGame record);

    int updateByPrimaryKey(DsSgsGame record);
    
    //查询明细总条数、总投注金额、总有效金额及总输赢金额
    DsReportDetail queryTotal(DsSgsGameExample example);
    
	List<DsReport> queryTotalGroupGameType(DsSgsGameExample example);

    /** 按天统计 */
	List<DsReport> queryBetTotalByDayNew(DsSgsGameExample example);

	List<DsReportDetail> queryDetail(DsSgsGameExample example);
}