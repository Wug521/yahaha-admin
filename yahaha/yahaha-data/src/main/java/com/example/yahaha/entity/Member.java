/**
 * Copyright(C) 2006-2016 安普利科技
 * All rights reserved
 * 2019-05-06 17:19:22 Created
 * 
 */
package com.example.yahaha.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Member implements Serializable {
	
    /**
     * 主键ID
     */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * 系统用户id
     */
    private Long uid;

    /**
     * 当前积分
     */
    private Long score;

    /**
     * 历史总积分
     */
    private Long grossScore;

    /**
     * 连续签到天数
     */
    private Long signday;

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
     * 获取：主键ID
     * 表字段：member.id
     * </pre>
     *
     * @return member.id：主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：主键ID
     * 表字段：member.id
     * </pre>
     *
     * @param id
     *            member.id：主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：系统用户id
     * 表字段：member.uid
     * </pre>
     *
     * @return member.uid：系统用户id
     */
    public Long getUid() {
        return uid;
    }

    /**
     * <pre>
     * 设置：系统用户id
     * 表字段：member.uid
     * </pre>
     *
     * @param uid
     *            member.uid：系统用户id
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * <pre>
     * 获取：当前积分
     * 表字段：member.score
     * </pre>
     *
     * @return member.score：当前积分
     */
    public Long getScore() {
        return score;
    }

    /**
     * <pre>
     * 设置：当前积分
     * 表字段：member.score
     * </pre>
     *
     * @param score
     *            member.score：当前积分
     */
    public void setScore(Long score) {
        this.score = score;
    }

    /**
     * <pre>
     * 获取：历史总积分
     * 表字段：member.gross_score
     * </pre>
     *
     * @return member.gross_score：历史总积分
     */
    public Long getGrossScore() {
        return grossScore;
    }

    /**
     * <pre>
     * 设置：历史总积分
     * 表字段：member.gross_score
     * </pre>
     *
     * @param grossScore
     *            member.gross_score：历史总积分
     */
    public void setGrossScore(Long grossScore) {
        this.grossScore = grossScore;
    }

    /**
     * <pre>
     * 获取：连续签到天数
     * 表字段：member.signday
     * </pre>
     *
     * @return member.signday：连续签到天数
     */
    public Long getSignday() {
        return signday;
    }

    /**
     * <pre>
     * 设置：连续签到天数
     * 表字段：member.signday
     * </pre>
     *
     * @param signday
     *            member.signday：连续签到天数
     */
    public void setSignday(Long signday) {
        this.signday = signday;
    }

    /**
     * <pre>
     * 获取：状态(数据)
     * 表字段：member.status
     * </pre>
     *
     * @return member.status：状态(数据)
     */
    public Short getStatus() {
        return status;
    }

    /**
     * <pre>
     * 设置：状态(数据)
     * 表字段：member.status
     * </pre>
     *
     * @param status
     *            member.status：状态(数据)
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * <pre>
     * 获取：机构编码
     * 表字段：member.org_code
     * </pre>
     *
     * @return member.org_code：机构编码
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * <pre>
     * 设置：机构编码
     * 表字段：member.org_code
     * </pre>
     *
     * @param orgCode
     *            member.org_code：机构编码
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * <pre>
     * 获取：创建人
     * 表字段：member.create_user
     * </pre>
     *
     * @return member.create_user：创建人
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * <pre>
     * 设置：创建人
     * 表字段：member.create_user
     * </pre>
     *
     * @param createUser
     *            member.create_user：创建人
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * <pre>
     * 获取：创建时间
     * 表字段：member.create_date
     * </pre>
     *
     * @return member.create_date：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：创建时间
     * 表字段：member.create_date
     * </pre>
     *
     * @param createDate
     *            member.create_date：创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：修改人
     * 表字段：member.update_user
     * </pre>
     *
     * @return member.update_user：修改人
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * <pre>
     * 设置：修改人
     * 表字段：member.update_user
     * </pre>
     *
     * @param updateUser
     *            member.update_user：修改人
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * <pre>
     * 获取：修改时间
     * 表字段：member.update_date
     * </pre>
     *
     * @return member.update_date：修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * <pre>
     * 设置：修改时间
     * 表字段：member.update_date
     * </pre>
     *
     * @param updateDate
     *            member.update_date：修改时间
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
        Member other = (Member) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getGrossScore() == null ? other.getGrossScore() == null : this.getGrossScore().equals(other.getGrossScore()))
            && (this.getSignday() == null ? other.getSignday() == null : this.getSignday().equals(other.getSignday()))
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
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getGrossScore() == null) ? 0 : getGrossScore().hashCode());
        result = prime * result + ((getSignday() == null) ? 0 : getSignday().hashCode());
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
        sb.append(", uid=").append(uid);
        sb.append(", score=").append(score);
        sb.append(", grossScore=").append(grossScore);
        sb.append(", signday=").append(signday);
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