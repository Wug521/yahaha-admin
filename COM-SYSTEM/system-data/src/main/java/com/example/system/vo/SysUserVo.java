package com.example.system.vo;

import com.example.system.entity.SysUser;

/**
 * 文件名：SysUserVo.java 日　期：2017年1月16日 版　权：ZJAPL 作　者：wug 类说明：
 */
public class SysUserVo extends SysUser {
	private static final long serialVersionUID = 1L;

	private String sexName;

	private String statusName;

	private String RoleNames;

	private String accountTypeName;

	public String getSexName() {
		return sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getRoleNames() {
		return RoleNames;
	}

	public void setRoleNames(String roleNames) {
		RoleNames = roleNames;
	}

	public String getAccountTypeName() {
		return accountTypeName;
	}

	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}

}
