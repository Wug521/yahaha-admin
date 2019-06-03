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
import com.example.yahaha.dao.IGameDao;
import com.example.yahaha.entity.Game;
import com.example.yahaha.entity.vo.GameQueryVo;
import com.example.yahaha.entity.vo.GameVo;
import com.example.yahaha.service.IGameService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;
import com.zjapl.common.result.XResult.ErrorCode;
import com.zjapl.common.util.StringUtil;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * 游戏接口
 * @author liul
 *
 */
@Service
public class GameServiceImpl implements IGameService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IGameDao gameDao;

	@Override
	public ResultEx add(GameVo vo, SysUser sysUser) {
		String checkResult = this.checkParams(vo);
		if (!StringUtil.eq(CommonDictionary.SUCCESS, checkResult)) {
			logger.error("GameServiceImpl.add error. " + checkResult);
        	return new ResultEx().makeFailedResult(ErrorCode.BAD_PARAMETER, checkResult);
        }
		Game info = new Game();
		BeanUtils.copyPropertiesIgnoreNullValue(vo, info);//copy
		info.setIdsTag(addString(info.getIdsTag()));
		info.setIdsCategory(addString(info.getIdsCategory()));
		info.setCreateDate(new Date());
		info.setCreateUser(sysUser.getId());
		info.setCreateUsername(sysUser.getUsername());
		info.setUpdateDate(info.getCreateDate());
		info.setUpdateUser(sysUser.getId());
		info.setOrgCode(sysUser.getOrgCode());
		if(StringUtil.isEmpty(info.getStatus())){
			info.setStatus(EnableOrDisableCode.ENABLE);
		}
		gameDao.insertSelective(info);//添加游戏
		return new ResultEx().makeSuccessResult();
	}

	@Override
	public ResultEx update(GameVo vo, SysUser sysUser) {
		String checkResult = this.checkParams(vo);
		if (!StringUtil.eq(CommonDictionary.SUCCESS, checkResult)) {
			logger.error("GameServiceImpl.update error. " + checkResult);
        	return new ResultEx().makeFailedResult(ErrorCode.BAD_PARAMETER, checkResult);
        }
		Game info = new Game();
		BeanUtils.copyPropertiesIgnoreNullValue(vo, info);//copy
		info.setIdsTag(addString(info.getIdsTag()));
		info.setIdsCategory(addString(info.getIdsCategory()));
		info.setUpdateDate(info.getCreateDate());
		info.setUpdateUser(sysUser.getId());
		gameDao.updateByPrimaryKeySelective(info);//修改游戏
		return new ResultEx().makeSuccessResult();
	}

	@Override
	public ResultEx edit(Long id, SysUser sysUser) {
		if(StringUtil.isEmpty(id)){
			logger.error("GameServiceImpl.edit error. id is empty");
			return new ObjectResultEx<GameVo>().makeInvalidParameterResult();
		}
		
		Game info = new Game();
		info.setId(id);
		info.setOrgCode(sysUser.getOrgCode());
		info = gameDao.selectOne(info);//验证该记录isHas
		if(info != null){
			//设置状态为删除
			info.setStatus(EnableOrDisableCode.DELETED);
			gameDao.updateByPrimaryKeySelective(info);
		}else{
			return new ResultEx().makeFailedResult(ErrorCode.BAD_PARAMETER, "传入非法参数");
		}
		return new ResultEx().makeSuccessResult();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ObjectResultEx<PageInfo<GameVo>> queryGameList(GameQueryVo query, SysUser sysUser) {
		if(StringUtil.isEmpty(query)){
			logger.error("GameServiceImpl.queryGameList error. query is empty");
			return new ObjectResultEx<PageInfo<GameVo>>().makeInvalidParameterResult();
		}
		try {
			Example example = new Example(Game.class);
			Criteria criteria = example.createCriteria();
			//查询条件
			if(StringUtil.noEmpty(query.getId())){//游戏ID
				criteria.andEqualTo("id", query.getId());
			}
			if(StringUtil.noEmpty(query.getTop())){//是否置顶
				criteria.andEqualTo("top", query.getTop());
			}
			if(StringUtil.noEmpty(query.getTitle())){//游戏标题
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
			if(StringUtil.noEmpty(query.getStatus())){//游戏状态
				criteria.andEqualTo("status", query.getStatus());
			}else{
				criteria.andEqualTo("status", EnableOrDisableCode.ENABLE);
			}
			criteria.andEqualTo("orgCode", sysUser.getOrgCode());
			PageHelper.startPage(query.getPageNum(),query.getPageSize(),"CREATE_DATE DESC");//创建时间倒序
			List<Game> list = gameDao.selectByExample(example);//查询
			List<GameVo> result = new ArrayList<GameVo>();
			PageInfo pageInfo = new PageInfo(list);
			for (Game opsAccept : list) {//查询结果解析,bean => vo
				GameVo GameVo = new GameVo();
				//取出分类和标签集合前后字符串逗号deleteString
				opsAccept.setIdsTag(deleteString(opsAccept.getIdsTag()));
				opsAccept.setIdsCategory(deleteString(opsAccept.getIdsCategory()));
				BeanUtils.copyPropertiesIgnoreNullValue(opsAccept, GameVo);//copy
				result.add(GameVo);
			}
			pageInfo.setList(result);
			return new ObjectResultEx<PageInfo<GameVo>>().makeSuccessResult(pageInfo);
		} catch (Exception e) {
			logger.error("GameServiceImpl.queryGameList error.",e);
			return new ObjectResultEx<PageInfo<GameVo>>().makeInternalErrorResult();
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ObjectResultEx<PageInfo<GameVo>> queryGameListFromApplet(GameQueryVo query) {
		if(StringUtil.isEmpty(query)){
			logger.error("GameServiceImpl.queryGameList error. query is empty");
			return new ObjectResultEx<PageInfo<GameVo>>().makeInvalidParameterResult();
		}
		try {
			Example example = new Example(Game.class);
			Criteria criteria = example.createCriteria();
			//查询条件
			if(StringUtil.noEmpty(query.getId())){//游戏ID
				criteria.andEqualTo("id", query.getId());
			}
			if(StringUtil.noEmpty(query.getTop())){//是否置顶
				criteria.andEqualTo("top", query.getTop());
			}
			if(StringUtil.noEmpty(query.getTitle())){//游戏标题
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
			if(StringUtil.noEmpty(query.getStatus())){//游戏状态
				criteria.andEqualTo("status", query.getStatus());
			}else{
				criteria.andEqualTo("status", EnableOrDisableCode.ENABLE);
			}
			PageHelper.startPage(query.getPageNum(),query.getPageSize(),"CREATE_DATE DESC");//创建时间倒序
			List<Game> list = gameDao.selectByExample(example);//查询
			List<GameVo> result = new ArrayList<GameVo>();
			PageInfo pageInfo = new PageInfo(list);
			for (Game opsAccept : list) {//查询结果解析,bean => vo
				GameVo GameVo = new GameVo();
				//取出分类和标签集合前后字符串逗号deleteString
				opsAccept.setIdsTag(deleteString(opsAccept.getIdsTag()));
				opsAccept.setIdsCategory(deleteString(opsAccept.getIdsCategory()));
				BeanUtils.copyPropertiesIgnoreNullValue(opsAccept, GameVo);//copy
				result.add(GameVo);
			}
			pageInfo.setList(result);
			return new ObjectResultEx<PageInfo<GameVo>>().makeSuccessResult(pageInfo);
		} catch (Exception e) {
			logger.error("GameServiceImpl.queryGameList error.",e);
			return new ObjectResultEx<PageInfo<GameVo>>().makeInternalErrorResult();
		}
	}	
	
	private String checkParams(GameVo param) {
		if(StringUtil.isEmpty(param)){return "数据为空";}
		if(StringUtil.isEmpty(param.getTitle())){return "游戏标题为空";}
		if(StringUtil.isEmpty(param.getContent())){return "游戏内容为空";}
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
