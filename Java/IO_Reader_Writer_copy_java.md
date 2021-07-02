# copy .java
## Input,Output StreamWriter 
```java
public class StringDemo_Copy_Java {
	public static void main(String[] args) throws Exception {
		try(
			// 輸入流
			FileInputStream fis = new FileInputStream("Test.java");
			InputStreamReader isr = new InputStreamReader(fis);
			// 輸出流
			FileOutputStream fos = new FileOutputStream("Test_copy.java");
			OutputStreamWriter osr = new OutputStreamWriter(fos);
	
		){
			// 一次讀一個字元陣列  
			char[] crr = new char[8192];
			int len;
			while ((len = isr.read(crr)) != -1) {				//讀
				System.out.println(new String(crr ,0 , len));
				osr.write(crr,0,len);							//寫
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
```

## 使用FileReader FileWriter 簡化
```java
public class StringDemo_Copy_Java {
	public static void main(String[] args) throws Exception {
		try(
			// 輸入流
			FileReader fr = new FileReader("Test.java");		
			// 輸出流
			FileWriter fw = new FileWriter("Test_copy2.java");
		){
			// 一次讀一個字元陣列  
			char[] crr = new char[8192];
			int len;
			while ((len = fr.read(crr)) != -1) {				//讀
				System.out.println(new String(crr ,0 , len));
				fw.write(crr,0,len);							//寫
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
```

## 使用字符緩衝流
```java
public class StringDemo_Copy_Java3 {
	public static void main(String[] args) throws Exception {
		try(
			// 輸入流
			FileReader fr = new FileReader("Test.java");	
			BufferedReader br = new BufferedReader(fr);
			// 輸出流
			FileWriter fw = new FileWriter("Test_copy3.java");
			BufferedWriter bw = new BufferedWriter(fw);
		){
			// 一次讀一個字元陣列  
			char[] crr = new char[8192];
			int len;
			while ((len = br.read(crr)) != -1) {		//讀
				bw.write(crr,0,len);					//寫
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
```

## 使用Buffered特有功能
`readLine()`
`write(String str)`
`newLine()`

```java
public class StringDemo_Copy_Java3 {
	public static void main(String[] args) throws Exception {
		try(
			// 輸入流
			FileReader fr = new FileReader("Test.java");	
			BufferedReader br = new BufferedReader(fr);
			// 輸出流
			FileWriter fw = new FileWriter("Test_copy4.java");
			BufferedWriter bw = new BufferedWriter(fw);
		){
			// 一次讀一行數據
			String len;
			while ((len = br.readLine()) != null) {		//讀
				bw.write(len);
				bw.newLine();
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
```