- 解析器在調用函數時，每次都會向函數內部傳遞一個隱含的參數
	這個參數就是 `this`
	- `this` 指向一個對象，稱為函數執行的上下文對象
		根據調用的方式不同，`this`會指向不同對象
		1. 以函數形式調用，`this`永遠都是`window`
		2. 以方法形式調用，`this`就是調用方法的對象
```js
        function fun(a, b) {
            console.log('a: ', a);
            console.log('b: ', b);

            console.log('this.a: ', this.a);
            console.log('this.b: ', this.b);
            console.log('this: ' , this);
        }

        let a = "let a";   //this.a:  undefined 找不到此數值
        var b = 'var b';
        fun(1 , 2);

        let obj = { name: 'wang',
                    sayname:fun            
        }

        obj.sayname('obj_a' , 'obj_b');
```

```js
a:  1
b:  2
this.a:  undefined
this.b:  var b
this:  Window 
---
a:  obj_a
b:  obj_b
this.a:  undefined
this.b:  undefined
this:  {name: "wang", sayname: ƒ}
```

![[_24_this.html]]