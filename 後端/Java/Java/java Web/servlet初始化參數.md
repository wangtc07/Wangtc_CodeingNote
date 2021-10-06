# servlet 初始化參數

## 配置 web.xml 文件

- 配置**整個 web 應用**的初始化參數
  - ```xml
    <!-- 配置整個web應用的初始化參數 -->
      <context-param>
      	<param-name>admin-email</param-name>
      	<param-value>123456@gmail.com</param-value>
      </context-param>
    ```

## servlet 初始化參數

- **注釋**進行**servlet 的參數**初始化
  - ```java
    @WebServlet(
    		name = "ConfigDemoServlet",
    		urlPatterns="/configDemo.do",
    		initParams = {
    				@WebInitParam(name= "email", value="telephone")
    		})
    ```
