package com.ds.report.dao.mapper;

import com.ds.report.entity.DsBbinJilv;
import com.ds.report.entity.DsBbinJilvExample;
import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportDetail;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DsBbinJilvMapper {
    int countByExample(DsBbinJilvExample example);

    int deleteByExample(DsBbinJilvExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DsBbinJilv record);

    int insertSelective(DsBbinJilv record);

    List<DsBbinJilv> selectByExample(DsBbinJilvExample example);

    DsBbinJilv selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DsBbinJilv record, @Param("example") DsBbinJilvExample example);

    int updateByExample(@Param("record") DsBbinJilv record, @Param("example") DsBbinJilvExample example);

    int updateByPrimaryKeySelective(DsBbinJilv record);

    int updateByPrimaryKey(DsBbinJilv record);
    
  //查询明细总条数、总投注金额、总有效金额及总输赢金额
    DsReportDetail queryTotal(DsBbinJilvExample example);
    List<DsReportDetail> queryDetail(DsBbinJilvExample example);

	List<DsReport> queryTotalGroupGameType(DsBbinJilvExample example);

	/** 按天统计 */
	List<DsReport> queryBetTotalByDayNew(DsBbinJilvExample example);
}