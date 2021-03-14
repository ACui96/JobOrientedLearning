//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2219 👎 0


package leetcode.editor.cn;

//有效的括号

import java.util.ArrayDeque;
import java.util.Deque;

public class P20_ValidParentheses{
    //测试代码
    public static void main(String[] args) {
        Solution solution = new P20_ValidParentheses().new Solution();
        String s = "({[)";
        boolean ret = solution.isValid(s);
        System.out.println(ret);


    }
        
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()) {
            if(!stack.isEmpty()) {
                char insideChar = stack.peek();
                if((insideChar == '(' && c == ')') || (insideChar == '[' && c == ']') || (insideChar == '{' && c == '}')) {
                    stack.removeLast();
                } else {
                    stack.addLast(c);
                }
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}