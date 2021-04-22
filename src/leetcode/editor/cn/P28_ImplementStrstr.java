//实现 strStr() 函数。 
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：haystack = "", needle = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 104 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 794 👎 0


package leetcode.editor.cn;
//Java：实现 strStr()
public class P28_ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new P28_ImplementStrstr ().new Solution();
        // TO TEST
        String haystack = "aaaaac", needle = "c";
        int ret = solution.strStr(haystack, needle);
        System.out.println("结果" + ret);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 朴素
         * @author Acui
         * @date 2021/4/20 9:52
         * @param s 父字符串
         * @param p 匹配字符串
         * @return int 第一次出现下标
         */
        public int strStr(String s, String p) {
            int n = s.length(), m = p.length();
            char[] ss = s.toCharArray(), pp = p.toCharArray();
            for (int i = 0; i + m <=n; i++) {
                int a = i, b = 0;
                while(b < m && ss[a] == pp[b]) {
                    a++;
                    b++;
                }
                if (b == m) {
                    return i;
                }
            }
            return -1;
        }
        /**
         * java String api indexOf
         * @author Acui
         * @date 2021/4/20 9:54
         * @param s
         * @param p
         * @return int
         */
        public int strStr1(String s, String p) {
            return s.indexOf(p);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

