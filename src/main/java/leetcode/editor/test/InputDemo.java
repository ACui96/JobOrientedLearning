package leetcode.editor.test;

import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年03月10日 14:42
 */
public class InputDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int full = sc.nextInt();
            int avg = sc.nextInt();
            int[][] nums = new int[n][2];
            for (int i = 0; i < n; i++) {
                nums[i][0] = sc.nextInt();
                nums[i][1] = sc.nextInt();
            }
            System.out.println("" + n + "\t" + full + "\t" + avg + "\t");

        }


    }
}
