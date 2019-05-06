package com.example.system.edge.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import com.example.system.dao.ISysDeptDao;
import com.example.system.dao.ISysRoleDao;
import com.example.system.dao.ISysUserDao;
import com.example.system.dao.ISysUserDeptDao;
import com.example.system.dao.ISysUserRoleDao;
import com.example.system.dic.CommonDictionary.DeptType;
import com.example.system.dic.CommonDictionary.EnableOrDisable;
import com.example.system.dic.CommonDictionary.EnableOrDisableCode;
import com.example.system.entity.SysDept;
import com.example.system.entity.SysRole;
import com.example.system.entity.SysUser;
import com.example.system.entity.SysUserDept;
import com.example.system.entity.SysUserRole;
import com.example.system.utils.BeanUtils;
import com.example.system.vo.QuerySysDeptVo;
import com.example.system.vo.ShowSysDeptVo;
import com.example.system.vo.SysDeptUserVo;
import com.example.system.vo.SysDeptVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;
import com.zjapl.common.result.XResult.ErrorCode;
import com.zjapl.common.util.StringUtil;
import com.zjapl.common.util.TreeMenuUtils;
import com.zjapl.common.vo.TreeMenuVo;
/**
 * 文件名：SysDeptService.java
 * 日　期：2017年3月1日 下午4:32:54
 * 版　权：ZJAPL
 * 作　者：LISS
 * 类说明：
 */
