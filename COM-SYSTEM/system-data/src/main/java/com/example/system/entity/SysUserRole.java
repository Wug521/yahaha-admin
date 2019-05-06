package com.example.system.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SysUserRole implements Serializable {
    /**
     * ID
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;

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
     * 表字段：MEETING.SYS_USER_ROLE.ID
     * </pre>
     *
     * @return MEETING.SYS_USER_ROLE.ID：ID
     */
    public Long getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：ID
     * 表字段：MEETING.SYS_USER_ROLE.ID
     * </pre>
     *
     * @param id
     *            MEETING.SYS_USER_ROLE.ID：ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：用户ID
     * 表字段：MEETING.SYS_USER_ROLE.USER_ID
     * </pre>
     *
     * @return MEETING.SYS_USER_ROLE.USER_ID：用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * <pre>
     * 设置：用户ID
     * 表字段：MEETING.SYS_USER_ROLE.USER_ID
     * </pre>
     *
     * @param userId
     *            MEETING.SYS_USER_ROLE.USER_ID：用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * <pre>
     * 获取：角色ID
     * 表字段：MEETING.SYS_USER_ROLE.ROLE_ID
     * </pre>
     *
     * @return MEETING.SYS_USER_ROLE.ROLE_ID：角色ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * <pre>
     * 设置：角色ID
     * 表字段：MEETING.SYS_USER_ROLE.ROLE_ID
     * </pre>
     *
     * @param roleId
     *            MEETING.SYS_USER_ROLE.ROLE_ID：角色ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * <pre>
     * 获取：创建用户
     * 表字段：MEETING.SYS_USER_ROLE.CREATE_USER_ID
     * </pre>
     *
     * @return MEETING.SYS_USER_ROLE.CREATE_USER_ID：创建用户
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * <pre>
     * 设置：创建用户
     * 表字段：MEETING.SYS_USER_ROLE.CREATE_USER_ID
     * </pre>
     *
     * @param createUserId
     *            MEETING.SYS_USER_ROLE.CREATE_USER_ID：创建用户
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * <pre>
     * 获取：创建时间
     * 表字段：MEETING.SYS_USER_ROLE.CREATE_DATE
     * </pre>
     *
     * @return MEETING.SYS_USER_ROLE.CREATE_DATE：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：创建时间
     * 表字段：MEETING.SYS_USER_ROLE.CREATE_DATE
     * </pre>
     *
     * @param createDate
     *            MEETING.SYS_USER_ROLE.CREATE_DATE：创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：修改用户
     * 表字段：MEETING.SYS_USER_ROLE.UPDATE_USER_ID
     * </pre>
     *
     * @return MEETING.SYS_USER_ROLE.UPDATE_USER_ID：修改用户
     */
    public Long getUpdateUserId() {
        return updateUserId;
    }

    /**
     * <pre>
     * 设置：修改用户
     * 表字段：MEETING.SYS_USER_ROLE.UPDATE_USER_ID
     * </pre>
     *
     * @param updateUserId
     *            MEETING.SYS_USER_ROLE.UPDATE_USER_ID：修改用户
     */
    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * <pre>
     * 获取：修改时间
     * 表字段：MEETING.SYS_USER_ROLE.UPDATE_DATE
     * </pre>
     *
     * @return MEETING.SYS_USER_ROLE.UPDATE_DATE：修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * <pre>
     * 设置：修改时间
     * 表字段：MEETING.SYS_USER_ROLE.UPDATE_DATE
     * </pre>
     *
     * @param updateDate
     *            MEETING.SYS_USER_ROLE.UPDATE_DATE：修改时间
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
        SysUserRole other = (SysUserRole) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
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
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
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
        sb.append(", userId=").append(userId);
        sb.append(", roleId=").append(roleId);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}