package com.example.yahaha.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.yahaha.entity.Likes;
import com.example.yahaha.entity.vo.CommentVo;
import com.zjapl.common.mybaits.dao.Dao;

@Repository
public interface ILikesDao extends Dao<Likes> {

	@Select("SELECT \n" +
			"(SELECT count(1) FROM `likes` where type=1 AND user_id=#{userId}  AND source_id = #{sourceId}) AS praise,\n" +
			"(SELECT count(1) FROM `likes` where type=2 AND user_id=#{userId}  AND source_id = #{sourceId}) AS trample")
	public CommentVo likesByType(@Param("userId") Long userId, @Param("sourceId") Long sourceId);
	
	@Select("SELECT \n" +
			"(SELECT count(1) FROM `likes` where type=1 AND source_id = #{sourceId}) AS praiseNum,\n" +
			"(SELECT count(1) FROM `likes` where type=2 AND source_id = #{sourceId}) AS trampleNum")
	public CommentVo likesNumByType(@Param("sourceId") Long sourceId);
	
}
