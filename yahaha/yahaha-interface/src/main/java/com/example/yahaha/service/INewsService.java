package com.example.yahaha.service;

import com.example.system.entity.SysUser;
import com.example.yahaha.entity.vo.NewsQueryVo;
import com.example.yahaha.entity.vo.NewsVo;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;

public interface INewsService {
	
	/**
	 * 添加新闻
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ResultEx add(NewsVo vo, SysUser sysUser);
	
	/**
	 * 修改新闻
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ResultEx update(NewsVo vo, SysUser sysUser);
	
	/**
	 * 删除新闻(伪删除)
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ResultEx edit(Long id, SysUser sysUser);
	
	/**
	 * 分页查询新闻List
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ObjectResultEx<PageInfo<NewsVo>> queryNewsList(NewsQueryVo queryVo,SysUser sysUser);

}
