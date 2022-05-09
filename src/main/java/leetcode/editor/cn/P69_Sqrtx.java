//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 619 👎 0


package leetcode.editor.cn;

//x 的平方根

public class P69_Sqrtx{
    //测试代码
    public static void main(String[] args) {
        Solution solution = new P69_Sqrtx().new Solution();
    }
        
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            if (x <= 1) {
                return x;
            }
            int lo = 1, hi = x;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                int sqrt = x / mid;
                if (sqrt == mid) {
                    return mid;
                } else if (sqrt > mid) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            return hi;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}