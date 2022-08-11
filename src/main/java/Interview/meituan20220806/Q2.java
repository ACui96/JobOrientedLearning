package Interview.meituan20220806;

import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年08月06日 10:07
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
//        int[] nums = new int[]{0, -1, 1, 1, -1};

        System.out.println(solve(nums));
    }

    private static int solve(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int sumLeft = 0, sumRight = 0;
        for (int i = 0; i < n; i++) {
            int diff = sumRight - sumLeft;
            sumLeft += nums[i];
            sumRight = 0;
            for (int j = i + 1; j < n; j++) {
                sumRight += nums[j];
            }
            if (sumRight - sumLeft > diff) {
                int leftError = 0, rightError = 0;
                for (int k = 0; k < i; k++) {
                    if (nums[k] == 1 || nums[k] == 0) {
                        leftError++;
                    }
                }
                for (int h = i + 1; h < n; h++) {
                    if (nums[h] == -1 || nums[h] == 0) {
                        rightError++;
                    }
                }
                ans = Math.min(ans, leftError + rightError);
            }
        }

        return ans;
    }
}
