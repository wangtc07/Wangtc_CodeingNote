[SpringBoot注解最全详解(整合超详细版本)_浩瀚星空-CSDN博客_springboot注解](https://blog.csdn.net/weixin_40753536/article/details/81285046?utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control)

# 起步依賴

`spring-boot-starter-parent`

`spring-boot-starter-web`

# 配置

- 默認文件名稱 `application`

- 用自己的配置替換默認配置

    - properties

        - ```properties
            server.port=8080
            ```

    - yml / yaml

        - ```yml
            server: 
            	port: 8080
            ```

- 同級目錄下優先級: properties > yml > yaml

##  讀取配置內容

- `@Value`

    - 
		```java
        @Value("${name}")
        String name;
        ```

- `Environment`

    - 
		```java
        @Autowired
        private Environment env;
        
        env.getProperty("name");
        ```

- `@ConfigurationProperties`

    - 
		```yml
        name: wang
        person:
        	name: mayu
        	address:
        		- taiwan
        		- japan
        ```

    - 
		```java
        // 如果沒指定前綴，會抓不到person，name的值->wang
        @ConfigurationProperties(perfix = "person")  
        public class person(){
            String name;
            String[] address;
        }
        ```




## profile
用來完成不同環境下，配置動態切換功能

- 多profile文件配置

    - 自訂配置文件:  `Application-dev.properties`

    - 主配置文件，讀取配置文件

        - 
        	```properties
            spring.profiles.active=dev
          ```

- yml 一文件多配置

    - 使用 `---` 分隔
		```yml
		---
		server:
			prot:8081
		spring:
			profile: dev
		---
		server:
			prot:8082
		spring:
			prifile: test
		---
		spring:
			prifiles:
				active: dev  #指定dev的配置
		```

    

- profile激活方式
	- 配置文件(如上)
    - 虛擬機參數
		- VM options:
			- `-Dspring.profiles.active=test`
			- ![](https://i.imgur.com/CMEXx8A.png)
	- 命令行參數
		1. 打包成jar包![](https://i.imgur.com/NLV8hCd.png)
		2. 運行 `java -jar ./profiles-0.0.1-SNAPSHOT.jar`
		3. 命令行參數 Program arguments
			- `--spring.profiles.active=test`
		4. 結束 `control + c`

## 內部配置加載順序
- 啟動時，會從以下位置加載配置文件
	1. `file:./config/` 
	2. `file:./`  
	3. `classpath:/config/` classpath的/config目錄
	4. `classpath:/` classpath的根目錄

## 外部配置
[Spring Boot Reference Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.external-config)

[[SpringBoot 外部配置]]