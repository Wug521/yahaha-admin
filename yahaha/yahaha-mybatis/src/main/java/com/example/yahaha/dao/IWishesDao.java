package com.example.yahaha.dao;

import com.example.yahaha.entity.Wishes;
import com.example.yahaha.entity.vo.GameVo;
import com.zjapl.common.mybaits.dao.Dao;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * yahaha
 *
 * @author create by yangb in 2019/7/29
 */
@Repository
public interface IWishesDao extends Dao<Wishes> {

    @Select("SELECT\n" +
            "	g.id,\n" +
            "	g.content,\n" +
            "	g.capacity,\n" +
            "	g.player,\n" +
            "	g.cassette,\n" +
            "	g.demo,\n" +
            "	g.remark,\n" +
            "	g.ids_tag idsTag,\n" +
            "	g.ids_tag_name idsTagName,\n" +
            "	g.ids_category idsCategory,\n" +
            "	g.files_path filesPath,\n" +
            "	g.img_files_path imgFilesPath,\n" +
            "	g.video_files_path videoFilesPath,\n" +
            "	g.`status`,\n" +
            "	g.top,\n" +
            "	g.platform,\n" +
            "	g.title,\n" +
            "	g.title_zh titleZh,\n" +
            "	g.release_date releaseDate,\n" +
            "	g.best_price bestPrice,\n" +
            "	g.current_price currentPrice,\n" +
            "	g.url_eshop urlEshop,\n" +
            "	g.discount,\n" +
            "	g.country_code countryCode,\n" +
            "	g.country_name countryName,\n" +
            "	g.regular_price regularPrice,\n" +
            "	g.discount_price discountPrice,\n" +
            "	g.discount_begin discountBegin,\n" +
            "	g.discount_end discountEnd,\n" +
            "	g.spider_time spiderTime,\n" +
            "	g.prices,\n" +
            "	g.percentOff,\n" +
            "	g.image_url imageUrl,\n" +
            "	g.data_source dataSource,\n" +
            "	w.id wishId,\n" +
            "	w.create_time createTime\n" +
            "FROM\n" +
            "	`wishes` w\n" +
            "LEFT JOIN game g ON w.game_id = g.id\n" +
            "WHERE\n" +
            "w.user_id = #{0}")
    List<GameVo> querWishGame(Long userId);

    @Select("SELECT\n" +
            "	g.id,\n" +
            "	g.content,\n" +
            "	g.capacity,\n" +
            "	g.player,\n" +
            "	g.cassette,\n" +
            "	g.demo,\n" +
            "	g.remark,\n" +
            "	g.ids_tag idsTag,\n" +
            "	g.ids_tag_name idsTagName,\n" +
            "	g.ids_category idsCategory,\n" +
            "	g.files_path filesPath,\n" +
            "	g.img_files_path imgFilesPath,\n" +
            "	g.video_files_path videoFilesPath,\n" +
            "	g.`status`,\n" +
            "	g.top,\n" +
            "	g.platform,\n" +
            "	g.title,\n" +
            "	g.title_zh titleZh,\n" +
            "	g.release_date releaseDate,\n" +
            "	g.best_price bestPrice,\n" +
            "	g.current_price currentPrice,\n" +
            "	g.url_eshop urlEshop,\n" +
            "	g.discount,\n" +
            "	g.country_code countryCode,\n" +
            "	g.country_name countryName,\n" +
            "	g.regular_price regularPrice,\n" +
            "	g.discount_price discountPrice,\n" +
            "	g.discount_begin discountBegin,\n" +
            "	g.discount_end discountEnd,\n" +
            "	g.spider_time spiderTime,\n" +
            "	g.prices,\n" +
            "	g.percentOff,\n" +
            "	g.image_url imageUrl,\n" +
            "	g.data_source dataSource,\n" +
            "	w.id wishId,\n" +
            "	w.create_time createTime\n" +
            "FROM\n" +
            "	`wishes` w\n" +
            "LEFT JOIN game g ON w.game_id = g.id\n" +
            "WHERE\n" +
            "w.user_id = #{0} AND w.change_time < spider_time")
    List<GameVo> queryDiscountGame(Long userId);
}
