[.vue文件中style標簽的幾個標識符 - SegmentFault 思否](https://segmentfault.com/a/1190000015652687)

### 解決方案一: `scoped`方案

-   將無法進行樣式覆蓋的部分拿出來
-   使用原生的css樣式, 添加scoped
-   使用 `>>>` 語法糖進行樣式的注入

```html
<style scoped> 
	.main_nav .el-menu .el-submenu >>> .el-submenu__title {
	  background-color: red;
	} 
</style>
```