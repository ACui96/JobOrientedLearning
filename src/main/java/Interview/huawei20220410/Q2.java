package Interview.huawei20220410;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年04月10日 15:05
 */
public class Q2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }
//        int min = sc.nextInt();

        System.out.println(maxTeam(new int[]{1,2,3,4,5,6,7,8,9}, 8));
        System.out.println(maxTeam(new int[]{1, 3, 5, 7, 9}, 8));
        System.out.println(maxTeam(new int[]{1, 3, 5, 7, 9}, 2));
        System.out.println(maxTeam(new int[]{1, 1, 1, 1 ,1}, 2));
        System.out.println(maxTeam(new int[]{1, 1, 1, 1 ,1}, 3));
        System.out.println(maxTeam(new int[]{1, 1, 1, 1 ,2}, 3));

    }

    public static int maxTeam(int[] a, int min) {
        Arrays.sort(a);
        int i = 0, j = a.length - 1;
        int tNum = 0;
        while (i < j) {

            while (a[j] >= min && j >= 0) {
                j--;
                tNum ++;
            }

            while (i < j && a[i] + a[j] < min) {
                i++;
            }
            if (i >= j) break;
            i++;
            j--;
            tNum++;

        }
        return tNum;
    }
}
