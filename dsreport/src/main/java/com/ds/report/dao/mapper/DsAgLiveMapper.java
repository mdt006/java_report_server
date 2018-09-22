package com.ds.report.dao.mapper;

import com.ds.report.entity.DsAgLive;
import com.ds.report.entity.DsAgLiveExample;
import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportDetail;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DsAgLiveMapper {
    int countByExample(DsAgLiveExample example);

    int deleteByExample(DsAgLiveExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DsAgLive record);

    int insertSelective(DsAgLive record);

    List<DsAgLive> selectByExample(DsAgLiveExample example);

    DsAgLive selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DsAgLive record, @Param("example") DsAgLiveExample example);

    int updateByExample(@Param("record") DsAgLive record, @Param("example") DsAgLiveExample example);

    int updateByPrimaryKeySelective(DsAgLive record);

    int updateByPrimaryKey(DsAgLive record);
    
  //查询明细总条数、总投注金额、总有效金额及总输赢金额
    DsReportDetail queryTotal(DsAgLiveExample example);
    List<DsReportDetail> queryDetail(DsAgLiveExample example);

	List<DsReport> queryTotalGroupGameType(DsAgLiveExample example);

	/** 按天统计 */
	List<DsReport> queryBetTotalByDayNew(DsAgLiveExample example);
}