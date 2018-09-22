package com.ds.live.until;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	static SimpleDateFormat sdfdate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static Date convertStrDate(String date){
		try {
			return sdfdate.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		};
		return null;
	}
	
	public static String convertDateStr(Date date){
		return sdfdate.format(date);
	}
}
