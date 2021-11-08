# 簡介
- [1-1 Vue.js 簡介](https://book.vue.tw/CH1/1-1-introduction.html)




---

# 條件判斷與列表渲染
- [數組更新檢測](https://cn.vuejs.org/v2/guide/list.html#%E6%95%B0%E7%BB%84%E6%9B%B4%E6%96%B0%E6%A3%80%E6%B5%8B "數組更新檢測")
	Vue 將被偵聽的數組的變更方法進行了包裹，所以它們也將會觸發視圖更新。這些被包裹過的方法包括：
	- `push()`
	- `pop()`
	- `shift()`
	- `unshift()`
	- `splice()`
	- `sort()`
	- `reverse()`

	除了上述七種包裝過的陣列方法外，也可以透過 `vm.$set(vm.items, indexOfItem, newValue)` 來強制更新內容