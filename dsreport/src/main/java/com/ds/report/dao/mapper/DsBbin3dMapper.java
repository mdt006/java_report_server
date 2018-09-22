package com.ds.report.dao.mapper;

import com.ds.report.entity.DsBbin3d;
import com.ds.report.entity.DsBbin3dExample;
import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportDetail;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DsBbin3dMapper {
    int countByExample(DsBbin3dExample example);

    int deleteByExample(DsBbin3dExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DsBbin3d record);

    int insertSelective(DsBbin3d record);

    List<DsBbin3d> selectByExample(DsBbin3dExample example);

    DsBbin3d selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DsBbin3d record, @Param("example") DsBbin3dExample example);

    int updateByExample(@Param("record") DsBbin3d record, @Param("example") DsBbin3dExample example);

    int updateByPrimaryKeySelective(DsBbin3d record);

    int updateByPrimaryKey(DsBbin3d record);
    
    //查询明细总条数、总投注金额、总有效金额及总输赢金额
    DsReportDetail queryTotal(DsBbin3dExample example);
    List<DsReportDetail> queryDetail(DsBbin3dExample example);

	List<DsReport> queryTotalGroupGameType(DsBbin3dExample example);

	/** 按天统计 */
	List<DsReport> queryBetTotalByDayNew(DsBbin3dExample example);
}