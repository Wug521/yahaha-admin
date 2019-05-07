package com.example.system.edge.service;

import java.util.List;

import com.example.system.entity.SysUser;
import com.example.system.vo.SysUserQueryVo;
import com.example.system.vo.SysUserRoleVo;
import com.example.system.vo.SysUserVo;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;

public interface IUserService {

    /**
     * 增加或修改用户
     *
     * @param user
     * @return
     */
    public ResultEx saveOrEdit(SysUserVo user, Long userId, String orgCode);

    /**
     * 查询用户列表
     *
     * @param sysUserVo
     * @return
     */
    public ObjectResultEx<PageInfo<SysUserVo>> queryUserList(SysUserQueryVo user, String orgCode);
    
    /**
     * 查询用户列表
     *
     * @param sysUserVo
     * @return
     */
    public ObjectResultEx<List<SysUser>> queryUserSelectList(String orgCode,String name);

    /**
     * 根据id查询当前用户信息（有效用户）
     *
     * @param orgCode
     * @return
     */
    public ResultEx queryUserInfoById(Long userId,String orgCode);
    
    /**
     * 用户登录(手机号)
     *
     * @param username
     * @return
     */
    public ResultEx queryByPhone(String phone, String orgCode);
    
    /**
     * 修改用户状态
     *
     * @param ids
     * @param status
     * @param sysUser
     * @return
     */
    public ResultEx editStatus(String ids, Short status, Long userId, String orgCode);


    /**
     * 保存用户角色
     *
     * @param user
     * @return
     */
    public ResultEx saveUserRole(SysUserRoleVo param, Long userId);

    /**
     * 重置密码
     *
     * @param user
     * @return
     */
    public ResultEx passwordReset(String ids, Long userId);

    /**
     * 根据token查询用户信息
     *
     * @param username
     * @return
     */
    public ResultEx getSysUserByToken(String token);

    /**
     * 根据用户ID更新token
     *
     * @param userId 用户ID
     * @param token
     */
    public ResultEx updateUserTokenById(Long userId, String token);

    /**
     * 上传人员头像
     * @param user
     * @param userId
     * @return
     */
    public ResultEx uploadUserPicture(SysUserVo user, Long userId);
    
    /**
     * 修改密码
     * @param passward 新密码
     * @param phone 执行操作的用户
     * @return
     */
    ResultEx changePassword(String password, String confirmPwd, String phone);
    
}
