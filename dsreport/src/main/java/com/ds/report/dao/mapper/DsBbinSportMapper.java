package com.ds.report.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ds.report.entity.DsBbinSport;
import com.ds.report.entity.DsBbinSportExample;
import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportDetail;

public interface DsBbinSportMapper {
    int countByExample(DsBbinSportExample example);

    int deleteByExample(DsBbinSportExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DsBbinSport record);

    int insertSelective(DsBbinSport record);

    List<DsBbinSport> selectByExample(DsBbinSportExample example);

    DsBbinSport selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DsBbinSport record, @Param("example") DsBbinSportExample example);

    int updateByExample(@Param("record") DsBbinSport record, @Param("example") DsBbinSportExample example);

    int updateByPrimaryKeySelective(DsBbinSport record);

    int updateByPrimaryKey(DsBbinSport record);
    
    //查询明细总条数、总投注金额、总有效金额及总输赢金额
    DsReportDetail queryTotal(DsBbinSportExample example);
    List<DsReportDetail> queryDetail(DsBbinSportExample example);
    
    //根绝游戏类型去统计
    List<DsReport> queryTotalGroupGameType(DsBbinSportExample example);

    /** 按天统计 */
	List<DsReport> queryBetTotalByDayNew(DsBbinSportExample example);
}