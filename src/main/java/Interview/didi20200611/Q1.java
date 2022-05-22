package Interview.didi20200611;

import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年06月11日 19:29
 *
 *
 * abcabc
 * 2
 * bca cba
 * bab aca
 *
 *
 * 如样例：abcabc->acbabc->acacac。
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = sc.nextInt();
        String[][] T = new String[n][2];
        for (int i = 0; i < n; i++) {
            T[i][0] = sc.next();
            T[i][1] = sc.next();
        }
        System.out.println(solve(s, T));
    }

    private static String solve(String s, String[][] T) {
        String ret = s;
        for (String[] t : T) {
            ret = ret.replaceAll(t[0], t[1]);
        }
        return ret;
    }

}
