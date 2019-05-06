package com.example.system.edge.service;

import java.io.File;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.system.base.BaseFileParams;
import com.example.system.dao.ISysFileDao;
import com.example.system.entity.SysFile;
import com.example.system.entity.SysUser;
import com.example.system.vo.QuerySysFileVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ResultEx;
import com.zjapl.common.result.XResult.ErrorCode;
import com.zjapl.common.util.FTPUtil;
import com.zjapl.common.util.FileUtil;
import com.zjapl.common.util.StringUtil;

import tk.mybatis.mapper.entity.Example;
/**
 * 文件名：SysFileService.java
 * 版本号：V 1.0
 * 日　期：2016年10月20日
 * 版　权：ZJAPL
 * 作　者：zhuj
 * 类说明：文件上传
 */
@Service
public class SysFileService extends BaseFileParams{
	final static Logger logger = LoggerFactory.getLogger(SysFileService.class);
	
	private boolean isFtpParamAvailable(){
		if (StringUtil.isEmpty(preAppName) || StringUtil.isEmpty(preWebAccessName) || StringUtil.isEmpty(preUrlPath)){
			logger.error("preAppName or preWebAccessName or preUrlPath is null.");
			return false;
		}
		if (StringUtil.isEmpty(ftpIp)){
			logger.error("ftpIp is null.");
			return false;
		}
		preUrlPath = FileUtil.addPathTailSeparate(preUrlPath);
		return true;
	}
	@Resource
	ISysFileDao sysFileDao;
	/**
	 * 文件上传
	 * @param multipartFile
	 * @param sysFile
	 * @return
	 * @throws Exception
	 */
	public SysFile uploadFile(MultipartFile multipartFile, SysFile sysFile) throws Exception{
		if (!isFtpParamAvailable()){
			logger.error("FtpParam is not avaliable.");
			throw new Exception("FtpParam is not avaliable.");
		}
		String originFileName = multipartFile.getOriginalFilename();
		if(StringUtil.isEmpty(originFileName)){
			logger.debug("获取multipartFile 文件名称为空, 保存文件失败。");
			return null;
		}
		sysFile.setOriginalName(originFileName);
		String fileName = generateFileName(originFileName);
		sysFile.setFileName(fileName);
		String fileType = fileName.substring(fileName.indexOf(".") + 1, fileName.length()).toLowerCase(); // 获得文件的后缀名
		sysFile.setFileType(fileType);
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		String monthPath = format.format(new Date());
		String path = monthPath + File.separator + fileType + File.separator;
		//针对不同角色，对文件存放的地址归类（主要针对移动应用场景)
		if(!StringUtil.isEmpty(sysFile.getOrgCode())){
			path = sysFile.getOrgCode() + File.separator + path;
		} else{
			path = "common" + File.separator + path;
		}
		InputStream inputStream = null;
		try {
			inputStream = multipartFile.getInputStream();
			String savePath = preWebAccessName + File.separator + preAppName + File.separator + path;
			savePath = FileUtil.convertToLinuxDirectory(savePath);
			String ftpPath = "ftp://" + ftpIp + ":" + ftpPort + "/" + savePath;
			sysFile.setFilePath(ftpPath);
			String urlPath = preUrlPath + savePath;
			sysFile.setShowsPath(FileUtil.convertToLinuxDirectory(urlPath));
			String remoteFile = savePath + fileName;
			logger.debug("文件[{}]存入FTP", remoteFile);
			//文件上传到FTP
			FTPUtil.uploadLocalFile(inputStream, remoteFile, ftpIp, ftpPort, ftpUserName, ftpPassword);
			/*logger.info("写入文件路径[{}]", savePath);
				File saveFile = new File(savePath);
				if (!saveFile.exists()) {
					saveFile.mkdirs();
				}
				saveFile = new File(savePath, fileName);
				try {
					multipartFile.transferTo(saveFile);
				} catch (Exception e) {
					logger.error("uploadFile error.", e);
					throw e;
				}*/
			saveSysFileInfo(sysFile);
		} catch (Exception e) {
			throw e;
		} finally {
			if (inputStream != null){
				inputStream.close();
			}
		}
		return sysFile;
	}
	/**
	 * 保存系统文件信息
	 * @param sysFile
	 * @return
	 */
	private boolean saveSysFileInfo(SysFile sysFile){
		if (sysFile == null || StringUtil.isEmpty(sysFile.getFileName())|| StringUtil.isEmpty(sysFile.getShowsPath())|| StringUtil.isEmpty(sysFile.getFilePath())){
			logger.error("saveSysFileInfo error. fileName or showsPath or filePath is empty.");
			return false;
		}
		sysFile.setCreateDate(new Date());
		sysFileDao.insertSelective(sysFile);
		return true;
	}
	/**
	 * 生成文件名称
	 * @param fileName
	 * @return
	 */
	private synchronized String generateFileName(String fileName) {
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String formatDate = format.format(new Date());
		int random = new Random().nextInt(10000);
		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);
		return formatDate + random + extension;
	}
	public Map<String, String> savaFiles(HttpServletRequest request, SysUser sysUser){
		Map<String, String> result = new HashMap<>();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		// 根据请求端参数名获得图片OR文件
		Map<String, List<MultipartFile>> fileMap = multipartRequest.getMultiFileMap();
		if (fileMap == null || fileMap.isEmpty()){
			logger.info("上传文件为空");
			return null;
		}
		for (Map.Entry<String, List<MultipartFile>> entry : fileMap.entrySet()) {  
			System.out.println("key = " + entry.getKey() + " and value = " + entry.getValue()); 
			if (StringUtil.isEmpty(entry.getKey()) || entry.getValue() == null || entry.getValue().isEmpty()){
				logger.info("上传文件input name为空，或者上传文件为空");
				continue;
			}
			List<String> sysFileIds = new ArrayList<>();
			for(MultipartFile mFile : entry.getValue()){
				SysFile sysFileTmp = null;
				try {
					SysFile sysFile = new SysFile();
					sysFile.setCreateDate(new Date());
					sysFile.setOrgCode(sysUser.getOrgCode());
					sysFile.setUserId(String.valueOf(sysUser.getId()));
					sysFileTmp = uploadFile(mFile, sysFile);
				} catch (Exception e) {
					logger.error("uploadFile error.", e);
				}
				if (sysFileTmp != null && sysFileTmp.getId() != null){
					sysFileIds.add(String.valueOf(sysFileTmp.getId()));
				}
			}
			String fileIds = convertListToString(sysFileIds);
			result.put(entry.getKey(), fileIds);
		}  
		return result;
	}
	/**
	 * 字符串list转成逗号分隔的字符串
	 * @param list
	 * @return
	 */
	private static String convertListToString(List<String> list){
		if (list == null || list.isEmpty()){
			return "";
		}
		String result = "";
		for(String tmp : list){
			result =  result + tmp + ",";
		}
		return result.substring(0, result.length() - 1);
	}
	/**
	 * 获取文件
	 * @param ids
	 * @return
	 */
	public List<SysFile> fetchShowPath(String ids){
		List<SysFile> pathList=new ArrayList<SysFile>();
		if(!StringUtil.isEmpty(ids)){
			String[] idsStr=ids.split(",");
			for(String idStr:idsStr){
				Long id=Long.valueOf(idStr);
				SysFile file=sysFileDao.selectByPrimaryKey(id);
				if(file!=null){
					pathList.add(file);
				}
			}
		}
		return pathList;
	}

	/**
	 *  上传文件
	 * @param request
	 * @param sysUser
	 * @return
	 * @throws Exception 
	 */
	public ResultEx uploadShowFile(HttpServletRequest request, SysUser sysUser) throws Exception {
		List<SysFile> sysFileList=new ArrayList<SysFile>();
		ResultEx ex= new ResultEx();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		// 根据请求端参数名获得图片OR文件
		Map<String, List<MultipartFile>> fileMap = multipartRequest.getMultiFileMap();
		if (fileMap == null || fileMap.isEmpty()){
			logger.info("上传文件为空");
			return ex.makeFailedResult(ErrorCode.BAD_PARAMETER);
		}
		for (Map.Entry<String, List<MultipartFile>> entry : fileMap.entrySet()) {  
			System.out.println("key = " + entry.getKey() + " and value = " + entry.getValue()); 
			if (StringUtil.isEmpty(entry.getKey()) || entry.getValue() == null || entry.getValue().isEmpty()){
				logger.info("上传文件input name为空，或者上传文件为空");
				continue;
			}
			for(MultipartFile mFile : entry.getValue()){
				try {
					SysFile sysFile = new SysFile();
					sysFile.setCreateDate(new Date());
					sysFile.setOrgCode(sysUser.getOrgCode());
					sysFile.setUserId(String.valueOf(sysUser.getId()));
					SysFile sysFileTmp = uploadFile(mFile, sysFile);
					sysFileList.add(sysFileTmp);
				} catch (Exception e) {
					logger.error("uploadFile error.", e);
					throw e;
				}
			}
		}
		ex.setData(sysFileList);
		return ex.makeSuccessResult();
	}
	
	/**
	 * ftp上传-Ueditor
	 * @param inputStream
	 * @param savePath
	 * @param maxSize
	 * @return
	 * @throws Exception 
	 */
	public void ftpUploadFile(InputStream in,String remoteDir) throws Exception{
		FTPUtil.uploadLocalFile(in, remoteDir, ftpIp, ftpPort, ftpUserName, ftpPassword);
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<SysFile> getDownloadResourceByOrgCode(QuerySysFileVo param){
		if(StringUtil.isEmpty(param.getPageNum())){
			param.setPageNum(1);
		}
		if(StringUtil.isEmpty(param.getPageSize())){
			param.setPageSize(15);
		}
		Example example = new Example(SysFile.class);
		example.createCriteria().andEqualTo("orgCode", param.getOrgCode());
		PageHelper.startPage(param.getPageNum(), param.getPageSize(), "CREATE_DATE ASC");
		List<SysFile> list = sysFileDao.selectByExample(example);
		if(list!=null){
			return new PageInfo(list);
		}else{
			return new PageInfo();
		}
	}
}
