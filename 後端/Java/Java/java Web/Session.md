# Session

## 概念

- 服務器端會話技術
- 再一次會話的**多次請求**間共享數據，將數據本存在服務器端的對象中
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

> Session 的時限是依賴於 Cookie

![](https://i.imgur.com/SASnOYx.png)

## 細節

- 瀏覽器關閉後，session 是否相同
  - 默認情況不同
  - 需要相同，可創建 cookie
    ```java
    	// 獲取session
        HttpSession session = request.getSession();
        // 客戶端關閉後，session也能相同
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
    // cookie 持久化
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
    ```
- 服務器關閉後，session 不是同一個
  - 但要確保數據不丟失 (tomcat 以自動完成)
    - session 的鈍化
      - 在服務器正常關閉之前，將 session 序列化
    - session 的活化
      - 反序列化
- session 什麼時候銷毀
  - 服務器關閉
  - `invalidate()` 方法
  - 默認 30 分鐘失效

![](https://i.imgur.com/OgMUK8n.png)

![](https://i.imgur.com/TEO1AoQ.png)

- 在 Cookie 被禁用的情況下使用 url rewrite 機制保持 Session
  - `String encodeRedirectURL(String url)`
    - 功能
      `http://xxx.com/abc?a=b`
      👇`http://xxx.com/abc;jsessionid=D97956894C4330053A84DBE6FA7E8AC2?a=b`
      - ```java
        response.sendRedirect(
        response.encodeRedirectURL("InsertMemberSuccess.jsp"));
        ```

## 特點

> 可以儲存任意類型，任意大小的數據

![](https://i.imgur.com/5708Tzp.png)

---

### 案例

[[Session 用戶登入 驗證碼]]
