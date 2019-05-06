package com.example.system.edge.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import com.example.system.dao.ISysDeptDao;
import com.example.system.dao.ISysUserDao;
import com.example.system.dao.ISysUserDeptDao;
import com.example.system.dao.ISysUserRoleDao;
import com.example.system.dic.CommonDictionary.EnableOrDisable;
import com.example.system.dic.CommonDictionary.EnableOrDisableCode;
import com.example.system.dic.CommonDictionary.Gender;
import com.example.system.dic.CommonDictionary.UserType;
import com.example.system.entity.SysDept;
import com.example.system.entity.SysUser;
import com.example.system.entity.SysUserDept;
import com.example.system.utils.BeanUtils;
import com.example.system.vo.ShowSysUserVo;
import com.example.system.vo.SysUserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;
import com.zjapl.common.result.XResult.ErrorCode;
import com.zjapl.common.util.StringUtil;

@Service
public class SysUserService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	ISysUserDao sysUserDao;
	@Resource
	ISysUserRoleDao sysUserRoleDao;
	@Resource
	ISysDeptDao sysDeptDao;
	@Resource
	private SysDeptService sysDeptService;
	@Resource
	private ISysUserDeptDao sysUserDeptDao;

	/**
	 * 根据用户名查询用户信息
	 * 
	 * @param username
	 * @return TODO 多系统的用户登录
	 */
	public SysUser getUserByUsername(String username) {
		SysUser record = new SysUser();
		record.setStatus(EnableOrDisableCode.ENABLE);
		record.setUsername(username);
		SysUser sysUser = sysUserDao.selectOne(record);
		return sysUser;
	}
	/**
	 * 根据用户名查询用户信息
	 * 金保服务网注册用户 默认是禁用的
	 * 
	 * @param username
	 * @return TODO 多系统的用户登录
	 */
	public SysUser getUserByUsernameForKingBao(String username) {
		SysUser record = new SysUser();
		//record.setStatus(EnableOrDisableCode.ENABLE);
		record.setUsername(username);
		SysUser sysUser = sysUserDao.selectOne(record);
		return sysUser;
	}
	
	/**
	 * 根据token查询用户信息
	 * @param username
	 * @return
	 */
	public SysUser getSysUserByToken(String token) {
		SysUser record = new SysUser();
		//TODO 状态核实一下
		record.setStatus(EnableOrDisableCode.ENABLE);
		record.setToken(token);
		SysUser sysUser = sysUserDao.selectOne(record);
		return sysUser;
	}

	/**
	 * 更新错误登录次数
	 * 
	 * @param sysUserId
	 */
	public void updateLoginFailed(Long sysUserId) throws AccountException {
		SysUser existSysUser = sysUserDao.selectByPrimaryKey(sysUserId);
		if (existSysUser == null || existSysUser.getId() == null) {
			logger.error("not existSysUser id[{}]", sysUserId);
			throw new AccountException("找不到用户");
		}
		SysUser record = new SysUser();
		record.setId(sysUserId);
		record.setUpdateDate(new Date());
		Integer errorCount = existSysUser.getErrorCount();
		if (errorCount == null || errorCount < 0) {
			errorCount = 0;
		}
		errorCount++;
		record.setErrorCount(errorCount);
		sysUserDao.updateByPrimaryKeySelective(record);
	}

	/**
	 * 更新成功登录次数
	 * 
	 * @param sysUserId
	 * @param ip
	 */
	public void updateLoginInfo(Long sysUserId, String ip)
			throws AccountException {
		SysUser existSysUser = sysUserDao.selectByPrimaryKey(sysUserId);
		if (existSysUser == null || existSysUser.getId() == null) {
			logger.error("not existSysUser id[{}]", sysUserId);
			throw new AccountException("找不到用户");
		}
		SysUser record = new SysUser();
		record.setId(sysUserId);
		record.setUpdateDate(new Date());
		Long loginCount = existSysUser.getLoginCount();
		if (loginCount == null || loginCount < 0) {
			loginCount = 0L;
		}
		loginCount++;
		record.setLoginCount(loginCount);
		record.setErrorCount(0);
		sysUserDao.updateByPrimaryKeySelective(record);
	}
	/**
	 * 更新成功登录次数
	 * 
	 * @param sysUserId
	 * @param ip
	 */
	public void updateUserTokenById(Long sysUserId, String token) {
		/*SysUser existSysUser = sysUserDao.selectByPrimaryKey(sysUserId);
		if (existSysUser == null || existSysUser.getId() == null) {
			logger.error("not existSysUser id[{}]", sysUserId);
			throw new AccountException("找不到用户");
		}*/
		try {
			SysUser record = new SysUser();
			record.setId(sysUserId);
			record.setRecentlyTime(new Date());
			record.setToken(token);
			sysUserDao.updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			logger.warn("更新用户token error", e);
		}
	}
	/**
	 * 更新成功登录次数
	 * 
	 * @param sysUserId
	 * @param ip
	 */
	public void logoutToken(String token) {
		try {
		SysUser record = new SysUser();
		record.setToken(token);
		SysUser existSysUser = sysUserDao.selectOne(record);
		if (existSysUser == null || existSysUser.getId() == null) {
			logger.error("not existSysUser token[{}]", token);
			return ;
		}
		record.setRecentlyTime(null);
		record.setToken(null);
		sysUserDao.updateByPrimaryKey(record);//不能使用update selective,否则没法置空token
		} catch (Exception e) {
			logger.warn("置空用户token error", e);
		}
	}

	/**
	 * 查询用户列表
	 * 
	 * @param sysUserVo
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ObjectResultEx<PageInfo<ShowSysUserVo>> queryUserList(
			SysUserVo sysUserVo,SysUser sysUser) {
		if(sysUserVo==null){
			return new ObjectResultEx<PageInfo<ShowSysUserVo>>().makeInvalidParameterResult();
		}
		if (sysUser == null || StringUtil.isEmpty(sysUser.getOrgCode())){
			logger.error("queryUserList error, sysUser is null or orgCode is null.");
			return null;
		}
		PageInfo pageInfo=null;
		List<Long> userIds=new ArrayList<Long>();
		Example ex=new Example(SysUser.class);
		Criteria cri=ex.createCriteria();
		cri.andNotEqualTo("status", EnableOrDisableCode.DELETED);
		cri.andEqualTo("orgCode",sysUser.getOrgCode());
		if(!StringUtil.isEmpty(sysUserVo.getDeptId())){
			Example deptEx=new Example(SysUserDept.class);
			deptEx.createCriteria().andIn("deptId",	getSysDeptAndSonsById(sysUserVo.getDeptId()));
			List<SysUserDept> userDeptLsit=sysUserDeptDao.selectByExample(deptEx);
			for(SysUserDept user:userDeptLsit){
				userIds.add(user.getUserId());
			}	
			if(userIds.size()>0){
				cri.andIn("id", userIds);
			}else{
				pageInfo = new PageInfo<ShowSysUserVo>(null);
				return new ObjectResultEx<PageInfo<ShowSysUserVo>>()
						.makeSuccessResult(pageInfo);
			}
		}
		if(!StringUtil.isEmpty(sysUserVo.getRealName())){
			cri.andLike("realName", "%"+sysUserVo.getRealName()+"%");
			
		}
		if (sysUserVo.getAccountType() != null){
			cri.andEqualTo("accountType", sysUserVo.getAccountType());
		}
		List<SysUser> sysUserList = null;
		PageHelper.startPage(sysUserVo.getPageNum(), sysUserVo.getPageSize(),"ID ASC");
		List<ShowSysUserVo> showList = new ArrayList<ShowSysUserVo>();
		try {
			sysUserList = sysUserDao.selectByExample(ex);
			pageInfo=new PageInfo(sysUserList);
			for (SysUser user : sysUserList) {
				ShowSysUserVo vo = new ShowSysUserVo();
				BeanUtils.copyPropertiesIgnoreNullValue(user, vo);
				vo.setSexName(Gender.parseCode(vo.getSex()).getLocalizedName());
				vo.setStatusName(EnableOrDisable.parseCode(vo.getStatus()).getLocalizedName());
				String deptNames = "";
				String deptIds = "";
				StringBuffer sbf = new StringBuffer();
				StringBuffer sbfIds = new StringBuffer();
				Example example = new Example(SysUserDept.class);
				example.createCriteria().andEqualTo("userId",user.getId());
				List<SysUserDept> userDepts = sysUserDeptDao.selectByExample(example);
				for (SysUserDept userDept : userDepts) {
					String deptName = sysDeptService.parseDeptNameCode(userDept.getDeptId());
					sbf.append(","+deptName);
					sbfIds.append("," + userDept.getDeptId());
				}
				if (sbf.toString().length() > 0){
					deptNames = sbf.toString().substring(1,sbf.toString().length());
					vo.setDeptsName(deptNames);
				}
				if (sbfIds.toString().length()>0){
					deptIds = sbfIds.toString().substring(1,sbfIds.toString().length());
					vo.setDeptIds(deptIds);
				}
				vo.setAccountTypeName(UserType.parseCode(user.getAccountType())==null?"未定义":UserType.parseCode(user.getAccountType()).getLocalizedName());
				vo.setPassword("");
				showList.add(vo);
			}
			pageInfo.setList(showList);
		} catch (Exception e) {
			logger.error("queryUserList error.", e);
			throw e;
		}
		return new ObjectResultEx<PageInfo<ShowSysUserVo>>().makeSuccessResult(pageInfo);
	}

	/**
	 * 添加或修改用户信息
	 * 
	 * @param sysUserVo
	 * @return
	 */
	public ResultEx addOrEditSysUser(SysUserVo sysUserVo, SysUser user) {
		if (sysUserVo == null) {
			return new ResultEx().makeInvalidParameterResult();
		}
		SysUser sysUser = new SysUser();
		try {
			BeanUtils.copyPropertiesIgnoreNullValue(sysUserVo, sysUser);
			Example userEx = new Example(SysUser.class);
			Criteria userCri = userEx.createCriteria();
			userCri.andNotEqualTo("status", EnableOrDisableCode.DELETED);
			userCri.andEqualTo("username", sysUser.getUsername());
			if (sysUser.getId() != null){
				userCri.andNotEqualTo("id", sysUser.getId());
			}
			int count  =sysUserDao.selectCountByExample(userEx);
			if(count>0){
				return new ResultEx().makeFailedResult(ErrorCode.DUPLICATED, "该登录名已存在"); 
			}		
			if (sysUserVo.getId() != null) {
				sysUser.setPassword(null);
				sysUserDao.updateByPrimaryKeySelective(sysUser);
				//更新用户所在的部门
				if(!StringUtil.isEmpty(sysUserVo.getDeptIds())){
					//先删除用户的原先部门
					Example example = new Example(SysUserDept.class);
					example.createCriteria().andEqualTo("userId", sysUserVo.getId());
					sysUserDeptDao.deleteByExample(example);
				}
			} else {
				String password = sysUser.getPassword();
				if(StringUtil.isEmpty(password)){
					password = "888888";
					
				}
				Md5Hash md5Hash = new Md5Hash(password);
				sysUser.setPassword(md5Hash.toHex());
				if(StringUtil.isEmpty(sysUser.getOrgCode())){
					sysUser.setOrgCode(user.getOrgCode());
				}
				
				sysUserDao.insertSelective(sysUser);
			}
			//增加用户所在的部门
			if(!StringUtil.isEmpty(sysUserVo.getDeptIds())){
				//再插入用户的新部门
				String[] deptIds = sysUserVo.getDeptIds().split(",");
				for (String deptId : deptIds) {
					SysUserDept record = new SysUserDept();
					record.setUserId(sysUser.getId());
					record.setDeptId(Long.parseLong(deptId));
					record.setCreateDate(new Date());
					record.setCreateUserId(sysUser.getId());
					record.setUpdateDate(new Date());
					record.setUpdateUserId(sysUser.getId());
					record.setOrgCode(user.getOrgCode());
					sysUserDeptDao.insertSelective(record);
				}
			}
		} catch (Exception e) {
			logger.error("addOrEditSysUser error.", e);
			throw e;
		}
		return new ResultEx().makeSuccessResult();
	}

	/**
	 * 根据用户ID修改用户状态
	 * 
	 * @param id
	 * @return
	 */
	public ResultEx updateSysUserStatusById(ShowSysUserVo param, SysUser sysUser) {
		if (StringUtil.isEmpty(param.getIds()) || StringUtil.isEmpty(param.getStatus())) {
			return new ResultEx().makeInvalidParameterResult();
		}
		try {
			String[] idStrings=param.getIds().split(",");
			List<Long> idList=new ArrayList<Long>();
			for(String str: idStrings){
				if(str.matches("[0-9]{1,}")){
					idList.add(Long.valueOf(str));
				}
			}
			Example ex=new Example(SysUser.class);
			ex.createCriteria().andIn("id", idList);
			SysUser user = new SysUser();
			user.setUpdateUserId(sysUser.getId());
			user.setUpdateDate(new Date());
			EnableOrDisable disable=EnableOrDisable.parseCode(param.getStatus());
			if(disable!=null){
				user.setStatus(disable.getCode());
			}
			sysUserDao.updateByExampleSelective(user,ex);
		} catch (Exception e) {
			logger.error("updateSysUserStatusById error.", e);
			throw e;
		}
		return new ResultEx().makeSuccessResult();
	}

	/**
	 * 根据用户ID初始化密码
	 * 
	 * @param id
	 * @return
	 */
	public ResultEx passwordInitById(String ids) {
		if (ids == null) {
			return new ResultEx().makeInvalidParameterResult();
		}
		try {
			String[] idStrings=ids.split(",");
			List<Long> idList=new ArrayList<Long>();
			for(String str: idStrings){
				if(str.matches("[0-9]{1,}")){
					idList.add(Long.valueOf(str));
				}
			}
			Example ex=new Example(SysUser.class);
			ex.createCriteria().andIn("id", idList);
			SysUser sysUser = new SysUser();
			sysUser.setUpdateDate(new Date());
			Md5Hash md5Hash = new Md5Hash("888888");
			sysUser.setPassword(md5Hash.toHex());
			sysUserDao.updateByExampleSelective(sysUser,ex);
		} catch (Exception e) {
			logger.error("passwordInitById error.", e);
			throw e;
		}
		return new ResultEx().makeSuccessResult();
	}

	/**
	 * 根据ID查询用户信息
	 * 
	 * @param id
	 * @return
	 */
	public ObjectResultEx<SysUser> querySysUser(Long id) {
		SysUser sysUser = new SysUser();
		if (id == null) {
			return new ObjectResultEx<SysUser>().makeSuccessResult(sysUser);
		}
		try {
			sysUser = sysUserDao.selectByPrimaryKey(id);
			sysUser.setPassword("");
		} catch (Exception e) {
			logger.error("querySysUser error.", e);
			throw e;
		}
		return new ObjectResultEx<SysUser>().makeSuccessResult(sysUser);
	}
	
	/**
	 * 根据ID查询用户信息
	 * 
	 * @param id
	 * @return
	 */
	public ObjectResultEx<SysUser> querySysUserEnable(Long id) {
		SysUser sysUser = null;
		if (id == null) {
			return new ObjectResultEx<SysUser>().makeSuccessResult(sysUser);
		}
		try {
			Example example = new Example(SysUser.class);
			example.createCriteria().andEqualTo("id", id).andEqualTo("status", EnableOrDisableCode.ENABLE);
			List<SysUser>  users = sysUserDao.selectByExample(example);
			if (users.size() >0 ){
				sysUser = users.get(0);
				sysUser.setPassword("");
			}
		} catch (Exception e) {
			logger.error("querySysUser error.", e);
			throw e;
		}
		return new ObjectResultEx<SysUser>().makeSuccessResult(sysUser);
	}

