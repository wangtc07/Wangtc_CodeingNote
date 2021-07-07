# 新建 Maven 的 Web 專案
[建立新 Maven 專案 | Code101](https://code101.app/docs/NewMaven)
1.  左邊 Project Explorer 空白處點選右鍵 ==-> New -> Project -> Maven -> Maven Project -> Next==    
2.  打勾 Create a simple projects -> Next
    
3.  Group ID: com.sevletjsp -> Artifact Id(你要的專案名稱): jspExercise -> Version(不變) -> Packaging: war -> Finish
    
4.  建立專案後發現左邊視圖有剛剛我們建的 jspExercise 專案，目前有錯誤是正常的，這時請找到專案的 pom.xml 檔案右鍵 -> Open with -> Maven POM Editor
    
5.  請在中央視圖底下點選 Overview 標籤 -> Properties -> Create -> Name: maven.compiler.source -> Vaule: 1.8(or 11) -> OK -> 再一個 Create -> Name: maven.compiler.target -> Vaule: 1.8(or 11) -> OK ->存檔(Ctrl + S)
    
6.  這時可以看看底下標籤 pom.xml 多了
    
    ```xml
	pom.xml
    
    <properties>
    
    <maven.compiler.source>1.8</maven.compiler.source>
    
    <maven.compiler.target>1.8</maven.compiler.target>
    
    </properties>
    
    Copy
	```
    
7.  上面是我們剛才輸入進去的，當然直接從這邊手寫這段也可以。
    
8.  更新剛剛我們做的改動讓整個環境知道: 需要點選==專案右鍵 -> Maven -> Update Project==
    
9.  打勾 Force Update of Snapshops/ Releases
    
10.  右鍵選專案 -> Properties -> Project Facets -> Dynamic Web Module 右邊三角型 選 4.0 -> Java 1.8 -> Apply and Close
    
11.  右鍵選專案 -> Java EE Tools -> Generate Deployment Descriptor Stub
    
12.  看專案內 -> src -> main -> webapp -> WEB-INF -> web.xml -> 點兩下打開 -> 確認下方標籤在 Source
    
13.  看文件內拉到最右邊看版本會是 version ="2.5" 這不是我們要的，經過 facet 設定後應該要是 4.0
    
14.  因此，刪除整個 WEB-INF，再一次==右鍵選專案 -> Java EE Tools -> Generate Deployment Descriptor Stub== 👉 新增 `web.xml`
    
15.  看專案內 -> src -> main -> webapp -> WEB-INF -> web.xml -> 點兩下打開，應該就是 version= "4.0" 了
    
16.  設定完成。
    

## 測試執行
1.  打開 pom.xml 加入 Maven 的 Servlet、JSTL，可以從
    
    -   [https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api](https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api)
        
    -   [https://mvnrepository.com/artifact/jstl/jstl](https://mvnrepository.com/artifact/jstl/jstl)
        
        找到最多人使用版本，在 pom 內加入(加完後記得存檔，有外層`<dependencies>`就不用再寫一次，直接接續`<dependency>` 就好)
2.  在專案的 src -> main -> webapp -> 右鍵 new -> jsp file -> 命名 index.jsp -> 打一些字在 index.jsp -> 存檔
3.  index.jsp 右鍵 -> Run As -> Run on Server -> Next -> Finish
4.  成功會看到畫面。

# 新增會員
- 邏輯
	- 控制器: `Servlet` 👉 邏輯層: `Servise` 👉 數據訪問層: `MenberDao`

## Servlet
1. 判斷輸入資料
	1. 資料格式正確 👉 調用 `Servise` 新增會員到資料庫
		- ==跳轉==到 `InsertMemberSuccess.jsp` 頁面
			- 網址列產生改變，第二次請求 👉 ==資料需儲存在 `Session` 中==
	2. 資料格式錯誤 👉 ==轉發==回 `InsertMemberForm.jsp` 頁面
		- 網址列不產生改變，同次請求


## Servise
- 封裝 `MenberDao` 的方法


## Dao
- 數據庫基本==增刪改==操作


# 登入
## Servlet
1. 判斷是否有輸入資料
	1. 有資料 👉 調用 `Servise` 查詢輸入帳密是否正確
		- 傳入輸入的資料當作參數 `id` `password`
			1. 帳密==正確== 👉 
				1. 將資料存進 `Session` 中，用於==判斷是否登入過==
				1. ==跳轉==到 首頁
			2. 帳密==錯誤==
				1. ==轉發==回 登入頁
	2. 沒資料 👉 ==轉發==回 登入頁



## Servise
1. 判斷帳號是否正確
	1. 判斷帳號是否存在
		- 依帳號查詢資料庫 `select`
	2. 判斷==資料庫密碼==是否跟==輸入的密碼==的相同
		`bean.getPassword().equals(password)`
		- 判斷==從哪連到登入頁面==
			1. 如果 `Session` 中==沒有target物件==
				==跳轉==到 首頁
			2. ==有target物件==
				==跳轉==回 target紀錄的頁面
				- 
					```java
					response.sendRedirect(contextPath + target);
					```


## 需登入才能訪問的頁面
- 判斷是否登入過
	1. 判斷 `Session` 中是否有登入成功的資料
		- `${ empty LoginOk }` 
			1. 為空 👉 `ture` 
				1. 存入 `ServletPath` 到 `Session` 中，
					用於登入頁面的Servise 判斷從哪邊轉發過去
					```html
					<c:set var="target" 
					value="${pageContext.request.servletPath}" 
					scope="session" />
					```
				1. ==轉發== 登入頁面
			2. 不為空 👉 `false` 訪問頁面


# 顯示會員資料
