# 一次讀寫一個位元組
```java
public class File_Copy {
	public static void main(String[] args){
		try (
			FileInputStream fis = new FileInputStream("copy.txt");
			FileOutputStream fos = new FileOutputStream("copy_01.txt");
		) {

			int i;
			while ((i = fis.read()) != -1) {	//讀一次
				fos.write(i);					//寫一次
			}			
			
			System.out.println("done");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
```

---
# 一次讀寫多個位元組
```java
public class File_Copy {
	public static void main(String[] args){
		try (
			FileInputStream fis = new FileInputStream("Source.gif");
			FileOutputStream fos = new FileOutputStream("Target.gif");
		) {

			byte[] b = new byte[1024];
			int len;
			while ((len = fis.read(b)) != -1) {	//最多讀b.length長度的位元組
				fos.write(b);					//寫一次
			}		
			System.out.println("done");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
```
