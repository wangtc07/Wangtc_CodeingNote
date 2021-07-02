# Activity

## public methods

### onCreateOptionsMenu
```java
public boolean onCreateOptionsMenu (Menu menu)
```
- 畫面載入時創建

### onOptionsItemSelected
```java
public boolean onOptionsItemSelected (MenuItem item)
```
- `itme`
	- 被選中的菜單項。此值不能為空。
- 每當選擇選項功能表中的專案時被調用。
- ==做對應的處理即可回傳true==，讓Menu處理到此為止
	- 預設實現只是返回錯誤，以允許正常菜單處理繼續


### registerForContextMenu
```java
public void registerForContextMenu (View view)
```
- 註冊要顯示給定檢視的上下文菜單（多個檢視可以顯示上下文菜單）。此方法將設置此活動的檢視，因此在顯示上下文菜單時將調用該檢視。

[OnCreateContextMenuListener](https://developer.android.com/reference/android/view/View.OnCreateContextMenuListener)

[onCreateContextMenu(android.view.ContextMenu, android.view.View, android.view.ContextMenu.ContextMenuInfo)](https://developer.android.com/reference/android/app/Activity#onCreateContextMenu(android.view.ContextMenu,%20android.view.View,%20android.view.ContextMenu.ContextMenuInfo))

### onCreateContextMenu
```java
public void onCreateContextMenu (ContextMenu menu, 
                				 View v, 
                				 ContextMenu.ContextMenuInfo menuInfo)
```
- 在即將顯示 的上下文菜單時調用。這將在==每次即將顯示上下文菜單時調用==

### onContextItemSelected
```java
public boolean onContextItemSelected (MenuItem item)
```
- 每當 `ContextMenu` 中的專案時被調用。
- ==做對應的處理即可回傳true==，讓Menu處理到此為止
	- 預設實現只是返回錯誤，以允許 `ContextMenu` 處理繼續