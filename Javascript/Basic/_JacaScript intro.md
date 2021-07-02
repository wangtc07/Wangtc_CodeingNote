# JacaScripe 基礎

怎樣向頁面添加 JavaScript？

- 可以像添加 CSS 那樣將 JavaScript 添加到 HTML 頁面中。
CSS 使用 `<link>` 元素鏈接外部樣式表，使用 `<style>` 元素向 HTML 嵌入內部樣式表
JavaScript 這裡只需一個元素`<script>`。

- 內部 JavaScript
在 ``</body>`` 標簽結束前插入
  ```jsx
  <script>
    // 在此編寫 JavaScript 代碼 
  </script>
  ```
---

### 外部 JavaScript
跟HTML文件同目錄，在 ``</body>`` 標簽結束前插入

```jsx
<script src="script.js" async></script>
```
---
### 基本型態
```jsx
let i = 0;
let string = 'So long and thankk for all the fish';
let boolean = i < 5;

let stringArray = ['a' , 'b' , 'c'];
let numberArray = [1 , 2 , 3];

// object 使用 .點 呼叫
let object = { name : 'Spot' , breed : 'dalmatian'};
alert(object.name); //Spot

// typeof 返回變量是什麼類型
alert(typeof i); //number
```

```jsx
let myInt = 5;
let myFloat = 6.667;
// typeof myInt;
typeof myFloat;

let pow = 7 ** 3;  //等同下列
pow = Math.pow(7,3);
pow;     //343

++pow;   //344
```

# 動態類型

JavaScript是一種“動態類型語言”，這意味著不同於其他一些語言(譯者註：如C、JAVA)，您不需要指定變量將包含什麼數據類型（例如number或string）

---

# var and let

### 功能區塊 Function Scope

