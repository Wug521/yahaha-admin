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

@Controller
@RequestMapping(value="/sysResource")
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
	 * 获取ALL资源树
	 */
	@RequestMapping("/queryResourceTree")
	@ResponseBody
	public ResultEx queryResourceTree(Short fla){
		return sysResourceService.queryAllTree();
	}
	
	/**
	 * 获取父资源树
	 */
	@RequestMapping("/queryRootResourceTree")
	@ResponseBody
	public ResultEx queryRootResourceTree(){
		return sysResourceService.queryRootTree();
	}
	
	/**
	 * 分页查询资源List
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/list")
	public ResultEx listResource(SysResourceQueryVo page){
		return sysResourceService.queryResourceListForId(page);
	}
	
	/**
	 * 资源管理新增或修改
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addOrEdit")
	public ResultEx addOrEditResource(@Validated SysResource sysResource){
		return sysResourceService.saveOrEdit(sysResource, getUserIdForUser());
	}
	
	/**
	 * 删除资源
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delResource")
	public ResultEx delResource(String ids, Short status){
		return sysResourceService.editStatus(ids, status, getUserIdForUser());
	}
	
	/**
	 * 根据角色查找资源list列表
	 * @param sysUserId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getResourceListByRoleId")
	public ResultEx getResourceListByRoleId(@RequestParam("roleId") Long roleId){
		return sysResourceService.queryResourceByRoleId(roleId);
	}
}
