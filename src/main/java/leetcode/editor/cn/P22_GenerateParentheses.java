//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1791 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P22_GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22_GenerateParentheses ().new Solution();
        // TO TEST
        List<String> ret = solution.generateParenthesis(2);
        for (String s : ret) {
            System.out.println("s = " + s);
        }
    }
    //Java：括号生成
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> ret = new ArrayList<>();
        public List<String> generateParenthesis(int n) {
            if (n < 0) {
                return ret;
            }
            generete("", n, n);

            return ret;
        }

        private void generete(String s, int left, int right) {
            if (left == 0 && right == 0) {
                ret.add(s);
                return;
            }
            if (left == right) {
                generete(s + '(', left - 1, right);
            } else {
                if (left > 0) {
                    generete(s + '(', left - 1, right);
                }
                generete(s + ')',left, right -1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

