package com.ds.dtapi.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class PlatformUtil {
	  static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.US);
	  static SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
	  static Random random = new Random();

	  static char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 
	    'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 
	    'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	/**
	 * MD5 加密
	 * @param str
	 * @return
	 */
	public static String toMD5(String str){
	     try
	     {
	       MessageDigest md = MessageDigest.getInstance("MD5");
	       md.update(str.getBytes());
	       byte[] byteDigest = md.digest();
	 
	       StringBuffer buf = new StringBuffer("");
	       for (int offset = 0; offset < byteDigest.length; offset++) {
	         int i = byteDigest[offset];
	         if (i < 0)
	           i += 256;
	         if (i < 16)
	           buf.append("0");
	         buf.append(Integer.toHexString(i));
	       }
	 
	       return buf.toString();
	     } catch (NoSuchAlgorithmException e) {
	         e.printStackTrace();
	     }
	     
	     return null;
	}
	
	
	  //服务器时间为美东时间  
	  public static String getTime() {
		  return sdf.format(new Date());
	  }
	  
	  public static String randomString(int digit)
	  {
	    StringBuilder build = new StringBuilder(digit);
	    for (int i = 0; i < digit; i++) {
	      build.append(str[random.nextInt(26)]);
	    }

	    return build.toString();
	  }
	  
}
