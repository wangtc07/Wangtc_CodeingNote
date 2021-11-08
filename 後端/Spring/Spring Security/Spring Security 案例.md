
[【系统权限管理】SpringSecurity实现动态权限菜单控制_编程小马-CSDN博客_springsecurity动态权限管理](https://blog.csdn.net/qq_40205116/article/details/103739978?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522162999282316780269815308%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=162999282316780269815308&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_v2~rank_v29-2-103739978.pc_search_result_cache&utm_term=spring+security%E6%9D%83%E9%99%90%E7%AE%A1%E7%90%86&spm=1018.2226.3001.4187)

[spring security——基本介绍（一）_随笔记-CSDN博客](https://blog.csdn.net/qq_22172133/article/details/86503223?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522162999210216780265479434%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=162999210216780265479434&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_v2~rank_v29-1-86503223.pc_search_result_cache&utm_term=spring+security&spm=1018.2226.3001.4187)

[spring security四種實現方式_不學習就淘汰-CSDN博客_attemptauthentication](https://blog.csdn.net/bao19901210/article/details/52574340?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-11.essearch_pc_relevant&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-11.essearch_pc_relevant)

---
---
---
---

# Spring Security + 數據庫
- [（五）Spring Security基于数据库的权限授权_惜阳-CSDN博客_springsecurity数据库授权](https://blog.csdn.net/YCJ_xiyang/article/details/95317813?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522163007855316780366523825%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=163007855316780366523825&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~baidu_landing_v2~default-1-95317813.first_rank_v2_pc_rank_v29&utm_term=spring+security+Authority+%E6%95%B0%E6%8D%AE%E5%BA%93&spm=1018.2226.3001.4187)

- [Spring Boot + Spring Security with JPA authentication and MySQL from scratch ](https://www.youtube.com/watch?v=TNt3GHuayXs)
	- 連接MySQL
	- 判斷權限

# 檢查用戶是否在 Java 中具有角色
- [Spring Security: Check If a User Has a Role in Java | Baeldung](https://www.baeldung.com/spring-security-check-user-role)


# 自定義權限註解
- [​Spring Boot + Spring Security + Thymeleaf 實戰教程！-技術圈](https://jishuin.proginn.com/p/763bfbd5b812)

# 自訂認證流程
- [Spring Security認證提供程式 | IT人 (iter01.com)](https://iter01.com/418535.html)
- [Spring Security 架構解析 - Wayne's Talk (waynestalk.com)](https://waynestalk.com/spring-security-architecture-explained/)
- [Spring Security 學習之原理篇_duval - MdEditor (gushiciku.cn)](https://www.gushiciku.cn/pl/gb2y/zh-tw)
- [Spring Security詳解（一）認證之核心元件和服務 - IT閱讀 (itread01.com)](https://www.itread01.com/content/1547992984.html)
	- 認證流程介紹
- [聊聊spring security的賬戶鎖定 | 程式前沿 (codertw.com)](https://codertw.com/%E4%BC%BA%E6%9C%8D%E5%99%A8/171380/)
	- DefaultPreAuthenticationChecks 
		這裡會對賬戶的isAccountNonLocked進行判斷，如果被鎖定，則在登入的時候，丟擲LockedException

	```java
	private class DefaultPreAuthenticationChecks implements UserDetailsChecker {  

	 @Override  
	 public void check(UserDetails user) {  
	 if (!user.isAccountNonLocked()) {  
	 AbstractUserDetailsAuthenticationProvider.this.logger  
	 .debug("Failed to authenticate since user account is locked");  
	 throw new LockedException(AbstractUserDetailsAuthenticationProvider.this.messages  
	 .getMessage("AbstractUserDetailsAuthenticationProvider.locked", "User account is locked"));  
	 }  
	 if (!user.isEnabled()) {  
	 AbstractUserDetailsAuthenticationProvider.this.logger  
	 .debug("Failed to authenticate since user account is disabled");  
	 throw new DisabledException(AbstractUserDetailsAuthenticationProvider.this.messages  
	 .getMessage("AbstractUserDetailsAuthenticationProvider.disabled", "User is disabled"));  
	 }  
	 if (!user.isAccountNonExpired()) {  
	 AbstractUserDetailsAuthenticationProvider.this.logger  
	 .debug("Failed to authenticate since user account has expired");  
	 throw new AccountExpiredException(AbstractUserDetailsAuthenticationProvider.this.messages  
	 .getMessage("AbstractUserDetailsAuthenticationProvider.expired", "User account has expired"));  
	 }  
	 }  
	}
	```