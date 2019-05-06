package com.example.system.vo;

import java.util.Date;

import com.github.pagehelper.PageInfo;

public class QuerySysFileVo  extends PageInfo<Object>{

	private static final long serialVersionUID = 1L;
	
	private Long id;

	/**
     * 名称
     */
    private String fileName;

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

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getShowsPath() {
		return showsPath;
	}

	public void setShowsPath(String showsPath) {
		this.showsPath = showsPath;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
     * 创建时间
     */
    private Date createDate;

}
