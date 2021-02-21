//给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。 
//
// 
//
// 示例： 
//
// 
//输入：[1,12,-5,-6,50,3], k = 4
//输出：12.75
//解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 30,000。 
// 所给数据范围 [-10,000，10,000]。 
// 
// Related Topics 数组 
// 👍 167 👎 0


package leetcode.editor.cn;

//子数组最大平均数 I

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P643_MaximumAverageSubarrayI{
    //测试代码
    public static void main(String[] args) {
        Solution solution = new P643_MaximumAverageSubarrayI().new Solution();
        int[] nums = new int[]{1, 12, -5, -6, 50, 3};
        double ans = solution.findMaxAverage(nums, 4);
        System.out.println(ans);
    }
        
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int len = nums.length;
            List<Double> sums = new ArrayList<>();
            int sum = 0;
            for(int i = 0; i < len; ++i){
                int j = 4;
                while(j > 0){
                    sum += nums[i];
                    j--;
                }
                if(j == 0) sum = 0;
                sums.add((double)(sum / 4));
            }

            return Collections.max(sums);
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}