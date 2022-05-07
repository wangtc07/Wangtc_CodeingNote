接受一個對象 (響應式或純對象) 或 [ref](https://v3.cn.vuejs.org/api/refs-api.html#ref) 並返回原始對象的只讀代理。只讀代理是深層的：任何被訪問的嵌套 property 也是只讀的。

```js
const original = reactive({ count: 0 })

const copy = readonly(original)

watchEffect(() => {
  // 用於響應性追蹤
  console.log(copy.count)
})

// 變更 original 會觸發依賴於副本的偵聽器
original.count++

// 變更副本將失敗並導致警告
copy.count++ // 警告!
```