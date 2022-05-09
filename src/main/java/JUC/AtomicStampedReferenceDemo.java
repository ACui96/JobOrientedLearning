package JUC;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author Acui
 * @date 2021年09月20日 10:08
 */
public class AtomicStampedReferenceDemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {
        System.out.println("=======ABA问题======");

        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        }, "t1").start();

        new Thread(() -> {
            try {
                //暂停是为了保证 t1 完成一次ABA
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 2021) + "\t" + atomicReference.get());
        }, "t2").start();
        System.out.println("=======ABA问题的解决======");
        int stamp = atomicStampedReference.getStamp();
        System.out.println(Thread.currentThread().getName() + "\t第 1 次版本号" + stamp);

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t第 2 次版本号" + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t第 3 次版本号" + atomicStampedReference.getStamp());
                }, "t3").start();



        new Thread(() -> {

            int stamp1 = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t 第 1 次版本号:" + stamp1);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean ret = atomicStampedReference.compareAndSet(100, 2019, stamp1, stamp1 + 1);
            System.out.println("修改成功与否：" + ret + "\t目前实际版本号：" + atomicStampedReference.getStamp());
            System.out.println(Thread.currentThread().getName() + "\t当前实际的值：" + atomicStampedReference.getReference());

        }, "t4").start();

    }
}
