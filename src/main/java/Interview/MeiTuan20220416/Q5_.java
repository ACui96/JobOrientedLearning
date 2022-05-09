package Interview.MeiTuan20220416;

import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年04月16日 11:49
 */
public class Q5_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n + 1];
        p[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            p[i] = sc.nextInt();
        }
        int[] c = new int[n + 1];
        for (int i = 1; i < n + 1; ++i) {
            c[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] u = new int[m + 1];
        for (int i = 1; i < m + 1; i++) {
            u[i] = sc.nextInt();
        }
        int[] v = new int[m + 1];
        for (int i = 1; i < m + 1; i++) {
            v[i] = sc.nextInt();
        }
        for (int i = 1; i < m + 1; ++i) {
            int start = u[i];
            int end = v[i];
            int res = c[start];
            while (start != end) {
                if (start < end) {
                    res ^= c[end];
                    end = p[end];
                } else {
                    start = p[start];
                    res ^= c[start];
                }
            }
            System.out.print(res + " ");
        }
    }
}
