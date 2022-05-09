package Interview.MeiTuan20220416;

import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年04月16日 10:36
 */
public class Q4_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int res = 0;
        if (x == y) {
            res = 0;
        } else if (x < y) {
            while (y >= 2 * x) {
                y /= 2;
                res++;
            }
            res += y - x;
        }else {
            while (x >= 2 * y) {
                x /= 2;
                res++;
            }
            res += x - y;
        }
        System.out.println(res);
    }
}
