package com.example.system.base;

import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.example.system.entity.SysUser;
import com.example.system.shiro.ShiroUtils;
import com.zjapl.common.util.DateUtil;
import com.zjapl.common.vo.TreeMenuVo;


@Controller
public abstract class BaseController{
	/**
	 * 从shiro中获取用户信息
	 * @return
	 */
	public SysUser getSysUser() {
		return ShiroUtils.getShiroPrincipal().getSysUser();
	}
	/**
	 * 从shiro中获取用户信息
	 * @return
	 */
	public List<TreeMenuVo> getMenuList() {
		return ShiroUtils.getShiroPrincipal().getMenuList();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			public void setAsText(String value) {
				try {
					if (StringUtils.isNotBlank(value)) {
						Date d = DateUtil.parseDate(value, DateUtil.FORMAT_LONG,
								DateUtil.getDatePattern(),DateUtil.FORMAT_MIN);

						setValue(d);

					} else {
						setValue(null);
					}
				} catch (Exception e) {
					setValue(null);
				}
			}
		});

		binder.registerCustomEditor(Integer.class, new PropertyEditorSupport() {
			public void setAsText(String value) {
				try {
					if (StringUtils.isNotBlank(value)) {
						setValue(Integer.valueOf(value));
					} else {
						setValue(null);
					}
				} catch (Exception e) {
					setValue(null);
				}
			}
		});
		binder.registerCustomEditor(Long.class, new PropertyEditorSupport() {
			public void setAsText(String value) {
				try {
					if (StringUtils.isNotBlank(value)) {
						setValue(Long.valueOf(value));
					} else {
						setValue(null);
					}
				} catch (Exception e) {
					setValue(null);
				}
			}
		});
		binder.registerCustomEditor(Double.class, new PropertyEditorSupport() {
			public void setAsText(String value) {
				try {
					if (StringUtils.isNotBlank(value)) {
						setValue(Double.valueOf(value));
					} else {
						setValue(null);
					}
				} catch (Exception e) {
					setValue(null);
				}
			}
		});

		binder.registerCustomEditor(BigDecimal.class,new PropertyEditorSupport() {
			public void setAsText(String value) {
				try {
					if (StringUtils.isNotBlank(value)) {
						setValue(new BigDecimal(value));
					} else {
						setValue(null);
					}
				} catch (Exception e) {
					setValue(null);
				}
			}
		});
	}


}
