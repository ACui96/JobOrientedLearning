package Java.Java并发;

/**
 * @author Acui
 * @date 2022年03月10日 17:54
 * 单例模式
 * 单例模式（Singleton Pattern）是 Java 中最简单的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 *
 * 这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。
 *
 * 注意：
 *
 * 1、单例类只能有一个实例。
 * 2、单例类必须自己创建自己的唯一实例。
 * 3、单例类必须给所有其他对象提供这一实例。
 */
public class Singleton {
    private volatile static Singleton uniqueInstance;

    private Singleton() {

    }
    //4、双检锁/双重校验锁（DCL，即 double-checked locking）
    //JDK 版本：JDK1.5 起
    //
    //是否 Lazy 初始化：是
    //
    //是否多线程安全：是
    //
    //实现难度：较复杂
    //
    //描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
    //getInstance() 的性能对应用程序很关键。
    public static Singleton getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }




}
