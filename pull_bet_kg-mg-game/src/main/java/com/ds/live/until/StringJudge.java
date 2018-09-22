package com.ds.live.until;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;





public class StringJudge{
	

	

	

	

	
	/**
	 * 向指定URL 发送 post方法请求
	 * @param url 发送请求的 URL
	 * @param param 请求参数，请求参数应该是 name1=value&name2=value2的形式
	 * @return URL所代表远程资源的响应
	 */
	public static String sendPost1(String url,String param){
		
		PrintWriter out = null;
		BufferedReader in = null;
		StringBuffer result = new StringBuffer();
		
		try{
			
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			conn.setConnectTimeout(300000);//连接超时时间
			conn.setReadTimeout(300000); 
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
			"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			
			//发送POST请求必须设置如下两行 
			conn.setDoOutput(true);
			conn.setDoInput(true); 
			
			//获取URLConnection对象对应的输出流 
			out = new PrintWriter(conn.getOutputStream()); 
			
			//发送请求参数
			out.print(param); 
			
			//flush输出流的缓冲
			out.flush();
			
			//定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
			new InputStreamReader(conn.getInputStream()));//报错
			String line; 
			
			while ((line = in.readLine())!= null){
				result.append(line);
				//System.out.println("line::" + line);
				//logger.info(line);
				
			} 
			//System.out.println("line:::" + result);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result.toString();
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
	
	//判断是否为空
	public static boolean isParam(String website,String username,String uppername,String key){
		
		if(null == website || null == username || null==uppername || null==key){
			return true;
		}
		
		return false;
	}
	
	public static boolean isUppername(String uppername){
		//if(SiteLiveName.kkw_uppername.equals(uppername)){
		//	return false;
		//}
		
		return true;
	}
	
	 private Properties propertie;
	 private FileInputStream inputFile;
	
	public static void main(String[] args) {
		//StringJudge judge = new StringJudge();
		//judge.Configuration();
		String uppername = "testkkw";
		if(uppername.contains("test")){
			System.out.println("test::");
		}else{
			System.out.println("uppername::");
		}
	}
	
	public void Configuration(){
		propertie = new Properties();
		try{
			inputFile = new FileInputStream("../classes/config.properties");
			propertie.load(inputFile);
			System.out.println("hashCode:"+propertie.getProperty("hashCode"));
		}catch(FileNotFoundException ex){
			System.out.println("读取属性文件--->失败！- 原因：文件路径错误或者文件不存在");
			ex.printStackTrace();
		}catch(IOException e){
			System.out.println("装载文件--->失败!");
			e.printStackTrace();
		}
	}
}
