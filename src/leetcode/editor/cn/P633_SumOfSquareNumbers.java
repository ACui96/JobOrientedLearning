//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。 
//
// 
//
// 示例 1： 
//
// 输入：c = 5
//输出：true
//解释：1 * 1 + 2 * 2 = 5
// 
//
// 示例 2： 
//
// 输入：c = 3
//输出：false
// 
//
// 示例 3： 
//
// 输入：c = 4
//输出：true
// 
//
// 示例 4： 
//
// 输入：c = 2
//输出：true
// 
//
// 示例 5： 
//
// 输入：c = 1
//输出：true 
//
// 
//
// 提示： 
//
// 
// 0 <= c <= 231 - 1 
// 
// Related Topics 数学 
// 👍 167 👎 0


package leetcode.editor.cn;

//平方数之和

public class P633_SumOfSquareNumbers{
    //测试代码
    public static void main(String[] args) {
        Solution solution = new P633_SumOfSquareNumbers().new Solution();
        boolean ret = solution.judgeSquareSum(2);
        System.out.println(ret);
    }
        
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgeSquareSum(int c) {
            //0~c
            if (c < 0) {
                return false;
            }
            int i = 0, j = (int) Math.sqrt(c);
            while (i <= j) {
                int powSum = i * i + j * j;
                if (powSum == c) {
                    return true;
                } else if (powSum < c) {
                    i++;
                } else {
                    j--;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}