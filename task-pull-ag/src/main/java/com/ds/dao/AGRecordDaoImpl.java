package com.ds.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ds.mapper.AGRecordMapper;
import com.ds.mapper.Mapper;
import com.ds.po.AGPullRecordPO;
@Repository
public class AGRecordDaoImpl extends AbsBaseDaoImpl<AGPullRecordPO> implements IAGRecordDao{
	private AGRecordMapper agrecMapper;
	public AGRecordDaoImpl(Mapper<AGPullRecordPO> mapper) {
		super(mapper);
		this.agrecMapper = (AGRecordMapper)mapper;
	}

	@Override
	public void create(AGPullRecordPO t) {
		
	}

	@Override
	public List<AGPullRecordPO> getAGPullRecord(String agPath,String date) {
		return agrecMapper.getAGPullRecord(agPath, date);
	}

	public void insertOrupdateRecord(List<AGPullRecordPO> recordList) {
		agrecMapper.insertOrupdateRecord(recordList);
	}

}
