get auto increment key 取得主鍵

```java
public void save(Entity entity) {
	entityMapper.insert(entity);
  Integer id = entity.getId();
}
```

