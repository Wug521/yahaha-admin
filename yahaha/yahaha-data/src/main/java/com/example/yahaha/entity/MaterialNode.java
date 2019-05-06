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

public class MaterialNode implements Serializable {
	
    /**
     * 主键ID
     */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * 当前节点id
     */
    private String nodeId;

    /**
     * 节点名称
     */
    private String nodeName;

    /**
     * 父节点id
     */
    private String fatherNodeId;

    /**
     * 父节点名称
     */
    private String parantName;

    /**
     * 节点序号
     */
    private Short nodeNumber;

    /**
     * 节点类型，1图片，2视频
     */
    private Short nodeTpye;

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
     * 表字段：material_node.id
     * </pre>
     *
     * @return material_node.id：主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：主键ID
     * 表字段：material_node.id
     * </pre>
     *
     * @param id
     *            material_node.id：主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：当前节点id
     * 表字段：material_node.node_id
     * </pre>
     *
     * @return material_node.node_id：当前节点id
     */
    public String getNodeId() {
        return nodeId;
    }

    /**
     * <pre>
     * 设置：当前节点id
     * 表字段：material_node.node_id
     * </pre>
     *
     * @param nodeId
     *            material_node.node_id：当前节点id
     */
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId == null ? null : nodeId.trim();
    }

    /**
     * <pre>
     * 获取：节点名称
     * 表字段：material_node.node_name
     * </pre>
     *
     * @return material_node.node_name：节点名称
     */
    public String getNodeName() {
        return nodeName;
    }

    /**
     * <pre>
     * 设置：节点名称
     * 表字段：material_node.node_name
     * </pre>
     *
     * @param nodeName
     *            material_node.node_name：节点名称
     */
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName == null ? null : nodeName.trim();
    }

    /**
     * <pre>
     * 获取：父节点id
     * 表字段：material_node.father_node_id
     * </pre>
     *
     * @return material_node.father_node_id：父节点id
     */
    public String getFatherNodeId() {
        return fatherNodeId;
    }

    /**
     * <pre>
     * 设置：父节点id
     * 表字段：material_node.father_node_id
     * </pre>
     *
     * @param fatherNodeId
     *            material_node.father_node_id：父节点id
     */
    public void setFatherNodeId(String fatherNodeId) {
        this.fatherNodeId = fatherNodeId == null ? null : fatherNodeId.trim();
    }

    /**
     * <pre>
     * 获取：父节点名称
     * 表字段：material_node.parant_name
     * </pre>
     *
     * @return material_node.parant_name：父节点名称
     */
    public String getParantName() {
        return parantName;
    }

    /**
     * <pre>
     * 设置：父节点名称
     * 表字段：material_node.parant_name
     * </pre>
     *
     * @param parantName
     *            material_node.parant_name：父节点名称
     */
    public void setParantName(String parantName) {
        this.parantName = parantName == null ? null : parantName.trim();
    }

    /**
     * <pre>
     * 获取：节点序号
     * 表字段：material_node.node_number
     * </pre>
     *
     * @return material_node.node_number：节点序号
     */
    public Short getNodeNumber() {
        return nodeNumber;
    }

    /**
     * <pre>
     * 设置：节点序号
     * 表字段：material_node.node_number
     * </pre>
     *
     * @param nodeNumber
     *            material_node.node_number：节点序号
     */
    public void setNodeNumber(Short nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    /**
     * <pre>
     * 获取：节点类型，1图片，2视频
     * 表字段：material_node.node_tpye
     * </pre>
     *
     * @return material_node.node_tpye：节点类型，1图片，2视频
     */
    public Short getNodeTpye() {
        return nodeTpye;
    }

    /**
     * <pre>
     * 设置：节点类型，1图片，2视频
     * 表字段：material_node.node_tpye
     * </pre>
     *
     * @param nodeTpye
     *            material_node.node_tpye：节点类型，1图片，2视频
     */
    public void setNodeTpye(Short nodeTpye) {
        this.nodeTpye = nodeTpye;
    }

    /**
     * <pre>
     * 获取：状态(数据)
     * 表字段：material_node.status
     * </pre>
     *
     * @return material_node.status：状态(数据)
     */
    public Short getStatus() {
        return status;
    }

    /**
     * <pre>
     * 设置：状态(数据)
     * 表字段：material_node.status
     * </pre>
     *
     * @param status
     *            material_node.status：状态(数据)
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * <pre>
     * 获取：机构编码
     * 表字段：material_node.org_code
     * </pre>
     *
     * @return material_node.org_code：机构编码
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * <pre>
     * 设置：机构编码
     * 表字段：material_node.org_code
     * </pre>
     *
     * @param orgCode
     *            material_node.org_code：机构编码
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * <pre>
     * 获取：创建人
     * 表字段：material_node.create_user
     * </pre>
     *
     * @return material_node.create_user：创建人
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * <pre>
     * 设置：创建人
     * 表字段：material_node.create_user
     * </pre>
     *
     * @param createUser
     *            material_node.create_user：创建人
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * <pre>
     * 获取：创建时间
     * 表字段：material_node.create_date
     * </pre>
     *
     * @return material_node.create_date：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：创建时间
     * 表字段：material_node.create_date
     * </pre>
     *
     * @param createDate
     *            material_node.create_date：创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：修改人
     * 表字段：material_node.update_user
     * </pre>
     *
     * @return material_node.update_user：修改人
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * <pre>
     * 设置：修改人
     * 表字段：material_node.update_user
     * </pre>
     *
     * @param updateUser
     *            material_node.update_user：修改人
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * <pre>
     * 获取：修改时间
     * 表字段：material_node.update_date
     * </pre>
     *
     * @return material_node.update_date：修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * <pre>
     * 设置：修改时间
     * 表字段：material_node.update_date
     * </pre>
     *
     * @param updateDate
     *            material_node.update_date：修改时间
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
        MaterialNode other = (MaterialNode) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNodeId() == null ? other.getNodeId() == null : this.getNodeId().equals(other.getNodeId()))
            && (this.getNodeName() == null ? other.getNodeName() == null : this.getNodeName().equals(other.getNodeName()))
            && (this.getFatherNodeId() == null ? other.getFatherNodeId() == null : this.getFatherNodeId().equals(other.getFatherNodeId()))
            && (this.getParantName() == null ? other.getParantName() == null : this.getParantName().equals(other.getParantName()))
            && (this.getNodeNumber() == null ? other.getNodeNumber() == null : this.getNodeNumber().equals(other.getNodeNumber()))
            && (this.getNodeTpye() == null ? other.getNodeTpye() == null : this.getNodeTpye().equals(other.getNodeTpye()))
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
        result = prime * result + ((getNodeId() == null) ? 0 : getNodeId().hashCode());
        result = prime * result + ((getNodeName() == null) ? 0 : getNodeName().hashCode());
        result = prime * result + ((getFatherNodeId() == null) ? 0 : getFatherNodeId().hashCode());
        result = prime * result + ((getParantName() == null) ? 0 : getParantName().hashCode());
        result = prime * result + ((getNodeNumber() == null) ? 0 : getNodeNumber().hashCode());
        result = prime * result + ((getNodeTpye() == null) ? 0 : getNodeTpye().hashCode());
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
        sb.append(", nodeId=").append(nodeId);
        sb.append(", nodeName=").append(nodeName);
        sb.append(", fatherNodeId=").append(fatherNodeId);
        sb.append(", parantName=").append(parantName);
        sb.append(", nodeNumber=").append(nodeNumber);
        sb.append(", nodeTpye=").append(nodeTpye);
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