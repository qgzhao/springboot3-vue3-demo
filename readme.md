# 🎯 用户管理系统

<p align="center">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.5.6-brightgreen.svg" alt="Spring Boot">
  <img src="https://img.shields.io/badge/Vue.js-3.4.0-blue.svg" alt="Vue.js">
  <img src="https://img.shields.io/badge/MyBatis%20Plus-3.5.5-red.svg" alt="MyBatis Plus">
  <img src="https://img.shields.io/badge/Vite-5.0.0-646CFF.svg" alt="Vite">
  <img src="https://img.shields.io/badge/License-MIT-yellow.svg" alt="License">
</p>


一个基于 **Spring Boot 3** + **MyBatis Plus** + **Vue 3** + **Vite** + **Pinia** 的现代化用户管理系统，采用前后端分离架构，实现了完整的用户认证、授权和管理功能。

## 📋 目录

- [项目简介](#项目简介)
- [技术栈](#技术栈)
- [功能特性](#功能特性)
- [项目结构](#项目结构)
- [快速开始](#快速开始)
- [详细配置](#详细配置)
- [API文档](#api文档)
- [界面预览](#界面预览)
- [开发指南](#开发指南)
- [部署说明](#部署说明)
- [常见问题](#常见问题)
- [开源协议](#开源协议)

---

## 🚀 项目简介

本项目是一个企业级用户管理系统的完整解决方案，旨在提供一个可扩展、高性能、易维护的基础框架。系统采用目前主流的技术栈，适合作为学习项目或作为新项目的脚手架使用。

### 核心特点

- 🔐 **安全可靠**：JWT Token 认证，BCrypt 密码加密
- 🎨 **现代化UI**：基于 Element Plus 的精美界面
- ⚡ **高性能**：Vite 构建，MyBatis Plus 优化
- 📱 **响应式设计**：完美适配各种屏幕尺寸
- 🔧 **易于扩展**：清晰的代码结构，遵循最佳实践
- 📊 **数据管理**：完整的 CRUD 操作，支持分页和搜索

---

## 🛠️ 技术栈

### 后端技术

| 技术            | 版本   | 说明     |
| --------------- | ------ | -------- |
| Spring Boot     | 3.5.6  | 应用框架 |
| Spring Security | 6.x    | 安全框架 |
| MyBatis Plus    | 3.5.14 | ORM 框架 |
| MySQL           | 8.0+   | 数据库   |
| JWT             | 0.12.3 | 身份认证 |
| Lombok          | Latest | 简化代码 |
| Maven           | 3.6+   | 项目管理 |

### 前端技术

| 技术         | 版本  | 说明        |
| ------------ | ----- | ----------- |
| Vue.js       | 3.4.0 | 渐进式框架  |
| Vite         | 5.0.0 | 构建工具    |
| Pinia        | 2.1.7 | 状态管理    |
| Vue Router   | 4.2.5 | 路由管理    |
| Element Plus | 2.5.0 | UI 组件库   |
| Axios        | 1.6.2 | HTTP 客户端 |

---

## ✨ 功能特性

### 用户认证

- ✅ 用户注册（用户名、密码、邮箱、手机号）
- ✅ 用户登录（JWT Token 认证）
- ✅ 自动登录（Token 持久化）
- ✅ 退出登录（清除 Token）
- ✅ 路由守卫（未登录自动跳转）

### 用户管理

- ✅ 用户列表展示（分页）
- ✅ 用户信息搜索（用户名/邮箱/手机号）
- ✅ 用户信息编辑
- ✅ 用户状态管理（启用/禁用）
- ✅ 用户删除（逻辑删除）
- ✅ 当前用户信息展示

### 系统特性

- ✅ 统一异常处理
- ✅ 统一响应格式
- ✅ 请求参数校验
- ✅ 密码加密存储
- ✅ CORS 跨域支持
- ✅ 数据库字段自动填充
- ✅ MyBatis Plus 分页插件

---

## 📁 项目结构

### 后端结构

```
backend/
├── src/main/java/com/cdvtc/demo/
│   ├── config/              # 配置类
│   │   ├── MyBatisPlusConfig.java
│   │   └── SecurityConfig.java
│   ├── controller/          # 控制器
│   │   ├── AuthController.java
│   │   └── UserController.java
│   ├── dto/                 # 数据传输对象
│   │   ├── LoginRequest.java
│   │   ├── RegisterRequest.java
│   │   └── UserUpdateRequest.java
│   ├── entity/              # 实体类
│   │   └── User.java
│   ├── mapper/              # Mapper 接口
│   │   └── UserMapper.java
│   ├── service/             # 业务逻辑层
│   │   └── UserService.java
│   ├── vo/                  # 视图对象
│   │   ├── LoginResponse.java
│   │   └── UserVO.java
│   ├── common/              # 公共类
│   │   └── Result.java
│   ├── util/                # 工具类
│   │   └── JwtUtil.java
│   ├── filter/              # 过滤器
│   │   └── JwtAuthenticationFilter.java
│   ├── exception/           # 异常处理
│   │   └── GlobalExceptionHandler.java
│   └── Application.java     # 启动类
├── src/main/resources/
│   ├── application.yml      # 配置文件
│   └── schema.sql          # 数据库脚本
└── pom.xml                 # Maven 配置
```

### 前端结构

```
frontend/
├── src/
│   ├── api/                # API 接口
│   │   ├── auth.js
│   │   └── user.js
│   ├── assets/             # 静态资源
│   ├── components/         # 公共组件
│   ├── router/             # 路由配置
│   │   └── index.js
│   ├── stores/             # Pinia 状态管理
│   │   └── user.js
│   ├── utils/              # 工具类
│   │   └── request.js
│   ├── views/              # 页面组件
│   │   ├── Login.vue
│   │   ├── Register.vue
│   │   ├── Layout.vue
│   │   ├── Home.vue
│   │   └── Users.vue
│   ├── App.vue             # 根组件
│   └── main.js             # 入口文件
├── index.html              # HTML 模板
├── vite.config.js          # Vite 配置
└── package.json            # 依赖配置
```

---

## 🚀 快速开始

### 环境要求

- **JDK**: 17 或更高版本
- **Maven**: 3.6 或更高版本
- **Node.js**: 16 或更高版本
- **MySQL**: 8.0 或更高版本

### 1️⃣ 克隆项目

```bash
git clone https://github.com/qgzhao/springboot3-vue3-demo.git
cd springboot3-vue3-demo
```

### 2️⃣ 数据库配置

```bash
# 登录 MySQL
mysql -u root -p

# 执行数据库脚本
source database.sql
```

或直接执行以下 SQL：

```sql
-- 创建数据库
CREATE DATABASE IF NOT EXISTS user_management 
DEFAULT CHARACTER SET utf8mb4 
COLLATE utf8mb4_unicode_ci;

USE user_management;

-- 创建用户表
CREATE TABLE `sys_user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` VARCHAR(50) NOT NULL COMMENT '用户名',
  `password` VARCHAR(100) NOT NULL COMMENT '密码',
  `email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
  `phone` VARCHAR(20) DEFAULT NULL COMMENT '手机号',
  `status` TINYINT NOT NULL DEFAULT 1 COMMENT '状态：0-禁用，1-启用',
  `deleted` TINYINT NOT NULL DEFAULT 0 COMMENT '逻辑删除：0-未删除，1-已删除',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`username`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统用户表';
```

### 3️⃣ 启动后端

```bash
# 进入后端目录
cd backend

# 修改 application.yml 中的数据库配置
# spring.datasource.url
# spring.datasource.username
# spring.datasource.password

# 启动项目
mvn clean install
mvn spring-boot:run

# 或使用 IDE 直接运行 Application.java
```

后端服务将在 `http://localhost:8080` 启动

### 4️⃣ 启动前端

```bash
# 进入前端目录
cd frontend

# 安装依赖
npm install

# 启动开发服务器
npm run dev
```

前端服务将在 `http://localhost:5173` 启动

### 5️⃣ 访问系统

打开浏览器访问：`http://localhost:5173`

**测试账号**：
- 用户名：`admin` / 密码：`123456`
- 用户名：`test` / 密码：`123456`

---

## ⚙️ 详细配置

### 后端配置 (application.yml)

```yaml
server:
  port: 8080                    # 服务端口

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/user_management?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai
    username: root              # 数据库用户名
    password: your_password     # 数据库密码
    driver-class-name: com.mysql.cj.jdbc.Driver

mybatis-plus:
  configuration:
    map-underscore-to-camel-case: true    # 驼峰命名转换
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl  # SQL日志
  global-config:
    db-config:
      id-type: auto             # ID自增
      logic-delete-field: deleted
      logic-delete-value: 1
      logic-not-delete-value: 0

jwt:
  secret: your-256-bit-secret-key-change-this-in-production  # JWT密钥（生产环境请修改）
  expiration: 86400000          # Token过期时间（24小时）
```

### 前端配置 (vite.config.js)

```javascript
export default defineConfig({
  server: {
    port: 5173,                 // 前端端口
    proxy: {
      '/api': {
        target: 'http://localhost:8080',  // 后端地址
        changeOrigin: true
      }
    }
  }
})
```

---

## 📖 API文档

### 认证接口

#### 用户登录

```http
POST /api/auth/login
Content-Type: application/json

{
  "username": "admin",
  "password": "123456"
}

Response:
{
  "code": 200,
  "message": "success",
  "data": {
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
    "user": {
      "id": 1,
      "username": "admin",
      "email": "admin@example.com",
      "phone": "13800138000",
      "status": 1,
      "createTime": "2024-01-01 00:00:00"
    }
  }
}
```

#### 用户注册

```http
POST /api/auth/register
Content-Type: application/json

{
  "username": "newuser",
  "password": "123456",
  "email": "user@example.com",
  "phone": "13800138888"
}

Response:
{
  "code": 200,
  "message": "success",
  "data": null
}
```

### 用户管理接口

#### 获取当前用户信息

```http
GET /api/users/current
Authorization: Bearer {token}

Response:
{
  "code": 200,
  "message": "success",
  "data": {
    "id": 1,
    "username": "admin",
    "email": "admin@example.com",
    "phone": "13800138000",
    "status": 1,
    "createTime": "2024-01-01 00:00:00"
  }
}
```

#### 获取用户列表

```http
GET /api/users?page=1&size=10&keyword=admin
Authorization: Bearer {token}

Response:
{
  "code": 200,
  "message": "success",
  "data": {
    "records": [...],
    "total": 100,
    "size": 10,
    "current": 1,
    "pages": 10
  }
}
```

#### 更新用户信息

```http
PUT /api/users
Authorization: Bearer {token}
Content-Type: application/json

{
  "id": 1,
  "email": "newemail@example.com",
  "phone": "13900139000",
  "status": 1
}

Response:
{
  "code": 200,
  "message": "success",
  "data": null
}
```

#### 删除用户

```http
DELETE /api/users/{id}
Authorization: Bearer {token}

Response:
{
  "code": 200,
  "message": "success",
  "data": null
}
```

---

## 🎨 界面预览

### 登录页面
- 精美的渐变背景
- 简洁的登录表单
- 表单验证提示

### 用户列表
- 数据表格展示
- 搜索功能
- 分页功能
- 编辑和删除操作

### 用户信息
- 个人信息展示
- 详细描述列表

---

## 👨‍💻 开发指南

### 后端开发

#### 添加新的实体类

```java
@Data
@TableName("new_table")
public class NewEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}
```

#### 添加新的Controller

```java
@RestController
@RequestMapping("/api/new")
@RequiredArgsConstructor
public class NewController {
    
    private final NewService newService;
    
    @GetMapping
    public Result<List<NewEntity>> getList() {
        return Result.success(newService.list());
    }
}
```

### 前端开发

#### 添加新的API

```javascript
// src/api/new.js
import request from '@/utils/request'

export const getNewList = () => {
  return request({
    url: '/new',
    method: 'get'
  })
}
```

#### 添加新的路由

```javascript
// src/router/index.js
{
  path: '/new',
  name: 'New',
  component: () => import('@/views/New.vue')
}
```

#### 添加新的Store

```javascript
// src/stores/new.js
import { defineStore } from 'pinia'

export const useNewStore = defineStore('new', {
  state: () => ({
    data: []
  }),
  actions: {
    async fetchData() {
      // 实现逻辑
    }
  }
})
```

---

## 🚀 部署说明

### 后端部署

#### 使用 JAR 包部署

```bash
# 打包
mvn clean package -DskipTests

# 运行
java -jar target/user-management-1.0.0.jar

# 指定配置文件
java -jar target/user-management-1.0.0.jar --spring.profiles.active=prod
```

#### 使用 Docker 部署

```dockerfile
FROM openjdk:17-jdk-slim
COPY target/user-management-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

```bash
# 构建镜像
docker build -t user-management-backend .

# 运行容器
docker run -d -p 8080:8080 user-management-backend
```

### 前端部署

#### 构建生产版本

```bash
npm run build
```

#### Nginx 配置

```nginx
server {
    listen 80;
    server_name yourdomain.com;
    
    location / {
        root /var/www/user-management;
        try_files $uri $uri/ /index.html;
    }
    
    location /api {
        proxy_pass http://localhost:8080;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
    }
}
```

---

## ❓ 常见问题

### 1. 数据库连接失败

**问题**：`Communications link failure`

**解决**：
- 检查 MySQL 服务是否启动
- 确认数据库连接信息是否正确
- 检查防火墙设置

### 2. JWT Token 验证失败

**问题**：401 Unauthorized

**解决**：
- 检查 Token 是否过期
- 确认请求头是否携带 Token
- 验证 JWT 密钥配置

### 3. 跨域问题

**问题**：CORS policy error

**解决**：
- 检查 SecurityConfig 中的 CORS 配置
- 确认前端代理配置正确

### 4. 前端依赖安装失败

**问题**：npm install 报错

**解决**：
```bash
# 清除缓存
npm cache clean --force

# 使用淘宝镜像
npm install --registry=https://registry.npmmirror.com

# 或使用 pnpm
npm install -g pnpm
pnpm install
```

---

5. 📄 开源协议

本项目基于 [MIT License](LICENSE) 开源协议。

感谢以下开源项目：

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Vue.js](https://vuejs.org/)
- [MyBatis Plus](https://baomidou.com/)
- [Element Plus](https://element-plus.org/)
- [Vite](https://vitejs.dev/)





