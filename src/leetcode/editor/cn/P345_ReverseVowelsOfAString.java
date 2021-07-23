//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 
// 
// Related Topics 双指针 字符串 
// 👍 148 👎 0


package leetcode.editor.cn;

//反转字符串中的元音字母

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P345_ReverseVowelsOfAString{

    //测试代码
    public static void main(String[] args) {
        Solution1 solution = new P345_ReverseVowelsOfAString().new Solution1();
        String s = "hello";
        String ret = solution.reverseVowels(s);
        System.out.println(ret);

    }




    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final HashSet<Character> vowels= new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        public String reverseVowels(String s) {
            if (s == null) return null;
            int i = 0, j = s.length() - 1;
            char[] ret = new char[s.length()];
            while (i <= j) {
                char ci = s.charAt(i);
                char cj = s.charAt(j);
                if (!vowels.contains(ci)) {
                    ret[i++] = ci;
                } else if (!vowels.contains(cj)) {
                    ret[j--] = cj;
                } else {
                    ret[i++] = cj;
                    ret[j--] = ci;
                }
            }
            return new String(ret);
        }
    }
    private  final static Set<Character> set = new HashSet<>( Arrays.asList('a', 'e', 'i','o', 'u', 'A', 'E', 'I', 'O', 'U'));
    class Solution1 {
        public String reverseVowels(String s) {
            if (s == null) return null;
            char[] chs = s.toCharArray();
            int i = 0, j = chs.length - 1;
            while (i < j) {
                while (!set.contains(chs[i]) && i < chs.length - 1) i++;
                while (!set.contains(chs[j]) && j > 0) j--;
                if(i < j) {
                    char tmp = chs[i];
                    chs[i] = chs[j];
                    chs[j] = tmp;
                    i++;
                    j--;
                }

            }
            return new String(chs);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}