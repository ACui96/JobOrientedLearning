package Interview.MeiTuan20220416;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年04月16日 9:39
 * 奇怪
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 你学会了一种奇怪的运算，叫做异或（对应于C/C++中 ‘^’代表的运算）。你对这个运算很好奇，你把他拿到一棵树上进行摆玩。
 *
 * 这棵树上每个节点都有权值，你每次指定两个节点，
 * 想要知道这两个节点的简单路径(即此路径上的节点不重复)上的所有点的值异或起来是多少。
 *
 * 输入描述
 * 第一行一个正整数n表示节点个数。
 *
 * 第二行n-1个正整数p[2,3,…n], p[i]表示第 i 个节点的父亲。1号节点是根节点。
 *
 * 第三行n个正整数c[1,2,…n]，c[i]表示第 i 个节点的权值。
 *
 * 第四行一个正整数m表示询问次数。
 *
 * 第五行m个正整数u[1,2,…m]，u[i]表示第 i 次询问中指定的第一个点。
 *
 * 第六行m个正整数v[1,2,…m]，v[i]表示第 i 次询问中指定的第二个点。
 *
 * 数据保证形成合法的树。数字间两两有空格隔开。
 *
 * n,m<=50000
 *
 * c[i]<=1000000000，1<=u[i],v[i]<=n
 *
 * 输出描述
 * 输出一行m个空格隔开的整数，依次对应每次询问的答案。
 *
 * 样例输入
 * 3
 * 1 1
 * 1 2 3
 * 3
 * 1 1 2
 * 2 3 3
 *
 * 样例输出
 * 3 2 0
 *
 * 样例如图所示
 *
 * 第一次询问，1到2的路径上有节点1、2，那么答案为1^2=3
 *
 * 第二次询问，1到3的路径上有节点1、3，那么答案为1^3=2
 *
 * 第三次询问，2到3的路径上有节点1、2、3，那么答案为1^2^3=0
 */
public class Q5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 节点数

        int[] parent = new int[n + 1];
        parent[1] = 1;
        for (int i = 2; i < n + 1;i++) {
            parent[i] = sc.nextInt();
        }
        int[] val = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            val[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        int[] u = new int[q + 1];
        int[] v = new int[q + 1];
        for (int i = 1; i < q+1; i++) {
            u[i] = sc.nextInt();
        }
        for(int i = 1; i < q + 1; i++) {
            v[i] = sc.nextInt();
        }


        int[] ans = func(parent, val, u, v);
        for (int num : ans) {
            System.out.printf(n +" ");
        }
    }

    private static int[] func(int[] p, int[] c, int[] u, int[] v) {
        int[] ans = new int[p.length];
        for (int i = 1; i < p.length; i++) {
            int start = u[i];
            int end = v[i];
            int res = c[start];
            while (start != end) {
                if (start < end) {
                    res ^= c[end];
                    end = p[end];
                } else {
                    start = p[start];
                    res ^= c[start];
                }
            }
            ans[i] = res;
        }
        return ans;
    }
}
