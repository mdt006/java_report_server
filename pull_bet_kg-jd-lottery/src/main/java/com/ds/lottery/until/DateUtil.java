package com.ds.lottery.until;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import com.alibaba.druid.util.StringUtils;

public class DateUtil {
	private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>();
	private static final Object object = new Object();
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static String defaultDatePattern = "yyyy-MM-dd ";
	
	public static Date covertTime(String time) {
		try {
			// TimeZone zone = TimeZone.getTimeZone("America/Halifax");
			// TimeZone.setDefault(zone);
			// return new
			// Timestamp(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar(time).toGregorianCalendar().getTimeInMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			sdf.setTimeZone(TimeZone.getTimeZone("GMT-4"));
			return new Timestamp(sdf.parse(time).getTime() - 1000 * 60 * 60
					* 12);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取SimpleDateFormat
	 * 
	 * @param pattern
	 *            日期格式
	 * @return SimpleDateFormat对象
	 * @throws RuntimeException
	 *             异常：非法日期格式
	 */
	static SimpleDateFormat getDateFormat(String pattern)
			throws RuntimeException {
		SimpleDateFormat dateFormat = threadLocal.get();
		if (dateFormat == null) {
			synchronized (object) {
				if (dateFormat == null) {
					dateFormat = new SimpleDateFormat(pattern, Locale.US);
					dateFormat.setLenient(false);
					threadLocal.set(dateFormat);
				}
			}
		}
		dateFormat.applyPattern(pattern);
		return dateFormat;
	}

	/**
	 * 获得指定日期的前一天
	 * 
	 * @param specifiedDay
	 * @return
	 * @throws Exception
	 */
	public static String getSpecifiedDayBefore(String specifiedDay) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);
		String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c
				.getTime());
		return dayBefore;
	}

	public static String covertDate(String time) {
		StringBuffer dateTime = new StringBuffer();
		try {
			if(!StringUtils.isEmpty(time)){
				String[] split = time.split("T");
				String date = split[0];
				String tempTime = split[1].substring(0,8);
				dateTime.append(date).append(" ").append(tempTime);
				Date datePase = datePase(dateTime.toString());
				long longTime = datePase.getTime();
				long timestamp = longTime -(1000*60*60*12);
				return dateCovertStr(new Date(timestamp));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date usDate(Date date){
		if(null != date){
			long time = date.getTime()-(1000*60*60*12);
			String dateCovertStr = dateCovertStr(new Date(time));
			try {
				return dateFormat.parse(dateCovertStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static String dateCovertStr(Date date) {
		SimpleDateFormat dateFormat = getDateFormat(defaultDatePattern);
		return dateFormat.format(date);
	}

	public static Date datePase(String dateString) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return formatter.parse(dateString);
		} catch (ParseException e) {e.printStackTrace();}
		return null;
	}
	
	public static void main(String[] args) throws ParseException {
		/*
		 * String specifiedDayBefore = getSpecifiedDayBefore("2017-05-13");
		 * System.out.println(specifiedDayBefore); //Date covertTime =
		 * covertTime("2017-03-10T15:47:00+08:00"); //
		 * System.out.println(getTimeToGMT(new Date(""))); String dateCovertSt
		 */
		/*String usDate = usDate(new Date());
		System.out.println(datePase(usDate));*/
		
	}

}
