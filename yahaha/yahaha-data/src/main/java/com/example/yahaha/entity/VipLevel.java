/**
 * Copyright(C) 2006-2016 安普利科技
 * All rights reserved
 * 2019-05-29 10:08:22 Created
 * 
 */
package com.example.yahaha.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class VipLevel implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private Integer integralPoint;

    private String title;

    private String headUrl;

    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 获取：
     * 表字段：vip_level.id
     * </pre>
     *
     * @return vip_level.id：
     */
    public Integer getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：vip_level.id
     * </pre>
     *
     * @param id
     *            vip_level.id：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：vip_level.integral_point
     * </pre>
     *
     * @return vip_level.integral_point：
     */
    public Integer getIntegralPoint() {
        return integralPoint;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：vip_level.integral_point
     * </pre>
     *
     * @param integralPoint
     *            vip_level.integral_point：
     */
    public void setIntegralPoint(Integer integralPoint) {
        this.integralPoint = integralPoint;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：vip_level.title
     * </pre>
     *
     * @return vip_level.title：
     */
    public String getTitle() {
        return title;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：vip_level.title
     * </pre>
     *
     * @param title
     *            vip_level.title：
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：vip_level.head_url
     * </pre>
     *
     * @return vip_level.head_url：
     */
    public String getHeadUrl() {
        return headUrl;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：vip_level.head_url
     * </pre>
     *
     * @param headUrl
     *            vip_level.head_url：
     */
    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl == null ? null : headUrl.trim();
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
        VipLevel other = (VipLevel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIntegralPoint() == null ? other.getIntegralPoint() == null : this.getIntegralPoint().equals(other.getIntegralPoint()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getHeadUrl() == null ? other.getHeadUrl() == null : this.getHeadUrl().equals(other.getHeadUrl()));
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIntegralPoint() == null) ? 0 : getIntegralPoint().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getHeadUrl() == null) ? 0 : getHeadUrl().hashCode());
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
        sb.append(", integralPoint=").append(integralPoint);
        sb.append(", title=").append(title);
        sb.append(", headUrl=").append(headUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}