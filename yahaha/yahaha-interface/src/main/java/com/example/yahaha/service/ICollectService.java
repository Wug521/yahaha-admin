package com.example.yahaha.service;

import com.example.system.entity.SysUser;
import com.example.yahaha.entity.vo.CollectQueryVo;
import com.example.yahaha.entity.vo.CollectVo;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;

public interface ICollectService {
	
	/**
	 * 添加游戏
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ResultEx add(CollectVo vo, SysUser sysUser);
	
	/**
	 * 删除游戏(伪删除)
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ResultEx edit(String ids, SysUser sysUser);
	
	/**
	 * 分页查询游戏List
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ObjectResultEx<PageInfo<CollectVo>> queryCollectList(CollectQueryVo queryVo,SysUser sysUser);

}
