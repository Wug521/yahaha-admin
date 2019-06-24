package com.example.yahaha.entity.vo;

import com.github.pagehelper.PageInfo;

public class CollectQueryVo extends PageInfo<Object> {
	
	private static final long serialVersionUID = 1L;
	
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 类型(1:新闻 2:游戏)
     */
    private Short type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}
	
}