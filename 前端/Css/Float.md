# Float
```ad-info
[金魚都能懂網頁設計入門 : Float浮動 - 鐵人賽第九天 | CSS教學 | 網頁教學 - YouTube](https://www.youtube.com/watch?v=-AO1IdBTY5c&list=PLqivELodHt3iL9PgGHg0_EF86FwdiqCre&index=8)
```
- `float`: 浮動
	- 被設定的物件會浮起來，其他未設定的物件會跑到Float物件下方
- `clear`: 避開浮動

# Demo1
- [[Float_三欄.html]]
- 利用 `clear` 把 container 的高度撐開
	- 
		```ad-success
		![](https://i.imgur.com/L4JqZRm.png)
		```

	- 
		```html:floatDemo.html
		<style>
				* {
					margin: 0;
					padding: 0;
				}

				.container {
					width: 960px;
					background-color: #ddd;
					margin: auto;
					/* height: 10px; */
				}

				.col {
					width: 300px;
					margin: 10px;
					height: 100px;
					background-color: #aaa;
					float: left;
				}

				.clearfix {
					clear: both;
					background-color: red;
					height: 10px;
				}
			</style>
			<div class="container">
				<div class="col"></div>
				<div class="col"></div>
				<div class="col"></div>
				<div class="clearfix"></div>
			</div>
		```