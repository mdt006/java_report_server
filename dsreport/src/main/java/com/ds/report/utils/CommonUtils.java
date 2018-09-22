package com.ds.report.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CommonUtils {
	public final static Integer pageLimit = 10;
	
	/**
	* MD5 加密
	* @param str
	* @return
	*/
	public static String toMD5(String str){
		try{
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
