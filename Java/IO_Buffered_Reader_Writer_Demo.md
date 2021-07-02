# BufferedWriter_Demo
```java
public class StringDemo_Buffered {
	public static void main(String[] args) throws Exception {
		try(
			// 輸出流
			FileWriter fw = new FileWriter("BufferWriter.txt");
			BufferedWriter bw = new BufferedWriter(fw);
		){
			bw.write("wang");
			bw.write("\nまゆたん");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
```

# BufferedReader_Demo
```java
public class StringDemo_Buffered2 {
	public static void main(String[] args) throws Exception {
		try(
			// 輸入流
			FileReader fr = new FileReader("BufferWriter.txt");	
			BufferedReader br = new BufferedReader(fr);
		){

			int len;
			
			// 一次一個字元
			while ((len = br.read()) != -1) {
				System.out.print((char)len);
			}
			
			// 一次一個字元陣列
			char[] crr = new char[1024];
			while ((len = br.read(crr)) != -1) {
				System.out.println(new String(crr ,0 ,len));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
```

