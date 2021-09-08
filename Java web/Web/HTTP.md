# HTTP
> [HTTP编程 - 廖雪峰的官方网站](https://www.liaoxuefeng.com/wiki/1252599548343744/1319099982413858)
> [Web基礎 - 廖雪峰的官方網站](https://www.liaoxuefeng.com/wiki/1252599548343744/1304265903570978)
- HTTP協議
	- 規定瀏覽器和服務器端的數據交互格式
- HTTP特性
	- 基於請求和響應
		- 必須先有請求，後有響應
		- 請求和響應，必須成對出現
	- 簡單快捷
		- 請求時，只需發送請求方式和請求路徑
- 版本
	- HTTP1.0
	- HTTP1.1

---
## HTTP分析
### HTTP請求
1. 請求行
	`GET /index.html HTTP/1.1`
	2. ==請求方式==: HTTP有7種請求方式 預設為GET
		1. GET: 請求的參數會顯示到地址欄，通常是有大小的限制
		2. POST: 請求的參數在請求體中，沒有大小的限制
	3. 請求路徑
	4. 協議版本
2. 請求頭
	格式: 一個key對應一個value(也有對應多個value的)
		1. `Referer`: 代表的網頁來源
			1. 防盜連
			![](https://i.imgur.com/o18B3Ww.png)
			2. 統計工作
			![](https://i.imgur.com/A4ANbXy.png)
	

		2. `User-Agent`: 獲得客戶端(瀏覽器)的類型
			在服務器端獲取該訊息，解決瀏覽器兼容問題
		3. 	
<br>空白行
3. 請求體
	1. 只有POST方式才有，是POST方式的請求參數

### HTTP響應
1. 響應行
	1. 協議版本
	2. ==狀態碼==
		1. 200: 響應成功
		2. 302: 需要進行重訂向操作
		3. 304: 需要查找本地緩存
		4. 404: 客戶端錯誤，請求資源不存在
		5. 405: 沒有對應的 `doGet() , doPost()` 方法
		6. 500: 服務器內部錯誤
	3. 狀態碼描述
2. 響應頭
	格式: 一個key對應一個value(也有對應多個value的)
		1. `ContenType` 服務器告訴客戶端，本次響應體數據格式，及==編碼格式==
		1. `Location` 重定向的路徑
		2. `Refersh` 定時刷新
		3. `Content-Disposition` 文件下載的時候
			1. `in-line` 默認值，在當前頁面打開
			2. `attachment;filename=xxx` 以附件形式打開。下載文件
<br>空白行
3. 響應體
	顯示到瀏覽器的數據







---
# HTTPServlet
![[servlet#HttpServlet]]


---
## URLConnection
#### method
- [`Map`](https://www.apiref.com/java11-zh/java.base/java/util/Map.html "interface in java.util")<[`String`](https://www.apiref.com/java11-zh/java.base/java/lang/String.html "class in java.lang"),​[`List`](https://www.apiref.com/java11-zh/java.base/java/util/List.html "interface in java.util")<[`String`](https://www.apiref.com/java11-zh/java.base/java/lang/String.html "class in java.lang")\>> getHeaderFields()