package com.example.system.vo;

import com.github.pagehelper.PageInfo;

public class SysResourceQueryVo extends PageInfo<Object> {
	private static final long serialVersionUID = 1L;
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}