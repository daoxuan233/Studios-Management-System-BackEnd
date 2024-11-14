package com.streaming.controller;

import com.streaming.dto.VideoUploadRequest;
import com.streaming.model.Video;
import com.streaming.service.VideoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 视频控制器
 */
@Tag(name = "视频管理", description = "视频相关接口")
@RestController
@RequestMapping("/api")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @Operation(summary = "获取所有视频", description = "获取所有已上线的视频列表")
    @GetMapping("/videos")
    public ResponseEntity<List<Video>> getAllVideos() {
        return ResponseEntity.ok(videoService.findAll());
    }

    @Operation(summary = "获取视频详情", description = "根据ID获取视频详细信息")
    @GetMapping("/videos/{id}")
    public ResponseEntity<Video> getVideo(
            @Parameter(description = "视频ID") @PathVariable Long id) {
        return ResponseEntity.ok(videoService.findById(id));
    }

    @Operation(summary = "上传视频", description = "上传新的视频资源")
    @PostMapping("/upload-video")
    public ResponseEntity<Video> uploadVideo(
            @Parameter(description = "视频上传信息") @Valid @ModelAttribute VideoUploadRequest request,
            Authentication authentication) {
        Long userId = getUserIdFromAuthentication(authentication);
        return ResponseEntity.ok(videoService.upload(request, userId));
    }

    @Operation(summary = "更新视频信息", description = "更新视频的基本信息")
    @PutMapping("/update-video/{id}")
    public ResponseEntity<Video> updateVideo(
            @Parameter(description = "视频ID") @PathVariable Long id,
            @Parameter(description = "视频信息") @Valid @RequestBody Video video) {
        video.setId(id);
        return ResponseEntity.ok(videoService.update(video));
    }

    @Operation(summary = "删除视频", description = "删除指定的视频")
    @DeleteMapping("/delete-video/{id}")
    public ResponseEntity<Void> deleteVideo(
            @Parameter(description = "视频ID") @PathVariable Long id) {
        videoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "搜索视频", description = "根据关键词搜索视频")
    @GetMapping("/search-videos")
    public ResponseEntity<List<Video>> searchVideos(
            @Parameter(description = "搜索关键词") @RequestParam String keyword) {
        return ResponseEntity.ok(videoService.search(keyword));
    }

    private Long getUserIdFromAuthentication(Authentication authentication) {
        return 1L; // 临时返回，需要根据实际认证实现修改
    }
} 