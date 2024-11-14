package com.streaming.service;

import com.streaming.model.User;
import com.streaming.dto.LoginRequest;

/**
 * 用户服务接口
 */
public interface UserService {
    /**
     * 用户注册
     */
    User register(User user);

    /**
     * 用户登录
     */
    String login(LoginRequest loginRequest);

    /**
     * 更新用户信息
     */
    User updateProfile(User user);

    /**
     * 根据用户名查找用户
     */
    User findByUsername(String username);
} 