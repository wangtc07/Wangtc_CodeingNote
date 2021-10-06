> Web Storage 有兩種型態的儲存體：`localStorage`和`sessionStorage`
> 查看位置
> ![](https://i.imgur.com/gkCtrvF.png)

# Local Storage

**本機儲存空間**
持續時間由撰寫者指定，不會隨著瀏覽器關閉而自動終止。

- 把值放到儲存區中

  - `localStorage.settings = 'ABC';`
  - `localStorage['settings'] = 'ABC';`
  - `localStorage.setItem('settings','ABC');`

- 取出值
  - `localStorage.settings ;`
  - `localStorage['settings'];`
  - `localStorage.getItem('settings');`
- 刪除值
  - `delete localStorage.settings ;`
  - `delete localStorage['settings'];`
  - `localStorage.removeItem('settings');`
- 刪除所有資料
  - `localStorage.clear();`

# Session Storage

**連線時段儲存空間**
sessionStorage 每個分頁有各自的資料，當網頁關閉時，sessionStorage 會被刪除。
