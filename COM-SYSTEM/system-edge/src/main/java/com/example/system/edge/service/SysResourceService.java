package com.example.system.edge.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.example.system.dao.ISysResourceDao;
import com.example.system.dao.ISysRoleResourceDao;
import com.example.system.dao.ISysUserRoleDao;
import com.example.system.dic.CommonDictionary.EnableOrDisable;
import com.example.system.dic.CommonDictionary.EnableOrDisableCode;
import com.example.system.dic.CommonDictionary.YesOrNo;
import com.example.system.entity.SysResource;
import com.example.system.entity.SysRoleResource;
import com.example.system.entity.SysUser;
import com.example.system.entity.SysUserRole;
import com.example.system.utils.BeanUtils;
import com.example.system.vo.SysResourceVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;
import com.zjapl.common.result.XResult.ErrorCode;
import com.zjapl.common.util.StringUtil;
import com.zjapl.common.util.TreeMenuUtils;
import com.zjapl.common.vo.TreeMenuVo;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
@Service
public class SysResourceService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	ISysUserRoleDao sysUserRoleDao;
	@Resource
	ISysRoleResourceDao sysRoleResourceDao;
	@Resource
	ISysResourceDao sysResourceDao;
	/**
	 * 根据用户id获取资源信息
	 * @param sysUserId
	 * @return
	 */
	public  ObjectResultEx<List<TreeMenuVo>> getResourcesMenuByUserId(Long sysUserId){
		//根据用户查角色
		SysUserRole record = new SysUserRole();
		record.setUserId(sysUserId);
		Example example = new Example(SysUserRole.class);
		example.createCriteria().andEqualTo("userId", sysUserId);
		List<SysUserRole> existSysUserRoles = sysUserRoleDao.selectByExample(example);
		if (existSysUserRoles == null || existSysUserRoles.isEmpty()){
			logger.warn("用户id[{}]尚未配置角色信息", sysUserId);
			return new ObjectResultEx<List<TreeMenuVo>>().makeFailedResult(ErrorCode.NOT_LOGGED_IN);
		}
		Set<Long> ids = new HashSet<>();
		for(SysUserRole tmp : existSysUserRoles){
			ids.add(tmp.getRoleId());
		}
		//根据角色查权限
		Example exampleRoleResource = new Example(SysRoleResource.class);
		exampleRoleResource.createCriteria().andIn("roleId", ids);
		List<SysRoleResource> existSysRoleResources = sysRoleResourceDao.selectByExample(exampleRoleResource);
		if (existSysRoleResources == null || existSysRoleResources.isEmpty()){
			logger.warn("角色id[{}]尚未配置资源信息", JSON.toJSONString(ids));
			return new ObjectResultEx<List<TreeMenuVo>>().makeFailedResult(ErrorCode.NOT_LOGGED_IN);
		}
		ids.clear();
		for(SysRoleResource tmp : existSysRoleResources){
			ids.add(tmp.getResourceId());
		}
		ids = getSysRoleById(ids);
		PageHelper.startPage(1,1000,"P_ID,SORT ASC");
		Example exampleSysResource = new Example(SysResource.class);
		exampleSysResource.createCriteria().andIn("id", ids).andEqualTo("status", 1);
		List<SysResource> sysResources = sysResourceDao.selectByExample(exampleSysResource);
		if (sysResources == null || sysResources.isEmpty()){
			logger.debug("该用户id[{}]可用资源为空", sysUserId);
			return new ObjectResultEx<List<TreeMenuVo>>().makeFailedResult(ErrorCode.NOT_LOGGED_IN);
		}
		
		List<TreeMenuVo> treeMenuVos = new ArrayList<>();
		for(SysResource sysResource : sysResources){
			TreeMenuVo treeMenuVo = new TreeMenuVo();
			treeMenuVo.setId(sysResource.getId());
			treeMenuVo.setpId(sysResource.getpId());
			treeMenuVo.setText(sysResource.getName());
			treeMenuVo.setIconCls(sysResource.getIcon());
			treeMenuVo.setRemark(sysResource.getRemark());
			treeMenuVo.setMenuUrl(sysResource.getValue());
			treeMenuVo.setPermission(sysResource.getPermission());
			treeMenuVo.setSort(sysResource.getSort());
			treeMenuVos.add(treeMenuVo);
		}
		List<TreeMenuVo> treeNodes = TreeMenuUtils.getSortTreeMenuNodes(treeMenuVos);
		return new ObjectResultEx<List<TreeMenuVo>>().makeSuccessResult(treeNodes);
	}
	/**
	 * 根据用户id获取资源信息列表
	 * @param sysUserId
	 * @return
	 */
	public  ObjectResultEx<PageInfo<SysResource>> getResourcesByUserId(Long sysUserId){
		//根据用户查角色
		SysUserRole record = new SysUserRole();
		record.setUserId(sysUserId);
		Example example = new Example(SysUserRole.class);
		example.createCriteria().andEqualTo("userId", sysUserId);
		List<SysUserRole> existSysUserRoles = sysUserRoleDao.selectByExample(example);
		if (existSysUserRoles == null || existSysUserRoles.isEmpty()){
			logger.warn("用户id[{}]尚未配置角色信息", sysUserId);
			return new ObjectResultEx<PageInfo<SysResource>>().makeSuccessResult(new PageInfo<SysResource>());
		}
		Set<Long> ids = new HashSet<>();
		for(SysUserRole tmp : existSysUserRoles){
			ids.add(tmp.getRoleId());
		}
		//根据角色查权限
		Example exampleRoleResource = new Example(SysRoleResource.class);
		exampleRoleResource.createCriteria().andIn("roleId", ids);
		List<SysRoleResource> existSysRoleResources = sysRoleResourceDao.selectByExample(exampleRoleResource);
		if (existSysRoleResources == null || existSysRoleResources.isEmpty()){
			logger.warn("角色id[{}]尚未配置资源信息", JSON.toJSONString(ids));
			return new ObjectResultEx<PageInfo<SysResource>>().makeSuccessResult(new PageInfo<SysResource>());
		}
		ids.clear();
		for(SysRoleResource tmp : existSysRoleResources){
			ids.add(tmp.getResourceId());
		}
		Example exampleSysResource = new Example(SysResource.class);
		exampleSysResource.createCriteria().andIn("id", ids).andEqualTo("status", 1);
		List<SysResource> sysResources = sysResourceDao.selectByExample(exampleSysResource);
		if (sysResources == null || sysResources.isEmpty()){
			logger.debug("该用户id[{}]可用资源为空", sysUserId);
			return new ObjectResultEx<PageInfo<SysResource>>().makeSuccessResult(new PageInfo<SysResource>());
		}
		PageInfo<SysResource> pageInfo = new PageInfo<SysResource>(sysResources);
		return new ObjectResultEx<PageInfo<SysResource>>().makeSuccessResult(pageInfo);
	}


	/**
	 * 根据id获取资源列表 
	 * @param pid
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ObjectResultEx<PageInfo<SysResourceVo>> queryResourceList(SysResource resourceVo){
		Example example = new Example(SysResource.class);
		Criteria cri = example.createCriteria();
		cri.andEqualTo("status", EnableOrDisableCode.ENABLE);
		if(!StringUtil.isEmpty(resourceVo.getId())){
			Set<Long> deptIds = getSysResourceAndSonsById(resourceVo.getId());
			cri.andIn("id", deptIds);
		}
		List<SysResourceVo> resourcelist = new ArrayList<SysResourceVo>();
		PageHelper.startPage(1, 1000, "P_ID,SORT ASC");
		List<SysResource> list = sysResourceDao.selectByExample(example);
		PageInfo pageInfo = new PageInfo<>(list);
		for (SysResource sysResource : list) {
			SysResourceVo sysResourceVo = new  SysResourceVo();
			BeanUtils.copyProperties(sysResource, sysResourceVo);
			if(!StringUtil.isEmpty(sysResource.getLeaf())){
				sysResourceVo.setLeafName(YesOrNo.parseCode(sysResource.getLeaf()).getLocalizedName());
			}
			if(!StringUtil.isEmpty(sysResource.getStatus())){
				sysResourceVo.setStatusName(EnableOrDisable.parseCode(sysResource.getStatus()).getLocalizedName());
			}
			SysResource resource = sysResourceDao.selectByPrimaryKey(sysResource.getpId());
			if(resource != null){
				sysResourceVo.setpIdName(resource.getName());
			}
			resourcelist.add(sysResourceVo);
		}
		pageInfo.setList(resourcelist);
		return new ObjectResultEx<PageInfo<SysResourceVo>>().makeSuccessResult(pageInfo);
	}
	
	/**
	 * 增加或修改资源
	 * @param sysResource
	 * @param sysUser
	 * @return
	 */
	public  ResultEx addOrEditResource(SysResource sysResource,SysUser sysUser){
		if(sysResource == null){
			return null;
		}
		sysResource.setUpdateDate(new Date());
		sysResource.setUpdateUserId(sysUser.getbUserId());
		if(sysResource.getId()==null || StringUtil.isEmpty(sysResource.getId())){
			sysResource.setStatus(EnableOrDisableCode.ENABLE);
			sysResource.setCreateDate(new Date());
			sysResource.setCreateUserId(sysUser.getbUserId());
			sysResourceDao.insertSelective(sysResource);
		}else{
			Example example = new Example(SysResource.class);
			example.createCriteria().andEqualTo("id", sysResource.getId());
			sysResourceDao.updateByExampleSelective(sysResource, example);
		}
		return new ResultEx().makeSuccessResult();
	}

	/**
	 *  修改资源信息
	 * @param sysResource
	 * @param sysUser
	 * @return
	 */
	public ResultEx delResource(SysResourceVo param,SysUser sysUser){
		if(StringUtil.isEmpty(param.getIds())){
			logger.debug("delResource ids is null");
			return new ResultEx().makeInternalErrorResult();
		}
		String[] id = param.getIds().split(",");
		for (int i = 0; i < id.length; i++) {
			SysResource sysResource = new SysResource();
			sysResource.setStatus(param.getStatus());
			sysResource.setUpdateDate(new Date());
			sysResource.setUpdateUserId(sysUser.getbUserId());
			Example example = new Example(SysResource.class);
			example.createCriteria().andEqualTo("id", Long.parseLong(id[i]));
			sysResourceDao.updateByExampleSelective(sysResource, example);
		}
		return new ResultEx().makeSuccessResult();
	}
	/**
	 * 根据部门查询部门全部子节点Id
	 * @param deptIds
	 * @return
	 */
	public Set<Long> getSysResourceAndSonsById(Long... deptIds){
		if (deptIds == null || deptIds.length <= 0){
			return null;
		}
		Example example = new Example(SysResource.class);
		Set<Long> ids = new HashSet<>();
		ids.remove(null);
		ids.addAll(Arrays.asList(deptIds));
		int idSize = ids.size();
		example = new Example(SysResource.class);
		example.createCriteria().andIn("pId", ids);
		List<SysResource> sysResources = sysResourceDao.selectByExample(example);
		if (sysResources != null && sysResources.size() > 0){
			for(SysResource sysResource : sysResources){
				ids.add(sysResource.getId());
			}
		}
		ids.remove(null);
		if (ids.size() > idSize){
			ids.addAll(getSysResourceAndSonsById(ids.toArray(new Long[ids.size()])));
		}
		return ids;
	}
	
	/**
	 * 根据角色查找资源list列表
	 */
	public ObjectResultEx<PageInfo<SysResource>> queryResourceListByRoleId(Long roleId){
		if(StringUtil.isEmpty(roleId)){
			logger.debug("queryResourceListByRoleId roleId is null");
			return new ObjectResultEx<PageInfo<SysResource>>().makeInvalidParameterResult(); 
		}
		PageHelper.startPage(1, 1000,"id asc");
		Example example = new Example(SysRoleResource.class);
		example.createCriteria().andEqualTo("roleId",roleId);
		List<SysRoleResource> list = sysRoleResourceDao.selectByExample(example);
		//资源列表
		List<SysResource> resources = new ArrayList<SysResource>();
		for (SysRoleResource sysRoleResource : list) {
			SysResource resource = sysResourceDao.selectByPrimaryKey(sysRoleResource.getResourceId());
			resources.add(resource);
		}
		PageInfo<SysResource> pageInfo = new PageInfo<SysResource>(resources);
		return new ObjectResultEx<PageInfo<SysResource>>().makeSuccessResult(pageInfo);
	}
	
	/**
	 * 根据id获取包括父id在内id集合
	 * @param deptIds
	 * @return
	 */
	public Set<Long> getSysRoleById(Set<Long> roleIds){
		if (roleIds == null || roleIds.isEmpty()){
			return null;
		}
		logger.debug("getSysRoleById[{}]", roleIds);
		Example example = new Example(SysResource.class);
		Set<Long> ids = new HashSet<>();
		ids.addAll(roleIds);
		ids.remove(null);
		int idsSize = ids.size();
		example = new Example(SysResource.class);
		example.createCriteria().andIn("id", ids);
		List<SysResource> sysResourceList = sysResourceDao.selectByExample(example);
		for(SysResource sysResource : sysResourceList){
			ids.add(sysResource.getId());
			ids.add(sysResource.getpId());
		}
		ids.remove(null);
		if (ids.size() == idsSize){
			return ids;
		} else {
			return getSysRoleById(ids);
		}
	}
	
	/**
	 * 获取资源菜单左侧树
	 * @return
	 */
	public  ObjectResultEx<List<TreeMenuVo>> getLeftResources(){
		PageHelper.startPage(1,1000,"P_ID,SORT ASC");
		Example exampleSysResource = new Example(SysResource.class);
		exampleSysResource.createCriteria().andEqualTo("status", EnableOrDisableCode.ENABLE);
		List<SysResource> sysResources = sysResourceDao.selectByExample(exampleSysResource);
		if (sysResources == null || sysResources.isEmpty()){
			return new ObjectResultEx<List<TreeMenuVo>>().makeFailedResult(ErrorCode.NOT_LOGGED_IN);
		}
		List<TreeMenuVo> treeMenuVos = new ArrayList<>();
		for(SysResource sysResource : sysResources){
			TreeMenuVo treeMenuVo = new TreeMenuVo();
			treeMenuVo.setId(sysResource.getId());
			treeMenuVo.setpId(sysResource.getpId());
			treeMenuVo.setText(sysResource.getName());
			treeMenuVo.setIconCls(sysResource.getIcon());
			treeMenuVo.setRemark(sysResource.getRemark());
			treeMenuVo.setMenuUrl(sysResource.getValue());
			treeMenuVo.setPermission(sysResource.getPermission());
			treeMenuVo.setSort(sysResource.getSort());
			treeMenuVos.add(treeMenuVo);
		}
		List<TreeMenuVo> treeNodes = TreeMenuUtils.getSortTreeMenuNodes(treeMenuVos);
		return new ObjectResultEx<List<TreeMenuVo>>().makeSuccessResult(treeNodes);
	}
}
