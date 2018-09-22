package com.kg.live.mapper;

import com.kg.live.entity.DtPtGame;
import com.kg.live.entity.DtPtGameExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DtPtGameMapper {
    long countByExample(DtPtGameExample example);

    int deleteByExample(DtPtGameExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DtPtGame record);

    int insertSelective(DtPtGame record);

    List<DtPtGame> selectByExample(DtPtGameExample example);

    DtPtGame selectByPrimaryKey(Long id);
    
    DtPtGame selectByGameCode(@Param("gameCode")String gameCode);

    int updateByExampleSelective(@Param("record") DtPtGame record, @Param("example") DtPtGameExample example);

    int updateByExample(@Param("record") DtPtGame record, @Param("example") DtPtGameExample example);

    int updateByPrimaryKeySelective(DtPtGame record);

    int updateByPrimaryKey(DtPtGame record);
    
    //批量插入
    int insertByBatch(List<DtPtGame> list);
    
    //根据游戏ID更新
    int updateByGameCode(DtPtGame record);
    //查询某个网站当前时间段的数量
    int getCountBySiteAndTime(@Param("site_id")int site_id,@Param("starttime")String starttime,@Param("endtime")String endtime);

}