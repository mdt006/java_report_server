package com.ds.dao;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.ds.common.AGCommon;
import com.ds.mapper.ApiInfoExtMapper;
import com.ds.mapper.Mapper;
import com.kg.live.entity.ApiInfoEntity;
import com.kg.live.entity.ApiInfoEntityExample;
@Repository
public class AGDaoImpl extends AbsBaseDaoImpl<ApiInfoEntity> implements IAGDao{
	private ApiInfoExtMapper apiMapper;
	public AGDaoImpl(Mapper<ApiInfoEntity> mapper) {
		super(mapper);
		this.apiMapper = (ApiInfoExtMapper) mapper;
	}
	@Override
	public List<ApiInfoEntity> getAPIinfoList() {
		ApiInfoEntityExample e = new ApiInfoEntityExample();
		e.createCriteria().andLiveIdEqualTo(AGCommon.AG_LIVE_ID).andStateEqualTo(AGCommon.AG_API_NORMAL_STATE);
		return apiMapper.selectByExample(e);
	}
	
}
