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

public class News implements Serializable {
	
    /**
     * 主键ID
     */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * 新闻标题
     */
    private String title;

    /**
     * 新闻内容
     */
    private String content;

    /**
     * 标签id集合
     */
    private String idsTag;

    /**
     * 标签名称集合
     */
    private String idsTagName;

    /**
     * 分类id集合
     */
    private String idsCategory;

    /**
     * 分类名称集合
     */
    private String idsCategoryName;

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
     * 表字段：news.id
     * </pre>
     *
     * @return news.id：主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：主键ID
     * 表字段：news.id
     * </pre>
     *
     * @param id
     *            news.id：主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：新闻标题
     * 表字段：news.title
     * </pre>
     *
     * @return news.title：新闻标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * <pre>
     * 设置：新闻标题
     * 表字段：news.title
     * </pre>
     *
     * @param title
     *            news.title：新闻标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * <pre>
     * 获取：新闻内容
     * 表字段：news.content
     * </pre>
     *
     * @return news.content：新闻内容
     */
    public String getContent() {
        return content;
    }

    /**
     * <pre>
     * 设置：新闻内容
     * 表字段：news.content
     * </pre>
     *
     * @param content
     *            news.content：新闻内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * <pre>
     * 获取：标签id集合
     * 表字段：news.ids_tag
     * </pre>
     *
     * @return news.ids_tag：标签id集合
     */
    public String getIdsTag() {
        return idsTag;
    }

    /**
     * <pre>
     * 设置：标签id集合
     * 表字段：news.ids_tag
     * </pre>
     *
     * @param idsTag
     *            news.ids_tag：标签id集合
     */
    public void setIdsTag(String idsTag) {
        this.idsTag = idsTag == null ? null : idsTag.trim();
    }

    /**
     * <pre>
     * 获取：标签名称集合
     * 表字段：news.ids_tag_name
     * </pre>
     *
     * @return news.ids_tag_name：标签名称集合
     */
    public String getIdsTagName() {
        return idsTagName;
    }

    /**
     * <pre>
     * 设置：标签名称集合
     * 表字段：news.ids_tag_name
     * </pre>
     *
     * @param idsTagName
     *            news.ids_tag_name：标签名称集合
     */
    public void setIdsTagName(String idsTagName) {
        this.idsTagName = idsTagName == null ? null : idsTagName.trim();
    }

    /**
     * <pre>
     * 获取：分类id集合
     * 表字段：news.ids_category
     * </pre>
     *
     * @return news.ids_category：分类id集合
     */
    public String getIdsCategory() {
        return idsCategory;
    }

    /**
     * <pre>
     * 设置：分类id集合
     * 表字段：news.ids_category
     * </pre>
     *
     * @param idsCategory
     *            news.ids_category：分类id集合
     */
    public void setIdsCategory(String idsCategory) {
        this.idsCategory = idsCategory == null ? null : idsCategory.trim();
    }

    /**
     * <pre>
     * 获取：分类名称集合
     * 表字段：news.ids_category_name
     * </pre>
     *
     * @return news.ids_category_name：分类名称集合
     */
    public String getIdsCategoryName() {
        return idsCategoryName;
    }

    /**
     * <pre>
     * 设置：分类名称集合
     * 表字段：news.ids_category_name
     * </pre>
     *
     * @param idsCategoryName
     *            news.ids_category_name：分类名称集合
     */
    public void setIdsCategoryName(String idsCategoryName) {
        this.idsCategoryName = idsCategoryName == null ? null : idsCategoryName.trim();
    }

    /**
     * <pre>
     * 获取：状态(数据)
     * 表字段：news.status
     * </pre>
     *
     * @return news.status：状态(数据)
     */
    public Short getStatus() {
        return status;
    }

    /**
     * <pre>
     * 设置：状态(数据)
     * 表字段：news.status
     * </pre>
     *
     * @param status
     *            news.status：状态(数据)
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * <pre>
     * 获取：机构编码
     * 表字段：news.org_code
     * </pre>
     *
     * @return news.org_code：机构编码
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * <pre>
     * 设置：机构编码
     * 表字段：news.org_code
     * </pre>
     *
     * @param orgCode
     *            news.org_code：机构编码
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * <pre>
     * 获取：创建人
     * 表字段：news.create_user
     * </pre>
     *
     * @return news.create_user：创建人
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * <pre>
     * 设置：创建人
     * 表字段：news.create_user
     * </pre>
     *
     * @param createUser
     *            news.create_user：创建人
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * <pre>
     * 获取：创建时间
     * 表字段：news.create_date
     * </pre>
     *
     * @return news.create_date：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：创建时间
     * 表字段：news.create_date
     * </pre>
     *
     * @param createDate
     *            news.create_date：创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：修改人
     * 表字段：news.update_user
     * </pre>
     *
     * @return news.update_user：修改人
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * <pre>
     * 设置：修改人
     * 表字段：news.update_user
     * </pre>
     *
     * @param updateUser
     *            news.update_user：修改人
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * <pre>
     * 获取：修改时间
     * 表字段：news.update_date
     * </pre>
     *
     * @return news.update_date：修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * <pre>
     * 设置：修改时间
     * 表字段：news.update_date
     * </pre>
     *
     * @param updateDate
     *            news.update_date：修改时间
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
        News other = (News) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getIdsTag() == null ? other.getIdsTag() == null : this.getIdsTag().equals(other.getIdsTag()))
            && (this.getIdsTagName() == null ? other.getIdsTagName() == null : this.getIdsTagName().equals(other.getIdsTagName()))
            && (this.getIdsCategory() == null ? other.getIdsCategory() == null : this.getIdsCategory().equals(other.getIdsCategory()))
            && (this.getIdsCategoryName() == null ? other.getIdsCategoryName() == null : this.getIdsCategoryName().equals(other.getIdsCategoryName()))
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
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getIdsTag() == null) ? 0 : getIdsTag().hashCode());
        result = prime * result + ((getIdsTagName() == null) ? 0 : getIdsTagName().hashCode());
        result = prime * result + ((getIdsCategory() == null) ? 0 : getIdsCategory().hashCode());
        result = prime * result + ((getIdsCategoryName() == null) ? 0 : getIdsCategoryName().hashCode());
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
        sb.append(", title=").append(title);
        sb.append(", content=").append(content);
        sb.append(", idsTag=").append(idsTag);
        sb.append(", idsTagName=").append(idsTagName);
        sb.append(", idsCategory=").append(idsCategory);
        sb.append(", idsCategoryName=").append(idsCategoryName);
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