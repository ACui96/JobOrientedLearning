package testApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年03月28日 20:06
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            System.out.println(a + b);
//        }
        int a, b;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] split = s.split(" ");
            a = Integer.parseInt(split[0]);
            b = Integer.parseInt(split[1]);
            System.out.println(a + b);
        }
    }
}

