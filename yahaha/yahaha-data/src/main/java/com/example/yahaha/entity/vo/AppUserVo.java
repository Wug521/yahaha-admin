package com.example.yahaha.entity.vo;

import com.example.system.entity.SysUser;
import com.example.yahaha.entity.VipLevel;

/**
 * yahaha
 *
 * @author create by yangb in 2019/5/29
 */
public class AppUserVo {

    public SysUser user;
    public VipLevel level;
    public int firstLogin; // 0 不是第一次登陆  1 是第一次登陆
}
