package com.example.yahaha.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.system.dic.CommonDictionary;
import com.example.system.dic.CommonDictionary.EnableOrDisableCode;
import com.example.system.entity.SysUser;
import com.example.system.utils.BeanUtils;
import com.example.yahaha.dao.ICommentDao;
import com.example.yahaha.dao.ILikesDao;
import com.example.yahaha.entity.Comment;
import com.example.yahaha.entity.vo.CommentQueryVo;
import com.example.yahaha.entity.vo.CommentVo;
import com.example.yahaha.service.ICommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;
import com.zjapl.common.result.XResult.ErrorCode;
import com.zjapl.common.util.StringUtil;

/**
 * 新闻/游戏 评论接口
 * @author Mr.Wug
 *
 */
@Service
public class CommentServiceImpl implements ICommentService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ICommentDao commentDao;
	
	@Autowired
	ILikesDao likesDao;

	@Override
	public ResultEx add(CommentVo vo, SysUser sysUser) {
		String checkResult = this.checkParams(vo);
		if (!StringUtil.eq(CommonDictionary.SUCCESS, checkResult)) {
			logger.error("CommentServiceImpl.add error. " + checkResult);
        	return new ResultEx().makeFailedResult(ErrorCode.BAD_PARAMETER, checkResult);
        }
		Comment info = new Comment();
		BeanUtils.copyPropertiesIgnoreNullValue(vo, info);//copy
		info.setFromUid(sysUser.getId());
		info.setFromUname(sysUser.getRealName());
		info.setCreateDate(new Date());
		info.setCreateUser(sysUser.getId());
		info.setUpdateDate(info.getCreateDate());
		info.setUpdateUser(sysUser.getId());
		info.setOrgCode(sysUser.getOrgCode());
		info.setStatus(EnableOrDisableCode.ENABLE);
		commentDao.insertSelective(info);//添加节点
		return new ResultEx().makeSuccessResult();
	}

	@Override
	public ResultEx edit(Long id, SysUser sysUser) {
		if(StringUtil.isEmpty(id) && StringUtil.isEmpty(sysUser)){
			logger.error("CommentServiceImpl.edit error. id and sysUser is empty");
			return new ObjectResultEx<CommentVo>().makeInvalidParameterResult();
		}
		Comment info = new Comment();
		info.setId(id);
		info.setStatus(EnableOrDisableCode.DELETED);
		info.setUpdateDate(new Date());
		info.setUpdateUser(sysUser.getId());
		commentDao.updateByPrimaryKeySelective(info);
		return new ResultEx().makeSuccessResult();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ObjectResultEx<PageInfo<CommentVo>> queryCommentList(CommentQueryVo param, SysUser sysUser) {
		if(StringUtil.isEmpty(param.getTopicId()) && StringUtil.isEmpty(param.getSource())){
			logger.error("CollectServiceImpl.queryCollectList error. topicId and source is empty");
			return new ObjectResultEx<PageInfo<CommentVo>>().makeInvalidParameterResult();
		}
		try {
			PageHelper.startPage(param.getPageNum(), param.getPageSize());
			List<CommentVo> _list = commentDao.queryList(param.getTopicId(), param.getSource());
			PageInfo pageInfo = new PageInfo(_list);
			for (CommentVo comment : _list) {
				CommentVo vo = likesDao.likesNumByType(comment.getId());
				comment.setPraiseNum(vo.getPraiseNum());
				comment.setTrampleNum(vo.getTrampleNum());
				if(StringUtil.noEmpty(sysUser)){
					CommentVo likesByType = likesDao.likesByType(sysUser.getId(), comment.getId());
					vo.setPraise(likesByType.getPraise());
					vo.setTrample(likesByType.getTrample());
				}
			}
			return new ObjectResultEx<PageInfo<CommentVo>>().makeSuccessResult(pageInfo);
		} catch (Exception e) {
			logger.error("CollectServiceImpl.queryCollectList error.",e);
			return new ObjectResultEx<PageInfo<CommentVo>>().makeInternalErrorResult();
		}
	}
	
	/**
	 * 根据评论查询全部子节点Id
	 * @param mid
	 * @return
	 */
	/*public Set<Long> getCommentAndSonsById(Long... mid){
		if (mid == null || mid.length <= 0){
			return null;
		}
		Example example = new Example(Comment.class);
		Set<Long> ids = new HashSet<>();
		ids.remove(null);
		ids.addAll(Arrays.asList(mid));
		int idSize = ids.size();
		example = new Example(Comment.class);
		example.createCriteria().andIn("parentId", ids);
		List<Comment> list = commentDao.selectByExample(example);
		if (list != null && list.size() > 0){
			for(Comment tmp : list){
				ids.add(tmp.getId());
			}
		}
		ids.remove(null);
		if (ids.size() > idSize){
			ids.addAll(getCommentAndSonsById(ids.toArray(new Long[ids.size()])));
		}
		return ids;
	}*/
	
	private String checkParams(CommentVo param) {
		if(StringUtil.isEmpty(param)){return "数据为空";}
		if(StringUtil.isEmpty(param.getTopicId())){return "评论主题为空";}
		if(StringUtil.isEmpty(param.getSource())){return "评论类型为空";}
		if(StringUtil.isEmpty(param.getContent())){return "评论内容为空";}
		return CommonDictionary.SUCCESS;
	}

}
