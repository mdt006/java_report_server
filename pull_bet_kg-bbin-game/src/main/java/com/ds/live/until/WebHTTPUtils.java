package com.ds.live.until;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

//import org.apache.log4j.Logger;

public class WebHTTPUtils {
//	private static Logger logger = Logger.getLogger(WebHTTPUtils.class);
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
			new InputStreamReader(conn.getInputStream()));
			String line; 
			
			while ((line = in.readLine())!= null){
				result.append(line);
	//			logger.info(line);
				
			} 
			//System.out.println("line:::" + result);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result.toString();
	}
}
