package com.example.system.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.system.entity.SysRole;
import com.example.system.vo.SysRoleVo;
import com.zjapl.common.mybaits.dao.Dao;

/**
 * 
 * @author Mr.Wug
 *
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
