package com.example.yahaha.vip;

import com.example.system.base.BaseController;
import com.example.system.dao.ISysUserDao;
import com.example.system.entity.SysUser;
import com.example.system.vo.SysUserQueryVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * yahaha
 *
 * @author create by yangb in 2019/7/1
 */
@RestController
@RequestMapping("/vip")
public class VipController extends BaseController {

    @Autowired
    ISysUserDao userDao;

    @GetMapping
    public ObjectResultEx<PageInfo<SysUser>> getVip(SysUserQueryVo param){
        Example example = new Example(SysUser.class);
        example.createCriteria().andIsNull("status");
        PageHelper.startPage(param.getPageNum(),param.getPageSize());
        List<SysUser> sysUsers = userDao.selectByExample(example);
        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUsers);
        return new ObjectResultEx<PageInfo<SysUser>>().makeSuccessResult(pageInfo);
    }

}
