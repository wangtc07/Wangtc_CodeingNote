# 配置位置
1.  Default properties (specified by setting ).`SpringApplication.setDefaultProperties`
    
2.  [`@PropertySource`](https://docs.spring.io/spring-framework/docs/5.3.10/javadoc-api/org/springframework/context/annotation/PropertySource.html) annotations on your classes. Please note that such property sources are not added to the until the application context is being refreshed. This is too late to configure certain properties such as and which are read before refresh begins.`@Configuration``Environment``logging.*``spring.main.*`
    
3.  Config data (such as files)`application.properties`
    
4.  A that has properties only in .`RandomValuePropertySource``random.*`
    
5.  OS environment variables.
    
6.  Java System properties ().`System.getProperties()`
    
7.  JNDI attributes from .`java:comp/env`
    
8.  `ServletContext` init parameters.
    
9.  `ServletConfig` init parameters.
    
10.  Properties from (inline JSON embedded in an environment variable or system property).`SPRING_APPLICATION_JSON`
    
11.  Command line arguments.
    
12.  `properties` attribute on your tests. Available on [`@SpringBootTest`](https://docs.spring.io/spring-boot/docs/2.5.5/api/org/springframework/boot/test/context/SpringBootTest.html) and the [test annotations for testing a particular slice of your application](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.testing.spring-boot-applications.autoconfigured-tests).
    
13.  [`@TestPropertySource`](https://docs.spring.io/spring-framework/docs/5.3.10/javadoc-api/org/springframework/test/context/TestPropertySource.html) annotations on your tests.
    
14.  [Devtools global settings properties](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using.devtools.globalsettings) in the directory when devtools is active.`$HOME/.config/spring-boot`
    

Config data files are considered in the following order:
預設加載
1.  [Application properties](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.external-config.files) packaged inside your jar ( and YAML variants).`application.properties`
    
2.  [Profile-specific application properties](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.external-config.files.profile-specific) packaged inside your jar ( and YAML variants).`application-{profile}.properties`
    
3.  [Application properties](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.external-config.files) outside of your packaged jar ( and YAML variants).`application.properties`
	- 外部同級目錄下， `application.properties` 文件
    
4.  [Profile-specific application properties](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.external-config.files.profile-specific) outside of your packaged jar ( and YAML variants).`application-{profile}.properties`


# 外部文件
[外部文件](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.external-config.files)
```text
$ java -jar myproject.jar --spring.config.location=\
    optional:classpath:/default.properties,\
    optional:classpath:/override.properties
```