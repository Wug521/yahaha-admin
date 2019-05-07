package com.example.system.edge.service;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.system.entity.SysFile;
import com.example.system.entity.SysUser;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;

public interface IFileService {

	/** 
	 * 文件上传
	 * @param request
	 * @param userId
	 * @param orgCode
	 * @return
	 */
	public ResultEx uploadShowFile(HttpServletRequest request, SysUser user);
	
	/**
	 * 根据参数查询文件List
	 * @param ids
	 * @return
	 */
	public ObjectResultEx<List<SysFile>> queryList(String ids);
	
	/**
	 * FTP上传文件
	 * @param in
	 * @param remoteDir
	 * @throws Exception
	 */
	public void ftpUploadFile(InputStream in,String remoteDir) throws Exception;
	
	/**
	 * FTP下载文件
	 * @param response
	 * @param path
	 * @throws Exception
	 */
	public void downloadFile(HttpServletRequest request,HttpServletResponse response,String filePathAndName) throws Exception;
}
