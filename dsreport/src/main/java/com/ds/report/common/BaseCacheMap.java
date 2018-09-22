package com.ds.report.common;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class BaseCacheMap {
	private  static Cache<String, String> site_record_map = CacheBuilder.newBuilder().expireAfterWrite(2, TimeUnit.DAYS).build();
	
	public static void addCacheMap(String key,String value){
		site_record_map.put(key, value);
	}
	
	public static void removeCacheMap(String key,String value){
		site_record_map.put(key, value);
	}
	
	public static void clearCacheMap(String key,String value){
		site_record_map.cleanUp();
	}
	public static String getCacheMap(String key){
		return site_record_map.getIfPresent(key);
	}
	
	
}
