# Menus
```java
public interface Menu
```
[菜單  |  Android 開發者  |  Android Developers](https://developer.android.com/guide/topics/ui/menus) 

## 在XML中定義 Menus

# OptionsMenu
- 可以通過 Activity 子類或 Fragment 子類為選項菜單聲明菜單項
	- 如需為 Activity 指定選項菜單，
		請替換Override onCreateOptionsMenu()
- 創建 OptionsMenu
	- ![[Activity#onCreateOptionsMenu]]
- 選擇 OptionsMenu item
	- ![[Activity#onOptionsItemSelected]]


# ContextMenu
```java
public interface ContextMenu
implements Menu
```
- 註冊要為給定視圖顯示的上下文菜單（多個視圖可以顯示上下文菜單）。
	- ![[Activity#registerForContextMenu]]
- 顯示 ContextMenu
	- ![[Activity#onCreateContextMenu]]
- 選擇 ContextMenu item
	- ![[Activity#onContextItemSelected]]




# PopupMenu
```java
public class PopupMenu
extends Object
```
## method
- 
	```java
	inflate(int menuRes)
	```
	- 將菜單資源 inflate 到此 PopupMenu 中。
- 
	```java
	setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener listener)
	```
	- 設置一個偵聽器，當用戶從菜單中選擇一個項目時將收到通知。
		- 
			```java
			public interface OnMenuItemClickListener {
			        boolean onMenuItemClick(MenuItem item);
			    }
			```
			- `item`: 被點擊的菜單項
			- 如果事件被處理，則為 `true`，否則為 `false`
- `show()`