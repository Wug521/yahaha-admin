package com.example.system.edge.ctrl;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.system.base.BaseController;
import com.example.system.entity.SysUser;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;
import com.zjapl.common.result.XResult.ErrorCode;
import com.zjapl.common.util.StringUtil;


/**
 * 文件名：AuthController.java
 * 日　期：2017年2月5日 下午1:23:32
 * 版　权：ZJAPL
 * 作　者：liujg
 * 类说明：登录授权
 */
@Controller
@RequestMapping("/auth")
public class AuthController extends BaseController{

	@RequestMapping("/login")
	@ResponseBody
	public ObjectResultEx<Map<String, Object>> login(@Validated SysUser sysUser) {
		ObjectResultEx<Map<String, Object>> resultEx = new ObjectResultEx<Map<String, Object>>();
		if (sysUser == null || StringUtil.isEmpty(sysUser.getUsername())){
			return resultEx.makeFailedResult(ErrorCode.NOT_LOGGED_IN);
		}
		if (!SecurityUtils.getSubject().isAuthenticated()) {
			return resultEx.makeFailedResult(ErrorCode.USERNAME_OR_PASSWORD_ERROR);
		}
		Map<String, Object> rtnMap = new HashMap<>();
		rtnMap.put("user", getSysUser());
		rtnMap.put("menuList", getMenuList());
		return resultEx.makeSuccessResult(rtnMap);
	}

	@RequestMapping("/logoutResult")
	@ResponseBody
	public ResultEx logoutResult() {
		ResultEx resultEx = new ResultEx();
		try {
			SecurityUtils.getSubject().logout();
		} catch (Exception e) {
			e.printStackTrace();
			return resultEx.makeInternalErrorResult();
		}
		return resultEx.makeSuccessResult();
	}

	@RequestMapping("/index")
	@ResponseBody
	public ObjectResultEx<Map<String, Object>> index() {
		ObjectResultEx<Map<String, Object>> resultEx = new ObjectResultEx<Map<String, Object>>();
		if (!SecurityUtils.getSubject().isAuthenticated()) {
			return resultEx.makeFailedResult(ErrorCode.USERNAME_OR_PASSWORD_ERROR);
		}
		Map<String, Object> rtnMap = new HashMap<>();
		rtnMap.put("user", getSysUser());
		rtnMap.put("menuList", getMenuList());
		return resultEx.makeSuccessResult(rtnMap);
	}

}
