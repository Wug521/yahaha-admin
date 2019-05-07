package com.example.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.system.entity.SysUser;
import com.zjapl.common.mybaits.dao.Dao;

/**
 * 
 * @author Mr.Wug
 *
 */
@Repository
public interface ISysUserDao extends Dao<SysUser> {
	/**
	 * 根据登录名查询系统用户
	 * @param loginName
	 * @return
	 */
	public List<SysUser> getUserByOrgCode(@Param("record") SysUser record);
}
