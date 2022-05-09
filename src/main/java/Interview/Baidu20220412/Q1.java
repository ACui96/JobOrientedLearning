package Interview.Baidu20220412;

import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年04月12日 19:49
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int x = 0, y = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'L':
                    x--;
                    continue;
                case 'R':
                    x++;
                    continue;
                case 'U':
                    y++;
                    continue;
                case 'D':
                    y--;
                    continue;
            }
        }
        System.out.print("(" + x + "," + y + ")");
    }

}
