[Java SE 入門教學 - IO 流](https://ethan-imagination.blogspot.com/2018/12/javase-gettingstarted-019.html)

# InputStream
## FileInputStream
從文件系統中的文件獲取輸入位元資料
#### method
- 
	```java
	int read()
	```
- 
	```java
	int	read(byte[] b)
	```

### BufferedInputStream
創建內部緩沖區陣列。當讀取或跳過來自流的位元組時，內部緩沖區根據需要從包含的輸入流中重新填充，一次多個位元組。





---
## ObjectInputStream
[[IO_序列化]]
# OutputStream
## FileOutputStream
用於將數據寫入`File`
`FileOutputStream (String name)` 創建文件輸出流，以指定的名稱寫入文件
- 做了三件事
	1. 調用系統功能，創建文件
	2. 創建輸出流對象
	3. 讓輸出流對象指向創建好的文件
#### construct
- 
	```java
	FileOutputStream (String name)
	```
	name不等於null的話 -> new File(name)
	- 
		```java
		FileOutputStream fos = new FileOutputStream("fos.txt");
		```
- 
	```java
	FileOutputStream(String name, boolean append)
	```
	- `append`如果是`true`，那麼位元組將被==寫入文件的末尾==而不是開頭

- 
	```java
	FileOutputStream (File file)
	```
	- 
		```java
		File file = new File("fos.txt");
		FileOutputStream fos2 = new FileOutputStream(file);
		```

#### method
- 
	```java
	void write(int b)
	```
	- 將指定的位元組此文件輸出流
		- 
			```java
			fos.write(97);  // 得到 -> a
			```
- 
	```java
	void write(byte[] b)
	```
	- 將指定位元陣列中的b.length個位元組寫入此文件輸出流
		- 
			```java
			byte[] bys = "abcde".getBytes();
			fos.write(bys);
			```


---
### BufferedOutputStream
> 緩衝流==僅提供緩衝區==，真正讀寫數據得依靠基本節點流進行操做

緩沖輸出流。應用程序可以將位元組寫入基礎輸出流，而不必為寫入的每個位元組調用底層系統。
一次讀寫`[int b]`位元資料
#### construct
- 
	```java
	BufferedInputStream​(InputStream in)	
	```



---
### DataOutputStream
#### method
- `void writeInt (int v)`
	- 將int寫入基礎輸出流，為四個位元組，高位元組優先。

允許應用程序以可移植的方式將原始Java數據類型寫入輸出流



---
## ObjectOutputStream
[[IO_序列化]]

# Reader
用於讀取字符流的抽象類。
[[IO_character_編碼解碼]]

---
## InputStreamReader
#### method
- 
	```java
	int read()
	```
- 
	```java
	int	read(char[] cbuf)
	```


### FileReader
使用默認緩沖區大小從字符文件中讀取文本。
 -   [java.io.InputStreamReader](https://www.apiref.com/java11-zh/java.base/java/io/InputStreamReader.html "class in java.io")
     -   java.io.FileReader
- constructor
	- 
		```
		FileReader(File file)	
		```



## BufferedReader
從字符輸入流中讀取文本，緩沖字符，以便有效地讀取字符，陣列和行。

#### method
- 
	```java
	String	readLine()	//讀一行文字。 不包含換行符
	```

# Writer
## OutputStreamWriter
從字符流到字節(位元組)流的橋接器
[[IO_OutputStreamWriter_5Way_Demo]]

---
### FileWriter
使用默認緩沖區大小將文本寫入字符文件。

## BufferedWriter
將文本寫入字符輸出流，緩沖字符，以便有效地寫入單個字符，陣列和字符串。
#### method
- 
	```java
	void	newLine()	//寫一個行分隔符。
	```

## PrintWriter
#### method
- 
	```java
	void println()  // 可寫各式型態
	```


---
# example
## Input Output
[[IO_copy_txt]]
[[IO_Buffered_Input_Output_Demo]]
[[IO_複製文件夾]]

## Reader Writer
[[IO_Reader_Writer_copy_java]]
[[IO_Buffered_Reader_Writer_Demo]]
[[IO_Buffered_Line]]
[[IO_ArrayList to txt]]