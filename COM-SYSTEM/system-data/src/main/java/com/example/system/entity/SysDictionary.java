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

public class SysDictionary implements Serializable {
    /**
     * ID
     */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 值
     */
    private String value;

    /**
     * 范围
     */
    private String scope;

    /**
     * 类型标识
     */
    private Short type;

    /**
     * 有效标识1有效  0无效
     */
    private Short available;

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

    /**
     * 机构编码
     */
    private String orgCode;

    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 获取：ID
     * 表字段：APLOA.SYS_DICTIONARY.ID
     * </pre>
     *
     * @return APLOA.SYS_DICTIONARY.ID：ID
     */
    public Long getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：ID
     * 表字段：APLOA.SYS_DICTIONARY.ID
     * </pre>
     *
     * @param id
     *            APLOA.SYS_DICTIONARY.ID：ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：名称
     * 表字段：APLOA.SYS_DICTIONARY.NAME
     * </pre>
     *
     * @return APLOA.SYS_DICTIONARY.NAME：名称
     */
    public String getName() {
        return name;
    }

    /**
     * <pre>
     * 设置：名称
     * 表字段：APLOA.SYS_DICTIONARY.NAME
     * </pre>
     *
     * @param name
     *            APLOA.SYS_DICTIONARY.NAME：名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * <pre>
     * 获取：值
     * 表字段：APLOA.SYS_DICTIONARY.VALUE
     * </pre>
     *
     * @return APLOA.SYS_DICTIONARY.VALUE：值
     */
    public String getValue() {
        return value;
    }

    /**
     * <pre>
     * 设置：值
     * 表字段：APLOA.SYS_DICTIONARY.VALUE
     * </pre>
     *
     * @param value
     *            APLOA.SYS_DICTIONARY.VALUE：值
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * <pre>
     * 获取：范围
     * 表字段：APLOA.SYS_DICTIONARY.SCOPE
     * </pre>
     *
     * @return APLOA.SYS_DICTIONARY.SCOPE：范围
     */
    public String getScope() {
        return scope;
    }

    /**
     * <pre>
     * 设置：范围
     * 表字段：APLOA.SYS_DICTIONARY.SCOPE
     * </pre>
     *
     * @param scope
     *            APLOA.SYS_DICTIONARY.SCOPE：范围
     */
    public void setScope(String scope) {
        this.scope = scope == null ? null : scope.trim();
    }

    /**
     * <pre>
     * 获取：类型标识
     * 表字段：APLOA.SYS_DICTIONARY.TYPE
     * </pre>
     *
     * @return APLOA.SYS_DICTIONARY.TYPE：类型标识
     */
    public Short getType() {
        return type;
    }

    /**
     * <pre>
     * 设置：类型标识
     * 表字段：APLOA.SYS_DICTIONARY.TYPE
     * </pre>
     *
     * @param type
     *            APLOA.SYS_DICTIONARY.TYPE：类型标识
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     * <pre>
     * 获取：有效标识1有效  0无效
     * 表字段：APLOA.SYS_DICTIONARY.AVAILABLE
     * </pre>
     *
     * @return APLOA.SYS_DICTIONARY.AVAILABLE：有效标识1有效  0无效
     */
    public Short getAvailable() {
        return available;
    }

    /**
     * <pre>
     * 设置：有效标识1有效  0无效
     * 表字段：APLOA.SYS_DICTIONARY.AVAILABLE
     * </pre>
     *
     * @param available
     *            APLOA.SYS_DICTIONARY.AVAILABLE：有效标识1有效  0无效
     */
    public void setAvailable(Short available) {
        this.available = available;
    }

    /**
     * <pre>
     * 获取：创建用户
     * 表字段：APLOA.SYS_DICTIONARY.CREATE_USER_ID
     * </pre>
     *
     * @return APLOA.SYS_DICTIONARY.CREATE_USER_ID：创建用户
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * <pre>
     * 设置：创建用户
     * 表字段：APLOA.SYS_DICTIONARY.CREATE_USER_ID
     * </pre>
     *
     * @param createUserId
     *            APLOA.SYS_DICTIONARY.CREATE_USER_ID：创建用户
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * <pre>
     * 获取：创建时间
     * 表字段：APLOA.SYS_DICTIONARY.CREATE_DATE
     * </pre>
     *
     * @return APLOA.SYS_DICTIONARY.CREATE_DATE：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：创建时间
     * 表字段：APLOA.SYS_DICTIONARY.CREATE_DATE
     * </pre>
     *
     * @param createDate
     *            APLOA.SYS_DICTIONARY.CREATE_DATE：创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：修改用户
     * 表字段：APLOA.SYS_DICTIONARY.UPDATE_USER_ID
     * </pre>
     *
     * @return APLOA.SYS_DICTIONARY.UPDATE_USER_ID：修改用户
     */
    public Long getUpdateUserId() {
        return updateUserId;
    }

    /**
     * <pre>
     * 设置：修改用户
     * 表字段：APLOA.SYS_DICTIONARY.UPDATE_USER_ID
     * </pre>
     *
     * @param updateUserId
     *            APLOA.SYS_DICTIONARY.UPDATE_USER_ID：修改用户
     */
    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * <pre>
     * 获取：修改时间
     * 表字段：APLOA.SYS_DICTIONARY.UPDATE_DATE
     * </pre>
     *
     * @return APLOA.SYS_DICTIONARY.UPDATE_DATE：修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * <pre>
     * 设置：修改时间
     * 表字段：APLOA.SYS_DICTIONARY.UPDATE_DATE
     * </pre>
     *
     * @param updateDate
     *            APLOA.SYS_DICTIONARY.UPDATE_DATE：修改时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * <pre>
     * 获取：机构编码
     * 表字段：APLOA.SYS_DICTIONARY.ORG_CODE
     * </pre>
     *
     * @return APLOA.SYS_DICTIONARY.ORG_CODE：机构编码
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * <pre>
     * 设置：机构编码
     * 表字段：APLOA.SYS_DICTIONARY.ORG_CODE
     * </pre>
     *
     * @param orgCode
     *            APLOA.SYS_DICTIONARY.ORG_CODE：机构编码
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
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
        SysDictionary other = (SysDictionary) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
            && (this.getScope() == null ? other.getScope() == null : this.getScope().equals(other.getScope()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getAvailable() == null ? other.getAvailable() == null : this.getAvailable().equals(other.getAvailable()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateUserId() == null ? other.getUpdateUserId() == null : this.getUpdateUserId().equals(other.getUpdateUserId()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getOrgCode() == null ? other.getOrgCode() == null : this.getOrgCode().equals(other.getOrgCode()));
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
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        result = prime * result + ((getScope() == null) ? 0 : getScope().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getAvailable() == null) ? 0 : getAvailable().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateUserId() == null) ? 0 : getUpdateUserId().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getOrgCode() == null) ? 0 : getOrgCode().hashCode());
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
        sb.append(", value=").append(value);
        sb.append(", scope=").append(scope);
        sb.append(", type=").append(type);
        sb.append(", available=").append(available);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", orgCode=").append(orgCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}