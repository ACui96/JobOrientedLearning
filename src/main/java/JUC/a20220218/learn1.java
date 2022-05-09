package JUC.a20220218;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Acui
 * @date 2022年04月26日 11:12
 */
public class learn1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 1 同一对象，可同步
//        SynchronizedExample e = new SynchronizedExample();
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(() -> e.func1());
//        executorService.execute(() -> e.func1());


        //2 不同对象，不同步
//        SynchronizedExample e1 = new SynchronizedExample();
//        SynchronizedExample e2 = new SynchronizedExample();
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(()-> e1.func1());
//        executorService.execute(()-> e2.func1());

        //3 不同对象，同步
//        SynchronizedExample e3 = new SynchronizedExample();
//        SynchronizedExample e4 = new SynchronizedExample();
//        ExecutorService executorService1 = Executors.newCachedThreadPool();
//        executorService1.execute(()-> e3.func2());
//        executorService1.execute(()-> e4.func2());

        // ReentrantLock
        LockExample lockExample = new LockExample();
        executorService.execute(()-> lockExample.func());
        executorService.execute(()-> lockExample.func());


    }
}

class SynchronizedExample {
    public void func1() {
        synchronized (this) { // 同步一个代码块
            print0to9();

        }
    }

    public void func2() {
        synchronized (SynchronizedExample.class) {
            print0to9();
        }
    }
    private void print0to9() {
        for (int i = 0; i < 10; i++) {
            System.out.printf(i + " ");
        }
    }

}

class LockExample {
    private Lock lock = new ReentrantLock();

    public void func() {
        lock.lock();
        try{
            print0to9();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void print0to9() {
        for (int i = 0; i < 10; i++) {
            System.out.printf(i + " ");
        }
    }
}