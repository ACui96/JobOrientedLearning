package Interview.lenovo20220810;

import java.util.Objects;
import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年08月10日 21:54
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] A = new int[T];
        int[] B  = new int[T];
        for (int i = 0; i < T; i++) {
            A[i] = change(sc.next());
        }
        for (int i = 0; i < T; i++) {
            B[i] = change(sc.next());
        }
        int[] ans = solve(A, B);
        for (int i = 0; i < ans.length; i++) {
            System.out.printf(ans[i] + " ");
        }
    }

    private static int[] solve(int[] a, int[] b) {
        int[] ans = new int[2];
        int sa = 0, sb = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if ((a[i] == 0 && b[i] == 1) || (a[i] == 1 && b[i] == 2) || (a[i] == 2 && b[i] == 0)) {
                sa++;
            }
            if ((b[i] == 0 && a[i] == 1) || (b[i] == 1 && a[i] == 2) || (b[i] == 2 && a[i] == 0)) {
                sb++;
            }
        }
        ans[0] = sa;
        ans[1] = sb;
        return ans;
    }

    private static int change(String s) {
        if(Objects.equals(s, "Rock")) {
            return 0;
        } else if (Objects.equals(s, "Scissor")) {
            return 1;
        }
        return 2;
    }


}
