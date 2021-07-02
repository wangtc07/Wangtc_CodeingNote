[^306]
![](https://i.imgur.com/30YpbiW.png)



![](https://i.imgur.com/ZAq1crz.png)

> **重定向，數據要用session儲存**


---
# login.jsp
```html
<body>
    <form action="/web_demo_war_exploded/LoginServlet2" method="post">
        <table>

            <tr>
                <td>用戶名</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密碼</td>
				<td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>驗證碼</td>
                <td><input type="text" name="checkCode"></td>
            </tr>
            <tr>
                <td colspan="2"><img id="img" src="/web_demo_war_exploded/CheckCodeServlet"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" name="登入"></td>
            </tr>
        </table>
    </form>

兩行相等
<div><%= request.getAttribute("cc_error")%></div>
<div>${cc_error}</div>

<div><%= request.getAttribute("login_error")%></div>
<div>${login_error}</div>
</body>
```

---
# LoginServlet.java
```java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // 請求參數
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("login username = " + username);

        // 封裝user對象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        System.out.println("login user = " + loginUser);

        // 調用 UserDao 的 login 方法
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        System.out.println("user = " + user);

		// 獲取生成的驗證碼
        String checkCode = request.getParameter("checkCode");
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        System.out.println("check code = "+ checkCode_session);
		
        // 刪除session儲存的驗證碼 確保驗證碼不會重複
        session.removeAttribute("checkCode_session");
		
		
        // 判斷驗證碼 忽略大小寫
        if (checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)) {
            // 判斷用戶名 密碼
            // 判斷 user
            if (user == null) {
                // 登入失敗
                request.setAttribute("login_error", "用戶名或密碼錯誤");
                // 轉發到登入頁面
                request.getRequestDispatcher("/login.jsp").forward(request, response);
//                request.getRequestDispatcher("/FailServlet").forward(request, response);
            } else {
                // 成功 儲存數據
				// 因為是重定向，所以數據要用session儲存
                session.setAttribute("user", username);
                System.out.println("username = " + username);
                // 轉發
//                request.getRequestDispatcher("/SuccessServlet").forward(request, response);
                // 重定向到 success.jsp > 虛擬目錄+/success.jsp
                response.sendRedirect(request.getContextPath() + "/success.jsp");

            }
        } else {
            // 儲存提示訊息
            request.setAttribute("cc_error", "驗證碼錯誤");
            // 轉發到登入頁面
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }
```
