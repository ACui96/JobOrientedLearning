//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 👍 1024 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P47_PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new P47_PermutationsIi ().new Solution();
        // TO TEST
    }
    //Java：全排列 II
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> ret = new ArrayList<>();
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            boolean[] visited = new boolean[nums.length];
            List<Integer> path = new ArrayList<>();
            backtracking(nums, path, visited);
            return  ret;
        }

        private void backtracking(int[] nums, List<Integer> path, boolean[] visited) {
            if (path.size() == nums.length) {
                ret.add(new ArrayList<>(path));
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }
                if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {//剪枝
                    continue;
                }
                visited[i] = true;
                path.add(nums[i]);
                backtracking(nums, path, visited);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

