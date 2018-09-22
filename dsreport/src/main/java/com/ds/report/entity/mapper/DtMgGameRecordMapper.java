package com.ds.report.entity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportDetail;
import com.ds.report.entity.DtMgGameRecord;
import com.ds.report.entity.DtMgGameRecordExample;

public interface DtMgGameRecordMapper {
    long countByExample(DtMgGameRecordExample example);

    int deleteByExample(DtMgGameRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DtMgGameRecord record);

    int insertSelective(DtMgGameRecord record);

    List<DtMgGameRecord> selectByExample(DtMgGameRecordExample example);

    DtMgGameRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DtMgGameRecord record, @Param("example") DtMgGameRecordExample example);

    int updateByExample(@Param("record") DtMgGameRecord record, @Param("example") DtMgGameRecordExample example);

    int updateByPrimaryKeySelective(DtMgGameRecord record);

    int updateByPrimaryKey(DtMgGameRecord record);
    
  //查询明细总条数、总投注金额、总有效金额及总输赢金额
    DsReportDetail queryTotal(DtMgGameRecordExample example);
    	
    List<DsReport> queryTotalGroupGameType(DtMgGameRecordExample example);

    /** 按天统计 */
  	List<DsReport> queryBetTotalByDayNew(DtMgGameRecordExample example);

  	List<DsReportDetail> queryDetail(DtMgGameRecordExample m_example);
}