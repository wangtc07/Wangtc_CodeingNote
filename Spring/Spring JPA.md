# JPA 
[JPA詳解](https://blog.csdn.net/qq_42897427/article/details/102510101?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522162818800516780262582197%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=162818800516780262582197&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_v2~rank_v29-6-102510101.first_rank_v2_pc_rank_v29&utm_term=jpa+calendar&spm=1018.2226.3001.4187)


---


# 註解
## @Query
[@Query注解的用法(Spring Data JPA)](https://www.cnblogs.com/zj0208/p/6008627.html)

## @Temporal
該註解可以應用於以下類型的實體類屬性：
- `java.util.Date`
- `java.util.Calendar`

[[Web] @JsonFormat, @DateTimeFormat 和 @Temporal_buildcourage](https://blog.csdn.net/buildcourage/article/details/84895992?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522162831885916780271579256%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=162831885916780271579256&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_v2~hot_rank-1-84895992.first_rank_v2_pc_rank_v29&utm_term=%40Temporal&spm=1018.2226.3001.4187)

## @Transient
> _忽略Entity屬性映射_至資料表
> @transient 就是在給某個javabean上需要添加個屬性，但是這個屬性你又不希望給存到數據庫中去，僅僅是做個臨時變量，用一下。
> _不修改已經存在數據庫的數據的數據結構。_