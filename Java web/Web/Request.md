1. 原理
	1. Request Response 是由服務器創建，我們來使用
	2. Request: 獲取請求消息 
		Response: 設置響應消息
# Request 結構
	- ![](https://i.imgur.com/u74dRWi.png)
# Request 方法
- 獲取請求行
	- String [getMethod](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/http/HttpServletRequest.html#getMethod--)()
	- String [getContextPath](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/http/HttpServletRequest.html#getContextPath--)()
	- String [getRequestURI](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/http/HttpServletRequest.html#getRequestURI--)()
	- String [getPathInfo](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/http/HttpServletRequest.html#getPathInfo--)()
		- 返回請求的實際URL相對於請求的serlvet的url的路徑。[request.getPathInfo() 方法的作用](https://blog.csdn.net/turkeyzhou/article/details/3270289)
	- 
		```java
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        // 獲取請求方式
		        String method = request.getMethod();
		        System.out.println(method);
		
		        // 虛擬目錄
		        String contestPath  = request.getContextPath();
		        System.out.println(contestPath);
		
		        // Servlet 路徑
		        String servletPath = request.getServletPath();
		        System.out.println(servletPath);
		
		        // get 方式請求參數
		        String queryString = request.getQueryString();
		        System.out.println(queryString);
		
		        // 請求URI URL
		        String requestURI = request.getRequestURI();
		        System.out.println(requestURI);
		        StringBuffer requestURL = request.getRequestURL();
		        System.out.println(requestURL);
		
		        // 協議版本
		        String protocol = request.getProtocol();
		        System.out.println(protocol);
		
		        // 客戶ip地址
		        String localAddr = request.getLocalAddr();
		        System.out.println(localAddr);
				
				// 
				String PathInfo = request.getPathInfo();
		    }
			
		http://localhost:8080/web_demo_war_exploded/ServletRequestDemo1?name=wang
		>>>
		GET
		/web_demo_war_exploded
		/ServletRequestDemo1
		name=wang
		/web_demo_war_exploded/ServletRequestDemo1
		http://localhost:8080/web_demo_war_exploded/ServletRequestDemo1
		HTTP/1.1
		0:0:0:0:0:0:0:1
			
		```
- URI vs URL
	![](https://i.imgur.com/spD2vko.png)
	![](https://i.imgur.com/dUw2W5y.jpg)

<br><br><br>
- 獲取請求頭
	- String [getHeader](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/http/HttpServletRequest.html#getHeader-java.lang.String-)(String name)
	- [Enumeration](http://docs.oracle.com/javase/8/docs/api/java/util/Enumeration.html?is-external=true "class or interface in java.util")<[String](http://docs.oracle.com/javase/8/docs/api/java/lang/String.html?is-external=true "class or interface in java.lang")> [getHeaderNames](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/http/HttpServletRequest.html#getHeaderNames--)()
	- 
```java
// 獲取請求頭  
  
// 頭名稱  
Enumeration<String> headerNames = request.getHeaderNames();  
// 遍歷  
while (headerNames.hasMoreElements()) {  
 String name = headerNames.nextElement();  
 // 根據名稱獲得請求頭的值  
 String header = request.getHeader(name);  
 System.out.println(name + "---" + header);
```
<br>

- 獲取請求體
	- [BufferedReader](http://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html?is-external=true "class or interface in java.io") [getReader](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/ServletRequest.html#getReader--)()
	- [ServletInputStream](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/ServletInputStream.html "class in javax.servlet")  [getInputStream](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/ServletRequest.html#getInputStream--)()
	- 

		```html
		<form action="/web_demo_war_exploded/ServletRequestDemo5" method="post"\>  
		 <input type="text" PLACEHOLDER="帳號" name="username"\><br>  
		 <input type="text" placeholder="密碼" nam="password"\><br>  
		 <input type="submit" value="註冊"\>  
		  
		</form>
		```
		```java
		// 請求消息  
		  
		BufferedReader br = request.getReader();  
		  
		String line = null;  
		while ((line = br.readLine()) != null) {  
		 System.out.println(line);  
		}
		```

![](https://i.imgur.com/ClNtSIk.png)

- 其他功能
	1. 獲取請求通用方式(get post都可以用)
		- String &nbsp[getParameter](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/ServletRequest.html#getParameter-java.lang.String-)([String](http://docs.oracle.com/javase/8/docs/api/java/lang/String.html?is-external=true "class or interface in java.lang") name)
			- 根據參數名稱獲得==參數值==
		- String[] &nbsp[getParameterValues](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/ServletRequest.html#getParameterValues-java.lang.String-)([String](http://docs.oracle.com/javase/8/docs/api/java/lang/String.html?is-external=true "class or interface in java.lang") name)
			- 根據參數名稱獲得==參數值的陣列==
		- [Enumeration](http://docs.oracle.com/javase/8/docs/api/java/util/Enumeration.html?is-external=true "class or interface in java.util")<[String](http://docs.oracle.com/javase/8/docs/api/java/lang/String.html?is-external=true "class or interface in java.lang")> &nbsp[getParameterNames](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/ServletRequest.html#getParameterNames--)()
			- 獲取所有==請求的參數名稱==
		- Map<String,String[]> [getParameterMap](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/ServletRequest.html#getParameterMap--)()
			- 獲取所有==參數的map集合==

	2. 中文亂碼
		- 獲取請求前設置編碼(依HTML設定)
		`request.setCharacterEncoding("UTF-8");`
	
	2. 請求轉發
		> 特點: 
		> 1.瀏覽器網址不產生變化 (==重整後會發出同樣請求==)
		> 2.只能轉發內部資源
		> 3.一次請求
		1. ==獲取RequestDispatcher對象==
			- [RequestDispatcher](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/RequestDispatcher.html "interface in javax.servlet")  &nbsp[getRequestDispatcher](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/ServletRequest.html#getRequestDispatcher-java.lang.String-)  (String path)
		2. 再使用 `RequestDispatcher` 的方法==轉法==
			[forward](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/RequestDispatcher.html#forward-javax.servlet.ServletRequest-javax.servlet.ServletResponse-)([ServletRequest](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/ServletRequest.html "interface in javax.servlet") request, [ServletResponse](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/ServletResponse.html "interface in javax.servlet") response)
			![](https://i.imgur.com/tpxYL1o.png)
	3. 共享數據
		- 域對象
		- request域: 一次請求的範圍，用於請求轉發的多個資源中共享數據
			- [setAttribute](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/ServletRequest.html#setAttribute-java.lang.String-java.lang.Object-)( [String](http://docs.oracle.com/javase/8/docs/api/java/lang/String.html?is-external=true "class or interface in java.lang") name, [Object](http://docs.oracle.com/javase/8/docs/api/java/lang/Object.html?is-external=true "class or interface in java.lang") o)
				- 儲存數據
			- Object &nbsp [getAttribute](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/ServletRequest.html#getAttribute-java.lang.String-)([String](http://docs.oracle.com/javase/8/docs/api/java/lang/String.html?is-external=true "class or interface in java.lang") name)
				- 通過 key 獲取值
			- [removeAttribute](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/ServletRequest.html#removeAttribute-java.lang.String-)([String](http://docs.oracle.com/javase/8/docs/api/java/lang/String.html?is-external=true "class or interface in java.lang") name)
				- 通過 key 移除值
	4. 獲取 `ServletContext`
		- ServletContext &nbsp [getServletContext](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/ServletRequest.html#getServletContext--)()

<br><br><br>

## URL模式

```java
getRequestURL() = http://localhost:8080/java/resources/request.jsp
getRequestURI() = java/resources/request.jsp
getContextPath() = java
getServletPath() = resources/request.jsp
getPathInfo()= request.jsp
```
