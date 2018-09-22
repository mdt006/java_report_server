package com.ds.sgs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtils {
	
	private static final DateTimeFormatter DTF = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ");
	
	/**
	 * 得到UTC时间，类型为字符串，格式为"yyyy-MM-dd HH:mm"<br />
	 * 如果获取失败，返回null
	 * @return
	 */
	public static String getUTCTime(Date date,boolean hasMillisecond) {
		StringBuffer UTCTimeBuffer = new StringBuffer();
		// 1、取得本地时间：
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// 2、取得时间偏移量：
		int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
		// 3、取得夏令时差：
		int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
		// 4、从本地时间里扣除这些差量，即可以取得UTC时间：
		cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
		int year = cal.get(Calendar.YEAR);
		String month = format(String.valueOf(cal.get(Calendar.MONTH) + 1));
		String day = format(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
		String hour = format(String.valueOf(cal.get(Calendar.HOUR_OF_DAY)));
		String minute = format(String.valueOf(cal.get(Calendar.MINUTE)));
		String second = format(String.valueOf(cal.get(Calendar.SECOND)));
		UTCTimeBuffer.append(year).append("-").append(month).append("-").append(day).append("T");
		UTCTimeBuffer.append(hour).append(":").append(minute).append(":").append(second);
		String millisecond = "";
		if(hasMillisecond){
			millisecond = String.valueOf(cal.get(Calendar.MILLISECOND));
			UTCTimeBuffer.append(".").append(millisecond);
		}
		UTCTimeBuffer.append("Z");
		return UTCTimeBuffer.toString();
	}
	
	/**
	 * 转换为美东时间
	 * @param isoDate
	 * @return
	 */
	public static Date getGMT8Date(String isoDate){
		if(StringUtils.isBlank(isoDate)){
			return null;
		}
//		isoDate = isoDate.replaceAll(":[^:]*$", "00");
		Date date = DTF.parseDateTime(isoDate).toDate();
        return getGmt4Date(date);
	}
	
	/**
	 * 获取美东时间(自动判断当前时区)
	 * @param date
	 * @return
	 * @throws ParseException 
	 */
	public static Date getGmt4Date(Date date){
		int timeOffset = TimeZone.getDefault().getRawOffset() - TimeZone.getTimeZone("GMT-4").getRawOffset();
        return new Date(date.getTime() - timeOffset);  
	}
	
	private static String format(String tempDate){
		int length = tempDate.length();
		if(length<2){
			return "0" + tempDate;
		}
		return tempDate;
	}
	
	public static void main(String[] args) throws ParseException {
		System.out.println(getUTCTime(new Date(), true));
		System.out.println(getUTCTime(new Date(), false));
		
		String date = "2018-06-07T17:24:13+08:00";
		System.out.println(DateUtils.getGMT8Date(date));
		String str = "2018-06-07 17:24:13";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date2 = simpleDateFormat.parse(str);
		System.out.println(new Date(date2.getTime()- 1000*60*60*12));
	}
	
}
