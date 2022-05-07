將響應式對象轉換為普通對象，其中結果對象的每個 property 都是指向原始對象相應 property 的 `ref`。

```js
const state = reactive({
  foo: 1,
  bar: 2
})

const stateAsRefs = toRefs(state)
/*
stateAsRefs 的類型:

{
  foo: Ref<number>,
  bar: Ref<number>
}
*/

// ref 和原始 property 已經“鏈接”起來了
state.foo++
console.log(stateAsRefs.foo.value) // 2

stateAsRefs.foo.value++
console.log(state.foo) // 3
```

# use
可不用再寫 `{{ person.name }}`
```html
<h1> {{ name }} - {{ age }} </h1>
```

```js

const person = reactive({
	name: 'wang',
	age: 18
})

const personRefs = toRefs(person);

return{
	...personRefs
}
```