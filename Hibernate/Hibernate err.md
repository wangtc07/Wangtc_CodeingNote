- _org.hibernate.HibernateException: get is not valid without active transaction_
	- 使用 `Session.persist()` 時，要先開啟交易
		- `session.beginTransaction()`

---

1. _No CurrentSessionContext configured!_
	- 在 SessionFactory（會話工廠）啟動的時候，Hibernate 會根據配置創建相應的 `CurrentSessionContext`
	- 在 `getCurrentSession()` 被調用的時候，實際被執行的方法是 
		`CurrentSessionContext.currentSession()`
- 在 hibernate.cfg.xml 新增配置
	```xml
	（jdbc事務 本地事務：數據庫只有一個）
	<property name="hibernate.current_session_context_class">
		thread</property>
	
	（jta事務 全局事務：數據庫有多個）
	<property name="hibernate.current_session_context_class">
		jta</property> 
	```
	
---

- _HibernateException: Unable to make JDBC Connection _
	- Hibernate的配置文件中不能識別 "換行",所以url沒有得到正確的識別。
	- _url 寫成一行_

--- 

-  _CommandAcceptanceException: Error executing DDL_
	- 配置 SQL 方言
		```xml
		<property name="dialect">
			org.hibernate.dialect.MySQL5InnoDBDialect</property>
		```
		
		
--- 

- _org.hibernate.MappingException: Unknown entity？_
	- 沒有添加 `@Entity` 註解
	- hibernate.cfg.xml 沒有添加 `<mapping class=""/>` 映射