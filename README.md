## matthew第一个学习项目

### 资料
[Spring 文档](https://spring.io/guides)

[Spring Web](https://spring.io/guides/ge/serving-web-content/)

[es](https://elasticsearch.cn/explore)

[BootStrap](https://v3.bootcss.com/getting-started/)

[Github OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)

[Spring](https://docs.spring.io/spring-boot/docs/2.1.8.RELEASE/reference/html/boot-features-sql.html)
### 目标
[Git](https://elasticsearch.cn/)
### 工具
[Visual Paradigm用于画UML](https://www.visual-paradigm.com)

## 脚本
```sql
create table USER
(
	ID INTEGER auto_increment,
	ACCOUNT_ID VARCHAR(100),
	NAME VARCHAR(50),
	TOKEN CHAR(36),
	GMT_CREATE BIGINT,
	GMT_MODIFIED BIGINT,
	constraint USER_PK
		primary key (ID)
);
```