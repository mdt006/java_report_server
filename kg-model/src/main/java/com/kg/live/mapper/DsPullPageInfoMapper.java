package com.kg.live.mapper;

import com.kg.live.entity.DsPullPageInfo;
import com.kg.live.entity.DsPullPageInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsPullPageInfoMapper {
    long countByExample(DsPullPageInfoExample example);

    int deleteByExample(DsPullPageInfoExample example);

    int insert(DsPullPageInfo record);

    int insertSelective(DsPullPageInfo record);

    List<DsPullPageInfo> selectByExample(DsPullPageInfoExample example);

    int updateByExampleSelective(@Param("record") DsPullPageInfo record, @Param("example") DsPullPageInfoExample example);

    int updateByExample(@Param("record") DsPullPageInfo record, @Param("example") DsPullPageInfoExample example);
}