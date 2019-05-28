package com.example.yahaha.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.system.base.BaseController;
import com.example.yahaha.entity.vo.GameQueryVo;
import com.example.yahaha.entity.vo.GameVo;
import com.example.yahaha.service.IGameService;
import com.zjapl.common.result.ResultEx;

@RestController
@RequestMapping(value="/game")
public class GameController extends BaseController{
	
	@Autowired
	IGameService gameService;
	
	
	/**
	 * 游戏新增
	 * @return
	 */
	@PostMapping("/add")
	public ResultEx addOrEditResource(@RequestBody GameVo vo){
		return gameService.add(vo, getSysUser());
	}
	
	/**
	 * 游戏修改
	 * @return
	 */
	@PostMapping("/update")
	public ResultEx update(@RequestBody GameVo vo){
		return gameService.update(vo, getSysUser());
	}
	
	/**
	 * 游戏删除
	 * @return
	 */
	@GetMapping("/edit")
	public ResultEx editStatus(Long id){
		return gameService.edit(id, getSysUser());
	}
	
	/**
	 * 分页查询游戏List
	 * @return
	 */
	@PostMapping("/list")
	public ResultEx list(GameQueryVo query){
		return gameService.queryGameList(query, getSysUser());
	}
	
}
