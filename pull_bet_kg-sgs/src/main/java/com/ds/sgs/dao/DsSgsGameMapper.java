package com.ds.sgs.dao;

import com.ds.sgs.entity.DsSgsGame;

public interface DsSgsGameMapper {

    int insert(DsSgsGame record);

    DsSgsGame selectByPrimaryKey(Long id);

    int updateByPrimaryKey(DsSgsGame record);
    
    DsSgsGame selectByUgsBetId(String ugsBetId);
}