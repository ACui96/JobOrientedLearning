package Interview.NetEasy20220416;

import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年04月16日 16:11
 */
public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(my_func(nums));

    }

    private static int my_func(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int sum = 1;
                for (int m = i; m <= j; m++) {
                    sum *= nums[m];
                }
                num += helper(sum);
            }
        }
        return num;
    }

    private static int helper(int num) {
        int cnt = 0;
        while (num % 10 == 0) {
            cnt++;
            num /= 10;
        }
        return cnt;
    }
}
