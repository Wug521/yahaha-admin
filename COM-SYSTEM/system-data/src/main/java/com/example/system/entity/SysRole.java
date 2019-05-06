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

public class SysRole implements Serializable {
    /**
     * 角色流水号
     */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	 private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否启用
     */
    private Short status;

    /**
     * 所属机构
     */
    private String orgCode;

    /**
     * 创建时间
     */
    private Date crateDate;

    /**
     * 创建用户
     */
    private Long crateUserId;

    /**
     * 修改用户
     */
    private Long updateUserId;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 登录模式
     */
    private Short loginMode;

    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 获取：角色流水号
     * 表字段：APLCCP.SYS_ROLE.ID
     * </pre>
     *
     * @return APLCCP.SYS_ROLE.ID：角色流水号
     */
    public Long getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：角色流水号
     * 表字段：APLCCP.SYS_ROLE.ID
     * </pre>
     *
     * @param id
     *            APLCCP.SYS_ROLE.ID：角色流水号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：角色名称
     * 表字段：APLCCP.SYS_ROLE.NAME
     * </pre>
     *
     * @return APLCCP.SYS_ROLE.NAME：角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * <pre>
     * 设置：角色名称
     * 表字段：APLCCP.SYS_ROLE.NAME
     * </pre>
     *
     * @param name
     *            APLCCP.SYS_ROLE.NAME：角色名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * <pre>
     * 获取：备注
     * 表字段：APLCCP.SYS_ROLE.REMARK
     * </pre>
     *
     * @return APLCCP.SYS_ROLE.REMARK：备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * <pre>
     * 设置：备注
     * 表字段：APLCCP.SYS_ROLE.REMARK
     * </pre>
     *
     * @param remark
     *            APLCCP.SYS_ROLE.REMARK：备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * <pre>
     * 获取：是否启用
     * 表字段：APLCCP.SYS_ROLE.STATUS
     * </pre>
     *
     * @return APLCCP.SYS_ROLE.STATUS：是否启用
     */
    public Short getStatus() {
        return status;
    }

    /**
     * <pre>
     * 设置：是否启用
     * 表字段：APLCCP.SYS_ROLE.STATUS
     * </pre>
     *
     * @param status
     *            APLCCP.SYS_ROLE.STATUS：是否启用
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * <pre>
     * 获取：所属机构
     * 表字段：APLCCP.SYS_ROLE.ORG_CODE
     * </pre>
     *
     * @return APLCCP.SYS_ROLE.ORG_CODE：所属机构
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * <pre>
     * 设置：所属机构
     * 表字段：APLCCP.SYS_ROLE.ORG_CODE
     * </pre>
     *
     * @param orgCode
     *            APLCCP.SYS_ROLE.ORG_CODE：所属机构
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * <pre>
     * 获取：创建时间
     * 表字段：APLCCP.SYS_ROLE.CRATE_DATE
     * </pre>
     *
     * @return APLCCP.SYS_ROLE.CRATE_DATE：创建时间
     */
    public Date getCrateDate() {
        return crateDate;
    }

    /**
     * <pre>
     * 设置：创建时间
     * 表字段：APLCCP.SYS_ROLE.CRATE_DATE
     * </pre>
     *
     * @param crateDate
     *            APLCCP.SYS_ROLE.CRATE_DATE：创建时间
     */
    public void setCrateDate(Date crateDate) {
        this.crateDate = crateDate;
    }

    /**
     * <pre>
     * 获取：创建用户
     * 表字段：APLCCP.SYS_ROLE.CRATE_USER_ID
     * </pre>
     *
     * @return APLCCP.SYS_ROLE.CRATE_USER_ID：创建用户
     */
    public Long getCrateUserId() {
        return crateUserId;
    }

    /**
     * <pre>
     * 设置：创建用户
     * 表字段：APLCCP.SYS_ROLE.CRATE_USER_ID
     * </pre>
     *
     * @param crateUserId
     *            APLCCP.SYS_ROLE.CRATE_USER_ID：创建用户
     */
    public void setCrateUserId(Long crateUserId) {
        this.crateUserId = crateUserId;
    }

    /**
     * <pre>
     * 获取：修改用户
     * 表字段：APLCCP.SYS_ROLE.UPDATE_USER_ID
     * </pre>
     *
     * @return APLCCP.SYS_ROLE.UPDATE_USER_ID：修改用户
     */
    public Long getUpdateUserId() {
        return updateUserId;
    }

    /**
     * <pre>
     * 设置：修改用户
     * 表字段：APLCCP.SYS_ROLE.UPDATE_USER_ID
     * </pre>
     *
     * @param updateUserId
     *            APLCCP.SYS_ROLE.UPDATE_USER_ID：修改用户
     */
    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * <pre>
     * 获取：修改时间
     * 表字段：APLCCP.SYS_ROLE.UPDATE_DATE
     * </pre>
     *
     * @return APLCCP.SYS_ROLE.UPDATE_DATE：修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * <pre>
     * 设置：修改时间
     * 表字段：APLCCP.SYS_ROLE.UPDATE_DATE
     * </pre>
     *
     * @param updateDate
     *            APLCCP.SYS_ROLE.UPDATE_DATE：修改时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * <pre>
     * 获取：登录模式
     * 表字段：APLCCP.SYS_ROLE.LOGIN_MODE
     * </pre>
     *
     * @return APLCCP.SYS_ROLE.LOGIN_MODE：登录模式
     */
    public Short getLoginMode() {
        return loginMode;
    }

    /**
     * <pre>
     * 设置：登录模式
     * 表字段：APLCCP.SYS_ROLE.LOGIN_MODE
     * </pre>
     *
     * @param loginMode
     *            APLCCP.SYS_ROLE.LOGIN_MODE：登录模式
     */
    public void setLoginMode(Short loginMode) {
        this.loginMode = loginMode;
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
        SysRole other = (SysRole) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getOrgCode() == null ? other.getOrgCode() == null : this.getOrgCode().equals(other.getOrgCode()))
            && (this.getCrateDate() == null ? other.getCrateDate() == null : this.getCrateDate().equals(other.getCrateDate()))
            && (this.getCrateUserId() == null ? other.getCrateUserId() == null : this.getCrateUserId().equals(other.getCrateUserId()))
            && (this.getUpdateUserId() == null ? other.getUpdateUserId() == null : this.getUpdateUserId().equals(other.getUpdateUserId()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getLoginMode() == null ? other.getLoginMode() == null : this.getLoginMode().equals(other.getLoginMode()));
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
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getOrgCode() == null) ? 0 : getOrgCode().hashCode());
        result = prime * result + ((getCrateDate() == null) ? 0 : getCrateDate().hashCode());
        result = prime * result + ((getCrateUserId() == null) ? 0 : getCrateUserId().hashCode());
        result = prime * result + ((getUpdateUserId() == null) ? 0 : getUpdateUserId().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getLoginMode() == null) ? 0 : getLoginMode().hashCode());
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
        sb.append(", remark=").append(remark);
        sb.append(", status=").append(status);
        sb.append(", orgCode=").append(orgCode);
        sb.append(", crateDate=").append(crateDate);
        sb.append(", crateUserId=").append(crateUserId);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", loginMode=").append(loginMode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}