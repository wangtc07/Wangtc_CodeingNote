- 在調用函數時，瀏覽器每次會傳遞兩個隱含的參數
	1. 函數的上下文對象 `this`
	2. 封裝實參的對象 `arfuments`
		- `arguments` 是一個==類陣列對象==，也可以通過==索引==來操作數據
		- 即使不定義參數，也可以通過所以的方式調用
			- 
				```js
				arguments[0]  //表示第一個實參
				```
- 有一個屬性 `callee` 就是當前正在指向函數對象

```js 
function fun() {
    console.log(Array.isArray(arguments));          	// false arguments不是Array
    console.log('arguments[0]: ' ,arguments[0]);    	// arguments[0]:  5
    console.log('arguments.callee' , arguments.callee); // arguments.callee ƒ fun() 
}
fun(5,10);
```