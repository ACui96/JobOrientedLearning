package Interview.NetEasy20220421;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt(); //最大值
        int x = sc.nextInt(); //和
        int ret = 0;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        for (int i = 1; i < n; ++i) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
        int tmp = nums[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                ret += func(dp, nums, i, p, x);
            } else {
                dp[i] += tmp;
                tmp += nums[i];
                ret += func(dp, nums, i, p, x);
            }
        }
        System.out.println(ret);
    }

    private static int func(int[] dp, int[] nums, int i, int max, int sum) {
        int ret = 0;
        if (dp[i] % sum == 0) {
            for (int j = sum; j <= max; j += sum) {
                if (j == nums[i]) {
                    continue;
                } else {
                    ret++;
                }
            }
        } else {
            int t = sum - (dp[i] % sum);
            for (int j = t; j <= max; j += sum) {
                if (j == nums[i]) {
                    continue;
                } else {
                    ret++;
                }
            }
        }
        return ret;
    }


}
