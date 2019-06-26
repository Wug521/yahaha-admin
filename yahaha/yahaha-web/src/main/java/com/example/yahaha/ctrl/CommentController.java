package com.example.yahaha.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.system.base.BaseController;
import com.example.yahaha.entity.vo.CommentVo;
import com.example.yahaha.service.ICommentService;
import com.zjapl.common.result.ResultEx;

@RestController
@RequestMapping(value="/comment")
public class CommentController extends BaseController{
	
	@Autowired
	ICommentService commentService;
	
	/**
	 * 新增评论
	 * @return
	 */
	@PostMapping("/add")
	public ResultEx addComment(@RequestBody CommentVo vo){
		return commentService.add(vo, getSysUser());
	}
	
	/**
	 * 删除评论
	 * @return
	 */
	@GetMapping("/del")
	public ResultEx delComment( Long id){
		return commentService.edit(id, getSysUser());
	}
}
