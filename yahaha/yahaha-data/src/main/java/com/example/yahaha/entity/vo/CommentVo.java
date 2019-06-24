package com.example.yahaha.entity.vo;

import com.example.yahaha.entity.Comment;

public class CommentVo extends Comment {
	private static final long serialVersionUID = 1L;
	
	private Integer praiseNum;
	
	private Integer trampleNum;
	
	private boolean praise;
	
	private boolean trample;

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

	public Boolean getPraise() {
		return praise;
	}

	public void setPraise(Boolean praise) {
		this.praise = praise;
	}

	public Boolean getTrample() {
		return trample;
	}

	public void setTrample(Boolean trample) {
		this.trample = trample;
	}
	
	
}
