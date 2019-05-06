package com.example.system.edge.ctrl;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.system.base.BaseController;
import com.example.system.edge.service.SysRoleService;
import com.example.system.vo.QuerySysRoleVo;
import com.example.system.vo.SysRoleVo;
import com.zjapl.common.result.ResultEx;

/**
 * 
 * 文件名：SysRoleController.java
 * 日　期：2017年1月13日 上午9:36:31
 * 版　权：ZJAPL
 * 作　者：liss
 * 类说明：
 */
@Controller
@RequestMapping("/api/sysRole")
public class ApiSysRoleController extends BaseController{
	
	@Resource
	private SysRoleService sysRoleService;
	
	@RequestMapping("/list")
	@ResponseBody
	public ResultEx querySysRoleList(@Validated QuerySysRoleVo querySysRoleVo){
		return sysRoleService.queryRoleList(querySysRoleVo,getSysUser());
	}
	
	@RequestMapping("/addOrEdit")
	@ResponseBody
	public ResultEx addOrEditSysRole(@Validated SysRoleVo sysRoleVo){
		return sysRoleService.addOrEditRole(sysRoleVo,getSysUser());
	}
	
	@RequestMapping("/updateState")
	@ResponseBody
	public ResultEx delSysRole(@Validated SysRoleVo param){
		return sysRoleService.updateSysRoleStatusById(param, getSysUser());
	}
	
	/**
	 * 查询用户列表
	 * @param sysUserVo
	 * @return
	 */
	@RequestMapping("/queryRole")
	@ResponseBody
	public ResultEx queryUserById(@Validated Long id){
		return sysRoleService.querySysRoleById(id);
	}

	/**
	 * 查询未选择用户角色
	 * @param sysUserVo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryRoleListNotExit")
	public ResultEx queryRoleListNotExit(@RequestParam("userId") Long id){
		return sysRoleService.queryRoleListNotExit(id,getSysUser());
	}
	
	/**
	 * 查询已选择用户角色
	 * @param sysUserVo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryRoleListByUserId")
	public ResultEx queryRoleListByUserId(@RequestParam("userId") Long id){
		return sysRoleService.queryRoleListExit(id);
	}
	
}
