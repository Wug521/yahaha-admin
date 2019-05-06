/**
 * Copyright(C) 2006-2016 安普利科技
 * All rights reserved
 * 2017-03-06 16:16:23 Created
 * 
 */
package com.example.system.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SysRoleResource implements Serializable {
    /**
     * ID
     */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    private Long id;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 资源ID
     */
    private Long resourceId;

    /**
     * 创建用户
     */
    private Long createUserId;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改用户
     */
    private Long updateUserId;

    /**
     * 修改时间
     */
    private Date updateDate;

    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 获取：ID
     * 表字段：MEETING.SYS_ROLE_RESOURCE.ID
     * </pre>
     *
     * @return MEETING.SYS_ROLE_RESOURCE.ID：ID
     */
    public Long getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：ID
     * 表字段：MEETING.SYS_ROLE_RESOURCE.ID
     * </pre>
     *
     * @param id
     *            MEETING.SYS_ROLE_RESOURCE.ID：ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：角色ID
     * 表字段：MEETING.SYS_ROLE_RESOURCE.ROLE_ID
     * </pre>
     *
     * @return MEETING.SYS_ROLE_RESOURCE.ROLE_ID：角色ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * <pre>
     * 设置：角色ID
     * 表字段：MEETING.SYS_ROLE_RESOURCE.ROLE_ID
     * </pre>
     *
     * @param roleId
     *            MEETING.SYS_ROLE_RESOURCE.ROLE_ID：角色ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * <pre>
     * 获取：资源ID
     * 表字段：MEETING.SYS_ROLE_RESOURCE.RESOURCE_ID
     * </pre>
     *
     * @return MEETING.SYS_ROLE_RESOURCE.RESOURCE_ID：资源ID
     */
    public Long getResourceId() {
        return resourceId;
    }

    /**
     * <pre>
     * 设置：资源ID
     * 表字段：MEETING.SYS_ROLE_RESOURCE.RESOURCE_ID
     * </pre>
     *
     * @param resourceId
     *            MEETING.SYS_ROLE_RESOURCE.RESOURCE_ID：资源ID
     */
    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * <pre>
     * 获取：创建用户
     * 表字段：MEETING.SYS_ROLE_RESOURCE.CREATE_USER_ID
     * </pre>
     *
     * @return MEETING.SYS_ROLE_RESOURCE.CREATE_USER_ID：创建用户
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * <pre>
     * 设置：创建用户
     * 表字段：MEETING.SYS_ROLE_RESOURCE.CREATE_USER_ID
     * </pre>
     *
     * @param createUserId
     *            MEETING.SYS_ROLE_RESOURCE.CREATE_USER_ID：创建用户
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * <pre>
     * 获取：创建时间
     * 表字段：MEETING.SYS_ROLE_RESOURCE.CREATE_DATE
     * </pre>
     *
     * @return MEETING.SYS_ROLE_RESOURCE.CREATE_DATE：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：创建时间
     * 表字段：MEETING.SYS_ROLE_RESOURCE.CREATE_DATE
     * </pre>
     *
     * @param createDate
     *            MEETING.SYS_ROLE_RESOURCE.CREATE_DATE：创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：修改用户
     * 表字段：MEETING.SYS_ROLE_RESOURCE.UPDATE_USER_ID
     * </pre>
     *
     * @return MEETING.SYS_ROLE_RESOURCE.UPDATE_USER_ID：修改用户
     */
    public Long getUpdateUserId() {
        return updateUserId;
    }

    /**
     * <pre>
     * 设置：修改用户
     * 表字段：MEETING.SYS_ROLE_RESOURCE.UPDATE_USER_ID
     * </pre>
     *
     * @param updateUserId
     *            MEETING.SYS_ROLE_RESOURCE.UPDATE_USER_ID：修改用户
     */
    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * <pre>
     * 获取：修改时间
     * 表字段：MEETING.SYS_ROLE_RESOURCE.UPDATE_DATE
     * </pre>
     *
     * @return MEETING.SYS_ROLE_RESOURCE.UPDATE_DATE：修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * <pre>
     * 设置：修改时间
     * 表字段：MEETING.SYS_ROLE_RESOURCE.UPDATE_DATE
     * </pre>
     *
     * @param updateDate
     *            MEETING.SYS_ROLE_RESOURCE.UPDATE_DATE：修改时间
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
        SysRoleResource other = (SysRoleResource) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getResourceId() == null ? other.getResourceId() == null : this.getResourceId().equals(other.getResourceId()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateUserId() == null ? other.getUpdateUserId() == null : this.getUpdateUserId().equals(other.getUpdateUserId()))
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
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getResourceId() == null) ? 0 : getResourceId().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateUserId() == null) ? 0 : getUpdateUserId().hashCode());
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
        sb.append(", roleId=").append(roleId);
        sb.append(", resourceId=").append(resourceId);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}