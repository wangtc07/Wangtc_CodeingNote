# 連線mysql 會可能會出現錯誤 Public Key Retrieval is not allowed
![](https://i.imgur.com/F3ZTa1M.png)
在使用 MySQL 8.0
最簡單的解決方法是在連線後面新增 `allowPublicKeyRetrieval=true`

如果使用者使用了 sha256\_password 認證，密碼在傳輸過程中必須使用 TLS 協議保護，但是如果 RSA 公鑰不可用，可以使用伺服器提供的公鑰；可以在連線中通過 `ServerRSAPublicKeyFile` 指定伺服器的 RSA 公鑰，或者`AllowPublicKeyRetrieval=True`引數以允許客戶端從伺服器獲取公鑰；但是需要注意的是 `AllowPublicKeyRetrieval=True`可能會導致惡意的代理通過中間人攻擊(MITM)獲取到明文密碼，所以預設是關閉的

![](https://i.imgur.com/DBWZWFE.png)


**MySQL 8.0 以上版本的數據庫連接有所不同：**

- 1、MySQL 8.0 以上版本驅動包版本 。
- 2、**com.mysql.jdbc.Driver** 更換為 com.mysql.cj.jdbc.Driver。
    
- MySQL 8.0 以上版本不需要建立 SSL 連接的，需要顯示關閉。
    
- allowPublicKeyRetrieval=true 允許客戶端從服務器獲取公鑰。
    
- 最後還需要設置 CST。
    
---



