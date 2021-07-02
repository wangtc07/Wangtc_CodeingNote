# BufferedWriter newLine()
```java
public class StringDemo_Buffered_line2 {
	public static void main(String[] args) throws Exception {
		try(
			// 輸出流
			FileWriter fw = new FileWriter("copy_01.txt");
			BufferedWriter bw = new BufferedWriter(fw);
		){
			for (int i = 0; i < 10; i++) {
				bw.write("田村真佑" + i);
				bw.newLine();				// 換行
			}	
		} catch (IOException e) {
			e.printStackTrace();				
		}
	}
}
```

# BufferedReader readLine()
```java
public class StringDemo_Buffered_line {
	public static void main(String[] args) throws Exception {
		try(
			// 輸入流
			FileReader fr = new FileReader("copy_01.txt");	
			BufferedReader br = new BufferedReader(fr);
		){
			String line;
			while ((line = br.readLine()) != null) {
				System.out.print(line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();				
		}
	}
}
```