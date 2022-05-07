### ㄧ. 什麼是 pip 和為什麼需要他？

> pip The Python Package Installer[¶](https://pip.pypa.io/en/stable/#pip-the-python-package-installer)
> pip is the [package installer](https://packaging.python.org/guides/tool-recommendations/) for Python. You can use pip to install packages from the [Python Package Index](https://pypi.org/) and other indexes.
> 
> [https://pip.pypa.io/en/stable/](https://pip.pypa.io/en/stable/)

就如同上述 [pip 官方說明](https://pip.pypa.io/en/stable/) 所述，pip 是一個 Python 安裝管理套件工具，如果你今天要使用任何與 Python 有關的套件，基本上都會用到 pip 來安裝或是更新 Python 相關套件唷！

### 二. 如何安裝 pip ?

##### ▍安裝 pip 前請留意

目前 Python 3 的 3.4 版本以上 或是 Python 2 的 2.7.9 版本以上的 Python 都已經自帶 pip 了! 所以如果不是 Python 版本過舊的話，基本上不用需要安裝 pip 唷！

想要查詢目前使用的 Python 版本的話，在終端機中輸入以下指令，就可以知道目前的 Python 版本囉：

```
$ python --version

>>> Python 3.7.7
```

##### ▍Mac 的朋友安裝 pip 看這邊

1. 到 [pip document 官方網站](https://pip.pypa.io/en/stable/installing/) 建議的載點下載 pip 安裝檔

```
$ curl https://bootstrap.pypa.io/get-pip.py -o get-pip.py
```

2. 啟動剛剛下載好的 get-pip.py 檔案，就安裝完成囉！

```
$ python get-pip.py
```

3. 如何查看 pip 目前版本?

```
$ python -m pip --version
```

4. 如何更新 pip 到最新版本?

```
$ python -m pip install --upgrade pip
```

##### ▍Windows 的朋友安裝 pip 看這邊

1. 到 [pip document 官方網站](https://pip.pypa.io/en/stable/installing/) 建議的載點下載 pip 安裝檔

```
$ curl https://bootstrap.pypa.io/get-pip.py -o get-pip.py
```

2. 啟動剛剛下載好的 get-pip.py 檔案，就安裝完成囉！

```
$ py get-pip.py
```

3. 如何查看 pip 目前版本?

```
$ py -m pip --version
```

4. 如何更新 pip 到最新版本?

```
$ py -m pip install -U pip
```

##### ▍Linux 的朋友安裝 pip 看這邊

```
$ apt-get install python-pip 
```

### 三. pip 指令全記錄

1. 安裝套件： 可以將 flask 換成任何想安裝的 Python 套件

```
$ pip install flask
```

2. 更新套件：

```
 $ pip install -U flask
```

3. 移除安裝過的套件：

```
$ pip uninstall flask
```

4. 安裝並且指定套件版本：

```
$ pip install -v flask==1.0 
```

5. 查看目前安裝過的清單：

```
 $ pip list
```

### 四. 如何使用 pip 一次安裝多個套件

每次換環境就需要重新安裝套件，輸入指令重新安裝很麻煩，所以我們通常都會將要安裝的套件寫在 txt 檔案裡面，只需要 install 這個文字檔就可以一次安裝所有需要的套件囉！

1. pip 安裝 requirements.txt 內的清單：

```
$ pip install -r requirements.txt 
```

2. 將安裝過的套件建立成 requirements.txt 文件清單：

```
$ pip freeze > requirements.txt
```
