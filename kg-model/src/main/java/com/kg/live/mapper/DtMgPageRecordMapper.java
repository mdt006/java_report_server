package com.kg.live.mapper;

import com.kg.live.entity.DtMgPageRecord;
import com.kg.live.entity.DtMgPageRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DtMgPageRecordMapper {
    long countByExample(DtMgPageRecordExample example);

    int deleteByExample(DtMgPageRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DtMgPageRecord record);

    int insertSelective(DtMgPageRecord record);

    List<DtMgPageRecord> selectByExample(DtMgPageRecordExample example);

    DtMgPageRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DtMgPageRecord record, @Param("example") DtMgPageRecordExample example);

    int updateByExample(@Param("record") DtMgPageRecord record, @Param("example") DtMgPageRecordExample example);

    int updateByPrimaryKeySelective(DtMgPageRecord record);

    int updateByPrimaryKey(DtMgPageRecord record);
}