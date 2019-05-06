package com.example.system.edge.ctrl;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.system.base.BaseController;
import com.example.system.edge.service.SysDeptService;
import com.example.system.vo.QuerySysDeptVo;
import com.example.system.vo.SysDeptVo;
import com.zjapl.common.result.ResultEx;

/**
 * 文件名：SysDeptController.java
 * 日　期：2017年1月16日
 * 版　权：ZJAPL
 * 作　者：wug
 * 类说明：
 */
@Controller
@RequestMapping("/api/sysDept")
public class ApiSysDeptController extends BaseController{
	
	@Resource
	private SysDeptService sysDeptService;
	
	/**
	 * 获取部门列表
	 * @param sysDeptVo
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public ResultEx querySysDeptList(QuerySysDeptVo sysDeptVo){
		return sysDeptService.querySysDeptList(sysDeptVo,getSysUser());
	}
	
	/**
	 * 新增或修改部门
	 * @param sysDeptVo
	 * @return
	 */
	@RequestMapping("/saveOrEdit")
	@ResponseBody
	public ResultEx saveOrEditDept(SysDeptVo sysDeptVo){
		return sysDeptService.saveOrEditDept(sysDeptVo,getSysUser());
	}
	
	/**
	 * 修改部门状态
	 * @param ids
	 * @param status
	 * @return
	 */
	@RequestMapping("/editDeptStatus")
	@ResponseBody
	public ResultEx editDeptStatus(@RequestParam("ids")String ids,@RequestParam("status")Short status){
		return sysDeptService.editDeptStatus(ids, status, getSysUser());
	}
	
	/**
	 * 部门树
	 * @return
	 */
	@RequestMapping("/findAllDeptsForTree")
	@ResponseBody
	public ResultEx findAllOrg(){
		return sysDeptService.queryAllDeptsTree(getSysUser());
	}
	
	/**
	 * 部门人员树
	 * @return
	 */
	@RequestMapping("/findAllDeptUsers")
	@ResponseBody
	public ResultEx queryAllDeptUsers(){
		return sysDeptService.queryAllDeptUsers(getSysUser());
	}
	/**
	 * 部门人员树
	 * @return
	 */
	@RequestMapping("/findDeptUsers")
	@ResponseBody
	public ResultEx findDeptUsers(@RequestParam("deptType")Short deptType,@RequestParam("loginMode")Short loginMode){
		return sysDeptService.queryDeptUsers(deptType,loginMode,getSysUser());
	}
	
	/**
	 * 部门类型人员树
	 * @return
	 */
	@RequestMapping("/findDeptUser")
	@ResponseBody
	public ResultEx findDeptUser(@RequestParam("deptType")Short deptType){
		return sysDeptService.queryDeptUser(deptType ,getSysUser());
	}
}
