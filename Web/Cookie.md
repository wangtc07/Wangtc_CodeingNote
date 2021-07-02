# Cookie
- 概念
	- 將數據保存在客戶端
- 使用步驟
	1. 創建 `Cookie` 對象，綁定數據
		- `Class Cookie`
			-  [Cookie](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/http/Cookie.html#Cookie-java.lang.String-java.lang.String-)([String](http://docs.oracle.com/javase/8/docs/api/java/lang/String.html?is-external=true "class or interface in java.lang") name, [String](http://docs.oracle.com/javase/8/docs/api/java/lang/String.html?is-external=true "class or interface in java.lang") value)
	2. 發送 `Cookie` 對象
		- `HttpServletResponse` 
			- [addCookie](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/http/HttpServletResponse.html#addCookie-javax.servlet.http.Cookie-)([Cookie](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/http/Cookie.html "class in javax.servlet.http") cookie)
	3. 獲取 `Cookie` 拿到對象
		-  `HttpServletRequest`
			-  [Cookie](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/http/Cookie.html "class in javax.servlet.http")[] &nbsp&nbsp[getCookies](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/http/HttpServletRequest.html#getCookies--)()

- 原理
	- ![](https://i.imgur.com/aFIU2Mk.png)	
- 細節
	- 一次可發送多個 `Cookies` 
	- 在瀏覽器中保存多長時間
		- 默認，==瀏覽器關閉==時 `Cookies` 銷毀
		- 持久化儲存
			- `setMaxAge(int seconds)`
				- 正數: 數據寫到硬碟中，seconds:存活時間
				- 負數: 默認值
				- 零: 刪除 `Cookies`
	- 儲存中文
		- tomcat8之後可儲存中文
		- 特殊字符不支持 URL編碼
	- 獲取範圍
		- 默認不能共享
		- `setPath(String path)` 默認設計當前虛擬目錄
			如要共享，將path設置 `/`
		- 不同服務器共享 `Cookie`
			- `setDamain(String path)` 
				設置一級域名相同，則多個服務器之間可共享
				![](https://i.imgur.com/3uRb9P0.png)

## Cookie特點、作用
![](https://i.imgur.com/y9OwMmR.png)

- 一般用於存取少量、不太敏感的數據
![](https://i.imgur.com/lpuvYNN.png)

---
### 案例
[[Cookie 記住上次訪問時間]]