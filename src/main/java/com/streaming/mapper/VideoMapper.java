package com.streaming.mapper;

import com.streaming.model.Video;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * 视频资源数据访问接口
 */
@Mapper
public interface VideoMapper {
    
    /**
     * 查询所有视频
     */
    @Select("SELECT * FROM video WHERE status = 1")
    List<Video> findAll();
    
    /**
     * 根据ID查询视频
     */
    @Select("SELECT * FROM video WHERE id = #{id}")
    Video findById(Long id);
    
    /**
     * 插入新视频
     */
    @Insert("INSERT INTO video (title, type, description, file_url, cover_url, " +
            "upload_user_id, status, create_time, update_time) " +
            "VALUES (#{title}, #{type}, #{description}, #{fileUrl}, #{coverUrl}, " +
            "#{uploadUserId}, 0, NOW(), NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Video video);
    
    /**
     * 更新视频信息
     */
    @Update("UPDATE video SET title = #{title}, description = #{description}, " +
            "update_time = NOW() WHERE id = #{id}")
    int update(Video video);
    
    /**
     * 删除视频
     */
    @Update("UPDATE video SET status = 2, update_time = NOW() WHERE id = #{id}")
    int delete(Long id);
    
    /**
     * 搜索视频
     */
    @Select("SELECT * FROM video WHERE status = 1 AND " +
            "(title LIKE CONCAT('%', #{keyword}, '%') OR description LIKE CONCAT('%', #{keyword}, '%'))")
    List<Video> search(String keyword);
} 