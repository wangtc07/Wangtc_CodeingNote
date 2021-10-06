# CompoundButton
> 具有兩種狀態的按鈕，選中和未選中。當按鈕被按下或點擊時，狀態會自動改變。

## method
- [setOnCheckedChangeListener](https://developer.android.com/reference/android/widget/CompoundButton#setOnCheckedChangeListener(android.widget.CompoundButton.OnCheckedChangeListener))([CompoundButton.OnCheckedChangeListener](https://developer.android.com/reference/android/widget/CompoundButton.OnCheckedChangeListener) listener)
	- 當這個按鈕的選中狀態改變時調用。
# CompoundButton.OnCheckedChangeListener
## method
- 
	```java
	onCheckedChanged(CompoundButton buttonView, boolean isChecked)
	```
	- `buttonView`: The compound button view whose state has changed.
	- `isChecked`: buttonView 的新選中狀態。

# RadioGroup
## method
- [setOnCheckedChangeListener](https://developer.android.com/reference/android/widget/RadioGroup#setOnCheckedChangeListener(android.widget.RadioGroup.OnCheckedChangeListener))([RadioGroup.OnCheckedChangeListener](https://developer.android.com/reference/android/widget/RadioGroup.OnCheckedChangeListener) listener)

# RadioGroup.OnCheckedChangeListener
## method
- 
	```java
	onCheckedChanged(RadioGroup group, int checkedId)
	```
	- `group`: 選中的單選按鈕已更改的組
	- `checkedId`: 新選中的單選按鈕的唯一標識符


---
```java
private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handleViews();
    }

    private void handleViews() {
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        CheckBox checkBox = findViewById(R.id.checkBox);
        // API 14開始支援Switch，建議改用可以向前相容到API 7的SwitchCompat
        SwitchCompat aSwitch = findViewById(R.id.aSwitch);
        textView = findViewById(R.id.textView);

        // RadioGroup註冊OnCheckedChangeListener監聽器
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            /* 當RadioGroup內的RadioButton選項改變時會呼叫onCheckedChanged()，
               並傳遞被選取RadioButton的ID（checkedId），
               RadioGroup可以呼叫findViewById()取得該元件 */
            RadioButton radioButton = group.findViewById(checkedId);
            textView.setText(radioButton.getText());
            if (checkedId == R.id.rbFemale) {
                textView.setTextColor(Color.RED);
            } else {
                textView.setTextColor(Color.BLUE);
            }
        });

        /* 當checkBox或Switch選項改變時會呼叫onCheckedChanged()，
           並傳遞是否被選取（isChecked）資訊。
           注意：此監聽器為CompoundButton的OnCheckedChangeListener
           與RadioGroup的OnCheckedChangeListener不同 */
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener =
                (compoundButton, isChecked) -> {
            String text = compoundButton.getText().toString();
            if (isChecked) {
                text += " is checked";
            } else {
                text += " is unchecked";
            }
            textView.setText(text);
        };

        /* 註冊OnCheckedChangeListener監聽器 */
        checkBox.setOnCheckedChangeListener(onCheckedChangeListener);
        aSwitch.setOnCheckedChangeListener(onCheckedChangeListener);
    }
```