package com.ds.lottery.until;

public class ThreadUtil {
	public static void sleep(long millis){
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
		}
	}
}
