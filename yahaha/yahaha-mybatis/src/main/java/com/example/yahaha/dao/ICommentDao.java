package com.example.yahaha.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.yahaha.entity.Comment;
import com.example.yahaha.entity.vo.CommentVo;
import com.zjapl.common.mybaits.dao.Dao;

@Repository
public interface ICommentDao extends Dao<Comment> {
	
	@Select("SELECT \n"
			+ "c.id,c.topic_id AS topicId,c.source,c.content,"
			+ "c.from_uid AS fromUid,c.from_uname AS fromUname,c.create_date AS createDate,u.avatar_url AS avatarUrl \n"
			+ "FROM \n"
			+ "`comment` c, sys_user u \n"
			+ "WHERE \n"
			+ "c.from_uid = u.id "
			+ "AND c.topic_id = #{topicId} "
			+ "AND c.source = #{source} \n"
			+ "ORDER BY createDate DESC")
	public List<CommentVo> queryList(@Param("topicId") Long topicId, @Param("source") Short source);

}
