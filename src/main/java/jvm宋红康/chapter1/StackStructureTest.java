package jvm宋红康.chapter1;

/**
 * @author Acui
 * @date 2021年09月17日 11:03
 */
public class StackStructureTest {
    public static void main(String[] args) {
        int i = 2;
        int j = 3;
        int ret = i + j;
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("hello");

    }
}
