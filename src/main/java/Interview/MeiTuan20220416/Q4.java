package Interview.MeiTuan20220416;

import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年04月16日 9:39
 * 题目描述：
 * 你是魔法学院中的一个学生。你在魔法课中因老师讲得无聊开始了开小差。你手中有两个数字A和B，你可以释放以下三种魔法：
 *
 * ①选择一个数字，让它变成原先的二倍，即，假如数字本来为n，释放此魔法后将变成2*n 。
 *
 * ②选择一个数字，让它变成原来的一半后向下取整，即，假如数字本来为n，释放此魔法后将变成n/2（向下取整），例：对4释放将变成2，对7释放将变成3（向下取整了）。
 *
 * ③选择一个数字，让它变成原来的值加一，即，加入数字本来为n，释放此魔法后将变成n+1.
 *
 *
 *
 * 这三种魔法你都可以任意次数使用，但你是追求完美的学生，你想用尽可能少的释放魔法次数让这两个数变得相等。
 */
public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int ans = func(a, b);
        System.out.println(ans);
    }

    //最小次数
    private static int func(int a, int b) {
        int cnt = 0;
        if (a == b) return cnt;
        if (a > b) {  //使a < b
            int t = a;
            a = b;
            b = t;
        }
        while (b != a) {
            if (b / 2 >= a) {
                b /= 2;
                cnt++;
            }else {

            }
        }
        return cnt;
    }
}
