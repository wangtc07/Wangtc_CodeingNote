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
		2. `$.get()`：傳送get請求
			* 語法：`$.get(url, [data], [callback], [type])`
				* 引數：
					* url：請求路徑
					* data：請求引數
					* callback：回撥函式
					* type：響應結果的型別

		3. `$.post()`：傳送post請求
			* 語法：`$.post(url, [data], [callback], [type])`
				* 引數：
					* url：請求路徑
					* data：請求引數
					* callback：回撥函式
					* type：響應結果的型別



# JSON：
1. 概念： JavaScript Object Notation		JavaScript物件表示法
	Person p = new Person();
	p.setName("張三");
	p.setAge(23);
	p.setGender("男");

	var p = {"name":"張三","age":23,"gender":"男"};

	* json現在多用於儲存和交換文字資訊的語法
	* 進行資料的傳輸
	* JSON 比 XML 更小、更快，更易解析。

2. 語法：
	1. 基本規則
		* 資料在名稱/值對中：json資料是由鍵值對構成的
			* 鍵用引號(單雙都行)引起來，也可以不使用引號
			* 值得取值型別：
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
		2. json物件["鍵名"]
		3. 陣列物件[索引]
		4. 遍歷
				 //1.定義基本格式
				var person = {"name": "張三", age: 23, 'gender': true};

				var ps = [{"name": "張三", "age": 23, "gender": true},
					{"name": "李四", "age": 24, "gender": true},
					{"name": "王五", "age": 25, "gender": false}];




				//獲取person物件中所有的鍵和值
				//for in 迴圈
			   /* for(var key in person){
					//這樣的方式獲取不行。因為相當於  person."name"
					//alert(key + ":" + person.key);
					alert(key+":"+person[key]);
				}*/

			   //獲取ps中的所有值
				for (var i = 0; i < ps.length; i++) {
					var p = ps[i];
					for(var key in p){
						alert(key+":"+p[key]);
					}
				}


3. JSON資料和Java物件的相互轉換

	* JSON解析器：
		* 常見的解析器：Jsonlib，Gson，fastjson，jackson

	1. JSON轉為Java物件
		1. 匯入jackson的相關jar包
		2. 建立Jackson核心物件 ObjectMapper
		3. 呼叫ObjectMapper的相關方法進行轉換
			1. readValue(json字串資料,Class)
	2. Java物件轉換JSON
		1. 使用步驟：
			1. 匯入jackson的相關jar包
			2. 建立Jackson核心物件 ObjectMapper
			3. 呼叫ObjectMapper的相關方法進行轉換
				1. 轉換方法：
					* writeValue(引數1，obj):
						引數1：
							File：將obj物件轉換為JSON字串，並儲存到指定的檔案中
							Writer：將obj物件轉換為JSON字串，並將json資料填充到字元輸出流中
							OutputStream：將obj物件轉換為JSON字串，並將json資料填充到位元組輸出流中
					* writeValueAsString(obj):將物件轉為json字串

				2. 註解：
					1. @JsonIgnore：排除屬性。
					2. @JsonFormat：屬性值得格式化
						* @JsonFormat(pattern = "yyyy-MM-dd")

				3. 複雜java物件轉換
					1. List：陣列
					2. Map：物件格式一致


# 案例：
* 校驗使用者名稱是否存在
	1. 伺服器響應的資料，在客戶端使用時，要想當做json資料格式使用。有兩種解決方案：
		1. $.get(type):將最後一個引數type指定為"json"
		2. 在伺服器端設定MIME型別
			response.setContentType("application/json;charset=utf-8");






