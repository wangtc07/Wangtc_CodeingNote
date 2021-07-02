# Buffered IO
```java
public class BufferedDemo {
	public static void main(String[] args) {
		try (
			FileInputStream fis = new FileInputStream("copy.txt");
			BufferedInputStream bis = new BufferedInputStream(fis);
				
			FileOutputStream fos = new FileOutputStream("copy_01.txt");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
		){

			// 寫數據
			bos.write("hello\n".getBytes());
			bos.write("world\n".getBytes());
			
			// 讀數據，一次讀取多個位元組
			byte[] b = new byte[1024];
			int len;
			while ((len = bis.read(b)) != -1) {
				System.out.println(new String(b, 0, len));
			}
			
			System.out.println("done");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
```

# 複製影片
四種方式
afds
1. 一次讀寫一位元組 time: 15007
2. 一次讀寫多個位元組  time: 30
3. buffered 一次讀寫一個位元組 time: 701
4. buffered 一次讀寫多個位元組 time: 19

```java
public class BufferedDemo_Movie {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
//		method1();  // time: 15007
//		method2();  // time: 30
//		method3();	// time: 701
		method4();	// time: 19
	
		long end = System.currentTimeMillis();
		System.out.println("time: " + (end - start));

	}
	
	// 一次讀寫一位元組 time: 15007
	public static void method1() {
		try (
			FileInputStream fis = new FileInputStream("210601 with7月号.mp4");				
			FileOutputStream fos = new FileOutputStream("210601 with7月号_copy1.mp4");
		){
			int len;
			while ((len = fis.read()) != -1) {
				fos.write(len);
			}
			
			System.out.println("done");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	// 一次讀寫多個位元組  time: 30
	public static void method2() {
		try (
			FileInputStream fis = new FileInputStream("210601 with7月号.mp4");				
			FileOutputStream fos = new FileOutputStream("210601 with7月号_copy2.mp4");
				
		){
			byte[] b = new byte[8192];
			int len;
			while ((len = fis.read(b)) != -1) {
				fos.write(b, 0 , len);
			}
			
			System.out.println("done");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	// buffered 一次讀寫一個位元組
	public static void method3() {
		try (
			FileInputStream fis = new FileInputStream("210601 with7月号.mp4");				
			FileOutputStream fos = new FileOutputStream("210601 with7月号_copy3.mp4");
				
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
		){
			int len;
			while ((len = bis.read()) != -1) {
				bos.write(len);
			}
			
			System.out.println("done");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	// buffered 一次讀寫多個位元組
	public static void method4() {
		try (
			FileInputStream fis = new FileInputStream("210601 with7月号.mp4");				
			FileOutputStream fos = new FileOutputStream("210601 with7月号_copy4.mp4");
				
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
		){
			byte[] b = new byte[8192];
			int len;
			while ((len = bis.read(b)) != -1) {
				bos.write(b, 0, len);
			}
			
			System.out.println("done");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
```