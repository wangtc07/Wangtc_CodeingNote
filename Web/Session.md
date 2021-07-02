# Session 
## 概念
- 服務器端會話技術
- 再一次會話的==多次請求==間共享數據，將數據本存在服務器端的對象中
		瀏覽器關閉時銷毀，不同分頁中共享
```java
		// 獲取session
        HttpSession session = request.getSession();
        // 儲存數據
        session.setAttribute("msg" , "hello session");
		// 獲取數據
        Object msg = session.getAttribute("msg");
        System.out.println(msg);
```


![](https://i.imgur.com/A7b7KRN.png)

## 原理
> Session的時限是依賴於Cookie

![](https://i.imgur.com/SASnOYx.png)


## 細節
- 瀏覽器關閉後，session是否相同
	- 默認情況不同
	- 需要相同，可創建cookie
		```java
			// 獲取session
        HttpSession session = request.getSession();
        // 客戶端關閉後，session也能相同
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
		// cookie 持久化
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
		```
- 服務器關閉後，session不是同一個
	- 但要確保數據不丟失 (tomcat以自動完成)
		- session的鈍化
			- 在服務器正常關閉之前，將session序列化
		- session的活化
			- 反序列化
- session什麼時候銷毀
	- 服務器關閉
	- `invalidate()` 方法
	- 默認30分鐘失效

![](https://i.imgur.com/OgMUK8n.png)


![](https://i.imgur.com/TEO1AoQ.png)
		
		

## 特點
> 可以儲存任意類型，任意大小的數據

![](https://i.imgur.com/5708Tzp.png)

---
### 案例
[[Session 用戶登入 驗證碼]]