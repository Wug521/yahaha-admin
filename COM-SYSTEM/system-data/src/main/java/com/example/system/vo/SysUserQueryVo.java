package com.example.system.vo;

import com.github.pagehelper.PageInfo;

public class SysUserQueryVo extends PageInfo<Object> {
	private static final long serialVersionUID = 1L;
	
	private Long deptId;
	
	private String realName;
	
	private Short accountType;

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Short getAccountType() {
		return accountType;
	}

	public void setAccountType(Short accountType) {
		this.accountType = accountType;
	}
	
}