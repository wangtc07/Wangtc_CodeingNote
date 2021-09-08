# DOM
> 操作網頁

Document Object Model 文檔對象模型
- Document
	表示整個HTML網頁
- Object
	網頁中每個部分都轉換為了一個對象
- Model
	表示對象之間的關係，方便獲取對象
	
## Node
網頁中的每個部分都可以稱為節點
如: 標籤、屬性、文本、註釋等等

### 節點類型
- doucument節點
- 元素節點: html標籤
- 屬性節點: 元素的屬性
- 文本節點: 標籤中的文本內容

### 節點屬性
每個節點都有
- `nodeName`
- `nodeType`
- `nodeValue`

|          |  nodeName   | nodeType | nodeValue |
|:--------:|:-----------:|:--------:|:---------:|
| 文檔節點 | `#document` |    9      |   null    |
| 元素節點 |   標籤名     |    1      |   null    |
| 屬性節點 |   屬性名     |    2      |  屬性值   |
| 文本節點 |   `text`    |    3      | 文本內容  |

![[37_獲取對象#get by id]]


---
## 事件
用戶和瀏覽器之間的交互行為
如: 點擊、滑鼠移動、關閉窗口等等

