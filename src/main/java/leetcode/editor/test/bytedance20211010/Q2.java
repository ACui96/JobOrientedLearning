package leetcode.editor.test.bytedance20211010;

/**
 * @author Acui
 * @date 2021年10月10日 10:49
 */
public class Q2 {
    public static void main(String[] args) {
        System.out.println(new Solution().cntOfNum(123));
    }
    static class Solution {
        private static int[] num = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6}; //0-9需要多少根火柴棒
        private int maxInt(int n) {

            return -1;
        }

        // 输入一个数，计算需要多少火柴棒
        private int cntOfNum(int x) {

            if (x == 0) {
                return 6;
            }
            int c = 0;
            while (x > 0){
                int digit = x % 10;
                c += num[digit];
                x = (int) (x / 10);
            }
            return c;
        }
}




}
