package com.example.yahaha.service;

import com.example.system.entity.SysUser;
import com.example.yahaha.entity.vo.CommentQueryVo;
import com.example.yahaha.entity.vo.CommentVo;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;

public interface ICommentService {
	
	/**
	 * 添加评论
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ResultEx add(CommentVo vo, SysUser sysUser);
	
	/**
	 * 删除评论(伪删除)
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ResultEx edit(Long id, SysUser sysUser);

	/**
	 * 根据主题ID查询评论树
	 * @param queryVo
	 * @return
	 */	
	public ObjectResultEx<PageInfo<CommentVo>> queryCommentList(CommentQueryVo param, SysUser sysUser);

}
