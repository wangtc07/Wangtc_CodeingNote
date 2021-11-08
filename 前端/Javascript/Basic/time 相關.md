
---

---

# 定時執行

- `setTimeout(function, milliseconds)` 
	- 在指定的毫秒數後調用函數
- `setInterval(function, milliseconds)`
	- 固定時間**重複**調用函數

---

- 回傳參數: id 
	id傳遞給 `clearTimeout()` 來取消執行。
- function要傳參數，要以字串方式傳遞
	```js
	setTimeout("alertFunc('i')", 3000);
	```

