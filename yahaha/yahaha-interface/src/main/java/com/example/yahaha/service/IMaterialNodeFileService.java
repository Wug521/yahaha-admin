package com.example.yahaha.service;

import com.example.system.entity.SysUser;
import com.example.yahaha.entity.vo.MaterialNodeFileQueryVo;
import com.example.yahaha.entity.vo.MaterialNodeFileVo;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;

public interface IMaterialNodeFileService {
	
	/**
	 * 添加素材节点
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ResultEx add(MaterialNodeFileVo queryVo, SysUser sysUser);
	
	/**
	 * 添加素材节点
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ResultEx update(MaterialNodeFileVo queryVo, SysUser sysUser);
	
	/**
	 * 删除素材节点(伪删除)
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ResultEx edit(String ids, SysUser sysUser);
	
	/**
	 * 分页查询素材节点List
	 * @param queryVo
	 * @param sysUser
	 * @return
	 */
	public ObjectResultEx<PageInfo<MaterialNodeFileVo>> queryMaterialNodeFileList(MaterialNodeFileQueryVo queryVo,SysUser sysUser);

}
