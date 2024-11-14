package com.streaming.controller;

import com.streaming.model.Comment;
import com.streaming.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 评论控制器
 */
@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 获取视频评论
     */
    @GetMapping("/videos/{videoId}/comments")
    public ResponseEntity<List<Comment>> getVideoComments(@PathVariable Long videoId) {
        return ResponseEntity.ok(commentService.getVideoComments(videoId));
    }

    /**
     * 添加评论
     */
    @PostMapping("/add-comment")
    public ResponseEntity<Comment> addComment(
            @Valid @RequestBody Comment comment,
            Authentication authentication) {
        Long userId = getUserIdFromAuthentication(authentication);
        comment.setUserId(userId);
        return ResponseEntity.ok(commentService.addComment(comment));
    }

    /**
     * 删除评论
     */
    @DeleteMapping("/comments/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.ok().build();
    }

    private Long getUserIdFromAuthentication(Authentication authentication) {
        // 从JWT中获取用户ID的具体实现
        return 1L; // 临时返回，需要根据实际认证实现修改
    }
} 