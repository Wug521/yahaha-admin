package com.example.system.edge.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.system.base.BaseController;
import com.example.system.edge.service.SysDictionaryService;
import com.example.system.entity.SysDictionary;
import com.example.system.utils.EnumUtils;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;

/**
 * 文件名：ApiMeetingCommonController.java
 * 日　期：2017年2月10日
 * 版　权：ZJAPL
 * 作　者：wug
 * 类说明：
 */
@Controller
@RequestMapping("/api/common")
public class CommonController extends BaseController{
	
	@Resource
	private SysDictionaryService sysDictionaryService;
	
	/**
	 * 获取枚举数据字典
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/getEnumDics")
	public ResultEx getEnumDics(@RequestParam String type) throws Exception {
		ObjectResultEx<List<SysDictionary>> resultEx = EnumUtils.getEnumDics(type);
		return resultEx;
	}
	
	/**
	 * 查询字典的所有范围
	 * @return
	 */
	@RequestMapping("/querySysDictionaryScope")
	@ResponseBody
	public ResultEx querySysDictionaryScope(@RequestParam("type") String type){
		return sysDictionaryService.querySysDictionaryList(type,getSysUser());
	}

}
