# 冒泡事件
- 
	- 
		```jsx
		// 引用 事件物件 => (e) ， 調用事件方法 => e.事件方法
		
		var my\_inner = 
		document.getElementById('box').addEventListener('click', function (e) {
		// e.stopPropagation();
		console.log('inner');
		} , false);
		
		var my\_outer = 
		document.getElementById('warp').addEventListener('click', function () {
			console.log('outer');
		} , true);
		
		  
		
		// 預設為 false
		// false (事件氣泡 - event Bubbling) - 從指定元素往外找 inner -> outer
		// true (事件捕捉 - event capturing) - 從最外面找到指定元素 outer -> inner
		
		  
		
		// preventDefault() - 取消預設行為
		// stopPropagation() - 阻止冒泡事件
		```
		
---
- 阻止冒泡事件
	- `e.stopPropagation();`
- 實際被點擊的物件
	- `e.target`
- 傳遞到接收的物件
	- `e.currentTarget` 
![](https://i.imgur.com/fCLJWOJ.png)

---
## 冒泡應用
透過父標籤的事件聆聽，取得被點擊的子標籤
```js
const dad = document.getElementById('dad');
dad.onclick = (e) => {
	console.log('e.target: ', e.target);
	let target = e.target;
	if (target.id === 'dad') {
	   return;
	}
	target.style.background = 'orange';
}
```
![](https://i.imgur.com/asIGIpl.jpg)