package Interview.DJI20220807;

import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年08月07日 19:39
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] ret = input.split("\\s+");
        int[] nums = new int[ret.length];
        for (int i = 0; i < ret.length; i++) {
            nums[i] = Integer.valueOf(ret[i]);
        }
        int ans = solve(nums);
        System.out.println(ans);
    }
    private static int solve(int[] nums) {
        int pre1 = 0, pre2 = 0;
        for (int num : nums) {
            int cur = Math.max(pre2 + num, pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
