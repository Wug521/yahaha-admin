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

public class SysUser implements Serializable {
	
    /**
     * ID
     */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    private Long id;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 性别
     */
    private Short sex;

    /**
     * 用户昵称
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
     * 手机号
     */
    private String phone;

    /**
     * 账号类型
     */
    private Short accountType;

    /**
     * 令牌
     */
    private String token;

    /**
     * 公众号openid
     */
    private String openid;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 人员头像
     */
    private String avatarUrl;

    /**
     * 状态(数据)
     */
    private Short status;

    /**
     * 备注
     */
    private String remark;

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
     * 获取：主键ID
     * 表字段：sys_user.id
     * </pre>
     *
     * @return sys_user.id：主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：主键ID
     * 表字段：sys_user.id
     * </pre>
     *
     * @param id
     *            sys_user.id：主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：真实姓名
     * 表字段：sys_user.real_name
     * </pre>
     *
     * @return sys_user.real_name：真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * <pre>
     * 设置：真实姓名
     * 表字段：sys_user.real_name
     * </pre>
     *
     * @param realName
     *            sys_user.real_name：真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * <pre>
     * 获取：性别
     * 表字段：sys_user.sex
     * </pre>
     *
     * @return sys_user.sex：性别
     */
    public Short getSex() {
        return sex;
    }

    /**
     * <pre>
     * 设置：性别
     * 表字段：sys_user.sex
     * </pre>
     *
     * @param sex
     *            sys_user.sex：性别
     */
    public void setSex(Short sex) {
        this.sex = sex;
    }

    /**
     * <pre>
     * 获取：用户昵称
     * 表字段：sys_user.username
     * </pre>
     *
     * @return sys_user.username：用户昵称
     */
    public String getUsername() {
        return username;
    }

    /**
     * <pre>
     * 设置：用户昵称
     * 表字段：sys_user.username
     * </pre>
     *
     * @param username
     *            sys_user.username：用户昵称
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * <pre>
     * 获取：密码
     * 表字段：sys_user.password
     * </pre>
     *
     * @return sys_user.password：密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * <pre>
     * 设置：密码
     * 表字段：sys_user.password
     * </pre>
     *
     * @param password
     *            sys_user.password：密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * <pre>
     * 获取：邮箱
     * 表字段：sys_user.email
     * </pre>
     *
     * @return sys_user.email：邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * <pre>
     * 设置：邮箱
     * 表字段：sys_user.email
     * </pre>
     *
     * @param email
     *            sys_user.email：邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * <pre>
     * 获取：手机号
     * 表字段：sys_user.phone
     * </pre>
     *
     * @return sys_user.phone：手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * <pre>
     * 设置：手机号
     * 表字段：sys_user.phone
     * </pre>
     *
     * @param phone
     *            sys_user.phone：手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * <pre>
     * 获取：账号类型
     * 表字段：sys_user.account_type
     * </pre>
     *
     * @return sys_user.account_type：账号类型
     */
    public Short getAccountType() {
        return accountType;
    }

    /**
     * <pre>
     * 设置：账号类型
     * 表字段：sys_user.account_type
     * </pre>
     *
     * @param accountType
     *            sys_user.account_type：账号类型
     */
    public void setAccountType(Short accountType) {
        this.accountType = accountType;
    }

    /**
     * <pre>
     * 获取：令牌
     * 表字段：sys_user.token
     * </pre>
     *
     * @return sys_user.token：令牌
     */
    public String getToken() {
        return token;
    }

