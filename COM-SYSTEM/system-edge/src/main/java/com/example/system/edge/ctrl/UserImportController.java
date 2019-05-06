package com.example.system.edge.ctrl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.system.base.BaseController;
import com.example.system.edge.service.SysUserService;
import com.example.system.edge.service.UserImportService;
import com.zjapl.common.result.ResultEx;
import com.zjapl.common.util.StringUtil;

/**
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/system")
public class UserImportController extends BaseController {
	
	@Resource
	private SysUserService sysUserService;
	
	@Resource
	private  UserImportService userImportService;
	
	/**
	 * 跳转到用户导入userImport.html
	 * 
	 * @return
	 */
	@RequestMapping("/userImport")
	public String manageDept(ModelMap model) {
		return "system/userImport";
	}

	/**
	 * 用户模板下载
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/downLoadFile", method = RequestMethod.GET)
	public void downLoadFile(HttpServletRequest request,HttpServletResponse response) throws Exception {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		String fileName = "用户模板导入.xls"; // 设置下载文件名字
		String path = request.getServletContext().getRealPath("/");
		String ctxPath = path+ "WEB-INF/views/template/userImportTemplate.xls";
		System.out.println(ctxPath);
		response.setContentType("application/vnd.ms-excel");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode(fileName, "utf-8"));
		bis = new BufferedInputStream(new FileInputStream(ctxPath));
		bos = new BufferedOutputStream(response.getOutputStream());
		byte[] buff = new byte[2048];
		int bytesRead;
		while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
			bos.write(buff, 0, bytesRead);
		}
		bis.close();
		bos.close();
	}
	
	@ResponseBody
	@RequestMapping(value="/upLoadFile")
    public ResultEx upLoadFile(HttpServletRequest request){
		return userImportService.upLoadFile(request, getSysUser());
    }

	public String getStringResult(String value) {
		return "null".equals(value) == true ? "" : value;
	}
	
	public Boolean checkNull(Object[] s){
		boolean bool=false;
		for (int j = 0; j < s.length; j++) {
			//有一个字段为空返回true
			if(StringUtil.isEmpty(s[j]))
				bool=true;
		}
		return bool;
	}
}
