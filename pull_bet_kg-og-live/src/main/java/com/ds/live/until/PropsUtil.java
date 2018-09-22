package com.ds.live.until;
import java.io.IOException;
import java.util.Properties;

public class PropsUtil {

	private static Properties props = new Properties();

	static {
		try {
			props.load(PropsUtil.class.getClassLoader().getResourceAsStream("businessInfo.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return props.getProperty(key);
	}

	public static void main(String[] args) {
		System.out.println(getProperty("transfer_project"));
	}
}
