# 勤工助学系统
JMU软件工程系JavaWeb期末作业
## 项目介绍
勤工助学系统旨在为学生和用人单位提供一个高效的交流平台。学生可通过系统浏览最新的用人单位招聘岗位，查询岗位类别，并可随时发表留言、提出意见或建议。用人单位登录后可以实时发布招聘岗位。用工结束后双方可互评反馈。管理人员需及时维护更新系统中的学生、用人单位、岗位等信息。

## 主要功能
- 学生功能：
  - 浏览用人单位招聘岗位信息
  - 提交申请
  - 发表留言、提出意见或建议

- 用人单位功能：
  - 发布招聘岗位信息
  - 查看申请情况
  - 互评反馈学生工作情况

- 管理人员功能：
  - 维护学生、用人单位、岗位信息
  - 处理异常情况

## 附加功能
- 注册、登录、修改密码
- 防盗链

## 技术栈
- **前端：** Thymeleaf, Bootstrap
- **后端：** SpringBoot, MySQL, Maven, MyBatis-Plus, MySQL Connector/J, Spring Boot Starter Web

## 运行方式
1. 克隆项目到本地
   ```bash
   git clone https://github.com/Linsastar/JMU-JavaWebFinal.git
2. 导入项目到IDE中
3. 配置MySQL数据库，并在`application.properties`中修改数据库连接配置
4. 运行`JavaWebFinalApplication.java`启动项目
5. 在浏览器中访问`http://localhost:8080`查看系统

## 注意事项
- 管理员账号：admin，密码：123456
- 学生和用人单位账号需要在数据库中手动添加

如有问题，请及时联系开发者。
