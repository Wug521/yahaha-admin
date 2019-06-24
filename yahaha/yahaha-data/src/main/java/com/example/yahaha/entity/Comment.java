/**
 * Copyright(C) 2006-2016 安普利科技
 * All rights reserved
 * 2019-06-10 11:11:49 Created
 * 
 */
package com.example.yahaha.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Comment implements Serializable {
	
    /**
     * id主键
     */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * 主题id
     */
    private Long topicId;

    /**
     * 主题来源
     */
    private Short source;

    /**
     * 主题类型
     */
    private Short topicType;

    /**
     * 内容
     */
    private String content;

    /**
     * 评论用户id
     */
    private Long fromUid;

    /**
     * 评论人姓名
     */
    private String fromUname;

    /**
     * 评论目标用户id
     */
    private Long toUid;

    /**
     * 评论目标用户姓名
     */
    private String toUname;

    /**
     * 父id
     */
    private Long parentId;

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
     * 获取：id主键
     * 表字段：comment.id
     * </pre>
     *
     * @return comment.id：id主键
     */
    public Long getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：id主键
     * 表字段：comment.id
     * </pre>
     *
     * @param id
     *            comment.id：id主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：主题id
     * 表字段：comment.topic_id
     * </pre>
     *
     * @return comment.topic_id：主题id
     */
    public Long getTopicId() {
        return topicId;
    }

    /**
     * <pre>
     * 设置：主题id
     * 表字段：comment.topic_id
     * </pre>
     *
     * @param topicId
     *            comment.topic_id：主题id
     */
    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    /**
     * <pre>
     * 获取：主题来源
     * 表字段：comment.source
     * </pre>
     *
     * @return comment.source：主题来源
     */
    public Short getSource() {
        return source;
    }

    /**
     * <pre>
     * 设置：主题来源
     * 表字段：comment.source
     * </pre>
     *
     * @param source
     *            comment.source：主题来源
     */
    public void setSource(Short source) {
        this.source = source;
    }

    /**
     * <pre>
     * 获取：主题类型
     * 表字段：comment.topic_type
     * </pre>
     *
     * @return comment.topic_type：主题类型
     */
    public Short getTopicType() {
        return topicType;
    }

    /**
     * <pre>
     * 设置：主题类型
     * 表字段：comment.topic_type
     * </pre>
     *
     * @param topicType
     *            comment.topic_type：主题类型
     */
    public void setTopicType(Short topicType) {
        this.topicType = topicType;
    }

    /**
     * <pre>
     * 获取：内容
     * 表字段：comment.content
     * </pre>
     *
     * @return comment.content：内容
     */
    public String getContent() {
        return content;
    }

    /**
     * <pre>
     * 设置：内容
     * 表字段：comment.content
     * </pre>
     *
     * @param content
     *            comment.content：内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * <pre>
     * 获取：评论用户id
     * 表字段：comment.from_uid
     * </pre>
     *
     * @return comment.from_uid：评论用户id
     */
    public Long getFromUid() {
        return fromUid;
    }

    /**
     * <pre>
     * 设置：评论用户id
     * 表字段：comment.from_uid
     * </pre>
     *
     * @param fromUid
     *            comment.from_uid：评论用户id
     */
    public void setFromUid(Long fromUid) {
        this.fromUid = fromUid;
    }

    /**
     * <pre>
     * 获取：评论人姓名
     * 表字段：comment.from_uname
     * </pre>
     *
     * @return comment.from_uname：评论人姓名
     */
    public String getFromUname() {
        return fromUname;
    }

    /**
     * <pre>
     * 设置：评论人姓名
     * 表字段：comment.from_uname
     * </pre>
     *
     * @param fromUname
     *            comment.from_uname：评论人姓名
     */
    public void setFromUname(String fromUname) {
        this.fromUname = fromUname == null ? null : fromUname.trim();
    }

    /**
     * <pre>
     * 获取：评论目标用户id
     * 表字段：comment.to_uid
     * </pre>
     *
     * @return comment.to_uid：评论目标用户id
     */
    public Long getToUid() {
        return toUid;
    }

    /**
     * <pre>
     * 设置：评论目标用户id
     * 表字段：comment.to_uid
     * </pre>
     *
     * @param toUid
     *            comment.to_uid：评论目标用户id
     */
    public void setToUid(Long toUid) {
        this.toUid = toUid;
    }

    /**
     * <pre>
     * 获取：评论目标用户姓名
     * 表字段：comment.to_uname
     * </pre>
     *
     * @return comment.to_uname：评论目标用户姓名
     */
    public String getToUname() {
        return toUname;
    }

    /**
     * <pre>
     * 设置：评论目标用户姓名
     * 表字段：comment.to_uname
     * </pre>
     *
     * @param toUname
     *            comment.to_uname：评论目标用户姓名
     */
    public void setToUname(String toUname) {
        this.toUname = toUname == null ? null : toUname.trim();
    }

    /**
     * <pre>
     * 获取：父id
     * 表字段：comment.parent_id
     * </pre>
     *
     * @return comment.parent_id：父id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * <pre>
     * 设置：父id
     * 表字段：comment.parent_id
     * </pre>
     *
     * @param parentId
     *            comment.parent_id：父id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * <pre>
     * 获取：状态(数据)
     * 表字段：comment.status
     * </pre>
     *
     * @return comment.status：状态(数据)
     */
    public Short getStatus() {
        return status;
    }

    /**
     * <pre>
     * 设置：状态(数据)
     * 表字段：comment.status
     * </pre>
     *
     * @param status
     *            comment.status：状态(数据)
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * <pre>
     * 获取：机构编码
     * 表字段：comment.org_code
     * </pre>
     *
     * @return comment.org_code：机构编码
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * <pre>
     * 设置：机构编码
     * 表字段：comment.org_code
     * </pre>
     *
     * @param orgCode
     *            comment.org_code：机构编码
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * <pre>
     * 获取：创建人
     * 表字段：comment.create_user
     * </pre>
     *
     * @return comment.create_user：创建人
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * <pre>
     * 设置：创建人
     * 表字段：comment.create_user
     * </pre>
     *
     * @param createUser
     *            comment.create_user：创建人
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * <pre>
     * 获取：创建时间
     * 表字段：comment.create_date
     * </pre>
     *
     * @return comment.create_date：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：创建时间
     * 表字段：comment.create_date
     * </pre>
     *
     * @param createDate
     *            comment.create_date：创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：修改人
     * 表字段：comment.update_user
     * </pre>
     *
     * @return comment.update_user：修改人
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * <pre>
     * 设置：修改人
     * 表字段：comment.update_user
     * </pre>
     *
     * @param updateUser
     *            comment.update_user：修改人
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * <pre>
     * 获取：修改时间
     * 表字段：comment.update_date
     * </pre>
     *
     * @return comment.update_date：修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * <pre>
     * 设置：修改时间
     * 表字段：comment.update_date
     * </pre>
     *
     * @param updateDate
     *            comment.update_date：修改时间
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
        Comment other = (Comment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTopicId() == null ? other.getTopicId() == null : this.getTopicId().equals(other.getTopicId()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getTopicType() == null ? other.getTopicType() == null : this.getTopicType().equals(other.getTopicType()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getFromUid() == null ? other.getFromUid() == null : this.getFromUid().equals(other.getFromUid()))
            && (this.getFromUname() == null ? other.getFromUname() == null : this.getFromUname().equals(other.getFromUname()))
            && (this.getToUid() == null ? other.getToUid() == null : this.getToUid().equals(other.getToUid()))
            && (this.getToUname() == null ? other.getToUname() == null : this.getToUname().equals(other.getToUname()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
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
        result = prime * result + ((getTopicId() == null) ? 0 : getTopicId().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getTopicType() == null) ? 0 : getTopicType().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getFromUid() == null) ? 0 : getFromUid().hashCode());
        result = prime * result + ((getFromUname() == null) ? 0 : getFromUname().hashCode());
        result = prime * result + ((getToUid() == null) ? 0 : getToUid().hashCode());
        result = prime * result + ((getToUname() == null) ? 0 : getToUname().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
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
        sb.append(", topicId=").append(topicId);
        sb.append(", source=").append(source);
        sb.append(", topicType=").append(topicType);
        sb.append(", content=").append(content);
        sb.append(", fromUid=").append(fromUid);
        sb.append(", fromUname=").append(fromUname);
        sb.append(", toUid=").append(toUid);
        sb.append(", toUname=").append(toUname);
        sb.append(", parentId=").append(parentId);
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