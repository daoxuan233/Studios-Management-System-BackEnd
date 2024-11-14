package com.streaming.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * 评论实体类
 */
@Data
@Schema(description = "评论实体")
public class Comment {
    /**
     * 评论ID
     */
    @Schema(description = "评论ID")
    private Long id;

    /**
     * 视频ID
     */
    @Schema(description = "视频ID")
    @NotNull(message = "视频ID不能为空")
    private Long videoId;

    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    private Long userId;

    /**
     * 评论内容
     */
    @Schema(description = "评论内容")
    @NotBlank(message = "评论内容不能为空")
    private String content;

    /**
     * 点赞数
     */
    @Schema(description = "点赞数")
    private Integer likes;

    /**
     * 评论状态（0：已删除，1：正常）
     */
    @Schema(description = "评论状态（0：已删除，1：正常）")
    private Integer status;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
} 