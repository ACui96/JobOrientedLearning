package Java.Java并发.中断;

import Java.Java并发.使用线程.MyThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Acui
 * @date 2021年06月29日 19:50
 */
public class InterruptExample {
    private static class MyThread1 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class MyThread2 extends Thread {
        @Override
        public void run() {
            while (!interrupted()) {

            }
            System.out.println("Thread2 end");
        }
    }
    public static void main(String[] args) {
//        Thread thread1 = new MyThread1();
//        thread1.start();
//        thread1.interrupt();
//        System.out.println("Main run");

//        Thread thread2 = new MyThread2();
//        thread2.start();
//        thread2.interrupt();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdownNow();
        System.out.println("Main run");


        Future<?> future = executorService.submit(() -> {
        });

        future.cancel(true);

    }
}
