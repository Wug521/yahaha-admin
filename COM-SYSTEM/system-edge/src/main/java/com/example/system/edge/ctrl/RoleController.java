package com.example.system.edge.ctrl;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.system.base.BaseController;
import com.example.system.edge.service.IRoleService;
import com.example.system.vo.SysRoleQueryVo;
import com.example.system.vo.SysRoleVo;
import com.zjapl.common.result.ResultEx;

@Controller
@RequestMapping(value="/role")
public class RoleController extends BaseController{
	
	@Resource
	private IRoleService roleService;
	
	/**
	 * 查询账套list
	 * @param querySysRoleVo
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public ResultEx querySysRoleList(@Validated SysRoleQueryVo querySysRoleVo){
		return roleService.queryListByUser(querySysRoleVo,getOrgCodeForUser());
	}
	
	/**
	 * 添加、修改
	 * @param roleVo
	 * @return
	 */
	@RequestMapping("/addOrEdit")
	@ResponseBody
	public ResultEx addOrEditSysRole(@RequestBody SysRoleVo roleVo){
		return roleService.saveOrEdit(roleVo,getUserIdForUser(),getOrgCodeForUser());
	}
	
	/**
	 * 删除
	 * @param ids
	 * @param status
	 * @return
	 */
	@RequestMapping("/updateStatus")
	@ResponseBody
	public ResultEx delSysRole(String ids,Short status){
		return roleService.editStatus(ids, status, getUserIdForUser());
	}
	
	/**
	 * 查询用户账套列表
	 * @param id
	 * @return
	 */
	@RequestMapping("/queryRole")
	@ResponseBody
	public ResultEx queryUserById(@Validated Long id){
		return roleService.queryListByUserId(id);
	}
	
	/**
	 * 用户配置权限(左右穿梭框数据集)
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/power/list")
	public ResultEx powerList(@RequestParam("userId") Long userId) {
		return roleService.queryRoleListByUserId(userId,getOrgCodeForUser());
	}
}
