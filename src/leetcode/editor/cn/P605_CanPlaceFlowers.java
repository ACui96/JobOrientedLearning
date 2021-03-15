//假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。 
//
// 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则
//的情况下种入 n 朵花？能则返回 true ，不能则返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：flowerbed = [1,0,0,0,1], n = 1
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：flowerbed = [1,0,0,0,1], n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= flowerbed.length <= 2 * 104 
// flowerbed[i] 为 0 或 1 
// flowerbed 中不存在相邻的两朵花 
// 0 <= n <= flowerbed.length 
// 
// Related Topics 贪心算法 数组 
// 👍 301 👎 0


package leetcode.editor.cn;

//种花问题

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P605_CanPlaceFlowers{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P605_CanPlaceFlowers().new Solution();
         boolean b = solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1);

         System.out.println(b);
	 }
    //力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int len = flowerbed.length;
            int cnt = 0;
            for (int i = 0; i < len && cnt < n; i++) {
                if (flowerbed[i] == 1) {
                    continue;
                }
                int pre = i == 0 ? 0 : flowerbed[i - 1];
                int next = i == len - 1 ? 0 : flowerbed[i + 1];
                if (pre == 0 && next == 0) {
                    cnt++;
                    flowerbed[i] = 1;
                }
            }
            return cnt >= n;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}