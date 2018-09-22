package com.ds.lmg.util;

public class ThreadUtil {
	public static void sleep(long millis){
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
		}
	}
}
