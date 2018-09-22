package com.ds.sgs.dao;

import com.ds.sgs.entity.DsSgsRecordTime;

public interface DsSgsRecordTimeMapper {

    int insert(DsSgsRecordTime record);

    DsSgsRecordTime selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(DsSgsRecordTime record);
    
    DsSgsRecordTime selectOne();
    
}