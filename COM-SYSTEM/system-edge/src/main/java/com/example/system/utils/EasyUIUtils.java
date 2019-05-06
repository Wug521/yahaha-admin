package com.example.system.utils;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

/**
 * 文件名：ConvertPageInfoToEasyUI.java
 * 日　期：2016年12月29日
 * 版　权：ZJAPL
 * 作　者：wug
 * 类说明：
 */
public class EasyUIUtils {
	static Logger logger = LoggerFactory.getLogger(EasyUIUtils.class);
	@SuppressWarnings("rawtypes")
	public static  String convertPageInfoToEasyUI (PageInfo pageInfo) {	
		if (pageInfo == null ) {
			logger.warn("convert pageInfo is null.");
			return null;
		}
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		rtnMap.put("total", pageInfo.getTotal());
		rtnMap.put("page", pageInfo.getPageNum());
		rtnMap.put("rows", pageInfo.getList());
		return JSON.toJSONString(rtnMap);
	}
}
