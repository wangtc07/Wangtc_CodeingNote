# Spring
- 輕量級、開源、J2EE框架
- 中間層框架，可整合第三方框架
- 控制反轉 IOC 、面向切片 AOP 容器框架，用來裝javabean

# AOP
[[Spring Aop]]
- 面向切面: 不修改源代碼，進行功能增強

# IOC
- 控制反轉: 把創建對象的過程交給Spring進行管理

# 實現IOC容器
- 配置需要掃描包的路徑
- 定義spring bean
- 把要掃描包的 `.class` 文件儲存在 `Set` 集合中
- 遍歷 `Set` 獲取有定義 baen 的類別，交給 IOC 容器(用 `Map` 儲存)
- 再遍歷 IOC 容器，判斷裡面是否有依賴其他的類，進行遞迴注入

# BeanFactory ApplicatonContext
- `ApplicatonContext` 是 `BeanFactory` 的子接口
- `ApplicatonContext` 提供更完整的功能
	- 繼承 `MessageSource` ，支持國際化
	- 統一的資源訪問方式
	- 提供在監聽器中註冊 bean
	- 同時載入多個配置文件
	- 載入多個上下文，使每個上下文都專注於特定層次，如web層
- `BeanFactory`
	- 懶加載，在實際調用 `getBaen()` 時，才對 bean 實例化
- `ApplicatonContext`
	- 容器創建時，一次創建所有的 bean

# Spring Bean 生命週期


# Bean 作用域
- 單例
	- 每個容器中只有一個 bean 實例
- prototype
	- 每一個 bean 請求都會提供一個實例，每次注入時都會創建一個新的對象
- request
	- 每個 http 請求提供一個實例，單次請求中，會復用
- session
	- 每個 session 提供一個實例，session過期後 bean 失效
- applicaton
	- servletContext 生命週期中復用一個單例對象
- websocket
	- websocket 生命週期中復用一個單例對象
- globe-session

# 單例bean線程是安全的嗎
[單例bean線程是安全的嗎](https://www.bilibili.com/video/BV1Eb4y1R7zd?p=39&spm_id_from=pageDriver)
- 不是線程安全

# Spring 用到哪些設計模式
- 簡單工廠
	- 根據傳入的參數，動態決定該創建哪一個類
- 工廠方法
- 單例模式
	- 保證一個類只有一個實例
- 適配器模式
- 裝飾器模式
- 動態代理
- 觀察者模式
- 策略模式

# Spring 交易
- 編程式
- 聲明式
	- `@Transactional`