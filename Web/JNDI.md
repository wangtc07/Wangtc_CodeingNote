# JNDI的資源參考
- 在 context.xml 配置
	- 
		```xml
			<Resource name="jdbc/MemberDB" type="javax.sql.DataSource" 
			username="root" password="****"
			driverClassName="com.mysql.cj.jdbc.Driver" 
			url="jdbc:mysql:///jspdb"
			connectionProperties=
			"useUnicode=yes;characterEncoding=utf8;useSSL=false;serverTimezone=Asia/Taipei"
			maxTotal="8" 
			maxIdle="4" 
			maxWaitMillis="5000"  
		/>
		```

- 取得JDBC資源的查找名稱在JAVA規格中明訂如下
	- `java:comp/env/jdbc/xxx`

- web.xml內加入 `<resource-ref>` 標籤
	```xml
	<resource-ref>  
		<description>說明性文字</description> 
		<res-ref-name>jdbc/BlobClobDEMO</res-ref-name > 
		<res-type>javax.sql.DataSource</res-type> 
		<res-auth>Container</res-auth> //身份驗證
	</resource-ref>
	```
	當DataSource物件已經在JNDI註冊後，Java應用程式

	便可建立InitialContext物件，經由它的lookup()方法

	來取得DataSource物件。
	
- **在Java程式中取的Connection 的敘述如下:**
```java
InitialContext context = new InitialContext(); 

DataSource ds =(DataSource) context.lookup("java:comp/env/jdbc/MemberDB"); 

Connection conn1 = ds.getConnection(); // 當<res-auth>為CONTAINER

Connection conn2 = ds.getConnection("user", "password"); 
//當<res-auth>為 SERVLET
```


# 經由JNDI來建立資料庫連線
1. 建立 `InitialContext` 物件，
2. 經由它的 `lookup()` 方法來取得 `DataSource` 物件。

```java
DataSource ds = null;
	
	public MemberDao() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/BlobClobDEMO");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}	
	
 
Connection conn = ds.getConnection();
```



![](https://i.imgur.com/tPy6hEa.png)
