# 發送數據
1. 創建客戶端的 `Socket` 對象
	1. `Socket(InetAddress address, int port)`
	2. `Socket(String host, int port)`
2. 獲取輸出流，寫數據
	1. `OutputStream    getOutputStream()`
3. 釋放資源



# 接收數據
1. 創建服務器端的 `ServerSocket` 對象
	1. `ServerSocket​(int port)`
2. 監聽客戶端連線，返回 `Socket` 對象
	1. `Socket  accept()`
3. 獲取輸入流，讀取數據
	1. `InputStream	getInputStream()`
4. 釋放資源


[[TCP通信程序 案例]]