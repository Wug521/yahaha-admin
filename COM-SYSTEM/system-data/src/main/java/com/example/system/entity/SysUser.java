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

public class SysUser implements Serializable {
    /**
     * ID
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    private Long id;

    /**
     * 业务用户ID
     */
    private Long bUserId;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 性别
     */
    private Short sex;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 手机
     */
    private String tel;

    /**
     * 1正常；2用户锁定；3用户不可用
     */
    private Short status;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 账户类型
     */
    private Short accountType;

    /**
     * 最后一次登录时间
     */
    private Date lastLoginTime;

    /**
     * 最后一次登录IP
     */
    private String lastLoginIp;

    /**
     * 登录次数
     */
    private Long loginCount;

    /**
     * 错误次数
     */
    private Integer errorCount;

    /**
     * 错误时间
     */
    private Date errorTime;

    /**
     * 移动端token
     */
    private String token;

    /**
     * 最近登录时间
     */
    private Date recentlyTime;

    /**
     * 身份证号/员工证件号
     */
    private String idCard;

    /**
     * 机构编码
     */
    private String orgCode;

    /**
     * 修改用户
     */
    private Long updateUserId;

    /**
     * 创建用户
     */
    private Long createUserId;

    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 获取：ID
     * 表字段：MEETING.SYS_USER.ID
     * </pre>
     *
     * @return MEETING.SYS_USER.ID：ID
     */
    public Long getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：ID
     * 表字段：MEETING.SYS_USER.ID
     * </pre>
     *
     * @param id
     *            MEETING.SYS_USER.ID：ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：业务用户ID
     * 表字段：MEETING.SYS_USER.B_USER_ID
     * </pre>
     *
     * @return MEETING.SYS_USER.B_USER_ID：业务用户ID
     */
    public Long getbUserId() {
        return bUserId;
    }

    /**
     * <pre>
     * 设置：业务用户ID
     * 表字段：MEETING.SYS_USER.B_USER_ID
     * </pre>
     *
     * @param bUserId
     *            MEETING.SYS_USER.B_USER_ID：业务用户ID
     */
    public void setbUserId(Long bUserId) {
        this.bUserId = bUserId;
    }

    /**
     * <pre>
     * 获取：真实姓名
     * 表字段：MEETING.SYS_USER.REAL_NAME
     * </pre>
     *
     * @return MEETING.SYS_USER.REAL_NAME：真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * <pre>
     * 设置：真实姓名
     * 表字段：MEETING.SYS_USER.REAL_NAME
     * </pre>
     *
     * @param realName
     *            MEETING.SYS_USER.REAL_NAME：真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * <pre>
     * 获取：性别
     * 表字段：MEETING.SYS_USER.SEX
     * </pre>
     *
     * @return MEETING.SYS_USER.SEX：性别
     */
    public Short getSex() {
        return sex;
    }

    /**
     * <pre>
     * 设置：性别
     * 表字段：MEETING.SYS_USER.SEX
     * </pre>
     *
     * @param sex
     *            MEETING.SYS_USER.SEX：性别
     */
    public void setSex(Short sex) {
        this.sex = sex;
    }

    /**
     * <pre>
     * 获取：用户名
     * 表字段：MEETING.SYS_USER.USERNAME
     * </pre>
     *
     * @return MEETING.SYS_USER.USERNAME：用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * <pre>
     * 设置：用户名
     * 表字段：MEETING.SYS_USER.USERNAME
     * </pre>
     *
     * @param username
     *            MEETING.SYS_USER.USERNAME：用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * <pre>
     * 获取：密码
     * 表字段：MEETING.SYS_USER.PASSWORD
     * </pre>
     *
     * @return MEETING.SYS_USER.PASSWORD：密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * <pre>
     * 设置：密码
     * 表字段：MEETING.SYS_USER.PASSWORD
     * </pre>
     *
     * @param password
     *            MEETING.SYS_USER.PASSWORD：密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * <pre>
     * 获取：邮箱
     * 表字段：MEETING.SYS_USER.EMAIL
     * </pre>
     *
     * @return MEETING.SYS_USER.EMAIL：邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * <pre>
     * 设置：邮箱
     * 表字段：MEETING.SYS_USER.EMAIL
     * </pre>
     *
     * @param email
     *            MEETING.SYS_USER.EMAIL：邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * <pre>
     * 获取：电话
     * 表字段：MEETING.SYS_USER.PHONE
     * </pre>
     *
     * @return MEETING.SYS_USER.PHONE：电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * <pre>
     * 设置：电话
     * 表字段：MEETING.SYS_USER.PHONE
     * </pre>
     *
     * @param phone
     *            MEETING.SYS_USER.PHONE：电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * <pre>
     * 获取：手机
     * 表字段：MEETING.SYS_USER.TEL
     * </pre>
     *
     * @return MEETING.SYS_USER.TEL：手机
     */
    public String getTel() {
        return tel;
    }

