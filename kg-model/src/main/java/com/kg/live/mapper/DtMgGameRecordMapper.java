package com.kg.live.mapper;

import com.kg.live.entity.DtMgGameRecord;
import com.kg.live.entity.DtMgGameRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
    
  //根据MgID查询记录
    DtMgGameRecord selectByMgId(@Param("mgId")String mgId);
    //根据mgID更新记录
    int updateByMgId(DtMgGameRecord record);
}