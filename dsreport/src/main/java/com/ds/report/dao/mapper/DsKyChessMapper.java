package com.ds.report.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ds.report.entity.DsKyChess;
import com.ds.report.entity.DsKyChessExample;
import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportDetail;

public interface DsKyChessMapper {
    long countByExample(DsKyChessExample example);

    int deleteByExample(DsKyChessExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DsKyChess record);

    int insertSelective(DsKyChess record);

    List<DsKyChess> selectByExample(DsKyChessExample example);

    DsKyChess selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DsKyChess record, @Param("example") DsKyChessExample example);

    int updateByExample(@Param("record") DsKyChess record, @Param("example") DsKyChessExample example);

    int updateByPrimaryKeySelective(DsKyChess record);

    int updateByPrimaryKey(DsKyChess record);
    
    //查询明细总条数、总投注金额、总有效金额及总输赢金额
    DsReportDetail queryTotal(DsKyChessExample example);
    
	List<DsReport> queryTotalGroupGameType(DsKyChessExample example);

    /** 按天统计 */
	List<DsReport> queryBetTotalByDayNew(DsKyChessExample example);

	List<DsReportDetail> queryDetail(DsKyChessExample m_example);
}