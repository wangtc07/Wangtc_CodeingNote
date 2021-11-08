
- [JiunJiun: [jQuery] 指定select為選取狀態 (jiun-blog.blogspot.com)](http://jiun-blog.blogspot.com/2011/05/jquery-select.html)
- [jquery操作select(取值，設定選中） | IT人 (iter01.com)](https://iter01.com/705.html)
- [jquery操作select(增加，删除，清空) - 羽林.Luouy - 博客园 (cnblogs.com)](https://www.cnblogs.com/Luouy/p/5806833.html)


# 選取 
- 範例 HTML  
	```html
	<select id="selectBox">
		<option value="A">Number 0</option>
		<option value="B">Number 1</option>
		<option value="C">Number 2</option>
		<option value="D">Number 3</option>
		<option value="E">Number 4</option>
		<option value="F">Number 5</option>
		<option value="G">Number 6</option>
		<option value="H">Number 7</option>
	</script>
	```

- 切換選取項目

	```js
	$('#selectBox option[value=C]').attr('selected', 'selected');
	$("#selectBox").find("option:contains('C')").attr("selected",true);

	$('#selectBox').val('C');
	// 設定val值為C的選項選中

	$("#selectBox ").get(0).selectedIndex = 1;  
	// 設定Select索引值為1的項選中
	```
	
- 取消選取: 把val設定成沒有的值

	```js
	$('#list1').val('0');
	```
	


# 取值
- 取得選中的val值

	```js
	$("#selectBox").change(function(){
		var t = $(this).val(); 
	})
	```
	
- 取得選中的text值

	```js
	$("#selectBox").find("option:selected").text();
	```
	
- 取得選中的index

	```js
	var checkIndex=$("#select_id ").get(0).selectedIndex; 
	//獲取Select選擇的索引值
	```
	
- 取得選中的id

	```js
	let id$(this).attr('id')
	```

# 級聯 新增選項

- 根據選擇的項目，新增選項

	```js
	$(".selector1").change(function(){
		// 先清空第二個
		$(".selector2").empty();
		// 實際的應用中，這裡的option一般都是用迴圈生成多個了
		var option = $("<option>").val(1).text("pxx");
		$(".selector2").append(option);
	});
	```
	
	

# 新增 刪除

- 新增

	```js
	$("#select_id").append("<option value='Value'>Text</option>");  
	//為Select追加一個Option(下拉項)

	$("#select_id").prepend("<option value='0'>請選擇</option>");  
	//為Select插入一個Option(第一個位置)
	```

- 刪除

	```js
	$("#select_id option:last").remove();  
	//刪除Select中索引值最大Option(最後一個)

	$("#select_id option[index='0']").remove();  
	//刪除Select中索引值為0的Option(第一個)

	$("#select_id option[value='3']").remove();  
	//刪除Select中Value='3'的Option

	$("#select_id option[text='4']").remove();  
	//刪除Select中Text='4'的Option

	```
	
	
# 其他取值
- `radio`取值，`checkbox`取值，`select`取值，`radio`選中，`checkbox`選中，`select`選中
	- 獲取一組`radio`被選中項的值

	```js
	var item = $('input[name=items][checked]').val(); 
	```

	- 獲取`select`被選中項的文字

	```js
	var item = $("select[name=items] option[selected]").text();
	```

	- `select`下拉框的第二個元素為當前選中值

	```js
	$('#select_id')[0].selectedIndex = 1; 
	```

	-  `radio`單選組的第二個元素為當前選中值

	```js
	$('input[name=items]').get(1).checked = true; 
	```