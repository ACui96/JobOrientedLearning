package BDynamicProgramming;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/99wd55/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class B2TranslateNum {
    public static void main(String[] args) {
        int nums = 18580;
        int res = solution(nums);
        System.out.println(res);
    }

    public static int solution(int nums) {
        String s = String.valueOf(nums);
        int a = 1, b = 1;
        for (int i = 2; i <=s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }
}
