# 測試步驟

1. `@RunWith`
	- 參數 `SpringJUnit4ClassRunner.class`
2. `@ContextConfiguration`
	- 導入配置文件
		- xml
		- Config 類別

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AnnoTest {

}
```

# 在Spring Boot測試
1. `@SpringBootTest`
	- 將SpringBoot主類中導入的bean全都包含進來。