- 透過java API進行網路連線，連線後可進行資料的交換
- ![[Pasted image 20210602091025.png]]
---



# TCP 連線
兩端各建立`Socket`對象，通過`Socket`產生IO流進行通信
- 客戶端: `Socket` 
	- [[Socket#Socket]]
- 服務端: `ServerSocket` 
	- [[Socket#ServerSocket]]




--- 
# Server
- 提供IP與固定埠號[^1]的電腦，稱為伺服器
![[截圖 2021-06-02 上午9.10.36.png]]

[^1]:兩個位元組，大多數TCP/IP實現給臨時埠號分配1024～49151之間的埠號
	一部電腦有0-65535個埠號(2個字節)
	0-1023為公認連接埠（Well Known Ports），程式不該使用
	http:預設埠號80，https:預設埠號443

# Client
- 提出連線請求的電腦
- 回應 Response
	- Server收到請求後，進行相關的處理，得到要求的資訊後，轉換為Client可以接受的格式
		經由原來的網路連線送回Client
- ![[截圖 2021-06-02 上午9.17.55.png]]



# Socket
![[Socket]]