package com.example.system.edge.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.system.dao.ISysResourceDao;
import com.example.system.dao.ISysRoleDao;
import com.example.system.dao.ISysRoleResourceDao;
import com.example.system.dao.ISysUserRoleDao;
import com.example.system.dic.CommonDictionary.EnableOrDisable;
import com.example.system.dic.CommonDictionary.EnableOrDisableCode;
import com.example.system.edge.service.IRoleService;
import com.example.system.entity.SysRole;
import com.example.system.entity.SysRoleResource;
import com.example.system.entity.SysUserRole;
import com.example.system.utils.BeanUtils;
import com.example.system.utils.CommonUtil;
import com.example.system.vo.SysResourceVo;
import com.example.system.vo.SysRoleQueryVo;
import com.example.system.vo.SysRoleVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;
import com.zjapl.common.result.XResult.ErrorCode;
import com.zjapl.common.util.JSONUtil;
import com.zjapl.common.util.StringUtil;

import tk.mybatis.mapper.entity.Example;

@Service
public class RoleServiceImpl implements IRoleService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ISysRoleDao roleDao;
	
	@Autowired
	ISysUserRoleDao userRoleDao;
	
	@Autowired
	ISysResourceDao resourceDao;
	
	@Autowired
	ISysRoleResourceDao roleResourceDao;

	/**
	 * 添加修改角色
	 * @param role
	 * @param sysUser
	 * @return
	 */
	@Override
	public ResultEx saveOrEdit(SysRoleVo role, Long userId, String orgCode) {
		ResultEx result = new ResultEx();
		if(role == null || userId == null || StringUtil.isEmpty(role.getName())){
			return result.makeFailedResult(ErrorCode.BAD_PARAMETER);
		}
		List<SysResourceVo> resourceList = JSONUtil.json2List(role.getResourceJson(), SysResourceVo.class);
		role.setUpdateDate(new Date());
		/*
		 * 添加修改角色
		 */
		if(role.getId() == null){
			if(resourceList == null){
				return result.makeFailedResult(ErrorCode.BAD_PARAMETER);
			}
			role.setStatus(EnableOrDisableCode.ENABLE);
			role.setCreateDate(role.getUpdateDate());
			role.setCreateUser(userId);
			role.setOrgCode(orgCode);
			roleDao.insertSelective(role);
		}else{
			roleDao.updateByPrimaryKeySelective(role);
		}
		/*
		 * 配置角色资源
		 */
		if(resourceList != null){
			setResourceForRole(role, resourceList);
		}
		return result.makeSuccessResult();
	}

	/**
	 * 配置角色资源、权限
	 * @param Role
	 * @param resourceList
	 */
	public void setResourceForRole(SysRoleVo Role, List<SysResourceVo> resourceList) {
		SysRoleResource record = new SysRoleResource();
		record.setRoleId(Role.getId());
		roleResourceDao.delete(record);
		for(SysResourceVo resource : resourceList){
			SysRoleResource roleResource = new SysRoleResource();
			roleResource.setRoleId(Role.getId());
			roleResource.setOrgCode(Role.getOrgCode());
			roleResource.setResourceId(resource.getId());
			roleResource.setCreateDate(new Date());
			roleResource.setUpdateDate(new Date());
			roleResourceDao.insertSelective(roleResource);
		}
	}

	/**
	 * 分页查询角色列表
	 * @param vo
	 * @param sysUser
	 * @return
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResultEx queryListByUser(SysRoleQueryVo vo, String orgCode) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		SysRole sysRole = new SysRole();
		BeanUtils.copyProperties(vo, sysRole);
		if(!StringUtil.isEmpty(orgCode)){
			sysRole.setOrgCode(orgCode);
		}
		sysRole.setStatus(EnableOrDisableCode.ENABLE);
		List<SysRole> sysRoleList = roleDao.select(sysRole);
		PageInfo pageInfo = new PageInfo(sysRoleList);
		List<SysRoleVo> sysRoleListVo = new ArrayList<SysRoleVo>();
		for(SysRole role : sysRoleList){
			SysRoleVo roleVo = new SysRoleVo();
			BeanUtils.copyProperties(role, roleVo);
			//有效标记
			if(role.getStatus()!=null){
				roleVo.setStatusName(EnableOrDisable.parseCode(role.getStatus()).getLocalizedName());
			}
			sysRoleListVo.add(roleVo);
		}
		pageInfo.setList(sysRoleListVo);
		return new ObjectResultEx<PageInfo<SysRoleVo>>().makeSuccessResult(pageInfo);
	}

	/**
	 * 修改角色状态
	 * @param ids
	 * @param status
	 * @param sysUser
	 * @return
	 */
	@Override
	public ResultEx editStatus(String ids, Short status, Long userId) {
		ResultEx result = new ResultEx();
		if (StringUtil.isEmpty(ids) || status == null || userId == null) {
			logger.error("RoleService.editStatus error, ids or status is empty");
			return result.makeFailedResult(ErrorCode.BAD_PARAMETER);
		}
		List<Long> idList = CommonUtil.idsToList(ids);
		Example ex = new Example(SysRole.class);
		ex.createCriteria().andIn("id", idList);
		SysRole role = new SysRole();
		role.setStatus(status);
		role.setUpdateUser(userId);
		role.setUpdateDate(new Date());
		roleDao.updateByExampleSelective(role, ex);
		return result.makeSuccessResult();
	}

	/**
	 * 查询用户角色列表
	 * @param sysUser
	 * @return
	 */
	@Override
	public ObjectResultEx<List<SysRole>> queryListByUserId(Long userId) {
		//根据用户查角色
		SysUserRole record = new SysUserRole();
		record.setUserId(userId);
		Example example = new Example(SysUserRole.class);
		example.createCriteria().andEqualTo("userId", userId);
		List<SysUserRole> existSysUserRoles = userRoleDao.selectByExample(example);
		if (existSysUserRoles == null || existSysUserRoles.isEmpty()){
			logger.warn("用户id[{}]尚未配置角色信息", userId);
			return new ObjectResultEx<List<SysRole>>().makeSuccessResult(new ArrayList<SysRole>());
		}
		Set<Long> ids = new HashSet<>();
		for(SysUserRole tmp : existSysUserRoles){
			ids.add(tmp.getRoleId());
		}
		Example exampleSysRole = new Example(SysRole.class);
		exampleSysRole.createCriteria().andIn("id", ids);
		List<SysRole> result = roleDao.selectByExample(exampleSysRole);
		return new ObjectResultEx<List<SysRole>>().makeSuccessResult(result);
	}

	/**
	 * 用户角色配置查询
	 */
	@Override
	public ObjectResultEx<List<SysRoleVo>> queryRoleListByUserId(Long userId, String OrgCode) {
		ObjectResultEx<List<SysRoleVo>> resultEx = new ObjectResultEx<List<SysRoleVo>>();
		if(userId == null){
			return resultEx.makeFailedResult(ErrorCode.BAD_PARAMETER);
		}
		SysRoleVo record = new SysRoleVo();
		record.setUserId(userId);
		record.setOrgCode(OrgCode);
		record.setStatus(EnableOrDisableCode.DELETED);
		List<SysRoleVo> list = roleDao.selectListByUser(record);
		return resultEx.makeSuccessResult(list);
	}

}
