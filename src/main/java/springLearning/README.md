## Spring 的 AOP 顺序

### AOP 常用注解

- @Before 				  前置通知 ： 目标方法之前执行
- @After 			         后置通知 ： 目标方法之后执行 （始终执行）
- @AfterReturning    返回后通知 ： 目标方法结束之后执行（异常不执行）
- @AfterThrowing     异常通知： 出现异常时候执行
- @Around                 环绕通知： 环绕目标方法执行

### 题目：说说 springboot 中 AOP 的执行顺序

#### 测试Spring4

##### 情景假设及测试

```xml
<!--spring版本4.3.12.RELEASE	SpringBoot版本1.5.8.RELEASE-->
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.5.8.RELEASE</version>
</parent>
```

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

自定义切面 MyAspect

```java
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
```

测试类 

```java
package springLearning.aop;

import org.junit.Test; // spring4 用的junit
...
    
@SpringBootTest // 相当于一个 Controller
@RunWith(SpringRunner.class)
public class TestAop {
    @Resource // 或用 Autowired
    private CalcService calcService;

    @Test
    public void testAop4() {
        System.out.println("正常情况");
        System.out.println("spring版本"+ SpringVersion.getVersion() + "\t" + "SpringBoot版本"+ SpringBootVersion.getVersion());
        System.out.println();
        calcService.div(10, 2);
    }

    @Test
    public void testAop4WithException() {
        System.out.println("testAop4WithException");
        System.out.println("spring版本"+ SpringVersion.getVersion() + "\t" + "SpringBoot版本"+ SpringBootVersion.getVersion());
        System.out.println();
        calcService.div(10, 0);
    }
}
```

##### Spring4 结果

正常情况

```shell
正常情况
spring版本4.3.12.RELEASE	SpringBoot版本1.5.8.RELEASE

************ @Around 我是环绕通知之前 AAA
************ @Before 我是前置通知 MyAspect
             =========> CalcServiceImpl 被调用了，计算结果为：5
************ @Around 我是环绕通知之后 BBB
************ @After 我是后置通知 MyAspect
************ @AfterReturning 我是返回后通知 MyAspect
```

异常情况

```shell
testAop4WithException
spring版本4.3.12.RELEASE	SpringBoot版本1.5.8.RELEASE

************ @Around 我是环绕通知之前 AAA
************ @Before 我是前置通知 MyAspect
************ @After 我是后置通知 MyAspect
************ @AfterThrowing 我是异常通知 MyAspect

java.lang.ArithmeticException: / by zero
```

#### 测试 Spring5.3.18

pom.xml

```xml
<!--spring版本5.3.18	SpringBoot版本2.6.6-->
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.6.6</version>
</parent>
```

##### Spring5 结果

正常情况

```shell
正常情况
spring版本5.3.18	SpringBoot版本2.6.6

************ @Around 我是环绕通知之前 AAA
************ @Before 我是前置通知 MyAspect
             =========> CalcServiceImpl 被调用了，计算结果为：5
************ @AfterReturning 我是返回后通知 MyAspect
************ @After 我是后置通知 MyAspect
************ @Around 我是环绕通知之后 BBB
```

异常情况

```shell
testAop5WithException
spring版本5.3.18	SpringBoot版本2.6.6

************ @Around 我是环绕通知之前 AAA
************ @Before 我是前置通知 MyAspect
************ @AfterThrowing 我是异常通知 MyAspect
************ @After 我是后置通知 MyAspect

java.lang.ArithmeticException: / by zero
```

#### 结论

Spring4 下

**正常情况：**@Before----->@After----->@AfterReturning

**异常情况：**@Before----->@After----->@AfterThrowing

Spring5 下

**正常情况：**@Before----->@AfterReturning----->@After

**异常情况：**@Before----->@AfterThrowing----->@After

tip：@After 应是类似 finally，最后执行  ，从 Spring5 以后，After 都是最后执行了

## Spring 的 循环依赖

