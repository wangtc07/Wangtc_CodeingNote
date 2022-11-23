表格 內容 置中

```css
td {
  text-align: -webkit-center;
}
```



css 計算

```css
calc(100%/3)
```



form label 對齊

```css
.form-item {
  display: inline-block;
  width: 140px;
}
```



html 單選
同組單選， `name` 要一樣

```html
<input type="radio" name="invoice" value="none" id="a"> <label for="a">a</label>
<input type="radio" name="invoice" value="source" id="b"><label for="b">b</label>
```



html 表格 table 輸入
[[HTML5]可編輯的Table，contenteditable屬性](https://dotblogs.com.tw/ShihGoGo/2019/12/19/153431)

```html
<table>
  <tr>
    <td> <input  type="text" style="width:100%;height:100%" /></td>
  </tr>
</table>
<!-- or -->
<table>
  <tr>
    <td contenteditable="true"></td>
  </tr>
</table>
```



html form 表單 固定

```html
<label class="label">聯絡方式：</label>
<input class="input-style text-in2" value="" v-model="tel" />
```

```css
.label {
  position: absolute;
}
/* 設定input游標起始位置，根據實際情況自行調整 */
.text-in2 {
  text-indent: 98px;
}
.input-style {
  height: 40px;
  width: 480px;
  outline-style: none;
}
```



get checkbox ststus value
```js
document.querySelector('.messageCheckbox').checked;
```