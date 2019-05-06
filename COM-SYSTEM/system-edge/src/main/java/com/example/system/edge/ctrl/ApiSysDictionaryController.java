package com.example.system.edge.ctrl;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.system.base.BaseController;
import com.example.system.edge.service.SysDictionaryService;
import com.example.system.vo.SysDictionaryVo;
import com.zjapl.common.result.ResultEx;

/**
 * 文件名：SysDictionaryController.java
 * 日　期：2017年1月16日
 * 版　权：ZJAPL
 * 作　者：wug
 * 类说明：
 */
@Controller
@RequestMapping("/api/sysDictionary")
public class ApiSysDictionaryController extends BaseController{
	
	@Resource
	private SysDictionaryService sysDictionaryService;
	
	@RequestMapping("/list")
	@ResponseBody
	public ResultEx querySysDictionaryList(SysDictionaryVo sysDictionaryVo){
		return sysDictionaryService.querySysDictionaryList(sysDictionaryVo,getSysUser());
	}
	
	/**
	 * 新增或修改数据字典参数
	 * @param sysDictionary
	 * @return
	 */
	@RequestMapping("/addOrEdit")
	@ResponseBody
	public ResultEx addOrEditSysDictionary(SysDictionaryVo sysDictionaryVo){
		return sysDictionaryService.addOrEditSysDictionary(sysDictionaryVo, getSysUser());
	}
	
	/**
	 * 删除数据字典
	 * 1有效  0无效
	 * @param id
	 * @return
	 */
	@RequestMapping("/del")
	@ResponseBody
	public ResultEx delSysDictionary(SysDictionaryVo sysDictionaryVo){
		return sysDictionaryService.updateSysDictionary(sysDictionaryVo, getSysUser());
	}
	
	/**
	 * 查询字典的所有范围
	 * @return
	 */
	@RequestMapping("/querySysDictionaryScope")
	@ResponseBody
	public ResultEx querySysDictionaryScope(){
		return sysDictionaryService.querySysDictionaryScope(getSysUser());
	}
	
}
