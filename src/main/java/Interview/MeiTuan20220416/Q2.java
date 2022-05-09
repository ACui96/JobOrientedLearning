package Interview.MeiTuan20220416;

import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年04月16日 9:39
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h1 = sc.nextInt();
        int m1 = sc.nextInt();
        int h2 = sc.nextInt();
        int m2 = sc.nextInt();
        int res = 0;
        if (m1 <= m2) {
            res = (h2 - h1) * 60 + (m2 - m1);
        } else {
            res = (h2 - h1 - 1) * 60 + (60 - m1 + m2);
        }
        System.out.println(res);
    }
}
