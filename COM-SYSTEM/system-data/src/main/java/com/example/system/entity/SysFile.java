/**
 * Copyright(C) 2006-2016 安普利科技
 * All rights reserved
 * 2019-05-07 13:31:24 Created
 * 
 */
package com.example.system.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SysFile implements Serializable {

    /**
     * ID
     */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    private Long id;

    /**
     * 系统文件名称
     */
    private String fileName;

    /**
     * 文件类型(文档/图片/视频)
     */
    private Short fileType;

    /**
     * 文件后缀
     */
    private String suffix;

    /**
     * 文件保存路径
     */
    private String filePath;

    /**
     * 文件访问路劲
     */
    private String showsPath;

    /**
     * 上传人ID
     */
    private Long userId;

    /**
     * 上传人名称
     */
    private String userName;

    /**
     * 任务ID
     */
    private Long taskId;

    /**
     * 原文件名称
     */
    private String originalName;

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
     * 表字段：sys_file.id
     * </pre>
     *
     * @return sys_file.id：主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：主键ID
     * 表字段：sys_file.id
     * </pre>
     *
     * @param id
     *            sys_file.id：主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：系统文件名称
     * 表字段：sys_file.file_name
     * </pre>
     *
     * @return sys_file.file_name：系统文件名称
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * <pre>
     * 设置：系统文件名称
     * 表字段：sys_file.file_name
     * </pre>
     *
     * @param fileName
     *            sys_file.file_name：系统文件名称
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * <pre>
     * 获取：文件类型(文档/图片/视频)
     * 表字段：sys_file.file_type
     * </pre>
     *
     * @return sys_file.file_type：文件类型(文档/图片/视频)
     */
    public Short getFileType() {
        return fileType;
    }

    /**
     * <pre>
     * 设置：文件类型(文档/图片/视频)
     * 表字段：sys_file.file_type
     * </pre>
     *
     * @param fileType
     *            sys_file.file_type：文件类型(文档/图片/视频)
     */
    public void setFileType(Short fileType) {
        this.fileType = fileType;
    }

    /**
     * <pre>
     * 获取：文件后缀
     * 表字段：sys_file.suffix
     * </pre>
     *
     * @return sys_file.suffix：文件后缀
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * <pre>
     * 设置：文件后缀
     * 表字段：sys_file.suffix
     * </pre>
     *
     * @param suffix
     *            sys_file.suffix：文件后缀
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix == null ? null : suffix.trim();
    }

    /**
     * <pre>
     * 获取：文件保存路径
     * 表字段：sys_file.file_path
     * </pre>
     *
     * @return sys_file.file_path：文件保存路径
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * <pre>
     * 设置：文件保存路径
     * 表字段：sys_file.file_path
     * </pre>
     *
     * @param filePath
     *            sys_file.file_path：文件保存路径
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    /**
     * <pre>
     * 获取：文件访问路劲
     * 表字段：sys_file.shows_path
     * </pre>
     *
     * @return sys_file.shows_path：文件访问路劲
     */
    public String getShowsPath() {
        return showsPath;
    }

    /**
     * <pre>
     * 设置：文件访问路劲
     * 表字段：sys_file.shows_path
     * </pre>
     *
     * @param showsPath
     *            sys_file.shows_path：文件访问路劲
     */
    public void setShowsPath(String showsPath) {
        this.showsPath = showsPath == null ? null : showsPath.trim();
    }

    /**
     * <pre>
     * 获取：上传人ID
     * 表字段：sys_file.user_id
     * </pre>
     *
     * @return sys_file.user_id：上传人ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * <pre>
     * 设置：上传人ID
     * 表字段：sys_file.user_id
     * </pre>
     *
     * @param userId
     *            sys_file.user_id：上传人ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * <pre>
     * 获取：上传人名称
     * 表字段：sys_file.user_name
     * </pre>
     *
     * @return sys_file.user_name：上传人名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * <pre>
     * 设置：上传人名称
     * 表字段：sys_file.user_name
     * </pre>
     *
     * @param userName
     *            sys_file.user_name：上传人名称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * <pre>
     * 获取：任务ID
     * 表字段：sys_file.task_id
     * </pre>
     *
     * @return sys_file.task_id：任务ID
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * <pre>
     * 设置：任务ID
     * 表字段：sys_file.task_id
     * </pre>
     *
     * @param taskId
     *            sys_file.task_id：任务ID
     */
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    /**
     * <pre>
     * 获取：原文件名称
     * 表字段：sys_file.original_name
     * </pre>
     *
     * @return sys_file.original_name：原文件名称
     */
    public String getOriginalName() {
        return originalName;
    }

    /**
     * <pre>
     * 设置：原文件名称
     * 表字段：sys_file.original_name
     * </pre>
     *
     * @param originalName
     *            sys_file.original_name：原文件名称
     */
    public void setOriginalName(String originalName) {
        this.originalName = originalName == null ? null : originalName.trim();
    }

    /**
     * <pre>
     * 获取：状态(数据)
     * 表字段：sys_file.status
     * </pre>
     *
     * @return sys_file.status：状态(数据)
     */
    public Short getStatus() {
        return status;
    }

    /**
     * <pre>
     * 设置：状态(数据)
     * 表字段：sys_file.status
     * </pre>
     *
     * @param status
     *            sys_file.status：状态(数据)
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * <pre>
     * 获取：机构编码
     * 表字段：sys_file.org_code
     * </pre>
     *
     * @return sys_file.org_code：机构编码
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * <pre>
     * 设置：机构编码
     * 表字段：sys_file.org_code
     * </pre>
     *
     * @param orgCode
     *            sys_file.org_code：机构编码
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * <pre>
     * 获取：创建人
     * 表字段：sys_file.create_user
     * </pre>
     *
     * @return sys_file.create_user：创建人
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * <pre>
     * 设置：创建人
     * 表字段：sys_file.create_user
     * </pre>
     *
     * @param createUser
     *            sys_file.create_user：创建人
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * <pre>
     * 获取：创建时间
     * 表字段：sys_file.create_date
     * </pre>
     *
     * @return sys_file.create_date：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：创建时间
     * 表字段：sys_file.create_date
     * </pre>
     *
     * @param createDate
     *            sys_file.create_date：创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：修改人
     * 表字段：sys_file.update_user
     * </pre>
     *
     * @return sys_file.update_user：修改人
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * <pre>
     * 设置：修改人
     * 表字段：sys_file.update_user
     * </pre>
     *
     * @param updateUser
     *            sys_file.update_user：修改人
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * <pre>
     * 获取：修改时间
     * 表字段：sys_file.update_date
     * </pre>
     *
     * @return sys_file.update_date：修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * <pre>
     * 设置：修改时间
     * 表字段：sys_file.update_date
     * </pre>
     *
     * @param updateDate
     *            sys_file.update_date：修改时间
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
        SysFile other = (SysFile) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFileName() == null ? other.getFileName() == null : this.getFileName().equals(other.getFileName()))
            && (this.getFileType() == null ? other.getFileType() == null : this.getFileType().equals(other.getFileType()))
            && (this.getSuffix() == null ? other.getSuffix() == null : this.getSuffix().equals(other.getSuffix()))
            && (this.getFilePath() == null ? other.getFilePath() == null : this.getFilePath().equals(other.getFilePath()))
            && (this.getShowsPath() == null ? other.getShowsPath() == null : this.getShowsPath().equals(other.getShowsPath()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getOriginalName() == null ? other.getOriginalName() == null : this.getOriginalName().equals(other.getOriginalName()))
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
        result = prime * result + ((getFileName() == null) ? 0 : getFileName().hashCode());
        result = prime * result + ((getFileType() == null) ? 0 : getFileType().hashCode());
        result = prime * result + ((getSuffix() == null) ? 0 : getSuffix().hashCode());
        result = prime * result + ((getFilePath() == null) ? 0 : getFilePath().hashCode());
        result = prime * result + ((getShowsPath() == null) ? 0 : getShowsPath().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getOriginalName() == null) ? 0 : getOriginalName().hashCode());
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
        sb.append(", fileName=").append(fileName);
        sb.append(", fileType=").append(fileType);
        sb.append(", suffix=").append(suffix);
        sb.append(", filePath=").append(filePath);
        sb.append(", showsPath=").append(showsPath);
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", taskId=").append(taskId);
        sb.append(", originalName=").append(originalName);
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