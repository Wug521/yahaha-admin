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
import com.example.system.utils.CommonUtil;
import com.example.yahaha.dao.ICategoryDao;
import com.example.yahaha.entity.Category;
import com.example.yahaha.entity.vo.CategoryQueryVo;
import com.example.yahaha.entity.vo.CategoryVo;
import com.example.yahaha.entity.vo.MaterialNodeVo;
import com.example.yahaha.service.ICategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;
import com.zjapl.common.result.XResult.ErrorCode;
import com.zjapl.common.util.StringUtil;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * 标签/分类接口
 * @author Mr.Wug
 *
 */
@Service
public class CategoryServiceImpl implements ICategoryService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ICategoryDao categoryDao;

	@Override
	public ResultEx add(CategoryVo vo, SysUser sysUser) {
		String checkResult = this.checkParams(vo);
		if (!StringUtil.eq(CommonDictionary.SUCCESS, checkResult)) {
			logger.error("CategoryServiceImpl.add error. " + checkResult);
        	return new ResultEx().makeFailedResult(ErrorCode.BAD_PARAMETER, checkResult);
        }
		Category info = new Category();
		BeanUtils.copyPropertiesIgnoreNullValue(vo, info);//copy
		info.setCreateDate(new Date());
		info.setCreateUser(sysUser.getId());
		info.setUpdateDate(info.getCreateDate());
		info.setUpdateUser(sysUser.getId());
		info.setOrgCode(sysUser.getOrgCode());
		info.setStatus(EnableOrDisableCode.ENABLE);
		categoryDao.insertSelective(info);//添加节点
		return new ResultEx().makeSuccessResult();
	}

	@Override
	public ResultEx update(CategoryVo vo, SysUser sysUser) {
		String checkResult = this.checkParams(vo);
		if (!StringUtil.eq(CommonDictionary.SUCCESS, checkResult)) {
			logger.error("CategoryServiceImpl.update error. " + checkResult);
        	return new ResultEx().makeFailedResult(ErrorCode.BAD_PARAMETER, checkResult);
        }
		Category info = new Category();
		BeanUtils.copyPropertiesIgnoreNullValue(vo, info);//copy
		info.setUpdateDate(info.getCreateDate());
		info.setUpdateUser(sysUser.getId());
		categoryDao.updateByPrimaryKeySelective(info);//添加节点
		return new ResultEx().makeSuccessResult();
	}

	@Override
	public ResultEx edit(String ids, SysUser sysUser) {
		if(StringUtil.isEmpty(ids)){
			logger.error("MaterialNodeServiceImpl.edit error. id is empty");
			return new ObjectResultEx<MaterialNodeVo>().makeInvalidParameterResult();
		}
		List<Long> idsToList = CommonUtil.idsToList(ids);
		Example example = new Example(Category.class);
		example.createCriteria().andIn("id", idsToList)
								.andEqualTo("orgCode", sysUser.getOrgCode());
		Category info = new Category();
		info.setStatus(EnableOrDisableCode.DELETED);
		info.setUpdateDate(new Date());
		info.setUpdateUser(sysUser.getId());
		categoryDao.updateByExampleSelective(info, example);
		return new ResultEx().makeSuccessResult();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ObjectResultEx<PageInfo<CategoryVo>> queryCategoryList(CategoryQueryVo query, SysUser sysUser) {
		if(StringUtil.isEmpty(query)){
			logger.error("CategoryServiceImpl.queryCategoryList error. query is empty");
			return new ObjectResultEx<PageInfo<CategoryVo>>().makeInvalidParameterResult();
		}
		try {
			Example example = new Example(Category.class);
			Criteria criteria = example.createCriteria();
			//查询条件
			if(StringUtil.noEmpty(query.getName())){//节点名称
				criteria.andLike("name", "%" + query.getName() + "%");
			}
			if(StringUtil.noEmpty(query.getType())){//节点类型
				criteria.andEqualTo("type", query.getType());
			}
			if(StringUtil.noEmpty(query.getScope())){//域
				criteria.andEqualTo("scope", query.getScope());
			}
			criteria.andEqualTo("status", EnableOrDisableCode.ENABLE);
			if(StringUtil.noEmpty(sysUser)){
				criteria.andEqualTo("orgCode", sysUser.getOrgCode());
			}
			PageHelper.startPage(query.getPageNum(),query.getPageSize(),"SORT ASC");//排序号升序
			List<Category> list = categoryDao.selectByExample(example);//查询
			List<CategoryVo> result = new ArrayList<CategoryVo>();
			PageInfo pageInfo = new PageInfo(list);
			for (Category opsAccept : list) {//查询结果解析,bean => vo
				CategoryVo CategoryVo = new CategoryVo();
				BeanUtils.copyPropertiesIgnoreNullValue(opsAccept, CategoryVo);//copy
				result.add(CategoryVo);
			}
			pageInfo.setList(result);
			return new ObjectResultEx<PageInfo<CategoryVo>>().makeSuccessResult(pageInfo);
		} catch (Exception e) {
			logger.error("CategoryServiceImpl.queryCategoryList error.",e);
			return new ObjectResultEx<PageInfo<CategoryVo>>().makeInternalErrorResult();
		}
	}
	
	@Override
	public ObjectResultEx<List<CategoryVo>> getCategoryList(CategoryVo query, SysUser sysUser) {
		if(StringUtil.isEmpty(query)){
			logger.error("CategoryServiceImpl.queryCategoryList error. query is empty");
			return new ObjectResultEx<List<CategoryVo>>().makeInvalidParameterResult();
		}
		try {
			Example example = new Example(Category.class);
			Criteria criteria = example.createCriteria();
			//查询条件
			if(StringUtil.noEmpty(query.getName())){//节点名称
				criteria.andLike("name", "%" + query.getName() + "%");
			}
			if(StringUtil.noEmpty(query.getType())){//节点类型
				criteria.andEqualTo("type", query.getType());
			}
			if(StringUtil.noEmpty(query.getScope())){//域
				criteria.andEqualTo("scope", query.getScope());
			}
			criteria.andEqualTo("status", EnableOrDisableCode.ENABLE);
			if(StringUtil.noEmpty(sysUser)){
				criteria.andEqualTo("orgCode", sysUser.getOrgCode());
			}
			example.orderBy("sort").desc();//排序倒序
			List<Category> list = categoryDao.selectByExample(example);//查询
			List<CategoryVo> result = new ArrayList<CategoryVo>();
			for (Category opsAccept : list) {//查询结果解析,bean => vo
				CategoryVo CategoryVo = new CategoryVo();
				BeanUtils.copyPropertiesIgnoreNullValue(opsAccept, CategoryVo);//copy
				result.add(CategoryVo);
			}
			return new ObjectResultEx<List<CategoryVo>>().makeSuccessResult(result);
		} catch (Exception e) {
			logger.error("CategoryServiceImpl.queryCategoryList error.",e);
			return new ObjectResultEx<List<CategoryVo>>().makeInternalErrorResult();
		}
	}
	
	
	private String checkParams(CategoryVo param) {
		if(StringUtil.isEmpty(param)){return "数据为空";}
		if(StringUtil.isEmpty(param.getName())){return "标签/分类名称为空";}
		if(StringUtil.isEmpty(param.getType())){return "标签/分类类型为空";}
		return CommonDictionary.SUCCESS;
	}

}
