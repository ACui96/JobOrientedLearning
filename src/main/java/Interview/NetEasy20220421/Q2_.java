package Interview.NetEasy20220421;

import java.util.Arrays;

/**
 * @author Acui
 * @date 2022年04月21日 20:53
 */
public class Q2_ {
    public static void main(String[] args) {
        System.out.println(func(new int[]{2, 5, 3, 4}, 4, 3));
        int _val2 = 1;
//        int final = 2;
//        int val3& =
//        int 1var1 = 1;
        String a = "sss";

    }

    private static int func(int[] nums, int max, int x) {
        int ret = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int yushu = sum % x;
        for (int num : nums) {
            int tmp = num;
            while (tmp - yushu > 0 ) {
                tmp -= yushu;
                if (tmp - yushu < max) {
                    ret++;
                }
            }
        }
        return ret;
    }
}
