package com.example.system.dic;




/**
 * 文件名：CommonDictionary.java
 * 日　期：2017年1月13日 下午12:47:20
 * 版　权：ZJAPL
 * 作　者：liujg
 * 类说明：
 * 通用系统数据字典
 */
public class CommonDictionary {
	
	public static final String SUCCESS = "success";
	
	public static final String ERROR = "error";

	/**
	 * 文件名：Constants.java
	 * 日　期：2016年12月28日 下午3:17:41
	 * 版　权：ZJAPL
	 * 作　者：liujg
	 * 类说明：材料状态枚举
	 */
	public static class EnableOrDisableCode{
		public final static Short ENABLE = 1;
		public final static Short DISABLE = 2;
		public final static Short DELETED = 3;
		
	}
	public enum EnableOrDisable{
		ENABLE(EnableOrDisableCode.ENABLE, "启用"),
		DISABLE(EnableOrDisableCode.DISABLE, "禁用"),
		DELETED(EnableOrDisableCode.DELETED, "删除");
		
		private Short code;
		public Short getCode(){
			return code;
		}
		private String localizedName;
		public String getLocalizedName(){
			return localizedName;
		}
		EnableOrDisable(Short code, String localizedName) {
			this.code = code;
			this.localizedName = localizedName;
		}
		public static EnableOrDisable parseCode(Short code) {
			if (code == null){
				return null;
			}
			for (EnableOrDisable tmp : values()) {
				if (tmp.code == code)
					return tmp;
			}
			return null;
		}
	}
	public static class GenderCode{
		public final static short MALE = 1;
		public final static short FEMALE = 2;
		public final static short UNKNOWN = 3;

	}
	public enum Gender{
		Male(GenderCode.MALE, "男"),
		Female(GenderCode.FEMALE, "女"),
		Unknown(GenderCode.UNKNOWN, "未知");

		private short code;
		public int getCode(){
			return code;
		}
		private String localizedName;
		public String getLocalizedName(){
			return localizedName;
		}
		Gender(short code, String localizedName) {
			this.code = code;
			this.localizedName = localizedName;
		}
		public static Gender parseCode(Short code) {
			if (code == null){
				return null;
			}
			for (Gender gender : values()) {
				if (gender.code == code)
					return gender;
			}
			return null;
		}
	}
	
	/**
	 * 
	 * 文件名：CommonDictionary.java
	 * 日　期：2017年2月8日
	 * 版　权：ZJAPL
	 * 作　者：wug
	 * 类说明：
	 */
	public static class YesOrNoCode{
		public final static short YES = 1;
		public final static short NO = 0;
		
	}
	public enum YesOrNo{
		YES(YesOrNoCode.YES, "是"),
		NO(YesOrNoCode.NO, "否");
		
		private short code;
		public int getCode(){
			return code;
		}
		private String localizedName;
		public String getLocalizedName(){
			return localizedName;
		}
		YesOrNo(short code, String localizedName) {
			this.code = code;
			this.localizedName = localizedName;
		}
		public static YesOrNo parseCode(Short code) {
			if (code == null){
				return null;
			}
			for (YesOrNo yesOrNo : values()) {
				if (yesOrNo.code == code)
					return yesOrNo;
			}
			return null;
		}
	}
	
	
	/**
	 * 
	 * 文件名：LoginMode.java
	 * 日　期：2017年2月8日
	 * 版　权：ZJAPL
	 * 作　者：wug
	 * 类说明：登录模式
	 */
	public static class LoginModeCode{
		public final static short ADMIN = 0;
		public final static short USER = 1;
		
	}
	
	public enum LoginMode{
		ADMIN(LoginModeCode.ADMIN, "管理模式"),
		USER(LoginModeCode.USER, "用户模式");
		
		private short code;
		public int getCode(){
			return code;
		}
		private String localizedName;
		public String getLocalizedName(){
			return localizedName;
		}
		LoginMode(short code, String localizedName) {
			this.code = code;
			this.localizedName = localizedName;
		}
		public static LoginMode parseCode(Short code) {
			if (code == null){
				return null;
			}
			for (LoginMode loginMode : values()) {
				if (loginMode.code == code)
					return loginMode;
			}
			return null;
		}
	}

}

