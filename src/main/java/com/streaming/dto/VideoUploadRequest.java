package com.streaming.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

/**
 * 视频上传请求DTO
 */
@Data
public class VideoUploadRequest {
    /**
     * 视频标题
     */
    @NotBlank(message = "视频标题不能为空")
    private String title;

    /**
     * 视频类型
     */
    @NotBlank(message = "视频类型不能为空")
    private String type;

    /**
     * 视频描述
     */
    private String description;

    /**
     * 视频文件
     */
    private MultipartFile videoFile;

    /**
     * 封面文件
     */
    private MultipartFile coverFile;
} 