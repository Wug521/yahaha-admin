package com.example.ueditor.upload;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.system.base.BaseFileParams;
import com.example.ueditor.PathFormat;
import com.example.ueditor.define.AppInfo;
import com.example.ueditor.define.BaseState;
import com.example.ueditor.define.FileType;
import com.example.ueditor.define.State;
import com.zjapl.common.util.FileUtil;

@Service
public class FtpUploader extends BaseFileParams{
    
	@Resource
	private StorageManager storageManager;
	
	public State save(HttpServletRequest request, Map<String, Object> conf){
	    try{
	    	MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
	        MultipartFile multipartFile = multipartRequest.getFile(conf.get("fieldName").toString());
	       
	        String savePath = (String)conf.get("savePath");
	        String originFileName = multipartFile.getOriginalFilename();
	        String suffix = FileType.getSuffixByFilename(originFileName);
	
	        originFileName = originFileName.substring(0, originFileName.length() - suffix.length());
	        savePath = savePath + suffix;
	      
	        long maxSize = ((Long)conf.get("maxSize")).longValue();
	      
	        if (!validType(suffix, (String[])conf.get("allowFiles"))) {
	    	    return new BaseState(false, AppInfo.NOT_ALLOW_FILE_TYPE);
	        }
	        savePath = preWebAccessName + File.separator + preAppName + PathFormat.parse(savePath, originFileName);
	        savePath = FileUtil.convertToLinuxDirectory(savePath);
	        State storageState = storageManager.saveFtpFileByInputStream(multipartFile,savePath, maxSize);
	        if (storageState.isSuccess()) {
	    	    storageState.putInfo("url", preUrlPath + savePath);
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
  
}