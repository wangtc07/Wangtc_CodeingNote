# Response 字符
```java
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //
        PrintWriter pw = response.getWriter();
        //
        pw.write("<h1>你好 hello response</h1>");
    }
```

![](https://i.imgur.com/J4sgqQJ.png)
![](https://i.imgur.com/tfUMwFu.png)


# Response 字元

![](https://i.imgur.com/ychQJjR.png)
