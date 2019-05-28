package com.example.yahaha.service;

import java.util.List;

import com.example.system.entity.SysUser;
import com.example.yahaha.entity.vo.CategoryQueryVo;
import com.example.yahaha.entity.vo.CategoryVo;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;

public interface ICategoryService {
	
	/**
	 * 添加标签/分类
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ResultEx add(CategoryVo vo, SysUser sysUser);
	
	/**
	 * 修改标签/分类
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ResultEx update(CategoryVo vo, SysUser sysUser);
	
	/**
	 * 删除标签/分类(伪删除)
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ResultEx edit(Long id, SysUser sysUser);
	
	/**
	 * 分页查询标签/分类List
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ObjectResultEx<PageInfo<CategoryVo>> queryCategoryList(CategoryQueryVo queryVo,SysUser sysUser);
	
	/**
	 * 查询标签/分类下拉List
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ObjectResultEx<List<CategoryVo>> getCategoryList(CategoryVo queryVo,SysUser sysUser);

}
