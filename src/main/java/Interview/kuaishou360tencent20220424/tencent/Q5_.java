package Interview.kuaishou360tencent20220424.tencent;

import java.util.Arrays;
import java.util.Scanner;

public class Q5_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int prices[] = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        long dp[][] = new long[n][n];//dp[i][j] 表示在第i天拥有j注股票的最大资产 ,n天最多n-1支股票
        Arrays.fill(dp[0], -1);
        dp[0][0] = m;//第0天 0注股票拥有m元
        if (m >= prices[0]) {
            dp[0][1] = m - prices[0];
        }
        for (int i = 1; i < n; i++) {
            //两种情况
            //一是买入一注
            //一是卖出一注
            //一个是啥也不干
            for (int j = 0; j < n; j++) {
                //啥也不干
                dp[i][j] = dp[i - 1][j];
                //买入一注 并且金额足够
                if (j > 0) {
                    if (dp[i - 1][j - 1] != -1 && dp[i - 1][j - 1] >= prices[i]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] - prices[i]);
                    }
                }
                //卖出一注
                if (j < n - 1) {
                    if (dp[i - 1][j + 1] != -1) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + 1] + prices[i]);
                    }
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (dp[n - 1][i] == -1) continue;
            ans = Math.max(ans, dp[n - 1][i] + i * prices[n - 1]);
        }
        print(dp);
        System.out.println(ans);
    }

    public static void print(long[][] dp) {
        int n = dp.length;
        System.out.print("\t\t");
        for (int i = 0; i < n; i++) {
            System.out.print("d" + i + "\t");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(i + "注股票\t");
            for (int j = 0; j < n; j++) {
                System.out.print(dp[j][i] + "\t");
            }
            System.out.println();
        }
    }
}
