//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
// 👍 289 👎 0


package leetcode.editor.cn;

public class P557_ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new P557_ReverseWordsInAStringIii ().new Solution();
        // TO TEST
        String s = "Let's take LeetCode contest";
        System.out.println(solution.reverseWords(s));
    }
    //Java：反转字符串中的单词 III
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }
            String[] words = s.split("\\s+");
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                char[] chars = word.toCharArray();
                int i = 0, j = word.length() - 1;
                while (i < j) {
                    char tmp = chars[i];
                    chars[i++] = chars[j];
                    chars[j--] = tmp;
                }
                sb.append(new String(chars));
                sb.append(" ");
            }
            sb.delete(sb.length() - 1, sb.length());
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

