/**
 * Copyright(C) 2006-2016 安普利科技
 * All rights reserved
 * 2019-07-29 15:44:14 Created
 * 
 */
package com.example.yahaha.entity;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class Wishes implements Serializable {
    @Id
    private Integer id;

    private Long userId;
    @NotNull
    private Long gameId;

    private String gameTitle;

    private Date createTime;

    private Date changeTime;

    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 获取：
     * 表字段：wishes.id
     * </pre>
     *
     * @return wishes.id：
     */
    public Integer getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：wishes.id
     * </pre>
     *
     * @param id
     *            wishes.id：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：wishes.user_id
     * </pre>
     *
     * @return wishes.user_id：
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：wishes.user_id
     * </pre>
     *
     * @param userId
     *            wishes.user_id：
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：wishes.game_id
     * </pre>
     *
     * @return wishes.game_id：
     */
    public Long getGameId() {
        return gameId;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：wishes.game_id
     * </pre>
     *
     * @param gameId
     *            wishes.game_id：
     */
    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：wishes.game_title
     * </pre>
     *
     * @return wishes.game_title：
     */
    public String getGameTitle() {
        return gameTitle;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：wishes.game_title
     * </pre>
     *
     * @param gameTitle
     *            wishes.game_title：
     */
    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle == null ? null : gameTitle.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：wishes.create_time
     * </pre>
     *
     * @return wishes.create_time：
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：wishes.create_time
     * </pre>
     *
     * @param createTime
     *            wishes.create_time：
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：wishes.change_time
     * </pre>
     *
     * @return wishes.change_time：
     */
    public Date getChangeTime() {
        return changeTime;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：wishes.change_time
     * </pre>
     *
     * @param changeTime
     *            wishes.change_time：
     */
    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    /**
     *
     * @param that
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Wishes other = (Wishes) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getGameId() == null ? other.getGameId() == null : this.getGameId().equals(other.getGameId()))
            && (this.getGameTitle() == null ? other.getGameTitle() == null : this.getGameTitle().equals(other.getGameTitle()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getChangeTime() == null ? other.getChangeTime() == null : this.getChangeTime().equals(other.getChangeTime()));
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getGameId() == null) ? 0 : getGameId().hashCode());
        result = prime * result + ((getGameTitle() == null) ? 0 : getGameTitle().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getChangeTime() == null) ? 0 : getChangeTime().hashCode());
        return result;
    }

    /**
     *
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", gameId=").append(gameId);
        sb.append(", gameTitle=").append(gameTitle);
        sb.append(", createTime=").append(createTime);
        sb.append(", changeTime=").append(changeTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}