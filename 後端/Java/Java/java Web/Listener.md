# Listende

- 概念：web 的三大組件之一。

  - 事件監聽機制
    - 事件 ：一件事情
    - 事件源 ：事件發生的地方
    - 監聽器 ：一個對象
    - 注冊監聽：將事件、事件源、監聽器綁定在一起。 當事件源上發生某個事件後，執行監聽器代碼

- ServletContextListener:監聽 ServletContext 對象的創建和銷毀

  - 方法：
    - ```java
      void contextDestroyed(ServletContextEvent sce)
      ```
      - ServletContext 對象被**銷毀之前會調用該方法**
      - server 銷毀時調用
    - ```java
      void contextInitialized(ServletContextEvent sce)
      ```
      - ServletContext 對象**創建後會調用該方法**
      - server 創建時調用
  - 步驟：

    1. 定義一個類，實現 `ServletContextListener` 接口
    2. 複寫方法
    3. 配置

       1. web.xml

          - ```html
            <listener>
              <listener-class> Lintener類的位置 </listener-class>
            </listener>
            ```

          * 指定初始化參數`<context-param>`

       2. 註解：
          - `@WebListener`
