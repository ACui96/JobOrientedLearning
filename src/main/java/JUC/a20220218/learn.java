package JUC.a20220218;

import java.util.concurrent.*;

/**
 * @author Acui
 * @date 2022年04月26日 9:48
 */
public class learn {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Runnable
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        // Callable
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> integerFutureTask = new FutureTask<>(myCallable);
        Thread thread1 = new Thread(integerFutureTask);
        thread1.start();
        System.out.println(integerFutureTask.get());

        // Thread
        MyThread thread2 = new MyThread();
        thread2.run();
        thread2.start();


        // Executor
        Executors.newFixedThreadPool(5);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();

        System.out.println("executorService.execute(new MyRunnable());");
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable());
        }
        executorService.shutdown();

        // Daemon 守护线程
        Thread thread3 = new Thread(new MyRunnable());
        thread3.setDaemon(true);// 设为守护线程
        thread3.start();

        //Sleep
        Thread thread4 = new Thread(new SleepRunnable());
        System.out.println("SleepRunnable");
        thread4.start();

        // Interrupt
//        thread4.start();
//        thread4.interrupt();//Exception in thread "main" java.lang.IllegalThreadStateException
//                                    //at java.lang.Thread.start(Thread.java:708)
//                                    //at JUC.a20220218.learn.main(learn.java:51)
//        System.out.println("Main run...");

        // Executor.shutdown() 中断所有线程
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(() -> {
            try {
                Thread.sleep(4000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.shutdownNow(); // 调用 Executor 的 shutdown() 方法会等待线程都执行完毕之后再关闭
        // ，但是如果调用的是 shutdownNow() 方法，
        // 则相当于调用每个线程的 interrupt() 方法。
        System.out.println("Main run...");

        // 单独停止某个线程
        Future<Integer> submit = service.submit(() -> {
            int i = 123;
            return i;
        });
        submit.cancel(true);



    }
}



class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("runnalble...");
    }
}

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 123;
    }
}

class MyThread extends Thread {
    public void run() {
        System.out.println("class MyThread extends Thread...");
    }
}

class SleepRunnable implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("SleepRunnable....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
