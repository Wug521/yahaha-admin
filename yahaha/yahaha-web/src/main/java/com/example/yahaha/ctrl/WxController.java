package com.example.yahaha.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.system.base.BaseController;
import com.example.yahaha.entity.vo.CommentQueryVo;
import com.example.yahaha.entity.vo.LikesVo;
import com.example.yahaha.service.ICommentService;
import com.example.yahaha.service.ILikesService;
import com.zjapl.common.result.ResultEx;

@RestController
@RequestMapping(value="/wx")
public class WxController extends BaseController{
	
	@Autowired
	ILikesService likesService;
	
	@Autowired
	ICommentService commentService;
	
	/**
	 * 点赞
	 * @return
	 */
	@PostMapping("/likes/add")
	public ResultEx addLikes(@RequestBody LikesVo vo){
		return likesService.add(vo, getSysUser());
	}
	
	/**
	 * 根据主题ID查询评论树
	 * @return
	 */
	@PostMapping("/comment/list")
	public ResultEx list(@RequestBody CommentQueryVo param){
		return commentService.queryCommentList(param, getSysUser());
	}

}
