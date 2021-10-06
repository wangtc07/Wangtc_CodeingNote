# 創建 Statement 物件

必須**經由`Connection`物件所提供的方法**取得`java.sql.Statement`家族的物件，:

- construct
  - ```java
    Statement st = con.createStatement()
    //此方法不需要參數
    創建一個Statement對象，用於將SQL語句發送到數據庫。
    ```
  - ```java
    PreparedStatement psmt = con.prepareStatement(String sql)
    創建一個PreparedStatement對象，用於將參數化SQL語句發送到數據庫。
    ```
    - [Interface PreparedStatement](https://www.apiref.com/java11-zh/java.sql/java/sql/PreparedStatement.html)

---

# 執行 SQL 命令

- 執行**SELECT 命令**
  - 呼叫`Statement`介面的`executeQuery(String sql)`方法
  - 此方法**傳回 [[ResultSet]] 物件**，它封裝資料庫挑選出的記錄。
- 執行**其他 SQL 命令**

  - 呼叫`Statement`介面的`executeUpdate(String sql)`方法
  - 此方法**傳回 int**，表示受此 SQL 命令(insert into、update、delete from...)影響的記錄個數。
  - 執行 DDL 時，會傳回 0。

    > `PreparedStatement`物件
    > `executeQuery()` `executeUpdate()` 方法不能傳參數

---

# SQL 命令

- 可用問號`?`表示 SQL 命令要處理的資料
  - 索引從`1`開始
  - 使用`set資料型態(int no , value)`設定`?`的值
    > 所有`?`都必須有值，才能執行
