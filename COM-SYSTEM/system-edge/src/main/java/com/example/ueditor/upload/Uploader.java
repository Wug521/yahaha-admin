package com.example.ueditor.upload;


import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.example.ueditor.define.State;


@Service
public class Uploader {
	
	@Resource
	private FtpUploader ftpUploader;

	public State doExec(HttpServletRequest request, Map<String, Object> conf) {
		String filedName = (String) conf.get("fieldName");
		State state = null;

		if ("true".equals(conf.get("isBase64"))) {
			state = Base64Uploader.save(request.getParameter(filedName),conf);
		}else {
			if((boolean) conf.get("useOSSUpload")){
				state = ftpUploader.save(request, conf);
			}else{
				state = BinaryUploader.save(request, conf);
			}
		}
		return state;
	}
}
