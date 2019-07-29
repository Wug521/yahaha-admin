/**
 * Copyright(C) 2006-2016 安普利科技
 * All rights reserved
 * 2019-07-29 09:36:41 Created
 * 
 */
package com.example.yahaha.entity;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class Wish implements Serializable {
    private Long userId;
    @Id
    private Integer id;

    @NotNull
    private Long gameId;

    private String gameTitle;

    private Date flagTime;

    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 获取：
     * 表字段：wish.user_id
     * </pre>
     *
     * @return wish.user_id：
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：wish.user_id
     * </pre>
     *
     * @param userId
     *            wish.user_id：
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：wish.id
     * </pre>
     *
     * @return wish.id：
     */
    public Integer getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：wish.id
     * </pre>
     *
     * @param id
     *            wish.id：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：wish.game_id
     * </pre>
     *
     * @return wish.game_id：
     */
    public Long getGameId() {
        return gameId;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：wish.game_id
     * </pre>
     *
     * @param gameId
     *            wish.game_id：
     */
    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：wish.game_title
     * </pre>
     *
     * @return wish.game_title：
     */
    public String getGameTitle() {
        return gameTitle;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：wish.game_title
     * </pre>
     *
     * @param gameTitle
     *            wish.game_title：
     */
    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle == null ? null : gameTitle.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：wish.flag_time
     * </pre>
     *
     * @return wish.flag_time：
     */
    public Date getFlagTime() {
        return flagTime;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：wish.flag_time
     * </pre>
     *
     * @param flagTime
     *            wish.flag_time：
     */
    public void setFlagTime(Date flagTime) {
        this.flagTime = flagTime;
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
        Wish other = (Wish) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGameId() == null ? other.getGameId() == null : this.getGameId().equals(other.getGameId()))
            && (this.getGameTitle() == null ? other.getGameTitle() == null : this.getGameTitle().equals(other.getGameTitle()))
            && (this.getFlagTime() == null ? other.getFlagTime() == null : this.getFlagTime().equals(other.getFlagTime()));
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGameId() == null) ? 0 : getGameId().hashCode());
        result = prime * result + ((getGameTitle() == null) ? 0 : getGameTitle().hashCode());
        result = prime * result + ((getFlagTime() == null) ? 0 : getFlagTime().hashCode());
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
        sb.append(", userId=").append(userId);
        sb.append(", id=").append(id);
        sb.append(", gameId=").append(gameId);
        sb.append(", gameTitle=").append(gameTitle);
        sb.append(", flagTime=").append(flagTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}