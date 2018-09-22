package com.ds.report.dao.mapper;

import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportDetail;
import com.ds.report.entity.DsLive;
import com.ds.report.entity.DsLiveExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DsLiveMapper {
    int countByExample(DsLiveExample example);

    int deleteByExample(DsLiveExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DsLive record);

    int insertSelective(DsLive record);

    List<DsLive> selectByExample(DsLiveExample example);

    DsLive selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DsLive record, @Param("example") DsLiveExample example);

    int updateByExample(@Param("record") DsLive record, @Param("example") DsLiveExample example);

    int updateByPrimaryKeySelective(DsLive record);

    int updateByPrimaryKey(DsLive record);
    
    //查询明细总条数、总投注金额、总有效金额及总输赢金额
    DsReportDetail queryTotal(DsLiveExample example);
    List<DsReportDetail> queryDetail(DsLiveExample example);

	List<DsReport> queryTotalGroupGameType(DsLiveExample example);

	List<DsReport> queryBetTotalByDayNew(DsLiveExample example);

}