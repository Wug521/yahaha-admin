package com.example.system.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.system.entity.SysRole;
import com.example.system.vo.SysRoleVo;
import com.zjapl.common.mybaits.dao.Dao;

/**
 * 
 * 文件名：ISysOrgDao.java
 * 日　期：2017年1月13日 上午10:02:06
 * 版　权：ZJAPL
 * 作　者：liss
 * 类说明：
 */
@Repository
public interface ISysRoleDao extends Dao<SysRole> {
	
	/**
	 * 用户角色配置查询
	 * @param record
	 * @return
	 */
	public List<SysRoleVo> selectListByUser(SysRoleVo record);

}
