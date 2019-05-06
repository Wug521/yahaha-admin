package com.example.system.edge.ctrl;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.system.base.BaseController;
import com.example.system.edge.service.SysRoleResourceService;
import com.zjapl.common.result.ResultEx;

/**
 * 
 * 文件名：SysRoleResourceController.java
 * 日　期：2017年1月13日 上午9:52:11
 * 版　权：ZJAPL
 * 作　者：liss
 * 类说明：
 */
@Controller
@RequestMapping("/api/sysRoleResource")
public class ApiSysRoleResourceController extends BaseController{
	
	@Resource
	private SysRoleResourceService sysRoleResourceService;
	/**
	 * 角色配置资源权限
	 * @param roleId 		角色ID
	 * @param resourceId	资源ID
	 * @return
	 */
	@RequestMapping("/configurationRoleResource")
	@ResponseBody
	public ResultEx configurationRoleResource(@RequestParam("roleId") Long roleId,@RequestParam("resourceIds") String resourceIds){
		return sysRoleResourceService.addRoleResource(roleId, resourceIds, getSysUser());
	}
	
	/**
	 * 根据角色获取资源
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryResourceByRoleId")
	public Object queryResourceByRoleId(@RequestParam("roleId") Long roleId){
		return sysRoleResourceService.getAllResourcesAndCheckedMenuByRoleId(roleId);
	}

}
