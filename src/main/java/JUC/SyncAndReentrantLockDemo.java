package JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Acui
 * @date 2021年09月26日 17:41
 * Synchronized 和 Lock 的区别
 *  ### synchronized 和 lock 有什么区别？用新的lock有什么好处？举例说明
 *
 * - synchronized 和 lock 有什么区别？用新的lock有什么好处？举例说明
 *
 * 1）synchronized属于JVM层面，属于java的关键字
 *
 * - ​	monitorenter（底层是通过monitor对象来完成，其实wait/notify等方法也依赖于monitor对象 只能在同步块或者方法中才能调用 wait/ notify等方法）
 * - Lock是具体类（java.util.concurrent.locks.Lock）是api层面的锁
 *
 * 2）使用方法：
 *
 * - synchronized：不需要用户去手动释放锁，当synchronized代码执行后，系统会自动让线程释放对锁的占用
 *
 * - ReentrantLock：则需要用户去手动释放锁，若没有主动释放锁，就有可能出现死锁的现象，需要lock() 和 unlock() 配置try catch语句来完成
 *
 * 3）等待是否中断
 *
 * - synchronized：不可中断，除非抛出异常或者正常运行完成
 * - ReentrantLock：可中断，可以设置超时方法
 *   - 设置超时方法，trylock(long timeout, TimeUnit unit)
 *   - lockInterrupible() 放代码块中，调用interrupt() 方法可以中断
 *
 * 4）加锁是否公平
 *
 * - synchronized：非公平锁
 * - ReentrantLock：默认非公平锁，构造函数可以传递boolean值，true为公平锁，false为非公平锁
 *
 * 5）锁绑定多个条件Condition
 *
 * - synchronized：没有，要么随机，要么全部唤醒
 * - ReentrantLock：用来实现分组唤醒需要唤醒的线程，可以精确唤醒，而不是像synchronized那样，要么随机，要么全部唤醒
 *
 *
 * 题目：多线程之间按顺序调用，实现 A-> B -> C 三个线程启动，要求如下：
 * AA打印5次，BB打印10次，CC打印15次
 * 紧接着
 * AA打印5次，BB打印10次，CC打印15次
 * ..
 * 来10轮
 */
class SharedData {
    private volatile int number = 1;// A 1 B 2 C 3

    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();


    public void print2() {
        lock.lock();
        try{
            while (this.number != 1) {
                c1.await();
            }
            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + number);
            }
            this.number = 2;
            c2.signal();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print3() {
        lock.lock();
        try{
            while (this.number != 2) {
                c2.await();
            }
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + number);
            }
            this.number = 3;
            c3.signal();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print5() {
        lock.lock();
        try{
            while (this.number != 3) {
                c3.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + number);
            }
            this.number = 1;
            c1.signal();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                sharedData.print2();
            }, "AAA").start();

            new Thread(() -> {
                sharedData.print3();
            }, "BBB").start();

            new Thread(() -> {
                sharedData.print5();
            }, "CCC").start();
        }


    }
}
