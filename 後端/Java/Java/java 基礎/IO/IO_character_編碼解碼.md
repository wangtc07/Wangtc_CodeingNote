# 字符串 編碼解碼
- 用什麼編碼方式，就要用同編碼解碼
```java
public class StringDemo {
	public static void main(String[] args) throws Exception {
		String s = "台灣";	// 預設utf-8
		
		byte[] bys = s.getBytes();
		System.out.println(Arrays.toString(bys));  // [-27, -113, -80, -25, -127, -93]
		
		// 指定編碼
		byte[] bys2 = s.getBytes("UTF-8");
		System.out.println(Arrays.toString(bys2)); // [-27, -113, -80, -25, -127, -93]

		byte[] bys3 = s.getBytes("GBK");
		System.out.println(Arrays.toString(bys3)); // [-52, -88, -98, -77]
		
		// 解碼
		String ss = new String(bys);
		System.out.println(ss);						// 台灣
		
		String ss2 = new String(bys2, "GBK");
		System.out.println(ss2);					// 鍙扮仯 bys2是utf-8
		
		String ss3 = new String(bys3 , "GBK");
		System.out.println(ss3);					// 台灣
	}
}
```