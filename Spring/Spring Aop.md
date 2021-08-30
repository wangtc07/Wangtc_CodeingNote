# AOP 簡介
- 通過動態代理技術
	1. JDK 代理: 接口代理
	2. cglib 代理: 父類代理

---
# AOP 術語
- Target 目標對象: 被代理的對象
- Porxy 代理: _被AOP增強後_產生的代理類
- Joinpoint 連接點: 被攔截到到點(_方法_)
- Pointcut 切入點: 要對哪些 joinpoint 進行攔截的_定義_
- Advice 增強: 攔截後所執行的方法
- Aspect 切面: 包含 Pointcut , Advice
	- Aspect與Advice的關係好比就是類別與方法的關係，
	_一個 Aspect 可以有多個 Advice_
- Weaving 織入: 增強應用到目標對象，創建新的代理對象的_過程_

---
# AOP 步驟
1. AOP maven 配置
```xml
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.0.5.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.8.4</version>
        </dependency>
```
2. 創建目標對象
```java
@Component("target")
public class Target implements TargetInterface {
    public void save() {
        System.out.println("save running.....");
        //int i = 1/0;
    }
}
```
3. 創建切面類
```java
@Component("myAspect")
@Aspect //標注當前MyAspect是一個切面類
public class MyAspect {

    //配置前置通知
    //@Before("execution(* com.itheima.anno.*.*(..))")
    public void before(){
        System.out.println("前置增強..........");
    }

    public void afterReturning(){
        System.out.println("後置增強..........");
    }

    //Proceeding JoinPoint:  正在執行的連接點===切點
    //@Around("execution(* com.itheima.anno.*.*(..))")
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("環繞前增強....");
        Object proceed = pjp.proceed();//切點方法
        System.out.println("環繞後增強....");
        return proceed;
    }

    public void afterThrowing(){
        System.out.println("異常拋出增強..........");
    }

    //@After("execution(* com.itheima.anno.*.*(..))")
    @After("MyAspect.pointcut()")
    public void after(){
        System.out.println("最終增強..........");
    }

    //定義切點表達式
    @Pointcut("execution(* com.itheima.anno.*.*(..))")
    public void pointcut(){}

}
```

![](https://i.imgur.com/qly6giR.png)


4. 開啟 AOP 自動代理
	- xml `<aop:aspectj-autoproxy/>`
	- 註解 `@EnableAspectJAutoProxy`
