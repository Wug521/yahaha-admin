package com.example.yahaha.vip;

import com.example.system.dao.ISysUserDao;
import com.example.system.edge.service.IUserService;
import com.example.system.entity.SysUser;
import com.example.system.vo.SysUserVo;
import com.example.yahaha.entity.VipLevel;
import com.example.yahaha.entity.vo.AppUserVo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * 登陆授权
 * @author liujg
 *
 */
@Controller
@RequestMapping(value = "/app/auth")
public class AppAuthController {

	@Autowired
    WxUtils wxUtils;
	@Autowired
    IUserService sysUserService;
	@Autowired
    ISysUserDao userDao;
	@Autowired
	LevelService levelService;

	@ResponseBody
	@RequestMapping(value = "/login")
	public Object login(@RequestBody WxAppModel model) throws IOException {
		String openId = wxUtils.getOpenId(model.getCode());
		SysUser sysUser = new SysUser();
		sysUser.setUsername(openId);
		sysUser = userDao.selectOne(sysUser);
		if (sysUser == null) {
			sysUser = new SysUser();
			sysUser.setUsername(openId);
			sysUser.setPassword("21218cca77804d2ba1922c33e0151105");
			sysUser.setSex(model.getGender().shortValue());
			sysUser.setRealName(model.getNickName());
			sysUser.setAvatarUrl(model.getAvatarUrl());
			sysUser.setRemark(model.getCountry() + "-" + model.getProvince() + "-" + model.getCity());
			userDao.insert(sysUser);
		}
		AuthenticationToken token = new UsernamePasswordToken(openId,"888888");
		SecurityUtils.getSubject().login(token);
		checkIntegral(sysUser);
		VipLevel vipLevel = levelService.checkLevel(sysUser.getIntegral());
		AppUserVo userVo = new AppUserVo();
		sysUser.setPassword(null);
		userVo.level = vipLevel;
		userVo.user = sysUser;
		return new ObjectResultEx<>().makeSuccessResult(userVo);
	}

	private void checkIntegral(SysUser sysUser) {
		// 计算积分
		if (sysUser.getLoginDate() == null) {
			sysUser.setSignCount(1);
		}else{
			int betweenDay = getBetweenDay(clearDate(new Date()), clearDate(sysUser.getLoginDate()));
			if(betweenDay == 1){
				sysUser.setSignCount(sysUser.getSignCount() + 1);
			}else if (betweenDay == 0){
				return;
			}else{
				sysUser.setSignCount(1);
			}
		}
		sysUser.setLoginDate(new Date());
		if (sysUser.getSignCount() > 7) {
			sysUser.setIntegral(sysUser.getIntegral() == null ? 14 : sysUser.getIntegral() + 14);
		} else {
			sysUser.setIntegral(sysUser.getIntegral() == null ? 2 : sysUser.getIntegral() + 2);
		}
		userDao.updateByPrimaryKeySelective(sysUser);
	}

	private Date clearDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR,0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND,0);
		c.set(Calendar.MILLISECOND,0);
		return c.getTime();
	}

	private int getBetweenDay(Date d1, Date d2){
		return (int) ((d1.getTime()-d2.getTime())/86400000);
	}

}
