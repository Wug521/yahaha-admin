package com.example.system.vo;

import com.example.system.entity.SysUser;

/**
 * 文件名：ShowSysUserVo.java
 * 日　期：2017年1月17日 下午8:04:32
 * 版　权：ZJAPL
 * 作　者：ZFM
 * 类说明：显示vo
 */
public class ShowSysUserVo extends SysUser{
	private static final long serialVersionUID = 1L;
	
	private String sexName;
	
    private String statusName;
    
    private String deptName;
    
    private String deptsName;
    
    private String deptIds;
    
    private String ids;
    
    private String oldpass;
    
    /**
     * 用户身份
     */
    private String accountTypeName;
    
	public String getAccountTypeName() {
		return accountTypeName;
	}

	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}

	public String getOldpass() {
		return oldpass;
	}

	public void setOldpass(String oldpass) {
		this.oldpass = oldpass;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getDeptIds() {
		return deptIds;
	}

	public void setDeptIds(String deptIds) {
		this.deptIds = deptIds;
	}

	public String getDeptsName() {
		return deptsName;
	}

	public void setDeptsName(String deptsName) {
		this.deptsName = deptsName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

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
  
}
