//给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。 
//
// 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1, 2, 2, 3, 1]
//输出：2
//解释：
//输入数组的度是2，因为元素1和2的出现频数最大，均为2.
//连续子数组里面拥有相同度的有如下所示:
//[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//最短连续子数组[2, 2]的长度为2，所以返回2.
// 
//
// 示例 2： 
//
// 
//输入：[1,2,2,3,1,4,2]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// nums.length 在1到 50,000 区间范围内。 
// nums[i] 是一个在 0 到 49,999 范围内的整数。 
// 
// Related Topics 数组 
// 👍 252 👎 0


package leetcode.editor.cn;

//数组的度

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class P697_DegreeOfAnArray{
    //测试代码
    public static void main(String[] args) {
        Solution solution = new P697_DegreeOfAnArray().new Solution();
        int[] nums = new int[]{1, 2, 2, 3, 1, 4, 2};
        int len = solution.findShortestSubArray(nums);
        System.out.println(len);
        // 初始化小顶堆
        Queue<Integer> heap = new PriorityQueue<>();

// 元素入堆
        heap.add(1);
        heap.add(4);
        heap.add(2);
        heap.add(6);
        heap.add(8);

// 元素出堆（从小到大）
        heap.poll(); // -> 1
        heap.poll(); // -> 2
        heap.poll(); // -> 4
        heap.poll(); // -> 6
        heap.poll(); // -> 8

    }
        
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        for(int i = 0; i < nums.length; ++i){
            if(map.containsKey(nums[i])){
                map.get(nums[i])[0] ++;
                map.get(nums[i])[2] = i;
            }else{
                map.put(nums[i], new int[]{1, i, i});
            }
        }

        int maxCount = 0, minLen = 0;
        for(Map.Entry<Integer, int[]> entry : map.entrySet()){
            int[] arr = entry.getValue();
            if(maxCount < arr[0]){
                maxCount = arr[0];
                minLen = arr[2] - arr[1] + 1;
            }else if(maxCount == arr[0]){
                if(minLen > arr[2] - arr[1] + 1){
                    minLen = arr[2] - arr[1] +1;
                }
            }
        }
        return minLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}