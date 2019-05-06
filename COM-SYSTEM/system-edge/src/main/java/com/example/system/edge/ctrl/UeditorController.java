package com.example.system.edge.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ueditor.ActionEnter;



@Controller
@RequestMapping("/use")
public class UeditorController {
	
	@Resource
	private ActionEnter actionEnter;

	@RequestMapping("/config")
	@ResponseBody
	public void config(HttpServletRequest request, HttpServletResponse response) {
		String rootPath = request.getServletContext().getRealPath("/");
        try {
        	String exec = actionEnter.exec(request,rootPath);
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }

}
