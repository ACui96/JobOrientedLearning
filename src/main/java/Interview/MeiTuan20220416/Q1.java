package Interview.MeiTuan20220416;

import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年04月16日 9:39
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner reader=new Scanner(System.in);
        String s = reader.nextLine();
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                ans++;
            }
        }
        System.out.println(ans);

    }

}
