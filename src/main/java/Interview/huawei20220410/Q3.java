package Interview.huawei20220410;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年04月10日 15:27
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String a = sc.next();
        String b = sc.next();

        List<String> list = new ArrayList<>();
        if (list.contains("a")) {

        }

        String[] ret = func(N, a, b);
        if (ret[0] == "-1") System.out.println(-1);
        else {
            System.out.print(ret[0]);
            System.out.print(" ");
            System.out.print(ret[1]);

        }
    }

    private static String[] func(int N, String a, String b) {
        String[] ret = new String[2];
        // 判断合法性
        int a10 = new BigInteger(a, N).intValue(),b10 = new BigInteger(b, N).intValue();

        if (a10 != 0 || b10 != 0) {
            if (a.charAt(0) == '0' || b.charAt(0) =='0') {
                ret[0] = "-1";
                return ret;
            }
        }
        int r = a10 - b10;
        ret[1] = Integer.toString(r, N);
        ret[0] = r >= 0 ? "0" : "1";
        return ret;
    }
}
