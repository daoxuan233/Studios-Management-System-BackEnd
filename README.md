# 流媒体播放管理系统

## 一、项目概述
本项目是一个基于Spring Boot的流媒体播放管理系统后端服务，旨在为用户提供便捷的视频上传、播放以及丰富的互动功能，如评论、点赞等，同时确保系统的安全性和高效性。

## 二、技术栈
## 技术栈
![example](https://img.shields.io/badge/SpringBoot-2.7.0-grunt.svg)
![example](https://img.shields.io/badge/MySQL-8.0-grunt.svg)
- **Spring Boot 2.7.0**：作为项目的核心框架，提供了快速搭建项目、简化配置、内置容器等诸多便利，大大提高了开发效率。
- **Spring Security + JWT认证**：通过Spring Security实现强大的安全控制，结合JWT（JSON Web Tokens）进行用户认证，确保系统资源的安全访问，有效防止非法请求。
- **Lombok**：简化Java代码编写，通过注解自动生成常见的方法，如构造函数、Getter/Setter、ToString等，使代码更加简洁、易于维护。
- **MyBatis注解开发**：使用MyBatis的注解方式进行数据持久层操作，方便与数据库进行交互，能够高效地执行SQL语句，实现对数据的增删改查。
- **MySQL 8.0**：作为关系型数据库，存储系统的各类数据，包括用户信息、视频信息、评论信息等，确保数据的完整性和一致性。

## 三、核心功能
1. **用户管理**
    - 用户注册与登录（JWT认证）：用户可通过注册功能创建账号，注册时需提供必要信息。登录时，采用JWT认证机制，确保用户身份安全，成功登录后获取Token用于后续请求验证。
    - 用户信息管理：用户可修改个人信息，如头像、昵称、密码等，同时系统管理员可对用户信息进行全面管理，包括查询、禁用、启用等操作。
    - 基于角色的权限控制：系统定义了不同的角色，如普通用户、管理员等，每个角色具有不同的操作权限。例如，管理员可以管理所有视频资源和用户信息，而普通用户仅能进行视频播放、评论等操作。
2. **视频管理**
    - 视频上传与播放：支持用户上传各类格式的视频文件，上传过程中进行文件格式、大小等验证。视频播放采用流畅的流媒体技术，确保用户观看体验。
    - 视频信息管理：包括视频标题、简介、分类、标签等信息的编辑和管理，方便用户搜索和分类浏览视频。
    - 视频搜索功能：用户可通过关键词、分类、标签等多种方式搜索视频，快速找到感兴趣的内容。
3. **评论系统**
    - 视频评论功能：用户观看视频后可发表评论，评论内容支持文字、表情等。系统实时展示评论，并支持回复、点赞评论等互动操作。
    - 评论管理：管理员可对评论进行审核、删除等管理操作，确保评论内容符合平台规定。
4. **点赞功能**：用户可以对喜欢的视频和评论进行点赞，系统记录点赞数量，展示热门视频和优质评论。

## 四、系统特性
1. **RESTful API设计**：遵循RESTful架构风格，定义清晰的接口规范，方便前后端分离开发和与其他系统的集成，使接口具有良好的可读性和可扩展性。
2. **文件上传管理**：提供完善的文件上传机制，对上传的视频文件进行分类存储、备份，同时处理文件上传过程中的异常情况，确保文件上传的稳定性和可靠性。
3. **接口文档（Swagger UI）**：利用SpringDoc OpenAPI 3.0生成详细的接口文档，通过Swagger UI界面展示，方便前端开发人员和其他合作伙伴快速了解和调用接口，提高开发效率。
4. **容器化部署支持**：项目提供Dockerfile和docker-compose.yml文件，方便将项目容器化部署，实现快速部署、环境隔离和高效的资源利用，适用于不同的运行环境。

## 五、快速开始
1. **环境准备**
    - 确保安装JDK 11或更高版本。
    - 安装Maven 3.6及以上版本。
    - 安装并启动MySQL 8.0数据库，创建相应的数据库和表结构（可参考项目中的数据库初始化脚本）。
    - （可选）安装Docker和Docker Compose（如果需要进行容器化部署）。
2. **项目安装与运行**
    - 克隆项目代码到本地：`git clone [项目仓库地址]`。
    - 进入项目目录：`cd Studios-Management-System-BackEnd`。
    - 使用Maven构建项目：`mvn clean install`。
    - 运行项目：可以通过在IDE中运行主类（通常是包含main方法的类）启动项目，或者使用Maven命令`mvn spring-boot:run`启动。项目启动后，默认监听在本地的某个端口（如8080），可通过浏览器或其他工具访问接口进行测试（如`http://localhost:8080/api-docs`可查看接口文档）。

## 六、贡献指南
1. **代码规范**
    - 遵循Java编程规范，保持代码结构清晰、命名合理、注释适当。
    - 合理使用Lombok注解，避免过度使用导致代码可读性下降。
    - MyBatis的SQL语句编写应遵循最佳实践，确保高效性和可维护性。
2. **分支管理**
    - 创建新功能或修复bug时，从主分支（master）创建新分支，分支命名应具有描述性，如`feature/video-upload-optimization`表示优化视频上传功能的分支。
    - 完成开发后，提交代码并发起合并请求（Pull Request），详细说明所做的更改和功能实现情况。
3. **问题反馈**
    - 若发现项目中存在问题或有改进建议，欢迎在项目的GitHub仓库中提交Issue，提供详细的问题描述、复现步骤等信息，以便团队成员能够快速定位和解决问题。

## 七、许可证
本项目采用Apache-2.0许可证，详情请查看项目根目录下的LICENSE文件。

通过以上优化，使README.md文件更加清晰地展示了项目的技术架构、功能特性、快速上手方法以及贡献指南等重要信息，有助于其他开发者更好地理解和参与项目。
