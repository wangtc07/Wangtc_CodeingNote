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

# toRefs
[toRefs](https://v3.vuejs.org/api/refs-api.html#torefs)

[ref,toRef,toRefs三者的使用及區別_潛龍入淵 - MdEditor](https://www.gushiciku.cn/pl/gbfK/zh-tw)


```js
const state = reactive({
  foo: 1,
  bar: 2
})

const stateAsRefs = toRefs(state)
/*
Type of stateAsRefs:

{
  foo: Ref<number>,
  bar: Ref<number>
}
*/

// The ref and the original property is "linked"
state.foo++
console.log(stateAsRefs.foo.value) // 2

stateAsRefs.foo.value++
console.log(state.foo) // 3
```

