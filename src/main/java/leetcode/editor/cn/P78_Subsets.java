//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 👍 1373 👎 0


package leetcode.editor.cn;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

public class P78_Subsets {
    public static void main(String[] args) {
        Solution solution = new P78_Subsets ().new Solution();
        // TO TEST
    }
    //Java：子集
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ret = new ArrayList<>();
        public List<List<Integer>> subsets(int[] nums) {

            ArrayList<Integer> tmp = new ArrayList<>();
            for (int size = 0; size < nums.length + 1; size++) { // 不同长度的子集
                dfs(0, nums, tmp, size);
            }
            return ret;
        }

        private void dfs(int index, int[] nums, ArrayList<Integer> tmp, int size) {
            if (index == size) {
                ret.add(new ArrayList<>(tmp));
                return;
            }
            for (int i = index; i < nums.length; i++) {
                tmp.add(nums[i]);
                dfs(i + 1, nums, tmp, size);
                tmp.remove(tmp.size() - 1);

            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}

