package com.kg.live.mapper;

import com.kg.live.entity.DsAgHunterInfo;
import com.kg.live.entity.DsAgHunterInfoExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DsAgHunterInfoMapper {
    long countByExample(DsAgHunterInfoExample example);

    int deleteByExample(DsAgHunterInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DsAgHunterInfo record);

    int insertSelective(DsAgHunterInfo record);

    List<DsAgHunterInfo> selectByExample(DsAgHunterInfoExample example);
    
    DsAgHunterInfo getHunterInfoByBillId(@Param("billId")String billId);
    
    DsAgHunterInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DsAgHunterInfo record, @Param("example") DsAgHunterInfoExample example);

    int updateByExample(@Param("record") DsAgHunterInfo record, @Param("example") DsAgHunterInfoExample example);

    int updateByPrimaryKeySelective(DsAgHunterInfo record);

    int updateByPrimaryKey(@Param("record") DsAgHunterInfo record);
    int updateByBillId(@Param("record") DsAgHunterInfo record);
    List<Map<String,Object>> selectTempInfo(@Param("create_date")String date);
    void insertTempInfo(@Param("id")String id,@Param("page_num")int page_num,@Param("create_date")String date);
    String getTempIdById(@Param("id")String id);
}