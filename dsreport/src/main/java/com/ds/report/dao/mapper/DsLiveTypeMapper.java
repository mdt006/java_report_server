package com.ds.report.dao.mapper;

import com.ds.report.entity.DsLiveType;
import com.ds.report.entity.DsLiveTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsLiveTypeMapper {
    int countByExample(DsLiveTypeExample example);

    int deleteByExample(DsLiveTypeExample example);

    int deleteByPrimaryKey(Byte id);

    int insert(DsLiveType record);

    int insertSelective(DsLiveType record);

    List<DsLiveType> selectByExample(DsLiveTypeExample example);

    DsLiveType selectByPrimaryKey(Byte id);

    int updateByExampleSelective(@Param("record") DsLiveType record, @Param("example") DsLiveTypeExample example);

    int updateByExample(@Param("record") DsLiveType record, @Param("example") DsLiveTypeExample example);

    int updateByPrimaryKeySelective(DsLiveType record);

    int updateByPrimaryKey(DsLiveType record);
}