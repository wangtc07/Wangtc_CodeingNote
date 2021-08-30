# Spring 交易管理器
`PlatformTransactionManager`

 

# TransactionDefinition
[Spring的事務--TransactionDefinition](https://blog.csdn.net/huangjianghong6816/article/details/79579503)
- 交易的定義信息對象
	1. 交易隔離級別
	2. 交易傳播行為

# TransactionStatus
- 交易運行的狀態
![](https://i.imgur.com/gYOr5U1.png)


# 註解 交易控制
[Spring Boot的事務管理註解@EnableTransactionManagement的使用](https://blog.csdn.net/u010963948/article/details/79208328?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522162939125616780261928601%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=162939125616780261928601&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_v2~rank_v29-3-79208328.pc_search_result_cache&utm_term=%40EnableTransactionManagement&spm=1018.2226.3001.4187)

- `@EnableTransactionManagement`
	- 開啟基於註解的事務管理功能
		- 等同於以前xml配置 `<tx:annotation-driven/>`
	- SpringBoot 自動注入相對應 `PlatformTransactionManager` 實現類
	```java
	@Bean(name="transactionManager")
 	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
 		HibernateTransactionManager txManager = new HibernateTransactionManager();
 		txManager.setSessionFactory(sessionFactory);
 		return txManager;
 	}    
	```

- `@Transactional`
	- 在 service 類 or 方法上添加，開啟交易