package com.example.system.edge.app.ctrl;

import com.example.system.dao.ISysUserDao;
import com.example.system.edge.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.system.entity.SysUser;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;
import com.zjapl.common.util.AESParamUtil;

import java.io.IOException;

/**
 * 登陆授权
 * @author liujg
 *
 */
@Controller
@RequestMapping(value = "/app/auth", method = RequestMethod.POST)
public class AppAuthController extends AppBaseController{
	Logger logger = LoggerFactory.getLogger(AppAuthController.class);

	@Autowired
	WxUtils wxUtils;
	@Autowired
	IUserService sysUserService;
	@Autowired
	ISysUserDao userDao;

	@ResponseBody
	@RequestMapping(value = "/login")
	public Object login(@RequestBody WxAppModel model) throws IOException {
		String openId = wxUtils.getOpenId(model.getCode());
		SysUser sysUser = new SysUser();
		sysUser.setUsername(openId);
		sysUser = userDao.selectOne(sysUser);
		if (sysUser == null) {
			sysUser = new SysUser();
			sysUser.setUsername(openId);
			sysUser.setPassword("21218cca77804d2ba1922c33e0151105");
			sysUser.setSex(model.getGender().shortValue());
			sysUser.setRealName(model.getNickName());
			sysUser.setAvatarUrl(model.getAvatarUrl());
			sysUser.setRemark(model.getCountry() + "-" + model.getProvince() + "-" + model.getCity());
			userDao.insert(sysUser);
		}
		AuthenticationToken token = new UsernamePasswordToken(openId,"888888");
		SecurityUtils.getSubject().login(token);
		return new ResultEx().makeSuccessResult();
	}

}
