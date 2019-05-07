package com.example.system.edge.ctrl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.system.base.BaseController;
import com.example.system.edge.service.IFileService;
import com.zjapl.common.result.ResultEx;


/**
 * 
 * 文件名：SysFileController.java
 * 版本号：V 1.0
 * 日　期：2016年5月24日
 * 版　权：ZJAPL
 * 作　者：wuzy
 * 类说明：
 */
@Controller
@RequestMapping("/sysFile")
public class SysFileController extends BaseController{
	
	@Autowired
	private IFileService fileService; 
	
	@RequestMapping("/uploadShowFile")
	@ResponseBody
	public ResultEx upload(HttpServletRequest request) {
		try {
			return fileService.uploadShowFile(request, getSysUser());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResultEx().makeInternalErrorResult();
		}
	}
}
