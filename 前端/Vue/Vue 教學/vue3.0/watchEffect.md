1. 立即執行
2. 響應式追蹤依賴(watchEffect內函數所有使用到的參數)
3. 在組建卸載時停止 `unmounted`
4. 返回一個參數，調用後停止監聽
	```js
	const stop = watchEffect(() => {
	  /* ... */
	})

	// later
	stop()
	```
5. side Effect invalidation
	在 `watchEffect` 可接受一個 `onInvalidate` 參數，在下列情況下被觸發
	1. `watchEffect` 即將被執行前
	2. 偵聽器被停止前
	```js
	const data = ref(null)
	watchEffect(async onInvalidate => {
	  onInvalidate(() => {
		/* 此區塊先執行 */
	  }) 
	  data.value = await fetchData(props.id)
	})
	```
	目的: [節流與防抖](https://juejin.cn/post/6844903894997286920)
6. 