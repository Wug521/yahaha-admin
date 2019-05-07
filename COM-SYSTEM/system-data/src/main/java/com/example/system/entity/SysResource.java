/**
 * Copyright(C) 2006-2016 安普利科技
 * All rights reserved
 * 2019-05-07 13:05:15 Created
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
     * ID
     */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    private Long id;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 排序值
     */
    private Integer sort;

    /**
     * 资源值
     */
    private String value;

    /**
     * 资源图标
     */
    private String icon;

    /**
     * 父资源
     */
    private Long pid;

    /**
     * 服务标识
     */
    private String serviceId;

    /**
     * 备注
     */
    private String remark;

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
     * 获取：
     * 表字段：sys_resource.id
     * </pre>
     *
     * @return sys_resource.id：
     */
    public Long getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：sys_resource.id
     * </pre>
     *
     * @param id
     *            sys_resource.id：
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：资源名称
     * 表字段：sys_resource.name
     * </pre>
     *
     * @return sys_resource.name：资源名称
     */
    public String getName() {
        return name;
    }

    /**
     * <pre>
     * 设置：资源名称
     * 表字段：sys_resource.name
     * </pre>
     *
     * @param name
     *            sys_resource.name：资源名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * <pre>
     * 获取：排序值
     * 表字段：sys_resource.sort
     * </pre>
     *
     * @return sys_resource.sort：排序值
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * <pre>
     * 设置：排序值
     * 表字段：sys_resource.sort
     * </pre>
     *
     * @param sort
     *            sys_resource.sort：排序值
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * <pre>
     * 获取：资源值
     * 表字段：sys_resource.value
     * </pre>
     *
     * @return sys_resource.value：资源值
     */
    public String getValue() {
        return value;
    }

    /**
     * <pre>
     * 设置：资源值
     * 表字段：sys_resource.value
     * </pre>
     *
     * @param value
     *            sys_resource.value：资源值
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * <pre>
     * 获取：资源图标
     * 表字段：sys_resource.icon
     * </pre>
     *
     * @return sys_resource.icon：资源图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * <pre>
     * 设置：资源图标
     * 表字段：sys_resource.icon
     * </pre>
     *
     * @param icon
     *            sys_resource.icon：资源图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * <pre>
     * 获取：父资源
     * 表字段：sys_resource.pid
     * </pre>
     *
     * @return sys_resource.pid：父资源
     */
    public Long getPid() {
        return pid;
    }

    /**
     * <pre>
     * 设置：父资源
     * 表字段：sys_resource.pid
     * </pre>
     *
     * @param pid
     *            sys_resource.pid：父资源
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * <pre>
     * 获取：服务标识
     * 表字段：sys_resource.service_id
     * </pre>
     *
     * @return sys_resource.service_id：服务标识
     */
    public String getServiceId() {
        return serviceId;
    }

    /**
     * <pre>
     * 设置：服务标识
     * 表字段：sys_resource.service_id
     * </pre>
     *
     * @param serviceId
     *            sys_resource.service_id：服务标识
     */
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    /**
     * <pre>
     * 获取：备注
     * 表字段：sys_resource.remark
     * </pre>
     *
     * @return sys_resource.remark：备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * <pre>
     * 设置：备注
     * 表字段：sys_resource.remark
     * </pre>
     *
     * @param remark
     *            sys_resource.remark：备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * <pre>
     * 获取：状态(数据)
     * 表字段：sys_resource.status
     * </pre>
     *
     * @return sys_resource.status：状态(数据)
     */
    public Short getStatus() {
        return status;
    }

    /**
     * <pre>
     * 设置：状态(数据)
     * 表字段：sys_resource.status
     * </pre>
     *
     * @param status
     *            sys_resource.status：状态(数据)
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * <pre>
     * 获取：机构编码
     * 表字段：sys_resource.org_code
     * </pre>
     *
     * @return sys_resource.org_code：机构编码
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * <pre>
     * 设置：机构编码
     * 表字段：sys_resource.org_code
     * </pre>
     *
     * @param orgCode
     *            sys_resource.org_code：机构编码
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * <pre>
     * 获取：创建人
     * 表字段：sys_resource.create_user
     * </pre>
     *
     * @return sys_resource.create_user：创建人
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * <pre>
     * 设置：创建人
     * 表字段：sys_resource.create_user
     * </pre>
     *
     * @param createUser
     *            sys_resource.create_user：创建人
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * <pre>
     * 获取：创建时间
     * 表字段：sys_resource.create_date
     * </pre>
     *
     * @return sys_resource.create_date：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：创建时间
     * 表字段：sys_resource.create_date
     * </pre>
     *
     * @param createDate
     *            sys_resource.create_date：创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：修改人
     * 表字段：sys_resource.update_user
     * </pre>
     *
     * @return sys_resource.update_user：修改人
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * <pre>
     * 设置：修改人
     * 表字段：sys_resource.update_user
     * </pre>
     *
     * @param updateUser
     *            sys_resource.update_user：修改人
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * <pre>
     * 获取：修改时间
     * 表字段：sys_resource.update_date
     * </pre>
     *
     * @return sys_resource.update_date：修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * <pre>
     * 设置：修改时间
     * 表字段：sys_resource.update_date
     * </pre>
     *
     * @param updateDate
     *            sys_resource.update_date：修改时间
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
        SysResource other = (SysResource) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
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
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", sort=").append(sort);
        sb.append(", value=").append(value);
        sb.append(", icon=").append(icon);
        sb.append(", pid=").append(pid);
        sb.append(", serviceId=").append(serviceId);
        sb.append(", remark=").append(remark);
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