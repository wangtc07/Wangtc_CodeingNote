# popoer
- [ElementUI使用采坑之多個Popover_大笨兒鐘的博客-CSDN博客_多個el-popover](https://blog.csdn.net/u014298440/article/details/82942463)

````ad-note
對於一個數組或者對象，直接去改變某個屬性對應的值，雖然值是成功修改了，但是這種變動是無法反應到視圖上的。
應改成: 
```js
this.tipVisibles.splice(index, 1, false);
```
---
![[Vue 基礎入門#條件判斷與列表渲染]]

````
		
```html
<el-popover v-model="tipVisibles[index]" placement="top" width="160">

	<p>確定刪除？</p>
	<div style="text-align: right; margin: 0">
		<el-button size="mini" type="text" @click="canelDelete(index)">取消</el-button>
		<el-button type="primary" size="mini" @click="deleteBtn(index)">確定</el-button>
	</div>

	<el-button slot="reference" type="info" style="width: 100%">刪除</el-button>

</el-popover>
```

```js
canelDelete(index) {
  this.tipVisibles.splice(index, 1, false); // 關閉popover
  console.log("tipVisibles: ", this.tipVisibles);
},
deleteBtn(index) {
  this.tipVisibles.splice(index, 1, false);
  this.list.splice(index, 1); // 刪除當前列
  console.log("list: ", this.list);
},
```