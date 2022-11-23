html 原生 彈跳視窗

[HTML dialog](https://codepen.io/deathhell/pen/KKyxoEK)

```html
<body>
  <button id="show">show</button>
  <dialog id="infoModal">
    <p>這是 html 的 dialog!!</p>
    <button id="close">close</button>
  </dialog>
</body>
<style>
  dialog {
    border: none;
    box-shadow: 0 2px 6px #ccc;
    border-radius: 10px;
  }
  dialog::backdrop {
    background-color: rgba(0, 0, 0, 0.1);
  }
</style>

<script>
  let btn = document.querySelector("#show");
  let infoModal = document.querySelector("#infoModal");
  let close = document.querySelector("#close");
  btn.addEventListener("click", function () {
    infoModal.showModal();
  });
  close.addEventListener("click", function () {
    infoModal.close();
  });
</script>
```

