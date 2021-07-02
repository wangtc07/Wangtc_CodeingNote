# AndroidManifest.xml setting
```html
<!--瀏覽網頁會用到網路，需要加入uses-permission - INTERNET請求用戶同意-->  
<uses-permission android:name="android.permission.INTERNET" />
```

```html, java
<!--Android 9 (API 28)開始要求加密連線 (https)；  
 要允許不加密連線 (http) 就必須將usesCleartextTraffic設定為true-->
 android:usesCleartextTraffic="true"
 ```
 
 ---
# MainActivity.java setting
 ```java
 /* WebView上可運行JavaScript語法 */
     webView.getSettings().setJavaScriptEnabled(true);
```

```java
//WebView元件欲載入網址
	webView.loadUrl("http://www.google.com");
```
<br>

- 在webView顯示其他連結頁面
```java
/* 如果沒有覆寫shouldOverrideUrlLoading()並回傳false，
 用戶點擊任何連結都會自動開啟手機內建的瀏覽器來呈現內容 */
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		return false;
	}

	/* shouldOverrideUrlLoading(WebView view, String url)
	   在API 24時被列為deprecated，官方文件建議改覆寫下面方法 */
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
		return false;
	}
```
<br>

- 回到上個網頁
```java
/* 預設點擊手機返回鍵會返回前一個Android頁面（Activity），
   可以覆寫onKeyDown()，讓用戶回到上個網頁而非上個Android頁面。 */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
```	