    /**
     * <pre>
     * 设置：手机
     * 表字段：MEETING.SYS_USER.TEL
     * </pre>
     *
     * @param tel
     *            MEETING.SYS_USER.TEL：手机
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * <pre>
     * 获取：1正常；2用户锁定；3用户不可用
     * 表字段：MEETING.SYS_USER.STATUS
     * </pre>
     *
     * @return MEETING.SYS_USER.STATUS：1正常；2用户锁定；3用户不可用
     */
    public Short getStatus() {
        return status;
    }

    /**
     * <pre>
     * 设置：1正常；2用户锁定；3用户不可用
     * 表字段：MEETING.SYS_USER.STATUS
     * </pre>
     *
     * @param status
     *            MEETING.SYS_USER.STATUS：1正常；2用户锁定；3用户不可用
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * <pre>
     * 获取：修改时间
     * 表字段：MEETING.SYS_USER.UPDATE_DATE
     * </pre>
     *
     * @return MEETING.SYS_USER.UPDATE_DATE：修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * <pre>
     * 设置：修改时间
     * 表字段：MEETING.SYS_USER.UPDATE_DATE
     * </pre>
     *
     * @param updateDate
     *            MEETING.SYS_USER.UPDATE_DATE：修改时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * <pre>
     * 获取：创建时间
     * 表字段：MEETING.SYS_USER.CREATE_DATE
     * </pre>
     *
     * @return MEETING.SYS_USER.CREATE_DATE：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：创建时间
     * 表字段：MEETING.SYS_USER.CREATE_DATE
     * </pre>
     *
     * @param createDate
     *            MEETING.SYS_USER.CREATE_DATE：创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：备注
     * 表字段：MEETING.SYS_USER.REMARK
     * </pre>
     *
     * @return MEETING.SYS_USER.REMARK：备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * <pre>
     * 设置：备注
     * 表字段：MEETING.SYS_USER.REMARK
     * </pre>
     *
     * @param remark
     *            MEETING.SYS_USER.REMARK：备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * <pre>
     * 获取：账户类型
     * 表字段：MEETING.SYS_USER.ACCOUNT_TYPE
     * </pre>
     *
     * @return MEETING.SYS_USER.ACCOUNT_TYPE：账户类型
     */
    public Short getAccountType() {
        return accountType;
    }

    /**
     * <pre>
     * 设置：账户类型
     * 表字段：MEETING.SYS_USER.ACCOUNT_TYPE
     * </pre>
     *
     * @param accountType
     *            MEETING.SYS_USER.ACCOUNT_TYPE：账户类型
     */
    public void setAccountType(Short accountType) {
        this.accountType = accountType;
    }

    /**
     * <pre>
     * 获取：最后一次登录时间
     * 表字段：MEETING.SYS_USER.LAST_LOGIN_TIME
     * </pre>
     *
     * @return MEETING.SYS_USER.LAST_LOGIN_TIME：最后一次登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * <pre>
     * 设置：最后一次登录时间
     * 表字段：MEETING.SYS_USER.LAST_LOGIN_TIME
     * </pre>
     *
     * @param lastLoginTime
     *            MEETING.SYS_USER.LAST_LOGIN_TIME：最后一次登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * <pre>
     * 获取：最后一次登录IP
     * 表字段：MEETING.SYS_USER.LAST_LOGIN_IP
     * </pre>
     *
     * @return MEETING.SYS_USER.LAST_LOGIN_IP：最后一次登录IP
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * <pre>
     * 设置：最后一次登录IP
     * 表字段：MEETING.SYS_USER.LAST_LOGIN_IP
     * </pre>
     *
     * @param lastLoginIp
     *            MEETING.SYS_USER.LAST_LOGIN_IP：最后一次登录IP
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    /**
     * <pre>
     * 获取：登录次数
     * 表字段：MEETING.SYS_USER.LOGIN_COUNT
     * </pre>
     *
     * @return MEETING.SYS_USER.LOGIN_COUNT：登录次数
     */
    public Long getLoginCount() {
        return loginCount;
    }

