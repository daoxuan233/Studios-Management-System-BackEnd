-- 用户表
CREATE TABLE user (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    create_time DATETIME NOT NULL,
    update_time DATETIME NOT NULL,
    status TINYINT NOT NULL DEFAULT 1,
    role VARCHAR(20) NOT NULL
);

-- 视频表
CREATE TABLE video (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    type VARCHAR(20) NOT NULL,
    description TEXT,
    file_url VARCHAR(255) NOT NULL,
    cover_url VARCHAR(255),
    upload_user_id BIGINT NOT NULL,
    play_count BIGINT DEFAULT 0,
    status TINYINT NOT NULL DEFAULT 0,
    create_time DATETIME NOT NULL,
    update_time DATETIME NOT NULL,
    FOREIGN KEY (upload_user_id) REFERENCES user(id)
);

-- 评论表
CREATE TABLE comment (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    video_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    content TEXT NOT NULL,
    likes INT DEFAULT 0,
    status TINYINT NOT NULL DEFAULT 1,
    create_time DATETIME NOT NULL,
    update_time DATETIME NOT NULL,
    FOREIGN KEY (video_id) REFERENCES video(id),
    FOREIGN KEY (user_id) REFERENCES user(id)
); 