package com.example.system.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class MenuVo<T> implements Comparable<Object>, Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 树形菜单的ID
	 */
	private T id;
	
	/**
	 * 树形菜单的父节点
	 */
	private T pId;

	/**
	 * 菜单名称
	 */
	private String text;
	
	/**
	 * 国际化
	 */
	private String i18n;
	/**
	 * 分组
	 */
	private Boolean group;
	/**
	 * 链接
	 */
	private String link;
	/**
	 * 图标
	 */
	private String icon;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 排序
	 */
	private Short sort;
	/**
	 * 是否选中
	 */
	private Boolean checked;
	
	@SuppressWarnings("rawtypes")
	private List<MenuVo> children = new ArrayList<MenuVo>();

	public T getpId() {
		return pId;
	}

	public void setpId(T pId) {
		this.pId = pId;
	}

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getI18n() {
		return i18n;
	}
	
	public void setI18n(String i18n) {
		this.i18n = i18n;
	}
	
	public Boolean getGroup() {
		return group;
	}
	
	public void setGroup(Boolean group) {
		this.group = group;
	}
	
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public String getIcon() {
		return icon;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public Short getSort() {
		return sort;
	}
	
	public void setSort(Short sort) {
		this.sort = sort;
	}
	
	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	@SuppressWarnings("rawtypes")
	public List<MenuVo> getChildren() {
		return children;
	}

	@SuppressWarnings("rawtypes")
	public void setChildren(List<MenuVo> children) {
		this.children = children;
	}

	/**
	 * list排序使用
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public int compareTo(Object o) {
		if (o == null){
			return -1;
		}
		MenuVo vo = (MenuVo)o;
		Short otherSort = vo.getSort();
		if (this.sort == null && otherSort == null){
			return -1;
		} else if (this.sort == null){
			return -otherSort;
		} else if (otherSort == null){
			return this.sort;
		} else {
			return this.sort.compareTo(otherSort);
		}
	}
}

