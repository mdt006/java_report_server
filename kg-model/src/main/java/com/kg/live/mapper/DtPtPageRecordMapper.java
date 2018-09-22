package com.kg.live.mapper;

import com.kg.live.entity.DtPtPageRecord;
import com.kg.live.entity.DtPtPageRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DtPtPageRecordMapper {
    long countByExample(DtPtPageRecordExample example);

    int deleteByExample(DtPtPageRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DtPtPageRecord record);

    int insertSelective(DtPtPageRecord record);

    List<DtPtPageRecord> selectByExample(DtPtPageRecordExample example);

    DtPtPageRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DtPtPageRecord record, @Param("example") DtPtPageRecordExample example);

    int updateByExample(@Param("record") DtPtPageRecord record, @Param("example") DtPtPageRecordExample example);

    int updateByPrimaryKeySelective(DtPtPageRecord record);
    
    int updateByPrimaryKey(DtPtPageRecord record);
    //根据代理和日期更新页数记录
    int updateByAgentAndDate(DtPtPageRecord record);

}