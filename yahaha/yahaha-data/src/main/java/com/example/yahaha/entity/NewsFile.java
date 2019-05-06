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

public class NewsFile implements Serializable {
	
    /**
     * 主键ID
     */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * 新闻表id
     */
    private Long nid;

    /**
     * 新闻标题
     */
    private String newsTitle;

    /**
     * 系统文件表id
     */
    private Long fid;

    /**
     * 文件名称
     */
    private String fileName;

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
     * 表字段：news_file.id
     * </pre>
     *
     * @return news_file.id：主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：主键ID
     * 表字段：news_file.id
     * </pre>
     *
     * @param id
     *            news_file.id：主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：新闻表id
     * 表字段：news_file.nid
     * </pre>
     *
     * @return news_file.nid：新闻表id
     */
    public Long getNid() {
        return nid;
    }

    /**
     * <pre>
     * 设置：新闻表id
     * 表字段：news_file.nid
     * </pre>
     *
     * @param nid
     *            news_file.nid：新闻表id
     */
    public void setNid(Long nid) {
        this.nid = nid;
    }

    /**
     * <pre>
     * 获取：新闻标题
     * 表字段：news_file.news_title
     * </pre>
     *
     * @return news_file.news_title：新闻标题
     */
    public String getNewsTitle() {
        return newsTitle;
    }

    /**
     * <pre>
     * 设置：新闻标题
     * 表字段：news_file.news_title
     * </pre>
     *
     * @param newsTitle
     *            news_file.news_title：新闻标题
     */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    /**
     * <pre>
     * 获取：系统文件表id
     * 表字段：news_file.fid
     * </pre>
     *
     * @return news_file.fid：系统文件表id
     */
    public Long getFid() {
        return fid;
    }

    /**
     * <pre>
     * 设置：系统文件表id
     * 表字段：news_file.fid
     * </pre>
     *
     * @param fid
     *            news_file.fid：系统文件表id
     */
    public void setFid(Long fid) {
        this.fid = fid;
    }

    /**
     * <pre>
     * 获取：文件名称
     * 表字段：news_file.file_name
     * </pre>
     *
     * @return news_file.file_name：文件名称
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * <pre>
     * 设置：文件名称
     * 表字段：news_file.file_name
     * </pre>
     *
     * @param fileName
     *            news_file.file_name：文件名称
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * <pre>
     * 获取：状态(数据)
     * 表字段：news_file.status
     * </pre>
     *
     * @return news_file.status：状态(数据)
     */
    public Short getStatus() {
        return status;
    }

    /**
     * <pre>
     * 设置：状态(数据)
     * 表字段：news_file.status
     * </pre>
     *
     * @param status
     *            news_file.status：状态(数据)
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * <pre>
     * 获取：机构编码
     * 表字段：news_file.org_code
     * </pre>
     *
     * @return news_file.org_code：机构编码
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * <pre>
     * 设置：机构编码
     * 表字段：news_file.org_code
     * </pre>
     *
     * @param orgCode
     *            news_file.org_code：机构编码
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * <pre>
     * 获取：创建人
     * 表字段：news_file.create_user
     * </pre>
     *
     * @return news_file.create_user：创建人
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * <pre>
     * 设置：创建人
     * 表字段：news_file.create_user
     * </pre>
     *
     * @param createUser
     *            news_file.create_user：创建人
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * <pre>
     * 获取：创建时间
     * 表字段：news_file.create_date
     * </pre>
     *
     * @return news_file.create_date：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：创建时间
     * 表字段：news_file.create_date
     * </pre>
     *
     * @param createDate
     *            news_file.create_date：创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：修改人
     * 表字段：news_file.update_user
     * </pre>
     *
     * @return news_file.update_user：修改人
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * <pre>
     * 设置：修改人
     * 表字段：news_file.update_user
     * </pre>
     *
     * @param updateUser
     *            news_file.update_user：修改人
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * <pre>
     * 获取：修改时间
     * 表字段：news_file.update_date
     * </pre>
     *
     * @return news_file.update_date：修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * <pre>
     * 设置：修改时间
     * 表字段：news_file.update_date
     * </pre>
     *
     * @param updateDate
     *            news_file.update_date：修改时间
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
        NewsFile other = (NewsFile) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNid() == null ? other.getNid() == null : this.getNid().equals(other.getNid()))
            && (this.getNewsTitle() == null ? other.getNewsTitle() == null : this.getNewsTitle().equals(other.getNewsTitle()))
            && (this.getFid() == null ? other.getFid() == null : this.getFid().equals(other.getFid()))
            && (this.getFileName() == null ? other.getFileName() == null : this.getFileName().equals(other.getFileName()))
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
        result = prime * result + ((getNid() == null) ? 0 : getNid().hashCode());
        result = prime * result + ((getNewsTitle() == null) ? 0 : getNewsTitle().hashCode());
        result = prime * result + ((getFid() == null) ? 0 : getFid().hashCode());
        result = prime * result + ((getFileName() == null) ? 0 : getFileName().hashCode());
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
        sb.append(", nid=").append(nid);
        sb.append(", newsTitle=").append(newsTitle);
        sb.append(", fid=").append(fid);
        sb.append(", fileName=").append(fileName);
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