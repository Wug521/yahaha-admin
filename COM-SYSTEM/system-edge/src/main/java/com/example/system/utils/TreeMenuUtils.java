package com.example.system.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.example.system.vo.MenuVo;
import com.zjapl.common.util.JSONUtil;
import com.zjapl.common.util.StringUtil;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class TreeMenuUtils {
	
	static Logger logger = LoggerFactory.getLogger(TreeMenuUtils.class);
	
	public static List<MenuVo> getSortTreeMenuNodes(List<MenuVo> MenuVos){
		List<MenuVo> sortTreeMenus = getTreeMenuNodes(MenuVos);
		if (sortTreeMenus != null && sortTreeMenus.size() > 1){
			Collections.sort(sortTreeMenus);
		}
		return sortTreeMenus;
	}
	
	/**
	 * 设置叶子节点的icon
	 * @param MenuVos
	 * @param iconCls
	 */
	public static void handleTreeLeafIconCls(List<MenuVo> MenuVos, String iconCls){
		if (MenuVos != null && !MenuVos.isEmpty()){
			for (MenuVo tmp : MenuVos){
				if (tmp == null){
					continue;
				}
				if (tmp.getChildren() == null || tmp.getChildren().size() <= 0){
					if (StringUtil.isEmpty(tmp.getIcon())){
						tmp.setIcon(iconCls);
					}
				} else {
					handleTreeLeafIconCls(tmp.getChildren(), iconCls);
				}
			}
		}
	}
	
	/**
	 * 获取树形菜单所有结点
	 * @param MenuVos
	 * @return
	 */
	public static List<MenuVo> getTreeMenuNodes(List<MenuVo> MenuVos){
		List<MenuVo> rtnMenuVos = new ArrayList<MenuVo>();
		boolean isGetParentNode = false;
		if (MenuVos != null && !MenuVos.isEmpty()){
			for (MenuVo tmp : MenuVos){
				if (tmp.getpId() == null || "0".equals(tmp.getpId().toString())) {
					isGetParentNode = true;
					getTreeSonNodesByParent(MenuVos, tmp);
					rtnMenuVos.add(tmp);
				}
			}
		} else {
			logger.warn("输入树形菜单为空[{}]", JSONUtil.object2String(MenuVos));
		}
		if (!isGetParentNode){
			logger.warn("未找到所有结点的父节点。父节点的pid必须为null");
		}
		return rtnMenuVos;
	}
	
	/**
	 * 根据父节点获取树形菜单的子节点
	 * @param list
	 * @param parent
	 */
	private static void getTreeSonNodesByParent(List<MenuVo> list, MenuVo parent){
		parent.setChildren(new ArrayList<MenuVo>());
		for (MenuVo tmp : list){
			if (tmp.getpId() != null && tmp.getpId().equals(parent.getId())) {
				MenuVo childrenVo = new MenuVo();
				BeanUtils.copyProperties(tmp, childrenVo);
				childrenVo.setChildren(null);
				getTreeSonNodesByParent(list, childrenVo);
				parent.getChildren().add(childrenVo);
			}
		}
		if (parent.getChildren() != null && parent.getChildren().size() > 1){
			Collections.sort(parent.getChildren()); 
		}
	}
}

