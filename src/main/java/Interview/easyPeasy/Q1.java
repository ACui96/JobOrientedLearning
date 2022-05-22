package Interview.easyPeasy;

import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年05月10日 19:32
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
