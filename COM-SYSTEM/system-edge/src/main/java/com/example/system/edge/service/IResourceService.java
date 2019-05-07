package com.example.system.edge.service;

import java.util.List;

import com.example.system.entity.SysResource;
import com.example.system.vo.MenuVo;
import com.example.system.vo.SysResourceQueryVo;
import com.example.system.vo.SysResourceVo;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;

public interface IResourceService {
	
	/**
	 * 添加或修改资源信息
	 * @param resource
	 * @param sysUser
	 * @return
	 */
	public ResultEx saveOrEdit(SysResource resource, Long userId);
	
	/**
	 * 获取用户资源列表树
	 * @param sysUser
	 * @param roleType
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public ObjectResultEx<List<MenuVo>> queryTreeByUser(Long userId, String orgCode);
	
	/**
	 * 获取父资源列表 -- 分页
	 * @param page
	 * @param sysUser
	 * @return
	 */
	public ResultEx queryRootResourceList(SysResourceQueryVo page);
	
	/**
	 * 修改资源状态
	 * @param ids
	 * @param status
	 * @param sysUser
	 * @return
	 */
	public ResultEx editStatus(String ids,Short status,Long userId);
	
	/**
	 * 获取所有资源树
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public ObjectResultEx<List<MenuVo>> queryAllTree();
	
	/**
	 * 获取父级资源树
	 * @param sysUser
	 * @param roleType
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public ObjectResultEx<List<MenuVo>> queryRootTree();
	
	/**
	 * 查询资源List
	 * @param id
	 * @return
	 */
	public ObjectResultEx<PageInfo<SysResourceVo>> queryResourceListForId(SysResourceQueryVo page);
	
}
