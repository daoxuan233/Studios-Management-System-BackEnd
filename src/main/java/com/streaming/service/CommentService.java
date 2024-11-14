package com.streaming.service;

import com.streaming.model.Comment;
import java.util.List;

/**
 * 评论服务接口
 */
public interface CommentService {
    /**
     * 获取视频的所有评论
     */
    List<Comment> getVideoComments(Long videoId);

    /**
     * 添加评论
     */
    Comment addComment(Comment comment);

    /**
     * 删除评论
     */
    void deleteComment(Long id);
} 