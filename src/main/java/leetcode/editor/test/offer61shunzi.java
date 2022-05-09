package leetcode.editor.test;

import java.util.Arrays;

/**
 * @author Acui
 * @date 2021年06月18日 15:08
 */
public class offer61shunzi {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 2, 5};
        Solution solution = new offer61shunzi(). new Solution();
        boolean straight = solution.isStraight(nums);
        System.out.println(straight);
    }

    class Solution {
        public boolean isStraight(int[] nums) {
            Arrays.sort(nums);
            int joker = 0;
            for (int i = 0; i < 5; i++) {
                if (nums[i] == 0) {
                    joker++;
                    continue;
                } else if ( i > 0 && nums[i] == nums[i - 1]) {
                    return false;
                }
            }
            return nums[4] - nums[joker] < 5;
        }
    }
}
