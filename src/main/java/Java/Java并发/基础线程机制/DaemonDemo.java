package Java.Java并发.基础线程机制;

import Java.Java并发.使用线程.MyRunnable;
import Java.Java并发.使用线程.MyThread;

/**
 * @author Acui
 * @date 2021年06月27日 15:58
 */
public class DaemonDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.setDaemon(true);
    }
}