### 循环依赖相关问题

- 你解释下Spring中的**三级缓存**
- 三级缓存分别是什么，三个Map有何异同
- 什么是循环依赖？请你谈谈？看过Spring源码吗？一般我们说的**Spring容器**是什么
- **如何检测**是否存在循环依赖？实际开发中见过循环依赖的异常吗？
- 多例的情况下，循环依赖问题为什么无法解决？

### 循环依赖

- 多个 bean 之间相互依赖，形成一个闭环。 如：

  ```java
  public class TestClazz {
      class A {
          B b;
      }
      class B {
          C c;
      }
      class C {
          A a;
      }
  }
  ```

- 通常来说，如果问 Spring 容器中如何解决循环依赖，**一定是指默认的单例 Bean 中**，属性相互引用的场景

### 两种注入方法对循环依赖的影响

[Spring官网文档](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-dependencies)

>Circular dependencies 循环依赖
>
>If you use predominantly **constructor injection**, it is possible to create an unresolvable circular dependency scenario.
>
>For example: Class A requires an instance of class B through constructor injection, and class B requires an instance of class A through constructor injection. If you configure beans for classes A and B to be injected into each other, the Spring IoC container detects this circular reference at runtime, and throws a `BeanCurrentlyInCreationException`.
>
>One possible solution is to edit the source code of some classes to be configured by **setters rather than constructors.** Alternatively, avoid constructor injection and use setter injection only. In other words, although it is not recommended, you can configure circular dependencies with setter injection.
>
>Unlike the typical case (with no circular dependencies), a circular dependency between bean A and bean B forces one of the beans to be injected into the other prior to being fully initialized itself (a classic chicken-and-egg scenario).

上面这段话主要讲了使用**构造器注入**可能导致循环依赖问题，官方建议使用 **Setter 注入方法**。

#### 构造器注入方法

无法解决循环依赖问题，典型的``先有鸡还是先有蛋``

```java
@Component
public class ServiceA {
    private ServiceB serviceB;

    public ServiceA(ServiceB serviceB) {
        this.serviceB = serviceB;
    }
}

@Component
public class ServiceB {
    private ServiceA serviceA;

    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
}

public class Main {
    public static void main(String[] args) {
        //new ServiceA(new ServiceB(new ServiceA(......)));
    }
}
```

#### Setter 注入方法

```java
@Component
public class ServiceC {
    private ServiceD serviceD;

    public void setServiceD(ServiceD serviceD) {
        this.serviceD = serviceD;
        System.out.println("C里设置了D");
    }
}

@Component
public class ServiceD {
    private ServiceC serviceC;

    public void setServiceC(ServiceC serviceC) {
        this.serviceC = serviceC;
        System.out.println("D设置C");
    }
}

public class Main {
    public static void main(String[] args) {
        ServiceC c = new ServiceC();
        ServiceD d = new ServiceD();

        d.setServiceC(c);
        c.setServiceD(d);
    }
}
```



结论：AB 循环依赖问题只要A的注入方式是 Setter 注入，就不会有循环依赖问题

### 容器环境下的循环依赖

- 容器中，默认的单例场景（singleton）下是支持循环依赖的，不报错

- 原型场景（prototype）不支持循环依赖，会报错

  > bean的作用域
  >
  > 1. singleton 单例
  > 2. prototype 原型
  > 3. request
  > 4. session
  > 5. global-session   Spring5 已经没了

#### singleton 作用域下

```xml
<!--scope不写也是默认单例-->
<bean id = "c" class="springLearning.CircularDependencies.setterInjection.ServiceC" scope="singleton">
    <property name="serviceD" ref="d"></property>
</bean>

<bean id = "d" class="springLearning.CircularDependencies.setterInjection.ServiceD" scope="singleton">
    <property name="serviceC" ref="c"></property>
</bean>
```

```java
public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    ServiceC c = context.getBean("c", ServiceC.class);
    ServiceD d = context.getBean("d", ServiceD.class);
}
```

