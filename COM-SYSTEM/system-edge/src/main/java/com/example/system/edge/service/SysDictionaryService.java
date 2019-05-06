package com.example.system.edge.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import com.example.system.dao.ISysDictionaryDao;
import com.example.system.dic.CommonDictionary.EnableOrDisable;
import com.example.system.dic.CommonDictionary.EnableOrDisableCode;
import com.example.system.entity.SysDictionary;
import com.example.system.entity.SysUser;
import com.example.system.utils.BeanUtils;
import com.example.system.vo.SysDictionaryVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;
import com.zjapl.common.util.StringUtil;

/**
 * 文件名：SysDictionaryService.java
 * 日　期：2017年1月16日
 * 版　权：ZJAPL
 * 作　者：wug
 * 类说明：
 */
@Service
public class SysDictionaryService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private ISysDictionaryDao sysDictionaryDao;
	
	/**
	 * 新增或修改数据字典参数
	 * @param sysDictionary
	 * @return
	 */
	public ResultEx addOrEditSysDictionary(SysDictionaryVo sysDictionaryVo, SysUser sysUser){
		if(sysDictionaryVo==null){
			return new ResultEx().makeInvalidParameterResult();
		}
		try{
			SysDictionary sysDictionary = new SysDictionary();
			BeanUtils.copyPropertiesIgnoreNullValue(sysDictionaryVo, sysDictionary);
			sysDictionary.setUpdateDate(new Date());
			sysDictionary.setUpdateUserId(sysUser.getId());
			if(sysDictionaryVo.getId()!=null){
				sysDictionaryDao.updateByPrimaryKeySelective(sysDictionary);
			}else{
				sysDictionary.setAvailable(EnableOrDisableCode.ENABLE);
				sysDictionary.setCreateUserId(sysUser.getId());
				sysDictionary.setCreateDate(new Date());
				sysDictionary.setOrgCode(sysUser.getOrgCode());
				sysDictionaryDao.insertSelective(sysDictionary);
			}
		}catch (Exception e) {
			logger.error("addOrEditSysDictionary error.", e);
			throw e;
		}
		return new ResultEx().makeSuccessResult();
	}
	
	/**
	 * 根据ID修改参数有效标识
	 * 1有效  0无效
	 * @param id
	 * @return
	 */
	public ResultEx updateSysDictionary(SysDictionaryVo sysDictionaryVo, SysUser sysUser){
		if(sysDictionaryVo==null || StringUtil.isEmpty(sysDictionaryVo.getIds())){
			return new ResultEx().makeInvalidParameterResult();
		}
		String[] idStrings=sysDictionaryVo.getIds().split(",");
		List<Long> idList=new ArrayList<Long>();
		for(String str: idStrings){
			if(str.matches("[0-9]{1,}")){
				idList.add(Long.valueOf(str));
			}
		}
		try{
			SysDictionary sysDictionary =new SysDictionary();
			Example ex=new Example(SysDictionary.class);
			ex.createCriteria().andIn("id", idList);
			sysDictionary.setUpdateUserId(sysUser.getId());
			sysDictionary.setUpdateDate(new Date());
			sysDictionary.setAvailable(sysDictionaryVo.getAvailable());
			sysDictionaryDao.updateByExampleSelective(sysDictionary, ex);
		}catch (Exception e) {
			logger.error("updateSysDictionary error.", e);
			throw e;
		}
		return new ResultEx().makeSuccessResult();
	}
	
	/**
	 * 查询参数列表
	 * @param sysDictionaryVo
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ObjectResultEx<PageInfo<SysDictionaryVo>> querySysDictionaryList(SysDictionaryVo sysDictionaryVo, SysUser sysUser){
		if (sysUser == null){ // || StringUtil.isEmpty(sysUser.getOrgCode())
			logger.error("querySysDictionaryList error, sysUser is null or orgCode is null.");
			return null;
		}
		if(sysDictionaryVo==null){
			return new ObjectResultEx<PageInfo<SysDictionaryVo>>().makeInvalidParameterResult();
		}
		if (sysDictionaryVo.getPageSize() == 0){
			sysDictionaryVo.setPageSize(20);
		}
		PageHelper.startPage(sysDictionaryVo.getPageNum(),  sysDictionaryVo.getPageSize(),"TYPE,VALUE ASC");
		Example ex=new Example(SysDictionary.class);
		Criteria cri=ex.createCriteria();
		cri.andNotEqualTo("available", EnableOrDisableCode.DELETED);
		cri.andEqualTo("orgCode",sysUser.getOrgCode());
		if(!StringUtil.isEmpty(sysDictionaryVo.getName())){
			cri.andLike("name", "%"+sysDictionaryVo.getName()+"%");
		}
		if(!StringUtil.isEmpty(sysDictionaryVo.getType())){
			cri.andEqualTo("type", sysDictionaryVo.getType());
		}
		List<SysDictionary> sysDictionaryList  = sysDictionaryDao.selectByExample(ex);
		PageInfo pageInfo = new PageInfo(sysDictionaryList);
		List<SysDictionaryVo> sysDictionaryListVo = new ArrayList<SysDictionaryVo>();
		for(SysDictionary dictionary:sysDictionaryList){
			SysDictionaryVo dictionaryVo = new SysDictionaryVo();
			BeanUtils.copyProperties(dictionary, dictionaryVo);
			if(dictionary.getAvailable()!=null){
				dictionaryVo.setAvailableName(EnableOrDisable.parseCode(dictionary.getAvailable())==null ? "未定义":EnableOrDisable.parseCode(dictionary.getAvailable()).getLocalizedName());
			}
			sysDictionaryListVo.add(dictionaryVo);
		}
		pageInfo.setList(sysDictionaryListVo);
		return new ObjectResultEx<PageInfo<SysDictionaryVo>>().makeSuccessResult(pageInfo);
	}
	
	/**
	 * 根据ID查询参数字典信息
	 * @param id
	 * @return
	 */
	public ObjectResultEx<SysDictionary> querySysDictionary(Long id){
		SysDictionary SysDictionary = new SysDictionary();
		if(id==null){
			return new ObjectResultEx<SysDictionary>().makeSuccessResult(SysDictionary);
		}
		try{
			SysDictionary = sysDictionaryDao.selectByPrimaryKey(id);
		}catch(Exception e){
			logger.error("querySysDictionary error.", e);
			throw e;
		}
		return new ObjectResultEx<SysDictionary>().makeSuccessResult(SysDictionary);
	}
	
	/**
	 * 查询字典的所有范围
	 * @return
	 */
	public ObjectResultEx<List<SysDictionary>> querySysDictionaryScope(SysUser sysUser){
		if (sysUser == null){ // || StringUtil.isEmpty(sysUser.getOrgCode())
			logger.error("querySysDictionaryScope error, sysUser is null or orgCode is null.");
			return null;
		}
		List<String> scope = new ArrayList<String>();
		List<SysDictionary> scopeList = new ArrayList<SysDictionary>();
		Example example = new Example(SysDictionary.class);
		example.createCriteria().andEqualTo("available", EnableOrDisableCode.ENABLE)
		.andEqualTo("orgCode",sysUser.getOrgCode());
		List<SysDictionary> list = sysDictionaryDao.selectByExample(example);
		for (SysDictionary sysDictionary : list) {
			if (!scope.contains(sysDictionary.getScope())){
				scope.add(sysDictionary.getScope());
				scopeList.add(sysDictionary);
			}
		}
		return new ObjectResultEx<List<SysDictionary>>().makeSuccessResult(scopeList);
	}
	
	/**
	 * 查询参数列表
	 * @param sysDictionaryVo
	 * @return
	 */
	public ObjectResultEx<List<SysDictionary>> querySysDictionaryList(String type,SysUser sysUser){
		if (sysUser == null){ // || StringUtil.isEmpty(sysUser.getOrgCode())
			logger.error("querySysDictionaryList error, sysUser is null or orgCode is null.");
			return null;
		}
		if(StringUtil.isEmpty(type)){
			logger.error("querySysDictionaryList type is null");
			return new ObjectResultEx<List<SysDictionary>>().makeInvalidParameterResult();
		}
		PageHelper.startPage(1,  10000,"TYPE,VALUE ASC");
		Example example = new Example(SysDictionary.class);
		example.createCriteria().andEqualTo("type", type).andEqualTo("available", EnableOrDisableCode.ENABLE)
		.andEqualTo("orgCode",sysUser.getOrgCode());
		List<SysDictionary> sysDictionaryList  = sysDictionaryDao.selectByExample(example);
		return new ObjectResultEx<List<SysDictionary>>().makeSuccessResult(sysDictionaryList);
	}
}
