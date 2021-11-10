- [Refs | Vue.js (vuejs.org)](https://v3.cn.vuejs.org/api/refs-api.html#ref)

- [Vue.js 3 Composition API 基本學習筆記-1：Ref、Props、watch、生命週期 - Vue - Let's Write (letswrite.tw)](https://www.letswrite.tw/vue3-composition-api/)

---
# ref()

- ref 就是 Vue 2 時的 data。
	在 Vue 2 時我們會這樣寫：

```JavaScript
data: {
  msg: 'Hello World'
}
```

- 到了 Vue 3 Composition API 就會寫成：
	如果 console.log(msg) 來看，會看見 Composition API 的 ref 是一個 Object：

```JavaScript
setup() {
  const msg = ref('Hello World');
  return { msg }
}
```
