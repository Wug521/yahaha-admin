package com.example.system.kaptcha;

import java.awt.image.BufferedImage;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

/**
 * 文件名：KaptchaController.java
 * 版本号：V 1.0
 * 日　期：2016年5月31日
 * 版　权：ZJAPL
 * 作　者：wuzy
 * 类说明：
 */
@Controller
@RequestMapping(value="/captcha")
public class KaptchaController {
    
	@Resource
	private Producer captchaProducer;  
	  
    
    /**
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/image")  
    public void getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {  
      
    	HttpSession session = request.getSession();  
        response.setDateHeader("Expires", 0);  
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
        response.setHeader("Pragma", "no-cache");  
        
        String capText = captchaProducer.createText();  
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);  
        
        BufferedImage bi = captchaProducer.createImage(capText);  
        ServletOutputStream out = response.getOutputStream();  
        ImageIO.write(bi, "jpg", out);  
        try {  
            out.flush();  
        } finally {  
            out.close();  
        }  
    } 
	
}
