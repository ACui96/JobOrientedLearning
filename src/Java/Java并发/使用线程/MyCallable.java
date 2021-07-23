package Java.Java并发.使用线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Acui
 * @date 2021年06月27日 15:46
 */
public class MyCallable implements Callable {

    @Override
    public Integer call() {
        return 123; // 与 Runnable 相比，Callable 可以有返回值，返回值通过 FutureTask 进行封装。
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable mc = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<>(mc);
        Thread thread = new Thread(ft);
        thread.start();
        System.out.println(ft.get());
    }
}
