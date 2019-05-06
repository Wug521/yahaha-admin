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

public class SysDept implements Serializable {
    /**
     * ID
     */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    /**
     * ID
     */
    private Long id;

    /**
     * 部门编码
     */
    private String deptCode;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 状态
     */
    private Short status;

    /**
     * 父ID
     */
    private Long pid;

    /**
     * 联系人
     */
    private String linkman;

    /**
     * 联系电话
     */
    private String linkmobile;

    /**
     * 创建用户
     */
    private String createUserId;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改用户
     */
    private String updateUserId;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 机构编码
     */
    private String orgCode;

    /**
     * 部门类型
     */
    private Short deptType;

    /**
     * 分管局领导
     */
    private Long userId;

    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 获取：ID
     * 表字段：ASSESS.SYS_DEPT.ID
     * </pre>
     *
     * @return ASSESS.SYS_DEPT.ID：ID
     */
    public Long getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：ID
     * 表字段：ASSESS.SYS_DEPT.ID
     * </pre>
     *
     * @param id
     *            ASSESS.SYS_DEPT.ID：ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：部门编码
     * 表字段：ASSESS.SYS_DEPT.DEPT_CODE
     * </pre>
     *
     * @return ASSESS.SYS_DEPT.DEPT_CODE：部门编码
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * <pre>
     * 设置：部门编码
     * 表字段：ASSESS.SYS_DEPT.DEPT_CODE
     * </pre>
     *
     * @param deptCode
     *            ASSESS.SYS_DEPT.DEPT_CODE：部门编码
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    /**
     * <pre>
     * 获取：部门名称
     * 表字段：ASSESS.SYS_DEPT.DEPT_NAME
     * </pre>
     *
     * @return ASSESS.SYS_DEPT.DEPT_NAME：部门名称
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * <pre>
     * 设置：部门名称
     * 表字段：ASSESS.SYS_DEPT.DEPT_NAME
     * </pre>
     *
     * @param deptName
     *            ASSESS.SYS_DEPT.DEPT_NAME：部门名称
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    /**
     * <pre>
     * 获取：状态
     * 表字段：ASSESS.SYS_DEPT.STATUS
     * </pre>
     *
     * @return ASSESS.SYS_DEPT.STATUS：状态
     */
    public Short getStatus() {
        return status;
    }

    /**
     * <pre>
     * 设置：状态
     * 表字段：ASSESS.SYS_DEPT.STATUS
     * </pre>
     *
     * @param status
     *            ASSESS.SYS_DEPT.STATUS：状态
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * <pre>
     * 获取：父ID
     * 表字段：ASSESS.SYS_DEPT.PID
     * </pre>
     *
     * @return ASSESS.SYS_DEPT.PID：父ID
     */
    public Long getPid() {
        return pid;
    }

    /**
     * <pre>
     * 设置：父ID
     * 表字段：ASSESS.SYS_DEPT.PID
     * </pre>
     *
     * @param pid
     *            ASSESS.SYS_DEPT.PID：父ID
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * <pre>
     * 获取：联系人
     * 表字段：ASSESS.SYS_DEPT.LINKMAN
     * </pre>
     *
     * @return ASSESS.SYS_DEPT.LINKMAN：联系人
     */
    public String getLinkman() {
        return linkman;
    }

    /**
     * <pre>
     * 设置：联系人
     * 表字段：ASSESS.SYS_DEPT.LINKMAN
     * </pre>
     *
     * @param linkman
     *            ASSESS.SYS_DEPT.LINKMAN：联系人
     */
    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    /**
     * <pre>
     * 获取：联系电话
     * 表字段：ASSESS.SYS_DEPT.LINKMOBILE
     * </pre>
     *
     * @return ASSESS.SYS_DEPT.LINKMOBILE：联系电话
     */
    public String getLinkmobile() {
        return linkmobile;
    }

    /**
     * <pre>
     * 设置：联系电话
     * 表字段：ASSESS.SYS_DEPT.LINKMOBILE
     * </pre>
     *
     * @param linkmobile
     *            ASSESS.SYS_DEPT.LINKMOBILE：联系电话
     */
    public void setLinkmobile(String linkmobile) {
        this.linkmobile = linkmobile == null ? null : linkmobile.trim();
    }

    /**
     * <pre>
     * 获取：创建用户
     * 表字段：ASSESS.SYS_DEPT.CREATE_USER_ID
     * </pre>
     *
     * @return ASSESS.SYS_DEPT.CREATE_USER_ID：创建用户
     */
    public String getCreateUserId() {
        return createUserId;
    }

