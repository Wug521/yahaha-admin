package com.example.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.system.entity.SysResource;
import com.zjapl.common.mybaits.dao.Dao;

/**
 * 
 * @author Mr.Wug
 *
 */
@Repository
public interface ISysResourceDao extends Dao<SysResource> {
	
	/**
	 * 获取用户资源树
	 * @param userRole
	 * @return
	 */
	public List<SysResource> selectTreeList(@Param("userId") Long userId, 
			@Param("status") Short status, @Param("orgCode") String orgCode);
	
	public List<SysResource> selectList(@Param("id") Long id, 
			@Param("status") Short status, @Param("orgCode") String orgCode);

}
