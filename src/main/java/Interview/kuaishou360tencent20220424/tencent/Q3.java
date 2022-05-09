package Interview.kuaishou360tencent20220424.tencent;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] chars = sc.next().toCharArray();
        System.out.println(minAbs(chars, n));
    }

    private static int minAbs(char[] chars, int n){
        int[][] atk_dfd = new int[n + 1][2];

        for(int i = 1; i <= n; i++){
            char x = chars[i - 1];
            if(x == '0'){
                atk_dfd[i][0] = atk_dfd[i - 1][0] + i;
                atk_dfd[i][1] = atk_dfd[i - 1][1];
            }else {
                atk_dfd[i][0] = atk_dfd[i - 1][0];
                atk_dfd[i][1] = atk_dfd[i - 1][1] + i;
            }
        }
        int ret = Integer.MAX_VALUE;
        for(int i = 1; i < n + 1; i++){
            ret = Math.min(Math.abs(atk_dfd[i][0] - (atk_dfd[n][1] - atk_dfd[i][1])), ret);
        }
        return ret;
    }
}
