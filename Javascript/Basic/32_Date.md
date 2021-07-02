# Date對象
- JS中使用 `Date` 對象來表示一個時間

## 創建Date對象
- 創建當前時間
	- 
		```js
		let d = new Date();
		```
- 創建指定時間
	- 時間格式: `月/日/年 時:分:秒`
	- 
		```js
		let d = new Date('12/31/2020 12:10:30');
		```
		
## Date的屬性、方法
- `getDate()`
	- 一個月中的某一天 (1 ~ 31)
- `getDay()`
	- 一週中的某一天 (0 ~ 6)，0為週日
- `getMonth()`
	- 返回月份 (0 ~ 11)，0為一月
- `getFullYear()`
	- 以四位數字返回年份。
- `getTimezoneOffset()`
	- 返回本地時間與格林威治標准時間 (GMT) 的分鐘差。