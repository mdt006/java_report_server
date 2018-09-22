package com.ds.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils {
	static SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd",Locale.US);
	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String getGTM4date(Date date){
		sdf.setTimeZone(TimeZone.getTimeZone("GMT-4"));
		return sdf.format(date);
	}
	public static String getGTM4Lastdate(Date date){
		Date lastDate = new Date(date.getTime()-1000*60*60*24);
		sdf.setTimeZone(TimeZone.getTimeZone("GMT-4"));
		return sdf.format(lastDate);
	}
}
