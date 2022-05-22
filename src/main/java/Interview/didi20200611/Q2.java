package Interview.didi20200611;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年06月11日 19:45
 * 3
 * 6
 * 3 6 5 1 4 2
 * 7
 * 7 4 1 3 2 5 6
 * 6
 * 1 4 3 6 5 2
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            if (solve(arr)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean solve(int[] arr) {
        int n = arr.length;
        if (n < 3) return true;
        int max = Arrays.stream(arr).max().orElse(-1);
        int min = Arrays.stream(arr).min().orElse(-1);
        int idmax = 0, idmin = 1;
        for (int i = 0; i < arr.length; i++) {
            if (max == arr[i]) {
                idmax = i;
            }
            if (min == arr[i]) {
                idmin = i;
            }
        }
        if (idmax > n / 2 && idmin < n / 2) {
            return false;
        }

        return true;
    }

    private static  boolean isUP(int[] arr, int[] indexes) {
        for (int i = 1; i < indexes.length; i++) {
            if (arr[indexes[i - 1]] >= arr[indexes[i]]) {
                return false;
            }
        }
        return true;
    }

    private static  boolean isDown(int[] arr, int[] indexes) {
        for (int i = 1; i < indexes.length; i++) {
            if (arr[indexes[i - 1]] <= arr[indexes[i]]) {
                return false;
            }
        }
        return true;
    }
}
