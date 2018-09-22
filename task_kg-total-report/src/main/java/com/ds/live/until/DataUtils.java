package com.ds.live.until;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class DataUtils {
	static Random random = new Random();
	static char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			'x', 'y', 'z' };

	public static String randomString(int digit) {
		StringBuilder build = new StringBuilder(digit);
		for (int i = 0; i < digit; i++) {
			build.append(str[random.nextInt(26)]);
		}
		return build.toString();
	}
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
}
