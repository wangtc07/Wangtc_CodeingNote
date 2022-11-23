### Mybatis

Entity 和 DB 欄位、屬性必須一致

必須有個可以調用的接口
`id` 方法
`resultType` 返回值類型

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.example.demo.repository.UserMapper">
    <select id="search" resultType="com.example.demo.entity.User">
        SELECT * FROM user WHERE id = #{id}
    </select>
</mapper>
```

#### mybatis generator

![截圖 2022-10-02 19.40.37](https://i.imgur.com/YCKQDrT.png)

```xml
<context id="context" targetRuntime="MyBatis3"></context>
<!-- 老版本 -->
```

![截圖 2022-10-02 19.42.53](/Users/tcwang/Desktop/截圖 2022-10-02 19.42.53.png)

`targetProject` 文件要放到哪個 project

`targetPackage` 文件要放到哪個 package

![截圖 2022-10-02 19.52.24](https://i.imgur.com/uoekIP8.png)

##### 生成表

`<cloumnOverride>` 欄位名重寫

![截圖 2022-10-02 19.50.32](https://i.imgur.com/hegceiT.png)