    /**
     * <pre>
     * 设置：创建用户
     * 表字段：ASSESS.SYS_DEPT.CREATE_USER_ID
     * </pre>
     *
     * @param createUserId
     *            ASSESS.SYS_DEPT.CREATE_USER_ID：创建用户
     */
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    /**
     * <pre>
     * 获取：创建时间
     * 表字段：ASSESS.SYS_DEPT.CREATE_DATE
     * </pre>
     *
     * @return ASSESS.SYS_DEPT.CREATE_DATE：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：创建时间
     * 表字段：ASSESS.SYS_DEPT.CREATE_DATE
     * </pre>
     *
     * @param createDate
     *            ASSESS.SYS_DEPT.CREATE_DATE：创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：修改用户
     * 表字段：ASSESS.SYS_DEPT.UPDATE_USER_ID
     * </pre>
     *
     * @return ASSESS.SYS_DEPT.UPDATE_USER_ID：修改用户
     */
    public String getUpdateUserId() {
        return updateUserId;
    }

    /**
     * <pre>
     * 设置：修改用户
     * 表字段：ASSESS.SYS_DEPT.UPDATE_USER_ID
     * </pre>
     *
     * @param updateUserId
     *            ASSESS.SYS_DEPT.UPDATE_USER_ID：修改用户
     */
    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId == null ? null : updateUserId.trim();
    }

    /**
     * <pre>
     * 获取：修改时间
     * 表字段：ASSESS.SYS_DEPT.UPDATE_DATE
     * </pre>
     *
     * @return ASSESS.SYS_DEPT.UPDATE_DATE：修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * <pre>
     * 设置：修改时间
     * 表字段：ASSESS.SYS_DEPT.UPDATE_DATE
     * </pre>
     *
     * @param updateDate
     *            ASSESS.SYS_DEPT.UPDATE_DATE：修改时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * <pre>
     * 获取：机构编码
     * 表字段：ASSESS.SYS_DEPT.ORG_CODE
     * </pre>
     *
     * @return ASSESS.SYS_DEPT.ORG_CODE：机构编码
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * <pre>
     * 设置：机构编码
     * 表字段：ASSESS.SYS_DEPT.ORG_CODE
     * </pre>
     *
     * @param orgCode
     *            ASSESS.SYS_DEPT.ORG_CODE：机构编码
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * <pre>
     * 获取：部门类型
     * 表字段：ASSESS.SYS_DEPT.DEPT_TYPE
     * </pre>
     *
     * @return ASSESS.SYS_DEPT.DEPT_TYPE：部门类型
     */
    public Short getDeptType() {
        return deptType;
    }

    /**
     * <pre>
     * 设置：部门类型
     * 表字段：ASSESS.SYS_DEPT.DEPT_TYPE
     * </pre>
     *
     * @param deptType
     *            ASSESS.SYS_DEPT.DEPT_TYPE：部门类型
     */
    public void setDeptType(Short deptType) {
        this.deptType = deptType;
    }

    /**
     * <pre>
     * 获取：分管局领导
     * 表字段：ASSESS.SYS_DEPT.USER_ID
     * </pre>
     *
     * @return ASSESS.SYS_DEPT.USER_ID：分管局领导
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * <pre>
     * 设置：分管局领导
     * 表字段：ASSESS.SYS_DEPT.USER_ID
     * </pre>
     *
     * @param userId
     *            ASSESS.SYS_DEPT.USER_ID：分管局领导
     */
    public void setUserId(Long userId) {
        this.userId = userId;
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
        SysDept other = (SysDept) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDeptCode() == null ? other.getDeptCode() == null : this.getDeptCode().equals(other.getDeptCode()))
            && (this.getDeptName() == null ? other.getDeptName() == null : this.getDeptName().equals(other.getDeptName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getLinkman() == null ? other.getLinkman() == null : this.getLinkman().equals(other.getLinkman()))
            && (this.getLinkmobile() == null ? other.getLinkmobile() == null : this.getLinkmobile().equals(other.getLinkmobile()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateUserId() == null ? other.getUpdateUserId() == null : this.getUpdateUserId().equals(other.getUpdateUserId()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getOrgCode() == null ? other.getOrgCode() == null : this.getOrgCode().equals(other.getOrgCode()))
            && (this.getDeptType() == null ? other.getDeptType() == null : this.getDeptType().equals(other.getDeptType()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDeptCode() == null) ? 0 : getDeptCode().hashCode());
        result = prime * result + ((getDeptName() == null) ? 0 : getDeptName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getLinkman() == null) ? 0 : getLinkman().hashCode());
        result = prime * result + ((getLinkmobile() == null) ? 0 : getLinkmobile().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateUserId() == null) ? 0 : getUpdateUserId().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getOrgCode() == null) ? 0 : getOrgCode().hashCode());
        result = prime * result + ((getDeptType() == null) ? 0 : getDeptType().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
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
        sb.append(", deptCode=").append(deptCode);
        sb.append(", deptName=").append(deptName);
        sb.append(", status=").append(status);
        sb.append(", pid=").append(pid);
        sb.append(", linkman=").append(linkman);
        sb.append(", linkmobile=").append(linkmobile);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", orgCode=").append(orgCode);
        sb.append(", deptType=").append(deptType);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

}