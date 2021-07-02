
![](https://i.imgur.com/dIdRTmZ.png)

---
```java
response.setContentType("text/html;charset=utf-8");

        boolean flag = false;
        // 獲取所有cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie c : cookies) {
                String name = c.getName();
                // 判斷是否是 lastTime
                if ("lastTime".equals(name)) {
                    flag = true;
                    // 設置cookie的value
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
                    String strDate = sdf.format(date);
                    System.out.println("->"+strDate);
                    // URL編碼
                    String URLDate = URLEncoder.encode(strDate, "utf-8");
                    System.out.println("->"+URLDate);

                    c.setValue(URLDate);
                    // 設置存活時間
                    c.setMaxAge(60*60*24*30);
                    response.addCookie(c);

                    // 不是第一次訪問
                    String value = c.getValue();
                    // URL解碼
                    System.out.println(value);
                    String URLValue = URLDecoder.decode(value, "utf-8");
                    System.out.println(URLValue);
                    response.getWriter().write("<h1>你上次訪問時間:" + URLValue + "</h1>");

                    break;
                }
            }
        }

        if (cookies == null || cookies.length == 0 || flag == false) {
            // 第一次訪問
            // 設置cookie的value
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String strDate = sdf.format(date);
            // URL編碼
            String URLDate = URLEncoder.encode(strDate, "utf-8");
            System.out.println("--->"+URLDate);

            Cookie cookie = new Cookie("lastTime", URLDate);
            // 設置存活時間
            cookie.setMaxAge(60*60*24*30);
            response.addCookie(cookie);

            response.getWriter().write("<h1>歡迎首次訪問</h1>");

        }
```