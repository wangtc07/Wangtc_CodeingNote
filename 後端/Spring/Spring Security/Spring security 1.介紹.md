# 什麼是 Spring Security
- 應用程式安全主要分成兩個部分，**驗證** (authentication) 以及**授權**(authorization | access-control)。
	- 驗證就是一個建立 **Principal** 的過程
		**判斷用戶身份是否合法**
		- `Principal` 通常代表一個使用者、裝置或其他要對你的應用程式採取動作的系統
	- 授權則是指決定 Principal 在你的應用系統中是否能執行一個動作的過程。而當進行到一個需要授權的階段時，Principal 的身分 (identity) 應該早就透過驗證建立起來。

## 會話
避免擁護每次操作都進行驗證，可以將用戶信息存在會話中(保持用戶登入狀態)
- session
	- 
![](https://i.imgur.com/iHxZGSa.png)

- token
	1. 用戶驗證成功
	2. 服務端生成token
	3. 返回token給客戶端
	4. 客戶端保存token，可放在cookie或localStorage
	5. 客戶端請求時帶上token
	6. 服務端驗證token
	- ![](https://i.imgur.com/csxvR40.png)


## 授權
- 在認證通過後，控制不同用戶能夠訪問不同的資源
	可理解為 who對what進行how操作
	- who 主體，用戶或程序
	- what 資源，功能資源、數據資源
	- how 權限
![](https://i.imgur.com/g8NfVr8.png)

![](https://i.imgur.com/fqVEmKY.png)

## RBAC 訪問控制
- 基於角色的訪問控制
	- 總經理可查工資 -> 總經理和部門經理可查工資
		```java
		if(hasRole("總經理")){查工資}
		```
		->
		```java
		if(hasRole("總經理") || hasRole("部門經理")){查工資}
		```
		- 需要修改角色權限時，就需要修改相關代碼
	- ![](https://i.imgur.com/tgthWwU.png)

 - 基於資源的訪問控制
	 - 總經理可查工資 -> 總經理和部門經理可查工資
		```java
		if(hasPermission("查工資")){查工資}
		```
		->
		```java
		if(hasPermission("查工資")){查工資}
		```
		- 不需修改代碼
	 - ![](https://i.imgur.com/y4zsMjT.png)



# 取得 Spring Security
1. 使用 Maven
 	一組最基本的 Spring Security Maven 組合通常會長這樣：

	```xml
	<dependencies>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-web</artifactId>
			<version>5.0.7.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-config</artifactId>
			<version>5.0.7.RELEASE</version>
		</dependency>
	</dependencies>
	```