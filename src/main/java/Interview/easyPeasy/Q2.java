package Interview.easyPeasy;

import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年05月10日 20:12
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
