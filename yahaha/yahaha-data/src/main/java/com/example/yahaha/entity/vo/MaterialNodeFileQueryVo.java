package com.example.yahaha.entity.vo;

import com.github.pagehelper.PageInfo;

public class MaterialNodeFileQueryVo extends PageInfo<Object> {
	private static final long serialVersionUID = 1L;
	
	/**
     * 素材节点表id
     */
    private Long mid;

	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
	}
    
    
}