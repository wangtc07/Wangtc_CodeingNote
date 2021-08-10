# AJAX：
1. 概念： ASynchronous JavaScript And XML	非同步的JavaScript 和 XML
	1. 非同步和同步：客戶端和伺服器端相互通訊的基礎上
		* 客戶端必須等待伺服器端的響應。在等待的期間客戶端不能做其他操作。
		* 客戶端不需要等待伺服器端的響應。在伺服器處理請求的過程中，客戶端可以進行其他的操作。

		> Ajax 是一種在無需重新載入整個網頁的情況下，能夠更新部分網頁的技術。 
		> 通過在後臺與伺服器進行少量資料交換，Ajax 可以使網頁實現非同步更新。這意味著可以在不重新載入整個網頁的情況下，對網頁的某部分進行更新。
		> 傳統的網頁（不使用 Ajax）如果需要更新內容，必須過載整個網頁頁面。

		* 提升使用者的體驗

2. 實現方式：
	-  原生的JS實現方式（瞭解）
		 1. 建立核心物件
			 - 
				 ```js
				var xmlhttp;
				if (window.XMLHttpRequest)
				{// code for IE7+, Firefox, Chrome, Opera, Safari
					xmlhttp=new XMLHttpRequest();
				}
				else
				{// code for IE6, IE5
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
				}
				```

		2. 建立連線	
			- 
				```js
				xmlhttp.open("GET","ajaxServlet?username=tom",true);
				```
			- 參數：
				1. 請求方式：GET、POST
					* get方式，請求引數在URL後邊拼接。send方法為空參
					* post方式，請求引數在send方法中定義
				2. 請求的URL：
				3. 同步或非同步請求：true（非同步）或 false（同步）
		1. 傳送請求
			```js
			xmlhttp.send();
			```

		4. 接受並處理來自伺服器的響應結果
			- 獲取方式 ：xmlhttp.responseText
			- 什麼時候獲取？當伺服器響應成功後再獲取
			- 當xmlhttp物件的就緒狀態改變時，觸發事件onreadystatechange。
				```js
				xmlhttp.onreadystatechange=function()
				{
					//判斷readyState就緒狀態是否為4，判斷status響應狀態碼是否為200
					if (xmlhttp.readyState==4 && xmlhttp.status==200)
					{
					   //獲取伺服器的響應結果
						var responseText = xmlhttp.responseText;
						alert(responseText);
					}
				}
				```
	-  JQeury實現方式
		1. `$.ajax()`
			* 語法：$.ajax({鍵值對});
				```js
			 	//使用$.ajax()傳送非同步請求
				$.ajax({
					url:"ajaxServlet1111" , // 請求路徑
					type:"POST" , //請求方式
					//data: "username=jack&age=23",//請求引數
					data:{"username":"jack","age":23},
					success:function (data) {
						alert(data);
					},//響應成功後的回撥函式
					error:function () {
						alert("出錯啦...")
					},//表示如果請求響應出現錯誤，會執行的回撥函式

					dataType:"text"//設定接受到的響應資料的格式
				});
				```
			- JS文件中獲取 `contextPath` 的方法
				- [JS文件中獲取contextPath的方法](https://blog.csdn.net/zhuchunyan_aijia/article/details/51568521)
		1. `$.get()`：傳送get請求
			* 語法：`$.get(url, [data], [callback], [type])`
				* 參數：
					* url：請求路徑
					* data：請求引數
					* callback：回撥函式
					* type：響應結果的型別

		3. `$.post()`：傳送post請求
			* 語法：`$.post(url, [data], [callback], [type])`
				* 參數：
					* url：請求路徑
					* data：請求引數
					* callback：回撥函式
					* type：響應結果的型別



# JSON：
1. 概念： 
	JavaScript Object Notation
	_JavaScript物件表示法_
	```js
	var p = {"name":"張三","age":23,"gender":"男"};
	 ```
	* json現在多用於 _儲存_ 和 _交換文字資訊_ 的語法
	* 進行 _資料的傳輸_
	* JSON 比 XML 更小、更快，更易解析。

2. 語法：
	1. 基本規則
		* 資料在名稱/值對中：json資料是由 _鍵值對_ 構成的
			* _鍵_ 用引號(單雙都行)引起來，也可以不使用引號
			* _值_ 得取值型別：
				1. 數字（整數或浮點數）
				2. 字串（在雙引號中）
				3. 邏輯值（true 或 false）
				4. 陣列（在方括號中）	{"persons":[{},{}]}
				5. 物件（在花括號中） {"address":{"province"："陝西"....}}
				6. null
		* 資料由逗號分隔：多個鍵值對由逗號分隔
		* 花括號儲存物件：使用{}定義json 格式
		* 方括號儲存陣列：[]
	2. 獲取資料:
		1. json物件.鍵名
			- `person.name;`
		2. json物件["鍵名"]
			- `person["name"];`
		3. 陣列物件[索引]
		4. 遍歷
	```js
	//1.定義基本格式
	var person = {"name": "張三", age: 23, 'gender': true};
	
	//2.嵌套格式   {}———> []
	var persons = {  
		 "persons": [  
			 {"name": "张三", "age": 23, "gender": true},  
			 {"name": "李四", "age": 24, "gender": true},  
			 {"name": "王五", "age": 25, "gender": false}  
		 ]
	 };
	 //获取王五值  
	var name1 = persons.persons[2].name;
	 
	//2.嵌套格式   []———> {}
	var ps = [{"name": "張三", "age": 23, "gender": true},
		{"name": "李四", "age": 24, "gender": true},
		{"name": "王五", "age": 25, "gender": false}];
	//获取李四值
	var name2 = ps[1].name;




	//獲取person物件中所有的鍵和值
	//for in 迴圈
   for(var key in person){
		//這樣的方式獲取不行。因為相當於  person."name"
		//alert(key + ":" + person.key);
		alert(key+":" + person[key]);
	}

   //獲取ps中的所有值
	for (var i = 0; i < ps.length; i++) {
		var p = ps[i];
		for(var key in p){
			alert(key+":"+p[key]);
		}
	}
	```


3. JSON資料和Java物件的相互轉換

	* JSON解析器：
		* 常見的解析器：Jsonlib，Gson，fastjson，jackson

	1. JSON轉為Java物件
		1. 匯入jackson的相關jar包
		2. 建立Jackson核心物件 ObjectMapper
		3. 呼叫ObjectMapper的相關方法進行轉換
			1. `readValue(json字串資料,Class)`
	2. Java物件轉換JSON
		1. 使用步驟：
			1. 匯入jackson的相關jar包
			2. 建立Jackson核心物件 ObjectMapper
			3. 呼叫ObjectMapper的相關方法進行轉換
				1. 轉換方法：
					* `writeValue(引數1，obj)`:
						引數1：
							File：將obj物件轉換為JSON字串，並儲存到指定的檔案中
							Writer：將obj物件轉換為JSON字串，並將json資料填充到字元輸出流中
							OutputStream：將obj物件轉換為JSON字串，並將json資料填充到位元組輸出流中
					* `writeValueAsString(obj)`:將物件轉為json字串

				2. 註解：
					1. @JsonIgnore：排除屬性。
					2. @JsonFormat：屬性值得格式化
						* `@JsonFormat(pattern = "yyyy-MM-dd")`

				3. 複雜java物件轉換
					1. `List` 👉 陣列
					2. `Map`  👉 物件格式一致
		- 
			```java
			Map<String,Object> map = new HashMap<String,Object>();
        	map.put("userExsit",true);
        	map.put("msg","此用户名太受欢迎,请更换一个");
        	//将map转为json，并且传递给客户端
        	//将map转为json
        	ObjectMapper mapper = new ObjectMapper();
        	String mapJsonString = mapper.writeValueAsString(map);
			```


# 案例：
* 校驗使用者名稱是否存在
	1. 伺服器響應的資料，在客戶端使用時，要想當做json資料格式使用。有兩種解決方案：
		1. `$.get(type)` :將最後一個引數type指定為"json"
		2. 在伺服器端 _設定MIME型別_
			```java
			response.setContentType("application/json;charset=utf-8");
			```



# SpringMVC AJAX
1. 參數前加 `@RequestBody` 
	- 👉 ajax 要加上 `contentType:'application/json;charset=utf-8'`
		說明傳遞的是 _json 格式_
	- 傳遞的 json 對象要用 `JSON.stringify(data);` 
		將動態的 Object 轉成 _靜態json String_
	```java
	public String calendercopy(@RequestBody Map<String,Object> paramsMap){
		System.out.println(paramsMap);
		// {day=June.1.2021}
		System.out.println(paramsMap.get("day"));
		// June.1.2021
	}
	```
	```js
	$.ajax({
		url: "controller", // 请求路径
		type: "POST", //请求方式
	
		contentType: "application/json; charset=utf-8",
		data: JSON.stringify({'day': day }) ,
	
		dataType: "json", //设置接受到的响应数据的格式
		success: function (data) {
		},//响应成功后的回调函数
		error: function () {
		},
	});
	```
1. jQuery AJAX 預設的 Content-Type 格式
	- `Content-Type: application/x-www-form-urlencoded; charset=UTF-8`
		是以 _鍵值對拼接_ 的形式，如 `name=abc&phone=123456`，並不是application/json那樣的json格式`{"name":"abc","phone":"123456"}`
	- _參數必須改成_ `@RequestParam` 
	- `request.getParameter()` 可以用key得到value
	```java
	public String calendercopy(@RequestParam Map<String,Object> paramsMap , HttpServletRequest request) throws JsonProcessingException {
		System.out.println(request.getParameter("day"));
		// June.1.2021
		System.out.println(paramsMap);
		// {day=June.1.2021}
	}
	
	```
	```js
	$.post("calender_controller", { day: day }, function (data) {
		//判断userExsit键的值是否是true
		console.log('day: ', day);
	
		// alert(data);
		var span = $("#s_username");
		if (data.userExsit) {
			//用户名存在
			console.log(data.msg);
		} else {
			//用户名不存在
			console.log(data.msg);
		}
	});
	```


