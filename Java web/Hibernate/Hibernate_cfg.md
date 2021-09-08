# 配置
[Hibernate配置文件hibernate.cfg.xml詳解、實體.hbm.xml 映射文件詳解-day02上](https://blog.csdn.net/qq_43414199/article/details/108219345?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522162817475816780271571100%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=162817475816780271571100&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_v2~hot_rank-4-108219345.first_rank_v2_pc_rank_v29&utm_term=Hibernate+calendar+%E6%98%A0%E5%B0%84&spm=1018.2226.3001.4187)

- `hibernate.hbm2ddl.auto`
	- `create` 每次啟動Hibernate，新建SessionFactory物件時，都會 刪除現有的表格，重新建立
	- `create-drop` 新建SessionFactory物件時生成表,sessionFactory關閉,表就自動刪除。
	- `update` 新建SessionFactory物件時，若表格不存在就新建表格， 如果表格存在，自動更新表格結構
		不會刪除表格中已有 的行與列
	- `validate` 新建SessionFactory物件時，驗證表格結構，只會和資料庫中的表格進行比較，不會創建新表。若表格結構不同，將會丟出例外。