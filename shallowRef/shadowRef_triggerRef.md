## shallowRef
創建一個跟蹤自身 `.value` 變化的 ref，但不會使其值也變成響應式的。
```js
const foo = shallowRef({});

console.log(foo);  // RefImpl{}

// 改變 ref 的值是響應式的
foo.value = {}

// 但是這個值不會被轉換。
console.log(foo);  // {}
isReactive(foo.value) // false
```

## triggerRef
手動執行與 [`shallowRef`](https://v3.cn.vuejs.org/api/refs-api.html#shallowref) 關聯的任何作用 (effect)。


```js
const shallow = shallowRef({
  greet: 'Hello, world'
})

// 第一次運行時記錄一次 "Hello, world"
watchEffect(() => {
  console.log(shallow.value.greet)
})

// 這不會觸發作用 (effect)，因為 ref 是淺層的
shallow.value.greet = 'Hello, universe'

// 記錄 "Hello, universe"
triggerRef(shallow)
```
