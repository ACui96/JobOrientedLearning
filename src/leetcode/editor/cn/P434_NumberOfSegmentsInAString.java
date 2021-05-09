//统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。 
//
// 请注意，你可以假定字符串里不包括任何不可打印的字符。 
//
// 示例: 
//
// 输入: "Hello, my name is John"
//输出: 5
//解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
// 
// Related Topics 字符串 
// 👍 85 👎 0


package leetcode.editor.cn;

public class P434_NumberOfSegmentsInAString {
    public static void main(String[] args) {
        Solution solution = new P434_NumberOfSegmentsInAString ().new Solution();
        // TO TEST
        String s = "    a b c  ";
        s = s.trim();
        System.out.println(s);
        for (String s1 : s.split("\\s+")) {
            System.out.println(s1);
        }
    }
    //Java：字符串中的单词数
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSegments(String s) {
            String s1 = s.trim();
            if (s1.equals("")) {
                return 0;
            }
            return s1.split("\\s+").length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

