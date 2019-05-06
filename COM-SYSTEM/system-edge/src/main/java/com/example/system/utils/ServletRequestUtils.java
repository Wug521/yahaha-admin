package com.example.system.utils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public class ServletRequestUtils {
	/** 
	 * 判断是否是  Ajax 请求 
	 * @param request 
	 * @return 
	 */  
	public static boolean isAjaxRequest(ServletRequest request) {  
		String headerType = ((HttpServletRequest)request).getHeader("X-Requested-With");
		if ("XMLHttpRequest".equalsIgnoreCase(headerType)){
			return true;
		}
		return false;
	}
}
