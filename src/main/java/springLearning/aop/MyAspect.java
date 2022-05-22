package springLearning.aop;

/**
 * @author Acui
 * @date 2022年05月22日 19:07
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("execution(public int springLearning.aop.CalcServiceImpl.*(..))")
    public void beforeNotify() {
        System.out.println("************ @Before 我是前置通知 MyAspect");
    }

    @After("execution(public int springLearning.aop.CalcServiceImpl.*(..))")
    public void afterNotify() {
        System.out.println("************ @After 我是后置通知 MyAspect");
    }

    @AfterReturning("execution(public int springLearning.aop.CalcServiceImpl.*(..))")
    public void afterReturning() {
        System.out.println("************ @AfterReturning 我是返回后通知 MyAspect");
    }

    @AfterThrowing("execution(public int springLearning.aop.CalcServiceImpl.*(..))")
    public void afterThrowing() {
        System.out.println("************ @AfterThrowing 我是异常通知 MyAspect");
    }

    @Around("execution(public int springLearning.aop.CalcServiceImpl.*(..))")
    public Object aroud(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object retValue = null;
        System.out.println("************ @Around 我是环绕通知之前 AAA");
        retValue = proceedingJoinPoint.proceed();
        System.out.println("************ @Around 我是环绕通知之后 BBB");
        return retValue;
    }
}
