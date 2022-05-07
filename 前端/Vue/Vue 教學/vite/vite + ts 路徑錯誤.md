```ad-error
# vue3+ts引用第三方模塊報錯

原因是：
 ‘vue-xxx’文件可能不是.ts文件而是.js文件
```

# solution
[ts：报错Could not find a declaration file for module xxx_飞翔的哔哔鸡的博客-CSDN博客](https://blog.csdn.net/weixin_43972437/article/details/106374235)
```js
declare module '*';
```
---
```js
declare module '*/router';

declare module '*/store';
```




---

# 未成功
## 問題

Vite + Vue + ts 項目下，引用 .vue 報錯

```
 vue vite ts Cannot find module   or its corresponding type declarations.ts(2307)
```

## 方案

VS code 中，F1， "typescript: select Typescript version"， 選擇 workspace 下的 typescript 即可

-   參考信息：[https://github.com/vitejs/vite/issues/965#issuecomment-717248892](https://github.com/vitejs/vite/issues/965#issuecomment-717248892)