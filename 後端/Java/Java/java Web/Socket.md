[Socket](https://www.apiref.com/java11-zh/java.base/java/net/Socket.html)
# Socket
一條網路連線的一個端點(各自有各自的)
- 連線期間
	- 客戶端: 動態配置一個本地埠號
	- 伺服端: 動態配置一個新的埠號
		- 目的是讓伺服端可以用原本的固定埠號，接受客戶端提出的請求
## 透過Socket傳送資料
Socket提供讀/寫位元組的功能
- Java.net.Socket提供網路讀寫資料的功能

![[截圖 2021-06-02 上午9.24.26.png]]

![[截圖 2021-06-02 上午9.27.57.png]]

![[截圖 2021-06-02 上午9.57.03.png]]

# ServerSocket
![[截圖 2021-06-02 上午10.33.07.png]]

```java
Socket socket = serverSocket.accept()
```



![[截圖 2021-06-02 上午10.35.30.png]]

![[截圖 2021-06-02 上午10.49.16.png]]

# Socket
- construct

