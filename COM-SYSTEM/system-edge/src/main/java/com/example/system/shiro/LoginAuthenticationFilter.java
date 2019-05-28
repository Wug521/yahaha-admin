package com.example.system.shiro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.example.system.dic.CommonDictionary.EnableOrDisableCode;
import com.example.system.edge.service.IResourceService;
import com.example.system.edge.service.IUserService;
import com.example.system.entity.SysUser;
import com.example.system.vo.MenuVo;
import com.zjapl.common.exception.CaptchaException;
import com.zjapl.common.result.ResultEx;
import com.zjapl.common.result.XResult.ErrorCode;

/**
 * 
 * 文件名：LoginAuthenticationFilter.java 
 * 版本号：V 1.0 
 * 日　期：2016年6月1日
 * 版　权：ZJAPL 
 * 作　者：wuzy
 * 类说明：
 */
@Component
public class LoginAuthenticationFilter extends FormAuthenticationFilter {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public static final String CAPTCHA_PARAM = "captcha";
	
	public static final String CAPTCHA_IF_SHOW = "showCaptcha";
	
	public static final String LOGIN_ERROR_COUNT = "errorCount";
	
	public static final String LOGIN_ERROR_TIME = "errorTime";
	
	 public static final String FAILURE_URL = "failureUrl";
	
	@Autowired
	private IUserService sysUserService;
	
	@Autowired
	private IResourceService sysResourceService;

	protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
		AuthenticationToken token = createToken(request, response);
		if (token == null) {
			String msg = "create AuthenticationToken error";
			throw new IllegalStateException(msg);
		}
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String username = (String) token.getPrincipal();
		String failureUrl = httpRequest.getParameter(FAILURE_URL);
		failureUrl = "/login";
		ShiroUtils.getOrCreateSession();
		SysUser sysUser = (SysUser) sysUserService.queryByUserName(username, null).getData();
		if(sysUser == null){
			return onLoginFailure(true,token, new UnknownAccountException("用户不存在"), request, response);
		}else{
			if(EnableOrDisableCode.DISABLE == sysUser.getStatus())
				return onLoginFailure(true,token, new LockedAccountException("用户已锁定"), request, response);
			if(EnableOrDisableCode.DELETED == sysUser.getStatus())
				return onLoginFailure(true,token, new DisabledAccountException("用户不可用"), request, response);
		}
		try {
			Subject subject = getSubject(request, response);
			subject.login(token);
			return onLoginSuccess(token, subject, sysUser, request, response);
		} catch (AuthenticationException ae) {
			System.out.println(ae.getMessage());
			return onLoginFailure(failureUrl, token, sysUser,
					new AuthenticationException("登录异常"), request, response);
		}

	}
	
	@Override
	protected void setFailureAttribute(ServletRequest request,
			AuthenticationException ae) {
		request.setAttribute(getFailureKeyAttribute(), getFailureMessage(ae));
	}

	private boolean onLoginFailure(String failureUrl,AuthenticationToken token, SysUser sysUser,
			AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		return onLoginFailure(token, e, request, response);
	}

	private boolean onLoginFailure(Boolean bool,
			AuthenticationToken token, AuthenticationException ae,
			ServletRequest request, ServletResponse response) {
		return onLoginFailure(token, ae, request, response);
	}
	
	@SuppressWarnings("rawtypes")
	protected void setResourcesForUser(){
		ShiroPrincipal sessionPrincipal = (ShiroPrincipal)ShiroUtils.getSession().getAttribute(ShiroPrincipal.SHIRO_PRINCIPAL_KEY);
		ShiroPrincipal shiroPrincipal = ShiroUtils.getShiroPrincipal();
		//置空用户密码，防止泄漏
		if (shiroPrincipal != null && shiroPrincipal.getSysUser() != null ){
			shiroPrincipal.getSysUser().setPassword(null);
		}
		List<MenuVo> menuVos = sysResourceService.queryTreeByUser(shiroPrincipal.getId(),shiroPrincipal.getOrgCode()).getData();
		if(sessionPrincipal == null){
			shiroPrincipal.setMenuList(menuVos);
			ShiroUtils.getSession().setAttribute(ShiroPrincipal.SHIRO_PRINCIPAL_KEY,shiroPrincipal);
		}else{
			sessionPrincipal.setMenuList(menuVos);
			ShiroUtils.getSession().setAttribute(ShiroPrincipal.SHIRO_PRINCIPAL_KEY,sessionPrincipal);
		}
	}
	
	@SuppressWarnings("unused")
	private boolean isCaptchaRequired() {
		Session tmpSession = ShiroUtils.getSession();
		if (tmpSession == null) {
			tmpSession = ShiroUtils.getSession(true);
		}
		Boolean captchaShow = (Boolean) ShiroUtils.getSession().getAttribute(
				CAPTCHA_IF_SHOW);
		Boolean flag = BooleanUtils.toBooleanDefaultIfNull(captchaShow, false);
		if (flag) {
			return true;
		} else {
			Long time = (Long) ShiroUtils.getSession().getAttribute(
					LOGIN_ERROR_TIME);
			Long now = System.currentTimeMillis();
			// 30分钟
			int maxErrorInterval = 30 * 60 * 1000;
			if (time != null && time + maxErrorInterval < now) {
				ShiroUtils.getSession().setAttribute(LOGIN_ERROR_COUNT, 0);
				return false;
			}
		}
		return false;
	}
	
	private boolean onLoginSuccess(AuthenticationToken token, Subject subject,
			SysUser sysUser, ServletRequest request, ServletResponse response)
					throws Exception {
		//清除session中记录的上一次请求url,禁用登录成功后跳转到上次请求失败的url，如果有类似论坛评论须登录成功后再次跳转到访问页，不要清除session中url
		/*WebUtils.getAndClearSavedRequest(request);
		HttpServletRequest req = (HttpServletRequest) request;
		String ip = RequestUtils.getIpAddr(req);
		sysUserService.updateLoginInfo(sysUser.getId(), ip);*/
		/*
		 * 设置用户资源
		 */
		setResourcesForUser();
		ShiroUtils.getSession().removeAttribute(CAPTCHA_IF_SHOW);
		ShiroUtils.getSession().removeAttribute(LOGIN_ERROR_COUNT);
		ShiroUtils.getSession().removeAttribute(LOGIN_ERROR_TIME);
		boolean flag = onLoginSuccess(token, subject, request, response);
		return flag;
	}
	
	/**
	 * 重写父类方法,记住密码
	 */
	@Override
	protected AuthenticationToken createToken(ServletRequest request,
			ServletResponse response) {

		String username = getUsername(request);
		String password = getPassword(request);
		boolean rememberMe = isRememberMe(request);
		String host = getHost(request);

		return new UsernamePasswordToken(username, password, rememberMe, host);
	}
	
	@Override
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException ae,
			ServletRequest request, ServletResponse response) {
		Integer count = (Integer) ShiroUtils.getSession().getAttribute(
				LOGIN_ERROR_COUNT);
		if (count == null) {
			count = 1;
		} else {
			count++;
		}
		if (count > 2) {
			ShiroUtils.getSession().setAttribute(CAPTCHA_IF_SHOW, true);
		} else {
			ShiroUtils.getSession().setAttribute(CAPTCHA_IF_SHOW, false);
		}
		ShiroUtils.getSession().setAttribute(LOGIN_ERROR_COUNT, count);
		ShiroUtils.getSession().setAttribute(LOGIN_ERROR_TIME, System.currentTimeMillis());
		try {
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			String message = getFailureMessage(ae);
			ResultEx result = new ResultEx();
			result.setData(ShiroUtils.getSession()
					.getAttribute(CAPTCHA_IF_SHOW));
			out.println(JSON.toJSONString(result.makeFailedResult(
					ErrorCode.USERNAME_OR_PASSWORD_ERROR, message)));
			out.flush();
			out.close();
		} catch (IOException e) {
			logger.error("ServletResponse out error", e);
		}
		return false;
	}
	
	/**
	 * 获取登录失败消息
	 * @param ae
	 * @return
	 */
	private String getFailureMessage(AuthenticationException ae){
		String message = null;
		if (ae instanceof CaptchaException) {
			message = "验证码不匹配!";
		} else if (ae instanceof IncorrectCredentialsException) {
			message = "用户名或密码错误！";
		} else if (ae instanceof UnknownAccountException) {
			message = "用户名不存在！";
		} else if (ae instanceof DisabledAccountException) {
			message = "用户不可用！";
		} else if (ae instanceof AuthenticationException) {
			message = "用户名或密码错误！！！";
		} else if (ae instanceof LockedAccountException) {
			message = "账户已锁定！";
		} else if (ae instanceof ExcessiveAttemptsException) {
			message = "用户名或密码错误次数过多！";
		} else {
			message = ae.getMessage();
		}
		return message;
	}

}
