package com.ds.lottery.until;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class PropsUtil {

	private static Properties props = new Properties();

	static{
		      //初始化读取配置文件中的分表信息
		      Resource resource = new ClassPathResource("BaseConfig.properties");
		      try {
		          InputStream is = resource.getInputStream();
		          try {
		              BufferedReader bf = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		              props.load(bf);
		         } finally {
		             is.close();
		         }
		     } catch (IOException e) {
		         e.printStackTrace();
		     }
		 }

	public static String getProperty(String key) {
		return props.getProperty(key);
	}

	public static void main(String[] args) {
		System.out.println(getProperty("KIND_NAME_SSC"));
	}
}
