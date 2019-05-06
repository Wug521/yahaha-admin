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

public class MaterialNodeFile implements Serializable {
	
    /**
     * 主键ID
     */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * 素材节点表id
     */
    private Long mid;

    /**
     * 素材节点表节点名称
     */
    private String nodeName;

    /**
     * 系统文件表id
     */
    private Long fid;

    /**
     * 系统文件表文件名
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
     * 表字段：material_node_file.id
     * </pre>
     *
     * @return material_node_file.id：主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：主键ID
     * 表字段：material_node_file.id
     * </pre>
     *
     * @param id
     *            material_node_file.id：主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：素材节点表id
     * 表字段：material_node_file.mid
     * </pre>
     *
     * @return material_node_file.mid：素材节点表id
     */
    public Long getMid() {
        return mid;
    }

    /**
     * <pre>
     * 设置：素材节点表id
     * 表字段：material_node_file.mid
     * </pre>
     *
     * @param mid
     *            material_node_file.mid：素材节点表id
     */
    public void setMid(Long mid) {
        this.mid = mid;
    }

    /**
     * <pre>
     * 获取：素材节点表节点名称
     * 表字段：material_node_file.node_name
     * </pre>
     *
     * @return material_node_file.node_name：素材节点表节点名称
     */
    public String getNodeName() {
        return nodeName;
    }

    /**
     * <pre>
     * 设置：素材节点表节点名称
     * 表字段：material_node_file.node_name
     * </pre>
     *
     * @param nodeName
     *            material_node_file.node_name：素材节点表节点名称
     */
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName == null ? null : nodeName.trim();
    }

    /**
     * <pre>
     * 获取：系统文件表id
     * 表字段：material_node_file.fid
     * </pre>
     *
     * @return material_node_file.fid：系统文件表id
     */
    public Long getFid() {
        return fid;
    }

    /**
     * <pre>
     * 设置：系统文件表id
     * 表字段：material_node_file.fid
     * </pre>
     *
     * @param fid
     *            material_node_file.fid：系统文件表id
     */
    public void setFid(Long fid) {
        this.fid = fid;
    }

    /**
     * <pre>
     * 获取：系统文件表文件名
     * 表字段：material_node_file.file_name
     * </pre>
     *
     * @return material_node_file.file_name：系统文件表文件名
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * <pre>
     * 设置：系统文件表文件名
     * 表字段：material_node_file.file_name
     * </pre>
     *
     * @param fileName
     *            material_node_file.file_name：系统文件表文件名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * <pre>
     * 获取：状态(数据)
     * 表字段：material_node_file.status
     * </pre>
     *
     * @return material_node_file.status：状态(数据)
     */
    public Short getStatus() {
        return status;
    }

    /**
     * <pre>
     * 设置：状态(数据)
     * 表字段：material_node_file.status
     * </pre>
     *
     * @param status
     *            material_node_file.status：状态(数据)
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * <pre>
     * 获取：机构编码
     * 表字段：material_node_file.org_code
     * </pre>
     *
     * @return material_node_file.org_code：机构编码
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * <pre>
     * 设置：机构编码
     * 表字段：material_node_file.org_code
     * </pre>
     *
     * @param orgCode
     *            material_node_file.org_code：机构编码
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * <pre>
     * 获取：创建人
     * 表字段：material_node_file.create_user
     * </pre>
     *
     * @return material_node_file.create_user：创建人
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * <pre>
     * 设置：创建人
     * 表字段：material_node_file.create_user
     * </pre>
     *
     * @param createUser
     *            material_node_file.create_user：创建人
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * <pre>
     * 获取：创建时间
     * 表字段：material_node_file.create_date
     * </pre>
     *
     * @return material_node_file.create_date：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：创建时间
     * 表字段：material_node_file.create_date
     * </pre>
     *
     * @param createDate
     *            material_node_file.create_date：创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：修改人
     * 表字段：material_node_file.update_user
     * </pre>
     *
     * @return material_node_file.update_user：修改人
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * <pre>
     * 设置：修改人
     * 表字段：material_node_file.update_user
     * </pre>
     *
     * @param updateUser
     *            material_node_file.update_user：修改人
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * <pre>
     * 获取：修改时间
     * 表字段：material_node_file.update_date
     * </pre>
     *
     * @return material_node_file.update_date：修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * <pre>
     * 设置：修改时间
     * 表字段：material_node_file.update_date
     * </pre>
     *
     * @param updateDate
     *            material_node_file.update_date：修改时间
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
        MaterialNodeFile other = (MaterialNodeFile) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMid() == null ? other.getMid() == null : this.getMid().equals(other.getMid()))
            && (this.getNodeName() == null ? other.getNodeName() == null : this.getNodeName().equals(other.getNodeName()))
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
        result = prime * result + ((getMid() == null) ? 0 : getMid().hashCode());
        result = prime * result + ((getNodeName() == null) ? 0 : getNodeName().hashCode());
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
        sb.append(", mid=").append(mid);
        sb.append(", nodeName=").append(nodeName);
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