1. 寫一個字元
2. 寫一個字元陣列
3. 寫字元陣列的一部分
4. 寫字符串
5. 寫字符串一部分

```java
public class StringDemo2 {
	public static void main(String[] args) throws Exception {
		try(
			FileOutputStream fos = new FileOutputStream("copy_01.txt");
			OutputStreamWriter osw = new OutputStreamWriter(fos);
		){
			// 寫一個字元
			osw.write(97);
			osw.flush();   	// 刷新流
			osw.write(98);
			osw.write(99);	// 釋放資源時，會先自動刷新流
			
			// 寫一個字元陣列
			char[] crr = {'A' ,'B' ,'C'};
			osw.write(crr);
			
			// 寫字元陣列的一部分
			char[] crr2 = {'1' ,'2' ,'3' ,'4' ,'5'};
			osw.write(crr2, 0, crr2.length);			// 從0 到 crr2.length
			
			// 寫字符串
			osw.write("\n田村真佑");
			
			// 寫字符串一部分
			osw.write("\n3456789", 0, 5);				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
```