package com.ds.live.until;

public class BBINCommon {
	//上一页校验次数
	public static Integer LAST_PAGE_CHECK_TIMES = 3;
	//当前页达到N条注单的时候，上一页不再进行校验
	public static Integer CUR_PAGE_CHECK_MAX_PAGE_SIZE = 100;
	//请求错误时，线程休眠时间
	public static Long HTTP_ERROR_THREAD_SLEEP = 1000L;
	//循环一次线程休眠时间
	public static Long ONCE_TIME_THREAD_SLEEP = 5000L;
	
	
}
