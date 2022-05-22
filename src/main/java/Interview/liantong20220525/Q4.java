package Interview.liantong20220525;

import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年05月25日 17:02
 */
public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] rank = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            rank[i] = sc.nextInt();
        }
        int testNum = sc.nextInt();
        for (int i = 0; i < testNum; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int k = sc.nextInt();

            int count = 0;
            for (int j = l; j < r; j++) {
                if (rank[j] == k) {
                    count++;
                }
            }
            System.out.println(count);
//            System.out.println(find(rank, l, r, k));
        }
        sc.close();
    }

    private static int find(int[] rank, int l, int r, int k) {

        return 0;
    }
}
