package com.ds.live.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ds.live.entity.BBINGameVo;


public interface BBINDao {

	void insertOrUpdate(List<BBINGameVo> list);
	
	//插入稽核表
	void insertOrUpdateTempAuditTotal(List<BBINGameVo> list);
	//查询数量
	int getCountByTime(@Param("str_sql")String str_sql);
}
