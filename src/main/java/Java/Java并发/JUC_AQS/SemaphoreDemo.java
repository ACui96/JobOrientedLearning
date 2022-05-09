package Java.Java并发.JUC_AQS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author Acui
 * @date 2022年04月26日 14:57
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        final int totalRequests = 10;
        final int totalClients = 3;
        Semaphore semaphore = new Semaphore(totalClients);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalRequests; i++) {
            int finalI = i;
            executorService.execute(()->{
                try {
                    System.out.printf("当前可用（acquire前）"+semaphore.availablePermits()+" ");
                    semaphore.acquire();
                    System.out.println();
                    System.out.printf("当前可用"+semaphore.availablePermits()+" ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }

            });
        }
        executorService.shutdown();
    }
}
