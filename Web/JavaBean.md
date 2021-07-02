## JavaBean
[JSP JavaBean | 菜鳥教程](https://www.runoob.com/jsp/jsp-javabean.html)

## apache BeanUtils
![](https://i.imgur.com/XhWygOL.png)


![](https://i.imgur.com/sFvcS0b.png)


![](https://i.imgur.com/jQsX71R.png)
#### method
- [setProperty](https://commons.apache.org/proper/commons-beanutils/apidocs/org/apache/commons/beanutils/BeanUtils.html#setProperty-java.lang.Object-java.lang.String-java.lang.Object-)([Object](https://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Object.html?is-external=true "class or interface in java.lang") bean, [String](https://docs.oracle.com/javase/1.5.0/docs/api/java/lang/String.html?is-external=true "class or interface in java.lang") name, [Object](https://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Object.html?is-external=true "class or interface in java.lang") value)
- [getProperty](https://commons.apache.org/proper/commons-beanutils/apidocs/org/apache/commons/beanutils/BeanUtils.html#getProperty-java.lang.Object-java.lang.String-)([Object](https://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Object.html?is-external=true "class or interface in java.lang") bean, [String](https://docs.oracle.com/javase/1.5.0/docs/api/java/lang/String.html?is-external=true "class or interface in java.lang") name)
- [populate](https://commons.apache.org/proper/commons-beanutils/apidocs/org/apache/commons/beanutils/BeanUtils.html#populate-java.lang.Object-java.util.Map-)([Object](https://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Object.html?is-external=true "class or interface in java.lang") bean, [Map](https://docs.oracle.com/javase/1.5.0/docs/api/java/util/Map.html?is-external=true "class or interface in java.util")<[String](https://docs.oracle.com/javase/1.5.0/docs/api/java/lang/String.html?is-external=true "class or interface in java.lang"),? extends [Object](https://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Object.html?is-external=true "class or interface in java.lang")\> properties)
	- 將 map 集合的鍵值對應信息，封裝到對應的 JavaBean 對象中