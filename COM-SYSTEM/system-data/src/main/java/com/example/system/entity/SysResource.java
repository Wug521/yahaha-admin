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

public class SysResource implements Serializable {
    /**
     * 资源流水号
     */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    private Long id;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源类型 0: 菜单类型, 1 安全类型
     */
    private Short type;

    /**
     * 父节点
     */
    private Long pId;

    /**
     * 资源url
     */
    private String value;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排序号
     */
    private Short sort;

    /**
     * 是否生效，0否，1是
     */
    private Short status;

    /**
     * 是否叶子节点，0否 1是
     */
    private Short leaf;

    /**
     * 权限
     */
    private String permission;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 创建用户
     */
    private Long createUserId;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 修改用户
     */
    private Long updateUserId;

    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 获取：资源流水号
     * 表字段：MEETING.SYS_RESOURCE.ID
     * </pre>
     *
     * @return MEETING.SYS_RESOURCE.ID：资源流水号
     */
    public Long getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：资源流水号
     * 表字段：MEETING.SYS_RESOURCE.ID
     * </pre>
     *
     * @param id
     *            MEETING.SYS_RESOURCE.ID：资源流水号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：资源名称
     * 表字段：MEETING.SYS_RESOURCE.NAME
     * </pre>
     *
     * @return MEETING.SYS_RESOURCE.NAME：资源名称
     */
    public String getName() {
        return name;
    }

    /**
     * <pre>
     * 设置：资源名称
     * 表字段：MEETING.SYS_RESOURCE.NAME
     * </pre>
     *
     * @param name
     *            MEETING.SYS_RESOURCE.NAME：资源名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * <pre>
     * 获取：资源类型 0: 菜单类型, 1 安全类型
     * 表字段：MEETING.SYS_RESOURCE.TYPE
     * </pre>
     *
     * @return MEETING.SYS_RESOURCE.TYPE：资源类型 0: 菜单类型, 1 安全类型
     */
    public Short getType() {
        return type;
    }

    /**
     * <pre>
     * 设置：资源类型 0: 菜单类型, 1 安全类型
     * 表字段：MEETING.SYS_RESOURCE.TYPE
     * </pre>
     *
     * @param type
     *            MEETING.SYS_RESOURCE.TYPE：资源类型 0: 菜单类型, 1 安全类型
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     * <pre>
     * 获取：父节点
     * 表字段：MEETING.SYS_RESOURCE.P_ID
     * </pre>
     *
     * @return MEETING.SYS_RESOURCE.P_ID：父节点
     */
    public Long getpId() {
        return pId;
    }

    /**
     * <pre>
     * 设置：父节点
     * 表字段：MEETING.SYS_RESOURCE.P_ID
     * </pre>
     *
     * @param pId
     *            MEETING.SYS_RESOURCE.P_ID：父节点
     */
    public void setpId(Long pId) {
        this.pId = pId;
    }

    /**
     * <pre>
     * 获取：资源url
     * 表字段：MEETING.SYS_RESOURCE.VALUE
     * </pre>
     *
     * @return MEETING.SYS_RESOURCE.VALUE：资源url
     */
    public String getValue() {
        return value;
    }

    /**
     * <pre>
     * 设置：资源url
     * 表字段：MEETING.SYS_RESOURCE.VALUE
     * </pre>
     *
     * @param value
     *            MEETING.SYS_RESOURCE.VALUE：资源url
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * <pre>
     * 获取：图标
     * 表字段：MEETING.SYS_RESOURCE.ICON
     * </pre>
     *
     * @return MEETING.SYS_RESOURCE.ICON：图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * <pre>
     * 设置：图标
     * 表字段：MEETING.SYS_RESOURCE.ICON
     * </pre>
     *
     * @param icon
     *            MEETING.SYS_RESOURCE.ICON：图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * <pre>
     * 获取：排序号
     * 表字段：MEETING.SYS_RESOURCE.SORT
     * </pre>
     *
     * @return MEETING.SYS_RESOURCE.SORT：排序号
     */
    public Short getSort() {
        return sort;
    }

    /**
     * <pre>
     * 设置：排序号
     * 表字段：MEETING.SYS_RESOURCE.SORT
     * </pre>
     *
     * @param sort
     *            MEETING.SYS_RESOURCE.SORT：排序号
     */
    public void setSort(Short sort) {
        this.sort = sort;
    }

    /**
     * <pre>
     * 获取：是否生效，0否，1是
     * 表字段：MEETING.SYS_RESOURCE.STATUS
     * </pre>
     *
     * @return MEETING.SYS_RESOURCE.STATUS：是否生效，0否，1是
     */
    public Short getStatus() {
        return status;
    }

