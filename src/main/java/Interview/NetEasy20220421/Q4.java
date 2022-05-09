package Interview.NetEasy20220421;

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int h = sc.nextInt();
        boolean[] painted = new boolean[n * m * h];
        int k = sc.nextInt();
        int[][] op = new int[k][3];
        for (int i = 0; i < k; i++) {
            op[i][0] = sc.nextInt();
            op[i][1] = sc.nextInt();
            op[i][2] = sc.nextInt();
            System.out.println(func(n, m, h, op[i], painted));
        }


    }

    private static int func(int n, int m, int h, int[] op, boolean[] painted) {

        return 1;
    }
}
