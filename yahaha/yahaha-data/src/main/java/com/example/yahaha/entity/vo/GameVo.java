package com.example.yahaha.entity.vo;

import com.example.yahaha.entity.Game;

import java.util.Date;

public class GameVo extends Game {
	private static final long serialVersionUID = 1L;
	private Long wishId;
	private Date flagTime;

	public Long getWishId() {
		return wishId;
	}

	public void setWishId(Long wishId) {
		this.wishId = wishId;
	}
}
