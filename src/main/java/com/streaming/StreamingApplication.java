package com.streaming;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 流媒体播放管理系统启动类
 */
@SpringBootApplication
@MapperScan("com.streaming.mapper")
public class StreamingApplication {
    public static void main(String[] args) {
        SpringApplication.run(StreamingApplication.class, args);
    }
} 