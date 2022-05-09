//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 1944 👎 0


package leetcode.editor.cn;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

public class P46_Permutations {
    public static void main(String[] args) {
        Solution solution = new P46_Permutations ().new Solution();
        // TO TEST
        List<List<Integer>> lists = solution.permute(new int[]{1, 2, 3});
        for (List<Integer> list:lists
             ) {
            System.out.println(list);
        }
    }
    //Java：全排列
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        private List<List<Integer>> ret = new ArrayList<>();
        public List<List<Integer>> permute(int[] nums) {
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

