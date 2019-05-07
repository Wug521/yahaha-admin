package com.example.system.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zjapl.common.util.StringUtil;

public class CommonUtil {
	
	/**
	 * 正则判断-是否是数字格式
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){ 
		   Pattern pattern = Pattern.compile("[0-9]*"); 
		   Matcher isNum = pattern.matcher(str);
		   if( !isNum.matches() ){
		       return false; 
		   } 
		   return true; 
	}
	
	/**
	 * "1,2,3"格式转list
	 * @param ids
	 * @return
	 */
	public static List<Long> idsToList(String ids){
		List<Long> idList = new ArrayList<Long>();
		if(!StringUtil.isEmpty(ids)){
			String[] strList = ids.split(",");
			for(String str : strList){
				if(isNumeric(str)){
					idList.add(Long.valueOf(str));
				}
			}
		}
		return idList;
	}
	
	/**
	 * "a,b,c"格式转list
	 * @param strs
	 * @return
	 */
	public static List<String> strsToList(String strs){
		List<String> strsList = new ArrayList<String>();
		if(!StringUtil.isEmpty(strs)){
			String[] strList = strs.split(",");
			for(String str : strList){
					strsList.add(str);
				
			}
		}
		return strsList;
	}
}
