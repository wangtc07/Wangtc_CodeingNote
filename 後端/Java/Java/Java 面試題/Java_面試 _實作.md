# Collection 
[[Java_面試#List Set Map]]
- 
	```java
	boolean	isEmpty()
	```
- 	
	```java
	boolean	add(E e)
	```
- 	
	```java
	int	size()
	```
		
	
# List 方法
- 
	```java
	E get(int index)
	```


# Set
- 沒有 `get()` 方法
- 取值
	- 
		```java
		Iterator iterator = set.Iterator();
		while(iterator.hashNext()){
			System.out.printIn(iterator.next());
		}
		```
	- 
		```java
		for(String s : set){
			System.out.pringIn(s);
		}
		```
# Map
- 
	```java
	V get(Object key)
	```

	
	

# Arrays 方法
- 
	```java
	static <T> List<T> asList(T... a) 
	```
