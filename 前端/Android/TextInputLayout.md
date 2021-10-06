[Material Design Patterns 教學 (6) - EditText 的拍擋 - TextInputLayout](https://blog.30sparks.com/material-design-6-textinputlayout/)

---
這次我們改善輸入文字的元件顯示。

Android Design Support Library 提供一個 `TextInputLayout` 元件，可用來包著 `EditText`，令 `EditText` 得到 focus 時，自動將 hints 變成標題：

```html
<android.support.design.widget.TextInputLayout
        android:id="@+id/til_et_name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/content_view"
        >

    <EditText
            android:id="@+id/et_name"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Your name"
            />
</android.support.design.widget.TextInputLayout>

```

效果如下：

一個 `TextInputLayout` 只能容納一個 `EditText`，所以每個 `EditText` 都需要自訂各自的 `TextInputLayout`。

關於 Hint
-------

`TextInputLayout` 可直接使用 `EditText` 上的 hint，用來當成 header 。不過，你也可直接設定 hint 到 `TextInputLayout` 上，它們的效果也是相同的，值得留意的是，你可同時設定 hint 到 `TextInputLayout` 和 `EditText` 上。這樣的話，它們一開始會重叠，而當拿到 focus 時，在 `TextInputLayout` 上的 hint 會被拿來當 header ，而在 `EditText` 上的會跟以往一樣，有文字輸入後 hint 會消失。不過我想，在正常情況下應該不會這樣做吧？

> !\[Overlapping hint\](/content/images/2016/02/overlapping\_hint.jpg) 
  重叠的 Hint 


> !\[Focus overlapping hint\](/content/images/2016/02/overlapping\_hint\_focus.jpg) Focus 後，會有不同的 Hint/figcaption>

字數統計
----

可使用 `app:counterEnabled="true"` 和 `app:counterMaxLength` 可設定顯示輸入文字的長度。

錯誤訊息
----

`TextInputLayout` 還有另一好處，是可以顯示錯誤訊息。透過 `textInputLayout.setError("Erorr in name input")` 便在底部可顯示錯誤訊息。

例如為我們之前加的 `EditText` 加進驗証的的話，可以這樣做：

```java
final TextInputLayout nameLayout = (TextInputLayout)findViewById(R.id.til_et_name);
final EditText nameEditText = (EditText)findViewById(R.id.et_name);
final Button button = (Button) findViewById(R.id.btn_submit);

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(nameEditText.length() == 0){
            nameLayout.setError("Error in name input");
        }
        else{
            nameLayout.setError(null);
        }
    }
});

```

這樣當按 `button` 時，若 `nameEditText` 沒有文字的話，便會顯示 "Error in name input"。

不過有留意到顯示錯誤訊息時，整個 `messageEditText` 會被推下，因為當初 `TextInputLayout` 沒有預留空間去顯示錯誤訊息！想避免此情況，可以先設定

```java
nameLayout.setErrorEnabled(true);

```

或者在 layout xml 上加入`app:errorEnabled="true"`

```java
<android.support.design.widget.TextInputLayout
        android:id="@+id/til_et_name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/content_view"
        app:errorEnabled="true" >

```

這樣，`TextInputLayout` 便會預留空間去顯示錯誤訊息了。留意的是，你可用 `nameLayout. setErrorEnabled(false)` 的話，去消除錯誤訊息，但整個 layout 會被拉上去 (因錯誤訊息的位置也會被消除)。若不想 layout 移動的話，便應用 `nameLayout.setError(null)` 去消除。

Style 風格
--------

### 顏色

想簡單更改底線顏色的話，可到 `style.xml` 修改 `colorAccent`

```
<style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
    <!-- ...other style settings -->
    <item name="colorAccent">#0000FF</item>
</style>

```

### header

若只想改變 header 顏色 ，可使用 `app:hintTextAppearance="style"`。先到 `style.xml` 中加入 `TextInputHint`

```html
<style name="TextInputHint" parent="TextAppearance.AppCompat.Small">
    <item name="android:textStyle">italic</item>
    <item name="android:textColor">#AA2288</item>
</style>

```

然後加到 `TextInputLayout` 加入 `app:hintTextAppearance="@style/TextInputHint "`

```html
<android.support.design.widget.TextInputLayout
        android:id="@+id/til_et_name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:errorEnabled="true"
        app:hintTextAppearance ="@style/TextInputHint "
>

```

佷簡單便可修改 header 的風格了。

### 錯誤訊息

要更改錯誤訊息的顏色的話，跟改 header 顏色的方法差不多，這次使用的是 `app:errorTextAppearance`。

`style.xml`:

```html
<style name="TextInputError" parent="TextAppearance.AppCompat.Small">
    <item name="android:textStyle">bold|italic</item>
    <item name="android:textColor">#FF00FF</item>
</style>

```

layout:

```html
<android.support.design.widget.TextInputLayout
        android:id="@+id/til_et_name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:errorEnabled="true"
        app:errorTextAppearance="@style/TextInputError"
>

```

這樣便可以自訂錯誤訊息的風格了。

字數統計的文字也是透過 `app:counterOverflowTextAppearance` 和 `app:counterTextAppearance` 去修改。不再另述。