package com.ds.dtapi.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class BaseCommon {
	//缓存30分钟（记录数据id）
	public static Cache<String, String> record_map = CacheBuilder.newBuilder().expireAfterWrite(30, TimeUnit.MINUTES).build();
	//一次拉取条数
	public static int PAGE_SIZE=5000;
	//上一页校验次数
	public static Integer LAST_PAGE_CHECK_TIMES = 3;
	//当前页达到N条注单的时候，上一页不再进行校验
	public static Integer CUR_PAGE_CHECK_MAX_PAGE_SIZE = 100;
	//请求错误时，线程休眠时间
	public static Long HTTP_ERROR_THREAD_SLEEP = 1000L;
	//循环一次线程休眠时间
	public static Long ONCE_TIME_THREAD_SLEEP = 4*60*1000L;
	
	
	public static int M_PAGE_SIZE=1000;//手动拉取条数
	public static Long M_WAIT_TIME=2*1000L;//手动拉取等待时间
	
	
	//pt密钥
	public final static String PT_PASSWORD="changeit";
	//pt 请求url
//	public final static String PT_BASEURI="https://kioskpublicapi.grandmandarin88.com";//旧的
	
	public final static String PT_BASEURI="https://kioskpublicapi.luckyspin88.com";//新的

	/**
	 * 拉取时间段设置，PT只能拉取半小时之内数据
	 * 为了方便拉取数据的操作，故写死。(解耦原子性)
	 * 第一次拉取需要拉取昨天23：59:59的数据
	 */
	public final static List<String> TIME_LIST=Arrays.asList(
		"23:59:00_00:01:00",
		"00:00:00_00:30:00",
		"00:30:00_01:00:00",
		"01:00:00_01:30:00",
		"01:30:00_02:00:00",
		"02:00:00_02:30:00",
		"02:30:00_03:00:00",
		"03:00:00_03:30:00",
		"03:30:00_04:00:00",
		"04:00:00_04:30:00",
		"04:30:00_05:00:00",
		"05:00:00_05:30:00",
		"05:30:00_06:00:00",
		"06:00:00_06:30:00",
		"06:30:00_07:00:00",
		"07:00:00_07:30:00",
		"07:30:00_08:00:00",
		"08:00:00_08:30:00",
		"08:30:00_09:00:00",
		"09:00:00_09:30:00",
		"09:30:00_10:00:00",
		"10:00:00_10:30:00",
		"10:30:00_11:00:00",
		"11:00:00_11:30:00",
		"11:30:00_12:00:00",
		"12:00:00_12:30:00",
		"12:30:00_13:00:00",
		"13:00:00_13:30:00",
		"13:30:00_14:00:00",
		"14:00:00_14:30:00",
		"14:30:00_15:00:00",
		"15:00:00_15:30:00",
		"15:30:00_16:00:00",
		"16:00:00_16:30:00",
		"16:30:00_17:00:00",
		"17:00:00_17:30:00",
		"17:30:00_18:00:00",
		"18:00:00_18:30:00",
		"18:30:00_19:00:00",
		"19:00:00_19:30:00",
		"19:30:00_20:00:00",
		"20:00:00_20:30:00",
		"20:30:00_21:00:00",
		"21:00:00_21:30:00",
		"21:30:00_22:00:00",
		"22:00:00_22:30:00",
		"22:30:00_23:00:00",
		"23:00:00_23:30:00",
		"23:30:00_23:59:59"
		);
	
	public static String getNowDate(){
		return LocalDate.now(ZoneId.of("GMT+8")).toString();
	}
	
	public static String  addDateByDay(String date,int day){
		LocalDate d=LocalDate.parse(date);
		d=d.plusDays(day);
		return d.toString();
		
	}
	public static String  addDateByHours(String datetime,int hours){
		LocalDateTime d=LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		d=d.plusHours(12);
		return d.format(DateTimeFormatter.ofPattern("yyyy-MM-dd%20HH:mm:ss"));
	}
	
}
