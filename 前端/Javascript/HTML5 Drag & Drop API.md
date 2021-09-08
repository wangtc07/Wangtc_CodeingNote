[[筆記] 製作可拖曳的元素（HTML5 Drag and Drop API） ~ PJCHENder<br>那些沒告訴你的小細節](https://pjchender.blogspot.com/2017/08/html5-drag-and-drop-api.html)

> 在學習 HTML5 Drag & Drop API 時，最重要的是去區分 `Drag Source` 和 `Drop Target`，因為它們會需要各自去監聽不同的事件。

![](https://1.bp.blogspot.com/-yw9WFaksyB4/WaDkUJyGE9I/AAAAAAAA0uY/TYanhU_7-P8jcXoRWpyo99jBw3AoZYCbACLcBGAs/s640/%25E8%259E%25A2%25E5%25B9%2595%25E5%25BF%25AB%25E7%2585%25A7%2B2017-08-26%2B%25E4%25B8%258A%25E5%258D%258810.58.05.png)

- `Drag Source`指的是被點擊==要拖曳的物件==，也就是藍色的圓，通常是一個 element
- `Drop Target`指的是拖曳的==物件被放置的區域==，也就是右邊的綠色區域，通常是一個`div container`

## 事件（Event）
| Drag Source |     Drop Target     |
|:-----------:|:-------------------:|
| `dragstart` |                     |
|   `drag`    |     `dragenter`     |
|             | `dragover` 停在裡面 |
|             |     `dragleave`     |
|             |       `drop`        |
|  `dragend`  |                     |

