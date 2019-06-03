package com.example.yahaha.service;

import com.example.system.entity.SysUser;
import com.example.yahaha.entity.vo.GameQueryVo;
import com.example.yahaha.entity.vo.GameVo;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;

public interface IGameService {
	
	/**
	 * 添加游戏
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ResultEx add(GameVo vo, SysUser sysUser);
	
	/**
	 * 修改游戏
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ResultEx update(GameVo vo, SysUser sysUser);
	
	/**
	 * 删除游戏(伪删除)
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ResultEx edit(Long id, SysUser sysUser);
	
	/**
	 * 分页查询游戏List
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ObjectResultEx<PageInfo<GameVo>> queryGameList(GameQueryVo queryVo,SysUser sysUser);

	/**
	 * 小程序分页查询游戏List
	 * @param queryVo
	 * @return
	 */	
	public ObjectResultEx<PageInfo<GameVo>> queryGameListFromApplet(GameQueryVo query);

}
