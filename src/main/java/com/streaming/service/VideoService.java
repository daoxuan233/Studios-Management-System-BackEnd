package com.streaming.service;

import com.streaming.model.Video;
import com.streaming.dto.VideoUploadRequest;
import java.util.List;

/**
 * 视频服务接口
 */
public interface VideoService {
    /**
     * 获取所有视频
     */
    List<Video> findAll();

    /**
     * 根据ID获取视频
     */
    Video findById(Long id);

    /**
     * 上传视频
     */
    Video upload(VideoUploadRequest request, Long userId);

    /**
     * 更新视频信息
     */
    Video update(Video video);

    /**
     * 删除视频
     */
    void delete(Long id);

    /**
     * 搜索视频
     */
    List<Video> search(String keyword);
} 