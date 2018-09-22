package com.ds.dao;

import java.util.List;

import com.ds.po.AGPullRecordPO;

public interface IAGRecordDao extends IBaseDao<AGPullRecordPO> {
	public List<AGPullRecordPO> getAGPullRecord(String agPath, String date); 
	public void insertOrupdateRecord(List<AGPullRecordPO> recordList);
}
