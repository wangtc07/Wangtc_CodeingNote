一、什麼是example類

mybatis-generator會為每個欄位產生Criterion，為底層的mapper.xml建立動態sql。如果表的欄位比較多,產生的example類會十分龐大。理論上通過example類可以構造你想到的任何篩選條件。在mybatis-generator中加以組態，組態資料表的生成操作就可以自動生成example了。具體組態可以參考 [Mybatis-Generator的具體使用方法 - zorro的菜鳥筆記 - 部落格園](https://link.zhihu.com/?target=https%3A//www.cnblogs.com/zorro-y/p/5602471.html)。

下面是mybatis自動生成example的使用。

二、瞭解example成員變數

```java
 //作用：升序還是降序
 //參數格式：欄位+空格+asc(desc)
 protected String orderByClause;  
 //作用：去除重複
 //true是選擇不重複記錄，false，反之
 protected boolean distinct;
 //自訂查詢條件
 //Criteria的集合，集合中對像是由or連接
 protected List<Criteria> oredCriteria;
 //內部類Criteria包含一個Cretiron的集合，
 //每一個Criteria對象內包含的Cretiron之間是由  AND連接的
 public static class Criteria extends GeneratedCriteria {
  protected Criteria() {super();}
 }
 //是mybatis中逆向工程中的程式碼模型
 protected abstract static class GeneratedCriteria {......}
 //是最基本,最底層的Where條件，用於欄位級的篩選
 public static class Criterion {......}
```

三、example使用前的準備

比如我的example是根據user表生成的，UserMapper屬於dao層，UserMapper.xml是對應的對應檔案。

```java
UserMapper介面：
long countByExample(CompetingStoreExample example);
List<CompetingStore> selectByExample(CompetingStoreExample example);

在我們的測試類裡：
UserExample example = new UserExample();
UserExample.Criteria criteria = example.createCriteria();
```

四、查詢使用者數量

```java
 long count = UserMapper.countByExample(example);
```

類似於：select count(*) from user

五、where條件查詢或多條件查詢

```java
 example.setOrderByClause(“age asc"); //升序
 example.setDistinct(false); //不去重
 if(!StringUtils.isNotBlank(user.getName())){
 Criteria.andNameEqualTo(user.getName());
 }
 if(!StringUtils.isNotBlank(user.getSex())){
 Criteria.andSexEqualTo(user.getSex());
 }
 List<User> userList=userMapper.selectByExample(example);
```

類似於：select * from user where name={#user.name} and sex={#user.sex} order by age asc;

```java
 UserExample.Criteria criteria1 = example.createCriteria();
 UserExample.Criteria criteria2 = example.createCriteria();
 if(!StringUtils.isNotBlank(user.getName())){
 Criteria1.andNameEqualTo(user.getName());
 }
 if(!StringUtils.isNotBlank(user.getSex())){
 Criteria2.andSexEqualTo(user.getSex());
 }
 Example.or(criteria2);
 List<User> userList=userMapper.selectByExample(example);
```

類似於：select * from user where name={#user.name} or sex={#user.sex} ;

六、模糊查詢

```java
 if(!StringUtils.isNotBlank(user.getName())){
 criteria.andNameLIke(‘%’+name+’%’);
 }
 List<User> userList=userMapper.selectByExample(example);
```

類似於：select * from user where name like %{#user.name}%

七、分頁查詢

```java
 int start = (currentPage - 1) * rows;
 //分頁查詢中的一頁數量
 example.setPageSize(rows); 
 //開始查詢的位置
 example.setStartRow(start);  
 List<User> userList=userMapper.selectByExample(example);
```

類似於：select * from user limit start to rows