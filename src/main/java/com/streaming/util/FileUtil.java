package com.streaming.util;

import com.streaming.exception.BusinessException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

/**
 * 文件上传工具类
 */
@Component
public class FileUtil {

    @Value("${file.upload-dir}")
    private String uploadDir;

    /**
     * 上传文件
     * @param file 文件
     * @return 文件访问URL
     */
    public String uploadFile(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new BusinessException("文件不能为空");
        }

        // 获取文件名
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // 检查文件名是否包含非法字符
            if (fileName.contains("..")) {
                throw new BusinessException("文件名包含非法字符");
            }

            // 生成新的文件名
            String newFileName = UUID.randomUUID().toString() + 
                    fileName.substring(fileName.lastIndexOf("."));

            // 创建目标目录
            Path targetLocation = Paths.get(uploadDir).toAbsolutePath().normalize();
            Files.createDirectories(targetLocation);

            // 复制文件到目标位置
            Path targetPath = targetLocation.resolve(newFileName);
            Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

            // 返回文件访问路径
            return "/uploads/" + newFileName;

        } catch (IOException ex) {
            throw new BusinessException("文件上传失败");
        }
    }

    /**
     * 删除文件
     * @param fileUrl 文件URL
     */
    public void deleteFile(String fileUrl) {
        if (StringUtils.hasText(fileUrl)) {
            try {
                String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
                Path filePath = Paths.get(uploadDir).resolve(fileName).normalize();
                Files.deleteIfExists(filePath);
            } catch (IOException ex) {
                throw new BusinessException("文件删除失败");
            }
        }
    }
} 