    /**
     * <pre>
     * 设置：登录次数
     * 表字段：MEETING.SYS_USER.LOGIN_COUNT
     * </pre>
     *
     * @param loginCount
     *            MEETING.SYS_USER.LOGIN_COUNT：登录次数
     */
    public void setLoginCount(Long loginCount) {
        this.loginCount = loginCount;
    }

    /**
     * <pre>
     * 获取：错误次数
     * 表字段：MEETING.SYS_USER.ERROR_COUNT
     * </pre>
     *
     * @return MEETING.SYS_USER.ERROR_COUNT：错误次数
     */
    public Integer getErrorCount() {
        return errorCount;
    }

    /**
     * <pre>
     * 设置：错误次数
     * 表字段：MEETING.SYS_USER.ERROR_COUNT
     * </pre>
     *
     * @param errorCount
     *            MEETING.SYS_USER.ERROR_COUNT：错误次数
     */
    public void setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
    }

    /**
     * <pre>
     * 获取：错误时间
     * 表字段：MEETING.SYS_USER.ERROR_TIME
     * </pre>
     *
     * @return MEETING.SYS_USER.ERROR_TIME：错误时间
     */
    public Date getErrorTime() {
        return errorTime;
    }

    /**
     * <pre>
     * 设置：错误时间
     * 表字段：MEETING.SYS_USER.ERROR_TIME
     * </pre>
     *
     * @param errorTime
     *            MEETING.SYS_USER.ERROR_TIME：错误时间
     */
    public void setErrorTime(Date errorTime) {
        this.errorTime = errorTime;
    }

    /**
     * <pre>
     * 获取：移动端token
     * 表字段：MEETING.SYS_USER.TOKEN
     * </pre>
     *
     * @return MEETING.SYS_USER.TOKEN：移动端token
     */
    public String getToken() {
        return token;
    }

    /**
     * <pre>
     * 设置：移动端token
     * 表字段：MEETING.SYS_USER.TOKEN
     * </pre>
     *
     * @param token
     *            MEETING.SYS_USER.TOKEN：移动端token
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * <pre>
     * 获取：最近登录时间
     * 表字段：MEETING.SYS_USER.RECENTLY_TIME
     * </pre>
     *
     * @return MEETING.SYS_USER.RECENTLY_TIME：最近登录时间
     */
    public Date getRecentlyTime() {
        return recentlyTime;
    }

    /**
     * <pre>
     * 设置：最近登录时间
     * 表字段：MEETING.SYS_USER.RECENTLY_TIME
     * </pre>
     *
     * @param recentlyTime
     *            MEETING.SYS_USER.RECENTLY_TIME：最近登录时间
     */
    public void setRecentlyTime(Date recentlyTime) {
        this.recentlyTime = recentlyTime;
    }

    /**
     * <pre>
     * 获取：身份证号/员工证件号
     * 表字段：MEETING.SYS_USER.ID_CARD
     * </pre>
     *
     * @return MEETING.SYS_USER.ID_CARD：身份证号/员工证件号
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * <pre>
     * 设置：身份证号/员工证件号
     * 表字段：MEETING.SYS_USER.ID_CARD
     * </pre>
     *
     * @param idCard
     *            MEETING.SYS_USER.ID_CARD：身份证号/员工证件号
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * <pre>
     * 获取：机构编码
     * 表字段：MEETING.SYS_USER.ORG_CODE
     * </pre>
     *
     * @return MEETING.SYS_USER.ORG_CODE：机构编码
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * <pre>
     * 设置：机构编码
     * 表字段：MEETING.SYS_USER.ORG_CODE
     * </pre>
     *
     * @param orgCode
     *            MEETING.SYS_USER.ORG_CODE：机构编码
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * <pre>
     * 获取：修改用户
     * 表字段：MEETING.SYS_USER.UPDATE_USER_ID
     * </pre>
     *
     * @return MEETING.SYS_USER.UPDATE_USER_ID：修改用户
     */
    public Long getUpdateUserId() {
        return updateUserId;
    }

    /**
     * <pre>
     * 设置：修改用户
     * 表字段：MEETING.SYS_USER.UPDATE_USER_ID
     * </pre>
     *
     * @param updateUserId
     *            MEETING.SYS_USER.UPDATE_USER_ID：修改用户
     */
    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * <pre>
     * 获取：创建用户
     * 表字段：MEETING.SYS_USER.CREATE_USER_ID
     * </pre>
     *
     * @return MEETING.SYS_USER.CREATE_USER_ID：创建用户
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * <pre>
     * 设置：创建用户
     * 表字段：MEETING.SYS_USER.CREATE_USER_ID
     * </pre>
     *
     * @param createUserId
     *            MEETING.SYS_USER.CREATE_USER_ID：创建用户
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
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
        SysUser other = (SysUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getbUserId() == null ? other.getbUserId() == null : this.getbUserId().equals(other.getbUserId()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getAccountType() == null ? other.getAccountType() == null : this.getAccountType().equals(other.getAccountType()))
            && (this.getLastLoginTime() == null ? other.getLastLoginTime() == null : this.getLastLoginTime().equals(other.getLastLoginTime()))
            && (this.getLastLoginIp() == null ? other.getLastLoginIp() == null : this.getLastLoginIp().equals(other.getLastLoginIp()))
            && (this.getLoginCount() == null ? other.getLoginCount() == null : this.getLoginCount().equals(other.getLoginCount()))
            && (this.getErrorCount() == null ? other.getErrorCount() == null : this.getErrorCount().equals(other.getErrorCount()))
            && (this.getErrorTime() == null ? other.getErrorTime() == null : this.getErrorTime().equals(other.getErrorTime()))
            && (this.getToken() == null ? other.getToken() == null : this.getToken().equals(other.getToken()))
            && (this.getRecentlyTime() == null ? other.getRecentlyTime() == null : this.getRecentlyTime().equals(other.getRecentlyTime()))
            && (this.getIdCard() == null ? other.getIdCard() == null : this.getIdCard().equals(other.getIdCard()))
            && (this.getOrgCode() == null ? other.getOrgCode() == null : this.getOrgCode().equals(other.getOrgCode()))
            && (this.getUpdateUserId() == null ? other.getUpdateUserId() == null : this.getUpdateUserId().equals(other.getUpdateUserId()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()));
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getbUserId() == null) ? 0 : getbUserId().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getAccountType() == null) ? 0 : getAccountType().hashCode());
        result = prime * result + ((getLastLoginTime() == null) ? 0 : getLastLoginTime().hashCode());
        result = prime * result + ((getLastLoginIp() == null) ? 0 : getLastLoginIp().hashCode());
        result = prime * result + ((getLoginCount() == null) ? 0 : getLoginCount().hashCode());
        result = prime * result + ((getErrorCount() == null) ? 0 : getErrorCount().hashCode());
        result = prime * result + ((getErrorTime() == null) ? 0 : getErrorTime().hashCode());
        result = prime * result + ((getToken() == null) ? 0 : getToken().hashCode());
        result = prime * result + ((getRecentlyTime() == null) ? 0 : getRecentlyTime().hashCode());
        result = prime * result + ((getIdCard() == null) ? 0 : getIdCard().hashCode());
        result = prime * result + ((getOrgCode() == null) ? 0 : getOrgCode().hashCode());
        result = prime * result + ((getUpdateUserId() == null) ? 0 : getUpdateUserId().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
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
        sb.append(", bUserId=").append(bUserId);
        sb.append(", realName=").append(realName);
        sb.append(", sex=").append(sex);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append(", tel=").append(tel);
        sb.append(", status=").append(status);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", createDate=").append(createDate);
        sb.append(", remark=").append(remark);
        sb.append(", accountType=").append(accountType);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", lastLoginIp=").append(lastLoginIp);
        sb.append(", loginCount=").append(loginCount);
        sb.append(", errorCount=").append(errorCount);
        sb.append(", errorTime=").append(errorTime);
        sb.append(", token=").append(token);
        sb.append(", recentlyTime=").append(recentlyTime);
        sb.append(", idCard=").append(idCard);
        sb.append(", orgCode=").append(orgCode);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}