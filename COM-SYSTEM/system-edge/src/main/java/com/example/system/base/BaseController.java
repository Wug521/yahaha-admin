package com.example.system.base;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.example.system.entity.SysUser;
import com.example.system.shiro.ShiroUtils;
import com.example.system.vo.MenuVo;


@Controller
public abstract class BaseController{

	/**
	 * 从shiro中获取用户信息
	 * @return
	 */
	public SysUser getSysUser() {
		return ShiroUtils.getShiroPrincipal().getSysUser();
	}
	
	/**
	 * 从shiro中获取用户ID
	 * @return
	 */
	public Long getUserIdForUser() {
		return ShiroUtils.getShiroPrincipal().getSysUser().getId();
	}
	
	/**
	 * 从shiro中获取用户信息
	 * @return
	 */
	public String getOrgCodeForUser() {
		return ShiroUtils.getShiroPrincipal().getSysUser().getOrgCode();
	}
	
	/**
	 * 获取用户菜单资源信息
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<MenuVo> getMenuList() {
		return ShiroUtils.getShiroPrincipal().getMenuList();
	}
}
