package com.example.system.vo;

import com.github.pagehelper.PageInfo;

/**
 * 文件名：SysDictionaryVo.java
 * 日　期：2017年1月16日
 * 版　权：ZJAPL
 * 作　者：wug
 * 类说明：
 */
public class SysDictionaryVo extends PageInfo<Object>{
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 值
     */
    private String value;

    /**
     * 范围
     */
    private String scope;

    /**
     * 类型标识
     */
    private Short type;

    /**
     * 有效标识1有效  0无效
     */
    private Short available;
    
    private String ids;
    
    private String availableName;

    public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getAvailableName() {
		return availableName;
	}

	public void setAvailableName(String availableName) {
		this.availableName = availableName;
	}

	private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 获取：null
     * 表字段：ZJAPL_SYSTEM.SYS_DICTIONARY.ID
     * </pre>
     *
     * @return ZJAPL_SYSTEM.SYS_DICTIONARY.ID：null
     */
    public Long getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：null
     * 表字段：ZJAPL_SYSTEM.SYS_DICTIONARY.ID
     * </pre>
     *
     * @param id
     *            ZJAPL_SYSTEM.SYS_DICTIONARY.ID：null
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：名称
     * 表字段：ZJAPL_SYSTEM.SYS_DICTIONARY.NAME
     * </pre>
     *
     * @return ZJAPL_SYSTEM.SYS_DICTIONARY.NAME：名称
     */
    public String getName() {
        return name;
    }

    /**
     * <pre>
     * 设置：名称
     * 表字段：ZJAPL_SYSTEM.SYS_DICTIONARY.NAME
     * </pre>
     *
     * @param name
     *            ZJAPL_SYSTEM.SYS_DICTIONARY.NAME：名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * <pre>
     * 获取：值
     * 表字段：ZJAPL_SYSTEM.SYS_DICTIONARY.VALUE
     * </pre>
     *
     * @return ZJAPL_SYSTEM.SYS_DICTIONARY.VALUE：值
     */
    public String getValue() {
        return value;
    }

    /**
     * <pre>
     * 设置：值
     * 表字段：ZJAPL_SYSTEM.SYS_DICTIONARY.VALUE
     * </pre>
     *
     * @param value
     *            ZJAPL_SYSTEM.SYS_DICTIONARY.VALUE：值
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * <pre>
     * 获取：范围
     * 表字段：ZJAPL_SYSTEM.SYS_DICTIONARY.SCOPE
     * </pre>
     *
     * @return ZJAPL_SYSTEM.SYS_DICTIONARY.SCOPE：范围
     */
    public String getScope() {
        return scope;
    }

    /**
     * <pre>
     * 设置：范围
     * 表字段：ZJAPL_SYSTEM.SYS_DICTIONARY.SCOPE
     * </pre>
     *
     * @param scope
     *            ZJAPL_SYSTEM.SYS_DICTIONARY.SCOPE：范围
     */
    public void setScope(String scope) {
        this.scope = scope == null ? null : scope.trim();
    }

    /**
     * <pre>
     * 获取：类型标识
     * 表字段：ZJAPL_SYSTEM.SYS_DICTIONARY.TYPE
     * </pre>
     *
     * @return ZJAPL_SYSTEM.SYS_DICTIONARY.TYPE：类型标识
     */
    public Short getType() {
        return type;
    }

    /**
     * <pre>
     * 设置：类型标识
     * 表字段：ZJAPL_SYSTEM.SYS_DICTIONARY.TYPE
     * </pre>
     *
     * @param type
     *            ZJAPL_SYSTEM.SYS_DICTIONARY.TYPE：类型标识
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     * <pre>
     * 获取：有效标识1有效  0无效
     * 表字段：ZJAPL_SYSTEM.SYS_DICTIONARY.AVAILABLE
     * </pre>
     *
     * @return ZJAPL_SYSTEM.SYS_DICTIONARY.AVAILABLE：有效标识1有效  0无效
     */
    public Short getAvailable() {
        return available;
    }

    /**
     * <pre>
     * 设置：有效标识1有效  0无效
     * 表字段：ZJAPL_SYSTEM.SYS_DICTIONARY.AVAILABLE
     * </pre>
     *
     * @param available
     *            ZJAPL_SYSTEM.SYS_DICTIONARY.AVAILABLE：有效标识1有效  0无效
     */
    public void setAvailable(Short available) {
        this.available = available;
    }
}
