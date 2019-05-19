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
import com.example.yahaha.dao.ICategoryDao;
import com.example.yahaha.entity.Category;
import com.example.yahaha.entity.MaterialNode;
import com.example.yahaha.entity.vo.CategoryQueryVo;
import com.example.yahaha.entity.vo.CategoryVo;
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
		categoryDao.insertSelective(info);//添加节点
		return new ResultEx().makeSuccessResult();
	}

	@Override
	public ResultEx edit(Long id, SysUser sysUser) {
		if(StringUtil.isEmpty(id)){
			logger.error("CategoryServiceImpl.edit error. id is empty");
			return new ObjectResultEx<CategoryVo>().makeInvalidParameterResult();
		}
		Category info = new Category();
		info.setId(id);
		info.setStatus(EnableOrDisableCode.ENABLE);
		info.setOrgCode(sysUser.getOrgCode());
		info = categoryDao.selectOne(info);//验证该记录isHas
		if(info != null){
			//设置状态为删除
			info.setStatus(EnableOrDisableCode.DISABLE);
			categoryDao.updateByPrimaryKeySelective(info);
		}else{
			return new ResultEx().makeFailedResult(ErrorCode.BAD_PARAMETER, "传入非法参数");
		}
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
			Example example = new Example(MaterialNode.class);
			Criteria criteria = example.createCriteria();
			//查询条件
			if(StringUtil.noEmpty(query.getName())){//节点名称
				criteria.andLike("name", "%" + query.getName() + "%");
			}
			if(StringUtil.noEmpty(query.getType())){//节点类型
				criteria.andEqualTo("tpye", query.getType());
			}
			criteria.andEqualTo("status", EnableOrDisableCode.ENABLE).andEqualTo("orgCode", sysUser.getOrgCode());
			PageHelper.startPage(query.getPageNum(),query.getPageSize(),"CREATE_DATE DESC");//创建时间倒序
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
			Example example = new Example(MaterialNode.class);
			Criteria criteria = example.createCriteria();
			//查询条件
			if(StringUtil.noEmpty(query.getName())){//节点名称
				criteria.andLike("name", "%" + query.getName() + "%");
			}
			if(StringUtil.noEmpty(query.getType())){//节点类型
				criteria.andEqualTo("tpye", query.getType());
			}
			criteria.andEqualTo("status", EnableOrDisableCode.ENABLE).andEqualTo("orgCode", sysUser.getOrgCode());
			example.orderBy("createDate").desc();//创建时间倒序
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
