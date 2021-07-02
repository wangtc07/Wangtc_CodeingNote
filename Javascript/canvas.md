# canvas 元素
```html
<canvas id="canvas" width="150" height="150"></canvas>
```
- 渲染環境(rendering context)
	```js
	var canvas = document.getElementById('tutorial');
	var ctx = canvas.getContext('2d');
    //宣告ctx渲染方式
	```
	
## 繪製圖形
### 矩形
x, y代表從原點出發的座標位置，width, height代表矩形的寬高。
- `fillRect(_x_, _y_, _width_, _height_)`
	- 畫出一個填滿的矩形。
- `strokeRect(_x_, _y_, _width_, _height_)`
	- 畫出一個矩形的邊框
- `clearRect(_x_, _y_, _width_, _height_)`
	- 清除指定矩形區域內的內容，使其變為全透明。	
### 弧形
[arc(x, y, radius, startAngle, endAngle, anticlockwise)](https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/arc "Currently only available in English (US)")
- 本方法接受五個參數: 
	- x, y代表圓心座標點，
	- radius代表半徑，
	- startAngle, endAngle分別代表沿著弧形曲線上的起始點與結束點的弧度，弧度測量是相對於x軸，
		> arc()方法用的是弧度(radians)而非角度(degrees)，如果要在弧度與角度間換算，可以利用以下javascript程式碼: `radians = (Math.PI/180) \* degrees`
	- anticlockwise為true代表逆時針作圖、false代表順時針作圖。

## 路徑繪製
- [beginPath()](https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/beginPath "Currently only available in English (US)")
	- 產生一個新路徑，產生後再使用繪圖指令來設定路徑。

- [closePath()](https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/closePath "Currently only available in English (US)")
	- 閉合路徑好讓新的繪圖指令來設定路徑。

- [路徑 API](https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D#Paths)
	- 路徑 API，這些 API 便是繪圖指令

- [stroke()](https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/stroke "Currently only available in English (US)")
	- 畫出圖形的邊框。

- [fill()](https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/fill "Currently only available in English (US)")
	- 填滿路徑內容區域來產生圖形。