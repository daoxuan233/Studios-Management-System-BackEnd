package com.streaming.mapper;

import com.streaming.model.Comment;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * 评论数据访问接口
 */
@Mapper
public interface CommentMapper {
    
    /**
     * 查询视频的所有评论
     */
    @Select("SELECT * FROM comment WHERE video_id = #{videoId} AND status = 1")
    List<Comment> findByVideoId(Long videoId);
    
    /**
     * 添加评论
     */
    @Insert("INSERT INTO comment (video_id, user_id, content, likes, status, create_time, update_time) " +
            "VALUES (#{videoId}, #{userId}, #{content}, 0, 1, NOW(), NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Comment comment);
    
    /**
     * 删除评论
     */
    @Update("UPDATE comment SET status = 0, update_time = NOW() WHERE id = #{id}")
    int delete(Long id);
} 