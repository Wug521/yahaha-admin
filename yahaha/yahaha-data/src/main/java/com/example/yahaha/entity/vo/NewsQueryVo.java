package com.example.yahaha.entity.vo;

import com.github.pagehelper.PageInfo;

public class NewsQueryVo extends PageInfo<Object> {
	private static final long serialVersionUID = 1L;
	
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 新闻标题
     */
    private String title;

    /**
     * 新闻内容
     */
    private String content;

    /**
     * 标签id集合
     */
    private String idsTag;	
    
    /**
     * 分类id集合
     */
    private String idsCategory;
    
    /**
     * 状态(数据)
     */
    private Short status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIdsTag() {
		return idsTag;
	}

	public void setIdsTag(String idsTag) {
		this.idsTag = idsTag;
	}

	public String getIdsCategory() {
		return idsCategory;
	}

	public void setIdsCategory(String idsCategory) {
		this.idsCategory = idsCategory;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}
    
    
	
}