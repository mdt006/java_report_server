package com.ds.report.dao.mapper;

import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportDetail;
import com.ds.report.entity.DsBbinLive;
import com.ds.report.entity.DsBbinLiveExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DsBbinLiveMapper {
    int countByExample(DsBbinLiveExample example);

    int deleteByExample(DsBbinLiveExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DsBbinLive record);

    int insertSelective(DsBbinLive record);

    List<DsBbinLive> selectByExample(DsBbinLiveExample example);

    DsBbinLive selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DsBbinLive record, @Param("example") DsBbinLiveExample example);

    int updateByExample(@Param("record") DsBbinLive record, @Param("example") DsBbinLiveExample example);

    int updateByPrimaryKeySelective(DsBbinLive record);

    int updateByPrimaryKey(DsBbinLive record);
    
    //查询明细总条数、总投注金额、总有效金额及总输赢金额
    DsReportDetail queryTotal(DsBbinLiveExample example);
    List<DsReportDetail> queryDetail(DsBbinLiveExample example);

	List<DsReport> queryTotalGroupGameType(DsBbinLiveExample example);

	/** 按天统计 */
	List<DsReport> queryBetTotalByDayNew(DsBbinLiveExample example);
}