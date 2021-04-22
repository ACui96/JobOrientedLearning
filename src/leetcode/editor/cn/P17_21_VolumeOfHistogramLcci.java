//给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marco
//s 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针 
// 👍 77 👎 0


package leetcode.editor.cn;
//Java：直方图的水量
public class P17_21_VolumeOfHistogramLcci {
    public static void main(String[] args) {
        Solution solution = new P17_21_VolumeOfHistogramLcci ().new Solution();
        // TO TEST
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(height));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int ans = 0;
            int left = 0, right = height.length - 1;
            int leftMax = 0, rightMax = 0;
            while (left < right) {
                leftMax = Math.max(height[left], leftMax);
                rightMax = Math.max(height[right], rightMax);
                if (height[left] < height[right]) {
                    ans += leftMax - height[left];
                    left++;
                } else if (height[left] >= height[right]) {
                    ans += rightMax - height[right];
                    right--;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

