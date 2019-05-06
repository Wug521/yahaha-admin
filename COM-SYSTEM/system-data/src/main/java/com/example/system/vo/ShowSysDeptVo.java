package com.example.system.vo;

import com.example.system.entity.SysDept;

/**
 * 文件名：ShowSysDeptVo.java 日　期：2017年1月19日 下午3:09:34 版　权：ZJAPL 作　者：ZFM 类说明：显示部门vo
 */
public class ShowSysDeptVo extends SysDept {
	private static final long serialVersionUID = 1L;
	
	private String pdeptName;
	private String statusName;
	private String deptTypeName;
	private String createUser;
	private String updateUser;
	
	private String realName;
	
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getDeptTypeName() {
		return deptTypeName;
	}

	public void setDeptTypeName(String deptTypeName) {
		this.deptTypeName = deptTypeName;
	}

	public String getPdeptName() {
		return pdeptName;
	}

	public void setPdeptName(String pdeptName) {
		this.pdeptName = pdeptName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}
