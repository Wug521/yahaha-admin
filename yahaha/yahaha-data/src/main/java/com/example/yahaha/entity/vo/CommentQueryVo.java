package com.example.yahaha.entity.vo;

import com.github.pagehelper.PageInfo;

public class CommentQueryVo extends PageInfo<Object> {
	
	private static final long serialVersionUID = 1L;
	
	private Long topicId;
	
	private Short source;

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public Short getSource() {
		return source;
	}

	public void setSource(Short source) {
		this.source = source;
	}
	
}