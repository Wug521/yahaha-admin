package com.example.system.edge.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.system.base.BaseController;
import com.example.system.edge.service.IResourceService;
import com.example.system.entity.SysResource;
import com.example.system.vo.MenuVo;
import com.example.system.vo.SysResourceQueryVo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;

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
public class ResourceController extends BaseController{
	@Resource
	private IResourceService sysResourceService;

	@SuppressWarnings("rawtypes")
	@RequestMapping("/getAuthMenuList")
	@ResponseBody
	public ObjectResultEx<List<MenuVo>> getAuthMenuList() {
		ObjectResultEx<List<MenuVo>> resultEx = new ObjectResultEx<List<MenuVo>>();
		return resultEx.makeSuccessResult(getMenuList());
	}
	
	/**
	 * 获取资源树
	 */
	@RequestMapping("/queryResourceTree")
	@ResponseBody
	public ResultEx queryResourceTree(Short flag){
		return sysResourceService.queryAllTree(flag, isSystemUser() ? null : getUserIdForUser());
	}
	
	/**
	 * 获取资源树
	 */
	@RequestMapping("/queryRootResourceTree")
	@ResponseBody
	public ResultEx queryRootResourceTree(){
		return sysResourceService.queryRootTree();
	}
	
	/**
	 * 资源管理查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listResource")
	public ResultEx listResource(SysResourceQueryVo page){
		return sysResourceService.queryResourceListForId(page);
	}
	
	/**
	 * 资源管理新增或修改
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addOrEdit")
	@ValidPermission(permission = {"SYS_RESOURCE_ADD", "SYS_RESOURCE_EDIT"})
	public ResultEx addOrEditResource(@Validated SysResource sysResource){
		return sysResourceService.saveOrEdit(sysResource, getUserIdForUser());
	}
	
	/**
	 * 删除资源
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/dellistResource")
	@ValidPermission(permission = "SYS_RESOURCE_DEL")
	public ResultEx delResource(String ids, Short status){
		return sysResourceService.editStatus(ids, status, getUserIdForUser());
	}
	
	/**
	 * 根据用户id获取资源信息列表
	 * @param sysUserId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getResourcesByUserId")
	public ResultEx getResourcesByUserId(@RequestParam("userId") Long id){
		return sysResourceService.getResourcePermsByUserId(id);
	}
	
	/**
	 * 根据角色查找资源list列表
	 * @param sysUserId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryResourceListByRoleId")
	public ResultEx queryResourceListByRoleId(@RequestParam("roleId") Long id){
		return null;
	}
}
