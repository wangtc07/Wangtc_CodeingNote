# JSP 概念
[^295]
![](https://i.imgur.com/UUSWX0D.png)

![](https://i.imgur.com/ACqSjXb.png)

![](https://i.imgur.com/HrXFbCu.png)


# JSP 原理
- 本質上就是一個 `Servlet`

# JSP 腳本
- 定義 java 代碼的方式
	- `<%   %>`
		- 在 seriver 方法中，
	- `<%!  %>`
		- 在 jsp 轉換後的java類中的成員變量
	- `<%=  %>`
		- 會輸出頁面上

![](https://i.imgur.com/wCGNSFi.png)

## 內置對象
- jsp頁面中不需要獲取和創建，==可以直接使用的對象==
	- 變量名 👉 真實類型
	- `pageContext` 
		- 👉 `PageContext`
		- 獲取其他八個內置對象 👉 `getOOO()`
		- 在當前頁面中訪問數據
			- ![](https://i.imgur.com/jwq5AjU.png)

	- `requset` 
		- 👉 `HttpServletRequset`
		- 一次請求中訪問多個資源
	- `session` 
		- 👉 `HttpSession`
		- 一次會話中的多個請求間
	- `application` 
		- 👉 `ServletContext`
		- 所有用戶之間共享數據
	- `response` 
		- 👉 `HttpServletResponse`
		- 響應對象
	- `page`
		- 👉 `Objetc`
		- 當前頁面的對象 `this`
	- `out`
		- 👉 `JspWriter`
		- 輸出對象
	- `config`
		- 👉 `Servletconfig`
		- Servlet的配置對象
	- `exception`
		- 👉 `Throwable`
		- 異常對象

## 隱式對象
> 通過 `pageContext` 獲取

- 動態獲取虛擬目錄
	- `pageContext.request.contextPath` 

![](https://i.imgur.com/gnff9TE.png)


# JSP 指令
> 用於配置JSP頁面，導入資源文件

- 格式
	- `<%@ 指令名稱 屬性名1=屬性值1 屬性名2=屬性值2`
- 分類
	- `page`
		- 配置JSP頁面
			- `contentType` 👉 等同於 `reaponse.setContentType`
				- 設置響應體的mime類型及編碼格式
			- `errorPage`
				- 當前頁面發生異常後，跳轉到指定頁面
	- `include`
		- 導入其他頁面的資源文件，如有共通的頁首頁尾
	- `taglib`
		- 導入資源(標籤庫)

![](https://i.imgur.com/N6Bps4e.jpg)


![](https://i.imgur.com/OkA1LYw.png)


# JSP 註釋
- `<!--     -->` html
- `<%--    --%>` jsp







# JSTL標籤
[[JSTL]]

# EL
[[EL表達式]]

# MVC
[[MVC]]

# JavaBean
![[JavaBean]]


---
# class
[[JSP_Ch01]]
[[JSP-Ch05_EL]]