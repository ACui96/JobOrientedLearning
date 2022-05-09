package JUC.prod_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource {
    private volatile boolean FLAG = true; // 默认开启， 进行生产和消费
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws Exception {
        String data = "";
        boolean retVal = true;
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retVal) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "成功！");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "失败。");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "大老板叫停，表示FLAG = false，生产动作结束");

    }

    public void myConsume()throws Exception {
        String ret = null;
        while (FLAG) {
            ret = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null == ret || ret.equalsIgnoreCase("")) {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t 超过 2秒钟没有取到，消费退出");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费队列data" + ret + "成功");
        }
    }

    public void myStop()throws Exception{
        this.FLAG = false;
    }


}

/**
 * @author Acui
 * @date 2021年09月29日 15:29
 * 生产者消费者 新版本
 */
public class ProductionConsumerSyQueueDemo {
    public static void main(String[] args) throws Exception {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 生产线程启动");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Prod").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 消费线程启动");
            try {
                myResource.myConsume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Consumer").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("5 s timeout，到老板main线程叫停，结束");
        myResource.myStop();
    }
}
