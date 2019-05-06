package com.example.system.edge.app.ctrl;

import javax.annotation.Resource;

import com.example.system.base.BaseController;
import com.example.system.edge.app.service.AppBaseServiceImpl;
import com.example.system.entity.SysUser;

public class AppBaseController extends BaseController {
	@Resource
	protected AppBaseServiceImpl appBaseService;
	/**
	 * 从缓存中获取用户信息
	 * @return
	 */
	public SysUser getSysUserByToken(String token) {
		return appBaseService.getUserInfoByToken(token);
	}
}
