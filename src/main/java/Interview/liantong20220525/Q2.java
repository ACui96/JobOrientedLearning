package Interview.liantong20220525;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年05月25日 16:03
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next().toLowerCase();
        String s2 = sc.next().toLowerCase();
        System.out.println(find(s1, s2));

    }

    private static String find(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return "result=?";
        }
        int[] h1 = new int[26], h2 = new int[26];
        for (char c : s1.toCharArray()) {
            h1[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            h2[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (h1[i] != 0 && h2[i] != 0) {
                sb.append((char)(i + 'a'));
            }
        }
        return sb.length() == 0 ? "result=?" : sb.toString();
    }



}
