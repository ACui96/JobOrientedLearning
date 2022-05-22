package 算法.recursion;

/**
 *
 * @author Acui
 * @date 2022年05月22日 15:48
 */
public class Recursion {
    int lifetime = 10;

    public static void main(String[] args) {
        new Recursion().recursion(0);
    }

    private void recursion(int i) {
        if (i < lifetime) {
            System.out.print(i + " ");
            recursion(++i);
            System.out.print(i - 1 + " ");
        } else {
            System.out.println();
            System.out.println("reverse");
        }
    }
}
