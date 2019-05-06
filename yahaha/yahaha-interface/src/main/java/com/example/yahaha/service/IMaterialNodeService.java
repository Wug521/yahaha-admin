package com.example.yahaha.service;

import com.example.system.entity.SysUser;
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
	public ResultEx add(MaterialNodeQueryVo queryVo, SysUser sysUser);
	
	/**
	 * 修改素材节点
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ResultEx update(MaterialNodeQueryVo queryVo, SysUser sysUser);
	
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

}
