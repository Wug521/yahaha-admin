package com.example.yahaha.entity.vo;

import com.example.yahaha.entity.Comment;

public class CommentVo extends Comment {
	private static final long serialVersionUID = 1L;
	
	private Integer praiseNum;
	
	private Integer trampleNum;
	
	private boolean praise;
	
	private boolean trample;
	
	private String avatarUrl;

	public Integer getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(Integer praiseNum) {
		this.praiseNum = praiseNum;
	}

	public Integer getTrampleNum() {
		return trampleNum;
	}

	public void setTrampleNum(Integer trampleNum) {
		this.trampleNum = trampleNum;
	}

	public boolean getPraise() {
		return praise;
	}

	public void setPraise(boolean praise) {
		this.praise = praise;
	}

	public boolean getTrample() {
		return trample;
	}

	public void setTrample(boolean trample) {
		this.trample = trample;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	
}
