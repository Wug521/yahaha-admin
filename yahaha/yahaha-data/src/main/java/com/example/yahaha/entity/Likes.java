/**
 * Copyright(C) 2006-2016 安普利科技
 * All rights reserved
 * 2019-06-19 14:59:02 Created
 * 
 */
package com.example.yahaha.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Likes implements Serializable {
    /**
     * id主键
     */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * 来源id
     */
    private Long sourceId;

    /**
     * 点赞类型
     */
    private Short type;

    /**
     * 点赞人
     */
    private Long userId;

    /**
     * 状态(数据)
     */
    private Short status;

    /**
     * 机构编码
     */
    private String orgCode;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改人
     */
    private Long updateUser;

    /**
     * 修改时间
     */
    private Date updateDate;

    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 获取：id主键
     * 表字段：likes.id
     * </pre>
     *
     * @return likes.id：id主键
     */
    public Long getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：id主键
     * 表字段：likes.id
     * </pre>
     *
     * @param id
     *            likes.id：id主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：来源id
     * 表字段：likes.source_id
     * </pre>
     *
     * @return likes.source_id：来源id
     */
    public Long getSourceId() {
        return sourceId;
    }

    /**
     * <pre>
     * 设置：来源id
     * 表字段：likes.source_id
     * </pre>
     *
     * @param sourceId
     *            likes.source_id：来源id
     */
    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * <pre>
     * 获取：点赞类型
     * 表字段：likes.type
     * </pre>
     *
     * @return likes.type：点赞类型
     */
    public Short getType() {
        return type;
    }

    /**
     * <pre>
     * 设置：点赞类型
     * 表字段：likes.type
     * </pre>
     *
     * @param type
     *            likes.type：点赞类型
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     * <pre>
     * 获取：点赞人
     * 表字段：likes.user_id
     * </pre>
     *
     * @return likes.user_id：点赞人
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * <pre>
     * 设置：点赞人
     * 表字段：likes.user_id
     * </pre>
     *
     * @param userId
     *            likes.user_id：点赞人
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * <pre>
     * 获取：状态(数据)
     * 表字段：likes.status
     * </pre>
     *
     * @return likes.status：状态(数据)
     */
    public Short getStatus() {
        return status;
    }

    /**
     * <pre>
     * 设置：状态(数据)
     * 表字段：likes.status
     * </pre>
     *
     * @param status
     *            likes.status：状态(数据)
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * <pre>
     * 获取：机构编码
     * 表字段：likes.org_code
     * </pre>
     *
     * @return likes.org_code：机构编码
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * <pre>
     * 设置：机构编码
     * 表字段：likes.org_code
     * </pre>
     *
     * @param orgCode
     *            likes.org_code：机构编码
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * <pre>
     * 获取：创建人
     * 表字段：likes.create_user
     * </pre>
     *
     * @return likes.create_user：创建人
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * <pre>
     * 设置：创建人
     * 表字段：likes.create_user
     * </pre>
     *
     * @param createUser
     *            likes.create_user：创建人
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * <pre>
     * 获取：创建时间
     * 表字段：likes.create_date
     * </pre>
     *
     * @return likes.create_date：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：创建时间
     * 表字段：likes.create_date
     * </pre>
     *
     * @param createDate
     *            likes.create_date：创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：修改人
     * 表字段：likes.update_user
     * </pre>
     *
     * @return likes.update_user：修改人
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * <pre>
     * 设置：修改人
     * 表字段：likes.update_user
     * </pre>
     *
     * @param updateUser
     *            likes.update_user：修改人
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * <pre>
     * 获取：修改时间
     * 表字段：likes.update_date
     * </pre>
     *
     * @return likes.update_date：修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * <pre>
     * 设置：修改时间
     * 表字段：likes.update_date
     * </pre>
     *
     * @param updateDate
     *            likes.update_date：修改时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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
        Likes other = (Likes) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSourceId() == null ? other.getSourceId() == null : this.getSourceId().equals(other.getSourceId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getOrgCode() == null ? other.getOrgCode() == null : this.getOrgCode().equals(other.getOrgCode()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()));
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSourceId() == null) ? 0 : getSourceId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getOrgCode() == null) ? 0 : getOrgCode().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
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
        sb.append(", sourceId=").append(sourceId);
        sb.append(", type=").append(type);
        sb.append(", userId=").append(userId);
        sb.append(", status=").append(status);
        sb.append(", orgCode=").append(orgCode);
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}