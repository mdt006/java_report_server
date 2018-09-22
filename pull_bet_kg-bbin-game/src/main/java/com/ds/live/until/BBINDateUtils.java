package com.ds.live.until;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class BBINDateUtils {
	static SimpleDateFormat sdfdate= new SimpleDateFormat("yyyy-MM-dd",Locale.US);
	static SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd",Locale.US);
	/**
	 * 获取美东时间，时间延迟8分钟
	 * @param date
	 * @return
	 */
	public static String getBBINRounddate(Date date){
		sdfdate.setTimeZone(TimeZone.getTimeZone("GMT-4"));
		return sdfdate.format(new Date(date.getTime()-8*1000*60));
	}
	public static String getGMT4Date(Date date){
		sdf.setTimeZone(TimeZone.getTimeZone("GMT-4"));
		return sdf.format(date);
	}
	
}
