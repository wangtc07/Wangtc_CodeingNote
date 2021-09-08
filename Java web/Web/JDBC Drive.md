
- 載入一個實作[java.sql.Driver](https://www.apiref.com/java11-zh/java.sql/java/sql/Driver.html) 介面的類別
	- 此類別位於由資料庫廠商/驅動程式廠商提供的jar檔內
---
- JVM必須知道驅動程式的所在位置
	- Eclipse提拱相關設定，解決此問題
			Maven專案會自動通知JVM有關JDBC類別所在的位置
		- 在pom.xml檔加上相關敘述
			[Maven Repository: mysql » mysql-connector-java](https://mvnrepository.com/artifact/mysql/mysql-connector-java)
			```maven
			<dependency>
				<groupId>mysql</groupId>
					<artifactId>mysql-connector-java</artifactId>
				<version>8.0.23</version>
			</dependency> 
			```