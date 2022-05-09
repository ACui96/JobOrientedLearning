package Interview.kuaishou360tencent20220424.sanliuling;


import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] gift = new int[n][m + 1];
        int[][] sum = new int[n][m + 1];
        for (int r = 0; r < n; r++) {

            for (int c = 0; c < m; c++) {
                gift[r][c] = sc.nextInt();
                gift[r][m] = Math.max(gift[r][m], gift[r][c]);
                for (int i = 0; i < r; i++) {
                    if (r != 0) {
                        sum[r][c] +=gift[i][c - 1];

                    } else {
                        sum[r][c] +=gift[i][c];
                    }
                    sum[r][m] = Math.max(sum[r][m], sum[r][c]);

                }

            }
        }
        System.out.println(func(n, m, gift, sum));
    }

    private static int func(int n, int m,  int[][] gift,int[][] sum) {
        if (n <= 7) {
            return sum[n - 1][m] + 1;
        }

//        int[] dp = new int[n];
//        int start = 0;
//        int[] max = new int[n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; )
//        }
//
//
//        return dp[dp.length - 1];
        return 0;
    }

}
