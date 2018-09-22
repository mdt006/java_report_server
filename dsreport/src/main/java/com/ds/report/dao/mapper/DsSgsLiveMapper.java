package com.ds.report.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportDetail;
import com.ds.report.entity.DsSgsLive;
import com.ds.report.entity.DsSgsLiveExample;

public interface DsSgsLiveMapper {
    long countByExample(DsSgsLiveExample example);

    int deleteByExample(DsSgsLiveExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DsSgsLive record);

    int insertSelective(DsSgsLive record);

    List<DsSgsLive> selectByExample(DsSgsLiveExample example);

    DsSgsLive selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DsSgsLive record, @Param("example") DsSgsLiveExample example);

    int updateByExample(@Param("record") DsSgsLive record, @Param("example") DsSgsLiveExample example);

    int updateByPrimaryKeySelective(DsSgsLive record);

    int updateByPrimaryKey(DsSgsLive record);
    
    //查询明细总条数、总投注金额、总有效金额及总输赢金额
    DsReportDetail queryTotal(DsSgsLiveExample example);
    
	List<DsReport> queryTotalGroupGameType(DsSgsLiveExample example);

    /** 按天统计 */
	List<DsReport> queryBetTotalByDayNew(DsSgsLiveExample example);

	List<DsReportDetail> queryDetail(DsSgsLiveExample example);
    
}