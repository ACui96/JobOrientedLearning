package JUC;

import com.sun.deploy.uitoolkit.impl.awt.AWTAppletAdapter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Acui
 * @date 2021年09月26日 15:55
 * 同步队列
 * 生产一个，消费一个
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t put 1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName() + "\t put 2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName() + "\t put 3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AA").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("BB consume" + "\t" + blockingQueue.take());

                TimeUnit.SECONDS.sleep(2);
                System.out.println("BB consume" + "\t" + blockingQueue.take());

                TimeUnit.SECONDS.sleep(2);
                System.out.println("BB consume" + "\t" + blockingQueue.take());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "BB").start();
    }
}
