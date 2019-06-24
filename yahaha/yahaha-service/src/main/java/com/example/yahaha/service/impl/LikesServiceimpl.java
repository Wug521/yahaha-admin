package com.example.yahaha.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.system.dic.CommonDictionary;
import com.example.system.dic.CommonDictionary.EnableOrDisableCode;
import com.example.system.entity.SysUser;
import com.example.system.utils.BeanUtils;
import com.example.yahaha.dao.ILikesDao;
import com.example.yahaha.entity.Likes;
import com.example.yahaha.entity.vo.LikesVo;
import com.example.yahaha.service.ILikesService;
import com.zjapl.common.result.ResultEx;
import com.zjapl.common.result.XResult.ErrorCode;
import com.zjapl.common.util.StringUtil;

/**
 * 点赞接口
 * @author Mr.Wug
 *
 */
@Service
public class LikesServiceimpl implements ILikesService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ILikesDao LikesDao;

	@Override
	public ResultEx add(LikesVo vo, SysUser sysUser) {
		String checkResult = this.checkParams(vo);
		if (!StringUtil.eq(CommonDictionary.SUCCESS, checkResult)) {
			logger.error("LikesServiceImpl.add error. " + checkResult);
        	return new ResultEx().makeFailedResult(ErrorCode.BAD_PARAMETER, checkResult);
        }
		Likes info = new Likes();
		BeanUtils.copyPropertiesIgnoreNullValue(vo, info);//copy
		if(StringUtil.noEmpty(sysUser)){
			info.setUserId(sysUser.getId());
			info.setCreateUser(sysUser.getId());
			info.setUpdateUser(sysUser.getId());
			info.setOrgCode(sysUser.getOrgCode());
		}
		info.setCreateDate(new Date());
		info.setUpdateDate(info.getCreateDate());
		info.setStatus(EnableOrDisableCode.ENABLE);
		LikesDao.insertSelective(info);//添加节点
		return new ResultEx().makeSuccessResult();
	}
	
	private String checkParams(LikesVo param) {
		if(StringUtil.isEmpty(param)){return "数据为空";}
		if(StringUtil.isEmpty(param.getSourceId())){return "点赞来源为空";}
		if(StringUtil.isEmpty(param.getType())){return "点赞类型为空";}
		return CommonDictionary.SUCCESS;
	}

}
