package Interview.Baidu20220412;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年04月12日 20:09
 */
public class Q2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int[] prices = new int[N], plus = new int[N];
//
//        for (int i = 0; i < N; i++) {
//            prices[i] = sc.nextInt();
//            plus[i] = sc.nextInt();
//        }

        int ret = minCost(new int[]{6, 2, 4}, new int[]{8, 9, 7});
        System.out.println(ret);
    }
    //最小花费
    public static int minCost(int[] prices, int[] plus) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int N = prices.length;
        int days = 0, buy = 0;
        while (buy < N) {
            if (days % 2 != 0) {
                buy += 2;
            } else {
                buy += 1;
            }
            days++;
        }
        System.out.println(days);
        int min = 0;
        boolean[] bought = new boolean[N];


        for (int i = 0; i < days; i++) {
            int[] pricesI = new int[N];

            int minIdx = 0, maxIdx = 0;

            //已购买
            int minI = Integer.MAX_VALUE, maxI = Integer.MIN_VALUE;
            for (int j = 0; j < N; j++) {

                pricesI[j] = prices[j] + plus[j] * i;
                if (pricesI[j] < minI && !bought[j]) {
                    minI = pricesI[j];
                    minIdx = j;
                }
                if (pricesI[j] > maxI && !bought[j]) {
                    maxI = pricesI[j];
                    maxIdx = j;
                }
            }
            min = min + minI;
            if (i % 2 != 0) {
                bought[minIdx] = true;
                bought[maxIdx] = true;
            } else {
                bought[minIdx] = true;
            }


        }

        return min;
    }
}
