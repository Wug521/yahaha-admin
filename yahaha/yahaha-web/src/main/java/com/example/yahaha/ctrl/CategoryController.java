package com.example.yahaha.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.system.base.BaseController;
import com.example.yahaha.entity.vo.CategoryQueryVo;
import com.example.yahaha.entity.vo.CategoryVo;
import com.example.yahaha.service.ICategoryService;
import com.zjapl.common.result.ResultEx;

@RestController
@RequestMapping(value="/category")
public class CategoryController extends BaseController{
	
	@Autowired
	ICategoryService categoryNodeService;
	
	
	/**
	 * 标签/分类新增
	 * @return
	 */
	@PostMapping("/add")
	public ResultEx addOrEditResource(@RequestBody CategoryVo vo){
		return categoryNodeService.add(vo, getSysUser());
	}
	
	/**
	 * 标签/分类修改
	 * @return
	 */
	@PostMapping("/update")
	public ResultEx update(@RequestBody CategoryVo vo){
		return categoryNodeService.update(vo, getSysUser());
	}
	
	/**
	 * 标签/分类删除
	 * @return
	 */
	@GetMapping("/edit")
	public ResultEx editStatus(Long id){
		return categoryNodeService.edit(id, getSysUser());
	}
	
	/**
	 * 分页查询标签/分类List
	 * @return
	 */
	@PostMapping("/page")
	public ResultEx list(@RequestBody CategoryQueryVo query){
		return categoryNodeService.queryCategoryList(query, getSysUser());
	}
	
	/**
	 * 查询标签/分类下拉List
	 * @return
	 */
	@PostMapping("/list")
	public ResultEx list(@RequestBody CategoryVo query){
		return categoryNodeService.getCategoryList(query, getSysUser());
	}

}
