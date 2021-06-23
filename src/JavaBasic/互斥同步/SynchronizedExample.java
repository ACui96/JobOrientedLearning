package JavaBasic.互斥同步;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Acui
 * @date 2021年06月03日 20:21
 */
public class SynchronizedExample {

    // 同步一个方法
//    public synchronized void func() {
//
//    }

    public void func1() {
        // 同步一个代码块
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }

//    public void func2() {
//        // 同步一个类
//        // 作用于整个类，也就是说两个线程调用同一个类的不同对象上的这种同步语句，也会进行同步。
//        synchronized (SynchronizedExample.class) {
//            for (int i = 0; i < 10; i++) {
//                System.out.print(i + " ");
//            }
//        }
//    }
//
//    // 同步一个静态方法
//    // 作用于整个类
//    public synchronized static void fun() {
//
//    }

    // TEST
    public static void main(String[] args) {
        SynchronizedExample e1 = new SynchronizedExample();
        SynchronizedExample e2 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 1
        // 使用 ExecutorService 执行了两个线程，由于调用的是同一个对象的同步代码块，因此这两个线程会进行同步，
        // 当一个线程进入同步语句块时，另一个线程就必须等待。
//        executorService.execute(() -> e1.func1());
//        executorService.execute(() -> e1.func1()); // 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9

        // 2
        executorService.execute(() -> e1.func1());
        executorService.execute(() -> e2.func1());

        // 3
//        executorService.execute(() -> e1.func2());
//        executorService.execute(() -> e2.func2());

        // 4
//        executorService.execute(() -> e1.func2());
//        executorService.execute(() -> e2.func2());





//        SynchronizedExample e2 = new SynchronizedExample();
//        // 两个线程调用了不同对象的同步代码块，因此这两个线程就不需要同步
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(() -> e1.func1());
//        executorService.execute(() -> e2.func1());

//        executorService.shutdown();




        executorService.shutdown();

    }
}
