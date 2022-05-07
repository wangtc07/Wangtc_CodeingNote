可以用來為 source reactive object 上的某個 property 新創建一個 [`ref`](https://v3.cn.vuejs.org/api/refs-api.html#ref)。然後，ref 可以被傳遞，它會保持對其源 property 的響應式連接。

```js
const state = reactive({
  foo: 1,
  bar: 2
})

const fooRef = toRef(state, 'foo')

fooRef.value++
console.log(state.foo) // 2

state.foo++
console.log(fooRef.value) // 3
```