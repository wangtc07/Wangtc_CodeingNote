#### 簡介

1. Virtual DOM

   DOM Diffing 算法，最小化頁面重繪![截圖 2022-11-03 14.25.26](https://i.imgur.com/VuFvP0b.png)

---

#### Hello World

Version: 16.8

###### 使用 jsx 創建虛擬DOM

> `ReactDOM.render()` React 18 之後不支持

```react
<div id="test"></div>

<!-- 核心庫 -->
<script
  crossorigin
  src="https://unpkg.com/react@18/umd/react.development.js"
  ></script>
<!-- react dom -->
<script
  crossorigin
  src="https://unpkg.com/react-dom@18/umd/react-dom.development.js"
  ></script>
<!-- babel jsx -> js -->
<script src="../js/babel.min.js"></script>

<script type="text/babel">
  // 此處一定要寫 babel

  // 1. 創建虛擬 DOM
  // 此處不能寫引號
  const vdom = <h1> Hello, React </h1>;

  // 2. 選染到頁面
  // Warning: ReactDOM.render is no longer supported in React 18. Use createRoot instead. Until you switch to the new API, your app will behave as if it's running React 17. Learn more: https://reactjs.org/link/switch-to-createroot
  ReactDOM.render(vdom, document.getElementById("test"));
</script>
```

###### 使用 js 創建虛擬DOM

```react
<script type="text/javascript">
  // 此處一定要寫 babel

  // 1. 創建虛擬 DOM
  // 此處不能寫引號
  const vdom = React.createElement("h1", { id: "title" }, "Hello, React"); // 標籤名, 標籤屬性, 標籤內容

  // 2. 選染到頁面
  // Warning: ReactDOM.render is no longer supported in React 18. Use createRoot instead. Until you switch to the new API, your app will behave as if it's running React 17. Learn more: https://reactjs.org/link/switch-to-createroot
  ReactDOM.render(vdom, document.getElementById("test"));
</script>
```

##### 虛擬DOM

1. 本質為 Object 類型 (一般對象)
2. 虛擬DOM是 React 內部使用，無需像真實DOM那麼多屬性
   所以虛擬DOM較輕
3. 虛擬DOM最終會被 React 轉會成真實DOM，呈現在頁面上