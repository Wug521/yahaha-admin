package com.example.system.edge.service;

import java.util.List;

import com.example.system.entity.SysRole;
import com.example.system.vo.SysRoleQueryVo;
import com.example.system.vo.SysRoleVo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;

public interface IRoleService {
	
	/**
	 * 添加修改角色
	 * @param role
	 * @param sysUser
	 * @return
	 */
	public ResultEx saveOrEdit(SysRoleVo role,Long userId, String orgCode);
	
	/**
	 * 分页查询角色列表
	 * @param vo
	 * @param sysUser
	 * @return
	 */
	public ResultEx queryListByUser(SysRoleQueryVo vo, String orgCode);
	

	/**
	 * 修改角色状态
	 * @param ids
	 * @param status
	 * @param sysUser
	 * @return
	 */
	public ResultEx editStatus(String ids,Short status, Long userId);
	
	
	/**
	 * 查询用户角色列表
	 * @param sysUser
	 * @return
	 */
	public ObjectResultEx<List<SysRole>> queryListByUserId(Long userId);
	
	/**
	 * 角色分配查询
	 * @param userId
	 * @param createUser
	 * @return
	 */
	public ObjectResultEx<List<SysRoleVo>> queryRoleListByUserId(Long userId, String OrgCode);
}
