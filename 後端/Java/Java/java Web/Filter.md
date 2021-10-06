# Filter
> 攔截請求，完成一些特殊的功能

- 作用
	- 完成通用的操作
		- 登入驗證、編碼處理、

![](https://i.imgur.com/csedjQf.png)

- 入門
	- 步驟
		1. 定義類，實現 `Filter` 接口
		1. 複寫方法
			- `init()`
			- `doFilter()`
			- `destroy()`
		1. 配置攔截路徑
			- web.xml
				- ![](https://i.imgur.com/ludjDCO.png)

			- 註解
				- `@WebFilter("/*")`
			- 攔截目錄
				- `/user/*`
			- 後綴名攔截
				- `*.jsp`
		1. 攔截方式配置
			- 資源被訪問的方式
			- 註解
				- 設置 `dispatcherTypes` 屬性
					- `REQUEST`
						- 默認，瀏覽器直接請求資源
					- `FORWARD`
						- 轉發訪問資源
					- `INCLUDE`
						- 包含訪問資源
					- `ASYNC`
						- 異步訪問資源
					- `ERROR`
						- 錯誤跳轉資源
		2. 放行
			- 
				```java
				// 放行
				filterChain.doFilter(servletRequest,
					servletResponse);
				```
- 過濾器鏈
	- 請求時先攔截的，回應時後攔截
	- 過濾器先後順序
		- 註解
			- 按照類名字符串比較，小的先執行
		- web.xml `<filter-mapping>`定義在上面的先執行

![](https://i.imgur.com/In6ui2S.png)

# 代理
![[Proxy]]

# 案例
[[Filter 用戶登入]]
