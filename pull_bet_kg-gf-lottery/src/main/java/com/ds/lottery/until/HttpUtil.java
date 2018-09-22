package com.ds.lottery.until;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtil {

	private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

	public static String sendPost1(String url, String param) throws Exception {
		logger.info("sendPost1 url = {}, param = {}", url, param);

		PrintWriter out = null;
		BufferedReader in = null;
		StringBuilder result = new StringBuilder();

		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			conn.setConnectTimeout(60000);// 连接超时时间
			conn.setReadTimeout(60000);
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("User-Agent", "WEB_LIB_GI_");
			conn.setRequestProperty("Content-Type", "application/json");

			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);

			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());

			// 发送请求参数
			out.print(param);

			// flush输出流的缓冲
			out.flush();

			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;

			while ((line = in.readLine()) != null) {
				result.append(line);
			}
			if (out != null) {
				out.close();
			}
			if (in != null) {
				in.close();
			}
		} catch (Exception e) {
			logger.error("sendPost1 error", e);
		} finally {
			if (out != null) {
				out.close();
			}
			if (in != null) {
				in.close();
			}
		}
		return result.toString();
	}
}
