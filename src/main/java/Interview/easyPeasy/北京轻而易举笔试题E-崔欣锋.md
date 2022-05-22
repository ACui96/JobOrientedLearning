```java
import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年05月10日
 * 北京轻而易举笔试题E
 * 一、查数字个数
 * 描述：
 * 给定一个整数n，计算所有小于等于n 的非负整数中数字1 出现的个数。
 * 示例1
 * 输入：n = 13
 * 输出：6
 * 示例2
 * 输入：n = 0
 * 输出：0
 * 提示：0 <= n <= 1000000000
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(count(n));
    }

    private static int count(int n) {
        if (n < 10) {
            return n == 0 ? 0 : 1;
        }
        String s = String.valueOf(n);
        int m = s.length();
        int[] pre = new int[m], suf = new int[m];
        suf[0] = Integer.parseInt(s.substring(1));
        for (int i = 1; i < m - 1; i++) {
            pre[i] = Integer.parseInt(s.substring(0, i));
            suf[i] = Integer.parseInt(s.substring(i + 1));
        }
        pre[m - 1] = Integer.parseInt(s.substring(0, m - 1));

        int res = 0;
        for (int i = 0; i < m; i++) {
            int cur = s.charAt(i) - '0', len = m - i - 1;
            int cnt_cur = 0;
            int prefix = pre[i], suffix = suf[i];
            cnt_cur += prefix * Math.pow(10, len);
            // 0： 无 1： suffix + 1    > 1 : pow(10, len)
            if (cur == 1) {
                cnt_cur += suffix + 1;
            } else if (cur > 1) {
                cnt_cur += Math.pow(10, len);
            }
            res += cnt_cur;
        }
        return res;
    }

}
```
```java
import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年05月10日
 * 二、查字符串个数
 * 描述：
 * 给定一个字符串s 和一个字符串t，计算在s 的子序列中t 出现的个数。
 * 字符串的一个子序列是指，通过删除一些（也可以不删除）字符，且不干扰剩余字符的相对
 * 位置所组成的新字符串。（例如，“ACE”是“ABCDE”的一个子序列，而“AEC”不是）
 * 示例1
 * 输入：s = “rabbbit”，t = “rabbit”
 * 输出：3
 * 解释：如下所示，有3 种可以从s 中得到“rabbit”的方案。
 * rabbbit
 * rabbbit
 * rabbbit
 * 示例2
 * 输入：s = “babgbag”，t = “bag”
 * 输出：5
 * 解释：如下所示，有5 种可以从s 中得到“bag”的方案。
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * 提示1：0 <= s.length, t.length <= 1000
 * 提示2：s 和t 由英文字母组成
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(), t = sc.next();
        System.out.println(find(s, t));
    }

    private static int find(String s, String t) {
        int m = s.length(), n = t.length();
        if(m < n) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1]; // dp[i][j] 表示 s[:i] 中 t[:j] 的个数
        // 边界
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = 1;
        }
        //状态转移
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
```
