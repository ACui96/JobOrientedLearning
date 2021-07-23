package Java.Java并发.使用线程;

/**
 * @author Acui
 * @date 2021年06月27日 15:44
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello, thread!");
    }

    public static void main(String[] args) {
        MyRunnable instance = new MyRunnable();
        Thread thread = new Thread(instance);
        thread.start();
    }
}
