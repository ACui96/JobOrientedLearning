package Interview.meituan20220806;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年08月06日 11:46
 */
public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] queries = new int[T];
        for (int i = 0; i < T; i++) {
            queries[i] = sc.nextInt();
        }
        List<Character> ans = solve(queries);
        for (Character c : ans) {
            System.out.println(c);
        }
    }

    private static List<Character> solve(int[] queries) {
        List<Character> ans = new ArrayList<>();
        String origin = "MeiTuan";
        for (int i = 0; i < 10; i++) {
            origin = func(origin);
        }
        for (int q : queries) {
            ans.add(origin.charAt(q));
        }
        return ans;
    }

    private static String func(String s) {
        return s + reverse(s) + "wow";
    }

    private static String reverse(String str) {
        String result="";
        for(int i=str.length()-1;i>=0;i--){
            result+=str.charAt(i);
        }
        return result;
    }
}
