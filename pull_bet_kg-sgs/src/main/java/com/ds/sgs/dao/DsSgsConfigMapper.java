package com.ds.sgs.dao;

import java.util.List;

import com.ds.sgs.entity.DsSgsConfig;

public interface DsSgsConfigMapper {

    int insert(DsSgsConfig record);

    DsSgsConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(DsSgsConfig record);
    
    List<DsSgsConfig> selectAll();
}