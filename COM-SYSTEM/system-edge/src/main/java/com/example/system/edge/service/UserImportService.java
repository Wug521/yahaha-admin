package com.example.system.edge.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import tk.mybatis.mapper.entity.Example;

import com.example.system.dao.ISysDeptDao;
import com.example.system.dao.ISysRoleDao;
import com.example.system.dao.ISysUserDao;
import com.example.system.dao.ISysUserDeptDao;
import com.example.system.dao.ISysUserRoleDao;
import com.example.system.entity.SysDept;
import com.example.system.entity.SysRole;
import com.example.system.entity.SysUser;
import com.example.system.entity.SysUserDept;
import com.example.system.entity.SysUserRole;
import com.example.system.vo.SysUserVo;
import com.zjapl.common.Constants;
import com.zjapl.common.result.ResultEx;
import com.zjapl.common.util.ExcelUtil;
import com.zjapl.common.util.StringUtil;

/**
 * 
 * @author Administrator
 *
 */

@Transactional
@Service
public class UserImportService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private ISysUserRoleDao sysUserRoleDao;
	@Resource
	private ISysUserDao sysUserDao;
	@Resource
	private ISysUserDeptDao sysUserDeptDao;
	@Resource
	private ISysRoleDao roleDao;
	@Resource
	private ISysDeptDao deptDao;

	public ResultEx upLoadFile(HttpServletRequest request, SysUser sysUser) {

		try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			// 根据请求端参数名获得图片OR文件
			Map<String, List<MultipartFile>> fileMap = multipartRequest
					.getMultiFileMap();
			if (fileMap == null || fileMap.isEmpty()) {
				return new ResultEx().makeInvalidParameterResult();
			}
			StringBuffer sbf = new StringBuffer();
			List<SysUserVo> sysUserList = new ArrayList<SysUserVo>();
			for (Map.Entry<String, List<MultipartFile>> entry : fileMap.entrySet()) {
				if (StringUtil.isEmpty(entry.getKey())|| entry.getValue() == null|| entry.getValue().isEmpty()) {
					continue;
				}
				for (MultipartFile mFile : entry.getValue()) {
					CommonsMultipartFile cf = (CommonsMultipartFile) mFile; // 这个multipartFile是MultipartFile的
					DiskFileItem fi = (DiskFileItem) cf.getFileItem();
					File file = fi.getStoreLocation();
					List<?> list = ExcelUtil.getDataFromExcel(file);
					// 记录添加的用户名
					List<String> userNames = new Vector<String>();
					for (int i = 0; i < list.size(); i++) {
						Object[] s = (Object[]) (list.get(i));
						String realName = String.valueOf(s[0]);
						if ("null".equals(realName)){
							realName = null;
						}
						String userName = String.valueOf(s[1]);
						if ("null".equals(userName)){
							userName = null;
						}
						String phone = String.valueOf(s[2]);
						if ("null".equals(phone)){
							phone = null;
						}
						String email = String.valueOf(s[3]);
						if ("null".equals(email)){
							email = null;
						}
						String idCard = String.valueOf(s[4]);
						if ("null".equals(idCard)){
							idCard = null;
						}
						String deptNames = String.valueOf(s[5]);
						if ("null".equals(deptNames)){
							deptNames = null;
						}
						String roleNames = String.valueOf(s[6]);
						if ("null".equals(roleNames)){
							roleNames = null;
						}
						String orgCode = String.valueOf(s[7]);
						if (StringUtil.isEmpty(realName)||StringUtil.isEmpty(userName)|| StringUtil.isEmpty(deptNames)
								|| StringUtil.isEmpty(roleNames)|| StringUtil.isEmpty(orgCode)) {
							sbf.append("第" + (i + 2)+ "行,用户真实姓名，登陆名，机构名称，角色名称，机构名称均不能为空");
							continue;
						}
						// 判断用户名是否存在
						if (queryUsesIdByUsersName(userName) > 0) {
							sbf.append(Constants.userName + userName);
							continue;
						} else {
							// 表格中带有重复用户名
							if (userNames.contains(userName)) {
								sbf.append(Constants.userNameRepeat + userName);
								continue;
							} else {
								userNames.add(userName);
							}
						}
						// sysUserVo
						SysUserVo sysUserVo = new SysUserVo();
						sysUserVo.setRealName(realName.trim());
						sysUserVo.setUsername(userName.trim()); // 登录账号
						sysUserVo.setPhone(phone.trim()); // 手机
						sysUserVo.setEmail(email.trim()); // 邮箱
						sysUserVo.setIdCard(idCard.trim()); // 人员证件号码
						sysUserVo.setDeptName(deptNames.trim());
						sysUserVo.setRoleIdNames(roleNames.trim());
						sysUserVo.setOrgCode(orgCode.trim());
						sysUserList.add(sysUserVo);
					}
				}
			}
			batchUserImport(sysUserList, sysUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResultEx().makeSuccessResult();
	}

	public ResultEx batchUserImport(List<SysUserVo> list, SysUser sysUser) {
		try {
			for (SysUserVo sysUserVo : list) {
				// 用户
				SysUser user = new SysUser();
				user.setUsername(sysUserVo.getUsername());
				user.setPassword("21218cca77804d2ba1922c33e0151105"); // 初始密码
				user.setRealName(sysUserVo.getRealName());
				user.setPhone(sysUserVo.getPhone());
				user.setEmail(sysUserVo.getEmail());
				user.setIdCard(sysUserVo.getIdCard());
				user.setOrgCode(sysUserVo.getOrgCode());
				user.setCreateDate(new Date());
				user.setUpdateDate(new Date());
				user.setCreateUserId(sysUser.getId());
				user.setUpdateUserId(sysUser.getId());
				sysUserDao.insertSelective(user);
				// 用户角色
				String[] roleNames = sysUserVo.getRoleIdNames().split(",");
				// 一个用户多个角色
				if (roleNames.length > 1) {
					for (String roleName : roleNames) {
						SysUserRole userRole = new SysUserRole();
						userRole.setUserId(user.getId());
						userRole.setRoleId(queryRoleIdByRoleName(roleName));
						userRole.setCreateDate(new Date());
						userRole.setUpdateDate(new Date());
						userRole.setCreateUserId(sysUser.getId());
						userRole.setUpdateUserId(sysUser.getId());
						sysUserRoleDao.insertSelective(userRole);
					}
				} else {
					SysUserRole userRole = new SysUserRole();
					userRole.setUserId(user.getId());
					userRole.setRoleId(queryRoleIdByRoleName(roleNames[0]));
					userRole.setCreateDate(new Date());
					userRole.setUpdateDate(new Date());
					userRole.setCreateUserId(sysUser.getId());
					userRole.setUpdateUserId(sysUser.getId());
					sysUserRoleDao.insertSelective(userRole);
				}
				// 用户部门
				String[] deptNames = sysUserVo.getDeptName().split(",");
				// 一个用户多个部门
				if (deptNames.length > 1) {
					for (String deptName : deptNames) {
						SysUserDept userDept = new SysUserDept();
						userDept.setCreateDate(new Date());
						userDept.setUpdateDate(new Date());
						userDept.setCreateUserId(sysUser.getId());
						userDept.setUpdateUserId(sysUser.getId());
						userDept.setUserId(user.getId());
						userDept.setDeptId(queryDeptIdByDeptName(deptName));
						sysUserDeptDao.insertSelective(userDept);
					}
				} else {
					SysUserDept userDept = new SysUserDept();
					userDept.setCreateDate(new Date());
					userDept.setUpdateDate(new Date());
					userDept.setCreateUserId(sysUser.getId());
					userDept.setUpdateUserId(sysUser.getId());
					userDept.setUserId(user.getId());
					userDept.setDeptId(queryDeptIdByDeptName(deptNames[0]));
					sysUserDeptDao.insertSelective(userDept);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResultEx().makeSuccessResult();
	}

	// 根据部门名称获取部门ID
	private Long queryDeptIdByDeptName(String name) {
		if (!StringUtil.isEmpty(name)) {
			Example example = new Example(SysDept.class);
			example.createCriteria().andEqualTo("deptName", name.trim());
			List<SysDept> depts = deptDao.selectByExample(example);
			if (!StringUtil.isEmpty(depts) && depts.size() > 0) {
				Long id = depts.get(0).getId();
				return id;
			}
		}
		return 0L;
	}

	// 根据角色名称获取角色ID
	private Long queryRoleIdByRoleName(String name) {
		if (!StringUtil.isEmpty(name)) {
			Example example = new Example(SysRole.class);
			example.createCriteria().andEqualTo("name", name.trim());
			List<SysRole> roles = roleDao.selectByExample(example);
			if (!StringUtil.isEmpty(roles) && roles.size() > 0) {
				Long id = roles.get(0).getId();
				return id;
			}
		}
		return 0L;
	}

	// 根据角色名称获取角色ID
	public Long queryUsesIdByUsersName(String name) {
		if (!StringUtil.isEmpty(name)) {
			Example example = new Example(SysUser.class);
			example.createCriteria().andEqualTo("username", name.trim());
			List<SysUser> users = sysUserDao.selectByExample(example);
			if (!StringUtil.isEmpty(users) && users.size() > 0) {
				Long id = users.get(0).getId();
				return id;
			}
		}
		return 0L;
	}

}
