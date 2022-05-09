package Interview;

import java.math.BigDecimal;

/**
 * @author Acui
 * @date 2022年04月14日 21:18
 */
import java.util.*;
public class chufa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long d = sc.nextLong();
        long n = sc.nextLong();
        long a = 10, b = d - 1;
        long res = 1;

        while (b > 0) { // 快速幂
            if ((b & 1) == 1) {
                res = res * a % x;
            }
            a = a * a % x;
            b >>= 1;
        }
        for (long i = d; i < n + d; ++i) {
            res *= 10;
            System.out.print(res / x);
            res %= x;
        }
    }
}