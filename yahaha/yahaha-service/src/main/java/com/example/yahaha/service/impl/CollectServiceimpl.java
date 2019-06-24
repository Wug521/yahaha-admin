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
import com.example.system.utils.CommonUtil;
import com.example.yahaha.dao.ICollectDao;
import com.example.yahaha.entity.Collect;
import com.example.yahaha.entity.vo.CollectQueryVo;
import com.example.yahaha.entity.vo.CollectVo;
import com.example.yahaha.entity.vo.MaterialNodeVo;
import com.example.yahaha.service.ICollectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;
import com.zjapl.common.result.XResult.ErrorCode;
import com.zjapl.common.util.StringUtil;

import tk.mybatis.mapper.entity.Example;

/**
 * 新闻/游戏 收藏接口
 * @author Mr.Wug
 *
 */
@Service
public class CollectServiceimpl implements ICollectService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ICollectDao collectDao;

	@Override
	public ResultEx add(CollectVo vo, SysUser sysUser) {
		String checkResult = this.checkParams(vo, sysUser);
		if (!StringUtil.eq(CommonDictionary.SUCCESS, checkResult)) {
			logger.error("CollectServiceImpl.add error. " + checkResult);
        	return new ResultEx().makeFailedResult(ErrorCode.BAD_PARAMETER, checkResult);
        }
		Collect info = new Collect();
		BeanUtils.copyPropertiesIgnoreNullValue(vo, info);//copy
		info.setUserId(sysUser.getId());
		info.setCreateDate(new Date());
		info.setCreateUser(sysUser.getId());
		info.setUpdateDate(info.getCreateDate());
		info.setUpdateUser(sysUser.getId());
		info.setOrgCode(sysUser.getOrgCode());
		info.setStatus(EnableOrDisableCode.ENABLE);
		collectDao.insertSelective(info);//添加节点
		return new ResultEx().makeSuccessResult();
	}

	@Override
	public ResultEx edit(String ids, SysUser sysUser) {
		if(StringUtil.isEmpty(ids)){
			logger.error("CollectServiceImpl.edit error. id is empty");
			return new ObjectResultEx<MaterialNodeVo>().makeInvalidParameterResult();
		}
		List<Long> idsToList = CommonUtil.idsToList(ids);
		Example example = new Example(Collect.class);
		example.createCriteria().andIn("id", idsToList)
								.andEqualTo("orgCode", sysUser.getOrgCode());
		Collect info = new Collect();
		info.setStatus(EnableOrDisableCode.DELETED);
		info.setUpdateDate(new Date());
		info.setUpdateUser(sysUser.getId());
		collectDao.updateByExampleSelective(info, example);
		return new ResultEx().makeSuccessResult();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ObjectResultEx<PageInfo<CollectVo>> queryCollectList(CollectQueryVo query, SysUser sysUser) {
		if(StringUtil.isEmpty(query)){
			logger.error("CollectServiceImpl.queryCollectList error. query or type is empty");
			return new ObjectResultEx<PageInfo<CollectVo>>().makeInvalidParameterResult();
		}
		try {
			PageHelper.startPage(query.getPageNum(),query.getPageSize());//创建时间倒序
			List<CollectVo> result = collectDao.queryNewsCollectList(sysUser.getId());
			PageInfo pageInfo = new PageInfo(result);
			return new ObjectResultEx<PageInfo<CollectVo>>().makeSuccessResult(pageInfo);
		} catch (Exception e) {
			logger.error("CollectServiceImpl.queryCollectList error.",e);
			return new ObjectResultEx<PageInfo<CollectVo>>().makeInternalErrorResult();
		}
	}
	
	private String checkParams(CollectVo param, SysUser sysUser) {
		if(StringUtil.isEmpty(param)){return "数据为空";}
		if(StringUtil.isEmpty(param.getSourceId())){return "收藏来源为空";}
		if(StringUtil.noEmpty(param.getSourceId())){
			Example example = new Example(Collect.class);
			example.createCriteria().andEqualTo("sourceId", param.getSourceId()).andEqualTo("userId", sysUser.getId());
			int num = collectDao.selectCountByExample(example);
			return num > 0 ? "已收藏" : CommonDictionary.SUCCESS;
		}
		return CommonDictionary.SUCCESS;
	}

}
