package JUC;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Acui
 * @date 2021年09月19日 21:23
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2021) + "当前值: \t" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1024) + "当前值： \t" + atomicInteger.get());
    }
}
