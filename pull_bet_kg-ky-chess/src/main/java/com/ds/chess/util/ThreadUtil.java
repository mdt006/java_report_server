package com.ds.chess.util;

public class ThreadUtil {
	public static void sleep(long millis){
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
		}
	}
}
