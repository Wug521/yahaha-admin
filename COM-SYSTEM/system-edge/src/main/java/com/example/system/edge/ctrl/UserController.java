package com.example.system.edge.ctrl;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.system.base.BaseController;
import com.example.system.edge.service.IRoleService;
import com.example.system.edge.service.IUserService;
import com.example.system.vo.SysUserQueryVo;
import com.example.system.vo.SysUserRoleVo;
import com.example.system.vo.SysUserVo;
import com.zjapl.common.result.ResultEx;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Resource
    private IUserService userService;

    @Resource
    private IRoleService RoleService;

    /**
     * 查询用户列表
     *
     * @param sysUserVo
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public ResultEx queryUserList(@Validated SysUserQueryVo sysUserVo) {
        return userService.queryUserList(sysUserVo, getOrgCodeForUser());
    }
    
    @RequestMapping("/queryUserSelectList")
    @ResponseBody
    public ResultEx queryUserSelectList(){
    	return userService.queryUserSelectList(getOrgCodeForUser(),null);
    }

    /**
     * 添加或修改用户信息
     *
     * @param sysUserVo
     * @return
     */
    @RequestMapping("/addOrEdit")
    @ResponseBody
    public ResultEx addOrEditSysUser(@Validated SysUserVo sysUserVo) {
        return userService.saveOrEdit(sysUserVo, getUserIdForUser(), getOrgCodeForUser());
    }

    /**
     * 删除用户信息
     *
     * @param sysUserVo
     * @return
     */
    @RequestMapping("/editStatus")
    @ResponseBody
    public ResultEx editStatus(String ids, Short status) {
        return userService.editStatus(ids, status, getUserIdForUser(),getOrgCodeForUser());
    }

    /**
     * 根据用户ID初始化密码
     *
     * @param id
     * @return
     */
    @RequestMapping("/passwordInitById")
    @ResponseBody
    public ResultEx passwordInitById(@RequestParam("ids") String ids) {
        return userService.passwordReset(ids, getUserIdForUser());
    }

    @ResponseBody
    @RequestMapping("/saveRole")
    public ResultEx saveUserRole(SysUserRoleVo param) {
        return userService.saveUserRole(param, getUserIdForUser());
    }

    @ResponseBody
    @RequestMapping("/uploadUserPicture")
    public ResultEx uploadUserPicture(SysUserVo param) {
        return userService.uploadUserPicture(param, getUserIdForUser());
    }


}
