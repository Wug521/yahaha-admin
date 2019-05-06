package com.example.system.shiro;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.system.dic.CommonDictionary.EnableOrDisableCode;
import com.example.system.edge.service.SysDeptService;
import com.example.system.edge.service.SysResourceService;
import com.example.system.edge.service.SysRoleService;
import com.example.system.edge.service.SysUserService;
import com.example.system.entity.SysDept;
import com.example.system.entity.SysRole;
import com.example.system.entity.SysUser;
import com.zjapl.common.vo.TreeMenuVo;

/**
 * 
 * 文件名：ShiroUserRealm.java
 * 版本号：V 1.0
 * 日　期：2016年5月24日
 * 版　权：ZJAPL
 * 作　者：wuzy
 * 类说明：
 */
public class ShiroUserRealm extends AuthorizingRealm {
    Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private SysUserService sysUserService;
	@Resource
	private SysDeptService sysDeptService;
	@Resource
	private SysRoleService sysRoleService;
	@Resource
	private SysResourceService sysResourceService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		SimpleAuthorizationInfo authorinfo = new SimpleAuthorizationInfo();
		ShiroPrincipal shiroPrincipal = principal.oneByType(ShiroPrincipal.class);
		if(shiroPrincipal == null){
			throw new NullPointerException("用户Principals找不到");
		}
		List<SysRole> roles = sysRoleService.getRolesByUserId(shiroPrincipal.getId());
		List<TreeMenuVo> treeMenuVos = sysResourceService.getResourcesMenuByUserId(shiroPrincipal.getId()).getData();
		addRoles(authorinfo, shiroPrincipal, roles);
		addResources(authorinfo, shiroPrincipal, treeMenuVos);
		return authorinfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenToken;
		String username = token.getUsername();
		SysUser sysUser =  sysUserService.getUserByUsername(username);
		if(sysUser != null){
			 if (sysUser.getStatus() != EnableOrDisableCode.ENABLE) {  
				throw new DisabledAccountException("账户不可用");  
	          } 
		} else {
			throw new IncorrectCredentialsException();
		}
		List<SysDept> sysDepts = sysDeptService.getSysDeptByUserId(sysUser.getId());
		return new SimpleAuthenticationInfo(new ShiroPrincipal(sysUser,sysDepts), sysUser.getPassword(), getName());
	}
    /**
     * 添加角色信息
     * @param authorinfo
     * @param shiroPrincipal
     * @param roles
     */
	public void addRoles(SimpleAuthorizationInfo authorinfo,ShiroPrincipal shiroPrincipal,List<SysRole> roles){
		List<String> list = new ArrayList<String>();
		for(SysRole sysRole : roles){
			String role;
			try {
				role = (String)PropertyUtils.getProperty(sysRole, "name");
				if(role == null || "".equals(role))
					continue;
				list.add(role);
			} catch (IllegalAccessException e) {
				logger.error("addRoles IllegalAccessException.", e);
			} catch (InvocationTargetException e) {
				logger.error("addRoles IllegalAccessException.", e);
			} catch (NoSuchMethodException e) {
				logger.error("addRoles IllegalAccessException.", e);
			}
		}
		if(!list.isEmpty()){
			shiroPrincipal.setRoleList(list);
			authorinfo.addRoles(list);
		}
		
	}
	/**
	 * 添加资源信息
	 * @param authorinfo
	 * @param shiroPrincipal
	 * @param resources
	 */
    public void addResources(SimpleAuthorizationInfo authorinfo, ShiroPrincipal shiroPrincipal, List<TreeMenuVo> treeMenuVos){
		List<String> list = new ArrayList<String>();
		for(TreeMenuVo treeMenuVo : treeMenuVos){
			String permission;
			try {
				permission = (String)PropertyUtils.getProperty(treeMenuVo, "permission");
				if(permission == null || "".equals(permission))
					continue;
				list.add(permission);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		}
		List<String> perms = getPerms(list,"perms\\[(.*?)\\]");
		if(!perms.isEmpty()){
			shiroPrincipal.setAuthorizationList(perms);
			authorinfo.addStringPermissions(perms);
		}
	}
    public List<String> getPerms(List<String> perms,String regex){
    	List<String> list = new ArrayList<String>();
    	
    	Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(StringUtils.join(perms, ","));
		while(matcher.find()){
			list.add(matcher.group(1));
		}
		return list;
    }
	
}
