## 前言

Mybatis屬於半自動ORM，在使用Mybatis框架中，需要產生大量的Mapping映射文件，這時候我們可以利用官方提供的Mybatis-Generator來幫我們自動生成文件。

## 相關文件

[Mybatis官網](https://blog.mybatis.org/)
![img](https://i.imgur.com/XHwOEg7.png)

現在版本
MyBatis Generator Release 1.3.7

1.3.7版本以後 必須在Java 8+之後的版本才能運行Generator。

## Maven配置

```java
<dependency>
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator</artifactId>
    <version>1.3.7</version>
</dependency>
<dependency>
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator-maven-plugin</artifactId>
    <version>1.3.7</version>
</dependency>
```

如果IDE是使用Eclipse可下載plugin :
https://marketplace.eclipse.org/content/mybatis-generator

## generatorConfig配置

生成需要配置文件generatorConfig.xml :

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>
<!-- 指定連線資料庫時所需要的JDBC driver的檔案位置 -->
	<classPathEntry
		location="C:/Thinkpower/ojdbc6/ojdbc6.jar" />
	<context id="my" targetRuntime="MyBatis3">
    
		<commentGenerator>
			<property name="suppressDate" value="false" />
			<property name="suppressAllComments" value="true" />
		</commentGenerator>
        
<!-- 資料庫連線設定 -->
		<jdbcConnection
			driverClass="oracle.jdbc.driver.OracleDriver"
			connectionURL="jdbc:oracle:thin:@//172.20.10.1:1521/xe"
			userId="itp" password="1234" />
            
<!-- 要產生的model位置，targetProject的值為專案的Source folder，所以是gm/src/main/java -->
		<javaModelGenerator
			targetPackage="com.tsb.itp.vo"
			targetProject="gm/src/main/java">
			<property name="enableSubPackages" value="true" />
			<property name="trimStrings" value="true" />
		</javaModelGenerator>
        
<!-- 要產生的MyBatis Mapper位置 --> 
		<sqlMapGenerator targetPackage="mapper"
			targetProject="gm/src/main/java">
			<property name="enableSubPackages" value="true" />
		</sqlMapGenerator>
        
<!-- 要產生的MyBatis Dao位置 --> 
		<javaClientGenerator
			targetPackage="com.tsb.itp.dao"
			targetProject="gm/src/main/java" type="XMLMAPPER">
			<property name="enableSubPackages" value="true" />
		</javaClientGenerator>
		
        <!-- 要生成的資料表 -->
		<table schema="" tableName="SYS_CFG"
			domainObjectName="SysCfg" enableCountByExample="false"
			enableUpdateByExample="false" enableDeleteByExample="false"
			enableSelectByExample="false" selectByExampleQueryId="false">
		</table>

	</context>
</generatorConfiguration>
```

## 使用方式

Eclipse下載plugin後，直接在generatorConfig文件滑鼠右鍵，點選Run MyBatis Generator。

![img](https://i.imgur.com/JIquGQt.png)

生成文件如下 :
dao:
![img](https://i.imgur.com/TRmEMkV.png)

vo:
![img](https://i.imgur.com/vfEBX52.png)

mapper:
![img](https://i.imgur.com/mb1YJy6.png)

## 改用相關文件生成(封閉環境)

先下載相關的jar檔，
因為我使用的資料庫是Oracle11g，
所以我準備的是ojdbc6。
![img](https://i.imgur.com/cCmYL4c.png)

## generatorConfig配置(封閉環境)

生成需要配置文件generatorConfig.xml :

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>
<!-- 指定連線資料庫時所需要的JDBC driver的檔案位置 -->
	<classPathEntry
		location="C:/mybatis/ojdbc6-11.2.0.3.jar" />
	<context id="my" targetRuntime="MyBatis3">
    
		<commentGenerator>
			<property name="suppressDate" value="false" />
			<property name="suppressAllComments" value="true" />
		</commentGenerator>
        
<!-- 資料庫連線設定 -->
		<jdbcConnection
			driverClass="oracle.jdbc.driver.OracleDriver"
			connectionURL="jdbc:oracle:thin:@//172.20.10.1:1521/xe"
			userId="itp" password="1234" />
            
<!-- 要產生的model位置，targetProject的值為專案的Source folder，所以是gm/src/main/java -->
		<javaModelGenerator
			targetPackage="com.tsb.itp.vo"
			targetProject="C:/mybatis/test/">
			<property name="enableSubPackages" value="true" />
			<property name="trimStrings" value="true" />
		</javaModelGenerator>
        
<!-- 要產生的MyBatis Mapper位置 --> 
		<sqlMapGenerator targetPackage="mapper"
			targetProject="C:/mybatis/test/">
			<property name="enableSubPackages" value="true" />
		</sqlMapGenerator>
        
<!-- 要產生的MyBatis Dao位置 --> 
		<javaClientGenerator
			targetPackage="com.tsb.itp.dao"
			targetProject="gC:/mybatis/test/" type="XMLMAPPER">
			<property name="enableSubPackages" value="true" />
		</javaClientGenerator>
		
        <!-- 要生成的資料表 -->
		<table schema="" tableName="SYS_CFG"
			domainObjectName="SysCfg" enableCountByExample="false"
			enableUpdateByExample="false" enableDeleteByExample="false"
			enableSelectByExample="false" selectByExampleQueryId="false">
		</table>

	</context>
</generatorConfiguration>

```

## 執行的cmd指令

```java
java -jar mybatis-generator-core-1.3.7.jar -configfile generatorConfig.xml -overwrite 
```

生成文件如下 :
![img](https://i.imgur.com/3OhDhWd.png)

![img](https://i.imgur.com/qgPTypg.png)