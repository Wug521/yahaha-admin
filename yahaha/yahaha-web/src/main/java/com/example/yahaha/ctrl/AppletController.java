package com.example.yahaha.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.yahaha.entity.vo.GameQueryVo;
import com.example.yahaha.entity.vo.NewsQueryVo;
import com.example.yahaha.service.IGameService;
import com.example.yahaha.service.INewsService;
import com.zjapl.common.result.ResultEx;

@RestController
@RequestMapping(value="/public")
public class AppletController{
	
	@Autowired
	INewsService newsService;

	@Autowired
	IGameService gameService;	
	
	/**
	 * 分页查询新闻List
	 * @return
	 */
	@PostMapping("/queryNewsListFromApplet")
	public ResultEx queryNewsListFromApplet(@RequestBody NewsQueryVo query){
		return newsService.queryNewsListFromApplet(query);
	}
	
	/**
	 * 分页查询游戏List
	 * @return
	 */
	@PostMapping("/queryGameListFromApplet")
	public ResultEx queryGameListFromApplet(@RequestBody GameQueryVo query){
		return gameService.queryGameListFromApplet(query);
	}
		
}
