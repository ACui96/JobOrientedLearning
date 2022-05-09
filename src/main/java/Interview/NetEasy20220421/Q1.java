package Interview.NetEasy20220421;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        func(n);
    }

    private static void func(int n) {
        int side = n * 2 - 1;
        int lr = 2, rr = 2 * n - 2;
        int ll = n - 1, rl = n + 1;
        for (int i = 1; i <= side; i++) {
            if (i == n) { // 中间行
                for (int j = 1; j <= side; j++) {
                    System.out.printf("*");
                }
            }
            if (i >= 1 && i < n) { // 上

                if (i == 1) {
                    for (int j = 1; j <= side; j++) {
                        if (j == 1 || j >= n) {
                            System.out.printf("*");
                        }else {
                            System.out.printf(" ");
                        }
                    }
                } else {
                    for (int j = 1; j <= side; j++) {
                        if (j == 1 || j == n || j == lr || j == rr) {
                            System.out.printf("*");
                        } else {
                            System.out.printf(" ");
                        }
                    }
                    lr++;
                    rr--;
                }

            }
            if (i > n && i <= side) { // 下

                if (i == side) {
                    for (int j = 1; j <= side; j++) {
                        if (j == side || j <=n) {
                            System.out.printf("*");
                        }else {
                            System.out.printf(" ");
                        }
                    }
                } else {
                    for (int j = 1; j <= side; j++) {
                        if (j == n || j == side || j == ll || j == rl) {
                            System.out.printf("*");
                        } else {
                            System.out.printf(" ");
                        }
                    }
                    ll--;
                    rl++;
                }
            }
            System.out.println();
        }
    }
}
