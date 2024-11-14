package com.streaming.service.impl;

import com.streaming.mapper.CommentMapper;
import com.streaming.model.Comment;
import com.streaming.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * 评论服务实现类
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getVideoComments(Long videoId) {
        return commentMapper.findByVideoId(videoId);
    }

    @Override
    @Transactional
    public Comment addComment(Comment comment) {
        commentMapper.insert(comment);
        return comment;
    }

    @Override
    @Transactional
    public void deleteComment(Long id) {
        commentMapper.delete(id);
    }
} 