# 概述

- Hibernate 是一個持久層的 **ORM** 框架

## ORM

- 對象關系映射
	- 將 java 中的對象，與關係數據庫中的表建立映射關係。
	而操作對象就可以操作數據庫中的表
	
# Hibernate對象狀態
![Hibernate Lifecycle - GeeksforGeeks](https://media.geeksforgeeks.org/wp-content/uploads/20210626212614/GFGHibernateLifecycle.png)
- 瞬時 Transient 
	- 對象通過new語句創建到被持久化之前的狀態，此時對象不在Session的緩存中。
		- 不在Session緩存中，不與任何Session實例相關聯。
		- 在數據庫中沒有與之對應的記錄。
- 持久 Persistent
- 脫管 Detached
	- 是指從持久化對象的Session對象被銷毀到該對象消失之前的狀態，此時對象不在Session的緩存中。
		- 不在Session緩存中，不與任何Session實例相關聯。
		- 在數據庫中有與之對應的記錄（前提是沒有其他Session實例刪除該條記錄）
- 刪除 Removed