package com.example.system.edge.app.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.system.entity.SysUser;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;
import com.zjapl.common.util.AESParamUtil;

/**
 * 登陆授权
 * @author liujg
 *
 */
@Controller
@RequestMapping(value = "/app/auth", method = RequestMethod.POST)
public class AppAuthController extends AppBaseController{
	Logger logger = LoggerFactory.getLogger(AppAuthController.class);

	@ResponseBody
	@RequestMapping(value = "/login")
	public Object login(@RequestParam String param) {
		ObjectResultEx<SysUser> resultEx = new ObjectResultEx<SysUser>();
		try {
			SysUser sysUserParam = AESParamUtil.parseObject(SysUser.class, param);
			resultEx = appBaseService.userLogin(sysUserParam.getUsername(), sysUserParam.getPassword());
		} catch (Exception e) {
			logger.error("login process error.", e);
			return resultEx.makeInternalErrorResult();
		}
		return resultEx;
	}
	@ResponseBody
	@RequestMapping(value = "/logout")
	public Object logout(@RequestParam String param) {
		ResultEx resultEx = new ResultEx();
		try {
			SysUser sysUserParam = AESParamUtil.parseObject(SysUser.class, param);
			boolean isSuccess = appBaseService.logoutToken(sysUserParam.getToken());
			if (isSuccess){
				return resultEx.makeSuccessResult();
			} else {
				return resultEx.makeInternalErrorResult();
			}
		} catch (Exception e) {
			logger.error("login process error.", e);
			return resultEx.makeInternalErrorResult();
		}
	}
}
