package JUC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Acui
 * @date 2021年09月19日 20:03
 */
public class T1 {
    volatile int num = 0;

    public void add() {
        num++;
    }

    public static void main(String[] args) {
        Lock reentrantLock = new ReentrantLock();
    }
}
