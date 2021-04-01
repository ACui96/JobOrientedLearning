//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
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
// 
// 
// 
// Related Topics 数组 回溯算法 
// 👍 441 👎 0


package leetcode.editor.cn;

//子集 II

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P90_SubsetsIi{
    //测试代码
    public static void main(String[] args) {
        Solution solution = new P90_SubsetsIi().new Solution();
        int[] nums = {1, 2, 2, 3};
        List<List<Integer>> lists = solution.subsetsWithDup(nums);
        for (List<Integer> list : lists) {
            System.out.println('[');
            for (Integer i : list) {
                System.out.print(String.valueOf(i) + ']');
            }
        }
    }
        
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> t = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            dfs(false, 0, nums);
            return ret;
        }

        public void dfs(boolean chosenPre, int cur, int[] nums) {
            if(cur == nums.length) {
                ret.add(new ArrayList<>(t));
                return;
            }
            dfs(false, cur + 1, nums);
            if(!chosenPre && cur > 0 && nums[cur] == nums[cur - 1]) return;
            t.add(nums[cur]);
            dfs(true, cur + 1, nums);
            t.remove(t.size() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}