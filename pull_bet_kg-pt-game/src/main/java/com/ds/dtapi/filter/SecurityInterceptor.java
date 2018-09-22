package com.ds.dtapi.filter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ds.dtapi.vo.ReturnResult;

public class SecurityInterceptor implements HandlerInterceptor {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String remoteIp = getIpAddr(request);
		logger.info("dtapi preHandle remote ip: " + remoteIp);
//		List<UserAddress> list = Platform.getUserAddress();
//		for (UserAddress address : list) {
//			String ipStr = address.getUserIp();
//			if (ipStr.indexOf(remoteIp) != -1) {
//				return true;
//			}
//		}
//
//		PrintWriter out = response.getWriter();
//		String url = request.getRequestURI().replace(request.getContextPath(),
//				"");
//		out.write(retMessage(url));
//		logger.info("ip is not allowed  : " + remoteIp);
//		return false;
		
		return true;
	}

	private String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	private String retMessage(String url) {
		if (url.indexOf("bbin") != -1) {
			return new ReturnResult(false, 44900, "IP is not accepted.").toString();
		}
		return "";
	}
}
