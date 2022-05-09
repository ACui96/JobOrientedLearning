package Interview.NetEasy20220416;


import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = n + 1, end = 3 * n;
        int startM = 2, endM = 4 * n - 1;
        for (int i = 1; i < 4 * n + 1; ++i) {
            if (i <= n) { // 前 n 行
                for (int j = 1; j < 4 * n + 1; j++) {
                    if (j >= start && j <= end) {
                        System.out.print("*");
                    } else {
                        System.out.print(".");
                        if (j == 4 * n) {
                            System.out.println("");
                        }
                    }
                }
                start = start - 1;
                end = end + 1;

            } else if (i > n && i < 3*n + 1) {
                for (int j = 1; j < 4 * n + 1; j++) {
                    if (j >= n + 1 && j <= 3 * n) {
                        System.out.print(".");
                    } else {
                        System.out.print("*");
                        if (j == 4 * n) {
                            System.out.println("");
                        }
                    }
                }
            } else {
                for (int j = 1; j < 4 * n + 1; j++) {
                    if (j >= startM && j <= endM) {
                        System.out.print("*");
                    } else {
                        System.out.print(".");
                        if (j == 4 * n) {
                            System.out.println("");
                        }
                    }
                }
                startM = startM + 1;
                endM = endM - 1;
            }
        }
    }

}
