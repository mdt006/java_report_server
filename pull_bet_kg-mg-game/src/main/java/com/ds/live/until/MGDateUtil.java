package com.ds.live.until;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MGDateUtil {
	static SimpleDateFormat sdfdate= new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss",Locale.CHINA);
	static SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd",Locale.CHINA);
	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String getGMT8dateStr(Date date){
		sdfdate.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		return sdfdate.format(date);
	}
	/**
	 * 输入的时区必须是美东的时区
	 * @param gmt4date
	 * @return
	 */
	public static Date getGMT8Date(Date gmt4date){
		return new Date(gmt4date.getTime()+1000*60*60*12);
	//	return new Date(gmt4date.getTime());
	}
		
		
//	public static void main(String[] args) {
//		System.out.println(getGMT8date(new Date()));
//	}
}
