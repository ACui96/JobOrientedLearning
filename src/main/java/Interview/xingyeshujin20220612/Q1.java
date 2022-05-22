package Interview.xingyeshujin20220612;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Acui
 * @date 2022年06月12日 19:57
 */
public class Q1 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }
    public static int lengthOfLongestSubstring (String s) {
        // write code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            res = Math.max(res, i - left + 1);
            map.put(s.charAt(i), i);
        }
        return res;

    }
}