@Service
public class SysDeptService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	ISysUserDeptDao sysUserDeptDao;
	@Resource
	ISysDeptDao sysDeptDao;
	@Resource
	ISysUserDao sysUserDao;
	@Resource
	ISysRoleDao sysRoleDao;
	@Resource
	ISysUserRoleDao sysUserRoleDao;
	@Resource
	SysUserService sysUserService;
	
	/**
	 * 查询部门树结构
	 * @param sysUser
	 * @return
	 */
	public ObjectResultEx<List<TreeMenuVo>> queryAllDeptsTree(SysUser sysUser) {
		if (sysUser == null ){//|| StringUtil.isEmpty(sysUser.getOrgCode())
			logger.error("queryAllDeptsTree error. sysUser is null.");
			return new ObjectResultEx<List<TreeMenuVo>>().makeFailedResult(ErrorCode.NOT_LOGGED_IN);
		}
		List<SysDept> sysDepts = queryAllDepts(sysUser);
		if (sysDepts == null || sysDepts.isEmpty()){
			logger.info("查询部门树为空.sysDepts[{}]", sysDepts);
			return new ObjectResultEx<List<TreeMenuVo>>().makeSuccessResult(new ArrayList<TreeMenuVo>());
		}
		List<TreeMenuVo> treeMenuVos = new ArrayList<TreeMenuVo>();
		for(SysDept sysDept : sysDepts){
			TreeMenuVo treeMenuVo = new TreeMenuVo();
			treeMenuVo.setId(sysDept.getId());
			treeMenuVo.setpId(sysDept.getPid());
			treeMenuVo.setText(sysDept.getDeptName());
			treeMenuVo.setIconCls(null);
			treeMenuVo.setChecked(false);
			treeMenuVos.add(treeMenuVo);
		}
		List<TreeMenuVo> treeNodes = TreeMenuUtils.getTreeMenuNodes(treeMenuVos);
		return new ObjectResultEx<List<TreeMenuVo>>().makeSuccessResult(treeNodes);
	}

	/**
	 * 查询参数列表
	 * @param sysDeptVo
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public  ObjectResultEx<PageInfo<ShowSysDeptVo>> querySysDeptList(QuerySysDeptVo sysDeptVo,SysUser sysUser){
		if (sysUser == null){ // || StringUtil.isEmpty(sysUser.getOrgCode())
			logger.error("querySysDeptList error, sysUser is null or orgCode is null.");
			return null;
		}
		if (sysDeptVo == null){
			return new ObjectResultEx<PageInfo<ShowSysDeptVo>>().makeInvalidParameterResult();
		}
		SysDept sysDept = new SysDept();
		BeanUtils.copyProperties(sysDeptVo, sysDept);
		Example ex=new Example(SysDept.class);
		Criteria criteria=ex.createCriteria();
		criteria.andNotEqualTo("status", EnableOrDisableCode.DELETED);
		criteria.andEqualTo("orgCode", sysUser.getOrgCode());
		if(!StringUtil.isEmpty(sysDept.getDeptName())){
			criteria.andLike("deptName", "%"+sysDept.getDeptName()+"%");
		}
		if(!StringUtil.isEmpty(sysDept.getId())){
			Set<Long> deptIds = getSysDeptAndSonsById(sysDept.getId());
			criteria.andIn("id", deptIds);
		}
		if (sysDept.getDeptType() != null){
			criteria.andEqualTo("deptType", sysDept.getDeptType());
		}
		PageHelper.startPage(sysDeptVo.getPageNum(),  sysDeptVo.getPageSize());
		List<SysDept> sysDictionaryList= sysDeptDao.selectByExample(ex);
		PageInfo pageInfo = new PageInfo<>(sysDictionaryList);
		List<ShowSysDeptVo> showSysDeptVos=new ArrayList<ShowSysDeptVo>();
		for(SysDept dept:sysDictionaryList){
			ShowSysDeptVo vo=new ShowSysDeptVo();
			BeanUtils.copyPropertiesIgnoreNullValue(dept, vo);
			SysDept sys=sysDeptDao.selectByPrimaryKey(vo.getPid());
			if(sys!=null){
				vo.setPdeptName(sys.getDeptName());
			}
			if (!StringUtil.isEmpty(vo.getStatus())){
				vo.setStatusName(EnableOrDisable.parseCode(vo.getStatus()).getLocalizedName());
			}
			if (!StringUtil.isEmpty(vo.getDeptType())){
				vo.setDeptTypeName(DeptType.parseCode(vo.getDeptType()).getLocalizedName());
			}
			SysUser user = sysUserDao.selectByPrimaryKey(dept.getUserId());
			if (user!=null){
				vo.setRealName(user.getRealName());
			}
			showSysDeptVos.add(vo);
		}
		pageInfo.setList(showSysDeptVos);
		return new ObjectResultEx<PageInfo<ShowSysDeptVo>>().makeSuccessResult(pageInfo);
	}
	/**
	 * 添加修改
	 * @param sysDeptVo
	 * @return
	 */
	public  ResultEx saveOrEditDept(SysDeptVo sysDeptVo,SysUser user){
		if (sysDeptVo == null){
			return new ResultEx().makeInvalidParameterResult();
		}
		SysDept sysDept = new SysDept();
		BeanUtils.copyProperties(sysDeptVo, sysDept);
		sysDept.setUpdateDate(new Date());
		sysDept.setUpdateUserId(user.getId()+"");
		sysDept.setUserId(getUserIdByUserDeptId(sysDeptVo.getUserId()));
		if(!StringUtil.isEmpty(sysDept.getId())){
			sysDeptDao.updateByPrimaryKeySelective(sysDept);
		}else{
			sysDept.setStatus(EnableOrDisableCode.ENABLE);
			if(StringUtils.isEmpty(sysDeptVo.getOrgCode())){
				sysDept.setOrgCode(user.getOrgCode());
			}
			sysDept.setCreateDate(new Date());
			sysDept.setCreateUserId(user.getId()+"");
			sysDeptDao.insertSelective(sysDept);
		}
		return new ResultEx().makeSuccessResult();
	}
	
	/**
	 * 修改状态
	 * @param sysDeptVo
	 * @return
	 */
	public  ResultEx editDeptStatus(String ids, Short status, SysUser sysUser){
		if (StringUtil.isEmpty(ids) || StringUtil.isEmpty(status)){
			return new ResultEx().makeInvalidParameterResult();
		}
		SysDept dept = new SysDept();
		dept.setUpdateDate(new Date());
		dept.setUpdateUserId(sysUser.getId()+"");
		dept.setStatus(status);
		String[] idStrings=ids.split(",");
		List<Long> idList=new ArrayList<Long>();
		for(String str: idStrings){
			if(str.matches("[0-9]{1,}")){
				idList.add(Long.valueOf(str));
			}
		}
		Example ex=new Example(SysDept.class);
		ex.createCriteria().andIn("id", idList);
		sysDeptDao.updateByExampleSelective(dept, ex);
		return new ResultEx().makeSuccessResult();
	}
	
	/**
	 * 根据部门ID获取部门名称
	 * @param deptCode
	 * @return
	 */
	public String parseDeptNameCode(Long id){
		if(id == null || StringUtil.isEmpty(id)){
			logger.error("parseDeptNameCode id is null Or empty");
			return null;
		}
		SysDept sysDept = sysDeptDao.selectByPrimaryKey(id);
		if(sysDept==null || StringUtil.isEmpty(sysDept.getDeptName())){
			logger.warn("parseDeptNameCode not exist sysDept[{}]", sysDept);
			return null;
		}
		return sysDept.getDeptName();
	}
	
	public ObjectResultEx<List<SysDeptUserVo>> queryAllDeptUsers(SysUser sysUser){
		if (sysUser == null){ // || StringUtil.isEmpty(sysUser.getOrgCode())
			logger.error("queryAllDeptUsers error, sysUser is null or orgCode is null.");
			return null;
		}
		List<SysDeptUserVo> deptUser = new ArrayList<SysDeptUserVo>();
		//机构列表
		Example exDept = new Example(SysDept.class);
		exDept.createCriteria().andEqualTo("status", EnableOrDisableCode.ENABLE)
		.andEqualTo("orgCode", sysUser.getOrgCode());
		List<SysDept> sysDepts = sysDeptDao.selectByExample(exDept);
		for (SysDept sysDept : sysDepts) {
			SysDeptUserVo userVo = new SysDeptUserVo();
			userVo.setId(sysDept.getId());
			userVo.setName(sysDept.getDeptName());
			userVo.setPid(sysDept.getPid());
			userVo.setIsUser(false);
			deptUser.add(userVo);
		}
		//机构列表
		Example exUserDept = new Example(SysUserDept.class);
		exUserDept.createCriteria().andEqualTo("orgCode", sysUser.getOrgCode());
		List<SysUserDept> userDeptList = sysUserDeptDao.selectByExample(exUserDept);
		for (SysUserDept sysUserDept : userDeptList) {
			ObjectResultEx<SysUser> sysUserData = sysUserService.querySysUserEnable(sysUserDept.getUserId());
			SysUser user = sysUserData.getData();
			if(!StringUtil.isEmpty(user)){
				SysDeptUserVo userVo = new SysDeptUserVo();
				userVo.setId(sysUserDept.getId());
				userVo.setName(user.getRealName());
				userVo.setPid(sysUserDept.getDeptId());
				userVo.setIsUser(true);
				deptUser.add(userVo);
			}
		}
		return new ObjectResultEx<List<SysDeptUserVo>>().makeSuccessResult(deptUser);
	}
	
	/**
	 * 根据部门查询部门全部子节点Id
	 * @param deptIds
	 * @return
	 */
	private Set<Long> getSysDeptAndSonsById(Long... deptIds){
		if (deptIds == null || deptIds.length <= 0){
			return null;
		}
		Example example = new Example(SysDept.class);
		Set<Long> ids = new HashSet<>();
		ids.remove(null);
		ids.addAll(Arrays.asList(deptIds));
		int idSize = ids.size();
		example = new Example(SysDept.class);
		example.createCriteria().andIn("pid", ids);
		List<SysDept> sysDepts = sysDeptDao.selectByExample(example);
		if (sysDepts != null && sysDepts.size() > 0){
			for(SysDept sysDept : sysDepts){
				ids.add(sysDept.getId());
			}
		}
		ids.remove(null);
		if (ids.size() > idSize){
			ids.addAll(getSysDeptAndSonsById(ids.toArray(new Long[ids.size()])));
		}
		return ids;
	}
	
	/**
	 * 根据用户id查询部门信息
	 * @param userId
	 * @return
	 */
	public List<SysDept> getSysDeptByUserId(Long userId){
		if (userId == null){
			logger.debug("getSysDeptByUserId userId is null.");
			return null;
		}
		Example example = new Example(SysUserDept.class);
		example.createCriteria().andEqualTo("userId", userId);
		List<SysUserDept> existSysUserDepts = sysUserDeptDao.selectByExample(example);
		if (existSysUserDepts == null || existSysUserDepts.isEmpty()){
			logger.warn("用户id[{}]尚未配置部门信息", userId);
			return new ArrayList<>();
		}
		Set<Long> ids = new HashSet<>();
		for (SysUserDept tmp : existSysUserDepts){
			ids.add(tmp.getDeptId());
		}
		Example exampleSysDept = new Example(SysDept.class);
		exampleSysDept.createCriteria().andIn("id", ids);
		return sysDeptDao.selectByExample(exampleSysDept);
	}
	
	/**
	 * 通过机构代码查部门
	 * @param orgCode
	 * @return
	 */
	private List<SysDept> queryAllDepts(SysUser sysUser){
		if (sysUser == null ){//|| StringUtil.isEmpty(sysUser.getOrgCode())
			logger.error("queryAllDepts error, sysUser is null or orgCode is null.");
			return null;
		}
		// 通过用户机构代码查询下面所属部门
		PageHelper.startPage(1, 0,"ID");
		Example ex=new Example(SysDept.class);
		Criteria criteria=ex.createCriteria();
		criteria.andNotEqualTo("status", EnableOrDisableCode.DELETED);
		criteria.andEqualTo("orgCode",sysUser.getOrgCode());
		List<SysDept> sysDepts = sysDeptDao.selectByExample(ex);
		return sysDepts;
	}
	
	public ObjectResultEx<List<SysDeptUserVo>> queryDeptUsers(Short deptType,Short loginMode,SysUser sysUser){
		List<SysDeptUserVo> deptUser = new ArrayList<SysDeptUserVo>();
		//机构列表
		Example exDept = new Example(SysDept.class);
		Criteria criDept=exDept.createCriteria();
		criDept.andEqualTo("status", EnableOrDisableCode.ENABLE);
		if(!StringUtil.isEmpty(deptType)){
			criDept.andEqualTo("deptType", deptType);
		}
		List<Long> deptIds=new ArrayList<Long>();
		List<SysDept> sysDepts = sysDeptDao.selectByExample(exDept);
		for (SysDept sysDept : sysDepts) {
			SysDeptUserVo userVo = new SysDeptUserVo();
			userVo.setId(sysDept.getId());
			userVo.setName(sysDept.getDeptName());
			userVo.setPid(sysDept.getPid());
			userVo.setIsUser(false);
			deptUser.add(userVo);
			deptIds.add(sysDept.getId());
		}
		Set<Long> userIdList=new HashSet<Long>();
		if(!StringUtil.isEmpty(loginMode)){
			Example exRole = new Example(SysRole.class);
			exRole.createCriteria().andEqualTo("loginMode", loginMode).andEqualTo("status", EnableOrDisableCode.ENABLE);
			List<SysRole> roleList=sysRoleDao.selectByExample(exRole);
			List<Long> roelIdList=new ArrayList<Long>();
			for(SysRole role : roleList){
				roelIdList.add(role.getId());
			}
			List<SysUserRole> userRoleList=sysUserRoleDao.selectAll();
			for(SysUserRole userRole : userRoleList){
				if(!roelIdList.contains(userRole.getRoleId())){
					continue;
				}
				userIdList.add(userRole.getUserId());
			}
		}
		List<SysUserDept> userDeptList = sysUserDeptDao.selectAll();
		for (SysUserDept sysUserDept : userDeptList) {
			if(!deptIds.contains(sysUserDept.getDeptId())){
				continue;
			}
			if(!userIdList.contains(sysUserDept.getUserId())){
				continue;
			}
			ObjectResultEx<SysUser> sysUserData = sysUserService.querySysUserEnable(sysUserDept.getUserId());
			SysUser user = sysUserData.getData();
			if(!StringUtil.isEmpty(user)){
				SysDeptUserVo userVo = new SysDeptUserVo();
				userVo.setId(sysUserDept.getId());
				userVo.setName(user.getRealName());
				userVo.setPid(sysUserDept.getDeptId());
				userVo.setIsUser(true);
				deptUser.add(userVo);
			}
		}
		return new ObjectResultEx<List<SysDeptUserVo>>().makeSuccessResult(deptUser);
	}
	
	public ObjectResultEx<List<SysDeptUserVo>> queryDeptUser(Short deptType ,SysUser sysUser){
		List<SysDeptUserVo> deptUser = new ArrayList<SysDeptUserVo>();
		//机构列表
		Example exDept = new Example(SysDept.class);
		Criteria criDept=exDept.createCriteria();
		criDept.andEqualTo("status", EnableOrDisableCode.ENABLE);
		if(!StringUtil.isEmpty(deptType)){
			criDept.andEqualTo("deptType", deptType);
		}
		List<Long> deptIds=new ArrayList<Long>();
		List<SysDept> sysDepts = sysDeptDao.selectByExample(exDept);
		for (SysDept sysDept : sysDepts) {
			SysDeptUserVo userVo = new SysDeptUserVo();
			userVo.setId(sysDept.getId());
			userVo.setName(sysDept.getDeptName());
			userVo.setPid(sysDept.getPid());
			userVo.setIsUser(false);
			deptUser.add(userVo);
			deptIds.add(sysDept.getId());
		}
		List<SysUserDept> userDeptList = sysUserDeptDao.selectAll();
		for (SysUserDept sysUserDept : userDeptList) {
			if(!deptIds.contains(sysUserDept.getDeptId())){
				continue;
			}
			ObjectResultEx<SysUser> sysUserData = sysUserService.querySysUserEnable(sysUserDept.getUserId());
			SysUser user = sysUserData.getData();
			if(!StringUtil.isEmpty(user)){
				SysDeptUserVo userVo = new SysDeptUserVo();
				userVo.setId(sysUserDept.getId());
				userVo.setName(user.getRealName());
				userVo.setPid(sysUserDept.getDeptId());
				userVo.setIsUser(true);
				deptUser.add(userVo);
			}
		}
		return new ObjectResultEx<List<SysDeptUserVo>>().makeSuccessResult(deptUser);
	}
	
	/**
	 * 中间表id获取userId
	 * @param userId
	 * @return
	 */
	public Long getUserIdByUserDeptId(Long userDeptId){
		if (userDeptId==null){
			return null;
		}
		SysUserDept sysUserDept = sysUserDeptDao.selectByPrimaryKey(userDeptId);
		if (sysUserDept!=null){
			return sysUserDept.getUserId();
		}
		return null;
	}
}

