package com.ds.report.dao.mapper;

import com.ds.report.entity.DsGameType;
import com.ds.report.entity.DsGameTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsGameTypeMapper {
    int countByExample(DsGameTypeExample example);

    int deleteByExample(DsGameTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DsGameType record);

    int insertSelective(DsGameType record);

    List<DsGameType> selectByExample(DsGameTypeExample example);

    DsGameType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DsGameType record, @Param("example") DsGameTypeExample example);

    int updateByExample(@Param("record") DsGameType record, @Param("example") DsGameTypeExample example);

    int updateByPrimaryKeySelective(DsGameType record);

    int updateByPrimaryKey(DsGameType record);
    
    List<DsGameType> selectByParentId(Integer parentId);
}