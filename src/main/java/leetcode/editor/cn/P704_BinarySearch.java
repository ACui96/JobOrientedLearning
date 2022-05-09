//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 
//示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
// Related Topics 二分查找 
// 👍 196 👎 0


package leetcode.editor.cn;

//二分查找

import java.util.*;

public class P704_BinarySearch{
    //测试代码
    public static void main(String[] args) {
//        Solution solution = new P704_BinarySearch().new Solution();
//        int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int target = 6;
//        int i = solution.search(nums, target);
//        System.out.println(i);
//        String s = "string";
//        char c = 'r';
//        String[] strings = s.split(String.valueOf(c));
//        for (String string : strings) {
//            System.out.println(string);
//        }
        int[][] env = new int[3][3];
        Arrays.sort(env, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1 != o2) {
                    return o1[0] - o2[0];
                }else{
                    return o2[1] - o1[1];
                }
            }
        });
        List<Integer> f = new ArrayList<>();
        Object key;
        int index = Collections.binarySearch(f, 1);
    }
        
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while(left < right){
            System.out.println("[" + left + "," + right + "]");
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else{
                right = mid;
            }
        }
        if(nums[left] == target) return left;
        return -1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}