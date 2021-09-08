# 概念

![](https://i.imgur.com/whtCKfD.png)

# 獲取ServletContext
```java
        // 通過request
        ServletContext servletContext1 = request.getServletContext();
        // 通過HttpServlet
        ServletContext servletContext = this.getServletContext();

        // servletContext1 == servletContext2
```

# 功能
- 獲取MIME類型
	- `getMimeType(String realPath)`
- 共享數據
	- `ServletContext` 對象範圍: 所有用戶的所有請請求數據
- 獲取文件的真實路徑(服務器)
	- `getRealPath(String path)`
	- 
		```java
		String realPath = servletContext.getRealPath("/b.txt");
        // web目錄下資源訪問

        String c = servletContext.getRealPath("/WEB-INF/c.txt");
        // WEB-INF目錄下資源訪問
        
        String a = servletContext.getRealPath("/WEB-INF/classes/a.txt");
        // java專案目錄下資源訪問
        

        System.out.println(realPath);
        System.out.println(c);
        System.out.println(a);
		```
	- ![](https://i.imgur.com/2EMvc7s.png)

	- ![](https://i.imgur.com/y4tLlDo.png)
	- 


![](https://i.imgur.com/TEvsFt5.png)

---
- 案例
	- [[文件下載]]