package com.example.yahaha.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.system.base.BaseController;
import com.example.yahaha.entity.vo.CollectQueryVo;
import com.example.yahaha.entity.vo.CollectVo;
import com.example.yahaha.service.ICollectService;
import com.zjapl.common.result.ResultEx;

@RestController
@RequestMapping(value="/collect")
public class CollectController extends BaseController{
	
	@Autowired
	ICollectService collectService;
	
	/**
	 * 收藏新增
	 * @return
	 */
	@PostMapping("/add")
	public ResultEx addCollect(@RequestBody CollectVo vo){
		return collectService.add(vo, getSysUser());
	}
	
	/**
	 * 收藏删除
	 * @return
	 */
	@GetMapping("/del")
	public ResultEx delCollect(String ids){
		return collectService.edit(ids, getSysUser());
	}
	
	/**
	 * 分页查询收藏List
	 * @return
	 */
	@PostMapping("/page")
	public ResultEx list(@RequestBody CollectQueryVo query){
		return collectService.queryCollectList(query, getSysUser());
	}

}
