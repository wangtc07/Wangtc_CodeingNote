# method
- [setOnSeekBarChangeListener](https://developer.android.com/reference/android/widget/SeekBar#setOnSeekBarChangeListener(android.widget.SeekBar.OnSeekBarChangeListener))([SeekBar.OnSeekBarChangeListener](https://developer.android.com/reference/android/widget/SeekBar.OnSeekBarChangeListener) l)
	- 設置偵聽器以接收有關 SeekBar 進度級別更改的通知。

# SeekBar.OnSeekBarChangeListener
> `public static interface SeekBar.OnSeekBarChangeListener`

## method
- 
	```java
	onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
	```
	- 通知進度級別已更改。
- 
	```java
	onStartTrackingTouch(SeekBar seekBar)
	```
	- 用戶已開始觸摸手勢的通知。
- 
	```java
	onStopTrackingTouch(SeekBar seekBar)
	```
	- 用戶已完成觸摸手勢的通知。