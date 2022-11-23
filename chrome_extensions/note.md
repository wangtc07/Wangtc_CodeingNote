安裝 https://www.npmjs.com/package/node-polyfill-webpack-plugin
在 webpack.config.js 加上 `plugins: [*new* NodePolyfillPlugin()]`

之後還是有fs, net, tls 幾個模塊顯示找不到，手動安裝後重啟
fs 模塊還是顯示找不到，在下面網址找到解
一樣在 webpack.config.js 加上

```js
resolve: {
        fallback: {
            "fs": false
        },
    }
```

https://stackoverflow.com/questions/57161839/module-not-found-error-cant-resolve-fs-in

