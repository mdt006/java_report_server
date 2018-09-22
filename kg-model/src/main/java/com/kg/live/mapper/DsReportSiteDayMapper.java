package com.kg.live.mapper;

import com.kg.live.entity.DsReportSiteDay;
import com.kg.live.entity.DsReportSiteDayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsReportSiteDayMapper {
    long countByExample(DsReportSiteDayExample example);

    int deleteByExample(DsReportSiteDayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DsReportSiteDay record);

    int insertSelective(DsReportSiteDay record);

    List<DsReportSiteDay> selectByExample(DsReportSiteDayExample example);

    DsReportSiteDay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DsReportSiteDay record, @Param("example") DsReportSiteDayExample example);

    int updateByExample(@Param("record") DsReportSiteDay record, @Param("example") DsReportSiteDayExample example);

    int updateByPrimaryKeySelective(DsReportSiteDay record);

    int updateByPrimaryKey(DsReportSiteDay record);
}