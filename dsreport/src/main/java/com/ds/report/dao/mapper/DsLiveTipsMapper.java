package com.ds.report.dao.mapper;

import com.ds.report.entity.DsLiveTips;
import com.ds.report.entity.DsLiveTipsExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsLiveTipsMapper {
    int countByExample(DsLiveTipsExample example);

    int deleteByExample(DsLiveTipsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DsLiveTips record);

    int insertSelective(DsLiveTips record);

    List<DsLiveTips> selectByExample(DsLiveTipsExample example);

    DsLiveTips selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DsLiveTips record, @Param("example") DsLiveTipsExample example);

    int updateByExample(@Param("record") DsLiveTips record, @Param("example") DsLiveTipsExample example);

    int updateByPrimaryKeySelective(DsLiveTips record);

    int updateByPrimaryKey(DsLiveTips record);
    
    DsLiveTips queryTotal(DsLiveTipsExample example);
    List<DsLiveTips> queryDetail(DsLiveTipsExample example);
    
}