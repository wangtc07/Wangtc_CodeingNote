1. 引入redis起步依賴
	1. ![](https://i.imgur.com/Ifi9QFL.png)
2. 配置redis相關屬性
	1. ![](https://i.imgur.com/3KFyHXk.png)
3. 注入 `RedisTemplat` 模板
	```java
	@Autowired
	private RedisTemplate redisTemplate;
	```
	
4. 測試
	```java
	@Test
	void set() {
		redisTemplate.boundValueOps("name").set("mayu");
	}

	@Test
	void get() {
		Object name = redisTemplate.boundValueOps("name").get();
		System.out.println(name);
	}
	```