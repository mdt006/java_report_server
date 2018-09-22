package com.ds.live.until;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropsUtil {

	public static Properties props = new Properties();

	static {
		try {
			InputStream is = PropsUtil.class.getClassLoader().getResourceAsStream("weight.properties");
			props.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return props.getProperty(key);
	}

}
