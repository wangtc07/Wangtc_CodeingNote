# 冒泡事件
- 
	- 
		```jsx
		// 引用 事件物件 => (e) ， 調用事件方法 => e.事件方法
		
		var my\_inner = document.getElementById('box').addEventListener('click', function (e) {
		// e.stopPropagation();
		console.log('inner');
		} , false);
		var my\_outer
		document.getElementById('warp').addEventListener('click', function () {console.log('outer');} , true);
		
		  
		
		// 預設為 false
		// false (事件氣泡 - event Bubbling) - 從指定元素往外找 inner -> outer
		// true (事件捕捉 - event capturing) - 從最外面找到指定元素 outer -> inner
		
		  
		
		// preventDefault() - 取消預設行為
		// stopPropagation() - 阻止冒泡事件
		```
		
---
- 