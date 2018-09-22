package com.ds.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ds.po.AGPullRecordPO;

public interface  AGRecordMapper extends Mapper<AGPullRecordPO> {
	public List<AGPullRecordPO> getAGPullRecord(@Param("agPath")String agPath, @Param("date")String date);

	public void insertOrupdateRecord(List<AGPullRecordPO> recordList);
}
