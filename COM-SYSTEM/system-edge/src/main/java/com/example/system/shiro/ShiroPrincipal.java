package com.example.system.shiro;

import java.io.Serializable;
import java.util.List;

import com.example.system.entity.SysDept;
import com.example.system.entity.SysUser;
import com.zjapl.common.vo.TreeMenuVo;


/**
 * 
 * 文件名：ShiroPrincipal.java
 * 版本号：V 1.0
 * 日　期：2016年5月19日
 * 版　权：ZJAPL
 * 作　者：wuzy
 * 类说明：
 */
public class ShiroPrincipal implements Serializable{
    
    private static final long serialVersionUID = -4803693337395282370L;
	public static final String SHIRO_PRINCIPAL_KEY = "shiro_principal_key";
	// 当前用户
	private SysUser sysUser;
	// 当前用户的角色集合
	private List<String> roleList;
	// 当前用户的授权资源集合
	private List<String> authorizationList;
	// 当前用户的功能菜单
	private List<TreeMenuVo> menuList;
	//获取当前用户所属机构信息
	private List<SysDept> sysDepts;
	
	public Long getId(){
		return this.sysUser.getId();
	}
	public ShiroPrincipal(){
	}
	public ShiroPrincipal(SysUser sysUser){
		this.sysUser = sysUser;
	}
	public ShiroPrincipal(SysUser sysUser,List<SysDept> sysDepts){
		this.sysUser = sysUser;
		this.sysDepts = sysDepts;
	}
	public SysUser getSysUser() {
		return sysUser;
	}
	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
	public List<String> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<String> roleList) {
		this.roleList = roleList;
	}
	public List<String> getAuthorizationList() {
		return authorizationList;
	}
	public void setAuthorizationList(List<String> authorizationList) {
		this.authorizationList = authorizationList;
	}
	public static String getShiroPrincipalKey() {
		return SHIRO_PRINCIPAL_KEY;
	}
	public List<SysDept> getSysDepts() {
		return sysDepts;
	}
	public void setSysDepts(List<SysDept> sysDepts) {
		this.sysDepts = sysDepts;
	}
	public List<TreeMenuVo> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<TreeMenuVo> menuList) {
		this.menuList = menuList;
	}
}
