package com.ds.report.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author 光光
 *
 */
public class RequestUtils {

	protected static final Logger logger = LoggerFactory.getLogger(RequestUtils.class);

	
	public static void showParams(HttpServletRequest request) {
		// 解析参数.
				Enumeration map = request.getParameterNames();
				StringBuffer br = new StringBuffer(">>>客户端(").append(
						request.getRemoteAddr()).append("),请求参数:\r\n");
				while (map.hasMoreElements()) {
					Object o = map.nextElement();
					String key = (o == null ? "" : o.toString());
					br.append(key + "=" + request.getParameter(key)).append("\r\n");
				}
				String param = br.toString();
				logger.info(param);
    }
	/**
	 * 接收json请求参数
	 * @param request
	 * @return
	 */
	public static String getParams(HttpServletRequest request) {
		// 解析参数.
		Enumeration map = request.getParameterNames();
		String param =null;
		while (map.hasMoreElements()) {
			Object o = map.nextElement();
			param = (o == null ? "" : o.toString());
		}
		return param;
    }
}
