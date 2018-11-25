# spring boot
## spring boot特性
编码：强大的生态圈，多元化搭配，各种组件，开箱即用
配置：约定大于配置
测试：七大测试框架
部署：内嵌的运行环境
监控：
		spring boot actuator
		spring boot admin
## spring boot基础
### 1.构建springboot 项目
#### Spring Initializr
Web方式：https://start.spring.io/
Idea：file ->new ->spring starter project
#### 项目结构
src/main/java
src/main/resources
src/test/java
JRE
Maven Dependenccies
src
target
mvnw
mvnw.cmd
pom.xml
#### 启动类
Spring Boot通常有一个名为*Application的入口类,在入口类里有一个main方法,这个main方法其实就是一个标准的java应用的入口方法。
在main方法中使用SpringApplication.run方法启动SpringBoot应用项目。
其中@SpringBootApplication是Spring Boot的核心注解，它是一个组合注解:

	@SpringBootApplication
		@Configration
		@EnableAutoConfiguration
		@@ComponentScan

 #### 配置文件
 1.pom.xml
 ```xml
 <?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.example</groupId>
	<artifactId>spring-boot-config</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>spring-boot-config</name>
	<description>Demo project for Spring Boot</description>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.5.17.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
<!--编码格式 -->
	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-configuration-processor</artifactId>
			<optional>true</optional>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>


</project>

 ```
 2.application.yml
 ```properties
 my:
 name: Jack
 age: 22
 number: ${random.int[100,999]}
 uuid: ${random.uuid}
 max: ${random.int(10)}
 value: ${random.value}
 greeting: Hi,I' ${my.name}
   
server:
  port: 9999
 ```
 ConfigBean.java

 	

```java
@ConfigurationProperties(prefix = "my")
@Configuration
```


​    
 ConfigController.java

 ```java
 	@RestController 
	@EnableConfigurationProperties({ConfigBean.class})
	public class ConfigController {
	@Autowired
	ConfigBean configBean;
	
	@RequestMapping(value="/config")
	public String config() {
		return configBean.toString();
	}
 ```

3.test.properties
自己编写的配置文件
```properties
com.example.name=ffffff
com.example.age=24
com.lk.name=qwe
com.lk.age=45
```
User.java
```	java
@Configuration
@PropertySource(value="classpath:test.properties")
@ConfigurationProperties(prefix="com.example")
```
MyController.java
```java
@RestController
public class MyController {
	
	/*@Value("${my.name}")
	private String name;
	@Value("${my.age}")
	private int age;
	
	@RequestMapping(value="/my")
	public String My() {
		return name+":"+age;
		
	}
*/
//	@Value("${com.example.name}")
//	private String name;
//	@Value("${com.example.age}")
//	private int age;
	
	@Autowired
	private User user;
	
	@RequestMapping(value="/user")
	public String My() {
//		return name+":"+age;
		return user.getName()+":"+user.getAge();
		

	}
```
**注解@RestController标记在类上,表示该类处理http请求,并且返回json数据**

### 3.	日志

SLF4J
常用日志框架
	Commons-log
### 4.	单元测试
Service曾单元测试
	@RunWith(SpringRunner.class)
	@SpringBootTest
Controller层单元测试
	@MockMvc实现了对Http请求的模拟
断言assertThat的使用
	assertThat（[value],[matcher statement]）;
	单元测试的回滚
		@transactional
### 5.	热部署
Spring-boot devtools
​	

### 6.	Actuator
### 7.	Admin
