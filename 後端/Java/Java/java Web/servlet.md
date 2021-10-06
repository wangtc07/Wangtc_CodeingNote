# Servlet 概述

> Serverlet 就是運行在服務器或應用服務器上小的的 java 程序，用於處理 web 客戶端發送的請求，並寫做出響應
> [Servlet (Java(TM) EE 7 Specification APIs)](https://docs.oracle.com/javaee/7/api/toc.htm)
> ![](https://i.imgur.com/FQ0rtVb.png)

![](https://i.imgur.com/Hxfq9C4.png)
![](https://i.imgur.com/tN1C3aL.png)

## 入門

### 配置 servlet

![](https://i.imgur.com/SJlWE8M.png)

![](https://i.imgur.com/kNL1t76.png)

### 執行原理

![](https://i.imgur.com/FIy683T.png)

![](https://i.imgur.com/YtB0JLQ.png)

- 生命週期
  ![](https://i.imgur.com/c6x3nJj.png)

- Servlet 什麼時候被創建
  - 指定 Servlet 的創建時機  
     1. 第一次被訪問時，創建 負整數 2. 服務器啟動時，創建 0 或 正整數
    ![](https://i.imgur.com/sDupOsi.png)
- 問題
  ![](https://i.imgur.com/BisHauj.png)

![](https://i.imgur.com/EI4NKZR.png)

---

# Servlet3.0

> 支持註解配置
> 可以不需要 web.xml

![](https://i.imgur.com/T4glFuH.png)
![](https://i.imgur.com/ACiQ45m.png)

![](https://i.imgur.com/fUEbLDs.png)

### tomcat 配置

![](https://i.imgur.com/cpBJuLx.png)

---

# Servlet 結構

All Known Implementing Classes:
[FacesServlet](https://javaee.github.io/javaee-spec/javadocs/javax/faces/webapp/FacesServlet.html 'class in javax.faces.webapp'), [GenericServlet](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/GenericServlet.html 'class in javax.servlet'), [HttpServlet](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/http/HttpServlet.html 'class in javax.servlet.http')
![](https://i.imgur.com/CiwNqEs.png)

### GenericServlet

### HttpServlet

> 已處理 判斷請求方式
> 對 http 協議的一種封裝，簡化操作
>
> ```java
> // 判斷請求的方式...
> protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
>        String method = req.getMethod();
>        long lastModified;
>        if (method.equals("GET")) {......
> ```

- 需要複寫的方法
  - `@Override doGet`
  - `@Override doPost`

#### Request

![[Request]]

---

#### Response

![](https://i.imgur.com/sigB20N.png)

![](https://i.imgur.com/hCWYb7D.png)

##### Response 方法

- [sendRedirect](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/http/HttpServletResponse.html#sendRedirect-java.lang.String-)([String](http://docs.oracle.com/javase/8/docs/api/java/lang/String.html?is-external=true 'class or interface in java.lang') location)
  - **簡單的重定向方法**。使用指定的重定向位置 URL 向客戶端發送臨時重定向響應並清除緩衝區。
- `response.setContentType("text/html;charset=utf-8");`
  等於下面兩行
  - `response.setCharacterEncoding("UTF-8");`
  - `response.setHeader(“content-type”, “text/html;charset=utf-8”);`

##### Response Demo

- 路徑寫法
  - ![](https://i.imgur.com/8i864oN.png)

---

# Servlet 配置

- 定義多個虛擬路徑可訪問
  `java @WebServlet({"/d1" , "/d2" , "d3"}) `
  [Servlet 虛擬路徑映射詳解\_丹丹的後花園-CSDN 博客](https://blog.csdn.net/qq_34666857/article/details/104450306)
  ![](https://i.imgur.com/cuUogx8.png)

---

# ServletContext

![[ServeltContext]]

# servlet 初始化參數

![[servlet初始化參數]]

# 案例

[[用戶登入]]
[[驗證碼]]
[[重定向]]
[[Response 輸出]]
