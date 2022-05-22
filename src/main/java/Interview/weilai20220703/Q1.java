package Interview.weilai20220703;

import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年07月03日 19:57
 */
public class Q1 {
    static int i = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println((int)count(n));
    }

    private static double count(int n) {
//        return (Math.pow((1+Math.sqrt(5.0))/2,n)-Math.pow((1-Math.sqrt(5.0))/2,n))/Math.sqrt(5.0);
        i++;
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return count(n - 1) + count(n - 2);
        }

    }
}
