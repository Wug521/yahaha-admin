package com.example.yahaha.service.impl;

import org.springframework.stereotype.Service;

import com.example.system.entity.SysUser;
import com.example.yahaha.entity.vo.CategoryQueryVo;
import com.example.yahaha.entity.vo.CategoryVo;
import com.example.yahaha.service.ICategoryService;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;

/**
 * 标签/分类接口
 * @author Mr.Wug
 *
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

	@Override
	public ResultEx add(CategoryQueryVo queryVo, SysUser sysUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultEx update(CategoryQueryVo queryVo, SysUser sysUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultEx edit(Long id, SysUser sysUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjectResultEx<PageInfo<CategoryVo>> queryCategoryList(CategoryQueryVo queryVo, SysUser sysUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
