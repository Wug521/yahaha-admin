package com.example.system.vo;

import java.util.Date;

import com.github.pagehelper.PageInfo;

/**
 * 文件名：SysUserVo.java 日　期：2017年1月16日 版　权：ZJAPL 作　者：wug 类说明：
 */
public class SysUserVo extends PageInfo<Object> {
	private static final long serialVersionUID = 1L;
	private Long id;

	/**
	 * 员工编号
	 */
	private Long bUserId;

	private String realName;

	private Short sex;

	private String username;

	private String password;

	private String email;

	private String phone;

	private String tel;

	/**
	 * 1正常；2用户锁定；3用户不可用
	 */
	private Short status;

	private Date updateDate;

	private Date createDate;

	private String remark;

	private Short accountType;

	private Date lastLoginTime;

	private String lastLoginIp;

	private Long loginCount;

	private Integer errorCount;

	private Date errorTime;
	
	private String roleIdNames;
	
	public String getRoleIdNames() {
		return roleIdNames;
	}

	public void setRoleIdNames(String roleIdNames) {
		this.roleIdNames = roleIdNames;
	}

	/**
	 * 移动端token
	 */
	private String token;

	/**
	 * 最近登录时间
	 */
	private Date recentlyTime;

	/**
	 * 机构编码
	 */
	private String orgCode;

	/**
	 * 部门内码
	 */
	private Long deptId;
	/**
	 * 角色集合
	 */
	private String roleIds;

	/**
	 * 用户集合
	 */
	private String userIds;

	/**
	 * 部门名称
	 */
	private String deptName;

    private String idCard;
    
    private String deptIds;
    
    private Long roleId;
    
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getDeptIds() {
		return deptIds;
	}

	public void setDeptIds(String deptIds) {
		this.deptIds = deptIds;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}

	/**
	 * <pre>
	 * 获取：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.ID
	 * </pre>
	 *
	 * @return ZJAPL_SYSTEM.SYS_USER.ID：null
	 */
	public Long getId() {
		return id;
	}

	/**
	 * <pre>
	 * 设置：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.ID
	 * </pre>
	 *
	 * @param id
	 *            ZJAPL_SYSTEM.SYS_USER.ID：null
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * <pre>
	 * 获取：员工编号
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.B_USER_ID
	 * </pre>
	 *
	 * @return ZJAPL_SYSTEM.SYS_USER.B_USER_ID：员工编号
	 */
	public Long getbUserId() {
		return bUserId;
	}

	/**
	 * <pre>
	 * 设置：员工编号
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.B_USER_ID
	 * </pre>
	 *
	 * @param bUserId
	 *            ZJAPL_SYSTEM.SYS_USER.B_USER_ID：员工编号
	 */
	public void setbUserId(Long bUserId) {
		this.bUserId = bUserId;
	}

	/**
	 * <pre>
	 * 获取：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.REAL_NAME
	 * </pre>
	 *
	 * @return ZJAPL_SYSTEM.SYS_USER.REAL_NAME：null
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * <pre>
	 * 设置：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.REAL_NAME
	 * </pre>
	 *
	 * @param realName
	 *            ZJAPL_SYSTEM.SYS_USER.REAL_NAME：null
	 */
	public void setRealName(String realName) {
		this.realName = realName == null ? null : realName.trim();
	}

	/**
	 * <pre>
	 * 获取：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.SEX
	 * </pre>
	 *
	 * @return ZJAPL_SYSTEM.SYS_USER.SEX：null
	 */
	public Short getSex() {
		return sex;
	}

	/**
	 * <pre>
	 * 设置：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.SEX
	 * </pre>
	 *
	 * @param sex
	 *            ZJAPL_SYSTEM.SYS_USER.SEX：null
	 */
	public void setSex(Short sex) {
		this.sex = sex;
	}

