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
import tk.mybatis.mapper.entity.Example.Criteria;

import com.example.system.dao.ISysDeptDao;
import com.example.system.dao.ISysRoleDao;
import com.example.system.dao.ISysRoleResourceDao;
import com.example.system.dao.ISysUserDao;
import com.example.system.dao.ISysUserRoleDao;
import com.example.system.dic.CommonDictionary.EnableOrDisable;
import com.example.system.dic.CommonDictionary.EnableOrDisableCode;
import com.example.system.entity.SysRole;
import com.example.system.entity.SysRoleResource;
import com.example.system.entity.SysUser;
import com.example.system.entity.SysUserRole;
import com.example.system.utils.BeanUtils;
import com.example.system.vo.QuerySysRoleVo;
import com.example.system.vo.SysRoleVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;
import com.zjapl.common.util.StringUtil;
@Service
public class SysRoleService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	ISysRoleDao sysRoleDao;
	@Resource
	ISysUserRoleDao sysUserRoleDao;
	@Resource
	ISysUserDao sysUserDao;
	@Resource
	ISysDeptDao sysDeptDao;
	@Resource
	ISysRoleResourceDao sysRoleResourceDao;
	
	/**
	 *	查询角色列表
	 * @param querySysRoleVo
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ObjectResultEx<PageInfo<SysRoleVo>> queryRoleList(QuerySysRoleVo querySysRoleVo, SysUser user){
		if (user == null ){//|| StringUtil.isEmpty(user.getOrgCode())
			logger.error("queryRoleList error, user is null or orgCode is null.");
			return null;
		}
		PageHelper.startPage(querySysRoleVo.getPageNum(),querySysRoleVo.getPageSize());
		SysRole sysRole = new SysRole();
		BeanUtils.copyProperties(querySysRoleVo, sysRole);
		if(!StringUtil.isEmpty(user.getOrgCode())){
			sysRole.setOrgCode(user.getOrgCode());
		}
		sysRole.setStatus(EnableOrDisableCode.ENABLE);
		List<SysRole> sysRoleList = sysRoleDao.select(sysRole);
		PageInfo pageInfo = new PageInfo(sysRoleList);
		List<SysRoleVo> sysRoleListVo = new ArrayList<SysRoleVo>();
		for(SysRole role:sysRoleList){
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
		/*	if(role.getOrgCode()!=null){
				SysDept dept=sysDeptDao.selectByPrimaryKey(Long.valueOf(role.getOrgCode()));
				if(dept!=null){
					roleVo.setOrgCode(dept.getDeptName());
				}
			}*/
			sysRoleListVo.add(roleVo);
		}
		pageInfo.setList(sysRoleListVo);
		return new ObjectResultEx<PageInfo<SysRoleVo>>().makeSuccessResult(pageInfo);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ObjectResultEx<PageInfo<SysRole>> queryAllRoleList(){
		PageHelper.startPage(1, 1000);
		SysRole sysRole = new SysRole();
		List<SysRole> sysRoleList = sysRoleDao.select(sysRole);
		PageInfo pageInfo = new PageInfo(sysRoleList);
		return new ObjectResultEx<PageInfo<SysRole>>().makeSuccessResult(pageInfo);
	}
	/**
	 * 添加或修改角色信息
	 * @param sysRoleVo
	 * @return
	 */
	public ResultEx addOrEditRole(SysRoleVo sysRoleVo,SysUser sysUser){
		try{
			SysRole sysRole = new SysRole();
			BeanUtils.copyPropertiesIgnoreNullValue(sysRoleVo, sysRole);
			sysRole.setUpdateDate(new Date());
			sysRole.setUpdateUserId(sysUser.getId());
			if(sysRoleVo.getId()!=null){
				sysRoleDao.updateByPrimaryKeySelective(sysRole);
			}else{
				sysRole.setCrateDate(new Date());
				sysRole.setCrateUserId(sysUser.getId());
				sysRole.setStatus(EnableOrDisableCode.ENABLE);
				sysRole.setOrgCode(sysUser.getOrgCode());
				sysRoleDao.insertSelective(sysRole);
			}
			if(sysRole.getId()>0&&sysRoleVo.getResourceIds()!=null){
				Example ex=new Example(SysRoleResource.class);
				ex.createCriteria().andEqualTo("roleId", sysRole.getId());
				sysRoleResourceDao.deleteByExample(ex);
				String[] ids=sysRoleVo.getResourceIds().split(",");
				for(String id:ids){
					SysRoleResource resource=new SysRoleResource();
					resource.setRoleId(sysRole.getId());
					resource.setResourceId(Long.valueOf(id));
					resource.setCreateDate(new Date());
					resource.setCreateUserId(sysUser.getId());
					resource.setUpdateDate(new Date());
					resource.setUpdateUserId(sysUser.getId());
					sysRoleResourceDao.insertSelective(resource);
				}
				
			}
		}catch (Exception e) {
			logger.error("addOrEditRole error.", e);
			throw e;
		}
		return new ResultEx().makeSuccessResult();
	}
	
	/**
	 * 根据角色ID修改角色状态
	 * @param id
	 * @return
	 */
	public ResultEx updateSysRoleStatusById(SysRoleVo param, SysUser sysUser){
		if (StringUtil.isEmpty(param.getId()) || StringUtil.isEmpty(param.getStatus())) {
			return new ResultEx().makeInvalidParameterResult();
		}
		try {
			SysRole sysRole=new SysRole();
			sysRole.setStatus(param.getStatus());
			sysRole.setUpdateDate(new Date());
			sysRole.setUpdateUserId(sysUser.getId());
			sysRole.setId(param.getId());
			sysRoleDao.updateByPrimaryKeySelective(sysRole);
			return new ResultEx().makeSuccessResult();
		}catch (Exception e) {
			logger.error("updateSysRoleStatusById error.", e);
			throw e;
		}
	}
	
	/**
	 * 根据角色ID查询角色
	 * @param id
	 * @return
	 */
	public ObjectResultEx<SysRole> querySysRoleById(Long id){
		try{
			SysRole sysRole =sysRoleDao.selectByPrimaryKey(id);
			return new ObjectResultEx<SysRole>().makeSuccessResult(sysRole);
		}catch (Exception e) {
			logger.error("updateSysRoleStatusById error.", e);
			throw e;
		}
		
	}
	
	/**
	 * 查询用户已选择角色
	 * 
	 * @param sysUserVo
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ObjectResultEx<PageInfo<SysRoleVo>> queryRoleListExit(Long id) {
		try{
			PageHelper.startPage(1, 1000,"ID ASC");
			List<SysRole> rolelist = new ArrayList<SysRole>();
			Set<Long> ids = new HashSet<>();
			if(!StringUtil.isEmpty(id)){
				Example example = new Example(SysUserRole.class);
				example.createCriteria().andEqualTo("userId", id);
				List<SysUserRole> userRolelist = sysUserRoleDao.selectByExample(example);
				for (SysUserRole sysUserRole : userRolelist) {
					Long roleId = sysUserRole.getRoleId();
					ids.add(roleId);
				}
				Example exam = new Example(SysRole.class);
				if(ids.size()>0){
					exam.createCriteria().andIn("id", ids).andEqualTo("status", EnableOrDisableCode.ENABLE);
				    rolelist = sysRoleDao.selectByExample(exam);
				}
			}
		    PageInfo pageInfo = new PageInfo(rolelist);
		    List<SysRoleVo> sysRoleListVo = new ArrayList<SysRoleVo>();
		    for(SysRole role:rolelist){
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
//				//所属部门
//				if(role.getOrgCode()!=null){
//					SysDept dept=sysDeptDao.selectByPrimaryKey(Long.valueOf(role.getOrgCode()));
//					if(dept!=null){
//						roleVo.setOrgCode(dept.getDeptName());
//					}
//				}
				sysRoleListVo.add(roleVo);
			}
		    pageInfo.setList(sysRoleListVo);
			return new ObjectResultEx<PageInfo<SysRoleVo>>().makeSuccessResult(pageInfo);
		} catch (Exception e) {
			logger.error("queryRoleListExit error.", e);
			throw e;
		}
	}

	/**
	 * 查询未选择用户角色
	 * 
	 * @param sysUserVo
	 * @return
	 */
	public ObjectResultEx<PageInfo<SysRole>> queryRoleListNotExit(Long id,SysUser sysUser) {
		if (sysUser == null){ // || StringUtil.isEmpty(sysUser.getOrgCode())
			logger.error("queryRoleListNotExit error, user is null or orgCode is null.");
			return null;
		}
		try{
			PageHelper.startPage(1, 1000,"ID ASC");
			List<SysRole> rolelist = new ArrayList<SysRole>();
			Set<Long> ids = new HashSet<>();
			if(!StringUtil.isEmpty(id)){
				Example example = new Example(SysUserRole.class);
				example.createCriteria().andEqualTo("userId", id);
				List<SysUserRole> userRolelist = sysUserRoleDao.selectByExample(example);
				for (SysUserRole sysUserRole : userRolelist) {
					Long roleId = sysUserRole.getRoleId();
					ids.add(roleId);
				}
				Example exam = new Example(SysRole.class);
				Criteria cri=exam.createCriteria();
				if(ids.size() >0){
					cri.andNotIn("id", ids);
				}
				cri.andEqualTo("status", EnableOrDisableCode.ENABLE).andEqualTo("orgCode", sysUser.getOrgCode());
				rolelist = sysRoleDao.selectByExample(exam);
			}
		    PageInfo<SysRole> pageInfo = new PageInfo<SysRole>(rolelist);
			return new ObjectResultEx<PageInfo<SysRole>>().makeSuccessResult(pageInfo);
		} catch (Exception e) {
			logger.error("queryRoleListNotExit error.", e);
			throw e;
		}
	}
	
	/**
	 * 根据用户id查角色列表
	 * @param userId
	 * @return
	 */
	public List<SysRole> getRolesByUserId(Long userId){
		//根据用户查角色
		SysUserRole record = new SysUserRole();
		record.setUserId(userId);
		Example example = new Example(SysUserRole.class);
		example.createCriteria().andEqualTo("userId", userId);
		List<SysUserRole> existSysUserRoles = sysUserRoleDao.selectByExample(example);
		if (existSysUserRoles == null || existSysUserRoles.isEmpty()){
			logger.warn("用户id[{}]尚未配置角色信息", userId);
			return new ArrayList<>();
		}
		Set<Long> ids = new HashSet<>();
		for(SysUserRole tmp : existSysUserRoles){
			ids.add(tmp.getRoleId());
		}
		Example exampleSysRole = new Example(SysRole.class);
		exampleSysRole.createCriteria().andIn("id", ids);
		return sysRoleDao.selectByExample(exampleSysRole);
	}
	
}
