package com.ds.common;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.kg.live.entity.ApiInfoEntity;
public class AGApplication {
	//记录文件每个文件读取到哪一行
	public static Cache<String, Integer> fileMap = CacheBuilder.newBuilder().expireAfterWrite(2, TimeUnit.DAYS).build();
	//apiinfoList
	public static List<ApiInfoEntity> list = new ArrayList<ApiInfoEntity>();
	public static List<String> liveGameList;
}
