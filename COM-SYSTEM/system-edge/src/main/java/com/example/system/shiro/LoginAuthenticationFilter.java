package com.example.system.shiro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
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
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.example.system.dic.CommonDictionary.EnableOrDisableCode;
import com.example.system.edge.service.SysResourceService;
import com.example.system.edge.service.SysUserService;
import com.example.system.entity.SysUser;
import com.example.system.utils.ServletRequestUtils;
import com.google.code.kaptcha.Constants;
import com.zjapl.common.exception.CaptchaException;
import com.zjapl.common.result.ResultEx;
import com.zjapl.common.result.XResult.ErrorCode;
import com.zjapl.common.util.RequestUtils;
import com.zjapl.common.vo.TreeMenuVo;

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
	public static final String FAILURE_URL = "failureUrl";
	public static final String CAPTCHA_IF_SHOW = "showCaptcha";
	// public static final String RETURN_URL = "returnUrl";
	@Resource
	private SysUserService sysUserService;
	@Resource
	private SysResourceService sysResourceService;

	protected boolean executeLogin(ServletRequest request,
			ServletResponse response) throws Exception {
		AuthenticationToken token = createToken(request, response);
		if (token == null) {
			String msg = "create AuthenticationToken error";
			throw new IllegalStateException(msg);
		}
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String loginName = (String) token.getPrincipal();
		String failureUrl = httpRequest.getParameter(FAILURE_URL);
		failureUrl = "/login";
		ShiroUtils.getOrCreateSession();		
		SysUser sysUser = sysUserService.getUserByUsername(loginName);
		if(sysUser == null){
			return onLoginFailure(true,token, new UnknownAccountException("用户不存在"), request, response);
		}else{
			if(EnableOrDisableCode.DISABLE == sysUser.getStatus())
				return onLoginFailure(true,token, new LockedAccountException("用户已锁定"), request, response);
			if(EnableOrDisableCode.DELETED == sysUser.getStatus())
				return onLoginFailure(true,token, new DisabledAccountException("用户不可用"), request, response);
		}
		if (isCaptchaRequired(httpRequest, httpResponse, loginName)) {
			String captcha = request.getParameter(CAPTCHA_PARAM);
			if (captcha != null) {
				String capText = (String) httpRequest.getSession()
						.getAttribute(Constants.KAPTCHA_SESSION_KEY);
				httpRequest.getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);
				if (!captcha.equals(capText)) {
					return onLoginFailure(token, new CaptchaException("验证码不匹配"), request, response);
				}
			} else {
				return onLoginFailure(failureUrl, token, sysUser,
						new AuthenticationException(), httpRequest,
						httpResponse);
			}
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

	private boolean isCaptchaRequired(HttpServletRequest request,
			HttpServletResponse response, String username) {
		Session tmpSession = ShiroUtils.getSession();
		if (tmpSession == null){
			tmpSession = ShiroUtils.getSession(true);
		}
		Boolean captchaShow = (Boolean)ShiroUtils.getSession().getAttribute(CAPTCHA_IF_SHOW);
		Boolean flag = BooleanUtils.toBooleanDefaultIfNull(captchaShow, false);
		if(flag){
			return true;
		}else{
			Integer errorRemaining = errorRemaining(username);
			if (errorRemaining != null && errorRemaining <= 0) {
				setCaptchaShow();
				return true;
			}
		}
		return false;
	}
	private void setCaptchaShow(){
		ShiroUtils.getSession().setAttribute(CAPTCHA_IF_SHOW, true);
	}
	@Override
	protected void setFailureAttribute(ServletRequest request,
			AuthenticationException ae) {
		request.setAttribute(getFailureKeyAttribute(), getFailureMessage(ae));
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

	private Integer errorRemaining(String loginName) {
		if (StringUtils.isBlank(loginName)) {
			return null;
		}
		SysUser sysUser = sysUserService.getUserByUsername(loginName);
		if (sysUser == null) {
			return null;
		}
		Integer errorCount = sysUser.getErrorCount();
		Long now = System.currentTimeMillis();
		//数据库从0开始计算，所以输错3次密码显示验证码
		int maxErrorTimes = 2;
		// 30分钟
		int maxErrorInterval = 30 * 60 * 1000;
		Date errorTime = sysUser.getErrorTime();
		if (errorCount == 0 || errorTime == null || errorTime.getTime() + maxErrorInterval < now) {
			return maxErrorTimes;
		}
		return maxErrorTimes - errorCount;
	}

	@Override
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException ae,
			ServletRequest request, ServletResponse response) {
		if (!ServletRequestUtils.isAjaxRequest(request)) {// 非ajax请求  
			setFailureAttribute(request, ae);  
			return true;  
		}
		try {  
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();  
			String message = getFailureMessage(ae);  
			out.println(JSON.toJSONString(new ResultEx().makeFailedResult(ErrorCode.USERNAME_OR_PASSWORD_ERROR, message)));
			out.flush();  
			out.close();  
		} catch (IOException e) {  
			logger.error("ServletResponse out error", e); 
		}  
		return false;  
	}

	private boolean onLoginFailure(Boolean bool,
			AuthenticationToken token, AuthenticationException ae,
			ServletRequest request, ServletResponse response) {
		return onLoginFailure(token, ae, request, response);
	}

	private boolean onLoginFailure(String failureUrl,
			AuthenticationToken token, SysUser sysUser,
			AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		//		String className = e.getClass().getName();
		//		request.setAttribute(getFailureKeyAttribute(), className);
		sysUserService.updateLoginFailed(sysUser.getId());
		/*if (failureUrl != null || StringUtils.isNotBlank(failureUrl)) {
			try {
				request.getRequestDispatcher(failureUrl).forward(request,
						response);
			} catch (Exception e1) {
				 e1.printStackTrace();
			}
		}*/
		return onLoginFailure(token, e, request, response);
	}

	private boolean onLoginSuccess(AuthenticationToken token, Subject subject,
			SysUser sysUser, ServletRequest request, ServletResponse response)
					throws Exception {
		//清除session中记录的上一次请求url,禁用登录成功后跳转到上次请求失败的url，如果有类似论坛评论须登录成功后再次跳转到访问页，不要清除session中url
		WebUtils.getAndClearSavedRequest(request);
		HttpServletRequest req = (HttpServletRequest) request;
		String ip = RequestUtils.getIpAddr(req);
		sysUserService.updateLoginInfo(sysUser.getId(), ip);
		ShiroUtils.getSession().removeAttribute(CAPTCHA_IF_SHOW);
		setResourcesForUser();
		return onLoginSuccess(token, subject, request, response);
	}
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject,
			ServletRequest request, ServletResponse response) throws Exception {
		//通过ajax请求的页面也跳转到成功跳转页URL，在成功跳转页URL处再做ajax和页面返回细分
		issueSuccessRedirect(request, response);  
		/*HttpServletResponse httpServletResponse = (HttpServletResponse) response;  
		if (!ServletRequestUtils.isAjaxRequest(request)) {// 不是ajax请求  
		} else { 
			//TODO 当Api方式调用时也使用ajax，需要获取用户相关信息，网页通过ajax登录也走这个流程
			try {
				httpServletResponse.setCharacterEncoding("UTF-8");  
				PrintWriter out = httpServletResponse.getWriter();  
				out.println(JSON.toJSONString(new ResultEx().makeSuccessResult()));
				out.flush();  
				out.close();  
			} catch (IOException e) {
				logger.error("ServletResponse out error", e); 
			}
		}  */
		return false;  
	}
	protected void setResourcesForUser(){
		ShiroPrincipal sessionPrincipal = (ShiroPrincipal)ShiroUtils.getSession().getAttribute(ShiroPrincipal.SHIRO_PRINCIPAL_KEY);
		ShiroPrincipal shiroPrincipal = ShiroUtils.getShiroPrincipal();
		//置空用户密码，防止泄漏
		if (shiroPrincipal != null && shiroPrincipal.getSysUser() != null ){
			shiroPrincipal.getSysUser().setPassword(null);
		}
		List<TreeMenuVo> treeMenuVos = sysResourceService.getResourcesMenuByUserId(shiroPrincipal.getId()).getData();
		if(sessionPrincipal == null){
			shiroPrincipal.setMenuList(treeMenuVos);
			ShiroUtils.getSession().setAttribute(ShiroPrincipal.SHIRO_PRINCIPAL_KEY,shiroPrincipal);
		}else{
			sessionPrincipal.setMenuList(treeMenuVos);
			ShiroUtils.getSession().setAttribute(ShiroPrincipal.SHIRO_PRINCIPAL_KEY,sessionPrincipal);
		}
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
}
