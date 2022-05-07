創建一個自定義的 ref，並對其依賴項跟蹤和更新觸發進行顯式控制。它需要一個工廠函數，該函數接收 `track` 和 `trigger` 函數作為參數，並且應該返回一個帶有 `get` 和 `set` 的對象。

```js
function useDebouncedRef(value, delay = 200) {
  let timeout
  return customRef((track, trigger) => {
    return {
      get() {
        track()
        return value
      },
      set(newValue) {
        clearTimeout(timeout)
        timeout = setTimeout(() => {
          value = newValue
          trigger()
        }, delay)
      }
    }
  })
}

export default {
  setup() {
    return {
      text: useDebouncedRef('hello')
    }
  }
}
```