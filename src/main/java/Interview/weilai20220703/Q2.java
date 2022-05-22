package Interview.weilai20220703;

import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年07月03日 19:53
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        System.out.println(func(A, B, C));
    }

    private static int func(int a, int b, int c) {
        int age = 1;
        int money = 0;
        while (money < c) {
            if (c % a == 0) {
                money += b;
            } else {
                money += 1;
            }
            age++;
        }

        return age;
    }
}
