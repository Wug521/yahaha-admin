package com.example.system.edge.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.alibaba.fastjson.JSON;
import com.example.system.dao.ISysDeptDao;
import com.example.system.dao.ISysRoleDao;
import com.example.system.dao.ISysUserDao;
import com.example.system.dao.ISysUserRoleDao;
import com.example.system.dic.CommonDictionary.EnableOrDisable;
import com.example.system.entity.SysDept;
import com.example.system.entity.SysRole;
import com.example.system.entity.SysUser;
import com.example.system.entity.SysUserRole;
import com.example.system.utils.BeanUtils;
import com.example.system.vo.SysRoleVo;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;

/**
 * 文件名：SysUserRoleService.java
 * 日　期：2017年1月17日
 * 版　权：ZJAPL
 * 作　者：wug
 * 类说明：
 */
@Service
public class SysUserRoleService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private ISysUserRoleDao sysUserRoleDao;
	@Resource
	private ISysRoleDao sysRoleDao;
	@Resource
	private ISysUserDao sysUserDao;
	@Resource
	private ISysDeptDao sysDeptDao;

	/**
	 * 给用户配置角色
	 * @param sysUser 当前操作人员
	 * @param userId  被操作用户ID
	 * @param roleId  角色ID
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ResultEx addSysUserRoleDao(String param, SysUser sysUser){
		if(!checkparam(param)){
			return new ResultEx().makeInvalidParameterResult();
		}
		
		Map<String,Object> roles = JSON.parseObject(param, Map.class);
//		if(roles==null){
//			return new ResultEx().makeInvalidParameterResult();
//		}
		Integer userId=(Integer) roles.get("userId");
		List<Integer> roleIds=(List<Integer>) roles.get("roleIds");
//		if(userId==null || roleIds==null || roleIds.size()==0){
//			return new ResultEx().makeInvalidParameterResult();
//		}
		SysUserRole record=new SysUserRole();
		record.setUserId(userId.longValue());
		sysUserRoleDao.delete(record);
		for(Integer roleId:roleIds){		
			SysUserRole sysUserRole = new SysUserRole();
			sysUserRole.setRoleId(roleId.longValue());
		    sysUserRole.setUserId(userId.longValue());
			sysUserRole.setCreateDate(new Date());
			sysUserRole.setUpdateDate(new Date());
			sysUserRole.setCreateUserId(sysUser.getId());
			sysUserRole.setUpdateUserId(sysUser.getId());
			try{
				sysUserRoleDao.insertSelective(sysUserRole);
			}catch(Exception e){
				logger.error("addSysUserRoleDao error.", e);
				throw e;
			}
		}
		return new ResultEx().makeSuccessResult();
	}
	/**
	 * 给用户配置角色
	 * @param sysUser 当前操作人员
	 * @param userId  被操作用户ID
	 * @param roleId  角色ID
	 * @return
	 */
	public ResultEx queryRoleUser(Long userId){
		if(userId==null){
			return new ResultEx().makeInvalidParameterResult();
		}
		SysUserRole sysUserRole = new SysUserRole();
		sysUserRole.setUserId(userId);
		List<SysUserRole> roleList=sysUserRoleDao.select(sysUserRole);
		ResultEx ex=new ResultEx();
		ex.setData(roleList);
		return ex;
	}
	/**
	 * 根据用户ID查询其拥有角色
	 * @param sysUser 当前操作人员
	 * @param userId  被操作用户ID
	 * @param roleId  角色ID
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ObjectResultEx<PageInfo<SysRoleVo>> queryRolesByUserId(Long userId){
		if(userId==null){
			return new ObjectResultEx<PageInfo<SysRoleVo>>().makeInvalidParameterResult();
		}
		SysUserRole sysUserRole = new SysUserRole();
		sysUserRole.setUserId(userId);
		List<SysUserRole> sysUserRoleList=sysUserRoleDao.select(sysUserRole);
		if (sysUserRoleList == null || sysUserRoleList.isEmpty()){
			return new ObjectResultEx<PageInfo<SysRoleVo>>().makeNotExistResult();
		}
		Set<Long> roleIds = new HashSet<Long>();
		for(SysUserRole tmp : sysUserRoleList){
			roleIds.add(tmp.getRoleId());
		}
		roleIds.remove(null);
		ResultEx ex=new ResultEx();
		ex.setData(sysUserRoleList);
		Example example = new Example(SysRole.class);
		example.createCriteria().andIn("id", roleIds);
		List<SysRole> sysRoles = sysRoleDao.selectByExample(example);
		PageInfo pageInfo = new PageInfo<>(sysRoles);
		List<SysRoleVo> sysRoleListVo = new ArrayList<SysRoleVo>();
		for(SysRole role:sysRoles){
			SysRoleVo roleVo = new SysRoleVo();
			BeanUtils.copyProperties(role, roleVo);
			//操作人
			if(role.getUpdateUserId()!=null){
				SysUser sysUser = sysUserDao.selectByPrimaryKey(role.getUpdateUserId());
				if(sysUser!=null){
					roleVo.setUserName(sysUser.getUsername());
				}
			}
			//有效标记
			if(role.getStatus()!=null){
				roleVo.setStatusName(EnableOrDisable.parseCode(role.getStatus()).getLocalizedName());
			}
			//所属部门
			if(role.getOrgCode()!=null){
				SysDept dept=sysDeptDao.selectByPrimaryKey(Long.valueOf(role.getOrgCode()));
				if(dept!=null){
					roleVo.setOrgCode(dept.getDeptName());
				}
			}
			sysRoleListVo.add(roleVo);
		}
		pageInfo.setList(sysRoleListVo);
		return new ObjectResultEx<PageInfo<SysRoleVo>>().makeSuccessResult(pageInfo);
	}
	
	public boolean checkparam(String param){
		if(param==null){
			return false;
		}/*else{
			//{userId:1,roleIds:[1,2,4]}}
			//"\\[(\\{\"userId\":[0-9]{1,},\"manType\":[0-9]{1,}\\})(,{1}\\{\"userId\":[0-9]{1,},\"manType\":[0-9]{1,}\\})*\\]"
			 String regEx = "\\{\"userId\":[0-9]{1,},\"roleIds\":\\[([0-9]{1,}){1,}\\]\\}";
		     Pattern pattern = Pattern.compile(regEx);
		     Matcher matcher = pattern.matcher(param);
		     if(!matcher.matches()){
		    	 logger.error("param  is error.");
				 return false; 
		     }
		}*/
		return true;
	}
}
