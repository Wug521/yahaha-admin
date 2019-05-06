package com.example.system.vo;

import com.github.pagehelper.PageInfo;

public class QuerySysDeptVo extends PageInfo<Object>{
	
	private Long id;
	private String deptName;
	/**
     * 部门类型
     */
	private Short deptType;
	
	public Short getDeptType() {
		return deptType;
	}

	public void setDeptType(Short deptType) {
		this.deptType = deptType;
	}

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
