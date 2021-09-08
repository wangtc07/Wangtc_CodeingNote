# ArrayList to txt
```java
public class ArrayLise2Txt {
	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<String>();
		
		array.add("wang");
		array.add("mayu");
		array.add("kakki");
		array.add("sera");
		
		try(
			FileWriter fw = new FileWriter("array.txt");
			BufferedWriter bw = new BufferedWriter(fw);
		) {
			for (String string : array) {
				bw.write(string);
				bw.newLine();
			}
			
			System.out.println("don");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```

# txt to ArrayList
```java
public class ArrayLise2Txt_inver {
	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<String>();
		
		try(
			FileReader fr = new FileReader("array.txt");
			BufferedReader br = new BufferedReader(fr);
		) {
			String str ;
			while ((str = br.readLine()) != null) {
				array.add(str);
			}
			
			for (String s : array) {
				System.out.println(s);
			}
			
			System.out.println("don");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
```

# 亂數點名
文件讀到ArrayList中，在隨機挑一個點名
```java
public class ArrayLise2Txt_inver_rollCall {
	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<String>();
		
		try(
			FileReader fr = new FileReader("copy_01.txt");
			BufferedReader br = new BufferedReader(fr);
		) {
			String str ;
			while ((str = br.readLine()) != null) {
				array.add(str);
			}		
			System.out.println("don");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Random r = new Random();
		int index = r.nextInt(array.size());
		
		String name = array.get(index);
		System.out.println("random name: " + name);
	}
}
```

---
# 類別數據 to .txt
```java
public class ArrayListToTxt {
	public static void main(String[] args) {
		ArrayList<Student> array = new ArrayList<>();
		Student s1 = new Student("aa001", "wang", 5, "taiwan");
		Student s2 = new Student("aa002", "mayu", 21, "japain");
		Student s3 = new Student("aa003", "kakki", 19, "japain");
		Student s4 = new Student("aa004", "sera", 20, "japain");
		array.add(s1);array.add(s2);array.add(s3);array.add(s4);

		try(
				FileWriter fw = new FileWriter("ArrayListToTxt.txt");
				BufferedWriter bw = new BufferedWriter(fw);
		){
			for (Student s : array) {
				StringBuffer  sb = new StringBuffer();  //拼接
				sb.append(s.getId()).append(",").append(s.getName()).append(",").append(s.getAge()).append(",").append(s.getAddress());
				bw.write(sb.toString());
				bw.newLine();
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```

# .txt to 類別集合
```java
public class ArrayListToTxt_inver {
	public static void main(String[] args) {
		ArrayList<Student> array = new ArrayList<>();
		
		try(
				FileReader fr = new FileReader("ArrayListToTxt.txt");
				BufferedReader br = new BufferedReader(fr);
		){
			String line;
			while ((line = br.readLine()) != null) {
				String[] split = line.split(",");
				Student s = new Student();
				s.setId(split[0]);
				s.setName(split[1]);
				s.setAge(Integer.parseInt(split[2]));
				s.setAddress(split[3]);
				
				array.add(s);
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (Student student : array) {
			System.out.println(student);
		}
		
	}
}
```