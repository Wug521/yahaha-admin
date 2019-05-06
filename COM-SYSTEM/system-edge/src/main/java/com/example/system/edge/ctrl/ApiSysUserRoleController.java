package com.example.system.edge.ctrl;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.system.base.BaseController;
import com.example.system.edge.service.SysUserRoleService;
import com.zjapl.common.result.ResultEx;

/**
 * 
 * 文件名：SysUserRoleController.java
 * 日　期：2017年1月13日 上午9:51:19
 * 版　权：ZJAPL
 * 作　者：liss
 * 类说明：
 */
@Controller
@RequestMapping("/api/sysUserRole")
public class ApiSysUserRoleController extends BaseController{

	@Resource
	private SysUserRoleService sysUserRoleService;
	
	@RequestMapping("/configurationRole")
	@ResponseBody
	public ResultEx configurationRole(String param){
		return sysUserRoleService.addSysUserRoleDao(param, getSysUser());
	}
	
	@RequestMapping("/queryUserRole")
	@ResponseBody
	public ResultEx queryUserRole(@RequestParam("userId")Long userId){
		return sysUserRoleService.queryRolesByUserId(userId);
	}
}
