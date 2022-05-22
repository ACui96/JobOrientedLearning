package Java.Java并发;

/**
 * @author Acui
 * @date 2022年06月06日 19:47
 */
public class TestThread implements Runnable {
    int[] a = {1, 2, 3, 4, 5};

    public static void main(String[] args) {
        int i = 1;
        System.out.println(i++ + ++i);

    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(a[i]);
        }
    }
}
