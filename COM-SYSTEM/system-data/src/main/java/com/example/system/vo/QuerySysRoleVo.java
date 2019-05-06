package com.example.system.vo;

import java.util.Date;

import com.github.pagehelper.PageInfo;

/**
 * 文件名：QuerySysRoleVo.java
 * 日　期：2017年2月9日
 * 版　权：ZJAPL
 * 作　者：wug
 * 类说明：
 */
public class QuerySysRoleVo extends PageInfo<Object>{
	private static final long serialVersionUID = 1L;

	/**
     * 角色流水号
     */
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

    private Date crateDate;

    private Long crateUserId;

    private Long updateUserId;

    private Date updateDate;
    
    private String userName;
    
    private String resourceIds;
    
    public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	private String statusName;

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
     * <pre>
     * 获取：角色流水号
     * 表字段：ZJAPL_SYSTEM.SYS_ROLE.ID
     * </pre>
     *
     * @return ZJAPL_SYSTEM.SYS_ROLE.ID：角色流水号
     */
    public Long getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：角色流水号
     * 表字段：ZJAPL_SYSTEM.SYS_ROLE.ID
     * </pre>
     *
     * @param id
     *            ZJAPL_SYSTEM.SYS_ROLE.ID：角色流水号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：角色名称
     * 表字段：ZJAPL_SYSTEM.SYS_ROLE.NAME
     * </pre>
     *
     * @return ZJAPL_SYSTEM.SYS_ROLE.NAME：角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * <pre>
     * 设置：角色名称
     * 表字段：ZJAPL_SYSTEM.SYS_ROLE.NAME
     * </pre>
     *
     * @param name
     *            ZJAPL_SYSTEM.SYS_ROLE.NAME：角色名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * <pre>
     * 获取：备注
     * 表字段：ZJAPL_SYSTEM.SYS_ROLE.REMARK
     * </pre>
     *
     * @return ZJAPL_SYSTEM.SYS_ROLE.REMARK：备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * <pre>
     * 设置：备注
     * 表字段：ZJAPL_SYSTEM.SYS_ROLE.REMARK
     * </pre>
     *
     * @param remark
     *            ZJAPL_SYSTEM.SYS_ROLE.REMARK：备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * <pre>
     * 获取：是否启用
     * 表字段：ZJAPL_SYSTEM.SYS_ROLE.STATUS
     * </pre>
     *
     * @return ZJAPL_SYSTEM.SYS_ROLE.STATUS：是否启用
     */
    public Short getStatus() {
        return status;
    }

    /**
     * <pre>
     * 设置：是否启用
     * 表字段：ZJAPL_SYSTEM.SYS_ROLE.STATUS
     * </pre>
     *
     * @param status
     *            ZJAPL_SYSTEM.SYS_ROLE.STATUS：是否启用
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * <pre>
     * 获取：所属机构
     * 表字段：ZJAPL_SYSTEM.SYS_ROLE.ORG_CODE
     * </pre>
     *
     * @return ZJAPL_SYSTEM.SYS_ROLE.ORG_CODE：所属机构
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * <pre>
     * 设置：所属机构
     * 表字段：ZJAPL_SYSTEM.SYS_ROLE.ORG_CODE
     * </pre>
     *
     * @param orgCode
     *            ZJAPL_SYSTEM.SYS_ROLE.ORG_CODE：所属机构
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * <pre>
     * 获取：null
     * 表字段：ZJAPL_SYSTEM.SYS_ROLE.CRATE_DATE
     * </pre>
     *
     * @return ZJAPL_SYSTEM.SYS_ROLE.CRATE_DATE：null
     */
    public Date getCrateDate() {
        return crateDate;
    }

    /**
     * <pre>
     * 设置：null
     * 表字段：ZJAPL_SYSTEM.SYS_ROLE.CRATE_DATE
     * </pre>
     *
     * @param crateDate
     *            ZJAPL_SYSTEM.SYS_ROLE.CRATE_DATE：null
     */
    public void setCrateDate(Date crateDate) {
        this.crateDate = crateDate;
    }

    /**
     * <pre>
     * 获取：null
     * 表字段：ZJAPL_SYSTEM.SYS_ROLE.CRATE_USER_ID
     * </pre>
     *
     * @return ZJAPL_SYSTEM.SYS_ROLE.CRATE_USER_ID：null
     */
    public Long getCrateUserId() {
        return crateUserId;
    }

    /**
     * <pre>
     * 设置：null
     * 表字段：ZJAPL_SYSTEM.SYS_ROLE.CRATE_USER_ID
     * </pre>
     *
     * @param crateUserId
     *            ZJAPL_SYSTEM.SYS_ROLE.CRATE_USER_ID：null
     */
    public void setCrateUserId(Long crateUserId) {
        this.crateUserId = crateUserId;
    }

    /**
     * <pre>
     * 获取：null
     * 表字段：ZJAPL_SYSTEM.SYS_ROLE.UPDATE_USER_ID
     * </pre>
     *
     * @return ZJAPL_SYSTEM.SYS_ROLE.UPDATE_USER_ID：null
     */
    public Long getUpdateUserId() {
        return updateUserId;
    }

    /**
     * <pre>
     * 设置：null
     * 表字段：ZJAPL_SYSTEM.SYS_ROLE.UPDATE_USER_ID
     * </pre>
     *
     * @param updateUserId
     *            ZJAPL_SYSTEM.SYS_ROLE.UPDATE_USER_ID：null
     */
    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * <pre>
     * 获取：null
     * 表字段：ZJAPL_SYSTEM.SYS_ROLE.UPDATE_DATE
     * </pre>
     *
     * @return ZJAPL_SYSTEM.SYS_ROLE.UPDATE_DATE：null
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * <pre>
     * 设置：null
     * 表字段：ZJAPL_SYSTEM.SYS_ROLE.UPDATE_DATE
     * </pre>
     *
     * @param updateDate
     *            ZJAPL_SYSTEM.SYS_ROLE.UPDATE_DATE：null
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

	public String getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}


}
