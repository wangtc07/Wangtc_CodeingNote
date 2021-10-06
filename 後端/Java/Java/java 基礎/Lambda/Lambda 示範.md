# 示範
```java
public class LambdaDemo {
    public static void main(String[] args) {
        // 實現類的方式實現
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        // 匿名內部類改進
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("多線程程序啟動");
            }
        }).start();

        // Lambda改進
        new Thread(() -> {
            System.out.println("多線程程序啟動");
        }).start();
    }
}
```

# Demo1
```java

/**
 *   操作步驟
 * 定義一個接口(Eatable)，裡面定義一個抽象方法:void eat();
 * 定義一個測試類(EatableDemo)，在測試類中提供兩個方法
 * 一個方法是:useEatable(Eatable e)
 * 一個方法是主方法，在主方法中調用useEatable方法
 */
public class LambdaDemo {
    public static void main(String[] args) {
        Eatable e = new EatableImpl();
        uesEatable(e);

        uesEatable(new Eatable() {
            @Override
            public void eat() {
                System.out.println("inter class eat...");
            }
        });

        uesEatable(() -> System.out.println("eat..."));
    }

    private static void uesEatable(Eatable e){
        e.eat();
    }
}
```

```java
public interface Eatable {
    void eat();
}
```

```java
public class EatableImpl implements Eatable{
    @Override
    public void eat() {
        System.out.println("EatableImpl");
    }
}
```


# Demo2
```java
/**
 * 操作步驟
 * 定義一個接口(Flyable)，裡面定義一個抽象方法:void fly(String s);
 * 定義一個測試類(FlyableDemo)，在測試類中提供兩個方法
 * 一個方法是:useFlyable(Flyable f)
 * 一個方法是主方法，在主方法中調用useFlyable方法
 */
public class LambdaDemo {
    public static void main(String[] args) {
        // 匿名內部類
        useFlyable(new Flyable() {
            @Override
            public void fly(String s) {
                System.out.println(s);
                System.out.println("~~~");
            }
        });

        // Lambda
        useFlyable(s -> {
            System.out.println(s);
            System.out.println("~~~");
        });
    }


    private static  void  useFlyable(Flyable f){
        f.fly("useFlyable fly...");
    }
}
```

```java
public interface Flyable {
    void fly(String s);
}
```


# Demo3
```java
/**
 * 操作步驟
 * 定義一個接口(Addable)，裡面定義一個抽象方法:int add(int x,int y);
 * 定義一個測試類(AddableDemo)，在測試類中提供兩個方法
 * 一個方法是:useAddable(Addable a)
 * 一個方法是主方法，在主方法中調用useAddable方法
 */
public class LambdaDemo {
    public static void main(String[] args) {

        useAddable((int x, int y) -> {
            return x + y;
        });
    }

    private static void useAddable(Addable a) {
        int add = a.add(10, 5);
        System.out.println(add);
    }
}
```

```java
public interface Addable {
    int add(int x, int y);
}
```