package com.example.yahaha.entity.vo;

import com.example.yahaha.entity.Game;

import java.util.Date;

public class GameVo extends Game {
	private static final long serialVersionUID = 1L;
	private Long wishId;
	private Date createTime;
    private Date changeTime;

    public Boolean getNewDiscount() {
        return newDiscount;
    }

    public void setNewDiscount(Boolean newDiscount) {
        this.newDiscount = newDiscount;
    }

    private Boolean newDiscount;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    public Long getWishId() {
		return wishId;
	}

	public void setWishId(Long wishId) {
		this.wishId = wishId;
	}
}
