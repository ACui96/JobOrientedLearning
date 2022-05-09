package JUC;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Acui
 * @date 2021年09月26日 15:18
 * 1 队列
 * 2 阻塞队列  BlockingQueue
 *      2.1 阻塞队列有好的一面
 *
 *      2.2 不得不阻塞的时候，如何管理
 *
 *      阻塞队列概念   类比 生产者-消费者 模式
 *          1. 当阻塞队列为空时，获取 会导致阻塞
 *          2. 当阻塞队列为满时，添加 会导致阻塞
 *     为什么用
 *      不需要关心什么时候需要阻塞线程  手动挡-》自动挡
 *
 *
 *
 *
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception{
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));


    }
}