[https://codepen.io/wangtc07/pen/zYZZmVE](https://codepen.io/wangtc07/pen/zYZZmVE)

### { } 區塊

[https://codepen.io/wangtc07/pen/zYZZMem](https://codepen.io/wangtc07/pen/zYZZMem)

### loop區塊

[https://codepen.io/wangtc07/pen/yLMMGqZ](https://codepen.io/wangtc07/pen/yLMMGqZ)

# 運算符

Note: 您可能會看到有些人在他們的代碼中使用`==`和`!=`來判斷相等和不相等，這些都是JavaScript中的有效運算符。
但它們與`===/` `!==`不同，==前者測試值是否相同==， 但是數據類型可能不同，==而後者的嚴格版本測試值和數據類型是否相同==。 嚴格的版本往往導致更少的錯誤，所以我們建議您使用這些嚴格的版本。

# 類型

```jsx
let string = 'The revolution will not be televised.';
string;
let badString = string;
badString;

//單引號雙引號都可以使用
let sglDbl = 'Would you eat a "fish supper"?';
let dblSgl = "I'm feeling blue.";
sglDbl;
dblSgl;

//轉義字符 . ex:\'
let bigmouth = 'I\'ve got no right to take my place...';
bigmouth;

//轉換成數字 Number 對象將把傳遞給它的任何東西轉換成一個數字。
let numString = '123';
let num = Number(numString);
typeof num;                 //number

//轉為字符串 toString()方法
let numToString = num.toString();
```

# 字符串方法

```jsx
//在javascript中，一切東西都可以被當作對象。例如我們創建一個字符串。
let string = 'abc mozilla';

//獲得字符串的長度 length 屬性
string.length;      //返回string的長度

//檢索特定字符串字符>>在變量名的末尾包含方括號 [ ]
string[1];

//在字符串中查找子字符串並提取它
string.indexOf('mozilla');

if(string.indexOf('mozilla') !== -1) {
  // do stuff with the string
  string;
}

string.slice(0,3);      //提取字串0~3-1  "abc"

string.slice(2);        //提取2之後的字串  "c mozilla"

//轉換大小寫 .toLowerCase()和toUpperCase()字符串並將所有字符分別轉換為小寫或大寫。
let radData = 'My NaMe Is MuD';
radData.toLowerCase();
radData.toUpperCase();

//替換字符串的某部分 .使用replace()方法將字符串中的一個子字符串替換為另一個子字符串。
string.replace('abc' , 'xyz');
```

# Array

```jsx
let shopping = ['bread', 'milk', 'cheese', 'hummus', 'noodles'];
shopping;

//可以將任何類型的元素存儲在數組中 - 字符串，數字，對象，另一個變量，甚至另一個數組。
let random = ['tree', 795, [0, 1, 2]];

//訪問和修改數組元素
shopping[0];             //"bread"
shopping[0] = 'tahini';
shopping[0];             //"tahini"

//獲取數組長度
let sequence = [1, 1, 2, 3, 5, 8, 13];
sequence.length;         //7

for(let i = 0 ; i < sequence.length ; i++){
    console.log(sequence[i]);
}

//字符串和數組之間的轉換
let myData = 'Manchester,London,Liverpool,Birmingham,Leeds,Carlisle';

let myArray = myData.split(',');    //用每個逗號分隔它
myArray;

//使用 join() 方法進行相反的操作。 Array to String
let myNewString = myArray.join(' / ');
myNewString;    //"Manchester / London / Liverpool / Birmingham / Leeds / Carlisle"

let myNewString2 = myArray.toString();
myNewString2;   //"Manchester,London,Liverpool,Birmingham,Leeds,Carlisle"

//添加和刪除數組項
//數組末尾添加或刪除一個項目，我們可以使用  push() 和 pop()。
myArray.push('Bradford', 'finalAdd');
myArray;

var newLength = myArray.push('finalFinalAdd');    //number，儲存Array的長度
myArray;
newLength;

//刪除最後一個元素 
myArray.pop();      
myArray;                        //["Manchester", "London", "Liverpool", "Birmingham", "Leeds", "Carlisle", "Bradford", "finalAdd"]

//返回已刪除的項目
let removedItem = myArray.pop();    
myArray;                        //["Manchester", "London", "Liverpool", "Birmingham", "Leeds", "Carlisle", "Bradford"]
removedItem;                    //"finalAdd"

//unshift() 和 shift() 從功能上與 push() 和 pop() 完全相同，
//只是它們分別作用於數組的開始，而不是結尾。
myArray.unshift('addFromStart');
myArray;                        //["addFromStart", "Manchester", "London", "Liverpool", "Birmingham", "Leeds", "Carlisle", "Bradford"]

let removedFormStart = myArray.shift();
myArray;                        //["Manchester", "London", "Liverpool", "Birmingham", "Leeds", "Carlisle", "Bradford"]
removedFormStart                //"addFromStart"
```

# 條件語句

```jsx
//不是 false, undefined, null, 0, NaN 的值，或一個空字符串（''）在作為條件語句進行測試時實際返回true
var cheese = 'Cheddar';

// 等於true
if (cheese) {
  console.log('Yay! Cheese available for making cheese on toast.');
} else {
  console.log('No cheese on toast for you today.');
}

//邏輯運算符：&&  , || 和 !

//switch語句
switch ('choice2') {
  case 'choice1':
    //run this code
    alert('chice1')
    break;

  case 'choice2':
    //run this code instead
    alert('chice2')
    break;
  // include as many cases as you like
  default:
    //actually, just run this code
}

//三元運算符
var greeting = ( true ) ? 'Happy birthday Mrs. Smith — we hope you have a great day!' : 'Good morning Mrs. Smith.';
greeting;
```

[在代码中做决定 - 条件语句 - Playable_code - code sample](https://yari-demos.prod.mdn.mozit.cloud/zh-CN/docs/learn/JavaScript/Building_blocks/conditionals/_samples_/Playable_code)

# 循環語句

[https://codepen.io/wangtc07/pen/VwPgQdy](https://codepen.io/wangtc07/pen/VwPgQdy)

[https://codepen.io/wangtc07/pen/jOydZxj](https://codepen.io/wangtc07/pen/jOydZxj)

[https://codepen.io/wangtc07/pen/rNjPdoJ](https://codepen.io/wangtc07/pen/rNjPdoJ)

# 函數

[JavaScript 标准内置对象](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects)

---