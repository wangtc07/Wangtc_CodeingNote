- [[Spring Security 案例]]

# 認證機制

- `filterChainProxy`

![](https://i.imgur.com/jLANIZG.png)

![](https://i.imgur.com/zIk8GWX.png)

## 流程

![](https://i.imgur.com/MVWb0mg.png)

# 註解

- 使用註解，在啟動類加上
  ```java
  @EnableGlobalMethodSecurity(prePostEnabled = true,
  							securedEnabled = true)
  ```
- 在 controller 方法上加上註解
  ```java
    @RequestMapping("add")
    @PreAuthorize("hasAuthority('sys:add')")  // 前置授權
    public String add(){
        return "add";
    }
  ```
  - `@PreAuthorize` 在方法調用**前**進行權限檢查
  - `@PostAuthorize` 在方法調用**後**進行權限檢查
  - `@Secured`

# 錯誤

- `AccessDeniedException` 拒絕存取

- `An internal error occurred while trying to authenticate the user.`

# token

[session、cookie、token 详解\_徐本锡的专栏-CSDN 博客](https://blog.csdn.net/xubenxismile/article/details/92838749?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522162999283616780271588264%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=162999283616780271588264&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_v2~rank_v29-1-92838749.pc_search_result_cache&utm_term=Token&spm=1018.2226.3001.4187)
