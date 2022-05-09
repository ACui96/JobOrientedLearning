package Java;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + atomicInteger.incrementAndGet());
            }, "线程1").start();

            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + atomicInteger.incrementAndGet());
            }, "线程2").start();

            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + atomicInteger.incrementAndGet());
            }, "线程3").start();
        }

    }

}
