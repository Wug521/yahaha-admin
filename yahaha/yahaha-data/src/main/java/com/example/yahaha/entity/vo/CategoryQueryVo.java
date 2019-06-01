package com.example.yahaha.entity.vo;

import com.github.pagehelper.PageInfo;

public class CategoryQueryVo extends PageInfo<Object> {
	
	private static final long serialVersionUID = 1L;
	
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 名称
     */
    private String name;
    
    /**
     * 类型(1:类别 2:标签)
     */
    private String type;
    
    /**
     * 名称
     */
    private Short scope;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Short getScope() {
		return scope;
	}

	public void setScope(Short scope) {
		this.scope = scope;
	}
	
}