//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	public ObjectResultEx<PageInfo<SysUserVo>> queryAllSysUser() {
//		Example example = new Example(SysUser.class);
//		example.createCriteria().andEqualTo("status", EnableOrDisableCode.ENABLE);
//		List<SysUser> list = sysUserDao.selectByExample(example);
//		List<SysUserVo> userVoList = new ArrayList<SysUserVo>();
//		PageInfo pageInfo = new PageInfo<>(userVoList);
//		for (SysUser sysUser : list) {
//			SysUserVo userVo = new SysUserVo();
//			BeanUtils.copyProperties(sysUser, userVo);
//			Example exam = new Example(SysUserDept.class);
//			List<SysUserDept> userDeptList = sysUserDeptDao.selectByExample(example);
//			for (SysUserDept sysUserDept : userDeptList) {
//				sysUserDept.getDeptId();
//			}
//			if(sysUser.getDeptId() != null){
//				SysDept sysDept = sysDeptDao.selectByPrimaryKey(sysUser.getDeptId());
//				userVo.setDeptName(sysDept.getDeptName());
//			}
//			userVo.setPassword("");
//			userVoList.add(userVo);
//		}
//		pageInfo.setList(userVoList);
//		return new ObjectResultEx<PageInfo<SysUserVo>>().makeSuccessResult(pageInfo);
//	}

