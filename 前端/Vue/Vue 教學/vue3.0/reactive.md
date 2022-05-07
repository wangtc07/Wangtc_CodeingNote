[響應性基礎 API | Vue.js (vuejs.org)](https://v3.cn.vuejs.org/api/basic-reactivity.html#reactive)

響應式轉換是“深層”的——它影響所有嵌套 property。在基於 [ES2015 Proxy](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Proxy) 的實現中，返回的 proxy 是**不**等於原始對象的。建議只使用響應式 proxy，避免依賴原始對象。

