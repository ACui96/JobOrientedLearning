//给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[
//j]) 都应当满足：
// 
// answer[i] % answer[j] == 0 ，或 
// answer[j] % answer[i] == 0 
// 
//
// 如果存在多个有效解子集，返回其中任何一个均可。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,2]
//解释：[1,3] 也会被视为正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,4,8]
//输出：[1,2,4,8]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 2 * 109 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数学 动态规划 
// 👍 226 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P368_LargestDivisibleSubset {
    public static void main(String[] args) {
        Solution solution = new P368_LargestDivisibleSubset ().new Solution();
        // TO TEST
        List<Integer> ret = solution.largestDivisibleSubset(new int[]{1, 2, 3});
        System.out.println(ret);
    }
    //Java：最大整除子集
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxsize = 1;
        int maxVal = dp[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxsize) {
                maxsize = dp[i];
                maxVal = nums[i];
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        if (maxsize == 1) {
            res.add(nums[0]);
            return res;
        }
        for (int i = n - 1; i >= 0 && maxsize > 0; i--) {
            if (dp[i] == maxsize && maxVal % nums[i] == 0) {
                res.add(nums[i]);
                maxVal = nums[i];
                maxsize--;
            }

        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

