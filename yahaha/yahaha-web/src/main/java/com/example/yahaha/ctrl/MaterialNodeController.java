package com.example.yahaha.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.system.base.BaseController;
import com.example.yahaha.entity.vo.MaterialNodeQueryVo;
import com.example.yahaha.entity.vo.MaterialNodeVo;
import com.example.yahaha.service.IMaterialNodeService;
import com.zjapl.common.result.ResultEx;

@RestController
@RequestMapping(value="/materialNode")
public class MaterialNodeController extends BaseController{

	@Autowired
	IMaterialNodeService materialNodeService;
	
	
	/**
	 * 素材节点新增
	 * @return
	 */
	@PostMapping("/add")
	public ResultEx addOrEditResource(MaterialNodeVo vo){
		return materialNodeService.add(vo, getSysUser());
	}
	
	/**
	 * 素材节点修改
	 * @return
	 */
	@PostMapping("/update")
	public ResultEx update(MaterialNodeVo vo){
		return materialNodeService.update(vo, getSysUser());
	}
	
	/**
	 * 素材节点删除
	 * @return
	 */
	@GetMapping("/edit")
	public ResultEx editStatus(Long id){
		return materialNodeService.edit(id, getSysUser());
	}
	
	/**
	 * 分页查询素材节点List
	 * @return
	 */
	@PostMapping("/list")
	public ResultEx list(MaterialNodeQueryVo query){
		return materialNodeService.queryMaterialNodeList(query, getSysUser());
	}
	
}
