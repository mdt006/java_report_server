package com.ds.lmg.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kg.live.entity.LMGLiveEntityWithBLOBs;


public interface LMGDao {

	String getMaxSeqNo(@Param(value="siteId")Integer siteId);
	void addLmg(List<LMGLiveEntityWithBLOBs> lmglist);

}
