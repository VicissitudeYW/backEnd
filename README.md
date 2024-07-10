# 厦大Java实践后端源码
> 基于SpringBoot与Mybatis框架

## 项目结构
```css
project-root
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── org.example
│   │   │   │   ├── controller
│   │   │   │   │   └── (控制类 - 控制前端交互，展示结果)
│   │   │   │   ├── mapper
│   │   │   │   │   └── (映射类 - 数据库操作)
│   │   │   │   ├── pojo
│   │   │   │   │   └──(角色类 - 映射数据库关系)
│   │   │   │   ├── service
│   │   │   │   │   └── (服务类 - 业务逻辑处理)
│   │   │   │   ├── dto
│   │   │   │   │   └── (数据传输类 - 前后端数据交互)
│   │   │   │   ├── config
│   │   │   │   │   └── (配置类)
│   │   │   │   ├── exception
│   │   │   │   │   └── (异常类 - 自定义异常)
│   │   │   │   ├── Application.java
│   │   │   │   └── ServiceException.java
│   │   │   └── (其他可能的包和类)
│   │   ├── resources
│   │   │   └── (Springboot、Mybatis的基本配置文件)
│   │   └── (其他可能的资源文件)
│   └── test
│       └── (含MyBatis的数据库操作测试)
├── target
│   └── (打包的jar文件)
└── (其他可能的项目文件，如README.md, .gitignore等)
```
<br/>

## controller包
控制类

用于交付前端，展示结果
<br/>

## mapper包
映射类

用于实现数据库操作

使用注释写法
<br/>

## pojo包
角色类

映射数据库的关系，类的属性即关系的属性
<br/>

## service包
服务类

用于专门处理业务逻辑
<br/>

## dto包
数据传输类

在前、后端数据交互中传输
<br/>

## config包
配置类

包含聊天室组件
<br/>

## exception包
自定义的异常类
<br/>

## Application类、ServiceException类
程序入口 & 服务异常
<br/>
<br/>
<br/>

## resources——基本设定与配置
Springboot、Mybatis的基本配置文件

含有数据库连接信息
<br/>
<br/>
## test
含mybatis的数据库操作测试
<br/>
<br/>
## target
含有打包的jar文件
<br/>
<br/>
