package com.example.system.edge.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.system.base.BaseController;
import com.example.system.edge.service.SysResourceService;
import com.example.system.entity.SysResource;
import com.example.system.vo.SysResourceVo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;
import com.zjapl.common.vo.TreeMenuVo;

/**
 * 
 * 文件名：SysResourceController.java
 * 日　期：2017年1月13日 上午9:44:51
 * 版　权：ZJAPL
 * 作　者：liss
 * 类说明：
 */
@Controller
@RequestMapping("/api/sysResource")
public class ApiSysResourceController extends BaseController{

	@Resource
	private SysResourceService sysResourceService;
	/**
	 * 获取授权的菜单列表
	 * @param sysUser
	 * @return
	 */
	@RequestMapping("/getAuthMenuList")
	@ResponseBody
	public ObjectResultEx<List<TreeMenuVo>> getAuthMenuList() {
		ObjectResultEx<List<TreeMenuVo>> resultEx = new ObjectResultEx<List<TreeMenuVo>>();
		return resultEx.makeSuccessResult(getMenuList());
	}
	
	/**
	 * 获取资源树
	 */
	@RequestMapping("/queryResourceTree")
	@ResponseBody
	public ResultEx queryResourceTree(){
		return sysResourceService.getResourcesMenuByUserId(getSysUser().getId());
	}
	
	/**
	 * 获取左侧资源树
	 */
	@RequestMapping("/getLeftResources")
	@ResponseBody
	public ResultEx getLeftResources(){
		return sysResourceService.getLeftResources();
	}
	
	/**
	 * 资源管理查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listResource")
	public ResultEx listResource(@Validated SysResource sysResource){
		return sysResourceService.queryResourceList(sysResource);
	}
	
	/**
	 * 资源管理查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addOrEdit")
	public ResultEx addOrEditResource(@Validated SysResource sysResource){
		return sysResourceService.addOrEditResource(sysResource, getSysUser());
	}
	
	/**
	 * 删除资源
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/dellistResource")
	public ResultEx dellistResource(@Validated SysResourceVo param){
		return sysResourceService.delResource(param , getSysUser());
	}
	
	/**
	 * 根据用户id获取资源信息列表
	 * @param sysUserId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getResourcesByUserId")
	public ResultEx getResourcesByUserId(@RequestParam("userId") Long id){
		return sysResourceService.getResourcesByUserId(id);
	}
	
	/**
	 * 根据角色查找资源list列表
	 * @param sysUserId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryResourceListByRoleId")
	public ResultEx queryResourceListByRoleId(@RequestParam("roleId") Long id){
		return sysResourceService.queryResourceListByRoleId(id);
	}
	
}
