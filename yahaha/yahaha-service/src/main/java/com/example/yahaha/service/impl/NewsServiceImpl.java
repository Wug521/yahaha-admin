package com.example.yahaha.service.impl;

import java.util.ArrayList;
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
import com.example.yahaha.dao.INewsDao;
import com.example.yahaha.entity.News;
import com.example.yahaha.entity.vo.NewsQueryVo;
import com.example.yahaha.entity.vo.NewsVo;
import com.example.yahaha.service.INewsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;
import com.zjapl.common.result.XResult.ErrorCode;
import com.zjapl.common.util.StringUtil;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * 新闻接口
 * @author liul
 *
 */
@Service
public class NewsServiceImpl implements INewsService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	INewsDao newsDao;

	@Override
	public ResultEx add(NewsVo vo, SysUser sysUser) {
		String checkResult = this.checkParams(vo);
		if (!StringUtil.eq(CommonDictionary.SUCCESS, checkResult)) {
			logger.error("NewsServiceImpl.add error. " + checkResult);
        	return new ResultEx().makeFailedResult(ErrorCode.BAD_PARAMETER, checkResult);
        }
		News info = new News();
		BeanUtils.copyPropertiesIgnoreNullValue(vo, info);//copy
		info.setIdsTag(addString(info.getIdsTag()));
		info.setIdsCategory(addString(info.getIdsCategory()));
		info.setCreateDate(new Date());
		info.setCreateUser(sysUser.getId());
		info.setUpdateDate(info.getCreateDate());
		info.setUpdateUser(sysUser.getId());
		info.setOrgCode(sysUser.getOrgCode());
		if(StringUtil.isEmpty(info.getStatus())){
			info.setStatus(EnableOrDisableCode.ENABLE);
		}
		newsDao.insertSelective(info);//添加新闻
		return new ResultEx().makeSuccessResult();
	}

	@Override
	public ResultEx update(NewsVo vo, SysUser sysUser) {
		String checkResult = this.checkParams(vo);
		if (!StringUtil.eq(CommonDictionary.SUCCESS, checkResult)) {
			logger.error("NewsServiceImpl.update error. " + checkResult);
        	return new ResultEx().makeFailedResult(ErrorCode.BAD_PARAMETER, checkResult);
        }
		News info = new News();
		BeanUtils.copyPropertiesIgnoreNullValue(vo, info);//copy
		info.setIdsTag(addString(info.getIdsTag()));
		info.setIdsCategory(addString(info.getIdsCategory()));
		info.setUpdateDate(info.getCreateDate());
		info.setUpdateUser(sysUser.getId());
		newsDao.updateByPrimaryKeySelective(info);//修改新闻
		return new ResultEx().makeSuccessResult();
	}

	@Override
	public ResultEx edit(Long id, SysUser sysUser) {
		if(StringUtil.isEmpty(id)){
			logger.error("NewsServiceImpl.edit error. id is empty");
			return new ObjectResultEx<NewsVo>().makeInvalidParameterResult();
		}
		News info = new News();
		info.setId(id);
		info.setOrgCode(sysUser.getOrgCode());
		info = newsDao.selectOne(info);//验证该记录isHas
		if(info != null){
			//设置状态为删除
			info.setStatus(EnableOrDisableCode.DELETED);
			newsDao.updateByPrimaryKeySelective(info);
		}else{
			return new ResultEx().makeFailedResult(ErrorCode.BAD_PARAMETER, "传入非法参数");
		}
		return new ResultEx().makeSuccessResult();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ObjectResultEx<PageInfo<NewsVo>> queryNewsList(NewsQueryVo query, SysUser sysUser) {
		if(StringUtil.isEmpty(query)){
			logger.error("NewsServiceImpl.queryNewsList error. query is empty");
			return new ObjectResultEx<PageInfo<NewsVo>>().makeInvalidParameterResult();
		}
		try {
			Example example = new Example(News.class);
			Criteria criteria = example.createCriteria();
			//查询条件
			if(StringUtil.noEmpty(query.getId())){//新闻ID
				criteria.andEqualTo("id", query.getId());
			}
			if(StringUtil.noEmpty(query.getTitle())){//新闻标题
				criteria.andLike("title", "%" + query.getTitle() + "%");
			}
			if(StringUtil.noEmpty(query.getIdsTag())){//标签id集合,以逗号隔开
				String[] idsTag = query.getIdsTag().split(",");
		        for (int i = 0; i < idsTag.length; i++) {
		        	criteria.andLike("idsTag", "%" + addString(idsTag[i]) + "%");
		        }
			}
			if(StringUtil.noEmpty(query.getIdsCategory())){//分类id集合,以逗号隔开
				String[] idsCategory = query.getIdsCategory().split(",");
		        for (int i = 0; i < idsCategory.length; i++) {
		        	criteria.andLike("idsCategory", "%" + addString(idsCategory[i]) + "%");
		        }
			}	
			if(StringUtil.noEmpty(query.getStatus())){//新闻状态
				criteria.andEqualTo("status", query.getStatus());
			}else{
				criteria.andEqualTo("status", EnableOrDisableCode.ENABLE);
			}
			criteria.andEqualTo("orgCode", sysUser.getOrgCode());
			PageHelper.startPage(query.getPageNum(),query.getPageSize(),"CREATE_DATE DESC");//创建时间倒序
			List<News> list = newsDao.selectByExample(example);//查询
			List<NewsVo> result = new ArrayList<NewsVo>();
			PageInfo pageInfo = new PageInfo(list);
			for (News opsAccept : list) {//查询结果解析,bean => vo
				NewsVo NewsVo = new NewsVo();
				//取出分类和标签集合前后字符串逗号deleteString
				opsAccept.setIdsTag(deleteString(opsAccept.getIdsTag()));
				opsAccept.setIdsCategory(deleteString(opsAccept.getIdsCategory()));
				BeanUtils.copyPropertiesIgnoreNullValue(opsAccept, NewsVo);//copy
				result.add(NewsVo);
			}
			pageInfo.setList(result);
			return new ObjectResultEx<PageInfo<NewsVo>>().makeSuccessResult(pageInfo);
		} catch (Exception e) {
			logger.error("NewsServiceImpl.queryNewsList error.",e);
			return new ObjectResultEx<PageInfo<NewsVo>>().makeInternalErrorResult();
		}
	}
	
	private String checkParams(NewsVo param) {
		if(StringUtil.isEmpty(param)){return "数据为空";}
		if(StringUtil.isEmpty(param.getTitle())){return "新闻标题为空";}
		if(StringUtil.isEmpty(param.getContent())){return "新闻内容为空";}
		return CommonDictionary.SUCCESS;
	}
	
	/**
	 * 字符串前后添加逗号
	 * @param String
	 * @return String
	 */
	private String addString(String value) {
		if(StringUtil.noEmpty(value)){value = ","+value+",";}
		return value;
	}

	/**
	 * 字符串前后逗号删除
	 * @param String
	 * @return String
	 */
	private String deleteString(String value) {
		if(StringUtil.noEmpty(value)){value = value.substring(1, value.length()-1);}
		return value;
	}

}
