## matthew第一个学习项目

### 资料

[Spring 文档](https://spring.io/guides)

[Spring Web](https://docs.spring.io/spring-boot/docs/2.1.8.RELEASE/reference/html/)

[es](https://elasticsearch.cn/explore)

[BootStrap](https://v3.bootcss.com/getting-started/)

[Github OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)

[Spring](https://docs.spring.io/spring-boot/docs/2.1.8.RELEASE/reference/html/boot-features-sql.html)

[thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html)

[Markdown 插件](http://editor.md.ipandao.com/examples/)

[云服务UCloud](https://github.com/ucloud/ufile-sdk-java)

[配置日志](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features)

[云硬盘操作指南](https://docs.ucloud.cn/compute/uhost/guide/disk#%E4%BA%91%E7%A1%AC%E7%9B%98)
### 目标

[Git](https://elasticsearch.cn/)

### 工具

[Visual Paradigm用于画UML](https://www.visual-paradigm.com)

[Flyway](https://flywaydb.org/getstarted/firststeps/maven)

### 部署
#### 依赖
- Git
- JDK
- Maven
- MySQL
#### 步骤
- ssh root@106.75.120.185
- yum update
- yum install git
- mkdir App
- cd App
- git clone https://github.com/JavaMatthew/community.git
- yum install maven
- mvn -v
- mvn clean compile package
- cp src/main/resources/application.properties src/main/resources/application-production.properties
- vim src/main/resources/application-production.properties
- mvn package
- java -jar -Dspring.profiles.active=production target/community-0.0.1-SNAPSHOT.jar
- Shutting down ExecutorService 'applicationTaskExecutor'
- ps -aux | grep java


## 脚本

```bash
    mvn flyway:migrate
    mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```
```
    进入插入模式：     i

    输入内容：程序代码

    切换到命令行模式：Esc

    切换到末行模式：Shift + ：

    保存文件到桌面：w desktop

    退出：Shift + ：     q
```