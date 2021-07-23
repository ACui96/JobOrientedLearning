package Java.Java并发.使用线程;

/**
 * @author Acui
 * @date 2021年06月27日 15:52
 */
public class MyThread extends Thread {
    public void run() {
        System.out.println("123");
    }

    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();
    }
}
