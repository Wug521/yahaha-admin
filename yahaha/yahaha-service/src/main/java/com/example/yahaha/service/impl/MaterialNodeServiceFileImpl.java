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
import com.example.yahaha.dao.IMaterialNodeDao;
import com.example.yahaha.dao.IMaterialNodeFileDao;
import com.example.yahaha.entity.MaterialNode;
import com.example.yahaha.entity.MaterialNodeFile;
import com.example.yahaha.entity.vo.MaterialNodeFileQueryVo;
import com.example.yahaha.entity.vo.MaterialNodeFileVo;
import com.example.yahaha.entity.vo.MaterialNodeVo;
import com.example.yahaha.service.IMaterialNodeFileService;
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
 * 素材文件接口
 * @author Mr.Wug
 *
 */
@Service
public class MaterialNodeServiceFileImpl implements IMaterialNodeFileService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IMaterialNodeFileDao materialNodeFileDao;
	
	@Autowired
	IMaterialNodeDao materialNodeDao;
	
	@Override
	public ResultEx add(MaterialNodeFileVo vo, SysUser sysUser) {
		String checkResult = this.checkParams(vo);
		if (!StringUtil.eq(CommonDictionary.SUCCESS, checkResult)) {
			logger.error("MaterialNodeServiceFileImpl.add error. " + checkResult);
        	return new ResultEx().makeFailedResult(ErrorCode.BAD_PARAMETER, checkResult);
        }
		List<MaterialNodeFile> list = JSONUtil.json2List(vo.getFileJson(), MaterialNodeFile.class);
		if(list != null && list.size() > Constants.ZERO.intValue()){
			for (MaterialNodeFile tmp : list) {
				tmp.setMid(vo.getMid());
				tmp.setName(vo.getName());
				tmp.setFileType(vo.getFileType());
				tmp.setCreateDate(new Date());
				tmp.setCreateUser(sysUser.getId());
				tmp.setUpdateDate(tmp.getCreateDate());
				tmp.setUpdateUser(sysUser.getId());
				tmp.setStatus(EnableOrDisableCode.ENABLE);
				tmp.setOrgCode(sysUser.getOrgCode());
			}
		}
		materialNodeFileDao.insertList(list);
		return new ResultEx().makeSuccessResult();
	}
	
	@Override
	public ResultEx update(MaterialNodeFileVo vo, SysUser sysUser) {
		String checkResult = this.checkParams(vo);
		if (!StringUtil.eq(CommonDictionary.SUCCESS, checkResult)) {
			logger.error("MaterialNodeServiceImpl.add error. " + checkResult);
        	return new ResultEx().makeFailedResult(ErrorCode.BAD_PARAMETER, checkResult);
        }
		MaterialNodeFile info = new MaterialNodeFile();
		BeanUtils.copyPropertiesIgnoreNullValue(vo, info);//copy
		info.setUpdateDate(new Date());
		info.setUpdateUser(sysUser.getId());
		materialNodeFileDao.updateByPrimaryKeySelective(info);//修改节点
		return new ResultEx().makeSuccessResult();
	}

	@Override
	public ResultEx edit(String ids, SysUser sysUser) {
		if(StringUtil.isEmpty(ids)){
			logger.error("MaterialNodeServiceFileImpl.edit error. ids is empty");
			return new ObjectResultEx<MaterialNodeVo>().makeInvalidParameterResult();
		}
		List<Long> list = CommonUtil.idsToList(ids);
		Example example = new Example(MaterialNodeFile.class);
		MaterialNodeFile record = new MaterialNodeFile();
		record.setStatus(EnableOrDisableCode.DELETED);
		record.setUpdateDate(new Date());
		record.setUpdateUser(sysUser.getId());
		example.createCriteria().andIn("id", list).andEqualTo("orgCode", sysUser.getOrgCode());
		materialNodeFileDao.updateByExampleSelective(record, example);
		return new ResultEx().makeSuccessResult();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ObjectResultEx<PageInfo<MaterialNodeFileVo>> queryMaterialNodeFileList(MaterialNodeFileQueryVo query,
			SysUser sysUser) {
		if(StringUtil.isEmpty(query)){
			logger.error("IOpsAccepOrderServiceImpl.queryMaterialNodeList error. query is empty");
			return new ObjectResultEx<PageInfo<MaterialNodeFileVo>>().makeInvalidParameterResult();
		}
		try {
			Example example = new Example(MaterialNodeFile.class);
			Criteria criteria = example.createCriteria();
			//查询条件
			if(StringUtil.noEmpty(query.getMid())){//节点名称
				Set<Long> nodeIds = getMaterialNodeAndSonsById(query.getMid());
				criteria.andIn("mid", nodeIds);
			}
			if(StringUtil.noEmpty(query.getFileType())){//文件类型
				criteria.andEqualTo("fileType", query.getFileType());
			}
			criteria.andEqualTo("status", EnableOrDisableCode.ENABLE).andEqualTo("orgCode", sysUser.getOrgCode());
			PageHelper.startPage(query.getPageNum(),query.getPageSize(),"CREATE_DATE DESC");//创建时间倒序
			List<MaterialNodeFile> list = materialNodeFileDao.selectByExample(example);//查询
			List<MaterialNodeFileVo> result = new ArrayList<MaterialNodeFileVo>();
			PageInfo pageInfo = new PageInfo(list);
			for (MaterialNodeFile tmp : list) {//查询结果解析,bean => vo
				MaterialNodeFileVo MaterialNodeVo = new MaterialNodeFileVo();
				BeanUtils.copyPropertiesIgnoreNullValue(tmp, MaterialNodeVo);//copy
				result.add(MaterialNodeVo);
			}
			pageInfo.setList(result);
			return new ObjectResultEx<PageInfo<MaterialNodeFileVo>>().makeSuccessResult(pageInfo);
		} catch (Exception e) {
			logger.error("IOpsAccepOrderServiceImpl.queryAcceptList error.",e);
			return new ObjectResultEx<PageInfo<MaterialNodeFileVo>>().makeInternalErrorResult();
		}
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
	
	private String checkParams(MaterialNodeFileVo param) {
		if(StringUtil.isEmpty(param)){return "数据为空";}
		if(StringUtil.isEmpty(param.getMid())){return "节点ID为空";}
		if(StringUtil.isEmpty(param.getName())){return "节点名称为空";}
		if(StringUtil.isEmpty(param.getId())){
			if(StringUtil.isEmpty(param.getFileJson())){return "文件为空";}
		}
		if(StringUtil.isEmpty(param.getFileType())){return "文件路径为空";}
		return CommonDictionary.SUCCESS;
	}
}
