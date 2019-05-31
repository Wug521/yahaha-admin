package com.example.yahaha.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.system.base.BaseController;
import com.example.yahaha.entity.vo.NewsQueryVo;
import com.example.yahaha.entity.vo.NewsVo;
import com.example.yahaha.service.INewsService;
import com.zjapl.common.result.ResultEx;

@RestController
@RequestMapping(value="/news")
public class NewsController extends BaseController{
	
	@Autowired
	INewsService newsService;
	
	
	/**
	 * 新闻新增
	 * @return
	 */
	@PostMapping("/add")
	public ResultEx addOrEditResource(@RequestBody NewsVo vo){
		return newsService.add(vo, getSysUser());
	}
	
	/**
	 * 新闻修改
	 * @return
	 */
	@PostMapping("/update")
	public ResultEx update(@RequestBody NewsVo vo){
		return newsService.update(vo, getSysUser());
	}
	
	/**
	 * 新闻删除
	 * @return
	 */
	@GetMapping("/updateStatus")
	public ResultEx updateStatus(Long id){
		return newsService.edit(id, getSysUser());
	}
	
	/**
	 * 分页查询新闻List
	 * @return
	 */
	@PostMapping("/list")
	public ResultEx list(@RequestBody NewsQueryVo query){
		return newsService.queryNewsList(query, getSysUser());
	}
	
}
