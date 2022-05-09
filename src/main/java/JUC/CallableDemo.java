package JUC;

import java.util.concurrent.Callable;

class MyThread implements Runnable {

    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 1024;
    }
}

/**
 * @author Acui
 * @date 2021年09月29日 16:51
 *
 * Thread Runnable Callable
 */
public class CallableDemo {
    public static void main(String[] args) {


    }
}
