package com.example.system.edge.app.service;

import java.util.UUID;

import javax.annotation.Resource;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.example.system.dic.CommonDictionary.EnableOrDisableCode;
import com.example.system.edge.app.ctrl.AppBaseController;
import com.example.system.edge.service.SysUserService;
import com.example.system.entity.SysUser;
import com.zjapl.common.cache.TimeExpiredPoolCache;
import com.zjapl.common.cache.TimeExpiredPoolCache.DataRenewer;
import com.zjapl.common.framework.interceptor.AppAspectJService;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.XResult;
import com.zjapl.common.util.StringUtil;

/**
 * 
 * 文件名：AppBaseServiceImpl.java
 * 日　期：2017年3月23日 下午1:31:29
 * 版　权：ZJAPL
 * 作　者：liujg
 * 类说明：app端基础类
 */
@Service
public class AppBaseServiceImpl implements AppAspectJService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 超时时间
	 */
	private static Long overTime = 1000*60*60*24*7L;
	@Resource
	private SysUserService sysUserService;
	
	@Override
	public boolean isAppController(ProceedingJoinPoint point) {
		try {
			if (AppBaseController.class.isAssignableFrom(point.getTarget().getClass())){
				return true;
			}
		} catch (Exception e) {
			logger.error("isAppController error.", e);
		}
		return false;
	}

	@Override
	public boolean isTokenEnable(String token) {
		SysUser sysUser = getUserInfoByToken(token);
		if (sysUser == null || StringUtil.isEmpty(sysUser.getToken())){
			return false;
		} else {
			return true;
		}
	}
	/**
	 * 根据Token获取用户信息
	 * @param token
	 * @return
	 */
	public SysUser getUserInfoByToken(final String token){
		try {
			return TimeExpiredPoolCache.getInstance().get(token, overTime, new DataRenewer<SysUser>() {
				@Override
				public SysUser renewData() {
					//缓存没有 查询数据库验证
					SysUser sysUser = sysUserService.getSysUserByToken(token);
					logger.info("缓存前的userInfo:[{}]", JSON.toJSONString(sysUser));
					if(sysUser != null && sysUser.getRecentlyTime().getTime() - System.currentTimeMillis() < overTime){
						//计算是否超时,没有超时，更新缓存
						sysUser.setPassword(null);
						return sysUser;
					}
					return null;
				}
			});
		} catch (Exception e) {
			logger.error("getUserInfoByToken execute error.", e);
		}
		return null;
	}
	private String getToken(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	/**
	 * 用户登录
	 * */
	public ObjectResultEx<SysUser> userLogin(String loginName,String password) {

		Md5Hash md5Hash = new Md5Hash(password);
		password = md5Hash.toHex();
		final SysUser sysUser = sysUserService.getUserByUsername(loginName);
		if(sysUser == null || sysUser.getStatus() != EnableOrDisableCode.ENABLE){
			//用户不存在
			return new ObjectResultEx<SysUser>().makeFailedResult(XResult.ErrorCode.USER_NOT_EXISTING);
		}else if(sysUser.getPassword().equals(password)){
			//登录成功,生成token
			if(!StringUtil.isEmpty(sysUser.getToken())){
				TimeExpiredPoolCache.getInstance().remove(sysUser.getToken());
			}
			try {
				final String token = getToken();
				sysUserService.updateUserTokenById(sysUser.getId(), token);
				sysUser.setToken(token);
				sysUser.setPassword(null);
				//当前sysUser没有取到org，舍弃，不放缓存
				/*SysUser sysUserTmp = TimeExpiredPoolCache.getInstance().get(token,overTime,new DataRenewer<SysUser>(){
					@Override
					public SysUser renewData() {
						//更新登录时间
						sysUserService.updateUserToken(sysUser.getId(),token);
						sysUser.setToken(token);
						sysUser.setPassword(null);
						return sysUser;
					}
				});*/
				return new ObjectResultEx<SysUser>().makeSuccessResult(sysUser);
			} catch (Exception e) {
				e.printStackTrace();
				return new ObjectResultEx<SysUser>().makeFailedResult(XResult.ErrorCode.INTERNAL_ERROR);
			}
		}else{
			//密码错误
			return new ObjectResultEx<SysUser>().makeFailedResult(XResult.ErrorCode.USERNAME_OR_PASSWORD_ERROR);
		}

	}

	/**
	 * 用户退出
	 * */
	public boolean logoutToken(String token){

		try {
			SysUser sysUser = TimeExpiredPoolCache.getInstance().get(token);
			if(sysUser == null){

			}else{
				TimeExpiredPoolCache.getInstance().remove(token);
			}
			//退出token登录置空
			sysUserService.logoutToken(token);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}

