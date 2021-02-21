//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 306 👎 0


package leetcode.editor.cn;

//字符串的排列

import java.util.Arrays;

public class P567_PermutationInString{
    //测试代码
    public static void main(String[] args) {
        Solution solution = new P567_PermutationInString().new Solution();
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean ret = solution.checkInclusion(s1, s2);
        System.out.println(ret);
    }
        
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if(len1 > len2) return false;
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        for(int i = 0; i < len1; i++){
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if(Arrays.equals(cnt1, cnt2)) return true;
        for(int i = len1; i < len2; i++){
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - len1) - 'a'];
            if(Arrays.equals(cnt1, cnt2)){
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}