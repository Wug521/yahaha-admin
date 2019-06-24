package com.example.yahaha.service;

import com.example.system.entity.SysUser;
import com.example.yahaha.entity.vo.LikesVo;
import com.zjapl.common.result.ResultEx;

public interface ILikesService {
	
	/**
	 * 添加游戏
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ResultEx add(LikesVo vo, SysUser sysUser);

}
