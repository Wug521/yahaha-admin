package com.example.yahaha.entity.vo;

import com.github.pagehelper.PageInfo;

public class MaterialNodeQueryVo extends PageInfo<Object> {
	
	private static final long serialVersionUID = 1L;
	
	/**
     * 主键ID
     */
    private Long id;
	
	/**
     * 节点名称
     */
    private String nodeName;
    
    /**
     * 节点类型，1图片，2视频
     */
    private Short nodeTpye;
    
    /**
     * 系统文件表id
     */
    private Long fid;

    /**
     * 系统文件表文件名
     */
    private String fileName;

    /**
     * 文件路径
     */
    private String fileUrl;
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public Short getNodeTpye() {
		return nodeTpye;
	}

	public void setNodeTpye(Short nodeTpye) {
		this.nodeTpye = nodeTpye;
	}

	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
}