# Proxy
[Proxy](https://www.apiref.com/java11-zh/java.base/java/lang/reflect/Proxy.html)
[InvocationHandler](https://www.apiref.com/java11-zh/java.base/java/lang/reflect/InvocationHandler.html)

* 概念：
	1. 真實對象：被代理的對象
	2. 代理對象：
	3. 代理模式：代理對象代理真實對象，達到增強真實對象功能的目的
* 實現方式：
	1. 靜態代理：有一個類文件描述代理模式
	2. 動態代理：在內存中形成代理類
		* 實現步驟：
			1. 代理對象和真實對象實現相同的接口
			2. 代理對象 = Proxy.newProxyInstance();
			3. 使用代理對象調用方法。
			4. 增強方法

		* 增強方式：
			1. 增強參數列表
			2. 增強返回值類型
			3. 增強方法體執行邏輯	

## method
- 
	```java
	public static Object newProxyInstance(ClassLoader loader, 
					類<?>[] interfaces, InvocationHandler h)
	```
	- 代理對象調用的==所有方法==都會觸發該方法執行
	- 三個參數：
		1. 類加載器：真實對象.getClass().getClassLoader()
		2. 接口數組：真實對象.getClass().getInterfaces()
		3. 處理器：new InvocationHandler()
# InvocationHandler
## method
- 
	```java
	InvocationHandler()
	```
	- 參數：
		1. proxy:代理對象
		2. method：代理對象調用的方法，被封裝為的對象
		3. args:代理對象調用的方法時，傳遞的實際參數

---
# 代理類
```java
public class ProxyTest {

    public static void main(String[] args) {
        //1.創建真實對象
        Lenovo lenovo = new Lenovo();
        
        //2.動態代理增強lenovo對象
        /*
            三個參數：
                1. 類加載器：真實對象.getClass().getClassLoader()
                2. 接口數組：真實對象.getClass().getInterfaces()
                3. 處理器：new InvocationHandler()
         */
        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(),
                lenovo.getClass().getInterfaces(), new InvocationHandler() {

            /*
                代理邏輯編寫的方法：代理對象調用的所有方法都會觸發該方法執行
                    參數：
                        1. proxy:代理對象
                        2. method：代理對象調用的方法，被封裝為的對象
                        3. args:代理對象調用的方法時，傳遞的實際參數
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /*System.out.println("該方法執行了....");
                System.out.println(method.getName());
                System.out.println(args[0]);
*/
                //判斷是否是sale方法
                if(method.getName().equals("sale")){
                    //1.增強參數
                    double money = (double) args[0];
                    money = money * 0.85;
                    System.out.println("專車接你....");
                    //使用真實對象調用該方法
                    String obj = (String) method.invoke(lenovo, money);
                    System.out.println("免費送貨...");
                    //2.增強返回值
                    return obj+"_鼠標墊";
                }else{
                    Object obj = method.invoke(lenovo, args);
                    return obj;
                }
            }
        });

        //3.調用方法
		//改用代理後的對象調用方法

       /* String computer = proxy_lenovo.sale(8000);
        System.out.println(computer);*/

        proxy_lenovo.show();
    }
}
```