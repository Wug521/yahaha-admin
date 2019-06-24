package com.example.yahaha.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.yahaha.entity.vo.CategoryQueryVo;
import com.example.yahaha.entity.vo.CategoryVo;
import com.example.yahaha.entity.vo.GameQueryVo;
import com.example.yahaha.entity.vo.NewsQueryVo;
import com.example.yahaha.service.ICategoryService;
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
	
	@Autowired
	ICategoryService categoryNodeService;
	
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
	
	
	/**
	 * 分页查询标签/分类List
	 * @return
	 */
	@PostMapping("/category/page")
	public ResultEx list(@RequestBody CategoryQueryVo query){
		return categoryNodeService.queryCategoryList(query, null);
	}
	
	/**
	 * 查询标签/分类下拉List
	 * @return
	 */
	@PostMapping("/category/list")
	public ResultEx list(@RequestBody CategoryVo query){
		return categoryNodeService.getCategoryList(query, null);
	}
	
}
