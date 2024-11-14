package com.streaming.service.impl;

import com.streaming.mapper.VideoMapper;
import com.streaming.model.Video;
import com.streaming.service.VideoService;
import com.streaming.dto.VideoUploadRequest;
import com.streaming.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * 视频服务实现类
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private FileUtil fileUtil;

    @Override
    public List<Video> findAll() {
        return videoMapper.findAll();
    }

    @Override
    public Video findById(Long id) {
        return videoMapper.findById(id);
    }

    @Override
    @Transactional
    public Video upload(VideoUploadRequest request, Long userId) {
        // 上传视频文件
        String videoUrl = fileUtil.uploadFile(request.getVideoFile());
        String coverUrl = fileUtil.uploadFile(request.getCoverFile());

        // 创建视频记录
        Video video = new Video();
        video.setTitle(request.getTitle());
        video.setType(request.getType());
        video.setDescription(request.getDescription());
        video.setFileUrl(videoUrl);
        video.setCoverUrl(coverUrl);
        video.setUploadUserId(userId);

        videoMapper.insert(video);
        return video;
    }

    @Override
    @Transactional
    public Video update(Video video) {
        Video existingVideo = videoMapper.findById(video.getId());
        if (existingVideo == null) {
            throw new RuntimeException("视频不存在");
        }

        videoMapper.update(video);
        return video;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        videoMapper.delete(id);
    }

    @Override
    public List<Video> search(String keyword) {
        return videoMapper.search(keyword);
    }
} 