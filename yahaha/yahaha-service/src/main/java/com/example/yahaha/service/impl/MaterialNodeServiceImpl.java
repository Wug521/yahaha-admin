package com.example.yahaha.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.system.dic.CommonDictionary;
import com.example.system.dic.CommonDictionary.EnableOrDisableCode;
import com.example.system.entity.SysUser;
import com.example.system.utils.BeanUtils;
import com.example.system.utils.CommonUtil;
import com.example.system.utils.TreeMenuUtils;
import com.example.system.vo.MenuVo;
import com.example.yahaha.dao.IMaterialNodeDao;
import com.example.yahaha.entity.MaterialNode;
import com.example.yahaha.entity.vo.MaterialNodeQueryVo;
import com.example.yahaha.entity.vo.MaterialNodeVo;
import com.example.yahaha.service.IMaterialNodeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.Constants;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;
import com.zjapl.common.result.XResult.ErrorCode;
import com.zjapl.common.util.JSONUtil;
import com.zjapl.common.util.StringUtil;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * 素材节点接口
 * @author Mr.Wug
 *
 */
@Service
public class MaterialNodeServiceImpl implements IMaterialNodeService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IMaterialNodeDao materialNodeDao;

	@Override
	public ResultEx add(MaterialNodeVo vo, SysUser sysUser) {
		String checkResult = this.checkParams(vo);
		if (!StringUtil.eq(CommonDictionary.SUCCESS, checkResult)) {
			logger.error("MaterialNodeServiceImpl.add error. " + checkResult);
        	return new ResultEx().makeFailedResult(ErrorCode.BAD_PARAMETER, checkResult);
        }
		MaterialNode info = new MaterialNode();
		BeanUtils.copyPropertiesIgnoreNullValue(vo, info);//copy
		info.setFatherNodeId(StringUtil.isEmpty(vo.getFatherNodeId()) ? "0" : vo.getFatherNodeId());
		info.setCreateDate(new Date());
		info.setCreateUser(sysUser.getId());
		info.setUpdateDate(info.getCreateDate());
		info.setUpdateUser(sysUser.getId());
		info.setOrgCode(sysUser.getOrgCode());
		materialNodeDao.insertSelective(info);//添加节点
		return new ResultEx().makeSuccessResult();
	}

	@Override
	public ResultEx update(MaterialNodeVo vo, SysUser sysUser) {
		String checkResult = this.checkParams(vo);
		if (!StringUtil.eq(CommonDictionary.SUCCESS, checkResult)) {
			logger.error("MaterialNodeServiceImpl.add error. " + checkResult);
        	return new ResultEx().makeFailedResult(ErrorCode.BAD_PARAMETER, checkResult);
        }
		if(StringUtil.noEmpty(vo.getFatherNodeId())){
			if(StringUtil.eq(vo.getId().toString(), vo.getFatherNodeId())){
				logger.error("MaterialNodeServiceImpl.add error. parentName is self");
	        	return new ResultEx().makeFailedResult(ErrorCode.BAD_PARAMETER, "父子节点一致");
			}
		}
		MaterialNode info = new MaterialNode();
		BeanUtils.copyPropertiesIgnoreNullValue(vo, info);//copy
		info.setUpdateDate(info.getCreateDate());
		info.setUpdateUser(sysUser.getId());
		materialNodeDao.updateByPrimaryKeySelective(info);//修改节点
		return new ResultEx().makeSuccessResult();
	}

	@Override
	public ResultEx editStatus(String ids, SysUser sysUser) {
		if(StringUtil.isEmpty(ids)){
			logger.error("MaterialNodeServiceImpl.edit error. id is empty");
			return new ObjectResultEx<MaterialNodeVo>().makeInvalidParameterResult();
		}
		List<Long> idsToList = CommonUtil.idsToList(ids);
		Example example = new Example(MaterialNode.class);
		example.createCriteria().andIn("id", idsToList)
								.andEqualTo("orgCode", sysUser.getOrgCode());
		MaterialNode info = new MaterialNode();
		info.setStatus(EnableOrDisableCode.DELETED);
		info.setUpdateDate(new Date());
		info.setUpdateUser(sysUser.getId());
		materialNodeDao.updateByExampleSelective(info, example);
		return new ResultEx().makeSuccessResult();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ObjectResultEx<PageInfo<MaterialNodeVo>> queryMaterialNodeList(MaterialNodeQueryVo query,
			SysUser sysUser) {
		if(StringUtil.isEmpty(query)){
			logger.error("IOpsAccepOrderServiceImpl.queryMaterialNodeList error. query is empty");
			return new ObjectResultEx<PageInfo<MaterialNodeVo>>().makeInvalidParameterResult();
		}
		try {
			Example example = new Example(MaterialNode.class);
			Criteria criteria = example.createCriteria();
			//查询条件
			if(StringUtil.noEmpty(query.getId())){//节点名称
				Set<Long> nodeIds = getMaterialNodeAndSonsById(query.getId());
				criteria.andIn("id", nodeIds);
			}
			criteria.andEqualTo("status", EnableOrDisableCode.ENABLE).andEqualTo("orgCode", sysUser.getOrgCode());
			PageHelper.startPage(query.getPageNum(),query.getPageSize(),"CREATE_DATE DESC");//创建时间倒序
			List<MaterialNode> list = materialNodeDao.selectByExample(example);//查询
			List<MaterialNodeVo> result = new ArrayList<MaterialNodeVo>();
			PageInfo pageInfo = new PageInfo(list);
			for (MaterialNode opsAccept : list) {//查询结果解析,bean => vo
				MaterialNodeVo MaterialNodeVo = new MaterialNodeVo();
				BeanUtils.copyPropertiesIgnoreNullValue(opsAccept, MaterialNodeVo);//copy
				result.add(MaterialNodeVo);
			}
			pageInfo.setList(result);
			return new ObjectResultEx<PageInfo<MaterialNodeVo>>().makeSuccessResult(pageInfo);
		} catch (Exception e) {
			logger.error("IOpsAccepOrderServiceImpl.queryAcceptList error.",e);
			return new ObjectResultEx<PageInfo<MaterialNodeVo>>().makeInternalErrorResult();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ObjectResultEx<List<MenuVo>> getNodeTree(String orgCode) {
		Example ex = new Example(MaterialNode.class);
		ex.createCriteria().andEqualTo("status", EnableOrDisableCode.ENABLE).andEqualTo("orgCode", orgCode);
		List<MaterialNode> list = materialNodeDao.selectByExample(ex);
		List<MenuVo> treeNodes = new ArrayList<MenuVo>();
		if(list != null && list.size() > Constants.ZERO.intValue()){
			List<MenuVo> menuVo = new ArrayList<MenuVo>();
			for (MaterialNode tmp : list) {
				MenuVo menu = new MenuVo();
				menu.setId(tmp.getId().toString());
				menu.setpId(tmp.getFatherNodeId());
				menu.setText(tmp.getName());
				menu.setSort(tmp.getNodeNumber().shortValue());
				menuVo.add(menu);
			}
			System.out.println(JSONUtil.object2String(menuVo));
			treeNodes = TreeMenuUtils.getSortTreeMenuNodes(menuVo);
		}
		return new ObjectResultEx<List<MenuVo>>().makeSuccessResult(treeNodes);
	}
	
	/**
	 * 根据素材节点查询全部子节点Id
	 * @param mid
	 * @return
	 */
	public Set<Long> getMaterialNodeAndSonsById(Long... mid){
		if (mid == null || mid.length <= 0){
			return null;
		}
		Example example = new Example(MaterialNode.class);
		Set<Long> ids = new HashSet<>();
		ids.remove(null);
		ids.addAll(Arrays.asList(mid));
		int idSize = ids.size();
		example = new Example(MaterialNode.class);
		example.createCriteria().andIn("fatherNodeId", ids);
		List<MaterialNode> list = materialNodeDao.selectByExample(example);
		if (list != null && list.size() > 0){
			for(MaterialNode tmp : list){
				ids.add(tmp.getId());
			}
		}
		ids.remove(null);
		if (ids.size() > idSize){
			ids.addAll(getMaterialNodeAndSonsById(ids.toArray(new Long[ids.size()])));
		}
		return ids;
	}
	
	private String checkParams(MaterialNodeVo param) {
		if(StringUtil.isEmpty(param)){return "数据为空";}
		if(StringUtil.isEmpty(param.getName())){return "节点名称为空";}
//		if(StringUtil.isEmpty(param.getNodeTpye())){return "节点类型为空";}
		return CommonDictionary.SUCCESS;
	}


}
