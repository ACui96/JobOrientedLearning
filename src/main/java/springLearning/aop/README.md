## Spring 的 AOP 顺序

### AOP 常用注解

- @Before 				  前置通知 ： 目标方法之前执行
- @After 			         后置通知 ： 目标方法之后执行 （始终执行）
- @AfterReturning    返回后通知 ： 目标方法结束之前执行（异常不执行）
- @AfterThrowing     异常通知： 出现异常时候执行
- @Around                 环绕通知： 环绕目标方法执行

### 题目：说说你使用AOP的过程中遇到过哪些坑，springboot中aop的执行顺序

假设现在有一个业务类 `CalcService`

```java
public class CalcServiceImpl implements CalcService{
    @Override
    public int div(int x, int y) {
        int result = x / y;
        return result;
    }
}
```



## springLearning 的 循环依赖