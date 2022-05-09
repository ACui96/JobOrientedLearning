package Java.Java并发.基础线程机制;

import Java.Java并发.使用线程.MyRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Acui
 * @date 2021年06月27日 15:55
 */
public class ThreadDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();//一个任务创建一个线程；
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable());
        }
//        executorService = Executors.newFixedThreadPool(5);所有任务只能使用固定大小的线程；
//
//        executorService = Executors.newSingleThreadExecutor();相当于大小为 1 的 FixedThreadPool。


        executorService.shutdown();


        Thread thread = new Thread(new MyRunnable());
        thread.setDaemon(true);
    }
}
