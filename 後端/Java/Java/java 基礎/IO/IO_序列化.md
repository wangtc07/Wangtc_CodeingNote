- 通過`ObjectOutputStream`將Java原始文件序列化
- 使用`ObjectInputStream`讀取(重構)對象
- 要被序列化的文件中的`class`需要實現`Serializable`接口，此接口沒有需要被重寫的方法，僅作為標示用

## 序列化
```java
public class ObjectOutputStreamDemo {
    public static void main(String[] args) {

        Student s = new Student("001", "wang" , 5 , "taipei");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("oos.java"))) {
            oos.writeObject(s);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## 反序列化
```java
public class ObjectInputStreamDemo {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("oos.java"))) {
            Object obj = ois.readObject();

            Student s = (Student) obj;
            System.out.println(s.getId());
            System.out.println(s.getName());
            System.out.println(s.getAge());
            System.out.println(s.getAddress());

        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

`transient`關鍵字，使變數不參與反序列化