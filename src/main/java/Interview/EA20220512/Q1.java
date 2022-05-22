package Interview.EA20220512;

/**
 * @author Acui
 * @date 2022年05月12日 19:01
 */
public class Q1 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = a.clone();
        a[0] = 100;
        System.out.println(a[0]);

        System.out.println(b[0]);
    }


}
