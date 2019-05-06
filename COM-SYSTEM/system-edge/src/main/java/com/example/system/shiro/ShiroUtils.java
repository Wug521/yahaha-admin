package com.example.system.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * 
 * 文件名：ShiroUtils.java
 * 版本号：V 1.0
 * 日　期：2016年5月20日
 * 版　权：ZJAPL
 * 作　者：wuzy
 * 类说明：
 */
public class ShiroUtils {
	
	
     
	public static ShiroPrincipal getShiroPrincipal(){
		Subject subject = SecurityUtils.getSubject();
		if(subject != null && subject.getPrincipals() !=null ){
			return subject.getPrincipals().oneByType(ShiroPrincipal.class);
		}
		return null;
	}
	/**
	 * 
	 * @return
	 */
	public static Session getOrCreateSession() {
		Session session = getSession();

		if (session == null) {
			session = getSession(true);
		}

		return session;
	}

	/**
	 * 
	 * @return
	 */
	public static Session getSession() {
		return getSession(false);
	}

	/**
	 * 
	 * @param create
	 * @return
	 */
	public static Session getSession(boolean create) {
		return SecurityUtils.getSubject().getSession(create);
	}
}
