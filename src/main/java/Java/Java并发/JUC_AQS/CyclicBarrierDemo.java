package Java.Java并发.JUC_AQS;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Acui
 * @date 2022年04月26日 14:49
 */
public class CyclicBarrierDemo {


    public static void main(String[] args) {
        final int totalThread = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread; i++) {
            int finalI = i;
            executorService.execute(() -> {
                System.out.printf(finalI +"before..");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException|BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.printf(finalI+"after..");
            });

        }
        executorService.shutdown();
    }
}
