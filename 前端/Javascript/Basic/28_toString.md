- 直接打印一個對象時，事實上是輸出對象的 `toSting()` 方法
- 修改構造函數的原型`toString`，不同對象才能共用同方法

---

```js
        function Person(name , age){
            this.name = name;
            this.age = age;
        }

        let per = new Person('wang', 5);
        let per2 = new Person('mayu', 17);

        // 直接打印一個對象時，事實上是輸出對象的 toSting() 方法
        console.log('per: ', per);      // Person {name: "wang", age: 5}

        // toSting() 是屬於 Object 的方法
        console.log(per.**proto**.**proto**.hasOwnProperty('toString'));  // true

        // 修改Person原型的toString，不同對象才能共用同方法
        Person.prototype.toString = function () {
            return `name: ${this.name}, age: ${this.age},`;
        }

        console.log(per.toString());    // name: wang, age: 5,
        console.log(per2.toString());   // name: mayu, age: 17,
```
