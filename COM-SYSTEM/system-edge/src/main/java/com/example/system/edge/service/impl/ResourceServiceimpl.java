package com.example.system.edge.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.system.dao.ISysResourceDao;
import com.example.system.dao.ISysRoleResourceDao;
import com.example.system.dao.ISysUserRoleDao;
import com.example.system.dic.CommonDictionary.EnableOrDisable;
import com.example.system.dic.CommonDictionary.EnableOrDisableCode;
import com.example.system.edge.service.IResourceService;
import com.example.system.entity.SysResource;
import com.example.system.entity.SysRoleResource;
import com.example.system.utils.BeanUtils;
import com.example.system.utils.CommonUtil;
import com.example.system.utils.TreeMenuUtils;
import com.example.system.vo.MenuVo;
import com.example.system.vo.SysResourceQueryVo;
import com.example.system.vo.SysResourceVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;
import com.zjapl.common.result.XResult.ErrorCode;
import com.zjapl.common.util.StringUtil;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class ResourceServiceimpl implements IResourceService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ISysUserRoleDao userRoleDao;
	
	@Autowired
	ISysRoleResourceDao roleResourceDao;
	
	@Autowired
	ISysResourceDao resourceDao;

	@Override
	public ResultEx saveOrEdit(SysResource resource, Long userId) {
		if (resource == null || userId == null) {
			logger.error("ResourceService.saveOrEdit error, resource or userId is null");
			return new ResultEx().makeFailedResult(ErrorCode.BAD_PARAMETER);
		}
		resource.setUpdateDate(new Date());
		resource.setUpdateUser(userId);
		if (resource.getId() == null) {
			if (resource.getPid() == null) {
				resource.setPid(0L);
			}
			resource.setStatus(EnableOrDisableCode.ENABLE);
			resource.setCreateDate(resource.getUpdateDate());
			resource.setCreateUser(userId);
			resourceDao.insertSelective(resource);
		} else {
			resourceDao.updateByPrimaryKeySelective(resource);
		}
		return new ResultEx().makeSuccessResult();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ObjectResultEx<List<MenuVo>> queryTreeByUser(Long userId, String orgCode) {
		if (StringUtil.isEmpty(userId)) {
			logger.error("ResourceService.queryTreeByUser error, userId is null");
			return new ObjectResultEx<List<MenuVo>>().makeFailedResult(ErrorCode.BAD_PARAMETER);
		}
		List<SysResource> rosourceList = null;
		rosourceList = resourceDao.selectTreeList(userId,EnableOrDisableCode.ENABLE,orgCode);
		List<MenuVo> menuVo = sortResource(rosourceList, true);
		return new ObjectResultEx<List<MenuVo>>().makeSuccessResult(menuVo);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ResultEx queryRootResourceList(SysResourceQueryVo page) {
		ObjectResultEx<PageInfo<SysResourceVo>> resultEx = new ObjectResultEx<PageInfo<SysResourceVo>>();
		List<SysResourceVo> voList = new ArrayList<SysResourceVo>();
		if (page.getId() == null) {
			page.setId(0L);
		}
		Example ex = new Example(SysResource.class);
		ex.createCriteria().andEqualTo("pid", page.getId())
						   .andNotEqualTo("status", EnableOrDisableCode.DELETED);
		PageHelper.startPage(page.getPageNum(), page.getPageSize(),"SORT ASC");
		List<SysResource> list = resourceDao.selectByExample(ex);
		PageInfo pageInfo = new PageInfo(list);
		for (SysResource resource : list) {
			SysResourceVo resourceVo = new SysResourceVo();
			BeanUtils.copyProperties(resource, resourceVo);
			voList.add(resourceVo);
		}
		pageInfo.setList(voList);
		return resultEx.makeSuccessResult(pageInfo);
	}

	@Override
	public ResultEx editStatus(String ids, Short status, Long userId) {
		ResultEx result = new ResultEx();
		if (StringUtil.isEmpty(ids) || status == null || userId == null) {
			logger.error("ResourceService.editStatus error, ids or status is empty");
			return result.makeFailedResult(ErrorCode.BAD_PARAMETER);
		}
		List<Long> idList = CommonUtil.idsToList(ids);
		Example ex = new Example(SysResource.class);
		ex.createCriteria().andIn("id", idList);
		SysResource resource = new SysResource();
		resource.setStatus(status);
		resource.setUpdateUser(userId);
		resource.setUpdateDate(new Date());
		resourceDao.updateByExampleSelective(resource, ex);
		return result.makeSuccessResult();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ObjectResultEx<List<MenuVo>> queryAllTree() {
		Example ex = new Example(SysResource.class);
		ex.createCriteria().andNotEqualTo("status", EnableOrDisableCode.DELETED);
		List<SysResource> rosourceList = resourceDao.selectByExample(ex);
		List<MenuVo> list = sortResource(rosourceList, true);
		return new ObjectResultEx<List<MenuVo>>().makeSuccessResult(list);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ObjectResultEx<List<MenuVo>> queryRootTree() {
		Example ex = new Example(SysResource.class);
		ex.createCriteria().andNotEqualTo("status", EnableOrDisableCode.DELETED).andEqualTo("pid", 0);
		List<SysResource> rosourceList = resourceDao.selectByExample(ex);
		List<MenuVo> list = sortResource(rosourceList, true);
		return new ObjectResultEx<List<MenuVo>>().makeSuccessResult(list);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ObjectResultEx<PageInfo<SysResourceVo>> queryResourceListForId(SysResourceQueryVo page) {
		Example example = new Example(SysResource.class);
		Criteria cri = example.createCriteria();
		cri.andNotEqualTo("status", EnableOrDisableCode.DELETED);
		if(!StringUtil.isEmpty(page.getId())){
			Set<Long> resourceIds = getSysResourceAndSonsById(page.getId());
			cri.andIn("id", resourceIds);
		}
		List<SysResourceVo> resourcelist = new ArrayList<SysResourceVo>();
		PageHelper.startPage(page.getPageNum(), page.getPageSize(),"SORT ASC");
		List<SysResource> list = resourceDao.selectByExample(example);
		PageInfo pageInfo = new PageInfo(list);
		for (SysResource sysResource : list) {
			SysResourceVo sysResourceVo = new  SysResourceVo();
			BeanUtils.copyProperties(sysResource, sysResourceVo);
			SysResource resource = resourceDao.selectByPrimaryKey(sysResource.getPid());
			if(resource != null){
				sysResourceVo.setPidName(resource.getName());
			}
			sysResourceVo.setStatusName(sysResourceVo.getStatus() ==null ? "" : EnableOrDisable.parseCode(sysResourceVo.getStatus()).getLocalizedName());
			resourcelist.add(sysResourceVo);
		}
		pageInfo.setList(resourcelist);
		return new ObjectResultEx<PageInfo<SysResourceVo>>().makeSuccessResult(pageInfo);
	}
	
	/**
	 * 将给定数据组成树形结构  (菜单)
	 * @param rosourceList
	 * @param flag
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<MenuVo> sortResource(List<SysResource> rosourceList, boolean flag) {
		List<MenuVo> treeMenuVos = new ArrayList<>();
		for (SysResource sysResource : rosourceList) {
			MenuVo menu = new MenuVo();
			menu.setId(sysResource.getId());
			menu.setpId(sysResource.getPid());
			menu.setText(sysResource.getName());
			menu.setIcon(sysResource.getIcon());
			menu.setRemark(sysResource.getRemark());
			menu.setLink(sysResource.getValue());
			menu.setSort(sysResource.getSort().shortValue());
			treeMenuVos.add(menu);
		}
		List<MenuVo> treeNodes = TreeMenuUtils.getSortTreeMenuNodes(treeMenuVos);
		if (flag) {
			MenuVo vo = new MenuVo();
			vo.setText("");
			vo.setId(0L);
			vo.setChildren(treeNodes);
			List<MenuVo> voList = new ArrayList<>();
			voList.add(vo);
			return voList;
		}
		return treeNodes;
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
		example.createCriteria().andIn("pid", ids);
		List<SysResource> sysResources = resourceDao.selectByExample(example);
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

	@Override
	public ResultEx queryResourceByRoleId(Long roleId) {
		ResultEx result = new ResultEx();
		if (roleId == null) {
			return result.makeFailedResult(ErrorCode.BAD_PARAMETER);
		}
		Example ex = new Example(SysRoleResource.class);
		Criteria cri = ex.createCriteria();
		cri.andEqualTo("roleId", roleId);
		List<SysRoleResource> list = roleResourceDao.selectByExample(ex);
		List<SysResourceVo> resList = new ArrayList<SysResourceVo>();
		if(list !=null && list.size()>0 ){
			for(SysRoleResource RoleResource : list){
				SysResourceVo vo = new SysResourceVo();
				vo.setId(RoleResource.getResourceId());
				vo.setName(resourceDao.selectByPrimaryKey(RoleResource.getResourceId()).getName());
				resList.add(vo);
			}
		}
		result.setData(resList);
		return result.makeSuccessResult();
	}
	

}
