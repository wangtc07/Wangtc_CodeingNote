Android---String資源文件中通過String.format()（動態改變）字符串資源的顯示內容  
例如：**小明**來自**煙台**年齡**18**歲性別**男**。其中，“小明”、“煙台”、“18”、“男”，均為可變的，就可以通過String.format()設置。  
代碼：  
string.xml中

```html
<string name="formatStr">%1$s:來自%2$s,年齡%3$d,性別%4$s.</string>
```

MainActivity.java

```java
TextView tx = (TextView)findViewById(R.id.tx);
String userName = "小明";
String userArea = "煙台";
int age = 18;
String userSex = "男";
String Str = getResources( ).getString( R.string.formatStr);
String ss = String.format( Str,userName, userArea, age, userSex );
tx.setText( ss );

```

結果：

  

image.png

#### **String.format()字符串常規類型格式化的兩種重載方式**

*   format(String format, Object… args) 新字符串使用本地語言環境，制定字符串格式和參數生成格式化的新字符串。
*   format(Locale locale, String format, Object… args) 使用指定的語言環境，制定字符串格式和參數生成格式化的字符串。

##### 上例包括字符類型和整數類型的格式化，下表為常用的類型例舉

| 轉換符 | 詳細說明 | 示例 |
| --- | --- | --- |
| %s | 字符串類型 | "簡書" |
| %c | 字符類型 | 'm' |
| %b | 布爾類型 | true |
| %d | 整數類型（十進制） | 88 |
| %x | 整數類型（十六進制） | FF |
| %o | 整數類型（八進制） | 77 |
| %f | 浮點類型 | 8.888 |
| %a | 十六進制浮點類型 | FF.35AE |
| %e | 指數類型 | 9.38e + 5 |
| %g | 通用浮點類型（f和e類型中較短的） | 不舉例（基本用不到） |
| %h | 散列碼 | 不舉例（基本用不到） |
| %% | 百分比類型 | %（%特殊字符%%才能顯示%） |
| %n | 換行符 | 不舉例（基本用不到） |
| %tx | 日期與時間類型（x代表不同的日期與時間轉換符） | 不舉例（基本用不到） |

##### 代碼示例

```java
//例子
        String str=null;
        str=String.format("Hi,%s", "小明");
        System.out.println(str);
        str=String.format("Hi,%s %s %s", "小明","是個","學生");
        System.out.println(str);
        System.out.printf("字母c的大寫是：%c %n", 'C');
        System.out.printf("布爾結果是：%b %n", "小明".equals("學生"));
        System.out.printf("100的一半是：%d %n", 100/2);
        System.out.printf("100的16進制數是：%x %n", 100);
        System.out.printf("100的8進制數是：%o %n", 100);
        System.out.printf("50元的書打8.5折扣是：%f 元%n", 50*0.85);
        System.out.printf("上面價格的16進制數是：%a %n", 50*0.85);
        System.out.printf("上面價格的指數表示：%e %n", 50*0.85);
        System.out.printf("上面價格的指數和浮點數結果的長度較短的是：%g %n", 50*0.85);
        System.out.printf("上面的折扣是%d%% %n", 85);
        System.out.printf("字母A的散列碼是：%h %n", 'A');

```

運行結果

  

image.png

##### 搭配轉換符可實現高級功能 第一個例子中有用到 $

| 轉換符 | 詳細說明 | 示例 | 結果 |
| --- | --- | --- | --- |
| + | 為正數或者負數添加符號 | (“%+d”,15) | +15 |
| 0 | 數字前面補0(加密常用) | (“%04d”, 99) | 0099 |
| 空格 | 在整數之前添加指定數量的空格 | (“% 4d”, 99) | 99 |
| , | 以“,”對數字分組(常用顯示金額) | (“%,f”, 9999.99) | 9,999.990000 |
| ( | 使用括號包含負數 | (“%(f”, -99.99) | (99.990000) |
| # | 如果是浮點數則包含小數點，如果是16進制或8進制則添加0x或0 | (“%#x”, 99) (“%#o”, 99) | 0x63 0143 |
| < | 格式化前一個轉換符所描述的參數 | (“%f和%<3.2f”, 99.45) | 99.450000和99.45 |
| |被格式化的參數索引| ("d,%2$s”, 99,”abc”) | 99,abc |  |  |

##### 日期轉換符

| 轉換符 | 詳細說明                    | 示例                            |
| ------ | --------------------------- | ------------------------------- |
| c      | 包括全部日期和時間信息      | 星期四 三月 1 14:21:20 CST 2007 |
| F      | “年-月-日”格式              | 2018-03-01                      |
| D      | “月/日/年”格式              | 03/01/18                        |
| r      | “HH:MM:SS PM”格式（12時制） | 02:25:51 下午                   |
| T      | “HH:MM:SS”格式（24時制）    | 14:28:16                        |
| R      | “HH:MM”格式（24時制）       | 14:28                           |

代碼示例：

```
   //例子
        Date date=new Date();
        //c的使用
        System.out.printf("全部日期和時間信息：%tc%n",date);
        //f的使用
        System.out.printf("年-月-日格式：%tF%n",date);
        //d的使用
        System.out.printf("月/日/年格式：%tD%n",date);
        //r的使用
        System.out.printf("HH:MM:SS PM格式（12時制）：%tr%n",date);
        //t的使用
        System.out.printf("HH:MM:SS格式（24時制）：%tT%n",date);
        //R的使用
        System.out.printf("HH:MM格式（24時制）：%tR",date);

```

運行結果：