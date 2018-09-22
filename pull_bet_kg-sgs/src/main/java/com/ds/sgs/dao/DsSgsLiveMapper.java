package com.ds.sgs.dao;

import com.ds.sgs.entity.DsSgsLive;

public interface DsSgsLiveMapper {

    int insert(DsSgsLive record);

    DsSgsLive selectByPrimaryKey(Long id);

    int updateByPrimaryKey(DsSgsLive record);
    
    DsSgsLive selectByUgsBetId(String ugsBetId);
}