# xpath


- 路徑查詢
`//` : 查找所有子節點，不考慮層級關係
`/` : 找直接子節點

- 謂詞查詢
`//div[@id]`
`//div[@id="maincontent"]`

- 屬性查詢
`//@class`

- 模糊查詢
`//div[contains(@id, "he")]`
`//div[starts-with(@id, "he")]`

- 內容查詢
`//div/h1/tet()`

- 邏輯查詢
`//div[@id="head" and @class="s_down"]`
`//title | //price`


```python
# xpath 解析
# 1. 本地文件 etree.parse
# 2. 響應數據 etree.HTML()  response.read().decode('UTF-8')

# 解析本地文件
tree = etree.parse('069.html')
print(tree)

# 找 ul 下面的 li
liList = tree.xpath('//body/ul/li')
print(len(liList)) # 判斷列表長度

# 找所有有 id 屬性的 li 標籤
# text() 獲取標籤內內容
liList2 = tree.xpath('//ul/li[@id]/text()')
print(liList2)

# 找 id 為 l1 的標籤
liList3 = tree.xpath('//ul/li[@id="l1"]/text()')
print(liList3)

# 找到 id 為 l1 的標籤的 class 屬性值
liList4 = tree.xpath('//ul/li[@id="l1"]/@class')
print(liList4)

# 找 id 中包含 2 的 li 標籤
liList5 = tree.xpath('//ul/li[contains(@id, "2")]/text()')
print(liList5)

# 找 id 中以 c 開頭的 li 標籤
liList6 = tree.xpath('//ul/li[starts-with(@id, "c")]/text()')
print(liList6)

# 查詢 id=l1 且 class=city
liList7 = tree.xpath('//ul/li[@id="l1" and @class="city"]/text()')
print(liList7)

# 查詢 id=l1 或 id=c1
# liList8 = tree.xpath('//ul/li[@id="l1" | @id="c1"]/text()') # 錯誤
liList8 = tree.xpath('//ul/li[@id="l1"]/text() | //ul/li[@id="c1"]/text()')
print(liList8)
```
