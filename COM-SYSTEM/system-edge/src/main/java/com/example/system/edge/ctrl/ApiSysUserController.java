package com.example.system.edge.ctrl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.system.base.BaseController;
import com.example.system.edge.service.SysRoleService;
import com.example.system.edge.service.SysUserService;
import com.example.system.vo.ShowSysUserVo;
import com.example.system.vo.SysUserVo;
import com.zjapl.common.result.ResultEx;
import com.zjapl.common.util.DateUtil;

/**
 * 
 * 文件名：SysUserController.java
 * 日　期：2017年1月13日 上午9:37:59
 * 版　权：ZJAPL
 * 作　者：liss
 * 类说明：
 */
@Controller
@RequestMapping("/api/sysUser")
public class ApiSysUserController extends BaseController{
	
	@Resource
	private SysUserService sysUserService;
	
	@Resource
	private SysRoleService sysRoleService;
	
	@ResponseBody
	@RequestMapping(value="/sysdate")
	public String queryDate(){
		return DateUtil.format(new Date(), DateUtil.FORMAT_LONG);
	}

	/**
	 * 查询用户列表
	 * @param sysUserVo
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public ResultEx queryUserList(@Validated SysUserVo sysUserVo){
		return sysUserService.queryUserList(sysUserVo,getSysUser());
	}
	
	/**
	 * 添加或修改用户信息
	 * @param sysUserVo
	 * @return
	 */
	@RequestMapping("/addOrEditSysUser")
	@ResponseBody
	public ResultEx addOrEditSysUser(@Validated SysUserVo sysUserVo){
		return sysUserService.addOrEditSysUser(sysUserVo,getSysUser());
	}
	
	/**
	 * 根据用户ID修改账号状态
	 * @param id
	 * @param hangleCode
	 * @return
	 */
	@RequestMapping("/updateSysUserStatusById")
	@ResponseBody
	public ResultEx updateSysUserStatusById(@Validated ShowSysUserVo param){
		return sysUserService.updateSysUserStatusById(param, getSysUser());
	}
	
	/**
	 * 根据用户ID初始化密码
	 * @param id
	 * @return
	 */
	@RequestMapping("/passwordInitById")
	@ResponseBody
	public ResultEx passwordInitById(@RequestParam("ids")String ids){
		return sysUserService.passwordInitById(ids);
	}
	
	/**
	 * 添加或修改用户信息
	 * @param sysUserVo
	 * @return
	 */
	@RequestMapping("/updateCurrentPassword")
	@ResponseBody
	public ResultEx updateCurrentPassword(@Validated ShowSysUserVo param){
//		String result = sysUserService.updateCurrentPassword(param, getSysUser());
		return sysUserService.updateCurrentPassword(param, getSysUser());
	}
}
