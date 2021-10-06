[Intellij IDEA集成PHP](https://blog.csdn.net/xu1227233860/article/details/53693175)

# Intellij IDEA2016集成PHP

前些天由於學習需要，需要學習PHP一些基礎知識。當然，為了更形象化一些，最好的方法就是把學到的代碼到開發工具裡運行。開始用記事本寫了一些代碼，但是苦於沒有運行效果，而自己電腦裡只有IDEA。而在百度搜索了一會兒也沒能找到有效的集成PHP的方法，所以就自己慢慢地去試了，終於還是找到了。首先，我們得需要一些基礎的環境：

-   **安裝 web 服務器**
-   **安裝 PHP**
-   **安裝數據庫，比如 MySQL**

所以，為了滿足這幾個要求，我們得安裝Apache、PHP、MySQL。怎麼感覺有點多嘞，還好，有已經集成好的軟件，我們安裝一個就可以用到所有的功能了。那就是強大的WAMP service，即在windows下提供Apache、MySQL和PHP的服務。安裝過程我就忽略了，接下來直接講集成PHP的步驟。

![這裡寫圖片描述](https://img-blog.csdn.net/20161216143737195?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveHUxMjI3MjMzODYw/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![這裡寫圖片描述](https://img-blog.csdn.net/20161216143858180?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveHUxMjI3MjMzODYw/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![這裡寫圖片描述](https://img-blog.csdn.net/20161216143910441?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveHUxMjI3MjMzODYw/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![這裡寫圖片描述](https://img-blog.csdn.net/20161216143923238?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveHUxMjI3MjMzODYw/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![這裡寫圖片描述](https://img-blog.csdn.net/20161216143935754?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveHUxMjI3MjMzODYw/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![這裡寫圖片描述](https://img-blog.csdn.net/20161216144006317?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveHUxMjI3MjMzODYw/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![這裡寫圖片描述](https://img-blog.csdn.net/20161216144017740?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveHUxMjI3MjMzODYw/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![這裡寫圖片描述](https://img-blog.csdn.net/20161216144033321?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveHUxMjI3MjMzODYw/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![這裡寫圖片描述](https://img-blog.csdn.net/20161216144100959?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveHUxMjI3MjMzODYw/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![這裡寫圖片描述](https://img-blog.csdn.net/20161216144155430?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveHUxMjI3MjMzODYw/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![這裡寫圖片描述](https://img-blog.csdn.net/20161216144210681?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveHUxMjI3MjMzODYw/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![這裡寫圖片描述](https://img-blog.csdn.net/20161216144241525?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveHUxMjI3MjMzODYw/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![這裡寫圖片描述](https://img-blog.csdn.net/20161216144305681?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveHUxMjI3MjMzODYw/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![這裡寫圖片描述](https://img-blog.csdn.net/20161216144336338?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveHUxMjI3MjMzODYw/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![這裡寫圖片描述](https://img-blog.csdn.net/20161216144348479?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveHUxMjI3MjMzODYw/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)