	/**
	 * <pre>
	 * 获取：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.USERNAME
	 * </pre>
	 *
	 * @return ZJAPL_SYSTEM.SYS_USER.USERNAME：null
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * <pre>
	 * 设置：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.USERNAME
	 * </pre>
	 *
	 * @param username
	 *            ZJAPL_SYSTEM.SYS_USER.USERNAME：null
	 */
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/**
	 * <pre>
	 * 获取：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.PASSWORD
	 * </pre>
	 *
	 * @return ZJAPL_SYSTEM.SYS_USER.PASSWORD：null
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <pre>
	 * 设置：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.PASSWORD
	 * </pre>
	 *
	 * @param password
	 *            ZJAPL_SYSTEM.SYS_USER.PASSWORD：null
	 */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	/**
	 * <pre>
	 * 获取：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.EMAIL
	 * </pre>
	 *
	 * @return ZJAPL_SYSTEM.SYS_USER.EMAIL：null
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * <pre>
	 * 设置：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.EMAIL
	 * </pre>
	 *
	 * @param email
	 *            ZJAPL_SYSTEM.SYS_USER.EMAIL：null
	 */
	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	/**
	 * <pre>
	 * 获取：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.PHONE
	 * </pre>
	 *
	 * @return ZJAPL_SYSTEM.SYS_USER.PHONE：null
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * <pre>
	 * 设置：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.PHONE
	 * </pre>
	 *
	 * @param phone
	 *            ZJAPL_SYSTEM.SYS_USER.PHONE：null
	 */
	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	/**
	 * <pre>
	 * 获取：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.TEL
	 * </pre>
	 *
	 * @return ZJAPL_SYSTEM.SYS_USER.TEL：null
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * <pre>
	 * 设置：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.TEL
	 * </pre>
	 *
	 * @param tel
	 *            ZJAPL_SYSTEM.SYS_USER.TEL：null
	 */
	public void setTel(String tel) {
		this.tel = tel == null ? null : tel.trim();
	}

	/**
	 * <pre>
	 * 获取：1正常；2用户锁定；3用户不可用
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.STATUS
	 * </pre>
	 *
	 * @return ZJAPL_SYSTEM.SYS_USER.STATUS：1正常；2用户锁定；3用户不可用
	 */
	public Short getStatus() {
		return status;
	}

	/**
	 * <pre>
	 * 设置：1正常；2用户锁定；3用户不可用
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.STATUS
	 * </pre>
	 *
	 * @param status
	 *            ZJAPL_SYSTEM.SYS_USER.STATUS：1正常；2用户锁定；3用户不可用
	 */
	public void setStatus(Short status) {
		this.status = status;
	}

	/**
	 * <pre>
	 * 获取：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.UPDATE_DATE
	 * </pre>
	 *
	 * @return ZJAPL_SYSTEM.SYS_USER.UPDATE_DATE：null
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * <pre>
	 * 设置：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.UPDATE_DATE
	 * </pre>
	 *
	 * @param updateDate
	 *            ZJAPL_SYSTEM.SYS_USER.UPDATE_DATE：null
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * <pre>
	 * 获取：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.CREATE_DATE
	 * </pre>
	 *
	 * @return ZJAPL_SYSTEM.SYS_USER.CREATE_DATE：null
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * <pre>
	 * 设置：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.CREATE_DATE
	 * </pre>
	 *
	 * @param createDate
	 *            ZJAPL_SYSTEM.SYS_USER.CREATE_DATE：null
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * <pre>
	 * 获取：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.REMARK
	 * </pre>
	 *
	 * @return ZJAPL_SYSTEM.SYS_USER.REMARK：null
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * <pre>
	 * 设置：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.REMARK
	 * </pre>
	 *
	 * @param remark
	 *            ZJAPL_SYSTEM.SYS_USER.REMARK：null
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * <pre>
	 * 获取：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.ACCOUNT_TYPE
	 * </pre>
	 *
	 * @return ZJAPL_SYSTEM.SYS_USER.ACCOUNT_TYPE：null
	 */
	public Short getAccountType() {
		return accountType;
	}

	/**
	 * <pre>
	 * 设置：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.ACCOUNT_TYPE
	 * </pre>
	 *
	 * @param accountType
	 *            ZJAPL_SYSTEM.SYS_USER.ACCOUNT_TYPE：null
	 */
	public void setAccountType(Short accountType) {
		this.accountType = accountType;
	}

	/**
	 * <pre>
	 * 获取：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.LAST_LOGIN_TIME
	 * </pre>
	 *
	 * @return ZJAPL_SYSTEM.SYS_USER.LAST_LOGIN_TIME：null
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * <pre>
	 * 设置：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.LAST_LOGIN_TIME
	 * </pre>
	 *
	 * @param lastLoginTime
	 *            ZJAPL_SYSTEM.SYS_USER.LAST_LOGIN_TIME：null
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * <pre>
	 * 获取：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.LAST_LOGIN_IP
	 * </pre>
	 *
	 * @return ZJAPL_SYSTEM.SYS_USER.LAST_LOGIN_IP：null
	 */
	public String getLastLoginIp() {
		return lastLoginIp;
	}

