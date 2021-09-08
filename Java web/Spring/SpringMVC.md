# SpringMVC
[[SpringMVC 配置]]
[[Spring 例外處理]]

# 獲得請求數據
- 方法參數名稱和請求的參數的 name 一致，會自動映射數據
	```java
	@RequestMapping(value="/quick11")
	@ResponseBody
	public void save11(String username,int age) throws IOException {
	    System.out.println(username);
	    System.out.println(age);
	}
	```

- 獲取POJO類型參數
	- 方法參數對應的實體類，和請求的 name 一致
	```java
	public class User {
		private String username; 
		private int age; 
		getter/setter...
	}
	@RequestMapping("/quick12")
	@ResponseBody
	public void quickMethod10(User user) throws IOException {
		System.out.println(user); }
	```
	
- 獲取Array類型參數
	```java
	@RequestMapping(value="/quick13")
	@ResponseBody
	public void save13(String[] strs) throws IOException {
	    System.out.println(Arrays.asList(strs));
	}
	```

- 獲取集合類型參數
	建立一個VO類，封裝要儲存的的實體類對象
	參數裝傳入VO類
	```java
	@RequestMapping(value="/quick14")
	@ResponseBody
	public void save14(VO vo) throws IOException {
	    System.out.println(vo);
	}
	//
	public class VO {
    	private List<User> userList;
	}
	```
	```html
	<form action="${pageContext.request.contextPath}/user/quick14" method="post">
   	    <%--表明是第几个User对象的username age--%>
   	    <input type="text" name="userList[0].username"><br/>
   	    <input type="text" name="userList[0].age"><br/>
   	    <input type="text" name="userList[1].username"><br/>
   	    <input type="text" name="userList[1].age"><br/>
   	    <input type="submit" value="提交">
 	</form>
	```
	
- 獲取集合類型參數，ajax提交
	以 _JAON_ 格式提交
	controller 參數加上 `@RequestBody` 以相應類型接收數據
	```java	
	@RequestMapping(value="/quick15")
	@ResponseBody
	public void save15(@RequestBody List<User> userList) {
	    System.out.println(userList);
	}
	```
	
	```js
	var userList = new Array();
	userList.push({username:"zhangsan",age:18});
	userList.push({username:"lisi",age:28});
	$.ajax({
	    type:"POST",
	    url:"${pageContext.request.contextPath}/user/quick15",
	    data:JSON.stringify(userList),
	    contentType:"application/json;charset=utf-8"
	});
	```





---
# 註解
![[SpringMVC 註解]]




---
# 請求數據亂碼
配置全局filter
web.xml
```xml
<filter>
	<filter-name>CharacterEncodingFilter</filter-name>
	<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
	<init-param>
		<param-name>encoding</param-name>
		<param-value>UTF-8</param-value>
	</init-param>
</filter>
<!-- 過濾所有請求 -->
<filter-mapping>
	<filter-name>CharacterEncodingFilter</filter-name>
	<url-pattern>/*</url-pattern>
</filter-mapping>
```


---

# RedirectAttributes
[[SpringMVC RedirectAttributes]]