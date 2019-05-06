/**
 * Copyright(C) 2006-2016 安普利科技
 * All rights reserved
 * 2019-05-06 17:20:15 Created
 * 
 */
package com.example.yahaha.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class GameInfo implements Serializable {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

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
     * 是否可得到
     */
    private String status;

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

    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 获取：
     * 表字段：GAME_INFO.id
     * </pre>
     *
     * @return GAME_INFO.id：
     */
    public Integer getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：GAME_INFO.id
     * </pre>
     *
     * @param id
     *            GAME_INFO.id：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：平台
     * 表字段：GAME_INFO.platform
     * </pre>
     *
     * @return GAME_INFO.platform：平台
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * <pre>
     * 设置：平台
     * 表字段：GAME_INFO.platform
     * </pre>
     *
     * @param platform
     *            GAME_INFO.platform：平台
     */
    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    /**
     * <pre>
     * 获取：游戏名称
     * 表字段：GAME_INFO.title
     * </pre>
     *
     * @return GAME_INFO.title：游戏名称
     */
    public String getTitle() {
        return title;
    }

    /**
     * <pre>
     * 设置：游戏名称
     * 表字段：GAME_INFO.title
     * </pre>
     *
     * @param title
     *            GAME_INFO.title：游戏名称
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * <pre>
     * 获取：中文标题
     * 表字段：GAME_INFO.title_zh
     * </pre>
     *
     * @return GAME_INFO.title_zh：中文标题
     */
    public String getTitleZh() {
        return titleZh;
    }

    /**
     * <pre>
     * 设置：中文标题
     * 表字段：GAME_INFO.title_zh
     * </pre>
     *
     * @param titleZh
     *            GAME_INFO.title_zh：中文标题
     */
    public void setTitleZh(String titleZh) {
        this.titleZh = titleZh == null ? null : titleZh.trim();
    }

    /**
     * <pre>
     * 获取：发行日期
     * 表字段：GAME_INFO.release_date
     * </pre>
     *
     * @return GAME_INFO.release_date：发行日期
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * <pre>
     * 设置：发行日期
     * 表字段：GAME_INFO.release_date
     * </pre>
     *
     * @param releaseDate
     *            GAME_INFO.release_date：发行日期
     */
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * <pre>
     * 获取：是否有优惠
     * 表字段：GAME_INFO.best_price
     * </pre>
     *
     * @return GAME_INFO.best_price：是否有优惠
     */
    public Integer getBestPrice() {
        return bestPrice;
    }

    /**
     * <pre>
     * 设置：是否有优惠
     * 表字段：GAME_INFO.best_price
     * </pre>
     *
     * @param bestPrice
     *            GAME_INFO.best_price：是否有优惠
     */
    public void setBestPrice(Integer bestPrice) {
        this.bestPrice = bestPrice;
    }

    /**
     * <pre>
     * 获取：当前价格
     * 表字段：GAME_INFO.current_price
     * </pre>
     *
     * @return GAME_INFO.current_price：当前价格
     */
    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    /**
     * <pre>
     * 设置：当前价格
     * 表字段：GAME_INFO.current_price
     * </pre>
     *
     * @param currentPrice
     *            GAME_INFO.current_price：当前价格
     */
    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    /**
     * <pre>
     * 获取：是否可得到
     * 表字段：GAME_INFO.status
     * </pre>
     *
     * @return GAME_INFO.status：是否可得到
     */
    public String getStatus() {
        return status;
    }

    /**
     * <pre>
     * 设置：是否可得到
     * 表字段：GAME_INFO.status
     * </pre>
     *
     * @param status
     *            GAME_INFO.status：是否可得到
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * <pre>
     * 获取：商城链接
     * 表字段：GAME_INFO.url_eshop
     * </pre>
     *
     * @return GAME_INFO.url_eshop：商城链接
     */
    public String getUrlEshop() {
        return urlEshop;
    }

    /**
     * <pre>
     * 设置：商城链接
     * 表字段：GAME_INFO.url_eshop
     * </pre>
     *
     * @param urlEshop
     *            GAME_INFO.url_eshop：商城链接
     */
    public void setUrlEshop(String urlEshop) {
        this.urlEshop = urlEshop == null ? null : urlEshop.trim();
    }

    /**
     * <pre>
     * 获取：是否有打折
     * 表字段：GAME_INFO.discount
     * </pre>
     *
     * @return GAME_INFO.discount：是否有打折
     */
    public Integer getDiscount() {
        return discount;
    }

    /**
     * <pre>
     * 设置：是否有打折
     * 表字段：GAME_INFO.discount
     * </pre>
     *
     * @param discount
     *            GAME_INFO.discount：是否有打折
     */
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    /**
     * <pre>
     * 获取：国家代码
     * 表字段：GAME_INFO.country_code
     * </pre>
     *
     * @return GAME_INFO.country_code：国家代码
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * <pre>
     * 设置：国家代码
     * 表字段：GAME_INFO.country_code
     * </pre>
     *
     * @param countryCode
     *            GAME_INFO.country_code：国家代码
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode == null ? null : countryCode.trim();
    }

    /**
     * <pre>
     * 获取：国家名称
     * 表字段：GAME_INFO.country_name
     * </pre>
     *
     * @return GAME_INFO.country_name：国家名称
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * <pre>
     * 设置：国家名称
     * 表字段：GAME_INFO.country_name
     * </pre>
     *
     * @param countryName
     *            GAME_INFO.country_name：国家名称
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName == null ? null : countryName.trim();
    }

    /**
     * <pre>
     * 获取：原价
     * 表字段：GAME_INFO.regular_price
     * </pre>
     *
     * @return GAME_INFO.regular_price：原价
     */
    public BigDecimal getRegularPrice() {
        return regularPrice;
    }

    /**
     * <pre>
     * 设置：原价
     * 表字段：GAME_INFO.regular_price
     * </pre>
     *
     * @param regularPrice
     *            GAME_INFO.regular_price：原价
     */
    public void setRegularPrice(BigDecimal regularPrice) {
        this.regularPrice = regularPrice;
    }

    /**
     * <pre>
     * 获取：折扣价
     * 表字段：GAME_INFO.discount_price
     * </pre>
     *
     * @return GAME_INFO.discount_price：折扣价
     */
    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    /**
     * <pre>
     * 设置：折扣价
     * 表字段：GAME_INFO.discount_price
     * </pre>
     *
     * @param discountPrice
     *            GAME_INFO.discount_price：折扣价
     */
    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    /**
     * <pre>
     * 获取：折扣开始日期
     * 表字段：GAME_INFO.discount_begin
     * </pre>
     *
     * @return GAME_INFO.discount_begin：折扣开始日期
     */
    public Date getDiscountBegin() {
        return discountBegin;
    }

    /**
     * <pre>
     * 设置：折扣开始日期
     * 表字段：GAME_INFO.discount_begin
     * </pre>
     *
     * @param discountBegin
     *            GAME_INFO.discount_begin：折扣开始日期
     */
    public void setDiscountBegin(Date discountBegin) {
        this.discountBegin = discountBegin;
    }

    /**
     * <pre>
     * 获取：折扣结束日期
     * 表字段：GAME_INFO.discount_end
     * </pre>
     *
     * @return GAME_INFO.discount_end：折扣结束日期
     */
    public Date getDiscountEnd() {
        return discountEnd;
    }

    /**
     * <pre>
     * 设置：折扣结束日期
     * 表字段：GAME_INFO.discount_end
     * </pre>
     *
     * @param discountEnd
     *            GAME_INFO.discount_end：折扣结束日期
     */
    public void setDiscountEnd(Date discountEnd) {
        this.discountEnd = discountEnd;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：GAME_INFO.spider_time
     * </pre>
     *
     * @return GAME_INFO.spider_time：
     */
    public Date getSpiderTime() {
        return spiderTime;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：GAME_INFO.spider_time
     * </pre>
     *
     * @param spiderTime
     *            GAME_INFO.spider_time：
     */
    public void setSpiderTime(Date spiderTime) {
        this.spiderTime = spiderTime;
    }

    /**
     * <pre>
     * 获取：折扣率
     * 表字段：GAME_INFO.percentOff
     * </pre>
     *
     * @return GAME_INFO.percentOff：折扣率
     */
    public String getPercentoff() {
        return percentoff;
    }

    /**
     * <pre>
     * 设置：折扣率
     * 表字段：GAME_INFO.percentOff
     * </pre>
     *
     * @param percentoff
     *            GAME_INFO.percentOff：折扣率
     */
    public void setPercentoff(String percentoff) {
        this.percentoff = percentoff == null ? null : percentoff.trim();
    }

    /**
     * <pre>
     * 获取：游戏图片链接
     * 表字段：GAME_INFO.image_url
     * </pre>
     *
     * @return GAME_INFO.image_url：游戏图片链接
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * <pre>
     * 设置：游戏图片链接
     * 表字段：GAME_INFO.image_url
     * </pre>
     *
     * @param imageUrl
     *            GAME_INFO.image_url：游戏图片链接
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    /**
     * <pre>
     * 获取：数据来源
     * 表字段：GAME_INFO.data_source
     * </pre>
     *
     * @return GAME_INFO.data_source：数据来源
     */
    public String getDataSource() {
        return dataSource;
    }

    /**
     * <pre>
     * 设置：数据来源
     * 表字段：GAME_INFO.data_source
     * </pre>
     *
     * @param dataSource
     *            GAME_INFO.data_source：数据来源
     */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource == null ? null : dataSource.trim();
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
        GameInfo other = (GameInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPlatform() == null ? other.getPlatform() == null : this.getPlatform().equals(other.getPlatform()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getTitleZh() == null ? other.getTitleZh() == null : this.getTitleZh().equals(other.getTitleZh()))
            && (this.getReleaseDate() == null ? other.getReleaseDate() == null : this.getReleaseDate().equals(other.getReleaseDate()))
            && (this.getBestPrice() == null ? other.getBestPrice() == null : this.getBestPrice().equals(other.getBestPrice()))
            && (this.getCurrentPrice() == null ? other.getCurrentPrice() == null : this.getCurrentPrice().equals(other.getCurrentPrice()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
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
            && (this.getDataSource() == null ? other.getDataSource() == null : this.getDataSource().equals(other.getDataSource()));
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPlatform() == null) ? 0 : getPlatform().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getTitleZh() == null) ? 0 : getTitleZh().hashCode());
        result = prime * result + ((getReleaseDate() == null) ? 0 : getReleaseDate().hashCode());
        result = prime * result + ((getBestPrice() == null) ? 0 : getBestPrice().hashCode());
        result = prime * result + ((getCurrentPrice() == null) ? 0 : getCurrentPrice().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
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
        sb.append(", platform=").append(platform);
        sb.append(", title=").append(title);
        sb.append(", titleZh=").append(titleZh);
        sb.append(", releaseDate=").append(releaseDate);
        sb.append(", bestPrice=").append(bestPrice);
        sb.append(", currentPrice=").append(currentPrice);
        sb.append(", status=").append(status);
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
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}