# RedirectAttributes

# 重定向、跳轉

> `RedirectAttributes` 是 Spring mvc 3.1 版本之後出來的一個功能，專門用於*重定向之後還能帶參數跳轉*的的工具類

- `.addAttributie("prama",value)`

  - 在重定向鏈接地址追加傳遞的參數
  - 重新導向透過 RedirectAttributes 傳遞的參數用@ModelAttribute 來接收。

    ```java
    redirectAttributes.addAttributie("prama1",value1);
    return:"redirect：/world"
    ```

    等同於 return:"redirect：/world？prama1=value1

- `.addFlashAttributie("prama",value)`
  - 隱藏了參數，鏈接地址上不直接暴露，但是能且只能在重定向的 “頁面” 獲取 prama 參數值。
  - 其原理就是放到 session 中，session 在跳到頁面後馬上移除對象。
  - 在重定向後的 controller，使用 `@ModelAttribute` **接收參數**
    ```java
    @RequestMapping(value = "/world")
    // 這個方法負責處理來自hello的重新導向請求
    public ModelAndView world (@ModelAttribute("prama") String value) {
    // 重新導向透過RedirectAttributes傳遞的參數用@ModelAttribute來接收。
      System.out.println(value);
      ModelAndView mv = new ModelAndView("result")
      return mv;
    }
    ```
