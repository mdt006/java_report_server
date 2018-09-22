package com.kg.live.mapper;

import com.kg.live.entity.BbinLiveSportEntity;
import com.kg.live.entity.BbinLiveSportEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbinLiveSportEntityMapper {
    long countByExample(BbinLiveSportEntityExample example);

    int deleteByExample(BbinLiveSportEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BbinLiveSportEntity record);

    int insertSelective(BbinLiveSportEntity record);

    List<BbinLiveSportEntity> selectByExample(BbinLiveSportEntityExample example);

    BbinLiveSportEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BbinLiveSportEntity record, @Param("example") BbinLiveSportEntityExample example);

    int updateByExample(@Param("record") BbinLiveSportEntity record, @Param("example") BbinLiveSportEntityExample example);

    int updateByPrimaryKeySelective(BbinLiveSportEntity record);

    int updateByPrimaryKey(BbinLiveSportEntity record);
}