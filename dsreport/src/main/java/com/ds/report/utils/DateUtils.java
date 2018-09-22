package com.ds.report.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static boolean isValidDate(String str) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = (Date) formatter.parse(str);
			return str.equals(formatter.format(date));
		} catch (Exception e) {
			return false;
		}
	}
	public static void main(String[] args) {
		System.out.println(isValidDate("2015-07-07 23:24:23"));
	}
}
