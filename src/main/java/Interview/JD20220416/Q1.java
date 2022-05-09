package Interview.JD20220416;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年04月16日 18:56
 * 等差数
 */
public class Q1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Long[] nums = new Long[T];
        for (int i = 0; i < T; i++) {
            nums[i] = sc.nextLong();
        }
        Long[] ans = new Long[T];
        for (int i = 0; i < T; i++) {
            Long a = nums[i];
            while (!isValid(a)) {
                a++;
            }
            ans[i] = a;
        }
        for (Long a : ans) {
            System.out.println(a);
        }


    }

    private static String validNum(String s) {
        if (s.length() <= 2) return s;
        StringBuilder sb = new StringBuilder();
        int cha = (sb.charAt(1)-'0') - (sb.charAt(0)-'0');

        return sb.toString();
    }



    private static boolean isValid(Long num) {
        List<Integer> list = new ArrayList<>();
        int a;
        while (num != 0) {
            a = (int) (num % 10);
            num /= 10;
            list.add(a);
        }
        if (list.size() <= 2) return true;
        int cha = list.get(1) - list.get(0);
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i + 1) - list.get(i) != cha) {
                return false;
            }
        }
        return true;
    }

}
