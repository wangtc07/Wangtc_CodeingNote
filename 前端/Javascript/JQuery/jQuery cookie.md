[jquery中cookie用法例項詳解(獲取,儲存,刪除等) | 程式前沿 (codertw.com)](https://codertw.com/%E5%89%8D%E7%AB%AF%E9%96%8B%E7%99%BC/271228/)

---

# jQuery cookie 增刪
```js
$.cookie('the_cookie'); 
// 讀取 cookie 

$.cookie('the_cookie', 'the_value'); 
// 儲存 cookie 

$.cookie('the_cookie', 'the_value', { expires: 7 }); 
// 儲存一個帶7天期限的 cookie 

$.cookie('the_cookie', '', { expires: -1 }); 
// 刪除 cookie
```