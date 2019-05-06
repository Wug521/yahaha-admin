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
	 * 文件名：CommonDictionary.java
	 * 日　期：2017年3月30日 下午1:46:55
	 * 版　权：ZJAPL
	 * 作　者：LISS
	 * 类说明：部门类型
	 */
	public static class DeptTypeCode{
		public final static short COMMON = 0;
		public final static short INSPECTDEPT = 1;
		public final static short CHECKDEPT = 2;
		public final static short GROUPS = 3;
		
	}
	public enum DeptType{
		COMMON(DeptTypeCode.COMMON, "普通部门"),
		INSPECTDEPT(DeptTypeCode.INSPECTDEPT, "巡检部门"),
		CHECKDEPT(DeptTypeCode.CHECKDEPT, "检测部门"),
		GROUPS(DeptTypeCode.GROUPS, "群组");
		
		private short code;
		public int getCode(){
			return code;
		}
		private String localizedName;
		public String getLocalizedName(){
			return localizedName;
		}
		DeptType(short code, String localizedName) {
			this.code = code;
			this.localizedName = localizedName;
		}
		public static DeptType parseCode(Short code) {
			if (code == null){
				return null;
			}
			for (DeptType deptType : values()) {
				if (deptType.code == code)
					return deptType;
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
		/**
		 * 
		 * 文件名：Dictionary.java
		 * 日　期：2017年2月8日
		 * 版　权：ZJAPL
		 * 作　者：wug
		 * 类说明：数据字典类型枚举
		 */
		public static class DictionaryCode{
			public final static short COMPANY_POSITION= 0;
			public final static short USER_FILE= 1;
			public final static short PROJECT_CATEGORY= 2;
			public final static short PROJECT_TYPE= 3;
			public final static short AUDIT_TYPE= 4;
			public final static short VEHICLE= 5;
			public final static short COST_ITEM= 6;
			public final static short CURRENCY= 7;
			public final static short BANK= 8;
			public final static short REIMBURSEMENT_CATEGORY= 10;
			public final static short RECEIVABLES= 12;
			
		}
		public enum Dictionary{
			COMPANY_POSITION(DictionaryCode.COMPANY_POSITION, "公司职位"),
			USER_FILE(DictionaryCode.USER_FILE, "人员文档"),
			PROJECT_CATEGORY(DictionaryCode.PROJECT_CATEGORY, "项目类别"),
			PROJECT_TYPE(DictionaryCode.PROJECT_TYPE, "项目类型"),
			AUDIT_TYPE(DictionaryCode.AUDIT_TYPE, "审核类型"),
			VEHICLE(DictionaryCode.VEHICLE, "交通工具"),
			COST_ITEM(DictionaryCode.COST_ITEM, "花费项目"),
			CURRENCY(DictionaryCode.CURRENCY, "币种"),
			BANK(DictionaryCode.BANK, "银行"),
			REIMBURSEMENT_CATEGORY(DictionaryCode.REIMBURSEMENT_CATEGORY, "报销类型"),
			RECEIVABLES(DictionaryCode.RECEIVABLES, "报销类型");
			
			private short code;
			public int getCode(){
				return code;
			}
			private String localizedName;
			public String getLocalizedName(){
				return localizedName;
			}
			Dictionary(short code, String localizedName) {
				this.code = code;
				this.localizedName = localizedName;
			}
			public static Dictionary parseCode(Short code) {
				if (code == null){
					return null;
				}
				for (Dictionary dictionary : values()) {
					if (dictionary.code == code)
						return dictionary;
				}
				return null;
			}
		}
		
		/**
		 * 
		 * @Description: 人员类型
		 * @author liss
		 * @date 2017年6月5日 下午2:27:05
		 */
		public static class UserTypeCode{
			public final static short DIRECTOR = 1;
			public final static short VICE_DIRECTOR = 2;
			public final static short LEADER = 3;
			public final static short EMPLOYEE= 4;
		}
		public enum  UserType{
			DIRECTOR(UserTypeCode.DIRECTOR, "局长"),
			VICE_DIRECTOR(UserTypeCode.VICE_DIRECTOR, "分管局领导"),
			LEADER(UserTypeCode.LEADER, "部门领导"),
			EMPLOYEE(UserTypeCode.EMPLOYEE, "一般工作人员");
			
			private short code;
			public int getCode(){
				return code;
			}
			private String localizedName;
			public String getLocalizedName(){
				return localizedName;
			}
			UserType(short code, String localizedName) {
				this.code = code;
				this.localizedName = localizedName;
			}
			public static UserType parseCode(Short code) {
				if (code == null){
					return null;
				}
				for (UserType userType : values()) {
					if (userType.code == code)
						return userType;
				}
				return null;
			}
		}
}

