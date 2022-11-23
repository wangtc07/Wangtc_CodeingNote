

#### 安裝

```bash
pip install requests
```



### 方法

```python
response.text
response.content
response.status_code
response.request,headers
response.headers
```



#### response.text 和response.content的區別

`response.text`
類型：`str`
解碼類型：根據HTTP頭部對響應的編碼做出有根據的推測，推測的文本編碼
如何修改編碼方式：response.encoding=”gbk”

`response.content`
類型：`bytes`
解碼類型：沒有指定
如何修改編碼方式：response.content.decode(“utf8”)



---

### 參考

[python requests中content與text方法的區別_Erice_s的博客-CSDN博客](https://blog.csdn.net/Erice_s/article/details/80115895)