package com.example.yahaha.service.impl;

import org.springframework.stereotype.Service;

import com.example.system.entity.SysUser;
import com.example.yahaha.entity.vo.MaterialNodeQueryVo;
import com.example.yahaha.entity.vo.MaterialNodeVo;
import com.example.yahaha.service.IMaterialNodeService;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;

/**
 * 素材节点接口
 * @author Mr.Wug
 *
 */
@Service
public class MaterialNodeServiceImpl implements IMaterialNodeService {

	@Override
	public ResultEx add(MaterialNodeQueryVo queryVo, SysUser sysUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultEx update(MaterialNodeQueryVo queryVo, SysUser sysUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultEx edit(Long id, SysUser sysUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjectResultEx<PageInfo<MaterialNodeVo>> queryMaterialNodeList(MaterialNodeQueryVo queryVo,
			SysUser sysUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
