package com.example.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.system.entity.SysUser;
import com.zjapl.common.mybaits.dao.Dao;

/**
 * 
 * 文件名：ISysUserDao.java
 * 日　期：2017年1月13日 上午10:03:01
 * 版　权：ZJAPL
 * 作　者：liss
 * 类说明：
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