//	/**
//	 * 查询已选择用户
//	 * 
//	 * @param sysUserVo
//	 * @return
//	 */
//	public ObjectResultEx<PageInfo<SysUserVo>> queryUserListExit(SysUserVo sysUserVo) {
//		PageHelper.startPage(sysUserVo.getPageNum(), sysUserVo.getPageSize(),"ID ASC");
//		SysUser sysUser = new SysUser();
//		BeanUtils.copyProperties(sysUserVo, sysUser);
//		List<SysUser> sysUserList = null;
//		List<SysUserVo> showList = new ArrayList<SysUserVo>();
//		try {
//			if (sysUserVo != null && !StringUtil.isEmpty(sysUserVo.getUserIds())) {
//				Example example = new Example(SysUser.class);
//				String[] userIds = sysUserVo.getUserIds().split(",");
//				Set<Long> ids = new HashSet<>();
//				for (String userId : userIds) {
//					ids.add(Long.parseLong(userId));
//				}
//				if(ids.size() > 0){
//					example.createCriteria().andIn("id", ids);
//					sysUserList = sysUserDao.selectByExample(example);
//					for (SysUser user : sysUserList) {
//						SysUserVo userVo = new SysUserVo();
//						BeanUtils.copyProperties(user, userVo);
//						SysDept sysDept = sysDeptDao.selectByPrimaryKey(user.getDeptId());
//						userVo.setDeptName(sysDept.getDeptName());
//						showList.add(userVo);
//					}
//				}
//			}
//		} catch (Exception e) {
//			logger.error("queryUserListExit error.", e);
//			throw e;
//		}
//		PageInfo<SysUserVo> pageInfo = new PageInfo<SysUserVo>(showList);
//		return new ObjectResultEx<PageInfo<SysUserVo>>()
//				.makeSuccessResult(pageInfo);
//	}


