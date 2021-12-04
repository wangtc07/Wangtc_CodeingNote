# Response
- `@ResponseBody` 不進行頁面跳轉

# Request
- `@RequestParam`  映射請求參數名稱，和實際參數名稱
	- `value` 請求參數名稱
	- `required` 設定請求參數是否是必須，默認_true 必須有參數_
	- `defaultValue` 沒有請求參數時，默認的參數值
	- `produces` 指定返回值類型
		
		```java
		// 返回json數據的字符編碼為utf-8
		@RequestMapping(produces="MediaType.APPLICATION_JSON_VALUE"+
							";charset=utf-8")  
		```
	- `consumes` 指定處理_請求_的提交內容類型（Content-Type）
		- 處理request Content-Type為“application/json”類型的請求
			```java
			@RequestMapping(consumes="application/json")  
			```


# WebDataBinder @InitBinder
設定表單傳入的白/黑名單
[[Controller/Security]WebDataBinder-@InitBinder應用於表單欄位binding及表單驗證(Spring Vaildator) - iT 邦幫忙::一起幫忙解決難題，拯救 IT 人的一天](https://ithelp.ithome.com.tw/articles/10161515)


# @ModelAttribute
[[SpringMVC]@ModelAttribute 2種用法與解釋](https://b0444135.medium.com/springmvc-modelattribute-2%E7%A8%AE%E7%94%A8%E6%B3%95%E8%88%87%E8%A7%A3%E9%87%8B-modelattribute-used-on-method-and-parameter-db70284c3344)
1. 寫在_方法當參數_數用
當參數使用時效果類似於 
`model.addAttribute(“product”, new Product());`
```java
@GetMapping(value = "/showModelAttribute")
public String modelAttributeTest(@ModelAttribute Product product) {
      //等同於=model.addAttribute("product", new Product());
      return "CampPage/user/user.camp.camplist";
}
```

2. 寫在_方法上_@ModelAttribute
所有的 @RequestMapping 都會加入 `model.addAttribute("productList",productService.getAll());`

```java
@ModelAttribute("productList")
public List<Product> getProducts(){
  //相當於model.addAttribute("productList",productService.getAll());
  return productService.getAll();
}
```

