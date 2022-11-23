#### 建立單階層目錄

```python
import os

path = 'C:\\a'
if not os.path.isdir(path):
    os.mkdir(path)
```



#### 建立多層目錄

```python
import os

path = 'C:\\a\b\c\d'
if not os.path.isdir(path):
    os.makedirs(path)
```



#### 開檔案

```python
file = open(path + '\' + "開檔", 'w' )
```

