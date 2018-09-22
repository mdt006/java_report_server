package com.ds.chess.dao;

import com.ds.chess.entity.DsKyRecordTime;

public interface DsKyRecordTimeMapper {

	int insert(DsKyRecordTime record);

	int updateByPrimaryKey(DsKyRecordTime record);

	DsKyRecordTime selectByAgent(String agent);

}