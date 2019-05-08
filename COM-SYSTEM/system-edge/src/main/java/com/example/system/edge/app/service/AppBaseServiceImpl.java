package com.example.system.edge.app.service;

import java.util.UUID;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.system.edge.app.ctrl.AppBaseController;
import com.example.system.entity.SysUser;
import com.zjapl.common.framework.interceptor.AppAspectJService;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.util.StringUtil;

/**
 * 
 * 文件名：AppBaseServiceImpl.java
 * 日　期：2017年3月23日 下午1:31:29
 * 版　权：ZJAPL
 * 作　者：liujg
 * 类说明：app端基础类
 */
@Service
public class AppBaseServiceImpl implements AppAspectJService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 超时时间
	 */
	@SuppressWarnings("unused")
	private static Long overTime = 1000*60*60*24*7L;
	
	@Override
	public boolean isAppController(ProceedingJoinPoint point) {
		try {
			if (AppBaseController.class.isAssignableFrom(point.getTarget().getClass())){
				return true;
			}
		} catch (Exception e) {
			logger.error("isAppController error.", e);
		}
		return false;
	}

	@Override
	public boolean isTokenEnable(String token) {
		SysUser sysUser = getUserInfoByToken(token);
		if (sysUser == null || StringUtil.isEmpty(sysUser.getToken())){
			return false;
		} else {
			return true;
		}
	}
	/**
	 * 根据Token获取用户信息
	 * @param token
	 * @return
	 */
	public SysUser getUserInfoByToken(final String token){
		return null;
	}
	@SuppressWarnings("unused")
	private String getToken(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	/**
	 * 用户登录
	 * */
	public ObjectResultEx<SysUser> userLogin(String loginName,String password) {
		return null;

	}

	/**
	 * 用户退出
	 * */
	public boolean logoutToken(String token){
		return false;

	}

}

