package com.example.yahaha.entity.vo;

import com.github.pagehelper.PageInfo;

/**
 * yahaha
 *
 * @author create by yangb in 2019/7/29
 */
public class WishQueryVo extends PageInfo {

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
