package com.example.system.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class BeanUtils {
	/**
	 * 拷贝bean中的属性
	 * @param source
	 * @param target
	 * @param ignores
	 */
	public static void copyProperties(Object source, Object target, String... ignores){
		org.springframework.beans.BeanUtils.copyProperties(source, target, ignores);
	}
	/**
	 * 拷贝bean中的属性 忽略掉空值属性和ID属性
	 * @param source
	 * @param target
	 * @param ignores
	 */
	public static void copyPropertiesIgnoreNullValueAndId(Object source, Object target){
		copyProperties(source, target, getNullPropertyNamesAndIgnoreNames(source, "id"));
	}
	/**
	 * 拷贝bean中的属性 忽略掉空值属性
	 * @param source
	 * @param target
	 * @param ignores
	 */
	public static void copyPropertiesIgnoreNullValue(Object source, Object target){
		copyProperties(source, target, getNullPropertyNamesAndIgnoreNames(source));
	}
	/**
	 * 获取空值属性名称或者忽略
	 * @param source
	 * @param ignores
	 * @return
	 */
	public static String[] getNullPropertyNamesAndIgnoreNames (Object source, String... ignores ) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

		Set<String> emptyNames = new HashSet<String>();
		if (ignores != null && ignores.length > 0){
			emptyNames.addAll(Arrays.asList(ignores));
		}
		for(java.beans.PropertyDescriptor pd : pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null) emptyNames.add(pd.getName());
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}
}
