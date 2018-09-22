package com.kg.live.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.kg.live.entity.DsBbinLiveWeightEntity;
import com.kg.live.entity.DsBbinLiveWeightEntityExample;

public interface DsBbinLiveWeightMapper {
    int countByExample(DsBbinLiveWeightEntityExample example);

    int deleteByExample(DsBbinLiveWeightEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DsBbinLiveWeightEntity record);

    int insertSelective(DsBbinLiveWeightEntity record);

    List<DsBbinLiveWeightEntity> selectByExample(DsBbinLiveWeightEntityExample example);

    DsBbinLiveWeightEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DsBbinLiveWeightEntity record, @Param("example") DsBbinLiveWeightEntityExample example);

    int updateByExample(@Param("record") DsBbinLiveWeightEntity record, @Param("example") DsBbinLiveWeightEntityExample example);

    int updateByPrimaryKeySelective(DsBbinLiveWeightEntity record);

    int updateByPrimaryKey(DsBbinLiveWeightEntity record);
}