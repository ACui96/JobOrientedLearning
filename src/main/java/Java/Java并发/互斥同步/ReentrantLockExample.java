package Java.Java并发.互斥同步;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Acui
 * @date 2021年06月03日 20:41
 */
public class ReentrantLockExample {
    private Lock lock = new ReentrantLock();

    public void func() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        } finally {
            lock.unlock(); // 确保释放锁，从而避免死锁
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample lockExample = new ReentrantLockExample();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(
            () -> {
            // ... do something inside runnable task
            lockExample.func();
            lockExample.func();
        });
        service.shutdown();
    }
}
