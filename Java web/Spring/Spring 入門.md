# 步驟

![](https://i.imgur.com/FFIRH1Z.png)

1. 導入 Spring 開發的基本包坐標
	```xml
	<dependency>
		<groupId>org.springframework</groupId> 
		<artifactId>spring-context</artifactId> 
		<version>${spring.version}</version>
	</dependency>
	```
2. 編寫 Dao 接口和實現類
3. 創建 Spring 核心配置文件
	- 在類路徑下(resources)創建applicationContext.xml配置文件
	```xml
	<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation=" http://www.springframework.org/schema/beans 
	http://www.springframework.org/schema/beans/spring-beans.xsd">
	</beans>
	```
	- 配置 beam
	```xml
	<bean id="userDao" class="com.itheima.dao.impl.UserDaoImpl"></bean>
	```
1. 在 Spring 配置文件中配置 UserDaoImpl 使用 Spring 的 API 獲得 Bean 實例
	```java
	ClassPathXmlApplicationContext app = new 	ClassPathXmlApplicationContext("applicationContext.xml");
	UserDao userDao1 = (UserDao) app.getBean("userDao");
	System.out.println(userDao1);
	app.close();
	```
	
---
# Spring 配置
## Beam 標籤
- `id` Bean實例在Spring容器中的唯一標識 
- `class` Bean的全限定名稱
- `scope` 對象的作用範圍
	- `singleton`
	- `prototype`
## 生命週期
- `init-method` 指定類中的_初始化_方法名稱 
- `destroy-method` 指定類中_銷毀_方法名稱

## Bean實例化三種方式
- 無參構造方法實例化 
- 工廠靜態方法實例化 
- 工廠實例方法實例化

---

# 依賴注入
![](https://i.imgur.com/z1xMEiI.png)
> 依賴注入(Dependency Injection):它是 Spring 框架核心 IOC 的具體實現。在編寫程序時，通過控制反轉，把對象的創建交給了 Spring，但是代碼中不可能出現沒有依賴的情況。
IOC 解耦只是降低他們的依賴關係，但不會消除。例如:業務層仍會調用持久層的方法。
那這種業務層和持久層的依賴關係，在使用 Spring 之後，就讓 Spring 來維護了。簡單的說，就是坐等框架把持久層對像傳入業務層，而不用我們自己去獲取。

## 注入方式
- 構造方法
	```java
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
	```
	- beam 配置 `constructor-arg`
	```xml
	<bean id="userService" class="com.itheima.service.impl.UserServiceImpl">
		<constructor-arg name="userDao" ref="userDao"></constructor-arg>
	</bean>
	```
- set方法
	```java
	public class UserServiceImpl implements UserService {
		private UserDao userDao;
		public void setUserDao(UserDao userDao) {
			this.userDao = userDao; 
		}
	}
	```
	- beam 配置 `<property>` 
		`name` 
		`ref` 注入的Beam id
```xml
<bean id="userService" class="com.itheima.service.impl.UserServiceImpl">
    <property name="userDao" ref="userDao"></property>
</bean>
```