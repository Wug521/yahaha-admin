package com.example.yahaha.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.system.base.BaseController;
import com.example.yahaha.entity.vo.MaterialNodeFileQueryVo;
import com.example.yahaha.entity.vo.MaterialNodeFileVo;
import com.example.yahaha.service.IMaterialNodeFileService;
import com.zjapl.common.result.ResultEx;

@RestController
@RequestMapping(value="/materialNodeFile")
public class MaterialNodeFileController extends BaseController{

	@Autowired
	IMaterialNodeFileService materialNodeFileService;
	
	/**
	 * 素材文件新增
	 * @return
	 */
	@PostMapping("/add")
	public ResultEx add(@RequestBody MaterialNodeFileVo vo){
		return materialNodeFileService.add(vo, getSysUser());
	}
	
	/**
	 * 素材文件修改
	 * @return
	 */
	@PostMapping("/update")
	public ResultEx update(@RequestBody MaterialNodeFileVo vo){
		return materialNodeFileService.update(vo, getSysUser());
	}
	
	/**
	 * 素材文件删除
	 * @return
	 */
	@GetMapping("/del")
	public ResultEx editStatus(String ids){
		return materialNodeFileService.edit(ids, getSysUser());
	}
	
	/**
	 * 分页查询素材文件List
	 * @return
	 */
	@PostMapping("/list")
	public ResultEx list(@RequestBody MaterialNodeFileQueryVo query){
		return materialNodeFileService.queryMaterialNodeFileList(query, getSysUser());
	}
	
}