	/**
	 * <pre>
	 * 设置：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.LAST_LOGIN_IP
	 * </pre>
	 *
	 * @param lastLoginIp
	 *            ZJAPL_SYSTEM.SYS_USER.LAST_LOGIN_IP：null
	 */
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
	}

	/**
	 * <pre>
	 * 获取：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.LOGIN_COUNT
	 * </pre>
	 *
	 * @return ZJAPL_SYSTEM.SYS_USER.LOGIN_COUNT：null
	 */
	public Long getLoginCount() {
		return loginCount;
	}

	/**
	 * <pre>
	 * 设置：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.LOGIN_COUNT
	 * </pre>
	 *
	 * @param loginCount
	 *            ZJAPL_SYSTEM.SYS_USER.LOGIN_COUNT：null
	 */
	public void setLoginCount(Long loginCount) {
		this.loginCount = loginCount;
	}

	/**
	 * <pre>
	 * 获取：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.ERROR_COUNT
	 * </pre>
	 *
	 * @return ZJAPL_SYSTEM.SYS_USER.ERROR_COUNT：null
	 */
	public Integer getErrorCount() {
		return errorCount;
	}

	/**
	 * <pre>
	 * 设置：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.ERROR_COUNT
	 * </pre>
	 *
	 * @param errorCount
	 *            ZJAPL_SYSTEM.SYS_USER.ERROR_COUNT：null
	 */
	public void setErrorCount(Integer errorCount) {
		this.errorCount = errorCount;
	}

	/**
	 * <pre>
	 * 获取：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.ERROR_TIME
	 * </pre>
	 *
	 * @return ZJAPL_SYSTEM.SYS_USER.ERROR_TIME：null
	 */
	public Date getErrorTime() {
		return errorTime;
	}

	/**
	 * <pre>
	 * 设置：null
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.ERROR_TIME
	 * </pre>
	 *
	 * @param errorTime
	 *            ZJAPL_SYSTEM.SYS_USER.ERROR_TIME：null
	 */
	public void setErrorTime(Date errorTime) {
		this.errorTime = errorTime;
	}

	/**
	 * <pre>
	 * 获取：移动端token
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.TOKEN
	 * </pre>
	 *
	 * @return ZJAPL_SYSTEM.SYS_USER.TOKEN：移动端token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * <pre>
	 * 设置：移动端token
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.TOKEN
	 * </pre>
	 *
	 * @param token
	 *            ZJAPL_SYSTEM.SYS_USER.TOKEN：移动端token
	 */
	public void setToken(String token) {
		this.token = token == null ? null : token.trim();
	}

	/**
	 * <pre>
	 * 获取：最近登录时间
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.RECENTLY_TIME
	 * </pre>
	 *
	 * @return ZJAPL_SYSTEM.SYS_USER.RECENTLY_TIME：最近登录时间
	 */
	public Date getRecentlyTime() {
		return recentlyTime;
	}

	/**
	 * <pre>
	 * 设置：最近登录时间
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.RECENTLY_TIME
	 * </pre>
	 *
	 * @param recentlyTime
	 *            ZJAPL_SYSTEM.SYS_USER.RECENTLY_TIME：最近登录时间
	 */
	public void setRecentlyTime(Date recentlyTime) {
		this.recentlyTime = recentlyTime;
	}

	/**
	 * <pre>
	 * 获取：机构编码
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.ORG_CODE
	 * </pre>
	 *
	 * @return ZJAPL_SYSTEM.SYS_USER.ORG_CODE：机构编码
	 */
	public String getOrgCode() {
		return orgCode;
	}

	/**
	 * <pre>
	 * 设置：机构编码
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.ORG_CODE
	 * </pre>
	 *
	 * @param orgCode
	 *            ZJAPL_SYSTEM.SYS_USER.ORG_CODE：机构编码
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode == null ? null : orgCode.trim();
	}

	/**
	 * <pre>
	 * 获取：部门内码
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.DEPT_ID
	 * </pre>
	 *
	 * @return ZJAPL_SYSTEM.SYS_USER.DEPT_ID：部门内码
	 */
	public Long getDeptId() {
		return deptId;
	}

	/**
	 * <pre>
	 * 设置：部门内码
	 * 表字段：ZJAPL_SYSTEM.SYS_USER.DEPT_ID
	 * </pre>
	 *
	 * @param deptId
	 *            ZJAPL_SYSTEM.SYS_USER.DEPT_ID：部门内码
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

}
