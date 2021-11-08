![](https://i.imgur.com/MmHYsJv.png)


#  建立無XML配置
1. 配置 `DispatcherServlet`
	Servlet3 和 Spring3.1 之後使用 Java _將 DispatcherServlet 配置在 Servlet 容器中_，而不會再使用 web.xml 文件。

2. 建立初始化類別 `WebAppInitializer`
	- 繼承 _抽象註解配置初始化_
	`AbstractAnnotationConfigDispatcherServletInitializer`
	同時也就實現了 WebApplicationInitializer
	因此當部署到 Servlet3.0 容器中的時候，容器會自動發現它，並用它來配置 Servlet 上下文。
	- 實現抽象方法
		1. `getServletMappings()`
			- 為 DispatcherServlet 指定 servlet 映射
			"/"，這表示它會是應用的默認 Servlet。它會處理進入應用的所有請求。
		2. `getRootConfigClasses()`
			- 返回的帶有 @Configuration 註解的類
				將會用來配置 ContextLoaderListener 創建的應用上下文中的 bean。
			- 創建用於整個Web應用程序需要共享的組件
				- DataSource , LocalSessionFactoryBean ...等
		1. `getServletConfigClasses()`
			- 返回的帶有 @Configuration 註解的類
				將會用來定義 DispatcherServlet 應用上下文中的 bean。
			- 創建用於和該Servlet相關的組件
				- Controller , ViewResovler ...等
			- `WebAppConfig` 類別，設定
				1. `@Configuration` 聲明為配置類別
				2. `@EnableWebMvc` 聲明為MVC配置
				3. `@ComponentScan` 掃描有bean所在的package


```ad-info
# web.xml 配置
[詳解Spring mvc的web.xml配置說明 | 程式前沿 (codertw.com)](https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/311861/)

```