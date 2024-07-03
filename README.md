# 厦大Java实践后端源码
> 基于SpringBoot与Mybatis框架

## 项目结构
### main.java——源码
#### controller包
控制类

用于交付前端，展示结果
<br/>
#### mapper包
映射类

用于实现数据库操作
<br/>
#### pojo包
角色类

映射数据库的关系，类的属性即关系的属性
<br/>
### service包
服务类

用于专门处理业务逻辑
<br/>
#### Application类
程序入口
<br/>
<br/>
<br/>
### resources——基本设定与配置
#### mapper包
映射类数据库操作的具体实现
xml文件
<br/>
#### Others
Springboot、Mybatis的基本配置文件
含有数据库连接信息
<br/>
<br/>
### test
含mybatis的数据库操作测试
<br/>
<br/>
### target
含有打包的jar文件
