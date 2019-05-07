package com.example.system.vo;

import com.example.system.entity.SysRole;

/**
 * 文件名：SysRoleVo.java
 * 日　期：2017年1月17日
 * 版　权：ZJAPL
 * 作　者：wug
 * 类说明：
 */
public class SysRoleVo extends SysRole{
	private static final long serialVersionUID = 1L;
	
	private String resourceJson;
	
	private String statusName;
	
	private boolean flag;
	
	private Long userId;

	public String getResourceJson() {
		return resourceJson;
	}

	public void setResourceJson(String resourceJson) {
		this.resourceJson = resourceJson;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
