package Interview.kuaishou360tencent20220424.tencent;


import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(func(a, m));
    }

    private static int func(int[] a, int m) {
        int n = a.length;
        int cnt = 0;
        int last = a[n - 1];
        int idx = 0;
        while (a[idx] > m) {
            idx++;
        } // 买不起的票跳过
        for (int i = idx; i < n - 1; i++) {
            if (a[i] > last && cnt > 0) {
                cnt--;
                m += a[i];
            }else if(m >= a[i] && a[i] <= last) {
                m -= a[i];
                cnt++;
            }
        }
        return cnt * last + m;
    }


}
