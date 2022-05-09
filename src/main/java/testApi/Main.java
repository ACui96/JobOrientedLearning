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
        String[] s = sc.nextLine().split(" ");
        int[] h = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            h[i] = Integer.parseInt(s[i]);
        }
        for (int i : h) {
            System.out.print(i + " ");
        }
    }
}

