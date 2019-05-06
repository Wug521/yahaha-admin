package com.example.system.vo;

import com.example.system.entity.SysResource;

/**
 * 文件名：SysResourceVo.java
 * 日　期：2017年1月18日 下午4:03:44
 * 版　权：ZJAPL
 * 作　者：liss
 * 类说明：
 */
public class SysResourceVo extends SysResource{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4195880489641008897L;
	
	//父资源名称
	private String pIdName;
	
	private String statusName;
	
	private String leafName;
	
	private String ids;

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getLeafName() {
		return leafName;
	}

	public void setLeafName(String leafName) {
		this.leafName = leafName;
	}

	public String getpIdName() {
		return pIdName;
	}

	public void setpIdName(String pIdName) {
		this.pIdName = pIdName;
	}
	
	

}
