package com.ds.report.dao.mapper;

import com.ds.report.entity.DsJpgame;
import com.ds.report.entity.DsJpgameExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsJpgameMapper {
    int countByExample(DsJpgameExample example);

    int deleteByExample(DsJpgameExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DsJpgame record);

    int insertSelective(DsJpgame record);

    List<DsJpgame> selectByExample(DsJpgameExample example);

    DsJpgame selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DsJpgame record, @Param("example") DsJpgameExample example);

    int updateByExample(@Param("record") DsJpgame record, @Param("example") DsJpgameExample example);

    int updateByPrimaryKeySelective(DsJpgame record);

    int updateByPrimaryKey(DsJpgame record);
    
    DsJpgame queryTotal(DsJpgameExample example);
    List<DsJpgame> queryDetail(DsJpgameExample example);
}