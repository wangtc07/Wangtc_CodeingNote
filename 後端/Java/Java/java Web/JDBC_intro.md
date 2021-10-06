![[JDBC編寫步驟.png]]

# JDBC 組成

> 跟資料庫有關的型態，**用包裝類別**

- JDBC API
  - 用以存取資料庫的類別與介面，定義在 java.sql, javax.sql 兩套件內
- JDBC Drive ^jdbcDrive

  - 資料庫廠商提供的一組類別(class)
    - [MySQL :: Download Connector/J](https://dev.mysql.com/downloads/connector/j/)
    - ![](https://i.imgur.com/f0XjoSi.png)

- java 與資料庫關聯
  - java Program
  - JDBC_API
    - [[JDBC Drive]]
    - [[Connection]]
    - [[Staement]]
    - [[ResultSet]]
  - ![[JDBC關係圖.png]]

---

# JDBC 存取資料庫步驟

1. 安裝 JDBC Drive
   [[JDBC Drive]]

1. 取得 `Connection` 對象
   [[Connection]]

   - 建立 Java 程式**與資料庫的連線**

1. 創建 `Statement` 物件
   [[Staement]]

1. 關閉 JDBC 物件
   - 按照產生物件的相反順序呼叫相關物件 的 close()方法。
   - 使用 Try-With-Resource 關閉資源
     在 try 區塊的小括弧內定義屬於`java.lang.AutoCloseable`家族的物件，
     - ```java
       try(
       	Connection con = DriverManager.getConnection(dbURL);
       ){}
       ```

---

### 交易控制

- 有時多個 SQL 命令必須視為一個不能被分割的整體，它們必須**同時成功地執行**，或者**同時不執行**。
  - 在 JDBC 程式中，多個表格的異動若要成為一個交易，必須由**同一個`java.sql.Connection`物件產生的`java.sql.Statement`家族物件**進行表格的異動才能成為一個交易。

#### 進行 JDBC 交易的步驟

1. `con.setAutoCommit(false);`
2. 進行資料庫資料的異動(新增、刪除、修改...)
3. 如果一切**正常**，執行`con.commit();`，
   - 包括企業邏輯(BusinessLogic)，
   - 資料存取邏輯(Data Access Logic)都沒有發生異常
4. 如果有**異常**，執行`con.rollback();`
5. `con.setAutoCommit(true);`

### 內儲程序(Stored Procedures)

內儲程序是一組可以完成特定功能的敘述，它儲存在資 料庫伺服器內，可供遠方的應用程式**多次呼叫**。

- 內儲程序可以定義有 0 或多個參數，參數又可分為 IN、 OUT、 INOUT 三種形式:
  - IN: 此種參數可將外界資料傳遞到內儲程序內
  - OUT: 此種參數為內儲程序的傳回值
  - INOUT:此種參數可同時傳資料到內儲程序，並能由內儲程序傳出資料。

#### 用 Java 程式新建內儲程序

- 先將新建內儲程序(Create Procedure)的程式 碼放入 Java 字串內
  - ```java
    String createProcedure = "create procedure SHOW_BookCompany as "
    + "select BookCompany.SUP_NAME, COFFEES.COF_NAME "
    + "from BookCompany, COFFEES where BookCompany.SUP_ID " + " = COFFEES.SUP_ID order by SUP_NAME";
    ```
- 利用`Statement物件`的`executeUpdate()`方法 將內儲程序的定義傳送到資料庫伺服器:
  - ```java
    stmt.executeUpdate(createProcedure);
    ```

#### 呼叫內儲程序

1. 產生 CallableStatement 物件
   ```java
   con.prepareCall("{ call myProc(?) }");
   ```
1. 設定 IN 參數的初值
1. 登記 OUT 參數的型態
1. 執行內儲程序
   ```java
   cs.execute();
   ```
1. 取回 OUT 參數的值

# JNDI

[[JNDI]]

# 數據庫連接池

[[數據庫連接池]]
