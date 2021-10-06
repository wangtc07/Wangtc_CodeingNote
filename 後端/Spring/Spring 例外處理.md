- [Day23 Spring MVC例外處理篇(Exception Handling in Spring MVC)[上]](https://ithelp.ithome.com.tw/articles/10196822)

- [SpringBoot實踐之---處理全局統一異常的兩種方法與區別（@ControllerAdvice、@ExceptionHandler 與 ErrorController類）](https://blog.csdn.net/luckykapok918/article/details/102938951)
- 



# Spring MVC處理例外主要有三種配置方式
1. 全局配置
	- 透過註解 `@ControllerAdvice` 的控制器來配置我們全局控制器異常處理,在此註解中包含了三個常用註解
		-   `@ExceptionHandler`(用於全局控制器裡的異常)
		-   `@InitBinder`(用於設置`WebDataBinder`),`WebDataBinder`是用來自動綁定前台請求參數到Model中
		-   `@ModelAttribute`(用於綁定鍵值數據到Model中)

```java
@ControllerAdvice
public class ExceptionHandlerAdvice {
	@ExceptionHandler(value = Exception.class)
	public ModelAndView exception(Exception ex,WebRequest request){
		ModelAndView modelAndView = new ModelAndView();
		
		// 增加錯誤訊息在這方法在利用前台映射取出數值
		modelAndView.addObject("errorSomething","somerror");
		
		// 返回的錯誤頁面
		modelAndView.setViewName("error"); 
		return modelAndView;
	}
	
	//如果我們要讓所有的@RequestMapping擁有此鍵值
	@ModelAttribute
	public void addAttribute(Model md){
		md.addAttribute("message","你可以設定一些錯誤訊息");
	}	
}
```

2. 單一Controller


3. 單一方法配置

```java
@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Page is not Exist")
@ExceptionHandler(NullPointerException.class)
public ResponseEntity<Object> Not_Found() {
	System.out.println("進入NullPointerException例外處理");
	return new ResponseEntity<Object>(
		"NOT FOUND THE DATA ", new HttpHeaders(), HttpStatus.NOT_FOUND);
}
```
- @ResponseStatus :回傳的Http代碼 ex:404,500
- @ExceptionHandler() : 內可以填入多個Exception.class 我以NullPointerException為例子
- System.out.println("進入NullPointerException例外處理"); 測試當發生例外是否真的進入此方法
- return 帶了第一個參數 message: NOT FOUND THE DATA , 第二個參數固定 new HttpHeaders() 產生一個HttpHeaders物件,第三個參數 HttpHeaders的狀態
- 一個Controller下多個@ExceptionHandler上的_異常類型不能重複_，否則運行時拋異常
- `@ExceptionHandler` 方法_參數_支持：Exception、SessionAttribute 、 RequestAttribute註解、HttpServletRequest、HttpServletResponse、HttpSession
- `@ExceptionHandler` 方法_返回值類型支持多種_，常見的ModelAndView，@ResponseBody註解標注，ResponseEntity等類型都OK.


# Springboot2 
1. HttpErrorController類，實現 `ErrorPageRegistrar`
```java
@Component
public class HttpErrorController implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        /*1、按錯誤的類型顯示錯誤的網頁*/
        /*錯誤類型為404，找不到網頁的，默認顯示404.html網頁*/
        ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404");
        //錯誤類型為500，表示服務器響應錯誤，默認顯示500.html網頁
        ErrorPage e500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500");
        registry.addErrorPages(e404, e500);
    }
}
```
---
2. ErrorController控制器實現頁面跳轉
```java
@Controller
@RequestMapping("/error")
public class ErrorController {
    /**
     * 404頁面
     */
    @GetMapping(value = "/404")
    public String error_404() {
        return "404";
    }

    /**
     * 500頁面
     */
    @GetMapping(value = "/500")
    public String error_500() {
        return "500";
    }
}
```