//	/**
//	 * 查询未选择用户
//	 * 
//	 * @param sysUserVo
//	 * @return
//	 */
//	public ObjectResultEx<PageInfo<SysUserVo>> queryUserListNotExit(SysUserVo sysUserVo) {
//		PageHelper.startPage(sysUserVo.getPageNum(), sysUserVo.getPageSize(),"ID ASC");
//		SysUser sysUser = new SysUser();
//		BeanUtils.copyProperties(sysUserVo, sysUser);
//		List<SysUser> sysUserList = null;
//		List<SysUserVo> showList = new ArrayList<SysUserVo>();
//		try {
//			if (sysUserVo != null && !StringUtil.isEmpty(sysUserVo.getUserIds())) {
//				Example example = new Example(SysUser.class);
//				String[] userIds = sysUserVo.getUserIds().split(",");
//				Set<Long> ids = new HashSet<>();
//				for (String userId : userIds) {
//					ids.add(Long.parseLong(userId));
//				}
//				if(ids.size() >0){
//					example.createCriteria().andNotIn("id", ids);
//					sysUserList = sysUserDao.selectByExample(example);
//				}
//			} else {
//				sysUserList = sysUserDao.select(sysUser);
//			}
//			for (SysUser user : sysUserList) {
//				SysUserVo userVo = new SysUserVo();
//				BeanUtils.copyProperties(user, userVo);
//				SysDept sysDept = sysDeptDao.selectByPrimaryKey(user.getDeptId());
//				userVo.setDeptName(sysDept.getDeptName());
//				showList.add(userVo);
//			}
//		} catch (Exception e) {
//			logger.error("queryUserListExit error.", e);
//			throw e;
//		}
//		PageInfo<SysUserVo> pageInfo = new PageInfo<SysUserVo>(showList);
//		return new ObjectResultEx<PageInfo<SysUserVo>>().makeSuccessResult(pageInfo);
//	}
	
	/**
	 * 修改用户密码
	 * @param sysUserVo
	 * @param sysUser
	 */
	public ResultEx updateCurrentPassword(ShowSysUserVo param, SysUser sysUser){
		try{
			if(StringUtil.isEmpty(param.getPassword()) || StringUtil.isEmpty(param.getOldpass())){
				logger.error("updateCurrentPassword password or oldpass is null ");
				return new ResultEx().makeFailedResult(ErrorCode.BAD_PARAMETER, "请输出新密码或者原密码！");
			}
			if(param.getPassword().equals(param.getOldpass())){
				return new ResultEx().makeFailedResult(ErrorCode.BAD_PARAMETER, "新密码于旧密码不能相同！");
			}
			Example example = new Example(SysUser.class);
			example.createCriteria().andEqualTo("id",sysUser.getId()).andEqualTo("password", new Md5Hash(param.getOldpass()).toHex());
			List<SysUser> user = sysUserDao.selectByExample(example);
			if(StringUtil.isEmpty(user) || user.size() == 0){
				return new ResultEx().makeFailedResult(ErrorCode.BAD_PARAMETER, "您输入的原密码错误！");
			}else{
				SysUser users = new SysUser();
				users.setId(sysUser.getId());
				users.setPassword(new Md5Hash(param.getPassword()).toHex());
				users.setUpdateDate(new Date());
				sysUserDao.updateByPrimaryKeySelective(users);
			}
			return new ResultEx().makeSuccessResult();
//			return "系统提示, 恭喜，密码修改成功！您的新密码为：" + param.getPassword();
		} catch (Exception e) {
			logger.error("updateCurrentPassword error.", e);
			throw e;
		}
	}
	
	
	/**
	 * 根据部门查询部门全部子节点Id
	 * @param deptIds
	 * @return
	 */
	public Set<Long> getSysDeptAndSonsById(Long... deptIds){
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
	 * 
	 * @param sysUser
	 * @return
	 */
	public SysUser getSysUserByUsernameAndPassword(String userName,String password) {
		SysUser user = new SysUser();
		user.setUsername(userName);
		user.setPassword(password);
		try {
			user = sysUserDao.selectOne(user);
		} catch (Exception e) {
			logger.error("SysUserService.getSysUserByUsernameAndPassword error....",e);
			throw e;
		}
		
		return user;
	}
	
	/**
	 * FIXME 金保服务网网站用户忘记密码时使用
	 * 密码重置
	 * @param password 密码
	 * @param username 用户名
	 */
	public ResultEx resetPassword(String password, String username){
		ResultEx result = new ResultEx();
		try{
			if(StringUtil.isEmpty(username)){
				logger.error("updateCurrentPassword(String,String) 无用户名");
				return result.makeFailedResult(ErrorCode.BAD_PARAMETER, "非法操作！") ;
			}
			if(StringUtil.isEmpty(password)){
				return result.makeFailedResult(ErrorCode.BAD_PARAMETER, "请输入密码！") ;
			}
			Example example = new Example(SysUser.class);
			example.createCriteria().andEqualTo("username",username);
			
			SysUser sysUser = new SysUser();
			sysUser.setPassword(new Md5Hash(password).toHex());
			sysUserDao.updateByExampleSelective(sysUser, example);
		} catch (Exception e) {
			logger.error("resetPassword error....", e);
			throw e;
		}
		return result.makeSuccessResult();
	}
}