    /**
     * <pre>
     * 设置：是否生效，0否，1是
     * 表字段：MEETING.SYS_RESOURCE.STATUS
     * </pre>
     *
     * @param status
     *            MEETING.SYS_RESOURCE.STATUS：是否生效，0否，1是
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * <pre>
     * 获取：是否叶子节点，0否 1是
     * 表字段：MEETING.SYS_RESOURCE.LEAF
     * </pre>
     *
     * @return MEETING.SYS_RESOURCE.LEAF：是否叶子节点，0否 1是
     */
    public Short getLeaf() {
        return leaf;
    }

    /**
     * <pre>
     * 设置：是否叶子节点，0否 1是
     * 表字段：MEETING.SYS_RESOURCE.LEAF
     * </pre>
     *
     * @param leaf
     *            MEETING.SYS_RESOURCE.LEAF：是否叶子节点，0否 1是
     */
    public void setLeaf(Short leaf) {
        this.leaf = leaf;
    }

    /**
     * <pre>
     * 获取：权限
     * 表字段：MEETING.SYS_RESOURCE.PERMISSION
     * </pre>
     *
     * @return MEETING.SYS_RESOURCE.PERMISSION：权限
     */
    public String getPermission() {
        return permission;
    }

    /**
     * <pre>
     * 设置：权限
     * 表字段：MEETING.SYS_RESOURCE.PERMISSION
     * </pre>
     *
     * @param permission
     *            MEETING.SYS_RESOURCE.PERMISSION：权限
     */
    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    /**
     * <pre>
     * 获取：备注
     * 表字段：MEETING.SYS_RESOURCE.REMARK
     * </pre>
     *
     * @return MEETING.SYS_RESOURCE.REMARK：备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * <pre>
     * 设置：备注
     * 表字段：MEETING.SYS_RESOURCE.REMARK
     * </pre>
     *
     * @param remark
     *            MEETING.SYS_RESOURCE.REMARK：备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * <pre>
     * 获取：创建时间
     * 表字段：MEETING.SYS_RESOURCE.CREATE_DATE
     * </pre>
     *
     * @return MEETING.SYS_RESOURCE.CREATE_DATE：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：创建时间
     * 表字段：MEETING.SYS_RESOURCE.CREATE_DATE
     * </pre>
     *
     * @param createDate
     *            MEETING.SYS_RESOURCE.CREATE_DATE：创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：创建用户
     * 表字段：MEETING.SYS_RESOURCE.CREATE_USER_ID
     * </pre>
     *
     * @return MEETING.SYS_RESOURCE.CREATE_USER_ID：创建用户
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * <pre>
     * 设置：创建用户
     * 表字段：MEETING.SYS_RESOURCE.CREATE_USER_ID
     * </pre>
     *
     * @param createUserId
     *            MEETING.SYS_RESOURCE.CREATE_USER_ID：创建用户
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * <pre>
     * 获取：修改时间
     * 表字段：MEETING.SYS_RESOURCE.UPDATE_DATE
     * </pre>
     *
     * @return MEETING.SYS_RESOURCE.UPDATE_DATE：修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * <pre>
     * 设置：修改时间
     * 表字段：MEETING.SYS_RESOURCE.UPDATE_DATE
     * </pre>
     *
     * @param updateDate
     *            MEETING.SYS_RESOURCE.UPDATE_DATE：修改时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * <pre>
     * 获取：修改用户
     * 表字段：MEETING.SYS_RESOURCE.UPDATE_USER_ID
     * </pre>
     *
     * @return MEETING.SYS_RESOURCE.UPDATE_USER_ID：修改用户
     */
    public Long getUpdateUserId() {
        return updateUserId;
    }

    /**
     * <pre>
     * 设置：修改用户
     * 表字段：MEETING.SYS_RESOURCE.UPDATE_USER_ID
     * </pre>
     *
     * @param updateUserId
     *            MEETING.SYS_RESOURCE.UPDATE_USER_ID：修改用户
     */
    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
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
        SysResource other = (SysResource) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getpId() == null ? other.getpId() == null : this.getpId().equals(other.getpId()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLeaf() == null ? other.getLeaf() == null : this.getLeaf().equals(other.getLeaf()))
            && (this.getPermission() == null ? other.getPermission() == null : this.getPermission().equals(other.getPermission()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getUpdateUserId() == null ? other.getUpdateUserId() == null : this.getUpdateUserId().equals(other.getUpdateUserId()));
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getpId() == null) ? 0 : getpId().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLeaf() == null) ? 0 : getLeaf().hashCode());
        result = prime * result + ((getPermission() == null) ? 0 : getPermission().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdateUserId() == null) ? 0 : getUpdateUserId().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", pId=").append(pId);
        sb.append(", value=").append(value);
        sb.append(", icon=").append(icon);
        sb.append(", sort=").append(sort);
        sb.append(", status=").append(status);
        sb.append(", leaf=").append(leaf);
        sb.append(", permission=").append(permission);
        sb.append(", remark=").append(remark);
        sb.append(", createDate=").append(createDate);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}