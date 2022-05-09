package 算法.快速幂;

/**
 * 快速幂
 * a ^ n =
 * a^n-1 * a if n is odd
 * a^(n/2) * a^(n/2) if n is even but not 0
 * 1 if n == 0
 *
 * @author Acui
 * @date 2022年04月14日 22:10
 */
public class qpow {

    private final static long MOD = 100000007L;

    /**
     * 注意，这个tmp变量是必要的，因为如果不把tmp记录下来，
     * 直接写成qpow(a, n /2)*qpow(a, n /2)，那会计算两次qpow(a, n /2)，整个算法就退化为了 O(n) 。
     * @author Acui
     * @date 2022/4/14 22:15
     * @param a
     * @param n
     * @return int
     */
    public int qpow(int a, int n) {
        if (n == 0) {
            return 1;
        } else if (n % 2 == 0) {
            int tmp = qpow(a, n / 2);
            return tmp * tmp;
        } else {
            return qpow(a, n - 1) * a;
        }
    }

    public int qpow1(int a, int n) {
        int ans = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                ans *= a;
            }
            a *= a;
            n >>= 1;
        }
        return ans;
    }

    public long qpow2(long a, long n) {
        long ans = 1L;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans = ans * a % MOD;
            }
            a = (a * a) % MOD;
            n >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Long.MAX_VALUE = " + Long.MAX_VALUE);
        System.out.println("递归======== = " + new qpow().qpow2(2, 1000));
//        System.out.println("非递归，位运算 = " + new qpow().qpow1(2,100));
    }
}
