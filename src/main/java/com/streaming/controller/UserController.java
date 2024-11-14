package com.streaming.controller;

import com.streaming.dto.LoginRequest;
import com.streaming.model.User;
import com.streaming.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 用户控制器
 */
@Tag(name = "用户管理", description = "用户相关接口")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "用户注册", description = "新用户注册接口")
    @PostMapping("/register")
    public ResponseEntity<User> register(
            @Parameter(description = "用户注册信息") @Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @Operation(summary = "用户登录", description = "用户登录接口")
    @PostMapping("/login")
    public ResponseEntity<String> login(
            @Parameter(description = "登录信息") @Valid @RequestBody LoginRequest loginRequest) {
        String token = userService.login(loginRequest);
        return ResponseEntity.ok(token);
    }

    @Operation(summary = "更新用户信息", description = "更新用户个人信息")
    @PutMapping("/update-profile")
    public ResponseEntity<User> updateProfile(
            @Parameter(description = "用户信息") @Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.updateProfile(user));
    }
} 