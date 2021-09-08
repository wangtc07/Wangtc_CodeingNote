# Hibernate 
[[Hibernate_入門]]


# Session
![[Hibernate_session]]

---

# 配置
![[Hibernate_cfg]]

---

# 映射類型
[Hibernate 映射類型_lvdingding的專欄-CSDN博客](https://blog.csdn.net/lvdingding/article/details/111414742?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522162817475816780271571100%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=162817475816780271571100&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_v2~hot_rank-2-111414742.first_rank_v2_pc_rank_v29&utm_term=Hibernate+calendar+%E6%98%A0%E5%B0%84&spm=1018.2226.3001.4187)

---

# CascadeType
關聯映射中，如一對一、一對多、多對一等，都有設定cascade為`CascadeType.ALL`，這表示儲存其中一方實例時，
若有參考至另一方實例，另一方實例也一併儲存，這個稱之為_聯級（Cascade）操作_。

|                     |           |
| ------------------- | ----------------------------------------------------------- |
| CascadeType.ALL     | 無論儲存、合併、 更新或移除，一併對被參考物件作出對應動作。 |
| CascadeType.MERGE   | 在合併修改時一併 合併修改被參考的物件。                     |
| CascadeType.PERSIST | 在儲存時一併儲存 被參考的物件。                             |
| CascadeType.REFRESH | 在更新時一併更新 被參考的物件。                             |
| CascadeType.REMOVE  | 在移除時一併移除 被參考的物件。                             |
                                                         
---

# FetchType
標註的Fetch模式有其預設值

|             |                 |
| ----------- | --------------- |
| @Basic      | FetchType.EARGE |
| @OneToOne   | FetchType.EARGE |
| @ManyToOne  | FetchType.EARGE |
| @OneToMany  | FetchType.LAZY  |
| @ManyToMany | FetchType.LAZY  |


---

# @JoinColumn
> 指定外來鍵的資訊
- [@JoinColumn註解](https://blog.csdn.net/pengjunlee/article/details/79972059?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control)
- [SpringBoot重點詳解--@JoinColumn註解](https://blog.csdn.net/pengjunlee/article/details/79972059?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control)

## 屬性
- `name` 自訂外來鍵的名稱
- `referencedColumnName` 指定外來鍵參考的欄位，_默認為關聯表的id_
