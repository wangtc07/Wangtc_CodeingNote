# method
- [setOnRatingBarChangeListener](https://developer.android.com/reference/android/widget/RatingBar#setOnRatingBarChangeListener(android.widget.RatingBar.OnRatingBarChangeListener))([RatingBar.OnRatingBarChangeListener](https://developer.android.com/reference/android/widget/RatingBar.OnRatingBarChangeListener) listener)
	- 設置當評級改變時要調用的偵聽器。

# RatingBar.OnRatingBarChangeListener
> `public static interface RatingBar.OnRatingBarChangeListener`
### Public methods
> 實作onRatingChanged():評分狀態改變時會自動執行
- [onRatingChanged](https://developer.android.com/reference/android/widget/RatingBar.OnRatingBarChangeListener#onRatingChanged(android.widget.RatingBar,%20float,%20boolean))([RatingBar](https://developer.android.com/reference/android/widget/RatingBar) ratingBar, float rating, boolean fromUser)
	- 通知評級已更改。
		- `ratingBar` `RatingBar`: 評級已更改的 RatingBar。
		- `rating` `float`: 當前評級。

---
```java
ratingBar.setOnRatingBarChangeListener(ratingBar.getOnRatingBarChangeListener());

// 實作onRatingChanged() 取得當前評級
ratingBar.setOnRatingBarChangeListener((ratBar, rating, fromUser) -> {  
    String text = rating + " star(s)";  
	Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();  
});
```