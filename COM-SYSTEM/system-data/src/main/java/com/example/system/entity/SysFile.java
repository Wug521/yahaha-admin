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


public class SysFile implements Serializable {
    /**
     * ID
     */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    private Long id;

	/**
     * 名称
     */
    private String fileName;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 所属单位名称
     */
    private String orgCode;

    /**
     * 存放路径
     */
    private String filePath;

    /**
     * 展示路径
     */
    private String showsPath;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 人员ID
     */
    private String userId;

    /**
     * 任务ID(对应资源需要上传文件的模块产生的ID号，方便查找)
     */
    private Long taskId;

    /**
     * 原文件名称
     */
    private String originalName;

    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 获取：ID
     * 表字段：APLCCP.SYS_FILE.ID
     * </pre>
     *
     * @return APLCCP.SYS_FILE.ID：ID
     */
    public Long getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：ID
     * 表字段：APLCCP.SYS_FILE.ID
     * </pre>
     *
     * @param id
     *            APLCCP.SYS_FILE.ID：ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：名称
     * 表字段：APLCCP.SYS_FILE.FILE_NAME
     * </pre>
     *
     * @return APLCCP.SYS_FILE.FILE_NAME：名称
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * <pre>
     * 设置：名称
     * 表字段：APLCCP.SYS_FILE.FILE_NAME
     * </pre>
     *
     * @param fileName
     *            APLCCP.SYS_FILE.FILE_NAME：名称
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * <pre>
     * 获取：文件类型
     * 表字段：APLCCP.SYS_FILE.FILE_TYPE
     * </pre>
     *
     * @return APLCCP.SYS_FILE.FILE_TYPE：文件类型
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * <pre>
     * 设置：文件类型
     * 表字段：APLCCP.SYS_FILE.FILE_TYPE
     * </pre>
     *
     * @param fileType
     *            APLCCP.SYS_FILE.FILE_TYPE：文件类型
     */
    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    /**
     * <pre>
     * 获取：所属单位名称
     * 表字段：APLCCP.SYS_FILE.ORG_CODE
     * </pre>
     *
     * @return APLCCP.SYS_FILE.ORG_CODE：所属单位名称
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * <pre>
     * 设置：所属单位名称
     * 表字段：APLCCP.SYS_FILE.ORG_CODE
     * </pre>
     *
     * @param orgCode
     *            APLCCP.SYS_FILE.ORG_CODE：所属单位名称
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * <pre>
     * 获取：存放路径
     * 表字段：APLCCP.SYS_FILE.FILE_PATH
     * </pre>
     *
     * @return APLCCP.SYS_FILE.FILE_PATH：存放路径
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * <pre>
     * 设置：存放路径
     * 表字段：APLCCP.SYS_FILE.FILE_PATH
     * </pre>
     *
     * @param filePath
     *            APLCCP.SYS_FILE.FILE_PATH：存放路径
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    /**
     * <pre>
     * 获取：展示路径
     * 表字段：APLCCP.SYS_FILE.SHOWS_PATH
     * </pre>
     *
     * @return APLCCP.SYS_FILE.SHOWS_PATH：展示路径
     */
    public String getShowsPath() {
        return showsPath;
    }

    /**
     * <pre>
     * 设置：展示路径
     * 表字段：APLCCP.SYS_FILE.SHOWS_PATH
     * </pre>
     *
     * @param showsPath
     *            APLCCP.SYS_FILE.SHOWS_PATH：展示路径
     */
    public void setShowsPath(String showsPath) {
        this.showsPath = showsPath == null ? null : showsPath.trim();
    }

    /**
     * <pre>
     * 获取：创建时间
     * 表字段：APLCCP.SYS_FILE.CREATE_DATE
     * </pre>
     *
     * @return APLCCP.SYS_FILE.CREATE_DATE：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：创建时间
     * 表字段：APLCCP.SYS_FILE.CREATE_DATE
     * </pre>
     *
     * @param createDate
     *            APLCCP.SYS_FILE.CREATE_DATE：创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：人员ID
     * 表字段：APLCCP.SYS_FILE.USER_ID
     * </pre>
     *
     * @return APLCCP.SYS_FILE.USER_ID：人员ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * <pre>
     * 设置：人员ID
     * 表字段：APLCCP.SYS_FILE.USER_ID
     * </pre>
     *
     * @param userId
     *            APLCCP.SYS_FILE.USER_ID：人员ID
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * <pre>
     * 获取：任务ID(对应资源需要上传文件的模块产生的ID号，方便查找)
     * 表字段：APLCCP.SYS_FILE.TASK_ID
     * </pre>
     *
     * @return APLCCP.SYS_FILE.TASK_ID：任务ID(对应资源需要上传文件的模块产生的ID号，方便查找)
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * <pre>
     * 设置：任务ID(对应资源需要上传文件的模块产生的ID号，方便查找)
     * 表字段：APLCCP.SYS_FILE.TASK_ID
     * </pre>
     *
     * @param taskId
     *            APLCCP.SYS_FILE.TASK_ID：任务ID(对应资源需要上传文件的模块产生的ID号，方便查找)
     */
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    /**
     * <pre>
     * 获取：原文件名称
     * 表字段：APLCCP.SYS_FILE.ORIGINAL_NAME
     * </pre>
     *
     * @return APLCCP.SYS_FILE.ORIGINAL_NAME：原文件名称
     */
    public String getOriginalName() {
        return originalName;
    }

    /**
     * <pre>
     * 设置：原文件名称
     * 表字段：APLCCP.SYS_FILE.ORIGINAL_NAME
     * </pre>
     *
     * @param originalName
     *            APLCCP.SYS_FILE.ORIGINAL_NAME：原文件名称
     */
    public void setOriginalName(String originalName) {
        this.originalName = originalName == null ? null : originalName.trim();
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
            && (this.getOrgCode() == null ? other.getOrgCode() == null : this.getOrgCode().equals(other.getOrgCode()))
            && (this.getFilePath() == null ? other.getFilePath() == null : this.getFilePath().equals(other.getFilePath()))
            && (this.getShowsPath() == null ? other.getShowsPath() == null : this.getShowsPath().equals(other.getShowsPath()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getOriginalName() == null ? other.getOriginalName() == null : this.getOriginalName().equals(other.getOriginalName()));
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
        result = prime * result + ((getOrgCode() == null) ? 0 : getOrgCode().hashCode());
        result = prime * result + ((getFilePath() == null) ? 0 : getFilePath().hashCode());
        result = prime * result + ((getShowsPath() == null) ? 0 : getShowsPath().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getOriginalName() == null) ? 0 : getOriginalName().hashCode());
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
        sb.append(", orgCode=").append(orgCode);
        sb.append(", filePath=").append(filePath);
        sb.append(", showsPath=").append(showsPath);
        sb.append(", createDate=").append(createDate);
        sb.append(", userId=").append(userId);
        sb.append(", taskId=").append(taskId);
        sb.append(", originalName=").append(originalName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}