## JNDI的資源參考

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
InitialContext context = new InitialContext(); DataSource ds =

(DataSource) context.lookup("java:comp/env/jdbc/BlobClobDEMO"); 

Connectionconn1=ds.getConnection(); // 當<res-auth>為CONTAINER

Connection conn2 = ds.getConnection("user", "password"); //當<res-auth>為 SERVLET
```


## 經由JNDI來建立資料庫連線
當DataSource物件已經在JNDI註冊後，Java應用程式

便可建立InitialContext物件，經由它的lookup()方法

來取得DataSource物件。

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
