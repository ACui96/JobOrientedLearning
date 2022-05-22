package Interview.EA20220512;

import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年05月12日 19:02
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }

        System.out.println(minMovement(a, sum));
    }

    /**
     * n 个 盒子， 初始状态： 每个盒子里有 ai 个糖果 (至少有一个 ai 为正数)，
     * 移动糖果（每秒移动一个糖果，只能往两边盒子移动）
     * 使最终存在一个大于 1 的整数 k, 除了有 0 个糖果的盒子，其它盒子里的糖果数都能整除 k
     * 问最少的移动次数
     * 示例
     * 3
     * 1 0 1
     * 过程： 1 0 1 -> 0 1 1 -> 0 2 0  输出 2
     * 移动了 2 次，此时 k = 2
     */
    private static int minMovement(int[] target, int sum) {
        int ans = -1;
        if (sum <= 1) {
            return ans;
        }
        int n = target.length;
        ans = target[0];
        for (int i = 1; i < n; ++i) {
            ans += Math.max(target[i] - target[i - 1], 0);
        }
        return ans;

    }
}
