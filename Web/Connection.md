# 建立與資料庫的連線
## 取得`Connection`對象
- [DriverManager](https://www.apiref.com/java11-zh/java.sql/java/sql/DriverManager.html)
	- `DriveManager`類別的`getConnection()`方法返回`Connection`對象
		- 
			```java
			Connection con = DriverManager.getConnection(url,user,password);
			```
	- construct
		- 
			```java
			getConnection(String url)
			// url:jdbc:mysql://127.0.0.1:3306/DataBaseName?user=你的帳號&password=你的密碼&useSSL=true
			
			getConnection(String url, String user, String password)
			
			getConnection(String url, Properties info)
			將帳號、密碼封裝在Properties物件(實現Map接口)裡
				Properties prop = new Properties();
				prop.put("user", "帳號");
				prop.put("password", "密碼");
			```


