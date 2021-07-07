# Javascript

[JavaScript]
## 基本語法: 
- variables & types(內建物件 | class)
- input | output
- operators
	- ``===`` (絕對等於)	|	 ``!==`` (絕對不等於)
	- ???

- iterations
        。 while
        。 for | for....in
        。 do....while
- selections
        。 if | if....else
        。 switch
- Function 
	- 
		```jsx
		function fname(x,y){
    	        return XX;
    	    }
		```
		
- 命名大小寫
	內建物件(class) ==> PascalCase
   	屬性和方法 ==> camelCase
   	常數 ==> 全部大寫 (Math.PI) 
   	事件 ==> 全部小寫 (readystatechange)
	
- JS條件判斷為偽？(除以下六項，其餘皆為真)
    1. `0`
    1. `false`
    1. `'' or "" (空字串)`
    1. `undefined`
    1. `null`
    1. `NaN`

- 在 HTML, CSS, JavaScript 中，如何讓 p 標籤的字變大?
	```html
	.html
  <font size="+2">
      <p>Hello</p>
  </font> 
	```
	
	```css
	.css 
  p{
      font-size: 20px;
  }
	```
	
	```jsx
	.js
  // 先找到 p 物件
  theP.style.fontSize = '20px';
	```
	
- 在js裡面存取屬性
	- HTML 標籤本身的屬性
		- `img物件.scr = '路徑+檔名'`
		- `img物件.width = 00`
		- `某物件.id = 'myId'`
		- `某物件(input_text).value = 值`
	- CSS 的屬性
		- `img物件.style.width = '00px'`
		- `某物件.style.屬性 = 屬性值`

---
## 物件導向:
### 物件: 
何謂JS的物件: 自己宣告的==變數==，物件的==屬性==，所有的==HTML==，==事件==

- #### 物件的==屬性==(名詞|形容詞) 和==方法==(動詞)
   `? addEventListener()`
   `? parseInt()`
   `? innerHTML = 屬性值`

#### 事件
JavaScript is event-driven language. 
建立事件聆聽功能
		
1. 包括一個物件、一個事件、一個處理函數
2. 寫在 .html 
	 ``<body onload="doFirst()">``
3. 寫在 .js (傳統的寫法)
	``window.onload = doFirst;``
		``window.onload = function(){};``
4. 寫在 .js (W3C的推薦方式)
	``window.addEventListener('event',doFirst)	``
	``// 寫在js裡 even 不用加 on``
	==click => event==
	==onclick => event handler==

##### 事件分類
- ==輸入裝置(滑鼠)==
	- click | mousedown | mouseup | dblclick
	- mousemove 
	- mouseover | mouseout    //有支援冒泡事件
	- mouseenter | mouseleave //沒有支援冒泡事件
	- contextmenu
- ==鍵盤==
	- keypress | keydown | keyup
- ==browser==
	- resize(專用) | scroll 
	- copy | paste | cut (並非每個瀏覽器都有支援)
	- load | unload
- ==form==
	- submit | reset | select | change | input | focus | blur

		```jsx
		//theForm.onreset = function(){
                //    return confirm('Are you sure you want to reset the form?')
                //}
                change 事件的發生，不會在填寫的時候(focus)，會在填寫完畢並且blur之後
                select 事件的發生，會發生在使用者可以填寫的物件，例如: <input type="text">
		```

##### 事件物件 -> 屬性和方法
- 屬性
                clientX | clientY | pageX | pageY
                target | type | keyCode
- 方法
	- `preventDefault()`   //取消預設行為
	- `stopPropagation()`  //阻止冒泡事件
				[[Propagation]]

- 舉例
	- //事件物件經常用的命名： e | evt | event
		```jsx
		theForm.onreset = function(e){
			console.log(e.target);  //代表是哪個物件
			object HTMLFormElement
                 	console.log(e.target.nodeName);   //FORM
                  console.log(e.type);    //發生什麼事件  reset
			return confirm('Are you sure you want treset the form?')
		}
		```  
			



##### 引用事件物件

 - window 物件:
     - 屬性: 
         1. navigator
         2. location
         3. history
         4. document 物件:
	- 屬性: 
	- 方法: 
	`getElementById('myId')`
	`getElementsByName()`
	`getElementsByTagName('p')`
	`getElementsByClassName('myClass')`
	`querySelector('#myId')`
	`querySelectorAll('div p') | querySelectorAll('.myClass')`
	`物件.getElementsByTagName('div')[0].getElementsByTagName('p')`
       - 方法: 
            視窗類: alert() | confirm() | prompt()
- 內建物件: 
	- Number 預設(double)
	- 
- 自訂物件: 
