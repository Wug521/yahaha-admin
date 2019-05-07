package com.example.system.edge.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.system.dao.ISysUserDao;
import com.example.system.dao.ISysUserRoleDao;
import com.example.system.dic.CommonDictionary.EnableOrDisableCode;
import com.example.system.edge.service.IUserService;
import com.example.system.entity.SysUser;
import com.example.system.entity.SysUserRole;
import com.example.system.utils.BeanUtils;
import com.example.system.utils.CommonUtil;
import com.example.system.vo.SysUserQueryVo;
import com.example.system.vo.SysUserRoleVo;
import com.example.system.vo.SysUserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;
import com.zjapl.common.result.XResult.ErrorCode;
import com.zjapl.common.util.StringUtil;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class UserServiceImpl implements IUserService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ISysUserDao userDao;

    @Autowired
    ISysUserRoleDao userRoleDao;

    /**
     * 增加或修改用户
     *
     * @param userVo 用户INFO
     * @param userId 创建人
     * @return
     */
    @Override
    public ResultEx saveOrEdit(SysUserVo userVo, Long userId, String orgCode) {
        ResultEx result = new ResultEx();
        if (userVo == null || userId == null) {
            logger.error("UserService.saveOrEdit error, param is Failed.");
            return result.makeFailedResult(ErrorCode.BAD_PARAMETER);
        }
        //判断用户是否已注册
        if (isRegister(userVo)) {
            logger.error("UserService.saveOrEdit error, the account has been registered.");
            return result.makeFailedResult(ErrorCode.BAD_PARAMETER, "该帐号已注册");
        }
        //增加或修改用户基本信息
        SysUser user = saveUserInfo(userVo, userId, orgCode);
        result.setData(user.getId());
        return result.makeSuccessResult();
    }

    /**
     * 判断用户是否已注册
     *
     * @param userVo
     * @return
     */
    private boolean isRegister(SysUserVo userVo) {
        Example ex = new Example(SysUser.class);
        Criteria cri = ex.createCriteria();
        cri.andEqualTo("phone", userVo.getUsername())
                .andNotEqualTo("status", EnableOrDisableCode.DELETED);
        if (userVo.getId() != null) {
            cri.andNotEqualTo("id", userVo.getId());
        }
        int flag = userDao.selectCountByExample(ex);
        if (flag > 0) {
            return true;
        }
        return false;
    }

    /**
     * 增加或修改用户基本信息
     *
     * @param userVo
     * @param userId
     * @param orgCode
     */
    private SysUser saveUserInfo(SysUserVo userVo, Long userId, String orgCode) {
        SysUser user = new SysUser();
        user.setUsername(userVo.getUsername());
        user.setRealName(userVo.getRealName());
        user.setEmail(userVo.getEmail());
        user.setPhone(userVo.getPhone());
        user.setUpdateDate(new Date());
        user.setUpdateUser(userId);
        if (userVo.getId() == null) {
            Md5Hash md5Hash = new Md5Hash("888888");
            user.setPassword(md5Hash.toHex());
            user.setStatus(EnableOrDisableCode.ENABLE);
            user.setCreateDate(userVo.getUpdateDate());
            user.setCreateUser(userId);
            user.setOrgCode(userVo.getOrgCode() != null ? userVo.getOrgCode() : orgCode);
            userDao.insertSelective(user);
        } else {
            user.setId(userVo.getId());
            userDao.updateByPrimaryKeySelective(user);
        }	
        return user;
    }

    /**
     * 根据id查询当前用户信息（有效用户）
     *
     * @param orgCode
     * @return
     */
    @Override
    public ObjectResultEx<SysUser> queryUserInfoById(Long userId,String orgCode) {
        SysUser sysUser = new SysUser();
        if (userId == null) {
            logger.error("UserService.queryUserInfoById error, userId is empty.");
            return new ObjectResultEx<SysUser>().makeSuccessResult(sysUser);
        }
        try {
        	sysUser.setId(userId);
        	sysUser.setOrgCode(orgCode);
        	sysUser.setStatus(EnableOrDisableCode.ENABLE);
            sysUser = userDao.selectOne(sysUser);
            if(sysUser != null){
            	sysUser.setPassword(null);
            }
            return new ObjectResultEx<SysUser>().makeSuccessResult(sysUser);
        } catch (Exception e) {
            logger.error("UserService.queryUserInfoById error.", e);
            return new ObjectResultEx<SysUser>().makeInternalErrorResult();
        }
    }

    /**
     * 修改用户状态
     *
     * @param ids     用户集合
     * @param status  状态
     * @param sysUser 修改人
     * @return
     */
    @Override
    public ResultEx editStatus(String ids, Short status, Long userId,String orgCode) {
        if (StringUtil.isEmpty(ids) || StringUtil.isEmpty(status)) {
            logger.error("UserService.editStatus error. ids or status is empty");
            return new ResultEx().makeInvalidParameterResult();
        }
        List<Long> idList = CommonUtil.idsToList(ids);
        try {
            SysUser user = new SysUser();
            Example ex = new Example(SysUser.class);
            ex.createCriteria().andIn("id", idList);
            user.setUpdateUser(userId);
            user.setUpdateDate(new Date());
            user.setStatus(status);
            userDao.updateByExampleSelective(user, ex);
        } catch (Exception e) {
            logger.error("UserService.editStatus error.", e);
            return new ObjectResultEx<SysUser>().makeInvalidParameterResult();
        }
        return new ResultEx().makeSuccessResult();
    }
    

    /**
     * 保存用户角色
     *
     * @param RoleInfo 角色信息
     * @param userId  修改人
     * @return
     */
    @Override
    public ResultEx saveUserRole(SysUserRoleVo param, Long userId) {
        if (StringUtil.isEmpty(param) || StringUtil.isEmpty(userId)) {
            logger.error("UserService.saveUserRole error. param is empty");
            return new ResultEx().makeInvalidParameterResult();
        }
        /*
         * 解析角色信息
         */
        Long user_id = param.getUserId();
        List<Long> roleIds = CommonUtil.idsToList(param.getIds());
        if (roleIds == null || roleIds.size() == 0) {
            logger.error("UserService.saveUserRole error. RoleIds is empty");
            return new ResultEx().makeInvalidParameterResult();
        }
        /*
         * 将用户之前的角色信息清空
         */
        SysUserRole record = new SysUserRole();
        record.setUserId(user_id);
        userRoleDao.delete(record);
        /*
         * 给用户重新配置角色信息
         */
        for (Long roleId : roleIds) {
            SysUserRole userRole = new SysUserRole();
            Date date = new Date();
            userRole.setRoleId(roleId);
            userRole.setUserId(user_id);
            userRole.setCreateDate(date);
            userRole.setUpdateDate(date);
            userRole.setCreateUser(userId);
            userRole.setUpdateUser(userId);
            try {
                userRoleDao.insertSelective(userRole);
            } catch (Exception e) {
                logger.error("UserService.saveUserRole userRoleDao error.", e);
                return new ResultEx().makeInvalidSessionTokenResult();
            }
        }
        return new ResultEx().makeSuccessResult();
    }

    /**
     * 用户密码重置
     *
     * @param ids    用户ID集合
     * @param userId 修改人
     * @return
     */
    @Override
    public ResultEx passwordReset(String ids, Long userId) {
        List<Long> idList = CommonUtil.idsToList(ids);
        if (idList.size() == 0) {
            return new ResultEx().makeInvalidParameterResult();
        }
        SysUser user = new SysUser();
        Md5Hash md5Hash = new Md5Hash("888888");
        user.setPassword(md5Hash.toHex());
        user.setUpdateDate(new Date());
        user.setUpdateUser(userId);
        Example ex = new Example(SysUser.class);
        ex.createCriteria().andIn("id", idList);
        userDao.updateByExampleSelective(user, ex);
        return new ResultEx().makeSuccessResult();
    }

    /**
     * 根据token查询用户信息
     *
     * @param token
     * @return
     */
    @Override
    public ObjectResultEx<SysUser> getSysUserByToken(String token) {
        SysUser record = new SysUser();
        /*
         * 状态核实一下
         */
        record.setStatus(EnableOrDisableCode.ENABLE);
        record.setToken(token);
        SysUser sysUser = userDao.selectOne(record);
        return new ObjectResultEx<SysUser>().makeSuccessResult(sysUser);
    }

    /**
     * 根据用户ID更新token,并清除掉除当前用户之外的用户token值相同的值
     *
     * @param userId 用户ID
     * @param token
     */
    @Override
    public ResultEx updateUserTokenById(Long userId, String token) {
        SysUser record = new SysUser();
        record.setId(userId);
        record.setToken(token);
        userDao.updateByPrimaryKeySelective(record);
        
        //将之前更新上去的token值清除掉
        Example example = new Example(SysUser.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("token", token);
        criteria.andNotEqualTo("id", userId);
        SysUser recordDel = new SysUser();
        recordDel.setToken("");
        userDao.updateByExampleSelective(recordDel, example);
        return new ResultEx().makeSuccessResult();
    }

    /**
     * 查询用户列表
     *
     * @param sysUserVo
     * @return
     */
    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public ObjectResultEx<PageInfo<SysUserVo>> queryUserList(SysUserQueryVo user, String orgCode) {
        Example ex = new Example(SysUser.class);
        Criteria cri = ex.createCriteria();
        cri.andNotEqualTo("status", EnableOrDisableCode.DELETED);
        /*
         * 无机构编码  => 查询所有人员
         * 有机构编码  => 查询机构下所有人员
         */
        if (!StringUtil.isEmpty(orgCode)) {
            cri.andEqualTo("orgCode", orgCode);
        }
        if (!StringUtil.isEmpty(user.getRealName())) {
            cri.andLike("realName", "%" + user.getRealName() + "%");
        }
        if (user.getAccountType() != null) {
            cri.andEqualTo("accountType", user.getAccountType());
        }
        PageHelper.startPage(user.getPageNum(), user.getPageSize(), "ID ASC");
        List<SysUserVo> result = new ArrayList<SysUserVo>();
        try {
            List<SysUser> sysUserList = userDao.selectByExample(ex);
            PageInfo pageInfo = new PageInfo(sysUserList);
            //解析查询用户结果集
            for (SysUser sysUser : sysUserList) {
            	 SysUserVo vo = new SysUserVo();
                 BeanUtils.copyPropertiesIgnoreNullValue(sysUser, vo);
                 result.add(vo);
			}
            pageInfo.setList(result);
            return new ObjectResultEx<PageInfo<SysUserVo>>().makeSuccessResult(pageInfo);
        } catch (Exception e) {
            logger.error("queryUserList error.", e);
            return new ObjectResultEx<PageInfo<SysUserVo>>().makeInternalErrorResult();
        }
    }

	@Override
	public ObjectResultEx<List<SysUser>> queryUserSelectList(String orgCode,String name) {
		 Example ex = new Example(SysUser.class);
	        Criteria cri = ex.createCriteria();
	        cri.andEqualTo("status", EnableOrDisableCode.ENABLE)
	        .andEqualTo("orgCode", orgCode);
	        if(StringUtil.noEmpty(name)){
	        	cri.andLike("realName", "%"+name+"%");
	        }
	        List<SysUser> sysUserList = userDao.selectByExample(ex);
	        for (SysUser sysUser : sysUserList) {
	        	sysUser.setPassword(null);
			}
		return new ObjectResultEx<List<SysUser>>().makeSuccessResult(sysUserList);
	}

    /**
     * 上传人员头像
     */
    @Override
    public ResultEx uploadUserPicture(SysUserVo user, Long userId) {
        if (StringUtil.isEmpty(user)) {
            logger.error("UserService.uploadUserPicture error, userPicture is empty.");
            return new ResultEx().makeInvalidParameterResult();
        }
        SysUser userInfo = new SysUser();
        userInfo.setId(user.getId());
        userInfo.setAvatarUrl(user.getAvatarUrl());
        userInfo.setUpdateUser(userId);
        userInfo.setUpdateDate(new Date());
        userDao.updateByPrimaryKeySelective(userInfo);
        return new ResultEx().makeSuccessResult();
    }

	@Override
	public ResultEx queryByPhone(String phone, String orgCode) {
        if (StringUtil.isEmpty(phone)) {
            logger.error("UserService.queryByPhone error. phone or orgCode is empty");
            return new ObjectResultEx<SysUser>().makeInvalidParameterResult();
        }
        try {
            SysUser sysUser = new SysUser();
            sysUser.setPhone(phone);
            sysUser.setStatus(EnableOrDisableCode.ENABLE);
            sysUser = userDao.selectOne(sysUser);
            return new ObjectResultEx<SysUser>().makeSuccessResult(sysUser);
        } catch (Exception e) {
            logger.error("UserService.queryByPhone error.", e);
            return new ObjectResultEx<SysUser>().makeInvalidParameterResult();
        }
	}

	@Override
	public ResultEx changePassword(String password, String confirmPwd,String phone) {
        if (StringUtil.isEmpty(password) || StringUtil.isEmpty(confirmPwd) ||phone == null) {
            return new ResultEx().makeInvalidParameterResult();
        }
        if(!password.equals(confirmPwd)){
        	return new ResultEx().makeFailedResult(ErrorCode.BAD_PARAMETER, "密码不一致，请重新输入");
        }
        Example example = new Example(SysUser.class);
        example.createCriteria().andEqualTo("phone", phone);
        SysUser record = new SysUser();
        record.setPassword(new Md5Hash(password).toHex());
        record.setUpdateDate(new Date());
        userDao.updateByExampleSelective(record, example);
        return new ResultEx().makeSuccessResult();
	}

	public ObjectResultEx<List<SysUser>> queryUserListByIds(String orgCode,String ids){
		if(StringUtil.isEmpty(ids)){
			 logger.error("queryUserListByIds error.ids="+ids);
			return new ObjectResultEx<List<SysUser>>().makeFailedResult(ErrorCode.BAD_PARAMETER, "参数ids为空");
		}else if(StringUtil.isEmpty(orgCode)){
			 logger.error("queryUserListByIds error.orgCode="+orgCode);
			return new ObjectResultEx<List<SysUser>>().makeFailedResult(ErrorCode.BAD_PARAMETER, "当前登录的用户机构编码为空");
		}
		
		Example example = new Example(SysUser.class);
        example.createCriteria().andIn("id", CommonUtil.idsToList(ids)).andEqualTo("orgCode", orgCode);
        List<SysUser> userList = userDao.selectByExample(example);
        
        List<SysUser> result = new ArrayList<SysUser>();
        for(SysUser sysUser:userList){
        	SysUser user = new SysUser();
        	user.setId(sysUser.getId());
        	user.setRealName(sysUser.getRealName());
        	user.setAvatarUrl(sysUser.getAvatarUrl());
        	result.add(sysUser);
        }
		return new ObjectResultEx<List<SysUser>>().makeSuccessResult(userList);
	}

}
