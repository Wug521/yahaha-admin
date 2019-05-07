package com.example.system.vo;

import java.util.Set;

import com.example.system.entity.SysRoleResource;

public class SysRoleResourceVo extends SysRoleResource {
	private static final long serialVersionUID = 1L;
	
	//角色ids
	Set<Long> roleIds;
	
	//资源ids
	Set<Long> resourceIds;

	public Set<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Set<Long> roleIds) {
		this.roleIds = roleIds;
	}

	public Set<Long> getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(Set<Long> resourceIds) {
		this.resourceIds = resourceIds;
	}
}
