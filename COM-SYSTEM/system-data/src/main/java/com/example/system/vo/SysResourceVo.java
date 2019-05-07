package com.example.system.vo;

import com.example.system.entity.SysResource;

public class SysResourceVo extends SysResource {
	private static final long serialVersionUID = 1L;
	
	private String pidName;
	
	private String statusName;

	public String getPidName() {
		return pidName;
	}

	public void setPidName(String pidName) {
		this.pidName = pidName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
}
