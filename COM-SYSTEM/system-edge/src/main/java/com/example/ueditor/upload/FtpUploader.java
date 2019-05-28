package com.example.ueditor.upload;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.system.config.OSSConfig;
import com.example.ueditor.define.AppInfo;
import com.example.ueditor.define.BaseState;
import com.example.ueditor.define.FileType;
import com.example.ueditor.define.State;

@Service
public class FtpUploader{
    
	@Autowired
	OSSConfig ossConfig;
	
	@Resource
	private StorageManager storageManager;
	
	public State save(HttpServletRequest request, Map<String, Object> conf){
	    try{
	    	MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
	        MultipartFile multipartFile = multipartRequest.getFile(conf.get("fieldName").toString());
	       
	        String originFileName = multipartFile.getOriginalFilename();
	        String suffix = FileType.getSuffixByFilename(originFileName);
	      
	        long maxSize = ((Long)conf.get("maxSize")).longValue();
	      
	        if (!validType(suffix, (String[])conf.get("allowFiles"))) {
	    	    return new BaseState(false, AppInfo.NOT_ALLOW_FILE_TYPE);
	        }
	        String fileName = generateFileName(originFileName);
	        State storageState = storageManager.saveOSSFileByInputStream(multipartFile,fileName, maxSize);
	        if (storageState.isSuccess()) {
	    	    storageState.putInfo("url", "http://" + ossConfig.getBucketName()+ "." + ossConfig.getEndpoint() + "/" + fileName);
	            storageState.putInfo("type", suffix);
	            storageState.putInfo("original", originFileName + suffix);
	        }
	        return storageState;
	        } catch (Exception e) {
	    	    e.printStackTrace();
		    }
	    return new BaseState(false, AppInfo.IO_ERROR);
	}

  @SuppressWarnings("rawtypes")
  private static boolean validType(String type, String[] allowTypes) {
    List list = Arrays.asList(allowTypes);
    return list.contains(type);
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
  
}