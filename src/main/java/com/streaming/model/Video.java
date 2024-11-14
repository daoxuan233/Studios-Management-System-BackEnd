package com.streaming.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * 视频资源实体类
 */
@Data
@Schema(description = "视频资源实体")
public class Video {
    /**
     * 视频ID
     */
    @Schema(description = "视频ID")
    private Long id;

    /**
     * 视频标题
     */
    @Schema(description = "视频标题")
    @NotBlank(message = "视频标题不能为空")
    private String title;

    /**
     * 视频类型（电影、电视剧、综艺）
     */
    @Schema(description = "视频类型（电影、电视剧、综艺）")
    @NotBlank(message = "视频类型不能为空")
    private String type;

    /**
     * 视频简介
     */
    @Schema(description = "视频简介")
    private String description;

    /**
     * 视频文件URL
     */
    @Schema(description = "视频文件URL")
    private String fileUrl;

    /**
     * 视频封面URL
     */
    @Schema(description = "视频封面URL")
    private String coverUrl;

    /**
     * 上传用户ID
     */
    @Schema(description = "上传用户ID")
    private Long uploadUserId;

    /**
     * 播放次数
     */
    @Schema(description = "播放次数")
    private Long playCount;

    /**
     * 视频状态（0：待审核，1：已上线，2：已下线）
     */
    @Schema(description = "视频状态（0：待审核，1：已上线，2：已下线）")
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