    /**
     * <pre>
     * 设置：令牌
     * 表字段：sys_user.token
     * </pre>
     *
     * @param token
     *            sys_user.token：令牌
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * <pre>
     * 获取：公众号openid
     * 表字段：sys_user.openid
     * </pre>
     *
     * @return sys_user.openid：公众号openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * <pre>
     * 设置：公众号openid
     * 表字段：sys_user.openid
     * </pre>
     *
     * @param openid
     *            sys_user.openid：公众号openid
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * <pre>
     * 获取：身份证
     * 表字段：sys_user.id_card
     * </pre>
     *
     * @return sys_user.id_card：身份证
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * <pre>
     * 设置：身份证
     * 表字段：sys_user.id_card
     * </pre>
     *
     * @param idCard
     *            sys_user.id_card：身份证
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * <pre>
     * 获取：人员头像
     * 表字段：sys_user.avatar_url
     * </pre>
     *
     * @return sys_user.avatar_url：人员头像
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * <pre>
     * 设置：人员头像
     * 表字段：sys_user.avatar_url
     * </pre>
     *
     * @param avatarUrl
     *            sys_user.avatar_url：人员头像
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    /**
     * <pre>
     * 获取：状态(数据)
     * 表字段：sys_user.status
     * </pre>
     *
     * @return sys_user.status：状态(数据)
     */
    public Short getStatus() {
        return status;
    }

    /**
     * <pre>
     * 设置：状态(数据)
     * 表字段：sys_user.status
     * </pre>
     *
     * @param status
     *            sys_user.status：状态(数据)
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * <pre>
     * 获取：备注
     * 表字段：sys_user.remark
     * </pre>
     *
     * @return sys_user.remark：备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * <pre>
     * 设置：备注
     * 表字段：sys_user.remark
     * </pre>
     *
     * @param remark
     *            sys_user.remark：备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * <pre>
     * 获取：机构编码
     * 表字段：sys_user.org_code
     * </pre>
     *
     * @return sys_user.org_code：机构编码
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * <pre>
     * 设置：机构编码
     * 表字段：sys_user.org_code
     * </pre>
     *
     * @param orgCode
     *            sys_user.org_code：机构编码
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * <pre>
     * 获取：创建人
     * 表字段：sys_user.create_user
     * </pre>
     *
     * @return sys_user.create_user：创建人
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * <pre>
     * 设置：创建人
     * 表字段：sys_user.create_user
     * </pre>
     *
     * @param createUser
     *            sys_user.create_user：创建人
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * <pre>
     * 获取：创建时间
     * 表字段：sys_user.create_date
     * </pre>
     *
     * @return sys_user.create_date：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：创建时间
     * 表字段：sys_user.create_date
     * </pre>
     *
     * @param createDate
     *            sys_user.create_date：创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：修改人
     * 表字段：sys_user.update_user
     * </pre>
     *
     * @return sys_user.update_user：修改人
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * <pre>
     * 设置：修改人
     * 表字段：sys_user.update_user
     * </pre>
     *
     * @param updateUser
     *            sys_user.update_user：修改人
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * <pre>
     * 获取：修改时间
     * 表字段：sys_user.update_date
     * </pre>
     *
     * @return sys_user.update_date：修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * <pre>
     * 设置：修改时间
     * 表字段：sys_user.update_date
     * </pre>
     *
     * @param updateDate
     *            sys_user.update_date：修改时间
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
        SysUser other = (SysUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getAccountType() == null ? other.getAccountType() == null : this.getAccountType().equals(other.getAccountType()))
            && (this.getToken() == null ? other.getToken() == null : this.getToken().equals(other.getToken()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getIdCard() == null ? other.getIdCard() == null : this.getIdCard().equals(other.getIdCard()))
            && (this.getAvatarUrl() == null ? other.getAvatarUrl() == null : this.getAvatarUrl().equals(other.getAvatarUrl()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
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
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getAccountType() == null) ? 0 : getAccountType().hashCode());
        result = prime * result + ((getToken() == null) ? 0 : getToken().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getIdCard() == null) ? 0 : getIdCard().hashCode());
        result = prime * result + ((getAvatarUrl() == null) ? 0 : getAvatarUrl().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
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
        sb.append(", realName=").append(realName);
        sb.append(", sex=").append(sex);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append(", accountType=").append(accountType);
        sb.append(", token=").append(token);
        sb.append(", openid=").append(openid);
        sb.append(", idCard=").append(idCard);
        sb.append(", avatarUrl=").append(avatarUrl);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
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