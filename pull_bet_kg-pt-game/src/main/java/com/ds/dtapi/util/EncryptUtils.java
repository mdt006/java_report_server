package com.ds.dtapi.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;


public class EncryptUtils {
	
	/**
	 * 解密
	 * @param request
	 * @return
	 */
	public static boolean decrypt(HttpServletRequest request,String userkey) {
		Enumeration map = request.getParameterNames();
		List<String> list = new ArrayList<String>();
		String keyB = null;
		
		while (map.hasMoreElements()) {
			Object o = map.nextElement();
			String key = (o == null ? "" : o.toString());
			if(key.equals("key")){
				keyB = request.getParameter(key);
			}else{
				list.add(key + "=" + request.getParameter(key));
			}
		}
		if(keyB == null){
			return false;
		}
		String[] strArr = list.toArray(new String[list.size()]);
		
	//	System.out.println("param:"+Arrays.toString(strArr));
		String encryptStr = encrypt(strArr,userkey);
		if(encryptStr == null || !keyB.equals(encryptStr)){
			return false;
		}
		return true;
	}
	/**
	 * 返回数组加密后的md5值
	 * @param strArr
	 * @return
	 */
	private static String encrypt(String[] strArr,String userkey){
		if(strArr.length == 0 || userkey == null){
			return null;
		}
		Arrays.sort(strArr);
		StringBuffer sb = new StringBuffer();
		for (String str : strArr) {
			sb.append(StringUtils.substringAfter(str, "="));
		}
		sb.append(userkey);
		return MD5.getMD5(sb.toString());
	}
	
	/**
	 * 加密
	 * @param param
	 * @return
	 */
	public static String encrypt(String param,String userkey) {
		String [] strArr = param.split("\\&");
		if(strArr.length == 0 || userkey == null){
			return null;
		}
		
		return encrypt(strArr,userkey);
	}
}
