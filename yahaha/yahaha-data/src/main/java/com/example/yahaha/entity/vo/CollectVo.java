package com.example.yahaha.entity.vo;

import com.example.yahaha.entity.Collect;

public class CollectVo extends Collect {
	private static final long serialVersionUID = 1L;
	
    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签名称集合
     */
    private String idsTagName;


    /**
     * 分类名称集合
     */
    private String idsCategoryName;

    /**
     * 图片路径集合
     */
    private String filesPath;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIdsTagName() {
		return idsTagName;
	}

	public void setIdsTagName(String idsTagName) {
		this.idsTagName = idsTagName;
	}

	public String getIdsCategoryName() {
		return idsCategoryName;
	}

	public void setIdsCategoryName(String idsCategoryName) {
		this.idsCategoryName = idsCategoryName;
	}

	public String getFilesPath() {
		return filesPath;
	}

	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	}
    
    
}
