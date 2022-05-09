package Java.Java并发.CAS;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Acui
 * @date 2021年06月30日 8:48
 */
public class AtomicIntegerExample {
    private AtomicInteger cnt = new AtomicInteger();

    public void add() {
        cnt.incrementAndGet();
    }
}
