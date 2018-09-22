package com.ds.dao;

import java.util.List;

import com.kg.live.entity.ApiInfoEntity;

public interface IAGDao extends IBaseDao<ApiInfoEntity>{
	public List<ApiInfoEntity> getAPIinfoList();
}
