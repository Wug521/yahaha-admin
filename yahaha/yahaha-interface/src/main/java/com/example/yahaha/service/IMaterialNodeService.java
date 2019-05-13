package com.example.yahaha.service;

import java.util.List;

import com.example.system.entity.SysUser;
import com.example.system.vo.MenuVo;
import com.example.yahaha.entity.vo.MaterialNodeQueryVo;
import com.example.yahaha.entity.vo.MaterialNodeVo;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;

public interface IMaterialNodeService {
	
	/**
	 * 添加素材节点
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ResultEx add(MaterialNodeVo queryVo, SysUser sysUser);
	
	/**
	 * 修改素材节点
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ResultEx update(MaterialNodeVo queryVo, SysUser sysUser);
	
	/**
	 * 删除素材节点(伪删除)
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ResultEx edit(Long id, SysUser sysUser);
	
	/**
	 * 分页查询素材节点List
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ObjectResultEx<PageInfo<MaterialNodeVo>> queryMaterialNodeList(MaterialNodeQueryVo queryVo,SysUser sysUser);
	
	/**
	 * 获取素材节点列表树
	 * @param sysUser
	 * @param roleType
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public ObjectResultEx<List<MenuVo>> getNodeTree(String orgCode);

}
