package com.ds.live.until;

import java.util.Map;

public class BBINCommon {
	//上一页校验次数
	public static Integer LAST_PAGE_CHECK_TIMES = 3;
	//当前页达到N条注单的时候，上一页不再进行校验
	public static Integer CUR_PAGE_CHECK_MAX_PAGE_SIZE = 100;
	//请求错误时，线程休眠时间
	public static Long HTTP_ERROR_THREAD_SLEEP = 1000L;
	//循环一次线程休眠时间
	public static Long ONCE_TIME_THREAD_SLEEP = 5000L;

	//bbin 地址
	public final static String URL = "http://180.150.154.103/dtapi/app/bbin/";

	//秘钥
	public final static String USERKEY = "ff6829525ef73d279117";



	/**
	 　　* 按照“参数=参数值”的模式用“&”字符拼接成字符串
	 　　* @param params 需要排序并参与字符拼接的参数组
	 　　* @return 拼接后字符串
	 　　*/
	public static String mapToString(Map<String, String> params) {
		if(null == params || params.isEmpty()){
			return null;
		}
		StringBuffer sb = new StringBuffer();
		params.forEach((k,v)-> sb.append(k+"="+v+"&"));
		if(sb.length() > 0){
			return sb.substring(0,sb.length()-1);
		}
		return null;
	}
}
