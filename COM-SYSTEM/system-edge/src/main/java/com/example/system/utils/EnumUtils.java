package com.example.system.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.example.system.dic.CommonDictionary.Gender;
import com.example.system.entity.SysDictionary;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.util.StringUtil;

public class EnumUtils {
	static Logger logger = LoggerFactory.getLogger(EnumUtils.class);
	/**
	 * 根据枚举类型获取枚举的数据字典
	 * @param type
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ObjectResultEx<List<SysDictionary>> getEnumDics(String type){
		if (StringUtil.isEmpty(type)){
			logger.error("getEnumDics error.type is null.");
			return new ObjectResultEx<List<SysDictionary>>().makeInvalidParameterResult();
		}
		ObjectResultEx<List<SysDictionary>> resultEx = new ObjectResultEx<>();
		try {
			Class clazzType = Class.forName("com.zjapl.system.dic.CommonDictionary$" + type);
			List<SysDictionary> sysDictionarys= getEnumDics(clazzType);
			return resultEx.makeSuccessResult(sysDictionarys);
		} catch (Exception e) {
			logger.error("getEnumDics error.type[{}] is not find in CommonDictionary.", type);
		}
		return resultEx.makeInternalErrorResult();
	}

	/**
	 * 根据枚举类型获取系统数据字典
	 * @param clazz
	 * @param KeyMethodName
	 * @param valueMethodName
	 * @return
	 */
	private static <T extends Enum<T>>  List<SysDictionary> getEnumDics(Class<T> clazz) {
		String KeyMethodName = "getCode";
		String valueMethodName = "getLocalizedName";
		List<SysDictionary> sysDictionarys = new ArrayList<>();
		T[] universe = getEnumConstantsValues(clazz);
		if (universe == null)
			throw new IllegalArgumentException(clazz.getName() + " is not an enum type");
		for (T constant : universe)
			try {
				Object key = null;
				Object value = null;
				if (KeyMethodName != null && KeyMethodName.trim().length()>0) {
					Method method = constant.getClass().getMethod(KeyMethodName);
					key = method.invoke(constant);
				} 
				if (valueMethodName != null && valueMethodName.trim().length()>0) {
					Method method = constant.getClass().getMethod(valueMethodName);
					value = method.invoke(constant);
				} 
				SysDictionary tmp = new SysDictionary();
				tmp.setValue(key.toString());
				tmp.setName(String.valueOf(value));
				sysDictionarys.add(tmp);
			} catch (NoSuchMethodException e) {
				logger.error("getEnumDics error NoSuchMethodException.", e);
			} catch (InvocationTargetException e) {
				logger.error("getEnumDics error InvocationTargetException.", e);
			} catch (IllegalAccessException e) {
				logger.error("getEnumDics error IllegalAccessException.", e);
			}
		return sysDictionarys;
	}

	/**
	 * 获取枚举的常量对象
	 * @param clazz
	 * @return
	 */
	private static  <T extends Enum<T>> T[] getEnumConstantsValues(Class<T> clazz) {
		T[] enumConstants = null;
		if (enumConstants == null) {
			if (!clazz.isEnum()) return null;
			try {
				final Method values = clazz.getMethod("values");
				java.security.AccessController.doPrivileged(
						new java.security.PrivilegedAction<Void>() {
							public Void run() {
								values.setAccessible(true);
								return null;
							}
						});
				@SuppressWarnings("unchecked")
				T[] temporaryConstants = (T[])values.invoke(null);
				enumConstants = temporaryConstants;
			}
			catch (InvocationTargetException | NoSuchMethodException |
					IllegalAccessException ex) { return null; }
		}
		return enumConstants;
	}
	/**
	 * 根据枚举的名称获取枚举值
	 * @param clazz
	 * @param KeyMethodName
	 * @param valueMethodName
	 * @return
	 */
	@SuppressWarnings("unused")
	public static <T extends Enum<T>>  Short getEnumCodeByName(Class<T> clazz, String name) {
		if (StringUtil.isEmpty(name)){
			return null;
		}
		String KeyMethodName = "getCode";
		String valueMethodName = "getLocalizedName";
		List<SysDictionary> sysDictionarys = new ArrayList<>();
		T[] universe = getEnumConstantsValues(clazz);
		if (universe == null)
			throw new IllegalArgumentException(clazz.getName() + " is not an enum type");
		for (T constant : universe)
			try {
				Object key = null;
				Object value = null;
				if (KeyMethodName != null && KeyMethodName.trim().length()>0) {
					Method method = constant.getClass().getMethod(KeyMethodName);
					key = method.invoke(constant);
				} 
				if (valueMethodName != null && valueMethodName.trim().length()>0) {
					Method method = constant.getClass().getMethod(valueMethodName);
					value = method.invoke(constant);
				} 
				SysDictionary tmp = new SysDictionary();
				if (name.equals(String.valueOf(value))){
					return Short.valueOf(key.toString());
				}
			} catch (NoSuchMethodException e) {
				logger.error("getEnumDics error NoSuchMethodException.", e);
			} catch (InvocationTargetException e) {
				logger.error("getEnumDics error InvocationTargetException.", e);
			} catch (IllegalAccessException e) {
				logger.error("getEnumDics error IllegalAccessException.", e);
			}
		return null;
	}
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("开始");
		System.out.println(JSON.toJSONString(getEnumDics("Gender")));
		System.out.println(JSON.toJSONString(getEnumCodeByName(Gender.class, "男")));
		
	}
}
