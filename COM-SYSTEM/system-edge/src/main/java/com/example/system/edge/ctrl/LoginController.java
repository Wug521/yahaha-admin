package com.example.system.edge.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.example.system.shiro.ShiroUtils;
import com.example.system.utils.ServletRequestUtils;
import com.zjapl.common.result.ResultEx;


/**
 * 
 * 文件名：LoginController.java
 * 版本号：V 1.0
 * 日　期：2016年5月24日
 * 版　权：ZJAPL
 * 作　者：wuzy
 * 类说明：
 */
@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(ModelMap model) {
		if (!SecurityUtils.getSubject().isAuthenticated()) {
			model.addAttribute("tag", false);
			return "login";
		}
		return "redirect:/index";
	}

	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		if (ServletRequestUtils.isAjaxRequest(request)){//ajax请求
			try {
				response.setCharacterEncoding("UTF-8");  
				PrintWriter out = response.getWriter();  
				out.println(JSON.toJSONString(new ResultEx().makeSuccessResult()));
				out.flush();  
				out.close();  
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		try {
			if (SecurityUtils.getSubject().isAuthenticated()) {
				ShiroUtils.getSession().setAttribute("shiro_user_name", ShiroUtils.getShiroPrincipal().getSysUser().getRealName());
			}
		} catch (Exception e) {
		}
		return "index";
	}
}
