# 开发人员必读
## 1、开发规则
#### 1）、数据交互，Controller-->Service-->Mapper
#### 2）、Controller必须添加“private static Logger log = LoggerFactory.getLogger(LoginController.class);”
## 2、登录错误反馈
#### 0001 账号输入错误，数据库没有该账户
#### 0002 密码输入错误
#### 0003 账号输入不合法
