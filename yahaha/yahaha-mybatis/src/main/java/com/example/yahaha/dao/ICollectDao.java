package com.example.yahaha.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.yahaha.entity.Collect;
import com.example.yahaha.entity.vo.CollectVo;
import com.zjapl.common.mybaits.dao.Dao;

@Repository
public interface ICollectDao extends Dao<Collect> {
	
	/*@Select("SELECT g.content,g.ids_tag_name,g.ids_category_name,g.files_path,c.type from collect c LEFT JOIN game g on c.source_id = g.id where c.type = #{type} and c.user_id = #{userId} and c.`status` = 1")
	public List<CollectVo> queryGameCollectList(@Param("type") Short type, @Param("userId") Long userId);*/
	
	@Select("SELECT n.title,n.content,n.ids_tag_name AS idsTagName,n.ids_category_name AS idsCategoryName,n.files_path AS filesPath from collect c LEFT JOIN news n on c.source_id = n.id where 1=1 and c.user_id = #{userId} and c.`status` = 1 ORDER BY n.create_date DESC")
	public List<CollectVo> queryNewsCollectList(@Param("userId") Long userId);

}
