package leetcode.editor.test.bytedance20211010;

/**
 * @author Acui
 * @date 2021年10月10日 10:28
 */
public class Q3 {
    public static void main(String[] args) {
        int[] a = {5, 3, 4, 1, 2};
        int[] b = {0, 6, 7, 9, 8};
        int k = 1;


        System.out.println(new Solution().minValue(a, b, k));
        System.out.println(new Solution().minValue(a, b, 0));

    }

    static class Solution {
        private int minValue(int[] a, int[] b, int k) {
            int min = Integer.MAX_VALUE;
            for (int ai : a) {
                for (int bj : b) {
                    int tmp1 = ai - bj + k;
                    int tmp2 = ai - bj - k;
                    int ret = tmp1 * tmp2;
                    min = Math.min(ret, min);
                }
            }
            return min;
        }
    }
}
