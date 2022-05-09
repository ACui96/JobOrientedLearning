package Interview.MeiTuan20220416;

import java.util.*;

/**
 * @author Acui
 * @date 2022年04月16日 9:39
 * 题目描述：
 * 小美正在调研一个超市的促销情况。这个超市有n种商品，依次标号为1，2，… n，商店提供了若干种优惠券，每一种优惠券由两个参数l和r来描述，表示标号为 l , l+1 ,…, r-1 , r（即从l到r）的这些商品都可以通过此张优惠券享受优惠。
 *
 * 小美想要知道有多少种商品可以用至少两种优惠券进行优惠购买。
 *
 * 第一行两个正整数n和m，分别表示商品数量以及优惠券种类数。
 *
 * 第二行m个数 L[1,2,…m]，L[i]表示第 i 种优惠券的参数中的 l 值
 *
 * 第三行m个数 R[1,2,…m]，R[i]表示第 i 种优惠券的参数中的 r 值
 *
 * 数字间两两有空格隔开
 *
 * 可能存在两种优惠券参数相同，仍然算作两种。
 *
 * n,m<=100000
 *
 * 1<=L[i],R[i]<=n
 * 输出一行一个整数表示有多少种商品可以用至少两种优惠券进行优惠。
 *
 * 5 3
 * 1 2 3
 * 2 3 5
 *
 * 2
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 商品
        int m = sc.nextInt();//优惠卷

        int[][] range = new int[m][2];
        for (int i = 0; i < m; i++) {
            range[i][0] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            range[i][1] = sc.nextInt();
        }
        Arrays.sort(range, Comparator.comparingInt((int[] o) -> o[0]));
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int l = range[i][0], r = range[i][1];
            for (int j = l; j <= r; j++) {
                map.put(j, map.getOrDefault(j, 0) + 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(i) && map.get(i) >= 2) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static void func() {

    }
}
