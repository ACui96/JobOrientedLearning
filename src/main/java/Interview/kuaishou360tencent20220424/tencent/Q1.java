package Interview.kuaishou360tencent20220424.tencent;


import java.util.Arrays;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }
        int[] ret = func(str);
        for (int num : ret) {
            System.out.print(num +" ");
        }
    }

    private static int[] func(String[] str) {

        int rows = str.length;
        int cols = str[0].length(); // 每个数字字符串的长度 有len个数

        int[] ret = new int[cols];
        for (int c = 0; c < cols; c++) {
            StringBuilder sb = new StringBuilder();
            for (int r = 0; r < rows; r++) {
                sb.append(str[r].charAt(c));
            }
            ret[c] = Integer.parseInt(sb.toString());
        }
        Arrays.sort(ret);
        return ret;
    }

}
