# EL表達式
> 替換和簡化jsp頁面中的java代碼編寫

- 語法
	- `${ ... }`
- 
![](https://i.imgur.com/RPYVMBz.png)
- 運算
	- `empty`
		- 判斷字符串、集合、陣列對象是否為null或者長度為0
		- `${empty key}`
	- ![](https://i.imgur.com/qWXbH51.png)

## 獲取值
- 只能從==域對象==中獲取值
	- `${ 域名稱.key }`
		- `pageContext` 
		- `requset` 
		- `session` 
		- `application` 
	- `${ key }`
		- 依次從最小的域中查找

- 獲取==對象的值==
	- `${ 域名稱.key.屬性名 }`
		- 本質上是調用對象的get方法
	- 
		```java
		requesp.setAttribute("user", userBeam);
		```	
		```html
		${user.username}
		```
- 獲取==List==的值
	- `${ key[index] }`
- 獲取==Map==的值
	- `${ key.mapKey }`
	- `${ key["mapKey"] }`
	
