package Interview.huawei20220410;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Acui
 * @date 2022年04月10日 14:54
 */
public class Q1 {
    public static void main(String[] args) {
//        System.out.println('a' - '0');
//        System.out.println('b' - '0');
        System.out.println(Integer.valueOf('a')-97);
        System.out.println(Integer.valueOf('b')-97);
        System.out.println((char)('a' + 1));

        String s = "abc";
        s.startsWith("a", 1);

        Set<Integer> set = new TreeSet<>((o1, o2) -> o1 - o2);

    }

    public static String func(String s) {
        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < 26; i++) {
//            map.put(,i);
//        }

        for (char c : s.toCharArray()) {

        }
        return  "";

    }
}
