[IDEA集成XDebug，調式PHP項目_流氓兔的博客-CSDN博客_idea xdebug](https://blog.csdn.net/weixin_42170236/article/details/102741996?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522163092307716780262594031%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=163092307716780262594031&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_v2~rank_v29-3-102741996.pc_search_result_hbase_insert&utm_term=Intellij+IDEA+PHP+xdebug&spm=1018.2226.3001.4187)
# 一、Wamp配置xdebug

**本文以禪道項目為例，wamp安裝在C盤下**

## 1.1 Php項目放在wamp/www下

![](https://img-blog.csdnimg.cn/20191025140928872.png)

## 1.2 Wamp配置xdebug

修改文件C:\wamp\bin\apache\apache2.4.23\bin\php.ini，在xdebug模塊添加以下配置，沒有就新增

實際修改的是C:\wamp\bin\php\php7.0.10\phpForApache.ini文件

remote_port端口號不能沖突，remote_port和idekey需要記住，後面會用到

```
[xdebug] zend_extension = "c:/wamp/bin/php/php7.0.10/zend_ext/php_xdebug-2.4.1-7.0-vc14.dll"xdebug.remote_enable = onxdebug.profiler_enable = onxdebug.profiler_enable_trigger = onxdebug.profiler_output_name = cachegrind.out.%t.%pxdebug.profiler_output_dir ="C:/wamp/tmp"xdebug.show_local_vars=0 ;遠程處理協議xdebug.remote_handel=dbgp ;端口號xdebug.remote_port=9999;IDE KEYxdebug.idekey="mykey"xdebug.remote_connect_back=1
```

# 二、idea配置

## 2.1 安裝插件

idea中需要下載Oro PHPStorm Plugin 與 PHP插件，然後重啟

File->Settings…->Plugins->Install JetBrains plugin..

搜Oro PHPStorm Plugin 與 PHP

## 2.2 修改php配置

file -> settings

![](https://img-blog.csdnimg.cn/20191025140927489.png)

![](https://img-blog.csdnimg.cn/20191025140928937.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjE3MDIzNg==,size_16,color_FFFFFF,t_70)

![](https://img-blog.csdnimg.cn/201910251409295.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjE3MDIzNg==,size_16,color_FFFFFF,t_70)

Debug -> xdebug -> port與php.ini文件中設置的remote_port相同

![](https://img-blog.csdnimg.cn/20191025140928967.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjE3MDIzNg==,size_16,color_FFFFFF,t_70)

## 2.3 新建services

Php -> services -> 新建

名稱隨意，host寫localhost就行，port與http.conf中設置的Listen一致，debugger選擇Xdebug

![](https://img-blog.csdnimg.cn/20191025140928978.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjE3MDIzNg==,size_16,color_FFFFFF,t_70)

![](https://img-blog.csdnimg.cn/20191025143113778.png)

## 2.4 創建configurations

Run-> edit configurations

![](https://img-blog.csdnimg.cn/20191025140928948.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjE3MDIzNg==,size_16,color_FFFFFF,t_70)

![](https://img-blog.csdnimg.cn/20191025140928977.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjE3MDIzNg==,size_16,color_FFFFFF,t_70)

![](https://img-blog.csdnimg.cn/20191025140928975.png)

Idea中打斷點，debug模式正常啟動，進入斷點

![](https://img-blog.csdnimg.cn/20191025140928987.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjE3MDIzNg==,size_16,color_FFFFFF,t_70)