结果1

> 08:47:37.965 [main] DEBUG org.springframework.context.support.ClassPathXmlApplicationContext - Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@470e2030
> 08:47:38.090 [main] DEBUG org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loaded 2 bean definitions from class path resource [applicationContext.xml]
> 08:47:38.121 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'c'
> 08:47:38.132 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'd'
> D设置C
> C里设置了D

#### prototype作用域下

改成 prototype

```xml
<bean id = "c" class="springLearning.CircularDependencies.setterInjection.ServiceC" scope="prototype">
    <property name="serviceD" ref="d"></property>
</bean>

<bean id = "d" class="springLearning.CircularDependencies.setterInjection.ServiceD" scope="peototype">
    <property name="serviceC" ref="c"></property>
</bean>
```

结果2

```shell
Caused by: org.springframework.beans.factory.BeanCurrentlyInCreationException: Error creating bean with name 'c': Requested bean is currently in creation: Is there an unresolvable circular reference?
```

出现了 ``BeanCurrentlyInCreationException`` 异常

### Spring 容器的三级缓存解决循环依赖

[一文告诉你Spring是如何利用"三级缓存"巧妙解决Bean的循环依赖问题的](https://cloud.tencent.com/developer/article/1497692)

重要结论： Spring 内部通过3级缓存来解决循环依赖  **DefaultSingletonBeanRegistry**

```java
public class DefaultSingletonBeanRegistry extends SimpleAliasRegistry implements SingletonBeanRegistry {

	/** 一级缓存 Cache of singleton objects: bean name to bean instance. 
	 *  单例池
	 *  实例化 + 初始化
	 */
	private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

	/** 三级缓存 Cache of singleton factories: bean name to ObjectFactory. 
	 *  单例工厂的高速缓存
	 *  存放生成 bean 的工厂
	 */
	private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>(16);

	/** 二级缓存 Cache of early singleton objects: bean name to bean instance. 
	 *  实例化但未初始化
	 */
	private final Map<String, Object> earlySingletonObjects = new ConcurrentHashMap<>(16);
}
```

- 一级缓存 singletonObjects ： 存放已经经历了完整生命周期的 bean
- 二级缓存 earlySingletonObjects： 存放早期暴露出来的 bean 对象， bean 的声明周期为结束，属性还未填充完毕
- 三级缓存 Map<String, ObjectFactory<?>> singletonFactories： 存放可以生成 bean 的工厂，即 FactoryBean, 如果 A 类实现了 FactoryBean，那么依赖注入的时候不是注入 A 类，而是 A 类产生的 Bean

**只有单例的 bean 会通过三级缓存提前暴露来解决循环依赖的问题**，而非单例的 bean ，每次从容器中获取都是一个新的对象，都会重新创建，所以非单例的bean是没有缓存的，不会将器放到三级缓存中。

#### A / B 两对象在三级缓存中的迁移说明

1. 1A创建过程中需要B，于是A将自己放到三级缓里面，去实例化B
2. B实例化的时候发现需要A，于是B先查一级缓存，没有，再查二级缓存，还是没有，再查三级缓存，找到了A然后把三级缓存里面的这个A放到二级缓存里面，并删除三级缓存里面的A
3. B顺利初始化完毕，将自己放到一级缓存里面（此时B里面的A依然是创建中状态）然后回来接着创建A，此时B已经创建结束，直接从一级缓存里面拿到B，然后完成创建，并将A自己放到一级缓存里面。

#### 为什么一定要用三级缓存，用二级可以吗？一级可以吗？

**使用三级缓存而非二级缓存并不是因为只有三级缓存才能解决循环引用问题，其实二级缓存同样也能很好解决循环引用问题。使用三级而非二级缓存并非出于IOC的考虑，而是出于AOP的考虑，即若使用二级缓存，在AOP情形下，注入到其他bean的，不是最终的代理对象，而是原始对象。**

