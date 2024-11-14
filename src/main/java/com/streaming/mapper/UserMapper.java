package com.streaming.mapper;

import com.streaming.model.User;
import org.apache.ibatis.annotations.*;

/**
 * 用户数据访问接口
 */
@Mapper
public interface UserMapper {
    
    /**
     * 通过用户名查询用户
     */
    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUsername(String username);
    
    /**
     * 插入新用户
     */
    @Insert("INSERT INTO user (username, password, email, create_time, update_time, status, role) " +
            "VALUES (#{username}, #{password}, #{email}, NOW(), NOW(), 1, 'ROLE_USER')")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);
    
    /**
     * 更新用户信息
     */
    @Update("UPDATE user SET username = #{username}, email = #{email}, " +
            "update_time = NOW() WHERE id = #{id}")
    int update(User user);
} 