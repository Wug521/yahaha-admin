package com.example.system.edge.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.example.system.dao.ISysResourceDao;
import com.example.system.dao.ISysRoleResourceDao;
import com.example.system.entity.SysResource;
import com.example.system.entity.SysRoleResource;
import com.example.system.entity.SysUser;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;
import com.zjapl.common.util.StringUtil;
import com.zjapl.common.util.TreeMenuUtils;
import com.zjapl.common.vo.TreeMenuVo;

/**
 * 文件名：SysRoleResourceService.java
 * 日　期：2017年1月17日
 * 版　权：ZJAPL
 * 作　者：wug
 * 类说明：
 */
@Service
public class SysRoleResourceService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private ISysRoleResourceDao sysRoleResourceDao;
	@Resource
	private ISysResourceDao sysResourceDao;
	/**
	 * 给角色配置资源权限
	 * @param roleId		角色ID
	 * @param resourceId	资源ID
	 * @param sysUser		当前操作人员ID
	 * @return
	 */
	public ResultEx addRoleResource(Long roleId,String resourceIds,SysUser sysUser){
		if(StringUtil.isEmpty(resourceIds) && StringUtil.isEmpty(roleId)){
			return new ResultEx().makeInvalidParameterResult();
		}
		Example exmple = new Example(SysRoleResource.class);
		exmple.createCriteria().andEqualTo("roleId", roleId);
		//角色配置权限之前，先干掉角色之前的权限
		sysRoleResourceDao.deleteByExample(exmple);
		String[] resourceId = resourceIds.split(",");
		for(int i=0;i<resourceId.length;i++){
			SysRoleResource sysRoleResource = new SysRoleResource();
			sysRoleResource.setResourceId(Long.valueOf(resourceId[i]));
			sysRoleResource.setRoleId(roleId);
			sysRoleResource.setCreateDate(new Date());
			sysRoleResource.setUpdateDate(new Date());
			sysRoleResource.setCreateUserId(sysUser.getbUserId());
			sysRoleResource.setUpdateUserId(sysUser.getbUserId());
			try{
				sysRoleResourceDao.insertSelective(sysRoleResource);
			}catch(Exception e){
				logger.error("addRoleResource error.", e);
				throw e;
			}
		}
		return new ResultEx().makeSuccessResult();
	}
	
	/**
	 * 根据角色id获取资源信息
	 * @param sysUserId
	 * @return
	 */
	public ObjectResultEx<PageInfo<TreeMenuVo>>  getAllResourcesAndCheckedMenuByRoleId(Long roleId){
		if (StringUtil.isEmpty(roleId)){
			return new ObjectResultEx<PageInfo<TreeMenuVo>>().makeInvalidParameterResult();
		}
		Set<Long> ids = new HashSet<>();
		//根据角色查权限
		Example exampleRoleResource = new Example(SysRoleResource.class);
		exampleRoleResource.createCriteria().andEqualTo("roleId", roleId);
		List<SysRoleResource> existSysRoleResources = sysRoleResourceDao.selectByExample(exampleRoleResource);
		if (existSysRoleResources == null || existSysRoleResources.isEmpty()){
			logger.warn("角色id[{}]尚未配置资源信息", roleId);
		} else {
			for(SysRoleResource tmp : existSysRoleResources){
				ids.add(tmp.getResourceId());
			}
		}
		Example exampleSysResource = new Example(SysResource.class);
		exampleSysResource.createCriteria().andEqualTo("status", 1);
		List<SysResource> sysResources = sysResourceDao.selectByExample(exampleSysResource);
		if (sysResources == null || sysResources.isEmpty()){
			logger.debug("该角色id[{}]可用资源为空", roleId);
			return new ObjectResultEx<PageInfo<TreeMenuVo>>().makeNotExistResult();
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
			treeMenuVo.setSort(sysResource.getSort());
			treeMenuVo.setPermission(sysResource.getPermission());
			if (ids.contains(treeMenuVo.getId())){
				treeMenuVo.setChecked(true);
			} else {
				treeMenuVo.setChecked(false);
			}
			treeMenuVos.add(treeMenuVo);
		}
		List<TreeMenuVo> treeNodes = TreeMenuUtils.getSortTreeMenuNodes(treeMenuVos);
		PageInfo<TreeMenuVo> pageInfo = new PageInfo<TreeMenuVo>(treeNodes);
		return new ObjectResultEx<PageInfo<TreeMenuVo>>().makeSuccessResult(pageInfo);
	}
	
}
