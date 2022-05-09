package Java.Java并发.线程安全;

/**
 * @author Acui
 * @date 2022年04月26日 16:06
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        Thread thread = new Thread(() -> {
            threadLocal.set(1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
            threadLocal.remove();
        });
        Thread thread2 = new Thread(()->{
            threadLocal.set(2);
            threadLocal.remove();
        });
        thread.start();
        thread2.start();
    }
}
