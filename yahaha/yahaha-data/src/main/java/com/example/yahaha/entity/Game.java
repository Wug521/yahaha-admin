/**
 * Copyright(C) 2006-2016 安普利科技
 * All rights reserved
 * 2019-07-01 15:05:55 Created
 * 
 */
package com.example.yahaha.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Game implements Serializable {
    /**
     * 主键ID
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * 游戏介绍
     */
    private String content;

    /**
     * 标签id集合
     */
    private String idsTag;

    /**
     * 标签名称集合
     */
    private String idsTagName;

    /**
     * 分类id集合
     */
    private String idsCategory;

    /**
     * 分类名称集合
     */
    private String idsCategoryName;

    /**
     * 封面文件路径
     */
    private String filesPath;

    /**
     * 图片路径集合(逗号分隔)
     */
    private String imgFilesPath;

    /**
     * 视频路径集合(逗号分隔)
     */
    private String videoFilesPath;

    /**
     * 状态(数据)
     */
    private Short status;

    /**
     * 是否置顶
     */
    private Short top;

    /**
     * 机构编码
     */
    private String orgCode;

    /**
     * 创建人ID
     */
    private Long createUser;

    /**
     * 创建人姓名
     */
    private String createUsername;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改人
     */
    private Long updateUser;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 平台
     */
    private String platform;

    /**
     * 游戏名称
     */
    private String title;

    /**
     * 中文标题
     */
    private String titleZh;

    /**
     * 发行日期
     */
    private Date releaseDate;

    /**
     * 是否有优惠
     */
    private Integer bestPrice;

    /**
     * 当前价格
     */
    private BigDecimal currentPrice;

    /**
     * 商城链接
     */
    private String urlEshop;

    /**
     * 是否有打折
     */
    private Integer discount;

    /**
     * 国家代码
     */
    private String countryCode;

    /**
     * 国家名称
     */
    private String countryName;

    /**
     * 原价
     */
    private BigDecimal regularPrice;

    /**
     * 折扣价
     */
    private BigDecimal discountPrice;

    /**
     * 折扣开始日期
     */
    private Date discountBegin;

    /**
     * 折扣结束日期
     */
    private Date discountEnd;

    /**
     * 爬虫日期
     */
    private Date spiderTime;

    /**
     * 折扣率
     */
    private String percentoff;

    /**
     * 游戏图片链接
     */
    private String imageUrl;

    /**
     * 数据来源
     */
    private String dataSource;

    /**
     * 价格信息
     */
    private String prices;

    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 获取：主键ID
     * 表字段：game.id
     * </pre>
     *
     * @return game.id：主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：主键ID
     * 表字段：game.id
     * </pre>
     *
     * @param id
     *            game.id：主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：游戏介绍
     * 表字段：game.content
     * </pre>
     *
     * @return game.content：游戏介绍
     */
    public String getContent() {
        return content;
    }

    /**
     * <pre>
     * 设置：游戏介绍
     * 表字段：game.content
     * </pre>
     *
     * @param content
     *            game.content：游戏介绍
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * <pre>
     * 获取：标签id集合
     * 表字段：game.ids_tag
     * </pre>
     *
     * @return game.ids_tag：标签id集合
     */
    public String getIdsTag() {
        return idsTag;
    }

    /**
     * <pre>
     * 设置：标签id集合
     * 表字段：game.ids_tag
     * </pre>
     *
     * @param idsTag
     *            game.ids_tag：标签id集合
     */
    public void setIdsTag(String idsTag) {
        this.idsTag = idsTag == null ? null : idsTag.trim();
    }

    /**
     * <pre>
     * 获取：标签名称集合
     * 表字段：game.ids_tag_name
     * </pre>
     *
     * @return game.ids_tag_name：标签名称集合
     */
    public String getIdsTagName() {
        return idsTagName;
    }

    /**
     * <pre>
     * 设置：标签名称集合
     * 表字段：game.ids_tag_name
     * </pre>
     *
     * @param idsTagName
     *            game.ids_tag_name：标签名称集合
     */
    public void setIdsTagName(String idsTagName) {
        this.idsTagName = idsTagName == null ? null : idsTagName.trim();
    }

    /**
     * <pre>
     * 获取：分类id集合
     * 表字段：game.ids_category
     * </pre>
     *
     * @return game.ids_category：分类id集合
     */
    public String getIdsCategory() {
        return idsCategory;
    }

    /**
     * <pre>
     * 设置：分类id集合
     * 表字段：game.ids_category
     * </pre>
     *
     * @param idsCategory
     *            game.ids_category：分类id集合
     */
    public void setIdsCategory(String idsCategory) {
        this.idsCategory = idsCategory == null ? null : idsCategory.trim();
    }

    /**
     * <pre>
     * 获取：分类名称集合
     * 表字段：game.ids_category_name
     * </pre>
     *
     * @return game.ids_category_name：分类名称集合
     */
    public String getIdsCategoryName() {
        return idsCategoryName;
    }

    /**
     * <pre>
     * 设置：分类名称集合
     * 表字段：game.ids_category_name
     * </pre>
     *
     * @param idsCategoryName
     *            game.ids_category_name：分类名称集合
     */
    public void setIdsCategoryName(String idsCategoryName) {
        this.idsCategoryName = idsCategoryName == null ? null : idsCategoryName.trim();
    }

    /**
     * <pre>
     * 获取：封面文件路径
     * 表字段：game.files_path
     * </pre>
     *
     * @return game.files_path：封面文件路径
     */
    public String getFilesPath() {
        return filesPath;
    }

    /**
     * <pre>
     * 设置：封面文件路径
     * 表字段：game.files_path
     * </pre>
     *
     * @param filesPath
     *            game.files_path：封面文件路径
     */
    public void setFilesPath(String filesPath) {
        this.filesPath = filesPath == null ? null : filesPath.trim();
    }

    /**
     * <pre>
     * 获取：图片路径集合(逗号分隔)
     * 表字段：game.img_files_path
     * </pre>
     *
     * @return game.img_files_path：图片路径集合(逗号分隔)
     */
    public String getImgFilesPath() {
        return imgFilesPath;
    }

    /**
     * <pre>
     * 设置：图片路径集合(逗号分隔)
     * 表字段：game.img_files_path
     * </pre>
     *
     * @param imgFilesPath
     *            game.img_files_path：图片路径集合(逗号分隔)
     */
    public void setImgFilesPath(String imgFilesPath) {
        this.imgFilesPath = imgFilesPath == null ? null : imgFilesPath.trim();
    }

    /**
     * <pre>
     * 获取：视频路径集合(逗号分隔)
     * 表字段：game.video_files_path
     * </pre>
     *
     * @return game.video_files_path：视频路径集合(逗号分隔)
     */
    public String getVideoFilesPath() {
        return videoFilesPath;
    }

    /**
     * <pre>
     * 设置：视频路径集合(逗号分隔)
     * 表字段：game.video_files_path
     * </pre>
     *
     * @param videoFilesPath
     *            game.video_files_path：视频路径集合(逗号分隔)
     */
    public void setVideoFilesPath(String videoFilesPath) {
        this.videoFilesPath = videoFilesPath == null ? null : videoFilesPath.trim();
    }

    /**
     * <pre>
     * 获取：状态(数据)
     * 表字段：game.status
     * </pre>
     *
     * @return game.status：状态(数据)
     */
    public Short getStatus() {
        return status;
    }

    /**
     * <pre>
     * 设置：状态(数据)
     * 表字段：game.status
     * </pre>
     *
     * @param status
     *            game.status：状态(数据)
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * <pre>
     * 获取：是否置顶
     * 表字段：game.top
     * </pre>
     *
     * @return game.top：是否置顶
     */
    public Short getTop() {
        return top;
    }

    /**
     * <pre>
     * 设置：是否置顶
     * 表字段：game.top
     * </pre>
     *
     * @param top
     *            game.top：是否置顶
     */
    public void setTop(Short top) {
        this.top = top;
    }

    /**
     * <pre>
     * 获取：机构编码
     * 表字段：game.org_code
     * </pre>
     *
     * @return game.org_code：机构编码
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * <pre>
     * 设置：机构编码
     * 表字段：game.org_code
     * </pre>
     *
     * @param orgCode
     *            game.org_code：机构编码
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * <pre>
     * 获取：创建人ID
     * 表字段：game.create_user
     * </pre>
     *
     * @return game.create_user：创建人ID
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * <pre>
     * 设置：创建人ID
     * 表字段：game.create_user
     * </pre>
     *
     * @param createUser
     *            game.create_user：创建人ID
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * <pre>
     * 获取：创建人姓名
     * 表字段：game.create_username
     * </pre>
     *
     * @return game.create_username：创建人姓名
     */
    public String getCreateUsername() {
        return createUsername;
    }

    /**
     * <pre>
     * 设置：创建人姓名
     * 表字段：game.create_username
     * </pre>
     *
     * @param createUsername
     *            game.create_username：创建人姓名
     */
    public void setCreateUsername(String createUsername) {
        this.createUsername = createUsername == null ? null : createUsername.trim();
    }

    /**
     * <pre>
     * 获取：创建时间
     * 表字段：game.create_date
     * </pre>
     *
     * @return game.create_date：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：创建时间
     * 表字段：game.create_date
     * </pre>
     *
     * @param createDate
     *            game.create_date：创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：修改人
     * 表字段：game.update_user
     * </pre>
     *
     * @return game.update_user：修改人
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * <pre>
     * 设置：修改人
     * 表字段：game.update_user
     * </pre>
     *
     * @param updateUser
     *            game.update_user：修改人
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * <pre>
     * 获取：修改时间
     * 表字段：game.update_date
     * </pre>
     *
     * @return game.update_date：修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * <pre>
     * 设置：修改时间
     * 表字段：game.update_date
     * </pre>
     *
     * @param updateDate
     *            game.update_date：修改时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * <pre>
     * 获取：平台
     * 表字段：game.platform
     * </pre>
     *
     * @return game.platform：平台
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * <pre>
     * 设置：平台
     * 表字段：game.platform
     * </pre>
     *
     * @param platform
     *            game.platform：平台
     */
    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    /**
     * <pre>
     * 获取：游戏名称
     * 表字段：game.title
     * </pre>
     *
     * @return game.title：游戏名称
     */
    public String getTitle() {
        return title;
    }

    /**
     * <pre>
     * 设置：游戏名称
     * 表字段：game.title
     * </pre>
     *
     * @param title
     *            game.title：游戏名称
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * <pre>
     * 获取：中文标题
     * 表字段：game.title_zh
     * </pre>
     *
     * @return game.title_zh：中文标题
     */
    public String getTitleZh() {
        return titleZh;
    }

    /**
     * <pre>
     * 设置：中文标题
     * 表字段：game.title_zh
     * </pre>
     *
     * @param titleZh
     *            game.title_zh：中文标题
     */
    public void setTitleZh(String titleZh) {
        this.titleZh = titleZh == null ? null : titleZh.trim();
    }

    /**
     * <pre>
     * 获取：发行日期
     * 表字段：game.release_date
     * </pre>
     *
     * @return game.release_date：发行日期
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * <pre>
     * 设置：发行日期
     * 表字段：game.release_date
     * </pre>
     *
     * @param releaseDate
     *            game.release_date：发行日期
     */
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * <pre>
     * 获取：是否有优惠
     * 表字段：game.best_price
     * </pre>
     *
     * @return game.best_price：是否有优惠
     */
    public Integer getBestPrice() {
        return bestPrice;
    }

    /**
     * <pre>
     * 设置：是否有优惠
     * 表字段：game.best_price
     * </pre>
     *
     * @param bestPrice
     *            game.best_price：是否有优惠
     */
    public void setBestPrice(Integer bestPrice) {
        this.bestPrice = bestPrice;
    }

    /**
     * <pre>
     * 获取：当前价格
     * 表字段：game.current_price
     * </pre>
     *
     * @return game.current_price：当前价格
     */
    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    /**
     * <pre>
     * 设置：当前价格
     * 表字段：game.current_price
     * </pre>
     *
     * @param currentPrice
     *            game.current_price：当前价格
     */
    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    /**
     * <pre>
     * 获取：商城链接
     * 表字段：game.url_eshop
     * </pre>
     *
     * @return game.url_eshop：商城链接
     */
    public String getUrlEshop() {
        return urlEshop;
    }

    /**
     * <pre>
     * 设置：商城链接
     * 表字段：game.url_eshop
     * </pre>
     *
     * @param urlEshop
     *            game.url_eshop：商城链接
     */
    public void setUrlEshop(String urlEshop) {
        this.urlEshop = urlEshop == null ? null : urlEshop.trim();
    }

    /**
     * <pre>
     * 获取：是否有打折
     * 表字段：game.discount
     * </pre>
     *
     * @return game.discount：是否有打折
     */
    public Integer getDiscount() {
        return discount;
    }

    /**
     * <pre>
     * 设置：是否有打折
     * 表字段：game.discount
     * </pre>
     *
     * @param discount
     *            game.discount：是否有打折
     */
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    /**
     * <pre>
     * 获取：国家代码
     * 表字段：game.country_code
     * </pre>
     *
     * @return game.country_code：国家代码
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * <pre>
     * 设置：国家代码
     * 表字段：game.country_code
     * </pre>
     *
     * @param countryCode
     *            game.country_code：国家代码
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode == null ? null : countryCode.trim();
    }

    /**
     * <pre>
     * 获取：国家名称
     * 表字段：game.country_name
     * </pre>
     *
     * @return game.country_name：国家名称
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * <pre>
     * 设置：国家名称
     * 表字段：game.country_name
     * </pre>
     *
     * @param countryName
     *            game.country_name：国家名称
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName == null ? null : countryName.trim();
    }

    /**
     * <pre>
     * 获取：原价
     * 表字段：game.regular_price
     * </pre>
     *
     * @return game.regular_price：原价
     */
    public BigDecimal getRegularPrice() {
        return regularPrice;
    }

    /**
     * <pre>
     * 设置：原价
     * 表字段：game.regular_price
     * </pre>
     *
     * @param regularPrice
     *            game.regular_price：原价
     */
    public void setRegularPrice(BigDecimal regularPrice) {
        this.regularPrice = regularPrice;
    }

    /**
     * <pre>
     * 获取：折扣价
     * 表字段：game.discount_price
     * </pre>
     *
     * @return game.discount_price：折扣价
     */
    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    /**
     * <pre>
     * 设置：折扣价
     * 表字段：game.discount_price
     * </pre>
     *
     * @param discountPrice
     *            game.discount_price：折扣价
     */
    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    /**
     * <pre>
     * 获取：折扣开始日期
     * 表字段：game.discount_begin
     * </pre>
     *
     * @return game.discount_begin：折扣开始日期
     */
    public Date getDiscountBegin() {
        return discountBegin;
    }

    /**
     * <pre>
     * 设置：折扣开始日期
     * 表字段：game.discount_begin
     * </pre>
     *
     * @param discountBegin
     *            game.discount_begin：折扣开始日期
     */
    public void setDiscountBegin(Date discountBegin) {
        this.discountBegin = discountBegin;
    }

    /**
     * <pre>
     * 获取：折扣结束日期
     * 表字段：game.discount_end
     * </pre>
     *
     * @return game.discount_end：折扣结束日期
     */
    public Date getDiscountEnd() {
        return discountEnd;
    }

    /**
     * <pre>
     * 设置：折扣结束日期
     * 表字段：game.discount_end
     * </pre>
     *
     * @param discountEnd
     *            game.discount_end：折扣结束日期
     */
    public void setDiscountEnd(Date discountEnd) {
        this.discountEnd = discountEnd;
    }

    /**
     * <pre>
     * 获取：爬虫日期
     * 表字段：game.spider_time
     * </pre>
     *
     * @return game.spider_time：爬虫日期
     */
    public Date getSpiderTime() {
        return spiderTime;
    }

    /**
     * <pre>
     * 设置：爬虫日期
     * 表字段：game.spider_time
     * </pre>
     *
     * @param spiderTime
     *            game.spider_time：爬虫日期
     */
    public void setSpiderTime(Date spiderTime) {
        this.spiderTime = spiderTime;
    }

    /**
     * <pre>
     * 获取：折扣率
     * 表字段：game.percentOff
     * </pre>
     *
     * @return game.percentOff：折扣率
     */
    public String getPercentoff() {
        return percentoff;
    }

    /**
     * <pre>
     * 设置：折扣率
     * 表字段：game.percentOff
     * </pre>
     *
     * @param percentoff
     *            game.percentOff：折扣率
     */
    public void setPercentoff(String percentoff) {
        this.percentoff = percentoff == null ? null : percentoff.trim();
    }

    /**
     * <pre>
     * 获取：游戏图片链接
     * 表字段：game.image_url
     * </pre>
     *
     * @return game.image_url：游戏图片链接
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * <pre>
     * 设置：游戏图片链接
     * 表字段：game.image_url
     * </pre>
     *
     * @param imageUrl
     *            game.image_url：游戏图片链接
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    /**
     * <pre>
     * 获取：数据来源
     * 表字段：game.data_source
     * </pre>
     *
     * @return game.data_source：数据来源
     */
    public String getDataSource() {
        return dataSource;
    }

    /**
     * <pre>
     * 设置：数据来源
     * 表字段：game.data_source
     * </pre>
     *
     * @param dataSource
     *            game.data_source：数据来源
     */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource == null ? null : dataSource.trim();
    }

    /**
     * <pre>
     * 获取：价格信息
     * 表字段：game.prices
     * </pre>
     *
     * @return game.prices：价格信息
     */
    public String getPrices() {
        return prices;
    }

    /**
     * <pre>
     * 设置：价格信息
     * 表字段：game.prices
     * </pre>
     *
     * @param prices
     *            game.prices：价格信息
     */
    public void setPrices(String prices) {
        this.prices = prices == null ? null : prices.trim();
    }

    /**
     *
     * @param that
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Game other = (Game) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getIdsTag() == null ? other.getIdsTag() == null : this.getIdsTag().equals(other.getIdsTag()))
            && (this.getIdsTagName() == null ? other.getIdsTagName() == null : this.getIdsTagName().equals(other.getIdsTagName()))
            && (this.getIdsCategory() == null ? other.getIdsCategory() == null : this.getIdsCategory().equals(other.getIdsCategory()))
            && (this.getIdsCategoryName() == null ? other.getIdsCategoryName() == null : this.getIdsCategoryName().equals(other.getIdsCategoryName()))
            && (this.getFilesPath() == null ? other.getFilesPath() == null : this.getFilesPath().equals(other.getFilesPath()))
            && (this.getImgFilesPath() == null ? other.getImgFilesPath() == null : this.getImgFilesPath().equals(other.getImgFilesPath()))
            && (this.getVideoFilesPath() == null ? other.getVideoFilesPath() == null : this.getVideoFilesPath().equals(other.getVideoFilesPath()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTop() == null ? other.getTop() == null : this.getTop().equals(other.getTop()))
            && (this.getOrgCode() == null ? other.getOrgCode() == null : this.getOrgCode().equals(other.getOrgCode()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateUsername() == null ? other.getCreateUsername() == null : this.getCreateUsername().equals(other.getCreateUsername()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getPlatform() == null ? other.getPlatform() == null : this.getPlatform().equals(other.getPlatform()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getTitleZh() == null ? other.getTitleZh() == null : this.getTitleZh().equals(other.getTitleZh()))
            && (this.getReleaseDate() == null ? other.getReleaseDate() == null : this.getReleaseDate().equals(other.getReleaseDate()))
            && (this.getBestPrice() == null ? other.getBestPrice() == null : this.getBestPrice().equals(other.getBestPrice()))
            && (this.getCurrentPrice() == null ? other.getCurrentPrice() == null : this.getCurrentPrice().equals(other.getCurrentPrice()))
            && (this.getUrlEshop() == null ? other.getUrlEshop() == null : this.getUrlEshop().equals(other.getUrlEshop()))
            && (this.getDiscount() == null ? other.getDiscount() == null : this.getDiscount().equals(other.getDiscount()))
            && (this.getCountryCode() == null ? other.getCountryCode() == null : this.getCountryCode().equals(other.getCountryCode()))
            && (this.getCountryName() == null ? other.getCountryName() == null : this.getCountryName().equals(other.getCountryName()))
            && (this.getRegularPrice() == null ? other.getRegularPrice() == null : this.getRegularPrice().equals(other.getRegularPrice()))
            && (this.getDiscountPrice() == null ? other.getDiscountPrice() == null : this.getDiscountPrice().equals(other.getDiscountPrice()))
            && (this.getDiscountBegin() == null ? other.getDiscountBegin() == null : this.getDiscountBegin().equals(other.getDiscountBegin()))
            && (this.getDiscountEnd() == null ? other.getDiscountEnd() == null : this.getDiscountEnd().equals(other.getDiscountEnd()))
            && (this.getSpiderTime() == null ? other.getSpiderTime() == null : this.getSpiderTime().equals(other.getSpiderTime()))
            && (this.getPercentoff() == null ? other.getPercentoff() == null : this.getPercentoff().equals(other.getPercentoff()))
            && (this.getImageUrl() == null ? other.getImageUrl() == null : this.getImageUrl().equals(other.getImageUrl()))
            && (this.getDataSource() == null ? other.getDataSource() == null : this.getDataSource().equals(other.getDataSource()))
            && (this.getPrices() == null ? other.getPrices() == null : this.getPrices().equals(other.getPrices()));
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getIdsTag() == null) ? 0 : getIdsTag().hashCode());
        result = prime * result + ((getIdsTagName() == null) ? 0 : getIdsTagName().hashCode());
        result = prime * result + ((getIdsCategory() == null) ? 0 : getIdsCategory().hashCode());
        result = prime * result + ((getIdsCategoryName() == null) ? 0 : getIdsCategoryName().hashCode());
        result = prime * result + ((getFilesPath() == null) ? 0 : getFilesPath().hashCode());
        result = prime * result + ((getImgFilesPath() == null) ? 0 : getImgFilesPath().hashCode());
        result = prime * result + ((getVideoFilesPath() == null) ? 0 : getVideoFilesPath().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTop() == null) ? 0 : getTop().hashCode());
        result = prime * result + ((getOrgCode() == null) ? 0 : getOrgCode().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateUsername() == null) ? 0 : getCreateUsername().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getPlatform() == null) ? 0 : getPlatform().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getTitleZh() == null) ? 0 : getTitleZh().hashCode());
        result = prime * result + ((getReleaseDate() == null) ? 0 : getReleaseDate().hashCode());
        result = prime * result + ((getBestPrice() == null) ? 0 : getBestPrice().hashCode());
        result = prime * result + ((getCurrentPrice() == null) ? 0 : getCurrentPrice().hashCode());
        result = prime * result + ((getUrlEshop() == null) ? 0 : getUrlEshop().hashCode());
        result = prime * result + ((getDiscount() == null) ? 0 : getDiscount().hashCode());
        result = prime * result + ((getCountryCode() == null) ? 0 : getCountryCode().hashCode());
        result = prime * result + ((getCountryName() == null) ? 0 : getCountryName().hashCode());
        result = prime * result + ((getRegularPrice() == null) ? 0 : getRegularPrice().hashCode());
        result = prime * result + ((getDiscountPrice() == null) ? 0 : getDiscountPrice().hashCode());
        result = prime * result + ((getDiscountBegin() == null) ? 0 : getDiscountBegin().hashCode());
        result = prime * result + ((getDiscountEnd() == null) ? 0 : getDiscountEnd().hashCode());
        result = prime * result + ((getSpiderTime() == null) ? 0 : getSpiderTime().hashCode());
        result = prime * result + ((getPercentoff() == null) ? 0 : getPercentoff().hashCode());
        result = prime * result + ((getImageUrl() == null) ? 0 : getImageUrl().hashCode());
        result = prime * result + ((getDataSource() == null) ? 0 : getDataSource().hashCode());
        result = prime * result + ((getPrices() == null) ? 0 : getPrices().hashCode());
        return result;
    }

    /**
     *
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", content=").append(content);
        sb.append(", idsTag=").append(idsTag);
        sb.append(", idsTagName=").append(idsTagName);
        sb.append(", idsCategory=").append(idsCategory);
        sb.append(", idsCategoryName=").append(idsCategoryName);
        sb.append(", filesPath=").append(filesPath);
        sb.append(", imgFilesPath=").append(imgFilesPath);
        sb.append(", videoFilesPath=").append(videoFilesPath);
        sb.append(", status=").append(status);
        sb.append(", top=").append(top);
        sb.append(", orgCode=").append(orgCode);
        sb.append(", createUser=").append(createUser);
        sb.append(", createUsername=").append(createUsername);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", platform=").append(platform);
        sb.append(", title=").append(title);
        sb.append(", titleZh=").append(titleZh);
        sb.append(", releaseDate=").append(releaseDate);
        sb.append(", bestPrice=").append(bestPrice);
        sb.append(", currentPrice=").append(currentPrice);
        sb.append(", urlEshop=").append(urlEshop);
        sb.append(", discount=").append(discount);
        sb.append(", countryCode=").append(countryCode);
        sb.append(", countryName=").append(countryName);
        sb.append(", regularPrice=").append(regularPrice);
        sb.append(", discountPrice=").append(discountPrice);
        sb.append(", discountBegin=").append(discountBegin);
        sb.append(", discountEnd=").append(discountEnd);
        sb.append(", spiderTime=").append(spiderTime);
        sb.append(", percentoff=").append(percentoff);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", dataSource=").append(dataSource);
        sb.append(", prices=").append(prices);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}