1. 建立ConstraintLayout，並在其內建立 
	1. 1個FrameLayout、
	2. 1個LinearLayout、
	3. 4個ImageView與1個Button
2. 點擊ImageView會讓圖片消失 點擊Reset按鈕回復圖片

```java
public class MainActivity extends AppCompatActivity {
    private List<View> views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        views = new ArrayList<>();
        handleViews();
    }

    private void handleViews() {
        // 獲取所有物件
        ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6;
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        Button btReset = findViewById(R.id.btReset);

        View.OnClickListener listener1 = view -> {
            // View設定為INVISIBLE會隱藏但佔空間
            view.setVisibility(View.INVISIBLE);
            // 將隱藏的View加入到views內
            views.add(view);
        };

        View.OnClickListener listener2 = view -> {
            // View設定為GONE會隱藏但不佔空間
            view.setVisibility(View.GONE);
            // 將隱藏的View加入到views內
            views.add(view);
        };

        // FrameLayout內的3個ImageView註冊相同監聽器
        imageView1.setOnClickListener(listener1);
        imageView2.setOnClickListener(listener1);
        imageView3.setOnClickListener(listener1);

        // LinearLayout內的3個ImageView註冊相同監聽器
        imageView4.setOnClickListener(listener2);
        imageView5.setOnClickListener(listener2);
        imageView6.setOnClickListener(listener2);

        btReset.setOnClickListener(view -> {
            // 將加入views內的ImageView還原成顯示狀態(VISIBLE)
            if (views.size() > 0) {
                // 迴圈將每個 imageView 顯示
                for (View v : views) {
                    v.setVisibility(View.VISIBLE);
                }
                views.clear();
            }
        });
    }

}
```

![](https://i.imgur.com/6l7lvig.png)
